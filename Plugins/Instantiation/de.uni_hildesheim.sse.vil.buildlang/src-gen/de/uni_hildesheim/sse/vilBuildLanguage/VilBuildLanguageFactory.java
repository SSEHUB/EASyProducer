/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage
 * @generated
 */
public interface VilBuildLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  VilBuildLanguageFactory eINSTANCE = de.uni_hildesheim.sse.vilBuildLanguage.impl.VilBuildLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Implementation Unit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Implementation Unit</em>'.
   * @generated
   */
  ImplementationUnit createImplementationUnit();

  /**
   * Returns a new object of class '<em>Require</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Require</em>'.
   * @generated
   */
  Require createRequire();

  /**
   * Returns a new object of class '<em>Language Unit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Language Unit</em>'.
   * @generated
   */
  LanguageUnit createLanguageUnit();

  /**
   * Returns a new object of class '<em>Script Parent Decl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Script Parent Decl</em>'.
   * @generated
   */
  ScriptParentDecl createScriptParentDecl();

  /**
   * Returns a new object of class '<em>Load Properties</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Load Properties</em>'.
   * @generated
   */
  LoadProperties createLoadProperties();

  /**
   * Returns a new object of class '<em>Script Contents</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Script Contents</em>'.
   * @generated
   */
  ScriptContents createScriptContents();

  /**
   * Returns a new object of class '<em>Rule Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Declaration</em>'.
   * @generated
   */
  RuleDeclaration createRuleDeclaration();

  /**
   * Returns a new object of class '<em>Rule Element Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Element Block</em>'.
   * @generated
   */
  RuleElementBlock createRuleElementBlock();

  /**
   * Returns a new object of class '<em>Rule Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Element</em>'.
   * @generated
   */
  RuleElement createRuleElement();

  /**
   * Returns a new object of class '<em>Rule Modifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Modifier</em>'.
   * @generated
   */
  RuleModifier createRuleModifier();

  /**
   * Returns a new object of class '<em>Defer Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Defer Declaration</em>'.
   * @generated
   */
  DeferDeclaration createDeferDeclaration();

  /**
   * Returns a new object of class '<em>Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primary Expression</em>'.
   * @generated
   */
  PrimaryExpression createPrimaryExpression();

  /**
   * Returns a new object of class '<em>Instantiate</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instantiate</em>'.
   * @generated
   */
  Instantiate createInstantiate();

  /**
   * Returns a new object of class '<em>Map Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Map Variable</em>'.
   * @generated
   */
  MapVariable createMapVariable();

  /**
   * Returns a new object of class '<em>Map</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Map</em>'.
   * @generated
   */
  Map createMap();

  /**
   * Returns a new object of class '<em>Join</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Join</em>'.
   * @generated
   */
  Join createJoin();

  /**
   * Returns a new object of class '<em>Join Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Join Variable</em>'.
   * @generated
   */
  JoinVariable createJoinVariable();

  /**
   * Returns a new object of class '<em>System Execution</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>System Execution</em>'.
   * @generated
   */
  SystemExecution createSystemExecution();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  VilBuildLanguagePackage getVilBuildLanguagePackage();

} //VilBuildLanguageFactory
