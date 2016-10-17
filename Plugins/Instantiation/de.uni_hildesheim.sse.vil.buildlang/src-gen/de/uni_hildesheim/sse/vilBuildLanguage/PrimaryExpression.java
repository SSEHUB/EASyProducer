/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression#getSysEx <em>Sys Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression#getMap <em>Map</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression#getJoin <em>Join</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression#getInstantiate <em>Instantiate</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getPrimaryExpression()
 * @model
 * @generated
 */
public interface PrimaryExpression extends de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression
{
  /**
   * Returns the value of the '<em><b>Sys Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sys Ex</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sys Ex</em>' containment reference.
   * @see #setSysEx(SystemExecution)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getPrimaryExpression_SysEx()
   * @model containment="true"
   * @generated
   */
  SystemExecution getSysEx();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression#getSysEx <em>Sys Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sys Ex</em>' containment reference.
   * @see #getSysEx()
   * @generated
   */
  void setSysEx(SystemExecution value);

  /**
   * Returns the value of the '<em><b>Map</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Map</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Map</em>' containment reference.
   * @see #setMap(Map)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getPrimaryExpression_Map()
   * @model containment="true"
   * @generated
   */
  Map getMap();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression#getMap <em>Map</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Map</em>' containment reference.
   * @see #getMap()
   * @generated
   */
  void setMap(Map value);

  /**
   * Returns the value of the '<em><b>Join</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Join</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Join</em>' containment reference.
   * @see #setJoin(Join)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getPrimaryExpression_Join()
   * @model containment="true"
   * @generated
   */
  Join getJoin();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression#getJoin <em>Join</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Join</em>' containment reference.
   * @see #getJoin()
   * @generated
   */
  void setJoin(Join value);

  /**
   * Returns the value of the '<em><b>Instantiate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instantiate</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instantiate</em>' containment reference.
   * @see #setInstantiate(Instantiate)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getPrimaryExpression_Instantiate()
   * @model containment="true"
   * @generated
   */
  Instantiate getInstantiate();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression#getInstantiate <em>Instantiate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instantiate</em>' containment reference.
   * @see #getInstantiate()
   * @generated
   */
  void setInstantiate(Instantiate value);

} // PrimaryExpression
