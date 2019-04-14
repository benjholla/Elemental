package com.benjholla.elemental.atlas.indexer;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import com.benjholla.elemental.atlas.common.XCSG;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexBranch;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexLoop;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexLoopBack;
import com.benjholla.elemental.atlas.log.Log;
import com.benjholla.elemental.elemental.Assignment;
import com.benjholla.elemental.elemental.Block;
import com.benjholla.elemental.elemental.Branch;
import com.benjholla.elemental.elemental.ComputedGOTO;
import com.benjholla.elemental.elemental.Decrement;
import com.benjholla.elemental.elemental.DynamicDispatch;
import com.benjholla.elemental.elemental.Function;
import com.benjholla.elemental.elemental.GOTO;
import com.benjholla.elemental.elemental.Increment;
import com.benjholla.elemental.elemental.Instruction;
import com.benjholla.elemental.elemental.Label;
import com.benjholla.elemental.elemental.Loop;
import com.benjholla.elemental.elemental.MoveLeft;
import com.benjholla.elemental.elemental.MoveRight;
import com.benjholla.elemental.elemental.Program;
import com.benjholla.elemental.elemental.Recall;
import com.benjholla.elemental.elemental.StaticDispatch;
import com.benjholla.elemental.elemental.Store;
import com.benjholla.elemental.ide.eclipse.builder.ElementalNature;
import com.benjholla.elemental.ide.eclipse.core.ElementalProject;
import com.ensoftcorp.atlas.core.db.graph.Edge;
import com.ensoftcorp.atlas.core.db.graph.EditableGraph;
import com.ensoftcorp.atlas.core.db.graph.Node;
import com.ensoftcorp.atlas.core.indexing.IMappingSettings;
import com.ensoftcorp.atlas.core.indexing.Parser;
import com.ensoftcorp.atlas.core.indexing.Visitor;
import com.ensoftcorp.atlas.core.indexing.providers.LanguageIndexingProvider;
import com.ensoftcorp.atlas.core.indexing.providers.SimpleIndexingStage;
import com.ensoftcorp.atlas.core.script.Common;

public class ElementalIndexer implements com.ensoftcorp.atlas.core.indexing.providers.LanguageIndexingProviderFactory<ElementalProject, ElementalProjectAST> {
	
	private static void index(ElementalProjectAST ast, EditableGraph graph, Node projectNode, SubMonitor monitor) throws Exception {
		Log.info("Indexing: " + ast.getElementalProject().getProject().getName());
		
		// index the program
		for(Entry<IFile,Program> entry : ast.getASTForest().entrySet()) {
			IFile sourceFile = entry.getKey();
			
			EMFSourceCorrespondence sc = new EMFSourceCorrespondence(sourceFile, entry.getValue());
			String status = "Processing: " + sc.getSource().getName();
			Log.info(status);
			monitor.subTask(status);
			
			// create a namespace (defined by the source file)
			Node namespaceNode = graph.createNode();
			namespaceNode.tag(XCSG.Namespace);
			namespaceNode.putAttr(XCSG.name, sourceFile.getName());
			namespaceNode.putAttr(XCSG.sourceCorrespondence, sc.toAtlasSourceCorrespondence());
			
			// make the project contain the namespace
			Edge projectContainsEdge = graph.createEdge(projectNode, namespaceNode);
			projectContainsEdge.tag(XCSG.Contains);
			
			Program program = entry.getValue();
			IndexBuilder builder = new IndexBuilder();
			if(program.getImplicitFunction() != null && !program.getImplicitFunction().getInstructions().isEmpty()) {
				indexImplicitFunction(builder, sourceFile, program.getImplicitFunction());
			}
			for(Function function : program.getExplicitFunctions()) {
				indexExplicitFunction(builder, sourceFile, function);
			}
			
			IndexProgram indexProgram = builder.create();
			for(IndexFunction indexFunction : indexProgram.getFunctions()) {
				Node functionNode = indexFunction.index(graph, monitor);
				
				Edge namespaceContainsEdge = graph.createEdge(namespaceNode, functionNode);
				namespaceContainsEdge.tag(XCSG.Contains);
				
				buildCFG(indexFunction, functionNode, graph, monitor);
			}
		}
	}
	
	private static void indexImplicitFunction(IndexBuilder builder, IFile sourceFile, Block block) {
		builder.beginFunction((byte) 0, sourceFile, block);
		for(Instruction instruction : block.getInstructions()) {
			index(builder, sourceFile, instruction);
		}
		builder.endFunction();
	}
	
