package com.benjholla.elemental.runtime;

public abstract class Function {
	
	private Byte name;
	private Program program;
	
	public Function(Program program, Byte name, Instruction... instructions) {
		this.program = program;
		this.name = name;
	}
	
	public Program getProgram() {
		return program;
	}
	
	public Byte getName() {
		return name;
	}
	
	public void execute() {
		
	}
	
}
