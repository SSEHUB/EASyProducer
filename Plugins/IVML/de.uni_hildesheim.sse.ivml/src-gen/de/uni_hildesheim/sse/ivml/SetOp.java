/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Op</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.SetOp#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.SetOp#getDecl <em>Decl</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.SetOp#getDeclEx <em>Decl Ex</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getSetOp()
 * @model
 * @generated
 */
public interface SetOp extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getSetOp_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.SetOp#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decl</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decl</em>' containment reference.
   * @see #setDecl(Declarator)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getSetOp_Decl()
   * @model containment="true"
   * @generated
   */
  Declarator getDecl();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.SetOp#getDecl <em>Decl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Decl</em>' containment reference.
   * @see #getDecl()
   * @generated
   */
  void setDecl(Declarator value);

  /**
   * Returns the value of the '<em><b>Decl Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decl Ex</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decl Ex</em>' containment reference.
   * @see #setDeclEx(ActualParameterList)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getSetOp_DeclEx()
   * @model containment="true"
   * @generated
   */
  ActualParameterList getDeclEx();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.SetOp#getDeclEx <em>Decl Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Decl Ex</em>' containment reference.
   * @see #getDeclEx()
   * @generated
   */
  void setDeclEx(ActualParameterList value);

} // SetOp
