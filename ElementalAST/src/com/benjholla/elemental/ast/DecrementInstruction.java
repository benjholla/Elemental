package com.benjholla.elemental.ast;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class DecrementInstruction extends Instruction {

	public DecrementInstruction(ParserSourceCorrespondence sc) {
		super(sc);
	}

	@Override
	public Type getType() {
		return Type.DECREMENT;
	}
	
}
