/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Import;

import de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit;
import de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit;
import de.uni_hildesheim.sse.vilBuildLanguage.Require;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implementation Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.ImplementationUnitImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.ImplementationUnitImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.vilBuildLanguage.impl.ImplementationUnitImpl#getScripts <em>Scripts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImplementationUnitImpl extends MinimalEObjectImpl.Container implements ImplementationUnit
{
  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<Import> imports;

  /**
   * The cached value of the '{@link #getRequires() <em>Requires</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequires()
   * @generated
   * @ordered
   */
  protected EList<Require> requires;

  /**
   * The cached value of the '{@link #getScripts() <em>Scripts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScripts()
   * @generated
   * @ordered
   */
  protected EList<LanguageUnit> scripts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImplementationUnitImpl()
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
    return VilBuildLanguagePackage.Literals.IMPLEMENTATION_UNIT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Import> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<Import>(Import.class, this, VilBuildLanguagePackage.IMPLEMENTATION_UNIT__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Require> getRequires()
  {
    if (requires == null)
    {
      requires = new EObjectContainmentEList<Require>(Require.class, this, VilBuildLanguagePackage.IMPLEMENTATION_UNIT__REQUIRES);
    }
    return requires;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LanguageUnit> getScripts()
  {
    if (scripts == null)
    {
      scripts = new EObjectContainmentEList<LanguageUnit>(LanguageUnit.class, this, VilBuildLanguagePackage.IMPLEMENTATION_UNIT__SCRIPTS);
    }
    return scripts;
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
      case VilBuildLanguagePackage.IMPLEMENTATION_UNIT__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case VilBuildLanguagePackage.IMPLEMENTATION_UNIT__REQUIRES:
        return ((InternalEList<?>)getRequires()).basicRemove(otherEnd, msgs);
      case VilBuildLanguagePackage.IMPLEMENTATION_UNIT__SCRIPTS:
        return ((InternalEList<?>)getScripts()).basicRemove(otherEnd, msgs);
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
      case VilBuildLanguagePackage.IMPLEMENTATION_UNIT__IMPORTS:
        return getImports();
      case VilBuildLanguagePackage.IMPLEMENTATION_UNIT__REQUIRES:
        return getRequires();
      case VilBuildLanguagePackage.IMPLEMENTATION_UNIT__SCRIPTS:
        return getScripts();
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
      case VilBuildLanguagePackage.IMPLEMENTATION_UNIT__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case VilBuildLanguagePackage.IMPLEMENTATION_UNIT__REQUIRES:
        getRequires().clear();
        getRequires().addAll((Collection<? extends Require>)newValue);
        return;
      case VilBuildLanguagePackage.IMPLEMENTATION_UNIT__SCRIPTS:
        getScripts().clear();
        getScripts().addAll((Collection<? extends LanguageUnit>)newValue);
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
      case VilBuildLanguagePackage.IMPLEMENTATION_UNIT__IMPORTS:
        getImports().clear();
        return;
      case VilBuildLanguagePackage.IMPLEMENTATION_UNIT__REQUIRES:
        getRequires().clear();
        return;
      case VilBuildLanguagePackage.IMPLEMENTATION_UNIT__SCRIPTS:
        getScripts().clear();
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
      case VilBuildLanguagePackage.IMPLEMENTATION_UNIT__IMPORTS:
        return imports != null && !imports.isEmpty();
      case VilBuildLanguagePackage.IMPLEMENTATION_UNIT__REQUIRES:
        return requires != null && !requires.isEmpty();
      case VilBuildLanguagePackage.IMPLEMENTATION_UNIT__SCRIPTS:
        return scripts != null && !scripts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ImplementationUnitImpl
