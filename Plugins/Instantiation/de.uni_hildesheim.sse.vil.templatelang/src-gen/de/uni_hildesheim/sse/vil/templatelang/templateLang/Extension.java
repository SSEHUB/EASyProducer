/**
 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Extension#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getExtension()
 * @model
 * @generated
 */
public interface Extension extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(JavaQualifiedName)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getExtension_Name()
   * @model containment="true"
   * @generated
   */
  JavaQualifiedName getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Extension#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(JavaQualifiedName value);

} // Extension
