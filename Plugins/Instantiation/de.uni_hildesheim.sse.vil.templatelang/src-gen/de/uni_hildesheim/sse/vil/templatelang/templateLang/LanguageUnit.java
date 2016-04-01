/**
 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getJavaExts <em>Java Exts</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getIndent <em>Indent</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getFormatting <em>Formatting</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getParam <em>Param</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getExt <em>Ext</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getTypeDefs <em>Type Defs</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getVars <em>Vars</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getDefs <em>Defs</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getLanguageUnit()
 * @model
 * @generated
 */
public interface LanguageUnit extends de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit
{
  /**
   * Returns the value of the '<em><b>Java Exts</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Extension}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Java Exts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Java Exts</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getLanguageUnit_JavaExts()
   * @model containment="true"
   * @generated
   */
  EList<Extension> getJavaExts();

  /**
   * Returns the value of the '<em><b>Indent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Indent</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Indent</em>' containment reference.
   * @see #setIndent(IndentationHint)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getLanguageUnit_Indent()
   * @model containment="true"
   * @generated
   */
  IndentationHint getIndent();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getIndent <em>Indent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Indent</em>' containment reference.
   * @see #getIndent()
   * @generated
   */
  void setIndent(IndentationHint value);

  /**
   * Returns the value of the '<em><b>Formatting</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formatting</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formatting</em>' containment reference.
   * @see #setFormatting(FormattingHint)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getLanguageUnit_Formatting()
   * @model containment="true"
   * @generated
   */
  FormattingHint getFormatting();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getFormatting <em>Formatting</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formatting</em>' containment reference.
   * @see #getFormatting()
   * @generated
   */
  void setFormatting(FormattingHint value);

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
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getLanguageUnit_Param()
   * @model containment="true"
   * @generated
   */
  ParameterList getParam();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getParam <em>Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param</em>' containment reference.
   * @see #getParam()
   * @generated
   */
  void setParam(ParameterList value);

  /**
   * Returns the value of the '<em><b>Ext</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ext</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ext</em>' attribute.
   * @see #setExt(String)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getLanguageUnit_Ext()
   * @model
   * @generated
   */
  String getExt();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit#getExt <em>Ext</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ext</em>' attribute.
   * @see #getExt()
   * @generated
   */
  void setExt(String value);

  /**
   * Returns the value of the '<em><b>Type Defs</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Defs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Defs</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getLanguageUnit_TypeDefs()
   * @model containment="true"
   * @generated
   */
  EList<TypeDef> getTypeDefs();

  /**
   * Returns the value of the '<em><b>Vars</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vars</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vars</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getLanguageUnit_Vars()
   * @model containment="true"
   * @generated
   */
  EList<VariableDeclaration> getVars();

  /**
   * Returns the value of the '<em><b>Defs</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Defs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Defs</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getLanguageUnit_Defs()
   * @model containment="true"
   * @generated
   */
  EList<VilDef> getDefs();

} // LanguageUnit
