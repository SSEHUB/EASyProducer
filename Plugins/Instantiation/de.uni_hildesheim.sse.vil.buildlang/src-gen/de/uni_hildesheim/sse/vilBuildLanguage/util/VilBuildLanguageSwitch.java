/**
 */
package de.uni_hildesheim.sse.vilBuildLanguage.util;

import de.uni_hildesheim.sse.vilBuildLanguage.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage
 * @generated
 */
public class VilBuildLanguageSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static VilBuildLanguagePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VilBuildLanguageSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = VilBuildLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case VilBuildLanguagePackage.IMPLEMENTATION_UNIT:
      {
        ImplementationUnit implementationUnit = (ImplementationUnit)theEObject;
        T result = caseImplementationUnit(implementationUnit);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.REQUIRE:
      {
        Require require = (Require)theEObject;
        T result = caseRequire(require);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.LANGUAGE_UNIT:
      {
        LanguageUnit languageUnit = (LanguageUnit)theEObject;
        T result = caseLanguageUnit(languageUnit);
        if (result == null) result = caseExpressionDsl_LanguageUnit(languageUnit);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.SCRIPT_PARENT_DECL:
      {
        ScriptParentDecl scriptParentDecl = (ScriptParentDecl)theEObject;
        T result = caseScriptParentDecl(scriptParentDecl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.LOAD_PROPERTIES:
      {
        LoadProperties loadProperties = (LoadProperties)theEObject;
        T result = caseLoadProperties(loadProperties);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.SCRIPT_CONTENTS:
      {
        ScriptContents scriptContents = (ScriptContents)theEObject;
        T result = caseScriptContents(scriptContents);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.RULE_DECLARATION:
      {
        RuleDeclaration ruleDeclaration = (RuleDeclaration)theEObject;
        T result = caseRuleDeclaration(ruleDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.RULE_CONDITIONS:
      {
        RuleConditions ruleConditions = (RuleConditions)theEObject;
        T result = caseRuleConditions(ruleConditions);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.RULE_ELEMENT_BLOCK:
      {
        RuleElementBlock ruleElementBlock = (RuleElementBlock)theEObject;
        T result = caseRuleElementBlock(ruleElementBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.RULE_ELEMENT:
      {
        RuleElement ruleElement = (RuleElement)theEObject;
        T result = caseRuleElement(ruleElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.RULE_MODIFIER:
      {
        RuleModifier ruleModifier = (RuleModifier)theEObject;
        T result = caseRuleModifier(ruleModifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.EXPRESSION_STATEMENT:
      {
        ExpressionStatement expressionStatement = (ExpressionStatement)theEObject;
        T result = caseExpressionStatement(expressionStatement);
        if (result == null) result = caseExpressionDsl_ExpressionStatement(expressionStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.PRIMARY_EXPRESSION:
      {
        PrimaryExpression primaryExpression = (PrimaryExpression)theEObject;
        T result = casePrimaryExpression(primaryExpression);
        if (result == null) result = caseExpressionDsl_PrimaryExpression(primaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.INSTANTIATE:
      {
        Instantiate instantiate = (Instantiate)theEObject;
        T result = caseInstantiate(instantiate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.LOOP_VARIABLE:
      {
        LoopVariable loopVariable = (LoopVariable)theEObject;
        T result = caseLoopVariable(loopVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.MAP:
      {
        Map map = (Map)theEObject;
        T result = caseMap(map);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.FOR:
      {
        For for_ = (For)theEObject;
        T result = caseFor(for_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.WHILE:
      {
        While while_ = (While)theEObject;
        T result = caseWhile(while_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.ALTERNATIVE:
      {
        Alternative alternative = (Alternative)theEObject;
        T result = caseAlternative(alternative);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.STATEMENT_OR_BLOCK:
      {
        StatementOrBlock statementOrBlock = (StatementOrBlock)theEObject;
        T result = caseStatementOrBlock(statementOrBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.JOIN:
      {
        Join join = (Join)theEObject;
        T result = caseJoin(join);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.JOIN_VARIABLE:
      {
        JoinVariable joinVariable = (JoinVariable)theEObject;
        T result = caseJoinVariable(joinVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VilBuildLanguagePackage.SYSTEM_EXECUTION:
      {
        SystemExecution systemExecution = (SystemExecution)theEObject;
        T result = caseSystemExecution(systemExecution);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Implementation Unit</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Implementation Unit</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImplementationUnit(ImplementationUnit object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Require</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Require</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequire(Require object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Language Unit</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Language Unit</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLanguageUnit(LanguageUnit object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Script Parent Decl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Script Parent Decl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScriptParentDecl(ScriptParentDecl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Load Properties</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Load Properties</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoadProperties(LoadProperties object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Script Contents</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Script Contents</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScriptContents(ScriptContents object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleDeclaration(RuleDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Conditions</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Conditions</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleConditions(RuleConditions object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Element Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Element Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleElementBlock(RuleElementBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleElement(RuleElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Modifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Modifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleModifier(RuleModifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionStatement(ExpressionStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimaryExpression(PrimaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instantiate</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instantiate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstantiate(Instantiate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Loop Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Loop Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoopVariable(LoopVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Map</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Map</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMap(Map object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>For</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>For</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFor(For object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>While</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>While</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhile(While object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Alternative</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Alternative</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlternative(Alternative object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statement Or Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statement Or Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatementOrBlock(StatementOrBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Join</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Join</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJoin(Join object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Join Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Join Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJoinVariable(JoinVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>System Execution</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>System Execution</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSystemExecution(SystemExecution object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Language Unit</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Language Unit</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionDsl_LanguageUnit(de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionDsl_ExpressionStatement(de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionDsl_PrimaryExpression(de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //VilBuildLanguageSwitch
