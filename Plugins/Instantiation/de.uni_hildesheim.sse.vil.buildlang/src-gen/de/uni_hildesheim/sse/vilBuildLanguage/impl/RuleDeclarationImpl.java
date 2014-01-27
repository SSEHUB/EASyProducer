/**
 * <copyright>
 * </copyright>
 *

 */
package de.uni_hildesheim.sse.vilBuildLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleElementBlock;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleModifier;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleDeclarationImpl#getModifier <em>Modifier</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleDeclarationImpl#getParamList <em>Param List</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleDeclarationImpl#getPostcondition <em>Postcondition</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleDeclarationImpl#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.RuleDeclarationImpl#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleDeclarationImpl extends MinimalEObjectImpl.Container implements RuleDeclaration
{
  /**
   * The cached value of the '{@link #getModifier() <em>Modifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifier()
   * @generated
   * @ordered
   */
  protected RuleModifier modifier;

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
   * The cached value of the '{@link #getParamList() <em>Param List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParamList()
   * @generated
   * @ordered
   */
  protected ParameterList paramList;

  /**
   * The cached value of the '{@link #getPostcondition() <em>Postcondition</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostcondition()
   * @generated
   * @ordered
   */
  protected EList<LogicalExpression> postcondition;

  /**
   * The cached value of the '{@link #getPreconditions() <em>Preconditions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreconditions()
   * @generated
   * @ordered
   */
  protected EList<LogicalExpression> preconditions;

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
  protected RuleDeclarationImpl()
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
    return VilBuildLanguagePackage.Literals.RULE_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleModifier getModifier()
  {
    return modifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModifier(RuleModifier newModifier, NotificationChain msgs)
  {
    RuleModifier oldModifier = modifier;
    modifier = newModifier;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.RULE_DECLARATION__MODIFIER, oldModifier, newModifier);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModifier(RuleModifier newModifier)
  {
    if (newModifier != modifier)
    {
      NotificationChain msgs = null;
      if (modifier != null)
        msgs = ((InternalEObject)modifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.RULE_DECLARATION__MODIFIER, null, msgs);
      if (newModifier != null)
        msgs = ((InternalEObject)newModifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.RULE_DECLARATION__MODIFIER, null, msgs);
      msgs = basicSetModifier(newModifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.RULE_DECLARATION__MODIFIER, newModifier, newModifier));
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
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.RULE_DECLARATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterList getParamList()
  {
    return paramList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParamList(ParameterList newParamList, NotificationChain msgs)
  {
    ParameterList oldParamList = paramList;
    paramList = newParamList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.RULE_DECLARATION__PARAM_LIST, oldParamList, newParamList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParamList(ParameterList newParamList)
  {
    if (newParamList != paramList)
    {
      NotificationChain msgs = null;
      if (paramList != null)
        msgs = ((InternalEObject)paramList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.RULE_DECLARATION__PARAM_LIST, null, msgs);
      if (newParamList != null)
        msgs = ((InternalEObject)newParamList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.RULE_DECLARATION__PARAM_LIST, null, msgs);
      msgs = basicSetParamList(newParamList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.RULE_DECLARATION__PARAM_LIST, newParamList, newParamList));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LogicalExpression> getPostcondition()
  {
    if (postcondition == null)
    {
      postcondition = new EObjectContainmentEList<LogicalExpression>(LogicalExpression.class, this, VilBuildLanguagePackage.RULE_DECLARATION__POSTCONDITION);
    }
    return postcondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LogicalExpression> getPreconditions()
  {
    if (preconditions == null)
    {
      preconditions = new EObjectContainmentEList<LogicalExpression>(LogicalExpression.class, this, VilBuildLanguagePackage.RULE_DECLARATION__PRECONDITIONS);
    }
    return preconditions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.RULE_DECLARATION__BLOCK, oldBlock, newBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBlock(RuleElementBlock newBlock)
  {
    if (newBlock != block)
    {
      NotificationChain msgs = null;
      if (block != null)
        msgs = ((InternalEObject)block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.RULE_DECLARATION__BLOCK, null, msgs);
      if (newBlock != null)
        msgs = ((InternalEObject)newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VilBuildLanguagePackage.RULE_DECLARATION__BLOCK, null, msgs);
      msgs = basicSetBlock(newBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VilBuildLanguagePackage.RULE_DECLARATION__BLOCK, newBlock, newBlock));
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
      case VilBuildLanguagePackage.RULE_DECLARATION__MODIFIER:
        return basicSetModifier(null, msgs);
      case VilBuildLanguagePackage.RULE_DECLARATION__PARAM_LIST:
        return basicSetParamList(null, msgs);
      case VilBuildLanguagePackage.RULE_DECLARATION__POSTCONDITION:
        return ((InternalEList<?>)getPostcondition()).basicRemove(otherEnd, msgs);
      case VilBuildLanguagePackage.RULE_DECLARATION__PRECONDITIONS:
        return ((InternalEList<?>)getPreconditions()).basicRemove(otherEnd, msgs);
      case VilBuildLanguagePackage.RULE_DECLARATION__BLOCK:
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
      case VilBuildLanguagePackage.RULE_DECLARATION__MODIFIER:
        return getModifier();
      case VilBuildLanguagePackage.RULE_DECLARATION__NAME:
        return getName();
      case VilBuildLanguagePackage.RULE_DECLARATION__PARAM_LIST:
        return getParamList();
      case VilBuildLanguagePackage.RULE_DECLARATION__POSTCONDITION:
        return getPostcondition();
      case VilBuildLanguagePackage.RULE_DECLARATION__PRECONDITIONS:
        return getPreconditions();
      case VilBuildLanguagePackage.RULE_DECLARATION__BLOCK:
        return getBlock();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case VilBuildLanguagePackage.RULE_DECLARATION__MODIFIER:
        setModifier((RuleModifier)newValue);
        return;
      case VilBuildLanguagePackage.RULE_DECLARATION__NAME:
        setName((String)newValue);
        return;
      case VilBuildLanguagePackage.RULE_DECLARATION__PARAM_LIST:
        setParamList((ParameterList)newValue);
        return;
      case VilBuildLanguagePackage.RULE_DECLARATION__POSTCONDITION:
        getPostcondition().clear();
        getPostcondition().addAll((Collection<? extends LogicalExpression>)newValue);
        return;
      case VilBuildLanguagePackage.RULE_DECLARATION__PRECONDITIONS:
        getPreconditions().clear();
        getPreconditions().addAll((Collection<? extends LogicalExpression>)newValue);
        return;
      case VilBuildLanguagePackage.RULE_DECLARATION__BLOCK:
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
      case VilBuildLanguagePackage.RULE_DECLARATION__MODIFIER:
        setModifier((RuleModifier)null);
        return;
      case VilBuildLanguagePackage.RULE_DECLARATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case VilBuildLanguagePackage.RULE_DECLARATION__PARAM_LIST:
        setParamList((ParameterList)null);
        return;
      case VilBuildLanguagePackage.RULE_DECLARATION__POSTCONDITION:
        getPostcondition().clear();
        return;
      case VilBuildLanguagePackage.RULE_DECLARATION__PRECONDITIONS:
        getPreconditions().clear();
        return;
      case VilBuildLanguagePackage.RULE_DECLARATION__BLOCK:
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
      case VilBuildLanguagePackage.RULE_DECLARATION__MODIFIER:
        return modifier != null;
      case VilBuildLanguagePackage.RULE_DECLARATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case VilBuildLanguagePackage.RULE_DECLARATION__PARAM_LIST:
        return paramList != null;
      case VilBuildLanguagePackage.RULE_DECLARATION__POSTCONDITION:
        return postcondition != null && !postcondition.isEmpty();
      case VilBuildLanguagePackage.RULE_DECLARATION__PRECONDITIONS:
        return preconditions != null && !preconditions.isEmpty();
      case VilBuildLanguagePackage.RULE_DECLARATION__BLOCK:
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

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //RuleDeclarationImpl
