/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.Map#getVar <em>Var</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.Map#getSeparator <em>Separator</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.Map#getExpr <em>Expr</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.Map#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getMap()
 * @model
 * @generated
 */
public interface Map extends EObject
{
  /**
   * Returns the value of the '<em><b>Var</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.vilBuildLanguage.MapVariable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getMap_Var()
   * @model containment="true"
   * @generated
   */
  EList<MapVariable> getVar();

  /**
   * Returns the value of the '<em><b>Separator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Separator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Separator</em>' attribute.
   * @see #setSeparator(String)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getMap_Separator()
   * @model
   * @generated
   */
  String getSeparator();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.Map#getSeparator <em>Separator</em>}' attribute.
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
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expression)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getMap_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.Map#getExpr <em>Expr</em>}' containment reference.
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
   * <p>
   * If the meaning of the '<em>Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Block</em>' containment reference.
   * @see #setBlock(RuleElementBlock)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getMap_Block()
   * @model containment="true"
   * @generated
   */
  RuleElementBlock getBlock();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.Map#getBlock <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block</em>' containment reference.
   * @see #getBlock()
   * @generated
   */
  void setBlock(RuleElementBlock value);

} // Map
