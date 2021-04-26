/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Freeze Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.FreezeStatement#getDot <em>Dot</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.FreezeStatement#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.FreezeStatement#getAccess <em>Access</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getFreezeStatement()
 * @model
 * @generated
 */
public interface FreezeStatement extends EObject
{
  /**
   * Returns the value of the '<em><b>Dot</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dot</em>' attribute.
   * @see #setDot(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getFreezeStatement_Dot()
   * @model
   * @generated
   */
  String getDot();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.FreezeStatement#getDot <em>Dot</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dot</em>' attribute.
   * @see #getDot()
   * @generated
   */
  void setDot(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(QualifiedName)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getFreezeStatement_Name()
   * @model containment="true"
   * @generated
   */
  QualifiedName getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.FreezeStatement#getName <em>Name</em>}' containment reference.
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
   * <!-- end-user-doc -->
   * @return the value of the '<em>Access</em>' containment reference.
   * @see #setAccess(AccessName)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getFreezeStatement_Access()
   * @model containment="true"
   * @generated
   */
  AccessName getAccess();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.FreezeStatement#getAccess <em>Access</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Access</em>' containment reference.
   * @see #getAccess()
   * @generated
   */
  void setAccess(AccessName value);

} // FreezeStatement
