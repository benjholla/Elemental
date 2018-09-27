package com.benjholla.elemental.interpreter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.benjholla.elemental.ast.Function;
import com.benjholla.elemental.ast.Instruction;
import com.benjholla.elemental.ast.LoopInstruction;
import com.benjholla.elemental.ast.Program;

/**
 * A Elemental Interpreter implementation using a parsed Elemental AST.
 * 
 * Interpreter grammar from: http://en.wikipedia.org/wiki/Elemental
 * 
 * Assumptions: 
 * 1) The tape grows infinitely to the right
 * 2) The tape point resets to zero if moved past the leftmost cell
 * 3) A tape cell holds a single long value
 * 4) The default tape value is 0x00
 * 5) A read cannot be made on input that does not exist
 * 6) A read on a null input stream is an 0x00 byte value
 */
public class ElementalInterpreter {

//	/**
//	 * Executes a elemental program with an empty input, returning the output as a string
//	 * 
//	 * @param program
//	 * @param input
//	 * @param output
//	 * 
//	 * @throws IOException
//	 */
//	public static String execute(String program) throws IOException {
//		return execute(program, "");
//	}
//	
//	/**
//	 * Executes a elemental program with an empty input, returning the output as a string
//	 * 
//	 * @param program
//	 * @param input
//	 * @param output
//	 * 
//	 * @throws IOException
//	 */
//	public static String execute(String program, String input) throws IOException {
//		ByteArrayOutputStream output = new ByteArrayOutputStream();
//		execute(program, new ByteArrayInputStream(input.getBytes()), output, null);
//		return new String(output.toByteArray(), "UTF-8");
//	}
//	
//	/**
//	 * Executes a elemental program with the given input, output, and debug streams
//	 * 
//	 * @param program
//	 * @param input
//	 * @param output
//	 * 
//	 * @throws IOException
//	 */
//	public static void execute(String program, InputStream input, OutputStream output) throws IOException {
//		execute(program, input, output, null);
//	}
//	
//	/**
//	 * Executes a elemental program with the given input, output, and debug streams
//	 * 
//	 * @param program
//	 * @param input
//	 * @param output
//	 * @param debug
//	 * 
//	 * @throws IOException
//	 */
//	public static void execute(String program, InputStream input, OutputStream output, OutputStream debug) throws IOException {
//		InputStream codeStream = new ByteArrayInputStream(program.getBytes());
//		CharStream codeInputStream = CharStreams.fromStream(codeStream);
//		ElementalLexer lexer = new ElementalLexer(codeInputStream);
//		CommonTokenStream tokens = new CommonTokenStream(lexer);
//		ElementalParser parser = new ElementalParser(tokens);
//		parser.setFile(null);
//		Program ast = parser.program().prog;
//		execute(ast, input, output, null);
//	}
//	
//	/**
//	 * Executes a elemental program with an empty input, returning the output as a string
//	 * 
//	 * @param program
//	 * @param input
//	 * @param output
//	 * 
//	 * @throws IOException
//	 */
//	public static String execute(File program) throws IOException {
//		ByteArrayOutputStream output = new ByteArrayOutputStream();
//		execute(program, new ByteArrayInputStream("".getBytes()), output, null);
//		return new String(output.toByteArray(), "UTF-8");
//	}
//	
//	/**
//	 * Executes a elemental program with the given input, returning the output as a string
//	 * 
//	 * @param program
//	 * @param input
//	 * @param output
//	 * 
//	 * @throws IOException
//	 */
//	public static String execute(File program, String input) throws IOException {
//		return execute(program, input);
//	}
//	
//	/**
//	 * Executes a elemental program with the given input, output, and debug streams
//	 * 
//	 * @param program
//	 * @param input
//	 * @param output
//	 * 
//	 * @throws IOException
//	 */
//	public static void execute(File program, InputStream input, OutputStream output) throws IOException {
//		execute(program, input, output, null);
//	}
//	
//	/**
//	 * Executes a elemental program with the given input, output, and debug streams
//	 * 
//	 * @param program
//	 * @param input
//	 * @param output
//	 * @param debug
//	 * 
//	 * @throws IOException
//	 */
//	public static void execute(File program, InputStream input, OutputStream output, OutputStream debug) throws IOException {
//		FileInputStream fis = new FileInputStream(program);
//		CharStream codeInputStream = CharStreams.fromStream(fis);
//		ElementalLexer lexer = new ElementalLexer(codeInputStream);
//		CommonTokenStream tokens = new CommonTokenStream(lexer);
//		ElementalParser parser = new ElementalParser(tokens);
//		parser.setFile(program);
//		Program ast = parser.program().prog;
//		execute(ast, input, output, null);
//	}
	
