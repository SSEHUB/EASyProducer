/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Modifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleModifier#getProtected <em>Protected</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRuleModifier()
 * @model
 * @generated
 */
public interface RuleModifier extends EObject
{
  /**
   * Returns the value of the '<em><b>Protected</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Protected</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Protected</em>' attribute.
   * @see #setProtected(String)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRuleModifier_Protected()
   * @model
   * @generated
   */
  String getProtected();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleModifier#getProtected <em>Protected</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Protected</em>' attribute.
   * @see #getProtected()
   * @generated
   */
  void setProtected(String value);

} // RuleModifier
