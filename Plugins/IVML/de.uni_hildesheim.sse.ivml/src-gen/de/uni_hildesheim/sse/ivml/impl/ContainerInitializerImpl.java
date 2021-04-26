/**
 */
package de.uni_hildesheim.sse.ivml.impl;

import de.uni_hildesheim.sse.ivml.ContainerInitializer;
import de.uni_hildesheim.sse.ivml.ExpressionListOrRange;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.QualifiedName;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container Initializer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.ContainerInitializerImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.ContainerInitializerImpl#getInit <em>Init</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContainerInitializerImpl extends MinimalEObjectImpl.Container implements ContainerInitializer
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected QualifiedName type;

  /**
   * The cached value of the '{@link #getInit() <em>Init</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInit()
   * @generated
   * @ordered
   */
  protected ExpressionListOrRange init;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContainerInitializerImpl()
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
    return IvmlPackage.Literals.CONTAINER_INITIALIZER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public QualifiedName getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(QualifiedName newType, NotificationChain msgs)
  {
    QualifiedName oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.CONTAINER_INITIALIZER__TYPE, oldType, newType);
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
  public void setType(QualifiedName newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.CONTAINER_INITIALIZER__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.CONTAINER_INITIALIZER__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.CONTAINER_INITIALIZER__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExpressionListOrRange getInit()
  {
    return init;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInit(ExpressionListOrRange newInit, NotificationChain msgs)
  {
    ExpressionListOrRange oldInit = init;
    init = newInit;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.CONTAINER_INITIALIZER__INIT, oldInit, newInit);
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
  public void setInit(ExpressionListOrRange newInit)
  {
    if (newInit != init)
    {
      NotificationChain msgs = null;
      if (init != null)
        msgs = ((InternalEObject)init).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.CONTAINER_INITIALIZER__INIT, null, msgs);
      if (newInit != null)
        msgs = ((InternalEObject)newInit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.CONTAINER_INITIALIZER__INIT, null, msgs);
      msgs = basicSetInit(newInit, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.CONTAINER_INITIALIZER__INIT, newInit, newInit));
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
      case IvmlPackage.CONTAINER_INITIALIZER__TYPE:
        return basicSetType(null, msgs);
      case IvmlPackage.CONTAINER_INITIALIZER__INIT:
        return basicSetInit(null, msgs);
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
      case IvmlPackage.CONTAINER_INITIALIZER__TYPE:
        return getType();
      case IvmlPackage.CONTAINER_INITIALIZER__INIT:
        return getInit();
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
      case IvmlPackage.CONTAINER_INITIALIZER__TYPE:
        setType((QualifiedName)newValue);
        return;
      case IvmlPackage.CONTAINER_INITIALIZER__INIT:
        setInit((ExpressionListOrRange)newValue);
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
      case IvmlPackage.CONTAINER_INITIALIZER__TYPE:
        setType((QualifiedName)null);
        return;
      case IvmlPackage.CONTAINER_INITIALIZER__INIT:
        setInit((ExpressionListOrRange)null);
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
      case IvmlPackage.CONTAINER_INITIALIZER__TYPE:
        return type != null;
      case IvmlPackage.CONTAINER_INITIALIZER__INIT:
        return init != null;
    }
    return super.eIsSet(featureID);
  }

} //ContainerInitializerImpl
