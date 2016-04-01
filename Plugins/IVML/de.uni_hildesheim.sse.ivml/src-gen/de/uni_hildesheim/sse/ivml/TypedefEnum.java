/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typedef Enum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.TypedefEnum#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.TypedefEnum#getLiterals <em>Literals</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.TypedefEnum#getConstraint <em>Constraint</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getTypedefEnum()
 * @model
 * @generated
 */
public interface TypedefEnum extends EObject
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
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getTypedefEnum_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.TypedefEnum#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.ivml.TypedefEnumLiteral}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literals</em>' containment reference list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getTypedefEnum_Literals()
   * @model containment="true"
   * @generated
   */
  EList<TypedefEnumLiteral> getLiterals();

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
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getTypedefEnum_Constraint()
   * @model containment="true"
   * @generated
   */
  TypedefConstraint getConstraint();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.TypedefEnum#getConstraint <em>Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraint</em>' containment reference.
   * @see #getConstraint()
   * @generated
   */
  void setConstraint(TypedefConstraint value);

} // TypedefEnum
