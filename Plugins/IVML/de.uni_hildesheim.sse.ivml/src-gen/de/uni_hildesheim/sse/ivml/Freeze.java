/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Freeze</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Freeze#getNames <em>Names</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Freeze#getId <em>Id</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Freeze#getEx <em>Ex</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getFreeze()
 * @model
 * @generated
 */
public interface Freeze extends EObject
{
  /**
   * Returns the value of the '<em><b>Names</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.ivml.FreezeStatement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Names</em>' containment reference list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getFreeze_Names()
   * @model containment="true"
   * @generated
   */
  EList<FreezeStatement> getNames();

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getFreeze_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Freeze#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ex</em>' containment reference.
   * @see #setEx(LogicalExpression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getFreeze_Ex()
   * @model containment="true"
   * @generated
   */
  LogicalExpression getEx();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Freeze#getEx <em>Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ex</em>' containment reference.
   * @see #getEx()
   * @generated
   */
  void setEx(LogicalExpression value);

} // Freeze
