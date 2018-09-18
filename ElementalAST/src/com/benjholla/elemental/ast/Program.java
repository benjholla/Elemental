package com.benjholla.elemental.ast;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class Program extends ASTNode {
	private LinkedHashSet<Function> functions = new LinkedHashSet<Function>();

	public Program(ParserSourceCorrespondence sc, List<Function> functions) {
		super(sc);
		for(Function function : functions) {
			String name = function.getName();
			try {
				int nameInt = Integer.parseInt(name);
				if(nameInt >= 0 && nameInt <= 255) {
					if(!this.functions.add(function)) {
						throw new IllegalArgumentException(function + " is not unique.");
					}
				} else {
					throw new IllegalArgumentException(function + " is not inclusively between 0 and 255.");
				}
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(function + " is not a positive decimal integer.");
			}
		}
	}
	
	public List<Function> getFunctions(){
		return new ArrayList<Function>(functions);
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
