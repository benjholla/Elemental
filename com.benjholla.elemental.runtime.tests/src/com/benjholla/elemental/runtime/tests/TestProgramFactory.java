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
		programFactory.beginFunction((byte) 0);
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
			if (e.getMessage().contains(ProgramFactory.INSTRUCTIONS_MUST_BE_CONTAINED_BY_A_FUNCTION)) {
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
			programFactory.beginFunction((byte) 0);
			programFactory.addIncrement();
			Program program = programFactory.create();
			program.execute();
		} catch (Exception e) {
			if (e.getMessage().contains(ProgramFactory.INCOMPLETE_PROGRAM)) {
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
		programFactory.beginFunction((byte) 0);
		programFactory.addIncrement();
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
		if (stdout.toByteArray().length == 0) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testBranchTruePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte) 0);
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
		if (stdout.toByteArray().length != 0) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testBranchNonNestedFalseFalsePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte) 0);

		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();

		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();

		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
		if (stdout.toByteArray().length != 0) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testBranchNonNestedFalseTruePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte) 0);

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
		if (stdout.toByteArray().length != 1) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testNonNestedBranchTrueFalsePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte) 0);

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
		if (stdout.toByteArray().length != 1) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testNonNestedBranchTrueTruePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte) 0);

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
		if (stdout.toByteArray().length != 2) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testBranchNestedFalsePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte) 0);

		programFactory.beginBranch();
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		programFactory.endBranch();

		programFactory.endFunction();
		Program program = programFactory.create();
		program.execute();
		if (stdout.toByteArray().length != 0) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testBranchNestedTrueFalsePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte) 0);

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
		if (stdout.toByteArray().length != 0) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testBranchNestedTrueTruePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte) 0);

		programFactory.addIncrement();
		programFactory.beginBranch();
		programFactory.beginBranch();
		programFactory.addRecall();
		programFactory.endBranch();
		programFactory.endBranch();

		programFactory.endFunction();
		Program program = programFactory.create();

		program.execute();
		if (stdout.toByteArray().length != 1) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testWhileFalsePath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte) 0);

		programFactory.beginLoop();
		programFactory.addRecall();
		programFactory.endLoop();

		programFactory.endFunction();
		Program program = programFactory.create();

		program.execute();
		if (stdout.toByteArray().length != 0) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testWhile1IterationPath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte) 0);

		programFactory.addIncrement();

		programFactory.beginLoop();
		programFactory.addRecall();
		programFactory.addDecrement();
		programFactory.endLoop();

		programFactory.endFunction();
		Program program = programFactory.create();

		program.execute();
		if (stdout.toByteArray().length != 1) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testWhile2IterationPath() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory programFactory = new ProgramFactory(System.in, stdout);
		programFactory.beginFunction((byte) 0);

		programFactory.addIncrement();
		programFactory.addIncrement();

		programFactory.beginLoop();
		programFactory.addRecall();
		programFactory.addDecrement();
		programFactory.endLoop();

		programFactory.endFunction();
		Program program = programFactory.create();

		program.execute();
		if (stdout.toByteArray().length != 2) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testHelloWorld() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory factory = new ProgramFactory(System.in, stdout);

		factory.beginFunction((byte) 0x00);
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.beginLoop();
		factory.addMoveRight();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addMoveRight();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addMoveRight();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addMoveRight();
		factory.addIncrement();
		factory.addMoveLeft();
		factory.addMoveLeft();
		factory.addMoveLeft();
		factory.addMoveLeft();
		factory.addDecrement();
		factory.endLoop();
		factory.addMoveRight();
		factory.addIncrement();
		factory.addIncrement();
		factory.addRecall();
		factory.addMoveRight();
		factory.addIncrement();
		factory.addRecall();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addRecall();
		factory.addRecall();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addRecall();
		factory.addMoveRight();
		factory.addIncrement();
		factory.addIncrement();
		factory.addRecall();
		factory.addMoveLeft();
		factory.addMoveLeft();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addRecall();
		factory.addMoveRight();
		factory.addRecall();
		factory.addIncrement();
		factory.addIncrement();
		factory.addIncrement();
		factory.addRecall();
		factory.addDecrement();
		factory.addDecrement();
		factory.addDecrement();
		factory.addDecrement();
		factory.addDecrement();
		factory.addDecrement();
		factory.addRecall();
		factory.addDecrement();
		factory.addDecrement();
		factory.addDecrement();
		factory.addDecrement();
		factory.addDecrement();
		factory.addDecrement();
		factory.addDecrement();
		factory.addDecrement();
		factory.addRecall();
		factory.addMoveRight();
		factory.addIncrement();
		factory.addRecall();
		factory.addMoveRight();
		factory.addRecall();
		factory.endFunction();

		Program program = factory.create();
		program.execute();

		String result = new String(stdout.toByteArray());
		if (result.equals("Hello World!")) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testStaticDispatching() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory factory = new ProgramFactory(System.in, stdout);

		factory.beginFunction((byte) 0x00);
		factory.addStaticDispatch((byte) 0x01);
		factory.endFunction();

		factory.beginFunction((byte) 0x01);
		factory.addStaticDispatch((byte) 0x02);
		factory.endFunction();

		factory.beginFunction((byte) 0x02);
		factory.addRecall();
		factory.endFunction();

		Program program = factory.create();
		program.execute();

		if (stdout.toByteArray().length != 1) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testStaticDispatchingReturns() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory factory = new ProgramFactory(System.in, stdout);

		factory.beginFunction((byte) 0x00);
		factory.addStaticDispatch((byte) 0x01);
		factory.endFunction();

		factory.beginFunction((byte) 0x01);
		factory.addStaticDispatch((byte) 0x02);
		factory.addStaticDispatch((byte) 0x02);
		factory.endFunction();

		factory.beginFunction((byte) 0x02);
		factory.addRecall();
		factory.endFunction();

		Program program = factory.create();
		program.execute();

		if (stdout.toByteArray().length != 2) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testDynamicDispatching() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory factory = new ProgramFactory(System.in, stdout);

		factory.beginFunction((byte) 0x00);
		factory.addIncrement();
		factory.addDynamicDispatch();
		factory.endFunction();

		factory.beginFunction((byte) 0x01);
		factory.addRecall();
		factory.endFunction();

		factory.beginFunction((byte) 0x02);
		factory.addRecall();
		factory.addRecall();
		factory.endFunction();

		Program program = factory.create();
		program.execute();

		if (stdout.toByteArray().length != 1) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testDynamicDispatching2() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory factory = new ProgramFactory(System.in, stdout);

		factory.beginFunction((byte) 0x00);
		factory.addIncrement();
		factory.addIncrement();
		factory.addDynamicDispatch();
		factory.endFunction();

		factory.beginFunction((byte) 0x01);
		factory.addRecall();
		factory.endFunction();

		factory.beginFunction((byte) 0x02);
		factory.addRecall();
		factory.addRecall();
		factory.endFunction();

		Program program = factory.create();
		program.execute();

		if (stdout.toByteArray().length != 2) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testDynamicDispatching3() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory factory = new ProgramFactory(System.in, stdout);

		factory.beginFunction((byte) 0x00);
		factory.addIncrement();
		factory.addIncrement();
		factory.addDynamicDispatch();
		factory.addDecrement();
		factory.addDynamicDispatch();
		factory.endFunction();

		factory.beginFunction((byte) 0x01);
		factory.addRecall();
		factory.endFunction();

		factory.beginFunction((byte) 0x02);
		factory.addRecall();
		factory.addRecall();
		factory.endFunction();

		Program program = factory.create();
		program.execute();

		if (stdout.toByteArray().length != 3) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testAssignment() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory factory = new ProgramFactory(System.in, stdout);

		factory.beginFunction((byte) 0x00);
		factory.addMoveRight();
		factory.addIncrement();
		factory.addIncrement();
		factory.addMoveLeft();
		factory.addIncrement();
		factory.addAssignment();
		factory.addDecrement();
		factory.addDecrement();
		factory.beginBranch();
		factory.addRecall();
		factory.endBranch();
		factory.endFunction();

		Program program = factory.create();
		program.execute();

		if (stdout.toByteArray().length != 0) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testAssignment2() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory factory = new ProgramFactory(System.in, stdout);

		factory.beginFunction((byte) 0x00);
		factory.addMoveRight();
		factory.addIncrement();
		factory.addIncrement();
		factory.addMoveLeft();
		factory.addIncrement();
		factory.addAssignment();
		factory.beginBranch();
		factory.addRecall();
		factory.endBranch();
		factory.endFunction();

		Program program = factory.create();
		program.execute();

		if (stdout.toByteArray().length != 1) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testGOTO() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory factory = new ProgramFactory(System.in, stdout);

		factory.beginFunction((byte) 0x00);
		factory.addGOTO((byte) 0x01);
		factory.addLabel((byte) 0x00);
		factory.addRecall();
		factory.addLabel((byte) 0x01);
		factory.addRecall();
		factory.endFunction();

		Program program = factory.create();
		program.execute();

		if (stdout.toByteArray().length != 1) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testGOTO2() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory factory = new ProgramFactory(System.in, stdout);

		factory.beginFunction((byte) 0x00);
		factory.addIncrement();
		factory.addIncrement();
		factory.addLabel((byte) 0x00);
		factory.beginBranch();
		factory.addRecall();
		factory.addDecrement();
		factory.addGOTO((byte) 0x00);
		factory.endBranch();
		factory.endFunction();

		Program program = factory.create();
		program.execute();

		if (stdout.toByteArray().length != 2) {
			throw new RuntimeException("Unexpected output");
		}
	}

	@Test
	void testGOTO3() throws UnsupportedEncodingException {
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		ProgramFactory factory = new ProgramFactory(System.in, stdout);

		factory.beginFunction((byte) 0x00);
		factory.addGOTO((byte) 0x00);
		factory.addIncrement();
		factory.addIncrement();
		factory.addLabel((byte) 0x00);
		factory.endFunction();

		Program program = factory.create();
		program.execute();

		if (stdout.toByteArray().length != 0) {
			throw new RuntimeException("Unexpected output");
		}
	}

}
