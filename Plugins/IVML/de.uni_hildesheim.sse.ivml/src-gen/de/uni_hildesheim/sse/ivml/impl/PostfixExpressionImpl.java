/**
 */
package de.uni_hildesheim.sse.ivml.impl;

import de.uni_hildesheim.sse.ivml.Call;
import de.uni_hildesheim.sse.ivml.ExpressionAccess;
import de.uni_hildesheim.sse.ivml.FeatureCall;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.PostfixExpression;
import de.uni_hildesheim.sse.ivml.PrimaryExpression;

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
 * An implementation of the model object '<em><b>Postfix Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.PostfixExpressionImpl#getCall <em>Call</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.PostfixExpressionImpl#getFCalls <em>FCalls</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.PostfixExpressionImpl#getAccess <em>Access</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.PostfixExpressionImpl#getLeft <em>Left</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PostfixExpressionImpl extends MinimalEObjectImpl.Container implements PostfixExpression
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
   * The cached value of the '{@link #getFCalls() <em>FCalls</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFCalls()
   * @generated
   * @ordered
   */
  protected EList<Call> fCalls;

  /**
   * The cached value of the '{@link #getAccess() <em>Access</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccess()
   * @generated
   * @ordered
   */
  protected ExpressionAccess access;

  /**
   * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeft()
   * @generated
   * @ordered
   */
  protected PrimaryExpression left;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PostfixExpressionImpl()
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
    return IvmlPackage.Literals.POSTFIX_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.POSTFIX_EXPRESSION__CALL, oldCall, newCall);
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
  public void setCall(FeatureCall newCall)
  {
    if (newCall != call)
    {
      NotificationChain msgs = null;
      if (call != null)
        msgs = ((InternalEObject)call).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.POSTFIX_EXPRESSION__CALL, null, msgs);
      if (newCall != null)
        msgs = ((InternalEObject)newCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.POSTFIX_EXPRESSION__CALL, null, msgs);
      msgs = basicSetCall(newCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.POSTFIX_EXPRESSION__CALL, newCall, newCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Call> getFCalls()
  {
    if (fCalls == null)
    {
      fCalls = new EObjectContainmentEList<Call>(Call.class, this, IvmlPackage.POSTFIX_EXPRESSION__FCALLS);
    }
    return fCalls;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExpressionAccess getAccess()
  {
    return access;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAccess(ExpressionAccess newAccess, NotificationChain msgs)
  {
    ExpressionAccess oldAccess = access;
    access = newAccess;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.POSTFIX_EXPRESSION__ACCESS, oldAccess, newAccess);
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
  public void setAccess(ExpressionAccess newAccess)
  {
    if (newAccess != access)
    {
      NotificationChain msgs = null;
      if (access != null)
        msgs = ((InternalEObject)access).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.POSTFIX_EXPRESSION__ACCESS, null, msgs);
      if (newAccess != null)
        msgs = ((InternalEObject)newAccess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.POSTFIX_EXPRESSION__ACCESS, null, msgs);
      msgs = basicSetAccess(newAccess, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.POSTFIX_EXPRESSION__ACCESS, newAccess, newAccess));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PrimaryExpression getLeft()
  {
    return left;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeft(PrimaryExpression newLeft, NotificationChain msgs)
  {
    PrimaryExpression oldLeft = left;
    left = newLeft;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.POSTFIX_EXPRESSION__LEFT, oldLeft, newLeft);
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
  public void setLeft(PrimaryExpression newLeft)
  {
    if (newLeft != left)
    {
      NotificationChain msgs = null;
      if (left != null)
        msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.POSTFIX_EXPRESSION__LEFT, null, msgs);
      if (newLeft != null)
        msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.POSTFIX_EXPRESSION__LEFT, null, msgs);
      msgs = basicSetLeft(newLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.POSTFIX_EXPRESSION__LEFT, newLeft, newLeft));
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
      case IvmlPackage.POSTFIX_EXPRESSION__CALL:
        return basicSetCall(null, msgs);
      case IvmlPackage.POSTFIX_EXPRESSION__FCALLS:
        return ((InternalEList<?>)getFCalls()).basicRemove(otherEnd, msgs);
      case IvmlPackage.POSTFIX_EXPRESSION__ACCESS:
        return basicSetAccess(null, msgs);
      case IvmlPackage.POSTFIX_EXPRESSION__LEFT:
        return basicSetLeft(null, msgs);
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
      case IvmlPackage.POSTFIX_EXPRESSION__CALL:
        return getCall();
      case IvmlPackage.POSTFIX_EXPRESSION__FCALLS:
        return getFCalls();
      case IvmlPackage.POSTFIX_EXPRESSION__ACCESS:
        return getAccess();
      case IvmlPackage.POSTFIX_EXPRESSION__LEFT:
        return getLeft();
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
      case IvmlPackage.POSTFIX_EXPRESSION__CALL:
        setCall((FeatureCall)newValue);
        return;
      case IvmlPackage.POSTFIX_EXPRESSION__FCALLS:
        getFCalls().clear();
        getFCalls().addAll((Collection<? extends Call>)newValue);
        return;
      case IvmlPackage.POSTFIX_EXPRESSION__ACCESS:
        setAccess((ExpressionAccess)newValue);
        return;
      case IvmlPackage.POSTFIX_EXPRESSION__LEFT:
        setLeft((PrimaryExpression)newValue);
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
      case IvmlPackage.POSTFIX_EXPRESSION__CALL:
        setCall((FeatureCall)null);
        return;
      case IvmlPackage.POSTFIX_EXPRESSION__FCALLS:
        getFCalls().clear();
        return;
      case IvmlPackage.POSTFIX_EXPRESSION__ACCESS:
        setAccess((ExpressionAccess)null);
        return;
      case IvmlPackage.POSTFIX_EXPRESSION__LEFT:
        setLeft((PrimaryExpression)null);
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
      case IvmlPackage.POSTFIX_EXPRESSION__CALL:
        return call != null;
      case IvmlPackage.POSTFIX_EXPRESSION__FCALLS:
        return fCalls != null && !fCalls.isEmpty();
      case IvmlPackage.POSTFIX_EXPRESSION__ACCESS:
        return access != null;
      case IvmlPackage.POSTFIX_EXPRESSION__LEFT:
        return left != null;
    }
    return super.eIsSet(featureID);
  }

} //PostfixExpressionImpl
