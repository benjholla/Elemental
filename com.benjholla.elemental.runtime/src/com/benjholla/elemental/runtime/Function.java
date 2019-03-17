package com.benjholla.elemental.runtime;

import java.util.ArrayList;
import java.util.List;

public class Function {
	
	private Byte name;
	private Program program;
	private List<Instruction> body;
	
	public Function(Program program, Byte name) {
		this.program = program;
		this.name = name;
		body = new ArrayList<Instruction>();
	}
	
	public List<Instruction> getInstructions() {
		return body;
	}
	
	public void addInstruction(Instruction instruction) {
		body.add(instruction);
	}
	
	public Program getProgram() {
		return program;
	}
	
	public Byte getName() {
		return name;
	}
	
	public void execute() {
		Instruction next = null;
		if(body.size() > 0) {
			next = body.get(0);
		}
		while(next != null) {
			next = next.execute();
		}
	}
	
}
