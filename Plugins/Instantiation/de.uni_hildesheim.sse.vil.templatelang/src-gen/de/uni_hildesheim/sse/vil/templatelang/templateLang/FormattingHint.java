/**
 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formatting Hint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.FormattingHint#getParts <em>Parts</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getFormattingHint()
 * @model
 * @generated
 */
public interface FormattingHint extends EObject
{
  /**
   * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.vil.templatelang.templateLang.FormattingHintPart}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parts</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getFormattingHint_Parts()
   * @model containment="true"
   * @generated
   */
  EList<FormattingHintPart> getParts();

} // FormattingHint
