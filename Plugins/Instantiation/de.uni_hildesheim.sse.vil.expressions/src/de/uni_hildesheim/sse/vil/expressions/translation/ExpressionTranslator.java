package de.uni_hildesheim.sse.vil.expressions.translation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.Strings;

import de.uni_hildesheim.sse.dslCore.translation.ErrorCodes;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstantExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstructorCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ContainerInitializerExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IResolvable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ParenthesisExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VarModelIdentifierExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VariableExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VilTypeExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IvmlElement;
import de.uni_hildesheim.sse.utils.messages.AbstractException;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.AdditiveExpressionPart;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ArgumentList;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Call;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.Constant;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ConstructorExecution;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ContainerInitializer;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpression;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.EqualityExpressionPart;
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
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionSpec;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.VersionedId;

/**
 * Implements the translation from the expression DSL to the expression model in the instantiator core.
 * 
 * @author Holger Eichelberger
 */
public abstract class ExpressionTranslator<I extends VariableDeclaration, R extends Resolver<I>> extends de.uni_hildesheim.sse.dslCore.translation.ExpressionTranslator {

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
        if (null != ex.getExpr()) {
            result = processLogicalExpression(ex.getExpr(), resolver);
        } else {
            result = processContainerInitializer(ex.getInit(), resolver);
        }
        return result;
    }