	public static final int MAIN_FUNCTION = 0;
	
	/**
	 * Executes a elemental program with the given input, output, and debug streams
	 * 
	 * @param program
	 * @param input
	 * @param output
	 * @param debug
	 * 
	 * @throws IOException
	 */
	private static void execute(Program program, InputStream input, OutputStream output, OutputStream debug) throws IOException {
		if(program.getFunctions().isEmpty()) {
			return;
		}
		
		// initialize the tape to 1 cell with value 0
		// memory is unbounded in this implementation
		ArrayList<Byte> memory = new ArrayList<Byte>();
		memory.add((byte)0x00);
		
		// initialize the memory pointer (index into memory)
		int mp = 0;
		
		Function main = null;
		for(Function function : program.getFunctions()) {
			if(function.getName() == MAIN_FUNCTION) {
				main = function;
				break;
			}
		}
		if(main == null) {
			throw new IllegalArgumentException("Elemental program does not have a main function!");
		}
		
		Stack<LoopContext> stack = new Stack<LoopContext>();
		stack.push(new LoopContext(main.getInstructions()));
		LoopContext context = stack.peek();
		do {
			Instruction instruction = context.instructions.get(context.ip);

			if(debug != null) debug.write(("Stack Context: " + stack.size() + ", M[" + mp + "]: " + memory.get(mp) + ", IP: " + context.ip + ", " + instruction.getType() + "\n").getBytes());
			
			switch(instruction.getType()) {
				case INCREMENT:
					byte incrementValue = memory.remove(mp);
					memory.add(mp, ++incrementValue);
					break;
					
				case DECREMENT:
					byte decrementValue = memory.remove(mp);
					memory.add(mp, --decrementValue);
					break;
				
				case MOVE_RIGHT:
					mp++;
					if(mp == memory.size()){
						// we have reached the end of the tape, grow by one cell
						memory.add((byte)0x00);
					}
					break;
					
				case MOVE_LEFT:
					mp = (mp>0) ? mp-1 : 0;
					break;
					
				case READ:
					memory.remove(mp);
					byte[] bytes = new byte[1];
					if(input != null) {
						input.read(bytes);
					}
					memory.add(mp, bytes[0]);
					break;
					
				case WRITE:
					output.write(new byte[] {memory.get(mp)});
					break;
					
				case LOOP:
					// we reached a '['
					// if value at pointer is 0, skip to instruction after matching ]
					if (memory.get(mp) == 0) {
						if(debug != null) debug.write(("Stack Context: " + stack.size() + ", M[" + mp + "]: " + memory.get(mp) + ", IP: " + context.ip + ", ] SKIP\n").getBytes());
					} else {
						LoopInstruction loop = (LoopInstruction) instruction;
						LoopContext loopBody = new LoopContext(-1, loop.getInstructions());
						stack.push(loopBody);
						context = stack.peek();
					}
					break;
					
				default:
					throw new RuntimeException("Unimplemented instruction type!");
			}
			
			while(stack.size() > 1) {
				if((context.ip + 1) == context.instructions.size()) {
					// we reached a ']'
					// if value at pointer is nonzero, loop back to matching [
					if (memory.get(mp) != 0) {
						if(debug != null) debug.write(("Stack Context: " + stack.size() + ", M[" + mp + "]: " + memory.get(mp) + ", IP: " + context.ip + ", ] CONTINUE\n").getBytes());
						context.ip = -1;
						break;
					} else {
						if(debug != null) debug.write(("Stack Context: " + stack.size() + ", M[" + mp + "]: " + memory.get(mp) + ", IP: " + context.ip + ", ] BREAK\n").getBytes());
						stack.pop();
						context = stack.peek();
					}
				} else {
					break;
				}
			}
		} while (++context.ip < context.instructions.size() || stack.size() > 1);
	}
	
	private static class LoopContext {
		/**
		 * The current context instruction pointer
		 */
		public int ip;
		
		public List<Instruction> instructions;

		public LoopContext(List<Instruction> instructions) {
			this(0, instructions);
		}
		
		public LoopContext(int ip, List<Instruction> instructions) {
			this.ip = ip;
			this.instructions = instructions;
		}
	}
	
}
