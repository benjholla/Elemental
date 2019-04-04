package com.benjholla.elemental.atlas.indexer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class IndexProgram {

	public static final Byte MAIN_FUNCTION = (byte) 0x00;
	private Map<Byte,IndexFunction> functionTable;
	
	public IndexProgram() {
		this.functionTable = new HashMap<Byte,IndexFunction>();
	}
	
	@Override
	public String toString() {
		return "Program Functions: " + functionTable.keySet().stream().sorted().collect(Collectors.toList());
	}

	public void addFunction(IndexFunction function) {
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
	
	public Collection<IndexFunction> getFunctions(){
		return functionTable.values();
	}
	
}
