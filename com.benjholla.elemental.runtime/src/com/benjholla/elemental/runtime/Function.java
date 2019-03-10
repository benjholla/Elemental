package com.benjholla.elemental.runtime;

import java.util.HashMap;
import java.util.Map;

import com.benjholla.elemental.runtime.Instruction.Branch;
import com.benjholla.elemental.runtime.Instruction.BranchingInstruction;
import com.benjholla.elemental.runtime.Instruction.GOTO;
import com.benjholla.elemental.runtime.Instruction.ImplicitReturn;
import com.benjholla.elemental.runtime.Instruction.Label;
import com.benjholla.elemental.runtime.Instruction.Loop;
import com.benjholla.elemental.runtime.Instruction.NonBranchingInstruction;

public abstract class Function {
	
	private Byte name;
	private Program program;
	private int ip;
	private Instruction[] instructions;
	private Map<Byte,Label> labels = new HashMap<Byte,Label>();
	private Map<Instruction,Successor> successors = new HashMap<Instruction,Successor>();
	private ImplicitReturn implicitReturn = new ImplicitReturn(this);
	
	private static interface Successor {}
	
	private static class SingleSuccessor implements Successor {
		private Instruction successor;
		
		public SingleSuccessor(Instruction successor) {
			this.successor = successor;
		}
		
		public Instruction getSuccessor() {
			return successor;
		}
	}
	
	private static interface ConditionValue<T> {}
	
	private static class MultiSuccessor<T> implements Successor {
		private Map<ConditionValue<T>,Instruction> successor;
		
		public MultiSuccessor(Map<ConditionValue<T>,Instruction> successor) {
			this.successor = successor;
			if(successor.size() < 2) {
				throw new RuntimeException("Multi-successor statements must have at least two successors");
			}
		}
	}
	
	private static class BooleanConditionValue implements ConditionValue<Boolean> {
		private Boolean conditionValue;
		
		public BooleanConditionValue(Boolean conditionValue) {
			this.conditionValue = conditionValue;
		}

		public Boolean getConditionValue() {
			return conditionValue;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((conditionValue == null) ? 0 : conditionValue.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BooleanConditionValue other = (BooleanConditionValue) obj;
			if (conditionValue == null) {
				if (other.conditionValue != null)
					return false;
			} else if (!conditionValue.equals(other.conditionValue))
				return false;
			return true;
		}
	}
	
	public Function(Program program, Byte name, Instruction... instructions) {
		this.program = program;
		this.name = name;
		this.instructions = instructions;
		if(instructions != null) {
			cacheLabels(instructions);
//			buildFunction(instructions);
		}
	}
	
	private void cacheLabels(Instruction[] instructions) {
		for(Instruction instruction : instructions) {
			if(instruction instanceof NonBranchingInstruction) {
				if(instruction instanceof Label) {
					// create a cached map of label names for each label instruction
					Label label = (Label) instruction;
					labels.put(label.getName(), label);
				}
			} else if(instruction instanceof BranchingInstruction) {
				if(instruction instanceof Branch) {
					cacheLabels(((Branch) instruction).getBody());
				}
			} else if(instruction instanceof BranchingInstruction) {
				if(instruction instanceof Loop) {
					cacheLabels(((Loop) instruction).getBody());
				}
			} else {
				throw new RuntimeException("Unknown instruction type");
			}
		}
	}
	
	private void buildFunction(Instruction[] instructions) {
		for(int i=0; i<instructions.length; i++) {
			Instruction instruction = instructions[i];
			if(instruction instanceof NonBranchingInstruction) {
				// by default the next instruction or an implicit return is the successor,
				// but some instruction types (ex: goto) will override this behavior
				Instruction successor;
				if(i+1 < instructions.length) {
					successor = instructions[i+1];
				} else {
					successor = implicitReturn;
				}
				
				if(instruction instanceof GOTO) {
					GOTO gotoInstruction = (GOTO) instruction;
					successor = labels.get(gotoInstruction.getLabelName());
				}
				
				// record the instruction successor
				successors.put(instruction, new SingleSuccessor(successor));
			} else if(instruction instanceof BranchingInstruction) {
				if(instruction instanceof Loop) {
					
				}
			} else {
				throw new RuntimeException("Unknown instruction type");
			}
		}
	}
	
	public Program getProgram() {
		return program;
	}
	
	public Byte getName() {
		return name;
	}
	
	public int getInstructionPointer() {
		return ip;
	}
	
	public void setInstructionPointer(int ip) {
		this.ip = ip;
	}
	
	public void GOTO(Byte target) {
		labels.get(target).execute();
	}
	
	public void computedGOTO() {
		Byte target = program.getMemory().get(program.getMemoryPointer());
		labels.get(target).execute();
	}
	
	public void execute() {
		if(instructions.length > 0) {
			instructions[getInstructionPointer()].execute();
		}
	}
	
}
