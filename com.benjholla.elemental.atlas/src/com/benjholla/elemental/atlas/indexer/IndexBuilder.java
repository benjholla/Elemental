package com.benjholla.elemental.atlas.indexer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.resources.IFile;

import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexAssignment;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexBranch;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexComputedGOTO;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexDecrement;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexDynamicDispatch;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexGOTO;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexImplicitReturn;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexIncrement;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexLabel;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexLoop;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexLoopBack;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexMoveLeft;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexMoveRight;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexRecall;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexStaticDispatch;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexStore;
import com.benjholla.elemental.elemental.Assignment;
import com.benjholla.elemental.elemental.Block;
import com.benjholla.elemental.elemental.Branch;
import com.benjholla.elemental.elemental.ComputedGOTO;
import com.benjholla.elemental.elemental.Decrement;
import com.benjholla.elemental.elemental.DynamicDispatch;
import com.benjholla.elemental.elemental.Function;
import com.benjholla.elemental.elemental.GOTO;
import com.benjholla.elemental.elemental.Increment;
import com.benjholla.elemental.elemental.Label;
import com.benjholla.elemental.elemental.Loop;
import com.benjholla.elemental.elemental.MoveLeft;
import com.benjholla.elemental.elemental.MoveRight;
import com.benjholla.elemental.elemental.Recall;
import com.benjholla.elemental.elemental.StaticDispatch;
import com.benjholla.elemental.elemental.Store;

public class IndexBuilder {
	
	public static final String INCOMPLETE_PROGRAM = "Incomplete program";
	public static final String INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION = "Instructions must be contained by a function.";
	public static final String LABELS_WITHIN_FUNCTIONS_MUST_BE_UNIQUE = "Every label within a function must be unique.";
	
	private IndexProgram program;
	
	public IndexBuilder() {
		program = new IndexProgram();
	}

	public IndexProgram create() {
		if(function != null || !scope.isEmpty()) {
			throw new RuntimeException(INCOMPLETE_PROGRAM);
		}
		return program;
	}
	
	private IndexFunction function = null;
	private Stack<IndexInstruction> scope = new Stack<IndexInstruction>();
	private IndexInstruction lastInstruction = null;
	private List<IndexInstruction> branchTerminals = new ArrayList<IndexInstruction>();
	private Map<Byte,IndexLabel> labels = new HashMap<Byte,IndexLabel>();
	private Map<Byte,IndexLabel> futureLabels = new HashMap<Byte,IndexLabel>();
	
	private void setPredecessor(IndexInstruction instruction) {
		if(lastInstruction != null) {
			lastInstruction.addSuccessor(instruction);
		}
		lastInstruction = instruction;
	}
	
	private void addInstruction(IndexInstruction instruction) {
		for(IndexInstruction branchTerminal : branchTerminals) {
			branchTerminal.addSuccessor(instruction);
		}
		branchTerminals.clear();
		if(scope.isEmpty()) {
			function.addInstruction(instruction);
		} else {
			if(scope.peek() instanceof IndexBranch) {
				IndexBranch branch = ((IndexBranch) scope.peek());
				branch.addInstruction(instruction);
			} else if(scope.peek() instanceof IndexLoop) {
				IndexLoop loop = ((IndexLoop) scope.peek());
				loop.addInstruction(instruction);
			}
		}
		setPredecessor(instruction);
	}
	
	public void beginFunction(Byte name, IFile sourceFile, Block implicitFunction) {
		function = new IndexFunction(program, name, sourceFile, implicitFunction);
		program.addFunction(function);
	}
	
	public void beginFunction(Byte name, IFile sourceFile, Function explicitFunction) {
		function = new IndexFunction(program, name, sourceFile, explicitFunction);
		program.addFunction(function);
	}
	
