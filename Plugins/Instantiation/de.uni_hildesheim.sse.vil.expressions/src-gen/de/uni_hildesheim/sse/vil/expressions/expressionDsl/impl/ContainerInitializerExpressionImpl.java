/**
 */
package de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializer;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializerExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container Initializer Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ContainerInitializerExpressionImpl#getLogical <em>Logical</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ContainerInitializerExpressionImpl#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContainerInitializerExpressionImpl extends MinimalEObjectImpl.Container implements ContainerInitializerExpression
{
  /**
   * The cached value of the '{@link #getLogical() <em>Logical</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLogical()
   * @generated
   * @ordered
   */
  protected LogicalExpression logical;

  /**
   * The cached value of the '{@link #getContainer() <em>Container</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContainer()
   * @generated
   * @ordered
   */
  protected ContainerInitializer container;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContainerInitializerExpressionImpl()
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
    return ExpressionDslPackage.Literals.CONTAINER_INITIALIZER_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalExpression getLogical()
  {
    return logical;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLogical(LogicalExpression newLogical, NotificationChain msgs)
  {
    LogicalExpression oldLogical = logical;
    logical = newLogical;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__LOGICAL, oldLogical, newLogical);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLogical(LogicalExpression newLogical)
  {
    if (newLogical != logical)
    {
      NotificationChain msgs = null;
      if (logical != null)
        msgs = ((InternalEObject)logical).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__LOGICAL, null, msgs);
      if (newLogical != null)
        msgs = ((InternalEObject)newLogical).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__LOGICAL, null, msgs);
      msgs = basicSetLogical(newLogical, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__LOGICAL, newLogical, newLogical));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContainerInitializer getContainer()
  {
    return container;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContainer(ContainerInitializer newContainer, NotificationChain msgs)
  {
    ContainerInitializer oldContainer = container;
    container = newContainer;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__CONTAINER, oldContainer, newContainer);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContainer(ContainerInitializer newContainer)
  {
    if (newContainer != container)
    {
      NotificationChain msgs = null;
      if (container != null)
        msgs = ((InternalEObject)container).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__CONTAINER, null, msgs);
      if (newContainer != null)
        msgs = ((InternalEObject)newContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__CONTAINER, null, msgs);
      msgs = basicSetContainer(newContainer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__CONTAINER, newContainer, newContainer));
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
      case ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__LOGICAL:
        return basicSetLogical(null, msgs);
      case ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__CONTAINER:
        return basicSetContainer(null, msgs);
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
      case ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__LOGICAL:
        return getLogical();
      case ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__CONTAINER:
        return getContainer();
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
      case ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__LOGICAL:
        setLogical((LogicalExpression)newValue);
        return;
      case ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__CONTAINER:
        setContainer((ContainerInitializer)newValue);
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
      case ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__LOGICAL:
        setLogical((LogicalExpression)null);
        return;
      case ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__CONTAINER:
        setContainer((ContainerInitializer)null);
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
      case ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__LOGICAL:
        return logical != null;
      case ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION__CONTAINER:
        return container != null;
    }
    return super.eIsSet(featureID);
  }

} //ContainerInitializerExpressionImpl
