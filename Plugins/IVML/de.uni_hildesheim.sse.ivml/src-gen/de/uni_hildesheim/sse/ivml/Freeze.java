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
 * A representation of the model object '<em><b>Freeze</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Freeze#getNames <em>Names</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Freeze#getBut <em>But</em>}</li>
 * </ul>
 * </p>
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
   * <p>
   * If the meaning of the '<em>Names</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Names</em>' containment reference list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getFreeze_Names()
   * @model containment="true"
   * @generated
   */
  EList<FreezeStatement> getNames();

  /**
   * Returns the value of the '<em><b>But</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>But</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>But</em>' containment reference.
   * @see #setBut(FreezeButList)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getFreeze_But()
   * @model containment="true"
   * @generated
   */
  FreezeButList getBut();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Freeze#getBut <em>But</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>But</em>' containment reference.
   * @see #getBut()
   * @generated
   */
  void setBut(FreezeButList value);

} // Freeze
