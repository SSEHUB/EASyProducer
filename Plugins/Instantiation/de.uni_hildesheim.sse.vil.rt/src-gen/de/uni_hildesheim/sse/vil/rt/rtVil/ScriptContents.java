/**
 */
package de.uni_hildesheim.sse.vil.rt.rtVil;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Contents</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.ScriptContents#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getScriptContents()
 * @model
 * @generated
 */
public interface ScriptContents extends rtContents
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getScriptContents_Elements()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getElements();

} // ScriptContents
