/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Expression#getLet <em>Let</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Expression#getExpr <em>Expr</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Expression#getCollection <em>Collection</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends EObject
{
  /**
   * Returns the value of the '<em><b>Let</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Let</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Let</em>' containment reference.
   * @see #setLet(LetExpression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getExpression_Let()
   * @model containment="true"
   * @generated
   */
  LetExpression getLet();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Expression#getLet <em>Let</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Let</em>' containment reference.
   * @see #getLet()
   * @generated
   */
  void setLet(LetExpression value);

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(ImplicationExpression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getExpression_Expr()
   * @model containment="true"
   * @generated
   */
  ImplicationExpression getExpr();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Expression#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(ImplicationExpression value);

  /**
   * Returns the value of the '<em><b>Collection</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Collection</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Collection</em>' containment reference.
   * @see #setCollection(CollectionInitializer)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getExpression_Collection()
   * @model containment="true"
   * @generated
   */
  CollectionInitializer getCollection();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Expression#getCollection <em>Collection</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Collection</em>' containment reference.
   * @see #getCollection()
   * @generated
   */
  void setCollection(CollectionInitializer value);

} // Expression
