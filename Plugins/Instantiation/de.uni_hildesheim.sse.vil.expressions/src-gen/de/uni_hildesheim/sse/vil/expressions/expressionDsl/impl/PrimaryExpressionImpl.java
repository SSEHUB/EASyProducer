/**
 * <copyright>
 * </copyright>
 *

 */
package de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ConstructorExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionOrQualifiedExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.SuperExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnqualifiedExecution;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.PrimaryExpressionImpl#getOtherEx <em>Other Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.PrimaryExpressionImpl#getUnqEx <em>Unq Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.PrimaryExpressionImpl#getSuperEx <em>Super Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.PrimaryExpressionImpl#getNewEx <em>New Ex</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimaryExpressionImpl extends MinimalEObjectImpl.Container implements PrimaryExpression
{
  /**
   * The cached value of the '{@link #getOtherEx() <em>Other Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOtherEx()
   * @generated
   * @ordered
   */
  protected ExpressionOrQualifiedExecution otherEx;

  /**
   * The cached value of the '{@link #getUnqEx() <em>Unq Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnqEx()
   * @generated
   * @ordered
   */
  protected UnqualifiedExecution unqEx;

  /**
   * The cached value of the '{@link #getSuperEx() <em>Super Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperEx()
   * @generated
   * @ordered
   */
  protected SuperExecution superEx;

  /**
   * The cached value of the '{@link #getNewEx() <em>New Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNewEx()
   * @generated
   * @ordered
   */
  protected ConstructorExecution newEx;

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
    return ExpressionDslPackage.Literals.PRIMARY_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionOrQualifiedExecution getOtherEx()
  {
    return otherEx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOtherEx(ExpressionOrQualifiedExecution newOtherEx, NotificationChain msgs)
  {
    ExpressionOrQualifiedExecution oldOtherEx = otherEx;
    otherEx = newOtherEx;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.PRIMARY_EXPRESSION__OTHER_EX, oldOtherEx, newOtherEx);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOtherEx(ExpressionOrQualifiedExecution newOtherEx)
  {
    if (newOtherEx != otherEx)
    {
      NotificationChain msgs = null;
      if (otherEx != null)
        msgs = ((InternalEObject)otherEx).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.PRIMARY_EXPRESSION__OTHER_EX, null, msgs);
      if (newOtherEx != null)
        msgs = ((InternalEObject)newOtherEx).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.PRIMARY_EXPRESSION__OTHER_EX, null, msgs);
      msgs = basicSetOtherEx(newOtherEx, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.PRIMARY_EXPRESSION__OTHER_EX, newOtherEx, newOtherEx));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnqualifiedExecution getUnqEx()
  {
    return unqEx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUnqEx(UnqualifiedExecution newUnqEx, NotificationChain msgs)
  {
    UnqualifiedExecution oldUnqEx = unqEx;
    unqEx = newUnqEx;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.PRIMARY_EXPRESSION__UNQ_EX, oldUnqEx, newUnqEx);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnqEx(UnqualifiedExecution newUnqEx)
  {
    if (newUnqEx != unqEx)
    {
      NotificationChain msgs = null;
      if (unqEx != null)
        msgs = ((InternalEObject)unqEx).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.PRIMARY_EXPRESSION__UNQ_EX, null, msgs);
      if (newUnqEx != null)
        msgs = ((InternalEObject)newUnqEx).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.PRIMARY_EXPRESSION__UNQ_EX, null, msgs);
      msgs = basicSetUnqEx(newUnqEx, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.PRIMARY_EXPRESSION__UNQ_EX, newUnqEx, newUnqEx));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuperExecution getSuperEx()
  {
    return superEx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSuperEx(SuperExecution newSuperEx, NotificationChain msgs)
  {
    SuperExecution oldSuperEx = superEx;
    superEx = newSuperEx;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.PRIMARY_EXPRESSION__SUPER_EX, oldSuperEx, newSuperEx);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuperEx(SuperExecution newSuperEx)
  {
    if (newSuperEx != superEx)
    {
      NotificationChain msgs = null;
      if (superEx != null)
        msgs = ((InternalEObject)superEx).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.PRIMARY_EXPRESSION__SUPER_EX, null, msgs);
      if (newSuperEx != null)
        msgs = ((InternalEObject)newSuperEx).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.PRIMARY_EXPRESSION__SUPER_EX, null, msgs);
      msgs = basicSetSuperEx(newSuperEx, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.PRIMARY_EXPRESSION__SUPER_EX, newSuperEx, newSuperEx));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstructorExecution getNewEx()
  {
    return newEx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNewEx(ConstructorExecution newNewEx, NotificationChain msgs)
  {
    ConstructorExecution oldNewEx = newEx;
    newEx = newNewEx;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.PRIMARY_EXPRESSION__NEW_EX, oldNewEx, newNewEx);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNewEx(ConstructorExecution newNewEx)
  {
    if (newNewEx != newEx)
    {
      NotificationChain msgs = null;
      if (newEx != null)
        msgs = ((InternalEObject)newEx).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.PRIMARY_EXPRESSION__NEW_EX, null, msgs);
      if (newNewEx != null)
        msgs = ((InternalEObject)newNewEx).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.PRIMARY_EXPRESSION__NEW_EX, null, msgs);
      msgs = basicSetNewEx(newNewEx, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.PRIMARY_EXPRESSION__NEW_EX, newNewEx, newNewEx));
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
      case ExpressionDslPackage.PRIMARY_EXPRESSION__OTHER_EX:
        return basicSetOtherEx(null, msgs);
      case ExpressionDslPackage.PRIMARY_EXPRESSION__UNQ_EX:
        return basicSetUnqEx(null, msgs);
      case ExpressionDslPackage.PRIMARY_EXPRESSION__SUPER_EX:
        return basicSetSuperEx(null, msgs);
      case ExpressionDslPackage.PRIMARY_EXPRESSION__NEW_EX:
        return basicSetNewEx(null, msgs);
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
      case ExpressionDslPackage.PRIMARY_EXPRESSION__OTHER_EX:
        return getOtherEx();
      case ExpressionDslPackage.PRIMARY_EXPRESSION__UNQ_EX:
        return getUnqEx();
      case ExpressionDslPackage.PRIMARY_EXPRESSION__SUPER_EX:
        return getSuperEx();
      case ExpressionDslPackage.PRIMARY_EXPRESSION__NEW_EX:
        return getNewEx();
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
      case ExpressionDslPackage.PRIMARY_EXPRESSION__OTHER_EX:
        setOtherEx((ExpressionOrQualifiedExecution)newValue);
        return;
      case ExpressionDslPackage.PRIMARY_EXPRESSION__UNQ_EX:
        setUnqEx((UnqualifiedExecution)newValue);
        return;
      case ExpressionDslPackage.PRIMARY_EXPRESSION__SUPER_EX:
        setSuperEx((SuperExecution)newValue);
        return;
      case ExpressionDslPackage.PRIMARY_EXPRESSION__NEW_EX:
        setNewEx((ConstructorExecution)newValue);
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
      case ExpressionDslPackage.PRIMARY_EXPRESSION__OTHER_EX:
        setOtherEx((ExpressionOrQualifiedExecution)null);
        return;
      case ExpressionDslPackage.PRIMARY_EXPRESSION__UNQ_EX:
        setUnqEx((UnqualifiedExecution)null);
        return;
      case ExpressionDslPackage.PRIMARY_EXPRESSION__SUPER_EX:
        setSuperEx((SuperExecution)null);
        return;
      case ExpressionDslPackage.PRIMARY_EXPRESSION__NEW_EX:
        setNewEx((ConstructorExecution)null);
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
      case ExpressionDslPackage.PRIMARY_EXPRESSION__OTHER_EX:
        return otherEx != null;
      case ExpressionDslPackage.PRIMARY_EXPRESSION__UNQ_EX:
        return unqEx != null;
      case ExpressionDslPackage.PRIMARY_EXPRESSION__SUPER_EX:
        return superEx != null;
      case ExpressionDslPackage.PRIMARY_EXPRESSION__NEW_EX:
        return newEx != null;
    }
    return super.eIsSet(featureID);
  }

} //PrimaryExpressionImpl
