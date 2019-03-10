package com.benjholla.elemental.runtime;

import java.util.ArrayList;
import java.util.List;

import com.benjholla.elemental.runtime.Instruction.ImplicitReturn;
import com.benjholla.elemental.runtime.Instruction.Increment;

public abstract class Function {
	
	private Byte name;
	private Program program;
	private List<Instruction> instructions;
	private ImplicitReturn implicitReturn;
	
	public Function(Program program, Byte name) {
		this.program = program;
		this.name = name;
		instructions = new ArrayList<Instruction>();
		implicitReturn = new ImplicitReturn(this);
		instructions.add(implicitReturn);
	}
	
	public void addInstruction(Instruction instruction) {
		Instruction previousInstruction = null;
		if(instructions.size() >= 2) {
			previousInstruction = instructions.get(instructions.size()-2);
		}
		instructions.set(instructions.size()-1, instruction);
		instructions.add(implicitReturn);
		if(previousInstruction != null) {
			if(previousInstruction instanceof Increment) {
				Increment i = (Increment) previousInstruction;
				i.setSuccessor(instruction);
			}
		}
	}
	
	public ImplicitReturn getImplicitReturn() {
		return implicitReturn;
	}
	
	public Program getProgram() {
		return program;
	}
	
	public Byte getName() {
		return name;
	}
	
	public void execute() {
		Instruction next = null;
		if(instructions.size() > 0) {
			next = instructions.get(0);
		}
		while(next != null) {
			next = next.execute();
		}
	}
	
}
