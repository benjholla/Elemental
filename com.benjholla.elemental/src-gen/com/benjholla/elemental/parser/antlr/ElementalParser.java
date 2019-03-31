/*
 * generated by Xtext 2.16.0
 */
package com.benjholla.elemental.parser.antlr;

import com.benjholla.elemental.parser.antlr.internal.InternalElementalParser;
import com.benjholla.elemental.services.ElementalGrammarAccess;
import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class ElementalParser extends AbstractAntlrParser {

	@Inject
	private ElementalGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WHITESPACE", "RULE_COMMENT");
	}
	

	@Override
	protected InternalElementalParser createParser(XtextTokenStream stream) {
		return new InternalElementalParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Program";
	}

	public ElementalGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ElementalGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
