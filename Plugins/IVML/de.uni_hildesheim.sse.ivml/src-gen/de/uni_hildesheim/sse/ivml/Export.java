/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Export</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Export#getNames <em>Names</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getExport()
 * @model
 * @generated
 */
public interface Export extends EObject
{
  /**
   * Returns the value of the '<em><b>Names</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Names</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Names</em>' attribute list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getExport_Names()
   * @model unique="false"
   * @generated
   */
  EList<String> getNames();

} // Export
