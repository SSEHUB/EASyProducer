/**
 */
package de.uni_hildesheim.sse.vil.expressions.expressionDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getSet <em>Set</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getParam <em>Param</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getSeq <em>Seq</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getMap <em>Map</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getCall <em>Call</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getReturn <em>Return</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getType()
 * @model
 * @generated
 */
public interface Type extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(QualifiedPrefix)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getType_Name()
   * @model containment="true"
   * @generated
   */
  QualifiedPrefix getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(QualifiedPrefix value);

  /**
   * Returns the value of the '<em><b>Set</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Set</em>' attribute.
   * @see #setSet(String)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getType_Set()
   * @model
   * @generated
   */
  String getSet();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getSet <em>Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Set</em>' attribute.
   * @see #getSet()
   * @generated
   */
  void setSet(String value);

  /**
   * Returns the value of the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param</em>' containment reference.
   * @see #setParam(TypeParameters)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getType_Param()
   * @model containment="true"
   * @generated
   */
  TypeParameters getParam();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getParam <em>Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param</em>' containment reference.
   * @see #getParam()
   * @generated
   */
  void setParam(TypeParameters value);

  /**
   * Returns the value of the '<em><b>Seq</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Seq</em>' attribute.
   * @see #setSeq(String)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getType_Seq()
   * @model
   * @generated
   */
  String getSeq();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getSeq <em>Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Seq</em>' attribute.
   * @see #getSeq()
   * @generated
   */
  void setSeq(String value);

  /**
   * Returns the value of the '<em><b>Map</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Map</em>' attribute.
   * @see #setMap(String)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getType_Map()
   * @model
   * @generated
   */
  String getMap();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getMap <em>Map</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Map</em>' attribute.
   * @see #getMap()
   * @generated
   */
  void setMap(String value);

  /**
   * Returns the value of the '<em><b>Call</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call</em>' attribute.
   * @see #setCall(String)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getType_Call()
   * @model
   * @generated
   */
  String getCall();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getCall <em>Call</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call</em>' attribute.
   * @see #getCall()
   * @generated
   */
  void setCall(String value);

  /**
   * Returns the value of the '<em><b>Return</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return</em>' containment reference.
   * @see #setReturn(Type)
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getType_Return()
   * @model containment="true"
   * @generated
   */
  Type getReturn();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type#getReturn <em>Return</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return</em>' containment reference.
   * @see #getReturn()
   * @generated
   */
  void setReturn(Type value);

} // Type
