/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.For#getVar <em>Var</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.For#getSeparator <em>Separator</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.For#getExpr <em>Expr</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.For#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getFor()
 * @model
 * @generated
 */
public interface For extends EObject
{
  /**
   * Returns the value of the '<em><b>Var</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.vilBuildLanguage.LoopVariable}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getFor_Var()
   * @model containment="true"
   * @generated
   */
  EList<LoopVariable> getVar();

  /**
   * Returns the value of the '<em><b>Separator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Separator</em>' attribute.
   * @see #setSeparator(String)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getFor_Separator()
   * @model
   * @generated
   */
  String getSeparator();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.For#getSeparator <em>Separator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Separator</em>' attribute.
   * @see #getSeparator()
   * @generated
   */
  void setSeparator(String value);

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expression)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getFor_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.For#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

  /**
   * Returns the value of the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Block</em>' containment reference.
   * @see #setBlock(RuleElementBlock)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getFor_Block()
   * @model containment="true"
   * @generated
   */
  RuleElementBlock getBlock();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.For#getBlock <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block</em>' containment reference.
   * @see #getBlock()
   * @generated
   */
  void setBlock(RuleElementBlock value);

} // For
