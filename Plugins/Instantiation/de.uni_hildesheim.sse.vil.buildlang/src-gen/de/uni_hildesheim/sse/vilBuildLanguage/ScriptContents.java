/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Contents</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.ScriptContents#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getScriptContents()
 * @model
 * @generated
 */
public interface ScriptContents extends EObject
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getScriptContents_Elements()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getElements();

} // ScriptContents
