package com.benjholla.elemental.runtime;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Instruction {

	protected Program program;
	protected Function function;
	
	public Instruction(Function function) {
		this.function = function;
		this.program = function.getProgram();
	}
	
	public abstract void execute();
	
	public static class Increment extends Instruction {
		public Increment(Function function) {
			super(function);
		}

		@Override
		public void execute() {
			ArrayList<Byte> memory = program.getMemory();
			int mp = program.getMemoryPointer();
			byte incrementValue = memory.remove(mp);
			memory.add(mp, ++incrementValue);
		}
	}
	
	public static class Decrement extends Instruction {
		public Decrement(Function function) {
			super(function);
		}

		@Override
		public void execute() {
			ArrayList<Byte> memory = program.getMemory();
			int mp = program.getMemoryPointer();
			byte decrementValue = memory.remove(mp);
			memory.add(mp, --decrementValue);
		}
	}
	
	public static class MoveLeft extends Instruction {
		public MoveLeft(Function function) {
			super(function);
		}

		@Override
		public void execute() {
			program.setMemoryPointer(program.getMemoryPointer() + 1);
			if(program.getMemoryPointer() == program.getMemory().size()){
				// we have reached the end of the tape, grow by one cell
				program.getMemory().add((byte)0x00);
			}
		}
	}
	
	public static class MoveRight extends Instruction {
		public MoveRight(Function function) {
			super(function);
		}

		@Override
		public void execute() {
			int currentMemoryPointer = program.getMemoryPointer();
			program.setMemoryPointer((currentMemoryPointer>0) ? currentMemoryPointer-1 : 0);
		}
	}
	
	public static class Store extends Instruction {
		public Store(Function function) {
			super(function);
		}

		@Override
		public void execute() {
			program.getMemory().remove(program.getMemoryPointer());
			byte[] bytes = new byte[1];
			if(program.getStdin() != null) {
				try {
					program.getStdin().read(bytes);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			program.getMemory().add(program.getMemoryPointer(), bytes[0]);
		}
	}
	
	public static class Recall extends Instruction {
		public Recall(Function function) {
			super(function);
		}

		@Override
		public void execute() {
			try {
				program.getStdout().write(new byte[] {program.getMemory().get(program.getMemoryPointer())});
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
		public void execute() {
			// TODO: implement
		}
	}
	
	public static class Branch extends Instruction {
		public Branch(Function function, Instruction... instructions) {
			super(function);
		}

		@Override
		public void execute() {
			if (program.getMemory().get(program.getMemoryPointer()) != 0) {
				
			} else {
				// TODO: branch successor
			}
		}
	}
	
	public static class Loop extends Instruction {
		public Loop(Function function, Instruction... instructions) {
			super(function);
		}

		@Override
		public void execute() {
			while (program.getMemory().get(program.getMemoryPointer()) != 0) {
				
			}
			// TODO: loop successor
		}
	}
	
	public static class Label extends Instruction {
		public Label(Function function, byte label) {
			super(function);
		}

		@Override
		public void execute() {
			function.setInstructionPointer(function.getInstructionPointer()+1);
		}
	}
	
	public static class GOTO extends Instruction {
		public GOTO(Function function, byte label) {
			super(function);
		}

		@Override
		public void execute() {
			// TODO: implement
		}
	}
	
	public static class ComputedGOTO extends Instruction {
		public ComputedGOTO(Function function) {
			super(function);
		}

		@Override
		public void execute() {
			// TODO: implement
		}
	}
	
	public static class StaticDispatch extends Instruction {
		private byte target;
		public StaticDispatch(Function function, byte target) {
			super(function);
			this.target = target;
		}

		@Override
		public void execute() {
			program.staticDispatch(target);
		}
	}
	
	public static class DynamicDispatch extends Instruction {
		public DynamicDispatch(Function function) {
			super(function);
		}

		@Override
		public void execute() {
			program.dynamicDispatch();
		}
	}
	
}
