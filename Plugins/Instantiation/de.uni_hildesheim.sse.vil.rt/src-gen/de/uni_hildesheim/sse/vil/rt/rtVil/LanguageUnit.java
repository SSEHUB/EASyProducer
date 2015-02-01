/**
 */
package de.uni_hildesheim.sse.vil.rt.rtVil;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.LanguageUnit#getRtContents <em>Rt Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getLanguageUnit()
 * @model
 * @generated
 */
public interface LanguageUnit extends de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit
{
  /**
   * Returns the value of the '<em><b>Rt Contents</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rt Contents</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rt Contents</em>' containment reference.
   * @see #setRtContents(rtContents)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getLanguageUnit_RtContents()
   * @model containment="true"
   * @generated
   */
  rtContents getRtContents();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.LanguageUnit#getRtContents <em>Rt Contents</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rt Contents</em>' containment reference.
   * @see #getRtContents()
   * @generated
   */
  void setRtContents(rtContents value);

} // LanguageUnit
