/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage.impl;

import de.uni_hildesheim.sse.vilBuildLanguage.ExpressionStatement;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleElementBlock;
import de.uni_hildesheim.sse.vilBuildLanguage.StatementOrBlock;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statement Or Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.StatementOrBlockImpl#getExStmt <em>Ex Stmt</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.StatementOrBlockImpl#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StatementOrBlockImpl extends MinimalEObjectImpl.Container implements StatementOrBlock
{
  /**
   * The cached value of the '{@link #getExStmt() <em>Ex Stmt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExStmt()
   * @generated
   * @ordered
   */
  protected ExpressionStatement exStmt;

  /**
   * The cached value of the '{@link #getBlock() <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlock()
   * @generated
   * @ordered
   */
  protected RuleElementBlock block;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StatementOrBlockImpl()
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
    return VilBuildLanguagePackage.Literals.STATEMENT_OR_BLOCK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExpressionStatement getExStmt()
  {
    return exStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExStmt(ExpressionStatement newExStmt, NotificationChain msgs)
  {
    ExpressionStatement oldExStmt = exStmt;
    exStmt = newExStmt;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.STATEMENT_OR_BLOCK__EX_STMT, oldExStmt, newExStmt);
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
  public void setExStmt(ExpressionStatement newExStmt)
  {
    if (newExStmt != exStmt)
    {
      NotificationChain msgs = null;
      if (exStmt != null)
        msgs = ((InternalEObject)exStmt).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.STATEMENT_OR_BLOCK__EX_STMT, null, msgs);
      if (newExStmt != null)
        msgs = ((InternalEObject)newExStmt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.STATEMENT_OR_BLOCK__EX_STMT, null, msgs);
      msgs = basicSetExStmt(newExStmt, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.STATEMENT_OR_BLOCK__EX_STMT, newExStmt, newExStmt));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RuleElementBlock getBlock()
  {
    return block;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBlock(RuleElementBlock newBlock, NotificationChain msgs)
  {
    RuleElementBlock oldBlock = block;
    block = newBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.STATEMENT_OR_BLOCK__BLOCK, oldBlock, newBlock);
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
  public void setBlock(RuleElementBlock newBlock)
  {
    if (newBlock != block)
    {
      NotificationChain msgs = null;
      if (block != null)
        msgs = ((InternalEObject)block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.STATEMENT_OR_BLOCK__BLOCK, null, msgs);
      if (newBlock != null)
        msgs = ((InternalEObject)newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.STATEMENT_OR_BLOCK__BLOCK, null, msgs);
      msgs = basicSetBlock(newBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.STATEMENT_OR_BLOCK__BLOCK, newBlock, newBlock));
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
      case VilBuildLanguagePackage.STATEMENT_OR_BLOCK__EX_STMT:
        return basicSetExStmt(null, msgs);
      case VilBuildLanguagePackage.STATEMENT_OR_BLOCK__BLOCK:
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
      case VilBuildLanguagePackage.STATEMENT_OR_BLOCK__EX_STMT:
        return getExStmt();
      case VilBuildLanguagePackage.STATEMENT_OR_BLOCK__BLOCK:
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
      case VilBuildLanguagePackage.STATEMENT_OR_BLOCK__EX_STMT:
        setExStmt((ExpressionStatement)newValue);
        return;
      case VilBuildLanguagePackage.STATEMENT_OR_BLOCK__BLOCK:
        setBlock((RuleElementBlock)newValue);
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
      case VilBuildLanguagePackage.STATEMENT_OR_BLOCK__EX_STMT:
        setExStmt((ExpressionStatement)null);
        return;
      case VilBuildLanguagePackage.STATEMENT_OR_BLOCK__BLOCK:
        setBlock((RuleElementBlock)null);
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
      case VilBuildLanguagePackage.STATEMENT_OR_BLOCK__EX_STMT:
        return exStmt != null;
      case VilBuildLanguagePackage.STATEMENT_OR_BLOCK__BLOCK:
        return block != null;
    }
    return super.eIsSet(featureID);
  }

} //StatementOrBlockImpl
