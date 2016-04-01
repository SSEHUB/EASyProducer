/**
 */
package de.uni_hildesheim.sse.ivml.util;

import de.uni_hildesheim.sse.ivml.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.uni_hildesheim.sse.ivml.IvmlPackage
 * @generated
 */
public class IvmlAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static IvmlPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IvmlAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = IvmlPackage.eINSTANCE;
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
  protected IvmlSwitch<Adapter> modelSwitch =
    new IvmlSwitch<Adapter>()
    {
      @Override
      public Adapter caseVariabilityUnit(VariabilityUnit object)
      {
        return createVariabilityUnitAdapter();
      }
      @Override
      public Adapter caseProject(Project object)
      {
        return createProjectAdapter();
      }
      @Override
      public Adapter caseProjectContents(ProjectContents object)
      {
        return createProjectContentsAdapter();
      }
      @Override
      public Adapter caseTypedef(Typedef object)
      {
        return createTypedefAdapter();
      }
      @Override
      public Adapter caseTypedefEnum(TypedefEnum object)
      {
        return createTypedefEnumAdapter();
      }
      @Override
      public Adapter caseTypedefEnumLiteral(TypedefEnumLiteral object)
      {
        return createTypedefEnumLiteralAdapter();
      }
      @Override
      public Adapter caseTypedefCompound(TypedefCompound object)
      {
        return createTypedefCompoundAdapter();
      }
      @Override
      public Adapter caseAttrAssignment(AttrAssignment object)
      {
        return createAttrAssignmentAdapter();
      }
      @Override
      public Adapter caseAttrAssignmentPart(AttrAssignmentPart object)
      {
        return createAttrAssignmentPartAdapter();
      }
      @Override
      public Adapter caseTypedefMapping(TypedefMapping object)
      {
        return createTypedefMappingAdapter();
      }
      @Override
      public Adapter caseTypedefConstraint(TypedefConstraint object)
      {
        return createTypedefConstraintAdapter();
      }
      @Override
      public Adapter caseVariableDeclaration(VariableDeclaration object)
      {
        return createVariableDeclarationAdapter();
      }
      @Override
      public Adapter caseVariableDeclarationPart(VariableDeclarationPart object)
      {
        return createVariableDeclarationPartAdapter();
      }
      @Override
      public Adapter caseBasicType(BasicType object)
      {
        return createBasicTypeAdapter();
      }
      @Override
      public Adapter caseType(Type object)
      {
        return createTypeAdapter();
      }
      @Override
      public Adapter caseNumValue(NumValue object)
      {
        return createNumValueAdapter();
      }
      @Override
      public Adapter caseQualifiedName(QualifiedName object)
      {
        return createQualifiedNameAdapter();
      }
      @Override
      public Adapter caseAccessName(AccessName object)
      {
        return createAccessNameAdapter();
      }
      @Override
      public Adapter caseValue(Value object)
      {
        return createValueAdapter();
      }
      @Override
      public Adapter caseDerivedType(DerivedType object)
      {
        return createDerivedTypeAdapter();
      }
      @Override
      public Adapter caseAnnotateTo(AnnotateTo object)
      {
        return createAnnotateToAdapter();
      }
      @Override
      public Adapter caseFreeze(Freeze object)
      {
        return createFreezeAdapter();
      }
      @Override
      public Adapter caseFreezeStatement(FreezeStatement object)
      {
        return createFreezeStatementAdapter();
      }
      @Override
      public Adapter caseEval(Eval object)
      {
        return createEvalAdapter();
      }
      @Override
      public Adapter caseInterfaceDeclaration(InterfaceDeclaration object)
      {
        return createInterfaceDeclarationAdapter();
      }
      @Override
      public Adapter caseExport(Export object)
      {
        return createExportAdapter();
      }
      @Override
      public Adapter caseImportStmt(ImportStmt object)
      {
        return createImportStmtAdapter();
      }
      @Override
      public Adapter caseConflictStmt(ConflictStmt object)
      {
        return createConflictStmtAdapter();
      }
      @Override
      public Adapter caseVersionStmt(VersionStmt object)
      {
        return createVersionStmtAdapter();
      }
      @Override
      public Adapter caseOpDefStatement(OpDefStatement object)
      {
        return createOpDefStatementAdapter();
      }
      @Override
      public Adapter caseOpDefParameterList(OpDefParameterList object)
      {
        return createOpDefParameterListAdapter();
      }
      @Override
      public Adapter caseOpDefParameter(OpDefParameter object)
      {
        return createOpDefParameterAdapter();
      }
      @Override
      public Adapter caseExpressionStatement(ExpressionStatement object)
      {
        return createExpressionStatementAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseLetExpression(LetExpression object)
      {
        return createLetExpressionAdapter();
      }
      @Override
      public Adapter caseAssignmentExpression(AssignmentExpression object)
      {
        return createAssignmentExpressionAdapter();
      }
      @Override
      public Adapter caseAssignmentExpressionPart(AssignmentExpressionPart object)
      {
        return createAssignmentExpressionPartAdapter();
      }
      @Override
      public Adapter caseImplicationExpression(ImplicationExpression object)
      {
        return createImplicationExpressionAdapter();
      }
      @Override
      public Adapter caseImplicationExpressionPart(ImplicationExpressionPart object)
      {
        return createImplicationExpressionPartAdapter();
      }
      @Override
      public Adapter caseLogicalExpression(LogicalExpression object)
      {
        return createLogicalExpressionAdapter();
      }
      @Override
      public Adapter caseLogicalExpressionPart(LogicalExpressionPart object)
      {
        return createLogicalExpressionPartAdapter();
      }
      @Override
      public Adapter caseEqualityExpression(EqualityExpression object)
      {
        return createEqualityExpressionAdapter();
      }
      @Override
      public Adapter caseEqualityExpressionPart(EqualityExpressionPart object)
      {
        return createEqualityExpressionPartAdapter();
      }
      @Override
      public Adapter caseRelationalExpression(RelationalExpression object)
      {
        return createRelationalExpressionAdapter();
      }
      @Override
      public Adapter caseRelationalExpressionPart(RelationalExpressionPart object)
      {
        return createRelationalExpressionPartAdapter();
      }
      @Override
      public Adapter caseAdditiveExpression(AdditiveExpression object)
      {
        return createAdditiveExpressionAdapter();
      }
      @Override
      public Adapter caseAdditiveExpressionPart(AdditiveExpressionPart object)
      {
        return createAdditiveExpressionPartAdapter();
      }
      @Override
      public Adapter caseMultiplicativeExpression(MultiplicativeExpression object)
      {
        return createMultiplicativeExpressionAdapter();
      }
      @Override
      public Adapter caseMultiplicativeExpressionPart(MultiplicativeExpressionPart object)
      {
        return createMultiplicativeExpressionPartAdapter();
      }
      @Override
      public Adapter caseUnaryExpression(UnaryExpression object)
      {
        return createUnaryExpressionAdapter();
      }
      @Override
      public Adapter casePostfixExpression(PostfixExpression object)
      {
        return createPostfixExpressionAdapter();
      }
      @Override
      public Adapter caseCall(Call object)
      {
        return createCallAdapter();
      }
      @Override
      public Adapter caseFeatureCall(FeatureCall object)
      {
        return createFeatureCallAdapter();
      }
      @Override
      public Adapter caseSetOp(SetOp object)
      {
        return createSetOpAdapter();
      }
      @Override
      public Adapter caseDeclarator(Declarator object)
      {
        return createDeclaratorAdapter();
      }
      @Override
      public Adapter caseDeclaration(Declaration object)
      {
        return createDeclarationAdapter();
      }
      @Override
      public Adapter caseActualParameterList(ActualParameterList object)
      {
        return createActualParameterListAdapter();
      }
      @Override
      public Adapter caseExpressionAccess(ExpressionAccess object)
      {
        return createExpressionAccessAdapter();
      }
      @Override
      public Adapter casePrimaryExpression(PrimaryExpression object)
      {
        return createPrimaryExpressionAdapter();
      }
      @Override
      public Adapter caseCollectionInitializer(CollectionInitializer object)
      {
        return createCollectionInitializerAdapter();
      }
      @Override
      public Adapter caseExpressionListOrRange(ExpressionListOrRange object)
      {
        return createExpressionListOrRangeAdapter();
      }
      @Override
      public Adapter caseExpressionListEntry(ExpressionListEntry object)
      {
        return createExpressionListEntryAdapter();
      }
      @Override
      public Adapter caseLiteral(Literal object)
      {
        return createLiteralAdapter();
      }
      @Override
      public Adapter caseIfExpression(IfExpression object)
      {
        return createIfExpressionAdapter();
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
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.VariabilityUnit <em>Variability Unit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.VariabilityUnit
   * @generated
   */
  public Adapter createVariabilityUnitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.Project <em>Project</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.Project
   * @generated
   */
  public Adapter createProjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.ProjectContents <em>Project Contents</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.ProjectContents
   * @generated
   */
  public Adapter createProjectContentsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.Typedef <em>Typedef</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.Typedef
   * @generated
   */
  public Adapter createTypedefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.TypedefEnum <em>Typedef Enum</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.TypedefEnum
   * @generated
   */
  public Adapter createTypedefEnumAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.TypedefEnumLiteral <em>Typedef Enum Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.TypedefEnumLiteral
   * @generated
   */
  public Adapter createTypedefEnumLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.TypedefCompound <em>Typedef Compound</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.TypedefCompound
   * @generated
   */
  public Adapter createTypedefCompoundAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.AttrAssignment <em>Attr Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.AttrAssignment
   * @generated
   */
  public Adapter createAttrAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.AttrAssignmentPart <em>Attr Assignment Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.AttrAssignmentPart
   * @generated
   */
  public Adapter createAttrAssignmentPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.TypedefMapping <em>Typedef Mapping</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.TypedefMapping
   * @generated
   */
  public Adapter createTypedefMappingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.TypedefConstraint <em>Typedef Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.TypedefConstraint
   * @generated
   */
  public Adapter createTypedefConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.VariableDeclaration <em>Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.VariableDeclaration
   * @generated
   */
  public Adapter createVariableDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.VariableDeclarationPart <em>Variable Declaration Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.VariableDeclarationPart
   * @generated
   */
  public Adapter createVariableDeclarationPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.BasicType <em>Basic Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.BasicType
   * @generated
   */
  public Adapter createBasicTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.Type
   * @generated
   */
  public Adapter createTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.NumValue <em>Num Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.NumValue
   * @generated
   */
  public Adapter createNumValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.QualifiedName <em>Qualified Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.QualifiedName
   * @generated
   */
  public Adapter createQualifiedNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.AccessName <em>Access Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.AccessName
   * @generated
   */
  public Adapter createAccessNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.Value
   * @generated
   */
  public Adapter createValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.DerivedType <em>Derived Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.DerivedType
   * @generated
   */
  public Adapter createDerivedTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.AnnotateTo <em>Annotate To</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.AnnotateTo
   * @generated
   */
  public Adapter createAnnotateToAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.Freeze <em>Freeze</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.Freeze
   * @generated
   */
  public Adapter createFreezeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.FreezeStatement <em>Freeze Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.FreezeStatement
   * @generated
   */
  public Adapter createFreezeStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.Eval <em>Eval</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.Eval
   * @generated
   */
  public Adapter createEvalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.InterfaceDeclaration <em>Interface Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.InterfaceDeclaration
   * @generated
   */
  public Adapter createInterfaceDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.Export <em>Export</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.Export
   * @generated
   */
  public Adapter createExportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.ImportStmt <em>Import Stmt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.ImportStmt
   * @generated
   */
  public Adapter createImportStmtAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.ConflictStmt <em>Conflict Stmt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.ConflictStmt
   * @generated
   */
  public Adapter createConflictStmtAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.VersionStmt <em>Version Stmt</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.VersionStmt
   * @generated
   */
  public Adapter createVersionStmtAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.OpDefStatement <em>Op Def Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.OpDefStatement
   * @generated
   */
  public Adapter createOpDefStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.OpDefParameterList <em>Op Def Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.OpDefParameterList
   * @generated
   */
  public Adapter createOpDefParameterListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.OpDefParameter <em>Op Def Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.OpDefParameter
   * @generated
   */
  public Adapter createOpDefParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.ExpressionStatement <em>Expression Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.ExpressionStatement
   * @generated
   */
  public Adapter createExpressionStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.LetExpression <em>Let Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.LetExpression
   * @generated
   */
  public Adapter createLetExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.AssignmentExpression <em>Assignment Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.AssignmentExpression
   * @generated
   */
  public Adapter createAssignmentExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.AssignmentExpressionPart <em>Assignment Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.AssignmentExpressionPart
   * @generated
   */
  public Adapter createAssignmentExpressionPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.ImplicationExpression <em>Implication Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.ImplicationExpression
   * @generated
   */
  public Adapter createImplicationExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.ImplicationExpressionPart <em>Implication Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.ImplicationExpressionPart
   * @generated
   */
  public Adapter createImplicationExpressionPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.LogicalExpression <em>Logical Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.LogicalExpression
   * @generated
   */
  public Adapter createLogicalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.LogicalExpressionPart <em>Logical Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.LogicalExpressionPart
   * @generated
   */
  public Adapter createLogicalExpressionPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.EqualityExpression
   * @generated
   */
  public Adapter createEqualityExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.EqualityExpressionPart <em>Equality Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.EqualityExpressionPart
   * @generated
   */
  public Adapter createEqualityExpressionPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.RelationalExpression
   * @generated
   */
  public Adapter createRelationalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.RelationalExpressionPart <em>Relational Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.RelationalExpressionPart
   * @generated
   */
  public Adapter createRelationalExpressionPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.AdditiveExpression <em>Additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.AdditiveExpression
   * @generated
   */
  public Adapter createAdditiveExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.AdditiveExpressionPart <em>Additive Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.AdditiveExpressionPart
   * @generated
   */
  public Adapter createAdditiveExpressionPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.MultiplicativeExpression
   * @generated
   */
  public Adapter createMultiplicativeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.MultiplicativeExpressionPart <em>Multiplicative Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.MultiplicativeExpressionPart
   * @generated
   */
  public Adapter createMultiplicativeExpressionPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.UnaryExpression
   * @generated
   */
  public Adapter createUnaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.PostfixExpression <em>Postfix Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.PostfixExpression
   * @generated
   */
  public Adapter createPostfixExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.Call <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.Call
   * @generated
   */
  public Adapter createCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.FeatureCall <em>Feature Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.FeatureCall
   * @generated
   */
  public Adapter createFeatureCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.SetOp <em>Set Op</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.SetOp
   * @generated
   */
  public Adapter createSetOpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.Declarator <em>Declarator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.Declarator
   * @generated
   */
  public Adapter createDeclaratorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.Declaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.Declaration
   * @generated
   */
  public Adapter createDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.ActualParameterList <em>Actual Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.ActualParameterList
   * @generated
   */
  public Adapter createActualParameterListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.ExpressionAccess <em>Expression Access</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.ExpressionAccess
   * @generated
   */
  public Adapter createExpressionAccessAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.PrimaryExpression
   * @generated
   */
  public Adapter createPrimaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.CollectionInitializer <em>Collection Initializer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.CollectionInitializer
   * @generated
   */
  public Adapter createCollectionInitializerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.ExpressionListOrRange <em>Expression List Or Range</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.ExpressionListOrRange
   * @generated
   */
  public Adapter createExpressionListOrRangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.ExpressionListEntry <em>Expression List Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.ExpressionListEntry
   * @generated
   */
  public Adapter createExpressionListEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.Literal
   * @generated
   */
  public Adapter createLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.uni_hildesheim.sse.ivml.IfExpression <em>If Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.uni_hildesheim.sse.ivml.IfExpression
   * @generated
   */
  public Adapter createIfExpressionAdapter()
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

} //IvmlAdapterFactory
