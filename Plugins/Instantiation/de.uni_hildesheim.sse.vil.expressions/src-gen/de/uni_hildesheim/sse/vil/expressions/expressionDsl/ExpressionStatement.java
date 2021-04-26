/**
 */
package de.uni_hildesheim.sse.vil.expressions.expressionDsl;

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
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement#getVar <em>Var</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement#getField <em>Field</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getExpressionStatement()
 * @model
 * @generated
 */
public interface ExpressionStatement extends EObject
{
  /**
   * Returns the value of the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var</em>' attribute.
   * @see #setVar(String)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getExpressionStatement_Var()
   * @model
   * @generated
   */
  String getVar();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement#getVar <em>Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var</em>' attribute.
   * @see #getVar()
   * @generated
   */
  void setVar(String value);

  /**
   * Returns the value of the '<em><b>Field</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field</em>' attribute.
   * @see #setField(String)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getExpressionStatement_Field()
   * @model
   * @generated
   */
  String getField();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement#getField <em>Field</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field</em>' attribute.
   * @see #getField()
   * @generated
   */
  void setField(String value);

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expression)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getExpressionStatement_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

} // ExpressionStatement
