package com.benjholla.elemental.ast;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import com.benjholla.elemental.parser.support.ParserSourceCorrespondence;

public class Function extends ASTNode {

	private String name;
	private List<Instruction> instructions;
	private LinkedHashSet<LabelInstruction> labels = new LinkedHashSet<LabelInstruction>();

	public Function(ParserSourceCorrespondence sc, String name, List<Instruction> instructions) {
		super(sc);
		this.name = name;
		this.instructions = instructions;
		for(Instruction instruction : instructions) {
			if(instruction instanceof LabelInstruction) {
				LabelInstruction label = (LabelInstruction) instruction;
				String labelName = label.getName();
				try {
					int nameInt = Integer.parseInt(labelName);
					if(nameInt >= 0 && nameInt <= 255) {
						if(!this.labels.add(label)) {
							throw new IllegalArgumentException("Label \"" + label + "\" is not unique.");
						}
					} else {
						throw new IllegalArgumentException("Label \"" + label + "\" is not inclusively between 0 and 255.");
					}
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException("Label \"" + label + "\" is not a positive decimal integer.");
				}
			}
		}
	}
	
	public String getName() {
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
