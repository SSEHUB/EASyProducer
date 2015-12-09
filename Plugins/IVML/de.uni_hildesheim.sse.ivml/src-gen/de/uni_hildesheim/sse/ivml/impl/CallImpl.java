/**
 */
package de.uni_hildesheim.sse.ivml.impl;

import de.uni_hildesheim.sse.ivml.Call;
import de.uni_hildesheim.sse.ivml.Expression;
import de.uni_hildesheim.sse.ivml.FeatureCall;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.SetOp;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.CallImpl#getCall <em>Call</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.CallImpl#getSetOp <em>Set Op</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.CallImpl#getArrayEx <em>Array Ex</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CallImpl extends MinimalEObjectImpl.Container implements Call
{
  /**
   * The cached value of the '{@link #getCall() <em>Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCall()
   * @generated
   * @ordered
   */
  protected FeatureCall call;

  /**
   * The cached value of the '{@link #getSetOp() <em>Set Op</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSetOp()
   * @generated
   * @ordered
   */
  protected SetOp setOp;

  /**
   * The cached value of the '{@link #getArrayEx() <em>Array Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrayEx()
   * @generated
   * @ordered
   */
  protected Expression arrayEx;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CallImpl()
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
    return IvmlPackage.Literals.CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureCall getCall()
  {
    return call;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCall(FeatureCall newCall, NotificationChain msgs)
  {
    FeatureCall oldCall = call;
    call = newCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.CALL__CALL, oldCall, newCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCall(FeatureCall newCall)
  {
    if (newCall != call)
    {
      NotificationChain msgs = null;
      if (call != null)
        msgs = ((InternalEObject)call).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.CALL__CALL, null, msgs);
      if (newCall != null)
        msgs = ((InternalEObject)newCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.CALL__CALL, null, msgs);
      msgs = basicSetCall(newCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.CALL__CALL, newCall, newCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SetOp getSetOp()
  {
    return setOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSetOp(SetOp newSetOp, NotificationChain msgs)
  {
    SetOp oldSetOp = setOp;
    setOp = newSetOp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.CALL__SET_OP, oldSetOp, newSetOp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSetOp(SetOp newSetOp)
  {
    if (newSetOp != setOp)
    {
      NotificationChain msgs = null;
      if (setOp != null)
        msgs = ((InternalEObject)setOp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.CALL__SET_OP, null, msgs);
      if (newSetOp != null)
        msgs = ((InternalEObject)newSetOp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.CALL__SET_OP, null, msgs);
      msgs = basicSetSetOp(newSetOp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.CALL__SET_OP, newSetOp, newSetOp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getArrayEx()
  {
    return arrayEx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArrayEx(Expression newArrayEx, NotificationChain msgs)
  {
    Expression oldArrayEx = arrayEx;
    arrayEx = newArrayEx;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.CALL__ARRAY_EX, oldArrayEx, newArrayEx);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArrayEx(Expression newArrayEx)
  {
    if (newArrayEx != arrayEx)
    {
      NotificationChain msgs = null;
      if (arrayEx != null)
        msgs = ((InternalEObject)arrayEx).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.CALL__ARRAY_EX, null, msgs);
      if (newArrayEx != null)
        msgs = ((InternalEObject)newArrayEx).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.CALL__ARRAY_EX, null, msgs);
      msgs = basicSetArrayEx(newArrayEx, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.CALL__ARRAY_EX, newArrayEx, newArrayEx));
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
      case IvmlPackage.CALL__CALL:
        return basicSetCall(null, msgs);
      case IvmlPackage.CALL__SET_OP:
        return basicSetSetOp(null, msgs);
      case IvmlPackage.CALL__ARRAY_EX:
        return basicSetArrayEx(null, msgs);
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
      case IvmlPackage.CALL__CALL:
        return getCall();
      case IvmlPackage.CALL__SET_OP:
        return getSetOp();
      case IvmlPackage.CALL__ARRAY_EX:
        return getArrayEx();
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
      case IvmlPackage.CALL__CALL:
        setCall((FeatureCall)newValue);
        return;
      case IvmlPackage.CALL__SET_OP:
        setSetOp((SetOp)newValue);
        return;
      case IvmlPackage.CALL__ARRAY_EX:
        setArrayEx((Expression)newValue);
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
      case IvmlPackage.CALL__CALL:
        setCall((FeatureCall)null);
        return;
      case IvmlPackage.CALL__SET_OP:
        setSetOp((SetOp)null);
        return;
      case IvmlPackage.CALL__ARRAY_EX:
        setArrayEx((Expression)null);
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
      case IvmlPackage.CALL__CALL:
        return call != null;
      case IvmlPackage.CALL__SET_OP:
        return setOp != null;
      case IvmlPackage.CALL__ARRAY_EX:
        return arrayEx != null;
    }
    return super.eIsSet(featureID);
  }

} //CallImpl
