/**
 */
package de.uni_hildesheim.sse.vil.rt.rtVil.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;

import de.uni_hildesheim.sse.vil.rt.rtVil.GlobalVariableDeclaration;
import de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.GlobalVariableDeclarationImpl#getPersistent <em>Persistent</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.GlobalVariableDeclarationImpl#getVarDecl <em>Var Decl</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GlobalVariableDeclarationImpl extends MinimalEObjectImpl.Container implements GlobalVariableDeclaration
{
  /**
   * The default value of the '{@link #getPersistent() <em>Persistent</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPersistent()
   * @generated
   * @ordered
   */
  protected static final String PERSISTENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPersistent() <em>Persistent</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPersistent()
   * @generated
   * @ordered
   */
  protected String persistent = PERSISTENT_EDEFAULT;

  /**
   * The cached value of the '{@link #getVarDecl() <em>Var Decl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVarDecl()
   * @generated
   * @ordered
   */
  protected VariableDeclaration varDecl;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GlobalVariableDeclarationImpl()
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
    return RtVilPackage.Literals.GLOBAL_VARIABLE_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPersistent()
  {
    return persistent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPersistent(String newPersistent)
  {
    String oldPersistent = persistent;
    persistent = newPersistent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RtVilPackage.GLOBAL_VARIABLE_DECLARATION__PERSISTENT, oldPersistent, persistent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableDeclaration getVarDecl()
  {
    return varDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVarDecl(VariableDeclaration newVarDecl, NotificationChain msgs)
  {
    VariableDeclaration oldVarDecl = varDecl;
    varDecl = newVarDecl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RtVilPackage.GLOBAL_VARIABLE_DECLARATION__VAR_DECL, oldVarDecl, newVarDecl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVarDecl(VariableDeclaration newVarDecl)
  {
    if (newVarDecl != varDecl)
    {
      NotificationChain msgs = null;
      if (varDecl != null)
        msgs = ((InternalEObject)varDecl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RtVilPackage.GLOBAL_VARIABLE_DECLARATION__VAR_DECL, null, msgs);
      if (newVarDecl != null)
        msgs = ((InternalEObject)newVarDecl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RtVilPackage.GLOBAL_VARIABLE_DECLARATION__VAR_DECL, null, msgs);
      msgs = basicSetVarDecl(newVarDecl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RtVilPackage.GLOBAL_VARIABLE_DECLARATION__VAR_DECL, newVarDecl, newVarDecl));
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
      case RtVilPackage.GLOBAL_VARIABLE_DECLARATION__VAR_DECL:
        return basicSetVarDecl(null, msgs);
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
      case RtVilPackage.GLOBAL_VARIABLE_DECLARATION__PERSISTENT:
        return getPersistent();
      case RtVilPackage.GLOBAL_VARIABLE_DECLARATION__VAR_DECL:
        return getVarDecl();
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
      case RtVilPackage.GLOBAL_VARIABLE_DECLARATION__PERSISTENT:
        setPersistent((String)newValue);
        return;
      case RtVilPackage.GLOBAL_VARIABLE_DECLARATION__VAR_DECL:
        setVarDecl((VariableDeclaration)newValue);
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
      case RtVilPackage.GLOBAL_VARIABLE_DECLARATION__PERSISTENT:
        setPersistent(PERSISTENT_EDEFAULT);
        return;
      case RtVilPackage.GLOBAL_VARIABLE_DECLARATION__VAR_DECL:
        setVarDecl((VariableDeclaration)null);
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
      case RtVilPackage.GLOBAL_VARIABLE_DECLARATION__PERSISTENT:
        return PERSISTENT_EDEFAULT == null ? persistent != null : !PERSISTENT_EDEFAULT.equals(persistent);
      case RtVilPackage.GLOBAL_VARIABLE_DECLARATION__VAR_DECL:
        return varDecl != null;
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
    result.append(" (persistent: ");
    result.append(persistent);
    result.append(')');
    return result.toString();
  }

} //GlobalVariableDeclarationImpl
