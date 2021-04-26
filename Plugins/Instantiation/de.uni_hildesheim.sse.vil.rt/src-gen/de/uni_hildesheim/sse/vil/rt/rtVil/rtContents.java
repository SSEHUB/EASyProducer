/**
 */
package de.uni_hildesheim.sse.vil.rt.rtVil;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>rt Contents</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.rtContents#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getrtContents()
 * @model
 * @generated
 */
public interface rtContents extends EObject
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getrtContents_Elements()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getElements();

} // rtContents
