/**
 */
package de.uni_hildesheim.sse.ivml.impl;

import de.uni_hildesheim.sse.ivml.CollectionInitializer;
import de.uni_hildesheim.sse.ivml.EqualityExpressionPart;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.RelationalExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equality Expression Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.EqualityExpressionPartImpl#getOp <em>Op</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.EqualityExpressionPartImpl#getEx <em>Ex</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.EqualityExpressionPartImpl#getCollection <em>Collection</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EqualityExpressionPartImpl extends MinimalEObjectImpl.Container implements EqualityExpressionPart
{
  /**
   * The default value of the '{@link #getOp() <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected static final String OP_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOp() <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
  protected String op = OP_EDEFAULT;

  /**
   * The cached value of the '{@link #getEx() <em>Ex</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEx()
   * @generated
   * @ordered
   */
  protected RelationalExpression ex;

  /**
   * The cached value of the '{@link #getCollection() <em>Collection</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCollection()
   * @generated
   * @ordered
   */
  protected CollectionInitializer collection;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EqualityExpressionPartImpl()
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
    return IvmlPackage.Literals.EQUALITY_EXPRESSION_PART;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOp()
  {
    return op;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOp(String newOp)
  {
    String oldOp = op;
    op = newOp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.EQUALITY_EXPRESSION_PART__OP, oldOp, op));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalExpression getEx()
  {
    return ex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEx(RelationalExpression newEx, NotificationChain msgs)
  {
    RelationalExpression oldEx = ex;
    ex = newEx;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.EQUALITY_EXPRESSION_PART__EX, oldEx, newEx);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEx(RelationalExpression newEx)
  {
    if (newEx != ex)
    {
      NotificationChain msgs = null;
      if (ex != null)
        msgs = ((InternalEObject)ex).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EQUALITY_EXPRESSION_PART__EX, null, msgs);
      if (newEx != null)
        msgs = ((InternalEObject)newEx).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EQUALITY_EXPRESSION_PART__EX, null, msgs);
      msgs = basicSetEx(newEx, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.EQUALITY_EXPRESSION_PART__EX, newEx, newEx));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionInitializer getCollection()
  {
    return collection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCollection(CollectionInitializer newCollection, NotificationChain msgs)
  {
    CollectionInitializer oldCollection = collection;
    collection = newCollection;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.EQUALITY_EXPRESSION_PART__COLLECTION, oldCollection, newCollection);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCollection(CollectionInitializer newCollection)
  {
    if (newCollection != collection)
    {
      NotificationChain msgs = null;
      if (collection != null)
        msgs = ((InternalEObject)collection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EQUALITY_EXPRESSION_PART__COLLECTION, null, msgs);
      if (newCollection != null)
        msgs = ((InternalEObject)newCollection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EQUALITY_EXPRESSION_PART__COLLECTION, null, msgs);
      msgs = basicSetCollection(newCollection, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.EQUALITY_EXPRESSION_PART__COLLECTION, newCollection, newCollection));
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
      case IvmlPackage.EQUALITY_EXPRESSION_PART__EX:
        return basicSetEx(null, msgs);
      case IvmlPackage.EQUALITY_EXPRESSION_PART__COLLECTION:
        return basicSetCollection(null, msgs);
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
      case IvmlPackage.EQUALITY_EXPRESSION_PART__OP:
        return getOp();
      case IvmlPackage.EQUALITY_EXPRESSION_PART__EX:
        return getEx();
      case IvmlPackage.EQUALITY_EXPRESSION_PART__COLLECTION:
        return getCollection();
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
      case IvmlPackage.EQUALITY_EXPRESSION_PART__OP:
        setOp((String)newValue);
        return;
      case IvmlPackage.EQUALITY_EXPRESSION_PART__EX:
        setEx((RelationalExpression)newValue);
        return;
      case IvmlPackage.EQUALITY_EXPRESSION_PART__COLLECTION:
        setCollection((CollectionInitializer)newValue);
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
      case IvmlPackage.EQUALITY_EXPRESSION_PART__OP:
        setOp(OP_EDEFAULT);
        return;
      case IvmlPackage.EQUALITY_EXPRESSION_PART__EX:
        setEx((RelationalExpression)null);
        return;
      case IvmlPackage.EQUALITY_EXPRESSION_PART__COLLECTION:
        setCollection((CollectionInitializer)null);
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
      case IvmlPackage.EQUALITY_EXPRESSION_PART__OP:
        return OP_EDEFAULT == null ? op != null : !OP_EDEFAULT.equals(op);
      case IvmlPackage.EQUALITY_EXPRESSION_PART__EX:
        return ex != null;
      case IvmlPackage.EQUALITY_EXPRESSION_PART__COLLECTION:
        return collection != null;
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
    result.append(" (op: ");
    result.append(op);
    result.append(')');
    return result.toString();
  }

} //EqualityExpressionPartImpl
