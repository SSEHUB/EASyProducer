/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getLit <em>Lit</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getEx <em>Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getIfEx <em>If Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getRefEx <em>Ref Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getCalls <em>Calls</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getAccess <em>Access</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getPrimaryExpression()
 * @model
 * @generated
 */
public interface PrimaryExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Lit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lit</em>' containment reference.
   * @see #setLit(Literal)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getPrimaryExpression_Lit()
   * @model containment="true"
   * @generated
   */
  Literal getLit();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getLit <em>Lit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lit</em>' containment reference.
   * @see #getLit()
   * @generated
   */
  void setLit(Literal value);

  /**
   * Returns the value of the '<em><b>Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ex</em>' containment reference.
   * @see #setEx(Expression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getPrimaryExpression_Ex()
   * @model containment="true"
   * @generated
   */
  Expression getEx();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getEx <em>Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ex</em>' containment reference.
   * @see #getEx()
   * @generated
   */
  void setEx(Expression value);

  /**
   * Returns the value of the '<em><b>If Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>If Ex</em>' containment reference.
   * @see #setIfEx(IfExpression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getPrimaryExpression_IfEx()
   * @model containment="true"
   * @generated
   */
  IfExpression getIfEx();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getIfEx <em>If Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>If Ex</em>' containment reference.
   * @see #getIfEx()
   * @generated
   */
  void setIfEx(IfExpression value);

  /**
   * Returns the value of the '<em><b>Ref Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref Ex</em>' containment reference.
   * @see #setRefEx(Expression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getPrimaryExpression_RefEx()
   * @model containment="true"
   * @generated
   */
  Expression getRefEx();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getRefEx <em>Ref Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref Ex</em>' containment reference.
   * @see #getRefEx()
   * @generated
   */
  void setRefEx(Expression value);

  /**
   * Returns the value of the '<em><b>Calls</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.ivml.Call}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Calls</em>' containment reference list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getPrimaryExpression_Calls()
   * @model containment="true"
   * @generated
   */
  EList<Call> getCalls();

  /**
   * Returns the value of the '<em><b>Access</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Access</em>' containment reference.
   * @see #setAccess(ExpressionAccess)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getPrimaryExpression_Access()
   * @model containment="true"
   * @generated
   */
  ExpressionAccess getAccess();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.PrimaryExpression#getAccess <em>Access</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Access</em>' containment reference.
   * @see #getAccess()
   * @generated
   */
  void setAccess(ExpressionAccess value);

} // PrimaryExpression
