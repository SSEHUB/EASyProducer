/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Access Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.AccessName#getAName <em>AName</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAccessName()
 * @model
 * @generated
 */
public interface AccessName extends EObject
{
  /**
   * Returns the value of the '<em><b>AName</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>AName</em>' attribute list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAccessName_AName()
   * @model unique="false"
   * @generated
   */
  EList<String> getAName();

} // AccessName
