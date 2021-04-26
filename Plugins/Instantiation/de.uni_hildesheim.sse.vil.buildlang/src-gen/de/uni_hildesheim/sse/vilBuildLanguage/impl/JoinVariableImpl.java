/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;

import de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Join Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.JoinVariableImpl#getExcl <em>Excl</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.JoinVariableImpl#getVar <em>Var</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.JoinVariableImpl#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JoinVariableImpl extends MinimalEObjectImpl.Container implements JoinVariable
{
  /**
   * The default value of the '{@link #getExcl() <em>Excl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExcl()
   * @generated
   * @ordered
   */
  protected static final String EXCL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExcl() <em>Excl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExcl()
   * @generated
   * @ordered
   */
  protected String excl = EXCL_EDEFAULT;

  /**
   * The default value of the '{@link #getVar() <em>Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVar()
   * @generated
   * @ordered
   */
  protected static final String VAR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVar() <em>Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVar()
   * @generated
   * @ordered
   */
  protected String var = VAR_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JoinVariableImpl()
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
    return VilBuildLanguagePackage.Literals.JOIN_VARIABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getExcl()
  {
    return excl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExcl(String newExcl)
  {
    String oldExcl = excl;
    excl = newExcl;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.JOIN_VARIABLE__EXCL, oldExcl, excl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getVar()
  {
    return var;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setVar(String newVar)
  {
    String oldVar = var;
    var = newVar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.JOIN_VARIABLE__VAR, oldVar, var));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.JOIN_VARIABLE__EXPR, oldExpr, newExpr);
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
  public void setExpr(Expression newExpr)
  {
    if (newExpr != expr)
    {
      NotificationChain msgs = null;
      if (expr != null)
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.JOIN_VARIABLE__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.JOIN_VARIABLE__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.JOIN_VARIABLE__EXPR, newExpr, newExpr));
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
      case VilBuildLanguagePackage.JOIN_VARIABLE__EXPR:
        return basicSetExpr(null, msgs);
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
      case VilBuildLanguagePackage.JOIN_VARIABLE__EXCL:
        return getExcl();
      case VilBuildLanguagePackage.JOIN_VARIABLE__VAR:
        return getVar();
      case VilBuildLanguagePackage.JOIN_VARIABLE__EXPR:
        return getExpr();
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
      case VilBuildLanguagePackage.JOIN_VARIABLE__EXCL:
        setExcl((String)newValue);
        return;
      case VilBuildLanguagePackage.JOIN_VARIABLE__VAR:
        setVar((String)newValue);
        return;
      case VilBuildLanguagePackage.JOIN_VARIABLE__EXPR:
        setExpr((Expression)newValue);
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
      case VilBuildLanguagePackage.JOIN_VARIABLE__EXCL:
        setExcl(EXCL_EDEFAULT);
        return;
      case VilBuildLanguagePackage.JOIN_VARIABLE__VAR:
        setVar(VAR_EDEFAULT);
        return;
      case VilBuildLanguagePackage.JOIN_VARIABLE__EXPR:
        setExpr((Expression)null);
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
      case VilBuildLanguagePackage.JOIN_VARIABLE__EXCL:
        return EXCL_EDEFAULT == null ? excl != null : !EXCL_EDEFAULT.equals(excl);
      case VilBuildLanguagePackage.JOIN_VARIABLE__VAR:
        return VAR_EDEFAULT == null ? var != null : !VAR_EDEFAULT.equals(var);
      case VilBuildLanguagePackage.JOIN_VARIABLE__EXPR:
        return expr != null;
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
    result.append(" (excl: ");
    result.append(excl);
    result.append(", var: ");
    result.append(var);
    result.append(')');
    return result.toString();
  }

} //JoinVariableImpl
