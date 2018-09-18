package com.benjholla.elemental.ast;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class IncrementInstruction extends Instruction {

	public IncrementInstruction(ParserSourceCorrespondence sc) {
		super(sc);
	}

	@Override
	public Type getType() {
		return Type.INCREMENT;
	}
	
}
