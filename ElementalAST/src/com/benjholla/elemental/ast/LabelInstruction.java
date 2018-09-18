package com.benjholla.elemental.ast;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class LabelInstruction extends Instruction {

	private String name;
	
	public LabelInstruction(ParserSourceCorrespondence sc, String id) {
		super(sc);
		this.name = id;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Label: \"" + name + "\"";
	}
	
	@Override
	public Type getType() {
		return Type.LABEL;
	}
	
}
