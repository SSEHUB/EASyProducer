/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dsl Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.DslContext#getStop <em>Stop</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.DslContext#getEscape <em>Escape</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.DslContext#getCommand <em>Command</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.DslContext#getDsl <em>Dsl</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getDslContext()
 * @model
 * @generated
 */
public interface DslContext extends EObject
{
  /**
   * Returns the value of the '<em><b>Stop</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stop</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stop</em>' attribute.
   * @see #setStop(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getDslContext_Stop()
   * @model
   * @generated
   */
  String getStop();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.DslContext#getStop <em>Stop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stop</em>' attribute.
   * @see #getStop()
   * @generated
   */
  void setStop(String value);

  /**
   * Returns the value of the '<em><b>Escape</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Escape</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Escape</em>' attribute.
   * @see #setEscape(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getDslContext_Escape()
   * @model
   * @generated
   */
  String getEscape();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.DslContext#getEscape <em>Escape</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Escape</em>' attribute.
   * @see #getEscape()
   * @generated
   */
  void setEscape(String value);

  /**
   * Returns the value of the '<em><b>Command</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Command</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Command</em>' attribute.
   * @see #setCommand(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getDslContext_Command()
   * @model
   * @generated
   */
  String getCommand();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.DslContext#getCommand <em>Command</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Command</em>' attribute.
   * @see #getCommand()
   * @generated
   */
  void setCommand(String value);

  /**
   * Returns the value of the '<em><b>Dsl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dsl</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dsl</em>' attribute.
   * @see #setDsl(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getDslContext_Dsl()
   * @model
   * @generated
   */
  String getDsl();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.DslContext#getDsl <em>Dsl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dsl</em>' attribute.
   * @see #getDsl()
   * @generated
   */
  void setDsl(String value);

} // DslContext
