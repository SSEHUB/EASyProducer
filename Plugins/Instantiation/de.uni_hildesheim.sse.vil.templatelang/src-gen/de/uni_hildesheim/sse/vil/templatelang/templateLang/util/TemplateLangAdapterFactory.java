/**
 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang.util;

import de.uni_hildesheim.sse.vil.templatelang.templateLang.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage
 * @generated
 */
public class TemplateLangAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TemplateLangPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateLangAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = TemplateLangPackage.eINSTANCE;
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
  protected TemplateLangSwitch<Adapter> modelSwitch =
    new TemplateLangSwitch<Adapter>()
    {
      @Override
      public Adapter caseLanguageUnit(LanguageUnit object)
      {
        return createLanguageUnitAdapter();
      }
      @Override
      public Adapter caseIndentationHint(IndentationHint object)
      {
        return createIndentationHintAdapter();
      }
      @Override
      public Adapter caseIndentationHintPart(IndentationHintPart object)
      {
        return createIndentationHintPartAdapter();
      }
      @Override
      public Adapter caseFormattingHint(FormattingHint object)
      {
        return createFormattingHintAdapter();
      }
      @Override
      public Adapter caseFormattingHintPart(FormattingHintPart object)
      {
        return createFormattingHintPartAdapter();
      }
      @Override
      public Adapter caseVilDef(VilDef object)
      {
        return createVilDefAdapter();
      }
      @Override
      public Adapter caseStmtBlock(StmtBlock object)
      {
        return createStmtBlockAdapter();
      }
      @Override
      public Adapter caseStmt(Stmt object)
      {
        return createStmtAdapter();
      }
      @Override
      public Adapter caseAlternative(Alternative object)
      {
        return createAlternativeAdapter();
      }
      @Override
      public Adapter caseContent(Content object)
      {
        return createContentAdapter();
      }
      @Override
      public Adapter caseSwitch(Switch object)
      {
        return createSwitchAdapter();
      }
      @Override
      public Adapter caseSwitchPart(SwitchPart object)
      {
        return createSwitchPartAdapter();
      }
      @Override
      public Adapter caseLoop(Loop object)
      {
        return createLoopAdapter();
      }
      @Override
      public Adapter caseWhile(While object)
      {
        return createWhileAdapter();
      }
      @Override
      public Adapter casemultiselect(multiselect object)
      {
        return createmultiselectAdapter();
      }
      @Override
      public Adapter casegenericMultiselect(genericMultiselect object)
      {
        return creategenericMultiselectAdapter();
      }
      @Override
      public Adapter casemultiSelectPart(multiSelectPart object)
      {
        return createmultiSelectPartAdapter();
      }
      @Override
      public Adapter caseuserMultiselect(userMultiselect object)
      {
        return createuserMultiselectAdapter();
      }
      @Override
      public Adapter caseExtension(Extension object)
      {
        return createExtensionAdapter();
      }
      @Override
      public Adapter caseJavaQualifiedName(JavaQualifiedName object)
      {
        return createJavaQualifiedNameAdapter();
      }
      @Override
      public Adapter caseExpressionDsl_LanguageUnit(de.uni_hildesheim.sse.vil.expressions.expressionDsl.LanguageUnit object)
      {
        return createExpressionDsl_LanguageUnitAdapter();
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
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit <em>Language Unit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit
   * @generated
   */
  public Adapter createLanguageUnitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHint <em>Indentation Hint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHint
   * @generated
   */
  public Adapter createIndentationHintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHintPart <em>Indentation Hint Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.IndentationHintPart
   * @generated
   */
  public Adapter createIndentationHintPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.FormattingHint <em>Formatting Hint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.FormattingHint
   * @generated
   */
  public Adapter createFormattingHintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.FormattingHintPart <em>Formatting Hint Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.FormattingHintPart
   * @generated
   */
  public Adapter createFormattingHintPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef <em>Vil Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.VilDef
   * @generated
   */
  public Adapter createVilDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.StmtBlock <em>Stmt Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.StmtBlock
   * @generated
   */
  public Adapter createStmtBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt <em>Stmt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Stmt
   * @generated
   */
  public Adapter createStmtAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Alternative <em>Alternative</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Alternative
   * @generated
   */
  public Adapter createAlternativeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Content <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Content
   * @generated
   */
  public Adapter createContentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Switch <em>Switch</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Switch
   * @generated
   */
  public Adapter createSwitchAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.SwitchPart <em>Switch Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.SwitchPart
   * @generated
   */
  public Adapter createSwitchPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop <em>Loop</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Loop
   * @generated
   */
  public Adapter createLoopAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.While <em>While</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.While
   * @generated
   */
  public Adapter createWhileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.multiselect <em>multiselect</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.multiselect
   * @generated
   */
  public Adapter createmultiselectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect <em>generic Multiselect</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.genericMultiselect
   * @generated
   */
  public Adapter creategenericMultiselectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.multiSelectPart <em>multi Select Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.multiSelectPart
   * @generated
   */
  public Adapter createmultiSelectPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.userMultiselect <em>user Multiselect</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.userMultiselect
   * @generated
   */
  public Adapter createuserMultiselectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.Extension <em>Extension</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.Extension
   * @generated
   */
  public Adapter createExtensionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.vil.templatelang.templateLang.JavaQualifiedName <em>Java Qualified Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.JavaQualifiedName
   * @generated
   */
  public Adapter createJavaQualifiedNameAdapter()
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

} //TemplateLangAdapterFactory
