/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Stmt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.ImportStmt#getInsert <em>Insert</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.ImportStmt#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.ImportStmt#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.ImportStmt#getWildcard <em>Wildcard</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.ImportStmt#getRestriction <em>Restriction</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getImportStmt()
 * @model
 * @generated
 */
public interface ImportStmt extends EObject
{
  /**
   * Returns the value of the '<em><b>Insert</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Insert</em>' attribute.
   * @see #setInsert(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getImportStmt_Insert()
   * @model
   * @generated
   */
  String getInsert();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.ImportStmt#getInsert <em>Insert</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Insert</em>' attribute.
   * @see #getInsert()
   * @generated
   */
  void setInsert(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getImportStmt_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.ImportStmt#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interface</em>' attribute.
   * @see #setInterface(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getImportStmt_Interface()
   * @model
   * @generated
   */
  String getInterface();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.ImportStmt#getInterface <em>Interface</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interface</em>' attribute.
   * @see #getInterface()
   * @generated
   */
  void setInterface(String value);

  /**
   * Returns the value of the '<em><b>Wildcard</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Wildcard</em>' attribute.
   * @see #setWildcard(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getImportStmt_Wildcard()
   * @model
   * @generated
   */
  String getWildcard();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.ImportStmt#getWildcard <em>Wildcard</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Wildcard</em>' attribute.
   * @see #getWildcard()
   * @generated
   */
  void setWildcard(String value);

  /**
   * Returns the value of the '<em><b>Restriction</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Restriction</em>' containment reference.
   * @see #setRestriction(Expression)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getImportStmt_Restriction()
   * @model containment="true"
   * @generated
   */
  Expression getRestriction();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.ImportStmt#getRestriction <em>Restriction</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Restriction</em>' containment reference.
   * @see #getRestriction()
   * @generated
   */
  void setRestriction(Expression value);

} // ImportStmt
