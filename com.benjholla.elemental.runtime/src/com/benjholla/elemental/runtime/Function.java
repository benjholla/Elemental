package com.benjholla.elemental.runtime;

import java.util.HashMap;
import java.util.Map;

public abstract class Function {
	
	private Byte name;
	private Program program;
	private int ip;
	private Instruction[] instructions;
	private Map<Byte,Instruction> gotos = new HashMap<Byte,Instruction>();
	
	public Function(Program program, Byte name, Instruction... instructions) {
		this.program = program;
		this.name = name;
		this.instructions = instructions;
		for(Instruction instruction : instructions) {
			// TODO: implement
		}
	}
	
	public Program getProgram() {
		return program;
	}
	
	public Byte getName() {
		return name;
	}
	
	public int getInstructionPointer() {
		return ip;
	}
	
	public void setInstructionPointer(int ip) {
		this.ip = ip;
	}
	
	public void GOTO(Byte target) {
		gotos.get(target).execute();
	}
	
	public void computedGOTO() {
		Byte target = program.getMemory().get(program.getMemoryPointer());
		gotos.get(target).execute();
	}
	
	public void execute() {
		if(instructions.length > 0) {
			instructions[getInstructionPointer()].execute();
		}
	}
	
}
