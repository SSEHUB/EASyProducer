/**
 * <copyright>
 * </copyright>
 *

 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conflict Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.ConflictStmt#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.ConflictStmt#getConflicts <em>Conflicts</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getConflictStmt()
 * @model
 * @generated
 */
public interface ConflictStmt extends EObject
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
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getConflictStmt_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.ConflictStmt#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Conflicts</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.ivml.VersionedId}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Conflicts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conflicts</em>' containment reference list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getConflictStmt_Conflicts()
   * @model containment="true"
   * @generated
   */
  EList<VersionedId> getConflicts();

} // ConflictStmt
