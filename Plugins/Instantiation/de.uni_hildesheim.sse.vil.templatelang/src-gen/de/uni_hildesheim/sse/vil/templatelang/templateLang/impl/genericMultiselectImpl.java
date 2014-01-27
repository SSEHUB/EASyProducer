/**
 * <copyright>
 * </copyright>
 *

 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang.impl;

import de.uni_hildesheim.sse.vil.templatelang.templateLang.StmtBlock;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.multiSelectPart;

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
 * An implementation of the model object '<em><b>generic Multiselect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.genericMultiselectImpl#getPreamble <em>Preamble</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.genericMultiselectImpl#getSelector <em>Selector</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.genericMultiselectImpl#getPart <em>Part</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.genericMultiselectImpl#getTrailer <em>Trailer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class genericMultiselectImpl extends MinimalEObjectImpl.Container implements genericMultiselect
{
  /**
   * The cached value of the '{@link #getPreamble() <em>Preamble</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreamble()
   * @generated
   * @ordered
   */
  protected StmtBlock preamble;

  /**
   * The cached value of the '{@link #getSelector() <em>Selector</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelector()
   * @generated
   * @ordered
   */
  protected StmtBlock selector;

  /**
   * The cached value of the '{@link #getPart() <em>Part</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPart()
   * @generated
   * @ordered
   */
  protected EList<multiSelectPart> part;

  /**
   * The cached value of the '{@link #getTrailer() <em>Trailer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrailer()
   * @generated
   * @ordered
   */
  protected StmtBlock trailer;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected genericMultiselectImpl()
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
    return TemplateLangPackage.Literals.GENERIC_MULTISELECT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StmtBlock getPreamble()
  {
    return preamble;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPreamble(StmtBlock newPreamble, NotificationChain msgs)
  {
    StmtBlock oldPreamble = preamble;
    preamble = newPreamble;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.GENERIC_MULTISELECT__PREAMBLE, oldPreamble, newPreamble);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPreamble(StmtBlock newPreamble)
  {
    if (newPreamble != preamble)
    {
      NotificationChain msgs = null;
      if (preamble != null)
        msgs = ((InternalEObject)preamble).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.GENERIC_MULTISELECT__PREAMBLE, null, msgs);
      if (newPreamble != null)
        msgs = ((InternalEObject)newPreamble).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.GENERIC_MULTISELECT__PREAMBLE, null, msgs);
      msgs = basicSetPreamble(newPreamble, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.GENERIC_MULTISELECT__PREAMBLE, newPreamble, newPreamble));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StmtBlock getSelector()
  {
    return selector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSelector(StmtBlock newSelector, NotificationChain msgs)
  {
    StmtBlock oldSelector = selector;
    selector = newSelector;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.GENERIC_MULTISELECT__SELECTOR, oldSelector, newSelector);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSelector(StmtBlock newSelector)
  {
    if (newSelector != selector)
    {
      NotificationChain msgs = null;
      if (selector != null)
        msgs = ((InternalEObject)selector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.GENERIC_MULTISELECT__SELECTOR, null, msgs);
      if (newSelector != null)
        msgs = ((InternalEObject)newSelector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.GENERIC_MULTISELECT__SELECTOR, null, msgs);
      msgs = basicSetSelector(newSelector, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.GENERIC_MULTISELECT__SELECTOR, newSelector, newSelector));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<multiSelectPart> getPart()
  {
    if (part == null)
    {
      part = new EObjectContainmentEList<multiSelectPart>(multiSelectPart.class, this, TemplateLangPackage.GENERIC_MULTISELECT__PART);
    }
    return part;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StmtBlock getTrailer()
  {
    return trailer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTrailer(StmtBlock newTrailer, NotificationChain msgs)
  {
    StmtBlock oldTrailer = trailer;
    trailer = newTrailer;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.GENERIC_MULTISELECT__TRAILER, oldTrailer, newTrailer);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrailer(StmtBlock newTrailer)
  {
    if (newTrailer != trailer)
    {
      NotificationChain msgs = null;
      if (trailer != null)
        msgs = ((InternalEObject)trailer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.GENERIC_MULTISELECT__TRAILER, null, msgs);
      if (newTrailer != null)
        msgs = ((InternalEObject)newTrailer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.GENERIC_MULTISELECT__TRAILER, null, msgs);
      msgs = basicSetTrailer(newTrailer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.GENERIC_MULTISELECT__TRAILER, newTrailer, newTrailer));
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
      case TemplateLangPackage.GENERIC_MULTISELECT__PREAMBLE:
        return basicSetPreamble(null, msgs);
      case TemplateLangPackage.GENERIC_MULTISELECT__SELECTOR:
        return basicSetSelector(null, msgs);
      case TemplateLangPackage.GENERIC_MULTISELECT__PART:
        return ((InternalEList<?>)getPart()).basicRemove(otherEnd, msgs);
      case TemplateLangPackage.GENERIC_MULTISELECT__TRAILER:
        return basicSetTrailer(null, msgs);
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
      case TemplateLangPackage.GENERIC_MULTISELECT__PREAMBLE:
        return getPreamble();
      case TemplateLangPackage.GENERIC_MULTISELECT__SELECTOR:
        return getSelector();
      case TemplateLangPackage.GENERIC_MULTISELECT__PART:
        return getPart();
      case TemplateLangPackage.GENERIC_MULTISELECT__TRAILER:
        return getTrailer();
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
      case TemplateLangPackage.GENERIC_MULTISELECT__PREAMBLE:
        setPreamble((StmtBlock)newValue);
        return;
      case TemplateLangPackage.GENERIC_MULTISELECT__SELECTOR:
        setSelector((StmtBlock)newValue);
        return;
      case TemplateLangPackage.GENERIC_MULTISELECT__PART:
        getPart().clear();
        getPart().addAll((Collection<? extends multiSelectPart>)newValue);
        return;
      case TemplateLangPackage.GENERIC_MULTISELECT__TRAILER:
        setTrailer((StmtBlock)newValue);
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
      case TemplateLangPackage.GENERIC_MULTISELECT__PREAMBLE:
        setPreamble((StmtBlock)null);
        return;
      case TemplateLangPackage.GENERIC_MULTISELECT__SELECTOR:
        setSelector((StmtBlock)null);
        return;
      case TemplateLangPackage.GENERIC_MULTISELECT__PART:
        getPart().clear();
        return;
      case TemplateLangPackage.GENERIC_MULTISELECT__TRAILER:
        setTrailer((StmtBlock)null);
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
      case TemplateLangPackage.GENERIC_MULTISELECT__PREAMBLE:
        return preamble != null;
      case TemplateLangPackage.GENERIC_MULTISELECT__SELECTOR:
        return selector != null;
      case TemplateLangPackage.GENERIC_MULTISELECT__PART:
        return part != null && !part.isEmpty();
      case TemplateLangPackage.GENERIC_MULTISELECT__TRAILER:
        return trailer != null;
    }
    return super.eIsSet(featureID);
  }

} //genericMultiselectImpl
