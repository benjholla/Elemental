package com.benjholla.elemental.atlas.indexer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import com.benjholla.elemental.atlas.common.XCSG;
import com.benjholla.elemental.atlas.log.Log;
import com.benjholla.elemental.elemental.Function;
import com.benjholla.elemental.elemental.Program;
import com.benjholla.elemental.ide.eclipse.builder.ElementalNature;
import com.benjholla.elemental.ide.eclipse.core.ElementalProject;
import com.ensoftcorp.atlas.core.db.graph.EditableGraph;
import com.ensoftcorp.atlas.core.db.graph.Node;
import com.ensoftcorp.atlas.core.indexing.IMappingSettings;
import com.ensoftcorp.atlas.core.indexing.Parser;
import com.ensoftcorp.atlas.core.indexing.Visitor;
import com.ensoftcorp.atlas.core.indexing.providers.LanguageIndexingProvider;
import com.ensoftcorp.atlas.core.indexing.providers.SimpleIndexingStage;
import com.ensoftcorp.atlas.core.script.Common;

public class ElementalIndexer implements com.ensoftcorp.atlas.core.indexing.providers.LanguageIndexingProviderFactory<ElementalProject, ElementalProjectAST> {

	private static void index(ProgramFactory factory, com.benjholla.elemental.elemental.Function function) {
		factory.beginFunction((byte) Integer.parseInt(function.getName()));
		for(com.benjholla.elemental.elemental.Instruction instruction : function.getBody().getInstructions()) {
			index(factory, instruction);
		}
		factory.endFunction();
	}
	
	private static void index(ProgramFactory factory, com.benjholla.elemental.elemental.Instruction instruction) {
		if(instruction instanceof com.benjholla.elemental.elemental.Increment) {
			factory.addIncrement();
		} else if(instruction instanceof com.benjholla.elemental.elemental.Decrement) {
			factory.addDecrement();
		} else if(instruction instanceof com.benjholla.elemental.elemental.MoveLeft) {
			factory.addMoveLeft();
		} else if(instruction instanceof com.benjholla.elemental.elemental.MoveRight) {
			factory.addMoveRight();
		} else if(instruction instanceof com.benjholla.elemental.elemental.Store) {
			factory.addStore();
		} else if(instruction instanceof com.benjholla.elemental.elemental.Recall) {
			factory.addRecall();
		}
	}
	
	private static void index(ElementalProjectAST ast, EditableGraph graph, Node projectNode, SubMonitor monitor) throws Exception {
		Log.info("Indexing: " + ast.getElementalProject().getProject().getName());
		
		// index the program
		for(Entry<IFile,Program> entry : ast.getASTForest().entrySet()) {
			IFile source = entry.getKey();
			Program program = entry.getValue();
			
			ProgramFactory factory = new ProgramFactory();
			
			if(program.getImplicitFunction() != null && !program.getImplicitFunction().getInstructions().isEmpty()) {
				index(factory, (Function) program.getImplicitFunction());
			}
			for(com.benjholla.elemental.elemental.Function function : program.getExplicitFunctions()) {
				index(factory, function);
			}
			
//			EMFSourceCorrespondence sc = new EMFSourceCorrespondence(source, program);
//			Log.info("Processing: " + sc.toString());
//			File sourceFile = program.getParserSourceCorrespondence().getSource();
//			String sourceFileName = sourceFile.getName();
//			monitor.subTask("Processing: " + sourceFileName);
//			
//			// create a namespace (defined by the source file)
//			Node namespaceNode = graph.createNode();
//			namespaceNode.tag(XCSG.Namespace);
//			namespaceNode.putAttr(XCSG.name, sourceFileName);
//			ParserSourceCorrespondence psc = program.getParserSourceCorrespondence();
//			SourceCorrespondence namespaceSC = new SourceCorrespondence(WorkspaceUtils.getFile(psc.getSource()), psc.getOffset(), psc.getLength(), psc.getStartLine(), psc.getEndLine());
//			namespaceNode.putAttr(XCSG.sourceCorrespondence, namespaceSC);
//			
//			// make the project contain the namespace
//			Edge containsEdge = graph.createEdge(projectNode, namespaceNode);
//			containsEdge.tag(XCSG.Contains);
//			
//			// elemental has no real concept of functions, but will create a single implict main function
//			// as another container level inside the namespace to allow smart views and common queries to 
//			// operate cleanly out of the box
//			Node implicitFunctionNode = graph.createNode();
//			implicitFunctionNode.tag(XCSG.Elemental.ImplictFunction);
//			if(sourceFileName.contains(".")) {
//				sourceFileName = sourceFileName.substring(0, sourceFileName.lastIndexOf("."));
//			}
//			implicitFunctionNode.putAttr(XCSG.name, sourceFileName);
//			namespaceNode.putAttr(XCSG.sourceCorrespondence, namespaceSC);
//			
//			// make the namespace contain the implicit function
//			containsEdge = graph.createEdge(namespaceNode, implicitFunctionNode);
//			containsEdge.tag(XCSG.Contains);
//			
//			// index the contents of the namespace
//			program.index(graph, implicitFunctionNode, monitor);
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
