/**
 */
package de.uni_hildesheim.sse.vil.rt.rtVil.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;

import de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement;
import de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement;
import de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage;

import de.uni_hildesheim.sse.vilBuildLanguage.ExpressionStatement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Breakdown Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.BreakdownElementImpl#getVarDecl <em>Var Decl</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.BreakdownElementImpl#getExprStmt <em>Expr Stmt</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.rt.rtVil.impl.BreakdownElementImpl#getBreakdownStmt <em>Breakdown Stmt</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BreakdownElementImpl extends MinimalEObjectImpl.Container implements BreakdownElement
{
  /**
   * The cached value of the '{@link #getVarDecl() <em>Var Decl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVarDecl()
   * @generated
   * @ordered
   */
  protected VariableDeclaration varDecl;

  /**
   * The cached value of the '{@link #getExprStmt() <em>Expr Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExprStmt()
   * @generated
   * @ordered
   */
  protected ExpressionStatement exprStmt;

  /**
   * The cached value of the '{@link #getBreakdownStmt() <em>Breakdown Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBreakdownStmt()
   * @generated
   * @ordered
   */
  protected BreakdownStatement breakdownStmt;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BreakdownElementImpl()
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
    return RtVilPackage.Literals.BREAKDOWN_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableDeclaration getVarDecl()
  {
    return varDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVarDecl(VariableDeclaration newVarDecl, NotificationChain msgs)
  {
    VariableDeclaration oldVarDecl = varDecl;
    varDecl = newVarDecl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RtVilPackage.BREAKDOWN_ELEMENT__VAR_DECL, oldVarDecl, newVarDecl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVarDecl(VariableDeclaration newVarDecl)
  {
    if (newVarDecl != varDecl)
    {
      NotificationChain msgs = null;
      if (varDecl != null)
        msgs = ((InternalEObject)varDecl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RtVilPackage.BREAKDOWN_ELEMENT__VAR_DECL, null, msgs);
      if (newVarDecl != null)
        msgs = ((InternalEObject)newVarDecl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RtVilPackage.BREAKDOWN_ELEMENT__VAR_DECL, null, msgs);
      msgs = basicSetVarDecl(newVarDecl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RtVilPackage.BREAKDOWN_ELEMENT__VAR_DECL, newVarDecl, newVarDecl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionStatement getExprStmt()
  {
    return exprStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExprStmt(ExpressionStatement newExprStmt, NotificationChain msgs)
  {
    ExpressionStatement oldExprStmt = exprStmt;
    exprStmt = newExprStmt;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RtVilPackage.BREAKDOWN_ELEMENT__EXPR_STMT, oldExprStmt, newExprStmt);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExprStmt(ExpressionStatement newExprStmt)
  {
    if (newExprStmt != exprStmt)
    {
      NotificationChain msgs = null;
      if (exprStmt != null)
        msgs = ((InternalEObject)exprStmt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RtVilPackage.BREAKDOWN_ELEMENT__EXPR_STMT, null, msgs);
      if (newExprStmt != null)
        msgs = ((InternalEObject)newExprStmt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RtVilPackage.BREAKDOWN_ELEMENT__EXPR_STMT, null, msgs);
      msgs = basicSetExprStmt(newExprStmt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RtVilPackage.BREAKDOWN_ELEMENT__EXPR_STMT, newExprStmt, newExprStmt));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BreakdownStatement getBreakdownStmt()
  {
    return breakdownStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBreakdownStmt(BreakdownStatement newBreakdownStmt, NotificationChain msgs)
  {
    BreakdownStatement oldBreakdownStmt = breakdownStmt;
    breakdownStmt = newBreakdownStmt;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RtVilPackage.BREAKDOWN_ELEMENT__BREAKDOWN_STMT, oldBreakdownStmt, newBreakdownStmt);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBreakdownStmt(BreakdownStatement newBreakdownStmt)
  {
    if (newBreakdownStmt != breakdownStmt)
    {
      NotificationChain msgs = null;
      if (breakdownStmt != null)
        msgs = ((InternalEObject)breakdownStmt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RtVilPackage.BREAKDOWN_ELEMENT__BREAKDOWN_STMT, null, msgs);
      if (newBreakdownStmt != null)
        msgs = ((InternalEObject)newBreakdownStmt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RtVilPackage.BREAKDOWN_ELEMENT__BREAKDOWN_STMT, null, msgs);
      msgs = basicSetBreakdownStmt(newBreakdownStmt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RtVilPackage.BREAKDOWN_ELEMENT__BREAKDOWN_STMT, newBreakdownStmt, newBreakdownStmt));
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
      case RtVilPackage.BREAKDOWN_ELEMENT__VAR_DECL:
        return basicSetVarDecl(null, msgs);
      case RtVilPackage.BREAKDOWN_ELEMENT__EXPR_STMT:
        return basicSetExprStmt(null, msgs);
      case RtVilPackage.BREAKDOWN_ELEMENT__BREAKDOWN_STMT:
        return basicSetBreakdownStmt(null, msgs);
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
      case RtVilPackage.BREAKDOWN_ELEMENT__VAR_DECL:
        return getVarDecl();
      case RtVilPackage.BREAKDOWN_ELEMENT__EXPR_STMT:
        return getExprStmt();
      case RtVilPackage.BREAKDOWN_ELEMENT__BREAKDOWN_STMT:
        return getBreakdownStmt();
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
      case RtVilPackage.BREAKDOWN_ELEMENT__VAR_DECL:
        setVarDecl((VariableDeclaration)newValue);
        return;
      case RtVilPackage.BREAKDOWN_ELEMENT__EXPR_STMT:
        setExprStmt((ExpressionStatement)newValue);
        return;
      case RtVilPackage.BREAKDOWN_ELEMENT__BREAKDOWN_STMT:
        setBreakdownStmt((BreakdownStatement)newValue);
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
      case RtVilPackage.BREAKDOWN_ELEMENT__VAR_DECL:
        setVarDecl((VariableDeclaration)null);
        return;
      case RtVilPackage.BREAKDOWN_ELEMENT__EXPR_STMT:
        setExprStmt((ExpressionStatement)null);
        return;
      case RtVilPackage.BREAKDOWN_ELEMENT__BREAKDOWN_STMT:
        setBreakdownStmt((BreakdownStatement)null);
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
      case RtVilPackage.BREAKDOWN_ELEMENT__VAR_DECL:
        return varDecl != null;
      case RtVilPackage.BREAKDOWN_ELEMENT__EXPR_STMT:
        return exprStmt != null;
      case RtVilPackage.BREAKDOWN_ELEMENT__BREAKDOWN_STMT:
        return breakdownStmt != null;
    }
    return super.eIsSet(featureID);
  }

} //BreakdownElementImpl
