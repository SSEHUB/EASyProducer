/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ArgumentList;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionSpec;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instantiate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getProject <em>Project</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getRule <em>Rule</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getRuleName <em>Rule Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getParam <em>Param</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getVersionSpec <em>Version Spec</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getInstantiate()
 * @model
 * @generated
 */
public interface Instantiate extends EObject
{
  /**
   * Returns the value of the '<em><b>Project</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Project</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Project</em>' attribute.
   * @see #setProject(String)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getInstantiate_Project()
   * @model
   * @generated
   */
  String getProject();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getProject <em>Project</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Project</em>' attribute.
   * @see #getProject()
   * @generated
   */
  void setProject(String value);

  /**
   * Returns the value of the '<em><b>Rule</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rule</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule</em>' attribute.
   * @see #setRule(String)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getInstantiate_Rule()
   * @model
   * @generated
   */
  String getRule();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getRule <em>Rule</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule</em>' attribute.
   * @see #getRule()
   * @generated
   */
  void setRule(String value);

  /**
   * Returns the value of the '<em><b>Rule Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rule Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule Name</em>' attribute.
   * @see #setRuleName(String)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getInstantiate_RuleName()
   * @model
   * @generated
   */
  String getRuleName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getRuleName <em>Rule Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule Name</em>' attribute.
   * @see #getRuleName()
   * @generated
   */
  void setRuleName(String value);

  /**
   * Returns the value of the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param</em>' containment reference.
   * @see #setParam(ArgumentList)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getInstantiate_Param()
   * @model containment="true"
   * @generated
   */
  ArgumentList getParam();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getParam <em>Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param</em>' containment reference.
   * @see #getParam()
   * @generated
   */
  void setParam(ArgumentList value);

  /**
   * Returns the value of the '<em><b>Version Spec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Version Spec</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version Spec</em>' containment reference.
   * @see #setVersionSpec(VersionSpec)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getInstantiate_VersionSpec()
   * @model containment="true"
   * @generated
   */
  VersionSpec getVersionSpec();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.Instantiate#getVersionSpec <em>Version Spec</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version Spec</em>' containment reference.
   * @see #getVersionSpec()
   * @generated
   */
  void setVersionSpec(VersionSpec value);

} // Instantiate
