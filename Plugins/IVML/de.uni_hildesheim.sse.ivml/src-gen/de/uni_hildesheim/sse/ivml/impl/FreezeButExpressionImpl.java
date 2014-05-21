/**
 */
package de.uni_hildesheim.sse.ivml.impl;

import de.uni_hildesheim.sse.ivml.AccessName;
import de.uni_hildesheim.sse.ivml.FreezeButExpression;
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
 * An implementation of the model object '<em><b>Freeze But Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.FreezeButExpressionImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.FreezeButExpressionImpl#getAccess <em>Access</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.FreezeButExpressionImpl#getWildcard <em>Wildcard</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FreezeButExpressionImpl extends MinimalEObjectImpl.Container implements FreezeButExpression
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected QualifiedName name;

  /**
   * The cached value of the '{@link #getAccess() <em>Access</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccess()
   * @generated
   * @ordered
   */
  protected AccessName access;

  /**
   * The default value of the '{@link #getWildcard() <em>Wildcard</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWildcard()
   * @generated
   * @ordered
   */
  protected static final String WILDCARD_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getWildcard() <em>Wildcard</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWildcard()
   * @generated
   * @ordered
   */
  protected String wildcard = WILDCARD_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FreezeButExpressionImpl()
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
    return IvmlPackage.Literals.FREEZE_BUT_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedName getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(QualifiedName newName, NotificationChain msgs)
  {
    QualifiedName oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.FREEZE_BUT_EXPRESSION__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(QualifiedName newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.FREEZE_BUT_EXPRESSION__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.FREEZE_BUT_EXPRESSION__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.FREEZE_BUT_EXPRESSION__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AccessName getAccess()
  {
    return access;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAccess(AccessName newAccess, NotificationChain msgs)
  {
    AccessName oldAccess = access;
    access = newAccess;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.FREEZE_BUT_EXPRESSION__ACCESS, oldAccess, newAccess);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAccess(AccessName newAccess)
  {
    if (newAccess != access)
    {
      NotificationChain msgs = null;
      if (access != null)
        msgs = ((InternalEObject)access).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.FREEZE_BUT_EXPRESSION__ACCESS, null, msgs);
      if (newAccess != null)
        msgs = ((InternalEObject)newAccess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.FREEZE_BUT_EXPRESSION__ACCESS, null, msgs);
      msgs = basicSetAccess(newAccess, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.FREEZE_BUT_EXPRESSION__ACCESS, newAccess, newAccess));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getWildcard()
  {
    return wildcard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWildcard(String newWildcard)
  {
    String oldWildcard = wildcard;
    wildcard = newWildcard;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.FREEZE_BUT_EXPRESSION__WILDCARD, oldWildcard, wildcard));
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
      case IvmlPackage.FREEZE_BUT_EXPRESSION__NAME:
        return basicSetName(null, msgs);
      case IvmlPackage.FREEZE_BUT_EXPRESSION__ACCESS:
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
      case IvmlPackage.FREEZE_BUT_EXPRESSION__NAME:
        return getName();
      case IvmlPackage.FREEZE_BUT_EXPRESSION__ACCESS:
        return getAccess();
      case IvmlPackage.FREEZE_BUT_EXPRESSION__WILDCARD:
        return getWildcard();
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
      case IvmlPackage.FREEZE_BUT_EXPRESSION__NAME:
        setName((QualifiedName)newValue);
        return;
      case IvmlPackage.FREEZE_BUT_EXPRESSION__ACCESS:
        setAccess((AccessName)newValue);
        return;
      case IvmlPackage.FREEZE_BUT_EXPRESSION__WILDCARD:
        setWildcard((String)newValue);
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
      case IvmlPackage.FREEZE_BUT_EXPRESSION__NAME:
        setName((QualifiedName)null);
        return;
      case IvmlPackage.FREEZE_BUT_EXPRESSION__ACCESS:
        setAccess((AccessName)null);
        return;
      case IvmlPackage.FREEZE_BUT_EXPRESSION__WILDCARD:
        setWildcard(WILDCARD_EDEFAULT);
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
      case IvmlPackage.FREEZE_BUT_EXPRESSION__NAME:
        return name != null;
      case IvmlPackage.FREEZE_BUT_EXPRESSION__ACCESS:
        return access != null;
      case IvmlPackage.FREEZE_BUT_EXPRESSION__WILDCARD:
        return WILDCARD_EDEFAULT == null ? wildcard != null : !WILDCARD_EDEFAULT.equals(wildcard);
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
    result.append(" (wildcard: ");
    result.append(wildcard);
    result.append(')');
    return result.toString();
  }

} //FreezeButExpressionImpl
