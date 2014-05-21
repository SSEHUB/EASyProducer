/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;

import de.uni_hildesheim.sse.vilBuildLanguage.DeferDeclaration;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleElement;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleElementImpl#getVarDecl <em>Var Decl</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleElementImpl#getExprStmt <em>Expr Stmt</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleElementImpl#getDeferDecl <em>Defer Decl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleElementImpl extends MinimalEObjectImpl.Container implements RuleElement
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
   * The cached value of the '{@link #getDeferDecl() <em>Defer Decl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeferDecl()
   * @generated
   * @ordered
   */
  protected DeferDeclaration deferDecl;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleElementImpl()
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
    return VilBuildLanguagePackage.Literals.RULE_ELEMENT;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.RULE_ELEMENT__VAR_DECL, oldVarDecl, newVarDecl);
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
        msgs = ((InternalEObject)varDecl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.RULE_ELEMENT__VAR_DECL, null, msgs);
      if (newVarDecl != null)
        msgs = ((InternalEObject)newVarDecl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.RULE_ELEMENT__VAR_DECL, null, msgs);
      msgs = basicSetVarDecl(newVarDecl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.RULE_ELEMENT__VAR_DECL, newVarDecl, newVarDecl));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.RULE_ELEMENT__EXPR_STMT, oldExprStmt, newExprStmt);
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
        msgs = ((InternalEObject)exprStmt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.RULE_ELEMENT__EXPR_STMT, null, msgs);
      if (newExprStmt != null)
        msgs = ((InternalEObject)newExprStmt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.RULE_ELEMENT__EXPR_STMT, null, msgs);
      msgs = basicSetExprStmt(newExprStmt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.RULE_ELEMENT__EXPR_STMT, newExprStmt, newExprStmt));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeferDeclaration getDeferDecl()
  {
    return deferDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDeferDecl(DeferDeclaration newDeferDecl, NotificationChain msgs)
  {
    DeferDeclaration oldDeferDecl = deferDecl;
    deferDecl = newDeferDecl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.RULE_ELEMENT__DEFER_DECL, oldDeferDecl, newDeferDecl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeferDecl(DeferDeclaration newDeferDecl)
  {
    if (newDeferDecl != deferDecl)
    {
      NotificationChain msgs = null;
      if (deferDecl != null)
        msgs = ((InternalEObject)deferDecl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.RULE_ELEMENT__DEFER_DECL, null, msgs);
      if (newDeferDecl != null)
        msgs = ((InternalEObject)newDeferDecl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.RULE_ELEMENT__DEFER_DECL, null, msgs);
      msgs = basicSetDeferDecl(newDeferDecl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.RULE_ELEMENT__DEFER_DECL, newDeferDecl, newDeferDecl));
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
      case VilBuildLanguagePackage.RULE_ELEMENT__VAR_DECL:
        return basicSetVarDecl(null, msgs);
      case VilBuildLanguagePackage.RULE_ELEMENT__EXPR_STMT:
        return basicSetExprStmt(null, msgs);
      case VilBuildLanguagePackage.RULE_ELEMENT__DEFER_DECL:
        return basicSetDeferDecl(null, msgs);
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
      case VilBuildLanguagePackage.RULE_ELEMENT__VAR_DECL:
        return getVarDecl();
      case VilBuildLanguagePackage.RULE_ELEMENT__EXPR_STMT:
        return getExprStmt();
      case VilBuildLanguagePackage.RULE_ELEMENT__DEFER_DECL:
        return getDeferDecl();
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
      case VilBuildLanguagePackage.RULE_ELEMENT__VAR_DECL:
        setVarDecl((VariableDeclaration)newValue);
        return;
      case VilBuildLanguagePackage.RULE_ELEMENT__EXPR_STMT:
        setExprStmt((ExpressionStatement)newValue);
        return;
      case VilBuildLanguagePackage.RULE_ELEMENT__DEFER_DECL:
        setDeferDecl((DeferDeclaration)newValue);
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
      case VilBuildLanguagePackage.RULE_ELEMENT__VAR_DECL:
        setVarDecl((VariableDeclaration)null);
        return;
      case VilBuildLanguagePackage.RULE_ELEMENT__EXPR_STMT:
        setExprStmt((ExpressionStatement)null);
        return;
      case VilBuildLanguagePackage.RULE_ELEMENT__DEFER_DECL:
        setDeferDecl((DeferDeclaration)null);
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
      case VilBuildLanguagePackage.RULE_ELEMENT__VAR_DECL:
        return varDecl != null;
      case VilBuildLanguagePackage.RULE_ELEMENT__EXPR_STMT:
        return exprStmt != null;
      case VilBuildLanguagePackage.RULE_ELEMENT__DEFER_DECL:
        return deferDecl != null;
    }
    return super.eIsSet(featureID);
  }

} //RuleElementImpl
