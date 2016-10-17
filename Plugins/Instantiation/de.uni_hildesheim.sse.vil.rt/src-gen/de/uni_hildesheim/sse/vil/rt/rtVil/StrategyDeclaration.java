/**
 */
package de.uni_hildesheim.sse.vil.rt.rtVil;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;

import de.uni_hildesheim.sse.vilBuildLanguage.RuleConditions;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Strategy Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getParamList <em>Param List</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getConditions <em>Conditions</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getVarDecls <em>Var Decls</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getObjective <em>Objective</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getWeighting <em>Weighting</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getBreakdown <em>Breakdown</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getPost <em>Post</em>}</li>
 * </ul>
 *
 * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getStrategyDeclaration()
 * @model
 * @generated
 */
public interface StrategyDeclaration extends EObject
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
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getStrategyDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getName <em>Name</em>}' attribute.
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
   * <p>
   * If the meaning of the '<em>Param List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param List</em>' containment reference.
   * @see #setParamList(ParameterList)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getStrategyDeclaration_ParamList()
   * @model containment="true"
   * @generated
   */
  ParameterList getParamList();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getParamList <em>Param List</em>}' containment reference.
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
   * <p>
   * If the meaning of the '<em>Conditions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conditions</em>' containment reference.
   * @see #setConditions(RuleConditions)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getStrategyDeclaration_Conditions()
   * @model containment="true"
   * @generated
   */
  RuleConditions getConditions();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getConditions <em>Conditions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Conditions</em>' containment reference.
   * @see #getConditions()
   * @generated
   */
  void setConditions(RuleConditions value);

  /**
   * Returns the value of the '<em><b>Var Decls</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var Decls</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var Decls</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getStrategyDeclaration_VarDecls()
   * @model containment="true"
   * @generated
   */
  EList<VariableDeclaration> getVarDecls();

  /**
   * Returns the value of the '<em><b>Objective</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Objective</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Objective</em>' containment reference.
   * @see #setObjective(Expression)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getStrategyDeclaration_Objective()
   * @model containment="true"
   * @generated
   */
  Expression getObjective();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getObjective <em>Objective</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Objective</em>' containment reference.
   * @see #getObjective()
   * @generated
   */
  void setObjective(Expression value);

  /**
   * Returns the value of the '<em><b>Weighting</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Weighting</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Weighting</em>' containment reference.
   * @see #setWeighting(WeightingStatement)
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getStrategyDeclaration_Weighting()
   * @model containment="true"
   * @generated
   */
  WeightingStatement getWeighting();

  /**
   * Sets the value of the '{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration#getWeighting <em>Weighting</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Weighting</em>' containment reference.
   * @see #getWeighting()
   * @generated
   */
  void setWeighting(WeightingStatement value);

  /**
   * Returns the value of the '<em><b>Breakdown</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Breakdown</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Breakdown</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getStrategyDeclaration_Breakdown()
   * @model containment="true"
   * @generated
   */
  EList<BreakdownElement> getBreakdown();

  /**
   * Returns the value of the '<em><b>Post</b></em>' containment reference list.
   * The list contents are of type {@link de.uni_hildesheim.sse.vil.rt.rtVil.RuleElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Post</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Post</em>' containment reference list.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage#getStrategyDeclaration_Post()
   * @model containment="true"
   * @generated
   */
  EList<RuleElement> getPost();

} // StrategyDeclaration
