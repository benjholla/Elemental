package com.benjholla.elemental.runtime;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

import com.benjholla.elemental.runtime.Instruction.ImplicitReturn;
import com.benjholla.elemental.runtime.Instruction.Assignment;
import com.benjholla.elemental.runtime.Instruction.Branch;
import com.benjholla.elemental.runtime.Instruction.Decrement;
import com.benjholla.elemental.runtime.Instruction.Increment;
import com.benjholla.elemental.runtime.Instruction.Loop;
import com.benjholla.elemental.runtime.Instruction.LoopBack;
import com.benjholla.elemental.runtime.Instruction.MoveLeft;
import com.benjholla.elemental.runtime.Instruction.MoveRight;
import com.benjholla.elemental.runtime.Instruction.Recall;
import com.benjholla.elemental.runtime.Instruction.Store;

public class ProgramFactory {
	
	private static final boolean DEBUG = false;
	
	public static final String INCOMPLETE_PROGRAM = "Incomplete program";
	public static final String INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION = "Instructions must be contained by a function.";
	
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
	
	private void setPredecessor(Instruction instruction) {
		if(lastInstruction != null) {
			if(DEBUG) System.out.println("Predecessor: " + lastInstruction + ", " + "Successor: " + instruction);
			lastInstruction.setSuccessor(instruction);
			if(lastInstruction instanceof Branch) {
				Branch branch = (Branch) lastInstruction;
				if(!branch.getBody().isEmpty()) {
					Instruction lastBodyInstruction = branch.getBody().get(branch.getBody().size()-1);
					if(lastBodyInstruction.id != instruction.id && lastBodyInstruction.successor == null) {
						lastBodyInstruction.setSuccessor(instruction);
					}
				}
			}
		}
		lastInstruction = instruction;
	}
	
	private void addInstruction(Instruction instruction) {
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
		if(DEBUG) System.out.println("Added " + instruction + " instruction to function " + instruction.getFunction().getName() + ", Scope: " + scope.size());
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
	
	// TODO: add builder functions for remaining instruction types
	
	public void endFunction() {
		if(function != null) {
			if(!scope.isEmpty()) {
				throw new IllegalStateException("Unclosed branches or loops");
			} else {
				Instruction implicitReturn = new ImplicitReturn(function);
				addInstruction(implicitReturn);
				function = null;
			}
		} else {
			throw new IllegalStateException("No function to end.");
		}
	}
	
}
