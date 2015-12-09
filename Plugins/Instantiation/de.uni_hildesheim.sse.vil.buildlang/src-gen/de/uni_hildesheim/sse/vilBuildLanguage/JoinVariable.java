/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Join Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable#getExcl <em>Excl</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable#getVar <em>Var</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getJoinVariable()
 * @model
 * @generated
 */
public interface JoinVariable extends EObject
{
  /**
   * Returns the value of the '<em><b>Excl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Excl</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Excl</em>' attribute.
   * @see #setExcl(String)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getJoinVariable_Excl()
   * @model
   * @generated
   */
  String getExcl();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable#getExcl <em>Excl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Excl</em>' attribute.
   * @see #getExcl()
   * @generated
   */
  void setExcl(String value);

  /**
   * Returns the value of the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var</em>' attribute.
   * @see #setVar(String)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getJoinVariable_Var()
   * @model
   * @generated
   */
  String getVar();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable#getVar <em>Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var</em>' attribute.
   * @see #getVar()
   * @generated
   */
  void setVar(String value);

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expression)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getJoinVariable_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

} // JoinVariable
