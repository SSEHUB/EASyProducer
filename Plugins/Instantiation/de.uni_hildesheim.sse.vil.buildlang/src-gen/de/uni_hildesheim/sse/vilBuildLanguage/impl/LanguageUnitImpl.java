/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList;

import de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit;
import de.uni_hildesheim.sse.vilBuildLanguage.LoadProperties;
import de.uni_hildesheim.sse.vilBuildLanguage.ScriptContents;
import de.uni_hildesheim.sse.vilBuildLanguage.ScriptParentDecl;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Language Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.LanguageUnitImpl#getParam <em>Param</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.LanguageUnitImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.LanguageUnitImpl#getLoadProperties <em>Load Properties</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.LanguageUnitImpl#getContents <em>Contents</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LanguageUnitImpl extends de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.LanguageUnitImpl implements LanguageUnit
{
  /**
   * The cached value of the '{@link #getParam() <em>Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParam()
   * @generated
   * @ordered
   */
  protected ParameterList param;

  /**
   * The cached value of the '{@link #getParent() <em>Parent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParent()
   * @generated
   * @ordered
   */
  protected ScriptParentDecl parent;

  /**
   * The cached value of the '{@link #getLoadProperties() <em>Load Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoadProperties()
   * @generated
   * @ordered
   */
  protected EList<LoadProperties> loadProperties;

  /**
   * The cached value of the '{@link #getContents() <em>Contents</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContents()
   * @generated
   * @ordered
   */
  protected ScriptContents contents;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LanguageUnitImpl()
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
    return VilBuildLanguagePackage.Literals.LANGUAGE_UNIT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterList getParam()
  {
    return param;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParam(ParameterList newParam, NotificationChain msgs)
  {
    ParameterList oldParam = param;
    param = newParam;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.LANGUAGE_UNIT__PARAM, oldParam, newParam);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParam(ParameterList newParam)
  {
    if (newParam != param)
    {
      NotificationChain msgs = null;
      if (param != null)
        msgs = ((InternalEObject)param).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.LANGUAGE_UNIT__PARAM, null, msgs);
      if (newParam != null)
        msgs = ((InternalEObject)newParam).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.LANGUAGE_UNIT__PARAM, null, msgs);
      msgs = basicSetParam(newParam, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.LANGUAGE_UNIT__PARAM, newParam, newParam));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScriptParentDecl getParent()
  {
    return parent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParent(ScriptParentDecl newParent, NotificationChain msgs)
  {
    ScriptParentDecl oldParent = parent;
    parent = newParent;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.LANGUAGE_UNIT__PARENT, oldParent, newParent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParent(ScriptParentDecl newParent)
  {
    if (newParent != parent)
    {
      NotificationChain msgs = null;
      if (parent != null)
        msgs = ((InternalEObject)parent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.LANGUAGE_UNIT__PARENT, null, msgs);
      if (newParent != null)
        msgs = ((InternalEObject)newParent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.LANGUAGE_UNIT__PARENT, null, msgs);
      msgs = basicSetParent(newParent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.LANGUAGE_UNIT__PARENT, newParent, newParent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LoadProperties> getLoadProperties()
  {
    if (loadProperties == null)
    {
      loadProperties = new EObjectContainmentEList<LoadProperties>(LoadProperties.class, this, VilBuildLanguagePackage.LANGUAGE_UNIT__LOAD_PROPERTIES);
    }
    return loadProperties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScriptContents getContents()
  {
    return contents;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContents(ScriptContents newContents, NotificationChain msgs)
  {
    ScriptContents oldContents = contents;
    contents = newContents;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.LANGUAGE_UNIT__CONTENTS, oldContents, newContents);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContents(ScriptContents newContents)
  {
    if (newContents != contents)
    {
      NotificationChain msgs = null;
      if (contents != null)
        msgs = ((InternalEObject)contents).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.LANGUAGE_UNIT__CONTENTS, null, msgs);
      if (newContents != null)
        msgs = ((InternalEObject)newContents).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.LANGUAGE_UNIT__CONTENTS, null, msgs);
      msgs = basicSetContents(newContents, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.LANGUAGE_UNIT__CONTENTS, newContents, newContents));
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
      case VilBuildLanguagePackage.LANGUAGE_UNIT__PARAM:
        return basicSetParam(null, msgs);
      case VilBuildLanguagePackage.LANGUAGE_UNIT__PARENT:
        return basicSetParent(null, msgs);
      case VilBuildLanguagePackage.LANGUAGE_UNIT__LOAD_PROPERTIES:
        return ((InternalEList<?>)getLoadProperties()).basicRemove(otherEnd, msgs);
      case VilBuildLanguagePackage.LANGUAGE_UNIT__CONTENTS:
        return basicSetContents(null, msgs);
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
      case VilBuildLanguagePackage.LANGUAGE_UNIT__PARAM:
        return getParam();
      case VilBuildLanguagePackage.LANGUAGE_UNIT__PARENT:
        return getParent();
      case VilBuildLanguagePackage.LANGUAGE_UNIT__LOAD_PROPERTIES:
        return getLoadProperties();
      case VilBuildLanguagePackage.LANGUAGE_UNIT__CONTENTS:
        return getContents();
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
      case VilBuildLanguagePackage.LANGUAGE_UNIT__PARAM:
        setParam((ParameterList)newValue);
        return;
      case VilBuildLanguagePackage.LANGUAGE_UNIT__PARENT:
        setParent((ScriptParentDecl)newValue);
        return;
      case VilBuildLanguagePackage.LANGUAGE_UNIT__LOAD_PROPERTIES:
        getLoadProperties().clear();
        getLoadProperties().addAll((Collection<? extends LoadProperties>)newValue);
        return;
      case VilBuildLanguagePackage.LANGUAGE_UNIT__CONTENTS:
        setContents((ScriptContents)newValue);
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
      case VilBuildLanguagePackage.LANGUAGE_UNIT__PARAM:
        setParam((ParameterList)null);
        return;
      case VilBuildLanguagePackage.LANGUAGE_UNIT__PARENT:
        setParent((ScriptParentDecl)null);
        return;
      case VilBuildLanguagePackage.LANGUAGE_UNIT__LOAD_PROPERTIES:
        getLoadProperties().clear();
        return;
      case VilBuildLanguagePackage.LANGUAGE_UNIT__CONTENTS:
        setContents((ScriptContents)null);
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
      case VilBuildLanguagePackage.LANGUAGE_UNIT__PARAM:
        return param != null;
      case VilBuildLanguagePackage.LANGUAGE_UNIT__PARENT:
        return parent != null;
      case VilBuildLanguagePackage.LANGUAGE_UNIT__LOAD_PROPERTIES:
        return loadProperties != null && !loadProperties.isEmpty();
      case VilBuildLanguagePackage.LANGUAGE_UNIT__CONTENTS:
        return contents != null;
    }
    return super.eIsSet(featureID);
  }

} //LanguageUnitImpl
