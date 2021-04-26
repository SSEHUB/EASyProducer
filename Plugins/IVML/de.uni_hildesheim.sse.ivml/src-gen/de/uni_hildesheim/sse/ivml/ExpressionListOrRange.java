/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression List Or Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.ExpressionListOrRange#getList <em>List</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getExpressionListOrRange()
 * @model
 * @generated
 */
public interface ExpressionListOrRange extends EObject
{
  /**
   * Returns the value of the '<em><b>List</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.ivml.ExpressionListEntry}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' containment reference list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getExpressionListOrRange_List()
   * @model containment="true"
   * @generated
   */
  EList<ExpressionListEntry> getList();

} // ExpressionListOrRange
