/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionSpec;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Require</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.Require#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.Require#getVersionSpec <em>Version Spec</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRequire()
 * @model
 * @generated
 */
public interface Require extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRequire_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.Require#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Version Spec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version Spec</em>' containment reference.
   * @see #setVersionSpec(VersionSpec)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRequire_VersionSpec()
   * @model containment="true"
   * @generated
   */
  VersionSpec getVersionSpec();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.Require#getVersionSpec <em>Version Spec</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version Spec</em>' containment reference.
   * @see #getVersionSpec()
   * @generated
   */
  void setVersionSpec(VersionSpec value);

} // Require
