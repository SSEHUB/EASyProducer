/*
 * generated by Xtext 2.34.0
 */
package de.uni_hildesheim.sse.vil.rt.serializer;

import com.google.inject.Inject;
import de.uni_hildesheim.sse.vil.buildlang.serializer.VilBuildLanguageSemanticSequencer;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.Alternative;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.ExpressionStatement;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.For;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.Instantiate;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.Join;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.JoinVariable;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.LoadProperties;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.LoopVariable;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.Map;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.PrimaryExpression;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.Require;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.RuleConditions;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.RuleDeclaration;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.RuleModifier;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.ScriptContents;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.ScriptParentDecl;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.StatementOrBlock;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.SystemExecution;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.VilBuildLanguagePackage;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.While;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Advice;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.AnnotationDeclarations;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ArgumentList;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Compound;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ConstructorExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializer;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializerExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Declaration;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.DeclarationUnit;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Declarator;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionOrQualifiedExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.NamedArgument;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.NumValue;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.PostfixExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedName;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedPrefix;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.SubCall;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.SuperExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeParameters;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnaryExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnqualifiedExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionSpec;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionStmt;
import de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement;
import de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement;
import de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownWithPart;
import de.uni_hildesheim.sse.vil.rt.rtVil.FailStatement;
import de.uni_hildesheim.sse.vil.rt.rtVil.GlobalVariableDeclaration;
import de.uni_hildesheim.sse.vil.rt.rtVil.ImplementationUnit;
import de.uni_hildesheim.sse.vil.rt.rtVil.IntentDeclaration;
import de.uni_hildesheim.sse.vil.rt.rtVil.LanguageUnit;
import de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage;
import de.uni_hildesheim.sse.vil.rt.rtVil.RuleElement;
import de.uni_hildesheim.sse.vil.rt.rtVil.RuleElementBlock;
import de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration;
import de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration;
import de.uni_hildesheim.sse.vil.rt.rtVil.WeightingStatement;
import de.uni_hildesheim.sse.vil.rt.rtVil.rtContents;
import de.uni_hildesheim.sse.vil.rt.services.RtVilGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class RtVilSemanticSequencer extends VilBuildLanguageSemanticSequencer {

	@Inject
	private RtVilGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == ExpressionDslPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ExpressionDslPackage.ADDITIVE_EXPRESSION:
				sequence_AdditiveExpression(context, (AdditiveExpression) semanticObject); 
				return; 
			case ExpressionDslPackage.ADDITIVE_EXPRESSION_PART:
				sequence_AdditiveExpressionPart(context, (AdditiveExpressionPart) semanticObject); 
				return; 
			case ExpressionDslPackage.ADVICE:
				sequence_Advice(context, (Advice) semanticObject); 
				return; 
			case ExpressionDslPackage.ANNOTATION_DECLARATIONS:
				sequence_AnnotationDeclarations(context, (AnnotationDeclarations) semanticObject); 
				return; 
			case ExpressionDslPackage.ARGUMENT_LIST:
				sequence_ArgumentList(context, (ArgumentList) semanticObject); 
				return; 
			case ExpressionDslPackage.CALL:
				sequence_Call(context, (Call) semanticObject); 
				return; 
			case ExpressionDslPackage.COMPOUND:
				sequence_Compound(context, (Compound) semanticObject); 
				return; 
			case ExpressionDslPackage.CONSTANT:
				sequence_Constant(context, (Constant) semanticObject); 
				return; 
			case ExpressionDslPackage.CONSTRUCTOR_EXECUTION:
				sequence_ConstructorExecution(context, (ConstructorExecution) semanticObject); 
				return; 
			case ExpressionDslPackage.CONTAINER_INITIALIZER:
				sequence_ContainerInitializer(context, (ContainerInitializer) semanticObject); 
				return; 
			case ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION:
				sequence_ContainerInitializerExpression(context, (ContainerInitializerExpression) semanticObject); 
				return; 
			case ExpressionDslPackage.DECLARATION:
				sequence_Declaration(context, (Declaration) semanticObject); 
				return; 
			case ExpressionDslPackage.DECLARATION_UNIT:
				sequence_DeclarationUnit(context, (DeclarationUnit) semanticObject); 
				return; 
			case ExpressionDslPackage.DECLARATOR:
				sequence_Declarator(context, (Declarator) semanticObject); 
				return; 
			case ExpressionDslPackage.EQUALITY_EXPRESSION:
				sequence_EqualityExpression(context, (EqualityExpression) semanticObject); 
				return; 
			case ExpressionDslPackage.EQUALITY_EXPRESSION_PART:
				sequence_EqualityExpressionPart(context, (EqualityExpressionPart) semanticObject); 
				return; 
			case ExpressionDslPackage.EXPRESSION:
				sequence_Expression(context, (Expression) semanticObject); 
				return; 
			case ExpressionDslPackage.EXPRESSION_OR_QUALIFIED_EXECUTION:
				sequence_ExpressionOrQualifiedExecution(context, (ExpressionOrQualifiedExecution) semanticObject); 
				return; 
			case ExpressionDslPackage.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case ExpressionDslPackage.LOGICAL_EXPRESSION:
				sequence_LogicalExpression(context, (LogicalExpression) semanticObject); 
				return; 
			case ExpressionDslPackage.LOGICAL_EXPRESSION_PART:
				sequence_LogicalExpressionPart(context, (LogicalExpressionPart) semanticObject); 
				return; 
			case ExpressionDslPackage.MULTIPLICATIVE_EXPRESSION:
				sequence_MultiplicativeExpression(context, (MultiplicativeExpression) semanticObject); 
				return; 
			case ExpressionDslPackage.MULTIPLICATIVE_EXPRESSION_PART:
				sequence_MultiplicativeExpressionPart(context, (MultiplicativeExpressionPart) semanticObject); 
				return; 
			case ExpressionDslPackage.NAMED_ARGUMENT:
				sequence_NamedArgument(context, (NamedArgument) semanticObject); 
				return; 
			case ExpressionDslPackage.NUM_VALUE:
				sequence_NumValue(context, (NumValue) semanticObject); 
				return; 
			case ExpressionDslPackage.PARAMETER:
				sequence_Parameter(context, (de.uni_hildesheim.sse.vil.expressions.expressionDsl.Parameter) semanticObject); 
				return; 
			case ExpressionDslPackage.PARAMETER_LIST:
				sequence_ParameterList(context, (ParameterList) semanticObject); 
				return; 
			case ExpressionDslPackage.POSTFIX_EXPRESSION:
				sequence_PostfixExpression(context, (PostfixExpression) semanticObject); 
				return; 
			case ExpressionDslPackage.QUALIFIED_NAME:
				sequence_QualifiedName(context, (QualifiedName) semanticObject); 
				return; 
			case ExpressionDslPackage.QUALIFIED_PREFIX:
				sequence_QualifiedPrefix(context, (QualifiedPrefix) semanticObject); 
				return; 
			case ExpressionDslPackage.RELATIONAL_EXPRESSION:
				sequence_RelationalExpression(context, (RelationalExpression) semanticObject); 
				return; 
			case ExpressionDslPackage.RELATIONAL_EXPRESSION_PART:
				sequence_RelationalExpressionPart(context, (RelationalExpressionPart) semanticObject); 
				return; 
			case ExpressionDslPackage.SUB_CALL:
				sequence_SubCall(context, (SubCall) semanticObject); 
				return; 
			case ExpressionDslPackage.SUPER_EXECUTION:
				sequence_SuperExecution(context, (SuperExecution) semanticObject); 
				return; 
			case ExpressionDslPackage.TYPE:
				sequence_Type(context, (Type) semanticObject); 
				return; 
			case ExpressionDslPackage.TYPE_DEF:
				sequence_TypeDef(context, (TypeDef) semanticObject); 
				return; 
			case ExpressionDslPackage.TYPE_PARAMETERS:
				sequence_TypeParameters(context, (TypeParameters) semanticObject); 
				return; 
			case ExpressionDslPackage.UNARY_EXPRESSION:
				sequence_UnaryExpression(context, (UnaryExpression) semanticObject); 
				return; 
			case ExpressionDslPackage.UNQUALIFIED_EXECUTION:
				sequence_UnqualifiedExecution(context, (UnqualifiedExecution) semanticObject); 
				return; 
			case ExpressionDslPackage.VARIABLE_DECLARATION:
				sequence_VariableDeclaration(context, (VariableDeclaration) semanticObject); 
				return; 
			case ExpressionDslPackage.VERSION_SPEC:
				sequence_VersionSpec(context, (VersionSpec) semanticObject); 
				return; 
			case ExpressionDslPackage.VERSION_STMT:
				sequence_VersionStmt(context, (VersionStmt) semanticObject); 
				return; 
			}
		else if (epackage == RtVilPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case RtVilPackage.BREAKDOWN_ELEMENT:
				sequence_BreakdownElement(context, (BreakdownElement) semanticObject); 
				return; 
			case RtVilPackage.BREAKDOWN_STATEMENT:
				sequence_BreakdownStatement(context, (BreakdownStatement) semanticObject); 
				return; 
			case RtVilPackage.BREAKDOWN_WITH_PART:
				sequence_BreakdownWithPart(context, (BreakdownWithPart) semanticObject); 
				return; 
			case RtVilPackage.FAIL_STATEMENT:
				sequence_FailStatement(context, (FailStatement) semanticObject); 
				return; 
			case RtVilPackage.GLOBAL_VARIABLE_DECLARATION:
				sequence_GlobalVariableDeclaration(context, (GlobalVariableDeclaration) semanticObject); 
				return; 
			case RtVilPackage.IMPLEMENTATION_UNIT:
				sequence_ImplementationUnit(context, (ImplementationUnit) semanticObject); 
				return; 
			case RtVilPackage.INTENT_DECLARATION:
				sequence_IntentDeclaration(context, (IntentDeclaration) semanticObject); 
				return; 
			case RtVilPackage.LANGUAGE_UNIT:
				sequence_LanguageUnit(context, (LanguageUnit) semanticObject); 
				return; 
			case RtVilPackage.RULE_ELEMENT:
				sequence_RuleElement(context, (RuleElement) semanticObject); 
				return; 
			case RtVilPackage.RULE_ELEMENT_BLOCK:
				sequence_RuleElementBlock(context, (RuleElementBlock) semanticObject); 
				return; 
			case RtVilPackage.STRATEGY_DECLARATION:
				sequence_StrategyDeclaration(context, (StrategyDeclaration) semanticObject); 
				return; 
			case RtVilPackage.TACTIC_DECLARATION:
				sequence_TacticDeclaration(context, (TacticDeclaration) semanticObject); 
				return; 
			case RtVilPackage.WEIGHTING_STATEMENT:
				sequence_WeightingStatement(context, (WeightingStatement) semanticObject); 
				return; 
			case RtVilPackage.RT_CONTENTS:
				sequence_rtContents(context, (rtContents) semanticObject); 
				return; 
			}
		else if (epackage == VilBuildLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case VilBuildLanguagePackage.ALTERNATIVE:
				sequence_Alternative(context, (Alternative) semanticObject); 
				return; 
			case VilBuildLanguagePackage.EXPRESSION_STATEMENT:
				sequence_ExpressionStatement(context, (ExpressionStatement) semanticObject); 
				return; 
			case VilBuildLanguagePackage.FOR:
				sequence_For(context, (For) semanticObject); 
				return; 
			case VilBuildLanguagePackage.INSTANTIATE:
				sequence_Instantiate(context, (Instantiate) semanticObject); 
				return; 
			case VilBuildLanguagePackage.JOIN:
				sequence_Join(context, (Join) semanticObject); 
				return; 
			case VilBuildLanguagePackage.JOIN_VARIABLE:
				sequence_JoinVariable(context, (JoinVariable) semanticObject); 
				return; 
			case VilBuildLanguagePackage.LOAD_PROPERTIES:
				sequence_LoadProperties(context, (LoadProperties) semanticObject); 
				return; 
			case VilBuildLanguagePackage.LOOP_VARIABLE:
				sequence_LoopVariable(context, (LoopVariable) semanticObject); 
				return; 
			case VilBuildLanguagePackage.MAP:
				sequence_Map(context, (Map) semanticObject); 
				return; 
			case VilBuildLanguagePackage.PRIMARY_EXPRESSION:
				sequence_PrimaryExpression(context, (PrimaryExpression) semanticObject); 
				return; 
			case VilBuildLanguagePackage.REQUIRE:
				sequence_Require(context, (Require) semanticObject); 
				return; 
			case VilBuildLanguagePackage.RULE_CONDITIONS:
				sequence_RuleConditions(context, (RuleConditions) semanticObject); 
				return; 
			case VilBuildLanguagePackage.RULE_DECLARATION:
				sequence_RuleDeclaration(context, (RuleDeclaration) semanticObject); 
				return; 
			case VilBuildLanguagePackage.RULE_MODIFIER:
				sequence_RuleModifier(context, (RuleModifier) semanticObject); 
				return; 
			case VilBuildLanguagePackage.SCRIPT_CONTENTS:
				sequence_ScriptContents(context, (ScriptContents) semanticObject); 
				return; 
			case VilBuildLanguagePackage.SCRIPT_PARENT_DECL:
				sequence_ScriptParentDecl(context, (ScriptParentDecl) semanticObject); 
				return; 
			case VilBuildLanguagePackage.STATEMENT_OR_BLOCK:
				sequence_StatementOrBlock(context, (StatementOrBlock) semanticObject); 
				return; 
			case VilBuildLanguagePackage.SYSTEM_EXECUTION:
				sequence_SystemExecution(context, (SystemExecution) semanticObject); 
				return; 
			case VilBuildLanguagePackage.WHILE:
				sequence_While(context, (While) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     BreakdownElement returns BreakdownElement
	 *
	 * Constraint:
	 *     (varDecl=VariableDeclaration | exprStmt=ExpressionStatement | breakdownStmt=BreakdownStatement)
	 * </pre>
	 */
	protected void sequence_BreakdownElement(ISerializationContext context, BreakdownElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     BreakdownStatement returns BreakdownStatement
	 *
	 * Constraint:
	 *     (
	 *         (type='strategy' | type='tactic') 
	 *         guard=LogicalExpression? 
	 *         name=QualifiedPrefix 
	 *         param=ArgumentList? 
	 *         (part+=BreakdownWithPart part+=BreakdownWithPart)? 
	 *         time=Expression?
	 *     )
	 * </pre>
	 */
	protected void sequence_BreakdownStatement(ISerializationContext context, BreakdownStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     BreakdownWithPart returns BreakdownWithPart
	 *
	 * Constraint:
	 *     (name=Identifier value=Expression)
	 * </pre>
	 */
	protected void sequence_BreakdownWithPart(ISerializationContext context, BreakdownWithPart semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RtVilPackage.Literals.BREAKDOWN_WITH_PART__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RtVilPackage.Literals.BREAKDOWN_WITH_PART__NAME));
			if (transientValues.isValueTransient(semanticObject, RtVilPackage.Literals.BREAKDOWN_WITH_PART__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RtVilPackage.Literals.BREAKDOWN_WITH_PART__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBreakdownWithPartAccess().getNameIdentifierParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getBreakdownWithPartAccess().getValueExpressionParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     FailStatement returns FailStatement
	 *
	 * Constraint:
	 *     ((name='fail' reason=Expression? code=Expression?) | name='refail')
	 * </pre>
	 */
	protected void sequence_FailStatement(ISerializationContext context, FailStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     GlobalVariableDeclaration returns GlobalVariableDeclaration
	 *
	 * Constraint:
	 *     (persistent='persistent'? varDecl=VariableDeclaration)
	 * </pre>
	 */
	protected void sequence_GlobalVariableDeclaration(ISerializationContext context, GlobalVariableDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ImplementationUnit returns ImplementationUnit
	 *
	 * Constraint:
	 *     (imports+=Import* requires+=Require* scripts+=LanguageUnit*)
	 * </pre>
	 */
	protected void sequence_ImplementationUnit(ISerializationContext context, ImplementationUnit semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     IntentDeclaration returns IntentDeclaration
	 *
	 * Constraint:
	 *     exprStmt=ExpressionStatement
	 * </pre>
	 */
	protected void sequence_IntentDeclaration(ISerializationContext context, IntentDeclaration semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RtVilPackage.Literals.INTENT_DECLARATION__EXPR_STMT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RtVilPackage.Literals.INTENT_DECLARATION__EXPR_STMT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIntentDeclarationAccess().getExprStmtExpressionStatementParserRuleCall_1_0(), semanticObject.getExprStmt());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     LanguageUnit returns LanguageUnit
	 *
	 * Constraint:
	 *     (
	 *         advices+=Advice* 
	 *         name=Identifier 
	 *         param=ParameterList? 
	 *         parent=ScriptParentDecl? 
	 *         version=VersionStmt? 
	 *         rtContents=rtContents
	 *     )
	 * </pre>
	 */
	protected void sequence_LanguageUnit(ISerializationContext context, LanguageUnit semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RuleElementBlock returns RuleElementBlock
	 *
	 * Constraint:
	 *     (intent=IntentDeclaration? elements+=RuleElement*)
	 * </pre>
	 */
	protected void sequence_RuleElementBlock(ISerializationContext context, RuleElementBlock semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RuleElement returns RuleElement
	 *
	 * Constraint:
	 *     (varDecl=VariableDeclaration | exprStmt=ExpressionStatement | while=While | for=For | fail=FailStatement)
	 * </pre>
	 */
	protected void sequence_RuleElement(ISerializationContext context, RuleElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     StrategyDeclaration returns StrategyDeclaration
	 *
	 * Constraint:
	 *     (
	 *         name=Identifier 
	 *         paramList=ParameterList? 
	 *         conditions=RuleConditions? 
	 *         varDecls+=VariableDeclaration* 
	 *         objective=Expression? 
	 *         weighting=WeightingStatement? 
	 *         breakdown+=BreakdownElement+ 
	 *         post+=RuleElement*
	 *     )
	 * </pre>
	 */
	protected void sequence_StrategyDeclaration(ISerializationContext context, StrategyDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TacticDeclaration returns TacticDeclaration
	 *
	 * Constraint:
	 *     (name=Identifier paramList=ParameterList? conditions=RuleConditions? block=RuleElementBlock)
	 * </pre>
	 */
	protected void sequence_TacticDeclaration(ISerializationContext context, TacticDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     WeightingStatement returns WeightingStatement
	 *
	 * Constraint:
	 *     (name=Identifier expr=Expression)
	 * </pre>
	 */
	protected void sequence_WeightingStatement(ISerializationContext context, WeightingStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RtVilPackage.Literals.WEIGHTING_STATEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RtVilPackage.Literals.WEIGHTING_STATEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, RtVilPackage.Literals.WEIGHTING_STATEMENT__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RtVilPackage.Literals.WEIGHTING_STATEMENT__EXPR));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getWeightingStatementAccess().getNameIdentifierParserRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getWeightingStatementAccess().getExprExpressionParserRuleCall_4_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     rtContents returns rtContents
	 *
	 * Constraint:
	 *     (
	 *         elements+=GlobalVariableDeclaration | 
	 *         elements+=RuleDeclaration | 
	 *         elements+=StrategyDeclaration | 
	 *         elements+=TacticDeclaration | 
	 *         elements+=TypeDef | 
	 *         elements+=Compound
	 *     )*
	 * </pre>
	 */
	protected void sequence_rtContents(ISerializationContext context, rtContents semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}