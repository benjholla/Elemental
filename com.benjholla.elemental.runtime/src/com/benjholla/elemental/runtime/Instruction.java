package com.benjholla.elemental.runtime;

import java.util.ArrayList;

public abstract class Instruction {

	protected Function function;
	
	public Instruction(Function function) {
		this.function = function;
	}
	
	public abstract void execute();
	
	public static class Increment extends Instruction {
		public Increment(Function function) {
			super(function);
		}

		@Override
		public void execute() {
			Program program = function.getProgram();
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
			Program program = function.getProgram();
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
			// TODO: implement
		}
	}
	
	public static class MoveRight extends Instruction {
		public MoveRight(Function function) {
			super(function);
		}

		@Override
		public void execute() {
			// TODO: implement
		}
	}
	
	public static class Store extends Instruction {
		public Store(Function function) {
			super(function);
		}

		@Override
		public void execute() {
			// TODO: implement
		}
	}
	
	public static class Recall extends Instruction {
		public Recall(Function function) {
			super(function);
		}

		@Override
		public void execute() {
			// TODO: implement
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
			// TODO: implement
		}
	}
	
}
