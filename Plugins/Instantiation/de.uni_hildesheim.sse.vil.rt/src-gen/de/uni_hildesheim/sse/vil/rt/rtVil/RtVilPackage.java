/**
 */
package de.uni_hildesheim.sse.vil.rt.rtVil;

import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;

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
 * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilFactory
 * @model kind="package"
 * @generated
 */
public interface RtVilPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "rtVil";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.uni_hildesheim.de/sse/vil/rt/RtVil";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "rtVil";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  RtVilPackage eINSTANCE = de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl.init();

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.ImplementationUnitImpl <em>Implementation Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.ImplementationUnitImpl
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getImplementationUnit()
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
  int IMPLEMENTATION_UNIT__IMPORTS = VilBuildLanguagePackage.IMPLEMENTATION_UNIT__IMPORTS;

  /**
   * The feature id for the '<em><b>Requires</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_UNIT__REQUIRES = VilBuildLanguagePackage.IMPLEMENTATION_UNIT__REQUIRES;

  /**
   * The feature id for the '<em><b>Scripts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_UNIT__SCRIPTS = VilBuildLanguagePackage.IMPLEMENTATION_UNIT__SCRIPTS;

  /**
   * The number of structural features of the '<em>Implementation Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_UNIT_FEATURE_COUNT = VilBuildLanguagePackage.IMPLEMENTATION_UNIT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.LanguageUnitImpl <em>Language Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.LanguageUnitImpl
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getLanguageUnit()
   * @generated
   */
  int LANGUAGE_UNIT = 1;

  /**
   * The feature id for the '<em><b>Advices</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__ADVICES = VilBuildLanguagePackage.LANGUAGE_UNIT__ADVICES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__NAME = VilBuildLanguagePackage.LANGUAGE_UNIT__NAME;

  /**
   * The feature id for the '<em><b>Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__VERSION = VilBuildLanguagePackage.LANGUAGE_UNIT__VERSION;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__IMPORTS = VilBuildLanguagePackage.LANGUAGE_UNIT__IMPORTS;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__PARAM = VilBuildLanguagePackage.LANGUAGE_UNIT__PARAM;

  /**
   * The feature id for the '<em><b>Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__PARENT = VilBuildLanguagePackage.LANGUAGE_UNIT__PARENT;

  /**
   * The feature id for the '<em><b>Load Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__LOAD_PROPERTIES = VilBuildLanguagePackage.LANGUAGE_UNIT__LOAD_PROPERTIES;

  /**
   * The feature id for the '<em><b>Contents</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__CONTENTS = VilBuildLanguagePackage.LANGUAGE_UNIT__CONTENTS;

  /**
   * The feature id for the '<em><b>Rt Contents</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT__RT_CONTENTS = VilBuildLanguagePackage.LANGUAGE_UNIT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Language Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_UNIT_FEATURE_COUNT = VilBuildLanguagePackage.LANGUAGE_UNIT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.rtContentsImpl <em>rt Contents</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.rtContentsImpl
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getrtContents()
   * @generated
   */
  int RT_CONTENTS = 2;

  /**
   * The number of structural features of the '<em>rt Contents</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RT_CONTENTS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.GlobalVariableDeclarationImpl <em>Global Variable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.GlobalVariableDeclarationImpl
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getGlobalVariableDeclaration()
   * @generated
   */
  int GLOBAL_VARIABLE_DECLARATION = 3;

  /**
   * The feature id for the '<em><b>Persistent</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_VARIABLE_DECLARATION__PERSISTENT = 0;

  /**
   * The feature id for the '<em><b>Var Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_VARIABLE_DECLARATION__VAR_DECL = 1;

  /**
   * The number of structural features of the '<em>Global Variable Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_VARIABLE_DECLARATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.StrategyDeclarationImpl <em>Strategy Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.StrategyDeclarationImpl
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getStrategyDeclaration()
   * @generated
   */
  int STRATEGY_DECLARATION = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY_DECLARATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Param List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY_DECLARATION__PARAM_LIST = 1;

  /**
   * The feature id for the '<em><b>Conditions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY_DECLARATION__CONDITIONS = 2;

  /**
   * The feature id for the '<em><b>Var Decls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY_DECLARATION__VAR_DECLS = 3;

  /**
   * The feature id for the '<em><b>Objective</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY_DECLARATION__OBJECTIVE = 4;

  /**
   * The feature id for the '<em><b>Breakdown</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY_DECLARATION__BREAKDOWN = 5;

  /**
   * The feature id for the '<em><b>Post</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY_DECLARATION__POST = 6;

  /**
   * The number of structural features of the '<em>Strategy Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRATEGY_DECLARATION_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.BreakdownElementImpl <em>Breakdown Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.BreakdownElementImpl
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getBreakdownElement()
   * @generated
   */
  int BREAKDOWN_ELEMENT = 5;

  /**
   * The feature id for the '<em><b>Var Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAKDOWN_ELEMENT__VAR_DECL = 0;

  /**
   * The feature id for the '<em><b>Expr Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAKDOWN_ELEMENT__EXPR_STMT = 1;

  /**
   * The feature id for the '<em><b>Breakdown Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAKDOWN_ELEMENT__BREAKDOWN_STMT = 2;

  /**
   * The number of structural features of the '<em>Breakdown Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAKDOWN_ELEMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.BreakdownStatementImpl <em>Breakdown Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.BreakdownStatementImpl
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getBreakdownStatement()
   * @generated
   */
  int BREAKDOWN_STATEMENT = 6;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAKDOWN_STATEMENT__TYPE = 0;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAKDOWN_STATEMENT__GUARD = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAKDOWN_STATEMENT__NAME = 2;

  /**
   * The feature id for the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAKDOWN_STATEMENT__PARAM = 3;

  /**
   * The feature id for the '<em><b>Part</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAKDOWN_STATEMENT__PART = 4;

  /**
   * The feature id for the '<em><b>Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAKDOWN_STATEMENT__TIME = 5;

  /**
   * The number of structural features of the '<em>Breakdown Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAKDOWN_STATEMENT_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.BreakdownWithPartImpl <em>Breakdown With Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.BreakdownWithPartImpl
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getBreakdownWithPart()
   * @generated
   */
  int BREAKDOWN_WITH_PART = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAKDOWN_WITH_PART__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAKDOWN_WITH_PART__VALUE = 1;

  /**
   * The number of structural features of the '<em>Breakdown With Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BREAKDOWN_WITH_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.TacticDeclarationImpl <em>Tactic Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.TacticDeclarationImpl
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getTacticDeclaration()
   * @generated
   */
  int TACTIC_DECLARATION = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TACTIC_DECLARATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Param List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TACTIC_DECLARATION__PARAM_LIST = 1;

  /**
   * The feature id for the '<em><b>Conditions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TACTIC_DECLARATION__CONDITIONS = 2;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TACTIC_DECLARATION__BLOCK = 3;

  /**
   * The number of structural features of the '<em>Tactic Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TACTIC_DECLARATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.ScriptContentsImpl <em>Script Contents</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.ScriptContentsImpl
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getScriptContents()
   * @generated
   */
  int SCRIPT_CONTENTS = 9;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCRIPT_CONTENTS__ELEMENTS = RT_CONTENTS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Script Contents</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCRIPT_CONTENTS_FEATURE_COUNT = RT_CONTENTS_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.ImplementationUnit <em>Implementation Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Implementation Unit</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.ImplementationUnit
   * @generated
   */
  EClass getImplementationUnit();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.LanguageUnit <em>Language Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Language Unit</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.LanguageUnit
   * @generated
   */
  EClass getLanguageUnit();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.rt.rtVil.LanguageUnit#getRtContents <em>Rt Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rt Contents</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.LanguageUnit#getRtContents()
   * @see #getLanguageUnit()
   * @generated
   */
  EReference getLanguageUnit_RtContents();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.rtContents <em>rt Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>rt Contents</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.rtContents
   * @generated
   */
  EClass getrtContents();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.GlobalVariableDeclaration <em>Global Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Global Variable Declaration</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.GlobalVariableDeclaration
   * @generated
   */
  EClass getGlobalVariableDeclaration();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.rt.rtVil.GlobalVariableDeclaration#getPersistent <em>Persistent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Persistent</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.GlobalVariableDeclaration#getPersistent()
   * @see #getGlobalVariableDeclaration()
   * @generated
   */
  EAttribute getGlobalVariableDeclaration_Persistent();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.rt.rtVil.GlobalVariableDeclaration#getVarDecl <em>Var Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var Decl</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.GlobalVariableDeclaration#getVarDecl()
   * @see #getGlobalVariableDeclaration()
   * @generated
   */
  EReference getGlobalVariableDeclaration_VarDecl();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration <em>Strategy Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Strategy Declaration</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration
   * @generated
   */
  EClass getStrategyDeclaration();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getName()
   * @see #getStrategyDeclaration()
   * @generated
   */
  EAttribute getStrategyDeclaration_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getParamList <em>Param List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param List</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getParamList()
   * @see #getStrategyDeclaration()
   * @generated
   */
  EReference getStrategyDeclaration_ParamList();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getConditions <em>Conditions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Conditions</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getConditions()
   * @see #getStrategyDeclaration()
   * @generated
   */
  EReference getStrategyDeclaration_Conditions();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getVarDecls <em>Var Decls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Var Decls</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getVarDecls()
   * @see #getStrategyDeclaration()
   * @generated
   */
  EReference getStrategyDeclaration_VarDecls();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getObjective <em>Objective</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Objective</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getObjective()
   * @see #getStrategyDeclaration()
   * @generated
   */
  EReference getStrategyDeclaration_Objective();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getBreakdown <em>Breakdown</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Breakdown</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getBreakdown()
   * @see #getStrategyDeclaration()
   * @generated
   */
  EReference getStrategyDeclaration_Breakdown();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getPost <em>Post</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Post</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getPost()
   * @see #getStrategyDeclaration()
   * @generated
   */
  EReference getStrategyDeclaration_Post();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement <em>Breakdown Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Breakdown Element</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement
   * @generated
   */
  EClass getBreakdownElement();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement#getVarDecl <em>Var Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var Decl</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement#getVarDecl()
   * @see #getBreakdownElement()
   * @generated
   */
  EReference getBreakdownElement_VarDecl();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement#getExprStmt <em>Expr Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr Stmt</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement#getExprStmt()
   * @see #getBreakdownElement()
   * @generated
   */
  EReference getBreakdownElement_ExprStmt();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement#getBreakdownStmt <em>Breakdown Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Breakdown Stmt</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement#getBreakdownStmt()
   * @see #getBreakdownElement()
   * @generated
   */
  EReference getBreakdownElement_BreakdownStmt();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement <em>Breakdown Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Breakdown Statement</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement
   * @generated
   */
  EClass getBreakdownStatement();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getType()
   * @see #getBreakdownStatement()
   * @generated
   */
  EAttribute getBreakdownStatement_Type();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getGuard()
   * @see #getBreakdownStatement()
   * @generated
   */
  EReference getBreakdownStatement_Guard();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getName()
   * @see #getBreakdownStatement()
   * @generated
   */
  EReference getBreakdownStatement_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getParam()
   * @see #getBreakdownStatement()
   * @generated
   */
  EReference getBreakdownStatement_Param();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getPart <em>Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Part</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getPart()
   * @see #getBreakdownStatement()
   * @generated
   */
  EReference getBreakdownStatement_Part();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getTime <em>Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Time</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getTime()
   * @see #getBreakdownStatement()
   * @generated
   */
  EReference getBreakdownStatement_Time();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownWithPart <em>Breakdown With Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Breakdown With Part</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownWithPart
   * @generated
   */
  EClass getBreakdownWithPart();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownWithPart#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownWithPart#getName()
   * @see #getBreakdownWithPart()
   * @generated
   */
  EAttribute getBreakdownWithPart_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownWithPart#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownWithPart#getValue()
   * @see #getBreakdownWithPart()
   * @generated
   */
  EReference getBreakdownWithPart_Value();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration <em>Tactic Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tactic Declaration</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration
   * @generated
   */
  EClass getTacticDeclaration();

  /**
   * Returns the meta object for the attribute '{@link de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration#getName()
   * @see #getTacticDeclaration()
   * @generated
   */
  EAttribute getTacticDeclaration_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration#getParamList <em>Param List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param List</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration#getParamList()
   * @see #getTacticDeclaration()
   * @generated
   */
  EReference getTacticDeclaration_ParamList();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration#getConditions <em>Conditions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Conditions</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration#getConditions()
   * @see #getTacticDeclaration()
   * @generated
   */
  EReference getTacticDeclaration_Conditions();

  /**
   * Returns the meta object for the containment reference '{@link de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration#getBlock()
   * @see #getTacticDeclaration()
   * @generated
   */
  EReference getTacticDeclaration_Block();

  /**
   * Returns the meta object for class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.ScriptContents <em>Script Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Script Contents</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.ScriptContents
   * @generated
   */
  EClass getScriptContents();

  /**
   * Returns the meta object for the containment reference list '{@link de.uni_hildesheim.sse.vil.rt.rtVil.ScriptContents#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.ScriptContents#getElements()
   * @see #getScriptContents()
   * @generated
   */
  EReference getScriptContents_Elements();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  RtVilFactory getRtVilFactory();

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
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.ImplementationUnitImpl <em>Implementation Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.ImplementationUnitImpl
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getImplementationUnit()
     * @generated
     */
    EClass IMPLEMENTATION_UNIT = eINSTANCE.getImplementationUnit();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.LanguageUnitImpl <em>Language Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.LanguageUnitImpl
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getLanguageUnit()
     * @generated
     */
    EClass LANGUAGE_UNIT = eINSTANCE.getLanguageUnit();

    /**
     * The meta object literal for the '<em><b>Rt Contents</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LANGUAGE_UNIT__RT_CONTENTS = eINSTANCE.getLanguageUnit_RtContents();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.rtContentsImpl <em>rt Contents</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.rtContentsImpl
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getrtContents()
     * @generated
     */
    EClass RT_CONTENTS = eINSTANCE.getrtContents();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.GlobalVariableDeclarationImpl <em>Global Variable Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.GlobalVariableDeclarationImpl
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getGlobalVariableDeclaration()
     * @generated
     */
    EClass GLOBAL_VARIABLE_DECLARATION = eINSTANCE.getGlobalVariableDeclaration();

    /**
     * The meta object literal for the '<em><b>Persistent</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GLOBAL_VARIABLE_DECLARATION__PERSISTENT = eINSTANCE.getGlobalVariableDeclaration_Persistent();

    /**
     * The meta object literal for the '<em><b>Var Decl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GLOBAL_VARIABLE_DECLARATION__VAR_DECL = eINSTANCE.getGlobalVariableDeclaration_VarDecl();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.StrategyDeclarationImpl <em>Strategy Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.StrategyDeclarationImpl
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getStrategyDeclaration()
     * @generated
     */
    EClass STRATEGY_DECLARATION = eINSTANCE.getStrategyDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRATEGY_DECLARATION__NAME = eINSTANCE.getStrategyDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Param List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRATEGY_DECLARATION__PARAM_LIST = eINSTANCE.getStrategyDeclaration_ParamList();

    /**
     * The meta object literal for the '<em><b>Conditions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRATEGY_DECLARATION__CONDITIONS = eINSTANCE.getStrategyDeclaration_Conditions();

    /**
     * The meta object literal for the '<em><b>Var Decls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRATEGY_DECLARATION__VAR_DECLS = eINSTANCE.getStrategyDeclaration_VarDecls();

    /**
     * The meta object literal for the '<em><b>Objective</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRATEGY_DECLARATION__OBJECTIVE = eINSTANCE.getStrategyDeclaration_Objective();

    /**
     * The meta object literal for the '<em><b>Breakdown</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRATEGY_DECLARATION__BREAKDOWN = eINSTANCE.getStrategyDeclaration_Breakdown();

    /**
     * The meta object literal for the '<em><b>Post</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRATEGY_DECLARATION__POST = eINSTANCE.getStrategyDeclaration_Post();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.BreakdownElementImpl <em>Breakdown Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.BreakdownElementImpl
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getBreakdownElement()
     * @generated
     */
    EClass BREAKDOWN_ELEMENT = eINSTANCE.getBreakdownElement();

    /**
     * The meta object literal for the '<em><b>Var Decl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BREAKDOWN_ELEMENT__VAR_DECL = eINSTANCE.getBreakdownElement_VarDecl();

    /**
     * The meta object literal for the '<em><b>Expr Stmt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BREAKDOWN_ELEMENT__EXPR_STMT = eINSTANCE.getBreakdownElement_ExprStmt();

    /**
     * The meta object literal for the '<em><b>Breakdown Stmt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BREAKDOWN_ELEMENT__BREAKDOWN_STMT = eINSTANCE.getBreakdownElement_BreakdownStmt();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.BreakdownStatementImpl <em>Breakdown Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.BreakdownStatementImpl
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getBreakdownStatement()
     * @generated
     */
    EClass BREAKDOWN_STATEMENT = eINSTANCE.getBreakdownStatement();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BREAKDOWN_STATEMENT__TYPE = eINSTANCE.getBreakdownStatement_Type();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BREAKDOWN_STATEMENT__GUARD = eINSTANCE.getBreakdownStatement_Guard();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BREAKDOWN_STATEMENT__NAME = eINSTANCE.getBreakdownStatement_Name();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BREAKDOWN_STATEMENT__PARAM = eINSTANCE.getBreakdownStatement_Param();

    /**
     * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BREAKDOWN_STATEMENT__PART = eINSTANCE.getBreakdownStatement_Part();

    /**
     * The meta object literal for the '<em><b>Time</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BREAKDOWN_STATEMENT__TIME = eINSTANCE.getBreakdownStatement_Time();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.BreakdownWithPartImpl <em>Breakdown With Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.BreakdownWithPartImpl
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getBreakdownWithPart()
     * @generated
     */
    EClass BREAKDOWN_WITH_PART = eINSTANCE.getBreakdownWithPart();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BREAKDOWN_WITH_PART__NAME = eINSTANCE.getBreakdownWithPart_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BREAKDOWN_WITH_PART__VALUE = eINSTANCE.getBreakdownWithPart_Value();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.TacticDeclarationImpl <em>Tactic Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.TacticDeclarationImpl
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getTacticDeclaration()
     * @generated
     */
    EClass TACTIC_DECLARATION = eINSTANCE.getTacticDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TACTIC_DECLARATION__NAME = eINSTANCE.getTacticDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Param List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TACTIC_DECLARATION__PARAM_LIST = eINSTANCE.getTacticDeclaration_ParamList();

    /**
     * The meta object literal for the '<em><b>Conditions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TACTIC_DECLARATION__CONDITIONS = eINSTANCE.getTacticDeclaration_Conditions();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TACTIC_DECLARATION__BLOCK = eINSTANCE.getTacticDeclaration_Block();

    /**
     * The meta object literal for the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.ScriptContentsImpl <em>Script Contents</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.ScriptContentsImpl
     * @see de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilPackageImpl#getScriptContents()
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

  }

} //RtVilPackage
