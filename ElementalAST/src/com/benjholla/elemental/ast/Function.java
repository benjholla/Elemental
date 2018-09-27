package com.benjholla.elemental.ast;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class Function extends ASTNode {

	public static final int MAIN_FUNCTION = 0;
	
	private int name;
	private List<Instruction> instructions;
	private LinkedHashSet<LabelInstruction> labels = new LinkedHashSet<LabelInstruction>();

	public Function(ParserSourceCorrespondence sc, List<Instruction> instructions) {
		this(sc, new Integer(MAIN_FUNCTION).toString(), instructions);
	}
	
	public Function(ParserSourceCorrespondence sc, String name, List<Instruction> instructions) {
		super(sc);
		try {
			this.name = Integer.parseInt(name);
			try {
				if(this.name >= 0 && this.name <= Integer.MAX_VALUE) {
					throw new IllegalArgumentException("Function " + this.name + " is not inclusively between 0 and " + Integer.MAX_VALUE + ".");
				}
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Function " + this.name + " is not a positive decimal integer.");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
		this.instructions = instructions;
		for(Instruction instruction : instructions) {
			if(instruction instanceof LabelInstruction) {
				LabelInstruction label = (LabelInstruction) instruction;
				String labelName = label.getName();
				try {
					int nameInt = Integer.parseInt(labelName);
					if(nameInt >= 0 && nameInt <= 255) {
						if(!this.labels.add(label)) {
							throw new IllegalArgumentException(label + " is not unique.");
						}
					} else {
						throw new IllegalArgumentException(label + " is not inclusively between 0 and " + Integer.MAX_VALUE + ".");
					}
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException(label + " is not a positive decimal integer.");
				}
			}
		}
	}
	
	public int getName() {
		return name;
	}
	
	public List<Instruction> getInstructions(){
		return new ArrayList<Instruction>(instructions);
	}

	public List<LabelInstruction> getLabels(){
		return new ArrayList<LabelInstruction>(labels);
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Instruction instruction : instructions) {
			if(instruction instanceof LoopInstruction || instruction instanceof BranchInstruction) {
				result.append(" ");
			}
			result.append(instruction.toString());
		}
		return "Function " + name + ": {" + result + "}";
	}

}
