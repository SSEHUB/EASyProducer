/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container Initializer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.ContainerInitializer#getType <em>Type</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.ContainerInitializer#getInit <em>Init</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getContainerInitializer()
 * @model
 * @generated
 */
public interface ContainerInitializer extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(QualifiedName)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getContainerInitializer_Type()
   * @model containment="true"
   * @generated
   */
  QualifiedName getType();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.ContainerInitializer#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(QualifiedName value);

  /**
   * Returns the value of the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init</em>' containment reference.
   * @see #setInit(ExpressionListOrRange)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getContainerInitializer_Init()
   * @model containment="true"
   * @generated
   */
  ExpressionListOrRange getInit();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.ContainerInitializer#getInit <em>Init</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init</em>' containment reference.
   * @see #getInit()
   * @generated
   */
  void setInit(ExpressionListOrRange value);

} // ContainerInitializer
