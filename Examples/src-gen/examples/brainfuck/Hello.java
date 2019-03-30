package examples.brainfuck;

import com.benjholla.elemental.runtime.ProgramFactory;
import com.benjholla.elemental.runtime.Program;


public class Hello {
	public static void main(String[] args){
		
		ProgramFactory factory = new ProgramFactory(System.in, System.out);
		
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
	}
	
}
