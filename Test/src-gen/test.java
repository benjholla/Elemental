import com.benjholla.elemental.runtime.ProgramFactory;
import com.benjholla.elemental.runtime.Program;


public class Test {
	public static void main(String[] args){
		
		ProgramFactory factory = new ProgramFactory(System.in, System.out);
		
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
	}
	
}
