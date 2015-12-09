/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Op Def Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.OpDefStatement#getResult <em>Result</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.OpDefStatement#getId <em>Id</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.OpDefStatement#getParam <em>Param</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.OpDefStatement#getImpl <em>Impl</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getOpDefStatement()
 * @model
 * @generated
 */
public interface OpDefStatement extends EObject
{
  /**
   * Returns the value of the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result</em>' containment reference.
   * @see #setResult(Type)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getOpDefStatement_Result()
   * @model containment="true"
   * @generated
   */
  Type getResult();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.OpDefStatement#getResult <em>Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result</em>' containment reference.
   * @see #getResult()
   * @generated
   */
  void setResult(Type value);

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getOpDefStatement_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.OpDefStatement#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param</em>' containment reference.
   * @see #setParam(OpDefParameterList)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getOpDefStatement_Param()
   * @model containment="true"
   * @generated
   */
  OpDefParameterList getParam();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.OpDefStatement#getParam <em>Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param</em>' containment reference.
   * @see #getParam()
   * @generated
   */
  void setParam(OpDefParameterList value);

  /**
   * Returns the value of the '<em><b>Impl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Impl</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Impl</em>' containment reference.
   * @see #setImpl(Expression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getOpDefStatement_Impl()
   * @model containment="true"
   * @generated
   */
  Expression getImpl();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.OpDefStatement#getImpl <em>Impl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Impl</em>' containment reference.
   * @see #getImpl()
   * @generated
   */
  void setImpl(Expression value);

} // OpDefStatement
