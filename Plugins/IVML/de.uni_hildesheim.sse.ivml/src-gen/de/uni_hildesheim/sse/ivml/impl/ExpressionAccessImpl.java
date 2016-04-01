/**
 */
package de.uni_hildesheim.sse.ivml.impl;

import de.uni_hildesheim.sse.ivml.Call;
import de.uni_hildesheim.sse.ivml.ExpressionAccess;
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
 * An implementation of the model object '<em><b>Expression Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.ExpressionAccessImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.ExpressionAccessImpl#getCalls <em>Calls</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.ExpressionAccessImpl#getAccess <em>Access</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpressionAccessImpl extends MinimalEObjectImpl.Container implements ExpressionAccess
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getCalls() <em>Calls</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCalls()
   * @generated
   * @ordered
   */
  protected EList<Call> calls;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpressionAccessImpl()
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
    return IvmlPackage.Literals.EXPRESSION_ACCESS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION_ACCESS__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Call> getCalls()
  {
    if (calls == null)
    {
      calls = new EObjectContainmentEList<Call>(Call.class, this, IvmlPackage.EXPRESSION_ACCESS__CALLS);
    }
    return calls;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION_ACCESS__ACCESS, oldAccess, newAccess);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAccess(ExpressionAccess newAccess)
  {
    if (newAccess != access)
    {
      NotificationChain msgs = null;
      if (access != null)
        msgs = ((InternalEObject)access).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EXPRESSION_ACCESS__ACCESS, null, msgs);
      if (newAccess != null)
        msgs = ((InternalEObject)newAccess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EXPRESSION_ACCESS__ACCESS, null, msgs);
      msgs = basicSetAccess(newAccess, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION_ACCESS__ACCESS, newAccess, newAccess));
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
      case IvmlPackage.EXPRESSION_ACCESS__CALLS:
        return ((InternalEList<?>)getCalls()).basicRemove(otherEnd, msgs);
      case IvmlPackage.EXPRESSION_ACCESS__ACCESS:
        return basicSetAccess(null, msgs);
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
      case IvmlPackage.EXPRESSION_ACCESS__NAME:
        return getName();
      case IvmlPackage.EXPRESSION_ACCESS__CALLS:
        return getCalls();
      case IvmlPackage.EXPRESSION_ACCESS__ACCESS:
        return getAccess();
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
      case IvmlPackage.EXPRESSION_ACCESS__NAME:
        setName((String)newValue);
        return;
      case IvmlPackage.EXPRESSION_ACCESS__CALLS:
        getCalls().clear();
        getCalls().addAll((Collection<? extends Call>)newValue);
        return;
      case IvmlPackage.EXPRESSION_ACCESS__ACCESS:
        setAccess((ExpressionAccess)newValue);
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
      case IvmlPackage.EXPRESSION_ACCESS__NAME:
        setName(NAME_EDEFAULT);
        return;
      case IvmlPackage.EXPRESSION_ACCESS__CALLS:
        getCalls().clear();
        return;
      case IvmlPackage.EXPRESSION_ACCESS__ACCESS:
        setAccess((ExpressionAccess)null);
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
      case IvmlPackage.EXPRESSION_ACCESS__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case IvmlPackage.EXPRESSION_ACCESS__CALLS:
        return calls != null && !calls.isEmpty();
      case IvmlPackage.EXPRESSION_ACCESS__ACCESS:
        return access != null;
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

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ExpressionAccessImpl
