/**
 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;

import de.uni_hildesheim.sse.vil.templatelang.templateLang.Alternative;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alternative</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.AlternativeImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.AlternativeImpl#getIf <em>If</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.AlternativeImpl#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AlternativeImpl extends MinimalEObjectImpl.Container implements Alternative
{
  /**
   * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr()
   * @generated
   * @ordered
   */
  protected Expression expr;

  /**
   * The cached value of the '{@link #getIf() <em>If</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIf()
   * @generated
   * @ordered
   */
  protected Stmt if_;

  /**
   * The cached value of the '{@link #getElse() <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElse()
   * @generated
   * @ordered
   */
  protected Stmt else_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AlternativeImpl()
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
    return TemplateLangPackage.Literals.ALTERNATIVE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpr()
  {
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpr(Expression newExpr, NotificationChain msgs)
  {
    Expression oldExpr = expr;
    expr = newExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.ALTERNATIVE__EXPR, oldExpr, newExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpr(Expression newExpr)
  {
    if (newExpr != expr)
    {
      NotificationChain msgs = null;
      if (expr != null)
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.ALTERNATIVE__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.ALTERNATIVE__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.ALTERNATIVE__EXPR, newExpr, newExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Stmt getIf()
  {
    return if_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIf(Stmt newIf, NotificationChain msgs)
  {
    Stmt oldIf = if_;
    if_ = newIf;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.ALTERNATIVE__IF, oldIf, newIf);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIf(Stmt newIf)
  {
    if (newIf != if_)
    {
      NotificationChain msgs = null;
      if (if_ != null)
        msgs = ((InternalEObject)if_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.ALTERNATIVE__IF, null, msgs);
      if (newIf != null)
        msgs = ((InternalEObject)newIf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.ALTERNATIVE__IF, null, msgs);
      msgs = basicSetIf(newIf, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.ALTERNATIVE__IF, newIf, newIf));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Stmt getElse()
  {
    return else_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElse(Stmt newElse, NotificationChain msgs)
  {
    Stmt oldElse = else_;
    else_ = newElse;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.ALTERNATIVE__ELSE, oldElse, newElse);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElse(Stmt newElse)
  {
    if (newElse != else_)
    {
      NotificationChain msgs = null;
      if (else_ != null)
        msgs = ((InternalEObject)else_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.ALTERNATIVE__ELSE, null, msgs);
      if (newElse != null)
        msgs = ((InternalEObject)newElse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.ALTERNATIVE__ELSE, null, msgs);
      msgs = basicSetElse(newElse, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.ALTERNATIVE__ELSE, newElse, newElse));
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
      case TemplateLangPackage.ALTERNATIVE__EXPR:
        return basicSetExpr(null, msgs);
      case TemplateLangPackage.ALTERNATIVE__IF:
        return basicSetIf(null, msgs);
      case TemplateLangPackage.ALTERNATIVE__ELSE:
        return basicSetElse(null, msgs);
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
      case TemplateLangPackage.ALTERNATIVE__EXPR:
        return getExpr();
      case TemplateLangPackage.ALTERNATIVE__IF:
        return getIf();
      case TemplateLangPackage.ALTERNATIVE__ELSE:
        return getElse();
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
      case TemplateLangPackage.ALTERNATIVE__EXPR:
        setExpr((Expression)newValue);
        return;
      case TemplateLangPackage.ALTERNATIVE__IF:
        setIf((Stmt)newValue);
        return;
      case TemplateLangPackage.ALTERNATIVE__ELSE:
        setElse((Stmt)newValue);
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
      case TemplateLangPackage.ALTERNATIVE__EXPR:
        setExpr((Expression)null);
        return;
      case TemplateLangPackage.ALTERNATIVE__IF:
        setIf((Stmt)null);
        return;
      case TemplateLangPackage.ALTERNATIVE__ELSE:
        setElse((Stmt)null);
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
      case TemplateLangPackage.ALTERNATIVE__EXPR:
        return expr != null;
      case TemplateLangPackage.ALTERNATIVE__IF:
        return if_ != null;
      case TemplateLangPackage.ALTERNATIVE__ELSE:
        return else_ != null;
    }
    return super.eIsSet(featureID);
  }

} //AlternativeImpl
