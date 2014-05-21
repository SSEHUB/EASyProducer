/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Type#getType <em>Type</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Type#getId <em>Id</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Type#getDerived <em>Derived</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getType()
 * @model
 * @generated
 */
public interface Type extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(BasicType)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getType_Type()
   * @model containment="true"
   * @generated
   */
  BasicType getType();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Type#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(BasicType value);

  /**
   * Returns the value of the '<em><b>Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' containment reference.
   * @see #setId(QualifiedName)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getType_Id()
   * @model containment="true"
   * @generated
   */
  QualifiedName getId();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Type#getId <em>Id</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' containment reference.
   * @see #getId()
   * @generated
   */
  void setId(QualifiedName value);

  /**
   * Returns the value of the '<em><b>Derived</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Derived</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Derived</em>' containment reference.
   * @see #setDerived(DerivedType)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getType_Derived()
   * @model containment="true"
   * @generated
   */
  DerivedType getDerived();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Type#getDerived <em>Derived</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Derived</em>' containment reference.
   * @see #getDerived()
   * @generated
   */
  void setDerived(DerivedType value);

} // Type
