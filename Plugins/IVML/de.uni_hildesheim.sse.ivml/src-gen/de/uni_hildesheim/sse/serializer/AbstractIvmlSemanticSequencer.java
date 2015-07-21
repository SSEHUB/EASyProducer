package de.uni_hildesheim.sse.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import de.uni_hildesheim.sse.ivml.AccessName;
import de.uni_hildesheim.sse.ivml.ActualParameterList;
import de.uni_hildesheim.sse.ivml.AdditiveExpression;
import de.uni_hildesheim.sse.ivml.AdditiveExpressionPart;
import de.uni_hildesheim.sse.ivml.AnnotateTo;
import de.uni_hildesheim.sse.ivml.AssignmentExpression;
import de.uni_hildesheim.sse.ivml.AssignmentExpressionPart;
import de.uni_hildesheim.sse.ivml.AttrAssignment;
import de.uni_hildesheim.sse.ivml.AttrAssignmentPart;
import de.uni_hildesheim.sse.ivml.BasicType;
import de.uni_hildesheim.sse.ivml.Call;
import de.uni_hildesheim.sse.ivml.CollectionInitializer;
import de.uni_hildesheim.sse.ivml.ConflictStmt;
import de.uni_hildesheim.sse.ivml.Declaration;
import de.uni_hildesheim.sse.ivml.Declarator;
import de.uni_hildesheim.sse.ivml.DerivedType;
import de.uni_hildesheim.sse.ivml.EqualityExpression;
import de.uni_hildesheim.sse.ivml.EqualityExpressionPart;
import de.uni_hildesheim.sse.ivml.Eval;
import de.uni_hildesheim.sse.ivml.Export;
import de.uni_hildesheim.sse.ivml.Expression;
import de.uni_hildesheim.sse.ivml.ExpressionAccess;
import de.uni_hildesheim.sse.ivml.ExpressionListEntry;
import de.uni_hildesheim.sse.ivml.ExpressionListOrRange;
import de.uni_hildesheim.sse.ivml.ExpressionStatement;
import de.uni_hildesheim.sse.ivml.FeatureCall;
import de.uni_hildesheim.sse.ivml.Freeze;
import de.uni_hildesheim.sse.ivml.FreezeStatement;
import de.uni_hildesheim.sse.ivml.IfExpression;
import de.uni_hildesheim.sse.ivml.ImplicationExpression;
import de.uni_hildesheim.sse.ivml.ImplicationExpressionPart;
import de.uni_hildesheim.sse.ivml.ImportStmt;
import de.uni_hildesheim.sse.ivml.InterfaceDeclaration;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.LetExpression;
import de.uni_hildesheim.sse.ivml.Literal;
import de.uni_hildesheim.sse.ivml.LogicalExpression;
import de.uni_hildesheim.sse.ivml.LogicalExpressionPart;
import de.uni_hildesheim.sse.ivml.MultiplicativeExpression;
import de.uni_hildesheim.sse.ivml.MultiplicativeExpressionPart;
import de.uni_hildesheim.sse.ivml.NumValue;
import de.uni_hildesheim.sse.ivml.OpDefParameter;
import de.uni_hildesheim.sse.ivml.OpDefParameterList;
import de.uni_hildesheim.sse.ivml.OpDefStatement;
import de.uni_hildesheim.sse.ivml.PostfixExpression;
import de.uni_hildesheim.sse.ivml.PrimaryExpression;
import de.uni_hildesheim.sse.ivml.Project;
import de.uni_hildesheim.sse.ivml.ProjectContents;
import de.uni_hildesheim.sse.ivml.QualifiedName;
import de.uni_hildesheim.sse.ivml.RelationalExpression;
import de.uni_hildesheim.sse.ivml.RelationalExpressionPart;
import de.uni_hildesheim.sse.ivml.SetOp;
import de.uni_hildesheim.sse.ivml.Type;
import de.uni_hildesheim.sse.ivml.Typedef;
import de.uni_hildesheim.sse.ivml.TypedefCompound;
import de.uni_hildesheim.sse.ivml.TypedefConstraint;
import de.uni_hildesheim.sse.ivml.TypedefEnum;
import de.uni_hildesheim.sse.ivml.TypedefEnumLiteral;
import de.uni_hildesheim.sse.ivml.TypedefMapping;
import de.uni_hildesheim.sse.ivml.UnaryExpression;
import de.uni_hildesheim.sse.ivml.Value;
import de.uni_hildesheim.sse.ivml.VariabilityUnit;
import de.uni_hildesheim.sse.ivml.VariableDeclaration;
import de.uni_hildesheim.sse.ivml.VariableDeclarationPart;
import de.uni_hildesheim.sse.ivml.VersionStmt;
import de.uni_hildesheim.sse.services.IvmlGrammarAccess;
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
public abstract class AbstractIvmlSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private IvmlGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == IvmlPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case IvmlPackage.ACCESS_NAME:
				if(context == grammarAccess.getAccessNameRule()) {
					sequence_AccessName(context, (AccessName) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.ACTUAL_PARAMETER_LIST:
				if(context == grammarAccess.getActualParameterListRule()) {
					sequence_ActualParameterList(context, (ActualParameterList) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.ADDITIVE_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule()) {
					sequence_AdditiveExpression(context, (AdditiveExpression) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.ADDITIVE_EXPRESSION_PART:
				if(context == grammarAccess.getAdditiveExpressionPartRule()) {
					sequence_AdditiveExpressionPart(context, (AdditiveExpressionPart) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.ANNOTATE_TO:
				if(context == grammarAccess.getAnnotateToRule()) {
					sequence_AnnotateTo(context, (AnnotateTo) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.ASSIGNMENT_EXPRESSION:
				if(context == grammarAccess.getAssignmentExpressionRule()) {
					sequence_AssignmentExpression(context, (AssignmentExpression) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.ASSIGNMENT_EXPRESSION_PART:
				if(context == grammarAccess.getAssignmentExpressionPartRule()) {
					sequence_AssignmentExpressionPart(context, (AssignmentExpressionPart) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.ATTR_ASSIGNMENT:
				if(context == grammarAccess.getAttrAssignmentRule()) {
					sequence_AttrAssignment(context, (AttrAssignment) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.ATTR_ASSIGNMENT_PART:
				if(context == grammarAccess.getAttrAssignmentPartRule()) {
					sequence_AttrAssignmentPart(context, (AttrAssignmentPart) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.BASIC_TYPE:
				if(context == grammarAccess.getBasicTypeRule()) {
					sequence_BasicType(context, (BasicType) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.CALL:
				if(context == grammarAccess.getCallRule()) {
					sequence_Call(context, (Call) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.COLLECTION_INITIALIZER:
				if(context == grammarAccess.getCollectionInitializerRule()) {
					sequence_CollectionInitializer(context, (CollectionInitializer) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.CONFLICT_STMT:
				if(context == grammarAccess.getConflictStmtRule()) {
					sequence_ConflictStmt(context, (ConflictStmt) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.DECLARATION:
				if(context == grammarAccess.getDeclarationRule()) {
					sequence_Declaration(context, (Declaration) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.DECLARATOR:
				if(context == grammarAccess.getDeclaratorRule()) {
					sequence_Declarator(context, (Declarator) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.DERIVED_TYPE:
				if(context == grammarAccess.getDerivedTypeRule()) {
					sequence_DerivedType(context, (DerivedType) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.EQUALITY_EXPRESSION:
				if(context == grammarAccess.getEqualityExpressionRule()) {
					sequence_EqualityExpression(context, (EqualityExpression) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.EQUALITY_EXPRESSION_PART:
				if(context == grammarAccess.getEqualityExpressionPartRule()) {
					sequence_EqualityExpressionPart(context, (EqualityExpressionPart) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.EVAL:
				if(context == grammarAccess.getEvalRule()) {
					sequence_Eval(context, (Eval) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.EXPORT:
				if(context == grammarAccess.getExportRule()) {
					sequence_Export(context, (Export) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.EXPRESSION:
				if(context == grammarAccess.getExpressionRule()) {
					sequence_Expression(context, (Expression) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.EXPRESSION_ACCESS:
				if(context == grammarAccess.getExpressionAccessRule()) {
					sequence_ExpressionAccess(context, (ExpressionAccess) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.EXPRESSION_LIST_ENTRY:
				if(context == grammarAccess.getExpressionListEntryRule()) {
					sequence_ExpressionListEntry(context, (ExpressionListEntry) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.EXPRESSION_LIST_OR_RANGE:
				if(context == grammarAccess.getExpressionListOrRangeRule()) {
					sequence_ExpressionListOrRange(context, (ExpressionListOrRange) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.EXPRESSION_STATEMENT:
				if(context == grammarAccess.getExpressionStatementRule()) {
					sequence_ExpressionStatement(context, (ExpressionStatement) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.FEATURE_CALL:
				if(context == grammarAccess.getFeatureCallRule()) {
					sequence_FeatureCall(context, (FeatureCall) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.FREEZE:
				if(context == grammarAccess.getFreezeRule()) {
					sequence_Freeze(context, (Freeze) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.FREEZE_STATEMENT:
				if(context == grammarAccess.getFreezeStatementRule()) {
					sequence_FreezeStatement(context, (FreezeStatement) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.IF_EXPRESSION:
				if(context == grammarAccess.getIfExpressionRule()) {
					sequence_IfExpression(context, (IfExpression) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.IMPLICATION_EXPRESSION:
				if(context == grammarAccess.getImplicationExpressionRule()) {
					sequence_ImplicationExpression(context, (ImplicationExpression) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.IMPLICATION_EXPRESSION_PART:
				if(context == grammarAccess.getImplicationExpressionPartRule()) {
					sequence_ImplicationExpressionPart(context, (ImplicationExpressionPart) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.IMPORT_STMT:
				if(context == grammarAccess.getImportStmtRule()) {
					sequence_ImportStmt(context, (ImportStmt) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.INTERFACE_DECLARATION:
				if(context == grammarAccess.getInterfaceDeclarationRule()) {
					sequence_InterfaceDeclaration(context, (InterfaceDeclaration) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.LET_EXPRESSION:
				if(context == grammarAccess.getLetExpressionRule()) {
					sequence_LetExpression(context, (LetExpression) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.LITERAL:
				if(context == grammarAccess.getLiteralRule()) {
					sequence_Literal(context, (Literal) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.LOGICAL_EXPRESSION:
				if(context == grammarAccess.getLogicalExpressionRule()) {
					sequence_LogicalExpression(context, (LogicalExpression) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.LOGICAL_EXPRESSION_PART:
				if(context == grammarAccess.getLogicalExpressionPartRule()) {
					sequence_LogicalExpressionPart(context, (LogicalExpressionPart) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.MULTIPLICATIVE_EXPRESSION:
				if(context == grammarAccess.getMultiplicativeExpressionRule()) {
					sequence_MultiplicativeExpression(context, (MultiplicativeExpression) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.MULTIPLICATIVE_EXPRESSION_PART:
				if(context == grammarAccess.getMultiplicativeExpressionPartRule()) {
					sequence_MultiplicativeExpressionPart(context, (MultiplicativeExpressionPart) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.NUM_VALUE:
				if(context == grammarAccess.getNumValueRule()) {
					sequence_NumValue(context, (NumValue) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.OP_DEF_PARAMETER:
				if(context == grammarAccess.getOpDefParameterRule()) {
					sequence_OpDefParameter(context, (OpDefParameter) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.OP_DEF_PARAMETER_LIST:
				if(context == grammarAccess.getOpDefParameterListRule()) {
					sequence_OpDefParameterList(context, (OpDefParameterList) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.OP_DEF_STATEMENT:
				if(context == grammarAccess.getOpDefStatementRule()) {
					sequence_OpDefStatement(context, (OpDefStatement) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.POSTFIX_EXPRESSION:
				if(context == grammarAccess.getPostfixExpressionRule()) {
					sequence_PostfixExpression(context, (PostfixExpression) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.PRIMARY_EXPRESSION:
				if(context == grammarAccess.getPrimaryExpressionRule()) {
					sequence_PrimaryExpression(context, (PrimaryExpression) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.PROJECT:
				if(context == grammarAccess.getProjectRule()) {
					sequence_Project(context, (Project) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.PROJECT_CONTENTS:
				if(context == grammarAccess.getProjectContentsRule()) {
					sequence_ProjectContents(context, (ProjectContents) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.QUALIFIED_NAME:
				if(context == grammarAccess.getQualifiedNameRule()) {
					sequence_QualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.RELATIONAL_EXPRESSION:
				if(context == grammarAccess.getRelationalExpressionRule()) {
					sequence_RelationalExpression(context, (RelationalExpression) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.RELATIONAL_EXPRESSION_PART:
				if(context == grammarAccess.getRelationalExpressionPartRule()) {
					sequence_RelationalExpressionPart(context, (RelationalExpressionPart) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.SET_OP:
				if(context == grammarAccess.getSetOpRule()) {
					sequence_SetOp(context, (SetOp) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.TYPE:
				if(context == grammarAccess.getTypeRule()) {
					sequence_Type(context, (Type) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.TYPEDEF:
				if(context == grammarAccess.getTypedefRule()) {
					sequence_Typedef(context, (Typedef) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.TYPEDEF_COMPOUND:
				if(context == grammarAccess.getTypedefCompoundRule()) {
					sequence_TypedefCompound(context, (TypedefCompound) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.TYPEDEF_CONSTRAINT:
				if(context == grammarAccess.getTypedefConstraintRule()) {
					sequence_TypedefConstraint(context, (TypedefConstraint) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.TYPEDEF_ENUM:
				if(context == grammarAccess.getTypedefEnumRule()) {
					sequence_TypedefEnum(context, (TypedefEnum) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.TYPEDEF_ENUM_LITERAL:
				if(context == grammarAccess.getTypedefEnumLiteralRule()) {
					sequence_TypedefEnumLiteral(context, (TypedefEnumLiteral) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.TYPEDEF_MAPPING:
				if(context == grammarAccess.getTypedefMappingRule()) {
					sequence_TypedefMapping(context, (TypedefMapping) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.UNARY_EXPRESSION:
				if(context == grammarAccess.getUnaryExpressionRule()) {
					sequence_UnaryExpression(context, (UnaryExpression) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.VALUE:
				if(context == grammarAccess.getValueRule()) {
					sequence_Value(context, (Value) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.VARIABILITY_UNIT:
				if(context == grammarAccess.getVariabilityUnitRule()) {
					sequence_VariabilityUnit(context, (VariabilityUnit) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.VARIABLE_DECLARATION:
				if(context == grammarAccess.getVariableDeclarationRule()) {
					sequence_VariableDeclaration(context, (VariableDeclaration) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.VARIABLE_DECLARATION_PART:
				if(context == grammarAccess.getVariableDeclarationPartRule()) {
					sequence_VariableDeclarationPart(context, (VariableDeclarationPart) semanticObject); 
					return; 
				}
				else break;
			case IvmlPackage.VERSION_STMT:
				if(context == grammarAccess.getVersionStmtRule()) {
					sequence_VersionStmt(context, (VersionStmt) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (aName+='.' aName+=Identifier)+
	 */
	protected void sequence_AccessName(EObject context, AccessName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (param+=Expression param+=Expression*)
	 */
	protected void sequence_ActualParameterList(EObject context, ActualParameterList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=AdditiveOperator ex=MultiplicativeExpression)
	 */
	protected void sequence_AdditiveExpressionPart(EObject context, AdditiveExpressionPart semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.ADDITIVE_EXPRESSION_PART__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.ADDITIVE_EXPRESSION_PART__OP));
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.ADDITIVE_EXPRESSION_PART__EX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.ADDITIVE_EXPRESSION_PART__EX));
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
	 *     ((sname='attribute' | sname='annotate') annotationType=Type annotationDecl=VariableDeclarationPart names+=Identifier names+=Identifier*)
	 */
	protected void sequence_AnnotateTo(EObject context, AnnotateTo semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=AssignmentOperator (ex=LogicalExpression | collection=CollectionInitializer))
	 */
	protected void sequence_AssignmentExpressionPart(EObject context, AssignmentExpressionPart semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=LogicalExpression right+=AssignmentExpressionPart?)
	 */
	protected void sequence_AssignmentExpression(EObject context, AssignmentExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Identifier value=LogicalExpression)
	 */
	protected void sequence_AttrAssignmentPart(EObject context, AttrAssignmentPart semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.ATTR_ASSIGNMENT_PART__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.ATTR_ASSIGNMENT_PART__NAME));
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.ATTR_ASSIGNMENT_PART__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.ATTR_ASSIGNMENT_PART__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAttrAssignmentPartAccess().getNameIdentifierParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getAttrAssignmentPartAccess().getValueLogicalExpressionParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         parts+=AttrAssignmentPart 
	 *         parts+=AttrAssignmentPart* 
	 *         (elements+=VariableDeclaration | elements+=ExpressionStatement | elements+=AttrAssignment)+
	 *     )
	 */
	protected void sequence_AttrAssignment(EObject context, AttrAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type='Integer' | type='Real' | type='Boolean' | type='String' | type='Constraint')
	 */
	protected void sequence_BasicType(EObject context, BasicType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (call=FeatureCall | setOp=SetOp | arrayEx=Expression)
	 */
	protected void sequence_Call(EObject context, Call semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=QualifiedName? init=ExpressionListOrRange?)
	 */
	protected void sequence_CollectionInitializer(EObject context, CollectionInitializer semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Identifier restriction=Expression?)
	 */
	protected void sequence_ConflictStmt(EObject context, ConflictStmt semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=Type? id+=Identifier id+=Identifier* init=Expression?)
	 */
	protected void sequence_Declaration(EObject context, Declaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (decl+=Declaration decl+=Declaration*)
	 */
	protected void sequence_Declarator(EObject context, Declarator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((op='setOf' | op='sequenceOf' | op='refTo') type=Type)
	 */
	protected void sequence_DerivedType(EObject context, DerivedType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=EqualityOperator (ex=RelationalExpression | collection=CollectionInitializer))
	 */
	protected void sequence_EqualityExpressionPart(EObject context, EqualityExpressionPart semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
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
	 *     (nested+=Eval* statements+=ExpressionStatement+)
	 */
	protected void sequence_Eval(EObject context, Eval semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (names+=QualifiedName names+=QualifiedName*)
	 */
	protected void sequence_Export(EObject context, Export semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Identifier calls+=Call* access=ExpressionAccess?)
	 */
	protected void sequence_ExpressionAccess(EObject context, ExpressionAccess semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=Identifier attrib=Identifier?)? (value=LogicalExpression | collection=CollectionInitializer))
	 */
	protected void sequence_ExpressionListEntry(EObject context, ExpressionListEntry semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (list+=ExpressionListEntry list+=ExpressionListEntry*)
	 */
	protected void sequence_ExpressionListOrRange(EObject context, ExpressionListOrRange semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expr=Expression
	 */
	protected void sequence_ExpressionStatement(EObject context, ExpressionStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.EXPRESSION_STATEMENT__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.EXPRESSION_STATEMENT__EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_0_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (let=LetExpression | expr=ImplicationExpression | collection=CollectionInitializer)
	 */
	protected void sequence_Expression(EObject context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Identifier param=ActualParameterList?)
	 */
	protected void sequence_FeatureCall(EObject context, FeatureCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=QualifiedName access=AccessName?)
	 */
	protected void sequence_FreezeStatement(EObject context, FreezeStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (names+=FreezeStatement+ (id=Identifier ex=LogicalExpression)?)
	 */
	protected void sequence_Freeze(EObject context, Freeze semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ifEx=Expression thenEx=Expression elseEx=Expression)
	 */
	protected void sequence_IfExpression(EObject context, IfExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.IF_EXPRESSION__IF_EX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.IF_EXPRESSION__IF_EX));
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.IF_EXPRESSION__THEN_EX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.IF_EXPRESSION__THEN_EX));
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.IF_EXPRESSION__ELSE_EX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.IF_EXPRESSION__ELSE_EX));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIfExpressionAccess().getIfExExpressionParserRuleCall_1_0(), semanticObject.getIfEx());
		feeder.accept(grammarAccess.getIfExpressionAccess().getThenExExpressionParserRuleCall_3_0(), semanticObject.getThenEx());
		feeder.accept(grammarAccess.getIfExpressionAccess().getElseExExpressionParserRuleCall_5_0(), semanticObject.getElseEx());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (op=ImplicationOperator ex=AssignmentExpression)
	 */
	protected void sequence_ImplicationExpressionPart(EObject context, ImplicationExpressionPart semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.IMPLICATION_EXPRESSION_PART__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.IMPLICATION_EXPRESSION_PART__OP));
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.IMPLICATION_EXPRESSION_PART__EX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.IMPLICATION_EXPRESSION_PART__EX));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getImplicationExpressionPartAccess().getOpImplicationOperatorParserRuleCall_0_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getImplicationExpressionPartAccess().getExAssignmentExpressionParserRuleCall_1_0(), semanticObject.getEx());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=AssignmentExpression right+=ImplicationExpressionPart*)
	 */
	protected void sequence_ImplicationExpression(EObject context, ImplicationExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Identifier interface=Identifier? restriction=Expression?)
	 */
	protected void sequence_ImportStmt(EObject context, ImportStmt semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Identifier exports+=Export*)
	 */
	protected void sequence_InterfaceDeclaration(EObject context, InterfaceDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=Type name=Identifier valueExpr=Expression subExpr=Expression)
	 */
	protected void sequence_LetExpression(EObject context, LetExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.LET_EXPRESSION__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.LET_EXPRESSION__TYPE));
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.LET_EXPRESSION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.LET_EXPRESSION__NAME));
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.LET_EXPRESSION__VALUE_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.LET_EXPRESSION__VALUE_EXPR));
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.LET_EXPRESSION__SUB_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.LET_EXPRESSION__SUB_EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLetExpressionAccess().getTypeTypeParserRuleCall_1_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getLetExpressionAccess().getNameIdentifierParserRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getLetExpressionAccess().getValueExprExpressionParserRuleCall_4_0(), semanticObject.getValueExpr());
		feeder.accept(grammarAccess.getLetExpressionAccess().getSubExprExpressionParserRuleCall_6_0(), semanticObject.getSubExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     val=Value
	 */
	protected void sequence_Literal(EObject context, Literal semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.LITERAL__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.LITERAL__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLiteralAccess().getValValueParserRuleCall_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (op=LogicalOperator ex=EqualityExpression)
	 */
	protected void sequence_LogicalExpressionPart(EObject context, LogicalExpressionPart semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.LOGICAL_EXPRESSION_PART__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.LOGICAL_EXPRESSION_PART__OP));
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.LOGICAL_EXPRESSION_PART__EX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.LOGICAL_EXPRESSION_PART__EX));
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
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.MULTIPLICATIVE_EXPRESSION_PART__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.MULTIPLICATIVE_EXPRESSION_PART__OP));
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.MULTIPLICATIVE_EXPRESSION_PART__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.MULTIPLICATIVE_EXPRESSION_PART__EXPR));
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
	 *     val=NUMBER
	 */
	protected void sequence_NumValue(EObject context, NumValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.NUM_VALUE__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.NUM_VALUE__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNumValueAccess().getValNUMBERTerminalRuleCall_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((list+=OpDefParameter list+=OpDefParameter*)?)
	 */
	protected void sequence_OpDefParameterList(EObject context, OpDefParameterList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=Type id=Identifier val=Expression?)
	 */
	protected void sequence_OpDefParameter(EObject context, OpDefParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (result=Type id=Identifier param=OpDefParameterList impl=Expression)
	 */
	protected void sequence_OpDefStatement(EObject context, OpDefStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.OP_DEF_STATEMENT__RESULT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.OP_DEF_STATEMENT__RESULT));
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.OP_DEF_STATEMENT__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.OP_DEF_STATEMENT__ID));
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.OP_DEF_STATEMENT__PARAM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.OP_DEF_STATEMENT__PARAM));
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.OP_DEF_STATEMENT__IMPL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.OP_DEF_STATEMENT__IMPL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOpDefStatementAccess().getResultTypeParserRuleCall_1_0(), semanticObject.getResult());
		feeder.accept(grammarAccess.getOpDefStatementAccess().getIdIdentifierParserRuleCall_2_0(), semanticObject.getId());
		feeder.accept(grammarAccess.getOpDefStatementAccess().getParamOpDefParameterListParserRuleCall_4_0(), semanticObject.getParam());
		feeder.accept(grammarAccess.getOpDefStatementAccess().getImplExpressionParserRuleCall_7_0(), semanticObject.getImpl());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((call=FeatureCall fCalls+=Call* access=ExpressionAccess?) | left=PrimaryExpression)
	 */
	protected void sequence_PostfixExpression(EObject context, PostfixExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((lit=Literal | ex=Expression | ifEx=IfExpression | refName=Identifier) calls+=Call* access=ExpressionAccess?)
	 */
	protected void sequence_PrimaryExpression(EObject context, PrimaryExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             elements+=Typedef | 
	 *             elements+=VariableDeclaration | 
	 *             elements+=Freeze | 
	 *             elements+=Eval | 
	 *             elements+=ExpressionStatement | 
	 *             elements+=AnnotateTo | 
	 *             elements+=OpDefStatement | 
	 *             elements+=AttrAssignment
	 *         )*
	 *     )
	 */
	protected void sequence_ProjectContents(EObject context, ProjectContents semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=Identifier 
	 *         version=VersionStmt? 
	 *         imports+=ImportStmt* 
	 *         conflicts+=ConflictStmt* 
	 *         interfaces+=InterfaceDeclaration* 
	 *         contents=ProjectContents
	 *     )
	 */
	protected void sequence_Project(EObject context, Project semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((qName+=Identifier qName+='::' (qName+=Identifier qName+='::')*)? qName+=Identifier)
	 */
	protected void sequence_QualifiedName(EObject context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=RelationalOperator ex=AdditiveExpression)
	 */
	protected void sequence_RelationalExpressionPart(EObject context, RelationalExpressionPart semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.RELATIONAL_EXPRESSION_PART__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.RELATIONAL_EXPRESSION_PART__OP));
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.RELATIONAL_EXPRESSION_PART__EX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.RELATIONAL_EXPRESSION_PART__EX));
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
	 *     (name=Identifier decl=Declarator declEx=Expression?)
	 */
	protected void sequence_SetOp(EObject context, SetOp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=BasicType | id=QualifiedName | derived=DerivedType)
	 */
	protected void sequence_Type(EObject context, Type semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         abstract='abstract'? 
	 *         name=Identifier 
	 *         super=Identifier? 
	 *         (elements+=VariableDeclaration | elements+=ExpressionStatement | elements+=AttrAssignment)*
	 *     )
	 */
	protected void sequence_TypedefCompound(EObject context, TypedefCompound semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expressions+=Expression expressions+=Expression*)
	 */
	protected void sequence_TypedefConstraint(EObject context, TypedefConstraint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Identifier value=NumValue?)
	 */
	protected void sequence_TypedefEnumLiteral(EObject context, TypedefEnumLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Identifier literals+=TypedefEnumLiteral literals+=TypedefEnumLiteral* constraint=TypedefConstraint?)
	 */
	protected void sequence_TypedefEnum(EObject context, TypedefEnum semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (newType=Identifier type=Type constraint=TypedefConstraint?)
	 */
	protected void sequence_TypedefMapping(EObject context, TypedefMapping semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tEnum=TypedefEnum | tCompound=TypedefCompound | tMapping=TypedefMapping)
	 */
	protected void sequence_Typedef(EObject context, Typedef semanticObject) {
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
	 *     (
	 *         nValue=NumValue | 
	 *         sValue=STRING | 
	 *         qValue=QualifiedName | 
	 *         bValue='true' | 
	 *         bValue='false' | 
	 *         self='self' | 
	 *         nullValue='null' | 
	 *         version=VERSION
	 *     )
	 */
	protected void sequence_Value(EObject context, Value semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (projects+=Project*)
	 */
	protected void sequence_VariabilityUnit(EObject context, VariabilityUnit semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Identifier default=Expression?)
	 */
	protected void sequence_VariableDeclarationPart(EObject context, VariableDeclarationPart semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=Type decls+=VariableDeclarationPart decls+=VariableDeclarationPart*)
	 */
	protected void sequence_VariableDeclaration(EObject context, VariableDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     version=VERSION
	 */
	protected void sequence_VersionStmt(EObject context, VersionStmt semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, IvmlPackage.Literals.VERSION_STMT__VERSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IvmlPackage.Literals.VERSION_STMT__VERSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVersionStmtAccess().getVersionVERSIONTerminalRuleCall_1_0(), semanticObject.getVersion());
		feeder.finish();
	}
}
