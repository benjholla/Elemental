package com.benjholla.elemental.ast;

import java.util.List;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class Program extends ASTNode {
	private List<Function> functions;

	public Program(ParserSourceCorrespondence sc, List<Function> functions) {
		super(sc);
		this.functions = functions;
	}
	
	public List<Function> getFunctions(){
		return functions;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Function function : functions) {
			result.append("\n" + function.toString());
		}
		return "Program: " + result + "}";
	}
	
}
