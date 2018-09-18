package com.benjholla.elemental.regression;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.benjholla.elemental.ast.Program;
import com.benjholla.elemental.parser.ElementalLexer;
import com.benjholla.elemental.parser.ElementalParser;

public class Test {

	public static void main(String[] args) throws Exception {	
		String code = "0:[+](+)-\"1\"{0}'1'";
		InputStream is = new ByteArrayInputStream(code.getBytes());
		CharStream codeInputStream = CharStreams.fromStream(is);
		ElementalLexer lexer = new ElementalLexer(codeInputStream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ElementalParser parser = new ElementalParser(tokens);
		parser.setFile(new File("dummy.e"));
//		System.out.println(parser.program().toStringTree(parser)); // print LISP-style tree
		Program ast = parser.program().prog;
		System.out.println(ast.toString());
	}
	
}
