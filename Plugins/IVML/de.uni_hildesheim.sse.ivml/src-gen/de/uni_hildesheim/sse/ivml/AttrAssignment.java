/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attr Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.AttrAssignment#getParts <em>Parts</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.AttrAssignment#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAttrAssignment()
 * @model
 * @generated
 */
public interface AttrAssignment extends EObject
{
  /**
   * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.ivml.AttrAssignmentPart}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parts</em>' containment reference list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAttrAssignment_Parts()
   * @model containment="true"
   * @generated
   */
  EList<AttrAssignmentPart> getParts();

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAttrAssignment_Elements()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getElements();

} // AttrAssignment
