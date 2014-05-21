/**
 */
package de.uni_hildesheim.sse.vil.expressions.expressionDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Version Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionSpec#getConflicts <em>Conflicts</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getVersionSpec()
 * @model
 * @generated
 */
public interface VersionSpec extends EObject
{
  /**
   * Returns the value of the '<em><b>Conflicts</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionedId}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Conflicts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conflicts</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage#getVersionSpec_Conflicts()
   * @model containment="true"
   * @generated
   */
  EList<VersionedId> getConflicts();

} // VersionSpec
