/*
 * generated by Xtext 2.16.0
 */
package com.benjholla.elemental.generator

import com.benjholla.elemental.elemental.Assignment
import com.benjholla.elemental.elemental.Branch
import com.benjholla.elemental.elemental.ComputedGOTO
import com.benjholla.elemental.elemental.Decrement
import com.benjholla.elemental.elemental.DynamicDispatch
import com.benjholla.elemental.elemental.GOTO
import com.benjholla.elemental.elemental.Increment
import com.benjholla.elemental.elemental.Instruction
import com.benjholla.elemental.elemental.Loop
import com.benjholla.elemental.elemental.Model
import com.benjholla.elemental.elemental.MoveLeft
import com.benjholla.elemental.elemental.MoveRight
import com.benjholla.elemental.elemental.Recall
import com.benjholla.elemental.elemental.StaticDispatch
import com.benjholla.elemental.elemental.Store
import java.io.File
import java.net.URI
import org.eclipse.core.filesystem.EFS
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.emf.common.util.EList

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class ElementalGenerator extends AbstractGenerator {

	val EXTENSION = ".e";

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (Model model : resource.allContents.toIterable.filter(Model)) {
			if (model.eResource.URI.isPlatform) {
			  val relativePath = model.eResource.URI.toPlatformString(true);
			  val platformRoot = ResourcesPlugin.getWorkspace().getRoot();
			  val iFile = platformRoot.getFile(new Path(relativePath));
			  val projectRoot = iFile.getProject().getFolder("/src").getLocation().toFile();
			  val modelFile = getFile(iFile);
			  val name = modelFile.getName().substring(0,modelFile.getName().length()-EXTENSION.length());
			  val namespaceDirectoryPath = modelFile.getParentFile().getAbsolutePath();
			  var namespace = namespaceDirectoryPath.substring(projectRoot.getAbsolutePath().length()).replace(File.separator, ".");
			  if(namespace.startsWith(".")){
			  	namespace = namespace.substring(1);
			  }
			  fsa.generateFile(name + ".java", compile(namespace, name, model));
			} else {
			  throw new RuntimeException("Unsupported platform!")
			}
		}
	}
	
	def String compile(String namespace, String name, Model model) {
		var pkg = "";
		if(!namespace.isEmpty()){
			pkg = "package " + namespace + ";\n\n";
		}
		return  pkg + '''
		import com.benjholla.elemental.runtime.Program;
		import com.benjholla.elemental.runtime.Function;
		import com.benjholla.elemental.runtime.Instruction;
		import com.benjholla.elemental.runtime.Instruction.*;
		
		
		public class �name� {
			public static void main(String[] args){
				
				Program program = new Program(System.in, System.out);
				
				�IF model.implicitFunction !== null�
				program.addFunction(new Function(program, (byte) 0x00, buildFunction0()));
		        �ENDIF�
		        �FOR function : model.explicitFunctions�
		        program.addFunction(new Function(program, (byte) 0x�Integer.toHexString(Integer.parseInt(function.name))�, buildFunction�Integer.parseInt(function.name)�()));
		        �ENDFOR�
				
				program.execute();
			}
			
			
			�IF model.implicitFunction !== null�
			private static void buildFunction0(){
				Function function = new Function(program, (byte) 0x00);
				�FOR instruction : model.implicitFunction.instructions�
				function.addInstruction(�compileInstruction(instruction)�);
				�ENDFOR�
				return function;
			}
	        �ENDIF�
	        �FOR function : model.explicitFunctions�
			private static void buildFunction�Integer.parseInt(function.name)�(){
				Function function = new Function(program, (byte) 0x�Integer.toHexString(Integer.parseInt(function.name))�);
				�FOR instruction : function.body.instructions�
				function.addInstruction(�compileInstruction(instruction)�);
				�ENDFOR�
				return function;
			}
	        �ENDFOR�
		}
		''';
	}
	
	def String compileInstruction(Instruction instruction) {
		if(instruction instanceof Increment){
			return "new Increment(function)";
		} else {
			return "null";
		}
	}
	
	final static String INDENTATION_WHITESPACE = "   ";
	
	def String getIndentation(int level){
		var whitespace = "";
		for(var i=0; i<level; i++){
			whitespace += INDENTATION_WHITESPACE;
		}
		return whitespace;
	}
	
	/**
	 * Converts an IFile to a Java File
	 * 
	 * @param file
	 * @return
	 * @throws CoreException 
	 */
	def private static File getFile(IFile iFile) throws CoreException {
	  var uri = null as URI; 
	
	  // get the file uri, account for symbolic links
	  if(!iFile.isLinked()){
	    uri = iFile.getLocationURI();
	  } else {
	    uri = iFile.getRawLocationURI();
	  }
	
	  // get the native file using Eclipse File System
	  var file = null as File;
	  if(uri !== null){
	    file = EFS.getStore(uri).toLocalFile(0, new NullProgressMonitor());
	  } else {
	    // Eclipse is weird...this last resort should work
	    file = new File(iFile.getFullPath().toOSString());
	  }
	  
	  return file;
	}
}
