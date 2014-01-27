/**
 * <copyright>
 * </copyright>
 *

 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ParameterList;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration;

import de.uni_hildesheim.sse.vil.templatelang.templateLang.Extension;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHint;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Language Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.LanguageUnitImpl#getJavaExts <em>Java Exts</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.LanguageUnitImpl#getIndent <em>Indent</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.LanguageUnitImpl#getParam <em>Param</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.LanguageUnitImpl#getExt <em>Ext</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.LanguageUnitImpl#getVars <em>Vars</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.LanguageUnitImpl#getDefs <em>Defs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LanguageUnitImpl extends de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl.LanguageUnitImpl implements LanguageUnit
{
  /**
   * The cached value of the '{@link #getJavaExts() <em>Java Exts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJavaExts()
   * @generated
   * @ordered
   */
  protected EList<Extension> javaExts;

  /**
   * The cached value of the '{@link #getIndent() <em>Indent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndent()
   * @generated
   * @ordered
   */
  protected IndentationHint indent;

  /**
   * The cached value of the '{@link #getParam() <em>Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParam()
   * @generated
   * @ordered
   */
  protected ParameterList param;

  /**
   * The default value of the '{@link #getExt() <em>Ext</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExt()
   * @generated
   * @ordered
   */
  protected static final String EXT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExt() <em>Ext</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExt()
   * @generated
   * @ordered
   */
  protected String ext = EXT_EDEFAULT;

  /**
   * The cached value of the '{@link #getVars() <em>Vars</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVars()
   * @generated
   * @ordered
   */
  protected EList<VariableDeclaration> vars;

  /**
   * The cached value of the '{@link #getDefs() <em>Defs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefs()
   * @generated
   * @ordered
   */
  protected EList<VilDef> defs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LanguageUnitImpl()
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
    return TemplateLangPackage.Literals.LANGUAGE_UNIT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Extension> getJavaExts()
  {
    if (javaExts == null)
    {
      javaExts = new EObjectContainmentEList<Extension>(Extension.class, this, TemplateLangPackage.LANGUAGE_UNIT__JAVA_EXTS);
    }
    return javaExts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndentationHint getIndent()
  {
    return indent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIndent(IndentationHint newIndent, NotificationChain msgs)
  {
    IndentationHint oldIndent = indent;
    indent = newIndent;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.LANGUAGE_UNIT__INDENT, oldIndent, newIndent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIndent(IndentationHint newIndent)
  {
    if (newIndent != indent)
    {
      NotificationChain msgs = null;
      if (indent != null)
        msgs = ((InternalEObject)indent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.LANGUAGE_UNIT__INDENT, null, msgs);
      if (newIndent != null)
        msgs = ((InternalEObject)newIndent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.LANGUAGE_UNIT__INDENT, null, msgs);
      msgs = basicSetIndent(newIndent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.LANGUAGE_UNIT__INDENT, newIndent, newIndent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterList getParam()
  {
    return param;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParam(ParameterList newParam, NotificationChain msgs)
  {
    ParameterList oldParam = param;
    param = newParam;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplateLangPackage.LANGUAGE_UNIT__PARAM, oldParam, newParam);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParam(ParameterList newParam)
  {
    if (newParam != param)
    {
      NotificationChain msgs = null;
      if (param != null)
        msgs = ((InternalEObject)param).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.LANGUAGE_UNIT__PARAM, null, msgs);
      if (newParam != null)
        msgs = ((InternalEObject)newParam).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplateLangPackage.LANGUAGE_UNIT__PARAM, null, msgs);
      msgs = basicSetParam(newParam, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.LANGUAGE_UNIT__PARAM, newParam, newParam));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExt()
  {
    return ext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExt(String newExt)
  {
    String oldExt = ext;
    ext = newExt;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplateLangPackage.LANGUAGE_UNIT__EXT, oldExt, ext));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VariableDeclaration> getVars()
  {
    if (vars == null)
    {
      vars = new EObjectContainmentEList<VariableDeclaration>(VariableDeclaration.class, this, TemplateLangPackage.LANGUAGE_UNIT__VARS);
    }
    return vars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VilDef> getDefs()
  {
    if (defs == null)
    {
      defs = new EObjectContainmentEList<VilDef>(VilDef.class, this, TemplateLangPackage.LANGUAGE_UNIT__DEFS);
    }
    return defs;
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
      case TemplateLangPackage.LANGUAGE_UNIT__JAVA_EXTS:
        return ((InternalEList<?>)getJavaExts()).basicRemove(otherEnd, msgs);
      case TemplateLangPackage.LANGUAGE_UNIT__INDENT:
        return basicSetIndent(null, msgs);
      case TemplateLangPackage.LANGUAGE_UNIT__PARAM:
        return basicSetParam(null, msgs);
      case TemplateLangPackage.LANGUAGE_UNIT__VARS:
        return ((InternalEList<?>)getVars()).basicRemove(otherEnd, msgs);
      case TemplateLangPackage.LANGUAGE_UNIT__DEFS:
        return ((InternalEList<?>)getDefs()).basicRemove(otherEnd, msgs);
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
      case TemplateLangPackage.LANGUAGE_UNIT__JAVA_EXTS:
        return getJavaExts();
      case TemplateLangPackage.LANGUAGE_UNIT__INDENT:
        return getIndent();
      case TemplateLangPackage.LANGUAGE_UNIT__PARAM:
        return getParam();
      case TemplateLangPackage.LANGUAGE_UNIT__EXT:
        return getExt();
      case TemplateLangPackage.LANGUAGE_UNIT__VARS:
        return getVars();
      case TemplateLangPackage.LANGUAGE_UNIT__DEFS:
        return getDefs();
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
      case TemplateLangPackage.LANGUAGE_UNIT__JAVA_EXTS:
        getJavaExts().clear();
        getJavaExts().addAll((Collection<? extends Extension>)newValue);
        return;
      case TemplateLangPackage.LANGUAGE_UNIT__INDENT:
        setIndent((IndentationHint)newValue);
        return;
      case TemplateLangPackage.LANGUAGE_UNIT__PARAM:
        setParam((ParameterList)newValue);
        return;
      case TemplateLangPackage.LANGUAGE_UNIT__EXT:
        setExt((String)newValue);
        return;
      case TemplateLangPackage.LANGUAGE_UNIT__VARS:
        getVars().clear();
        getVars().addAll((Collection<? extends VariableDeclaration>)newValue);
        return;
      case TemplateLangPackage.LANGUAGE_UNIT__DEFS:
        getDefs().clear();
        getDefs().addAll((Collection<? extends VilDef>)newValue);
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
      case TemplateLangPackage.LANGUAGE_UNIT__JAVA_EXTS:
        getJavaExts().clear();
        return;
      case TemplateLangPackage.LANGUAGE_UNIT__INDENT:
        setIndent((IndentationHint)null);
        return;
      case TemplateLangPackage.LANGUAGE_UNIT__PARAM:
        setParam((ParameterList)null);
        return;
      case TemplateLangPackage.LANGUAGE_UNIT__EXT:
        setExt(EXT_EDEFAULT);
        return;
      case TemplateLangPackage.LANGUAGE_UNIT__VARS:
        getVars().clear();
        return;
      case TemplateLangPackage.LANGUAGE_UNIT__DEFS:
        getDefs().clear();
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
      case TemplateLangPackage.LANGUAGE_UNIT__JAVA_EXTS:
        return javaExts != null && !javaExts.isEmpty();
      case TemplateLangPackage.LANGUAGE_UNIT__INDENT:
        return indent != null;
      case TemplateLangPackage.LANGUAGE_UNIT__PARAM:
        return param != null;
      case TemplateLangPackage.LANGUAGE_UNIT__EXT:
        return EXT_EDEFAULT == null ? ext != null : !EXT_EDEFAULT.equals(ext);
      case TemplateLangPackage.LANGUAGE_UNIT__VARS:
        return vars != null && !vars.isEmpty();
      case TemplateLangPackage.LANGUAGE_UNIT__DEFS:
        return defs != null && !defs.isEmpty();
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
    result.append(" (ext: ");
    result.append(ext);
    result.append(')');
    return result.toString();
  }

} //LanguageUnitImpl
