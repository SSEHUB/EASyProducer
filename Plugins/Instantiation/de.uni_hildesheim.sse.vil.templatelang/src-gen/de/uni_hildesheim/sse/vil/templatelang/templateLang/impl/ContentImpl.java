/**
 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression;

import de.uni_hildesheim.sse.vil.templatelang.templateLang.Content;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Content</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.ContentImpl#getCtn <em>Ctn</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.ContentImpl#getNoCR <em>No CR</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.ContentImpl#getCR <em>CR</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.ContentImpl#getIndent <em>Indent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContentImpl extends MinimalEObjectImpl.Container implements Content
{
  /**
   * The default value of the '{@link #getCtn() <em>Ctn</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCtn()
   * @generated
   * @ordered
   */
  protected static final String CTN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCtn() <em>Ctn</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCtn()
   * @generated
   * @ordered
   */
  protected String ctn = CTN_EDEFAULT;

  /**
   * The default value of the '{@link #getNoCR() <em>No CR</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNoCR()
   * @generated
   * @ordered
   */
  protected static final String NO_CR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNoCR() <em>No CR</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNoCR()
   * @generated
   * @ordered
   */
  protected String noCR = NO_CR_EDEFAULT;

  /**
   * The default value of the '{@link #getCR() <em>CR</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCR()
   * @generated
   * @ordered
   */
  protected static final String CR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCR() <em>CR</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCR()
   * @generated
   * @ordered
   */
  protected String cr = CR_EDEFAULT;

  /**
   * The cached value of the '{@link #getIndent() <em>Indent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndent()
   * @generated
   * @ordered
   */
  protected Expression indent;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContentImpl()
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
    return TemplateLangPackage.Literals.CONTENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getCtn()
  {
    return ctn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCtn(String newCtn)
  {
    String oldCtn = ctn;
    ctn = newCtn;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.CONTENT__CTN, oldCtn, ctn));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getNoCR()
  {
    return noCR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNoCR(String newNoCR)
  {
    String oldNoCR = noCR;
    noCR = newNoCR;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.CONTENT__NO_CR, oldNoCR, noCR));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getCR()
  {
    return cr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCR(String newCR)
  {
    String oldCR = cr;
    cr = newCR;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.CONTENT__CR, oldCR, cr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getIndent()
  {
    return indent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIndent(Expression newIndent, NotificationChain msgs)
  {
    Expression oldIndent = indent;
    indent = newIndent;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.CONTENT__INDENT, oldIndent, newIndent);
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
  public void setIndent(Expression newIndent)
  {
    if (newIndent != indent)
    {
      NotificationChain msgs = null;
      if (indent != null)
        msgs = ((InternalEObject)indent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.CONTENT__INDENT, null, msgs);
      if (newIndent != null)
        msgs = ((InternalEObject)newIndent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.CONTENT__INDENT, null, msgs);
      msgs = basicSetIndent(newIndent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.CONTENT__INDENT, newIndent, newIndent));
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
      case TemplateLangPackage.CONTENT__INDENT:
        return basicSetIndent(null, msgs);
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
      case TemplateLangPackage.CONTENT__CTN:
        return getCtn();
      case TemplateLangPackage.CONTENT__NO_CR:
        return getNoCR();
      case TemplateLangPackage.CONTENT__CR:
        return getCR();
      case TemplateLangPackage.CONTENT__INDENT:
        return getIndent();
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
      case TemplateLangPackage.CONTENT__CTN:
        setCtn((String)newValue);
        return;
      case TemplateLangPackage.CONTENT__NO_CR:
        setNoCR((String)newValue);
        return;
      case TemplateLangPackage.CONTENT__CR:
        setCR((String)newValue);
        return;
      case TemplateLangPackage.CONTENT__INDENT:
        setIndent((Expression)newValue);
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
      case TemplateLangPackage.CONTENT__CTN:
        setCtn(CTN_EDEFAULT);
        return;
      case TemplateLangPackage.CONTENT__NO_CR:
        setNoCR(NO_CR_EDEFAULT);
        return;
      case TemplateLangPackage.CONTENT__CR:
        setCR(CR_EDEFAULT);
        return;
      case TemplateLangPackage.CONTENT__INDENT:
        setIndent((Expression)null);
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
      case TemplateLangPackage.CONTENT__CTN:
        return CTN_EDEFAULT == null ? ctn != null : !CTN_EDEFAULT.equals(ctn);
      case TemplateLangPackage.CONTENT__NO_CR:
        return NO_CR_EDEFAULT == null ? noCR != null : !NO_CR_EDEFAULT.equals(noCR);
      case TemplateLangPackage.CONTENT__CR:
        return CR_EDEFAULT == null ? cr != null : !CR_EDEFAULT.equals(cr);
      case TemplateLangPackage.CONTENT__INDENT:
        return indent != null;
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
    result.append(" (ctn: ");
    result.append(ctn);
    result.append(", noCR: ");
    result.append(noCR);
    result.append(", CR: ");
    result.append(cr);
    result.append(')');
    return result.toString();
  }

} //ContentImpl
