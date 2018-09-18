// Generated from Elemental.g4 by ANTLR 4.7.1

	package com.benjholla.elemental.parser; 
	
	import com.benjholla.elemental.parser.support.*;
	import com.benjholla.elemental.ast.*;
	import java.util.List;
	import java.io.File;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ElementalParser}.
 */
public interface ElementalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ElementalParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ElementalParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ElementalParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ElementalParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ElementalParser#function_list}.
	 * @param ctx the parse tree
	 */
	void enterFunction_list(ElementalParser.Function_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ElementalParser#function_list}.
	 * @param ctx the parse tree
	 */
	void exitFunction_list(ElementalParser.Function_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ElementalParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(ElementalParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ElementalParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(ElementalParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ElementalParser#instruction_list}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_list(ElementalParser.Instruction_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ElementalParser#instruction_list}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_list(ElementalParser.Instruction_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ElementalParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(ElementalParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ElementalParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(ElementalParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ElementalParser#computed_goto}.
	 * @param ctx the parse tree
	 */
	void enterComputed_goto(ElementalParser.Computed_gotoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ElementalParser#computed_goto}.
	 * @param ctx the parse tree
	 */
	void exitComputed_goto(ElementalParser.Computed_gotoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ElementalParser#function_pointer_callsite}.
	 * @param ctx the parse tree
	 */
	void enterFunction_pointer_callsite(ElementalParser.Function_pointer_callsiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ElementalParser#function_pointer_callsite}.
	 * @param ctx the parse tree
	 */
	void exitFunction_pointer_callsite(ElementalParser.Function_pointer_callsiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link ElementalParser#go2}.
	 * @param ctx the parse tree
	 */
	void enterGo2(ElementalParser.Go2Context ctx);
	/**
	 * Exit a parse tree produced by {@link ElementalParser#go2}.
	 * @param ctx the parse tree
	 */
	void exitGo2(ElementalParser.Go2Context ctx);
	/**
	 * Enter a parse tree produced by {@link ElementalParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(ElementalParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ElementalParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(ElementalParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ElementalParser#callsite}.
	 * @param ctx the parse tree
	 */
	void enterCallsite(ElementalParser.CallsiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ElementalParser#callsite}.
	 * @param ctx the parse tree
	 */
	void exitCallsite(ElementalParser.CallsiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link ElementalParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(ElementalParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ElementalParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(ElementalParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ElementalParser#branch}.
	 * @param ctx the parse tree
	 */
	void enterBranch(ElementalParser.BranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link ElementalParser#branch}.
	 * @param ctx the parse tree
	 */
	void exitBranch(ElementalParser.BranchContext ctx);
}