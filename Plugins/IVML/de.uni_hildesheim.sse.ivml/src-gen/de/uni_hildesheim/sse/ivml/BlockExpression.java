/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.BlockExpression#getExprs <em>Exprs</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getBlockExpression()
 * @model
 * @generated
 */
public interface BlockExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Exprs</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.ivml.ExpressionStatement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exprs</em>' containment reference list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getBlockExpression_Exprs()
   * @model containment="true"
   * @generated
   */
  EList<ExpressionStatement> getExprs();

} // BlockExpression
