package com.benjholla.elemental.ast;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class MoveRightInstruction extends Instruction {

	public MoveRightInstruction(ParserSourceCorrespondence sc) {
		super(sc);
	}
	
	@Override
	public Type getType() {
		return Type.MOVE_RIGHT;
	}
	
}
