/**
 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getVar <em>Var</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getAlt <em>Alt</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getSwitch <em>Switch</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getMulti <em>Multi</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getLoop <em>Loop</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getWhile <em>While</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getExprStmt <em>Expr Stmt</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getCtn <em>Ctn</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getFlush <em>Flush</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getStmt()
 * @model
 * @generated
 */
public interface Stmt extends EObject
{
  /**
   * Returns the value of the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var</em>' containment reference.
   * @see #setVar(VariableDeclaration)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getStmt_Var()
   * @model containment="true"
   * @generated
   */
  VariableDeclaration getVar();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getVar <em>Var</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var</em>' containment reference.
   * @see #getVar()
   * @generated
   */
  void setVar(VariableDeclaration value);

  /**
   * Returns the value of the '<em><b>Alt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alt</em>' containment reference.
   * @see #setAlt(Alternative)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getStmt_Alt()
   * @model containment="true"
   * @generated
   */
  Alternative getAlt();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getAlt <em>Alt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alt</em>' containment reference.
   * @see #getAlt()
   * @generated
   */
  void setAlt(Alternative value);

  /**
   * Returns the value of the '<em><b>Switch</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Switch</em>' containment reference.
   * @see #setSwitch(Switch)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getStmt_Switch()
   * @model containment="true"
   * @generated
   */
  Switch getSwitch();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getSwitch <em>Switch</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Switch</em>' containment reference.
   * @see #getSwitch()
   * @generated
   */
  void setSwitch(Switch value);

  /**
   * Returns the value of the '<em><b>Multi</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multi</em>' containment reference.
   * @see #setMulti(multiselect)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getStmt_Multi()
   * @model containment="true"
   * @generated
   */
  multiselect getMulti();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getMulti <em>Multi</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multi</em>' containment reference.
   * @see #getMulti()
   * @generated
   */
  void setMulti(multiselect value);

  /**
   * Returns the value of the '<em><b>Loop</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Loop</em>' containment reference.
   * @see #setLoop(Loop)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getStmt_Loop()
   * @model containment="true"
   * @generated
   */
  Loop getLoop();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getLoop <em>Loop</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Loop</em>' containment reference.
   * @see #getLoop()
   * @generated
   */
  void setLoop(Loop value);

  /**
   * Returns the value of the '<em><b>While</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>While</em>' containment reference.
   * @see #setWhile(While)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getStmt_While()
   * @model containment="true"
   * @generated
   */
  While getWhile();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getWhile <em>While</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>While</em>' containment reference.
   * @see #getWhile()
   * @generated
   */
  void setWhile(While value);

  /**
   * Returns the value of the '<em><b>Expr Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr Stmt</em>' containment reference.
   * @see #setExprStmt(ExpressionStatement)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getStmt_ExprStmt()
   * @model containment="true"
   * @generated
   */
  ExpressionStatement getExprStmt();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getExprStmt <em>Expr Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr Stmt</em>' containment reference.
   * @see #getExprStmt()
   * @generated
   */
  void setExprStmt(ExpressionStatement value);

  /**
   * Returns the value of the '<em><b>Ctn</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ctn</em>' containment reference.
   * @see #setCtn(Content)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getStmt_Ctn()
   * @model containment="true"
   * @generated
   */
  Content getCtn();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getCtn <em>Ctn</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ctn</em>' containment reference.
   * @see #getCtn()
   * @generated
   */
  void setCtn(Content value);

  /**
   * Returns the value of the '<em><b>Flush</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Flush</em>' attribute.
   * @see #setFlush(String)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getStmt_Flush()
   * @model
   * @generated
   */
  String getFlush();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt#getFlush <em>Flush</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Flush</em>' attribute.
   * @see #getFlush()
   * @generated
   */
  void setFlush(String value);

} // Stmt
