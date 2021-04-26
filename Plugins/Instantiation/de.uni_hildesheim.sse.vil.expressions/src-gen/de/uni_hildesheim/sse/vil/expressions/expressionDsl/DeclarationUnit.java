/**
 */
package de.uni_hildesheim.sse.vil.expressions.expressionDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declaration Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.DeclarationUnit#getId <em>Id</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.DeclarationUnit#getDeflt <em>Deflt</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getDeclarationUnit()
 * @model
 * @generated
 */
public interface DeclarationUnit extends EObject
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getDeclarationUnit_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.DeclarationUnit#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Deflt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deflt</em>' containment reference.
   * @see #setDeflt(Expression)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getDeclarationUnit_Deflt()
   * @model containment="true"
   * @generated
   */
  Expression getDeflt();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.DeclarationUnit#getDeflt <em>Deflt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Deflt</em>' containment reference.
   * @see #getDeflt()
   * @generated
   */
  void setDeflt(Expression value);

} // DeclarationUnit
