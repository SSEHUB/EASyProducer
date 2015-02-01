/**
 */
package de.uni_hildesheim.sse.vil.rt.rtVil;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;

import de.uni_hildesheim.sse.vilBuildLanguage.ExpressionStatement;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Breakdown Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement#getVarDecl <em>Var Decl</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement#getExprStmt <em>Expr Stmt</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement#getBreakdownStmt <em>Breakdown Stmt</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getBreakdownElement()
 * @model
 * @generated
 */
public interface BreakdownElement extends EObject
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
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getBreakdownElement_VarDecl()
   * @model containment="true"
   * @generated
   */
  VariableDeclaration getVarDecl();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement#getVarDecl <em>Var Decl</em>}' containment reference.
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
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getBreakdownElement_ExprStmt()
   * @model containment="true"
   * @generated
   */
  ExpressionStatement getExprStmt();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement#getExprStmt <em>Expr Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr Stmt</em>' containment reference.
   * @see #getExprStmt()
   * @generated
   */
  void setExprStmt(ExpressionStatement value);

  /**
   * Returns the value of the '<em><b>Breakdown Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Breakdown Stmt</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Breakdown Stmt</em>' containment reference.
   * @see #setBreakdownStmt(BreakdownStatement)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getBreakdownElement_BreakdownStmt()
   * @model containment="true"
   * @generated
   */
  BreakdownStatement getBreakdownStmt();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement#getBreakdownStmt <em>Breakdown Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Breakdown Stmt</em>' containment reference.
   * @see #getBreakdownStmt()
   * @generated
   */
  void setBreakdownStmt(BreakdownStatement value);

} // BreakdownElement
