/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Freeze But Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.FreezeButExpression#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.FreezeButExpression#getAccess <em>Access</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.FreezeButExpression#getWildcard <em>Wildcard</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getFreezeButExpression()
 * @model
 * @generated
 */
public interface FreezeButExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(QualifiedName)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getFreezeButExpression_Name()
   * @model containment="true"
   * @generated
   */
  QualifiedName getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.FreezeButExpression#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(QualifiedName value);

  /**
   * Returns the value of the '<em><b>Access</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Access</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Access</em>' containment reference.
   * @see #setAccess(AccessName)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getFreezeButExpression_Access()
   * @model containment="true"
   * @generated
   */
  AccessName getAccess();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.FreezeButExpression#getAccess <em>Access</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Access</em>' containment reference.
   * @see #getAccess()
   * @generated
   */
  void setAccess(AccessName value);

  /**
   * Returns the value of the '<em><b>Wildcard</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Wildcard</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Wildcard</em>' attribute.
   * @see #setWildcard(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getFreezeButExpression_Wildcard()
   * @model
   * @generated
   */
  String getWildcard();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.FreezeButExpression#getWildcard <em>Wildcard</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Wildcard</em>' attribute.
   * @see #getWildcard()
   * @generated
   */
  void setWildcard(String value);

} // FreezeButExpression
