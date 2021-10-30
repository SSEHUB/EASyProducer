/**
 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;

import de.uni_hildesheim.sse.vil.templatelang.templateLang.Alternative;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Content;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.Switch;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.While;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.multiselect;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stmt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtImpl#getVar <em>Var</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtImpl#getAlt <em>Alt</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtImpl#getSwitch <em>Switch</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtImpl#getMulti <em>Multi</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtImpl#getLoop <em>Loop</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtImpl#getWhile <em>While</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtImpl#getExprStmt <em>Expr Stmt</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtImpl#getCtn <em>Ctn</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.StmtImpl#getFlush <em>Flush</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StmtImpl extends MinimalEObjectImpl.Container implements Stmt
{
  /**
   * The cached value of the '{@link #getVar() <em>Var</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVar()
   * @generated
   * @ordered
   */
  protected VariableDeclaration var;

  /**
   * The cached value of the '{@link #getAlt() <em>Alt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlt()
   * @generated
   * @ordered
   */
  protected Alternative alt;

  /**
   * The cached value of the '{@link #getSwitch() <em>Switch</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSwitch()
   * @generated
   * @ordered
   */
  protected Switch switch_;

  /**
   * The cached value of the '{@link #getMulti() <em>Multi</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMulti()
   * @generated
   * @ordered
   */
  protected multiselect multi;

  /**
   * The cached value of the '{@link #getLoop() <em>Loop</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLoop()
   * @generated
   * @ordered
   */
  protected Loop loop;

  /**
   * The cached value of the '{@link #getWhile() <em>While</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWhile()
   * @generated
   * @ordered
   */
  protected While while_;

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
   * The cached value of the '{@link #getCtn() <em>Ctn</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCtn()
   * @generated
   * @ordered
   */
  protected Content ctn;

  /**
   * The default value of the '{@link #getFlush() <em>Flush</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFlush()
   * @generated
   * @ordered
   */
  protected static final String FLUSH_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFlush() <em>Flush</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFlush()
   * @generated
   * @ordered
   */
  protected String flush = FLUSH_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StmtImpl()
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
    return TemplateLangPackage.Literals.STMT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VariableDeclaration getVar()
  {
    return var;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVar(VariableDeclaration newVar, NotificationChain msgs)
  {
    VariableDeclaration oldVar = var;
    var = newVar;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__VAR, oldVar, newVar);
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
  public void setVar(VariableDeclaration newVar)
  {
    if (newVar != var)
    {
      NotificationChain msgs = null;
      if (var != null)
        msgs = ((InternalEObject)var).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.STMT__VAR, null, msgs);
      if (newVar != null)
        msgs = ((InternalEObject)newVar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.STMT__VAR, null, msgs);
      msgs = basicSetVar(newVar, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__VAR, newVar, newVar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Alternative getAlt()
  {
    return alt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAlt(Alternative newAlt, NotificationChain msgs)
  {
    Alternative oldAlt = alt;
    alt = newAlt;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__ALT, oldAlt, newAlt);
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
  public void setAlt(Alternative newAlt)
  {
    if (newAlt != alt)
    {
      NotificationChain msgs = null;
      if (alt != null)
        msgs = ((InternalEObject)alt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.STMT__ALT, null, msgs);
      if (newAlt != null)
        msgs = ((InternalEObject)newAlt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.STMT__ALT, null, msgs);
      msgs = basicSetAlt(newAlt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__ALT, newAlt, newAlt));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Switch getSwitch()
  {
    return switch_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSwitch(Switch newSwitch, NotificationChain msgs)
  {
    Switch oldSwitch = switch_;
    switch_ = newSwitch;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__SWITCH, oldSwitch, newSwitch);
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
  public void setSwitch(Switch newSwitch)
  {
    if (newSwitch != switch_)
    {
      NotificationChain msgs = null;
      if (switch_ != null)
        msgs = ((InternalEObject)switch_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.STMT__SWITCH, null, msgs);
      if (newSwitch != null)
        msgs = ((InternalEObject)newSwitch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.STMT__SWITCH, null, msgs);
      msgs = basicSetSwitch(newSwitch, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__SWITCH, newSwitch, newSwitch));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public multiselect getMulti()
  {
    return multi;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMulti(multiselect newMulti, NotificationChain msgs)
  {
    multiselect oldMulti = multi;
    multi = newMulti;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__MULTI, oldMulti, newMulti);
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
  public void setMulti(multiselect newMulti)
  {
    if (newMulti != multi)
    {
      NotificationChain msgs = null;
      if (multi != null)
        msgs = ((InternalEObject)multi).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.STMT__MULTI, null, msgs);
      if (newMulti != null)
        msgs = ((InternalEObject)newMulti).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.STMT__MULTI, null, msgs);
      msgs = basicSetMulti(newMulti, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__MULTI, newMulti, newMulti));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Loop getLoop()
  {
    return loop;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLoop(Loop newLoop, NotificationChain msgs)
  {
    Loop oldLoop = loop;
    loop = newLoop;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__LOOP, oldLoop, newLoop);
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
  public void setLoop(Loop newLoop)
  {
    if (newLoop != loop)
    {
      NotificationChain msgs = null;
      if (loop != null)
        msgs = ((InternalEObject)loop).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.STMT__LOOP, null, msgs);
      if (newLoop != null)
        msgs = ((InternalEObject)newLoop).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.STMT__LOOP, null, msgs);
      msgs = basicSetLoop(newLoop, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__LOOP, newLoop, newLoop));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public While getWhile()
  {
    return while_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetWhile(While newWhile, NotificationChain msgs)
  {
    While oldWhile = while_;
    while_ = newWhile;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__WHILE, oldWhile, newWhile);
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
  public void setWhile(While newWhile)
  {
    if (newWhile != while_)
    {
      NotificationChain msgs = null;
      if (while_ != null)
        msgs = ((InternalEObject)while_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.STMT__WHILE, null, msgs);
      if (newWhile != null)
        msgs = ((InternalEObject)newWhile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.STMT__WHILE, null, msgs);
      msgs = basicSetWhile(newWhile, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__WHILE, newWhile, newWhile));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__EXPR_STMT, oldExprStmt, newExprStmt);
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
  public void setExprStmt(ExpressionStatement newExprStmt)
  {
    if (newExprStmt != exprStmt)
    {
      NotificationChain msgs = null;
      if (exprStmt != null)
        msgs = ((InternalEObject)exprStmt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.STMT__EXPR_STMT, null, msgs);
      if (newExprStmt != null)
        msgs = ((InternalEObject)newExprStmt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.STMT__EXPR_STMT, null, msgs);
      msgs = basicSetExprStmt(newExprStmt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__EXPR_STMT, newExprStmt, newExprStmt));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Content getCtn()
  {
    return ctn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCtn(Content newCtn, NotificationChain msgs)
  {
    Content oldCtn = ctn;
    ctn = newCtn;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__CTN, oldCtn, newCtn);
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
  public void setCtn(Content newCtn)
  {
    if (newCtn != ctn)
    {
      NotificationChain msgs = null;
      if (ctn != null)
        msgs = ((InternalEObject)ctn).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.STMT__CTN, null, msgs);
      if (newCtn != null)
        msgs = ((InternalEObject)newCtn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.STMT__CTN, null, msgs);
      msgs = basicSetCtn(newCtn, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__CTN, newCtn, newCtn));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getFlush()
  {
    return flush;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFlush(String newFlush)
  {
    String oldFlush = flush;
    flush = newFlush;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.STMT__FLUSH, oldFlush, flush));
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
      case TemplateLangPackage.STMT__VAR:
        return basicSetVar(null, msgs);
      case TemplateLangPackage.STMT__ALT:
        return basicSetAlt(null, msgs);
      case TemplateLangPackage.STMT__SWITCH:
        return basicSetSwitch(null, msgs);
      case TemplateLangPackage.STMT__MULTI:
        return basicSetMulti(null, msgs);
      case TemplateLangPackage.STMT__LOOP:
        return basicSetLoop(null, msgs);
      case TemplateLangPackage.STMT__WHILE:
        return basicSetWhile(null, msgs);
      case TemplateLangPackage.STMT__EXPR_STMT:
        return basicSetExprStmt(null, msgs);
      case TemplateLangPackage.STMT__CTN:
        return basicSetCtn(null, msgs);
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
      case TemplateLangPackage.STMT__VAR:
        return getVar();
      case TemplateLangPackage.STMT__ALT:
        return getAlt();
      case TemplateLangPackage.STMT__SWITCH:
        return getSwitch();
      case TemplateLangPackage.STMT__MULTI:
        return getMulti();
      case TemplateLangPackage.STMT__LOOP:
        return getLoop();
      case TemplateLangPackage.STMT__WHILE:
        return getWhile();
      case TemplateLangPackage.STMT__EXPR_STMT:
        return getExprStmt();
      case TemplateLangPackage.STMT__CTN:
        return getCtn();
      case TemplateLangPackage.STMT__FLUSH:
        return getFlush();
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
      case TemplateLangPackage.STMT__VAR:
        setVar((VariableDeclaration)newValue);
        return;
      case TemplateLangPackage.STMT__ALT:
        setAlt((Alternative)newValue);
        return;
      case TemplateLangPackage.STMT__SWITCH:
        setSwitch((Switch)newValue);
        return;
      case TemplateLangPackage.STMT__MULTI:
        setMulti((multiselect)newValue);
        return;
      case TemplateLangPackage.STMT__LOOP:
        setLoop((Loop)newValue);
        return;
      case TemplateLangPackage.STMT__WHILE:
        setWhile((While)newValue);
        return;
      case TemplateLangPackage.STMT__EXPR_STMT:
        setExprStmt((ExpressionStatement)newValue);
        return;
      case TemplateLangPackage.STMT__CTN:
        setCtn((Content)newValue);
        return;
      case TemplateLangPackage.STMT__FLUSH:
        setFlush((String)newValue);
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
      case TemplateLangPackage.STMT__VAR:
        setVar((VariableDeclaration)null);
        return;
      case TemplateLangPackage.STMT__ALT:
        setAlt((Alternative)null);
        return;
      case TemplateLangPackage.STMT__SWITCH:
        setSwitch((Switch)null);
        return;
      case TemplateLangPackage.STMT__MULTI:
        setMulti((multiselect)null);
        return;
      case TemplateLangPackage.STMT__LOOP:
        setLoop((Loop)null);
        return;
      case TemplateLangPackage.STMT__WHILE:
        setWhile((While)null);
        return;
      case TemplateLangPackage.STMT__EXPR_STMT:
        setExprStmt((ExpressionStatement)null);
        return;
      case TemplateLangPackage.STMT__CTN:
        setCtn((Content)null);
        return;
      case TemplateLangPackage.STMT__FLUSH:
        setFlush(FLUSH_EDEFAULT);
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
      case TemplateLangPackage.STMT__VAR:
        return var != null;
      case TemplateLangPackage.STMT__ALT:
        return alt != null;
      case TemplateLangPackage.STMT__SWITCH:
        return switch_ != null;
      case TemplateLangPackage.STMT__MULTI:
        return multi != null;
      case TemplateLangPackage.STMT__LOOP:
        return loop != null;
      case TemplateLangPackage.STMT__WHILE:
        return while_ != null;
      case TemplateLangPackage.STMT__EXPR_STMT:
        return exprStmt != null;
      case TemplateLangPackage.STMT__CTN:
        return ctn != null;
      case TemplateLangPackage.STMT__FLUSH:
        return FLUSH_EDEFAULT == null ? flush != null : !FLUSH_EDEFAULT.equals(flush);
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
    result.append(" (flush: ");
    result.append(flush);
    result.append(')');
    return result.toString();
  }

} //StmtImpl
