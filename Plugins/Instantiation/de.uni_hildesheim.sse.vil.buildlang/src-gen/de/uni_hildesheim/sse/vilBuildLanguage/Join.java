/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Join</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.Join#getVar1 <em>Var1</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.Join#getVar2 <em>Var2</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.Join#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getJoin()
 * @model
 * @generated
 */
public interface Join extends EObject
{
  /**
   * Returns the value of the '<em><b>Var1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var1</em>' containment reference.
   * @see #setVar1(JoinVariable)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getJoin_Var1()
   * @model containment="true"
   * @generated
   */
  JoinVariable getVar1();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.Join#getVar1 <em>Var1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var1</em>' containment reference.
   * @see #getVar1()
   * @generated
   */
  void setVar1(JoinVariable value);

  /**
   * Returns the value of the '<em><b>Var2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var2</em>' containment reference.
   * @see #setVar2(JoinVariable)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getJoin_Var2()
   * @model containment="true"
   * @generated
   */
  JoinVariable getVar2();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.Join#getVar2 <em>Var2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var2</em>' containment reference.
   * @see #getVar2()
   * @generated
   */
  void setVar2(JoinVariable value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Expression)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getJoin_Condition()
   * @model containment="true"
   * @generated
   */
  Expression getCondition();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.Join#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Expression value);

} // Join
