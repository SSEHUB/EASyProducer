/**
 */
package de.uni_hildesheim.sse.ivml.impl;

import de.uni_hildesheim.sse.ivml.Expression;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.LetExpression;
import de.uni_hildesheim.sse.ivml.Type;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Let Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.LetExpressionImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.LetExpressionImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.LetExpressionImpl#getValueExpr <em>Value Expr</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.LetExpressionImpl#getSubExpr <em>Sub Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LetExpressionImpl extends MinimalEObjectImpl.Container implements LetExpression
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Type type;

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
   * The cached value of the '{@link #getValueExpr() <em>Value Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueExpr()
   * @generated
   * @ordered
   */
  protected Expression valueExpr;

  /**
   * The cached value of the '{@link #getSubExpr() <em>Sub Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubExpr()
   * @generated
   * @ordered
   */
  protected Expression subExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LetExpressionImpl()
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
    return IvmlPackage.Literals.LET_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(Type newType, NotificationChain msgs)
  {
    Type oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.LET_EXPRESSION__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(Type newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.LET_EXPRESSION__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.LET_EXPRESSION__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.LET_EXPRESSION__TYPE, newType, newType));
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
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.LET_EXPRESSION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getValueExpr()
  {
    return valueExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValueExpr(Expression newValueExpr, NotificationChain msgs)
  {
    Expression oldValueExpr = valueExpr;
    valueExpr = newValueExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.LET_EXPRESSION__VALUE_EXPR, oldValueExpr, newValueExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValueExpr(Expression newValueExpr)
  {
    if (newValueExpr != valueExpr)
    {
      NotificationChain msgs = null;
      if (valueExpr != null)
        msgs = ((InternalEObject)valueExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.LET_EXPRESSION__VALUE_EXPR, null, msgs);
      if (newValueExpr != null)
        msgs = ((InternalEObject)newValueExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.LET_EXPRESSION__VALUE_EXPR, null, msgs);
      msgs = basicSetValueExpr(newValueExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.LET_EXPRESSION__VALUE_EXPR, newValueExpr, newValueExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getSubExpr()
  {
    return subExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSubExpr(Expression newSubExpr, NotificationChain msgs)
  {
    Expression oldSubExpr = subExpr;
    subExpr = newSubExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.LET_EXPRESSION__SUB_EXPR, oldSubExpr, newSubExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubExpr(Expression newSubExpr)
  {
    if (newSubExpr != subExpr)
    {
      NotificationChain msgs = null;
      if (subExpr != null)
        msgs = ((InternalEObject)subExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.LET_EXPRESSION__SUB_EXPR, null, msgs);
      if (newSubExpr != null)
        msgs = ((InternalEObject)newSubExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.LET_EXPRESSION__SUB_EXPR, null, msgs);
      msgs = basicSetSubExpr(newSubExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.LET_EXPRESSION__SUB_EXPR, newSubExpr, newSubExpr));
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
      case IvmlPackage.LET_EXPRESSION__TYPE:
        return basicSetType(null, msgs);
      case IvmlPackage.LET_EXPRESSION__VALUE_EXPR:
        return basicSetValueExpr(null, msgs);
      case IvmlPackage.LET_EXPRESSION__SUB_EXPR:
        return basicSetSubExpr(null, msgs);
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
      case IvmlPackage.LET_EXPRESSION__TYPE:
        return getType();
      case IvmlPackage.LET_EXPRESSION__NAME:
        return getName();
      case IvmlPackage.LET_EXPRESSION__VALUE_EXPR:
        return getValueExpr();
      case IvmlPackage.LET_EXPRESSION__SUB_EXPR:
        return getSubExpr();
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
      case IvmlPackage.LET_EXPRESSION__TYPE:
        setType((Type)newValue);
        return;
      case IvmlPackage.LET_EXPRESSION__NAME:
        setName((String)newValue);
        return;
      case IvmlPackage.LET_EXPRESSION__VALUE_EXPR:
        setValueExpr((Expression)newValue);
        return;
      case IvmlPackage.LET_EXPRESSION__SUB_EXPR:
        setSubExpr((Expression)newValue);
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
      case IvmlPackage.LET_EXPRESSION__TYPE:
        setType((Type)null);
        return;
      case IvmlPackage.LET_EXPRESSION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case IvmlPackage.LET_EXPRESSION__VALUE_EXPR:
        setValueExpr((Expression)null);
        return;
      case IvmlPackage.LET_EXPRESSION__SUB_EXPR:
        setSubExpr((Expression)null);
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
      case IvmlPackage.LET_EXPRESSION__TYPE:
        return type != null;
      case IvmlPackage.LET_EXPRESSION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case IvmlPackage.LET_EXPRESSION__VALUE_EXPR:
        return valueExpr != null;
      case IvmlPackage.LET_EXPRESSION__SUB_EXPR:
        return subExpr != null;
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

} //LetExpressionImpl
