/**
 */
package de.uni_hildesheim.sse.vil.expressions.expressionDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression#getOtherEx <em>Other Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression#getUnqEx <em>Unq Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression#getSuperEx <em>Super Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression#getNewEx <em>New Ex</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getPrimaryExpression()
 * @model
 * @generated
 */
public interface PrimaryExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Other Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Other Ex</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Other Ex</em>' containment reference.
   * @see #setOtherEx(ExpressionOrQualifiedExecution)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getPrimaryExpression_OtherEx()
   * @model containment="true"
   * @generated
   */
  ExpressionOrQualifiedExecution getOtherEx();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression#getOtherEx <em>Other Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Other Ex</em>' containment reference.
   * @see #getOtherEx()
   * @generated
   */
  void setOtherEx(ExpressionOrQualifiedExecution value);

  /**
   * Returns the value of the '<em><b>Unq Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unq Ex</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unq Ex</em>' containment reference.
   * @see #setUnqEx(UnqualifiedExecution)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getPrimaryExpression_UnqEx()
   * @model containment="true"
   * @generated
   */
  UnqualifiedExecution getUnqEx();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression#getUnqEx <em>Unq Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unq Ex</em>' containment reference.
   * @see #getUnqEx()
   * @generated
   */
  void setUnqEx(UnqualifiedExecution value);

  /**
   * Returns the value of the '<em><b>Super Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Ex</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Ex</em>' containment reference.
   * @see #setSuperEx(SuperExecution)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getPrimaryExpression_SuperEx()
   * @model containment="true"
   * @generated
   */
  SuperExecution getSuperEx();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression#getSuperEx <em>Super Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Ex</em>' containment reference.
   * @see #getSuperEx()
   * @generated
   */
  void setSuperEx(SuperExecution value);

  /**
   * Returns the value of the '<em><b>New Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>New Ex</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>New Ex</em>' containment reference.
   * @see #setNewEx(ConstructorExecution)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getPrimaryExpression_NewEx()
   * @model containment="true"
   * @generated
   */
  ConstructorExecution getNewEx();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression#getNewEx <em>New Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>New Ex</em>' containment reference.
   * @see #getNewEx()
   * @generated
   */
  void setNewEx(ConstructorExecution value);

} // PrimaryExpression
