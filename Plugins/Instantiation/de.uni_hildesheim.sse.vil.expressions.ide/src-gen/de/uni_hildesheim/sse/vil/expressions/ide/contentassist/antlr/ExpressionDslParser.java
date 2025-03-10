/*
 * generated by Xtext 2.35.0
 */
package de.uni_hildesheim.sse.vil.expressions.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import de.uni_hildesheim.sse.vil.expressions.ide.contentassist.antlr.internal.InternalExpressionDslParser;
import de.uni_hildesheim.sse.vil.expressions.services.ExpressionDslGrammarAccess;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class ExpressionDslParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ExpressionDslGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, ExpressionDslGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getImportAccess().getAlternatives_0(), "rule__Import__Alternatives_0");
			builder.put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
			builder.put(grammarAccess.getLogicalOperatorAccess().getAlternatives(), "rule__LogicalOperator__Alternatives");
			builder.put(grammarAccess.getEqualityOperatorAccess().getAlternatives(), "rule__EqualityOperator__Alternatives");
			builder.put(grammarAccess.getRelationalOperatorAccess().getAlternatives(), "rule__RelationalOperator__Alternatives");
			builder.put(grammarAccess.getAdditiveOperatorAccess().getAlternatives(), "rule__AdditiveOperator__Alternatives");
			builder.put(grammarAccess.getMultiplicativeOperatorAccess().getAlternatives(), "rule__MultiplicativeOperator__Alternatives");
			builder.put(grammarAccess.getUnaryOperatorAccess().getAlternatives(), "rule__UnaryOperator__Alternatives");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getAlternatives(), "rule__PrimaryExpression__Alternatives");
			builder.put(grammarAccess.getExpressionOrQualifiedExecutionAccess().getAlternatives_0(), "rule__ExpressionOrQualifiedExecution__Alternatives_0");
			builder.put(grammarAccess.getSubCallAccess().getAlternatives(), "rule__SubCall__Alternatives");
			builder.put(grammarAccess.getSubCallAccess().getTypeAlternatives_0_0_0(), "rule__SubCall__TypeAlternatives_0_0_0");
			builder.put(grammarAccess.getConstantAccess().getAlternatives(), "rule__Constant__Alternatives");
			builder.put(grammarAccess.getConstantAccess().getBValueAlternatives_3_0(), "rule__Constant__BValueAlternatives_3_0");
			builder.put(grammarAccess.getIdentifierAccess().getAlternatives(), "rule__Identifier__Alternatives");
			builder.put(grammarAccess.getTypeAccess().getAlternatives(), "rule__Type__Alternatives");
			builder.put(grammarAccess.getContainerInitializerExpressionAccess().getAlternatives(), "rule__ContainerInitializerExpression__Alternatives");
			builder.put(grammarAccess.getLanguageUnitAccess().getGroup(), "rule__LanguageUnit__Group__0");
			builder.put(grammarAccess.getVariableDeclarationAccess().getGroup(), "rule__VariableDeclaration__Group__0");
			builder.put(grammarAccess.getVariableDeclarationAccess().getGroup_3(), "rule__VariableDeclaration__Group_3__0");
			builder.put(grammarAccess.getCompoundAccess().getGroup(), "rule__Compound__Group__0");
			builder.put(grammarAccess.getCompoundAccess().getGroup_3(), "rule__Compound__Group_3__0");
			builder.put(grammarAccess.getTypeDefAccess().getGroup(), "rule__TypeDef__Group__0");
			builder.put(grammarAccess.getAdviceAccess().getGroup(), "rule__Advice__Group__0");
			builder.put(grammarAccess.getVersionSpecAccess().getGroup(), "rule__VersionSpec__Group__0");
			builder.put(grammarAccess.getParameterListAccess().getGroup(), "rule__ParameterList__Group__0");
			builder.put(grammarAccess.getParameterListAccess().getGroup_1(), "rule__ParameterList__Group_1__0");
			builder.put(grammarAccess.getParameterAccess().getGroup(), "rule__Parameter__Group__0");
			builder.put(grammarAccess.getParameterAccess().getGroup_2(), "rule__Parameter__Group_2__0");
			builder.put(grammarAccess.getVersionStmtAccess().getGroup(), "rule__VersionStmt__Group__0");
			builder.put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
			builder.put(grammarAccess.getExpressionStatementAccess().getGroup(), "rule__ExpressionStatement__Group__0");
			builder.put(grammarAccess.getExpressionStatementAccess().getGroup_0(), "rule__ExpressionStatement__Group_0__0");
			builder.put(grammarAccess.getExpressionStatementAccess().getGroup_0_1(), "rule__ExpressionStatement__Group_0_1__0");
			builder.put(grammarAccess.getLogicalExpressionAccess().getGroup(), "rule__LogicalExpression__Group__0");
			builder.put(grammarAccess.getLogicalExpressionPartAccess().getGroup(), "rule__LogicalExpressionPart__Group__0");
			builder.put(grammarAccess.getEqualityExpressionAccess().getGroup(), "rule__EqualityExpression__Group__0");
			builder.put(grammarAccess.getEqualityExpressionPartAccess().getGroup(), "rule__EqualityExpressionPart__Group__0");
			builder.put(grammarAccess.getRelationalExpressionAccess().getGroup(), "rule__RelationalExpression__Group__0");
			builder.put(grammarAccess.getRelationalExpressionAccess().getGroup_1(), "rule__RelationalExpression__Group_1__0");
			builder.put(grammarAccess.getRelationalExpressionPartAccess().getGroup(), "rule__RelationalExpressionPart__Group__0");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getGroup(), "rule__AdditiveExpression__Group__0");
			builder.put(grammarAccess.getAdditiveExpressionPartAccess().getGroup(), "rule__AdditiveExpressionPart__Group__0");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getGroup(), "rule__MultiplicativeExpression__Group__0");
			builder.put(grammarAccess.getMultiplicativeExpressionPartAccess().getGroup(), "rule__MultiplicativeExpressionPart__Group__0");
			builder.put(grammarAccess.getUnaryExpressionAccess().getGroup(), "rule__UnaryExpression__Group__0");
			builder.put(grammarAccess.getExpressionOrQualifiedExecutionAccess().getGroup(), "rule__ExpressionOrQualifiedExecution__Group__0");
			builder.put(grammarAccess.getExpressionOrQualifiedExecutionAccess().getGroup_0_1(), "rule__ExpressionOrQualifiedExecution__Group_0_1__0");
			builder.put(grammarAccess.getUnqualifiedExecutionAccess().getGroup(), "rule__UnqualifiedExecution__Group__0");
			builder.put(grammarAccess.getSuperExecutionAccess().getGroup(), "rule__SuperExecution__Group__0");
			builder.put(grammarAccess.getConstructorExecutionAccess().getGroup(), "rule__ConstructorExecution__Group__0");
			builder.put(grammarAccess.getSubCallAccess().getGroup_0(), "rule__SubCall__Group_0__0");
			builder.put(grammarAccess.getSubCallAccess().getGroup_1(), "rule__SubCall__Group_1__0");
			builder.put(grammarAccess.getDeclaratorAccess().getGroup(), "rule__Declarator__Group__0");
			builder.put(grammarAccess.getDeclaratorAccess().getGroup_1(), "rule__Declarator__Group_1__0");
			builder.put(grammarAccess.getDeclarationAccess().getGroup(), "rule__Declaration__Group__0");
			builder.put(grammarAccess.getDeclarationAccess().getGroup_2(), "rule__Declaration__Group_2__0");
			builder.put(grammarAccess.getDeclarationUnitAccess().getGroup(), "rule__DeclarationUnit__Group__0");
			builder.put(grammarAccess.getDeclarationUnitAccess().getGroup_1(), "rule__DeclarationUnit__Group_1__0");
			builder.put(grammarAccess.getAnnotationDeclarationsAccess().getGroup(), "rule__AnnotationDeclarations__Group__0");
			builder.put(grammarAccess.getAnnotationDeclarationsAccess().getGroup_1(), "rule__AnnotationDeclarations__Group_1__0");
			builder.put(grammarAccess.getCallAccess().getGroup(), "rule__Call__Group__0");
			builder.put(grammarAccess.getArgumentListAccess().getGroup(), "rule__ArgumentList__Group__0");
			builder.put(grammarAccess.getArgumentListAccess().getGroup_1(), "rule__ArgumentList__Group_1__0");
			builder.put(grammarAccess.getNamedArgumentAccess().getGroup(), "rule__NamedArgument__Group__0");
			builder.put(grammarAccess.getNamedArgumentAccess().getGroup_0(), "rule__NamedArgument__Group_0__0");
			builder.put(grammarAccess.getQualifiedPrefixAccess().getGroup(), "rule__QualifiedPrefix__Group__0");
			builder.put(grammarAccess.getQualifiedPrefixAccess().getGroup_1(), "rule__QualifiedPrefix__Group_1__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getTypeAccess().getGroup_1(), "rule__Type__Group_1__0");
			builder.put(grammarAccess.getTypeAccess().getGroup_2(), "rule__Type__Group_2__0");
			builder.put(grammarAccess.getTypeAccess().getGroup_3(), "rule__Type__Group_3__0");
			builder.put(grammarAccess.getTypeAccess().getGroup_4(), "rule__Type__Group_4__0");
			builder.put(grammarAccess.getTypeParametersAccess().getGroup(), "rule__TypeParameters__Group__0");
			builder.put(grammarAccess.getTypeParametersAccess().getGroup_2(), "rule__TypeParameters__Group_2__0");
			builder.put(grammarAccess.getContainerInitializerAccess().getGroup(), "rule__ContainerInitializer__Group__0");
			builder.put(grammarAccess.getContainerInitializerAccess().getGroup_2(), "rule__ContainerInitializer__Group_2__0");
			builder.put(grammarAccess.getContainerInitializerAccess().getGroup_2_1(), "rule__ContainerInitializer__Group_2_1__0");
			builder.put(grammarAccess.getLanguageUnitAccess().getAdvicesAssignment_0(), "rule__LanguageUnit__AdvicesAssignment_0");
			builder.put(grammarAccess.getLanguageUnitAccess().getNameAssignment_1(), "rule__LanguageUnit__NameAssignment_1");
			builder.put(grammarAccess.getLanguageUnitAccess().getVersionAssignment_2(), "rule__LanguageUnit__VersionAssignment_2");
			builder.put(grammarAccess.getLanguageUnitAccess().getImportsAssignment_3(), "rule__LanguageUnit__ImportsAssignment_3");
			builder.put(grammarAccess.getVariableDeclarationAccess().getConstAssignment_0(), "rule__VariableDeclaration__ConstAssignment_0");
			builder.put(grammarAccess.getVariableDeclarationAccess().getTypeAssignment_1(), "rule__VariableDeclaration__TypeAssignment_1");
			builder.put(grammarAccess.getVariableDeclarationAccess().getNameAssignment_2(), "rule__VariableDeclaration__NameAssignment_2");
			builder.put(grammarAccess.getVariableDeclarationAccess().getExpressionAssignment_3_1(), "rule__VariableDeclaration__ExpressionAssignment_3_1");
			builder.put(grammarAccess.getCompoundAccess().getAbstractAssignment_0(), "rule__Compound__AbstractAssignment_0");
			builder.put(grammarAccess.getCompoundAccess().getNameAssignment_2(), "rule__Compound__NameAssignment_2");
			builder.put(grammarAccess.getCompoundAccess().getSuperAssignment_3_1(), "rule__Compound__SuperAssignment_3_1");
			builder.put(grammarAccess.getCompoundAccess().getVarsAssignment_5(), "rule__Compound__VarsAssignment_5");
			builder.put(grammarAccess.getTypeDefAccess().getNameAssignment_1(), "rule__TypeDef__NameAssignment_1");
			builder.put(grammarAccess.getTypeDefAccess().getTypeAssignment_2(), "rule__TypeDef__TypeAssignment_2");
			builder.put(grammarAccess.getAdviceAccess().getNameAssignment_2(), "rule__Advice__NameAssignment_2");
			builder.put(grammarAccess.getAdviceAccess().getVersionSpecAssignment_4(), "rule__Advice__VersionSpecAssignment_4");
			builder.put(grammarAccess.getVersionSpecAccess().getRestrictionAssignment_1(), "rule__VersionSpec__RestrictionAssignment_1");
			builder.put(grammarAccess.getParameterListAccess().getParamAssignment_0(), "rule__ParameterList__ParamAssignment_0");
			builder.put(grammarAccess.getParameterListAccess().getParamAssignment_1_1(), "rule__ParameterList__ParamAssignment_1_1");
			builder.put(grammarAccess.getParameterAccess().getTypeAssignment_0(), "rule__Parameter__TypeAssignment_0");
			builder.put(grammarAccess.getParameterAccess().getNameAssignment_1(), "rule__Parameter__NameAssignment_1");
			builder.put(grammarAccess.getParameterAccess().getDfltAssignment_2_1(), "rule__Parameter__DfltAssignment_2_1");
			builder.put(grammarAccess.getVersionStmtAccess().getVersionAssignment_1(), "rule__VersionStmt__VersionAssignment_1");
			builder.put(grammarAccess.getImportAccess().getInsertAssignment_0_1(), "rule__Import__InsertAssignment_0_1");
			builder.put(grammarAccess.getImportAccess().getNameAssignment_1(), "rule__Import__NameAssignment_1");
			builder.put(grammarAccess.getImportAccess().getWildcardAssignment_2(), "rule__Import__WildcardAssignment_2");
			builder.put(grammarAccess.getImportAccess().getVersionSpecAssignment_3(), "rule__Import__VersionSpecAssignment_3");
			builder.put(grammarAccess.getExpressionStatementAccess().getVarAssignment_0_0(), "rule__ExpressionStatement__VarAssignment_0_0");
			builder.put(grammarAccess.getExpressionStatementAccess().getFieldAssignment_0_1_1(), "rule__ExpressionStatement__FieldAssignment_0_1_1");
			builder.put(grammarAccess.getExpressionStatementAccess().getExprAssignment_1(), "rule__ExpressionStatement__ExprAssignment_1");
			builder.put(grammarAccess.getExpressionAccess().getExprAssignment_0(), "rule__Expression__ExprAssignment_0");
			builder.put(grammarAccess.getExpressionAccess().getInitAssignment_1(), "rule__Expression__InitAssignment_1");
			builder.put(grammarAccess.getLogicalExpressionAccess().getLeftAssignment_0(), "rule__LogicalExpression__LeftAssignment_0");
			builder.put(grammarAccess.getLogicalExpressionAccess().getRightAssignment_1(), "rule__LogicalExpression__RightAssignment_1");
			builder.put(grammarAccess.getLogicalExpressionPartAccess().getOpAssignment_0(), "rule__LogicalExpressionPart__OpAssignment_0");
			builder.put(grammarAccess.getLogicalExpressionPartAccess().getExAssignment_1(), "rule__LogicalExpressionPart__ExAssignment_1");
			builder.put(grammarAccess.getEqualityExpressionAccess().getLeftAssignment_0(), "rule__EqualityExpression__LeftAssignment_0");
			builder.put(grammarAccess.getEqualityExpressionAccess().getRightAssignment_1(), "rule__EqualityExpression__RightAssignment_1");
			builder.put(grammarAccess.getEqualityExpressionPartAccess().getOpAssignment_0(), "rule__EqualityExpressionPart__OpAssignment_0");
			builder.put(grammarAccess.getEqualityExpressionPartAccess().getExAssignment_1(), "rule__EqualityExpressionPart__ExAssignment_1");
			builder.put(grammarAccess.getRelationalExpressionAccess().getLeftAssignment_0(), "rule__RelationalExpression__LeftAssignment_0");
			builder.put(grammarAccess.getRelationalExpressionAccess().getRightAssignment_1_0(), "rule__RelationalExpression__RightAssignment_1_0");
			builder.put(grammarAccess.getRelationalExpressionAccess().getRight2Assignment_1_1(), "rule__RelationalExpression__Right2Assignment_1_1");
			builder.put(grammarAccess.getRelationalExpressionPartAccess().getOpAssignment_0(), "rule__RelationalExpressionPart__OpAssignment_0");
			builder.put(grammarAccess.getRelationalExpressionPartAccess().getExAssignment_1(), "rule__RelationalExpressionPart__ExAssignment_1");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getLeftAssignment_0(), "rule__AdditiveExpression__LeftAssignment_0");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getRightAssignment_1(), "rule__AdditiveExpression__RightAssignment_1");
			builder.put(grammarAccess.getAdditiveExpressionPartAccess().getOpAssignment_0(), "rule__AdditiveExpressionPart__OpAssignment_0");
			builder.put(grammarAccess.getAdditiveExpressionPartAccess().getExAssignment_1(), "rule__AdditiveExpressionPart__ExAssignment_1");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getLeftAssignment_0(), "rule__MultiplicativeExpression__LeftAssignment_0");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getRightAssignment_1(), "rule__MultiplicativeExpression__RightAssignment_1");
			builder.put(grammarAccess.getMultiplicativeExpressionPartAccess().getOpAssignment_0(), "rule__MultiplicativeExpressionPart__OpAssignment_0");
			builder.put(grammarAccess.getMultiplicativeExpressionPartAccess().getExprAssignment_1(), "rule__MultiplicativeExpressionPart__ExprAssignment_1");
			builder.put(grammarAccess.getUnaryExpressionAccess().getOpAssignment_0(), "rule__UnaryExpression__OpAssignment_0");
			builder.put(grammarAccess.getUnaryExpressionAccess().getExprAssignment_1(), "rule__UnaryExpression__ExprAssignment_1");
			builder.put(grammarAccess.getPostfixExpressionAccess().getLeftAssignment(), "rule__PostfixExpression__LeftAssignment");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getOtherExAssignment_0(), "rule__PrimaryExpression__OtherExAssignment_0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getUnqExAssignment_1(), "rule__PrimaryExpression__UnqExAssignment_1");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getSuperExAssignment_2(), "rule__PrimaryExpression__SuperExAssignment_2");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getNewExAssignment_3(), "rule__PrimaryExpression__NewExAssignment_3");
			builder.put(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValAssignment_0_0(), "rule__ExpressionOrQualifiedExecution__ValAssignment_0_0");
			builder.put(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisAssignment_0_1_1(), "rule__ExpressionOrQualifiedExecution__ParenthesisAssignment_0_1_1");
			builder.put(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsAssignment_1(), "rule__ExpressionOrQualifiedExecution__CallsAssignment_1");
			builder.put(grammarAccess.getUnqualifiedExecutionAccess().getCallAssignment_0(), "rule__UnqualifiedExecution__CallAssignment_0");
			builder.put(grammarAccess.getUnqualifiedExecutionAccess().getCallsAssignment_1(), "rule__UnqualifiedExecution__CallsAssignment_1");
			builder.put(grammarAccess.getSuperExecutionAccess().getCallAssignment_2(), "rule__SuperExecution__CallAssignment_2");
			builder.put(grammarAccess.getSuperExecutionAccess().getCallsAssignment_3(), "rule__SuperExecution__CallsAssignment_3");
			builder.put(grammarAccess.getConstructorExecutionAccess().getTypeAssignment_1(), "rule__ConstructorExecution__TypeAssignment_1");
			builder.put(grammarAccess.getConstructorExecutionAccess().getParamAssignment_3(), "rule__ConstructorExecution__ParamAssignment_3");
			builder.put(grammarAccess.getConstructorExecutionAccess().getCallsAssignment_5(), "rule__ConstructorExecution__CallsAssignment_5");
			builder.put(grammarAccess.getSubCallAccess().getTypeAssignment_0_0(), "rule__SubCall__TypeAssignment_0_0");
			builder.put(grammarAccess.getSubCallAccess().getCallAssignment_0_1(), "rule__SubCall__CallAssignment_0_1");
			builder.put(grammarAccess.getSubCallAccess().getArrayExAssignment_1_1(), "rule__SubCall__ArrayExAssignment_1_1");
			builder.put(grammarAccess.getDeclaratorAccess().getDeclAssignment_0(), "rule__Declarator__DeclAssignment_0");
			builder.put(grammarAccess.getDeclaratorAccess().getDeclAssignment_1_1(), "rule__Declarator__DeclAssignment_1_1");
			builder.put(grammarAccess.getDeclarationAccess().getTypeAssignment_0(), "rule__Declaration__TypeAssignment_0");
			builder.put(grammarAccess.getDeclarationAccess().getUnitsAssignment_1(), "rule__Declaration__UnitsAssignment_1");
			builder.put(grammarAccess.getDeclarationAccess().getUnitsAssignment_2_1(), "rule__Declaration__UnitsAssignment_2_1");
			builder.put(grammarAccess.getDeclarationUnitAccess().getIdAssignment_0(), "rule__DeclarationUnit__IdAssignment_0");
			builder.put(grammarAccess.getDeclarationUnitAccess().getDefltAssignment_1_1(), "rule__DeclarationUnit__DefltAssignment_1_1");
			builder.put(grammarAccess.getAnnotationDeclarationsAccess().getIdAssignment_1_1(), "rule__AnnotationDeclarations__IdAssignment_1_1");
			builder.put(grammarAccess.getCallAccess().getNameAssignment_0(), "rule__Call__NameAssignment_0");
			builder.put(grammarAccess.getCallAccess().getDeclAssignment_2(), "rule__Call__DeclAssignment_2");
			builder.put(grammarAccess.getCallAccess().getParamAssignment_3(), "rule__Call__ParamAssignment_3");
			builder.put(grammarAccess.getArgumentListAccess().getParamAssignment_0(), "rule__ArgumentList__ParamAssignment_0");
			builder.put(grammarAccess.getArgumentListAccess().getParamAssignment_1_1(), "rule__ArgumentList__ParamAssignment_1_1");
			builder.put(grammarAccess.getNamedArgumentAccess().getNameAssignment_0_0(), "rule__NamedArgument__NameAssignment_0_0");
			builder.put(grammarAccess.getNamedArgumentAccess().getExAssignment_1(), "rule__NamedArgument__ExAssignment_1");
			builder.put(grammarAccess.getQualifiedPrefixAccess().getQnameAssignment_0(), "rule__QualifiedPrefix__QnameAssignment_0");
			builder.put(grammarAccess.getQualifiedPrefixAccess().getQnameAssignment_1_0(), "rule__QualifiedPrefix__QnameAssignment_1_0");
			builder.put(grammarAccess.getQualifiedPrefixAccess().getQnameAssignment_1_1(), "rule__QualifiedPrefix__QnameAssignment_1_1");
			builder.put(grammarAccess.getQualifiedNameAccess().getPrefixAssignment_0(), "rule__QualifiedName__PrefixAssignment_0");
			builder.put(grammarAccess.getQualifiedNameAccess().getQnameAssignment_1_0(), "rule__QualifiedName__QnameAssignment_1_0");
			builder.put(grammarAccess.getQualifiedNameAccess().getQnameAssignment_1_1(), "rule__QualifiedName__QnameAssignment_1_1");
			builder.put(grammarAccess.getConstantAccess().getNValueAssignment_0(), "rule__Constant__NValueAssignment_0");
			builder.put(grammarAccess.getConstantAccess().getSValueAssignment_1(), "rule__Constant__SValueAssignment_1");
			builder.put(grammarAccess.getConstantAccess().getQValueAssignment_2(), "rule__Constant__QValueAssignment_2");
			builder.put(grammarAccess.getConstantAccess().getBValueAssignment_3(), "rule__Constant__BValueAssignment_3");
			builder.put(grammarAccess.getConstantAccess().getNullAssignment_4(), "rule__Constant__NullAssignment_4");
			builder.put(grammarAccess.getConstantAccess().getVersionAssignment_5(), "rule__Constant__VersionAssignment_5");
			builder.put(grammarAccess.getNumValueAccess().getValAssignment(), "rule__NumValue__ValAssignment");
			builder.put(grammarAccess.getTypeAccess().getNameAssignment_0(), "rule__Type__NameAssignment_0");
			builder.put(grammarAccess.getTypeAccess().getSetAssignment_1_0(), "rule__Type__SetAssignment_1_0");
			builder.put(grammarAccess.getTypeAccess().getParamAssignment_1_1(), "rule__Type__ParamAssignment_1_1");
			builder.put(grammarAccess.getTypeAccess().getSeqAssignment_2_0(), "rule__Type__SeqAssignment_2_0");
			builder.put(grammarAccess.getTypeAccess().getParamAssignment_2_1(), "rule__Type__ParamAssignment_2_1");
			builder.put(grammarAccess.getTypeAccess().getMapAssignment_3_0(), "rule__Type__MapAssignment_3_0");
			builder.put(grammarAccess.getTypeAccess().getParamAssignment_3_1(), "rule__Type__ParamAssignment_3_1");
			builder.put(grammarAccess.getTypeAccess().getCallAssignment_4_0(), "rule__Type__CallAssignment_4_0");
			builder.put(grammarAccess.getTypeAccess().getReturnAssignment_4_1(), "rule__Type__ReturnAssignment_4_1");
			builder.put(grammarAccess.getTypeAccess().getParamAssignment_4_2(), "rule__Type__ParamAssignment_4_2");
			builder.put(grammarAccess.getTypeParametersAccess().getParamAssignment_1(), "rule__TypeParameters__ParamAssignment_1");
			builder.put(grammarAccess.getTypeParametersAccess().getParamAssignment_2_1(), "rule__TypeParameters__ParamAssignment_2_1");
			builder.put(grammarAccess.getContainerInitializerAccess().getExprsAssignment_2_0(), "rule__ContainerInitializer__ExprsAssignment_2_0");
			builder.put(grammarAccess.getContainerInitializerAccess().getExprsAssignment_2_1_1(), "rule__ContainerInitializer__ExprsAssignment_2_1_1");
			builder.put(grammarAccess.getContainerInitializerExpressionAccess().getLogicalAssignment_0(), "rule__ContainerInitializerExpression__LogicalAssignment_0");
			builder.put(grammarAccess.getContainerInitializerExpressionAccess().getContainerAssignment_1(), "rule__ContainerInitializerExpression__ContainerAssignment_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ExpressionDslGrammarAccess grammarAccess;

	@Override
	protected InternalExpressionDslParser createParser() {
		InternalExpressionDslParser result = new InternalExpressionDslParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public ExpressionDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ExpressionDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
