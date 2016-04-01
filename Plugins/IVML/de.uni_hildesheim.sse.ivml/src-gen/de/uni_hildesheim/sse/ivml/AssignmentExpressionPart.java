/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment Expression Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.AssignmentExpressionPart#getOp <em>Op</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.AssignmentExpressionPart#getEx <em>Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.AssignmentExpressionPart#getCollection <em>Collection</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAssignmentExpressionPart()
 * @model
 * @generated
 */
public interface AssignmentExpressionPart extends EObject
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAssignmentExpressionPart_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.AssignmentExpressionPart#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

  /**
   * Returns the value of the '<em><b>Ex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ex</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ex</em>' containment reference.
   * @see #setEx(LogicalExpression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAssignmentExpressionPart_Ex()
   * @model containment="true"
   * @generated
   */
  LogicalExpression getEx();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.AssignmentExpressionPart#getEx <em>Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ex</em>' containment reference.
   * @see #getEx()
   * @generated
   */
  void setEx(LogicalExpression value);

  /**
   * Returns the value of the '<em><b>Collection</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Collection</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Collection</em>' containment reference.
   * @see #setCollection(CollectionInitializer)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAssignmentExpressionPart_Collection()
   * @model containment="true"
   * @generated
   */
  CollectionInitializer getCollection();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.AssignmentExpressionPart#getCollection <em>Collection</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Collection</em>' containment reference.
   * @see #getCollection()
   * @generated
   */
  void setCollection(CollectionInitializer value);

} // AssignmentExpressionPart
