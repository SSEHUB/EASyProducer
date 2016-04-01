/**
 */
package de.uni_hildesheim.sse.vil.rt.rtVil.impl;

import de.uni_hildesheim.sse.vil.rt.rtVil.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RtVilFactoryImpl extends EFactoryImpl implements RtVilFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RtVilFactory init()
  {
    try
    {
      RtVilFactory theRtVilFactory = (RtVilFactory)EPackage.Registry.INSTANCE.getEFactory(RtVilPackage.eNS_URI);
      if (theRtVilFactory != null)
      {
        return theRtVilFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new RtVilFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RtVilFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case RtVilPackage.IMPLEMENTATION_UNIT: return createImplementationUnit();
      case RtVilPackage.LANGUAGE_UNIT: return createLanguageUnit();
      case RtVilPackage.RT_CONTENTS: return creatertContents();
      case RtVilPackage.GLOBAL_VARIABLE_DECLARATION: return createGlobalVariableDeclaration();
      case RtVilPackage.STRATEGY_DECLARATION: return createStrategyDeclaration();
      case RtVilPackage.BREAKDOWN_ELEMENT: return createBreakdownElement();
      case RtVilPackage.WEIGHTING_STATEMENT: return createWeightingStatement();
      case RtVilPackage.BREAKDOWN_STATEMENT: return createBreakdownStatement();
      case RtVilPackage.BREAKDOWN_WITH_PART: return createBreakdownWithPart();
      case RtVilPackage.TACTIC_DECLARATION: return createTacticDeclaration();
      case RtVilPackage.RULE_ELEMENT_BLOCK: return createRuleElementBlock();
      case RtVilPackage.RULE_ELEMENT: return createRuleElement();
      case RtVilPackage.INTENT_DECLARATION: return createIntentDeclaration();
      case RtVilPackage.FAIL_STATEMENT: return createFailStatement();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImplementationUnit createImplementationUnit()
  {
    ImplementationUnitImpl implementationUnit = new ImplementationUnitImpl();
    return implementationUnit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LanguageUnit createLanguageUnit()
  {
    LanguageUnitImpl languageUnit = new LanguageUnitImpl();
    return languageUnit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public rtContents creatertContents()
  {
    rtContentsImpl rtContents = new rtContentsImpl();
    return rtContents;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GlobalVariableDeclaration createGlobalVariableDeclaration()
  {
    GlobalVariableDeclarationImpl globalVariableDeclaration = new GlobalVariableDeclarationImpl();
    return globalVariableDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StrategyDeclaration createStrategyDeclaration()
  {
    StrategyDeclarationImpl strategyDeclaration = new StrategyDeclarationImpl();
    return strategyDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BreakdownElement createBreakdownElement()
  {
    BreakdownElementImpl breakdownElement = new BreakdownElementImpl();
    return breakdownElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WeightingStatement createWeightingStatement()
  {
    WeightingStatementImpl weightingStatement = new WeightingStatementImpl();
    return weightingStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BreakdownStatement createBreakdownStatement()
  {
    BreakdownStatementImpl breakdownStatement = new BreakdownStatementImpl();
    return breakdownStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BreakdownWithPart createBreakdownWithPart()
  {
    BreakdownWithPartImpl breakdownWithPart = new BreakdownWithPartImpl();
    return breakdownWithPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TacticDeclaration createTacticDeclaration()
  {
    TacticDeclarationImpl tacticDeclaration = new TacticDeclarationImpl();
    return tacticDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleElementBlock createRuleElementBlock()
  {
    RuleElementBlockImpl ruleElementBlock = new RuleElementBlockImpl();
    return ruleElementBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleElement createRuleElement()
  {
    RuleElementImpl ruleElement = new RuleElementImpl();
    return ruleElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntentDeclaration createIntentDeclaration()
  {
    IntentDeclarationImpl intentDeclaration = new IntentDeclarationImpl();
    return intentDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FailStatement createFailStatement()
  {
    FailStatementImpl failStatement = new FailStatementImpl();
    return failStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RtVilPackage getRtVilPackage()
  {
    return (RtVilPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static RtVilPackage getPackage()
  {
    return RtVilPackage.eINSTANCE;
  }

} //RtVilFactoryImpl
