package com.benjholla.elemental.runtime;

import java.io.InputStream;
import java.io.OutputStream;

import com.benjholla.elemental.runtime.Instruction.Decrement;
import com.benjholla.elemental.runtime.Instruction.ImplicitReturn;
import com.benjholla.elemental.runtime.Instruction.Increment;

public class ProgramFactory {

	private Program program;
	
	public ProgramFactory(InputStream stdin, OutputStream stdout) {
		program = new Program(stdin, stdout);
	}

	private Function function = null;
	private Instruction lastInstruction = null;
	
	public void beginFunction(Byte name) {
		function = new Function(program, name);
	}
	
	public void addIncrementInstruction() {
		if(function != null) {
			Increment increment = new Increment(function);
			function.addInstruction(increment);
			if(lastInstruction != null) {
				lastInstruction.setSuccessor(increment);
			}
			lastInstruction = increment;
		} else {
			throw new IllegalStateException("Instructions must be contained by a function.");
		}
	}
	
	public void addDecrementInstruction() {
		if(function != null) {
			Decrement decrement = new Decrement(function);
			function.addInstruction(decrement);
			if(lastInstruction != null) {
				lastInstruction.setSuccessor(decrement);
			}
			lastInstruction = decrement;
		} else {
			throw new IllegalStateException("Instructions must be contained by a function.");
		}
	}
	
	// TODO: add builder functions for remaining instruction types
	
	public void endFunction() {
		if(function != null) {
			ImplicitReturn implicitReturn = new ImplicitReturn(function);
			if(lastInstruction != null) {
				lastInstruction.setSuccessor(implicitReturn);
			}
			function.addInstruction(implicitReturn);
			program.addFunction(function);
			lastInstruction = null;
			function = null;
		} else {
			throw new IllegalStateException("No function to end.");
		}
	}
	
}
