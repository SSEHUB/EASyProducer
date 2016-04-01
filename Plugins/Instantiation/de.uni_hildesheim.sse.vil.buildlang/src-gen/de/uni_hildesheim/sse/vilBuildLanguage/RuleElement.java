/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElement#getVarDecl <em>Var Decl</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElement#getExprStmt <em>Expr Stmt</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElement#getWhile <em>While</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElement#getFor <em>For</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRuleElement()
 * @model
 * @generated
 */
public interface RuleElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Var Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var Decl</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var Decl</em>' containment reference.
   * @see #setVarDecl(VariableDeclaration)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRuleElement_VarDecl()
   * @model containment="true"
   * @generated
   */
  VariableDeclaration getVarDecl();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElement#getVarDecl <em>Var Decl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var Decl</em>' containment reference.
   * @see #getVarDecl()
   * @generated
   */
  void setVarDecl(VariableDeclaration value);

  /**
   * Returns the value of the '<em><b>Expr Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr Stmt</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr Stmt</em>' containment reference.
   * @see #setExprStmt(ExpressionStatement)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRuleElement_ExprStmt()
   * @model containment="true"
   * @generated
   */
  ExpressionStatement getExprStmt();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElement#getExprStmt <em>Expr Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr Stmt</em>' containment reference.
   * @see #getExprStmt()
   * @generated
   */
  void setExprStmt(ExpressionStatement value);

  /**
   * Returns the value of the '<em><b>While</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>While</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>While</em>' containment reference.
   * @see #setWhile(While)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRuleElement_While()
   * @model containment="true"
   * @generated
   */
  While getWhile();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElement#getWhile <em>While</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>While</em>' containment reference.
   * @see #getWhile()
   * @generated
   */
  void setWhile(While value);

  /**
   * Returns the value of the '<em><b>For</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>For</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>For</em>' containment reference.
   * @see #setFor(For)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRuleElement_For()
   * @model containment="true"
   * @generated
   */
  For getFor();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElement#getFor <em>For</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>For</em>' containment reference.
   * @see #getFor()
   * @generated
   */
  void setFor(For value);

} // RuleElement