	private static void indexExplicitFunction(IndexBuilder builder, IFile sourceFile, Function function) {
		builder.beginFunction((byte) Integer.parseInt(function.getName()), sourceFile, function);
		for(Instruction instruction : function.getBody().getInstructions()) {
			index(builder, sourceFile, instruction);
		}
		builder.endFunction();
	}
	
	private static void index(IndexBuilder builder, IFile sourceFile, Instruction instruction) {
		if(instruction.getType() instanceof Increment) {
			builder.addIncrement(sourceFile, (Increment) instruction.getType());
		} else if(instruction.getType() instanceof Decrement) {
			builder.addDecrement(sourceFile, (Decrement) instruction.getType());
		} else if(instruction.getType() instanceof MoveLeft) {
			builder.addMoveLeft(sourceFile, (MoveLeft) instruction.getType());
		} else if(instruction.getType() instanceof MoveRight) {
			builder.addMoveRight(sourceFile, (MoveRight) instruction.getType());
		} else if(instruction.getType() instanceof Store) {
			builder.addStore(sourceFile, (Store) instruction.getType());
		} else if(instruction.getType() instanceof Recall) {
			builder.addRecall(sourceFile, (Recall) instruction.getType());
		} else if(instruction.getType() instanceof Assignment) {
			builder.addAssignment(sourceFile, (Assignment) instruction.getType());
		} else if(instruction.getType() instanceof Branch) {
			Branch branch = (Branch) instruction;
			builder.beginBranch(sourceFile, (Branch) instruction.getType());
			for(Instruction branchBodyInstruction : branch.getBody().getInstructions()) {
				index(builder, sourceFile, branchBodyInstruction);
			}
			builder.endBranch(sourceFile, branch);
		} else if(instruction.getType() instanceof Loop) {
			Loop loop = (Loop) instruction.getType();
			builder.beginLoop(sourceFile, (Loop) instruction.getType());
			for(Instruction loopBodyInstruction : loop.getBody().getInstructions()) {
				index(builder, sourceFile, loopBodyInstruction);
			}
			builder.endLoop(sourceFile, loop);
		} else if(instruction.getType() instanceof Label) {
			Label label = (Label) instruction.getType();
			builder.addLabel((byte) Integer.parseInt(label.getName()), sourceFile, label);
		} else if(instruction.getType() instanceof GOTO) {
			GOTO go2 = (GOTO) instruction.getType();
			builder.addGOTO((byte) Integer.parseInt(go2.getLabel().getName()), sourceFile, go2);
		} else if(instruction.getType() instanceof ComputedGOTO) {
			builder.addComputedGOTO(sourceFile, (ComputedGOTO) instruction.getType());
		} else if(instruction.getType() instanceof StaticDispatch) {
			StaticDispatch staticDispatch = (StaticDispatch) instruction.getType();
			builder.addStaticDispatch((byte) Integer.parseInt(staticDispatch.getTarget().getName()), sourceFile, (StaticDispatch) instruction.getType());
		} else if(instruction.getType() instanceof DynamicDispatch) {
			builder.addDynamicDispatch(sourceFile, (DynamicDispatch) instruction.getType());
		} else {
			throw new RuntimeException("Unknown instruction type: " + instruction.getType().toString());
		}
	}
	
	private static void buildCFG(IndexFunction indexFunction, Node functionNode, EditableGraph graph, SubMonitor monitor) {
		// create each node in the CFG and add containment edges
		Map<IndexInstruction,Node> instructionMap = new HashMap<IndexInstruction,Node>();
		Queue<IndexInstruction> instructionsToMap = new LinkedList<IndexInstruction>(indexFunction.getInstructions());
		while(!instructionsToMap.isEmpty()) {
			IndexInstruction indexInstruction = instructionsToMap.remove();
			if(indexInstruction instanceof IndexBranch) {
				instructionsToMap.addAll(((IndexBranch) indexInstruction).getBody());
			} else if(indexInstruction instanceof IndexLoop) {
				instructionsToMap.addAll(((IndexLoop) indexInstruction).getBody());
			}
			
			Node instructionNode = indexInstruction.index(graph, monitor);
			instructionMap.put(indexInstruction, instructionNode);
			
			Edge functionContainsEdge = graph.createEdge(functionNode, instructionNode);
			functionContainsEdge.tag(XCSG.Contains);
		}
		
		// create control flow edges for each control flow node
		instructionsToMap = new LinkedList<IndexInstruction>(indexFunction.getInstructions());
		while(!instructionsToMap.isEmpty()) {
			IndexInstruction predecessor = instructionsToMap.remove();
			Node predecessorNode = instructionMap.get(predecessor);

			// add branch and loop bodies to list of instructions to map
			if(predecessor instanceof IndexBranch) {
				instructionsToMap.addAll(((IndexBranch) predecessor).getBody());
			} else if(predecessor instanceof IndexLoop) {
				IndexLoop loopHeader = (IndexLoop) predecessor;
				for(IndexInstruction loopChild : loopHeader.getBody()) {
					// create loop child edge
					Node loopHeaderNode = predecessorNode;
					Node loopChildNode = instructionMap.get(loopChild);
					Edge loopChildEdge = graph.createEdge(loopHeaderNode, loopChildNode);
					loopChildEdge.tag(XCSG.LoopChild);
					
					// add loop child to instructions to map
					instructionsToMap.add(loopChild);
				}
			}
			
			// create a control flow edge from predecessor to each statically known successor
			for(IndexInstruction successor : predecessor.getSuccessors()) {
				Node successorNode = instructionMap.get(successor);
				Edge controlFlowEdge = graph.createEdge(predecessorNode, successorNode);
				if(predecessor instanceof IndexLoopBack) {
					controlFlowEdge.tag(XCSG.ControlFlowBackEdge);
				} else {
					controlFlowEdge.tag(XCSG.ControlFlow_Edge);
				}
			}
		}
	}

