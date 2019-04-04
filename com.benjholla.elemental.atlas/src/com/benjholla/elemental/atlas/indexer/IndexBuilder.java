package com.benjholla.elemental.atlas.indexer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

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
	
	public void beginFunction(Byte name) {
		function = new IndexFunction(program, name);
		program.addFunction(function);
	}
	
	public void addIncrement() {
		if(function != null) {
			IndexIncrement increment = new IndexIncrement(function);
			addInstruction(increment);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}

	public void addDecrement() {
		if(function != null) {
			IndexDecrement decrement = new IndexDecrement(function);
			addInstruction(decrement);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addMoveLeft() {
		if(function != null) {
			IndexMoveLeft moveLeft = new IndexMoveLeft(function);
			addInstruction(moveLeft);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addMoveRight() {
		if(function != null) {
			IndexMoveRight moveRight = new IndexMoveRight(function);
			addInstruction(moveRight);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addStore() {
		if(function != null) {
			IndexStore store = new IndexStore(function);
			addInstruction(store);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addRecall() {
		if(function != null) {
			IndexRecall recall = new IndexRecall(function);
			addInstruction(recall);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addAssignment() {
		if(function != null) {
			IndexAssignment assignment = new IndexAssignment(function);
			addInstruction(assignment);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void beginBranch() {
		if(function != null) {
			IndexBranch branch = new IndexBranch(function);
			addInstruction(branch);
			scope.add(branch);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void endBranch() {
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
	
	public void beginLoop() {
		if(function != null) {
			IndexLoop loop = new IndexLoop(function);
			addInstruction(loop);
			scope.add(loop);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void endLoop() {
		if(function != null) {
			if(scope.isEmpty() || !(scope.peek() instanceof IndexLoop)) {
				throw new IllegalStateException("No corresponding begin loop.");
			} else {
				IndexLoopBack loopBack = new IndexLoopBack(function, (IndexLoop) scope.peek());
				addInstruction(loopBack);
				lastInstruction = scope.pop();
			}
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addLabel(Byte labelName) {
		if(function != null) {
			if(!labels.containsKey(labelName)) {
				IndexLabel label = futureLabels.remove(labelName);
				if(label == null) {
					label = new IndexLabel(function, labelName);
					labels.put(labelName, label);
				}
				addInstruction(label);
			} else {
				throw new IllegalStateException(LABELS_WITHIN_FUNCTIONS_MUST_BE_UNIQUE);
			}
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addGOTO(Byte labelName) {
		if(function != null) {
			IndexLabel label = labels.get(labelName);
			if(label == null) {
				label = futureLabels.get(labelName);
				if(label == null) {
					label = new IndexLabel(function, labelName);
					futureLabels.put(labelName, label);
				}
			}
			IndexGOTO GOTO = new IndexGOTO(function, label);
			addInstruction(GOTO);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addComputedGOTO() {
		if(function != null) {
			IndexComputedGOTO computedGOTO = new IndexComputedGOTO(function);
			addInstruction(computedGOTO);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addStaticDispatch(Byte target) {
		if(function != null) {
			IndexStaticDispatch staticDispatch = new IndexStaticDispatch(function, target);
			addInstruction(staticDispatch);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addDynamicDispatch() {
		if(function != null) {
			IndexDynamicDispatch dynamicDispatch = new IndexDynamicDispatch(function);
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
					IndexInstruction implicitReturn = new IndexImplicitReturn(function);
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
