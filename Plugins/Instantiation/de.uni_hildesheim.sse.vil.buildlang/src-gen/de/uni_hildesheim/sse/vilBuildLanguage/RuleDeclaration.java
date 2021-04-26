/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getModifier <em>Modifier</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getType <em>Type</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getParamList <em>Param List</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getConditions <em>Conditions</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRuleDeclaration()
 * @model
 * @generated
 */
public interface RuleDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Modifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modifier</em>' containment reference.
   * @see #setModifier(RuleModifier)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRuleDeclaration_Modifier()
   * @model containment="true"
   * @generated
   */
  RuleModifier getModifier();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getModifier <em>Modifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modifier</em>' containment reference.
   * @see #getModifier()
   * @generated
   */
  void setModifier(RuleModifier value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(Type)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRuleDeclaration_Type()
   * @model containment="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRuleDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Param List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param List</em>' containment reference.
   * @see #setParamList(ParameterList)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRuleDeclaration_ParamList()
   * @model containment="true"
   * @generated
   */
  ParameterList getParamList();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getParamList <em>Param List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Param List</em>' containment reference.
   * @see #getParamList()
   * @generated
   */
  void setParamList(ParameterList value);

  /**
   * Returns the value of the '<em><b>Conditions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conditions</em>' containment reference.
   * @see #setConditions(RuleConditions)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRuleDeclaration_Conditions()
   * @model containment="true"
   * @generated
   */
  RuleConditions getConditions();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getConditions <em>Conditions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Conditions</em>' containment reference.
   * @see #getConditions()
   * @generated
   */
  void setConditions(RuleConditions value);

  /**
   * Returns the value of the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Block</em>' containment reference.
   * @see #setBlock(RuleElementBlock)
   * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage#getRuleDeclaration_Block()
   * @model containment="true"
   * @generated
   */
  RuleElementBlock getBlock();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration#getBlock <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block</em>' containment reference.
   * @see #getBlock()
   * @generated
   */
  void setBlock(RuleElementBlock value);

} // RuleDeclaration
