/**
 */
package de.uni_hildesheim.sse.vil.rt.rtVil;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.GlobalVariableDeclaration#getPersistent <em>Persistent</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.GlobalVariableDeclaration#getVarDecl <em>Var Decl</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getGlobalVariableDeclaration()
 * @model
 * @generated
 */
public interface GlobalVariableDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Persistent</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Persistent</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Persistent</em>' attribute.
   * @see #setPersistent(String)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getGlobalVariableDeclaration_Persistent()
   * @model
   * @generated
   */
  String getPersistent();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.GlobalVariableDeclaration#getPersistent <em>Persistent</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Persistent</em>' attribute.
   * @see #getPersistent()
   * @generated
   */
  void setPersistent(String value);

  /**
   * Returns the value of the '<em><b>Var Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var Decl</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var Decl</em>' containment reference.
   * @see #setVarDecl(VariableDeclaration)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getGlobalVariableDeclaration_VarDecl()
   * @model containment="true"
   * @generated
   */
  VariableDeclaration getVarDecl();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.GlobalVariableDeclaration#getVarDecl <em>Var Decl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var Decl</em>' containment reference.
   * @see #getVarDecl()
   * @generated
   */
  void setVarDecl(VariableDeclaration value);

} // GlobalVariableDeclaration
