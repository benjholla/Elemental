package com.benjholla.elemental.ast;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class WriteOutputInstruction extends Instruction {

	public WriteOutputInstruction(ParserSourceCorrespondence sc) {
		super(sc);
	}

	@Override
	public Type getType() {
		return Type.WRITE;
	}
	
}
