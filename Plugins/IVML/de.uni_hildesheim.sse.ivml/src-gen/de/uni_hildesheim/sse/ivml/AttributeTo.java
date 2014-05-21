/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute To</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.AttributeTo#getAttributeType <em>Attribute Type</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.AttributeTo#getAttributeDecl <em>Attribute Decl</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.AttributeTo#getNames <em>Names</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAttributeTo()
 * @model
 * @generated
 */
public interface AttributeTo extends EObject
{
  /**
   * Returns the value of the '<em><b>Attribute Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Type</em>' containment reference.
   * @see #setAttributeType(Type)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAttributeTo_AttributeType()
   * @model containment="true"
   * @generated
   */
  Type getAttributeType();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.AttributeTo#getAttributeType <em>Attribute Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute Type</em>' containment reference.
   * @see #getAttributeType()
   * @generated
   */
  void setAttributeType(Type value);

  /**
   * Returns the value of the '<em><b>Attribute Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute Decl</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Decl</em>' containment reference.
   * @see #setAttributeDecl(VariableDeclarationPart)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAttributeTo_AttributeDecl()
   * @model containment="true"
   * @generated
   */
  VariableDeclarationPart getAttributeDecl();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.AttributeTo#getAttributeDecl <em>Attribute Decl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute Decl</em>' containment reference.
   * @see #getAttributeDecl()
   * @generated
   */
  void setAttributeDecl(VariableDeclarationPart value);

  /**
   * Returns the value of the '<em><b>Names</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Names</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Names</em>' attribute list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAttributeTo_Names()
   * @model unique="false"
   * @generated
   */
  EList<String> getNames();

} // AttributeTo
