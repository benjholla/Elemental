package com.benjholla.elemental.runtime.tests;

import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;

import com.benjholla.elemental.runtime.Program;
import com.benjholla.elemental.runtime.ProgramFactory;

class TestProgramFactory {

//	@Test
//	void testBasic() {
//		ProgramFactory programFactory = new ProgramFactory(System.in, System.out);
//		programFactory.beginFunction((byte)0);
//		programFactory.addIncrementInstruction();
//		programFactory.endFunction();
//		Program program = programFactory.create();
//		program.execute();
//	}
//	
//	@Test
//	void testContainmentFailure() {
//		try {
//			ProgramFactory programFactory = new ProgramFactory(System.in, System.out);
//			programFactory.addIncrementInstruction();
//			Program program = programFactory.create();
//			program.execute();
//		} catch (Exception e) {
//			if(e.getMessage().contains(ProgramFactory.INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION)) {
//				return;
//			} else {
//				throw e;
//			}
//		}
//		fail("Expected an exception for function container");
//	}
//	
//	@Test
//	void testNonExistantFunction() {
//		try {
//			ProgramFactory programFactory = new ProgramFactory(System.in, System.out);
//			programFactory.beginFunction((byte)0);
//			programFactory.addIncrementInstruction();
//			Program program = programFactory.create();
//			program.execute();
//		} catch (Exception e) {
//			if(e.getMessage().contains("does not exist")) {
//				return;
//			} else {
//				throw e;
//			}
//		}
//		fail("Expected an exception for non existant dispatch target");
//	}
	
	@Test
	void testBranch() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte)0);
		programFactory.beginBranchInstruction();
		programFactory.addRecallInstruction();
		programFactory.endBranchInstruction();
		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
		String output = new String(stdout.toByteArray(), "UTF-8");
		System.out.println(output);
		if(!output.equals("0")) {
			throw new RuntimeException("Unexpected output");
		}
	}

}
