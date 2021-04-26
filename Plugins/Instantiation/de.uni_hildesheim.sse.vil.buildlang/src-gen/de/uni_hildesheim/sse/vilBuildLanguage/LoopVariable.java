/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.LoopVariable#getType <em>Type</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.LoopVariable#getVar <em>Var</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getLoopVariable()
 * @model
 * @generated
 */
public interface LoopVariable extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(Type)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getLoopVariable_Type()
   * @model containment="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.LoopVariable#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

  /**
   * Returns the value of the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var</em>' attribute.
   * @see #setVar(String)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getLoopVariable_Var()
   * @model
   * @generated
   */
  String getVar();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.LoopVariable#getVar <em>Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var</em>' attribute.
   * @see #getVar()
   * @generated
   */
  void setVar(String value);

} // LoopVariable
