package examples.brainfuck;

import com.benjholla.elemental.runtime.ProgramFactory;
import com.benjholla.elemental.runtime.Program;


public class Hello2 {
	public static void main(String[] args){
		
		ProgramFactory factory = new ProgramFactory(System.in, System.out);
		
		factory.beginFunction((byte) 0x00);
		factory.addIncrement();
		factory.beginLoop();
		factory.addDecrement();
		factory.beginLoop();
		factory.addMoveLeft();
		factory.addMoveLeft();
		factory.beginLoop();
		factory.addIncrement();
		factory.beginLoop();
		factory.addDecrement();
		factory.addDecrement();
		factory.addDecrement();
		factory.addMoveRight();
		factory.endLoop();
		factory.addDecrement();
		factory.beginLoop();
		factory.addMoveLeft();
		factory.addMoveLeft();
		factory.addMoveLeft();
		factory.endLoop();
		factory.endLoop();
		factory.endLoop();
		factory.addMoveRight();
		factory.addMoveRight();
		factory.addMoveRight();
		factory.addDecrement();
		factory.endLoop();
		factory.addMoveRight();
		factory.addDecrement();
		factory.addRecall();
		factory.addDecrement();
		factory.addDecrement();
		factory.addDecrement();
		factory.addRecall();
		factory.addMoveRight();
		factory.addRecall();
		factory.addRecall();
		factory.addMoveRight();
		factory.addRecall();
		factory.addMoveLeft();
		factory.addMoveLeft();
		factory.addMoveLeft();
		factory.addMoveLeft();
		factory.addDecrement();
		factory.addRecall();
		factory.addMoveLeft();
		factory.addIncrement();
		factory.addRecall();
		factory.addMoveRight();
		factory.addMoveRight();
		factory.addMoveRight();
		factory.addMoveRight();
		factory.addMoveRight();
		factory.addRecall();
		factory.addMoveRight();
		factory.addRecall();
		factory.addMoveLeft();
		factory.addMoveLeft();
		factory.addRecall();
		factory.addMoveLeft();
		factory.addDecrement();
		factory.addRecall();
		factory.endFunction();
		
		Program program = factory.create();
		program.execute();
	}
	
}
