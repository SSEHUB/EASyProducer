/**
 */
package de.uni_hildesheim.sse.vil.rt.rtVil;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage
 * @generated
 */
public interface RtVilFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  RtVilFactory eINSTANCE = de.uni_hildesheim.sse.vil.rt.rtVil.impl.RtVilFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Implementation Unit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Implementation Unit</em>'.
   * @generated
   */
  ImplementationUnit createImplementationUnit();

  /**
   * Returns a new object of class '<em>Language Unit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Language Unit</em>'.
   * @generated
   */
  LanguageUnit createLanguageUnit();

  /**
   * Returns a new object of class '<em>rt Contents</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>rt Contents</em>'.
   * @generated
   */
  rtContents creatertContents();

  /**
   * Returns a new object of class '<em>Global Variable Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Global Variable Declaration</em>'.
   * @generated
   */
  GlobalVariableDeclaration createGlobalVariableDeclaration();

  /**
   * Returns a new object of class '<em>Strategy Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Strategy Declaration</em>'.
   * @generated
   */
  StrategyDeclaration createStrategyDeclaration();

  /**
   * Returns a new object of class '<em>Breakdown Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Breakdown Element</em>'.
   * @generated
   */
  BreakdownElement createBreakdownElement();

  /**
   * Returns a new object of class '<em>Weighting Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Weighting Statement</em>'.
   * @generated
   */
  WeightingStatement createWeightingStatement();

  /**
   * Returns a new object of class '<em>Breakdown Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Breakdown Statement</em>'.
   * @generated
   */
  BreakdownStatement createBreakdownStatement();

  /**
   * Returns a new object of class '<em>Breakdown With Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Breakdown With Part</em>'.
   * @generated
   */
  BreakdownWithPart createBreakdownWithPart();

  /**
   * Returns a new object of class '<em>Tactic Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tactic Declaration</em>'.
   * @generated
   */
  TacticDeclaration createTacticDeclaration();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  RtVilPackage getRtVilPackage();

} //RtVilFactory
