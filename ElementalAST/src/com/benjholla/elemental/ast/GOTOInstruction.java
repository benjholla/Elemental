package com.benjholla.elemental.ast;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class GOTOInstruction extends Instruction {

	private String name;
	
	public GOTOInstruction(ParserSourceCorrespondence sc, String id) {
		super(sc);
		this.name = id;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "GOTO: '" + name + "'";
	}
	
	@Override
	public Type getType() {
		return Type.GOTO;
	}
	
}
