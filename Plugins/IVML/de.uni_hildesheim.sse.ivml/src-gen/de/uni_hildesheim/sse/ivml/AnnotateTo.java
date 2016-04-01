/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotate To</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.AnnotateTo#getSname <em>Sname</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.AnnotateTo#getAnnotationType <em>Annotation Type</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.AnnotateTo#getAnnotationDecl <em>Annotation Decl</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.AnnotateTo#getNames <em>Names</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAnnotateTo()
 * @model
 * @generated
 */
public interface AnnotateTo extends EObject
{
  /**
   * Returns the value of the '<em><b>Sname</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sname</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sname</em>' attribute.
   * @see #setSname(String)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAnnotateTo_Sname()
   * @model
   * @generated
   */
  String getSname();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.AnnotateTo#getSname <em>Sname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sname</em>' attribute.
   * @see #getSname()
   * @generated
   */
  void setSname(String value);

  /**
   * Returns the value of the '<em><b>Annotation Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotation Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotation Type</em>' containment reference.
   * @see #setAnnotationType(Type)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAnnotateTo_AnnotationType()
   * @model containment="true"
   * @generated
   */
  Type getAnnotationType();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.AnnotateTo#getAnnotationType <em>Annotation Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Annotation Type</em>' containment reference.
   * @see #getAnnotationType()
   * @generated
   */
  void setAnnotationType(Type value);

  /**
   * Returns the value of the '<em><b>Annotation Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotation Decl</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotation Decl</em>' containment reference.
   * @see #setAnnotationDecl(VariableDeclarationPart)
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAnnotateTo_AnnotationDecl()
   * @model containment="true"
   * @generated
   */
  VariableDeclarationPart getAnnotationDecl();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.ivml.AnnotateTo#getAnnotationDecl <em>Annotation Decl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Annotation Decl</em>' containment reference.
   * @see #getAnnotationDecl()
   * @generated
   */
  void setAnnotationDecl(VariableDeclarationPart value);

  /**
   * Returns the value of the '<em><b>Names</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Names</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Names</em>' attribute list.
   * @see de.uni_hildesheim.sse.ivml.IvmlPackage#getAnnotateTo_Names()
   * @model unique="false"
   * @generated
   */
  EList<String> getNames();

} // AnnotateTo
