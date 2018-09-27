package com.benjholla.elemental.ast;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class CallsiteInstruction extends Instruction {

	private int name;
	
	public CallsiteInstruction(ParserSourceCorrespondence sc, String name) {
		super(sc);
		try {
			this.name = Integer.parseInt(name);
			try {
				if(this.name >= 0 && this.name <= Integer.MAX_VALUE) {
					throw new IllegalArgumentException("Callsite " + this.name + " is not inclusively between 0 and " + Integer.MAX_VALUE + ".");
				}
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Callsite " + this.name + " is not a positive decimal integer.");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
	
	public int getName() {
		return name;
	}
	
	public String toString() {
		return "Callsite: function={" + name + "}";
	}
	
	@Override
	public Type getType() {
		return Type.CALLSITE;
	}
	
}
