/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actual Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.ActualArgument#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.ActualArgument#getArg <em>Arg</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getActualArgument()
 * @model
 * @generated
 */
public interface ActualArgument extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getActualArgument_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.ActualArgument#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Arg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arg</em>' containment reference.
   * @see #setArg(Expression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getActualArgument_Arg()
   * @model containment="true"
   * @generated
   */
  Expression getArg();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.ActualArgument#getArg <em>Arg</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arg</em>' containment reference.
   * @see #getArg()
   * @generated
   */
  void setArg(Expression value);

} // ActualArgument
