/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;

import de.uni_hildesheim.sse.vilBuildLanguage.DeferDeclaration;
import de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit;
import de.uni_hildesheim.sse.vilBuildLanguage.Instantiate;
import de.uni_hildesheim.sse.vilBuildLanguage.Join;
import de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable;
import de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit;
import de.uni_hildesheim.sse.vilBuildLanguage.LoadProperties;
import de.uni_hildesheim.sse.vilBuildLanguage.Map;
import de.uni_hildesheim.sse.vilBuildLanguage.MapVariable;
import de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression;
import de.uni_hildesheim.sse.vilBuildLanguage.Require;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleElement;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleElementBlock;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleModifier;
import de.uni_hildesheim.sse.vilBuildLanguage.ScriptContents;
import de.uni_hildesheim.sse.vilBuildLanguage.ScriptParentDecl;
import de.uni_hildesheim.sse.vilBuildLanguage.SystemExecution;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguageFactory;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VilBuildLanguagePackageImpl extends EPackageImpl implements VilBuildLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass implementationUnitEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass requireEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass languageUnitEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scriptParentDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loadPropertiesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass scriptContentsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleElementBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleModifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass deferDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass instantiateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mapVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mapEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass joinEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass joinVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass systemExecutionEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private VilBuildLanguagePackageImpl()
  {
    super(eNS_URI, VilBuildLanguageFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link VilBuildLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static VilBuildLanguagePackage init()
  {
    if (isInited) return (VilBuildLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(VilBuildLanguagePackage.eNS_URI);

    // Obtain or create and register package
    VilBuildLanguagePackageImpl theVilBuildLanguagePackage = (VilBuildLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VilBuildLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VilBuildLanguagePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    ExpressionDslPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theVilBuildLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theVilBuildLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theVilBuildLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(VilBuildLanguagePackage.eNS_URI, theVilBuildLanguagePackage);
    return theVilBuildLanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImplementationUnit()
  {
    return implementationUnitEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImplementationUnit_Imports()
  {
    return (EReference)implementationUnitEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImplementationUnit_Requires()
  {
    return (EReference)implementationUnitEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImplementationUnit_Scripts()
  {
    return (EReference)implementationUnitEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRequire()
  {
    return requireEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRequire_Name()
  {
    return (EAttribute)requireEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequire_VersionSpec()
  {
    return (EReference)requireEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLanguageUnit()
  {
    return languageUnitEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLanguageUnit_Param()
  {
    return (EReference)languageUnitEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLanguageUnit_Parent()
  {
    return (EReference)languageUnitEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLanguageUnit_LoadProperties()
  {
    return (EReference)languageUnitEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLanguageUnit_Contents()
  {
    return (EReference)languageUnitEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScriptParentDecl()
  {
    return scriptParentDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getScriptParentDecl_Name()
  {
    return (EAttribute)scriptParentDeclEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLoadProperties()
  {
    return loadPropertiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoadProperties_Path()
  {
    return (EAttribute)loadPropertiesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScriptContents()
  {
    return scriptContentsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getScriptContents_Elements()
  {
    return (EReference)scriptContentsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleDeclaration()
  {
    return ruleDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleDeclaration_Modifier()
  {
    return (EReference)ruleDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRuleDeclaration_Name()
  {
    return (EAttribute)ruleDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleDeclaration_ParamList()
  {
    return (EReference)ruleDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleDeclaration_Postcondition()
  {
    return (EReference)ruleDeclarationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleDeclaration_Preconditions()
  {
    return (EReference)ruleDeclarationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleDeclaration_Block()
  {
    return (EReference)ruleDeclarationEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleElementBlock()
  {
    return ruleElementBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleElementBlock_Elements()
  {
    return (EReference)ruleElementBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleElement()
  {
    return ruleElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleElement_VarDecl()
  {
    return (EReference)ruleElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleElement_ExprStmt()
  {
    return (EReference)ruleElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleElement_DeferDecl()
  {
    return (EReference)ruleElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleModifier()
  {
    return ruleModifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRuleModifier_Protected()
  {
    return (EAttribute)ruleModifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDeferDeclaration()
  {
    return deferDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDeferDeclaration_Name()
  {
    return (EAttribute)deferDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDeferDeclaration_Depends()
  {
    return (EAttribute)deferDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimaryExpression()
  {
    return primaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryExpression_SysEx()
  {
    return (EReference)primaryExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryExpression_Map()
  {
    return (EReference)primaryExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryExpression_Join()
  {
    return (EReference)primaryExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimaryExpression_Instantiate()
  {
    return (EReference)primaryExpressionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInstantiate()
  {
    return instantiateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInstantiate_Project()
  {
    return (EAttribute)instantiateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInstantiate_Rule()
  {
    return (EAttribute)instantiateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInstantiate_RuleName()
  {
    return (EAttribute)instantiateEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstantiate_Param()
  {
    return (EReference)instantiateEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstantiate_VersionSpec()
  {
    return (EReference)instantiateEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMapVariable()
  {
    return mapVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMapVariable_Type()
  {
    return (EReference)mapVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMapVariable_Var()
  {
    return (EAttribute)mapVariableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMap()
  {
    return mapEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMap_Var()
  {
    return (EReference)mapEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMap_Separator()
  {
    return (EAttribute)mapEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMap_Expr()
  {
    return (EReference)mapEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMap_Block()
  {
    return (EReference)mapEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJoin()
  {
    return joinEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJoin_Var1()
  {
    return (EReference)joinEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJoin_Var2()
  {
    return (EReference)joinEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJoin_Condition()
  {
    return (EReference)joinEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJoinVariable()
  {
    return joinVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJoinVariable_Excl()
  {
    return (EAttribute)joinVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJoinVariable_Var()
  {
    return (EAttribute)joinVariableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJoinVariable_Expr()
  {
    return (EReference)joinVariableEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSystemExecution()
  {
    return systemExecutionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSystemExecution_Call()
  {
    return (EReference)systemExecutionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSystemExecution_Calls()
  {
    return (EReference)systemExecutionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VilBuildLanguageFactory getVilBuildLanguageFactory()
  {
    return (VilBuildLanguageFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    implementationUnitEClass = createEClass(IMPLEMENTATION_UNIT);
    createEReference(implementationUnitEClass, IMPLEMENTATION_UNIT__IMPORTS);
    createEReference(implementationUnitEClass, IMPLEMENTATION_UNIT__REQUIRES);
    createEReference(implementationUnitEClass, IMPLEMENTATION_UNIT__SCRIPTS);

    requireEClass = createEClass(REQUIRE);
    createEAttribute(requireEClass, REQUIRE__NAME);
    createEReference(requireEClass, REQUIRE__VERSION_SPEC);

    languageUnitEClass = createEClass(LANGUAGE_UNIT);
    createEReference(languageUnitEClass, LANGUAGE_UNIT__PARAM);
    createEReference(languageUnitEClass, LANGUAGE_UNIT__PARENT);
    createEReference(languageUnitEClass, LANGUAGE_UNIT__LOAD_PROPERTIES);
    createEReference(languageUnitEClass, LANGUAGE_UNIT__CONTENTS);

    scriptParentDeclEClass = createEClass(SCRIPT_PARENT_DECL);
    createEAttribute(scriptParentDeclEClass, SCRIPT_PARENT_DECL__NAME);

    loadPropertiesEClass = createEClass(LOAD_PROPERTIES);
    createEAttribute(loadPropertiesEClass, LOAD_PROPERTIES__PATH);

    scriptContentsEClass = createEClass(SCRIPT_CONTENTS);
    createEReference(scriptContentsEClass, SCRIPT_CONTENTS__ELEMENTS);

    ruleDeclarationEClass = createEClass(RULE_DECLARATION);
    createEReference(ruleDeclarationEClass, RULE_DECLARATION__MODIFIER);
    createEAttribute(ruleDeclarationEClass, RULE_DECLARATION__NAME);
    createEReference(ruleDeclarationEClass, RULE_DECLARATION__PARAM_LIST);
    createEReference(ruleDeclarationEClass, RULE_DECLARATION__POSTCONDITION);
    createEReference(ruleDeclarationEClass, RULE_DECLARATION__PRECONDITIONS);
    createEReference(ruleDeclarationEClass, RULE_DECLARATION__BLOCK);

    ruleElementBlockEClass = createEClass(RULE_ELEMENT_BLOCK);
    createEReference(ruleElementBlockEClass, RULE_ELEMENT_BLOCK__ELEMENTS);

    ruleElementEClass = createEClass(RULE_ELEMENT);
    createEReference(ruleElementEClass, RULE_ELEMENT__VAR_DECL);
    createEReference(ruleElementEClass, RULE_ELEMENT__EXPR_STMT);
    createEReference(ruleElementEClass, RULE_ELEMENT__DEFER_DECL);

    ruleModifierEClass = createEClass(RULE_MODIFIER);
    createEAttribute(ruleModifierEClass, RULE_MODIFIER__PROTECTED);

    deferDeclarationEClass = createEClass(DEFER_DECLARATION);
    createEAttribute(deferDeclarationEClass, DEFER_DECLARATION__NAME);
    createEAttribute(deferDeclarationEClass, DEFER_DECLARATION__DEPENDS);

    primaryExpressionEClass = createEClass(PRIMARY_EXPRESSION);
    createEReference(primaryExpressionEClass, PRIMARY_EXPRESSION__SYS_EX);
    createEReference(primaryExpressionEClass, PRIMARY_EXPRESSION__MAP);
    createEReference(primaryExpressionEClass, PRIMARY_EXPRESSION__JOIN);
    createEReference(primaryExpressionEClass, PRIMARY_EXPRESSION__INSTANTIATE);

    instantiateEClass = createEClass(INSTANTIATE);
    createEAttribute(instantiateEClass, INSTANTIATE__PROJECT);
    createEAttribute(instantiateEClass, INSTANTIATE__RULE);
    createEAttribute(instantiateEClass, INSTANTIATE__RULE_NAME);
    createEReference(instantiateEClass, INSTANTIATE__PARAM);
    createEReference(instantiateEClass, INSTANTIATE__VERSION_SPEC);

    mapVariableEClass = createEClass(MAP_VARIABLE);
    createEReference(mapVariableEClass, MAP_VARIABLE__TYPE);
    createEAttribute(mapVariableEClass, MAP_VARIABLE__VAR);

    mapEClass = createEClass(MAP);
    createEReference(mapEClass, MAP__VAR);
    createEAttribute(mapEClass, MAP__SEPARATOR);
    createEReference(mapEClass, MAP__EXPR);
    createEReference(mapEClass, MAP__BLOCK);

    joinEClass = createEClass(JOIN);
    createEReference(joinEClass, JOIN__VAR1);
    createEReference(joinEClass, JOIN__VAR2);
    createEReference(joinEClass, JOIN__CONDITION);

    joinVariableEClass = createEClass(JOIN_VARIABLE);
    createEAttribute(joinVariableEClass, JOIN_VARIABLE__EXCL);
    createEAttribute(joinVariableEClass, JOIN_VARIABLE__VAR);
    createEReference(joinVariableEClass, JOIN_VARIABLE__EXPR);

    systemExecutionEClass = createEClass(SYSTEM_EXECUTION);
    createEReference(systemExecutionEClass, SYSTEM_EXECUTION__CALL);
    createEReference(systemExecutionEClass, SYSTEM_EXECUTION__CALLS);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    ExpressionDslPackage theExpressionDslPackage = (ExpressionDslPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionDslPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    languageUnitEClass.getESuperTypes().add(theExpressionDslPackage.getLanguageUnit());
    primaryExpressionEClass.getESuperTypes().add(theExpressionDslPackage.getPrimaryExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(implementationUnitEClass, ImplementationUnit.class, "ImplementationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getImplementationUnit_Imports(), theExpressionDslPackage.getImport(), null, "imports", null, 0, -1, ImplementationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getImplementationUnit_Requires(), this.getRequire(), null, "requires", null, 0, -1, ImplementationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getImplementationUnit_Scripts(), this.getLanguageUnit(), null, "scripts", null, 0, -1, ImplementationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(requireEClass, Require.class, "Require", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRequire_Name(), ecorePackage.getEString(), "name", null, 0, 1, Require.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequire_VersionSpec(), theExpressionDslPackage.getVersionSpec(), null, "versionSpec", null, 0, 1, Require.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(languageUnitEClass, LanguageUnit.class, "LanguageUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLanguageUnit_Param(), theExpressionDslPackage.getParameterList(), null, "param", null, 0, 1, LanguageUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLanguageUnit_Parent(), this.getScriptParentDecl(), null, "parent", null, 0, 1, LanguageUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLanguageUnit_LoadProperties(), this.getLoadProperties(), null, "loadProperties", null, 0, -1, LanguageUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLanguageUnit_Contents(), this.getScriptContents(), null, "contents", null, 0, 1, LanguageUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scriptParentDeclEClass, ScriptParentDecl.class, "ScriptParentDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getScriptParentDecl_Name(), ecorePackage.getEString(), "name", null, 0, 1, ScriptParentDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loadPropertiesEClass, LoadProperties.class, "LoadProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLoadProperties_Path(), ecorePackage.getEString(), "path", null, 0, 1, LoadProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(scriptContentsEClass, ScriptContents.class, "ScriptContents", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getScriptContents_Elements(), ecorePackage.getEObject(), null, "elements", null, 0, -1, ScriptContents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleDeclarationEClass, RuleDeclaration.class, "RuleDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRuleDeclaration_Modifier(), this.getRuleModifier(), null, "modifier", null, 0, 1, RuleDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRuleDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, RuleDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleDeclaration_ParamList(), theExpressionDslPackage.getParameterList(), null, "paramList", null, 0, 1, RuleDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleDeclaration_Postcondition(), theExpressionDslPackage.getLogicalExpression(), null, "postcondition", null, 0, -1, RuleDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleDeclaration_Preconditions(), theExpressionDslPackage.getLogicalExpression(), null, "preconditions", null, 0, -1, RuleDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleDeclaration_Block(), this.getRuleElementBlock(), null, "block", null, 0, 1, RuleDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleElementBlockEClass, RuleElementBlock.class, "RuleElementBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRuleElementBlock_Elements(), this.getRuleElement(), null, "elements", null, 0, -1, RuleElementBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleElementEClass, RuleElement.class, "RuleElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRuleElement_VarDecl(), theExpressionDslPackage.getVariableDeclaration(), null, "varDecl", null, 0, 1, RuleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleElement_ExprStmt(), theExpressionDslPackage.getExpressionStatement(), null, "exprStmt", null, 0, 1, RuleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleElement_DeferDecl(), this.getDeferDeclaration(), null, "deferDecl", null, 0, 1, RuleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleModifierEClass, RuleModifier.class, "RuleModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRuleModifier_Protected(), ecorePackage.getEString(), "protected", null, 0, 1, RuleModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(deferDeclarationEClass, DeferDeclaration.class, "DeferDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDeferDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, DeferDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDeferDeclaration_Depends(), ecorePackage.getEString(), "depends", null, 0, -1, DeferDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(primaryExpressionEClass, PrimaryExpression.class, "PrimaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPrimaryExpression_SysEx(), this.getSystemExecution(), null, "sysEx", null, 0, 1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPrimaryExpression_Map(), this.getMap(), null, "map", null, 0, 1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPrimaryExpression_Join(), this.getJoin(), null, "join", null, 0, 1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPrimaryExpression_Instantiate(), this.getInstantiate(), null, "instantiate", null, 0, 1, PrimaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(instantiateEClass, Instantiate.class, "Instantiate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInstantiate_Project(), ecorePackage.getEString(), "project", null, 0, 1, Instantiate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInstantiate_Rule(), ecorePackage.getEString(), "rule", null, 0, 1, Instantiate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInstantiate_RuleName(), ecorePackage.getEString(), "ruleName", null, 0, 1, Instantiate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInstantiate_Param(), theExpressionDslPackage.getArgumentList(), null, "param", null, 0, 1, Instantiate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInstantiate_VersionSpec(), theExpressionDslPackage.getVersionSpec(), null, "versionSpec", null, 0, 1, Instantiate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mapVariableEClass, MapVariable.class, "MapVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMapVariable_Type(), theExpressionDslPackage.getType(), null, "type", null, 0, 1, MapVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMapVariable_Var(), ecorePackage.getEString(), "var", null, 0, 1, MapVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mapEClass, Map.class, "Map", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMap_Var(), this.getMapVariable(), null, "var", null, 0, -1, Map.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMap_Separator(), ecorePackage.getEString(), "separator", null, 0, 1, Map.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMap_Expr(), theExpressionDslPackage.getExpression(), null, "expr", null, 0, 1, Map.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMap_Block(), this.getRuleElementBlock(), null, "block", null, 0, 1, Map.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(joinEClass, Join.class, "Join", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getJoin_Var1(), this.getJoinVariable(), null, "var1", null, 0, 1, Join.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getJoin_Var2(), this.getJoinVariable(), null, "var2", null, 0, 1, Join.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getJoin_Condition(), theExpressionDslPackage.getExpression(), null, "condition", null, 0, 1, Join.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(joinVariableEClass, JoinVariable.class, "JoinVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getJoinVariable_Excl(), ecorePackage.getEString(), "excl", null, 0, 1, JoinVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getJoinVariable_Var(), ecorePackage.getEString(), "var", null, 0, 1, JoinVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getJoinVariable_Expr(), theExpressionDslPackage.getExpression(), null, "expr", null, 0, 1, JoinVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(systemExecutionEClass, SystemExecution.class, "SystemExecution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSystemExecution_Call(), theExpressionDslPackage.getCall(), null, "call", null, 0, 1, SystemExecution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSystemExecution_Calls(), theExpressionDslPackage.getSubCall(), null, "calls", null, 0, -1, SystemExecution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //VilBuildLanguagePackageImpl
