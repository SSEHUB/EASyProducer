/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.InterfaceDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.InterfaceDeclaration#getExports <em>Exports</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getInterfaceDeclaration()
 * @model
 * @generated
 */
public interface InterfaceDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getInterfaceDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.InterfaceDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Exports</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.ivml.Export}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exports</em>' containment reference list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getInterfaceDeclaration_Exports()
   * @model containment="true"
   * @generated
   */
  EList<Export> getExports();

} // InterfaceDeclaration
