package com.benjholla.elemental.runtime.tests;

import org.junit.jupiter.api.Test;

import com.benjholla.elemental.runtime.Program;
import com.benjholla.elemental.runtime.ProgramFactory;

class TestProgramFactory {

	@Test
	void testBasic() {
		ProgramFactory programFactory = new ProgramFactory(System.in, System.out);
		programFactory.beginFunction((byte)0);
		programFactory.addIncrementInstruction();
		Program program = programFactory.create();
		programFactory.endFunction();
		program.execute();
	}

}
