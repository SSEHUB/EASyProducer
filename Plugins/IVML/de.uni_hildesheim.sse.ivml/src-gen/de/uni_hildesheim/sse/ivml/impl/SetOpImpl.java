/**
 */
package de.uni_hildesheim.sse.ivml.impl;

import de.uni_hildesheim.sse.ivml.ActualParameterList;
import de.uni_hildesheim.sse.ivml.Declarator;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.SetOp;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Op</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.SetOpImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.SetOpImpl#getDecl <em>Decl</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.SetOpImpl#getDeclEx <em>Decl Ex</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SetOpImpl extends MinimalEObjectImpl.Container implements SetOp
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
   * The cached value of the '{@link #getDecl() <em>Decl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecl()
   * @generated
   * @ordered
   */
  protected Declarator decl;

  /**
   * The cached value of the '{@link #getDeclEx() <em>Decl Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeclEx()
   * @generated
   * @ordered
   */
  protected ActualParameterList declEx;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SetOpImpl()
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
    return IvmlPackage.Literals.SET_OP;
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
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.SET_OP__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Declarator getDecl()
  {
    return decl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDecl(Declarator newDecl, NotificationChain msgs)
  {
    Declarator oldDecl = decl;
    decl = newDecl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.SET_OP__DECL, oldDecl, newDecl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDecl(Declarator newDecl)
  {
    if (newDecl != decl)
    {
      NotificationChain msgs = null;
      if (decl != null)
        msgs = ((InternalEObject)decl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.SET_OP__DECL, null, msgs);
      if (newDecl != null)
        msgs = ((InternalEObject)newDecl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.SET_OP__DECL, null, msgs);
      msgs = basicSetDecl(newDecl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.SET_OP__DECL, newDecl, newDecl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActualParameterList getDeclEx()
  {
    return declEx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDeclEx(ActualParameterList newDeclEx, NotificationChain msgs)
  {
    ActualParameterList oldDeclEx = declEx;
    declEx = newDeclEx;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.SET_OP__DECL_EX, oldDeclEx, newDeclEx);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeclEx(ActualParameterList newDeclEx)
  {
    if (newDeclEx != declEx)
    {
      NotificationChain msgs = null;
      if (declEx != null)
        msgs = ((InternalEObject)declEx).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.SET_OP__DECL_EX, null, msgs);
      if (newDeclEx != null)
        msgs = ((InternalEObject)newDeclEx).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.SET_OP__DECL_EX, null, msgs);
      msgs = basicSetDeclEx(newDeclEx, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.SET_OP__DECL_EX, newDeclEx, newDeclEx));
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
      case IvmlPackage.SET_OP__DECL:
        return basicSetDecl(null, msgs);
      case IvmlPackage.SET_OP__DECL_EX:
        return basicSetDeclEx(null, msgs);
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
      case IvmlPackage.SET_OP__NAME:
        return getName();
      case IvmlPackage.SET_OP__DECL:
        return getDecl();
      case IvmlPackage.SET_OP__DECL_EX:
        return getDeclEx();
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
      case IvmlPackage.SET_OP__NAME:
        setName((String)newValue);
        return;
      case IvmlPackage.SET_OP__DECL:
        setDecl((Declarator)newValue);
        return;
      case IvmlPackage.SET_OP__DECL_EX:
        setDeclEx((ActualParameterList)newValue);
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
      case IvmlPackage.SET_OP__NAME:
        setName(NAME_EDEFAULT);
        return;
      case IvmlPackage.SET_OP__DECL:
        setDecl((Declarator)null);
        return;
      case IvmlPackage.SET_OP__DECL_EX:
        setDeclEx((ActualParameterList)null);
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
      case IvmlPackage.SET_OP__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case IvmlPackage.SET_OP__DECL:
        return decl != null;
      case IvmlPackage.SET_OP__DECL_EX:
        return declEx != null;
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

} //SetOpImpl
