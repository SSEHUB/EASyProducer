/**
 */
package de.uni_hildesheim.sse.ivml.impl;

import de.uni_hildesheim.sse.ivml.AnnotateTo;
import de.uni_hildesheim.sse.ivml.IvmlPackage;
import de.uni_hildesheim.sse.ivml.Type;
import de.uni_hildesheim.sse.ivml.VariableDeclarationPart;

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
 * An implementation of the model object '<em><b>Annotate To</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.AnnotateToImpl#getSname <em>Sname</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.AnnotateToImpl#getAnnotationType <em>Annotation Type</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.AnnotateToImpl#getAnnotationDecl <em>Annotation Decl</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.AnnotateToImpl#getNames <em>Names</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnnotateToImpl extends MinimalEObjectImpl.Container implements AnnotateTo
{
  /**
   * The default value of the '{@link #getSname() <em>Sname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSname()
   * @generated
   * @ordered
   */
  protected static final String SNAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSname() <em>Sname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSname()
   * @generated
   * @ordered
   */
  protected String sname = SNAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getAnnotationType() <em>Annotation Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotationType()
   * @generated
   * @ordered
   */
  protected Type annotationType;

  /**
   * The cached value of the '{@link #getAnnotationDecl() <em>Annotation Decl</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotationDecl()
   * @generated
   * @ordered
   */
  protected VariableDeclarationPart annotationDecl;

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
  protected AnnotateToImpl()
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
    return IvmlPackage.Literals.ANNOTATE_TO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSname()
  {
    return sname;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSname(String newSname)
  {
    String oldSname = sname;
    sname = newSname;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.ANNOTATE_TO__SNAME, oldSname, sname));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getAnnotationType()
  {
    return annotationType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAnnotationType(Type newAnnotationType, NotificationChain msgs)
  {
    Type oldAnnotationType = annotationType;
    annotationType = newAnnotationType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.ANNOTATE_TO__ANNOTATION_TYPE, oldAnnotationType, newAnnotationType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnnotationType(Type newAnnotationType)
  {
    if (newAnnotationType != annotationType)
    {
      NotificationChain msgs = null;
      if (annotationType != null)
        msgs = ((InternalEObject)annotationType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.ANNOTATE_TO__ANNOTATION_TYPE, null, msgs);
      if (newAnnotationType != null)
        msgs = ((InternalEObject)newAnnotationType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.ANNOTATE_TO__ANNOTATION_TYPE, null, msgs);
      msgs = basicSetAnnotationType(newAnnotationType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.ANNOTATE_TO__ANNOTATION_TYPE, newAnnotationType, newAnnotationType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableDeclarationPart getAnnotationDecl()
  {
    return annotationDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAnnotationDecl(VariableDeclarationPart newAnnotationDecl, NotificationChain msgs)
  {
    VariableDeclarationPart oldAnnotationDecl = annotationDecl;
    annotationDecl = newAnnotationDecl;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IvmlPackage.ANNOTATE_TO__ANNOTATION_DECL, oldAnnotationDecl, newAnnotationDecl);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnnotationDecl(VariableDeclarationPart newAnnotationDecl)
  {
    if (newAnnotationDecl != annotationDecl)
    {
      NotificationChain msgs = null;
      if (annotationDecl != null)
        msgs = ((InternalEObject)annotationDecl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.ANNOTATE_TO__ANNOTATION_DECL, null, msgs);
      if (newAnnotationDecl != null)
        msgs = ((InternalEObject)newAnnotationDecl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IvmlPackage.ANNOTATE_TO__ANNOTATION_DECL, null, msgs);
      msgs = basicSetAnnotationDecl(newAnnotationDecl, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.ANNOTATE_TO__ANNOTATION_DECL, newAnnotationDecl, newAnnotationDecl));
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
      names = new EDataTypeEList<String>(String.class, this, IvmlPackage.ANNOTATE_TO__NAMES);
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
      case IvmlPackage.ANNOTATE_TO__ANNOTATION_TYPE:
        return basicSetAnnotationType(null, msgs);
      case IvmlPackage.ANNOTATE_TO__ANNOTATION_DECL:
        return basicSetAnnotationDecl(null, msgs);
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
      case IvmlPackage.ANNOTATE_TO__SNAME:
        return getSname();
      case IvmlPackage.ANNOTATE_TO__ANNOTATION_TYPE:
        return getAnnotationType();
      case IvmlPackage.ANNOTATE_TO__ANNOTATION_DECL:
        return getAnnotationDecl();
      case IvmlPackage.ANNOTATE_TO__NAMES:
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
      case IvmlPackage.ANNOTATE_TO__SNAME:
        setSname((String)newValue);
        return;
      case IvmlPackage.ANNOTATE_TO__ANNOTATION_TYPE:
        setAnnotationType((Type)newValue);
        return;
      case IvmlPackage.ANNOTATE_TO__ANNOTATION_DECL:
        setAnnotationDecl((VariableDeclarationPart)newValue);
        return;
      case IvmlPackage.ANNOTATE_TO__NAMES:
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
      case IvmlPackage.ANNOTATE_TO__SNAME:
        setSname(SNAME_EDEFAULT);
        return;
      case IvmlPackage.ANNOTATE_TO__ANNOTATION_TYPE:
        setAnnotationType((Type)null);
        return;
      case IvmlPackage.ANNOTATE_TO__ANNOTATION_DECL:
        setAnnotationDecl((VariableDeclarationPart)null);
        return;
      case IvmlPackage.ANNOTATE_TO__NAMES:
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
      case IvmlPackage.ANNOTATE_TO__SNAME:
        return SNAME_EDEFAULT == null ? sname != null : !SNAME_EDEFAULT.equals(sname);
      case IvmlPackage.ANNOTATE_TO__ANNOTATION_TYPE:
        return annotationType != null;
      case IvmlPackage.ANNOTATE_TO__ANNOTATION_DECL:
        return annotationDecl != null;
      case IvmlPackage.ANNOTATE_TO__NAMES:
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
    result.append(" (sname: ");
    result.append(sname);
    result.append(", names: ");
    result.append(names);
    result.append(')');
    return result.toString();
  }

} //AnnotateToImpl
