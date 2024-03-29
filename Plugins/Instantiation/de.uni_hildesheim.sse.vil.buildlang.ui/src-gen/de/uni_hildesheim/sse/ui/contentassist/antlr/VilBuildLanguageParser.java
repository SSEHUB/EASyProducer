/*
 * generated by Xtext
 */
package de.uni_hildesheim.sse.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import de.uni_hildesheim.sse.services.VilBuildLanguageGrammarAccess;

public class VilBuildLanguageParser extends AbstractContentAssistParser {
	
	@Inject
	private VilBuildLanguageGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.uni_hildesheim.sse.ui.contentassist.antlr.internal.InternalVilBuildLanguageParser createParser() {
		de.uni_hildesheim.sse.ui.contentassist.antlr.internal.InternalVilBuildLanguageParser result = new de.uni_hildesheim.sse.ui.contentassist.antlr.internal.InternalVilBuildLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getScriptContentsAccess().getAlternatives_1(), "rule__ScriptContents__Alternatives_1");
					put(grammarAccess.getRuleElementAccess().getAlternatives(), "rule__RuleElement__Alternatives");
					put(grammarAccess.getExpressionStatementAccess().getAlternatives(), "rule__ExpressionStatement__Alternatives");
					put(grammarAccess.getPrimaryExpressionAccess().getAlternatives(), "rule__PrimaryExpression__Alternatives");
					put(grammarAccess.getInstantiateAccess().getAlternatives_1(), "rule__Instantiate__Alternatives_1");
					put(grammarAccess.getMapAccess().getSeparatorAlternatives_4_0(), "rule__Map__SeparatorAlternatives_4_0");
					put(grammarAccess.getForAccess().getSeparatorAlternatives_4_0(), "rule__For__SeparatorAlternatives_4_0");
					put(grammarAccess.getStatementOrBlockAccess().getAlternatives(), "rule__StatementOrBlock__Alternatives");
					put(grammarAccess.getImportAccess().getAlternatives_0(), "rule__Import__Alternatives_0");
					put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
					put(grammarAccess.getLogicalOperatorAccess().getAlternatives(), "rule__LogicalOperator__Alternatives");
					put(grammarAccess.getEqualityOperatorAccess().getAlternatives(), "rule__EqualityOperator__Alternatives");
					put(grammarAccess.getRelationalOperatorAccess().getAlternatives(), "rule__RelationalOperator__Alternatives");
					put(grammarAccess.getAdditiveOperatorAccess().getAlternatives(), "rule__AdditiveOperator__Alternatives");
					put(grammarAccess.getMultiplicativeOperatorAccess().getAlternatives(), "rule__MultiplicativeOperator__Alternatives");
					put(grammarAccess.getUnaryOperatorAccess().getAlternatives(), "rule__UnaryOperator__Alternatives");
					put(grammarAccess.getExpressionOrQualifiedExecutionAccess().getAlternatives_0(), "rule__ExpressionOrQualifiedExecution__Alternatives_0");
					put(grammarAccess.getSubCallAccess().getAlternatives(), "rule__SubCall__Alternatives");
					put(grammarAccess.getSubCallAccess().getTypeAlternatives_0_0_0(), "rule__SubCall__TypeAlternatives_0_0_0");
					put(grammarAccess.getConstantAccess().getAlternatives(), "rule__Constant__Alternatives");
					put(grammarAccess.getConstantAccess().getBValueAlternatives_3_0(), "rule__Constant__BValueAlternatives_3_0");
					put(grammarAccess.getIdentifierAccess().getAlternatives(), "rule__Identifier__Alternatives");
					put(grammarAccess.getTypeAccess().getAlternatives(), "rule__Type__Alternatives");
					put(grammarAccess.getContainerInitializerExpressionAccess().getAlternatives(), "rule__ContainerInitializerExpression__Alternatives");
					put(grammarAccess.getImplementationUnitAccess().getGroup(), "rule__ImplementationUnit__Group__0");
					put(grammarAccess.getRequireAccess().getGroup(), "rule__Require__Group__0");
					put(grammarAccess.getLanguageUnitAccess().getGroup(), "rule__LanguageUnit__Group__0");
					put(grammarAccess.getScriptParentDeclAccess().getGroup(), "rule__ScriptParentDecl__Group__0");
					put(grammarAccess.getLoadPropertiesAccess().getGroup(), "rule__LoadProperties__Group__0");
					put(grammarAccess.getScriptContentsAccess().getGroup(), "rule__ScriptContents__Group__0");
					put(grammarAccess.getRuleDeclarationAccess().getGroup(), "rule__RuleDeclaration__Group__0");
					put(grammarAccess.getRuleDeclarationAccess().getGroup_1(), "rule__RuleDeclaration__Group_1__0");
					put(grammarAccess.getRuleConditionsAccess().getGroup(), "rule__RuleConditions__Group__0");
					put(grammarAccess.getRuleConditionsAccess().getGroup_3(), "rule__RuleConditions__Group_3__0");
					put(grammarAccess.getRuleConditionsAccess().getGroup_3_1(), "rule__RuleConditions__Group_3_1__0");
					put(grammarAccess.getRuleElementBlockAccess().getGroup(), "rule__RuleElementBlock__Group__0");
					put(grammarAccess.getRuleElementAccess().getGroup_2(), "rule__RuleElement__Group_2__0");
					put(grammarAccess.getRuleElementAccess().getGroup_3(), "rule__RuleElement__Group_3__0");
					put(grammarAccess.getExpressionStatementAccess().getGroup_0(), "rule__ExpressionStatement__Group_0__0");
					put(grammarAccess.getExpressionStatementAccess().getGroup_0_0(), "rule__ExpressionStatement__Group_0_0__0");
					put(grammarAccess.getExpressionStatementAccess().getGroup_0_0_1(), "rule__ExpressionStatement__Group_0_0_1__0");
					put(grammarAccess.getExpressionStatementAccess().getGroup_1(), "rule__ExpressionStatement__Group_1__0");
					put(grammarAccess.getInstantiateAccess().getGroup(), "rule__Instantiate__Group__0");
					put(grammarAccess.getLoopVariableAccess().getGroup(), "rule__LoopVariable__Group__0");
					put(grammarAccess.getMapAccess().getGroup(), "rule__Map__Group__0");
					put(grammarAccess.getMapAccess().getGroup_3(), "rule__Map__Group_3__0");
					put(grammarAccess.getForAccess().getGroup(), "rule__For__Group__0");
					put(grammarAccess.getForAccess().getGroup_3(), "rule__For__Group_3__0");
					put(grammarAccess.getWhileAccess().getGroup(), "rule__While__Group__0");
					put(grammarAccess.getAlternativeAccess().getGroup(), "rule__Alternative__Group__0");
					put(grammarAccess.getAlternativeAccess().getGroup_5(), "rule__Alternative__Group_5__0");
					put(grammarAccess.getJoinAccess().getGroup(), "rule__Join__Group__0");
					put(grammarAccess.getJoinAccess().getGroup_6(), "rule__Join__Group_6__0");
					put(grammarAccess.getJoinVariableAccess().getGroup(), "rule__JoinVariable__Group__0");
					put(grammarAccess.getSystemExecutionAccess().getGroup(), "rule__SystemExecution__Group__0");
					put(grammarAccess.getVariableDeclarationAccess().getGroup(), "rule__VariableDeclaration__Group__0");
					put(grammarAccess.getVariableDeclarationAccess().getGroup_3(), "rule__VariableDeclaration__Group_3__0");
					put(grammarAccess.getCompoundAccess().getGroup(), "rule__Compound__Group__0");
					put(grammarAccess.getCompoundAccess().getGroup_3(), "rule__Compound__Group_3__0");
					put(grammarAccess.getTypeDefAccess().getGroup(), "rule__TypeDef__Group__0");
					put(grammarAccess.getAdviceAccess().getGroup(), "rule__Advice__Group__0");
					put(grammarAccess.getVersionSpecAccess().getGroup(), "rule__VersionSpec__Group__0");
					put(grammarAccess.getParameterListAccess().getGroup(), "rule__ParameterList__Group__0");
					put(grammarAccess.getParameterListAccess().getGroup_1(), "rule__ParameterList__Group_1__0");
					put(grammarAccess.getParameterAccess().getGroup(), "rule__Parameter__Group__0");
					put(grammarAccess.getParameterAccess().getGroup_2(), "rule__Parameter__Group_2__0");
					put(grammarAccess.getVersionStmtAccess().getGroup(), "rule__VersionStmt__Group__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getLogicalExpressionAccess().getGroup(), "rule__LogicalExpression__Group__0");
					put(grammarAccess.getLogicalExpressionPartAccess().getGroup(), "rule__LogicalExpressionPart__Group__0");
					put(grammarAccess.getEqualityExpressionAccess().getGroup(), "rule__EqualityExpression__Group__0");
					put(grammarAccess.getEqualityExpressionPartAccess().getGroup(), "rule__EqualityExpressionPart__Group__0");
					put(grammarAccess.getRelationalExpressionAccess().getGroup(), "rule__RelationalExpression__Group__0");
					put(grammarAccess.getRelationalExpressionAccess().getGroup_1(), "rule__RelationalExpression__Group_1__0");
					put(grammarAccess.getRelationalExpressionPartAccess().getGroup(), "rule__RelationalExpressionPart__Group__0");
					put(grammarAccess.getAdditiveExpressionAccess().getGroup(), "rule__AdditiveExpression__Group__0");
					put(grammarAccess.getAdditiveExpressionPartAccess().getGroup(), "rule__AdditiveExpressionPart__Group__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup(), "rule__MultiplicativeExpression__Group__0");
					put(grammarAccess.getMultiplicativeExpressionPartAccess().getGroup(), "rule__MultiplicativeExpressionPart__Group__0");
					put(grammarAccess.getUnaryExpressionAccess().getGroup(), "rule__UnaryExpression__Group__0");
					put(grammarAccess.getExpressionOrQualifiedExecutionAccess().getGroup(), "rule__ExpressionOrQualifiedExecution__Group__0");
					put(grammarAccess.getExpressionOrQualifiedExecutionAccess().getGroup_0_1(), "rule__ExpressionOrQualifiedExecution__Group_0_1__0");
					put(grammarAccess.getUnqualifiedExecutionAccess().getGroup(), "rule__UnqualifiedExecution__Group__0");
					put(grammarAccess.getSuperExecutionAccess().getGroup(), "rule__SuperExecution__Group__0");
					put(grammarAccess.getConstructorExecutionAccess().getGroup(), "rule__ConstructorExecution__Group__0");
					put(grammarAccess.getSubCallAccess().getGroup_0(), "rule__SubCall__Group_0__0");
					put(grammarAccess.getSubCallAccess().getGroup_1(), "rule__SubCall__Group_1__0");
					put(grammarAccess.getDeclaratorAccess().getGroup(), "rule__Declarator__Group__0");
					put(grammarAccess.getDeclaratorAccess().getGroup_1(), "rule__Declarator__Group_1__0");
					put(grammarAccess.getDeclarationAccess().getGroup(), "rule__Declaration__Group__0");
					put(grammarAccess.getDeclarationAccess().getGroup_2(), "rule__Declaration__Group_2__0");
					put(grammarAccess.getDeclarationUnitAccess().getGroup(), "rule__DeclarationUnit__Group__0");
					put(grammarAccess.getDeclarationUnitAccess().getGroup_1(), "rule__DeclarationUnit__Group_1__0");
					put(grammarAccess.getAnnotationDeclarationsAccess().getGroup(), "rule__AnnotationDeclarations__Group__0");
					put(grammarAccess.getAnnotationDeclarationsAccess().getGroup_1(), "rule__AnnotationDeclarations__Group_1__0");
					put(grammarAccess.getCallAccess().getGroup(), "rule__Call__Group__0");
					put(grammarAccess.getArgumentListAccess().getGroup(), "rule__ArgumentList__Group__0");
					put(grammarAccess.getArgumentListAccess().getGroup_1(), "rule__ArgumentList__Group_1__0");
					put(grammarAccess.getNamedArgumentAccess().getGroup(), "rule__NamedArgument__Group__0");
					put(grammarAccess.getNamedArgumentAccess().getGroup_0(), "rule__NamedArgument__Group_0__0");
					put(grammarAccess.getQualifiedPrefixAccess().getGroup(), "rule__QualifiedPrefix__Group__0");
					put(grammarAccess.getQualifiedPrefixAccess().getGroup_1(), "rule__QualifiedPrefix__Group_1__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getTypeAccess().getGroup_1(), "rule__Type__Group_1__0");
					put(grammarAccess.getTypeAccess().getGroup_2(), "rule__Type__Group_2__0");
					put(grammarAccess.getTypeAccess().getGroup_3(), "rule__Type__Group_3__0");
					put(grammarAccess.getTypeAccess().getGroup_4(), "rule__Type__Group_4__0");
					put(grammarAccess.getTypeParametersAccess().getGroup(), "rule__TypeParameters__Group__0");
					put(grammarAccess.getTypeParametersAccess().getGroup_2(), "rule__TypeParameters__Group_2__0");
					put(grammarAccess.getContainerInitializerAccess().getGroup(), "rule__ContainerInitializer__Group__0");
					put(grammarAccess.getContainerInitializerAccess().getGroup_2(), "rule__ContainerInitializer__Group_2__0");
					put(grammarAccess.getContainerInitializerAccess().getGroup_2_1(), "rule__ContainerInitializer__Group_2_1__0");
					put(grammarAccess.getImplementationUnitAccess().getImportsAssignment_1(), "rule__ImplementationUnit__ImportsAssignment_1");
					put(grammarAccess.getImplementationUnitAccess().getRequiresAssignment_2(), "rule__ImplementationUnit__RequiresAssignment_2");
					put(grammarAccess.getImplementationUnitAccess().getScriptsAssignment_3(), "rule__ImplementationUnit__ScriptsAssignment_3");
					put(grammarAccess.getRequireAccess().getNameAssignment_1(), "rule__Require__NameAssignment_1");
					put(grammarAccess.getRequireAccess().getVersionSpecAssignment_2(), "rule__Require__VersionSpecAssignment_2");
					put(grammarAccess.getLanguageUnitAccess().getAdvicesAssignment_0(), "rule__LanguageUnit__AdvicesAssignment_0");
					put(grammarAccess.getLanguageUnitAccess().getNameAssignment_2(), "rule__LanguageUnit__NameAssignment_2");
					put(grammarAccess.getLanguageUnitAccess().getParamAssignment_4(), "rule__LanguageUnit__ParamAssignment_4");
					put(grammarAccess.getLanguageUnitAccess().getParentAssignment_6(), "rule__LanguageUnit__ParentAssignment_6");
					put(grammarAccess.getLanguageUnitAccess().getVersionAssignment_8(), "rule__LanguageUnit__VersionAssignment_8");
					put(grammarAccess.getLanguageUnitAccess().getLoadPropertiesAssignment_9(), "rule__LanguageUnit__LoadPropertiesAssignment_9");
					put(grammarAccess.getLanguageUnitAccess().getContentsAssignment_10(), "rule__LanguageUnit__ContentsAssignment_10");
					put(grammarAccess.getScriptParentDeclAccess().getNameAssignment_1(), "rule__ScriptParentDecl__NameAssignment_1");
					put(grammarAccess.getLoadPropertiesAccess().getPathAssignment_2(), "rule__LoadProperties__PathAssignment_2");
					put(grammarAccess.getScriptContentsAccess().getElementsAssignment_1_0(), "rule__ScriptContents__ElementsAssignment_1_0");
					put(grammarAccess.getScriptContentsAccess().getElementsAssignment_1_1(), "rule__ScriptContents__ElementsAssignment_1_1");
					put(grammarAccess.getScriptContentsAccess().getElementsAssignment_1_2(), "rule__ScriptContents__ElementsAssignment_1_2");
					put(grammarAccess.getScriptContentsAccess().getElementsAssignment_1_3(), "rule__ScriptContents__ElementsAssignment_1_3");
					put(grammarAccess.getRuleDeclarationAccess().getAnnotationsAssignment_1_0(), "rule__RuleDeclaration__AnnotationsAssignment_1_0");
					put(grammarAccess.getRuleDeclarationAccess().getModifierAssignment_1_1(), "rule__RuleDeclaration__ModifierAssignment_1_1");
					put(grammarAccess.getRuleDeclarationAccess().getTypeAssignment_1_2(), "rule__RuleDeclaration__TypeAssignment_1_2");
					put(grammarAccess.getRuleDeclarationAccess().getNameAssignment_1_3(), "rule__RuleDeclaration__NameAssignment_1_3");
					put(grammarAccess.getRuleDeclarationAccess().getParamListAssignment_1_5(), "rule__RuleDeclaration__ParamListAssignment_1_5");
					put(grammarAccess.getRuleDeclarationAccess().getConditionsAssignment_2(), "rule__RuleDeclaration__ConditionsAssignment_2");
					put(grammarAccess.getRuleDeclarationAccess().getBlockAssignment_3(), "rule__RuleDeclaration__BlockAssignment_3");
					put(grammarAccess.getRuleConditionsAccess().getPostconditionAssignment_1(), "rule__RuleConditions__PostconditionAssignment_1");
					put(grammarAccess.getRuleConditionsAccess().getPreconditionsAssignment_3_0(), "rule__RuleConditions__PreconditionsAssignment_3_0");
					put(grammarAccess.getRuleConditionsAccess().getPreconditionsAssignment_3_1_1(), "rule__RuleConditions__PreconditionsAssignment_3_1_1");
					put(grammarAccess.getRuleElementBlockAccess().getElementsAssignment_2(), "rule__RuleElementBlock__ElementsAssignment_2");
					put(grammarAccess.getRuleElementAccess().getVarDeclAssignment_0(), "rule__RuleElement__VarDeclAssignment_0");
					put(grammarAccess.getRuleElementAccess().getExprStmtAssignment_1(), "rule__RuleElement__ExprStmtAssignment_1");
					put(grammarAccess.getRuleElementAccess().getWhileAssignment_2_0(), "rule__RuleElement__WhileAssignment_2_0");
					put(grammarAccess.getRuleElementAccess().getForAssignment_3_0(), "rule__RuleElement__ForAssignment_3_0");
					put(grammarAccess.getRuleModifierAccess().getProtectedAssignment(), "rule__RuleModifier__ProtectedAssignment");
					put(grammarAccess.getExpressionStatementAccess().getVarAssignment_0_0_0(), "rule__ExpressionStatement__VarAssignment_0_0_0");
					put(grammarAccess.getExpressionStatementAccess().getFieldAssignment_0_0_1_1(), "rule__ExpressionStatement__FieldAssignment_0_0_1_1");
					put(grammarAccess.getExpressionStatementAccess().getExprAssignment_0_1(), "rule__ExpressionStatement__ExprAssignment_0_1");
					put(grammarAccess.getExpressionStatementAccess().getAltAssignment_1_0(), "rule__ExpressionStatement__AltAssignment_1_0");
					put(grammarAccess.getPrimaryExpressionAccess().getOtherExAssignment_0(), "rule__PrimaryExpression__OtherExAssignment_0");
					put(grammarAccess.getPrimaryExpressionAccess().getUnqExAssignment_1(), "rule__PrimaryExpression__UnqExAssignment_1");
					put(grammarAccess.getPrimaryExpressionAccess().getSuperExAssignment_2(), "rule__PrimaryExpression__SuperExAssignment_2");
					put(grammarAccess.getPrimaryExpressionAccess().getSysExAssignment_3(), "rule__PrimaryExpression__SysExAssignment_3");
					put(grammarAccess.getPrimaryExpressionAccess().getMapAssignment_4(), "rule__PrimaryExpression__MapAssignment_4");
					put(grammarAccess.getPrimaryExpressionAccess().getJoinAssignment_5(), "rule__PrimaryExpression__JoinAssignment_5");
					put(grammarAccess.getPrimaryExpressionAccess().getInstantiateAssignment_6(), "rule__PrimaryExpression__InstantiateAssignment_6");
					put(grammarAccess.getPrimaryExpressionAccess().getNewExAssignment_7(), "rule__PrimaryExpression__NewExAssignment_7");
					put(grammarAccess.getInstantiateAccess().getProjectAssignment_1_0(), "rule__Instantiate__ProjectAssignment_1_0");
					put(grammarAccess.getInstantiateAccess().getRuleNameAssignment_1_1(), "rule__Instantiate__RuleNameAssignment_1_1");
					put(grammarAccess.getInstantiateAccess().getParamAssignment_3(), "rule__Instantiate__ParamAssignment_3");
					put(grammarAccess.getInstantiateAccess().getVersionSpecAssignment_5(), "rule__Instantiate__VersionSpecAssignment_5");
					put(grammarAccess.getLoopVariableAccess().getTypeAssignment_0(), "rule__LoopVariable__TypeAssignment_0");
					put(grammarAccess.getLoopVariableAccess().getVarAssignment_1(), "rule__LoopVariable__VarAssignment_1");
					put(grammarAccess.getMapAccess().getVarAssignment_2(), "rule__Map__VarAssignment_2");
					put(grammarAccess.getMapAccess().getVarAssignment_3_1(), "rule__Map__VarAssignment_3_1");
					put(grammarAccess.getMapAccess().getSeparatorAssignment_4(), "rule__Map__SeparatorAssignment_4");
					put(grammarAccess.getMapAccess().getExprAssignment_5(), "rule__Map__ExprAssignment_5");
					put(grammarAccess.getMapAccess().getBlockAssignment_7(), "rule__Map__BlockAssignment_7");
					put(grammarAccess.getForAccess().getVarAssignment_2(), "rule__For__VarAssignment_2");
					put(grammarAccess.getForAccess().getVarAssignment_3_1(), "rule__For__VarAssignment_3_1");
					put(grammarAccess.getForAccess().getSeparatorAssignment_4(), "rule__For__SeparatorAssignment_4");
					put(grammarAccess.getForAccess().getExprAssignment_5(), "rule__For__ExprAssignment_5");
					put(grammarAccess.getForAccess().getBlockAssignment_7(), "rule__For__BlockAssignment_7");
					put(grammarAccess.getWhileAccess().getExprAssignment_2(), "rule__While__ExprAssignment_2");
					put(grammarAccess.getWhileAccess().getBlockAssignment_4(), "rule__While__BlockAssignment_4");
					put(grammarAccess.getAlternativeAccess().getExprAssignment_2(), "rule__Alternative__ExprAssignment_2");
					put(grammarAccess.getAlternativeAccess().getIfAssignment_4(), "rule__Alternative__IfAssignment_4");
					put(grammarAccess.getAlternativeAccess().getElseAssignment_5_1(), "rule__Alternative__ElseAssignment_5_1");
					put(grammarAccess.getStatementOrBlockAccess().getExStmtAssignment_0(), "rule__StatementOrBlock__ExStmtAssignment_0");
					put(grammarAccess.getStatementOrBlockAccess().getBlockAssignment_1(), "rule__StatementOrBlock__BlockAssignment_1");
					put(grammarAccess.getJoinAccess().getVar1Assignment_2(), "rule__Join__Var1Assignment_2");
					put(grammarAccess.getJoinAccess().getVar2Assignment_4(), "rule__Join__Var2Assignment_4");
					put(grammarAccess.getJoinAccess().getConditionAssignment_6_2(), "rule__Join__ConditionAssignment_6_2");
					put(grammarAccess.getJoinVariableAccess().getExclAssignment_0(), "rule__JoinVariable__ExclAssignment_0");
					put(grammarAccess.getJoinVariableAccess().getVarAssignment_1(), "rule__JoinVariable__VarAssignment_1");
					put(grammarAccess.getJoinVariableAccess().getExprAssignment_3(), "rule__JoinVariable__ExprAssignment_3");
					put(grammarAccess.getSystemExecutionAccess().getCallAssignment_1(), "rule__SystemExecution__CallAssignment_1");
					put(grammarAccess.getSystemExecutionAccess().getCallsAssignment_2(), "rule__SystemExecution__CallsAssignment_2");
					put(grammarAccess.getVariableDeclarationAccess().getConstAssignment_0(), "rule__VariableDeclaration__ConstAssignment_0");
					put(grammarAccess.getVariableDeclarationAccess().getTypeAssignment_1(), "rule__VariableDeclaration__TypeAssignment_1");
					put(grammarAccess.getVariableDeclarationAccess().getNameAssignment_2(), "rule__VariableDeclaration__NameAssignment_2");
					put(grammarAccess.getVariableDeclarationAccess().getExpressionAssignment_3_1(), "rule__VariableDeclaration__ExpressionAssignment_3_1");
					put(grammarAccess.getCompoundAccess().getAbstractAssignment_0(), "rule__Compound__AbstractAssignment_0");
					put(grammarAccess.getCompoundAccess().getNameAssignment_2(), "rule__Compound__NameAssignment_2");
					put(grammarAccess.getCompoundAccess().getSuperAssignment_3_1(), "rule__Compound__SuperAssignment_3_1");
					put(grammarAccess.getCompoundAccess().getVarsAssignment_5(), "rule__Compound__VarsAssignment_5");
					put(grammarAccess.getTypeDefAccess().getNameAssignment_1(), "rule__TypeDef__NameAssignment_1");
					put(grammarAccess.getTypeDefAccess().getTypeAssignment_2(), "rule__TypeDef__TypeAssignment_2");
					put(grammarAccess.getAdviceAccess().getNameAssignment_2(), "rule__Advice__NameAssignment_2");
					put(grammarAccess.getAdviceAccess().getVersionSpecAssignment_4(), "rule__Advice__VersionSpecAssignment_4");
					put(grammarAccess.getVersionSpecAccess().getRestrictionAssignment_1(), "rule__VersionSpec__RestrictionAssignment_1");
					put(grammarAccess.getParameterListAccess().getParamAssignment_0(), "rule__ParameterList__ParamAssignment_0");
					put(grammarAccess.getParameterListAccess().getParamAssignment_1_1(), "rule__ParameterList__ParamAssignment_1_1");
					put(grammarAccess.getParameterAccess().getTypeAssignment_0(), "rule__Parameter__TypeAssignment_0");
					put(grammarAccess.getParameterAccess().getNameAssignment_1(), "rule__Parameter__NameAssignment_1");
					put(grammarAccess.getParameterAccess().getDfltAssignment_2_1(), "rule__Parameter__DfltAssignment_2_1");
					put(grammarAccess.getVersionStmtAccess().getVersionAssignment_1(), "rule__VersionStmt__VersionAssignment_1");
					put(grammarAccess.getImportAccess().getInsertAssignment_0_1(), "rule__Import__InsertAssignment_0_1");
					put(grammarAccess.getImportAccess().getNameAssignment_1(), "rule__Import__NameAssignment_1");
					put(grammarAccess.getImportAccess().getWildcardAssignment_2(), "rule__Import__WildcardAssignment_2");
					put(grammarAccess.getImportAccess().getVersionSpecAssignment_3(), "rule__Import__VersionSpecAssignment_3");
					put(grammarAccess.getExpressionAccess().getExprAssignment_0(), "rule__Expression__ExprAssignment_0");
					put(grammarAccess.getExpressionAccess().getInitAssignment_1(), "rule__Expression__InitAssignment_1");
					put(grammarAccess.getLogicalExpressionAccess().getLeftAssignment_0(), "rule__LogicalExpression__LeftAssignment_0");
					put(grammarAccess.getLogicalExpressionAccess().getRightAssignment_1(), "rule__LogicalExpression__RightAssignment_1");
					put(grammarAccess.getLogicalExpressionPartAccess().getOpAssignment_0(), "rule__LogicalExpressionPart__OpAssignment_0");
					put(grammarAccess.getLogicalExpressionPartAccess().getExAssignment_1(), "rule__LogicalExpressionPart__ExAssignment_1");
					put(grammarAccess.getEqualityExpressionAccess().getLeftAssignment_0(), "rule__EqualityExpression__LeftAssignment_0");
					put(grammarAccess.getEqualityExpressionAccess().getRightAssignment_1(), "rule__EqualityExpression__RightAssignment_1");
					put(grammarAccess.getEqualityExpressionPartAccess().getOpAssignment_0(), "rule__EqualityExpressionPart__OpAssignment_0");
					put(grammarAccess.getEqualityExpressionPartAccess().getExAssignment_1(), "rule__EqualityExpressionPart__ExAssignment_1");
					put(grammarAccess.getRelationalExpressionAccess().getLeftAssignment_0(), "rule__RelationalExpression__LeftAssignment_0");
					put(grammarAccess.getRelationalExpressionAccess().getRightAssignment_1_0(), "rule__RelationalExpression__RightAssignment_1_0");
					put(grammarAccess.getRelationalExpressionAccess().getRight2Assignment_1_1(), "rule__RelationalExpression__Right2Assignment_1_1");
					put(grammarAccess.getRelationalExpressionPartAccess().getOpAssignment_0(), "rule__RelationalExpressionPart__OpAssignment_0");
					put(grammarAccess.getRelationalExpressionPartAccess().getExAssignment_1(), "rule__RelationalExpressionPart__ExAssignment_1");
					put(grammarAccess.getAdditiveExpressionAccess().getLeftAssignment_0(), "rule__AdditiveExpression__LeftAssignment_0");
					put(grammarAccess.getAdditiveExpressionAccess().getRightAssignment_1(), "rule__AdditiveExpression__RightAssignment_1");
					put(grammarAccess.getAdditiveExpressionPartAccess().getOpAssignment_0(), "rule__AdditiveExpressionPart__OpAssignment_0");
					put(grammarAccess.getAdditiveExpressionPartAccess().getExAssignment_1(), "rule__AdditiveExpressionPart__ExAssignment_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getLeftAssignment_0(), "rule__MultiplicativeExpression__LeftAssignment_0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getRightAssignment_1(), "rule__MultiplicativeExpression__RightAssignment_1");
					put(grammarAccess.getMultiplicativeExpressionPartAccess().getOpAssignment_0(), "rule__MultiplicativeExpressionPart__OpAssignment_0");
					put(grammarAccess.getMultiplicativeExpressionPartAccess().getExprAssignment_1(), "rule__MultiplicativeExpressionPart__ExprAssignment_1");
					put(grammarAccess.getUnaryExpressionAccess().getOpAssignment_0(), "rule__UnaryExpression__OpAssignment_0");
					put(grammarAccess.getUnaryExpressionAccess().getExprAssignment_1(), "rule__UnaryExpression__ExprAssignment_1");
					put(grammarAccess.getPostfixExpressionAccess().getLeftAssignment(), "rule__PostfixExpression__LeftAssignment");
					put(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValAssignment_0_0(), "rule__ExpressionOrQualifiedExecution__ValAssignment_0_0");
					put(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisAssignment_0_1_1(), "rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_1");
					put(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsAssignment_1(), "rule__ExpressionOrQualifiedExecution__CallsAssignment_1");
					put(grammarAccess.getUnqualifiedExecutionAccess().getCallAssignment_0(), "rule__UnqualifiedExecution__CallAssignment_0");
					put(grammarAccess.getUnqualifiedExecutionAccess().getCallsAssignment_1(), "rule__UnqualifiedExecution__CallsAssignment_1");
					put(grammarAccess.getSuperExecutionAccess().getCallAssignment_2(), "rule__SuperExecution__CallAssignment_2");
					put(grammarAccess.getSuperExecutionAccess().getCallsAssignment_3(), "rule__SuperExecution__CallsAssignment_3");
					put(grammarAccess.getConstructorExecutionAccess().getTypeAssignment_1(), "rule__ConstructorExecution__TypeAssignment_1");
					put(grammarAccess.getConstructorExecutionAccess().getParamAssignment_3(), "rule__ConstructorExecution__ParamAssignment_3");
					put(grammarAccess.getConstructorExecutionAccess().getCallsAssignment_5(), "rule__ConstructorExecution__CallsAssignment_5");
					put(grammarAccess.getSubCallAccess().getTypeAssignment_0_0(), "rule__SubCall__TypeAssignment_0_0");
					put(grammarAccess.getSubCallAccess().getCallAssignment_0_1(), "rule__SubCall__CallAssignment_0_1");
					put(grammarAccess.getSubCallAccess().getArrayExAssignment_1_1(), "rule__SubCall__ArrayExAssignment_1_1");
					put(grammarAccess.getDeclaratorAccess().getDeclAssignment_0(), "rule__Declarator__DeclAssignment_0");
					put(grammarAccess.getDeclaratorAccess().getDeclAssignment_1_1(), "rule__Declarator__DeclAssignment_1_1");
					put(grammarAccess.getDeclarationAccess().getTypeAssignment_0(), "rule__Declaration__TypeAssignment_0");
					put(grammarAccess.getDeclarationAccess().getUnitsAssignment_1(), "rule__Declaration__UnitsAssignment_1");
					put(grammarAccess.getDeclarationAccess().getUnitsAssignment_2_1(), "rule__Declaration__UnitsAssignment_2_1");
					put(grammarAccess.getDeclarationUnitAccess().getIdAssignment_0(), "rule__DeclarationUnit__IdAssignment_0");
					put(grammarAccess.getDeclarationUnitAccess().getDefltAssignment_1_1(), "rule__DeclarationUnit__DefltAssignment_1_1");
					put(grammarAccess.getAnnotationDeclarationsAccess().getIdAssignment_1_1(), "rule__AnnotationDeclarations__IdAssignment_1_1");
					put(grammarAccess.getCallAccess().getNameAssignment_0(), "rule__Call__NameAssignment_0");
					put(grammarAccess.getCallAccess().getDeclAssignment_2(), "rule__Call__DeclAssignment_2");
					put(grammarAccess.getCallAccess().getParamAssignment_3(), "rule__Call__ParamAssignment_3");
					put(grammarAccess.getArgumentListAccess().getParamAssignment_0(), "rule__ArgumentList__ParamAssignment_0");
					put(grammarAccess.getArgumentListAccess().getParamAssignment_1_1(), "rule__ArgumentList__ParamAssignment_1_1");
					put(grammarAccess.getNamedArgumentAccess().getNameAssignment_0_0(), "rule__NamedArgument__NameAssignment_0_0");
					put(grammarAccess.getNamedArgumentAccess().getExAssignment_1(), "rule__NamedArgument__ExAssignment_1");
					put(grammarAccess.getQualifiedPrefixAccess().getQnameAssignment_0(), "rule__QualifiedPrefix__QnameAssignment_0");
					put(grammarAccess.getQualifiedPrefixAccess().getQnameAssignment_1_0(), "rule__QualifiedPrefix__QnameAssignment_1_0");
					put(grammarAccess.getQualifiedPrefixAccess().getQnameAssignment_1_1(), "rule__QualifiedPrefix__QnameAssignment_1_1");
					put(grammarAccess.getQualifiedNameAccess().getPrefixAssignment_0(), "rule__QualifiedName__PrefixAssignment_0");
					put(grammarAccess.getQualifiedNameAccess().getQnameAssignment_1_0(), "rule__QualifiedName__QnameAssignment_1_0");
					put(grammarAccess.getQualifiedNameAccess().getQnameAssignment_1_1(), "rule__QualifiedName__QnameAssignment_1_1");
					put(grammarAccess.getConstantAccess().getNValueAssignment_0(), "rule__Constant__NValueAssignment_0");
					put(grammarAccess.getConstantAccess().getSValueAssignment_1(), "rule__Constant__SValueAssignment_1");
					put(grammarAccess.getConstantAccess().getQValueAssignment_2(), "rule__Constant__QValueAssignment_2");
					put(grammarAccess.getConstantAccess().getBValueAssignment_3(), "rule__Constant__BValueAssignment_3");
					put(grammarAccess.getConstantAccess().getNullAssignment_4(), "rule__Constant__NullAssignment_4");
					put(grammarAccess.getConstantAccess().getVersionAssignment_5(), "rule__Constant__VersionAssignment_5");
					put(grammarAccess.getNumValueAccess().getValAssignment(), "rule__NumValue__ValAssignment");
					put(grammarAccess.getTypeAccess().getNameAssignment_0(), "rule__Type__NameAssignment_0");
					put(grammarAccess.getTypeAccess().getSetAssignment_1_0(), "rule__Type__SetAssignment_1_0");
					put(grammarAccess.getTypeAccess().getParamAssignment_1_1(), "rule__Type__ParamAssignment_1_1");
					put(grammarAccess.getTypeAccess().getSeqAssignment_2_0(), "rule__Type__SeqAssignment_2_0");
					put(grammarAccess.getTypeAccess().getParamAssignment_2_1(), "rule__Type__ParamAssignment_2_1");
					put(grammarAccess.getTypeAccess().getMapAssignment_3_0(), "rule__Type__MapAssignment_3_0");
					put(grammarAccess.getTypeAccess().getParamAssignment_3_1(), "rule__Type__ParamAssignment_3_1");
					put(grammarAccess.getTypeAccess().getCallAssignment_4_0(), "rule__Type__CallAssignment_4_0");
					put(grammarAccess.getTypeAccess().getReturnAssignment_4_1(), "rule__Type__ReturnAssignment_4_1");
					put(grammarAccess.getTypeAccess().getParamAssignment_4_2(), "rule__Type__ParamAssignment_4_2");
					put(grammarAccess.getTypeParametersAccess().getParamAssignment_1(), "rule__TypeParameters__ParamAssignment_1");
					put(grammarAccess.getTypeParametersAccess().getParamAssignment_2_1(), "rule__TypeParameters__ParamAssignment_2_1");
					put(grammarAccess.getContainerInitializerAccess().getExprsAssignment_2_0(), "rule__ContainerInitializer__ExprsAssignment_2_0");
					put(grammarAccess.getContainerInitializerAccess().getExprsAssignment_2_1_1(), "rule__ContainerInitializer__ExprsAssignment_2_1_1");
					put(grammarAccess.getContainerInitializerExpressionAccess().getLogicalAssignment_0(), "rule__ContainerInitializerExpression__LogicalAssignment_0");
					put(grammarAccess.getContainerInitializerExpressionAccess().getContainerAssignment_1(), "rule__ContainerInitializerExpression__ContainerAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			de.uni_hildesheim.sse.ui.contentassist.antlr.internal.InternalVilBuildLanguageParser typedParser = (de.uni_hildesheim.sse.ui.contentassist.antlr.internal.InternalVilBuildLanguageParser) parser;
			typedParser.entryRuleImplementationUnit();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public VilBuildLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(VilBuildLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
