/**
 */
package de.uni_hildesheim.sse.vil.rt.rtVil.util;

import de.uni_hildesheim.sse.vil.rt.rtVil.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.uni_hildesheim.sse.vil.rt.rtVil.RtVilPackage
 * @generated
 */
public class RtVilAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static RtVilPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RtVilAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = RtVilPackage.eINSTANCE;
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
  protected RtVilSwitch<Adapter> modelSwitch =
    new RtVilSwitch<Adapter>()
    {
      @Override
      public Adapter caseImplementationUnit(ImplementationUnit object)
      {
        return createImplementationUnitAdapter();
      }
      @Override
      public Adapter caseLanguageUnit(LanguageUnit object)
      {
        return createLanguageUnitAdapter();
      }
      @Override
      public Adapter casertContents(rtContents object)
      {
        return creatertContentsAdapter();
      }
      @Override
      public Adapter caseGlobalVariableDeclaration(GlobalVariableDeclaration object)
      {
        return createGlobalVariableDeclarationAdapter();
      }
      @Override
      public Adapter caseStrategyDeclaration(StrategyDeclaration object)
      {
        return createStrategyDeclarationAdapter();
      }
      @Override
      public Adapter caseBreakdownElement(BreakdownElement object)
      {
        return createBreakdownElementAdapter();
      }
      @Override
      public Adapter caseWeightingStatement(WeightingStatement object)
      {
        return createWeightingStatementAdapter();
      }
      @Override
      public Adapter caseBreakdownStatement(BreakdownStatement object)
      {
        return createBreakdownStatementAdapter();
      }
      @Override
      public Adapter caseBreakdownWithPart(BreakdownWithPart object)
      {
        return createBreakdownWithPartAdapter();
      }
      @Override
      public Adapter caseTacticDeclaration(TacticDeclaration object)
      {
        return createTacticDeclarationAdapter();
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
      public Adapter caseIntentDeclaration(IntentDeclaration object)
      {
        return createIntentDeclarationAdapter();
      }
      @Override
      public Adapter caseFailStatement(FailStatement object)
      {
        return createFailStatementAdapter();
      }
      @Override
      public Adapter caseVilBuildLanguage_ImplementationUnit(de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit object)
      {
        return createVilBuildLanguage_ImplementationUnitAdapter();
      }
      @Override
      public Adapter caseExpressionDsl_LanguageUnit(de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit object)
      {
        return createExpressionDsl_LanguageUnitAdapter();
      }
      @Override
      public Adapter caseVilBuildLanguage_LanguageUnit(de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit object)
      {
        return createVilBuildLanguage_LanguageUnitAdapter();
      }
      @Override
      public Adapter caseVilBuildLanguage_RuleElementBlock(de.uni_hildesheim.sse.vilBuildLanguage.RuleElementBlock object)
      {
        return createVilBuildLanguage_RuleElementBlockAdapter();
      }
      @Override
      public Adapter caseVilBuildLanguage_RuleElement(de.uni_hildesheim.sse.vilBuildLanguage.RuleElement object)
      {
        return createVilBuildLanguage_RuleElementAdapter();
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
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.ImplementationUnit <em>Implementation Unit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.ImplementationUnit
   * @generated
   */
  public Adapter createImplementationUnitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.LanguageUnit <em>Language Unit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.LanguageUnit
   * @generated
   */
  public Adapter createLanguageUnitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.rtContents <em>rt Contents</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.rtContents
   * @generated
   */
  public Adapter creatertContentsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.GlobalVariableDeclaration <em>Global Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.GlobalVariableDeclaration
   * @generated
   */
  public Adapter createGlobalVariableDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration <em>Strategy Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration
   * @generated
   */
  public Adapter createStrategyDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement <em>Breakdown Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownElement
   * @generated
   */
  public Adapter createBreakdownElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.WeightingStatement <em>Weighting Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.WeightingStatement
   * @generated
   */
  public Adapter createWeightingStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement <em>Breakdown Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownStatement
   * @generated
   */
  public Adapter createBreakdownStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownWithPart <em>Breakdown With Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.BreakdownWithPart
   * @generated
   */
  public Adapter createBreakdownWithPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration <em>Tactic Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration
   * @generated
   */
  public Adapter createTacticDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.RuleElementBlock <em>Rule Element Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RuleElementBlock
   * @generated
   */
  public Adapter createRuleElementBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.RuleElement <em>Rule Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.RuleElement
   * @generated
   */
  public Adapter createRuleElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.IntentDeclaration <em>Intent Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.IntentDeclaration
   * @generated
   */
  public Adapter createIntentDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.rt.rtVil.FailStatement <em>Fail Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.rt.rtVil.FailStatement
   * @generated
   */
  public Adapter createFailStatementAdapter()
  {
    return null;
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
  public Adapter createVilBuildLanguage_ImplementationUnitAdapter()
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
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit <em>Language Unit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit
   * @generated
   */
  public Adapter createVilBuildLanguage_LanguageUnitAdapter()
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
  public Adapter createVilBuildLanguage_RuleElementBlockAdapter()
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
  public Adapter createVilBuildLanguage_RuleElementAdapter()
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

} //RtVilAdapterFactory
