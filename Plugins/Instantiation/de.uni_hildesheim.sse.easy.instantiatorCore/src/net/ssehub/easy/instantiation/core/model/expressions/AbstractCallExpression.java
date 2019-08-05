package net.ssehub.easy.instantiation.core.model.expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Constants;
import net.ssehub.easy.instantiation.core.model.vilTypes.IActualTypeProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaParameterDeclaration;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaType;
import net.ssehub.easy.instantiation.core.model.vilTypes.ITypedModel;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReflectionTypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeHelper;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.EnumValue;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlTypes;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Implements the type checking and automated type conversion mechanism in an abstracted form based on 
 * {@link IMetaType} and {@link IMetaOperation}. The search for matching operations is based on unnamed
 * arguments. Named arguments are ignored here as they are handled differently. 
 * However, results may have to be casted.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractCallExpression extends Expression implements IArgumentProvider {
    
    private static final ResolutionListener RESLIST = new ResolutionListener() {
        
        @Override
        public void resolved(VarModelIdentifierExpression ex) {
            ex.markAsResolved();
        }
        
    };

    private String name;
    private String prefix;

    /**
     * Constructor for serialization.
     */ 
    protected AbstractCallExpression() {
    }
    
    /**
     * Creates an instance from the given call name.
     * 
     * @param name the name of the call
     * @param unqualify reduce the name into name and prefix if possible, else leave name untouched
     * @throws VilException in case of an illegal qualified name
     */
    protected AbstractCallExpression(String name, boolean unqualify) throws VilException {
        this.name = name;
        if (unqualify && null != name) {
            int pos = name.lastIndexOf(Constants.QUALIFICATION_SEPARATOR);
            if (pos > 0) {
                this.prefix = name.substring(0, pos);
                this.name = name.substring(pos + 2, name.length());
                if (0 == this.name.length()) {
                    throw new VilException("illegal qualified name " + name, VilException.ID_INTERNAL);
                }
            }
        }
    }

    /**
     * Returns the name of the call.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the name prefix.
     * 
     * @return the prefix (or <b>null</b> if there is none)
     */
    public String getPrefix() {
        return prefix;
    }
    
    /**
     * Returns the qualified name consisting of {@link #getPrefix()} (if present) and {@link #getName()}.
     * 
     * @return the qualified name
     */
    public String getQualifiedName() {
        String result;
        if (null == prefix) {
            result = name;
        } else {
            result = prefix + Constants.QUALIFICATION_SEPARATOR + name;
        }
        return result;
    }

    /**
     * Returns whether a given operation is an actual candidate for this 
     * call expression.
     * 
     * @param op the operation to be compared
     * @param name the name of the operation call to be resolved
     * @param argCount the number of required arguments
     * @return <code>true</code> if <code>desc</code> is a candidate, <code>false</code> else
     */
    /*protected static boolean isCandidate(IMetaOperation op, String name, int argCount) {
        boolean result; 
        if (null != op && op.getName().equals(name)) {
            // in case of default parameters, the actual number of required params may be less than the given ones
            int reqParam = op.getRequiredParameterCount();
            if (argCount > 0) {
                result = reqParam > 0 && reqParam <= argCount && argCount <= op.getParameterCount();
            } else {
                result = reqParam == 0;
            }
        } else {
            result = false;
        }
        return result;
    }*/

    /**
     * Returns the parameter type considering named parameters. After unnamed arguments, this method may
     * switch to parameter names.
     * 
     * @param operation the operation
     * @param index the parameter index
     * @param arguments the arguments
     * @param unnamedArgsCount the number of unnamed arguments
     * @return the parameter type (may be <b>null</b> if there is none / legacy optional named parameter)
     */
    protected static IMetaType getParameterType(IMetaOperation operation, int index, CallArgument[] arguments, 
        int unnamedArgsCount) {
        IMetaType result;
        if (index < unnamedArgsCount) {
            result = operation.getParameterType(index);
        } else {
            IMetaParameterDeclaration pDecl;
            if (index < arguments.length) { // named after unnamed
                pDecl = operation.getParameter(arguments[index].getName());
                if (null != pDecl) {
                    result = pDecl.getType();
                } else {
                    result = null;
                }
            } else { // optional not given
                result = operation.getParameterType(index);
            }
        }
        return result;
    }

    /**
     * Derives the assignable candidates from <code>operand</code>, i.e., operations which 
     * can be directly applied with identical parameters or (second step) with assignable 
     * parameters but without parameter conversion.
     * 
     * @param operand the operand of the call to be resolved
     * @param name the name of the operation call to be resolved
     * @param arguments the arguments of the call
     * @param allowAny allow AnyType as assignable parameter type (dynamic dispatch)
     * @param unnamedArgsCount the number of unnamed arguments in <code>arguments</code>
     * @return the list of candidate operations
     * @throws VilException in case of type resolution problems or in case of an ambiguous call specification
     */
    private static List<IMetaOperation> assignableCandidates(IMetaType operand, String name, CallArgument[] arguments, 
        int unnamedArgsCount, boolean allowAny) throws VilException {
        List<IMetaOperation> result = new ArrayList<IMetaOperation>();
        IMetaType[] argumentTypes = toTypeDescriptors(arguments);
        List<IMetaOperation> candidates = operand.getCandidates(name, unnamedArgsCount);
        for (int o = 0; o < candidates.size(); o++) {
            IMetaOperation desc = candidates.get(o);
            boolean allEqual = true;
            for (int p = 0; allEqual && p < arguments.length; p++) {
                IMetaType pType = getParameterType(desc, p, arguments, unnamedArgsCount);
                if (null != pType) { // pType==null legacy: undeclared unnamed parameters
                    IMetaType aType = argumentTypes[p];
                    allEqual &= TypeRegistry.equals(pType, aType);
                    if (!allEqual) {
                        IMetaOperation funcOp = resolveResolvableOperation(null, pType, aType, 
                            arguments[p].getExpression(), RESLIST);
                        if (null != funcOp) {
                            arguments[p].resolveOperation((TypeDescriptor<?>) pType, funcOp);
                            allEqual = true;
                        }
                    }
                }
            }
            if (allEqual) {
                result.add(desc);
            }
        }
        if (result.isEmpty()) {
            int minAssignables = 0;
            for (int o = 0; o < candidates.size(); o++) {
                IMetaOperation desc = candidates.get(o);
                boolean allAssignable = true;
                int aCount = 0;
                final TypeDescriptor<?> any = TypeRegistry.anyType();
                for (int p = 0; allAssignable && p < arguments.length; p++) {
                    IMetaType pType = getParameterType(desc, p, arguments, unnamedArgsCount);
                    IMetaType aType = argumentTypes[p];
                    // pType==null legacy: undeclared unnamed parameters
                    if (null != pType) { 
                        if (pType.isAssignableFrom(aType) || (allowAny && any == pType)) {
                            aCount += (pType != aType) ? 1 : 0;
                        } else {
                            allAssignable = false;
                        }
                    }
                }
                if (allAssignable) {
                    // consider only minimum number of implicit conversions -> dynamic dispatch
                    if (0 == minAssignables || aCount < minAssignables) {
                        result.clear();
                        minAssignables = aCount;
                    } 
                    if (aCount == minAssignables) {
                        addAndPruneByType(result, desc, argumentTypes, arguments, unnamedArgsCount);
                    }
                }
            }
        }
        if (result.size() > 1) {
            throw new VilException(toSignatures(result) + " are ambiguous" , VilException.ID_AMBIGUOUS);
        }
        return result;
    }

    /**
     * Turns the signatures of the given <code>operations</code> into a string.
     * 
     * @param operations the operations
     * @return the string containing all signatures
     */
    private static String toSignatures(Iterable<IMetaOperation> operations) {
        StringBuilder tmp = new StringBuilder();
        for (IMetaOperation op : operations) {
            if (tmp.length() > 0) {
                tmp.append(",");
            }
            tmp.append(op.getSignature());
        }
        return tmp.toString();
    }

    /**
     * Resolves a resolvable operation ("function pointer").
     * 
     * @param operand the operand (must also be of type {@link IModel}, may be <b>null</b> then the model from 
     *     <code>initExpression</code> is taken if it is a {@link VarModelIdentifierExpression})
     * @param pType the parameter type
     * @param aType the argument type
     * @param initExpression the initialization expression (shall be of <code>aType</code>)
     * @param listener the listener to be informed about the variability model identifier resolution done
     * @return the resolved operation if there is one, else <b>null</b>
     * @throws VilException in case of type resolution problems
     */
    public static IMetaOperation resolveResolvableOperation(IMetaType operand, IMetaType pType, IMetaType aType, 
        Expression initExpression, ResolutionListener listener) throws VilException {
        IMetaOperation result = null;
        if (initExpression instanceof VarModelIdentifierExpression) {
            VarModelIdentifierExpression varModelIdEx = (VarModelIdentifierExpression) initExpression;
            if (null == operand) {
                operand = varModelIdEx.getModel();
            }
            if (TypeRegistry.resolvableOperationType().isAssignableFrom(pType) 
                && IvmlTypes.ivmlElement().isAssignableFrom(aType) && operand instanceof IModel) {
                String opName = varModelIdEx.getIdentifier();
                CallArgument[] args = toTypeDescriptors(pType, 1);
                List<IMetaOperation> ops = assignableCandidates(operand, opName, args, args.length, false);
                if (1 == ops.size()) { // return type may also select
                    IMetaOperation functionOp = ops.get(0);
                    TypeDescriptor<?> ret = pType.getGenericParameterType(pType.getGenericParameterCount() - 1);
                    if (ReflectionTypeDescriptor.VOID == ret 
                        || ret.isAssignableFrom(functionOp.getReturnType())) {
                        result = functionOp;
                        listener.resolved(varModelIdEx);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Turns the generic parameter types of <code>type</code> into an array.
     * 
     * @param type the type to take the generic parameters from
     * @param exclude the amount of parameters at the end of the generics to be excluded
     *    (operation return)
     * @return the related type descriptors according sequence of generic types
     */
    private static CallArgument[] toTypeDescriptors(IMetaType type, int exclude) {
        CallArgument[] result = new CallArgument[Math.max(0, type.getGenericParameterCount() - exclude)];
        for (int a = 0; a < result.length; a++) {
            result[a] = new CallArgument(type.getGenericParameterType(a));
        }
        return result;
    }

    /**
     * Turns the given call arguments to type descriptors.
     * 
     * @param args the arguments to be turned into type descriptors
     * @return the related type descriptors according to the input sequence
     * @throws VilException in case that obtaining a type fails
     */
    private static IMetaType[] toTypeDescriptors(CallArgument[] args) throws VilException {
        IMetaType[] result = new IMetaType[args.length];
        for (int a = 0; a < args.length; a++) {
            result[a] = args[a].inferType();
        }
        return result;
    }

    /**
     * Adds <code>toAdd</code> to <code>candidates</code> if it is considered as the best candidate with respect
     * to the given <code>argTypes</code>. May prune existing candidates with lower ranking.
     * 
     * @param candidates the candidates to modify
     * @param toAdd the candidate to add if it is the best candidate
     * @param argTypes the argument types
     * @param arguments the actual arguments
     * @param unnamedArgsCount the number of unnamed arguments in <code>arguments</code>
     */
    private static void addAndPruneByType(List<IMetaOperation> candidates, IMetaOperation toAdd, IMetaType[] argTypes, 
        CallArgument[] arguments, int unnamedArgsCount) {
        if (!candidates.isEmpty()) {
            int toAddDiff = calcTypeDiff(toAdd, argTypes, arguments, unnamedArgsCount);
            // multiple conversion-equivalent candidates
            for (int i = candidates.size() - 1; i >= 0; i--) {
                IMetaOperation op = candidates.get(i);
                int opDiff = calcTypeDiff(op, argTypes, arguments, unnamedArgsCount);
                if (toAddDiff < opDiff) {
                    candidates.remove(i);
                }
            }
        }
        if (candidates.isEmpty()) {
            candidates.add(toAdd);
        } 
    }
    
    /**
     * Calculates the differences in types between the given <code>operation</code> and the given argument types.
     * 
     * @param operation the operation to compare
     * @param argTypes the argument types to take into account
     * @param arguments the actual arguments
     * @param unnamedArgsCount the number of unnamed arguments in <code>arguments</code>
     * @return the (pseudo) difference in number of types
     */
    private static int calcTypeDiff(IMetaOperation operation, IMetaType[] argTypes, CallArgument[] arguments, 
        int unnamedArgsCount) {
        int diff = 0;
        for (int p = 0; p < argTypes.length; p++) {
            IMetaType pType = getParameterType(operation, p, arguments, unnamedArgsCount);
            IMetaType aType = argTypes[p];
            if (!TypeRegistry.equals(pType, aType)) {
                diff += calcSuperDiffRec(aType, pType); // iterate over argType, consider generic parameter??
            } // diff += 0
        }
        return diff;
    }
    
    /**
     * Calculates the difference of super types from <code>reference</code> to <code>iter</code>
     * over the types and their generic parameter.
     * 
     * @param iter the node to follow the super type hierarchy
     * @param reference the node to search for
     * @return the difference if found, <code>0</code> if equal, a value of at least <code>100</code> if not found 
     *     (shall not occur)
     */
    private static int calcSuperDiffRec(IMetaType iter, IMetaType reference) {
        int diff = calcSuperDiff(iter, reference); // iterate over argType, consider generic parameter??
        for (int p = 0; p < iter.getGenericParameterCount(); p++) {
            diff += calcSuperDiffRec(iter.getGenericParameterType(p), reference.getGenericParameterType(p));
        }
        return diff;
    }

    /**
     * Calculates the difference of super types from <code>reference</code> to <code>iter</code>.
     * 
     * @param iter the node to follow the super type hierarchy
     * @param reference the node to search for
     * @return the difference if found, <code>0</code> if equal, <code>100</code> if not found (shall not occur)
     */
    private static int calcSuperDiff(IMetaType iter, IMetaType reference) {
        int diff = 0;
        while (null != iter && !TypeRegistry.equals(iter, reference)) {
            diff++;
            iter = iter.getSuperType();
        }
        if (null == iter) {
            diff = 100; // not found, strange, higher than a typical hierarchy
        }
        return diff;
    }

    /**
     * Stores an operation as well as the required type conversion operations.
     * 
     * @author Holger Eichelberger
     */
    private static class ConvertibleOperation {
        private IMetaOperation operation;
        private IMetaOperation[] conversions; // same length as parameter!
        
        /**
         * Creates a convertible operation instance describing the operation as well as
         * the required conversions per parameter.
         * 
         * @param operation the candidate operation resolving this call expression
         * @param conversions the conversion operations (may contain <b>null</b> values
         *   if a conversion for a specific parameter is not required)
         */
        ConvertibleOperation(IMetaOperation operation, IMetaOperation[] conversions) {
            this.operation = operation;
            this.conversions = conversions;
        }
        
        /**
         * Returns the conversions core to compare similar canidates.
         * 
         * @param arguments the actual arguments
         * @param unnamedArgsCount the number of unnamed arguments in <code>arguments</code>
         * @return the number of conversions
         * @throws VilException in case that types cannot be inferred
         */
        public int getScore(CallArgument[] arguments, int unnamedArgsCount) throws VilException {
            int score = 0;
            final int step = operation.getParameterCount();
            for (int c = 0; c < conversions.length; c++) {
                IMetaType pType = getParameterType(operation, c, arguments, unnamedArgsCount);
                if (null == conversions[c]) {
                    IMetaType aType = arguments[c].inferType();
                    if (pType != aType) { 
                        score += 1; // implicit conversion
                    }
                } else { // score += 0
                    IMetaType cType = conversions[c].getReturnType();
                    if (pType == cType) { 
                        score += step; // explicit conversion
                    } else {
                        score += step * step; // dynamic dispatch, defer - decide at runtime
                    }
                }
            }
            return score;
        }
    }
    
    /**
     * Derives the convertible candidates from <code>operand</code>, i.e., operations which 
     * can be applied including parameter conversion.
     * 
     * @param operand the operand of the call to be resolved
     * @param name the name of the operation call to be resolved
     * @param arguments the arguments of the call
     * @param unnamedArgsCount the number of unnamed arguments in <code>arguments</code>
     * @return the list of candidate operations including their required conversions
     * @throws VilException in case of type resolution problems or in case of an ambiguous call specification
     */
    private static List<ConvertibleOperation> convertibleCandidates(IMetaType operand, String name, 
        CallArgument[] arguments, int unnamedArgsCount) throws VilException {
        List<ConvertibleOperation> result = new ArrayList<ConvertibleOperation>();
        List<IMetaOperation> candidates = operand.getCandidates(name, unnamedArgsCount);
        for (int o = 0; o < candidates.size(); o++) {
            IMetaOperation desc = candidates.get(o);
            int conversionCount = 0;
            IMetaOperation[] conversionOps = new IMetaOperation[arguments.length]; 
            boolean allParamOk = true;
            for (int p = 0; allParamOk && p < desc.getParameterCount(); p++) {
                IMetaType pType = getParameterType(desc, p, arguments, unnamedArgsCount);
                IMetaType argType = p < arguments.length ? arguments[p].inferType() : null;
                // pType==null legacy: undeclared unnamed parameters
                if (null != argType && null != pType && !pType.isAssignableFrom(argType)) {
                    conversionOps[p] = TypeHelper.findConversion(argType, pType);
                    if (null != conversionOps[p]) {
                        if (argType.checkConversion(pType, conversionOps[p])) {
                            conversionCount++;
                        } else {
                            conversionOps[p] = null;
                        }
                    }
                    allParamOk = (null != conversionOps[p]);
                }
            }
            if (allParamOk && conversionCount > 0) {
                assert null != conversionOps && conversionOps.length == arguments.length;
                result.add(new ConvertibleOperation(desc, conversionOps));
                conversionOps = new IMetaOperation[arguments.length];
            } else {
                Arrays.fill(conversionOps, null);
            }
        }
        if (result.size() > 1) {
            result = selectAmongMultipleCandidates(result, arguments, unnamedArgsCount);
            if (result.size() > 1) {
                StringBuilder tmp = new StringBuilder();
                for (ConvertibleOperation op : result) {
                    if (tmp.length() > 0) {
                        tmp.append(",");
                    }
                    tmp.append(op.operation.getSignature());
                }
                throw new VilException(tmp + " are ambiguous", VilException.ID_AMBIGUOUS);
            }
        }
        return result;
    }

    /**
     * Selects among multiple convertible candidates.
     * 
     * @param candidates the candidates
     * @param arguments the actual arguments
     * @param unnamedArgsCount the number of unnamed arguments in <code>arguments</code>
     * @return <code>candidates</code> or a list with exactly one candidate
     * @throws VilException in case that types cannot be inferred
     */
    private static List<ConvertibleOperation> selectAmongMultipleCandidates(List<ConvertibleOperation> candidates, 
        CallArgument[] arguments, int unnamedArgsCount) throws VilException {
        ConvertibleOperation op = null;
        int opCount = 0;
        int minScore = Integer.MAX_VALUE;
        for (int c = 0; c < candidates.size(); c++) {
            ConvertibleOperation tmp = candidates.get(c);
            int score = tmp.getScore(arguments, unnamedArgsCount);
            if (null == op || score < minScore) {
                op = tmp;
                minScore = score;
                opCount = 1;
            } else if (minScore == score) {
                opCount++;
            }
        }
        if (opCount == 1) {
            candidates.clear();
            candidates.add(op);
        } 
        return candidates;
    }

    /**
     * Resolves the given operation on <code>operand</code>.
     * 
     * @param operand the operand, i.e., the type to be searched for operations
     * @param name the name of the operation to be resolved
     * @param arguments the (named) arguments of the call
     * @return the resolved operation
     * @throws VilException in case that no resolution can be found for various (typically type compliance) 
     *   reasons
     */
    public static IMetaOperation resolveOperation(IMetaType operand, String name, CallArgument... arguments) 
        throws VilException {
        IMetaOperation op = null;
        try {
            op = resolveOperation(operand, name, arguments, true, false);
        } catch (VilException e) {
            // operand is fixed... let's try for a conversion
            try {
                if (null != arguments && arguments.length > 0 && !(operand instanceof IModel)) {
                    // model is resolved before - consider only matching there as otherwise arbitrary operations on
                    // string may shadow artifact operations; this conversion is last resort on artifact level
                    IMetaType opType = arguments[0].inferType();
                    if (2 == arguments.length) { // it could be an operator and the first could be a decision variable
                        op = tryOpConversionToSecond(opType, name, arguments);
                    }
                    if (null == op) {
                        op = resolveFallbacks(opType, name, arguments);
                        if (null == op) {
                            throw e;
                        }
                    }
                } else {
                    throw e;
                }
            } catch (VilException e1) {
                throw e;
            }
        }
        return op;
    }
    
    /**
     * Last resort resolution, try with String or in case of a decision variable with the primitive types it can 
     * represent.
     * 
     * @param opType the operand type
     * @param name the operation name
     * @param arguments the arguments
     * @return the operation or <b>null</b> if there is none
     */
    private static IMetaOperation resolveFallbacks(IMetaType opType, String name, CallArgument[] arguments) {
        IMetaOperation op = null;
        List<IMetaType> fallback = new ArrayList<IMetaType>();
        fallback.add(TypeRegistry.stringType());
        if (IvmlTypes.decisionVariableType().isAssignableFrom(opType)) {
            fallback.add(TypeRegistry.booleanType());
            fallback.add(TypeRegistry.realType());
            fallback.add(TypeRegistry.integerType());
        }
        IMetaOperation convOp = null;
        for (int f = 0; null == op && f < fallback.size(); f++) {
            IMetaType fType = fallback.get(f);
            convOp = TypeHelper.findConversion(opType, fType); // includes Any->String
            if (null != convOp) {
                try {
                    op = resolveOperation(fType, name, arguments, true, false);
                    if (opType == TypeRegistry.anyType()) {
                        arguments[0].insertConversion(convOp);
                        // ANY is assignable by itself, other conversion
                        // will be added on the way but for ANY the conversion
                        // is still needed
                    } 
                } catch (VilException e1) {
                    // see below if not found
                }
            }
        }
        return op;
    }

    /**
     * Resolves the given operation on <code>operand</code>, but allows checking the first field for a meta type 
     * (e.g., DecisionVariable instead of the actual field type).
     * 
     * @param operand the operand, i.e., the type to be searched for operations
     * @param checkMetaForFirstArgField whether the check for the meta type shall be enabled on the first field 
     *   (replacing operand) or not. In case that this is enabled and there is a compliant operation for meta type,
     *   the found operation is returned.
     * @param name the name of the operation to be resolved
     * @param arguments the (named) arguments of the call
     * @return the resolved operation
     * @throws VilException in case that no resolution can be found for various (typically type compliance) 
     *   reasons
     */
    public static IMetaOperation resolveOperation(IMetaType operand, boolean checkMetaForFirstArgField, String name, 
        CallArgument[] arguments) throws VilException {
        IMetaOperation op = null;
        if (arguments.length > 0 && checkMetaForFirstArgField 
            && arguments[0].getExpression() instanceof FieldAccessExpression) {
            FieldAccessExpression fae = (FieldAccessExpression) arguments[0].getExpression();
            TypeDescriptor<?> fOperand = fae.getField().getMetaType();
            if (null != fOperand) {
                CallArgument[] args = new CallArgument[arguments.length];
                args[0] = new CallArgument(fOperand);
                for (int a = 1; a < arguments.length; a++) {
                    args[a] = arguments[a];
                }
                try {
                    try {
                        op = resolveOperation(fOperand, name, args);
                    } catch (VilException e) {
                        op = resolveOperationOnModel(operand, name, args, new HashSet<Object>());
                    }
                    if (null != op && null == args[0].getExpression() /*&& op instanceof OperationDescriptor*/) {
                        fae.enableMetaAccess();
                    } else {
                        op = null; // args[0] indicates that a conversion was inserted; no conversions here!
                    }
                } catch (VilException e) {
                    // ignore as this was just a trial
                }
            }
        }
        if (null == op) {
            op = resolveOperation(operand, name, arguments);
        }
        return op;        
    }

    /**
     * Resolves the given operation on <code>operand</code>, considering <code>operand</code> as a model with imports.
     * 
     * @param operand the operand, i.e., the model to be searched for operations
     * @param name the name of the operation to be resolved
     * @param arguments the (named) arguments of the call
     * @param done already searched models
     * @return the resolved operation
     * @throws VilException in case that no resolution can be found for various (typically type compliance) 
     *   reasons
     */
    private static IMetaOperation resolveOperationOnModel(Object operand, String name, CallArgument[] arguments, 
        java.util.Set<Object> done) throws VilException {
        IMetaOperation op = null;
        if (operand instanceof ITypedModel) {
            ITypedModel model = (ITypedModel) operand;
            if (!done.contains(model)) {
                done.add(model);
                try {
                    op = resolveOperation(model, name, arguments);
                } catch (VilException e) {
                    // op -> null
                }
                for (int i = 0; null == op && i < model.getImportsCount(); i++) {
                    try {
                        op = resolveOperationOnModel(model.getImport(i).getResolved(), name, arguments, done);
                    } catch (VilException e) {
                        // op -> null
                    }
                }
            }
        }
        return op;
    }

    /**
     * Tries to convert the operand to the second argument type and resolves it.
     * 
     * @param opType the operand type
     * @param name the name of the operation
     * @param arguments the actual call arguments
     * @return the operation if resolved, <b>null</b> else
     * @throws VilException in case of type resolution problems
     */
    private static IMetaOperation tryOpConversionToSecond(IMetaType opType, String name, CallArgument[] arguments) 
        throws VilException {
        IMetaOperation op = null;
        IMetaType sndArgType = arguments[1].inferType();
        IMetaOperation convOp = TypeHelper.findConversion(opType, sndArgType);
        if (null != convOp) {
            try {
                // may already insert conversion
                op = resolveOperation(sndArgType, name, arguments, true, false);
                // don't accidentally insert conversion twice
                if (!op.getReturnType().isAssignableFrom(sndArgType)) { 
                    arguments[0].insertConversion(convOp);
                }
            } catch (VilException e1) {
                // ok, let's try strings
            }
        }
        return op;
    }
    
    /**
     * Actually aims at resolving the operation.
     * 
     * @param operand the operand, i.e., the type to be searched for operations
     * @param name the name of the operation to be resolved
     * @param arguments the (named) arguments of the call
     * @param allowConversion whether conversion shall be allowed
     * @param allowAny allow AnyType as assignable parameter type (dynamic dispatch)
     * @return the resolved operation
     * @throws VilException in case that no resolution can be found for various (typically type compliance) 
     *   reasons
     */
    private static IMetaOperation resolveOperation(IMetaType operand, String name, CallArgument[] arguments, 
        boolean allowConversion, boolean allowAny) throws VilException {
        IMetaOperation resolved = null;
        // check for direct applicable candidates
        int unnamedArgsCount = CallArgument.countUnnamedArguments(arguments);
        List<IMetaOperation> candidates = assignableCandidates(operand, name, arguments, unnamedArgsCount, allowAny);
        if (1 == candidates.size()) {
            resolved = candidates.get(0);
        } else if (allowConversion) {
            // check for candidates by conversion
            List<ConvertibleOperation> convertible = convertibleCandidates(operand, name, arguments, unnamedArgsCount);
            if (0 == convertible.size() && null != operand.getBaseType()) {
                // also operand operations must be considered
                convertible = convertibleCandidates(operand.getBaseType(), name, arguments, unnamedArgsCount);
            }
            if (1 == convertible.size()) {
                ConvertibleOperation found = convertible.get(0);
                // replace parameter expression by transparent call expression to conversion call
                resolved = found.operation;
                for (int i = 0; i < unnamedArgsCount; i++) { // same length as conversions
                    IMetaOperation conversionOp = found.conversions[i];
                    if (null != conversionOp) {
                        arguments[i].insertConversion(conversionOp);
                    }
                }
            }
        }
        if (null == resolved) {
            // try to go for a placeholder, works only on placeholder types
            resolved = operand.addPlaceholderOperation(name, unnamedArgsCount, arguments.length - unnamedArgsCount > 0);
        }
        if (null == resolved) {
            throw new VilException("cannot resolve operation " + getSignature(name, arguments), 
                VilException.ID_CANNOT_RESOLVE);
        } else {
            int optionalNamed = 0;
            for (int i = unnamedArgsCount; i < arguments.length; i++) {
                if (null == resolved.getParameter(arguments[i].getName())) {
                    optionalNamed++;
                }
            }
            if (optionalNamed > 0 && !resolved.acceptsNamedParameters()) {
                // difference indicates named parameter
                // use java signature as it is the matching signature!
                throw new VilException(resolved.getJavaSignature() 
                    + " does not accept (optional) named parameters", VilException.ID_CANNOT_RESOLVE);
            }
        }
        return resolved;
    }

/*    
private static final String toString(CallArgument[] args) {
    String res = "";
    for (int a = 0; a < args.length; a++) {
        if (a > 0) {
            res += ", ";
        }
        if (null != args[a].getName()) {
            res += args[a].getName();
            res += " ";
        }
        res += args[a].getExpression();
    }
    return res;
}*/
    
    /**
     * Returns a java-like signature for the specified operation.
     * 
     * @param name the name of the operation
     * @param arguments the (named) arguments of the call
     * @return the signature
     */
    public static final String getSignature(String name, CallArgument[] arguments) {
        StringBuilder signature = new StringBuilder(name);
        signature.append("(");
        for (int a = 0; a < arguments.length; a++) {
            CallArgument arg = arguments[a];
            if (arg.hasName()) {
                signature.append(arg.getName());
                signature.append(" = ");
            }
            try {
                signature.append(arguments[a].inferType().getName());
            } catch (VilException e) {
                signature.append("<unknown>");
            }
            if (a < arguments.length - 1) {
                signature.append(",");
            }
        }
        signature.append(")");
        return signature.toString();
    }
    
    /**
     * Determines the actual type of <code>object</code>. Considers {@link IMetaType#isActualTypeOf(IMetaType)}.
     * 
     * @param type the type of <code>object</code>
     * @param object the object to determine the type for
     * @param registry the responsible type registry
     * @return <code>type</code> or the actual type of <code>object</code>
     */
    private static IMetaType determineActualType(IMetaType type, Object object, TypeRegistry registry) {
        IMetaType result = type;
        if (object instanceof IActualTypeProvider) {
            IDatatype actualType = ((IActualTypeProvider) object).determineActualTypeName();
            if (null != actualType) {
                IMetaType tmpType = registry.getType(actualType);
                if (null != tmpType && tmpType.isActualTypeOf(type)) {
                    result = tmpType;
                }
            }
        }
        return result;
    }

    /**
     * Returns the VIL type for an enum value.
     * 
     * @param registry the type registry
     * @param val the enum value
     * @return the enum type or <b>null</b>
     */
    private static IMetaType getEnumType(TypeRegistry registry, EnumValue val) {
        IMetaType tmp = registry.getType(val.getDatatype());
        if (null == tmp) {
            tmp = registry.getType(EnumValue.class);
        }
        return tmp;
    }
    
    /**
     * Aims at re-resolving the given operation according to the dynamic types of <code>args</code>.
     * Argument-less operations are not dispatched dynamically.
     * 
     * @param <O> the actual type of operation
     * 
     * @param operation the operation to be considered
     * @param args the arguments
     * @param cls the type of operation
     * @param registry the (local) type registry
     * @param arguments access to the declared arguments
     * @return <code>operation</code> or the one determined dynamically
     */
    public static <O extends IMetaOperation> O dynamicDispatch(O operation, Object[] args, Class<O> cls, 
        TypeRegistry registry, IArgumentProvider arguments) {
        O result = operation;
        int offset = 0;
        if (operation.isFirstParameterOperand()) {
            offset = 1;
        }
        if (args.length >= offset) { // do only try to dispatch if there is at least one parameter
            IMetaType operand = operation.getDeclaringType();
            if (null != operand && operand.enableDynamicDispatch()) {
                CallArgument[] types = new CallArgument[args.length - offset];
                boolean allSame = true;
                boolean failure = false;
                int a = 0;
                while (!failure && a < operation.getRequiredParameterCount()) { //args.length) {
                    String argName = arguments.getArgument(a).getName(); 
                    if (null == args[a]) {
                        if (a - offset < 0) {
                            failure = true;
                        } else {
                            types[a - offset] = new CallArgument(argName, 
                                (TypeDescriptor<?>) operation.getParameterType(a));
                            //types[a - offset] = new CallArgument((TypeDescriptor<?>) operation.getParameterType(a));
                            a++;
                        }
                    } else {
                        IMetaType tmp;
                        if (args[a] instanceof EnumValue) {
                            tmp = getEnumType(registry, (EnumValue) args[a]);
                        } else {
                            tmp = registry.obtainTypeDescriptor(args[a]);
                        }
                        tmp = determineActualType(tmp, args[a], registry);
                        if (null == tmp) {
                            tmp = operation.getParameterType(a);
                        } else {
                            allSame &= tmp == operation.getParameterType(a);
                        }
                        if (0 == a && offset > 0) {
                            operand = tmp;
                        } else {
                            if (tmp instanceof TypeDescriptor) {
                                types[a - offset] = new CallArgument(argName, (TypeDescriptor<?>) tmp); // ugly
                                //types[a - offset] = new CallArgument((TypeDescriptor<?>) tmp); // ugly
                            } else {
                                failure = true;
                            }
                        }
                        a++;
                    }
                }
                // fill named/optional
                while (!failure && a < types.length) {
                    types[a] = new CallArgument("name", (Expression) null);
                    a++;
                }
                if (!allSame && !failure) {
                    try {
                        // no additional conversion while dynamic dispatch
                        IMetaOperation op = resolveOperation(operand, operation.getName(), types, false, true);
                        if (cls.isInstance(op)) {
                            result = cls.cast(op);
                        }
                    } catch (VilException e) {
                        // this may happen but then the passed in operation is ok and no other was found
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Returns whether the specified operation is a placeholder and cannot be executed,
     * i.e., the operation itself is a placeholder or a placeholder type is used in its
     * signature.
     * 
     * @param operation the operation to be tested
     * @return <code>true</code> if <code>operation</code> is a placeholder, <code>false</code> else
     */
    protected static boolean isPlaceholder(IMetaOperation operation) {
        boolean isPlaceholder;
        if (null == operation) {
            isPlaceholder = true;
        } else {
            isPlaceholder = operation.isPlaceholder();
            if (!isPlaceholder) {
                isPlaceholder = operation.getReturnType().isPlaceholder();
                for (int p = 0; !isPlaceholder && p < operation.getParameterCount(); p++) {
                    isPlaceholder = operation.getParameterType(p).isPlaceholder();
                }
            }
        }
        return isPlaceholder;
    }
    
    /**
     * Returns the VIL signature of the specified <code>operation</code>.
     * 
     * @param operation the operation to return the VIL signature for
     * @return the VIL signature (for messages, warnings, errors, etc.)
     */
    protected String getVilSignature(IMetaOperation operation) {
        String result;
        if (null == operation) {
            result = name + "(?)";
        } else {
            result = operation.getSignature();
        }
        return result;
    }

    /**
     * Returns whether this operation is a placeholder, i.e., either the resolved operation is 
     * a {@link IMetaOperation#isPlaceholder() placeholder}, its signature or its return 
     * type does contain a {@link IMetaType#isPlaceholder() placeholder type}.
     * 
     * @return <code>true</code> if this operation is a placeholder and cannot be executed, <code>false</code> else
     */
    public abstract boolean isPlaceholder();
    
    /**
     * Returns the VIL signature of the resolved operation.
     * 
     * @return the VIL signature 
     */
    public abstract String getVilSignature();

    /**
     * Returns whether this operation is OCL compliant or flagged as not compliant.
     * 
     * @return <code>true</code> for compliant, <code>false</code> else
     */
    public boolean isOclCompliant() {
        return true;
    }

    /**
     * Returns whether this operation is a collection-iterator operation.
     * 
     * @return <code>true</code> for collection-iterator, <code>false</code> else
     */
    public boolean isIteratingCollectionOperation() {
        return false;
    }
    
    /**
     * Returns the number of arguments.
     * 
     * @return the number of arguments
     */
    public abstract int getArgumentsCount();    
    /**
     * Returns the specified argument.
     * 
     * @param index the 0-based index of the argument to return
     * @return the argument
     * @throws IndexOutOfBoundsException in case that 
     *   <code>index &lt; 0 || index &gt;={@link #getArgumentsCount()}</code>
     */
    public abstract CallArgument getArgument(int index);

}
