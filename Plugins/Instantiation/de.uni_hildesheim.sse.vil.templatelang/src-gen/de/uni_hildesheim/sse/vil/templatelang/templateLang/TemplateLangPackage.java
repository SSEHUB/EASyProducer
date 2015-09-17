/**
 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang;

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
 * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangFactory
 * @model kind="package"
 * @generated
 */
public interface TemplateLangPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "templateLang";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.uni_hildesheim.de/sse/vil/templatelang/TemplateLang";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "templateLang";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TemplateLangPackage eINSTANCE = de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl.init();

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.LanguageUnitImpl <em>Language Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.LanguageUnitImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getLanguageUnit()
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
   * The feature id for the '<em><b>Java Exts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__JAVA_EXTS = ExpressionDslPackage.LANGUAGE_UNIT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Indent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__INDENT = ExpressionDslPackage.LANGUAGE_UNIT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__PARAM = ExpressionDslPackage.LANGUAGE_UNIT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Ext</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__EXT = ExpressionDslPackage.LANGUAGE_UNIT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Type Defs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__TYPE_DEFS = ExpressionDslPackage.LANGUAGE_UNIT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Vars</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__VARS = ExpressionDslPackage.LANGUAGE_UNIT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Defs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__DEFS = ExpressionDslPackage.LANGUAGE_UNIT_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Language Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT_FEATURE_COUNT = ExpressionDslPackage.LANGUAGE_UNIT_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.IndentationHintImpl <em>Indentation Hint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.IndentationHintImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getIndentationHint()
   * @generated
   */
  int INDENTATION_HINT = 1;

  /**
   * The feature id for the '<em><b>Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDENTATION_HINT__PARTS = 0;

  /**
   * The number of structural features of the '<em>Indentation Hint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDENTATION_HINT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.IndentationHintPartImpl <em>Indentation Hint Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.IndentationHintPartImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getIndentationHintPart()
   * @generated
   */
  int INDENTATION_HINT_PART = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDENTATION_HINT_PART__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDENTATION_HINT_PART__VALUE = 1;

  /**
   * The number of structural features of the '<em>Indentation Hint Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDENTATION_HINT_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.VilDefImpl <em>Vil Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.VilDefImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getVilDef()
   * @generated
   */
  int VIL_DEF = 3;

  /**
   * The feature id for the '<em><b>Protected</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIL_DEF__PROTECTED = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIL_DEF__TYPE = 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIL_DEF__ID = 2;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIL_DEF__PARAM = 3;

  /**
   * The feature id for the '<em><b>Stmts</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIL_DEF__STMTS = 4;

  /**
   * The number of structural features of the '<em>Vil Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIL_DEF_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtBlockImpl <em>Stmt Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtBlockImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getStmtBlock()
   * @generated
   */
  int STMT_BLOCK = 4;

  /**
   * The feature id for the '<em><b>Stmts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_BLOCK__STMTS = 0;

  /**
   * The number of structural features of the '<em>Stmt Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_BLOCK_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtImpl <em>Stmt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getStmt()
   * @generated
   */
  int STMT = 5;

  /**
   * The feature id for the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT__VAR = 0;

  /**
   * The feature id for the '<em><b>Alt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT__ALT = 1;

  /**
   * The feature id for the '<em><b>Switch</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT__SWITCH = 2;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT__BLOCK = 3;

  /**
   * The feature id for the '<em><b>Multi</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT__MULTI = 4;

  /**
   * The feature id for the '<em><b>Loop</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT__LOOP = 5;

  /**
   * The feature id for the '<em><b>Expr Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT__EXPR_STMT = 6;

  /**
   * The feature id for the '<em><b>Ctn</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT__CTN = 7;

  /**
   * The number of structural features of the '<em>Stmt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.AlternativeImpl <em>Alternative</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.AlternativeImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getAlternative()
   * @generated
   */
  int ALTERNATIVE = 6;

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
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.ContentImpl <em>Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.ContentImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getContent()
   * @generated
   */
  int CONTENT = 7;

  /**
   * The feature id for the '<em><b>Print</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTENT__PRINT = 0;

  /**
   * The feature id for the '<em><b>Ctn</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTENT__CTN = 1;

  /**
   * The feature id for the '<em><b>Indent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTENT__INDENT = 2;

  /**
   * The number of structural features of the '<em>Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.SwitchImpl <em>Switch</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.SwitchImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getSwitch()
   * @generated
   */
  int SWITCH = 8;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH__EXPR = 0;

  /**
   * The feature id for the '<em><b>Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH__PARTS = 1;

  /**
   * The feature id for the '<em><b>Dflt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH__DFLT = 2;

  /**
   * The number of structural features of the '<em>Switch</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.SwitchPartImpl <em>Switch Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.SwitchPartImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getSwitchPart()
   * @generated
   */
  int SWITCH_PART = 9;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_PART__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_PART__RIGHT = 1;

  /**
   * The number of structural features of the '<em>Switch Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.LoopImpl <em>Loop</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.LoopImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getLoop()
   * @generated
   */
  int LOOP = 10;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP__TYPE = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP__ID = 1;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP__EXPR = 2;

  /**
   * The feature id for the '<em><b>Separator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP__SEPARATOR = 3;

  /**
   * The feature id for the '<em><b>Final Separator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP__FINAL_SEPARATOR = 4;

  /**
   * The feature id for the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP__STMT = 5;

  /**
   * The number of structural features of the '<em>Loop</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.multiselectImpl <em>multiselect</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.multiselectImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getmultiselect()
   * @generated
   */
  int MULTISELECT = 11;

  /**
   * The feature id for the '<em><b>Gen</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTISELECT__GEN = 0;

  /**
   * The feature id for the '<em><b>User</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTISELECT__USER = 1;

  /**
   * The number of structural features of the '<em>multiselect</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTISELECT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.genericMultiselectImpl <em>generic Multiselect</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.genericMultiselectImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getgenericMultiselect()
   * @generated
   */
  int GENERIC_MULTISELECT = 12;

  /**
   * The feature id for the '<em><b>Preamble</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERIC_MULTISELECT__PREAMBLE = 0;

  /**
   * The feature id for the '<em><b>Selector</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERIC_MULTISELECT__SELECTOR = 1;

  /**
   * The feature id for the '<em><b>Part</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERIC_MULTISELECT__PART = 2;

  /**
   * The feature id for the '<em><b>Trailer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERIC_MULTISELECT__TRAILER = 3;

  /**
   * The number of structural features of the '<em>generic Multiselect</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERIC_MULTISELECT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.multiSelectPartImpl <em>multi Select Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.multiSelectPartImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getmultiSelectPart()
   * @generated
   */
  int MULTI_SELECT_PART = 13;

  /**
   * The feature id for the '<em><b>Case</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_SELECT_PART__CASE = 0;

  /**
   * The feature id for the '<em><b>Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_SELECT_PART__CODE = 1;

  /**
   * The feature id for the '<em><b>Selector</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_SELECT_PART__SELECTOR = 2;

  /**
   * The number of structural features of the '<em>multi Select Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_SELECT_PART_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.userMultiselectImpl <em>user Multiselect</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.userMultiselectImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getuserMultiselect()
   * @generated
   */
  int USER_MULTISELECT = 14;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_MULTISELECT__ID = 0;

  /**
   * The feature id for the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_MULTISELECT__STMT = 1;

  /**
   * The number of structural features of the '<em>user Multiselect</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_MULTISELECT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.ExtensionImpl <em>Extension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.ExtensionImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getExtension()
   * @generated
   */
  int EXTENSION = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTENSION__NAME = 0;

  /**
   * The number of structural features of the '<em>Extension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTENSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.JavaQualifiedNameImpl <em>Java Qualified Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.JavaQualifiedNameImpl
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getJavaQualifiedName()
   * @generated
   */
  int JAVA_QUALIFIED_NAME = 16;

  /**
   * The feature id for the '<em><b>Qname</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_QUALIFIED_NAME__QNAME = 0;

  /**
   * The number of structural features of the '<em>Java Qualified Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_QUALIFIED_NAME_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit <em>Language Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Language Unit</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit
   * @generated
   */
  EClass getLanguageUnit();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getJavaExts <em>Java Exts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Java Exts</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getJavaExts()
   * @see #getLanguageUnit()
   * @generated
   */
  EReference getLanguageUnit_JavaExts();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getIndent <em>Indent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Indent</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getIndent()
   * @see #getLanguageUnit()
   * @generated
   */
  EReference getLanguageUnit_Indent();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getParam()
   * @see #getLanguageUnit()
   * @generated
   */
  EReference getLanguageUnit_Param();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getExt <em>Ext</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ext</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getExt()
   * @see #getLanguageUnit()
   * @generated
   */
  EAttribute getLanguageUnit_Ext();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getTypeDefs <em>Type Defs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Defs</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getTypeDefs()
   * @see #getLanguageUnit()
   * @generated
   */
  EReference getLanguageUnit_TypeDefs();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getVars <em>Vars</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Vars</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getVars()
   * @see #getLanguageUnit()
   * @generated
   */
  EReference getLanguageUnit_Vars();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getDefs <em>Defs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Defs</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getDefs()
   * @see #getLanguageUnit()
   * @generated
   */
  EReference getLanguageUnit_Defs();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHint <em>Indentation Hint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Indentation Hint</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHint
   * @generated
   */
  EClass getIndentationHint();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHint#getParts <em>Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parts</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHint#getParts()
   * @see #getIndentationHint()
   * @generated
   */
  EReference getIndentationHint_Parts();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHintPart <em>Indentation Hint Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Indentation Hint Part</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHintPart
   * @generated
   */
  EClass getIndentationHintPart();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHintPart#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHintPart#getName()
   * @see #getIndentationHintPart()
   * @generated
   */
  EAttribute getIndentationHintPart_Name();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHintPart#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHintPart#getValue()
   * @see #getIndentationHintPart()
   * @generated
   */
  EAttribute getIndentationHintPart_Value();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef <em>Vil Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Vil Def</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef
   * @generated
   */
  EClass getVilDef();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef#getProtected <em>Protected</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Protected</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef#getProtected()
   * @see #getVilDef()
   * @generated
   */
  EAttribute getVilDef_Protected();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef#getType()
   * @see #getVilDef()
   * @generated
   */
  EReference getVilDef_Type();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef#getId()
   * @see #getVilDef()
   * @generated
   */
  EAttribute getVilDef_Id();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef#getParam()
   * @see #getVilDef()
   * @generated
   */
  EReference getVilDef_Param();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef#getStmts <em>Stmts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Stmts</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef#getStmts()
   * @see #getVilDef()
   * @generated
   */
  EReference getVilDef_Stmts();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.StmtBlock <em>Stmt Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stmt Block</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.StmtBlock
   * @generated
   */
  EClass getStmtBlock();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.StmtBlock#getStmts <em>Stmts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Stmts</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.StmtBlock#getStmts()
   * @see #getStmtBlock()
   * @generated
   */
  EReference getStmtBlock_Stmts();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt <em>Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stmt</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt
   * @generated
   */
  EClass getStmt();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getVar()
   * @see #getStmt()
   * @generated
   */
  EReference getStmt_Var();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getAlt <em>Alt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Alt</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getAlt()
   * @see #getStmt()
   * @generated
   */
  EReference getStmt_Alt();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getSwitch <em>Switch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Switch</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getSwitch()
   * @see #getStmt()
   * @generated
   */
  EReference getStmt_Switch();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getBlock()
   * @see #getStmt()
   * @generated
   */
  EReference getStmt_Block();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getMulti <em>Multi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multi</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getMulti()
   * @see #getStmt()
   * @generated
   */
  EReference getStmt_Multi();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getLoop <em>Loop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Loop</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getLoop()
   * @see #getStmt()
   * @generated
   */
  EReference getStmt_Loop();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getExprStmt <em>Expr Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr Stmt</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getExprStmt()
   * @see #getStmt()
   * @generated
   */
  EReference getStmt_ExprStmt();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getCtn <em>Ctn</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ctn</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getCtn()
   * @see #getStmt()
   * @generated
   */
  EReference getStmt_Ctn();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Alternative <em>Alternative</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alternative</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Alternative
   * @generated
   */
  EClass getAlternative();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Alternative#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Alternative#getExpr()
   * @see #getAlternative()
   * @generated
   */
  EReference getAlternative_Expr();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Alternative#getIf <em>If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>If</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Alternative#getIf()
   * @see #getAlternative()
   * @generated
   */
  EReference getAlternative_If();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Alternative#getElse <em>Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Alternative#getElse()
   * @see #getAlternative()
   * @generated
   */
  EReference getAlternative_Else();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Content <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Content</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Content
   * @generated
   */
  EClass getContent();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Content#getPrint <em>Print</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Print</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Content#getPrint()
   * @see #getContent()
   * @generated
   */
  EAttribute getContent_Print();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Content#getCtn <em>Ctn</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ctn</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Content#getCtn()
   * @see #getContent()
   * @generated
   */
  EAttribute getContent_Ctn();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Content#getIndent <em>Indent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Indent</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Content#getIndent()
   * @see #getContent()
   * @generated
   */
  EReference getContent_Indent();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Switch <em>Switch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Switch</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Switch
   * @generated
   */
  EClass getSwitch();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Switch#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Switch#getExpr()
   * @see #getSwitch()
   * @generated
   */
  EReference getSwitch_Expr();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Switch#getParts <em>Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parts</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Switch#getParts()
   * @see #getSwitch()
   * @generated
   */
  EReference getSwitch_Parts();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Switch#getDflt <em>Dflt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dflt</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Switch#getDflt()
   * @see #getSwitch()
   * @generated
   */
  EReference getSwitch_Dflt();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.SwitchPart <em>Switch Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Switch Part</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.SwitchPart
   * @generated
   */
  EClass getSwitchPart();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.SwitchPart#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.SwitchPart#getLeft()
   * @see #getSwitchPart()
   * @generated
   */
  EReference getSwitchPart_Left();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.SwitchPart#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.SwitchPart#getRight()
   * @see #getSwitchPart()
   * @generated
   */
  EReference getSwitchPart_Right();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop <em>Loop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Loop</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop
   * @generated
   */
  EClass getLoop();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop#getType()
   * @see #getLoop()
   * @generated
   */
  EReference getLoop_Type();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop#getId()
   * @see #getLoop()
   * @generated
   */
  EAttribute getLoop_Id();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop#getExpr()
   * @see #getLoop()
   * @generated
   */
  EReference getLoop_Expr();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop#getSeparator <em>Separator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Separator</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop#getSeparator()
   * @see #getLoop()
   * @generated
   */
  EReference getLoop_Separator();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop#getFinalSeparator <em>Final Separator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Final Separator</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop#getFinalSeparator()
   * @see #getLoop()
   * @generated
   */
  EReference getLoop_FinalSeparator();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop#getStmt <em>Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Stmt</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop#getStmt()
   * @see #getLoop()
   * @generated
   */
  EReference getLoop_Stmt();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.multiselect <em>multiselect</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>multiselect</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.multiselect
   * @generated
   */
  EClass getmultiselect();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.multiselect#getGen <em>Gen</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Gen</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.multiselect#getGen()
   * @see #getmultiselect()
   * @generated
   */
  EReference getmultiselect_Gen();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.multiselect#getUser <em>User</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>User</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.multiselect#getUser()
   * @see #getmultiselect()
   * @generated
   */
  EReference getmultiselect_User();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect <em>generic Multiselect</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>generic Multiselect</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect
   * @generated
   */
  EClass getgenericMultiselect();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect#getPreamble <em>Preamble</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Preamble</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect#getPreamble()
   * @see #getgenericMultiselect()
   * @generated
   */
  EReference getgenericMultiselect_Preamble();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect#getSelector <em>Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Selector</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect#getSelector()
   * @see #getgenericMultiselect()
   * @generated
   */
  EReference getgenericMultiselect_Selector();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect#getPart <em>Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Part</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect#getPart()
   * @see #getgenericMultiselect()
   * @generated
   */
  EReference getgenericMultiselect_Part();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect#getTrailer <em>Trailer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Trailer</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect#getTrailer()
   * @see #getgenericMultiselect()
   * @generated
   */
  EReference getgenericMultiselect_Trailer();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.multiSelectPart <em>multi Select Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>multi Select Part</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.multiSelectPart
   * @generated
   */
  EClass getmultiSelectPart();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.multiSelectPart#getCase <em>Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Case</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.multiSelectPart#getCase()
   * @see #getmultiSelectPart()
   * @generated
   */
  EReference getmultiSelectPart_Case();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.multiSelectPart#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Code</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.multiSelectPart#getCode()
   * @see #getmultiSelectPart()
   * @generated
   */
  EReference getmultiSelectPart_Code();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.multiSelectPart#getSelector <em>Selector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Selector</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.multiSelectPart#getSelector()
   * @see #getmultiSelectPart()
   * @generated
   */
  EReference getmultiSelectPart_Selector();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.userMultiselect <em>user Multiselect</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>user Multiselect</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.userMultiselect
   * @generated
   */
  EClass getuserMultiselect();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.userMultiselect#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.userMultiselect#getId()
   * @see #getuserMultiselect()
   * @generated
   */
  EAttribute getuserMultiselect_Id();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.userMultiselect#getStmt <em>Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Stmt</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.userMultiselect#getStmt()
   * @see #getuserMultiselect()
   * @generated
   */
  EReference getuserMultiselect_Stmt();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Extension <em>Extension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Extension</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Extension
   * @generated
   */
  EClass getExtension();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Extension#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Extension#getName()
   * @see #getExtension()
   * @generated
   */
  EReference getExtension_Name();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.JavaQualifiedName <em>Java Qualified Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Java Qualified Name</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.JavaQualifiedName
   * @generated
   */
  EClass getJavaQualifiedName();

  /**
   * Returns the meta object for the attribute list '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.JavaQualifiedName#getQname <em>Qname</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Qname</em>'.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.JavaQualifiedName#getQname()
   * @see #getJavaQualifiedName()
   * @generated
   */
  EAttribute getJavaQualifiedName_Qname();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TemplateLangFactory getTemplateLangFactory();

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
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.LanguageUnitImpl <em>Language Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.LanguageUnitImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getLanguageUnit()
     * @generated
     */
    EClass LANGUAGE_UNIT = eINSTANCE.getLanguageUnit();

    /**
     * The meta object literal for the '<em><b>Java Exts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_UNIT__JAVA_EXTS = eINSTANCE.getLanguageUnit_JavaExts();

    /**
     * The meta object literal for the '<em><b>Indent</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_UNIT__INDENT = eINSTANCE.getLanguageUnit_Indent();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_UNIT__PARAM = eINSTANCE.getLanguageUnit_Param();

    /**
     * The meta object literal for the '<em><b>Ext</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LANGUAGE_UNIT__EXT = eINSTANCE.getLanguageUnit_Ext();

    /**
     * The meta object literal for the '<em><b>Type Defs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_UNIT__TYPE_DEFS = eINSTANCE.getLanguageUnit_TypeDefs();

    /**
     * The meta object literal for the '<em><b>Vars</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_UNIT__VARS = eINSTANCE.getLanguageUnit_Vars();

    /**
     * The meta object literal for the '<em><b>Defs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_UNIT__DEFS = eINSTANCE.getLanguageUnit_Defs();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.IndentationHintImpl <em>Indentation Hint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.IndentationHintImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getIndentationHint()
     * @generated
     */
    EClass INDENTATION_HINT = eINSTANCE.getIndentationHint();

    /**
     * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INDENTATION_HINT__PARTS = eINSTANCE.getIndentationHint_Parts();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.IndentationHintPartImpl <em>Indentation Hint Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.IndentationHintPartImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getIndentationHintPart()
     * @generated
     */
    EClass INDENTATION_HINT_PART = eINSTANCE.getIndentationHintPart();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDENTATION_HINT_PART__NAME = eINSTANCE.getIndentationHintPart_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDENTATION_HINT_PART__VALUE = eINSTANCE.getIndentationHintPart_Value();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.VilDefImpl <em>Vil Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.VilDefImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getVilDef()
     * @generated
     */
    EClass VIL_DEF = eINSTANCE.getVilDef();

    /**
     * The meta object literal for the '<em><b>Protected</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VIL_DEF__PROTECTED = eINSTANCE.getVilDef_Protected();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VIL_DEF__TYPE = eINSTANCE.getVilDef_Type();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VIL_DEF__ID = eINSTANCE.getVilDef_Id();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VIL_DEF__PARAM = eINSTANCE.getVilDef_Param();

    /**
     * The meta object literal for the '<em><b>Stmts</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VIL_DEF__STMTS = eINSTANCE.getVilDef_Stmts();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtBlockImpl <em>Stmt Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtBlockImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getStmtBlock()
     * @generated
     */
    EClass STMT_BLOCK = eINSTANCE.getStmtBlock();

    /**
     * The meta object literal for the '<em><b>Stmts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT_BLOCK__STMTS = eINSTANCE.getStmtBlock_Stmts();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtImpl <em>Stmt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getStmt()
     * @generated
     */
    EClass STMT = eINSTANCE.getStmt();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT__VAR = eINSTANCE.getStmt_Var();

    /**
     * The meta object literal for the '<em><b>Alt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT__ALT = eINSTANCE.getStmt_Alt();

    /**
     * The meta object literal for the '<em><b>Switch</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT__SWITCH = eINSTANCE.getStmt_Switch();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT__BLOCK = eINSTANCE.getStmt_Block();

    /**
     * The meta object literal for the '<em><b>Multi</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT__MULTI = eINSTANCE.getStmt_Multi();

    /**
     * The meta object literal for the '<em><b>Loop</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT__LOOP = eINSTANCE.getStmt_Loop();

    /**
     * The meta object literal for the '<em><b>Expr Stmt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT__EXPR_STMT = eINSTANCE.getStmt_ExprStmt();

    /**
     * The meta object literal for the '<em><b>Ctn</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT__CTN = eINSTANCE.getStmt_Ctn();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.AlternativeImpl <em>Alternative</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.AlternativeImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getAlternative()
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
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.ContentImpl <em>Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.ContentImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getContent()
     * @generated
     */
    EClass CONTENT = eINSTANCE.getContent();

    /**
     * The meta object literal for the '<em><b>Print</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTENT__PRINT = eINSTANCE.getContent_Print();

    /**
     * The meta object literal for the '<em><b>Ctn</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTENT__CTN = eINSTANCE.getContent_Ctn();

    /**
     * The meta object literal for the '<em><b>Indent</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTENT__INDENT = eINSTANCE.getContent_Indent();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.SwitchImpl <em>Switch</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.SwitchImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getSwitch()
     * @generated
     */
    EClass SWITCH = eINSTANCE.getSwitch();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SWITCH__EXPR = eINSTANCE.getSwitch_Expr();

    /**
     * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SWITCH__PARTS = eINSTANCE.getSwitch_Parts();

    /**
     * The meta object literal for the '<em><b>Dflt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SWITCH__DFLT = eINSTANCE.getSwitch_Dflt();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.SwitchPartImpl <em>Switch Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.SwitchPartImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getSwitchPart()
     * @generated
     */
    EClass SWITCH_PART = eINSTANCE.getSwitchPart();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SWITCH_PART__LEFT = eINSTANCE.getSwitchPart_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SWITCH_PART__RIGHT = eINSTANCE.getSwitchPart_Right();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.LoopImpl <em>Loop</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.LoopImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getLoop()
     * @generated
     */
    EClass LOOP = eINSTANCE.getLoop();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOOP__TYPE = eINSTANCE.getLoop_Type();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOOP__ID = eINSTANCE.getLoop_Id();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOOP__EXPR = eINSTANCE.getLoop_Expr();

    /**
     * The meta object literal for the '<em><b>Separator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOOP__SEPARATOR = eINSTANCE.getLoop_Separator();

    /**
     * The meta object literal for the '<em><b>Final Separator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOOP__FINAL_SEPARATOR = eINSTANCE.getLoop_FinalSeparator();

    /**
     * The meta object literal for the '<em><b>Stmt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOOP__STMT = eINSTANCE.getLoop_Stmt();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.multiselectImpl <em>multiselect</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.multiselectImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getmultiselect()
     * @generated
     */
    EClass MULTISELECT = eINSTANCE.getmultiselect();

    /**
     * The meta object literal for the '<em><b>Gen</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTISELECT__GEN = eINSTANCE.getmultiselect_Gen();

    /**
     * The meta object literal for the '<em><b>User</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTISELECT__USER = eINSTANCE.getmultiselect_User();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.genericMultiselectImpl <em>generic Multiselect</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.genericMultiselectImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getgenericMultiselect()
     * @generated
     */
    EClass GENERIC_MULTISELECT = eINSTANCE.getgenericMultiselect();

    /**
     * The meta object literal for the '<em><b>Preamble</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GENERIC_MULTISELECT__PREAMBLE = eINSTANCE.getgenericMultiselect_Preamble();

    /**
     * The meta object literal for the '<em><b>Selector</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GENERIC_MULTISELECT__SELECTOR = eINSTANCE.getgenericMultiselect_Selector();

    /**
     * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GENERIC_MULTISELECT__PART = eINSTANCE.getgenericMultiselect_Part();

    /**
     * The meta object literal for the '<em><b>Trailer</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GENERIC_MULTISELECT__TRAILER = eINSTANCE.getgenericMultiselect_Trailer();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.multiSelectPartImpl <em>multi Select Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.multiSelectPartImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getmultiSelectPart()
     * @generated
     */
    EClass MULTI_SELECT_PART = eINSTANCE.getmultiSelectPart();

    /**
     * The meta object literal for the '<em><b>Case</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTI_SELECT_PART__CASE = eINSTANCE.getmultiSelectPart_Case();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTI_SELECT_PART__CODE = eINSTANCE.getmultiSelectPart_Code();

    /**
     * The meta object literal for the '<em><b>Selector</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTI_SELECT_PART__SELECTOR = eINSTANCE.getmultiSelectPart_Selector();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.userMultiselectImpl <em>user Multiselect</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.userMultiselectImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getuserMultiselect()
     * @generated
     */
    EClass USER_MULTISELECT = eINSTANCE.getuserMultiselect();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute USER_MULTISELECT__ID = eINSTANCE.getuserMultiselect_Id();

    /**
     * The meta object literal for the '<em><b>Stmt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference USER_MULTISELECT__STMT = eINSTANCE.getuserMultiselect_Stmt();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.ExtensionImpl <em>Extension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.ExtensionImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getExtension()
     * @generated
     */
    EClass EXTENSION = eINSTANCE.getExtension();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTENSION__NAME = eINSTANCE.getExtension_Name();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.JavaQualifiedNameImpl <em>Java Qualified Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.JavaQualifiedNameImpl
     * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangPackageImpl#getJavaQualifiedName()
     * @generated
     */
    EClass JAVA_QUALIFIED_NAME = eINSTANCE.getJavaQualifiedName();

    /**
     * The meta object literal for the '<em><b>Qname</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_QUALIFIED_NAME__QNAME = eINSTANCE.getJavaQualifiedName_Qname();

  }

} //TemplateLangPackage
