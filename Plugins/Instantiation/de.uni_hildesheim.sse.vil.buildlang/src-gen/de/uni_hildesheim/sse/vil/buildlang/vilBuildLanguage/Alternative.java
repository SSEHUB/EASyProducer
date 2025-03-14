/**
 * generated by Xtext 2.35.0
 */
package de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternative</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.Alternative#getExpr <em>Expr</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.Alternative#getIf <em>If</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.Alternative#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.VilBuildLanguagePackage#getAlternative()
 * @model
 * @generated
 */
public interface Alternative extends EObject
{
  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expression)
   * @see de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.VilBuildLanguagePackage#getAlternative_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.Alternative#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

  /**
   * Returns the value of the '<em><b>If</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>If</em>' containment reference.
   * @see #setIf(StatementOrBlock)
   * @see de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.VilBuildLanguagePackage#getAlternative_If()
   * @model containment="true"
   * @generated
   */
  StatementOrBlock getIf();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.Alternative#getIf <em>If</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>If</em>' containment reference.
   * @see #getIf()
   * @generated
   */
  void setIf(StatementOrBlock value);

  /**
   * Returns the value of the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else</em>' containment reference.
   * @see #setElse(StatementOrBlock)
   * @see de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.VilBuildLanguagePackage#getAlternative_Else()
   * @model containment="true"
   * @generated
   */
  StatementOrBlock getElse();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.Alternative#getElse <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else</em>' containment reference.
   * @see #getElse()
   * @generated
   */
  void setElse(StatementOrBlock value);

} // Alternative
