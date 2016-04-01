/**
 */
package de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedPrefix;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeParameters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeImpl#getSet <em>Set</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeImpl#getParam <em>Param</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeImpl#getSeq <em>Seq</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeImpl#getMap <em>Map</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeImpl#getCall <em>Call</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.TypeImpl#getReturn <em>Return</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeImpl extends MinimalEObjectImpl.Container implements Type
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected QualifiedPrefix name;

  /**
   * The default value of the '{@link #getSet() <em>Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSet()
   * @generated
   * @ordered
   */
  protected static final String SET_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSet() <em>Set</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSet()
   * @generated
   * @ordered
   */
  protected String set = SET_EDEFAULT;

  /**
   * The cached value of the '{@link #getParam() <em>Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParam()
   * @generated
   * @ordered
   */
  protected TypeParameters param;

  /**
   * The default value of the '{@link #getSeq() <em>Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSeq()
   * @generated
   * @ordered
   */
  protected static final String SEQ_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSeq() <em>Seq</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSeq()
   * @generated
   * @ordered
   */
  protected String seq = SEQ_EDEFAULT;

  /**
   * The default value of the '{@link #getMap() <em>Map</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMap()
   * @generated
   * @ordered
   */
  protected static final String MAP_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMap() <em>Map</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMap()
   * @generated
   * @ordered
   */
  protected String map = MAP_EDEFAULT;

  /**
   * The default value of the '{@link #getCall() <em>Call</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCall()
   * @generated
   * @ordered
   */
  protected static final String CALL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCall() <em>Call</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCall()
   * @generated
   * @ordered
   */
  protected String call = CALL_EDEFAULT;

  /**
   * The cached value of the '{@link #getReturn() <em>Return</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturn()
   * @generated
   * @ordered
   */
  protected Type return_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeImpl()
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
    return ExpressionDslPackage.Literals.TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedPrefix getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(QualifiedPrefix newName, NotificationChain msgs)
  {
    QualifiedPrefix oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.TYPE__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(QualifiedPrefix newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.TYPE__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.TYPE__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.TYPE__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSet()
  {
    return set;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSet(String newSet)
  {
    String oldSet = set;
    set = newSet;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.TYPE__SET, oldSet, set));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeParameters getParam()
  {
    return param;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParam(TypeParameters newParam, NotificationChain msgs)
  {
    TypeParameters oldParam = param;
    param = newParam;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.TYPE__PARAM, oldParam, newParam);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParam(TypeParameters newParam)
  {
    if (newParam != param)
    {
      NotificationChain msgs = null;
      if (param != null)
        msgs = ((InternalEObject)param).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.TYPE__PARAM, null, msgs);
      if (newParam != null)
        msgs = ((InternalEObject)newParam).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.TYPE__PARAM, null, msgs);
      msgs = basicSetParam(newParam, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.TYPE__PARAM, newParam, newParam));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSeq()
  {
    return seq;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSeq(String newSeq)
  {
    String oldSeq = seq;
    seq = newSeq;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.TYPE__SEQ, oldSeq, seq));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMap()
  {
    return map;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMap(String newMap)
  {
    String oldMap = map;
    map = newMap;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.TYPE__MAP, oldMap, map));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCall()
  {
    return call;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCall(String newCall)
  {
    String oldCall = call;
    call = newCall;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.TYPE__CALL, oldCall, call));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getReturn()
  {
    return return_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReturn(Type newReturn, NotificationChain msgs)
  {
    Type oldReturn = return_;
    return_ = newReturn;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.TYPE__RETURN, oldReturn, newReturn);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReturn(Type newReturn)
  {
    if (newReturn != return_)
    {
      NotificationChain msgs = null;
      if (return_ != null)
        msgs = ((InternalEObject)return_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.TYPE__RETURN, null, msgs);
      if (newReturn != null)
        msgs = ((InternalEObject)newReturn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.TYPE__RETURN, null, msgs);
      msgs = basicSetReturn(newReturn, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.TYPE__RETURN, newReturn, newReturn));
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
      case ExpressionDslPackage.TYPE__NAME:
        return basicSetName(null, msgs);
      case ExpressionDslPackage.TYPE__PARAM:
        return basicSetParam(null, msgs);
      case ExpressionDslPackage.TYPE__RETURN:
        return basicSetReturn(null, msgs);
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
      case ExpressionDslPackage.TYPE__NAME:
        return getName();
      case ExpressionDslPackage.TYPE__SET:
        return getSet();
      case ExpressionDslPackage.TYPE__PARAM:
        return getParam();
      case ExpressionDslPackage.TYPE__SEQ:
        return getSeq();
      case ExpressionDslPackage.TYPE__MAP:
        return getMap();
      case ExpressionDslPackage.TYPE__CALL:
        return getCall();
      case ExpressionDslPackage.TYPE__RETURN:
        return getReturn();
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
      case ExpressionDslPackage.TYPE__NAME:
        setName((QualifiedPrefix)newValue);
        return;
      case ExpressionDslPackage.TYPE__SET:
        setSet((String)newValue);
        return;
      case ExpressionDslPackage.TYPE__PARAM:
        setParam((TypeParameters)newValue);
        return;
      case ExpressionDslPackage.TYPE__SEQ:
        setSeq((String)newValue);
        return;
      case ExpressionDslPackage.TYPE__MAP:
        setMap((String)newValue);
        return;
      case ExpressionDslPackage.TYPE__CALL:
        setCall((String)newValue);
        return;
      case ExpressionDslPackage.TYPE__RETURN:
        setReturn((Type)newValue);
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
      case ExpressionDslPackage.TYPE__NAME:
        setName((QualifiedPrefix)null);
        return;
      case ExpressionDslPackage.TYPE__SET:
        setSet(SET_EDEFAULT);
        return;
      case ExpressionDslPackage.TYPE__PARAM:
        setParam((TypeParameters)null);
        return;
      case ExpressionDslPackage.TYPE__SEQ:
        setSeq(SEQ_EDEFAULT);
        return;
      case ExpressionDslPackage.TYPE__MAP:
        setMap(MAP_EDEFAULT);
        return;
      case ExpressionDslPackage.TYPE__CALL:
        setCall(CALL_EDEFAULT);
        return;
      case ExpressionDslPackage.TYPE__RETURN:
        setReturn((Type)null);
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
      case ExpressionDslPackage.TYPE__NAME:
        return name != null;
      case ExpressionDslPackage.TYPE__SET:
        return SET_EDEFAULT == null ? set != null : !SET_EDEFAULT.equals(set);
      case ExpressionDslPackage.TYPE__PARAM:
        return param != null;
      case ExpressionDslPackage.TYPE__SEQ:
        return SEQ_EDEFAULT == null ? seq != null : !SEQ_EDEFAULT.equals(seq);
      case ExpressionDslPackage.TYPE__MAP:
        return MAP_EDEFAULT == null ? map != null : !MAP_EDEFAULT.equals(map);
      case ExpressionDslPackage.TYPE__CALL:
        return CALL_EDEFAULT == null ? call != null : !CALL_EDEFAULT.equals(call);
      case ExpressionDslPackage.TYPE__RETURN:
        return return_ != null;
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
    result.append(" (set: ");
    result.append(set);
    result.append(", seq: ");
    result.append(seq);
    result.append(", map: ");
    result.append(map);
    result.append(", call: ");
    result.append(call);
    result.append(')');
    return result.toString();
  }

} //TypeImpl
