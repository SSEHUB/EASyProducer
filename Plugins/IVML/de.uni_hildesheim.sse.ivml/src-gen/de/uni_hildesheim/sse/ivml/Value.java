/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Value#getNValue <em>NValue</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Value#getSValue <em>SValue</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Value#getQValue <em>QValue</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Value#getBValue <em>BValue</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Value#getSelf <em>Self</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Value#getNullValue <em>Null Value</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Value#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getValue()
 * @model
 * @generated
 */
public interface Value extends EObject
{
  /**
   * Returns the value of the '<em><b>NValue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>NValue</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>NValue</em>' containment reference.
   * @see #setNValue(NumValue)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getValue_NValue()
   * @model containment="true"
   * @generated
   */
  NumValue getNValue();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Value#getNValue <em>NValue</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>NValue</em>' containment reference.
   * @see #getNValue()
   * @generated
   */
  void setNValue(NumValue value);

  /**
   * Returns the value of the '<em><b>SValue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>SValue</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>SValue</em>' attribute.
   * @see #setSValue(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getValue_SValue()
   * @model
   * @generated
   */
  String getSValue();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Value#getSValue <em>SValue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>SValue</em>' attribute.
   * @see #getSValue()
   * @generated
   */
  void setSValue(String value);

  /**
   * Returns the value of the '<em><b>QValue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>QValue</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>QValue</em>' containment reference.
   * @see #setQValue(QualifiedName)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getValue_QValue()
   * @model containment="true"
   * @generated
   */
  QualifiedName getQValue();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Value#getQValue <em>QValue</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>QValue</em>' containment reference.
   * @see #getQValue()
   * @generated
   */
  void setQValue(QualifiedName value);

  /**
   * Returns the value of the '<em><b>BValue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>BValue</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>BValue</em>' attribute.
   * @see #setBValue(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getValue_BValue()
   * @model
   * @generated
   */
  String getBValue();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Value#getBValue <em>BValue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>BValue</em>' attribute.
   * @see #getBValue()
   * @generated
   */
  void setBValue(String value);

  /**
   * Returns the value of the '<em><b>Self</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Self</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Self</em>' attribute.
   * @see #setSelf(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getValue_Self()
   * @model
   * @generated
   */
  String getSelf();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Value#getSelf <em>Self</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Self</em>' attribute.
   * @see #getSelf()
   * @generated
   */
  void setSelf(String value);

  /**
   * Returns the value of the '<em><b>Null Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Null Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Null Value</em>' attribute.
   * @see #setNullValue(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getValue_NullValue()
   * @model
   * @generated
   */
  String getNullValue();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Value#getNullValue <em>Null Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Null Value</em>' attribute.
   * @see #getNullValue()
   * @generated
   */
  void setNullValue(String value);

  /**
   * Returns the value of the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Version</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version</em>' attribute.
   * @see #setVersion(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getValue_Version()
   * @model
   * @generated
   */
  String getVersion();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Value#getVersion <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version</em>' attribute.
   * @see #getVersion()
   * @generated
   */
  void setVersion(String value);

} // Value
