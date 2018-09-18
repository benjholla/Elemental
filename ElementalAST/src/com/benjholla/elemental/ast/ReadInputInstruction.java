package com.benjholla.elemental.ast;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class ReadInputInstruction extends Instruction {

	public ReadInputInstruction(ParserSourceCorrespondence sc) {
		super(sc);
	}

	@Override
	public Type getType() {
		return Type.READ;
	}
	
}
