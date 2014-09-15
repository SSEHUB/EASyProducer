/**
 */
package de.uni_hildesheim.sse.vil.expressions.expressionDsl.impl;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.*;

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
public class ExpressionDslFactoryImpl extends EFactoryImpl implements ExpressionDslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ExpressionDslFactory init()
  {
    try
    {
      ExpressionDslFactory theExpressionDslFactory = (ExpressionDslFactory)EPackage.Registry.INSTANCE.getEFactory(ExpressionDslPackage.eNS_URI);
      if (theExpressionDslFactory != null)
      {
        return theExpressionDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ExpressionDslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionDslFactoryImpl()
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
      case ExpressionDslPackage.LANGUAGE_UNIT: return createLanguageUnit();
      case ExpressionDslPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
      case ExpressionDslPackage.ADVICE: return createAdvice();
      case ExpressionDslPackage.VERSION_SPEC: return createVersionSpec();
      case ExpressionDslPackage.VERSIONED_ID: return createVersionedId();
      case ExpressionDslPackage.PARAMETER_LIST: return createParameterList();
      case ExpressionDslPackage.PARAMETER: return createParameter();
      case ExpressionDslPackage.VERSION_STMT: return createVersionStmt();
      case ExpressionDslPackage.IMPORT: return createImport();
      case ExpressionDslPackage.EXPRESSION_STATEMENT: return createExpressionStatement();
      case ExpressionDslPackage.EXPRESSION: return createExpression();
      case ExpressionDslPackage.LOGICAL_EXPRESSION: return createLogicalExpression();
      case ExpressionDslPackage.LOGICAL_EXPRESSION_PART: return createLogicalExpressionPart();
      case ExpressionDslPackage.EQUALITY_EXPRESSION: return createEqualityExpression();
      case ExpressionDslPackage.EQUALITY_EXPRESSION_PART: return createEqualityExpressionPart();
      case ExpressionDslPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
      case ExpressionDslPackage.RELATIONAL_EXPRESSION_PART: return createRelationalExpressionPart();
      case ExpressionDslPackage.ADDITIVE_EXPRESSION: return createAdditiveExpression();
      case ExpressionDslPackage.ADDITIVE_EXPRESSION_PART: return createAdditiveExpressionPart();
      case ExpressionDslPackage.MULTIPLICATIVE_EXPRESSION: return createMultiplicativeExpression();
      case ExpressionDslPackage.MULTIPLICATIVE_EXPRESSION_PART: return createMultiplicativeExpressionPart();
      case ExpressionDslPackage.UNARY_EXPRESSION: return createUnaryExpression();
      case ExpressionDslPackage.POSTFIX_EXPRESSION: return createPostfixExpression();
      case ExpressionDslPackage.PRIMARY_EXPRESSION: return createPrimaryExpression();
      case ExpressionDslPackage.EXPRESSION_OR_QUALIFIED_EXECUTION: return createExpressionOrQualifiedExecution();
      case ExpressionDslPackage.UNQUALIFIED_EXECUTION: return createUnqualifiedExecution();
      case ExpressionDslPackage.SUPER_EXECUTION: return createSuperExecution();
      case ExpressionDslPackage.CONSTRUCTOR_EXECUTION: return createConstructorExecution();
      case ExpressionDslPackage.SUB_CALL: return createSubCall();
      case ExpressionDslPackage.DECLARATOR: return createDeclarator();
      case ExpressionDslPackage.DECLARATION: return createDeclaration();
      case ExpressionDslPackage.CALL: return createCall();
      case ExpressionDslPackage.ARGUMENT_LIST: return createArgumentList();
      case ExpressionDslPackage.NAMED_ARGUMENT: return createNamedArgument();
      case ExpressionDslPackage.QUALIFIED_PREFIX: return createQualifiedPrefix();
      case ExpressionDslPackage.QUALIFIED_NAME: return createQualifiedName();
      case ExpressionDslPackage.CONSTANT: return createConstant();
      case ExpressionDslPackage.NUM_VALUE: return createNumValue();
      case ExpressionDslPackage.TYPE: return createType();
      case ExpressionDslPackage.TYPE_PARAMETERS: return createTypeParameters();
      case ExpressionDslPackage.CONTAINER_INITIALIZER: return createContainerInitializer();
      case ExpressionDslPackage.CONTAINER_INITIALIZER_EXPRESSION: return createContainerInitializerExpression();
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
  public VariableDeclaration createVariableDeclaration()
  {
    VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
    return variableDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Advice createAdvice()
  {
    AdviceImpl advice = new AdviceImpl();
    return advice;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VersionSpec createVersionSpec()
  {
    VersionSpecImpl versionSpec = new VersionSpecImpl();
    return versionSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VersionedId createVersionedId()
  {
    VersionedIdImpl versionedId = new VersionedIdImpl();
    return versionedId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterList createParameterList()
  {
    ParameterListImpl parameterList = new ParameterListImpl();
    return parameterList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameter createParameter()
  {
    ParameterImpl parameter = new ParameterImpl();
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VersionStmt createVersionStmt()
  {
    VersionStmtImpl versionStmt = new VersionStmtImpl();
    return versionStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionStatement createExpressionStatement()
  {
    ExpressionStatementImpl expressionStatement = new ExpressionStatementImpl();
    return expressionStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalExpression createLogicalExpression()
  {
    LogicalExpressionImpl logicalExpression = new LogicalExpressionImpl();
    return logicalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalExpressionPart createLogicalExpressionPart()
  {
    LogicalExpressionPartImpl logicalExpressionPart = new LogicalExpressionPartImpl();
    return logicalExpressionPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityExpression createEqualityExpression()
  {
    EqualityExpressionImpl equalityExpression = new EqualityExpressionImpl();
    return equalityExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityExpressionPart createEqualityExpressionPart()
  {
    EqualityExpressionPartImpl equalityExpressionPart = new EqualityExpressionPartImpl();
    return equalityExpressionPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalExpression createRelationalExpression()
  {
    RelationalExpressionImpl relationalExpression = new RelationalExpressionImpl();
    return relationalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalExpressionPart createRelationalExpressionPart()
  {
    RelationalExpressionPartImpl relationalExpressionPart = new RelationalExpressionPartImpl();
    return relationalExpressionPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveExpression createAdditiveExpression()
  {
    AdditiveExpressionImpl additiveExpression = new AdditiveExpressionImpl();
    return additiveExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveExpressionPart createAdditiveExpressionPart()
  {
    AdditiveExpressionPartImpl additiveExpressionPart = new AdditiveExpressionPartImpl();
    return additiveExpressionPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeExpression createMultiplicativeExpression()
  {
    MultiplicativeExpressionImpl multiplicativeExpression = new MultiplicativeExpressionImpl();
    return multiplicativeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeExpressionPart createMultiplicativeExpressionPart()
  {
    MultiplicativeExpressionPartImpl multiplicativeExpressionPart = new MultiplicativeExpressionPartImpl();
    return multiplicativeExpressionPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryExpression createUnaryExpression()
  {
    UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
    return unaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PostfixExpression createPostfixExpression()
  {
    PostfixExpressionImpl postfixExpression = new PostfixExpressionImpl();
    return postfixExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryExpression createPrimaryExpression()
  {
    PrimaryExpressionImpl primaryExpression = new PrimaryExpressionImpl();
    return primaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionOrQualifiedExecution createExpressionOrQualifiedExecution()
  {
    ExpressionOrQualifiedExecutionImpl expressionOrQualifiedExecution = new ExpressionOrQualifiedExecutionImpl();
    return expressionOrQualifiedExecution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnqualifiedExecution createUnqualifiedExecution()
  {
    UnqualifiedExecutionImpl unqualifiedExecution = new UnqualifiedExecutionImpl();
    return unqualifiedExecution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuperExecution createSuperExecution()
  {
    SuperExecutionImpl superExecution = new SuperExecutionImpl();
    return superExecution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstructorExecution createConstructorExecution()
  {
    ConstructorExecutionImpl constructorExecution = new ConstructorExecutionImpl();
    return constructorExecution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubCall createSubCall()
  {
    SubCallImpl subCall = new SubCallImpl();
    return subCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Declarator createDeclarator()
  {
    DeclaratorImpl declarator = new DeclaratorImpl();
    return declarator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Declaration createDeclaration()
  {
    DeclarationImpl declaration = new DeclarationImpl();
    return declaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Call createCall()
  {
    CallImpl call = new CallImpl();
    return call;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArgumentList createArgumentList()
  {
    ArgumentListImpl argumentList = new ArgumentListImpl();
    return argumentList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedArgument createNamedArgument()
  {
    NamedArgumentImpl namedArgument = new NamedArgumentImpl();
    return namedArgument;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedPrefix createQualifiedPrefix()
  {
    QualifiedPrefixImpl qualifiedPrefix = new QualifiedPrefixImpl();
    return qualifiedPrefix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedName createQualifiedName()
  {
    QualifiedNameImpl qualifiedName = new QualifiedNameImpl();
    return qualifiedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constant createConstant()
  {
    ConstantImpl constant = new ConstantImpl();
    return constant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumValue createNumValue()
  {
    NumValueImpl numValue = new NumValueImpl();
    return numValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createType()
  {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeParameters createTypeParameters()
  {
    TypeParametersImpl typeParameters = new TypeParametersImpl();
    return typeParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContainerInitializer createContainerInitializer()
  {
    ContainerInitializerImpl containerInitializer = new ContainerInitializerImpl();
    return containerInitializer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContainerInitializerExpression createContainerInitializerExpression()
  {
    ContainerInitializerExpressionImpl containerInitializerExpression = new ContainerInitializerExpressionImpl();
    return containerInitializerExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionDslPackage getExpressionDslPackage()
  {
    return (ExpressionDslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ExpressionDslPackage getPackage()
  {
    return ExpressionDslPackage.eINSTANCE;
  }

} //ExpressionDslFactoryImpl
