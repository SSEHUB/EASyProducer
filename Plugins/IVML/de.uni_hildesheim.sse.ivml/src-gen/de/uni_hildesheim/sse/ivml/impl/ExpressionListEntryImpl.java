/**
 */
package de.uni_hildesheim.sse.ivml.impl;

import de.uni_hildesheim.sse.ivml.ContainerInitializer;
import de.uni_hildesheim.sse.ivml.ExpressionListEntry;
import de.uni_hildesheim.sse.ivml.ImplicationExpression;
import de.uni_hildesheim.sse.ivml.IvmlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression List Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.ExpressionListEntryImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.ExpressionListEntryImpl#getAttrib <em>Attrib</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.ExpressionListEntryImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.ExpressionListEntryImpl#getContainer <em>Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpressionListEntryImpl extends MinimalEObjectImpl.Container implements ExpressionListEntry
{
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
   * The default value of the '{@link #getAttrib() <em>Attrib</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttrib()
   * @generated
   * @ordered
   */
  protected static final String ATTRIB_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAttrib() <em>Attrib</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttrib()
   * @generated
   * @ordered
   */
  protected String attrib = ATTRIB_EDEFAULT;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected ImplicationExpression value;

  /**
   * The cached value of the '{@link #getContainer() <em>Container</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContainer()
   * @generated
   * @ordered
   */
  protected ContainerInitializer container;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpressionListEntryImpl()
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
    return IvmlPackage.Literals.EXPRESSION_LIST_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION_LIST_ENTRY__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getAttrib()
  {
    return attrib;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAttrib(String newAttrib)
  {
    String oldAttrib = attrib;
    attrib = newAttrib;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION_LIST_ENTRY__ATTRIB, oldAttrib, attrib));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImplicationExpression getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(ImplicationExpression newValue, NotificationChain msgs)
  {
    ImplicationExpression oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION_LIST_ENTRY__VALUE, oldValue, newValue);
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
  public void setValue(ImplicationExpression newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EXPRESSION_LIST_ENTRY__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EXPRESSION_LIST_ENTRY__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION_LIST_ENTRY__VALUE, newValue, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ContainerInitializer getContainer()
  {
    return container;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContainer(ContainerInitializer newContainer, NotificationChain msgs)
  {
    ContainerInitializer oldContainer = container;
    container = newContainer;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION_LIST_ENTRY__CONTAINER, oldContainer, newContainer);
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
  public void setContainer(ContainerInitializer newContainer)
  {
    if (newContainer != container)
    {
      NotificationChain msgs = null;
      if (container != null)
        msgs = ((InternalEObject)container).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EXPRESSION_LIST_ENTRY__CONTAINER, null, msgs);
      if (newContainer != null)
        msgs = ((InternalEObject)newContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.EXPRESSION_LIST_ENTRY__CONTAINER, null, msgs);
      msgs = basicSetContainer(newContainer, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.EXPRESSION_LIST_ENTRY__CONTAINER, newContainer, newContainer));
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
      case IvmlPackage.EXPRESSION_LIST_ENTRY__VALUE:
        return basicSetValue(null, msgs);
      case IvmlPackage.EXPRESSION_LIST_ENTRY__CONTAINER:
        return basicSetContainer(null, msgs);
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
      case IvmlPackage.EXPRESSION_LIST_ENTRY__NAME:
        return getName();
      case IvmlPackage.EXPRESSION_LIST_ENTRY__ATTRIB:
        return getAttrib();
      case IvmlPackage.EXPRESSION_LIST_ENTRY__VALUE:
        return getValue();
      case IvmlPackage.EXPRESSION_LIST_ENTRY__CONTAINER:
        return getContainer();
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
      case IvmlPackage.EXPRESSION_LIST_ENTRY__NAME:
        setName((String)newValue);
        return;
      case IvmlPackage.EXPRESSION_LIST_ENTRY__ATTRIB:
        setAttrib((String)newValue);
        return;
      case IvmlPackage.EXPRESSION_LIST_ENTRY__VALUE:
        setValue((ImplicationExpression)newValue);
        return;
      case IvmlPackage.EXPRESSION_LIST_ENTRY__CONTAINER:
        setContainer((ContainerInitializer)newValue);
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
      case IvmlPackage.EXPRESSION_LIST_ENTRY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case IvmlPackage.EXPRESSION_LIST_ENTRY__ATTRIB:
        setAttrib(ATTRIB_EDEFAULT);
        return;
      case IvmlPackage.EXPRESSION_LIST_ENTRY__VALUE:
        setValue((ImplicationExpression)null);
        return;
      case IvmlPackage.EXPRESSION_LIST_ENTRY__CONTAINER:
        setContainer((ContainerInitializer)null);
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
      case IvmlPackage.EXPRESSION_LIST_ENTRY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case IvmlPackage.EXPRESSION_LIST_ENTRY__ATTRIB:
        return ATTRIB_EDEFAULT == null ? attrib != null : !ATTRIB_EDEFAULT.equals(attrib);
      case IvmlPackage.EXPRESSION_LIST_ENTRY__VALUE:
        return value != null;
      case IvmlPackage.EXPRESSION_LIST_ENTRY__CONTAINER:
        return container != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(", attrib: ");
    result.append(attrib);
    result.append(')');
    return result.toString();
  }

} //ExpressionListEntryImpl
