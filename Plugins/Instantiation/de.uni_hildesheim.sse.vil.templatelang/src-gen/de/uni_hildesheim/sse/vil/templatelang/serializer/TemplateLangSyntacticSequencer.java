package de.uni_hildesheim.sse.vil.templatelang.serializer;

import com.google.inject.Inject;
import de.uni_hildesheim.sse.vil.templatelang.services.TemplateLangGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class TemplateLangSyntacticSequencer extends AbstractSyntacticSequencer {

	protected TemplateLangGrammarAccess grammarAccess;
	protected AbstractElementAlias match_VilDef_SemicolonKeyword_7_q;
	protected AbstractElementAlias match_userMultiselect_SemicolonKeyword_4_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (TemplateLangGrammarAccess) access;
		match_VilDef_SemicolonKeyword_7_q = new TokenAlias(false, true, grammarAccess.getVilDefAccess().getSemicolonKeyword_7());
		match_userMultiselect_SemicolonKeyword_4_q = new TokenAlias(false, true, grammarAccess.getUserMultiselectAccess().getSemicolonKeyword_4());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_VilDef_SemicolonKeyword_7_q.equals(syntax))
				emit_VilDef_SemicolonKeyword_7_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_userMultiselect_SemicolonKeyword_4_q.equals(syntax))
				emit_userMultiselect_SemicolonKeyword_4_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_VilDef_SemicolonKeyword_7_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_userMultiselect_SemicolonKeyword_4_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
