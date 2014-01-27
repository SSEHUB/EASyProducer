/**
 * <copyright>
 * </copyright>
 *

 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang.impl;

import de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.multiselect;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.userMultiselect;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>multiselect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.multiselectImpl#getGen <em>Gen</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.multiselectImpl#getUser <em>User</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class multiselectImpl extends MinimalEObjectImpl.Container implements multiselect
{
  /**
   * The cached value of the '{@link #getGen() <em>Gen</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGen()
   * @generated
   * @ordered
   */
  protected genericMultiselect gen;

  /**
   * The cached value of the '{@link #getUser() <em>User</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUser()
   * @generated
   * @ordered
   */
  protected userMultiselect user;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected multiselectImpl()
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
    return TemplateLangPackage.Literals.MULTISELECT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public genericMultiselect getGen()
  {
    return gen;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGen(genericMultiselect newGen, NotificationChain msgs)
  {
    genericMultiselect oldGen = gen;
    gen = newGen;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.MULTISELECT__GEN, oldGen, newGen);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGen(genericMultiselect newGen)
  {
    if (newGen != gen)
    {
      NotificationChain msgs = null;
      if (gen != null)
        msgs = ((InternalEObject)gen).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.MULTISELECT__GEN, null, msgs);
      if (newGen != null)
        msgs = ((InternalEObject)newGen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.MULTISELECT__GEN, null, msgs);
      msgs = basicSetGen(newGen, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.MULTISELECT__GEN, newGen, newGen));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public userMultiselect getUser()
  {
    return user;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUser(userMultiselect newUser, NotificationChain msgs)
  {
    userMultiselect oldUser = user;
    user = newUser;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.MULTISELECT__USER, oldUser, newUser);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUser(userMultiselect newUser)
  {
    if (newUser != user)
    {
      NotificationChain msgs = null;
      if (user != null)
        msgs = ((InternalEObject)user).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.MULTISELECT__USER, null, msgs);
      if (newUser != null)
        msgs = ((InternalEObject)newUser).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.MULTISELECT__USER, null, msgs);
      msgs = basicSetUser(newUser, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.MULTISELECT__USER, newUser, newUser));
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
      case TemplateLangPackage.MULTISELECT__GEN:
        return basicSetGen(null, msgs);
      case TemplateLangPackage.MULTISELECT__USER:
        return basicSetUser(null, msgs);
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
      case TemplateLangPackage.MULTISELECT__GEN:
        return getGen();
      case TemplateLangPackage.MULTISELECT__USER:
        return getUser();
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
      case TemplateLangPackage.MULTISELECT__GEN:
        setGen((genericMultiselect)newValue);
        return;
      case TemplateLangPackage.MULTISELECT__USER:
        setUser((userMultiselect)newValue);
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
      case TemplateLangPackage.MULTISELECT__GEN:
        setGen((genericMultiselect)null);
        return;
      case TemplateLangPackage.MULTISELECT__USER:
        setUser((userMultiselect)null);
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
      case TemplateLangPackage.MULTISELECT__GEN:
        return gen != null;
      case TemplateLangPackage.MULTISELECT__USER:
        return user != null;
    }
    return super.eIsSet(featureID);
  }

} //multiselectImpl
