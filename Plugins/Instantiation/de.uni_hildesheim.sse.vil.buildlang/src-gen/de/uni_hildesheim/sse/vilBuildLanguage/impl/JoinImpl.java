/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;

import de.uni_hildesheim.sse.vilBuildLanguage.Join;
import de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Join</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.JoinImpl#getVar1 <em>Var1</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.JoinImpl#getVar2 <em>Var2</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.JoinImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JoinImpl extends MinimalEObjectImpl.Container implements Join
{
  /**
   * The cached value of the '{@link #getVar1() <em>Var1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVar1()
   * @generated
   * @ordered
   */
  protected JoinVariable var1;

  /**
   * The cached value of the '{@link #getVar2() <em>Var2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVar2()
   * @generated
   * @ordered
   */
  protected JoinVariable var2;

  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected Expression condition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JoinImpl()
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
    return VilBuildLanguagePackage.Literals.JOIN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JoinVariable getVar1()
  {
    return var1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVar1(JoinVariable newVar1, NotificationChain msgs)
  {
    JoinVariable oldVar1 = var1;
    var1 = newVar1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.JOIN__VAR1, oldVar1, newVar1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVar1(JoinVariable newVar1)
  {
    if (newVar1 != var1)
    {
      NotificationChain msgs = null;
      if (var1 != null)
        msgs = ((InternalEObject)var1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.JOIN__VAR1, null, msgs);
      if (newVar1 != null)
        msgs = ((InternalEObject)newVar1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.JOIN__VAR1, null, msgs);
      msgs = basicSetVar1(newVar1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.JOIN__VAR1, newVar1, newVar1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JoinVariable getVar2()
  {
    return var2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVar2(JoinVariable newVar2, NotificationChain msgs)
  {
    JoinVariable oldVar2 = var2;
    var2 = newVar2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.JOIN__VAR2, oldVar2, newVar2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVar2(JoinVariable newVar2)
  {
    if (newVar2 != var2)
    {
      NotificationChain msgs = null;
      if (var2 != null)
        msgs = ((InternalEObject)var2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.JOIN__VAR2, null, msgs);
      if (newVar2 != null)
        msgs = ((InternalEObject)newVar2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.JOIN__VAR2, null, msgs);
      msgs = basicSetVar2(newVar2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.JOIN__VAR2, newVar2, newVar2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs)
  {
    Expression oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.JOIN__CONDITION, oldCondition, newCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondition(Expression newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.JOIN__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.JOIN__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.JOIN__CONDITION, newCondition, newCondition));
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
      case VilBuildLanguagePackage.JOIN__VAR1:
        return basicSetVar1(null, msgs);
      case VilBuildLanguagePackage.JOIN__VAR2:
        return basicSetVar2(null, msgs);
      case VilBuildLanguagePackage.JOIN__CONDITION:
        return basicSetCondition(null, msgs);
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
      case VilBuildLanguagePackage.JOIN__VAR1:
        return getVar1();
      case VilBuildLanguagePackage.JOIN__VAR2:
        return getVar2();
      case VilBuildLanguagePackage.JOIN__CONDITION:
        return getCondition();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case VilBuildLanguagePackage.JOIN__VAR1:
        setVar1((JoinVariable)newValue);
        return;
      case VilBuildLanguagePackage.JOIN__VAR2:
        setVar2((JoinVariable)newValue);
        return;
      case VilBuildLanguagePackage.JOIN__CONDITION:
        setCondition((Expression)newValue);
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
      case VilBuildLanguagePackage.JOIN__VAR1:
        setVar1((JoinVariable)null);
        return;
      case VilBuildLanguagePackage.JOIN__VAR2:
        setVar2((JoinVariable)null);
        return;
      case VilBuildLanguagePackage.JOIN__CONDITION:
        setCondition((Expression)null);
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
      case VilBuildLanguagePackage.JOIN__VAR1:
        return var1 != null;
      case VilBuildLanguagePackage.JOIN__VAR2:
        return var2 != null;
      case VilBuildLanguagePackage.JOIN__CONDITION:
        return condition != null;
    }
    return super.eIsSet(featureID);
  }

} //JoinImpl
