/**
 */
package de.uni_hildesheim.sse.ivml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container Op</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.ContainerOp#getDecl <em>Decl</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getContainerOp()
 * @model
 * @generated
 */
public interface ContainerOp extends ActualArgumentList
{
  /**
   * Returns the value of the '<em><b>Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decl</em>' containment reference.
   * @see #setDecl(Declarator)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getContainerOp_Decl()
   * @model containment="true"
   * @generated
   */
  Declarator getDecl();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.ContainerOp#getDecl <em>Decl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Decl</em>' containment reference.
   * @see #getDecl()
   * @generated
   */
  void setDecl(Declarator value);

} // ContainerOp
