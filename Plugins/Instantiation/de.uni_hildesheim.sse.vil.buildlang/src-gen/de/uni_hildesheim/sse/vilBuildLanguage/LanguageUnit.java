/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit#getParam <em>Param</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit#getParent <em>Parent</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit#getLoadProperties <em>Load Properties</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getLanguageUnit()
 * @model
 * @generated
 */
public interface LanguageUnit extends de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit
{
  /**
   * Returns the value of the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param</em>' containment reference.
   * @see #setParam(ParameterList)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getLanguageUnit_Param()
   * @model containment="true"
   * @generated
   */
  ParameterList getParam();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit#getParam <em>Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param</em>' containment reference.
   * @see #getParam()
   * @generated
   */
  void setParam(ParameterList value);

  /**
   * Returns the value of the '<em><b>Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parent</em>' containment reference.
   * @see #setParent(ScriptParentDecl)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getLanguageUnit_Parent()
   * @model containment="true"
   * @generated
   */
  ScriptParentDecl getParent();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit#getParent <em>Parent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent</em>' containment reference.
   * @see #getParent()
   * @generated
   */
  void setParent(ScriptParentDecl value);

  /**
   * Returns the value of the '<em><b>Load Properties</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.vilBuildLanguage.LoadProperties}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Load Properties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Load Properties</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getLanguageUnit_LoadProperties()
   * @model containment="true"
   * @generated
   */
  EList<LoadProperties> getLoadProperties();

  /**
   * Returns the value of the '<em><b>Contents</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contents</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contents</em>' containment reference.
   * @see #setContents(ScriptContents)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getLanguageUnit_Contents()
   * @model containment="true"
   * @generated
   */
  ScriptContents getContents();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit#getContents <em>Contents</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Contents</em>' containment reference.
   * @see #getContents()
   * @generated
   */
  void setContents(ScriptContents value);

} // LanguageUnit
