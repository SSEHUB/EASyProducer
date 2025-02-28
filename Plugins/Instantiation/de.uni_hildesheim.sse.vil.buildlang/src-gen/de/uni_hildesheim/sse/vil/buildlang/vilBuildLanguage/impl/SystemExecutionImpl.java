/**
 * generated by Xtext 2.35.0
 */
package de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.impl;

import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.SystemExecution;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.VilBuildLanguagePackage;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.SubCall;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Execution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.impl.SystemExecutionImpl#getCall <em>Call</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.impl.SystemExecutionImpl#getCalls <em>Calls</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemExecutionImpl extends MinimalEObjectImpl.Container implements SystemExecution
{
  /**
   * The cached value of the '{@link #getCall() <em>Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCall()
   * @generated
   * @ordered
   */
  protected Call call;

  /**
   * The cached value of the '{@link #getCalls() <em>Calls</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCalls()
   * @generated
   * @ordered
   */
  protected EList<SubCall> calls;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SystemExecutionImpl()
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
    return VilBuildLanguagePackage.Literals.SYSTEM_EXECUTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Call getCall()
  {
    return call;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCall(Call newCall, NotificationChain msgs)
  {
    Call oldCall = call;
    call = newCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.SYSTEM_EXECUTION__CALL, oldCall, newCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCall(Call newCall)
  {
    if (newCall != call)
    {
      NotificationChain msgs = null;
      if (call != null)
        msgs = ((InternalEObject)call).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.SYSTEM_EXECUTION__CALL, null, msgs);
      if (newCall != null)
        msgs = ((InternalEObject)newCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.SYSTEM_EXECUTION__CALL, null, msgs);
      msgs = basicSetCall(newCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.SYSTEM_EXECUTION__CALL, newCall, newCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<SubCall> getCalls()
  {
    if (calls == null)
    {
      calls = new EObjectContainmentEList<SubCall>(SubCall.class, this, VilBuildLanguagePackage.SYSTEM_EXECUTION__CALLS);
    }
    return calls;
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
      case VilBuildLanguagePackage.SYSTEM_EXECUTION__CALL:
        return basicSetCall(null, msgs);
      case VilBuildLanguagePackage.SYSTEM_EXECUTION__CALLS:
        return ((InternalEList<?>)getCalls()).basicRemove(otherEnd, msgs);
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
      case VilBuildLanguagePackage.SYSTEM_EXECUTION__CALL:
        return getCall();
      case VilBuildLanguagePackage.SYSTEM_EXECUTION__CALLS:
        return getCalls();
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
      case VilBuildLanguagePackage.SYSTEM_EXECUTION__CALL:
        setCall((Call)newValue);
        return;
      case VilBuildLanguagePackage.SYSTEM_EXECUTION__CALLS:
        getCalls().clear();
        getCalls().addAll((Collection<? extends SubCall>)newValue);
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
      case VilBuildLanguagePackage.SYSTEM_EXECUTION__CALL:
        setCall((Call)null);
        return;
      case VilBuildLanguagePackage.SYSTEM_EXECUTION__CALLS:
        getCalls().clear();
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
      case VilBuildLanguagePackage.SYSTEM_EXECUTION__CALL:
        return call != null;
      case VilBuildLanguagePackage.SYSTEM_EXECUTION__CALLS:
        return calls != null && !calls.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SystemExecutionImpl
