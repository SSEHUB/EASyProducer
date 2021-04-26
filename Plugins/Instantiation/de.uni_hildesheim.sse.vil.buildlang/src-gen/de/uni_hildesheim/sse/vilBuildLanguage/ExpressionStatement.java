/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.ExpressionStatement#getAlt <em>Alt</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getExpressionStatement()
 * @model
 * @generated
 */
public interface ExpressionStatement extends de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement
{
  /**
   * Returns the value of the '<em><b>Alt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alt</em>' containment reference.
   * @see #setAlt(Alternative)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getExpressionStatement_Alt()
   * @model containment="true"
   * @generated
   */
  Alternative getAlt();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.ExpressionStatement#getAlt <em>Alt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alt</em>' containment reference.
   * @see #getAlt()
   * @generated
   */
  void setAlt(Alternative value);

} // ExpressionStatement
