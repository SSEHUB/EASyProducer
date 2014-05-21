/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.RelationalExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.RelationalExpression#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getRelationalExpression()
 * @model
 * @generated
 */
public interface RelationalExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(AdditiveExpression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getRelationalExpression_Left()
   * @model containment="true"
   * @generated
   */
  AdditiveExpression getLeft();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.RelationalExpression#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(AdditiveExpression value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(RelationalExpressionPart)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getRelationalExpression_Right()
   * @model containment="true"
   * @generated
   */
  RelationalExpressionPart getRight();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.RelationalExpression#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(RelationalExpressionPart value);

} // RelationalExpression
