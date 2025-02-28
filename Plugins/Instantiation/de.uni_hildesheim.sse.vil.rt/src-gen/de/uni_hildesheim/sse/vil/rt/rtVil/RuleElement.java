/**
 * generated by Xtext 2.35.0
 */
package de.uni_hildesheim.sse.vil.rt.rtVil;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.RuleElement#getFail <em>Fail</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getRuleElement()
 * @model
 * @generated
 */
public interface RuleElement extends de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.RuleElement
{
  /**
   * Returns the value of the '<em><b>Fail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fail</em>' containment reference.
   * @see #setFail(FailStatement)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getRuleElement_Fail()
   * @model containment="true"
   * @generated
   */
  FailStatement getFail();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.RuleElement#getFail <em>Fail</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fail</em>' containment reference.
   * @see #getFail()
   * @generated
   */
  void setFail(FailStatement value);

} // RuleElement
