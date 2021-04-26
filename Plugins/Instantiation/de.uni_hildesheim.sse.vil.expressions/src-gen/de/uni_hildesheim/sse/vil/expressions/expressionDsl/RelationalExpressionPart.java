/**
 */
package de.uni_hildesheim.sse.vil.expressions.expressionDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Expression Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpressionPart#getOp <em>Op</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpressionPart#getEx <em>Ex</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getRelationalExpressionPart()
 * @model
 * @generated
 */
public interface RelationalExpressionPart extends EObject
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getRelationalExpressionPart_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpressionPart#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

  /**
   * Returns the value of the '<em><b>Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ex</em>' containment reference.
   * @see #setEx(AdditiveExpression)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getRelationalExpressionPart_Ex()
   * @model containment="true"
   * @generated
   */
  AdditiveExpression getEx();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpressionPart#getEx <em>Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ex</em>' containment reference.
   * @see #getEx()
   * @generated
   */
  void setEx(AdditiveExpression value);

} // RelationalExpressionPart