	public void addIncrement(IFile sourceFile, Increment instruction) {
		if(function != null) {
			IndexIncrement increment = new IndexIncrement(function, new EMFSourceCorrespondence(sourceFile, instruction));
			addInstruction(increment);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}

	public void addDecrement(IFile sourceFile, Decrement instruction) {
		if(function != null) {
			IndexDecrement decrement = new IndexDecrement(function, new EMFSourceCorrespondence(sourceFile, instruction));
			addInstruction(decrement);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addMoveLeft(IFile sourceFile, MoveLeft instruction) {
		if(function != null) {
			IndexMoveLeft moveLeft = new IndexMoveLeft(function, new EMFSourceCorrespondence(sourceFile, instruction));
			addInstruction(moveLeft);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addMoveRight(IFile sourceFile, MoveRight instruction) {
		if(function != null) {
			IndexMoveRight moveRight = new IndexMoveRight(function, new EMFSourceCorrespondence(sourceFile, instruction));
			addInstruction(moveRight);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addStore(IFile sourceFile, Store instruction) {
		if(function != null) {
			IndexStore store = new IndexStore(function, new EMFSourceCorrespondence(sourceFile, instruction));
			addInstruction(store);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addRecall(IFile sourceFile, Recall instruction) {
		if(function != null) {
			IndexRecall recall = new IndexRecall(function, new EMFSourceCorrespondence(sourceFile, instruction));
			addInstruction(recall);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addAssignment(IFile sourceFile, Assignment instruction) {
		if(function != null) {
			IndexAssignment assignment = new IndexAssignment(function, new EMFSourceCorrespondence(sourceFile, instruction));
			addInstruction(assignment);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void beginBranch(IFile sourceFile, Branch instruction) {
		if(function != null) {
			IndexBranch branch = new IndexBranch(function, new EMFSourceCorrespondence(sourceFile, instruction));
			addInstruction(branch);
			scope.add(branch);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void endBranch(IFile sourceFile, Branch instruction) {
		if(function != null) {
			if(scope.isEmpty() || !(scope.peek() instanceof IndexBranch)) {
				throw new IllegalStateException("No corresponding begin branch.");
			} else {
				lastInstruction = scope.pop();
				IndexBranch branch = (IndexBranch) lastInstruction;
				List<IndexInstruction> body = branch.getBody();
				if(!body.isEmpty()) {
					branchTerminals.add(body.get(body.size()-1));
				}
			}
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void beginLoop(IFile sourceFile, Loop instruction) {
		if(function != null) {
			IndexLoop loop = new IndexLoop(function, new EMFSourceCorrespondence(sourceFile, instruction));
			addInstruction(loop);
			scope.add(loop);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void endLoop(IFile sourceFile, Loop instruction) {
		if(function != null) {
			if(scope.isEmpty() || !(scope.peek() instanceof IndexLoop)) {
				throw new IllegalStateException("No corresponding begin loop.");
			} else {
				IndexLoopBack loopBack = new IndexLoopBack(function, (IndexLoop) scope.peek(), new EMFSourceCorrespondence(sourceFile, instruction));
				addInstruction(loopBack);
				lastInstruction = scope.pop();
			}
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addLabel(Byte labelName, IFile sourceFile, Label instruction) {
		if(function != null) {
			if(!labels.containsKey(labelName)) {
				IndexLabel label = futureLabels.remove(labelName);
				if(label == null) {
					label = new IndexLabel(function, labelName, new EMFSourceCorrespondence(sourceFile, instruction));
					labels.put(labelName, label);
				}
				// TODO: add label sc
				addInstruction(label);
			} else {
				throw new IllegalStateException(LABELS_WITHIN_FUNCTIONS_MUST_BE_UNIQUE);
			}
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addGOTO(Byte labelName, IFile sourceFile, GOTO instruction) {
		if(function != null) {
			IndexLabel label = labels.get(labelName);
			if(label == null) {
				label = futureLabels.get(labelName);
				if(label == null) {
					label = new IndexLabel(function, labelName, null);
					futureLabels.put(labelName, label);
				}
			}
			IndexGOTO GOTO = new IndexGOTO(function, label, new EMFSourceCorrespondence(sourceFile, instruction));
			addInstruction(GOTO);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addComputedGOTO(IFile sourceFile, ComputedGOTO instruction) {
		if(function != null) {
			IndexComputedGOTO computedGOTO = new IndexComputedGOTO(function, new EMFSourceCorrespondence(sourceFile, instruction));
			addInstruction(computedGOTO);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addStaticDispatch(Byte target, IFile sourceFile, StaticDispatch instruction) {
		if(function != null) {
			IndexStaticDispatch staticDispatch = new IndexStaticDispatch(function, target, new EMFSourceCorrespondence(sourceFile, instruction));
			addInstruction(staticDispatch);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addDynamicDispatch(IFile sourceFile, DynamicDispatch instruction) {
		if(function != null) {
			IndexDynamicDispatch dynamicDispatch = new IndexDynamicDispatch(function, new EMFSourceCorrespondence(sourceFile, instruction));
			addInstruction(dynamicDispatch);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void endFunction() {
		if(function != null) {
			if(!scope.isEmpty()) {
				throw new IllegalStateException("Unclosed branches or loops");
			} else {
				if(!futureLabels.isEmpty()) {
					throw new IllegalStateException("Labels were referenced that do not exist");
				} else {
					IndexInstruction implicitReturn = new IndexImplicitReturn(function, function.getSourceCorrespondence());
					addInstruction(implicitReturn);
					labels.clear();
					futureLabels.clear();
					function = null;
				}
			}
		} else {
			throw new IllegalStateException("No function to end.");
		}
	}
	
}
