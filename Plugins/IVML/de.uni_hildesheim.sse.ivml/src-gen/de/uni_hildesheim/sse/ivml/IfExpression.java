/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.IfExpression#getIfEx <em>If Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.IfExpression#getThenEx <em>Then Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.IfExpression#getElseEx <em>Else Ex</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getIfExpression()
 * @model
 * @generated
 */
public interface IfExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>If Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>If Ex</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>If Ex</em>' containment reference.
   * @see #setIfEx(Expression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getIfExpression_IfEx()
   * @model containment="true"
   * @generated
   */
  Expression getIfEx();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.IfExpression#getIfEx <em>If Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>If Ex</em>' containment reference.
   * @see #getIfEx()
   * @generated
   */
  void setIfEx(Expression value);

  /**
   * Returns the value of the '<em><b>Then Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then Ex</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then Ex</em>' containment reference.
   * @see #setThenEx(Expression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getIfExpression_ThenEx()
   * @model containment="true"
   * @generated
   */
  Expression getThenEx();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.IfExpression#getThenEx <em>Then Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then Ex</em>' containment reference.
   * @see #getThenEx()
   * @generated
   */
  void setThenEx(Expression value);

  /**
   * Returns the value of the '<em><b>Else Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Ex</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Ex</em>' containment reference.
   * @see #setElseEx(Expression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getIfExpression_ElseEx()
   * @model containment="true"
   * @generated
   */
  Expression getElseEx();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.IfExpression#getElseEx <em>Else Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Ex</em>' containment reference.
   * @see #getElseEx()
   * @generated
   */
  void setElseEx(Expression value);

} // IfExpression
