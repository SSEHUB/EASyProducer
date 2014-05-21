/**
 */
package de.uni_hildesheim.sse.ivml.impl;

import de.uni_hildesheim.sse.ivml.CollectionInitializer;
import de.uni_hildesheim.sse.ivml.DslContext;
import de.uni_hildesheim.sse.ivml.Expression;
import de.uni_hildesheim.sse.ivml.ImplicationExpression;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.LetExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.ExpressionImpl#getLet <em>Let</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.ExpressionImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.ExpressionImpl#getCollection <em>Collection</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.ExpressionImpl#getDsl <em>Dsl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionImpl extends MinimalEObjectImpl.Container implements Expression
{
  /**
   * The cached value of the '{@link #getLet() <em>Let</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLet()
   * @generated
   * @ordered
   */
  protected LetExpression let;

  /**
   * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr()
   * @generated
   * @ordered
   */
  protected ImplicationExpression expr;

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
   * The cached value of the '{@link #getDsl() <em>Dsl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDsl()
   * @generated
   * @ordered
   */
  protected DslContext dsl;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpressionImpl()
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
    return IvmlPackage.Literals.EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LetExpression getLet()
  {
    return let;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLet(LetExpression newLet, NotificationChain msgs)
  {
    LetExpression oldLet = let;
    let = newLet;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION__LET, oldLet, newLet);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLet(LetExpression newLet)
  {
    if (newLet != let)
    {
      NotificationChain msgs = null;
      if (let != null)
        msgs = ((InternalEObject)let).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EXPRESSION__LET, null, msgs);
      if (newLet != null)
        msgs = ((InternalEObject)newLet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EXPRESSION__LET, null, msgs);
      msgs = basicSetLet(newLet, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION__LET, newLet, newLet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImplicationExpression getExpr()
  {
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpr(ImplicationExpression newExpr, NotificationChain msgs)
  {
    ImplicationExpression oldExpr = expr;
    expr = newExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION__EXPR, oldExpr, newExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpr(ImplicationExpression newExpr)
  {
    if (newExpr != expr)
    {
      NotificationChain msgs = null;
      if (expr != null)
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EXPRESSION__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EXPRESSION__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION__EXPR, newExpr, newExpr));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION__COLLECTION, oldCollection, newCollection);
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
        msgs = ((InternalEObject)collection).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EXPRESSION__COLLECTION, null, msgs);
      if (newCollection != null)
        msgs = ((InternalEObject)newCollection).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EXPRESSION__COLLECTION, null, msgs);
      msgs = basicSetCollection(newCollection, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION__COLLECTION, newCollection, newCollection));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslContext getDsl()
  {
    return dsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDsl(DslContext newDsl, NotificationChain msgs)
  {
    DslContext oldDsl = dsl;
    dsl = newDsl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION__DSL, oldDsl, newDsl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDsl(DslContext newDsl)
  {
    if (newDsl != dsl)
    {
      NotificationChain msgs = null;
      if (dsl != null)
        msgs = ((InternalEObject)dsl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EXPRESSION__DSL, null, msgs);
      if (newDsl != null)
        msgs = ((InternalEObject)newDsl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EXPRESSION__DSL, null, msgs);
      msgs = basicSetDsl(newDsl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION__DSL, newDsl, newDsl));
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
      case IvmlPackage.EXPRESSION__LET:
        return basicSetLet(null, msgs);
      case IvmlPackage.EXPRESSION__EXPR:
        return basicSetExpr(null, msgs);
      case IvmlPackage.EXPRESSION__COLLECTION:
        return basicSetCollection(null, msgs);
      case IvmlPackage.EXPRESSION__DSL:
        return basicSetDsl(null, msgs);
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
      case IvmlPackage.EXPRESSION__LET:
        return getLet();
      case IvmlPackage.EXPRESSION__EXPR:
        return getExpr();
      case IvmlPackage.EXPRESSION__COLLECTION:
        return getCollection();
      case IvmlPackage.EXPRESSION__DSL:
        return getDsl();
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
      case IvmlPackage.EXPRESSION__LET:
        setLet((LetExpression)newValue);
        return;
      case IvmlPackage.EXPRESSION__EXPR:
        setExpr((ImplicationExpression)newValue);
        return;
      case IvmlPackage.EXPRESSION__COLLECTION:
        setCollection((CollectionInitializer)newValue);
        return;
      case IvmlPackage.EXPRESSION__DSL:
        setDsl((DslContext)newValue);
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
      case IvmlPackage.EXPRESSION__LET:
        setLet((LetExpression)null);
        return;
      case IvmlPackage.EXPRESSION__EXPR:
        setExpr((ImplicationExpression)null);
        return;
      case IvmlPackage.EXPRESSION__COLLECTION:
        setCollection((CollectionInitializer)null);
        return;
      case IvmlPackage.EXPRESSION__DSL:
        setDsl((DslContext)null);
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
      case IvmlPackage.EXPRESSION__LET:
        return let != null;
      case IvmlPackage.EXPRESSION__EXPR:
        return expr != null;
      case IvmlPackage.EXPRESSION__COLLECTION:
        return collection != null;
      case IvmlPackage.EXPRESSION__DSL:
        return dsl != null;
    }
    return super.eIsSet(featureID);
  }

} //ExpressionImpl
