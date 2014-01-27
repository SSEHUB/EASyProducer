/**
 * <copyright>
 * </copyright>
 *

 */
package de.uni_hildesheim.sse.ivml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import de.uni_hildesheim.sse.ivml.Expression;
import de.uni_hildesheim.sse.ivml.IfExpression;
import de.uni_hildesheim.sse.ivml.IvmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.IfExpressionImpl#getIfEx <em>If Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.IfExpressionImpl#getThenEx <em>Then Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.IfExpressionImpl#getElseEx <em>Else Ex</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfExpressionImpl extends MinimalEObjectImpl.Container implements IfExpression
{
  /**
   * The cached value of the '{@link #getIfEx() <em>If Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIfEx()
   * @generated
   * @ordered
   */
  protected Expression ifEx;

  /**
   * The cached value of the '{@link #getThenEx() <em>Then Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThenEx()
   * @generated
   * @ordered
   */
  protected Expression thenEx;

  /**
   * The cached value of the '{@link #getElseEx() <em>Else Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseEx()
   * @generated
   * @ordered
   */
  protected Expression elseEx;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfExpressionImpl()
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
    return IvmlPackage.Literals.IF_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getIfEx()
  {
    return ifEx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIfEx(Expression newIfEx, NotificationChain msgs)
  {
    Expression oldIfEx = ifEx;
    ifEx = newIfEx;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.IF_EXPRESSION__IF_EX, oldIfEx, newIfEx);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIfEx(Expression newIfEx)
  {
    if (newIfEx != ifEx)
    {
      NotificationChain msgs = null;
      if (ifEx != null)
        msgs = ((InternalEObject)ifEx).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.IF_EXPRESSION__IF_EX, null, msgs);
      if (newIfEx != null)
        msgs = ((InternalEObject)newIfEx).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.IF_EXPRESSION__IF_EX, null, msgs);
      msgs = basicSetIfEx(newIfEx, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.IF_EXPRESSION__IF_EX, newIfEx, newIfEx));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getThenEx()
  {
    return thenEx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetThenEx(Expression newThenEx, NotificationChain msgs)
  {
    Expression oldThenEx = thenEx;
    thenEx = newThenEx;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.IF_EXPRESSION__THEN_EX, oldThenEx, newThenEx);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setThenEx(Expression newThenEx)
  {
    if (newThenEx != thenEx)
    {
      NotificationChain msgs = null;
      if (thenEx != null)
        msgs = ((InternalEObject)thenEx).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.IF_EXPRESSION__THEN_EX, null, msgs);
      if (newThenEx != null)
        msgs = ((InternalEObject)newThenEx).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.IF_EXPRESSION__THEN_EX, null, msgs);
      msgs = basicSetThenEx(newThenEx, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.IF_EXPRESSION__THEN_EX, newThenEx, newThenEx));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getElseEx()
  {
    return elseEx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElseEx(Expression newElseEx, NotificationChain msgs)
  {
    Expression oldElseEx = elseEx;
    elseEx = newElseEx;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.IF_EXPRESSION__ELSE_EX, oldElseEx, newElseEx);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElseEx(Expression newElseEx)
  {
    if (newElseEx != elseEx)
    {
      NotificationChain msgs = null;
      if (elseEx != null)
        msgs = ((InternalEObject)elseEx).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.IF_EXPRESSION__ELSE_EX, null, msgs);
      if (newElseEx != null)
        msgs = ((InternalEObject)newElseEx).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.IF_EXPRESSION__ELSE_EX, null, msgs);
      msgs = basicSetElseEx(newElseEx, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.IF_EXPRESSION__ELSE_EX, newElseEx, newElseEx));
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
      case IvmlPackage.IF_EXPRESSION__IF_EX:
        return basicSetIfEx(null, msgs);
      case IvmlPackage.IF_EXPRESSION__THEN_EX:
        return basicSetThenEx(null, msgs);
      case IvmlPackage.IF_EXPRESSION__ELSE_EX:
        return basicSetElseEx(null, msgs);
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
      case IvmlPackage.IF_EXPRESSION__IF_EX:
        return getIfEx();
      case IvmlPackage.IF_EXPRESSION__THEN_EX:
        return getThenEx();
      case IvmlPackage.IF_EXPRESSION__ELSE_EX:
        return getElseEx();
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
      case IvmlPackage.IF_EXPRESSION__IF_EX:
        setIfEx((Expression)newValue);
        return;
      case IvmlPackage.IF_EXPRESSION__THEN_EX:
        setThenEx((Expression)newValue);
        return;
      case IvmlPackage.IF_EXPRESSION__ELSE_EX:
        setElseEx((Expression)newValue);
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
      case IvmlPackage.IF_EXPRESSION__IF_EX:
        setIfEx((Expression)null);
        return;
      case IvmlPackage.IF_EXPRESSION__THEN_EX:
        setThenEx((Expression)null);
        return;
      case IvmlPackage.IF_EXPRESSION__ELSE_EX:
        setElseEx((Expression)null);
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
      case IvmlPackage.IF_EXPRESSION__IF_EX:
        return ifEx != null;
      case IvmlPackage.IF_EXPRESSION__THEN_EX:
        return thenEx != null;
      case IvmlPackage.IF_EXPRESSION__ELSE_EX:
        return elseEx != null;
    }
    return super.eIsSet(featureID);
  }

} //IfExpressionImpl
