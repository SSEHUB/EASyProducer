/**
 * generated by Xtext 2.35.0
 */
package de.uni_hildesheim.sse.vil.rt.rtVil;

import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.RuleConditions;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tactic Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration#getParamList <em>Param List</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration#getConditions <em>Conditions</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getTacticDeclaration()
 * @model
 * @generated
 */
public interface TacticDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getTacticDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Param List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param List</em>' containment reference.
   * @see #setParamList(ParameterList)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getTacticDeclaration_ParamList()
   * @model containment="true"
   * @generated
   */
  ParameterList getParamList();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration#getParamList <em>Param List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param List</em>' containment reference.
   * @see #getParamList()
   * @generated
   */
  void setParamList(ParameterList value);

  /**
   * Returns the value of the '<em><b>Conditions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conditions</em>' containment reference.
   * @see #setConditions(RuleConditions)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getTacticDeclaration_Conditions()
   * @model containment="true"
   * @generated
   */
  RuleConditions getConditions();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration#getConditions <em>Conditions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Conditions</em>' containment reference.
   * @see #getConditions()
   * @generated
   */
  void setConditions(RuleConditions value);

  /**
   * Returns the value of the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Block</em>' containment reference.
   * @see #setBlock(RuleElementBlock)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getTacticDeclaration_Block()
   * @model containment="true"
   * @generated
   */
  RuleElementBlock getBlock();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration#getBlock <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block</em>' containment reference.
   * @see #getBlock()
   * @generated
   */
  void setBlock(RuleElementBlock value);

} // TacticDeclaration
