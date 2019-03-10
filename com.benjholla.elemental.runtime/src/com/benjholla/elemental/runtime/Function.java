package com.benjholla.elemental.runtime;

import com.benjholla.elemental.runtime.Instruction.ImplicitReturn;

public abstract class Function {
	
	private Byte name;
	private Program program;
	private Instruction[] instructions;
	
	public Function(Program program, Byte name, Instruction... instructions) {
		this.program = program;
		this.name = name;
		if(instructions == null) {
			instructions = new Instruction[] {};
		}
		instructions = new Instruction[instructions.length + 1];
		for(int i=0; i<instructions.length; i++) {
			this.instructions[i] = instructions[i];
		}
		this.instructions[instructions.length] = new ImplicitReturn(this);
	}
	
	public Program getProgram() {
		return program;
	}
	
	public Byte getName() {
		return name;
	}
	
	public void execute() {
		Instruction next = null;
		if(instructions.length > 0) {
			next = instructions[0];
		}
		while(next != null) {
			next = next.execute();
		}
	}
	
}
