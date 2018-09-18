package com.benjholla.elemental.ast;

import java.util.List;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class BranchInstruction extends Instruction {

	private List<Instruction> instructions;

	public BranchInstruction(ParserSourceCorrespondence sc, List<Instruction> instructions) {
		super(sc);
		this.instructions = instructions;
	}
	
	public List<Instruction> getInstructions(){
		return instructions;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Instruction instruction : instructions) {
			if(instruction instanceof BranchInstruction) {
				result.append(" ");
			}
			result.append(instruction.toString());
		}
		return "Branch: (" + result + ")";
	}
	
	@Override
	public Type getType() {
		return Type.BRANCH;
	}
}
