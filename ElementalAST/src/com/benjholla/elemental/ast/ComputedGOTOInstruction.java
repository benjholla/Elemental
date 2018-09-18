package com.benjholla.elemental.ast;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class ComputedGOTOInstruction extends Instruction {

	public ComputedGOTOInstruction(ParserSourceCorrespondence sc) {
		super(sc);
	}
	
	@Override
	public Type getType() {
		return Type.COMPUTED_GOTO;
	}
	
}
