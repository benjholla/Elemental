package com.benjholla.elemental.runtime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Instruction {

	protected Program program;
	protected Function function;
	protected Instruction successor = null;
	
	protected Instruction(Function function) {
		this.function = function;
		this.program = function.getProgram();
	}
	
	public Program getProgram() {
		return program;
	}
	
	public Function getFunction() {
		return function;
	}
	
	public abstract Instruction execute();
	
	protected void setSuccessor(Instruction successor) {
		this.successor = successor;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	public static class ImplicitReturn extends Instruction {
		protected ImplicitReturn(Function function) {
			super(function);
		}

		@Override
		public Instruction execute() {
			function.getProgram().getCallStack().pop();
			return null;
		}
	}
	
	public static class Increment extends Instruction {
		protected Increment(Function function) {
			super(function);
		}

		@Override
		public Instruction execute() {
			ArrayList<Byte> memory = program.getMemory();
			int mp = program.getMemoryPointer();
			byte incrementValue = memory.remove(mp);
			memory.add(mp, ++incrementValue);
			return successor;
		}
	}
	
	public static class Decrement extends Instruction {
		protected Decrement(Function function) {
			super(function);
		}

		@Override
		public Instruction execute() {
			ArrayList<Byte> memory = program.getMemory();
			int mp = program.getMemoryPointer();
			byte decrementValue = memory.remove(mp);
			memory.add(mp, --decrementValue);
			return successor;
		}
	}
	
	public static class MoveLeft extends Instruction {
		protected MoveLeft(Function function) {
			super(function);
		}

		@Override
		public Instruction execute() {
			int currentMemoryPointer = program.getMemoryPointer();
			program.setMemoryPointer((currentMemoryPointer>0) ? currentMemoryPointer-1 : 0);
			return successor;
		}
	}
	
	public static class MoveRight extends Instruction {
		protected MoveRight(Function function) {
			super(function);
		}

		@Override
		public Instruction execute() {
			program.setMemoryPointer(program.getMemoryPointer() + 1);
			if(program.getMemoryPointer() == program.getMemory().size()){
				// we have reached the end of the tape, grow by one cell
				program.getMemory().add((byte)0x00);
			}
			return successor;
		}
	}
	
	public static class Store extends Instruction {
		protected Store(Function function) {
			super(function);
		}

		@Override
		public Instruction execute() {
			program.getMemory().remove(program.getMemoryPointer());
			byte[] bytes = new byte[1];
			if(program.getStdin() != null) {
				try {
					program.getStdin().read(bytes);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			program.getMemory().set(program.getMemoryPointer(), bytes[0]);
			return successor;
		}
	}
	
	public static class Recall extends Instruction {
		protected Recall(Function function) {
			super(function);
		}

		@Override
		public Instruction execute() {
			try {
				program.getStdout().write(new byte[] {program.getMemory().get(program.getMemoryPointer())});
				return successor;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public static class Assignment extends Instruction {
		protected Assignment(Function function) {
			super(function);
		}

		@Override
		public Instruction execute() {
			Byte cell = program.getMemory().get(program.getMemoryPointer());
			Byte value = 0x00;
			if(cell < program.getMemory().size()) {
				value = program.getMemory().get(cell);
			}
			program.getMemory().set(program.getMemoryPointer(), value);
			return successor;
		}
	}
	
	public static class Branch extends Instruction {
		private List<Instruction> body = new ArrayList<Instruction>();
		
		protected Branch(Function function) {
			super(function);
		}
		
		public List<Instruction> getBody() {
			return body;
		}

		protected void addInstruction(Instruction instruction) {
			body.add(instruction);
		}
		
		@Override
		public Instruction execute() {
			if (program.getMemory().get(program.getMemoryPointer()) != 0) {
				if(!body.isEmpty()) {
					return body.get(0);
				} else {
					// empty branch body
					return successor;
				}
			} else {
				return successor;
			}
		}
	}
	
	public static class LoopBack extends Instruction {
		public LoopBack(Function function, Loop header) {
			super(function);
			this.successor = header;
		}
		
		@Override
		protected void setSuccessor(Instruction successor) {}
		
		protected Loop getHeader() {
			return (Loop) successor;
		}

		@Override
		public Instruction execute() {
			return successor;
		}
	}
	
	public static class Loop extends Instruction {
		private List<Instruction> body = new ArrayList<Instruction>();
		
		protected Loop(Function function, Instruction... instructions) {
			super(function);
		}
		
		public List<Instruction> getBody() {
			return body;
		}
		
		protected void addInstruction(Instruction instruction) {
			body.add(instruction);
		}

		@Override
		public Instruction execute() {
			if (program.getMemory().get(program.getMemoryPointer()) != 0) {
				if(!body.isEmpty()) {
					return body.get(0);
				} else {
					// empty branch body
					return successor;
				}
			} else {
				return successor;
			}
		}
	}
	
	public static class Label extends Instruction {
		private Byte name;
		
		protected Label(Function function, Byte name) {
			super(function);
			this.name = name;
		}
		
		public Byte getName() {
			return name;
		}

		@Override
		public Instruction execute() {
			return successor;
		}
	}
	
	public static class GOTO extends Instruction {
		protected GOTO(Function function, Label label) {
			super(function);
			this.successor = label;
		}
		
		@Override
		protected void setSuccessor(Instruction successor) {}

		public Label getLabel() {
			return (Label) successor;
		}

		@Override
		public Instruction execute() {
			return successor;
		}
	}
	
	public static class ComputedGOTO extends Instruction {
		protected ComputedGOTO(Function function) {
			super(function);
		}

		@Override
		public Instruction execute() {
			Byte name = program.getMemory().get(program.getMemoryPointer());
			Label label = function.getLabel(name);
			if(label != null) {
				return label;
			} else {
				throw new RuntimeException("Computed GOTO resolved to a non-existent label");
			}
		}
	}
	
	public static class StaticDispatch extends Instruction {
		private Byte target;
		
		protected StaticDispatch(Function function, Byte target) {
			super(function);
			this.target = target;
		}

		@Override
		public Instruction execute() {
			program.staticDispatch(target);
			return successor;
		}
	}
	
	public static class DynamicDispatch extends Instruction {
		protected DynamicDispatch(Function function) {
			super(function);
		}

		@Override
		public Instruction execute() {
			program.dynamicDispatch();
			return successor;
		}
	}
	
}
