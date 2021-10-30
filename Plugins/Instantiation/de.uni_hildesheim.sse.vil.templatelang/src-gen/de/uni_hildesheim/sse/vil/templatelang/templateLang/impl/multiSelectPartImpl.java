/**
 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;

import de.uni_hildesheim.sse.vil.templatelang.templateLang.StmtBlock;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.multiSelectPart;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>multi Select Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.multiSelectPartImpl#getCase <em>Case</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.multiSelectPartImpl#getCode <em>Code</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.multiSelectPartImpl#getSelector <em>Selector</em>}</li>
 * </ul>
 *
 * @generated
 */
public class multiSelectPartImpl extends MinimalEObjectImpl.Container implements multiSelectPart
{
  /**
   * The cached value of the '{@link #getCase() <em>Case</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCase()
   * @generated
   * @ordered
   */
  protected Expression case_;

  /**
   * The cached value of the '{@link #getCode() <em>Code</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCode()
   * @generated
   * @ordered
   */
  protected StmtBlock code;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected multiSelectPartImpl()
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
    return TemplateLangPackage.Literals.MULTI_SELECT_PART;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getCase()
  {
    return case_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCase(Expression newCase, NotificationChain msgs)
  {
    Expression oldCase = case_;
    case_ = newCase;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.MULTI_SELECT_PART__CASE, oldCase, newCase);
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
  public void setCase(Expression newCase)
  {
    if (newCase != case_)
    {
      NotificationChain msgs = null;
      if (case_ != null)
        msgs = ((InternalEObject)case_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.MULTI_SELECT_PART__CASE, null, msgs);
      if (newCase != null)
        msgs = ((InternalEObject)newCase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.MULTI_SELECT_PART__CASE, null, msgs);
      msgs = basicSetCase(newCase, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.MULTI_SELECT_PART__CASE, newCase, newCase));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StmtBlock getCode()
  {
    return code;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCode(StmtBlock newCode, NotificationChain msgs)
  {
    StmtBlock oldCode = code;
    code = newCode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.MULTI_SELECT_PART__CODE, oldCode, newCode);
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
  public void setCode(StmtBlock newCode)
  {
    if (newCode != code)
    {
      NotificationChain msgs = null;
      if (code != null)
        msgs = ((InternalEObject)code).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.MULTI_SELECT_PART__CODE, null, msgs);
      if (newCode != null)
        msgs = ((InternalEObject)newCode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.MULTI_SELECT_PART__CODE, null, msgs);
      msgs = basicSetCode(newCode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.MULTI_SELECT_PART__CODE, newCode, newCode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.MULTI_SELECT_PART__SELECTOR, oldSelector, newSelector);
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
  public void setSelector(StmtBlock newSelector)
  {
    if (newSelector != selector)
    {
      NotificationChain msgs = null;
      if (selector != null)
        msgs = ((InternalEObject)selector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.MULTI_SELECT_PART__SELECTOR, null, msgs);
      if (newSelector != null)
        msgs = ((InternalEObject)newSelector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.MULTI_SELECT_PART__SELECTOR, null, msgs);
      msgs = basicSetSelector(newSelector, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.MULTI_SELECT_PART__SELECTOR, newSelector, newSelector));
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
      case TemplateLangPackage.MULTI_SELECT_PART__CASE:
        return basicSetCase(null, msgs);
      case TemplateLangPackage.MULTI_SELECT_PART__CODE:
        return basicSetCode(null, msgs);
      case TemplateLangPackage.MULTI_SELECT_PART__SELECTOR:
        return basicSetSelector(null, msgs);
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
      case TemplateLangPackage.MULTI_SELECT_PART__CASE:
        return getCase();
      case TemplateLangPackage.MULTI_SELECT_PART__CODE:
        return getCode();
      case TemplateLangPackage.MULTI_SELECT_PART__SELECTOR:
        return getSelector();
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
      case TemplateLangPackage.MULTI_SELECT_PART__CASE:
        setCase((Expression)newValue);
        return;
      case TemplateLangPackage.MULTI_SELECT_PART__CODE:
        setCode((StmtBlock)newValue);
        return;
      case TemplateLangPackage.MULTI_SELECT_PART__SELECTOR:
        setSelector((StmtBlock)newValue);
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
      case TemplateLangPackage.MULTI_SELECT_PART__CASE:
        setCase((Expression)null);
        return;
      case TemplateLangPackage.MULTI_SELECT_PART__CODE:
        setCode((StmtBlock)null);
        return;
      case TemplateLangPackage.MULTI_SELECT_PART__SELECTOR:
        setSelector((StmtBlock)null);
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
      case TemplateLangPackage.MULTI_SELECT_PART__CASE:
        return case_ != null;
      case TemplateLangPackage.MULTI_SELECT_PART__CODE:
        return code != null;
      case TemplateLangPackage.MULTI_SELECT_PART__SELECTOR:
        return selector != null;
    }
    return super.eIsSet(featureID);
  }

} //multiSelectPartImpl
