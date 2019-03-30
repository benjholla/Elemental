package com.benjholla.elemental.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.benjholla.elemental.runtime.Instruction.Label;

public class Function {
	
	private Byte name;
	private Program program;
	private List<Instruction> body = new ArrayList<Instruction>();
	private Map<Byte,Label> labels = new HashMap<Byte,Label>();
	
	@Override
	public String toString() {
		return body.toString();
	}
	
	public Function(Program program, Byte name) {
		this.program = program;
		this.name = name;
	}
	
	public List<Instruction> getInstructions() {
		return body;
	}
	
	public void addInstruction(Instruction instruction) {
		if(instruction !=  null) {
			body.add(instruction);
			if(instruction instanceof Label) {
				Label label = (Label) instruction;
				labels.put(label.getName(), label);
			}
		} else {
			throw new IllegalStateException("Instruction cannot be null");
		}
	}
	
	public Label getLabel(Byte name) {
		return labels.get(name);
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
