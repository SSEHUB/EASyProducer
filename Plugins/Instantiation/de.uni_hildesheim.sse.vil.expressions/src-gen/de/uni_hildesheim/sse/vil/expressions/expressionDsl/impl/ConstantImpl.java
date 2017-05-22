/**
 */
package de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.NumValue;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedName;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ConstantImpl#getNValue <em>NValue</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ConstantImpl#getSValue <em>SValue</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ConstantImpl#getQValue <em>QValue</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ConstantImpl#getBValue <em>BValue</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ConstantImpl#getNull <em>Null</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.ConstantImpl#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstantImpl extends MinimalEObjectImpl.Container implements Constant
{
  /**
   * The cached value of the '{@link #getNValue() <em>NValue</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNValue()
   * @generated
   * @ordered
   */
  protected NumValue nValue;

  /**
   * The default value of the '{@link #getSValue() <em>SValue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSValue()
   * @generated
   * @ordered
   */
  protected static final String SVALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSValue() <em>SValue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSValue()
   * @generated
   * @ordered
   */
  protected String sValue = SVALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getQValue() <em>QValue</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQValue()
   * @generated
   * @ordered
   */
  protected QualifiedName qValue;

  /**
   * The default value of the '{@link #getBValue() <em>BValue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBValue()
   * @generated
   * @ordered
   */
  protected static final String BVALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBValue() <em>BValue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBValue()
   * @generated
   * @ordered
   */
  protected String bValue = BVALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getNull() <em>Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNull()
   * @generated
   * @ordered
   */
  protected static final String NULL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNull() <em>Null</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNull()
   * @generated
   * @ordered
   */
  protected String null_ = NULL_EDEFAULT;

  /**
   * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected static final String VERSION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected String version = VERSION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstantImpl()
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
    return ExpressionDslPackage.Literals.CONSTANT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumValue getNValue()
  {
    return nValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNValue(NumValue newNValue, NotificationChain msgs)
  {
    NumValue oldNValue = nValue;
    nValue = newNValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.CONSTANT__NVALUE, oldNValue, newNValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNValue(NumValue newNValue)
  {
    if (newNValue != nValue)
    {
      NotificationChain msgs = null;
      if (nValue != null)
        msgs = ((InternalEObject)nValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.CONSTANT__NVALUE, null, msgs);
      if (newNValue != null)
        msgs = ((InternalEObject)newNValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.CONSTANT__NVALUE, null, msgs);
      msgs = basicSetNValue(newNValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.CONSTANT__NVALUE, newNValue, newNValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSValue()
  {
    return sValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSValue(String newSValue)
  {
    String oldSValue = sValue;
    sValue = newSValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.CONSTANT__SVALUE, oldSValue, sValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedName getQValue()
  {
    return qValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQValue(QualifiedName newQValue, NotificationChain msgs)
  {
    QualifiedName oldQValue = qValue;
    qValue = newQValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.CONSTANT__QVALUE, oldQValue, newQValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQValue(QualifiedName newQValue)
  {
    if (newQValue != qValue)
    {
      NotificationChain msgs = null;
      if (qValue != null)
        msgs = ((InternalEObject)qValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.CONSTANT__QVALUE, null, msgs);
      if (newQValue != null)
        msgs = ((InternalEObject)newQValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.CONSTANT__QVALUE, null, msgs);
      msgs = basicSetQValue(newQValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.CONSTANT__QVALUE, newQValue, newQValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBValue()
  {
    return bValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBValue(String newBValue)
  {
    String oldBValue = bValue;
    bValue = newBValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.CONSTANT__BVALUE, oldBValue, bValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNull()
  {
    return null_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNull(String newNull)
  {
    String oldNull = null_;
    null_ = newNull;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.CONSTANT__NULL, oldNull, null_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVersion()
  {
    return version;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVersion(String newVersion)
  {
    String oldVersion = version;
    version = newVersion;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.CONSTANT__VERSION, oldVersion, version));
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
      case ExpressionDslPackage.CONSTANT__NVALUE:
        return basicSetNValue(null, msgs);
      case ExpressionDslPackage.CONSTANT__QVALUE:
        return basicSetQValue(null, msgs);
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
      case ExpressionDslPackage.CONSTANT__NVALUE:
        return getNValue();
      case ExpressionDslPackage.CONSTANT__SVALUE:
        return getSValue();
      case ExpressionDslPackage.CONSTANT__QVALUE:
        return getQValue();
      case ExpressionDslPackage.CONSTANT__BVALUE:
        return getBValue();
      case ExpressionDslPackage.CONSTANT__NULL:
        return getNull();
      case ExpressionDslPackage.CONSTANT__VERSION:
        return getVersion();
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
      case ExpressionDslPackage.CONSTANT__NVALUE:
        setNValue((NumValue)newValue);
        return;
      case ExpressionDslPackage.CONSTANT__SVALUE:
        setSValue((String)newValue);
        return;
      case ExpressionDslPackage.CONSTANT__QVALUE:
        setQValue((QualifiedName)newValue);
        return;
      case ExpressionDslPackage.CONSTANT__BVALUE:
        setBValue((String)newValue);
        return;
      case ExpressionDslPackage.CONSTANT__NULL:
        setNull((String)newValue);
        return;
      case ExpressionDslPackage.CONSTANT__VERSION:
        setVersion((String)newValue);
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
      case ExpressionDslPackage.CONSTANT__NVALUE:
        setNValue((NumValue)null);
        return;
      case ExpressionDslPackage.CONSTANT__SVALUE:
        setSValue(SVALUE_EDEFAULT);
        return;
      case ExpressionDslPackage.CONSTANT__QVALUE:
        setQValue((QualifiedName)null);
        return;
      case ExpressionDslPackage.CONSTANT__BVALUE:
        setBValue(BVALUE_EDEFAULT);
        return;
      case ExpressionDslPackage.CONSTANT__NULL:
        setNull(NULL_EDEFAULT);
        return;
      case ExpressionDslPackage.CONSTANT__VERSION:
        setVersion(VERSION_EDEFAULT);
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
      case ExpressionDslPackage.CONSTANT__NVALUE:
        return nValue != null;
      case ExpressionDslPackage.CONSTANT__SVALUE:
        return SVALUE_EDEFAULT == null ? sValue != null : !SVALUE_EDEFAULT.equals(sValue);
      case ExpressionDslPackage.CONSTANT__QVALUE:
        return qValue != null;
      case ExpressionDslPackage.CONSTANT__BVALUE:
        return BVALUE_EDEFAULT == null ? bValue != null : !BVALUE_EDEFAULT.equals(bValue);
      case ExpressionDslPackage.CONSTANT__NULL:
        return NULL_EDEFAULT == null ? null_ != null : !NULL_EDEFAULT.equals(null_);
      case ExpressionDslPackage.CONSTANT__VERSION:
        return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
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
    result.append(" (sValue: ");
    result.append(sValue);
    result.append(", bValue: ");
    result.append(bValue);
    result.append(", null: ");
    result.append(null_);
    result.append(", version: ");
    result.append(version);
    result.append(')');
    return result.toString();
  }

} //ConstantImpl
