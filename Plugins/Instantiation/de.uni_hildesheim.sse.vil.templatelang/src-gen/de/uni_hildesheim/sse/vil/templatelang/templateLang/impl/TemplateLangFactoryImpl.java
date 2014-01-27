/**
 * <copyright>
 * </copyright>
 *

 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang.impl;

import de.uni_hildesheim.sse.vil.templatelang.templateLang.*;

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
public class TemplateLangFactoryImpl extends EFactoryImpl implements TemplateLangFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TemplateLangFactory init()
  {
    try
    {
      TemplateLangFactory theTemplateLangFactory = (TemplateLangFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.uni_hildesheim.de/sse/vil/templatelang/TemplateLang"); 
      if (theTemplateLangFactory != null)
      {
        return theTemplateLangFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TemplateLangFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateLangFactoryImpl()
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
      case TemplateLangPackage.LANGUAGE_UNIT: return createLanguageUnit();
      case TemplateLangPackage.INDENTATION_HINT: return createIndentationHint();
      case TemplateLangPackage.INDENTATION_HINT_PART: return createIndentationHintPart();
      case TemplateLangPackage.VIL_DEF: return createVilDef();
      case TemplateLangPackage.STMT_BLOCK: return createStmtBlock();
      case TemplateLangPackage.STMT: return createStmt();
      case TemplateLangPackage.ALTERNATIVE: return createAlternative();
      case TemplateLangPackage.CONTENT: return createContent();
      case TemplateLangPackage.SWITCH: return createSwitch();
      case TemplateLangPackage.SWITCH_PART: return createSwitchPart();
      case TemplateLangPackage.LOOP: return createLoop();
      case TemplateLangPackage.MULTISELECT: return createmultiselect();
      case TemplateLangPackage.GENERIC_MULTISELECT: return creategenericMultiselect();
      case TemplateLangPackage.MULTI_SELECT_PART: return createmultiSelectPart();
      case TemplateLangPackage.USER_MULTISELECT: return createuserMultiselect();
      case TemplateLangPackage.EXTENSION: return createExtension();
      case TemplateLangPackage.JAVA_QUALIFIED_NAME: return createJavaQualifiedName();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
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
  public IndentationHint createIndentationHint()
  {
    IndentationHintImpl indentationHint = new IndentationHintImpl();
    return indentationHint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndentationHintPart createIndentationHintPart()
  {
    IndentationHintPartImpl indentationHintPart = new IndentationHintPartImpl();
    return indentationHintPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VilDef createVilDef()
  {
    VilDefImpl vilDef = new VilDefImpl();
    return vilDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StmtBlock createStmtBlock()
  {
    StmtBlockImpl stmtBlock = new StmtBlockImpl();
    return stmtBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Stmt createStmt()
  {
    StmtImpl stmt = new StmtImpl();
    return stmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Alternative createAlternative()
  {
    AlternativeImpl alternative = new AlternativeImpl();
    return alternative;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Content createContent()
  {
    ContentImpl content = new ContentImpl();
    return content;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Switch createSwitch()
  {
    SwitchImpl switch_ = new SwitchImpl();
    return switch_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SwitchPart createSwitchPart()
  {
    SwitchPartImpl switchPart = new SwitchPartImpl();
    return switchPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Loop createLoop()
  {
    LoopImpl loop = new LoopImpl();
    return loop;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public multiselect createmultiselect()
  {
    multiselectImpl multiselect = new multiselectImpl();
    return multiselect;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public genericMultiselect creategenericMultiselect()
  {
    genericMultiselectImpl genericMultiselect = new genericMultiselectImpl();
    return genericMultiselect;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public multiSelectPart createmultiSelectPart()
  {
    multiSelectPartImpl multiSelectPart = new multiSelectPartImpl();
    return multiSelectPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public userMultiselect createuserMultiselect()
  {
    userMultiselectImpl userMultiselect = new userMultiselectImpl();
    return userMultiselect;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Extension createExtension()
  {
    ExtensionImpl extension = new ExtensionImpl();
    return extension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaQualifiedName createJavaQualifiedName()
  {
    JavaQualifiedNameImpl javaQualifiedName = new JavaQualifiedNameImpl();
    return javaQualifiedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TemplateLangPackage getTemplateLangPackage()
  {
    return (TemplateLangPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TemplateLangPackage getPackage()
  {
    return TemplateLangPackage.eINSTANCE;
  }

} //TemplateLangFactoryImpl
