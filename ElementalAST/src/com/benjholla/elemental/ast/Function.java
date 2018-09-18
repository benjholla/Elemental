package com.benjholla.elemental.ast;

import java.util.List;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class Function extends ASTNode {

	private String name;
	private List<Instruction> instructions;

	public Function(ParserSourceCorrespondence sc, String name, List<Instruction> instructions) {
		super(sc);
		this.name = name;
		this.instructions = instructions;
	}
	
	public List<Instruction> getInstructions(){
		return instructions;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Instruction instruction : instructions) {
			if(instruction instanceof LoopInstruction || instruction instanceof BranchInstruction) {
				result.append(" ");
			}
			result.append(instruction.toString());
		}
		return "Function " + name + ": {" + result + "}";
	}

}
