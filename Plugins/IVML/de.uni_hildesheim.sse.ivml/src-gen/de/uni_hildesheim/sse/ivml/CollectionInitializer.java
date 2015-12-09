/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Initializer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.CollectionInitializer#getType <em>Type</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.CollectionInitializer#getInit <em>Init</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getCollectionInitializer()
 * @model
 * @generated
 */
public interface CollectionInitializer extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(QualifiedName)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getCollectionInitializer_Type()
   * @model containment="true"
   * @generated
   */
  QualifiedName getType();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.CollectionInitializer#getType <em>Type</em>}' containment reference.
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
   * <p>
   * If the meaning of the '<em>Init</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init</em>' containment reference.
   * @see #setInit(ExpressionListOrRange)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getCollectionInitializer_Init()
   * @model containment="true"
   * @generated
   */
  ExpressionListOrRange getInit();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.CollectionInitializer#getInit <em>Init</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init</em>' containment reference.
   * @see #getInit()
   * @generated
   */
  void setInit(ExpressionListOrRange value);

} // CollectionInitializer
