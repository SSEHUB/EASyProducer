package de.uni_hildesheim.sse.vil.expressions.translation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.dslCore.translation.ErrorCodes;
import de.uni_hildesheim.sse.dslCore.translation.StringUtils;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.ExpressionStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstantExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstructorCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ContainerInitializerExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.AbstractCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionVersionRestriction;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.FieldAccessExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IResolvable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ParenthesisExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ResolutionListener;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ValueAssignmentExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VarModelIdentifierExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VariableExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VilTypeExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.FieldDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaOperation;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ReflectionTypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeHelper;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IvmlElement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IvmlTypes;
import de.uni_hildesheim.sse.model.varModel.values.EnumValue;
import de.uni_hildesheim.sse.utils.messages.AbstractException;
import de.uni_hildesheim.sse.utils.modelManagement.DefaultImportResolver;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.IVersionRestriction;
import de.uni_hildesheim.sse.utils.modelManagement.RestrictionEvaluationException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ArgumentList;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ConstructorExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializer;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Declaration;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.DeclarationUnit;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Declarator;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionOrQualifiedExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.LogicalExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.MultiplicativeExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.NamedArgument;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.PostfixExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.PrimaryExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.RelationalExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.SubCall;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.SuperExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Type;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeParameters;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnaryExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.UnqualifiedExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionSpec;

/**
 * Implements the translation from the expression DSL to the expression model in the instantiator core.
 * 
 * @author Holger Eichelberger
 */
