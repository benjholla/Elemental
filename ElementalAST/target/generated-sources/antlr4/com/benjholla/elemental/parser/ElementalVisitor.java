// Generated from Elemental.g4 by ANTLR 4.7.1

	package com.benjholla.elemental.parser; 
	
	import com.benjholla.elemental.parser.support.*;
	import com.benjholla.elemental.ast.*;
	import java.util.List;
	import java.io.File;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ElementalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ElementalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ElementalParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ElementalParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ElementalParser#function_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_list(ElementalParser.Function_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ElementalParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(ElementalParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ElementalParser#instruction_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction_list(ElementalParser.Instruction_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ElementalParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(ElementalParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ElementalParser#computed_goto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComputed_goto(ElementalParser.Computed_gotoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ElementalParser#function_pointer_callsite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_pointer_callsite(ElementalParser.Function_pointer_callsiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link ElementalParser#go2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGo2(ElementalParser.Go2Context ctx);
	/**
	 * Visit a parse tree produced by {@link ElementalParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(ElementalParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link ElementalParser#callsite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallsite(ElementalParser.CallsiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link ElementalParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(ElementalParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ElementalParser#branch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranch(ElementalParser.BranchContext ctx);
}