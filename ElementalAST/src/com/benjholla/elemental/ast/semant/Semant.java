package com.benjholla.elemental.ast.semant;

import com.benjholla.elemental.ast.CallsiteInstruction;
import com.benjholla.elemental.ast.Function;
import com.benjholla.elemental.ast.GOTOInstruction;
import com.benjholla.elemental.ast.Instruction;
import com.benjholla.elemental.ast.LabelInstruction;
import com.benjholla.elemental.ast.Program;

public class Semant {

	public static void semant(Program program) {
		for(Function function : program.getFunctions()) {
			// check goto label jumps point to valid labels
			for(Instruction instruction : function.getInstructions()) {
				if(instruction instanceof GOTOInstruction) {
					GOTOInstruction gotoLabel = (GOTOInstruction) instruction;
					boolean labelExists = false;
					for(LabelInstruction label : function.getLabels()) {
						if(label.getName().equals(gotoLabel.getName())){
							labelExists = true;
							break;
						}
					}
					if(!labelExists) {
						throw new IllegalArgumentException(gotoLabel + " in function " + function.getName() + " references a non-existant label");
					}
				}
			}
			
			// check that callsites jump to valid functions
			for(Instruction instruction : function.getInstructions()) {
				if(instruction instanceof CallsiteInstruction) {
					CallsiteInstruction callsite = (CallsiteInstruction) instruction;
					boolean functionExists = false;
					for(Function functionDeclaration : program.getFunctions()) {
						if(functionDeclaration.getName().equals(callsite.getName())){
							functionExists = true;
							break;
						}
					}
					if(!functionExists) {
						throw new IllegalArgumentException(callsite + " in function " + function.getName() + " references a non-existant function");
					}
				}
			}
		}
	}
	
}
