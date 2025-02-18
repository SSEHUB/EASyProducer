/**
 * generated by Xtext 2.35.0
 */
package de.uni_hildesheim.sse.ivml.impl;

import de.uni_hildesheim.sse.ivml.BasicType;
import de.uni_hildesheim.sse.ivml.DerivedType;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.QualifiedName;
import de.uni_hildesheim.sse.ivml.Type;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.TypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.TypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.TypeImpl#getDerived <em>Derived</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeImpl extends MinimalEObjectImpl.Container implements Type
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected BasicType type;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected QualifiedName id;

  /**
   * The cached value of the '{@link #getDerived() <em>Derived</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDerived()
   * @generated
   * @ordered
   */
  protected DerivedType derived;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeImpl()
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
    return IvmlPackage.Literals.TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BasicType getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(BasicType newType, NotificationChain msgs)
  {
    BasicType oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.TYPE__TYPE, oldType, newType);
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
  public void setType(BasicType newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.TYPE__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.TYPE__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.TYPE__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public QualifiedName getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetId(QualifiedName newId, NotificationChain msgs)
  {
    QualifiedName oldId = id;
    id = newId;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.TYPE__ID, oldId, newId);
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
  public void setId(QualifiedName newId)
  {
    if (newId != id)
    {
      NotificationChain msgs = null;
      if (id != null)
        msgs = ((InternalEObject)id).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.TYPE__ID, null, msgs);
      if (newId != null)
        msgs = ((InternalEObject)newId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.TYPE__ID, null, msgs);
      msgs = basicSetId(newId, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.TYPE__ID, newId, newId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DerivedType getDerived()
  {
    return derived;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDerived(DerivedType newDerived, NotificationChain msgs)
  {
    DerivedType oldDerived = derived;
    derived = newDerived;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.TYPE__DERIVED, oldDerived, newDerived);
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
  public void setDerived(DerivedType newDerived)
  {
    if (newDerived != derived)
    {
      NotificationChain msgs = null;
      if (derived != null)
        msgs = ((InternalEObject)derived).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.TYPE__DERIVED, null, msgs);
      if (newDerived != null)
        msgs = ((InternalEObject)newDerived).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.TYPE__DERIVED, null, msgs);
      msgs = basicSetDerived(newDerived, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.TYPE__DERIVED, newDerived, newDerived));
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
      case IvmlPackage.TYPE__TYPE:
        return basicSetType(null, msgs);
      case IvmlPackage.TYPE__ID:
        return basicSetId(null, msgs);
      case IvmlPackage.TYPE__DERIVED:
        return basicSetDerived(null, msgs);
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
      case IvmlPackage.TYPE__TYPE:
        return getType();
      case IvmlPackage.TYPE__ID:
        return getId();
      case IvmlPackage.TYPE__DERIVED:
        return getDerived();
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
      case IvmlPackage.TYPE__TYPE:
        setType((BasicType)newValue);
        return;
      case IvmlPackage.TYPE__ID:
        setId((QualifiedName)newValue);
        return;
      case IvmlPackage.TYPE__DERIVED:
        setDerived((DerivedType)newValue);
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
      case IvmlPackage.TYPE__TYPE:
        setType((BasicType)null);
        return;
      case IvmlPackage.TYPE__ID:
        setId((QualifiedName)null);
        return;
      case IvmlPackage.TYPE__DERIVED:
        setDerived((DerivedType)null);
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
      case IvmlPackage.TYPE__TYPE:
        return type != null;
      case IvmlPackage.TYPE__ID:
        return id != null;
      case IvmlPackage.TYPE__DERIVED:
        return derived != null;
    }
    return super.eIsSet(featureID);
  }

} //TypeImpl
