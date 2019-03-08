package com.benjholla.elemental.runtime;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A Element program interpreter
 * 
 * Assumptions: 
 * 1) The tape grows infinitely to the right
 * 2) The tape point resets to zero if moved past the leftmost cell
 * 3) A tape cell holds a single byte
 * 4) The default tape value is 0x00
 * 5) A read cannot be made on input that does not exist
 * 6) A read on a null input stream is an 0x00 byte value
 */
public class Program {

	private static final byte MAIN_FUNCTION = (byte) 0x00;
	
	private ArrayList<Byte> memory;
	
	private Map<Byte,Function> functionTable;
	private int mp;
	
	private InputStream stdin;
	private OutputStream stdout;
	
	public Program(InputStream stdin, OutputStream stdout, Function... functions) {
		this.stdin = stdin;
		this.stdout = stdout;
		this.functionTable = new HashMap<Byte,Function>();
		if(functions != null) {
			for(Function function : functions) {
				if(!this.functionTable.containsKey(function.getName())) {
					this.functionTable.put(function.getName(), function);
				} else {
					if(function.getName() == MAIN_FUNCTION) {
						throw new RuntimeException("Error building function table: A main function already exists");
					} else {
						throw new RuntimeException(String.format("Error building function table: A function with the name function_%d already exists", function.getName()));
					}
				}
			}
		}
		
		// initialize the tape to 1 cell with value 0
		// memory is unbounded in this implementation
		memory = new ArrayList<Byte>();
		memory.add((byte)0x00);
		
		// initialize the memory pointer (index into memory)
		mp = 0;
	}
	
	public InputStream getStdin() {
		return stdin;
	}

	public OutputStream getStdout() {
		return stdout;
	}

	public ArrayList<Byte> getMemory(){
		return memory;
	}
	
	public int getMemoryPointer() {
		return mp;
	}
	
	public void setMemoryPointer(int mp) {
		this.mp = mp;;
	}
	
	public void execute() {
		staticDispatch(MAIN_FUNCTION);
	}
	
	public void staticDispatch(Byte target) {
		invoke(target);
	}
	
	public void dynamicDispatch() {
		Byte target = memory.get(mp);
		invoke(target);
	}
	
	private void invoke(Byte target) {
		Function function = functionTable.get(target);
		if(function != null) {
			function.execute();
		} else {
			throw new RuntimeException(String.format("Dispatch target function_%d does not exist.", target));
		}
	}
	
}
