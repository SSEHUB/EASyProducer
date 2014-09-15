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
   * Returns the value of the '<em><b>Names</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.ivml.QualifiedName}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Names</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Names</em>' containment reference list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getExport_Names()
   * @model containment="true"
   * @generated
   */
  EList<QualifiedName> getNames();

} // Export
