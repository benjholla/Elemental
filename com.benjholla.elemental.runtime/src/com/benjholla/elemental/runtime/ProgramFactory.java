package com.benjholla.elemental.runtime;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.benjholla.elemental.runtime.Instruction.Assignment;
import com.benjholla.elemental.runtime.Instruction.Branch;
import com.benjholla.elemental.runtime.Instruction.ComputedGOTO;
import com.benjholla.elemental.runtime.Instruction.Decrement;
import com.benjholla.elemental.runtime.Instruction.DynamicDispatch;
import com.benjholla.elemental.runtime.Instruction.GOTO;
import com.benjholla.elemental.runtime.Instruction.ImplicitReturn;
import com.benjholla.elemental.runtime.Instruction.Increment;
import com.benjholla.elemental.runtime.Instruction.Label;
import com.benjholla.elemental.runtime.Instruction.Loop;
import com.benjholla.elemental.runtime.Instruction.LoopBack;
import com.benjholla.elemental.runtime.Instruction.MoveLeft;
import com.benjholla.elemental.runtime.Instruction.MoveRight;
import com.benjholla.elemental.runtime.Instruction.Recall;
import com.benjholla.elemental.runtime.Instruction.StaticDispatch;
import com.benjholla.elemental.runtime.Instruction.Store;

public class ProgramFactory {
	
	public static final String INCOMPLETE_PROGRAM = "Incomplete program";
	public static final String INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION = "Instructions must be contained by a function.";
	public static final String LABELS_WITHIN_FUNCTIONS_MUST_BE_UNIQUE = "Every label within a function must be unique.";
	
	private Program program;
	
	public ProgramFactory(InputStream stdin, OutputStream stdout) {
		program = new Program(stdin, stdout);
	}

	public Program create() {
		if(function != null || !scope.isEmpty()) {
			throw new RuntimeException(INCOMPLETE_PROGRAM);
		}
		return program;
	}
	
	private Function function = null;
	private Stack<Instruction> scope = new Stack<Instruction>();
	private Instruction lastInstruction = null;
	private List<Instruction> branchTerminals = new ArrayList<Instruction>();
	private Map<Byte,Label> labels = new HashMap<Byte,Label>();
	private Map<Byte,Label> futureLabels = new HashMap<Byte,Label>();
	
	private void setPredecessor(Instruction instruction) {
		if(lastInstruction != null) {
			lastInstruction.setSuccessor(instruction);
		}
		lastInstruction = instruction;
	}
	
	private void addInstruction(Instruction instruction) {
		for(Instruction branchTerminal : branchTerminals) {
			branchTerminal.setSuccessor(instruction);
		}
		branchTerminals.clear();
		if(scope.isEmpty()) {
			function.addInstruction(instruction);
		} else {
			if(scope.peek() instanceof Branch) {
				Branch branch = ((Branch) scope.peek());
				branch.addInstruction(instruction);
			} else if(scope.peek() instanceof Loop) {
				Loop loop = ((Loop) scope.peek());
				loop.addInstruction(instruction);
			}
		}
		setPredecessor(instruction);
	}
	
	public void beginFunction(Byte name) {
		function = new Function(program, name);
		program.addFunction(function);
	}
	
	public void addIncrementInstruction() {
		if(function != null) {
			Increment increment = new Increment(function);
			addInstruction(increment);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}

	public void addDecrementInstruction() {
		if(function != null) {
			Decrement decrement = new Decrement(function);
			addInstruction(decrement);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addMoveLeftInstruction() {
		if(function != null) {
			MoveLeft moveLeft = new MoveLeft(function);
			addInstruction(moveLeft);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addMoveRightInstruction() {
		if(function != null) {
			MoveRight moveRight = new MoveRight(function);
			addInstruction(moveRight);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addStoreInstruction() {
		if(function != null) {
			Store store = new Store(function);
			addInstruction(store);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addRecallInstruction() {
		if(function != null) {
			Recall recall = new Recall(function);
			addInstruction(recall);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addAssignmentInstruction() {
		if(function != null) {
			Assignment assignment = new Assignment(function);
			addInstruction(assignment);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void beginBranchInstruction() {
		if(function != null) {
			Branch branch = new Branch(function);
			addInstruction(branch);
			scope.add(branch);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void endBranchInstruction() {
		if(function != null) {
			if(scope.isEmpty() || !(scope.peek() instanceof Branch)) {
				throw new IllegalStateException("No corresponding begin branch.");
			} else {
				lastInstruction = scope.pop();
				Branch branch = (Branch) lastInstruction;
				List<Instruction> body = branch.getBody();
				if(!body.isEmpty()) {
					branchTerminals.add(body.get(body.size()-1));
				}
			}
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void beginLoopInstruction() {
		if(function != null) {
			Loop loop = new Loop(function);
			addInstruction(loop);
			scope.add(loop);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void endLoopInstruction() {
		if(function != null) {
			if(scope.isEmpty() || !(scope.peek() instanceof Loop)) {
				throw new IllegalStateException("No corresponding begin loop.");
			} else {
				LoopBack loopBack = new LoopBack(function, (Loop) scope.peek());
				addInstruction(loopBack);
				lastInstruction = scope.pop();
			}
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addLabelInstruction(Byte labelName) {
		if(function != null) {
			if(!labels.containsKey(labelName)) {
				Label label = futureLabels.remove(labelName);
				if(label != null) {
					label = new Label(function, labelName);
				}
				addInstruction(label);
			} else {
				throw new IllegalStateException(LABELS_WITHIN_FUNCTIONS_MUST_BE_UNIQUE);
			}
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addGOTOInstruction(Byte labelName) {
		if(function != null) {
			Label label = labels.get(labelName);
			if(label == null) {
				label = futureLabels.get(labelName);
				if(label == null) {
					label = new Label(function, labelName);
					futureLabels.put(labelName, label);
				}
			}
			GOTO GOTO = new GOTO(function, label);
			addInstruction(GOTO);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addComputedGOTOInstruction() {
		if(function != null) {
			ComputedGOTO computedGOTO = new ComputedGOTO(function);
			addInstruction(computedGOTO);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addStaticDispatchInstruction(Byte target) {
		if(function != null) {
			StaticDispatch staticDispatch = new StaticDispatch(function, target);
			addInstruction(staticDispatch);
		} else {
			throw new IllegalStateException(INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION);
		}
	}
	
	public void addDynamicDispatchInstruction() {
		if(function != null) {
			DynamicDispatch dynamicDispatch = new DynamicDispatch(function);
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
					Instruction implicitReturn = new ImplicitReturn(function);
					addInstruction(implicitReturn);
					labels.clear();
					function = null;
				}
			}
		} else {
			throw new IllegalStateException("No function to end.");
		}
	}
	
}
