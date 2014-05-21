/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typedef Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.TypedefMapping#getNewType <em>New Type</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.TypedefMapping#getType <em>Type</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.TypedefMapping#getConstraint <em>Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getTypedefMapping()
 * @model
 * @generated
 */
public interface TypedefMapping extends EObject
{
  /**
   * Returns the value of the '<em><b>New Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>New Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>New Type</em>' attribute.
   * @see #setNewType(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getTypedefMapping_NewType()
   * @model
   * @generated
   */
  String getNewType();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.TypedefMapping#getNewType <em>New Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>New Type</em>' attribute.
   * @see #getNewType()
   * @generated
   */
  void setNewType(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(Type)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getTypedefMapping_Type()
   * @model containment="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.TypedefMapping#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

  /**
   * Returns the value of the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint</em>' containment reference.
   * @see #setConstraint(TypedefConstraint)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getTypedefMapping_Constraint()
   * @model containment="true"
   * @generated
   */
  TypedefConstraint getConstraint();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.TypedefMapping#getConstraint <em>Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraint</em>' containment reference.
   * @see #getConstraint()
   * @generated
   */
  void setConstraint(TypedefConstraint value);

} // TypedefMapping
