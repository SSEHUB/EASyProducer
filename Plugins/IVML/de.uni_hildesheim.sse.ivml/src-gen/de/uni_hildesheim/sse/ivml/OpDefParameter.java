/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Op Def Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.OpDefParameter#getType <em>Type</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.OpDefParameter#getId <em>Id</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.OpDefParameter#getVal <em>Val</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getOpDefParameter()
 * @model
 * @generated
 */
public interface OpDefParameter extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(Type)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getOpDefParameter_Type()
   * @model containment="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.OpDefParameter#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getOpDefParameter_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.OpDefParameter#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val</em>' containment reference.
   * @see #setVal(Expression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getOpDefParameter_Val()
   * @model containment="true"
   * @generated
   */
  Expression getVal();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.OpDefParameter#getVal <em>Val</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val</em>' containment reference.
   * @see #getVal()
   * @generated
   */
  void setVal(Expression value);

} // OpDefParameter
