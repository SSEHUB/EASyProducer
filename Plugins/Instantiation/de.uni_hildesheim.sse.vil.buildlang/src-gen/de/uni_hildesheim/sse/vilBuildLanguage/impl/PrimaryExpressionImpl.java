/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage.impl;

import de.uni_hildesheim.sse.vilBuildLanguage.Instantiate;
import de.uni_hildesheim.sse.vilBuildLanguage.Join;
import de.uni_hildesheim.sse.vilBuildLanguage.Map;
import de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression;
import de.uni_hildesheim.sse.vilBuildLanguage.SystemExecution;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.PrimaryExpressionImpl#getSysEx <em>Sys Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.PrimaryExpressionImpl#getMap <em>Map</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.PrimaryExpressionImpl#getJoin <em>Join</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.PrimaryExpressionImpl#getInstantiate <em>Instantiate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimaryExpressionImpl extends de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.PrimaryExpressionImpl implements PrimaryExpression
{
  /**
   * The cached value of the '{@link #getSysEx() <em>Sys Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSysEx()
   * @generated
   * @ordered
   */
  protected SystemExecution sysEx;

  /**
   * The cached value of the '{@link #getMap() <em>Map</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMap()
   * @generated
   * @ordered
   */
  protected Map map;

  /**
   * The cached value of the '{@link #getJoin() <em>Join</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJoin()
   * @generated
   * @ordered
   */
  protected Join join;

  /**
   * The cached value of the '{@link #getInstantiate() <em>Instantiate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInstantiate()
   * @generated
   * @ordered
   */
  protected Instantiate instantiate;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrimaryExpressionImpl()
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
    return VilBuildLanguagePackage.Literals.PRIMARY_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SystemExecution getSysEx()
  {
    return sysEx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSysEx(SystemExecution newSysEx, NotificationChain msgs)
  {
    SystemExecution oldSysEx = sysEx;
    sysEx = newSysEx;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.PRIMARY_EXPRESSION__SYS_EX, oldSysEx, newSysEx);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSysEx(SystemExecution newSysEx)
  {
    if (newSysEx != sysEx)
    {
      NotificationChain msgs = null;
      if (sysEx != null)
        msgs = ((InternalEObject)sysEx).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.PRIMARY_EXPRESSION__SYS_EX, null, msgs);
      if (newSysEx != null)
        msgs = ((InternalEObject)newSysEx).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.PRIMARY_EXPRESSION__SYS_EX, null, msgs);
      msgs = basicSetSysEx(newSysEx, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.PRIMARY_EXPRESSION__SYS_EX, newSysEx, newSysEx));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Map getMap()
  {
    return map;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMap(Map newMap, NotificationChain msgs)
  {
    Map oldMap = map;
    map = newMap;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.PRIMARY_EXPRESSION__MAP, oldMap, newMap);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMap(Map newMap)
  {
    if (newMap != map)
    {
      NotificationChain msgs = null;
      if (map != null)
        msgs = ((InternalEObject)map).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.PRIMARY_EXPRESSION__MAP, null, msgs);
      if (newMap != null)
        msgs = ((InternalEObject)newMap).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.PRIMARY_EXPRESSION__MAP, null, msgs);
      msgs = basicSetMap(newMap, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.PRIMARY_EXPRESSION__MAP, newMap, newMap));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Join getJoin()
  {
    return join;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetJoin(Join newJoin, NotificationChain msgs)
  {
    Join oldJoin = join;
    join = newJoin;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.PRIMARY_EXPRESSION__JOIN, oldJoin, newJoin);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJoin(Join newJoin)
  {
    if (newJoin != join)
    {
      NotificationChain msgs = null;
      if (join != null)
        msgs = ((InternalEObject)join).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.PRIMARY_EXPRESSION__JOIN, null, msgs);
      if (newJoin != null)
        msgs = ((InternalEObject)newJoin).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.PRIMARY_EXPRESSION__JOIN, null, msgs);
      msgs = basicSetJoin(newJoin, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.PRIMARY_EXPRESSION__JOIN, newJoin, newJoin));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Instantiate getInstantiate()
  {
    return instantiate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInstantiate(Instantiate newInstantiate, NotificationChain msgs)
  {
    Instantiate oldInstantiate = instantiate;
    instantiate = newInstantiate;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.PRIMARY_EXPRESSION__INSTANTIATE, oldInstantiate, newInstantiate);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInstantiate(Instantiate newInstantiate)
  {
    if (newInstantiate != instantiate)
    {
      NotificationChain msgs = null;
      if (instantiate != null)
        msgs = ((InternalEObject)instantiate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.PRIMARY_EXPRESSION__INSTANTIATE, null, msgs);
      if (newInstantiate != null)
        msgs = ((InternalEObject)newInstantiate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.PRIMARY_EXPRESSION__INSTANTIATE, null, msgs);
      msgs = basicSetInstantiate(newInstantiate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.PRIMARY_EXPRESSION__INSTANTIATE, newInstantiate, newInstantiate));
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
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__SYS_EX:
        return basicSetSysEx(null, msgs);
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__MAP:
        return basicSetMap(null, msgs);
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__JOIN:
        return basicSetJoin(null, msgs);
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__INSTANTIATE:
        return basicSetInstantiate(null, msgs);
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
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__SYS_EX:
        return getSysEx();
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__MAP:
        return getMap();
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__JOIN:
        return getJoin();
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__INSTANTIATE:
        return getInstantiate();
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
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__SYS_EX:
        setSysEx((SystemExecution)newValue);
        return;
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__MAP:
        setMap((Map)newValue);
        return;
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__JOIN:
        setJoin((Join)newValue);
        return;
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__INSTANTIATE:
        setInstantiate((Instantiate)newValue);
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
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__SYS_EX:
        setSysEx((SystemExecution)null);
        return;
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__MAP:
        setMap((Map)null);
        return;
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__JOIN:
        setJoin((Join)null);
        return;
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__INSTANTIATE:
        setInstantiate((Instantiate)null);
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
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__SYS_EX:
        return sysEx != null;
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__MAP:
        return map != null;
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__JOIN:
        return join != null;
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION__INSTANTIATE:
        return instantiate != null;
    }
    return super.eIsSet(featureID);
  }

} //PrimaryExpressionImpl
