/**
 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Content#getPrint <em>Print</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Content#getCtn <em>Ctn</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Content#getIndent <em>Indent</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getContent()
 * @model
 * @generated
 */
public interface Content extends EObject
{
  /**
   * Returns the value of the '<em><b>Print</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Print</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Print</em>' attribute.
   * @see #setPrint(String)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getContent_Print()
   * @model
   * @generated
   */
  String getPrint();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Content#getPrint <em>Print</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Print</em>' attribute.
   * @see #getPrint()
   * @generated
   */
  void setPrint(String value);

  /**
   * Returns the value of the '<em><b>Ctn</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ctn</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ctn</em>' attribute.
   * @see #setCtn(String)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getContent_Ctn()
   * @model
   * @generated
   */
  String getCtn();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Content#getCtn <em>Ctn</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ctn</em>' attribute.
   * @see #getCtn()
   * @generated
   */
  void setCtn(String value);

  /**
   * Returns the value of the '<em><b>Indent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Indent</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Indent</em>' containment reference.
   * @see #setIndent(Expression)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getContent_Indent()
   * @model containment="true"
   * @generated
   */
  Expression getIndent();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Content#getIndent <em>Indent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Indent</em>' containment reference.
   * @see #getIndent()
   * @generated
   */
  void setIndent(Expression value);

} // Content
