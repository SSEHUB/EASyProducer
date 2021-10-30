/**
 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang.util;

import de.uni_hildesheim.sse.vil.templatelang.templateLang.*;

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
 * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage
 * @generated
 */
public class TemplateLangSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TemplateLangPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateLangSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = TemplateLangPackage.eINSTANCE;
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
      case TemplateLangPackage.LANGUAGE_UNIT:
      {
        LanguageUnit languageUnit = (LanguageUnit)theEObject;
        T result = caseLanguageUnit(languageUnit);
        if (result == null) result = caseExpressionDsl_LanguageUnit(languageUnit);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.TOP:
      {
        Top top = (Top)theEObject;
        T result = caseTop(top);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.HINTED_EXPRESSION:
      {
        HintedExpression hintedExpression = (HintedExpression)theEObject;
        T result = caseHintedExpression(hintedExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.INDENTATION_HINT:
      {
        IndentationHint indentationHint = (IndentationHint)theEObject;
        T result = caseIndentationHint(indentationHint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.INDENTATION_HINT_PART:
      {
        IndentationHintPart indentationHintPart = (IndentationHintPart)theEObject;
        T result = caseIndentationHintPart(indentationHintPart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.FORMATTING_HINT:
      {
        FormattingHint formattingHint = (FormattingHint)theEObject;
        T result = caseFormattingHint(formattingHint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.FORMATTING_HINT_PART:
      {
        FormattingHintPart formattingHintPart = (FormattingHintPart)theEObject;
        T result = caseFormattingHintPart(formattingHintPart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.VIL_DEF:
      {
        VilDef vilDef = (VilDef)theEObject;
        T result = caseVilDef(vilDef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.STMT_BLOCK:
      {
        StmtBlock stmtBlock = (StmtBlock)theEObject;
        T result = caseStmtBlock(stmtBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.STMT:
      {
        Stmt stmt = (Stmt)theEObject;
        T result = caseStmt(stmt);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.ALTERNATIVE:
      {
        Alternative alternative = (Alternative)theEObject;
        T result = caseAlternative(alternative);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.CONTENT:
      {
        Content content = (Content)theEObject;
        T result = caseContent(content);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.SWITCH:
      {
        de.uni_hildesheim.sse.vil.templatelang.templateLang.Switch switch_ = (de.uni_hildesheim.sse.vil.templatelang.templateLang.Switch)theEObject;
        T result = caseSwitch(switch_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.SWITCH_PART:
      {
        SwitchPart switchPart = (SwitchPart)theEObject;
        T result = caseSwitchPart(switchPart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.LOOP:
      {
        Loop loop = (Loop)theEObject;
        T result = caseLoop(loop);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.WHILE:
      {
        While while_ = (While)theEObject;
        T result = caseWhile(while_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.MULTISELECT:
      {
        multiselect multiselect = (multiselect)theEObject;
        T result = casemultiselect(multiselect);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.GENERIC_MULTISELECT:
      {
        genericMultiselect genericMultiselect = (genericMultiselect)theEObject;
        T result = casegenericMultiselect(genericMultiselect);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.MULTI_SELECT_PART:
      {
        multiSelectPart multiSelectPart = (multiSelectPart)theEObject;
        T result = casemultiSelectPart(multiSelectPart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.USER_MULTISELECT:
      {
        userMultiselect userMultiselect = (userMultiselect)theEObject;
        T result = caseuserMultiselect(userMultiselect);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.EXTENSION:
      {
        Extension extension = (Extension)theEObject;
        T result = caseExtension(extension);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TemplateLangPackage.JAVA_QUALIFIED_NAME:
      {
        JavaQualifiedName javaQualifiedName = (JavaQualifiedName)theEObject;
        T result = caseJavaQualifiedName(javaQualifiedName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
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
   * Returns the result of interpreting the object as an instance of '<em>Top</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Top</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTop(Top object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Hinted Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Hinted Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHintedExpression(HintedExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Indentation Hint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Indentation Hint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIndentationHint(IndentationHint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Indentation Hint Part</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Indentation Hint Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIndentationHintPart(IndentationHintPart object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Formatting Hint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Formatting Hint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFormattingHint(FormattingHint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Formatting Hint Part</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Formatting Hint Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFormattingHintPart(FormattingHintPart object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Vil Def</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Vil Def</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVilDef(VilDef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Stmt Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Stmt Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStmtBlock(StmtBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Stmt</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Stmt</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStmt(Stmt object)
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
   * Returns the result of interpreting the object as an instance of '<em>Content</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Content</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContent(Content object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Switch</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Switch</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSwitch(de.uni_hildesheim.sse.vil.templatelang.templateLang.Switch object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Switch Part</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Switch Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSwitchPart(SwitchPart object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Loop</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Loop</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoop(Loop object)
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
   * Returns the result of interpreting the object as an instance of '<em>multiselect</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>multiselect</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casemultiselect(multiselect object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>generic Multiselect</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>generic Multiselect</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casegenericMultiselect(genericMultiselect object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>multi Select Part</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>multi Select Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casemultiSelectPart(multiSelectPart object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>user Multiselect</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>user Multiselect</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseuserMultiselect(userMultiselect object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Extension</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extension</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExtension(Extension object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Java Qualified Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Java Qualified Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJavaQualifiedName(JavaQualifiedName object)
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

} //TemplateLangSwitch
