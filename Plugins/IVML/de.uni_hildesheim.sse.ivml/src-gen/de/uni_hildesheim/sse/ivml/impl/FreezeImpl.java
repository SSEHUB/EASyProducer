/**
 */
package de.uni_hildesheim.sse.ivml.impl;

import de.uni_hildesheim.sse.ivml.Freeze;
import de.uni_hildesheim.sse.ivml.FreezeStatement;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.LogicalExpression;

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
 * An implementation of the model object '<em><b>Freeze</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.FreezeImpl#getNames <em>Names</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.FreezeImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.FreezeImpl#getEx <em>Ex</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FreezeImpl extends MinimalEObjectImpl.Container implements Freeze
{
  /**
   * The cached value of the '{@link #getNames() <em>Names</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNames()
   * @generated
   * @ordered
   */
  protected EList<FreezeStatement> names;

  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getEx() <em>Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEx()
   * @generated
   * @ordered
   */
  protected LogicalExpression ex;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FreezeImpl()
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
    return IvmlPackage.Literals.FREEZE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<FreezeStatement> getNames()
  {
    if (names == null)
    {
      names = new EObjectContainmentEList<FreezeStatement>(FreezeStatement.class, this, IvmlPackage.FREEZE__NAMES);
    }
    return names;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.FREEZE__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LogicalExpression getEx()
  {
    return ex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEx(LogicalExpression newEx, NotificationChain msgs)
  {
    LogicalExpression oldEx = ex;
    ex = newEx;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.FREEZE__EX, oldEx, newEx);
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
  public void setEx(LogicalExpression newEx)
  {
    if (newEx != ex)
    {
      NotificationChain msgs = null;
      if (ex != null)
        msgs = ((InternalEObject)ex).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.FREEZE__EX, null, msgs);
      if (newEx != null)
        msgs = ((InternalEObject)newEx).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.FREEZE__EX, null, msgs);
      msgs = basicSetEx(newEx, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.FREEZE__EX, newEx, newEx));
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
      case IvmlPackage.FREEZE__NAMES:
        return ((InternalEList<?>)getNames()).basicRemove(otherEnd, msgs);
      case IvmlPackage.FREEZE__EX:
        return basicSetEx(null, msgs);
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
      case IvmlPackage.FREEZE__NAMES:
        return getNames();
      case IvmlPackage.FREEZE__ID:
        return getId();
      case IvmlPackage.FREEZE__EX:
        return getEx();
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
      case IvmlPackage.FREEZE__NAMES:
        getNames().clear();
        getNames().addAll((Collection<? extends FreezeStatement>)newValue);
        return;
      case IvmlPackage.FREEZE__ID:
        setId((String)newValue);
        return;
      case IvmlPackage.FREEZE__EX:
        setEx((LogicalExpression)newValue);
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
      case IvmlPackage.FREEZE__NAMES:
        getNames().clear();
        return;
      case IvmlPackage.FREEZE__ID:
        setId(ID_EDEFAULT);
        return;
      case IvmlPackage.FREEZE__EX:
        setEx((LogicalExpression)null);
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
      case IvmlPackage.FREEZE__NAMES:
        return names != null && !names.isEmpty();
      case IvmlPackage.FREEZE__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case IvmlPackage.FREEZE__EX:
        return ex != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (id: ");
    result.append(id);
    result.append(')');
    return result.toString();
  }

} //FreezeImpl
