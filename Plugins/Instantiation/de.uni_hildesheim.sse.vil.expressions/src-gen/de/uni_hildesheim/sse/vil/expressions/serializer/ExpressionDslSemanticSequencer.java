package de.uni_hildesheim.sse.vil.expressions.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Advice;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ArgumentList;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ConstructorExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializer;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializerExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionOrQualifiedExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.NamedArgument;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.NumValue;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Parameter;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.PostfixExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedName;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedPrefix;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.SubCall;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.SuperExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeParameters;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnaryExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnqualifiedExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionSpec;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionStmt;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionedId;
import de.uni_hildesheim.sse.vil.expressions.services.ExpressionDslGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class ExpressionDslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ExpressionDslGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ExpressionDslPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ExpressionDslPackage.ADDITIVE_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule()) {
					sequence_AdditiveExpression(context, (AdditiveExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.ADDITIVE_EXPRESSION_PART:
				if(context == grammarAccess.getAdditiveExpressionPartRule()) {
					sequence_AdditiveExpressionPart(context, (AdditiveExpressionPart) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.ADVICE:
				if(context == grammarAccess.getAdviceRule()) {
					sequence_Advice(context, (Advice) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.ARGUMENT_LIST:
				if(context == grammarAccess.getArgumentListRule()) {
					sequence_ArgumentList(context, (ArgumentList) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.CALL:
				if(context == grammarAccess.getCallRule()) {
					sequence_Call(context, (Call) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.CONSTANT:
				if(context == grammarAccess.getConstantRule()) {
					sequence_Constant(context, (Constant) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.CONSTRUCTOR_EXECUTION:
				if(context == grammarAccess.getConstructorExecutionRule()) {
					sequence_ConstructorExecution(context, (ConstructorExecution) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.CONTAINER_INITIALIZER:
				if(context == grammarAccess.getContainerInitializerRule()) {
					sequence_ContainerInitializer(context, (ContainerInitializer) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION:
				if(context == grammarAccess.getContainerInitializerExpressionRule()) {
					sequence_ContainerInitializerExpression(context, (ContainerInitializerExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.EQUALITY_EXPRESSION:
				if(context == grammarAccess.getEqualityExpressionRule()) {
					sequence_EqualityExpression(context, (EqualityExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.EQUALITY_EXPRESSION_PART:
				if(context == grammarAccess.getEqualityExpressionPartRule()) {
					sequence_EqualityExpressionPart(context, (EqualityExpressionPart) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.EXPRESSION:
				if(context == grammarAccess.getExpressionRule()) {
					sequence_Expression(context, (Expression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.EXPRESSION_OR_QUALIFIED_EXECUTION:
				if(context == grammarAccess.getExpressionOrQualifiedExecutionRule()) {
					sequence_ExpressionOrQualifiedExecution(context, (ExpressionOrQualifiedExecution) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.EXPRESSION_STATEMENT:
				if(context == grammarAccess.getExpressionStatementRule()) {
					sequence_ExpressionStatement(context, (ExpressionStatement) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.IMPORT:
				if(context == grammarAccess.getImportRule()) {
					sequence_Import(context, (Import) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.LANGUAGE_UNIT:
				if(context == grammarAccess.getLanguageUnitRule()) {
					sequence_LanguageUnit(context, (LanguageUnit) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.LOGICAL_EXPRESSION:
				if(context == grammarAccess.getLogicalExpressionRule()) {
					sequence_LogicalExpression(context, (LogicalExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.LOGICAL_EXPRESSION_PART:
				if(context == grammarAccess.getLogicalExpressionPartRule()) {
					sequence_LogicalExpressionPart(context, (LogicalExpressionPart) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.MULTIPLICATIVE_EXPRESSION:
				if(context == grammarAccess.getMultiplicativeExpressionRule()) {
					sequence_MultiplicativeExpression(context, (MultiplicativeExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.MULTIPLICATIVE_EXPRESSION_PART:
				if(context == grammarAccess.getMultiplicativeExpressionPartRule()) {
					sequence_MultiplicativeExpressionPart(context, (MultiplicativeExpressionPart) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.NAMED_ARGUMENT:
				if(context == grammarAccess.getNamedArgumentRule()) {
					sequence_NamedArgument(context, (NamedArgument) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.NUM_VALUE:
				if(context == grammarAccess.getNumValueRule()) {
					sequence_NumValue(context, (NumValue) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.PARAMETER:
				if(context == grammarAccess.getParameterRule()) {
					sequence_Parameter(context, (Parameter) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.PARAMETER_LIST:
				if(context == grammarAccess.getParameterListRule()) {
					sequence_ParameterList(context, (ParameterList) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.POSTFIX_EXPRESSION:
				if(context == grammarAccess.getPostfixExpressionRule()) {
					sequence_PostfixExpression(context, (PostfixExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.PRIMARY_EXPRESSION:
				if(context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_PrimaryExpression(context, (PrimaryExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.QUALIFIED_NAME:
				if(context == grammarAccess.getQualifiedNameRule()) {
					sequence_QualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.QUALIFIED_PREFIX:
				if(context == grammarAccess.getQualifiedPrefixRule()) {
					sequence_QualifiedPrefix(context, (QualifiedPrefix) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.RELATIONAL_EXPRESSION:
				if(context == grammarAccess.getRelationalExpressionRule()) {
					sequence_RelationalExpression(context, (RelationalExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.RELATIONAL_EXPRESSION_PART:
				if(context == grammarAccess.getRelationalExpressionPartRule()) {
					sequence_RelationalExpressionPart(context, (RelationalExpressionPart) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.SUB_CALL:
				if(context == grammarAccess.getSubCallRule()) {
					sequence_SubCall(context, (SubCall) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.SUPER_EXECUTION:
				if(context == grammarAccess.getSuperExecutionRule()) {
					sequence_SuperExecution(context, (SuperExecution) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.TYPE:
				if(context == grammarAccess.getTypeRule()) {
					sequence_Type(context, (Type) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.TYPE_PARAMETERS:
				if(context == grammarAccess.getTypeParametersRule()) {
					sequence_TypeParameters(context, (TypeParameters) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.UNARY_EXPRESSION:
				if(context == grammarAccess.getUnaryExpressionRule()) {
					sequence_UnaryExpression(context, (UnaryExpression) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.UNQUALIFIED_EXECUTION:
				if(context == grammarAccess.getUnqualifiedExecutionRule()) {
					sequence_UnqualifiedExecution(context, (UnqualifiedExecution) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.VARIABLE_DECLARATION:
				if(context == grammarAccess.getVariableDeclarationRule()) {
					sequence_VariableDeclaration(context, (VariableDeclaration) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.VERSION_SPEC:
				if(context == grammarAccess.getVersionSpecRule()) {
					sequence_VersionSpec(context, (VersionSpec) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.VERSION_STMT:
				if(context == grammarAccess.getVersionStmtRule()) {
					sequence_VersionStmt(context, (VersionStmt) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.VERSIONED_ID:
				if(context == grammarAccess.getVersionedIdRule()) {
					sequence_VersionedId(context, (VersionedId) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (op=AdditiveOperator ex=MultiplicativeExpression)
	 */
	protected void sequence_AdditiveExpressionPart(EObject context, AdditiveExpressionPart semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.ADDITIVE_EXPRESSION_PART__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.ADDITIVE_EXPRESSION_PART__OP));
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.ADDITIVE_EXPRESSION_PART__EX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.ADDITIVE_EXPRESSION_PART__EX));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0(), semanticObject.getEx());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=MultiplicativeExpression right+=AdditiveExpressionPart*)
	 */
	protected void sequence_AdditiveExpression(EObject context, AdditiveExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=QualifiedName versionSpec=VersionSpec?)
	 */
	protected void sequence_Advice(EObject context, Advice semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (param+=NamedArgument param+=NamedArgument*)
	 */
	protected void sequence_ArgumentList(EObject context, ArgumentList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=QualifiedPrefix param=ArgumentList?)
	 */
	protected void sequence_Call(EObject context, Call semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (nValue=NumValue | sValue=STRING | qValue=QualifiedName | bValue='true' | bValue='false')
	 */
	protected void sequence_Constant(EObject context, Constant semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=Type param=ArgumentList? calls+=SubCall*)
	 */
	protected void sequence_ConstructorExecution(EObject context, ConstructorExecution semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (logical=LogicalExpression | container=ContainerInitializer)
	 */
	protected void sequence_ContainerInitializerExpression(EObject context, ContainerInitializerExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((exprs+=ContainerInitializerExpression exprs+=ContainerInitializerExpression*)?)
	 */
	protected void sequence_ContainerInitializer(EObject context, ContainerInitializer semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=EqualityOperator ex=RelationalExpression)
	 */
	protected void sequence_EqualityExpressionPart(EObject context, EqualityExpressionPart semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.EQUALITY_EXPRESSION_PART__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.EQUALITY_EXPRESSION_PART__OP));
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.EQUALITY_EXPRESSION_PART__EX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.EQUALITY_EXPRESSION_PART__EX));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0(), semanticObject.getEx());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=RelationalExpression right=EqualityExpressionPart?)
	 */
	protected void sequence_EqualityExpression(EObject context, EqualityExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((val=Constant | parenthesis=Expression) calls+=SubCall*)
	 */
	protected void sequence_ExpressionOrQualifiedExecution(EObject context, ExpressionOrQualifiedExecution semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (var=Identifier? expr=Expression)
	 */
	protected void sequence_ExpressionStatement(EObject context, ExpressionStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expr=LogicalExpression | init=ContainerInitializer)
	 */
	protected void sequence_Expression(EObject context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Identifier versionSpec=VersionSpec?)
	 */
	protected void sequence_Import(EObject context, Import semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (advices+=Advice* name=Identifier version=VersionStmt? imports+=Import*)
	 */
	protected void sequence_LanguageUnit(EObject context, LanguageUnit semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=LogicalOperator ex=EqualityExpression)
	 */
	protected void sequence_LogicalExpressionPart(EObject context, LogicalExpressionPart semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.LOGICAL_EXPRESSION_PART__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.LOGICAL_EXPRESSION_PART__OP));
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.LOGICAL_EXPRESSION_PART__EX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.LOGICAL_EXPRESSION_PART__EX));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0(), semanticObject.getEx());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=EqualityExpression right+=LogicalExpressionPart*)
	 */
	protected void sequence_LogicalExpression(EObject context, LogicalExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=MultiplicativeOperator expr=UnaryExpression)
	 */
	protected void sequence_MultiplicativeExpressionPart(EObject context, MultiplicativeExpressionPart semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.MULTIPLICATIVE_EXPRESSION_PART__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.MULTIPLICATIVE_EXPRESSION_PART__OP));
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.MULTIPLICATIVE_EXPRESSION_PART__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.MULTIPLICATIVE_EXPRESSION_PART__EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=UnaryExpression right=MultiplicativeExpressionPart?)
	 */
	protected void sequence_MultiplicativeExpression(EObject context, MultiplicativeExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Identifier? ex=Expression)
	 */
	protected void sequence_NamedArgument(EObject context, NamedArgument semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     val=NUMBER
	 */
	protected void sequence_NumValue(EObject context, NumValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.NUM_VALUE__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.NUM_VALUE__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNumValueAccess().getValNUMBERTerminalRuleCall_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (param+=Parameter param+=Parameter*)
	 */
	protected void sequence_ParameterList(EObject context, ParameterList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=Type name=Identifier)
	 */
	protected void sequence_Parameter(EObject context, Parameter semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.PARAMETER__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.PARAMETER__TYPE));
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.PARAMETER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.PARAMETER__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     left=PrimaryExpression
	 */
	protected void sequence_PostfixExpression(EObject context, PostfixExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.POSTFIX_EXPRESSION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.POSTFIX_EXPRESSION__LEFT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_0(), semanticObject.getLeft());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (otherEx=ExpressionOrQualifiedExecution | unqEx=UnqualifiedExecution | superEx=SuperExecution | newEx=ConstructorExecution)
	 */
	protected void sequence_PrimaryExpression(EObject context, PrimaryExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (prefix=QualifiedPrefix (qname+='.' qname+=Identifier)?)
	 */
	protected void sequence_QualifiedName(EObject context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (qname+=Identifier (qname+='::' qname+=Identifier)*)
	 */
	protected void sequence_QualifiedPrefix(EObject context, QualifiedPrefix semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=RelationalOperator ex=AdditiveExpression)
	 */
	protected void sequence_RelationalExpressionPart(EObject context, RelationalExpressionPart semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.RELATIONAL_EXPRESSION_PART__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.RELATIONAL_EXPRESSION_PART__OP));
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.RELATIONAL_EXPRESSION_PART__EX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.RELATIONAL_EXPRESSION_PART__EX));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0(), semanticObject.getEx());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=AdditiveExpression right=RelationalExpressionPart?)
	 */
	protected void sequence_RelationalExpression(EObject context, RelationalExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (call=Call | arrayEx=Expression)
	 */
	protected void sequence_SubCall(EObject context, SubCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (call=Call calls+=SubCall*)
	 */
	protected void sequence_SuperExecution(EObject context, SuperExecution semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (param+=Identifier param+=Identifier*)
	 */
	protected void sequence_TypeParameters(EObject context, TypeParameters semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Identifier | (set='setOf' param=TypeParameters) | (seq='sequenceOf' param=TypeParameters) | (map='mapOf' param=TypeParameters))
	 */
	protected void sequence_Type(EObject context, Type semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=UnaryOperator? expr=PostfixExpression)
	 */
	protected void sequence_UnaryExpression(EObject context, UnaryExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (call=Call calls+=SubCall*)
	 */
	protected void sequence_UnqualifiedExecution(EObject context, UnqualifiedExecution semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (const='const'? type=Type name=Identifier expression=Expression?)
	 */
	protected void sequence_VariableDeclaration(EObject context, VariableDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (conflicts+=VersionedId conflicts+=VersionedId*)
	 */
	protected void sequence_VersionSpec(EObject context, VersionSpec semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     version=VERSION
	 */
	protected void sequence_VersionStmt(EObject context, VersionStmt semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.VERSION_STMT__VERSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.VERSION_STMT__VERSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVersionStmtAccess().getVersionVERSIONTerminalRuleCall_1_0(), semanticObject.getVersion());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (op=VersionOperator version=VERSION)
	 */
	protected void sequence_VersionedId(EObject context, VersionedId semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.VERSIONED_ID__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.VERSIONED_ID__OP));
			if(transientValues.isValueTransient(semanticObject, ExpressionDslPackage.Literals.VERSIONED_ID__VERSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExpressionDslPackage.Literals.VERSIONED_ID__VERSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVersionedIdAccess().getOpVersionOperatorParserRuleCall_1_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getVersionedIdAccess().getVersionVERSIONTerminalRuleCall_2_0(), semanticObject.getVersion());
		feeder.finish();
	}
}