public abstract class ExpressionTranslator<I extends VariableDeclaration, R extends Resolver<I>, 
    E extends ExpressionStatement> extends de.uni_hildesheim.sse.dslCore.translation.ExpressionTranslator 
    implements ResolutionListener {

    private java.util.Map<VarModelIdentifierExpression, EObject> ivmlWarnings 
        = new HashMap<VarModelIdentifierExpression, EObject>();
    
    /**
     * Creates an expression translator (to be used within this package only).
     */
    public ExpressionTranslator() {
    }
    
    /**
     * Creates the expression tree for a given expression.
     * 
     * @param ex the expression to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression tree
     * @throws TranslatorException in case that the translation fails for some reason
     */
    public Expression processExpression(de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression ex, 
        R resolver) throws TranslatorException {
        Expression result;
        if (null != ex) {
            if (null != ex.getExpr()) {
                result = processLogicalExpression(ex.getExpr(), resolver);
            } else {
                result = processContainerInitializer(ex.getInit(), resolver);
            }
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Enacts the IVML warnings not resolved by "function pointers" so far.
     */
    public void enactIvmlWarnings() {
        for (Map.Entry<VarModelIdentifierExpression, EObject> ent : ivmlWarnings.entrySet()) {
            VarModelIdentifierExpression ex = ent.getKey();
            if (!ex.isMarkedAsResolved()) {
                ivmlWarning(ex.getIdentifier(), ent.getValue(), ExpressionDslPackage.Literals.CONSTANT__QVALUE);
            }
        }
        ivmlWarnings.clear();
    }
    
    /**
     * Creates a warning due to an unresolved IVML element.
     * 
     * @param name the name of the element
     * @param cause the causing ECore element
     * @param causingFeature the causing ECore feature
     */
    private void ivmlWarning(String name, EObject cause, EStructuralFeature causingFeature) {
        warning("'" + name + "' is unknown, shall be a VIL variable, a VIL type or an IVML variable " 
            + "/ annotation - may lead to a runtime error", cause, causingFeature, ErrorCodes.UNKNOWN_TYPE);
    }
    
    /**
     * Processes an expression statement.
     * 
     * @param expr the expression to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the expression statement
     * @throws TranslatorException in case that the translation fails due to semantic reasons
     * 
     * @see #cannotAssignHint()
     */
    public E processExpressionStatement(de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionStatement expr, 
        R resolver) throws TranslatorException {
        Expression result = processExpression(expr.getExpr(), resolver);
        try {
            result.inferType();
        } catch (VilException e) {
            throw new TranslatorException(e, expr, ExpressionDslPackage.Literals.EXPRESSION_STATEMENT__EXPR);
        }
        if (null != expr.getVar()) {
            I decl = resolver.resolve(expr.getVar(), false, expr, 
                ExpressionDslPackage.Literals.EXPRESSION_STATEMENT__VAR, this);
            if (null == decl) {
                throw new TranslatorException("cannot resolve variable '" + expr.getVar() + "'", expr, 
                    ExpressionDslPackage.Literals.EXPRESSION_STATEMENT__VAR, ErrorCodes.UNKNOWN_ELEMENT);
            }
            if (null != expr.getField()) {
                FieldDescriptor fdesc = decl.getType().getField(expr.getField());
                if (null != fdesc) {
                    result = new ValueAssignmentExpression(decl, fdesc, result);
                } else {
                    throw new TranslatorException("cannot resolve field '" + expr.getField() + "'", expr, 
                        ExpressionDslPackage.Literals.EXPRESSION_STATEMENT__FIELD, ErrorCodes.UNKNOWN_ELEMENT);
                }
                if (null != fdesc && fdesc.isReadOnly()) {
                    throw new TranslatorException("Cannot assign value to readonly field '" + fdesc.getName() + "'." 
                        + cannotAssignHint(), expr, ExpressionDslPackage.Literals.EXPRESSION_STATEMENT__FIELD, 
                        VilException.ID_RUNTIME_READ_WRITE);
                }
            } else {
                try {
                    result = new ValueAssignmentExpression(decl, result);
                    result.inferType();
                } catch (VilException e) {
                    throw new TranslatorException(e, expr, ExpressionDslPackage.Literals.EXPRESSION_STATEMENT__VAR);
                }
            }
        }
        return createExpressionStatement(result);
    }
    
    /**
     * A hint if an assignment is not allowed.
     * 
     * @return the hint (must not be <b>null</b>)
     */
    protected abstract String cannotAssignHint();

    /**
     * Creates an expression statement.
     * 
     * @param expression the expression
     * @return the expression statement
     */
    protected abstract E createExpressionStatement(Expression expression);
    
    /**
     * Processes a logical expression.
     * 
     * @param ex the expression to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason
     */
    public Expression processLogicalExpression(LogicalExpression ex, R resolver) 
        throws TranslatorException {
        Expression result = processEqualityExpression(ex.getLeft(), resolver);
        if (null != ex.getRight()) {
            try {
                for (LogicalExpressionPart part : ex.getRight()) {
                    result = new CallExpression(null, part.getOp(), result, 
                        processEqualityExpression(part.getEx(), resolver));
                    result.inferType();
                }
            } catch (VilException e) {
                throw new TranslatorException(e, ex, ExpressionDslPackage.Literals.LOGICAL_EXPRESSION__RIGHT);
            }
        }
        return result;
    }

    /**
     * Processes an equality expression.
     * 
     * @param ex the expression to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason
     */
    protected Expression processEqualityExpression(EqualityExpression ex, R resolver) 
        throws TranslatorException {
        Expression result = processRelationalExpression(ex.getLeft(), resolver);
        if (null != ex.getRight()) {
            try {
                EqualityExpressionPart part = ex.getRight();
                result = new CallExpression(null, part.getOp(), result, processRelationalExpression(part.getEx(), resolver));
                result.inferType();
            } catch (VilException e) {
                throw new TranslatorException(e, ex, ExpressionDslPackage.Literals.EQUALITY_EXPRESSION__RIGHT);
            }
        }
        return result;
    }

    /**
     * Processes a relational expression.
     * 
     * @param ex the expression to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason
     */
    protected Expression processRelationalExpression(RelationalExpression ex, R resolver) 
        throws TranslatorException {
        Expression result = processAdditiveExpression(ex.getLeft(), resolver);
        if (null != ex.getRight()) {
            try {
                RelationalExpressionPart part = ex.getRight();
                result = new CallExpression(null, part.getOp(), result, processAdditiveExpression(part.getEx(), resolver));
                result.inferType();
            } catch (VilException e) {
                throw new TranslatorException(e, ex, ExpressionDslPackage.Literals.RELATIONAL_EXPRESSION__RIGHT);
            }
        }
        return result;
    }

    /**
     * Processes an additive expression.
     * 
     * @param ex the expression to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason
     */
    protected Expression processAdditiveExpression(AdditiveExpression ex, R resolver) 
        throws TranslatorException {
        Expression result = processMultiplicativeExpression(ex.getLeft(), resolver);
        if (null != ex.getRight()) {
            try {
                for (AdditiveExpressionPart part : ex.getRight()) {
                    result = new CallExpression(null, part.getOp(), result, processMultiplicativeExpression(part.getEx(), resolver));
                    result.inferType();
                }
            } catch (VilException e) {
                throw new TranslatorException(e, ex, ExpressionDslPackage.Literals.ADDITIVE_EXPRESSION__RIGHT);
            }
        }
        return result;    
    }

    /**
     * Processes a multiplicative expression.
     * 
     * @param ex the expression to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason
     */
    protected Expression processMultiplicativeExpression(MultiplicativeExpression ex, 
        R resolver) throws TranslatorException {
        Expression result = processUnaryExpression(ex.getLeft(), resolver);
        if (null != ex.getRight()) {
            try {
                MultiplicativeExpressionPart part = ex.getRight();
                result = new CallExpression(null, part.getOp(), result, processUnaryExpression(part.getExpr(), resolver));
                result.inferType();
            } catch (VilException e) {
                throw new TranslatorException(e, ex, ExpressionDslPackage.Literals.EQUALITY_EXPRESSION__RIGHT);
            }
        }
        return result;
    }
    
    /**
     * Processes a unary expression.
     * 
     * @param ex the expression to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason
     */
    protected Expression processUnaryExpression(UnaryExpression ex, R resolver) 
        throws TranslatorException {
        Expression result = processPostfixExpression(ex.getExpr(), resolver);
        if (null != ex.getOp()) {
            try {
                result = new CallExpression(null, ex.getOp(), result);
                result.inferType();
            } catch (VilException e) {
                throw new TranslatorException(e, ex, ExpressionDslPackage.Literals.UNARY_EXPRESSION__EXPR);
            }
            
        }
        return result;
    }    

    /**
     * Processes a postfix expression.
     * 
     * @param ex the expression to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason
     */
    protected Expression processPostfixExpression(PostfixExpression ex, R resolver) 
        throws TranslatorException {
        return processPrimaryExpression(ex.getLeft(), resolver);
    }

    /**
     * Defines basic VIL call types.
     * 
     * @author Holger Eichelberger
     */
    protected enum CallType {
        
        /**
         * Super rule call.
         */
        SUPER,
        
        /**
         * System call.
         */
        SYSTEM,
        
        /**
         * Rule call, instantiator call or artifact call.
         */
        OTHER,
        
        /**
         * Call with iterator variables (expected), else similar to {@link OTHER}
         */
        ITERATOR
    }
    
    /**
     * Resolves the iterator declarations. Existence of iterator declarations in <code>call</code> is already
     * checked to be valid.
     * 
     * @param call the call holding the iterator declarations
     * @param type the type of the call (not the return type)
     * @return the iterator declarations in terms of variable declarations (may be <b>null</b> if there are none)
     * @throws TranslatorException in case that the translation fails for some reason
     */
    protected List<I> resolveIteratorDeclarations(Call call, CallType type, List<CallArgument> arguments, R resolver) 
        throws TranslatorException {
        List<I> result = null;
        if (null != call) {
            Declarator decl = call.getDecl();
            if (null != decl && null != decl.getDecl()) {
                if (arguments.size() > 0) {
                    TypeDescriptor<?> arg0Type = null; // implicit arg carries generic types
                    try {
                        arg0Type = arguments.get(0).inferType();
                    } catch (VilException e) {
                        throw new TranslatorException(e, call, ExpressionDslPackage.Literals.CALL__PARAM);
                    }
                    if (null != arg0Type) {
                        if (arg0Type.isCollection()) {
                            if (arg0Type.getGenericParameterCount() > 0) {
                                result = processDeclarators(call, arg0Type.getGenericParameterType(0), resolver);
                            } else {
                                throw new TranslatorException("cannot apply iterator as collection does not declare "
                                    + "generic types", call, ExpressionDslPackage.Literals.CALL__DECL, 
                                    ErrorCodes.CANNOT_RESOLVE_ITER);
                            }
                        } else {
                            result = processDeclarators(call, null, resolver);
                        }
                    }

                    if (null == result) { 
                        throw new TranslatorException("at least one declarator / iterator must be given", 
                            call, ExpressionDslPackage.Literals.CALL__DECL, ErrorCodes.CANNOT_RESOLVE_ITER);
                    } else {
                        int freeCount = 0;
                        for (int i = 0; i < result.size(); i++) {
                            I declarator = result.get(i);
                            if (null == declarator.getExpression()) {
                                freeCount++;
                            }
                        }
                        if (freeCount != 1) { // currently we consider only 1 dimension 
                            throw new TranslatorException("currently an iterator call accepts exactly one unbound / "
                                + "auto-bound iterator variable", call, ExpressionDslPackage.Literals.CALL__DECL, 
                                ErrorCodes.CANNOT_RESOLVE_ITER);
                        }
                        
                    }
                }
            }
        }
        return result;
    }

    /**
     * Processes a declarator.
     * 
     * @param call the actual call
     * @param implicitType the implicit type of the declarator to check against or to use if no explicit type is given,
     *   may be <b>null</b> if the underlying type declares the collection implicitly (see deleteJavaCall). In the 
     *   latter case, the type must be explicitly given by the declarator.
     * @param resolver the resolver
     * @return a list of resolved declarators (at the moment at maximum 1)
     * @throws TranslatorException in case that the translation fails
     */
    private ArrayList<I> processDeclarators(Call call, TypeDescriptor<?> implicitType, R resolver) throws TranslatorException {
        ArrayList<I> result = new ArrayList<I>();
        Declarator decl = call.getDecl();
        boolean firstDecl = true;
        String callName = Utils.getQualifiedNameString(call.getName());
        boolean isAggregator = "apply".equals(callName); // fixed name is not nice
        for (Declaration d : decl.getDecl()) {
            TypeDescriptor<?> t;
            if (null != d.getType()) {
                t = processType(d.getType(), resolver);
                if (!(firstDecl && isAggregator)) { // here it's the aggregator
                    if (null != implicitType && !t.isAssignableFrom(implicitType)) {
                        throw new TranslatorException("type '" + t.getVilName() + "' of iterator does not match type '" 
                            + implicitType.getVilName() + 
                            "' of the expression", call, ExpressionDslPackage.Literals.CALL__PARAM, 
                            ErrorCodes.CANNOT_RESOLVE_ITER);
                    }
                }
            } else {
                if (null == implicitType) {
                    throw new TranslatorException("on non-collection iterators the declarator must given with type", 
                        call, ExpressionDslPackage.Literals.CALL__PARAM, ErrorCodes.CANNOT_RESOLVE_ITER);
                }
                t = implicitType; // not explicitly given, take over
            }
            boolean firstUnit = true;
            for (DeclarationUnit unit : d.getUnits()) {
                Expression deflt = null;
                if (null != unit.getDeflt()) {
                    deflt = processExpression(unit.getDeflt(), resolver);
                }
                I var = createVariableDeclaration(unit.getId(), t, false, deflt);
                var.setHasExplicitType(firstUnit && null != d.getType());
                result.add(var);
                firstUnit = false;
            }
            firstDecl = false;
        }
        return result;
    }        
    
    /**
     * Resolves call arguments.
     * 
     * @param call the call to resolve the arguments for
     * @param arguments the arguments created so far (may be the operator, list is modified as a side effect)
     * @param arrayEx an array access expression (may be <b>null</b>, but then <code>call</code> is required)
     * @param resolver a resolver instance for resolving variables etc.
     * @return the operation name
     * @throws TranslatorException in case that the translation fails for some reason
     */
    protected String resolveCallArguments(Call call, List<I> iterators, List<CallArgument> arguments, 
        de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression arrayEx, R resolver) throws TranslatorException {
        String name;
        // arguments already contains implicit parameter and in case of iteration its type
        if (null != call) {
            
            if (null != call.getParam()) {
                if (null != iterators) {
                    resolver.pushLevel();
                    resolver.add(iterators);
                }
                int count = 0;
                for (de.uni_hildesheim.sse.vil.expressions.expressionDsl.NamedArgument param : call.getParam().getParam()) {
                    String paramName = param.getName();
                    Expression ex;
                    try {
                        ex = processExpression(param.getEx(), resolver);
                        if (0 == count && null != iterators) { // just on the first "parameter"
                            if (null != paramName) {
                                // if "named", turn into assignment -> grammar
                                I var = resolver.resolve(paramName, false, param, 
                                    ExpressionDslPackage.Literals.PARAMETER__NAME, this);
                                if (null == var) {
                                    throw new TranslatorException("Cannot resolve '" + paramName + "'", param, 
                                        ExpressionDslPackage.Literals.PARAMETER__NAME, ErrorCodes.CANNOT_RESOLVE_ITER);
                                }
                                ex = new ValueAssignmentExpression(var, ex);
                                paramName = null;
                            }
                            // find actual iterator (the one without default)
                            I iterator = null;
                            for (int i = 0; null == iterator && i < iterators.size(); i++) {
                                I iter = iterators.get(i);
                                if (null == iter.getExpression()) {
                                    iterator = iter;
                                }
                            }
                            ex = new ExpressionEvaluator(ex, iterator, iterators);        
                        }
                    } catch (TranslatorException e) {
                        if (ErrorCodes.CANNOT_RESOLVE_ITER == e.getId()) {
                            ex = tryIteratorExpression(arguments, param, resolver);
                        } else {
                            throw new TranslatorException(e, param, ExpressionDslPackage.Literals.NAMED_ARGUMENT__EX);
                        }
                    }
                    arguments.add(new CallArgument(paramName, ex));
                    count++;
                }
                if (null != iterators) {
                    resolver.popLevel();
                }
            }
            name = Utils.getQualifiedNameString(call.getName());
        } else {
            arguments.add(new CallArgument(processExpression(arrayEx, resolver)));
            name = "[]";
        }
        return name;
    }

    /**
     * Tries to compose an iterator expression ({@link ExpressionEvaluator})
     * 
     * @param arguments the arguments to try to construct the expression from
     * @param param the actual parameter to do the resolution for
     * @param resolver a resolver instance for resolving variables etc.
     * @return the iterator expression if successful
     * @throws TranslatorException in case that the expression cannot be created
     */
    private ExpressionEvaluator tryIteratorExpression(List<CallArgument> arguments, 
        de.uni_hildesheim.sse.vil.expressions.expressionDsl.NamedArgument param, R resolver) 
        throws TranslatorException {
        // remove
        ExpressionEvaluator ex = null;
        if (arguments.size() > 0) {
            try {
                TypeDescriptor<?> arg0Type = arguments.get(0).inferType();
                if (arg0Type.isCollection() && arg0Type.getGenericParameterCount() > 0) {
                    resolver.pushLevel();
                    I iterVar = createVariableDeclaration("ITER", arg0Type.getGenericParameterType(0), false, null);
                    resolver.add(iterVar); // iterVar shall be strictly local!
                    ex = new ExpressionEvaluator(processExpression(param.getEx(), resolver), iterVar, null);
                    resolver.popLevel();
                }
            } catch (VilException e) {
                throw new TranslatorException(e, param, ExpressionDslPackage.Literals.NAMED_ARGUMENT__EX);
            }
        }
        return ex;
    }
    
    /**
     * Creates a new variable declaration.
     * 
     * @param name the name of the variable
     * @param type the type of the variable
     * @param isConstant whether this variable is a constant
     * @param expression an expression denoting the initial value (may be <b>null</b>)
     */
    protected abstract I createVariableDeclaration(String name, TypeDescriptor<?> type, 
        boolean isConstant, Expression expression);

    /**
     * Processes a function call.
     * 
     * @param firstParam the first parameter (may be <b>null</b>)
     * @param call the function all (may be <b>null</b>, but then <code>arrayEx</code> is required)
     * @param arrayEx an array access expression (may be <b>null</b>, but then <code>call</code> is required)
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason
     */
    protected abstract Expression processCall(Expression firstParam, Call call, CallType type,
        de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression arrayEx, R resolver) 
        throws TranslatorException; 

    /**
     * Checks the semantics of a potential call candidate.
     * 
     * @param expr the expression to be checked
     * @return the <code>expr</code> if ok or <b>null</b>
     */
    protected VilException checkSemantics(Expression expr) {
        VilException semantic = null;
        if (null != expr) {
            try {
                expr.inferType();
            } catch (VilException e) {
                // cannot resolve
                semantic = e;
            }
        }
        return semantic;
    }
    
    /**
     * Processes sub calls, i.e., calls connected by ".".
     * @param firstParam the first parameter (the expression before the ".")
     * @param followups the follow-up calls
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason
     */
    protected Expression processSubCalls(Expression firstParam, EList<SubCall> followups, 
        R resolver) throws TranslatorException {
        Expression result = firstParam;
        if (null != followups) {
            for (SubCall call : followups) {
                CallType callType = CallType.OTHER;
                if (Constants.ITER_CALL.equals(call.getType())) {
                    callType = CallType.ITERATOR;
                }
                Call c = call.getCall();
                if (null != c) {
                    Declarator decl = c.getDecl();
                    if (null == decl) {
                        if (CallType.ITERATOR == callType) {
                            // it is an iterator call but without declarators -> error
                            throw new TranslatorException("iterator call without iterator variables", call, 
                                ExpressionDslPackage.Literals.SUB_CALL__TYPE, ErrorCodes.CANNOT_RESOLVE_ITER);
                        }
                    } else {
                        // it is a call with declarators but not a iterator call ->
                        if (callType != CallType.ITERATOR) {
                            throw new TranslatorException("iterator variables given but this is no iterator call", 
                                 c, ExpressionDslPackage.Literals.CALL__DECL, ErrorCodes.CANNOT_RESOLVE_ITER);
                        }
                    }
                }
                result = processCall(result, c, callType, call.getArrayEx(), resolver);
            }
        }
        return result;
    }

    /**
     * Processes a primary expression.
     * 
     * @param ex the expression to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason
     */
    public Expression processPrimaryExpression(PrimaryExpression ex, R resolver) 
        throws TranslatorException {
        Expression result = null;
        if (null != ex) {
            ExpressionOrQualifiedExecution otherEx = ex.getOtherEx();
            if (null != otherEx) {
                if (null != otherEx.getVal()) {
                    result = processConstant(otherEx.getVal(), resolver);
                } else if (null != otherEx.getParenthesis()) {
                    result = new ParenthesisExpression(processExpression(otherEx.getParenthesis(), resolver));
                }
                if (null != otherEx.getCalls()) {
                    result = processSubCalls(result, otherEx.getCalls(), resolver);
                }
            }
            UnqualifiedExecution unqEx = ex.getUnqEx();
            if (null != unqEx) {
                result = processCall(null, unqEx.getCall(), CallType.OTHER, null, resolver);
                result = processSubCalls(result, unqEx.getCalls(), resolver);
            }
            SuperExecution superEx = ex.getSuperEx();
            if (null != superEx) {
                result = processCall(null, superEx.getCall(), CallType.SUPER, null, resolver);
                result = processSubCalls(result, superEx.getCalls(), resolver);
            }
            ConstructorExecution cEx = ex.getNewEx();
            if (null != cEx) {
                try {
                    CallArgument[] args = processArguments(cEx.getParam(), resolver);
                    result = new ConstructorCallExpression(processType(cEx.getType(), resolver), args);
                    result = processSubCalls(result, cEx.getCalls(), resolver);
                    result.inferType();
                } catch (VilException e) {
                    throw new TranslatorException(e, cEx, ExpressionDslPackage.Literals.CONSTRUCTOR_EXECUTION__TYPE);
                }
            }
        }
        return result;
    }

    /**
     * Processes an argument list and translates them into call arguments.
     * 
     * @param arguments the arguments to be translated
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason
     */
    public CallArgument[] processArguments(ArgumentList arguments, R resolver) throws TranslatorException {
        CallArgument[] result;
        if (null == arguments || null == arguments.getParam()) {
            result = new CallArgument[0];
        } else {
            EList<NamedArgument> args = arguments.getParam();
            result = new CallArgument[args.size()];
            for (int a = 0; a < args.size(); a++) {
                NamedArgument arg = args.get(a);
                result[a] = new CallArgument(arg.getName(), processExpression(arg.getEx(), resolver));
            }
        }
        return result;
    }
    
    protected abstract Expression parseExpression(String expression, R resolver, StringBuilder warnings) 
        throws VilException;
    
    /**
     * Processes a constant argument.
     * 
     * @param arg the constant to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason
     */
    protected Expression processConstant(Constant arg, R resolver) 
        throws TranslatorException {
        Expression result = null;
        if (null != arg.getNValue()) {
            TypeDescriptor<?> type;
            String tmp = arg.getNValue().getVal();
            if (tmp.indexOf('.') > 0) {
                type = TypeRegistry.realType();
            } else {
                type = TypeRegistry.integerType();
            }
            result = createConstant(type, tmp, arg, 
                ExpressionDslPackage.Literals.CONSTANT__NVALUE, resolver.getTypeRegistry());
            
        } else if (null != arg.getSValue()) {
            String s = StringUtils.convertString(arg.getSValue());
            
            Expression ex;
            try {
                StringBuilder warnings = new StringBuilder();
                ex = StringResolver.substitute(s, resolver, this, warnings);
                if (warnings.length() > 0) {
                    warning(warnings.toString(), arg, ExpressionDslPackage.Literals.CONSTANT__SVALUE, 0);
                }
                result = ex;
            } catch (VilException e) {
                throw new TranslatorException(e, arg, ExpressionDslPackage.Literals.CONSTANT__SVALUE);
            }
//            result = createConstant(TypeRegistry.stringType(), ex, arg, 
//                ExpressionDslPackage.Literals.CONSTANT__SVALUE, resolver.getTypeRegistry());
        } else if (null != arg.getQValue()) {
            String name = Utils.getQualifiedNameString(arg.getQValue());
            if (Version.isVersion(name)) { // parser mismatch fixed here
                result = convertToVersion(name, arg, resolver);
            } else {
                result = processQualifiedValue(name, arg, ExpressionDslPackage.Literals.CONSTANT__QVALUE, resolver);
            }
        } else if (null != arg.getBValue()) {
            result = createConstant(TypeRegistry.booleanType(), arg.getBValue(), arg, 
                ExpressionDslPackage.Literals.CONSTANT__BVALUE, resolver.getTypeRegistry());
        } else if (null != arg.getNull()) {
            result = createConstant(TypeRegistry.anyType(), TypeRegistry.NULL, arg,
                ExpressionDslPackage.Literals.CONSTANT__NULL, resolver.getTypeRegistry());
        } else if (null != arg.getVersion()) {
            result = convertToVersion(arg.getVersion(), arg, resolver);
        }
        return result;
    }
    
    private Expression convertToVersion(String text, Constant arg, R resolver) throws TranslatorException {
        Expression result;
        if (text.startsWith("v")) {
            text = text.substring(1);
        }
        try {
            result = createConstant(TypeRegistry.versionType(), new Version(text), arg,
                ExpressionDslPackage.Literals.CONSTANT__VERSION, resolver.getTypeRegistry());
        } catch (VersionFormatException e) {
            throw new TranslatorException(e.getMessage(), arg, 
                ExpressionDslPackage.Literals.CONSTANT__VERSION, e.getId());
        }
        return result;
    }
    
    private FieldAccessExpression process(VariableDeclaration var, FieldAccessExpression last, String name, 
        Constant elt) throws TranslatorException {
        FieldAccessExpression result;
        if (null == last) {
            FieldDescriptor fd = var.getType().getField(name);
            if (null != fd) {
                try {
                    result = new FieldAccessExpression(var, fd);
                } catch (VilException e) {
                    throw new TranslatorException(e, elt, ExpressionDslPackage.Literals.CONSTANT__QVALUE);
                }
            } else {
                throw new TranslatorException("cannot resolve field " + name, elt, 
                    ExpressionDslPackage.Literals.CONSTANT__QVALUE, ErrorCodes.UNKNOWN_ELEMENT);
            }
        } else {
            try {
                FieldDescriptor fd = last.inferType().getField(name);
                if (null != fd) {
                    result = new FieldAccessExpression(last, fd);
                } else {
                    throw new TranslatorException("cannot resolve field " + name, elt, 
                        ExpressionDslPackage.Literals.CONSTANT__QVALUE, ErrorCodes.UNKNOWN_ELEMENT);
                }
            } catch (VilException e) {
                throw new TranslatorException(e, elt, ExpressionDslPackage.Literals.CONSTANT__QVALUE);
            }
        }
        return result;
    }

    /**
     * Processes a qualified value and creates variable expressions.
     * @param name the qualified name
     * @param arg the constant to be processed
     * @param feature the feature corresponding to <code>arg</code>
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason, in particular if 
     *     ITER cannot be resolved
     */
    protected Expression processQualifiedValue(String name, Constant arg, EStructuralFeature feature, R resolver) throws TranslatorException {
        Expression result = null;
        int pos = name.indexOf('.');
        IResolvable res = null;
        if (pos > 0 && pos < name.length()) { // grammar: there may by at maximum one "." in a qualified name
            String head = name.substring(0, pos);
            String tail = name.substring(pos + 1);
            res = resolver.resolve(head, false, arg, feature, this);
            if (res instanceof VariableDeclaration) {
                VariableDeclaration var = (VariableDeclaration) res;
                FieldAccessExpression fae = null;
                do {
                    pos = tail.indexOf('.');
                    if (pos >= 0) {
                        fae = process(var, fae, tail.substring(0, pos), arg);
                        tail = tail.substring(pos + 1);
                    } else {
                        fae = process(var, fae, tail, arg);
                    }
                } while (pos >= 0);
                result = fae;
                res = null;
            } else {
                TypeDescriptor<?> type = resolver.getTypeRegistry().getType(head);
                if (null != type) {
                    FieldDescriptor field = type.getField(tail); // TODO deep resolution by now, refactor
                    if (null != field && field.isStatic()) {
                        try {
                            result = new FieldAccessExpression(field);
                        } catch (VilException e) {
                            throw new TranslatorException(e, arg, ExpressionDslPackage.Literals.CONSTANT__QVALUE);
                        }
                    }
                }
                
            }
        } 
        if (null == res && null == result) {
            res = resolver.resolve(name, false, arg, feature, this);
        }
        if (null == res && null == result) {
            if ("ITER".equals(name)) {
                throw new TranslatorException("iterator variable ITER cannot be resolved", arg, 
                    ExpressionDslPackage.Literals.CONSTANT__QVALUE, ErrorCodes.CANNOT_RESOLVE_ITER);
            }
            TypeRegistry registry = resolver.getTypeRegistry();
            TypeDescriptor<?> type = registry.getType(name);
            if (null == type) {
                Object ivmlElement = resolver.getIvmlElement(name);
                if (ivmlElement instanceof EnumValue) {
                    EnumValue eValue = (EnumValue) ivmlElement;
                    type = registry.getType(eValue.getType());
                    if (null != type) {
                        try {
                            result = new ConstantExpression(type, new de.uni_hildesheim.sse.easy_producer.instantiator.
                                model.vilTypes.configuration.EnumValue(eValue), registry);
                        } catch (VilException e) {
                            throw new TranslatorException(e, arg, ExpressionDslPackage.Literals.CONSTANT__QVALUE);
                        }
                    }
                } 
                if (null == result) {
                    VarModelIdentifierExpression vmie = new VarModelIdentifierExpression(name); // also if elt==null 
                    result = vmie;
                    if (null == ivmlElement) {
                        ivmlWarnings.put(vmie, arg);
                    } 
                }
            } else {
                result = new VilTypeExpression(name, type);
                ivmlWarning(name, arg, ExpressionDslPackage.Literals.CONSTANT__QVALUE);
            }
        } else if (res instanceof VariableDeclaration) {
            result = new VariableExpression((VariableDeclaration) res, name);
        } else if (res instanceof IvmlElement) { // from VIL, model is known at parsing time
            result = new VarModelIdentifierExpression(name);
        } else if (null == result) {
            // may happen although template..
            throw new TranslatorException(name + " is no variable", arg, 
                ExpressionDslPackage.Literals.CONSTANT__QVALUE, ErrorCodes.TYPE_CONSISTENCY);
        }
        return result;
    }
    
    /**
     * Creates a constant.
     * 
     * @param type the type of the constant
     * @param value the value of the constant
     * @param cause the Ecore language model element for which the exception was
     *        caused
     * @param causingFeature the specific language feature within <code>cause</code> which
     *        caused the exception
     * @return the created constant expression
     * @throws TranslatorException in case that type resolution fails
     */
    protected static final Expression createConstant(TypeDescriptor<?> type, Object value, 
        EObject cause, EStructuralFeature causingFeature, TypeRegistry registry) throws TranslatorException {
        try {
            return new ConstantExpression(type, value, registry);
        } catch (VilException e) {
            throw new TranslatorException(e, cause, causingFeature);
        }
    }
    
    /**
     * Processes the given type and tries to resolve it to a VIL type.
     * @param type the type to be processed
     * @param resolver the resolver instance
     * @return the corresponding VIL type
     * @throws TranslatorException in case that type resolution fails
     */
    public TypeDescriptor<?> processType(Type type, R resolver) throws TranslatorException {
        TypeDescriptor<?> result;
        if (null == type) {
            throw new TranslatorException("no type given", type, 
                ExpressionDslPackage.Literals.TYPE__NAME, VilException.ID_INVALID);
        }
        if (null != type.getSeq()) {
            TypeDescriptor<?>[] param = processTypeParameter(type.getParam(), type, resolver);
            try {
                result = TypeRegistry.getSequenceType(param);
            } catch (VilException e) {
                throw new TranslatorException(e, type, ExpressionDslPackage.Literals.TYPE__SEQ);
            }
        } else if (null != type.getSet()) {
            TypeDescriptor<?>[] param = processTypeParameter(type.getParam(), type, resolver);
            try {
                result = TypeRegistry.getSetType(param);
            } catch (VilException e) {
                throw new TranslatorException(e, type, ExpressionDslPackage.Literals.TYPE__SET);
            }
        } else if (null != type.getMap()) {
            TypeDescriptor<?>[] param = processTypeParameter(type.getParam(), type, resolver);
            try {
                result = TypeRegistry.getMapType(param);
            } catch (VilException e) {
                throw new TranslatorException(e, type, ExpressionDslPackage.Literals.TYPE__SET);
            }
        } else if (null != type.getCall()) {
            TypeDescriptor<?>[] param = processTypeParameter(type.getParam(), type, resolver);
            TypeDescriptor<?>[] tmp = new TypeDescriptor<?>[param.length + 1];
            System.arraycopy(param, 0, tmp, 0, param.length);
            TypeDescriptor<?> ret;
            if (null == type.getReturn()) {
                ret = ReflectionTypeDescriptor.VOID;
            } else {
                ret = processType(type.getReturn(), resolver);
            }
            tmp[tmp.length - 1] = ret;
            try {
                result = TypeRegistry.getRuleType(tmp);
            } catch (VilException e) {
                throw new TranslatorException(e, type, ExpressionDslPackage.Literals.TYPE__CALL);
            }
        } else {
            String typeName = Utils.getQualifiedNameString(type.getName());
            result = resolver.getTypeRegistry().getType(typeName);
            if (null == result) {
                throw new TranslatorException("type '" + typeName + "' unknown", type, 
                    ExpressionDslPackage.Literals.TYPE__NAME, ErrorCodes.UNKNOWN_TYPE);
            }
        }
        if (result.isPlaceholder()) {
            String typeName = Utils.getQualifiedNameString(type.getName());
            warning("'" + typeName + "' is unknown, shall be an IVML/known type - may lead to a runtime error", type, 
                ExpressionDslPackage.Literals.TYPE__NAME, ErrorCodes.UNKNOWN_TYPE);
        }
        return result;
    }
    
    /**
     * Processes a container initializer expression.
     * 
     * @param initializer the container initializer expression as ECore instance
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resolved container initializer expression
     * @throws TranslatorException in case that type resolution fails
     */
    private ContainerInitializerExpression processContainerInitializer(ContainerInitializer initializer, R resolver) 
        throws TranslatorException {
        ContainerInitializerExpression result;
        if (null != initializer.getExprs()) {
            int dimensions = -1;
            List<TypeDescriptor<?>> partDims = new ArrayList<TypeDescriptor<?>>();
            List<Expression> inits = new ArrayList<Expression>();
            for (de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializerExpression initEx : initializer.getExprs()) {
                Expression part = null;
                partDims.clear();
                try {
                    if (null != initEx.getLogical()) {
                        part = processLogicalExpression(initEx.getLogical(), resolver);
                        partDims.add(part.inferType());
                    } else if (null != initEx.getContainer()) {
                        part = processContainerInitializer(initEx.getContainer(), resolver);
                        TypeDescriptor<?> partType = part.inferType();
                        for (int d = 0; d < partType.getGenericParameterCount(); d++) {
                            partDims.add(partType.getGenericParameterType(d));
                        }
                    }
                } catch (VilException e) {
                    throw new TranslatorException(e, initEx, 
                        ExpressionDslPackage.Literals.CONTAINER_INITIALIZER_EXPRESSION__CONTAINER);
                }
                if (partDims.isEmpty()) {
                    throw new TranslatorException("unknown dimension of container initializer", initEx, 
                        ExpressionDslPackage.Literals.CONTAINER_INITIALIZER_EXPRESSION__CONTAINER, ErrorCodes.DIMENSION);
                }
                if (dimensions < 0) {
                    dimensions = partDims.size();
                } else if (dimensions != partDims.size()) {
                    throw new TranslatorException("unmatching dimension of container initializer part", initEx, 
                        ExpressionDslPackage.Literals.CONTAINER_INITIALIZER_EXPRESSION__CONTAINER, ErrorCodes.DIMENSION);
                }
                inits.add(part);
            }
            Expression[] exprs = new Expression[inits.size()];
            inits.toArray(exprs);
            result = new ContainerInitializerExpression(exprs);
        } else {
            result = new ContainerInitializerExpression();
        }
        return result;
    }
    
    /**
     * Processes the type parameter.
     * 
     * @param param the ECore instance containing the type parameter
     * @param type the type the parameter are assigned to
     * @param resolver the resolver instance
     * @return the processed parameter in terms of VIL type descriptors
     * @throws TranslatorException in case that type resolution fails
     */
    protected TypeDescriptor<?>[] processTypeParameter(TypeParameters param, Type type, R resolver) 
        throws TranslatorException {
        EList<Type> params = param.getParam();
        TypeDescriptor<?>[] result = TypeDescriptor.createArray(params.size());
        for (int i = 0; i < params.size(); i++) {
            result[i] = processType(params.get(i), resolver);
        }
        return result;
    }
    
    /**
     * Processes a variable declaration.
     * 
     * @param decl the declaration
     * @param resolver a resolver instance for resolving variables etc.
     * @return the created model instance
     * @throws TranslatorException in case that the translation fails
     */
    public I processVariableDeclaration(
        de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration decl, R resolver) 
        throws TranslatorException {
        String name = decl.getName();
        if (resolver.resolve(name, true) != null) {
            throw new TranslatorException("variable '" + name + "' was already declared", decl, 
                ExpressionDslPackage.Literals.VARIABLE_DECLARATION__NAME, ErrorCodes.REDEFINITION);
        }
        TypeDescriptor<?> type = processType(decl.getType(), resolver);
        boolean isConstant = null != decl.getConst();
        Expression init = null;
        if (null != decl.getExpression()) {
            init = processExpression(decl.getExpression(), resolver);
            try {
                TypeDescriptor<?> exType = init.inferType();
                boolean ok = type.isAssignableFrom(exType);
                if (!ok && type.isSequence() && exType.isSequence() && 0 == exType.getGenericParameterCount() 
                    && init instanceof ContainerInitializerExpression) {
                    // left side is sequence and right side is empty container initializer - this works
                    ContainerInitializerExpression cie = (ContainerInitializerExpression) init;
                    ok = 0 == cie.getInitExpressionsCount();
                }
                if (!ok && type.isSet() && exType.isSequence() && 0 == exType.getGenericParameterCount() 
                    && init instanceof ContainerInitializerExpression) {
                    // left side is set and right side is empty container initializer - convert and ok
                    ContainerInitializerExpression cie = (ContainerInitializerExpression) init;
                    if (0 == cie.getInitExpressionsCount()) {
                        init = cie.toSet();
                        exType = cie.inferType();
                        ok = true;
                    }
                }
                if (!ok && type.isSet() && exType.isSequence() && init instanceof ContainerInitializerExpression) {
                    // left side is set and right side is empty container initializer - convert and ok
                    ContainerInitializerExpression cie = (ContainerInitializerExpression) init;
                    ContainerInitializerExpression tmp = cie.toSet();
                    TypeDescriptor<?> tmpType = tmp.inferType();
                    if (type.isAssignableFrom(tmpType)) {
                        init = tmp;
                        exType = tmpType;
                        ok = true;
                    }
                }
                if (!ok && TypeRegistry.resolvableOperationType().isAssignableFrom(type) 
                    && IvmlTypes.ivmlElement().isAssignableFrom(exType)) {
                    // this may be a "function pointer" - defer until everything is resolved and try later
                    init = new DeferredResolvableOperationExpression(decl, type, init);
                    ok = true; // pretend that everything is ok -> reProcessVariableDeclaration
                }
                if (!ok) {
                    OperationDescriptor conversion = TypeDescriptor.findConversionOnBoth(exType, type);
                    if (null == conversion) {
                        throwVariableCannotBeInitialized(decl, type, exType);
                    } else {
                        init = new CallExpression(conversion, new CallArgument(init));
                    }
                }
            } catch (VilException e) {
                throw new TranslatorException(e, decl, ExpressionDslPackage.Literals.VARIABLE_DECLARATION__TYPE);
            }
        } 
        I result = createVariableDeclaration(name, type, isConstant, init);
        resolver.add(result);
        return result;
    }
    
    /**
     * Re-processes a variable declaration in order to get rid of {@link DeferredResolvableOperationExpression}.
     * 
     * @param decl the declaration
     * @param resolver the resolver
     * @throws TranslatorException in case that re-processing fails for some reason
     */
    public void reProcessVariableDeclaration(I decl, R resolver) throws TranslatorException {
        Expression init = decl.getExpression();
        if (init instanceof DeferredResolvableOperationExpression) {
            DeferredResolvableOperationExpression defEx = (DeferredResolvableOperationExpression) init;
            try {
                boolean done = false;
                IModel model = resolver.getCurrentModel();
                Expression defExInit = defEx.getInit();
                TypeDescriptor<?> varType = defEx.getVarType();
                TypeDescriptor<?> defExInitType = defExInit.inferType();
                if (model instanceof IMetaType) {
                    IMetaOperation op = AbstractCallExpression.resolveResolvableOperation((IMetaType) model, 
                        varType, defExInitType, defExInit, this);
                    if (null != op) {
                        decl.resolveOperation(defEx.getVarType(), op);
                        done = true;
                    }
                }
                if (!done) {
                    throwVariableCannotBeInitialized(defEx.getDecl(), varType, defExInitType);
                }
            } catch (VilException e) {
                throw new TranslatorException(e, defEx.getDecl(), ExpressionDslPackage.Literals.VARIABLE_DECLARATION__TYPE);
            }
        }
    }

    /**
     * Throws a {@link TranslatorException} that a variable cannot be initialized.
     * 
     * @param decl the ECore declaration object
     * @param declType the declaration VIL type 
     * @param initType the init expression VIL type
     * @throws TranslatorException the created exception
     */
    private void throwVariableCannotBeInitialized(de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration decl, TypeDescriptor<?> declType, TypeDescriptor<?> initType) throws TranslatorException {
        throw new TranslatorException("variable '" + decl.getName()+ "' of type '" + declType.getVilName() + "' cannot be " 
            + "initialized with an expression of type '" + initType.getVilName() + "'", decl, 
            ExpressionDslPackage.Literals.VARIABLE_DECLARATION__NAME, ErrorCodes.TYPE_CONSISTENCY);
    }


    /**
     * Returns whether resolution shall be continued in case of multiple similar call expressions. 
     * 
     * @param semanticException the exception being thrown by the (partial) call resolution
     * @return <code>true</code> if resolution shall be continued (there was an exception and it points to a resolution 
     *     or a semantic problem), <code>false</code> else
     */
    protected boolean continueResolution(VilException semanticException) {
        return null != semanticException && (semanticException.getId() == VilException.ID_CANNOT_RESOLVE 
            || semanticException.getId() == VilException.ID_SEMANTIC); // legacy
    }

    
    /**
     * Turns a buildlang exception into a xText error.
     * 
     * @param exception the exception to used
     * @param cause
     *            the cause (as instance of the EMF grammar model)
     * @param causeFeature
     *            the cause of the feature as an appropriate constant from
     *            {@link de.uni_hildesheim.sse.ivml.IvmlPackage.Literals}
     */
    public void error(AbstractException exception, EObject cause, EStructuralFeature causeFeature) {
        error(exception.getMessage(), cause, causeFeature, exception.getId());
    }

    /**
     * Turns a buildlang exception into a xText warning.
     * 
     * @param exception the exception to used
     * @param cause
     *            the cause (as instance of the EMF grammar model)
     * @param causeFeature
     *            the cause of the feature as an appropriate constant from
     *            {@link de.uni_hildesheim.sse.ivml.IvmlPackage.Literals}
     */
    public void warning(AbstractException exception, EObject cause, EStructuralFeature causeFeature) {
        error(exception.getMessage(), cause, causeFeature, exception.getId());
    }
    
    /**
     * Issues implementation warnings about version restrictions.
     * 
     * @param spec the version specification (may be <b>null</b>)
     */
    public void warnVersionRestrictions(VersionSpec spec) {
        if (!DefaultImportResolver.IMPORT_WITH_VERSION) {
            if (null != spec) {
                warning("currently not (fully) supported", spec, 
                    ExpressionDslPackage.Literals.VERSION_SPEC__RESTRICTION, 0);
            }
        }
    }

    /**
     * Processes an import restriction.
     * 
     * @param name the name of the import
     * @param spec the version specification to be processed
     * @return the created restriction
     * @throws TranslatorException in case of any translation problem
     */
    public IVersionRestriction processRestriction(String name, VersionSpec spec, R resolver) 
        throws TranslatorException {
        IVersionRestriction result = null;
        if (null != spec && null != spec.getRestriction()) {
            resolver.pushLevel();
            I versionVariable = createVariableDeclaration("version", TypeRegistry.versionType(), false, null);
            resolver.add(versionVariable);
            try {
                result = createExpressionVersionRestriction(processExpression(spec.getRestriction(), resolver), 
                    versionVariable, spec.getRestriction(), ExpressionDslPackage.Literals.VERSION_SPEC__RESTRICTION);
                resolver.popLevel();
            } catch (RestrictionEvaluationException e) {
                throw new TranslatorException(e.getMessage(), spec, 
                    ExpressionDslPackage.Literals.VERSION_SPEC__RESTRICTION, e.getId());
            }
        }
        return result;
    }
    
    /**
     * Creates an expression version restriction matching this class.
     * 
     * @param expr the expression for the restriction
     * @param decl the version variable
     * @param cause the grammar cause for this call
     * @param feature the causing feature
     * @return the created instance
     * @throws RestrictionEvaluationException in case of any type related problems
     */
    protected abstract ExpressionVersionRestriction createExpressionVersionRestriction(Expression expr, 
        VariableDeclaration decl, EObject cause, EStructuralFeature feature) throws RestrictionEvaluationException;

    @Override
    public void resolved(VarModelIdentifierExpression ex) {
        ivmlWarnings.remove(ex);
    }

    /**
     * Asserts the given expression to be of Boolean type.
     * 
     * @param expression the expression to check
     * @param cause the causing ECore AST object
     * @param causingFeature the causing feature
     * @return <code>expression</code> or a converted expression
     * @throws TranslatorException thrown if the expression is not of type Boolean
     */
    public Expression assertBooleanExpression(Expression expression, EObject cause, EStructuralFeature causingFeature) 
        throws TranslatorException {
        if (null != expression) {
            try {
                TypeDescriptor<?> type = expression.inferType();
                boolean ok = false;
                if (IvmlTypes.decisionVariableType().isAssignableFrom(type)) {
                    ok = true; // just risk it, can be queried for a Boolean value (may be null)
                    IMetaOperation convOp = TypeHelper.findConversion(type, TypeRegistry.booleanType());
                    if (convOp instanceof OperationDescriptor) {
                        expression = new CallExpression((OperationDescriptor) convOp, new CallArgument(expression));;
                    } else {
                        throw new TranslatorException("No conversion from decisionVariable to Boolean defined", 
                                        cause, causingFeature, ErrorCodes.TYPE_CONSISTENCY);
                    }
                } else {
                    ok = TypeRegistry.booleanType().isAssignableFrom(type);
                }
                if (!ok) {
                    throw new TranslatorException("condition must be a Boolean expression rather than " + type.getVilName(), 
                        cause, causingFeature, ErrorCodes.TYPE_CONSISTENCY);
                }
            } catch (VilException e) {
                throw new TranslatorException(e, cause, causingFeature);
            }
        }
        return expression;
    }
    
}
