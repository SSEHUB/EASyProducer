/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Op Def Parameter List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.OpDefParameterList#getList <em>List</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getOpDefParameterList()
 * @model
 * @generated
 */
public interface OpDefParameterList extends EObject
{
  /**
   * Returns the value of the '<em><b>List</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.ivml.OpDefParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' containment reference list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getOpDefParameterList_List()
   * @model containment="true"
   * @generated
   */
  EList<OpDefParameter> getList();

} // OpDefParameterList
