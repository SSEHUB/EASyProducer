/**
 */
package de.uni_hildesheim.sse.vil.rt.rtVil.impl;

import de.uni_hildesheim.sse.vil.rt.rtVil.IntentDeclaration;
import de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage;
import de.uni_hildesheim.sse.vil.rt.rtVil.RuleElementBlock;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Element Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.RuleElementBlockImpl#getIntent <em>Intent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleElementBlockImpl extends de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleElementBlockImpl implements RuleElementBlock
{
  /**
   * The cached value of the '{@link #getIntent() <em>Intent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntent()
   * @generated
   * @ordered
   */
  protected IntentDeclaration intent;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleElementBlockImpl()
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
    return RtVilPackage.Literals.RULE_ELEMENT_BLOCK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntentDeclaration getIntent()
  {
    return intent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIntent(IntentDeclaration newIntent, NotificationChain msgs)
  {
    IntentDeclaration oldIntent = intent;
    intent = newIntent;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RtVilPackage.RULE_ELEMENT_BLOCK__INTENT, oldIntent, newIntent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIntent(IntentDeclaration newIntent)
  {
    if (newIntent != intent)
    {
      NotificationChain msgs = null;
      if (intent != null)
        msgs = ((InternalEObject)intent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RtVilPackage.RULE_ELEMENT_BLOCK__INTENT, null, msgs);
      if (newIntent != null)
        msgs = ((InternalEObject)newIntent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RtVilPackage.RULE_ELEMENT_BLOCK__INTENT, null, msgs);
      msgs = basicSetIntent(newIntent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RtVilPackage.RULE_ELEMENT_BLOCK__INTENT, newIntent, newIntent));
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
      case RtVilPackage.RULE_ELEMENT_BLOCK__INTENT:
        return basicSetIntent(null, msgs);
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
      case RtVilPackage.RULE_ELEMENT_BLOCK__INTENT:
        return getIntent();
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
      case RtVilPackage.RULE_ELEMENT_BLOCK__INTENT:
        setIntent((IntentDeclaration)newValue);
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
      case RtVilPackage.RULE_ELEMENT_BLOCK__INTENT:
        setIntent((IntentDeclaration)null);
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
      case RtVilPackage.RULE_ELEMENT_BLOCK__INTENT:
        return intent != null;
    }
    return super.eIsSet(featureID);
  }

} //RuleElementBlockImpl
