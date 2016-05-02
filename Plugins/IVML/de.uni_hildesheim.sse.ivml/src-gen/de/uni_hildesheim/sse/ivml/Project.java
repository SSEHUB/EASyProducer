/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Project#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Project#getVersion <em>Version</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Project#getImports <em>Imports</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Project#getConflicts <em>Conflicts</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Project#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.Project#getContents <em>Contents</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getProject()
 * @model
 * @generated
 */
public interface Project extends EObject
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
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getProject_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Project#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Version</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Version</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version</em>' containment reference.
   * @see #setVersion(VersionStmt)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getProject_Version()
   * @model containment="true"
   * @generated
   */
  VersionStmt getVersion();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Project#getVersion <em>Version</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version</em>' containment reference.
   * @see #getVersion()
   * @generated
   */
  void setVersion(VersionStmt value);

  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.ivml.ImportStmt}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getProject_Imports()
   * @model containment="true"
   * @generated
   */
  EList<ImportStmt> getImports();

  /**
   * Returns the value of the '<em><b>Conflicts</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.ivml.ConflictStmt}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Conflicts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conflicts</em>' containment reference list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getProject_Conflicts()
   * @model containment="true"
   * @generated
   */
  EList<ConflictStmt> getConflicts();

  /**
   * Returns the value of the '<em><b>Interfaces</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.ivml.InterfaceDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interfaces</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interfaces</em>' containment reference list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getProject_Interfaces()
   * @model containment="true"
   * @generated
   */
  EList<InterfaceDeclaration> getInterfaces();

  /**
   * Returns the value of the '<em><b>Contents</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contents</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contents</em>' containment reference.
   * @see #setContents(ProjectContents)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getProject_Contents()
   * @model containment="true"
   * @generated
   */
  ProjectContents getContents();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.Project#getContents <em>Contents</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Contents</em>' containment reference.
   * @see #getContents()
   * @generated
   */
  void setContents(ProjectContents value);

} // Project
