package com.benjholla.elemental.ast;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class FunctionPointerCallsiteInstruction extends Instruction {

	public FunctionPointerCallsiteInstruction(ParserSourceCorrespondence sc) {
		super(sc);
	}

	public String toString() {
		return "Function Pointer Callsite";
	}
	
	@Override
	public Type getType() {
		return Type.FUNCTION_POINTER_CALLSITE;
	}
	
}
