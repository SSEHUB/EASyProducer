/**
 */
package de.uni_hildesheim.sse.vil.expressions.expressionDsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionDslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "expressionDsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.uni_hildesheim.de/sse/vil/expressions/ExpressionDsl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "expressionDsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ExpressionDslPackage eINSTANCE = de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl.init();

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.LanguageUnitImpl <em>Language Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.LanguageUnitImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getLanguageUnit()
   * @generated
   */
  int LANGUAGE_UNIT = 0;

  /**
   * The feature id for the '<em><b>Advices</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__ADVICES = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__NAME = 1;

  /**
   * The feature id for the '<em><b>Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__VERSION = 2;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__IMPORTS = 3;

  /**
   * The number of structural features of the '<em>Language Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.VariableDeclarationImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getVariableDeclaration()
   * @generated
   */
  int VARIABLE_DECLARATION = 1;

  /**
   * The feature id for the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__CONST = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__TYPE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__NAME = 2;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__EXPRESSION = 3;

  /**
   * The number of structural features of the '<em>Variable Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeDefImpl <em>Type Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeDefImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getTypeDef()
   * @generated
   */
  int TYPE_DEF = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEF__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEF__TYPE = 1;

  /**
   * The number of structural features of the '<em>Type Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.AdviceImpl <em>Advice</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.AdviceImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getAdvice()
   * @generated
   */
  int ADVICE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADVICE__NAME = 0;

  /**
   * The feature id for the '<em><b>Version Spec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADVICE__VERSION_SPEC = 1;

  /**
   * The number of structural features of the '<em>Advice</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADVICE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.VersionSpecImpl <em>Version Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.VersionSpecImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getVersionSpec()
   * @generated
   */
  int VERSION_SPEC = 4;

  /**
   * The feature id for the '<em><b>Restriction</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERSION_SPEC__RESTRICTION = 0;

  /**
   * The number of structural features of the '<em>Version Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERSION_SPEC_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ParameterListImpl <em>Parameter List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ParameterListImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getParameterList()
   * @generated
   */
  int PARAMETER_LIST = 5;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_LIST__PARAM = 0;

  /**
   * The number of structural features of the '<em>Parameter List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ParameterImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 6;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__NAME = 1;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.VersionStmtImpl <em>Version Stmt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.VersionStmtImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getVersionStmt()
   * @generated
   */
  int VERSION_STMT = 7;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERSION_STMT__VERSION = 0;

  /**
   * The number of structural features of the '<em>Version Stmt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERSION_STMT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ImportImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__NAME = 0;

  /**
   * The feature id for the '<em><b>Version Spec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__VERSION_SPEC = 1;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionStatementImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getExpressionStatement()
   * @generated
   */
  int EXPRESSION_STATEMENT = 9;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT__VAR = 0;

  /**
   * The feature id for the '<em><b>Field</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT__FIELD = 1;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT__EXPR = 2;

  /**
   * The number of structural features of the '<em>Expression Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 10;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EXPR = 0;

  /**
   * The feature id for the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__INIT = 1;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.LogicalExpressionImpl <em>Logical Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.LogicalExpressionImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getLogicalExpression()
   * @generated
   */
  int LOGICAL_EXPRESSION = 11;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION__RIGHT = 1;

  /**
   * The number of structural features of the '<em>Logical Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.LogicalExpressionPartImpl <em>Logical Expression Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.LogicalExpressionPartImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getLogicalExpressionPart()
   * @generated
   */
  int LOGICAL_EXPRESSION_PART = 12;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION_PART__OP = 0;

  /**
   * The feature id for the '<em><b>Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION_PART__EX = 1;

  /**
   * The number of structural features of the '<em>Logical Expression Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_EXPRESSION_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.EqualityExpressionImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getEqualityExpression()
   * @generated
   */
  int EQUALITY_EXPRESSION = 13;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__RIGHT = 1;

  /**
   * The number of structural features of the '<em>Equality Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.EqualityExpressionPartImpl <em>Equality Expression Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.EqualityExpressionPartImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getEqualityExpressionPart()
   * @generated
   */
  int EQUALITY_EXPRESSION_PART = 14;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_PART__OP = 0;

  /**
   * The feature id for the '<em><b>Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_PART__EX = 1;

  /**
   * The number of structural features of the '<em>Equality Expression Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.RelationalExpressionImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getRelationalExpression()
   * @generated
   */
  int RELATIONAL_EXPRESSION = 15;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__RIGHT = 1;

  /**
   * The number of structural features of the '<em>Relational Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.RelationalExpressionPartImpl <em>Relational Expression Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.RelationalExpressionPartImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getRelationalExpressionPart()
   * @generated
   */
  int RELATIONAL_EXPRESSION_PART = 16;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_PART__OP = 0;

  /**
   * The feature id for the '<em><b>Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_PART__EX = 1;

  /**
   * The number of structural features of the '<em>Relational Expression Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.AdditiveExpressionImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getAdditiveExpression()
   * @generated
   */
  int ADDITIVE_EXPRESSION = 17;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__RIGHT = 1;

  /**
   * The number of structural features of the '<em>Additive Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.AdditiveExpressionPartImpl <em>Additive Expression Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.AdditiveExpressionPartImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getAdditiveExpressionPart()
   * @generated
   */
  int ADDITIVE_EXPRESSION_PART = 18;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_PART__OP = 0;

  /**
   * The feature id for the '<em><b>Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_PART__EX = 1;

  /**
   * The number of structural features of the '<em>Additive Expression Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.MultiplicativeExpressionImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getMultiplicativeExpression()
   * @generated
   */
  int MULTIPLICATIVE_EXPRESSION = 19;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__RIGHT = 1;

  /**
   * The number of structural features of the '<em>Multiplicative Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.MultiplicativeExpressionPartImpl <em>Multiplicative Expression Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.MultiplicativeExpressionPartImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getMultiplicativeExpressionPart()
   * @generated
   */
  int MULTIPLICATIVE_EXPRESSION_PART = 20;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_PART__OP = 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_PART__EXPR = 1;

  /**
   * The number of structural features of the '<em>Multiplicative Expression Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.UnaryExpressionImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getUnaryExpression()
   * @generated
   */
  int UNARY_EXPRESSION = 21;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__OP = 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__EXPR = 1;

  /**
   * The number of structural features of the '<em>Unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.PostfixExpressionImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getPostfixExpression()
   * @generated
   */
  int POSTFIX_EXPRESSION = 22;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__LEFT = 0;

  /**
   * The number of structural features of the '<em>Postfix Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.PrimaryExpressionImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getPrimaryExpression()
   * @generated
   */
  int PRIMARY_EXPRESSION = 23;

  /**
   * The feature id for the '<em><b>Other Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__OTHER_EX = 0;

  /**
   * The feature id for the '<em><b>Unq Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__UNQ_EX = 1;

  /**
   * The feature id for the '<em><b>Super Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__SUPER_EX = 2;

  /**
   * The feature id for the '<em><b>New Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__NEW_EX = 3;

  /**
   * The number of structural features of the '<em>Primary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionOrQualifiedExecutionImpl <em>Expression Or Qualified Execution</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionOrQualifiedExecutionImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getExpressionOrQualifiedExecution()
   * @generated
   */
  int EXPRESSION_OR_QUALIFIED_EXECUTION = 24;

  /**
   * The feature id for the '<em><b>Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_OR_QUALIFIED_EXECUTION__VAL = 0;

  /**
   * The feature id for the '<em><b>Parenthesis</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_OR_QUALIFIED_EXECUTION__PARENTHESIS = 1;

  /**
   * The feature id for the '<em><b>Calls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_OR_QUALIFIED_EXECUTION__CALLS = 2;

  /**
   * The number of structural features of the '<em>Expression Or Qualified Execution</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_OR_QUALIFIED_EXECUTION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.UnqualifiedExecutionImpl <em>Unqualified Execution</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.UnqualifiedExecutionImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getUnqualifiedExecution()
   * @generated
   */
  int UNQUALIFIED_EXECUTION = 25;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNQUALIFIED_EXECUTION__CALL = 0;

  /**
   * The feature id for the '<em><b>Calls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNQUALIFIED_EXECUTION__CALLS = 1;

  /**
   * The number of structural features of the '<em>Unqualified Execution</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNQUALIFIED_EXECUTION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.SuperExecutionImpl <em>Super Execution</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.SuperExecutionImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getSuperExecution()
   * @generated
   */
  int SUPER_EXECUTION = 26;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPER_EXECUTION__CALL = 0;

  /**
   * The feature id for the '<em><b>Calls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPER_EXECUTION__CALLS = 1;

  /**
   * The number of structural features of the '<em>Super Execution</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPER_EXECUTION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ConstructorExecutionImpl <em>Constructor Execution</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ConstructorExecutionImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getConstructorExecution()
   * @generated
   */
  int CONSTRUCTOR_EXECUTION = 27;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_EXECUTION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_EXECUTION__PARAM = 1;

  /**
   * The feature id for the '<em><b>Calls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_EXECUTION__CALLS = 2;

  /**
   * The number of structural features of the '<em>Constructor Execution</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_EXECUTION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.SubCallImpl <em>Sub Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.SubCallImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getSubCall()
   * @generated
   */
  int SUB_CALL = 28;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_CALL__TYPE = 0;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_CALL__CALL = 1;

  /**
   * The feature id for the '<em><b>Array Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_CALL__ARRAY_EX = 2;

  /**
   * The number of structural features of the '<em>Sub Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_CALL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.DeclaratorImpl <em>Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.DeclaratorImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getDeclarator()
   * @generated
   */
  int DECLARATOR = 29;

  /**
   * The feature id for the '<em><b>Decl</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR__DECL = 0;

  /**
   * The number of structural features of the '<em>Declarator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.DeclarationImpl <em>Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.DeclarationImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getDeclaration()
   * @generated
   */
  int DECLARATION = 30;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION__ID = 1;

  /**
   * The number of structural features of the '<em>Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.CallImpl <em>Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.CallImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getCall()
   * @generated
   */
  int CALL = 31;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL__NAME = 0;

  /**
   * The feature id for the '<em><b>Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL__DECL = 1;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL__PARAM = 2;

  /**
   * The number of structural features of the '<em>Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ArgumentListImpl <em>Argument List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ArgumentListImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getArgumentList()
   * @generated
   */
  int ARGUMENT_LIST = 32;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_LIST__PARAM = 0;

  /**
   * The number of structural features of the '<em>Argument List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.NamedArgumentImpl <em>Named Argument</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.NamedArgumentImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getNamedArgument()
   * @generated
   */
  int NAMED_ARGUMENT = 33;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ARGUMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ARGUMENT__EX = 1;

  /**
   * The number of structural features of the '<em>Named Argument</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ARGUMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.QualifiedPrefixImpl <em>Qualified Prefix</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.QualifiedPrefixImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getQualifiedPrefix()
   * @generated
   */
  int QUALIFIED_PREFIX = 34;

  /**
   * The feature id for the '<em><b>Qname</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_PREFIX__QNAME = 0;

  /**
   * The number of structural features of the '<em>Qualified Prefix</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_PREFIX_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.QualifiedNameImpl <em>Qualified Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.QualifiedNameImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getQualifiedName()
   * @generated
   */
  int QUALIFIED_NAME = 35;

  /**
   * The feature id for the '<em><b>Prefix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAME__PREFIX = 0;

  /**
   * The feature id for the '<em><b>Qname</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAME__QNAME = 1;

  /**
   * The number of structural features of the '<em>Qualified Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAME_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ConstantImpl <em>Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ConstantImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getConstant()
   * @generated
   */
  int CONSTANT = 36;

  /**
   * The feature id for the '<em><b>NValue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__NVALUE = 0;

  /**
   * The feature id for the '<em><b>SValue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__SVALUE = 1;

  /**
   * The feature id for the '<em><b>QValue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__QVALUE = 2;

  /**
   * The feature id for the '<em><b>BValue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__BVALUE = 3;

  /**
   * The feature id for the '<em><b>Null</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__NULL = 4;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__VERSION = 5;

  /**
   * The number of structural features of the '<em>Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.NumValueImpl <em>Num Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.NumValueImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getNumValue()
   * @generated
   */
  int NUM_VALUE = 37;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUM_VALUE__VAL = 0;

  /**
   * The number of structural features of the '<em>Num Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUM_VALUE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getType()
   * @generated
   */
  int TYPE = 38;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__NAME = 0;

  /**
   * The feature id for the '<em><b>Set</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__SET = 1;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__PARAM = 2;

  /**
   * The feature id for the '<em><b>Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__SEQ = 3;

  /**
   * The feature id for the '<em><b>Map</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__MAP = 4;

  /**
   * The feature id for the '<em><b>Call</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__CALL = 5;

  /**
   * The feature id for the '<em><b>Return</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__RETURN = 6;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeParametersImpl <em>Type Parameters</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeParametersImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getTypeParameters()
   * @generated
   */
  int TYPE_PARAMETERS = 39;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_PARAMETERS__PARAM = 0;

  /**
   * The number of structural features of the '<em>Type Parameters</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_PARAMETERS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ContainerInitializerImpl <em>Container Initializer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ContainerInitializerImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getContainerInitializer()
   * @generated
   */
  int CONTAINER_INITIALIZER = 40;

  /**
   * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTAINER_INITIALIZER__EXPRS = 0;

  /**
   * The number of structural features of the '<em>Container Initializer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTAINER_INITIALIZER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ContainerInitializerExpressionImpl <em>Container Initializer Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ContainerInitializerExpressionImpl
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getContainerInitializerExpression()
   * @generated
   */
  int CONTAINER_INITIALIZER_EXPRESSION = 41;

  /**
   * The feature id for the '<em><b>Logical</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTAINER_INITIALIZER_EXPRESSION__LOGICAL = 0;

  /**
   * The feature id for the '<em><b>Container</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTAINER_INITIALIZER_EXPRESSION__CONTAINER = 1;

  /**
   * The number of structural features of the '<em>Container Initializer Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTAINER_INITIALIZER_EXPRESSION_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit <em>Language Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Language Unit</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit
   * @generated
   */
  EClass getLanguageUnit();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit#getAdvices <em>Advices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Advices</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit#getAdvices()
   * @see #getLanguageUnit()
   * @generated
   */
  EReference getLanguageUnit_Advices();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit#getName()
   * @see #getLanguageUnit()
   * @generated
   */
  EAttribute getLanguageUnit_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Version</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit#getVersion()
   * @see #getLanguageUnit()
   * @generated
   */
  EReference getLanguageUnit_Version();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit#getImports()
   * @see #getLanguageUnit()
   * @generated
   */
  EReference getLanguageUnit_Imports();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration <em>Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Declaration</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration
   * @generated
   */
  EClass getVariableDeclaration();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration#getConst <em>Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Const</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration#getConst()
   * @see #getVariableDeclaration()
   * @generated
   */
  EAttribute getVariableDeclaration_Const();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration#getType()
   * @see #getVariableDeclaration()
   * @generated
   */
  EReference getVariableDeclaration_Type();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration#getName()
   * @see #getVariableDeclaration()
   * @generated
   */
  EAttribute getVariableDeclaration_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration#getExpression()
   * @see #getVariableDeclaration()
   * @generated
   */
  EReference getVariableDeclaration_Expression();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef <em>Type Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Def</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef
   * @generated
   */
  EClass getTypeDef();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef#getName()
   * @see #getTypeDef()
   * @generated
   */
  EAttribute getTypeDef_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef#getType()
   * @see #getTypeDef()
   * @generated
   */
  EReference getTypeDef_Type();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Advice <em>Advice</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Advice</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Advice
   * @generated
   */
  EClass getAdvice();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Advice#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Advice#getName()
   * @see #getAdvice()
   * @generated
   */
  EReference getAdvice_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Advice#getVersionSpec <em>Version Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Version Spec</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Advice#getVersionSpec()
   * @see #getAdvice()
   * @generated
   */
  EReference getAdvice_VersionSpec();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionSpec <em>Version Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Version Spec</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionSpec
   * @generated
   */
  EClass getVersionSpec();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionSpec#getRestriction <em>Restriction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Restriction</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionSpec#getRestriction()
   * @see #getVersionSpec()
   * @generated
   */
  EReference getVersionSpec_Restriction();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList <em>Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter List</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList
   * @generated
   */
  EClass getParameterList();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Param</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList#getParam()
   * @see #getParameterList()
   * @generated
   */
  EReference getParameterList_Param();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Parameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Parameter#getType()
   * @see #getParameter()
   * @generated
   */
  EReference getParameter_Type();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Parameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Parameter#getName()
   * @see #getParameter()
   * @generated
   */
  EAttribute getParameter_Name();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionStmt <em>Version Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Version Stmt</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionStmt
   * @generated
   */
  EClass getVersionStmt();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionStmt#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Version</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionStmt#getVersion()
   * @see #getVersionStmt()
   * @generated
   */
  EAttribute getVersionStmt_Version();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import#getName()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import#getVersionSpec <em>Version Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Version Spec</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import#getVersionSpec()
   * @see #getImport()
   * @generated
   */
  EReference getImport_VersionSpec();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement <em>Expression Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Statement</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement
   * @generated
   */
  EClass getExpressionStatement();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement#getVar()
   * @see #getExpressionStatement()
   * @generated
   */
  EAttribute getExpressionStatement_Var();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement#getField <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Field</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement#getField()
   * @see #getExpressionStatement()
   * @generated
   */
  EAttribute getExpressionStatement_Field();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement#getExpr()
   * @see #getExpressionStatement()
   * @generated
   */
  EReference getExpressionStatement_Expr();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression#getExpr()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Expr();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression#getInit <em>Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression#getInit()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Init();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression <em>Logical Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Expression</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression
   * @generated
   */
  EClass getLogicalExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression#getLeft()
   * @see #getLogicalExpression()
   * @generated
   */
  EReference getLogicalExpression_Left();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Right</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression#getRight()
   * @see #getLogicalExpression()
   * @generated
   */
  EReference getLogicalExpression_Right();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpressionPart <em>Logical Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Expression Part</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpressionPart
   * @generated
   */
  EClass getLogicalExpressionPart();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpressionPart#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpressionPart#getOp()
   * @see #getLogicalExpressionPart()
   * @generated
   */
  EAttribute getLogicalExpressionPart_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpressionPart#getEx <em>Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ex</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpressionPart#getEx()
   * @see #getLogicalExpressionPart()
   * @generated
   */
  EReference getLogicalExpressionPart_Ex();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Expression</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpression
   * @generated
   */
  EClass getEqualityExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpression#getLeft()
   * @see #getEqualityExpression()
   * @generated
   */
  EReference getEqualityExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpression#getRight()
   * @see #getEqualityExpression()
   * @generated
   */
  EReference getEqualityExpression_Right();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpressionPart <em>Equality Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Expression Part</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpressionPart
   * @generated
   */
  EClass getEqualityExpressionPart();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpressionPart#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpressionPart#getOp()
   * @see #getEqualityExpressionPart()
   * @generated
   */
  EAttribute getEqualityExpressionPart_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpressionPart#getEx <em>Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ex</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpressionPart#getEx()
   * @see #getEqualityExpressionPart()
   * @generated
   */
  EReference getEqualityExpressionPart_Ex();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Expression</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpression
   * @generated
   */
  EClass getRelationalExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpression#getLeft()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpression#getRight()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Right();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpressionPart <em>Relational Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Expression Part</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpressionPart
   * @generated
   */
  EClass getRelationalExpressionPart();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpressionPart#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpressionPart#getOp()
   * @see #getRelationalExpressionPart()
   * @generated
   */
  EAttribute getRelationalExpressionPart_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpressionPart#getEx <em>Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ex</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpressionPart#getEx()
   * @see #getRelationalExpressionPart()
   * @generated
   */
  EReference getRelationalExpressionPart_Ex();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpression <em>Additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Additive Expression</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpression
   * @generated
   */
  EClass getAdditiveExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpression#getLeft()
   * @see #getAdditiveExpression()
   * @generated
   */
  EReference getAdditiveExpression_Left();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Right</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpression#getRight()
   * @see #getAdditiveExpression()
   * @generated
   */
  EReference getAdditiveExpression_Right();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpressionPart <em>Additive Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Additive Expression Part</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpressionPart
   * @generated
   */
  EClass getAdditiveExpressionPart();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpressionPart#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpressionPart#getOp()
   * @see #getAdditiveExpressionPart()
   * @generated
   */
  EAttribute getAdditiveExpressionPart_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpressionPart#getEx <em>Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ex</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpressionPart#getEx()
   * @see #getAdditiveExpressionPart()
   * @generated
   */
  EReference getAdditiveExpressionPart_Ex();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicative Expression</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpression
   * @generated
   */
  EClass getMultiplicativeExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpression#getLeft()
   * @see #getMultiplicativeExpression()
   * @generated
   */
  EReference getMultiplicativeExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpression#getRight()
   * @see #getMultiplicativeExpression()
   * @generated
   */
  EReference getMultiplicativeExpression_Right();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpressionPart <em>Multiplicative Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicative Expression Part</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpressionPart
   * @generated
   */
  EClass getMultiplicativeExpressionPart();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpressionPart#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpressionPart#getOp()
   * @see #getMultiplicativeExpressionPart()
   * @generated
   */
  EAttribute getMultiplicativeExpressionPart_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpressionPart#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpressionPart#getExpr()
   * @see #getMultiplicativeExpressionPart()
   * @generated
   */
  EReference getMultiplicativeExpressionPart_Expr();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expression</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnaryExpression
   * @generated
   */
  EClass getUnaryExpression();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnaryExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnaryExpression#getOp()
   * @see #getUnaryExpression()
   * @generated
   */
  EAttribute getUnaryExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnaryExpression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnaryExpression#getExpr()
   * @see #getUnaryExpression()
   * @generated
   */
  EReference getUnaryExpression_Expr();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.PostfixExpression <em>Postfix Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postfix Expression</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.PostfixExpression
   * @generated
   */
  EClass getPostfixExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.PostfixExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.PostfixExpression#getLeft()
   * @see #getPostfixExpression()
   * @generated
   */
  EReference getPostfixExpression_Left();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Expression</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression
   * @generated
   */
  EClass getPrimaryExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression#getOtherEx <em>Other Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Other Ex</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression#getOtherEx()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_OtherEx();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression#getUnqEx <em>Unq Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Unq Ex</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression#getUnqEx()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_UnqEx();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression#getSuperEx <em>Super Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Super Ex</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression#getSuperEx()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_SuperEx();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression#getNewEx <em>New Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>New Ex</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression#getNewEx()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_NewEx();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionOrQualifiedExecution <em>Expression Or Qualified Execution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Or Qualified Execution</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionOrQualifiedExecution
   * @generated
   */
  EClass getExpressionOrQualifiedExecution();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionOrQualifiedExecution#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Val</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionOrQualifiedExecution#getVal()
   * @see #getExpressionOrQualifiedExecution()
   * @generated
   */
  EReference getExpressionOrQualifiedExecution_Val();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionOrQualifiedExecution#getParenthesis <em>Parenthesis</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parenthesis</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionOrQualifiedExecution#getParenthesis()
   * @see #getExpressionOrQualifiedExecution()
   * @generated
   */
  EReference getExpressionOrQualifiedExecution_Parenthesis();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionOrQualifiedExecution#getCalls <em>Calls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Calls</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionOrQualifiedExecution#getCalls()
   * @see #getExpressionOrQualifiedExecution()
   * @generated
   */
  EReference getExpressionOrQualifiedExecution_Calls();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnqualifiedExecution <em>Unqualified Execution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unqualified Execution</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnqualifiedExecution
   * @generated
   */
  EClass getUnqualifiedExecution();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnqualifiedExecution#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnqualifiedExecution#getCall()
   * @see #getUnqualifiedExecution()
   * @generated
   */
  EReference getUnqualifiedExecution_Call();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnqualifiedExecution#getCalls <em>Calls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Calls</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnqualifiedExecution#getCalls()
   * @see #getUnqualifiedExecution()
   * @generated
   */
  EReference getUnqualifiedExecution_Calls();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.SuperExecution <em>Super Execution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Super Execution</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.SuperExecution
   * @generated
   */
  EClass getSuperExecution();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.SuperExecution#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.SuperExecution#getCall()
   * @see #getSuperExecution()
   * @generated
   */
  EReference getSuperExecution_Call();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.SuperExecution#getCalls <em>Calls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Calls</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.SuperExecution#getCalls()
   * @see #getSuperExecution()
   * @generated
   */
  EReference getSuperExecution_Calls();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ConstructorExecution <em>Constructor Execution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constructor Execution</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ConstructorExecution
   * @generated
   */
  EClass getConstructorExecution();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ConstructorExecution#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ConstructorExecution#getType()
   * @see #getConstructorExecution()
   * @generated
   */
  EReference getConstructorExecution_Type();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ConstructorExecution#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ConstructorExecution#getParam()
   * @see #getConstructorExecution()
   * @generated
   */
  EReference getConstructorExecution_Param();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ConstructorExecution#getCalls <em>Calls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Calls</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ConstructorExecution#getCalls()
   * @see #getConstructorExecution()
   * @generated
   */
  EReference getConstructorExecution_Calls();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.SubCall <em>Sub Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sub Call</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.SubCall
   * @generated
   */
  EClass getSubCall();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.SubCall#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.SubCall#getType()
   * @see #getSubCall()
   * @generated
   */
  EAttribute getSubCall_Type();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.SubCall#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.SubCall#getCall()
   * @see #getSubCall()
   * @generated
   */
  EReference getSubCall_Call();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.SubCall#getArrayEx <em>Array Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Array Ex</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.SubCall#getArrayEx()
   * @see #getSubCall()
   * @generated
   */
  EReference getSubCall_ArrayEx();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Declarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declarator</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Declarator
   * @generated
   */
  EClass getDeclarator();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Declarator#getDecl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Decl</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Declarator#getDecl()
   * @see #getDeclarator()
   * @generated
   */
  EReference getDeclarator_Decl();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Declaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declaration</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Declaration
   * @generated
   */
  EClass getDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Declaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Declaration#getType()
   * @see #getDeclaration()
   * @generated
   */
  EReference getDeclaration_Type();

  /**
   * Returns the meta object for the attribute list '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Declaration#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Id</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Declaration#getId()
   * @see #getDeclaration()
   * @generated
   */
  EAttribute getDeclaration_Id();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Call</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call
   * @generated
   */
  EClass getCall();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call#getName()
   * @see #getCall()
   * @generated
   */
  EReference getCall_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call#getDecl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Decl</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call#getDecl()
   * @see #getCall()
   * @generated
   */
  EReference getCall_Decl();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call#getParam()
   * @see #getCall()
   * @generated
   */
  EReference getCall_Param();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ArgumentList <em>Argument List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument List</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ArgumentList
   * @generated
   */
  EClass getArgumentList();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ArgumentList#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Param</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ArgumentList#getParam()
   * @see #getArgumentList()
   * @generated
   */
  EReference getArgumentList_Param();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.NamedArgument <em>Named Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Argument</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.NamedArgument
   * @generated
   */
  EClass getNamedArgument();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.NamedArgument#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.NamedArgument#getName()
   * @see #getNamedArgument()
   * @generated
   */
  EAttribute getNamedArgument_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.NamedArgument#getEx <em>Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ex</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.NamedArgument#getEx()
   * @see #getNamedArgument()
   * @generated
   */
  EReference getNamedArgument_Ex();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedPrefix <em>Qualified Prefix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified Prefix</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedPrefix
   * @generated
   */
  EClass getQualifiedPrefix();

  /**
   * Returns the meta object for the attribute list '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedPrefix#getQname <em>Qname</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Qname</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedPrefix#getQname()
   * @see #getQualifiedPrefix()
   * @generated
   */
  EAttribute getQualifiedPrefix_Qname();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedName <em>Qualified Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified Name</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedName
   * @generated
   */
  EClass getQualifiedName();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedName#getPrefix <em>Prefix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Prefix</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedName#getPrefix()
   * @see #getQualifiedName()
   * @generated
   */
  EReference getQualifiedName_Prefix();

  /**
   * Returns the meta object for the attribute list '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedName#getQname <em>Qname</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Qname</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedName#getQname()
   * @see #getQualifiedName()
   * @generated
   */
  EAttribute getQualifiedName_Qname();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant
   * @generated
   */
  EClass getConstant();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant#getNValue <em>NValue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>NValue</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant#getNValue()
   * @see #getConstant()
   * @generated
   */
  EReference getConstant_NValue();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant#getSValue <em>SValue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>SValue</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant#getSValue()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_SValue();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant#getQValue <em>QValue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>QValue</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant#getQValue()
   * @see #getConstant()
   * @generated
   */
  EReference getConstant_QValue();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant#getBValue <em>BValue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>BValue</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant#getBValue()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_BValue();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant#getNull <em>Null</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Null</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant#getNull()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_Null();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Version</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant#getVersion()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_Version();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.NumValue <em>Num Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Num Value</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.NumValue
   * @generated
   */
  EClass getNumValue();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.NumValue#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.NumValue#getVal()
   * @see #getNumValue()
   * @generated
   */
  EAttribute getNumValue_Val();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getName()
   * @see #getType()
   * @generated
   */
  EReference getType_Name();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getSet <em>Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Set</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getSet()
   * @see #getType()
   * @generated
   */
  EAttribute getType_Set();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getParam()
   * @see #getType()
   * @generated
   */
  EReference getType_Param();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getSeq <em>Seq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Seq</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getSeq()
   * @see #getType()
   * @generated
   */
  EAttribute getType_Seq();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getMap <em>Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Map</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getMap()
   * @see #getType()
   * @generated
   */
  EAttribute getType_Map();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Call</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getCall()
   * @see #getType()
   * @generated
   */
  EAttribute getType_Call();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getReturn <em>Return</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getReturn()
   * @see #getType()
   * @generated
   */
  EReference getType_Return();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeParameters <em>Type Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Parameters</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeParameters
   * @generated
   */
  EClass getTypeParameters();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeParameters#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Param</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeParameters#getParam()
   * @see #getTypeParameters()
   * @generated
   */
  EReference getTypeParameters_Param();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializer <em>Container Initializer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Container Initializer</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializer
   * @generated
   */
  EClass getContainerInitializer();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializer#getExprs <em>Exprs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exprs</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializer#getExprs()
   * @see #getContainerInitializer()
   * @generated
   */
  EReference getContainerInitializer_Exprs();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializerExpression <em>Container Initializer Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Container Initializer Expression</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializerExpression
   * @generated
   */
  EClass getContainerInitializerExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializerExpression#getLogical <em>Logical</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Logical</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializerExpression#getLogical()
   * @see #getContainerInitializerExpression()
   * @generated
   */
  EReference getContainerInitializerExpression_Logical();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializerExpression#getContainer <em>Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Container</em>'.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializerExpression#getContainer()
   * @see #getContainerInitializerExpression()
   * @generated
   */
  EReference getContainerInitializerExpression_Container();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ExpressionDslFactory getExpressionDslFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.LanguageUnitImpl <em>Language Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.LanguageUnitImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getLanguageUnit()
     * @generated
     */
    EClass LANGUAGE_UNIT = eINSTANCE.getLanguageUnit();

    /**
     * The meta object literal for the '<em><b>Advices</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_UNIT__ADVICES = eINSTANCE.getLanguageUnit_Advices();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LANGUAGE_UNIT__NAME = eINSTANCE.getLanguageUnit_Name();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_UNIT__VERSION = eINSTANCE.getLanguageUnit_Version();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_UNIT__IMPORTS = eINSTANCE.getLanguageUnit_Imports();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.VariableDeclarationImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getVariableDeclaration()
     * @generated
     */
    EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

    /**
     * The meta object literal for the '<em><b>Const</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DECLARATION__CONST = eINSTANCE.getVariableDeclaration_Const();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATION__TYPE = eINSTANCE.getVariableDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DECLARATION__NAME = eINSTANCE.getVariableDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATION__EXPRESSION = eINSTANCE.getVariableDeclaration_Expression();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeDefImpl <em>Type Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeDefImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getTypeDef()
     * @generated
     */
    EClass TYPE_DEF = eINSTANCE.getTypeDef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_DEF__NAME = eINSTANCE.getTypeDef_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_DEF__TYPE = eINSTANCE.getTypeDef_Type();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.AdviceImpl <em>Advice</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.AdviceImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getAdvice()
     * @generated
     */
    EClass ADVICE = eINSTANCE.getAdvice();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADVICE__NAME = eINSTANCE.getAdvice_Name();

    /**
     * The meta object literal for the '<em><b>Version Spec</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADVICE__VERSION_SPEC = eINSTANCE.getAdvice_VersionSpec();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.VersionSpecImpl <em>Version Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.VersionSpecImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getVersionSpec()
     * @generated
     */
    EClass VERSION_SPEC = eINSTANCE.getVersionSpec();

    /**
     * The meta object literal for the '<em><b>Restriction</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERSION_SPEC__RESTRICTION = eINSTANCE.getVersionSpec_Restriction();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ParameterListImpl <em>Parameter List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ParameterListImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getParameterList()
     * @generated
     */
    EClass PARAMETER_LIST = eINSTANCE.getParameterList();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_LIST__PARAM = eINSTANCE.getParameterList_Param();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ParameterImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.VersionStmtImpl <em>Version Stmt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.VersionStmtImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getVersionStmt()
     * @generated
     */
    EClass VERSION_STMT = eINSTANCE.getVersionStmt();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERSION_STMT__VERSION = eINSTANCE.getVersionStmt_Version();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ImportImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__NAME = eINSTANCE.getImport_Name();

    /**
     * The meta object literal for the '<em><b>Version Spec</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPORT__VERSION_SPEC = eINSTANCE.getImport_VersionSpec();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionStatementImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getExpressionStatement()
     * @generated
     */
    EClass EXPRESSION_STATEMENT = eINSTANCE.getExpressionStatement();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION_STATEMENT__VAR = eINSTANCE.getExpressionStatement_Var();

    /**
     * The meta object literal for the '<em><b>Field</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION_STATEMENT__FIELD = eINSTANCE.getExpressionStatement_Field();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_STATEMENT__EXPR = eINSTANCE.getExpressionStatement_Expr();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__EXPR = eINSTANCE.getExpression_Expr();

    /**
     * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__INIT = eINSTANCE.getExpression_Init();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.LogicalExpressionImpl <em>Logical Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.LogicalExpressionImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getLogicalExpression()
     * @generated
     */
    EClass LOGICAL_EXPRESSION = eINSTANCE.getLogicalExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_EXPRESSION__LEFT = eINSTANCE.getLogicalExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_EXPRESSION__RIGHT = eINSTANCE.getLogicalExpression_Right();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.LogicalExpressionPartImpl <em>Logical Expression Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.LogicalExpressionPartImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getLogicalExpressionPart()
     * @generated
     */
    EClass LOGICAL_EXPRESSION_PART = eINSTANCE.getLogicalExpressionPart();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOGICAL_EXPRESSION_PART__OP = eINSTANCE.getLogicalExpressionPart_Op();

    /**
     * The meta object literal for the '<em><b>Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_EXPRESSION_PART__EX = eINSTANCE.getLogicalExpressionPart_Ex();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.EqualityExpressionImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getEqualityExpression()
     * @generated
     */
    EClass EQUALITY_EXPRESSION = eINSTANCE.getEqualityExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__LEFT = eINSTANCE.getEqualityExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__RIGHT = eINSTANCE.getEqualityExpression_Right();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.EqualityExpressionPartImpl <em>Equality Expression Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.EqualityExpressionPartImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getEqualityExpressionPart()
     * @generated
     */
    EClass EQUALITY_EXPRESSION_PART = eINSTANCE.getEqualityExpressionPart();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EQUALITY_EXPRESSION_PART__OP = eINSTANCE.getEqualityExpressionPart_Op();

    /**
     * The meta object literal for the '<em><b>Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION_PART__EX = eINSTANCE.getEqualityExpressionPart_Ex();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.RelationalExpressionImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getRelationalExpression()
     * @generated
     */
    EClass RELATIONAL_EXPRESSION = eINSTANCE.getRelationalExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__LEFT = eINSTANCE.getRelationalExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__RIGHT = eINSTANCE.getRelationalExpression_Right();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.RelationalExpressionPartImpl <em>Relational Expression Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.RelationalExpressionPartImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getRelationalExpressionPart()
     * @generated
     */
    EClass RELATIONAL_EXPRESSION_PART = eINSTANCE.getRelationalExpressionPart();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONAL_EXPRESSION_PART__OP = eINSTANCE.getRelationalExpressionPart_Op();

    /**
     * The meta object literal for the '<em><b>Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION_PART__EX = eINSTANCE.getRelationalExpressionPart_Ex();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.AdditiveExpressionImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getAdditiveExpression()
     * @generated
     */
    EClass ADDITIVE_EXPRESSION = eINSTANCE.getAdditiveExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION__LEFT = eINSTANCE.getAdditiveExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION__RIGHT = eINSTANCE.getAdditiveExpression_Right();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.AdditiveExpressionPartImpl <em>Additive Expression Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.AdditiveExpressionPartImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getAdditiveExpressionPart()
     * @generated
     */
    EClass ADDITIVE_EXPRESSION_PART = eINSTANCE.getAdditiveExpressionPart();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADDITIVE_EXPRESSION_PART__OP = eINSTANCE.getAdditiveExpressionPart_Op();

    /**
     * The meta object literal for the '<em><b>Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION_PART__EX = eINSTANCE.getAdditiveExpressionPart_Ex();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.MultiplicativeExpressionImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getMultiplicativeExpression()
     * @generated
     */
    EClass MULTIPLICATIVE_EXPRESSION = eINSTANCE.getMultiplicativeExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION__LEFT = eINSTANCE.getMultiplicativeExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION__RIGHT = eINSTANCE.getMultiplicativeExpression_Right();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.MultiplicativeExpressionPartImpl <em>Multiplicative Expression Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.MultiplicativeExpressionPartImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getMultiplicativeExpressionPart()
     * @generated
     */
    EClass MULTIPLICATIVE_EXPRESSION_PART = eINSTANCE.getMultiplicativeExpressionPart();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICATIVE_EXPRESSION_PART__OP = eINSTANCE.getMultiplicativeExpressionPart_Op();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION_PART__EXPR = eINSTANCE.getMultiplicativeExpressionPart_Expr();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.UnaryExpressionImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getUnaryExpression()
     * @generated
     */
    EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_EXPRESSION__OP = eINSTANCE.getUnaryExpression_Op();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__EXPR = eINSTANCE.getUnaryExpression_Expr();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.PostfixExpressionImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getPostfixExpression()
     * @generated
     */
    EClass POSTFIX_EXPRESSION = eINSTANCE.getPostfixExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTFIX_EXPRESSION__LEFT = eINSTANCE.getPostfixExpression_Left();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.PrimaryExpressionImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getPrimaryExpression()
     * @generated
     */
    EClass PRIMARY_EXPRESSION = eINSTANCE.getPrimaryExpression();

    /**
     * The meta object literal for the '<em><b>Other Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__OTHER_EX = eINSTANCE.getPrimaryExpression_OtherEx();

    /**
     * The meta object literal for the '<em><b>Unq Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__UNQ_EX = eINSTANCE.getPrimaryExpression_UnqEx();

    /**
     * The meta object literal for the '<em><b>Super Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__SUPER_EX = eINSTANCE.getPrimaryExpression_SuperEx();

    /**
     * The meta object literal for the '<em><b>New Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__NEW_EX = eINSTANCE.getPrimaryExpression_NewEx();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionOrQualifiedExecutionImpl <em>Expression Or Qualified Execution</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionOrQualifiedExecutionImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getExpressionOrQualifiedExecution()
     * @generated
     */
    EClass EXPRESSION_OR_QUALIFIED_EXECUTION = eINSTANCE.getExpressionOrQualifiedExecution();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_OR_QUALIFIED_EXECUTION__VAL = eINSTANCE.getExpressionOrQualifiedExecution_Val();

    /**
     * The meta object literal for the '<em><b>Parenthesis</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_OR_QUALIFIED_EXECUTION__PARENTHESIS = eINSTANCE.getExpressionOrQualifiedExecution_Parenthesis();

    /**
     * The meta object literal for the '<em><b>Calls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_OR_QUALIFIED_EXECUTION__CALLS = eINSTANCE.getExpressionOrQualifiedExecution_Calls();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.UnqualifiedExecutionImpl <em>Unqualified Execution</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.UnqualifiedExecutionImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getUnqualifiedExecution()
     * @generated
     */
    EClass UNQUALIFIED_EXECUTION = eINSTANCE.getUnqualifiedExecution();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNQUALIFIED_EXECUTION__CALL = eINSTANCE.getUnqualifiedExecution_Call();

    /**
     * The meta object literal for the '<em><b>Calls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNQUALIFIED_EXECUTION__CALLS = eINSTANCE.getUnqualifiedExecution_Calls();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.SuperExecutionImpl <em>Super Execution</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.SuperExecutionImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getSuperExecution()
     * @generated
     */
    EClass SUPER_EXECUTION = eINSTANCE.getSuperExecution();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPER_EXECUTION__CALL = eINSTANCE.getSuperExecution_Call();

    /**
     * The meta object literal for the '<em><b>Calls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPER_EXECUTION__CALLS = eINSTANCE.getSuperExecution_Calls();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ConstructorExecutionImpl <em>Constructor Execution</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ConstructorExecutionImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getConstructorExecution()
     * @generated
     */
    EClass CONSTRUCTOR_EXECUTION = eINSTANCE.getConstructorExecution();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRUCTOR_EXECUTION__TYPE = eINSTANCE.getConstructorExecution_Type();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRUCTOR_EXECUTION__PARAM = eINSTANCE.getConstructorExecution_Param();

    /**
     * The meta object literal for the '<em><b>Calls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRUCTOR_EXECUTION__CALLS = eINSTANCE.getConstructorExecution_Calls();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.SubCallImpl <em>Sub Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.SubCallImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getSubCall()
     * @generated
     */
    EClass SUB_CALL = eINSTANCE.getSubCall();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUB_CALL__TYPE = eINSTANCE.getSubCall_Type();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_CALL__CALL = eINSTANCE.getSubCall_Call();

    /**
     * The meta object literal for the '<em><b>Array Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_CALL__ARRAY_EX = eINSTANCE.getSubCall_ArrayEx();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.DeclaratorImpl <em>Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.DeclaratorImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getDeclarator()
     * @generated
     */
    EClass DECLARATOR = eINSTANCE.getDeclarator();

    /**
     * The meta object literal for the '<em><b>Decl</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATOR__DECL = eINSTANCE.getDeclarator_Decl();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.DeclarationImpl <em>Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.DeclarationImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getDeclaration()
     * @generated
     */
    EClass DECLARATION = eINSTANCE.getDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARATION__TYPE = eINSTANCE.getDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECLARATION__ID = eINSTANCE.getDeclaration_Id();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.CallImpl <em>Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.CallImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getCall()
     * @generated
     */
    EClass CALL = eINSTANCE.getCall();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL__NAME = eINSTANCE.getCall_Name();

    /**
     * The meta object literal for the '<em><b>Decl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL__DECL = eINSTANCE.getCall_Decl();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL__PARAM = eINSTANCE.getCall_Param();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ArgumentListImpl <em>Argument List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ArgumentListImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getArgumentList()
     * @generated
     */
    EClass ARGUMENT_LIST = eINSTANCE.getArgumentList();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT_LIST__PARAM = eINSTANCE.getArgumentList_Param();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.NamedArgumentImpl <em>Named Argument</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.NamedArgumentImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getNamedArgument()
     * @generated
     */
    EClass NAMED_ARGUMENT = eINSTANCE.getNamedArgument();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_ARGUMENT__NAME = eINSTANCE.getNamedArgument_Name();

    /**
     * The meta object literal for the '<em><b>Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_ARGUMENT__EX = eINSTANCE.getNamedArgument_Ex();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.QualifiedPrefixImpl <em>Qualified Prefix</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.QualifiedPrefixImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getQualifiedPrefix()
     * @generated
     */
    EClass QUALIFIED_PREFIX = eINSTANCE.getQualifiedPrefix();

    /**
     * The meta object literal for the '<em><b>Qname</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUALIFIED_PREFIX__QNAME = eINSTANCE.getQualifiedPrefix_Qname();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.QualifiedNameImpl <em>Qualified Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.QualifiedNameImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getQualifiedName()
     * @generated
     */
    EClass QUALIFIED_NAME = eINSTANCE.getQualifiedName();

    /**
     * The meta object literal for the '<em><b>Prefix</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_NAME__PREFIX = eINSTANCE.getQualifiedName_Prefix();

    /**
     * The meta object literal for the '<em><b>Qname</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUALIFIED_NAME__QNAME = eINSTANCE.getQualifiedName_Qname();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ConstantImpl <em>Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ConstantImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getConstant()
     * @generated
     */
    EClass CONSTANT = eINSTANCE.getConstant();

    /**
     * The meta object literal for the '<em><b>NValue</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT__NVALUE = eINSTANCE.getConstant_NValue();

    /**
     * The meta object literal for the '<em><b>SValue</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__SVALUE = eINSTANCE.getConstant_SValue();

    /**
     * The meta object literal for the '<em><b>QValue</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT__QVALUE = eINSTANCE.getConstant_QValue();

    /**
     * The meta object literal for the '<em><b>BValue</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__BVALUE = eINSTANCE.getConstant_BValue();

    /**
     * The meta object literal for the '<em><b>Null</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__NULL = eINSTANCE.getConstant_Null();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__VERSION = eINSTANCE.getConstant_Version();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.NumValueImpl <em>Num Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.NumValueImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getNumValue()
     * @generated
     */
    EClass NUM_VALUE = eINSTANCE.getNumValue();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUM_VALUE__VAL = eINSTANCE.getNumValue_Val();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE__NAME = eINSTANCE.getType_Name();

    /**
     * The meta object literal for the '<em><b>Set</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__SET = eINSTANCE.getType_Set();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE__PARAM = eINSTANCE.getType_Param();

    /**
     * The meta object literal for the '<em><b>Seq</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__SEQ = eINSTANCE.getType_Seq();

    /**
     * The meta object literal for the '<em><b>Map</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__MAP = eINSTANCE.getType_Map();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__CALL = eINSTANCE.getType_Call();

    /**
     * The meta object literal for the '<em><b>Return</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE__RETURN = eINSTANCE.getType_Return();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeParametersImpl <em>Type Parameters</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeParametersImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getTypeParameters()
     * @generated
     */
    EClass TYPE_PARAMETERS = eINSTANCE.getTypeParameters();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_PARAMETERS__PARAM = eINSTANCE.getTypeParameters_Param();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ContainerInitializerImpl <em>Container Initializer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ContainerInitializerImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getContainerInitializer()
     * @generated
     */
    EClass CONTAINER_INITIALIZER = eINSTANCE.getContainerInitializer();

    /**
     * The meta object literal for the '<em><b>Exprs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTAINER_INITIALIZER__EXPRS = eINSTANCE.getContainerInitializer_Exprs();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ContainerInitializerExpressionImpl <em>Container Initializer Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ContainerInitializerExpressionImpl
     * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ExpressionDslPackageImpl#getContainerInitializerExpression()
     * @generated
     */
    EClass CONTAINER_INITIALIZER_EXPRESSION = eINSTANCE.getContainerInitializerExpression();

    /**
     * The meta object literal for the '<em><b>Logical</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTAINER_INITIALIZER_EXPRESSION__LOGICAL = eINSTANCE.getContainerInitializerExpression_Logical();

    /**
     * The meta object literal for the '<em><b>Container</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTAINER_INITIALIZER_EXPRESSION__CONTAINER = eINSTANCE.getContainerInitializerExpression_Container();

  }

} //ExpressionDslPackage
