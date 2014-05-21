/**
 */
package de.uni_hildesheim.sse.ivml.impl;

import de.uni_hildesheim.sse.ivml.Freeze;
import de.uni_hildesheim.sse.ivml.FreezeButList;
import de.uni_hildesheim.sse.ivml.FreezeStatement;
import de.uni_hildesheim.sse.ivml.IvmlPackage;

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
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.FreezeImpl#getNames <em>Names</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.FreezeImpl#getBut <em>But</em>}</li>
 * </ul>
 * </p>
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
   * The cached value of the '{@link #getBut() <em>But</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBut()
   * @generated
   * @ordered
   */
  protected FreezeButList but;

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
  public FreezeButList getBut()
  {
    return but;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBut(FreezeButList newBut, NotificationChain msgs)
  {
    FreezeButList oldBut = but;
    but = newBut;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.FREEZE__BUT, oldBut, newBut);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBut(FreezeButList newBut)
  {
    if (newBut != but)
    {
      NotificationChain msgs = null;
      if (but != null)
        msgs = ((InternalEObject)but).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.FREEZE__BUT, null, msgs);
      if (newBut != null)
        msgs = ((InternalEObject)newBut).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.FREEZE__BUT, null, msgs);
      msgs = basicSetBut(newBut, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.FREEZE__BUT, newBut, newBut));
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
      case IvmlPackage.FREEZE__BUT:
        return basicSetBut(null, msgs);
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
      case IvmlPackage.FREEZE__BUT:
        return getBut();
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
      case IvmlPackage.FREEZE__BUT:
        setBut((FreezeButList)newValue);
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
      case IvmlPackage.FREEZE__BUT:
        setBut((FreezeButList)null);
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
      case IvmlPackage.FREEZE__BUT:
        return but != null;
    }
    return super.eIsSet(featureID);
  }

} //FreezeImpl
