/**
 */
package de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpressionPart;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relational Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.RelationalExpressionImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.RelationalExpressionImpl#getRight <em>Right</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.RelationalExpressionImpl#getRight2 <em>Right2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationalExpressionImpl extends MinimalEObjectImpl.Container implements RelationalExpression
{
  /**
   * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeft()
   * @generated
   * @ordered
   */
  protected AdditiveExpression left;

  /**
   * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRight()
   * @generated
   * @ordered
   */
  protected RelationalExpressionPart right;

  /**
   * The cached value of the '{@link #getRight2() <em>Right2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRight2()
   * @generated
   * @ordered
   */
  protected RelationalExpressionPart right2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RelationalExpressionImpl()
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
    return ExpressionDslPackage.Literals.RELATIONAL_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AdditiveExpression getLeft()
  {
    return left;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeft(AdditiveExpression newLeft, NotificationChain msgs)
  {
    AdditiveExpression oldLeft = left;
    left = newLeft;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.RELATIONAL_EXPRESSION__LEFT, oldLeft, newLeft);
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
  public void setLeft(AdditiveExpression newLeft)
  {
    if (newLeft != left)
    {
      NotificationChain msgs = null;
      if (left != null)
        msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.RELATIONAL_EXPRESSION__LEFT, null, msgs);
      if (newLeft != null)
        msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.RELATIONAL_EXPRESSION__LEFT, null, msgs);
      msgs = basicSetLeft(newLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.RELATIONAL_EXPRESSION__LEFT, newLeft, newLeft));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RelationalExpressionPart getRight()
  {
    return right;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRight(RelationalExpressionPart newRight, NotificationChain msgs)
  {
    RelationalExpressionPart oldRight = right;
    right = newRight;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT, oldRight, newRight);
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
  public void setRight(RelationalExpressionPart newRight)
  {
    if (newRight != right)
    {
      NotificationChain msgs = null;
      if (right != null)
        msgs = ((InternalEObject)right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT, null, msgs);
      if (newRight != null)
        msgs = ((InternalEObject)newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT, null, msgs);
      msgs = basicSetRight(newRight, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT, newRight, newRight));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RelationalExpressionPart getRight2()
  {
    return right2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRight2(RelationalExpressionPart newRight2, NotificationChain msgs)
  {
    RelationalExpressionPart oldRight2 = right2;
    right2 = newRight2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT2, oldRight2, newRight2);
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
  public void setRight2(RelationalExpressionPart newRight2)
  {
    if (newRight2 != right2)
    {
      NotificationChain msgs = null;
      if (right2 != null)
        msgs = ((InternalEObject)right2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT2, null, msgs);
      if (newRight2 != null)
        msgs = ((InternalEObject)newRight2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT2, null, msgs);
      msgs = basicSetRight2(newRight2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT2, newRight2, newRight2));
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
      case ExpressionDslPackage.RELATIONAL_EXPRESSION__LEFT:
        return basicSetLeft(null, msgs);
      case ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT:
        return basicSetRight(null, msgs);
      case ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT2:
        return basicSetRight2(null, msgs);
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
      case ExpressionDslPackage.RELATIONAL_EXPRESSION__LEFT:
        return getLeft();
      case ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT:
        return getRight();
      case ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT2:
        return getRight2();
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
      case ExpressionDslPackage.RELATIONAL_EXPRESSION__LEFT:
        setLeft((AdditiveExpression)newValue);
        return;
      case ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT:
        setRight((RelationalExpressionPart)newValue);
        return;
      case ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT2:
        setRight2((RelationalExpressionPart)newValue);
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
      case ExpressionDslPackage.RELATIONAL_EXPRESSION__LEFT:
        setLeft((AdditiveExpression)null);
        return;
      case ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT:
        setRight((RelationalExpressionPart)null);
        return;
      case ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT2:
        setRight2((RelationalExpressionPart)null);
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
      case ExpressionDslPackage.RELATIONAL_EXPRESSION__LEFT:
        return left != null;
      case ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT:
        return right != null;
      case ExpressionDslPackage.RELATIONAL_EXPRESSION__RIGHT2:
        return right2 != null;
    }
    return super.eIsSet(featureID);
  }

} //RelationalExpressionImpl
