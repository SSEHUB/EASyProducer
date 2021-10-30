/**
 */
package de.uni_hildesheim.sse.vil.templatelang.templateLang;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage
 * @generated
 */
public interface TemplateLangFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TemplateLangFactory eINSTANCE = de.uni_hildesheim.sse.vil.templatelang.templateLang.impl.TemplateLangFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Language Unit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Language Unit</em>'.
   * @generated
   */
  LanguageUnit createLanguageUnit();

  /**
   * Returns a new object of class '<em>Top</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Top</em>'.
   * @generated
   */
  Top createTop();

  /**
   * Returns a new object of class '<em>Hinted Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Hinted Expression</em>'.
   * @generated
   */
  HintedExpression createHintedExpression();

  /**
   * Returns a new object of class '<em>Indentation Hint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Indentation Hint</em>'.
   * @generated
   */
  IndentationHint createIndentationHint();

  /**
   * Returns a new object of class '<em>Indentation Hint Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Indentation Hint Part</em>'.
   * @generated
   */
  IndentationHintPart createIndentationHintPart();

  /**
   * Returns a new object of class '<em>Formatting Hint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formatting Hint</em>'.
   * @generated
   */
  FormattingHint createFormattingHint();

  /**
   * Returns a new object of class '<em>Formatting Hint Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formatting Hint Part</em>'.
   * @generated
   */
  FormattingHintPart createFormattingHintPart();

  /**
   * Returns a new object of class '<em>Vil Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Vil Def</em>'.
   * @generated
   */
  VilDef createVilDef();

  /**
   * Returns a new object of class '<em>Stmt Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stmt Block</em>'.
   * @generated
   */
  StmtBlock createStmtBlock();

  /**
   * Returns a new object of class '<em>Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stmt</em>'.
   * @generated
   */
  Stmt createStmt();

  /**
   * Returns a new object of class '<em>Alternative</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Alternative</em>'.
   * @generated
   */
  Alternative createAlternative();

  /**
   * Returns a new object of class '<em>Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Content</em>'.
   * @generated
   */
  Content createContent();

  /**
   * Returns a new object of class '<em>Switch</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Switch</em>'.
   * @generated
   */
  Switch createSwitch();

  /**
   * Returns a new object of class '<em>Switch Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Switch Part</em>'.
   * @generated
   */
  SwitchPart createSwitchPart();

  /**
   * Returns a new object of class '<em>Loop</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Loop</em>'.
   * @generated
   */
  Loop createLoop();

  /**
   * Returns a new object of class '<em>While</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>While</em>'.
   * @generated
   */
  While createWhile();

  /**
   * Returns a new object of class '<em>multiselect</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>multiselect</em>'.
   * @generated
   */
  multiselect createmultiselect();

  /**
   * Returns a new object of class '<em>generic Multiselect</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>generic Multiselect</em>'.
   * @generated
   */
  genericMultiselect creategenericMultiselect();

  /**
   * Returns a new object of class '<em>multi Select Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>multi Select Part</em>'.
   * @generated
   */
  multiSelectPart createmultiSelectPart();

  /**
   * Returns a new object of class '<em>user Multiselect</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>user Multiselect</em>'.
   * @generated
   */
  userMultiselect createuserMultiselect();

  /**
   * Returns a new object of class '<em>Extension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extension</em>'.
   * @generated
   */
  Extension createExtension();

  /**
   * Returns a new object of class '<em>Java Qualified Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Java Qualified Name</em>'.
   * @generated
   */
  JavaQualifiedName createJavaQualifiedName();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TemplateLangPackage getTemplateLangPackage();

} //TemplateLangFactory
