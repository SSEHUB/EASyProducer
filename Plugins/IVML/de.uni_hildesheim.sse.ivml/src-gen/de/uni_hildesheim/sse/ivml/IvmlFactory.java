/**
 */
package de.uni_hildesheim.sse.ivml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage
 * @generated
 */
public interface IvmlFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  IvmlFactory eINSTANCE = de.uni_hildesheim.sse.ivml.impl.IvmlFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Variability Unit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variability Unit</em>'.
   * @generated
   */
  VariabilityUnit createVariabilityUnit();

  /**
   * Returns a new object of class '<em>Project</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Project</em>'.
   * @generated
   */
  Project createProject();

  /**
   * Returns a new object of class '<em>Project Contents</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Project Contents</em>'.
   * @generated
   */
  ProjectContents createProjectContents();

  /**
   * Returns a new object of class '<em>Typedef</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Typedef</em>'.
   * @generated
   */
  Typedef createTypedef();

  /**
   * Returns a new object of class '<em>Typedef Enum</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Typedef Enum</em>'.
   * @generated
   */
  TypedefEnum createTypedefEnum();

  /**
   * Returns a new object of class '<em>Typedef Enum Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Typedef Enum Literal</em>'.
   * @generated
   */
  TypedefEnumLiteral createTypedefEnumLiteral();

  /**
   * Returns a new object of class '<em>Typedef Compound</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Typedef Compound</em>'.
   * @generated
   */
  TypedefCompound createTypedefCompound();

  /**
   * Returns a new object of class '<em>Attr Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attr Assignment</em>'.
   * @generated
   */
  AttrAssignment createAttrAssignment();

  /**
   * Returns a new object of class '<em>Attr Assignment Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attr Assignment Part</em>'.
   * @generated
   */
  AttrAssignmentPart createAttrAssignmentPart();

  /**
   * Returns a new object of class '<em>Typedef Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Typedef Mapping</em>'.
   * @generated
   */
  TypedefMapping createTypedefMapping();

  /**
   * Returns a new object of class '<em>Typedef Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Typedef Constraint</em>'.
   * @generated
   */
  TypedefConstraint createTypedefConstraint();

  /**
   * Returns a new object of class '<em>Variable Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Declaration</em>'.
   * @generated
   */
  VariableDeclaration createVariableDeclaration();

  /**
   * Returns a new object of class '<em>Variable Declaration Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Declaration Part</em>'.
   * @generated
   */
  VariableDeclarationPart createVariableDeclarationPart();

  /**
   * Returns a new object of class '<em>Basic Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Basic Type</em>'.
   * @generated
   */
  BasicType createBasicType();

  /**
   * Returns a new object of class '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type</em>'.
   * @generated
   */
  Type createType();

  /**
   * Returns a new object of class '<em>Num Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Num Value</em>'.
   * @generated
   */
  NumValue createNumValue();

  /**
   * Returns a new object of class '<em>Qualified Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified Name</em>'.
   * @generated
   */
  QualifiedName createQualifiedName();

  /**
   * Returns a new object of class '<em>Access Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Access Name</em>'.
   * @generated
   */
  AccessName createAccessName();

  /**
   * Returns a new object of class '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value</em>'.
   * @generated
   */
  Value createValue();

  /**
   * Returns a new object of class '<em>Derived Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Derived Type</em>'.
   * @generated
   */
  DerivedType createDerivedType();

  /**
   * Returns a new object of class '<em>Annotate To</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotate To</em>'.
   * @generated
   */
  AnnotateTo createAnnotateTo();

  /**
   * Returns a new object of class '<em>Freeze</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Freeze</em>'.
   * @generated
   */
  Freeze createFreeze();

  /**
   * Returns a new object of class '<em>Freeze Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Freeze Statement</em>'.
   * @generated
   */
  FreezeStatement createFreezeStatement();

  /**
   * Returns a new object of class '<em>Eval</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Eval</em>'.
   * @generated
   */
  Eval createEval();

  /**
   * Returns a new object of class '<em>Interface Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Interface Declaration</em>'.
   * @generated
   */
  InterfaceDeclaration createInterfaceDeclaration();

  /**
   * Returns a new object of class '<em>Export</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Export</em>'.
   * @generated
   */
  Export createExport();

  /**
   * Returns a new object of class '<em>Import Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import Stmt</em>'.
   * @generated
   */
  ImportStmt createImportStmt();

  /**
   * Returns a new object of class '<em>Conflict Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conflict Stmt</em>'.
   * @generated
   */
  ConflictStmt createConflictStmt();

  /**
   * Returns a new object of class '<em>Version Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Version Stmt</em>'.
   * @generated
   */
  VersionStmt createVersionStmt();

  /**
   * Returns a new object of class '<em>Op Def Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Op Def Statement</em>'.
   * @generated
   */
  OpDefStatement createOpDefStatement();

  /**
   * Returns a new object of class '<em>Op Def Parameter List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Op Def Parameter List</em>'.
   * @generated
   */
  OpDefParameterList createOpDefParameterList();

  /**
   * Returns a new object of class '<em>Op Def Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Op Def Parameter</em>'.
   * @generated
   */
  OpDefParameter createOpDefParameter();

  /**
   * Returns a new object of class '<em>Expression Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Statement</em>'.
   * @generated
   */
  ExpressionStatement createExpressionStatement();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Let Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Let Expression</em>'.
   * @generated
   */
  LetExpression createLetExpression();

  /**
   * Returns a new object of class '<em>Opt Block Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Opt Block Expression</em>'.
   * @generated
   */
  OptBlockExpression createOptBlockExpression();

  /**
   * Returns a new object of class '<em>Block Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Block Expression</em>'.
   * @generated
   */
  BlockExpression createBlockExpression();

  /**
   * Returns a new object of class '<em>Assignment Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment Expression</em>'.
   * @generated
   */
  AssignmentExpression createAssignmentExpression();

  /**
   * Returns a new object of class '<em>Assignment Expression Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment Expression Part</em>'.
   * @generated
   */
  AssignmentExpressionPart createAssignmentExpressionPart();

  /**
   * Returns a new object of class '<em>Implication Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Implication Expression</em>'.
   * @generated
   */
  ImplicationExpression createImplicationExpression();

  /**
   * Returns a new object of class '<em>Implication Expression Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Implication Expression Part</em>'.
   * @generated
   */
  ImplicationExpressionPart createImplicationExpressionPart();

  /**
   * Returns a new object of class '<em>Logical Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical Expression</em>'.
   * @generated
   */
  LogicalExpression createLogicalExpression();

  /**
   * Returns a new object of class '<em>Logical Expression Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical Expression Part</em>'.
   * @generated
   */
  LogicalExpressionPart createLogicalExpressionPart();

  /**
   * Returns a new object of class '<em>Equality Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equality Expression</em>'.
   * @generated
   */
  EqualityExpression createEqualityExpression();

  /**
   * Returns a new object of class '<em>Equality Expression Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equality Expression Part</em>'.
   * @generated
   */
  EqualityExpressionPart createEqualityExpressionPart();

  /**
   * Returns a new object of class '<em>Relational Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relational Expression</em>'.
   * @generated
   */
  RelationalExpression createRelationalExpression();

  /**
   * Returns a new object of class '<em>Relational Expression Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relational Expression Part</em>'.
   * @generated
   */
  RelationalExpressionPart createRelationalExpressionPart();

  /**
   * Returns a new object of class '<em>Additive Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Additive Expression</em>'.
   * @generated
   */
  AdditiveExpression createAdditiveExpression();

  /**
   * Returns a new object of class '<em>Additive Expression Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Additive Expression Part</em>'.
   * @generated
   */
  AdditiveExpressionPart createAdditiveExpressionPart();

  /**
   * Returns a new object of class '<em>Multiplicative Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicative Expression</em>'.
   * @generated
   */
  MultiplicativeExpression createMultiplicativeExpression();

  /**
   * Returns a new object of class '<em>Multiplicative Expression Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicative Expression Part</em>'.
   * @generated
   */
  MultiplicativeExpressionPart createMultiplicativeExpressionPart();

  /**
   * Returns a new object of class '<em>Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Expression</em>'.
   * @generated
   */
  UnaryExpression createUnaryExpression();

  /**
   * Returns a new object of class '<em>Postfix Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postfix Expression</em>'.
   * @generated
   */
  PostfixExpression createPostfixExpression();

  /**
   * Returns a new object of class '<em>Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Call</em>'.
   * @generated
   */
  Call createCall();

  /**
   * Returns a new object of class '<em>Feature Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Feature Call</em>'.
   * @generated
   */
  FeatureCall createFeatureCall();

  /**
   * Returns a new object of class '<em>Container Op</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Container Op</em>'.
   * @generated
   */
  ContainerOp createContainerOp();

  /**
   * Returns a new object of class '<em>Declarator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Declarator</em>'.
   * @generated
   */
  Declarator createDeclarator();

  /**
   * Returns a new object of class '<em>Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Declaration</em>'.
   * @generated
   */
  Declaration createDeclaration();

  /**
   * Returns a new object of class '<em>Actual Argument List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actual Argument List</em>'.
   * @generated
   */
  ActualArgumentList createActualArgumentList();

  /**
   * Returns a new object of class '<em>Actual Argument</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actual Argument</em>'.
   * @generated
   */
  ActualArgument createActualArgument();

  /**
   * Returns a new object of class '<em>Expression Access</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Access</em>'.
   * @generated
   */
  ExpressionAccess createExpressionAccess();

  /**
   * Returns a new object of class '<em>Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primary Expression</em>'.
   * @generated
   */
  PrimaryExpression createPrimaryExpression();

  /**
   * Returns a new object of class '<em>Container Initializer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Container Initializer</em>'.
   * @generated
   */
  ContainerInitializer createContainerInitializer();

  /**
   * Returns a new object of class '<em>Expression List Or Range</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression List Or Range</em>'.
   * @generated
   */
  ExpressionListOrRange createExpressionListOrRange();

  /**
   * Returns a new object of class '<em>Expression List Entry</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression List Entry</em>'.
   * @generated
   */
  ExpressionListEntry createExpressionListEntry();

  /**
   * Returns a new object of class '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal</em>'.
   * @generated
   */
  Literal createLiteral();

  /**
   * Returns a new object of class '<em>If Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Expression</em>'.
   * @generated
   */
  IfExpression createIfExpression();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  IvmlPackage getIvmlPackage();

} //IvmlFactory
