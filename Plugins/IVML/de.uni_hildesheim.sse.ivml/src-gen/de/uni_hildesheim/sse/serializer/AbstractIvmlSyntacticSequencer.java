package de.uni_hildesheim.sse.serializer;

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

import com.google.inject.Inject;

import de.uni_hildesheim.sse.services.IvmlGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractIvmlSyntacticSequencer extends AbstractSyntacticSequencer {

	protected IvmlGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AttrAssignment_SemicolonKeyword_9_q;
	protected AbstractElementAlias match_Eval_SemicolonKeyword_5_q;
	protected AbstractElementAlias match_Freeze_SemicolonKeyword_5_q;
	protected AbstractElementAlias match_InterfaceDeclaration_SemicolonKeyword_5_q;
	protected AbstractElementAlias match_Project_SemicolonKeyword_9_q;
	protected AbstractElementAlias match_TypedefCompound_SemicolonKeyword_6_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (IvmlGrammarAccess) access;
		match_AttrAssignment_SemicolonKeyword_9_q = new TokenAlias(false, true, grammarAccess.getAttrAssignmentAccess().getSemicolonKeyword_9());
		match_Eval_SemicolonKeyword_5_q = new TokenAlias(false, true, grammarAccess.getEvalAccess().getSemicolonKeyword_5());
		match_Freeze_SemicolonKeyword_5_q = new TokenAlias(false, true, grammarAccess.getFreezeAccess().getSemicolonKeyword_5());
		match_InterfaceDeclaration_SemicolonKeyword_5_q = new TokenAlias(false, true, grammarAccess.getInterfaceDeclarationAccess().getSemicolonKeyword_5());
		match_Project_SemicolonKeyword_9_q = new TokenAlias(false, true, grammarAccess.getProjectAccess().getSemicolonKeyword_9());
		match_TypedefCompound_SemicolonKeyword_6_q = new TokenAlias(false, true, grammarAccess.getTypedefCompoundAccess().getSemicolonKeyword_6());
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
			if(match_AttrAssignment_SemicolonKeyword_9_q.equals(syntax))
				emit_AttrAssignment_SemicolonKeyword_9_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Eval_SemicolonKeyword_5_q.equals(syntax))
				emit_Eval_SemicolonKeyword_5_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Freeze_SemicolonKeyword_5_q.equals(syntax))
				emit_Freeze_SemicolonKeyword_5_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_InterfaceDeclaration_SemicolonKeyword_5_q.equals(syntax))
				emit_InterfaceDeclaration_SemicolonKeyword_5_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Project_SemicolonKeyword_9_q.equals(syntax))
				emit_Project_SemicolonKeyword_9_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TypedefCompound_SemicolonKeyword_6_q.equals(syntax))
				emit_TypedefCompound_SemicolonKeyword_6_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_AttrAssignment_SemicolonKeyword_9_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_Eval_SemicolonKeyword_5_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_Freeze_SemicolonKeyword_5_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_InterfaceDeclaration_SemicolonKeyword_5_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_Project_SemicolonKeyword_9_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_TypedefCompound_SemicolonKeyword_6_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
