/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicative Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.MultiplicativeExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.MultiplicativeExpression#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getMultiplicativeExpression()
 * @model
 * @generated
 */
public interface MultiplicativeExpression extends EObject
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
   * @see #setLeft(UnaryExpression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getMultiplicativeExpression_Left()
   * @model containment="true"
   * @generated
   */
  UnaryExpression getLeft();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.MultiplicativeExpression#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(UnaryExpression value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(MultiplicativeExpressionPart)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getMultiplicativeExpression_Right()
   * @model containment="true"
   * @generated
   */
  MultiplicativeExpressionPart getRight();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.MultiplicativeExpression#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(MultiplicativeExpressionPart value);

} // MultiplicativeExpression
