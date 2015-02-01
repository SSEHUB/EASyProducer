/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement Or Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.StatementOrBlock#getExStmt <em>Ex Stmt</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.StatementOrBlock#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getStatementOrBlock()
 * @model
 * @generated
 */
public interface StatementOrBlock extends EObject
{
  /**
   * Returns the value of the '<em><b>Ex Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ex Stmt</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ex Stmt</em>' containment reference.
   * @see #setExStmt(ExpressionStatement)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getStatementOrBlock_ExStmt()
   * @model containment="true"
   * @generated
   */
  ExpressionStatement getExStmt();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.StatementOrBlock#getExStmt <em>Ex Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ex Stmt</em>' containment reference.
   * @see #getExStmt()
   * @generated
   */
  void setExStmt(ExpressionStatement value);

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
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getStatementOrBlock_Block()
   * @model containment="true"
   * @generated
   */
  RuleElementBlock getBlock();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.StatementOrBlock#getBlock <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block</em>' containment reference.
   * @see #getBlock()
   * @generated
   */
  void setBlock(RuleElementBlock value);

} // StatementOrBlock
