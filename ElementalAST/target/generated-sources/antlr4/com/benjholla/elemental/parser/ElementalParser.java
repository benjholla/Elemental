// Generated from Elemental.g4 by ANTLR 4.7.1

	package com.benjholla.elemental.parser; 
	
	import com.benjholla.elemental.parser.support.*;
	import com.benjholla.elemental.ast.*;
	import java.util.List;
	import java.io.File;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ElementalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, ID=12, TAPE_INCREMENT=13, TAPE_DECREMENT=14, TAPE_LEFT=15, 
		TAPE_RIGHT=16, INPUT=17, OUTPUT=18, ONE_LINE_COMMENT=19, WHITESPACE=20;
	public static final int
		RULE_program = 0, RULE_function_list = 1, RULE_function = 2, RULE_instruction_list = 3, 
		RULE_instruction = 4, RULE_computed_goto = 5, RULE_function_pointer_callsite = 6, 
		RULE_go2 = 7, RULE_label = 8, RULE_callsite = 9, RULE_loop = 10, RULE_branch = 11;
	public static final String[] ruleNames = {
		"program", "function_list", "function", "instruction_list", "instruction", 
		"computed_goto", "function_pointer_callsite", "go2", "label", "callsite", 
		"loop", "branch"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "'&'", "'?'", "'''", "'\"'", "'{'", "'}'", "'['", "']'", 
		"'('", "')'", null, "'+'", "'-'", "'<'", "'>'", "','", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"ID", "TAPE_INCREMENT", "TAPE_DECREMENT", "TAPE_LEFT", "TAPE_RIGHT", "INPUT", 
		"OUTPUT", "ONE_LINE_COMMENT", "WHITESPACE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Elemental.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		private File file;
		
		public void setFile(File file){
			this.file = file;
		}
		
		public File getFile(){
			return file;
		}

	public ElementalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public Program prog;
		public Function_listContext functions;
		public Token eof;
		public Function_listContext function_list() {
			return getRuleContext(Function_listContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ElementalParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ElementalVisitor ) return ((ElementalVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			((ProgramContext)_localctx).functions = function_list();
			setState(25);
			((ProgramContext)_localctx).eof = match(EOF);

			   	  ParserSourceCorrespondence sc;
			   	  if(((ProgramContext)_localctx).functions.list.isEmpty()){
			   	     sc = new ParserSourceCorrespondence(file, 0, 0, 0, 0);
			   	  } else {
			   	     ParserSourceCorrespondence firstFunctionSC = ((ProgramContext)_localctx).functions.list.get(0).getParserSourceCorrespondence();
			   	     sc = new ParserSourceCorrespondence(file, firstFunctionSC.getOffset(), ((int) ((ProgramContext)_localctx).eof.getStartIndex()- (int) firstFunctionSC.getOffset()), firstFunctionSC.getStartLine(), ((ProgramContext)_localctx).eof.getLine()); 
			   	  }
			      ((ProgramContext)_localctx).prog =  new Program(sc, ((ProgramContext)_localctx).functions.list);
			   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_listContext extends ParserRuleContext {
		public ArrayList<Function> list;
		public FunctionContext f;
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public Function_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).enterFunction_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).exitFunction_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ElementalVisitor ) return ((ElementalVisitor<? extends T>)visitor).visitFunction_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_listContext function_list() throws RecognitionException {
		Function_listContext _localctx = new Function_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function_list);

		      ((Function_listContext)_localctx).list =  new ArrayList<Function>();
		   
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(28);
				((Function_listContext)_localctx).f = function();
				_localctx.list.add(((Function_listContext)_localctx).f.value);
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public Function value;
		public Token id;
		public Instruction_listContext instructions;
		public TerminalNode ID() { return getToken(ElementalParser.ID, 0); }
		public Instruction_listContext instruction_list() {
			return getRuleContext(Instruction_listContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ElementalVisitor ) return ((ElementalVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			((FunctionContext)_localctx).id = match(ID);
			setState(37);
			match(T__0);
			setState(38);
			((FunctionContext)_localctx).instructions = instruction_list();

			      ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, ((FunctionContext)_localctx).id.getStartIndex(), ((FunctionContext)_localctx).id.getText().length()+1, ((FunctionContext)_localctx).id.getLine(), ((FunctionContext)_localctx).id.getLine());
			      ((FunctionContext)_localctx).value =  new Function(sc, ((FunctionContext)_localctx).id.getText(), ((FunctionContext)_localctx).instructions.list);
			   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Instruction_listContext extends ParserRuleContext {
		public ArrayList<Instruction> list;
		public InstructionContext c;
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public Instruction_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).enterInstruction_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).exitInstruction_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ElementalVisitor ) return ((ElementalVisitor<? extends T>)visitor).visitInstruction_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Instruction_listContext instruction_list() throws RecognitionException {
		Instruction_listContext _localctx = new Instruction_listContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruction_list);

		      ((Instruction_listContext)_localctx).list =  new ArrayList<Instruction>();
		   
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__9) | (1L << TAPE_INCREMENT) | (1L << TAPE_DECREMENT) | (1L << TAPE_LEFT) | (1L << TAPE_RIGHT) | (1L << INPUT) | (1L << OUTPUT))) != 0)) {
				{
				{
				setState(41);
				((Instruction_listContext)_localctx).c = instruction();
				_localctx.list.add(((Instruction_listContext)_localctx).c.value);
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public Instruction value;
		public Go2Context g;
		public LabelContext lbl;
		public CallsiteContext c;
		public Computed_gotoContext cgo2;
		public Function_pointer_callsiteContext fpc;
		public LoopContext l;
		public BranchContext b;
		public Token tape_increment;
		public Token tape_decrement;
		public Token tape_left;
		public Token tape_right;
		public Token input;
		public Token output;
		public Go2Context go2() {
			return getRuleContext(Go2Context.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public CallsiteContext callsite() {
			return getRuleContext(CallsiteContext.class,0);
		}
		public Computed_gotoContext computed_goto() {
			return getRuleContext(Computed_gotoContext.class,0);
		}
		public Function_pointer_callsiteContext function_pointer_callsite() {
			return getRuleContext(Function_pointer_callsiteContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public BranchContext branch() {
			return getRuleContext(BranchContext.class,0);
		}
		public TerminalNode TAPE_INCREMENT() { return getToken(ElementalParser.TAPE_INCREMENT, 0); }
		public TerminalNode TAPE_DECREMENT() { return getToken(ElementalParser.TAPE_DECREMENT, 0); }
		public TerminalNode TAPE_LEFT() { return getToken(ElementalParser.TAPE_LEFT, 0); }
		public TerminalNode TAPE_RIGHT() { return getToken(ElementalParser.TAPE_RIGHT, 0); }
		public TerminalNode INPUT() { return getToken(ElementalParser.INPUT, 0); }
		public TerminalNode OUTPUT() { return getToken(ElementalParser.OUTPUT, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ElementalVisitor ) return ((ElementalVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_instruction);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				((InstructionContext)_localctx).g = go2();

				   	 ((InstructionContext)_localctx).value =  ((InstructionContext)_localctx).g.value;
				   
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				((InstructionContext)_localctx).lbl = label();

				   	 ((InstructionContext)_localctx).value =  ((InstructionContext)_localctx).lbl.value;
				   
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				((InstructionContext)_localctx).c = callsite();

				      ((InstructionContext)_localctx).value =  ((InstructionContext)_localctx).c.value;
				   
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 4);
				{
				setState(58);
				((InstructionContext)_localctx).cgo2 = computed_goto();

				      ((InstructionContext)_localctx).value =  ((InstructionContext)_localctx).cgo2.value;
				   
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 5);
				{
				setState(61);
				((InstructionContext)_localctx).fpc = function_pointer_callsite();

				      ((InstructionContext)_localctx).value =  ((InstructionContext)_localctx).fpc.value;
				   
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 6);
				{
				setState(64);
				((InstructionContext)_localctx).l = loop();

				      ((InstructionContext)_localctx).value =  ((InstructionContext)_localctx).l.value;
				   
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 7);
				{
				setState(67);
				((InstructionContext)_localctx).b = branch();

				      ((InstructionContext)_localctx).value =  ((InstructionContext)_localctx).b.value;
				   
				}
				break;
			case TAPE_INCREMENT:
				enterOuterAlt(_localctx, 8);
				{
				setState(70);
				((InstructionContext)_localctx).tape_increment = match(TAPE_INCREMENT);

				      ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, ((InstructionContext)_localctx).tape_increment.getStartIndex(), ((InstructionContext)_localctx).tape_increment.getText().length(), ((InstructionContext)_localctx).tape_increment.getLine(), ((InstructionContext)_localctx).tape_increment.getLine());
				      ((InstructionContext)_localctx).value =  new IncrementInstruction(sc);
				   
				}
				break;
			case TAPE_DECREMENT:
				enterOuterAlt(_localctx, 9);
				{
				setState(72);
				((InstructionContext)_localctx).tape_decrement = match(TAPE_DECREMENT);

				      ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, ((InstructionContext)_localctx).tape_decrement.getStartIndex(), ((InstructionContext)_localctx).tape_decrement.getText().length(), ((InstructionContext)_localctx).tape_decrement.getLine(), ((InstructionContext)_localctx).tape_decrement.getLine());
				      ((InstructionContext)_localctx).value =  new DecrementInstruction(sc);
				   
				}
				break;
			case TAPE_LEFT:
				enterOuterAlt(_localctx, 10);
				{
				setState(74);
				((InstructionContext)_localctx).tape_left = match(TAPE_LEFT);

				      ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, ((InstructionContext)_localctx).tape_left.getStartIndex(), ((InstructionContext)_localctx).tape_left.getText().length(), ((InstructionContext)_localctx).tape_left.getLine(), ((InstructionContext)_localctx).tape_left.getLine());
				      ((InstructionContext)_localctx).value =  new MoveLeftInstruction(sc);
				   
				}
				break;
			case TAPE_RIGHT:
				enterOuterAlt(_localctx, 11);
				{
				setState(76);
				((InstructionContext)_localctx).tape_right = match(TAPE_RIGHT);

				      ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, ((InstructionContext)_localctx).tape_right.getStartIndex(), ((InstructionContext)_localctx).tape_right.getText().length(), ((InstructionContext)_localctx).tape_right.getLine(), ((InstructionContext)_localctx).tape_right.getLine());
				      ((InstructionContext)_localctx).value =  new MoveRightInstruction(sc);
				   
				}
				break;
			case INPUT:
				enterOuterAlt(_localctx, 12);
				{
				setState(78);
				((InstructionContext)_localctx).input = match(INPUT);

				      ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, ((InstructionContext)_localctx).input.getStartIndex(), ((InstructionContext)_localctx).input.getText().length(), ((InstructionContext)_localctx).input.getLine(), ((InstructionContext)_localctx).input.getLine());
				      ((InstructionContext)_localctx).value =  new ReadInputInstruction(sc);
				   
				}
				break;
			case OUTPUT:
				enterOuterAlt(_localctx, 13);
				{
				setState(80);
				((InstructionContext)_localctx).output = match(OUTPUT);

				      ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, ((InstructionContext)_localctx).output.getStartIndex(), ((InstructionContext)_localctx).output.getText().length(), ((InstructionContext)_localctx).output.getLine(), ((InstructionContext)_localctx).output.getLine());
				      ((InstructionContext)_localctx).value =  new WriteOutputInstruction(sc);
				   
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Computed_gotoContext extends ParserRuleContext {
		public ComputedGOTOInstruction value;
		public Token address;
		public Computed_gotoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_computed_goto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).enterComputed_goto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).exitComputed_goto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ElementalVisitor ) return ((ElementalVisitor<? extends T>)visitor).visitComputed_goto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Computed_gotoContext computed_goto() throws RecognitionException {
		Computed_gotoContext _localctx = new Computed_gotoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_computed_goto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			((Computed_gotoContext)_localctx).address = match(T__1);

			   	  ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, ((Computed_gotoContext)_localctx).address.getStartIndex(), ((Computed_gotoContext)_localctx).address.getText().length(), ((Computed_gotoContext)_localctx).address.getLine(), ((Computed_gotoContext)_localctx).address.getLine());
			      ((Computed_gotoContext)_localctx).value =  new ComputedGOTOInstruction(sc);
			   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_pointer_callsiteContext extends ParserRuleContext {
		public FunctionPointerCallsiteInstruction value;
		public Token func_address;
		public Function_pointer_callsiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_pointer_callsite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).enterFunction_pointer_callsite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).exitFunction_pointer_callsite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ElementalVisitor ) return ((ElementalVisitor<? extends T>)visitor).visitFunction_pointer_callsite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_pointer_callsiteContext function_pointer_callsite() throws RecognitionException {
		Function_pointer_callsiteContext _localctx = new Function_pointer_callsiteContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function_pointer_callsite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			((Function_pointer_callsiteContext)_localctx).func_address = match(T__2);

			   	  ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, ((Function_pointer_callsiteContext)_localctx).func_address.getStartIndex(), ((Function_pointer_callsiteContext)_localctx).func_address.getText().length(), ((Function_pointer_callsiteContext)_localctx).func_address.getLine(), ((Function_pointer_callsiteContext)_localctx).func_address.getLine());
			      ((Function_pointer_callsiteContext)_localctx).value =  new FunctionPointerCallsiteInstruction(sc);
			   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Go2Context extends ParserRuleContext {
		public GOTOInstruction value;
		public Token lquote;
		public Token id;
		public Token rquote;
		public TerminalNode ID() { return getToken(ElementalParser.ID, 0); }
		public Go2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_go2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).enterGo2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).exitGo2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ElementalVisitor ) return ((ElementalVisitor<? extends T>)visitor).visitGo2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Go2Context go2() throws RecognitionException {
		Go2Context _localctx = new Go2Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_go2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			((Go2Context)_localctx).lquote = match(T__3);
			setState(91);
			((Go2Context)_localctx).id = match(ID);
			setState(92);
			((Go2Context)_localctx).rquote = match(T__3);

			   	  int length = (((Go2Context)_localctx).rquote.getStartIndex() - ((Go2Context)_localctx).lquote.getStartIndex()) + 1;
			   	  ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, ((Go2Context)_localctx).lquote.getStartIndex(), length, ((Go2Context)_localctx).lquote.getLine(), ((Go2Context)_localctx).rquote.getLine());
			      ((Go2Context)_localctx).value =  new GOTOInstruction(sc, ((Go2Context)_localctx).id.getText());
			   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContext extends ParserRuleContext {
		public LabelInstruction value;
		public Token lquote;
		public Token id;
		public Token rquote;
		public TerminalNode ID() { return getToken(ElementalParser.ID, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).exitLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ElementalVisitor ) return ((ElementalVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			((LabelContext)_localctx).lquote = match(T__4);
			setState(96);
			((LabelContext)_localctx).id = match(ID);
			setState(97);
			((LabelContext)_localctx).rquote = match(T__4);

			   	  int length = (((LabelContext)_localctx).rquote.getStartIndex() - ((LabelContext)_localctx).lquote.getStartIndex()) + 1;
			   	  ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, ((LabelContext)_localctx).lquote.getStartIndex(), length, ((LabelContext)_localctx).lquote.getLine(), ((LabelContext)_localctx).rquote.getLine());
			      ((LabelContext)_localctx).value =  new LabelInstruction(sc, ((LabelContext)_localctx).id.getText());
			   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallsiteContext extends ParserRuleContext {
		public CallsiteInstruction value;
		public Token lbracket;
		public Token id;
		public Token rbracket;
		public TerminalNode ID() { return getToken(ElementalParser.ID, 0); }
		public CallsiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callsite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).enterCallsite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).exitCallsite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ElementalVisitor ) return ((ElementalVisitor<? extends T>)visitor).visitCallsite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallsiteContext callsite() throws RecognitionException {
		CallsiteContext _localctx = new CallsiteContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_callsite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			((CallsiteContext)_localctx).lbracket = match(T__5);
			setState(101);
			((CallsiteContext)_localctx).id = match(ID);
			setState(102);
			((CallsiteContext)_localctx).rbracket = match(T__6);

			   	  int length = (((CallsiteContext)_localctx).rbracket.getStartIndex() - ((CallsiteContext)_localctx).lbracket.getStartIndex()) + 1;
			   	  ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, ((CallsiteContext)_localctx).lbracket.getStartIndex(), length, ((CallsiteContext)_localctx).lbracket.getLine(), ((CallsiteContext)_localctx).rbracket.getLine());
			      ((CallsiteContext)_localctx).value =  new CallsiteInstruction(sc, ((CallsiteContext)_localctx).id.getText());
			   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopContext extends ParserRuleContext {
		public LoopInstruction value;
		public Token lbrace;
		public Instruction_listContext instructions;
		public Token rbrace;
		public Instruction_listContext instruction_list() {
			return getRuleContext(Instruction_listContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).exitLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ElementalVisitor ) return ((ElementalVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			((LoopContext)_localctx).lbrace = match(T__7);
			setState(106);
			((LoopContext)_localctx).instructions = instruction_list();
			setState(107);
			((LoopContext)_localctx).rbrace = match(T__8);

			   	  int length = (((LoopContext)_localctx).rbrace.getStartIndex() - ((LoopContext)_localctx).lbrace.getStartIndex()) + 1;
			   	  ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, ((LoopContext)_localctx).lbrace.getStartIndex(), length, ((LoopContext)_localctx).lbrace.getLine(), ((LoopContext)_localctx).rbrace.getLine());
			      ((LoopContext)_localctx).value =  new LoopInstruction(sc, ((LoopContext)_localctx).instructions.list);
			   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BranchContext extends ParserRuleContext {
		public BranchInstruction value;
		public Token lparen;
		public Instruction_listContext instructions;
		public Token rparen;
		public Instruction_listContext instruction_list() {
			return getRuleContext(Instruction_listContext.class,0);
		}
		public BranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).enterBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ElementalListener ) ((ElementalListener)listener).exitBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ElementalVisitor ) return ((ElementalVisitor<? extends T>)visitor).visitBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchContext branch() throws RecognitionException {
		BranchContext _localctx = new BranchContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_branch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			((BranchContext)_localctx).lparen = match(T__9);
			setState(111);
			((BranchContext)_localctx).instructions = instruction_list();
			setState(112);
			((BranchContext)_localctx).rparen = match(T__10);

			   	  int length = (((BranchContext)_localctx).rparen.getStartIndex() - ((BranchContext)_localctx).lparen.getStartIndex()) + 1;
			   	  ParserSourceCorrespondence sc = new ParserSourceCorrespondence(file, ((BranchContext)_localctx).lparen.getStartIndex(), length, ((BranchContext)_localctx).lparen.getLine(), ((BranchContext)_localctx).rparen.getLine());
			      ((BranchContext)_localctx).value =  new BranchInstruction(sc, ((BranchContext)_localctx).instructions.list);
			   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26v\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3\"\n\3\f\3\16\3%\13\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5/\n\5\f\5\16\5\62\13\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6U\n\6\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\2\2\16\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\2\2\2w\2\32\3\2\2\2\4#\3\2\2\2\6&\3\2\2\2\b\60\3"+
		"\2\2\2\nT\3\2\2\2\fV\3\2\2\2\16Y\3\2\2\2\20\\\3\2\2\2\22a\3\2\2\2\24f"+
		"\3\2\2\2\26k\3\2\2\2\30p\3\2\2\2\32\33\5\4\3\2\33\34\7\2\2\3\34\35\b\2"+
		"\1\2\35\3\3\2\2\2\36\37\5\6\4\2\37 \b\3\1\2 \"\3\2\2\2!\36\3\2\2\2\"%"+
		"\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\5\3\2\2\2%#\3\2\2\2&\'\7\16\2\2\'(\7\3\2"+
		"\2()\5\b\5\2)*\b\4\1\2*\7\3\2\2\2+,\5\n\6\2,-\b\5\1\2-/\3\2\2\2.+\3\2"+
		"\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\t\3\2\2\2\62\60\3\2\2\2"+
		"\63\64\5\20\t\2\64\65\b\6\1\2\65U\3\2\2\2\66\67\5\22\n\2\678\b\6\1\28"+
		"U\3\2\2\29:\5\24\13\2:;\b\6\1\2;U\3\2\2\2<=\5\f\7\2=>\b\6\1\2>U\3\2\2"+
		"\2?@\5\16\b\2@A\b\6\1\2AU\3\2\2\2BC\5\26\f\2CD\b\6\1\2DU\3\2\2\2EF\5\30"+
		"\r\2FG\b\6\1\2GU\3\2\2\2HI\7\17\2\2IU\b\6\1\2JK\7\20\2\2KU\b\6\1\2LM\7"+
		"\21\2\2MU\b\6\1\2NO\7\22\2\2OU\b\6\1\2PQ\7\23\2\2QU\b\6\1\2RS\7\24\2\2"+
		"SU\b\6\1\2T\63\3\2\2\2T\66\3\2\2\2T9\3\2\2\2T<\3\2\2\2T?\3\2\2\2TB\3\2"+
		"\2\2TE\3\2\2\2TH\3\2\2\2TJ\3\2\2\2TL\3\2\2\2TN\3\2\2\2TP\3\2\2\2TR\3\2"+
		"\2\2U\13\3\2\2\2VW\7\4\2\2WX\b\7\1\2X\r\3\2\2\2YZ\7\5\2\2Z[\b\b\1\2[\17"+
		"\3\2\2\2\\]\7\6\2\2]^\7\16\2\2^_\7\6\2\2_`\b\t\1\2`\21\3\2\2\2ab\7\7\2"+
		"\2bc\7\16\2\2cd\7\7\2\2de\b\n\1\2e\23\3\2\2\2fg\7\b\2\2gh\7\16\2\2hi\7"+
		"\t\2\2ij\b\13\1\2j\25\3\2\2\2kl\7\n\2\2lm\5\b\5\2mn\7\13\2\2no\b\f\1\2"+
		"o\27\3\2\2\2pq\7\f\2\2qr\5\b\5\2rs\7\r\2\2st\b\r\1\2t\31\3\2\2\2\5#\60"+
		"T";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}