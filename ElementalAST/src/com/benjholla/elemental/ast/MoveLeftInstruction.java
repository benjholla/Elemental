package com.benjholla.elemental.ast;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class MoveLeftInstruction extends Instruction {

	public MoveLeftInstruction(ParserSourceCorrespondence sc) {
		super(sc);
	}
	
	@Override
	public Type getType() {
		return Type.MOVE_LEFT;
	}
	
}
