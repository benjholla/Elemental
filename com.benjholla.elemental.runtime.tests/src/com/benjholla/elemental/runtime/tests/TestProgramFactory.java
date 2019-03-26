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
		programFactory.addIncrement();
		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
	}
	
	@Test
	void testContainmentFailure() {
		try {
			ProgramFactory programFactory = new ProgramFactory(System.in, System.out);
			programFactory.addIncrement();
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
			programFactory.addIncrement();
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
	void testBranchFalsePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte)0);
		programFactory.addIncrement();
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
		if(stdout.toByteArray().length == 0) {
			throw new RuntimeException("Unexpected output");
		}
	}
	
	@Test
	void testBranchTruePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte)0);
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
		if(stdout.toByteArray().length != 0) {
			throw new RuntimeException("Unexpected output");
		}
	}
	
	@Test
	void testBranchNonNestedFalseFalsePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte)0);
		
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		
		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
		if(stdout.toByteArray().length != 0) {
			throw new RuntimeException("Unexpected output");
		}
	}
	
	@Test
	void testBranchNonNestedFalseTruePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte)0);
		
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		
		programFactory.addIncrement();
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		
		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
		if(stdout.toByteArray().length != 1) {
			throw new RuntimeException("Unexpected output");
		}
	}
	
	@Test
	void testNonNestedBranchTrueFalsePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte)0);
		
		programFactory.addIncrement();
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		
		programFactory.addDecrement();
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		
		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
		if(stdout.toByteArray().length != 1) {
			throw new RuntimeException("Unexpected output");
		}
	}
	
	@Test
	void testNonNestedBranchTrueTruePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte)0);
		
		programFactory.addIncrement();
		
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		
		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
		if(stdout.toByteArray().length != 2) {
			throw new RuntimeException("Unexpected output");
		}
	}
	
	@Test
	void testBranchNestedFalsePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte)0);
		
		programFactory.beginBranch();
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		programFactory.endBranch();
		
		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
		if(stdout.toByteArray().length != 0) {
			throw new RuntimeException("Unexpected output");
		}
	}
	
	@Test
	void testBranchNestedTrueFalsePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte)0);
		
		programFactory.addIncrement();
		programFactory.beginBranch();
		programFactory.addDecrement();
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		programFactory.endBranch();
		
		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
		if(stdout.toByteArray().length != 0) {
			throw new RuntimeException("Unexpected output");
		}
	}
	
	@Test
	void testBranchNestedTrueTruePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte)0);
		
		programFactory.addIncrement();
		programFactory.beginBranch();
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		programFactory.endBranch();
		
		programFactory.endFunction();
		Program program = programFactory.create();
		
		program.execute();
		if(stdout.toByteArray().length != 1) {
			throw new RuntimeException("Unexpected output");
		}
	}
	
	@Test
	void testWhileFalsePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte)0);
		
		programFactory.beginLoop();
		programFactory.addRecall();
		programFactory.endLoop();
		
		programFactory.endFunction();
		Program program = programFactory.create();

		program.execute();
		if(stdout.toByteArray().length != 0) {
			throw new RuntimeException("Unexpected output");
		}
	}
	
	@Test
	void testWhile1IterationPath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte)0);
		
		programFactory.addIncrement();
		
		programFactory.beginLoop();
		programFactory.addRecall();
		programFactory.addDecrement();
		programFactory.endLoop();
		
		programFactory.endFunction();
		Program program = programFactory.create();

		program.execute();
		if(stdout.toByteArray().length != 1) {
			throw new RuntimeException("Unexpected output");
		}
	}
	
	@Test
	void testWhile2IterationPath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte)0);
		
		programFactory.addIncrement();
		programFactory.addIncrement();
		
		programFactory.beginLoop();
		programFactory.addRecall();
		programFactory.addDecrement();
		programFactory.endLoop();
		
		programFactory.endFunction();
		Program program = programFactory.create();

		program.execute();
		if(stdout.toByteArray().length != 2) {
			throw new RuntimeException("Unexpected output");
		}
	}
	
}
