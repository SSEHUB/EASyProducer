/**
 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>multiselect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.multiselect#getGen <em>Gen</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.multiselect#getUser <em>User</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getmultiselect()
 * @model
 * @generated
 */
public interface multiselect extends EObject
{
  /**
   * Returns the value of the '<em><b>Gen</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Gen</em>' containment reference.
   * @see #setGen(genericMultiselect)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getmultiselect_Gen()
   * @model containment="true"
   * @generated
   */
  genericMultiselect getGen();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.multiselect#getGen <em>Gen</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Gen</em>' containment reference.
   * @see #getGen()
   * @generated
   */
  void setGen(genericMultiselect value);

  /**
   * Returns the value of the '<em><b>User</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>User</em>' containment reference.
   * @see #setUser(userMultiselect)
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage#getmultiselect_User()
   * @model containment="true"
   * @generated
   */
  userMultiselect getUser();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.multiselect#getUser <em>User</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User</em>' containment reference.
   * @see #getUser()
   * @generated
   */
  void setUser(userMultiselect value);

} // multiselect
