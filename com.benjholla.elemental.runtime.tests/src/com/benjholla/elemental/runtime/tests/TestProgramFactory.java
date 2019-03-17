package com.benjholla.elemental.runtime.tests;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;

import com.benjholla.elemental.runtime.Program;
import com.benjholla.elemental.runtime.ProgramFactory;

class TestProgramFactory {

	@Test
	void testBasic() {
		ProgramFactory programFactory = new ProgramFactory(System.in, System.out);
		programFactory.beginFunction((byte)0);
		programFactory.addIncrementInstruction();
		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
	}
	
	@Test
	void testContainmentFailure() {
		try {
			ProgramFactory programFactory = new ProgramFactory(System.in, System.out);
			programFactory.addIncrementInstruction();
			Program program = programFactory.create();
			program.execute();
		} catch (Exception e) {
			if(e.getMessage().contains(ProgramFactory.INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION)) {
				return;
			} else {
				throw e;
			}
		}
	}
	
	@Test
	void testNonExistantFunction() {
		try {
			ProgramFactory programFactory = new ProgramFactory(System.in, System.out);
			programFactory.beginFunction((byte)0);
			programFactory.addIncrementInstruction();
			Program program = programFactory.create();
			program.execute();
		} catch (Exception e) {
			if(e.getMessage().contains(ProgramFactory.INCOMPLETE_PROGRAM)) {
				return;
			} else {
				throw e;
			}
		}
	}
	
	@Test
	void testBranchTruePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte)0);
		programFactory.beginBranchInstruction();
		programFactory.addRecallInstruction();
		programFactory.endBranchInstruction();
		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
		if(stdout.toByteArray().length != 0) {
			throw new RuntimeException("Unexpected output");
		}
	}
	
	@Test
	void testBranchFalsePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte)0);
		programFactory.addIncrementInstruction();
		programFactory.beginBranchInstruction();
		programFactory.addRecallInstruction();
		programFactory.endBranchInstruction();
		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
		if(stdout.toByteArray().length == 0) {
			throw new RuntimeException("Unexpected output");
		}
	}

}
