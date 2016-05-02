/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logical Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.LogicalExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.LogicalExpression#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getLogicalExpression()
 * @model
 * @generated
 */
public interface LogicalExpression extends EObject
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
   * @see #setLeft(EqualityExpression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getLogicalExpression_Left()
   * @model containment="true"
   * @generated
   */
  EqualityExpression getLeft();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.LogicalExpression#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(EqualityExpression value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.ivml.LogicalExpressionPart}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getLogicalExpression_Right()
   * @model containment="true"
   * @generated
   */
  EList<LogicalExpressionPart> getRight();

} // LogicalExpression
