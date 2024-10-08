/*
 * generated by Xtext 2.35.0
 */
package de.uni_hildesheim.sse.serializer;

import com.google.inject.Inject;
import de.uni_hildesheim.sse.services.IvmlGrammarAccess;
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
public class IvmlSyntacticSequencer extends AbstractSyntacticSequencer {

	protected IvmlGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AttrAssignment_SemicolonKeyword_9_q;
	protected AbstractElementAlias match_Eval_SemicolonKeyword_6_q;
	protected AbstractElementAlias match_ExpressionListOrRange_CommaKeyword_2_q;
	protected AbstractElementAlias match_Freeze_SemicolonKeyword_6_q;
	protected AbstractElementAlias match_ImportStmt_ImportKeyword_0_0_q;
	protected AbstractElementAlias match_InterfaceDeclaration_SemicolonKeyword_5_q;
	protected AbstractElementAlias match_Project_SemicolonKeyword_9_q;
	protected AbstractElementAlias match_TypedefCompound_SemicolonKeyword_7_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (IvmlGrammarAccess) access;
		match_AttrAssignment_SemicolonKeyword_9_q = new TokenAlias(false, true, grammarAccess.getAttrAssignmentAccess().getSemicolonKeyword_9());
		match_Eval_SemicolonKeyword_6_q = new TokenAlias(false, true, grammarAccess.getEvalAccess().getSemicolonKeyword_6());
		match_ExpressionListOrRange_CommaKeyword_2_q = new TokenAlias(false, true, grammarAccess.getExpressionListOrRangeAccess().getCommaKeyword_2());
		match_Freeze_SemicolonKeyword_6_q = new TokenAlias(false, true, grammarAccess.getFreezeAccess().getSemicolonKeyword_6());
		match_ImportStmt_ImportKeyword_0_0_q = new TokenAlias(false, true, grammarAccess.getImportStmtAccess().getImportKeyword_0_0());
		match_InterfaceDeclaration_SemicolonKeyword_5_q = new TokenAlias(false, true, grammarAccess.getInterfaceDeclarationAccess().getSemicolonKeyword_5());
		match_Project_SemicolonKeyword_9_q = new TokenAlias(false, true, grammarAccess.getProjectAccess().getSemicolonKeyword_9());
		match_TypedefCompound_SemicolonKeyword_7_q = new TokenAlias(false, true, grammarAccess.getTypedefCompoundAccess().getSemicolonKeyword_7());
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
			if (match_AttrAssignment_SemicolonKeyword_9_q.equals(syntax))
				emit_AttrAssignment_SemicolonKeyword_9_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Eval_SemicolonKeyword_6_q.equals(syntax))
				emit_Eval_SemicolonKeyword_6_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ExpressionListOrRange_CommaKeyword_2_q.equals(syntax))
				emit_ExpressionListOrRange_CommaKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Freeze_SemicolonKeyword_6_q.equals(syntax))
				emit_Freeze_SemicolonKeyword_6_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ImportStmt_ImportKeyword_0_0_q.equals(syntax))
				emit_ImportStmt_ImportKeyword_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_InterfaceDeclaration_SemicolonKeyword_5_q.equals(syntax))
				emit_InterfaceDeclaration_SemicolonKeyword_5_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Project_SemicolonKeyword_9_q.equals(syntax))
				emit_Project_SemicolonKeyword_9_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_TypedefCompound_SemicolonKeyword_7_q.equals(syntax))
				emit_TypedefCompound_SemicolonKeyword_7_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     elements+=AttrAssignment '}' (ambiguity) (rule end)
	 *     elements+=ExpressionStatement '}' (ambiguity) (rule end)
	 *     elements+=VariableDeclaration '}' (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_AttrAssignment_SemicolonKeyword_9_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'eval' '{' '}' (ambiguity) (rule start)
	 *     nested+=Eval '}' (ambiguity) (rule end)
	 *     statements+=ExpressionStatement '}' (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_Eval_SemicolonKeyword_6_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ','?
	 *
	 * This ambiguous syntax occurs at:
	 *     list+=ExpressionListEntry (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_ExpressionListOrRange_CommaKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     ex=LogicalExpression ')' (ambiguity) (rule end)
	 *     names+=FreezeStatement ';' '}' (ambiguity) (rule end)
	 *     names+=FreezeStatement '}' (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_Freeze_SemicolonKeyword_6_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     'import'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) name=Identifier
	 
	 * </pre>
	 */
	protected void emit_ImportStmt_ImportKeyword_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     exports+=Export '}' (ambiguity) (rule end)
	 *     name=Identifier '{' '}' (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_InterfaceDeclaration_SemicolonKeyword_5_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     contents=ProjectContents '}' (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_Project_SemicolonKeyword_9_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     elements+=AttrAssignment '}' (ambiguity) (rule end)
	 *     elements+=Eval '}' (ambiguity) (rule end)
	 *     elements+=ExpressionStatement '}' (ambiguity) (rule end)
	 *     elements+=VariableDeclaration '}' (ambiguity) (rule end)
	 *     name=Identifier '{' '}' (ambiguity) (rule end)
	 *     super+=Identifier '{' '}' (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_TypedefCompound_SemicolonKeyword_7_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
