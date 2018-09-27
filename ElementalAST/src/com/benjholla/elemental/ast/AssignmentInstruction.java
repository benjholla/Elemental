package com.benjholla.elemental.ast;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class AssignmentInstruction extends Instruction {

	public AssignmentInstruction(ParserSourceCorrespondence sc) {
		super(sc);
	}
	
	@Override
	public Type getType() {
		return Type.ASSIGNMENT;
	}
	
}
