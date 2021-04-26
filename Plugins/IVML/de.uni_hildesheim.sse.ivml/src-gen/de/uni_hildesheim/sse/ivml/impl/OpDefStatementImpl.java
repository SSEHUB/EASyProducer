/**
 */
package de.uni_hildesheim.sse.ivml.impl;

import de.uni_hildesheim.sse.ivml.BlockExpression;
import de.uni_hildesheim.sse.ivml.Expression;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.OpDefParameterList;
import de.uni_hildesheim.sse.ivml.OpDefStatement;
import de.uni_hildesheim.sse.ivml.Type;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Op Def Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.OpDefStatementImpl#getStatic <em>Static</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.OpDefStatementImpl#getResult <em>Result</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.OpDefStatementImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.OpDefStatementImpl#getParam <em>Param</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.OpDefStatementImpl#getImpl <em>Impl</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.OpDefStatementImpl#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OpDefStatementImpl extends MinimalEObjectImpl.Container implements OpDefStatement
{
  /**
   * The default value of the '{@link #getStatic() <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatic()
   * @generated
   * @ordered
   */
  protected static final String STATIC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStatic() <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatic()
   * @generated
   * @ordered
   */
  protected String static_ = STATIC_EDEFAULT;

  /**
   * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResult()
   * @generated
   * @ordered
   */
  protected Type result;

  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getParam() <em>Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParam()
   * @generated
   * @ordered
   */
  protected OpDefParameterList param;

  /**
   * The cached value of the '{@link #getImpl() <em>Impl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImpl()
   * @generated
   * @ordered
   */
  protected Expression impl;

  /**
   * The cached value of the '{@link #getBlock() <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlock()
   * @generated
   * @ordered
   */
  protected BlockExpression block;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OpDefStatementImpl()
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
    return IvmlPackage.Literals.OP_DEF_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getStatic()
  {
    return static_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStatic(String newStatic)
  {
    String oldStatic = static_;
    static_ = newStatic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.OP_DEF_STATEMENT__STATIC, oldStatic, static_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Type getResult()
  {
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetResult(Type newResult, NotificationChain msgs)
  {
    Type oldResult = result;
    result = newResult;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.OP_DEF_STATEMENT__RESULT, oldResult, newResult);
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
  public void setResult(Type newResult)
  {
    if (newResult != result)
    {
      NotificationChain msgs = null;
      if (result != null)
        msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.OP_DEF_STATEMENT__RESULT, null, msgs);
      if (newResult != null)
        msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.OP_DEF_STATEMENT__RESULT, null, msgs);
      msgs = basicSetResult(newResult, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.OP_DEF_STATEMENT__RESULT, newResult, newResult));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.OP_DEF_STATEMENT__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OpDefParameterList getParam()
  {
    return param;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParam(OpDefParameterList newParam, NotificationChain msgs)
  {
    OpDefParameterList oldParam = param;
    param = newParam;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.OP_DEF_STATEMENT__PARAM, oldParam, newParam);
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
  public void setParam(OpDefParameterList newParam)
  {
    if (newParam != param)
    {
      NotificationChain msgs = null;
      if (param != null)
        msgs = ((InternalEObject)param).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.OP_DEF_STATEMENT__PARAM, null, msgs);
      if (newParam != null)
        msgs = ((InternalEObject)newParam).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.OP_DEF_STATEMENT__PARAM, null, msgs);
      msgs = basicSetParam(newParam, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.OP_DEF_STATEMENT__PARAM, newParam, newParam));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getImpl()
  {
    return impl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetImpl(Expression newImpl, NotificationChain msgs)
  {
    Expression oldImpl = impl;
    impl = newImpl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.OP_DEF_STATEMENT__IMPL, oldImpl, newImpl);
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
  public void setImpl(Expression newImpl)
  {
    if (newImpl != impl)
    {
      NotificationChain msgs = null;
      if (impl != null)
        msgs = ((InternalEObject)impl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.OP_DEF_STATEMENT__IMPL, null, msgs);
      if (newImpl != null)
        msgs = ((InternalEObject)newImpl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.OP_DEF_STATEMENT__IMPL, null, msgs);
      msgs = basicSetImpl(newImpl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.OP_DEF_STATEMENT__IMPL, newImpl, newImpl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BlockExpression getBlock()
  {
    return block;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBlock(BlockExpression newBlock, NotificationChain msgs)
  {
    BlockExpression oldBlock = block;
    block = newBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.OP_DEF_STATEMENT__BLOCK, oldBlock, newBlock);
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
  public void setBlock(BlockExpression newBlock)
  {
    if (newBlock != block)
    {
      NotificationChain msgs = null;
      if (block != null)
        msgs = ((InternalEObject)block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.OP_DEF_STATEMENT__BLOCK, null, msgs);
      if (newBlock != null)
        msgs = ((InternalEObject)newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.OP_DEF_STATEMENT__BLOCK, null, msgs);
      msgs = basicSetBlock(newBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.OP_DEF_STATEMENT__BLOCK, newBlock, newBlock));
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
      case IvmlPackage.OP_DEF_STATEMENT__RESULT:
        return basicSetResult(null, msgs);
      case IvmlPackage.OP_DEF_STATEMENT__PARAM:
        return basicSetParam(null, msgs);
      case IvmlPackage.OP_DEF_STATEMENT__IMPL:
        return basicSetImpl(null, msgs);
      case IvmlPackage.OP_DEF_STATEMENT__BLOCK:
        return basicSetBlock(null, msgs);
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
      case IvmlPackage.OP_DEF_STATEMENT__STATIC:
        return getStatic();
      case IvmlPackage.OP_DEF_STATEMENT__RESULT:
        return getResult();
      case IvmlPackage.OP_DEF_STATEMENT__ID:
        return getId();
      case IvmlPackage.OP_DEF_STATEMENT__PARAM:
        return getParam();
      case IvmlPackage.OP_DEF_STATEMENT__IMPL:
        return getImpl();
      case IvmlPackage.OP_DEF_STATEMENT__BLOCK:
        return getBlock();
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
      case IvmlPackage.OP_DEF_STATEMENT__STATIC:
        setStatic((String)newValue);
        return;
      case IvmlPackage.OP_DEF_STATEMENT__RESULT:
        setResult((Type)newValue);
        return;
      case IvmlPackage.OP_DEF_STATEMENT__ID:
        setId((String)newValue);
        return;
      case IvmlPackage.OP_DEF_STATEMENT__PARAM:
        setParam((OpDefParameterList)newValue);
        return;
      case IvmlPackage.OP_DEF_STATEMENT__IMPL:
        setImpl((Expression)newValue);
        return;
      case IvmlPackage.OP_DEF_STATEMENT__BLOCK:
        setBlock((BlockExpression)newValue);
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
      case IvmlPackage.OP_DEF_STATEMENT__STATIC:
        setStatic(STATIC_EDEFAULT);
        return;
      case IvmlPackage.OP_DEF_STATEMENT__RESULT:
        setResult((Type)null);
        return;
      case IvmlPackage.OP_DEF_STATEMENT__ID:
        setId(ID_EDEFAULT);
        return;
      case IvmlPackage.OP_DEF_STATEMENT__PARAM:
        setParam((OpDefParameterList)null);
        return;
      case IvmlPackage.OP_DEF_STATEMENT__IMPL:
        setImpl((Expression)null);
        return;
      case IvmlPackage.OP_DEF_STATEMENT__BLOCK:
        setBlock((BlockExpression)null);
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
      case IvmlPackage.OP_DEF_STATEMENT__STATIC:
        return STATIC_EDEFAULT == null ? static_ != null : !STATIC_EDEFAULT.equals(static_);
      case IvmlPackage.OP_DEF_STATEMENT__RESULT:
        return result != null;
      case IvmlPackage.OP_DEF_STATEMENT__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case IvmlPackage.OP_DEF_STATEMENT__PARAM:
        return param != null;
      case IvmlPackage.OP_DEF_STATEMENT__IMPL:
        return impl != null;
      case IvmlPackage.OP_DEF_STATEMENT__BLOCK:
        return block != null;
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (static: ");
    result.append(static_);
    result.append(", id: ");
    result.append(id);
    result.append(')');
    return result.toString();
  }

} //OpDefStatementImpl
