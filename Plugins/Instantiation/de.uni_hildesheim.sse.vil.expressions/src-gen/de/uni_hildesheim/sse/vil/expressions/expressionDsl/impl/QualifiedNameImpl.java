/**
 */
package de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedName;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedPrefix;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.QualifiedNameImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.QualifiedNameImpl#getQname <em>Qname</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QualifiedNameImpl extends MinimalEObjectImpl.Container implements QualifiedName
{
  /**
   * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrefix()
   * @generated
   * @ordered
   */
  protected QualifiedPrefix prefix;

  /**
   * The cached value of the '{@link #getQname() <em>Qname</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQname()
   * @generated
   * @ordered
   */
  protected EList<String> qname;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QualifiedNameImpl()
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
    return ExpressionDslPackage.Literals.QUALIFIED_NAME;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public QualifiedPrefix getPrefix()
  {
    return prefix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrefix(QualifiedPrefix newPrefix, NotificationChain msgs)
  {
    QualifiedPrefix oldPrefix = prefix;
    prefix = newPrefix;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.QUALIFIED_NAME__PREFIX, oldPrefix, newPrefix);
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
  public void setPrefix(QualifiedPrefix newPrefix)
  {
    if (newPrefix != prefix)
    {
      NotificationChain msgs = null;
      if (prefix != null)
        msgs = ((InternalEObject)prefix).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.QUALIFIED_NAME__PREFIX, null, msgs);
      if (newPrefix != null)
        msgs = ((InternalEObject)newPrefix).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionDslPackage.QUALIFIED_NAME__PREFIX, null, msgs);
      msgs = basicSetPrefix(newPrefix, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDslPackage.QUALIFIED_NAME__PREFIX, newPrefix, newPrefix));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<String> getQname()
  {
    if (qname == null)
    {
      qname = new EDataTypeEList<String>(String.class, this, ExpressionDslPackage.QUALIFIED_NAME__QNAME);
    }
    return qname;
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
      case ExpressionDslPackage.QUALIFIED_NAME__PREFIX:
        return basicSetPrefix(null, msgs);
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
      case ExpressionDslPackage.QUALIFIED_NAME__PREFIX:
        return getPrefix();
      case ExpressionDslPackage.QUALIFIED_NAME__QNAME:
        return getQname();
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
      case ExpressionDslPackage.QUALIFIED_NAME__PREFIX:
        setPrefix((QualifiedPrefix)newValue);
        return;
      case ExpressionDslPackage.QUALIFIED_NAME__QNAME:
        getQname().clear();
        getQname().addAll((Collection<? extends String>)newValue);
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
      case ExpressionDslPackage.QUALIFIED_NAME__PREFIX:
        setPrefix((QualifiedPrefix)null);
        return;
      case ExpressionDslPackage.QUALIFIED_NAME__QNAME:
        getQname().clear();
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
      case ExpressionDslPackage.QUALIFIED_NAME__PREFIX:
        return prefix != null;
      case ExpressionDslPackage.QUALIFIED_NAME__QNAME:
        return qname != null && !qname.isEmpty();
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
    result.append(" (qname: ");
    result.append(qname);
    result.append(')');
    return result.toString();
  }

} //QualifiedNameImpl
