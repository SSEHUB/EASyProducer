/**
 */
package de.uni_hildesheim.sse.vil.rt.rtVil;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ArgumentList;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedPrefix;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Breakdown Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getType <em>Type</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getGuard <em>Guard</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getParam <em>Param</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getPart <em>Part</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getTime <em>Time</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getBreakdownStatement()
 * @model
 * @generated
 */
public interface BreakdownStatement extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getBreakdownStatement_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guard</em>' containment reference.
   * @see #setGuard(LogicalExpression)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getBreakdownStatement_Guard()
   * @model containment="true"
   * @generated
   */
  LogicalExpression getGuard();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getGuard <em>Guard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guard</em>' containment reference.
   * @see #getGuard()
   * @generated
   */
  void setGuard(LogicalExpression value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(QualifiedPrefix)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getBreakdownStatement_Name()
   * @model containment="true"
   * @generated
   */
  QualifiedPrefix getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(QualifiedPrefix value);

  /**
   * Returns the value of the '<em><b>Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param</em>' containment reference.
   * @see #setParam(ArgumentList)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getBreakdownStatement_Param()
   * @model containment="true"
   * @generated
   */
  ArgumentList getParam();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getParam <em>Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param</em>' containment reference.
   * @see #getParam()
   * @generated
   */
  void setParam(ArgumentList value);

  /**
   * Returns the value of the '<em><b>Part</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownWithPart}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Part</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getBreakdownStatement_Part()
   * @model containment="true"
   * @generated
   */
  EList<BreakdownWithPart> getPart();

  /**
   * Returns the value of the '<em><b>Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Time</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time</em>' containment reference.
   * @see #setTime(Expression)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getBreakdownStatement_Time()
   * @model containment="true"
   * @generated
   */
  Expression getTime();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement#getTime <em>Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time</em>' containment reference.
   * @see #getTime()
   * @generated
   */
  void setTime(Expression value);

} // BreakdownStatement
