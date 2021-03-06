/*
 * generated by Xtext
 */
package de.uni_hildesheim.sse.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import de.uni_hildesheim.sse.services.IvmlGrammarAccess;

public class IvmlParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private IvmlGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected de.uni_hildesheim.sse.parser.antlr.internal.InternalIvmlParser createParser(XtextTokenStream stream) {
		return new de.uni_hildesheim.sse.parser.antlr.internal.InternalIvmlParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "VariabilityUnit";
	}
	
	public IvmlGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(IvmlGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
