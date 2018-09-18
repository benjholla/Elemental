// Generated from Elemental.g4 by ANTLR 4.7.1

	package com.benjholla.elemental.parser; 
	
	import com.benjholla.elemental.parser.support.*;
	import com.benjholla.elemental.ast.*;
	import java.util.List;
	import java.io.File;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ElementalLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, ID=12, TAPE_INCREMENT=13, TAPE_DECREMENT=14, TAPE_LEFT=15, 
		TAPE_RIGHT=16, INPUT=17, OUTPUT=18, ONE_LINE_COMMENT=19, WHITESPACE=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "ID", "TAPE_INCREMENT", "TAPE_DECREMENT", "TAPE_LEFT", 
		"TAPE_RIGHT", "INPUT", "OUTPUT", "ONE_LINE_COMMENT", "WHITESPACE"
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


		private File file;
		
		public void setFile(File file){
			this.file = file;
		}
		
		public File getFile(){
			return file;
		}


	public ElementalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Elemental.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26b\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\6\rC\n\r\r\r\16"+
		"\rD\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\7\24U\n\24\f\24\16\24X\13\24\3\24\5\24[\n\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26\3\2\4\3\2\62;\3\2\f\f\2d\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5-\3\2\2\2\7/\3\2\2\2"+
		"\t\61\3\2\2\2\13\63\3\2\2\2\r\65\3\2\2\2\17\67\3\2\2\2\219\3\2\2\2\23"+
		";\3\2\2\2\25=\3\2\2\2\27?\3\2\2\2\31B\3\2\2\2\33F\3\2\2\2\35H\3\2\2\2"+
		"\37J\3\2\2\2!L\3\2\2\2#N\3\2\2\2%P\3\2\2\2\'R\3\2\2\2)^\3\2\2\2+,\7<\2"+
		"\2,\4\3\2\2\2-.\7(\2\2.\6\3\2\2\2/\60\7A\2\2\60\b\3\2\2\2\61\62\7)\2\2"+
		"\62\n\3\2\2\2\63\64\7$\2\2\64\f\3\2\2\2\65\66\7}\2\2\66\16\3\2\2\2\67"+
		"8\7\177\2\28\20\3\2\2\29:\7]\2\2:\22\3\2\2\2;<\7_\2\2<\24\3\2\2\2=>\7"+
		"*\2\2>\26\3\2\2\2?@\7+\2\2@\30\3\2\2\2AC\t\2\2\2BA\3\2\2\2CD\3\2\2\2D"+
		"B\3\2\2\2DE\3\2\2\2E\32\3\2\2\2FG\7-\2\2G\34\3\2\2\2HI\7/\2\2I\36\3\2"+
		"\2\2JK\7>\2\2K \3\2\2\2LM\7@\2\2M\"\3\2\2\2NO\7.\2\2O$\3\2\2\2PQ\7\60"+
		"\2\2Q&\3\2\2\2RV\7%\2\2SU\n\3\2\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2"+
		"\2\2WZ\3\2\2\2XV\3\2\2\2Y[\7\f\2\2ZY\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\b"+
		"\24\2\2](\3\2\2\2^_\13\2\2\2_`\3\2\2\2`a\b\25\2\2a*\3\2\2\2\6\2DVZ\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}