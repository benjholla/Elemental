import com.benjholla.elemental.runtime.ProgramFactory;
import com.benjholla.elemental.runtime.Program;


public class Test {
	public static void main(String[] args){
		
		ProgramFactory factory = new ProgramFactory(System.in, System.out);
		
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
	}
	
}
