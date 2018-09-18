package com.benjholla.elemental.ast;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class CallsiteInstruction extends Instruction {

	private String name;
	
	public CallsiteInstruction(ParserSourceCorrespondence sc, String name) {
		super(sc);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Callsite: {" + name + "}";
	}
	
	@Override
	public Type getType() {
		return Type.CALLSITE;
	}
	
}
