/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression;

import de.uni_hildesheim.sse.vilBuildLanguage.RuleConditions;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Conditions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleConditionsImpl#getPostcondition <em>Postcondition</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleConditionsImpl#getPreconditions <em>Preconditions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleConditionsImpl extends MinimalEObjectImpl.Container implements RuleConditions
{
  /**
   * The cached value of the '{@link #getPostcondition() <em>Postcondition</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostcondition()
   * @generated
   * @ordered
   */
  protected EList<LogicalExpression> postcondition;

  /**
   * The cached value of the '{@link #getPreconditions() <em>Preconditions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreconditions()
   * @generated
   * @ordered
   */
  protected EList<LogicalExpression> preconditions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleConditionsImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return VilBuildLanguagePackage.Literals.RULE_CONDITIONS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LogicalExpression> getPostcondition()
  {
    if (postcondition == null)
    {
      postcondition = new EObjectContainmentEList<LogicalExpression>(LogicalExpression.class, this, VilBuildLanguagePackage.RULE_CONDITIONS__POSTCONDITION);
    }
    return postcondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LogicalExpression> getPreconditions()
  {
    if (preconditions == null)
    {
      preconditions = new EObjectContainmentEList<LogicalExpression>(LogicalExpression.class, this, VilBuildLanguagePackage.RULE_CONDITIONS__PRECONDITIONS);
    }
    return preconditions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case VilBuildLanguagePackage.RULE_CONDITIONS__POSTCONDITION:
        return ((InternalEList<?>)getPostcondition()).basicRemove(otherEnd, msgs);
      case VilBuildLanguagePackage.RULE_CONDITIONS__PRECONDITIONS:
        return ((InternalEList<?>)getPreconditions()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case VilBuildLanguagePackage.RULE_CONDITIONS__POSTCONDITION:
        return getPostcondition();
      case VilBuildLanguagePackage.RULE_CONDITIONS__PRECONDITIONS:
        return getPreconditions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case VilBuildLanguagePackage.RULE_CONDITIONS__POSTCONDITION:
        getPostcondition().clear();
        getPostcondition().addAll((Collection<? extends LogicalExpression>)newValue);
        return;
      case VilBuildLanguagePackage.RULE_CONDITIONS__PRECONDITIONS:
        getPreconditions().clear();
        getPreconditions().addAll((Collection<? extends LogicalExpression>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case VilBuildLanguagePackage.RULE_CONDITIONS__POSTCONDITION:
        getPostcondition().clear();
        return;
      case VilBuildLanguagePackage.RULE_CONDITIONS__PRECONDITIONS:
        getPreconditions().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case VilBuildLanguagePackage.RULE_CONDITIONS__POSTCONDITION:
        return postcondition != null && !postcondition.isEmpty();
      case VilBuildLanguagePackage.RULE_CONDITIONS__PRECONDITIONS:
        return preconditions != null && !preconditions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RuleConditionsImpl
