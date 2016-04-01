/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Call#getCall <em>Call</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Call#getSetOp <em>Set Op</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Call#getArrayEx <em>Array Ex</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getCall()
 * @model
 * @generated
 */
public interface Call extends EObject
{
  /**
   * Returns the value of the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call</em>' containment reference.
   * @see #setCall(FeatureCall)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getCall_Call()
   * @model containment="true"
   * @generated
   */
  FeatureCall getCall();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Call#getCall <em>Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call</em>' containment reference.
   * @see #getCall()
   * @generated
   */
  void setCall(FeatureCall value);

  /**
   * Returns the value of the '<em><b>Set Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Set Op</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Set Op</em>' containment reference.
   * @see #setSetOp(SetOp)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getCall_SetOp()
   * @model containment="true"
   * @generated
   */
  SetOp getSetOp();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Call#getSetOp <em>Set Op</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Set Op</em>' containment reference.
   * @see #getSetOp()
   * @generated
   */
  void setSetOp(SetOp value);

  /**
   * Returns the value of the '<em><b>Array Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Array Ex</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Array Ex</em>' containment reference.
   * @see #setArrayEx(Expression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getCall_ArrayEx()
   * @model containment="true"
   * @generated
   */
  Expression getArrayEx();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Call#getArrayEx <em>Array Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Array Ex</em>' containment reference.
   * @see #getArrayEx()
   * @generated
   */
  void setArrayEx(Expression value);

} // Call
