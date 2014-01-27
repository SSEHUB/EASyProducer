/**
 * <copyright>
 * </copyright>
 *

 */
package de.uni_hildesheim.sse.ivml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;

import de.uni_hildesheim.sse.ivml.AttributeTo;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.Type;
import de.uni_hildesheim.sse.ivml.VariableDeclarationPart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute To</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.AttributeToImpl#getAttributeType <em>Attribute Type</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.AttributeToImpl#getAttributeDecl <em>Attribute Decl</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.AttributeToImpl#getNames <em>Names</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeToImpl extends MinimalEObjectImpl.Container implements AttributeTo
{
  /**
   * The cached value of the '{@link #getAttributeType() <em>Attribute Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeType()
   * @generated
   * @ordered
   */
  protected Type attributeType;

  /**
   * The cached value of the '{@link #getAttributeDecl() <em>Attribute Decl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeDecl()
   * @generated
   * @ordered
   */
  protected VariableDeclarationPart attributeDecl;

  /**
   * The cached value of the '{@link #getNames() <em>Names</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNames()
   * @generated
   * @ordered
   */
  protected EList<String> names;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeToImpl()
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
    return IvmlPackage.Literals.ATTRIBUTE_TO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getAttributeType()
  {
    return attributeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAttributeType(Type newAttributeType, NotificationChain msgs)
  {
    Type oldAttributeType = attributeType;
    attributeType = newAttributeType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_TYPE, oldAttributeType, newAttributeType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAttributeType(Type newAttributeType)
  {
    if (newAttributeType != attributeType)
    {
      NotificationChain msgs = null;
      if (attributeType != null)
        msgs = ((InternalEObject)attributeType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_TYPE, null, msgs);
      if (newAttributeType != null)
        msgs = ((InternalEObject)newAttributeType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_TYPE, null, msgs);
      msgs = basicSetAttributeType(newAttributeType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_TYPE, newAttributeType, newAttributeType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableDeclarationPart getAttributeDecl()
  {
    return attributeDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAttributeDecl(VariableDeclarationPart newAttributeDecl, NotificationChain msgs)
  {
    VariableDeclarationPart oldAttributeDecl = attributeDecl;
    attributeDecl = newAttributeDecl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_DECL, oldAttributeDecl, newAttributeDecl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAttributeDecl(VariableDeclarationPart newAttributeDecl)
  {
    if (newAttributeDecl != attributeDecl)
    {
      NotificationChain msgs = null;
      if (attributeDecl != null)
        msgs = ((InternalEObject)attributeDecl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_DECL, null, msgs);
      if (newAttributeDecl != null)
        msgs = ((InternalEObject)newAttributeDecl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_DECL, null, msgs);
      msgs = basicSetAttributeDecl(newAttributeDecl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_DECL, newAttributeDecl, newAttributeDecl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getNames()
  {
    if (names == null)
    {
      names = new EDataTypeEList<String>(String.class, this, IvmlPackage.ATTRIBUTE_TO__NAMES);
    }
    return names;
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
      case IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_TYPE:
        return basicSetAttributeType(null, msgs);
      case IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_DECL:
        return basicSetAttributeDecl(null, msgs);
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
      case IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_TYPE:
        return getAttributeType();
      case IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_DECL:
        return getAttributeDecl();
      case IvmlPackage.ATTRIBUTE_TO__NAMES:
        return getNames();
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
      case IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_TYPE:
        setAttributeType((Type)newValue);
        return;
      case IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_DECL:
        setAttributeDecl((VariableDeclarationPart)newValue);
        return;
      case IvmlPackage.ATTRIBUTE_TO__NAMES:
        getNames().clear();
        getNames().addAll((Collection<? extends String>)newValue);
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
      case IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_TYPE:
        setAttributeType((Type)null);
        return;
      case IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_DECL:
        setAttributeDecl((VariableDeclarationPart)null);
        return;
      case IvmlPackage.ATTRIBUTE_TO__NAMES:
        getNames().clear();
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
      case IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_TYPE:
        return attributeType != null;
      case IvmlPackage.ATTRIBUTE_TO__ATTRIBUTE_DECL:
        return attributeDecl != null;
      case IvmlPackage.ATTRIBUTE_TO__NAMES:
        return names != null && !names.isEmpty();
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
    result.append(" (names: ");
    result.append(names);
    result.append(')');
    return result.toString();
  }

} //AttributeToImpl
