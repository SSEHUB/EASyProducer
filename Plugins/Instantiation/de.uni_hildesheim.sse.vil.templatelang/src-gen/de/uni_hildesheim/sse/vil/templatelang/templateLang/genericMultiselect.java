/**
 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>generic Multiselect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect#getPreamble <em>Preamble</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect#getSelector <em>Selector</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect#getPart <em>Part</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect#getTrailer <em>Trailer</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getgenericMultiselect()
 * @model
 * @generated
 */
public interface genericMultiselect extends EObject
{
  /**
   * Returns the value of the '<em><b>Preamble</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Preamble</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Preamble</em>' containment reference.
   * @see #setPreamble(StmtBlock)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getgenericMultiselect_Preamble()
   * @model containment="true"
   * @generated
   */
  StmtBlock getPreamble();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect#getPreamble <em>Preamble</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Preamble</em>' containment reference.
   * @see #getPreamble()
   * @generated
   */
  void setPreamble(StmtBlock value);

  /**
   * Returns the value of the '<em><b>Selector</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Selector</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Selector</em>' containment reference.
   * @see #setSelector(StmtBlock)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getgenericMultiselect_Selector()
   * @model containment="true"
   * @generated
   */
  StmtBlock getSelector();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect#getSelector <em>Selector</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Selector</em>' containment reference.
   * @see #getSelector()
   * @generated
   */
  void setSelector(StmtBlock value);

  /**
   * Returns the value of the '<em><b>Part</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.vil.templatelang.templateLang.multiSelectPart}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Part</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getgenericMultiselect_Part()
   * @model containment="true"
   * @generated
   */
  EList<multiSelectPart> getPart();

  /**
   * Returns the value of the '<em><b>Trailer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trailer</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trailer</em>' containment reference.
   * @see #setTrailer(StmtBlock)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getgenericMultiselect_Trailer()
   * @model containment="true"
   * @generated
   */
  StmtBlock getTrailer();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect#getTrailer <em>Trailer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trailer</em>' containment reference.
   * @see #getTrailer()
   * @generated
   */
  void setTrailer(StmtBlock value);

} // genericMultiselect
