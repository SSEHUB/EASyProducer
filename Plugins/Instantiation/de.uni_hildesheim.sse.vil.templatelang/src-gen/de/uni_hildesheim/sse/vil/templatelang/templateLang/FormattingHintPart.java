/**
 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formatting Hint Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.FormattingHintPart#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.FormattingHintPart#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getFormattingHintPart()
 * @model
 * @generated
 */
public interface FormattingHintPart extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getFormattingHintPart_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.FormattingHintPart#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getFormattingHintPart_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.FormattingHintPart#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // FormattingHintPart
