package com.benjholla.elemental.ast;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public abstract class Instruction extends ASTNode {

	public static enum Type {
		INCREMENT("+"), 
		DECREMENT("-"),
		MOVE_RIGHT(">"),
		MOVE_LEFT("<"),
		READ(","),
		WRITE("."),
		LOOP("["),
		BRANCH("("),
		LABEL("\""), 
		GOTO("'"), 
		CALLSITE("{"), 
		COMPUTED_GOTO("&"), 
		FUNCTION_POINTER_CALLSITE("?"), 
		ASSIGNMENT("=");
		
		private String name;
		
		private Type(String name) {
			this.name = name;
		}
		
		public String toString() {
			return name;
		}
	}
	
	public String toString() {
		return getType().toString();
	}
	
	public abstract Type getType();
	
	public Instruction(ParserSourceCorrespondence sc) {
		super(sc);
	}

}
