/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.ExpressionStatement#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getExpressionStatement()
 * @model
 * @generated
 */
public interface ExpressionStatement extends EObject
{
  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getExpressionStatement_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.ExpressionStatement#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

} // ExpressionStatement
