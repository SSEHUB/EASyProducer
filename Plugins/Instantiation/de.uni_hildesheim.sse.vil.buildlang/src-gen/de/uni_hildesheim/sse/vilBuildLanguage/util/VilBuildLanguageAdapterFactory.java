/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage.util;

import de.uni_hildesheim.sse.vilBuildLanguage.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage
 * @generated
 */
public class VilBuildLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static VilBuildLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VilBuildLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = VilBuildLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VilBuildLanguageSwitch<Adapter> modelSwitch =
    new VilBuildLanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseImplementationUnit(ImplementationUnit object)
      {
        return createImplementationUnitAdapter();
      }
      @Override
      public Adapter caseRequire(Require object)
      {
        return createRequireAdapter();
      }
      @Override
      public Adapter caseLanguageUnit(LanguageUnit object)
      {
        return createLanguageUnitAdapter();
      }
      @Override
      public Adapter caseScriptParentDecl(ScriptParentDecl object)
      {
        return createScriptParentDeclAdapter();
      }
      @Override
      public Adapter caseLoadProperties(LoadProperties object)
      {
        return createLoadPropertiesAdapter();
      }
      @Override
      public Adapter caseScriptContents(ScriptContents object)
      {
        return createScriptContentsAdapter();
      }
      @Override
      public Adapter caseRuleDeclaration(RuleDeclaration object)
      {
        return createRuleDeclarationAdapter();
      }
      @Override
      public Adapter caseRuleElementBlock(RuleElementBlock object)
      {
        return createRuleElementBlockAdapter();
      }
      @Override
      public Adapter caseRuleElement(RuleElement object)
      {
        return createRuleElementAdapter();
      }
      @Override
      public Adapter caseRuleModifier(RuleModifier object)
      {
        return createRuleModifierAdapter();
      }
      @Override
      public Adapter caseDeferDeclaration(DeferDeclaration object)
      {
        return createDeferDeclarationAdapter();
      }
      @Override
      public Adapter casePrimaryExpression(PrimaryExpression object)
      {
        return createPrimaryExpressionAdapter();
      }
      @Override
      public Adapter caseInstantiate(Instantiate object)
      {
        return createInstantiateAdapter();
      }
      @Override
      public Adapter caseMap(Map object)
      {
        return createMapAdapter();
      }
      @Override
      public Adapter caseJoin(Join object)
      {
        return createJoinAdapter();
      }
      @Override
      public Adapter caseJoinVariable(JoinVariable object)
      {
        return createJoinVariableAdapter();
      }
      @Override
      public Adapter caseSystemExecution(SystemExecution object)
      {
        return createSystemExecutionAdapter();
      }
      @Override
      public Adapter caseExpressionDsl_LanguageUnit(de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit object)
      {
        return createExpressionDsl_LanguageUnitAdapter();
      }
      @Override
      public Adapter caseExpressionDsl_PrimaryExpression(de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression object)
      {
        return createExpressionDsl_PrimaryExpressionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit <em>Implementation Unit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit
   * @generated
   */
  public Adapter createImplementationUnitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.Require <em>Require</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Require
   * @generated
   */
  public Adapter createRequireAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit <em>Language Unit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit
   * @generated
   */
  public Adapter createLanguageUnitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.ScriptParentDecl <em>Script Parent Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.ScriptParentDecl
   * @generated
   */
  public Adapter createScriptParentDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.LoadProperties <em>Load Properties</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.LoadProperties
   * @generated
   */
  public Adapter createLoadPropertiesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.ScriptContents <em>Script Contents</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.ScriptContents
   * @generated
   */
  public Adapter createScriptContentsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration <em>Rule Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration
   * @generated
   */
  public Adapter createRuleDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElementBlock <em>Rule Element Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleElementBlock
   * @generated
   */
  public Adapter createRuleElementBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleElement <em>Rule Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleElement
   * @generated
   */
  public Adapter createRuleElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.RuleModifier <em>Rule Modifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.RuleModifier
   * @generated
   */
  public Adapter createRuleModifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.DeferDeclaration <em>Defer Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.DeferDeclaration
   * @generated
   */
  public Adapter createDeferDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.PrimaryExpression
   * @generated
   */
  public Adapter createPrimaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.Instantiate <em>Instantiate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Instantiate
   * @generated
   */
  public Adapter createInstantiateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.Map <em>Map</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Map
   * @generated
   */
  public Adapter createMapAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.Join <em>Join</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.Join
   * @generated
   */
  public Adapter createJoinAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable <em>Join Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.JoinVariable
   * @generated
   */
  public Adapter createJoinVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.SystemExecution <em>System Execution</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.SystemExecution
   * @generated
   */
  public Adapter createSystemExecutionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit <em>Language Unit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit
   * @generated
   */
  public Adapter createExpressionDsl_LanguageUnitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression
   * @generated
   */
  public Adapter createExpressionDsl_PrimaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //VilBuildLanguageAdapterFactory
