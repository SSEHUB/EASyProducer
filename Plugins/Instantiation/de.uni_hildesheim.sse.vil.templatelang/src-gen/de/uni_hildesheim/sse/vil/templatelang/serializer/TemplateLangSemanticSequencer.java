package de.uni_hildesheim.sse.vil.templatelang.serializer;

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
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Declaration;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.DeclarationUnit;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Declarator;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionOrQualifiedExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import;
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
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeParameters;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnaryExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnqualifiedExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionSpec;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionStmt;
import de.uni_hildesheim.sse.vil.expressions.serializer.ExpressionDslSemanticSequencer;
import de.uni_hildesheim.sse.vil.templatelang.services.TemplateLangGrammarAccess;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Alternative;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Content;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Extension;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHint;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHintPart;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.JavaQualifiedName;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.StmtBlock;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Switch;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.SwitchPart;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.multiSelectPart;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.multiselect;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.userMultiselect;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class TemplateLangSemanticSequencer extends ExpressionDslSemanticSequencer {

	@Inject
	private TemplateLangGrammarAccess grammarAccess;
	
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
			case ExpressionDslPackage.DECLARATION:
				if(context == grammarAccess.getDeclarationRule()) {
					sequence_Declaration(context, (Declaration) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.DECLARATION_UNIT:
				if(context == grammarAccess.getDeclarationUnitRule()) {
					sequence_DeclarationUnit(context, (DeclarationUnit) semanticObject); 
					return; 
				}
				else break;
			case ExpressionDslPackage.DECLARATOR:
				if(context == grammarAccess.getDeclaratorRule()) {
					sequence_Declarator(context, (Declarator) semanticObject); 
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
			case ExpressionDslPackage.TYPE_DEF:
				if(context == grammarAccess.getTypeDefRule()) {
					sequence_TypeDef(context, (TypeDef) semanticObject); 
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
			}
		else if(semanticObject.eClass().getEPackage() == TemplateLangPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TemplateLangPackage.ALTERNATIVE:
				if(context == grammarAccess.getAlternativeRule()) {
					sequence_Alternative(context, (Alternative) semanticObject); 
					return; 
				}
				else break;
			case TemplateLangPackage.CONTENT:
				if(context == grammarAccess.getContentRule()) {
					sequence_Content(context, (Content) semanticObject); 
					return; 
				}
				else break;
			case TemplateLangPackage.EXTENSION:
				if(context == grammarAccess.getExtensionRule()) {
					sequence_Extension(context, (Extension) semanticObject); 
					return; 
				}
				else break;
			case TemplateLangPackage.INDENTATION_HINT:
				if(context == grammarAccess.getIndentationHintRule()) {
					sequence_IndentationHint(context, (IndentationHint) semanticObject); 
					return; 
				}
				else break;
			case TemplateLangPackage.INDENTATION_HINT_PART:
				if(context == grammarAccess.getIndentationHintPartRule()) {
					sequence_IndentationHintPart(context, (IndentationHintPart) semanticObject); 
					return; 
				}
				else break;
			case TemplateLangPackage.JAVA_QUALIFIED_NAME:
				if(context == grammarAccess.getJavaQualifiedNameRule()) {
					sequence_JavaQualifiedName(context, (JavaQualifiedName) semanticObject); 
					return; 
				}
				else break;
			case TemplateLangPackage.LANGUAGE_UNIT:
				if(context == grammarAccess.getLanguageUnitRule()) {
					sequence_LanguageUnit(context, (LanguageUnit) semanticObject); 
					return; 
				}
				else break;
			case TemplateLangPackage.LOOP:
				if(context == grammarAccess.getLoopRule()) {
					sequence_Loop(context, (Loop) semanticObject); 
					return; 
				}
				else break;
			case TemplateLangPackage.STMT:
				if(context == grammarAccess.getStmtRule()) {
					sequence_Stmt(context, (Stmt) semanticObject); 
					return; 
				}
				else break;
			case TemplateLangPackage.STMT_BLOCK:
				if(context == grammarAccess.getStmtBlockRule()) {
					sequence_StmtBlock(context, (StmtBlock) semanticObject); 
					return; 
				}
				else break;
			case TemplateLangPackage.SWITCH:
				if(context == grammarAccess.getSwitchRule()) {
					sequence_Switch(context, (Switch) semanticObject); 
					return; 
				}
				else break;
			case TemplateLangPackage.SWITCH_PART:
				if(context == grammarAccess.getSwitchPartRule()) {
					sequence_SwitchPart(context, (SwitchPart) semanticObject); 
					return; 
				}
				else break;
			case TemplateLangPackage.VIL_DEF:
				if(context == grammarAccess.getVilDefRule()) {
					sequence_VilDef(context, (VilDef) semanticObject); 
					return; 
				}
				else break;
			case TemplateLangPackage.GENERIC_MULTISELECT:
				if(context == grammarAccess.getGenericMultiselectRule()) {
					sequence_genericMultiselect(context, (genericMultiselect) semanticObject); 
					return; 
				}
				else break;
			case TemplateLangPackage.MULTI_SELECT_PART:
				if(context == grammarAccess.getMultiSelectPartRule()) {
					sequence_multiSelectPart(context, (multiSelectPart) semanticObject); 
					return; 
				}
				else break;
			case TemplateLangPackage.MULTISELECT:
				if(context == grammarAccess.getMultiselectRule()) {
					sequence_multiselect(context, (multiselect) semanticObject); 
					return; 
				}
				else break;
			case TemplateLangPackage.USER_MULTISELECT:
				if(context == grammarAccess.getUserMultiselectRule()) {
					sequence_userMultiselect(context, (userMultiselect) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (expr=Expression if=Stmt else=Stmt?)
	 */
	protected void sequence_Alternative(EObject context, Alternative semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (print='print'? ctn=STRING indent=Expression?)
	 */
	protected void sequence_Content(EObject context, Content semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=JavaQualifiedName
	 */
	protected void sequence_Extension(EObject context, Extension semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TemplateLangPackage.Literals.EXTENSION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TemplateLangPackage.Literals.EXTENSION__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExtensionAccess().getNameJavaQualifiedNameParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=Identifier value=NUMBER)
	 */
	protected void sequence_IndentationHintPart(EObject context, IndentationHintPart semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TemplateLangPackage.Literals.INDENTATION_HINT_PART__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TemplateLangPackage.Literals.INDENTATION_HINT_PART__NAME));
			if(transientValues.isValueTransient(semanticObject, TemplateLangPackage.Literals.INDENTATION_HINT_PART__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TemplateLangPackage.Literals.INDENTATION_HINT_PART__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIndentationHintPartAccess().getNameIdentifierParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getIndentationHintPartAccess().getValueNUMBERTerminalRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (parts+=IndentationHintPart parts+=IndentationHintPart*)
	 */
	protected void sequence_IndentationHint(EObject context, IndentationHint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (qname+=Identifier (qname+='.' qname+=Identifier)*)
	 */
	protected void sequence_JavaQualifiedName(EObject context, JavaQualifiedName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         imports+=Import* 
	 *         javaExts+=Extension* 
	 *         advices+=Advice* 
	 *         indent=IndentationHint? 
	 *         name=Identifier 
	 *         param=ParameterList? 
	 *         ext=Identifier? 
	 *         version=VersionStmt? 
	 *         typeDefs+=TypeDef* 
	 *         vars+=VariableDeclaration* 
	 *         defs+=VilDef*
	 *     )
	 */
	protected void sequence_LanguageUnit(EObject context, LanguageUnit semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=Type id=Identifier expr=Expression (separator=PrimaryExpression finalSeparator=PrimaryExpression?)? stmt=Stmt)
	 */
	protected void sequence_Loop(EObject context, Loop semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (stmts+=Stmt*)
	 */
	protected void sequence_StmtBlock(EObject context, StmtBlock semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         var=VariableDeclaration | 
	 *         alt=Alternative | 
	 *         switch=Switch | 
	 *         block=StmtBlock | 
	 *         multi=multiselect | 
	 *         loop=Loop | 
	 *         exprStmt=ExpressionStatement | 
	 *         ctn=Content
	 *     )
	 */
	protected void sequence_Stmt(EObject context, Stmt semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Expression right=Expression)
	 */
	protected void sequence_SwitchPart(EObject context, SwitchPart semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TemplateLangPackage.Literals.SWITCH_PART__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TemplateLangPackage.Literals.SWITCH_PART__LEFT));
			if(transientValues.isValueTransient(semanticObject, TemplateLangPackage.Literals.SWITCH_PART__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TemplateLangPackage.Literals.SWITCH_PART__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSwitchPartAccess().getLeftExpressionParserRuleCall_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getSwitchPartAccess().getRightExpressionParserRuleCall_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (expr=Expression parts+=SwitchPart parts+=SwitchPart* dflt=Expression?)
	 */
	protected void sequence_Switch(EObject context, Switch semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (protected='protected'? type=Type? id=Identifier param=ParameterList? stmts=StmtBlock)
	 */
	protected void sequence_VilDef(EObject context, VilDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (preamble=StmtBlock selector=StmtBlock part+=multiSelectPart+ trailer=StmtBlock)
	 */
	protected void sequence_genericMultiselect(EObject context, genericMultiselect semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (case=Expression code=StmtBlock selector=StmtBlock)
	 */
	protected void sequence_multiSelectPart(EObject context, multiSelectPart semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TemplateLangPackage.Literals.MULTI_SELECT_PART__CASE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TemplateLangPackage.Literals.MULTI_SELECT_PART__CASE));
			if(transientValues.isValueTransient(semanticObject, TemplateLangPackage.Literals.MULTI_SELECT_PART__CODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TemplateLangPackage.Literals.MULTI_SELECT_PART__CODE));
			if(transientValues.isValueTransient(semanticObject, TemplateLangPackage.Literals.MULTI_SELECT_PART__SELECTOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TemplateLangPackage.Literals.MULTI_SELECT_PART__SELECTOR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMultiSelectPartAccess().getCaseExpressionParserRuleCall_1_0(), semanticObject.getCase());
		feeder.accept(grammarAccess.getMultiSelectPartAccess().getCodeStmtBlockParserRuleCall_2_0(), semanticObject.getCode());
		feeder.accept(grammarAccess.getMultiSelectPartAccess().getSelectorStmtBlockParserRuleCall_3_0(), semanticObject.getSelector());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (gen=genericMultiselect | user=userMultiselect)
	 */
	protected void sequence_multiselect(EObject context, multiselect semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (id=Identifier stmt=StmtBlock)
	 */
	protected void sequence_userMultiselect(EObject context, userMultiselect semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TemplateLangPackage.Literals.USER_MULTISELECT__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TemplateLangPackage.Literals.USER_MULTISELECT__ID));
			if(transientValues.isValueTransient(semanticObject, TemplateLangPackage.Literals.USER_MULTISELECT__STMT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TemplateLangPackage.Literals.USER_MULTISELECT__STMT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUserMultiselectAccess().getIdIdentifierParserRuleCall_0_0(), semanticObject.getId());
		feeder.accept(grammarAccess.getUserMultiselectAccess().getStmtStmtBlockParserRuleCall_3_0(), semanticObject.getStmt());
		feeder.finish();
	}
}
