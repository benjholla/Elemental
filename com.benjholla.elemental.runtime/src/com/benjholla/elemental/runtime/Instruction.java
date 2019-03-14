package com.benjholla.elemental.runtime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public abstract class Instruction {

	protected Program program;
	protected Function function;
	protected Instruction successor = null;
	
	public Instruction(Function function) {
		this.function = function;
		this.program = function.getProgram();
	}
	
	public abstract Instruction execute();
	
	public void setSuccessor(Instruction successor) {
		this.successor = successor;
	}
	
	public static class ImplicitReturn extends Instruction {
		public ImplicitReturn(Function function) {
			super(function);
		}

		@Override
		public Instruction execute() {
			function.getProgram().getCallStack().pop();
			return null;
		}
	}
	
	public static class Increment extends Instruction {
		public Increment(Function function) {
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
		public Decrement(Function function) {
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
		public MoveLeft(Function function) {
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
	
	public static class MoveRight extends Instruction {
		public MoveRight(Function function) {
			super(function);
		}

		@Override
		public Instruction execute() {
			int currentMemoryPointer = program.getMemoryPointer();
			program.setMemoryPointer((currentMemoryPointer>0) ? currentMemoryPointer-1 : 0);
			return successor;
		}
	}
	
	public static class Store extends Instruction {
		public Store(Function function) {
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
		public Recall(Function function) {
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
		public Assignment(Function function) {
			super(function);
		}

		@Override
		public Instruction execute() {
			Byte value = program.getMemory().get(program.getMemoryPointer());
			program.getMemory().set(program.getMemoryPointer(), value);
			return successor;
		}
	}
	
	// TODO: branches should have an add instruction
	public static class Branch extends Instruction {
		private Instruction[] body;
		
		public Branch(Function function, Instruction... instructions) {
			super(function);
			if(instructions != null) {
				body = instructions;
			} else {
				body = new Instruction[] {};
			}
		}
		
		public Instruction[] getBody() {
			return body;
		}

		@Override
		public Instruction execute() {
			if (program.getMemory().get(program.getMemoryPointer()) != 0) {
				if(body.length > 0) {
					return body[0];
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
		private Loop header;
		
		public LoopBack(Function function, Loop header) {
			super(function);
			this.header = header;
		}
		
		public Loop getHeader() {
			return header;
		}

		@Override
		public Instruction execute() {
			return header;
		}
	}
	
	// TODO: loops should have an add instruction
	public static class Loop extends Instruction {
		private Instruction[] body;
		
		public Loop(Function function, Instruction... instructions) {
			super(function);
			if(instructions == null) {
				instructions = new Instruction[] {};
			}
			body = new Instruction[instructions.length + 1];
			for(int i=0; i<instructions.length; i++) {
				body[i] = instructions[i];
			}
			body[instructions.length] = new LoopBack(function, this);
		}
		
		public Instruction[] getBody() {
			return body;
		}

		@Override
		public Instruction execute() {
			if (program.getMemory().get(program.getMemoryPointer()) != 0) {
				if(body.length > 0) {
					return body[0];
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
		
		public Label(Function function, Byte name) {
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
		private Label label;
		
		public GOTO(Function function, Label label) {
			super(function);
			this.label = label;
		}
		
		public Label getLabel() {
			return label;
		}

		@Override
		public Instruction execute() {
			return label;
		}
	}
	
	public static class ComputedGOTO extends Instruction {
		private Map<Byte,Label> labels;
		
		public ComputedGOTO(Function function, Map<Byte,Label> labels) {
			super(function);
			this.labels = labels;
		}

		@Override
		public Instruction execute() {
			Byte name = program.getMemory().get(program.getMemoryPointer());
			return labels.get(name);
		}
	}
	
	public static class StaticDispatch extends Instruction {
		private Byte target;
		
		public StaticDispatch(Function function, Byte target) {
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
		public DynamicDispatch(Function function) {
			super(function);
		}

		@Override
		public Instruction execute() {
			program.dynamicDispatch();
			return successor;
		}
	}
	
}