	@Override
	public boolean canIndexProject(IProject project) throws CoreException {
		return isIndexableElementalProject(project);
	}
	
	public static boolean isIndexableElementalProject(IProject project) throws CoreException {
		return project.isAccessible() && project.isNatureEnabled(ElementalNature.NATURE_ID);
	}

	@Override
	public long countIndexFiles() {
		// Note: it is unclear what this should do in Atlas APIs
		// so just returning 0 here
		return 0;
	}

	@Override
	public LanguageIndexingProvider<ElementalProject, ElementalProjectAST> getProvider(Collection<IMappingSettings> settings){

		LanguageIndexingProvider<ElementalProject, ElementalProjectAST> provider = new LanguageIndexingProvider<ElementalProject, ElementalProjectAST>(){

			@Override
			public SimpleIndexingStage[] getPreVisitationProcessors() {
				return new SimpleIndexingStage[]{};
			}

			@Override
			@SuppressWarnings("unchecked")
			public Visitor<ElementalProjectAST>[] getVisitors() {
				Visitor<ElementalProjectAST> visitor = new Visitor<ElementalProjectAST>(){

					@Override
					public void visit(ElementalProjectAST ast, EditableGraph graph, SubMonitor submonitor) {
						try {
							index(ast, graph, getOrCreateNodeForCompilationUnit(ast.getElementalProject(), graph), submonitor);
						} catch (Exception e) {
							Log.error("Indexing Elemental Program Failed", e);
						}
					}

					@Override
					public String displayName() {
						return "Elemental Program Indexer";
					}
					
				};
				
				return new Visitor[]{ visitor };
			}

			@Override
			public SimpleIndexingStage[] getPostVisitationProcessors() {
				return new SimpleIndexingStage[]{};
			}

			@Override
			public String indexingDisplayName() {
				return "Elemental Indexer";
			}

			@Override
			public String tag() {
				// a tag to be applied to every element created by this language indexing provider
				return XCSG.Language.Elemental;
			}

			@Override
			public Parser<ElementalProject, ElementalProjectAST> getParser() {
				Parser<ElementalProject, ElementalProjectAST> parser = new Parser<ElementalProject, ElementalProjectAST>(){
					@Override
					public ElementalProjectAST parse(ElementalProject project) throws Exception {
						Log.info("Parsing: " + project.getProject().getName());
						return new ElementalProjectAST(project);
					}
				};
				return parser;
			}

			@Override
			public boolean supportsMultithreadedParsing() {
				return false;
			}

			@Override
			public Collection<ElementalProject> findCompilationUnits(IProgressMonitor monitor) throws CoreException {
				LinkedList<ElementalProject> elementalProjects = new LinkedList<ElementalProject>();
				for(IProject project : com.ensoftcorp.atlas.core.index.ProjectPropertiesUtil.getAllEnabledProjects()){
					if(canIndexProject(project)){
						elementalProjects.add(new ElementalProject(project));
					}
				}
				return elementalProjects;
			}

			@Override
			public Node getOrCreateNodeForCompilationUnit(ElementalProject project, EditableGraph graph) {
				Node compilationUnit = Common.toQ(graph).nodes(XCSG.Project).selectNode(XCSG.name, project.getProject().getName()).eval().nodes().one();
				if(compilationUnit != null){
					return compilationUnit;
				} else {
					compilationUnit = graph.createNode();
					compilationUnit.tag(XCSG.Project);
					compilationUnit.putAttr(XCSG.name, project.getProject().getName());
					return compilationUnit;
				}
			}
			
		};
		
		return provider;
	}
	
}
