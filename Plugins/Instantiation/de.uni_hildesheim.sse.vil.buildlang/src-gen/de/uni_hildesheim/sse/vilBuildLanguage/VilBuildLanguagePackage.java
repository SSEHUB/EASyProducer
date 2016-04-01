/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;

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
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface VilBuildLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "vilBuildLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.uni_hildesheim.de/sse/VilBuildLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "vilBuildLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  VilBuildLanguagePackage eINSTANCE = de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.ImplementationUnitImpl <em>Implementation Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.ImplementationUnitImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getImplementationUnit()
   * @generated
   */
  int IMPLEMENTATION_UNIT = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_UNIT__IMPORTS = 0;

  /**
   * The feature id for the '<em><b>Requires</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_UNIT__REQUIRES = 1;

  /**
   * The feature id for the '<em><b>Scripts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_UNIT__SCRIPTS = 2;

  /**
   * The number of structural features of the '<em>Implementation Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_UNIT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RequireImpl <em>Require</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.RequireImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getRequire()
   * @generated
   */
  int REQUIRE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRE__NAME = 0;

  /**
   * The feature id for the '<em><b>Version Spec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRE__VERSION_SPEC = 1;

  /**
   * The number of structural features of the '<em>Require</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.LanguageUnitImpl <em>Language Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.LanguageUnitImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getLanguageUnit()
   * @generated
   */
  int LANGUAGE_UNIT = 2;

  /**
   * The feature id for the '<em><b>Advices</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__ADVICES = ExpressionDslPackage.LANGUAGE_UNIT__ADVICES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__NAME = ExpressionDslPackage.LANGUAGE_UNIT__NAME;

  /**
   * The feature id for the '<em><b>Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__VERSION = ExpressionDslPackage.LANGUAGE_UNIT__VERSION;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__IMPORTS = ExpressionDslPackage.LANGUAGE_UNIT__IMPORTS;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__PARAM = ExpressionDslPackage.LANGUAGE_UNIT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__PARENT = ExpressionDslPackage.LANGUAGE_UNIT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Load Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__LOAD_PROPERTIES = ExpressionDslPackage.LANGUAGE_UNIT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Contents</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__CONTENTS = ExpressionDslPackage.LANGUAGE_UNIT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Language Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT_FEATURE_COUNT = ExpressionDslPackage.LANGUAGE_UNIT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.ScriptParentDeclImpl <em>Script Parent Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.ScriptParentDeclImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getScriptParentDecl()
   * @generated
   */
  int SCRIPT_PARENT_DECL = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCRIPT_PARENT_DECL__NAME = 0;

  /**
   * The number of structural features of the '<em>Script Parent Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCRIPT_PARENT_DECL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.LoadPropertiesImpl <em>Load Properties</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.LoadPropertiesImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getLoadProperties()
   * @generated
   */
  int LOAD_PROPERTIES = 4;

  /**
   * The feature id for the '<em><b>Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_PROPERTIES__PATH = 0;

  /**
   * The number of structural features of the '<em>Load Properties</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOAD_PROPERTIES_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.ScriptContentsImpl <em>Script Contents</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.ScriptContentsImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getScriptContents()
   * @generated
   */
  int SCRIPT_CONTENTS = 5;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCRIPT_CONTENTS__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Script Contents</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCRIPT_CONTENTS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleDeclarationImpl <em>Rule Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleDeclarationImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getRuleDeclaration()
   * @generated
   */
  int RULE_DECLARATION = 6;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Modifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__MODIFIER = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__NAME = 2;

  /**
   * The feature id for the '<em><b>Param List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__PARAM_LIST = 3;

  /**
   * The feature id for the '<em><b>Conditions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__CONDITIONS = 4;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION__BLOCK = 5;

  /**
   * The number of structural features of the '<em>Rule Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DECLARATION_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleConditionsImpl <em>Rule Conditions</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleConditionsImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getRuleConditions()
   * @generated
   */
  int RULE_CONDITIONS = 7;

  /**
   * The feature id for the '<em><b>Postcondition</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CONDITIONS__POSTCONDITION = 0;

  /**
   * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CONDITIONS__PRECONDITIONS = 1;

  /**
   * The number of structural features of the '<em>Rule Conditions</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_CONDITIONS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleElementBlockImpl <em>Rule Element Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleElementBlockImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getRuleElementBlock()
   * @generated
   */
  int RULE_ELEMENT_BLOCK = 8;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_ELEMENT_BLOCK__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Rule Element Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_ELEMENT_BLOCK_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleElementImpl <em>Rule Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleElementImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getRuleElement()
   * @generated
   */
  int RULE_ELEMENT = 9;

  /**
   * The feature id for the '<em><b>Var Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_ELEMENT__VAR_DECL = 0;

  /**
   * The feature id for the '<em><b>Expr Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_ELEMENT__EXPR_STMT = 1;

  /**
   * The feature id for the '<em><b>While</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_ELEMENT__WHILE = 2;

  /**
   * The feature id for the '<em><b>For</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_ELEMENT__FOR = 3;

  /**
   * The number of structural features of the '<em>Rule Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_ELEMENT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleModifierImpl <em>Rule Modifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleModifierImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getRuleModifier()
   * @generated
   */
  int RULE_MODIFIER = 10;

  /**
   * The feature id for the '<em><b>Protected</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_MODIFIER__PROTECTED = 0;

  /**
   * The number of structural features of the '<em>Rule Modifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_MODIFIER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.ExpressionStatementImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getExpressionStatement()
   * @generated
   */
  int EXPRESSION_STATEMENT = 11;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT__VAR = ExpressionDslPackage.EXPRESSION_STATEMENT__VAR;

  /**
   * The feature id for the '<em><b>Field</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT__FIELD = ExpressionDslPackage.EXPRESSION_STATEMENT__FIELD;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT__EXPR = ExpressionDslPackage.EXPRESSION_STATEMENT__EXPR;

  /**
   * The feature id for the '<em><b>Alt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT__ALT = ExpressionDslPackage.EXPRESSION_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT_FEATURE_COUNT = ExpressionDslPackage.EXPRESSION_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.PrimaryExpressionImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getPrimaryExpression()
   * @generated
   */
  int PRIMARY_EXPRESSION = 12;

  /**
   * The feature id for the '<em><b>Other Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__OTHER_EX = ExpressionDslPackage.PRIMARY_EXPRESSION__OTHER_EX;

  /**
   * The feature id for the '<em><b>Unq Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__UNQ_EX = ExpressionDslPackage.PRIMARY_EXPRESSION__UNQ_EX;

  /**
   * The feature id for the '<em><b>Super Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__SUPER_EX = ExpressionDslPackage.PRIMARY_EXPRESSION__SUPER_EX;

  /**
   * The feature id for the '<em><b>New Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__NEW_EX = ExpressionDslPackage.PRIMARY_EXPRESSION__NEW_EX;

  /**
   * The feature id for the '<em><b>Sys Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__SYS_EX = ExpressionDslPackage.PRIMARY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Map</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__MAP = ExpressionDslPackage.PRIMARY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Join</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__JOIN = ExpressionDslPackage.PRIMARY_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Instantiate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__INSTANTIATE = ExpressionDslPackage.PRIMARY_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Primary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION_FEATURE_COUNT = ExpressionDslPackage.PRIMARY_EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.InstantiateImpl <em>Instantiate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.InstantiateImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getInstantiate()
   * @generated
   */
  int INSTANTIATE = 13;

  /**
   * The feature id for the '<em><b>Project</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANTIATE__PROJECT = 0;

  /**
   * The feature id for the '<em><b>Rule Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANTIATE__RULE_NAME = 1;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANTIATE__PARAM = 2;

  /**
   * The feature id for the '<em><b>Version Spec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANTIATE__VERSION_SPEC = 3;

  /**
   * The number of structural features of the '<em>Instantiate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANTIATE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.LoopVariableImpl <em>Loop Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.LoopVariableImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getLoopVariable()
   * @generated
   */
  int LOOP_VARIABLE = 14;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE__TYPE = 0;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE__VAR = 1;

  /**
   * The number of structural features of the '<em>Loop Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_VARIABLE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.MapImpl <em>Map</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.MapImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getMap()
   * @generated
   */
  int MAP = 15;

  /**
   * The feature id for the '<em><b>Var</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP__VAR = 0;

  /**
   * The feature id for the '<em><b>Separator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP__SEPARATOR = 1;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP__EXPR = 2;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP__BLOCK = 3;

  /**
   * The number of structural features of the '<em>Map</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.ForImpl <em>For</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.ForImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getFor()
   * @generated
   */
  int FOR = 16;

  /**
   * The feature id for the '<em><b>Var</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR__VAR = 0;

  /**
   * The feature id for the '<em><b>Separator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR__SEPARATOR = 1;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR__EXPR = 2;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR__BLOCK = 3;

  /**
   * The number of structural features of the '<em>For</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.WhileImpl <em>While</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.WhileImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getWhile()
   * @generated
   */
  int WHILE = 17;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE__EXPR = 0;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE__BLOCK = 1;

  /**
   * The number of structural features of the '<em>While</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.AlternativeImpl <em>Alternative</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.AlternativeImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getAlternative()
   * @generated
   */
  int ALTERNATIVE = 18;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVE__EXPR = 0;

  /**
   * The feature id for the '<em><b>If</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVE__IF = 1;

  /**
   * The feature id for the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVE__ELSE = 2;

  /**
   * The number of structural features of the '<em>Alternative</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.StatementOrBlockImpl <em>Statement Or Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.StatementOrBlockImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getStatementOrBlock()
   * @generated
   */
  int STATEMENT_OR_BLOCK = 19;

  /**
   * The feature id for the '<em><b>Ex Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_OR_BLOCK__EX_STMT = 0;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_OR_BLOCK__BLOCK = 1;

  /**
   * The number of structural features of the '<em>Statement Or Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_OR_BLOCK_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.JoinImpl <em>Join</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.JoinImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getJoin()
   * @generated
   */
  int JOIN = 20;

  /**
   * The feature id for the '<em><b>Var1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JOIN__VAR1 = 0;

  /**
   * The feature id for the '<em><b>Var2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JOIN__VAR2 = 1;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JOIN__CONDITION = 2;

  /**
   * The number of structural features of the '<em>Join</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JOIN_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.JoinVariableImpl <em>Join Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.JoinVariableImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getJoinVariable()
   * @generated
   */
  int JOIN_VARIABLE = 21;

  /**
   * The feature id for the '<em><b>Excl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JOIN_VARIABLE__EXCL = 0;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JOIN_VARIABLE__VAR = 1;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JOIN_VARIABLE__EXPR = 2;

  /**
   * The number of structural features of the '<em>Join Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JOIN_VARIABLE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.SystemExecutionImpl <em>System Execution</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.SystemExecutionImpl
   * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getSystemExecution()
   * @generated
   */
  int SYSTEM_EXECUTION = 22;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_EXECUTION__CALL = 0;

  /**
   * The feature id for the '<em><b>Calls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_EXECUTION__CALLS = 1;

  /**
   * The number of structural features of the '<em>System Execution</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_EXECUTION_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit <em>Implementation Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Implementation Unit</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit
   * @generated
   */
  EClass getImplementationUnit();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit#getImports()
   * @see #getImplementationUnit()
   * @generated
   */
  EReference getImplementationUnit_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit#getRequires <em>Requires</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Requires</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit#getRequires()
   * @see #getImplementationUnit()
   * @generated
   */
  EReference getImplementationUnit_Requires();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit#getScripts <em>Scripts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Scripts</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit#getScripts()
   * @see #getImplementationUnit()
   * @generated
   */
  EReference getImplementationUnit_Scripts();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.Require <em>Require</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Require</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Require
   * @generated
   */
  EClass getRequire();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vilBuildLanguage.Require#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Require#getName()
   * @see #getRequire()
   * @generated
   */
  EAttribute getRequire_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.Require#getVersionSpec <em>Version Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Version Spec</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Require#getVersionSpec()
   * @see #getRequire()
   * @generated
   */
  EReference getRequire_VersionSpec();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit <em>Language Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Language Unit</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit
   * @generated
   */
  EClass getLanguageUnit();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit#getParam()
   * @see #getLanguageUnit()
   * @generated
   */
  EReference getLanguageUnit_Param();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parent</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit#getParent()
   * @see #getLanguageUnit()
   * @generated
   */
  EReference getLanguageUnit_Parent();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit#getLoadProperties <em>Load Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Load Properties</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit#getLoadProperties()
   * @see #getLanguageUnit()
   * @generated
   */
  EReference getLanguageUnit_LoadProperties();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit#getContents <em>Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Contents</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit#getContents()
   * @see #getLanguageUnit()
   * @generated
   */
  EReference getLanguageUnit_Contents();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.ScriptParentDecl <em>Script Parent Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Script Parent Decl</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.ScriptParentDecl
   * @generated
   */
  EClass getScriptParentDecl();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vilBuildLanguage.ScriptParentDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.ScriptParentDecl#getName()
   * @see #getScriptParentDecl()
   * @generated
   */
  EAttribute getScriptParentDecl_Name();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.LoadProperties <em>Load Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Load Properties</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.LoadProperties
   * @generated
   */
  EClass getLoadProperties();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vilBuildLanguage.LoadProperties#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Path</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.LoadProperties#getPath()
   * @see #getLoadProperties()
   * @generated
   */
  EAttribute getLoadProperties_Path();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.ScriptContents <em>Script Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Script Contents</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.ScriptContents
   * @generated
   */
  EClass getScriptContents();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vilBuildLanguage.ScriptContents#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.ScriptContents#getElements()
   * @see #getScriptContents()
   * @generated
   */
  EReference getScriptContents_Elements();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration <em>Rule Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Declaration</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration
   * @generated
   */
  EClass getRuleDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getType()
   * @see #getRuleDeclaration()
   * @generated
   */
  EReference getRuleDeclaration_Type();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getModifier <em>Modifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Modifier</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getModifier()
   * @see #getRuleDeclaration()
   * @generated
   */
  EReference getRuleDeclaration_Modifier();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getName()
   * @see #getRuleDeclaration()
   * @generated
   */
  EAttribute getRuleDeclaration_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getParamList <em>Param List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param List</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getParamList()
   * @see #getRuleDeclaration()
   * @generated
   */
  EReference getRuleDeclaration_ParamList();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getConditions <em>Conditions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Conditions</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getConditions()
   * @see #getRuleDeclaration()
   * @generated
   */
  EReference getRuleDeclaration_Conditions();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getBlock()
   * @see #getRuleDeclaration()
   * @generated
   */
  EReference getRuleDeclaration_Block();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleConditions <em>Rule Conditions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Conditions</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleConditions
   * @generated
   */
  EClass getRuleConditions();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleConditions#getPostcondition <em>Postcondition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Postcondition</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleConditions#getPostcondition()
   * @see #getRuleConditions()
   * @generated
   */
  EReference getRuleConditions_Postcondition();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleConditions#getPreconditions <em>Preconditions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Preconditions</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleConditions#getPreconditions()
   * @see #getRuleConditions()
   * @generated
   */
  EReference getRuleConditions_Preconditions();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElementBlock <em>Rule Element Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Element Block</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleElementBlock
   * @generated
   */
  EClass getRuleElementBlock();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElementBlock#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleElementBlock#getElements()
   * @see #getRuleElementBlock()
   * @generated
   */
  EReference getRuleElementBlock_Elements();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElement <em>Rule Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Element</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleElement
   * @generated
   */
  EClass getRuleElement();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElement#getVarDecl <em>Var Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var Decl</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleElement#getVarDecl()
   * @see #getRuleElement()
   * @generated
   */
  EReference getRuleElement_VarDecl();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElement#getExprStmt <em>Expr Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr Stmt</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleElement#getExprStmt()
   * @see #getRuleElement()
   * @generated
   */
  EReference getRuleElement_ExprStmt();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElement#getWhile <em>While</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>While</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleElement#getWhile()
   * @see #getRuleElement()
   * @generated
   */
  EReference getRuleElement_While();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElement#getFor <em>For</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>For</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleElement#getFor()
   * @see #getRuleElement()
   * @generated
   */
  EReference getRuleElement_For();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleModifier <em>Rule Modifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Modifier</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleModifier
   * @generated
   */
  EClass getRuleModifier();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleModifier#getProtected <em>Protected</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Protected</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleModifier#getProtected()
   * @see #getRuleModifier()
   * @generated
   */
  EAttribute getRuleModifier_Protected();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.ExpressionStatement <em>Expression Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Statement</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.ExpressionStatement
   * @generated
   */
  EClass getExpressionStatement();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.ExpressionStatement#getAlt <em>Alt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Alt</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.ExpressionStatement#getAlt()
   * @see #getExpressionStatement()
   * @generated
   */
  EReference getExpressionStatement_Alt();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Expression</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression
   * @generated
   */
  EClass getPrimaryExpression();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression#getSysEx <em>Sys Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sys Ex</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression#getSysEx()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_SysEx();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression#getMap <em>Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Map</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression#getMap()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_Map();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression#getJoin <em>Join</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Join</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression#getJoin()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_Join();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression#getInstantiate <em>Instantiate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Instantiate</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression#getInstantiate()
   * @see #getPrimaryExpression()
   * @generated
   */
  EReference getPrimaryExpression_Instantiate();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.Instantiate <em>Instantiate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instantiate</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Instantiate
   * @generated
   */
  EClass getInstantiate();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getProject <em>Project</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Project</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getProject()
   * @see #getInstantiate()
   * @generated
   */
  EAttribute getInstantiate_Project();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getRuleName <em>Rule Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rule Name</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getRuleName()
   * @see #getInstantiate()
   * @generated
   */
  EAttribute getInstantiate_RuleName();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getParam()
   * @see #getInstantiate()
   * @generated
   */
  EReference getInstantiate_Param();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getVersionSpec <em>Version Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Version Spec</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getVersionSpec()
   * @see #getInstantiate()
   * @generated
   */
  EReference getInstantiate_VersionSpec();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.LoopVariable <em>Loop Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Loop Variable</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.LoopVariable
   * @generated
   */
  EClass getLoopVariable();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.LoopVariable#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.LoopVariable#getType()
   * @see #getLoopVariable()
   * @generated
   */
  EReference getLoopVariable_Type();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vilBuildLanguage.LoopVariable#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.LoopVariable#getVar()
   * @see #getLoopVariable()
   * @generated
   */
  EAttribute getLoopVariable_Var();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.Map <em>Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Map</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Map
   * @generated
   */
  EClass getMap();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vilBuildLanguage.Map#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Var</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Map#getVar()
   * @see #getMap()
   * @generated
   */
  EReference getMap_Var();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vilBuildLanguage.Map#getSeparator <em>Separator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Separator</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Map#getSeparator()
   * @see #getMap()
   * @generated
   */
  EAttribute getMap_Separator();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.Map#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Map#getExpr()
   * @see #getMap()
   * @generated
   */
  EReference getMap_Expr();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.Map#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Map#getBlock()
   * @see #getMap()
   * @generated
   */
  EReference getMap_Block();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.For <em>For</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>For</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.For
   * @generated
   */
  EClass getFor();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vilBuildLanguage.For#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Var</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.For#getVar()
   * @see #getFor()
   * @generated
   */
  EReference getFor_Var();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vilBuildLanguage.For#getSeparator <em>Separator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Separator</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.For#getSeparator()
   * @see #getFor()
   * @generated
   */
  EAttribute getFor_Separator();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.For#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.For#getExpr()
   * @see #getFor()
   * @generated
   */
  EReference getFor_Expr();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.For#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.For#getBlock()
   * @see #getFor()
   * @generated
   */
  EReference getFor_Block();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.While <em>While</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>While</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.While
   * @generated
   */
  EClass getWhile();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.While#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.While#getExpr()
   * @see #getWhile()
   * @generated
   */
  EReference getWhile_Expr();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.While#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.While#getBlock()
   * @see #getWhile()
   * @generated
   */
  EReference getWhile_Block();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.Alternative <em>Alternative</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alternative</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Alternative
   * @generated
   */
  EClass getAlternative();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.Alternative#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Alternative#getExpr()
   * @see #getAlternative()
   * @generated
   */
  EReference getAlternative_Expr();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.Alternative#getIf <em>If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>If</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Alternative#getIf()
   * @see #getAlternative()
   * @generated
   */
  EReference getAlternative_If();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.Alternative#getElse <em>Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Alternative#getElse()
   * @see #getAlternative()
   * @generated
   */
  EReference getAlternative_Else();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.StatementOrBlock <em>Statement Or Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement Or Block</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.StatementOrBlock
   * @generated
   */
  EClass getStatementOrBlock();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.StatementOrBlock#getExStmt <em>Ex Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ex Stmt</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.StatementOrBlock#getExStmt()
   * @see #getStatementOrBlock()
   * @generated
   */
  EReference getStatementOrBlock_ExStmt();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.StatementOrBlock#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.StatementOrBlock#getBlock()
   * @see #getStatementOrBlock()
   * @generated
   */
  EReference getStatementOrBlock_Block();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.Join <em>Join</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Join</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Join
   * @generated
   */
  EClass getJoin();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.Join#getVar1 <em>Var1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var1</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Join#getVar1()
   * @see #getJoin()
   * @generated
   */
  EReference getJoin_Var1();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.Join#getVar2 <em>Var2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var2</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Join#getVar2()
   * @see #getJoin()
   * @generated
   */
  EReference getJoin_Var2();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.Join#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Join#getCondition()
   * @see #getJoin()
   * @generated
   */
  EReference getJoin_Condition();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable <em>Join Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Join Variable</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable
   * @generated
   */
  EClass getJoinVariable();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable#getExcl <em>Excl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Excl</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable#getExcl()
   * @see #getJoinVariable()
   * @generated
   */
  EAttribute getJoinVariable_Excl();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable#getVar()
   * @see #getJoinVariable()
   * @generated
   */
  EAttribute getJoinVariable_Var();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable#getExpr()
   * @see #getJoinVariable()
   * @generated
   */
  EReference getJoinVariable_Expr();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vilBuildLanguage.SystemExecution <em>System Execution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>System Execution</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.SystemExecution
   * @generated
   */
  EClass getSystemExecution();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vilBuildLanguage.SystemExecution#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.SystemExecution#getCall()
   * @see #getSystemExecution()
   * @generated
   */
  EReference getSystemExecution_Call();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vilBuildLanguage.SystemExecution#getCalls <em>Calls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Calls</em>'.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.SystemExecution#getCalls()
   * @see #getSystemExecution()
   * @generated
   */
  EReference getSystemExecution_Calls();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  VilBuildLanguageFactory getVilBuildLanguageFactory();

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
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.ImplementationUnitImpl <em>Implementation Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.ImplementationUnitImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getImplementationUnit()
     * @generated
     */
    EClass IMPLEMENTATION_UNIT = eINSTANCE.getImplementationUnit();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPLEMENTATION_UNIT__IMPORTS = eINSTANCE.getImplementationUnit_Imports();

    /**
     * The meta object literal for the '<em><b>Requires</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPLEMENTATION_UNIT__REQUIRES = eINSTANCE.getImplementationUnit_Requires();

    /**
     * The meta object literal for the '<em><b>Scripts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPLEMENTATION_UNIT__SCRIPTS = eINSTANCE.getImplementationUnit_Scripts();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RequireImpl <em>Require</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.RequireImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getRequire()
     * @generated
     */
    EClass REQUIRE = eINSTANCE.getRequire();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQUIRE__NAME = eINSTANCE.getRequire_Name();

    /**
     * The meta object literal for the '<em><b>Version Spec</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIRE__VERSION_SPEC = eINSTANCE.getRequire_VersionSpec();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.LanguageUnitImpl <em>Language Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.LanguageUnitImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getLanguageUnit()
     * @generated
     */
    EClass LANGUAGE_UNIT = eINSTANCE.getLanguageUnit();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_UNIT__PARAM = eINSTANCE.getLanguageUnit_Param();

    /**
     * The meta object literal for the '<em><b>Parent</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_UNIT__PARENT = eINSTANCE.getLanguageUnit_Parent();

    /**
     * The meta object literal for the '<em><b>Load Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_UNIT__LOAD_PROPERTIES = eINSTANCE.getLanguageUnit_LoadProperties();

    /**
     * The meta object literal for the '<em><b>Contents</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_UNIT__CONTENTS = eINSTANCE.getLanguageUnit_Contents();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.ScriptParentDeclImpl <em>Script Parent Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.ScriptParentDeclImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getScriptParentDecl()
     * @generated
     */
    EClass SCRIPT_PARENT_DECL = eINSTANCE.getScriptParentDecl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCRIPT_PARENT_DECL__NAME = eINSTANCE.getScriptParentDecl_Name();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.LoadPropertiesImpl <em>Load Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.LoadPropertiesImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getLoadProperties()
     * @generated
     */
    EClass LOAD_PROPERTIES = eINSTANCE.getLoadProperties();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOAD_PROPERTIES__PATH = eINSTANCE.getLoadProperties_Path();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.ScriptContentsImpl <em>Script Contents</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.ScriptContentsImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getScriptContents()
     * @generated
     */
    EClass SCRIPT_CONTENTS = eINSTANCE.getScriptContents();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCRIPT_CONTENTS__ELEMENTS = eINSTANCE.getScriptContents_Elements();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleDeclarationImpl <em>Rule Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleDeclarationImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getRuleDeclaration()
     * @generated
     */
    EClass RULE_DECLARATION = eINSTANCE.getRuleDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DECLARATION__TYPE = eINSTANCE.getRuleDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Modifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DECLARATION__MODIFIER = eINSTANCE.getRuleDeclaration_Modifier();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_DECLARATION__NAME = eINSTANCE.getRuleDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Param List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DECLARATION__PARAM_LIST = eINSTANCE.getRuleDeclaration_ParamList();

    /**
     * The meta object literal for the '<em><b>Conditions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DECLARATION__CONDITIONS = eINSTANCE.getRuleDeclaration_Conditions();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DECLARATION__BLOCK = eINSTANCE.getRuleDeclaration_Block();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleConditionsImpl <em>Rule Conditions</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleConditionsImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getRuleConditions()
     * @generated
     */
    EClass RULE_CONDITIONS = eINSTANCE.getRuleConditions();

    /**
     * The meta object literal for the '<em><b>Postcondition</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_CONDITIONS__POSTCONDITION = eINSTANCE.getRuleConditions_Postcondition();

    /**
     * The meta object literal for the '<em><b>Preconditions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_CONDITIONS__PRECONDITIONS = eINSTANCE.getRuleConditions_Preconditions();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleElementBlockImpl <em>Rule Element Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleElementBlockImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getRuleElementBlock()
     * @generated
     */
    EClass RULE_ELEMENT_BLOCK = eINSTANCE.getRuleElementBlock();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_ELEMENT_BLOCK__ELEMENTS = eINSTANCE.getRuleElementBlock_Elements();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleElementImpl <em>Rule Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleElementImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getRuleElement()
     * @generated
     */
    EClass RULE_ELEMENT = eINSTANCE.getRuleElement();

    /**
     * The meta object literal for the '<em><b>Var Decl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_ELEMENT__VAR_DECL = eINSTANCE.getRuleElement_VarDecl();

    /**
     * The meta object literal for the '<em><b>Expr Stmt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_ELEMENT__EXPR_STMT = eINSTANCE.getRuleElement_ExprStmt();

    /**
     * The meta object literal for the '<em><b>While</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_ELEMENT__WHILE = eINSTANCE.getRuleElement_While();

    /**
     * The meta object literal for the '<em><b>For</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_ELEMENT__FOR = eINSTANCE.getRuleElement_For();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleModifierImpl <em>Rule Modifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleModifierImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getRuleModifier()
     * @generated
     */
    EClass RULE_MODIFIER = eINSTANCE.getRuleModifier();

    /**
     * The meta object literal for the '<em><b>Protected</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_MODIFIER__PROTECTED = eINSTANCE.getRuleModifier_Protected();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.ExpressionStatementImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getExpressionStatement()
     * @generated
     */
    EClass EXPRESSION_STATEMENT = eINSTANCE.getExpressionStatement();

    /**
     * The meta object literal for the '<em><b>Alt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_STATEMENT__ALT = eINSTANCE.getExpressionStatement_Alt();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.PrimaryExpressionImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getPrimaryExpression()
     * @generated
     */
    EClass PRIMARY_EXPRESSION = eINSTANCE.getPrimaryExpression();

    /**
     * The meta object literal for the '<em><b>Sys Ex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__SYS_EX = eINSTANCE.getPrimaryExpression_SysEx();

    /**
     * The meta object literal for the '<em><b>Map</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__MAP = eINSTANCE.getPrimaryExpression_Map();

    /**
     * The meta object literal for the '<em><b>Join</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__JOIN = eINSTANCE.getPrimaryExpression_Join();

    /**
     * The meta object literal for the '<em><b>Instantiate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_EXPRESSION__INSTANTIATE = eINSTANCE.getPrimaryExpression_Instantiate();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.InstantiateImpl <em>Instantiate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.InstantiateImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getInstantiate()
     * @generated
     */
    EClass INSTANTIATE = eINSTANCE.getInstantiate();

    /**
     * The meta object literal for the '<em><b>Project</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTANTIATE__PROJECT = eINSTANCE.getInstantiate_Project();

    /**
     * The meta object literal for the '<em><b>Rule Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTANTIATE__RULE_NAME = eINSTANCE.getInstantiate_RuleName();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANTIATE__PARAM = eINSTANCE.getInstantiate_Param();

    /**
     * The meta object literal for the '<em><b>Version Spec</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANTIATE__VERSION_SPEC = eINSTANCE.getInstantiate_VersionSpec();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.LoopVariableImpl <em>Loop Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.LoopVariableImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getLoopVariable()
     * @generated
     */
    EClass LOOP_VARIABLE = eINSTANCE.getLoopVariable();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOOP_VARIABLE__TYPE = eINSTANCE.getLoopVariable_Type();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOP_VARIABLE__VAR = eINSTANCE.getLoopVariable_Var();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.MapImpl <em>Map</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.MapImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getMap()
     * @generated
     */
    EClass MAP = eINSTANCE.getMap();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAP__VAR = eINSTANCE.getMap_Var();

    /**
     * The meta object literal for the '<em><b>Separator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MAP__SEPARATOR = eINSTANCE.getMap_Separator();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAP__EXPR = eINSTANCE.getMap_Expr();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAP__BLOCK = eINSTANCE.getMap_Block();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.ForImpl <em>For</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.ForImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getFor()
     * @generated
     */
    EClass FOR = eINSTANCE.getFor();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR__VAR = eINSTANCE.getFor_Var();

    /**
     * The meta object literal for the '<em><b>Separator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOR__SEPARATOR = eINSTANCE.getFor_Separator();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR__EXPR = eINSTANCE.getFor_Expr();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR__BLOCK = eINSTANCE.getFor_Block();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.WhileImpl <em>While</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.WhileImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getWhile()
     * @generated
     */
    EClass WHILE = eINSTANCE.getWhile();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE__EXPR = eINSTANCE.getWhile_Expr();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE__BLOCK = eINSTANCE.getWhile_Block();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.AlternativeImpl <em>Alternative</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.AlternativeImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getAlternative()
     * @generated
     */
    EClass ALTERNATIVE = eINSTANCE.getAlternative();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALTERNATIVE__EXPR = eINSTANCE.getAlternative_Expr();

    /**
     * The meta object literal for the '<em><b>If</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALTERNATIVE__IF = eINSTANCE.getAlternative_If();

    /**
     * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALTERNATIVE__ELSE = eINSTANCE.getAlternative_Else();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.StatementOrBlockImpl <em>Statement Or Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.StatementOrBlockImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getStatementOrBlock()
     * @generated
     */
    EClass STATEMENT_OR_BLOCK = eINSTANCE.getStatementOrBlock();

    /**
     * The meta object literal for the '<em><b>Ex Stmt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT_OR_BLOCK__EX_STMT = eINSTANCE.getStatementOrBlock_ExStmt();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT_OR_BLOCK__BLOCK = eINSTANCE.getStatementOrBlock_Block();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.JoinImpl <em>Join</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.JoinImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getJoin()
     * @generated
     */
    EClass JOIN = eINSTANCE.getJoin();

    /**
     * The meta object literal for the '<em><b>Var1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JOIN__VAR1 = eINSTANCE.getJoin_Var1();

    /**
     * The meta object literal for the '<em><b>Var2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JOIN__VAR2 = eINSTANCE.getJoin_Var2();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JOIN__CONDITION = eINSTANCE.getJoin_Condition();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.JoinVariableImpl <em>Join Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.JoinVariableImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getJoinVariable()
     * @generated
     */
    EClass JOIN_VARIABLE = eINSTANCE.getJoinVariable();

    /**
     * The meta object literal for the '<em><b>Excl</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JOIN_VARIABLE__EXCL = eINSTANCE.getJoinVariable_Excl();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JOIN_VARIABLE__VAR = eINSTANCE.getJoinVariable_Var();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JOIN_VARIABLE__EXPR = eINSTANCE.getJoinVariable_Expr();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.SystemExecutionImpl <em>System Execution</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.SystemExecutionImpl
     * @see de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguagePackageImpl#getSystemExecution()
     * @generated
     */
    EClass SYSTEM_EXECUTION = eINSTANCE.getSystemExecution();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SYSTEM_EXECUTION__CALL = eINSTANCE.getSystemExecution_Call();

    /**
     * The meta object literal for the '<em><b>Calls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SYSTEM_EXECUTION__CALLS = eINSTANCE.getSystemExecution_Calls();

  }

} //VilBuildLanguagePackage
