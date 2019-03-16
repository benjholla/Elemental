package com.benjholla.elemental.runtime;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

import com.benjholla.elemental.runtime.Instruction.Assignment;
import com.benjholla.elemental.runtime.Instruction.Branch;
import com.benjholla.elemental.runtime.Instruction.Decrement;
import com.benjholla.elemental.runtime.Instruction.ImplicitReturn;
import com.benjholla.elemental.runtime.Instruction.Increment;
import com.benjholla.elemental.runtime.Instruction.Loop;
import com.benjholla.elemental.runtime.Instruction.MoveLeft;
import com.benjholla.elemental.runtime.Instruction.MoveRight;
import com.benjholla.elemental.runtime.Instruction.Recall;
import com.benjholla.elemental.runtime.Instruction.Store;

public class ProgramFactory {

	private Program program;
	
	public ProgramFactory(InputStream stdin, OutputStream stdout) {
		program = new Program(stdin, stdout);
	}

	public Program create() {
		return program;
	}
	
	private Function function = null;
	private Stack<Instruction> lastNestedInstruction = new Stack<Instruction>();
	
	public void beginFunction(Byte name) {
		function = new Function(program, name);
	}
	
	public void addIncrementInstruction() {
		if(function != null) {
			Increment increment = new Increment(function);
			function.addInstruction(increment);
			if(!lastNestedInstruction.isEmpty()) {
				lastNestedInstruction.peek().setSuccessor(increment);
				
			}
			lastNestedInstruction.push(increment);
		} else {
			throw new IllegalStateException("Instructions must be contained by a function.");
		}
	}
	
	public void addDecrementInstruction() {
		if(function != null) {
			Decrement decrement = new Decrement(function);
			function.addInstruction(decrement);
			if(!lastNestedInstruction.isEmpty()) {
				lastNestedInstruction.peek().setSuccessor(decrement);
				lastNestedInstruction.pop();
			}
			lastNestedInstruction.push(decrement);
		} else {
			throw new IllegalStateException("Instructions must be contained by a function.");
		}
	}
	
	public void addMoveLeftInstruction() {
		if(function != null) {
			MoveLeft moveLeft = new MoveLeft(function);
			function.addInstruction(moveLeft);
			if(!lastNestedInstruction.isEmpty()) {
				lastNestedInstruction.peek().setSuccessor(moveLeft);
				lastNestedInstruction.pop();
			}
			lastNestedInstruction.push(moveLeft);
		} else {
			throw new IllegalStateException("Instructions must be contained by a function.");
		}
	}
	
	public void addMoveRightInstruction() {
		if(function != null) {
			MoveRight moveRight = new MoveRight(function);
			function.addInstruction(moveRight);
			if(!lastNestedInstruction.isEmpty()) {
				lastNestedInstruction.peek().setSuccessor(moveRight);
				lastNestedInstruction.pop();
			}
			lastNestedInstruction.push(moveRight);
		} else {
			throw new IllegalStateException("Instructions must be contained by a function.");
		}
	}
	
	public void addStoreInstruction() {
		if(function != null) {
			Store store = new Store(function);
			function.addInstruction(store);
			if(!lastNestedInstruction.isEmpty()) {
				lastNestedInstruction.peek().setSuccessor(store);
				lastNestedInstruction.pop();
			}
			lastNestedInstruction.push(store);
		} else {
			throw new IllegalStateException("Instructions must be contained by a function.");
		}
	}
	
	public void addRecallInstruction() {
		if(function != null) {
			Recall recall = new Recall(function);
			function.addInstruction(recall);
			if(!lastNestedInstruction.isEmpty()) {
				lastNestedInstruction.peek().setSuccessor(recall);
				lastNestedInstruction.pop();
			}
			lastNestedInstruction.push(recall);
		} else {
			throw new IllegalStateException("Instructions must be contained by a function.");
		}
	}
	
	public void addAssignmentInstruction() {
		if(function != null) {
			Assignment assignment = new Assignment(function);
			function.addInstruction(assignment);
			if(!lastNestedInstruction.isEmpty()) {
				lastNestedInstruction.peek().setSuccessor(assignment);
				lastNestedInstruction.pop();
			}
			lastNestedInstruction.push(assignment);
		} else {
			throw new IllegalStateException("Instructions must be contained by a function.");
		}
	}
	
	public void beginBranchInstruction() {
		if(function != null) {
			Branch branch = new Branch(function);
			function.addInstruction(branch);
			if(!lastNestedInstruction.isEmpty()) {
				lastNestedInstruction.peek().setSuccessor(branch);
			}
			lastNestedInstruction.push(branch);
		} else {
			throw new IllegalStateException("Instructions must be contained by a function.");
		}
	}
	
	public void endBranchInstruction() {
		if(function != null) {
			lastNestedInstruction.pop();
			if(!(lastNestedInstruction.peek() instanceof Branch)) {
				throw new IllegalStateException("No corresponding begin branch.");
			}
		} else {
			throw new IllegalStateException("Instructions must be contained by a function.");
		}
	}
	
	// TODO: add builder functions for remaining instruction types
	
	public void endFunction() {
		if(function != null) {
			ImplicitReturn implicitReturn = new ImplicitReturn(function);
			if(!lastNestedInstruction.isEmpty()) {
				lastNestedInstruction.peek().setSuccessor(implicitReturn);
			}
			function.addInstruction(implicitReturn);
			program.addFunction(function);
			lastNestedInstruction.clear();
			function = null;
		} else {
			throw new IllegalStateException("No function to end.");
		}
	}
	
}