/*
    protected Expression processImplicationExpression(ImplicationExpression ex, R resolver) 
        throws TranslatorException {
        Expression result = processLogicalExpression(ex.getLeft());
        if (null != ex.getRight()) {
            try {
                for (ImplicationExpressionPart part : ex.getRight()) {
                    part.getOp();
                    result = new CallExpression(part.getOp(), result, processLogicalExpression(part.getEx()));
                    result.inferType();
                }
            } catch (ExpressionException e) {
                throw new TranslatorException(e, ex, ExpressionDslPackage.Literals.IMPLICATION_EXPRESSION__RIGHT);
            }
        }
        return result;
    }*/
    
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
            } catch (ExpressionException e) {
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
            } catch (ExpressionException e) {
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
            } catch (ExpressionException e) {
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
            } catch (ExpressionException e) {
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
            } catch (ExpressionException e) {
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
            } catch (ExpressionException e) {
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
        OTHER
    }
    
    /**
     * Resolves call arguments.
     * 
     * @param call the call to resolve the arguments for
     * @param arguments the arguments created so far (may be the operator, list is modified as a side effect)
     * @param arrayEx an array access expression (may be <b>null</b>, but then <code>call</code> is required)
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason
     */
    protected String resolveCallArguments(Call call, List<CallArgument> arguments, 
        de.uni_hildesheim.sse.vil.expressions.expressionDsl.Expression arrayEx, R resolver) throws TranslatorException {
        String name;
        if (null != call) {
            if (null != call.getParam()) {
                for (de.uni_hildesheim.sse.vil.expressions.expressionDsl.NamedArgument param : call.getParam().getParam()) {
                    Expression ex;
                    try {
                        ex = processExpression(param.getEx(), resolver);
                    } catch (TranslatorException e) {
                        if (ErrorCodes.CANNOT_RESOLVE_ITER == e.getId()) {
                            ex = tryIteratorExpression(arguments, param, resolver);
                        } else {
                            throw new TranslatorException(e, param, ExpressionDslPackage.Literals.NAMED_ARGUMENT__EX);
                        }
                    }
                    arguments.add(new CallArgument(param.getName(), ex));
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
        ExpressionEvaluator ex = null;
        if (arguments.size() > 0) {
            try {
                TypeDescriptor<? extends IVilType> arg0Type = arguments.get(0).inferType();
                if (arg0Type.isCollection() && arg0Type.getParameterCount() > 0) {
                    resolver.pushLevel();
                    I iterVar = createVariableDeclaration("ITER", arg0Type.getParameterType(0), false, null);
                    resolver.add(iterVar); // iterVar shall be strictly local!
                    ex = new ExpressionEvaluator(processExpression(param.getEx(), resolver), iterVar);
                    resolver.popLevel();
                }
            } catch (ExpressionException e) {
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
    protected abstract I createVariableDeclaration(String name, TypeDescriptor<? extends IVilType> type, 
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
    protected ExpressionException checkSemantics(Expression expr) {
        ExpressionException semantic = null;
        if (null != expr) {
            try {
                expr.inferType();
            } catch (ExpressionException e) {
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
                result = processCall(result, call.getCall(), CallType.OTHER, call.getArrayEx(), resolver);
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
            } catch (ExpressionException e) {
                throw new TranslatorException(e, cEx, ExpressionDslPackage.Literals.CONSTRUCTOR_EXECUTION__TYPE);
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
    protected CallArgument[] processArguments(ArgumentList arguments, R resolver) throws TranslatorException {
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
            TypeDescriptor<? extends IVilType> type;
            String tmp = arg.getNValue().getVal();
            if (tmp.indexOf('.') > 0) {
                type = TypeRegistry.realType();
            } else {
                type = TypeRegistry.integerType();
            }
            result = createConstant(type, tmp, arg, 
                ExpressionDslPackage.Literals.CONSTANT__NVALUE, resolver.getTypeRegistry());
        }
        if (null != arg.getSValue()) {
            String s = convertString(arg.getSValue());
            result = createConstant(TypeRegistry.stringType(), s, arg, 
                ExpressionDslPackage.Literals.CONSTANT__SVALUE, resolver.getTypeRegistry());
        }
        if (null != arg.getQValue()) {
            result = processQualifiedValue(arg, resolver);
        }
        if (null != arg.getBValue()) {
            result = createConstant(TypeRegistry.booleanType(), arg.getBValue(), arg, 
                ExpressionDslPackage.Literals.CONSTANT__BVALUE, resolver.getTypeRegistry());
        }
        return result;
    }

    /**
     * Processes a qualified value and creates variable expressions.
     * @param arg the constant to be processed
     * @param resolver a resolver instance for resolving variables etc.
     * @return the resulting expression node
     * @throws TranslatorException in case that the translation fails for some reason, in particular if 
     *     ITER cannot be resolved
     */
    protected Expression processQualifiedValue(Constant arg, R resolver) throws TranslatorException {
        Expression result = null;
        String name = Utils.getQualifiedNameString(arg.getQValue());
        IResolvable res = resolver.resolve(name, false);
        if (null == res) {
            if ("ITER".equals(name)) {
                throw new TranslatorException("iterator variable ITER cannot be resolved", arg, 
                    ExpressionDslPackage.Literals.CONSTANT__QVALUE, ErrorCodes.CANNOT_RESOLVE_ITER);
            }
            TypeDescriptor<? extends IVilType> type = resolver.getTypeRegistry().getType(name);
            if (null == type) {
                if (!resolver.isIvmlElement(name)) {
                    warning("'" + name + "' is unknown, shall be a VIL variable, a VIL type or an IVML variable " 
                        + "/ attribute - may lead to a runtime error", arg, 
                        ExpressionDslPackage.Literals.CONSTANT__QVALUE, ErrorCodes.UNKNOWN_TYPE);
                } 
                result = new VarModelIdentifierExpression(name); // also if elt==null
            } else {
                result = new VilTypeExpression(name, type);
            }
        } else if (res instanceof VariableDeclaration) {
            result = new VariableExpression((VariableDeclaration) res, name);
        } else if (res instanceof IvmlElement) { // from VIL, model is known at parsing time
            result = new VarModelIdentifierExpression(name);
        } else {
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
    protected static final Expression createConstant(TypeDescriptor<? extends IVilType> type, Object value, 
        EObject cause, EStructuralFeature causingFeature, TypeRegistry registry) throws TranslatorException {
        try {
            return new ConstantExpression(type, value, registry);
        } catch (ExpressionException e) {
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
    public TypeDescriptor<? extends IVilType> processType(Type type, R resolver) throws TranslatorException {
        TypeDescriptor<? extends IVilType> result;
        if (null != type.getSeq()) {
            TypeDescriptor<? extends IVilType>[] param = processTypeParameter(type.getParam(), type, resolver);
            try {
                result = TypeRegistry.getSequenceType(param);
            } catch (VilException e) {
                throw new TranslatorException(e, type, ExpressionDslPackage.Literals.TYPE__SEQ);
            }
        } else if (null != type.getSet()) {
            TypeDescriptor<? extends IVilType>[] param = processTypeParameter(type.getParam(), type, resolver);
            try {
                result = TypeRegistry.getSetType(param);
            } catch (VilException e) {
                throw new TranslatorException(e, type, ExpressionDslPackage.Literals.TYPE__SET);
            }
        } else if (null != type.getMap()) {
            TypeDescriptor<? extends IVilType>[] param = processTypeParameter(type.getParam(), type, resolver);
            try {
                result = TypeRegistry.getMapType(param);
            } catch (VilException e) {
                throw new TranslatorException(e, type, ExpressionDslPackage.Literals.TYPE__SET);
            }
        } else {
            String typeName = type.getName();
            result = resolver.getTypeRegistry().getType(typeName);
            if (null == result) {
                throw new TranslatorException("type '" + typeName + "' unknown", type, 
                    ExpressionDslPackage.Literals.TYPE__NAME, ErrorCodes.UNKNOWN_TYPE);
            }
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
            List<TypeDescriptor<? extends IVilType>> dimensions = null;
            List<TypeDescriptor<? extends IVilType>> partDims = new ArrayList<TypeDescriptor<? extends IVilType>>();
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
                        TypeDescriptor<? extends IVilType> partType = part.inferType();
                        for (int d = 0; d < partType.getParameterCount(); d++) {
                            partDims.add(partType.getParameterType(d));
                        }
                    }
                } catch (ExpressionException e) {
                    throw new TranslatorException(e, initEx, 
                        ExpressionDslPackage.Literals.CONTAINER_INITIALIZER_EXPRESSION__CONTAINER);
                }
                if (partDims.isEmpty()) {
                    throw new TranslatorException("unknown dimension of container initializer", initEx, 
                        ExpressionDslPackage.Literals.CONTAINER_INITIALIZER_EXPRESSION__CONTAINER, ErrorCodes.DIMENSION);
                }
                if (null == dimensions) {
                    dimensions = new ArrayList<TypeDescriptor<? extends IVilType>>();
                    dimensions.addAll(partDims);
                } else if (!checkDimensions(dimensions, partDims)) {
                    throw new TranslatorException("unmatching dimension of container initializer", initEx, 
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
     * Checks the dimension types given as parameter for assignment compatibility.
     * 
     * @param d1 the first list of dimension types to be checked (taken as reference)
     * @param d2 the second list of dimension types to be checked
     * @return <code>true</code> if the dimension types are ok, <code>false</code> else
     */
    private boolean checkDimensions(List<TypeDescriptor<? extends IVilType>> d1, 
        List<TypeDescriptor<? extends IVilType>> d2) {
        boolean ok = d1.size() == d2.size();
        for (int d = 0; ok && d < d1.size(); d++) {
            ok = d1.get(d).isAssignableFrom(d2.get(d));
        }
        return ok;
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
    protected TypeDescriptor<? extends IVilType>[] processTypeParameter(TypeParameters param, Type type, R resolver) 
        throws TranslatorException {
        EList<String> typeNames = param.getParam();
        TypeDescriptor<? extends IVilType>[] result = TypeDescriptor.createArray(typeNames.size());
        for (int i = 0; i < typeNames.size(); i++) {
            String typeName = typeNames.get(i);
            result[i] = resolver.getTypeRegistry().getType(typeName);
            if (null == result[i]) {
                throw new TranslatorException("type '" + typeName + "' unknown", type, 
                    ExpressionDslPackage.Literals.TYPE__PARAM, ErrorCodes.UNKNOWN_TYPE);
            }
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
        TypeDescriptor<? extends IVilType> type = processType(decl.getType(), resolver);
        boolean isConstant = null != decl.getConst();
        Expression init = null;
        if (null != decl.getExpression()) {
            init = processExpression(decl.getExpression(), resolver);
            try {
                TypeDescriptor<? extends IVilType> exType = init.inferType();
                boolean ok = type.isAssignableFrom(exType);
                if (!ok && type.isSequence() && exType.isSequence() && 0 == exType.getParameterCount() 
                    && init instanceof ContainerInitializerExpression) {
                    // left side is sequence and right side is empty container initializer - this works
                    ContainerInitializerExpression cie = (ContainerInitializerExpression) init;
                    ok = 0 == cie.getInitExpressionsCount();
                }
                if (!ok) {
                    OperationDescriptor conversion = TypeDescriptor.findConversionOnBoth(exType, type);
                    if (null == conversion) {
                        throw new TranslatorException("variable '" + name + "' of type '" + type.getVilName() + "' cannot be " 
                            + "initialized with an expression of type '" + exType.getVilName() + "'", decl, 
                            ExpressionDslPackage.Literals.VARIABLE_DECLARATION__NAME, ErrorCodes.TYPE_CONSISTENCY);
                    } else {
                        init = new CallExpression(conversion, new CallArgument(init));
                    }
                }
            } catch (ExpressionException e) {
                throw new TranslatorException(e, decl, ExpressionDslPackage.Literals.VARIABLE_DECLARATION__TYPE);
            }
        } 
        I result = createVariableDeclaration(name, type, isConstant, init);
        resolver.add(result);
        return result;
    }


    /**
     * Returns whether resolution shall be continued in case of multiple similar call expressions. 
     * 
     * @param semanticException the exception being thrown by the (partial) call resolution
     * @return <code>true</code> if resolution shall be continued (there was an exception and it points to a resolution 
     *     or a semantic problem), <code>false</code> else
     */
    protected boolean continueResolution(ExpressionException semanticException) {
        return null != semanticException && (semanticException.getId() == ExpressionException.ID_CANNOT_RESOLVE 
            || semanticException.getId() == ExpressionException.ID_SEMANTIC); // legacy
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
     * Convert a string by removing trailing and leading string terminal
     * signs. This is required, as due to the nature of the VIL template 
     * language we will not rely on automatic conversion by xText.
     * 
     * @param string the string to be converted (may be <b>null</b>)
     * @return the same string but without the first and the last character (<b>null</b> 
     *     if <code>string</code> is <b>null</b>)
     */
    public static String convertString(String string) {
        String result;
        if (null == string) {
            result = null;
        } else {
            result = Strings.convertFromJavaString(string.substring(1, string.length() - 1), true);
        }
        return result;
    }
    
    /**
     * Issues implementation warnings about version restrictions.
     * 
     * @param spec the version specification (may be <b>null</b>)
     */
    public void warnVersionRestrictions(VersionSpec spec) {
        if (null != spec) {
            int size = spec.getConflicts().size();
            for (int v = 0; v < size; v++) {
                VersionedId vId = spec.getConflicts().get(v);
    
                warning("currently not (fully) supported", vId, 
                    ExpressionDslPackage.Literals.VERSIONED_ID__VERSION, 0);
            }        
        }
    }

}
