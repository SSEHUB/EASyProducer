package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IActualTypeProvider;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaOperation;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeHelper;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.EnumValue;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;

/**
 * Implements the type checking and automated type conversion mechanism in an abstracted form based on 
 * {@link IMetaType} and {@link IMetaOperation}. The search for matching operations is based on unnamed
 * arguments. Named arguments are ignored here as they are handled differently. 
 * However, results may have to be casted.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractCallExpression extends Expression {

    private String name;
    private String prefix;

    /**
     * Creates an instance from the given call name.
     * 
     * @param name the name of the call
     * @param unqualify reduce the name into name and prefix if possible, else leave name untouched
     * @throws ExpressionException in case of an illegal qualified name
     */
    protected AbstractCallExpression(String name, boolean unqualify) throws ExpressionException {
        this.name = name;
        if (unqualify && null != name) {
            int pos = name.lastIndexOf(Constants.QUALIFICATION_SEPARATOR);
            if (pos > 0) {
                this.prefix = name.substring(0, pos);
                this.name = name.substring(pos + 2, name.length());
                if (0 == this.name.length()) {
                    throw new ExpressionException("illegal qualified name " + name, ExpressionException.ID_INTERNAL);
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
     * @param arguments the unnamed arguments
     * @return <code>true</code> if <code>desc</code> is a candidate, <code>false</code> else
     */
    protected static boolean isCandidate(IMetaOperation op, String name, CallArgument[] arguments) {
        return null != arguments && op.getName().equals(name) && op.getParameterCount() == arguments.length;
    }
    
    /**
     * Derives the assignable candidates from <code>operand</code>, i.e., operations which 
     * can be directly applied with identical parameters or (second step) with assignable 
     * parameters but without parameter conversion.
     * 
     * @param operand the operand of the call to be resolved
     * @param name the name of the operation call to be resolved
     * @param arguments the (unnamed) arguments of the call
     * @return the list of candidate operations
     * @throws ExpressionException in case of type resolution problems or in case of an ambiguous call specification
     */
    private static List<IMetaOperation> assignableCandidates(IMetaType operand, String name, CallArgument[] arguments) 
        throws ExpressionException {
        List<IMetaOperation> result = new ArrayList<IMetaOperation>();
        for (int o = 0; o < operand.getOperationsCount(); o++) {
            IMetaOperation desc = operand.getOperation(o);
            if (isCandidate(desc, name, arguments)) {
                boolean allEqual = true;
                for (int p = 0; allEqual && p < arguments.length; p++) {
                    allEqual &= TypeRegistry.equals(desc.getParameterType(p), arguments[p].inferType());
                }
                if (allEqual) {
                    result.add(desc);
                }
            }
        }
        if (result.isEmpty()) {
            int minAssignables = 0;
            for (int o = 0; o < operand.getOperationsCount(); o++) {
                IMetaOperation desc = operand.getOperation(o);
                if (isCandidate(desc, name, arguments)) {
                    boolean allAssignable = true;
                    int aCount = 0;
                    for (int p = 0; allAssignable && p < arguments.length; p++) {
                        IMetaType pType = desc.getParameterType(p);
                        IMetaType aType = arguments[p].inferType();
                        if (pType.isAssignableFrom(aType)) {
                            if (pType != aType) {
                                aCount++;
                            }
                        } else {
                            allAssignable = false;
                        }
                    }
                    if (allAssignable) {
                        // consider only minimum number of implicit conversions -> dynamic dispatch
                        if (0 == minAssignables || aCount < minAssignables) {
                            result.clear();
                            minAssignables = aCount;
                        } 
                        if (aCount == minAssignables) {
                            result.add(desc);
                        }
                    }
                }
            }
        }
        if (result.size() > 1) {
            StringBuilder tmp = new StringBuilder();
            for (IMetaOperation op : result) {
                if (tmp.length() > 0) {
                    tmp.append(",");
                }
                tmp.append(op.getSignature());
            }
            throw new ExpressionException(tmp + " are ambiguous" , ExpressionException.ID_AMBIGUOUS);
        }
        return result;
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
         * @return the number of conversions
         * @throws ExpressionException in case that types cannot be inferred
         */
        public int getScore(CallArgument[] arguments) throws ExpressionException {
            int score = 0;
            final int step = operation.getParameterCount();
            for (int c = 0; c < conversions.length; c++) {
                IMetaType pType = operation.getParameterType(c);
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
     * @param arguments the (unnamed) arguments of the call
     * @return the list of candidate operations including their required conversions
     * @throws ExpressionException in case of type resolution problems or in case of an ambiguous call specification
     */
    private static List<ConvertibleOperation> convertibleCandidates(IMetaType operand, String name, 
        CallArgument[] arguments) throws ExpressionException {
        List<ConvertibleOperation> result = new ArrayList<ConvertibleOperation>();
        for (int o = 0; o < operand.getOperationsCount(); o++) {
            IMetaOperation desc = operand.getOperation(o);
            if (isCandidate(desc, name, arguments)) {
                int conversionCount = 0;
                IMetaOperation[] conversionOps = new IMetaOperation[arguments.length]; 
                boolean allParamOk = true;
                for (int p = 0; allParamOk && p < arguments.length; p++) {
                    IMetaType paramType = desc.getParameterType(p);
                    IMetaType argType = arguments[p].inferType();
                    if (!paramType.isAssignableFrom(argType)) {
                        conversionOps[p] = TypeHelper.findConversion(argType, paramType);
                        if (null != conversionOps[p]) {
                            conversionCount++;
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
        }
        if (result.size() > 1) {
            result = selectAmongMultipleCandidates(result, arguments);
            if (result.size() > 1) {
                StringBuilder tmp = new StringBuilder();
                for (ConvertibleOperation op : result) {
                    if (tmp.length() > 0) {
                        tmp.append(",");
                    }
                    tmp.append(op.operation.getSignature());
                }
                throw new ExpressionException(tmp + " are ambiguous", ExpressionException.ID_AMBIGUOUS);
            }
        }
        return result;
    }

    /**
     * Selects among multiple convertible candidates.
     * 
     * @param candidates the candidates
     * @param arguments the actual arguments
     * @return <code>candidates</code> or a list with exactly one candidate
     * @throws ExpressionException in case that types cannot be inferred
     */
    private static List<ConvertibleOperation> selectAmongMultipleCandidates(List<ConvertibleOperation> candidates, 
        CallArgument[] arguments) throws ExpressionException {
        ConvertibleOperation op = null;
        int opCount = 0;
        int minScore = Integer.MAX_VALUE;
        for (int c = 0; c < candidates.size(); c++) {
            ConvertibleOperation tmp = candidates.get(c);
            int score = tmp.getScore(arguments);
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
     * Actually aims at resolving the operation.
     * 
     * @param operand the operand, i.e., the type to be searched for operations
     * @param name the name of the operation to be resolved
     * @param arguments the (named) arguments of the call
     * @return the resolved operation
     * @throws ExpressionException in case that no resolution can be found for various (typically type compliance) 
     *   reasons
     */
    public static IMetaOperation resolveOperation(IMetaType operand, String name, CallArgument[] arguments) 
        throws ExpressionException {
        IMetaOperation op;
        try {
            op = resolveOperation(operand, name, arguments, true);
        } catch (ExpressionException e) {
            // most types can be converted to string but operand is fixed... let's try for a conversion
            try {
                if (null != arguments && arguments.length > 0 && !(operand instanceof IModel)) {
                    // model is resolved before - consider only matching there as otherwise arbitrary operations on
                    // string may shadow artifact operations; this conversion is last resort on artifact level
                    IMetaType opType = arguments[0].inferType();
                    IMetaType stringType = TypeRegistry.stringType();
                    IMetaOperation convOp = TypeHelper.findConversion(opType, stringType); // this includes Any->String
                    if (null != convOp) {
                        op = resolveOperation(stringType, name, arguments, true);
                        if (opType == TypeRegistry.anyType()) {
                            arguments[0].insertConversion(convOp);
                            // ANY is assignable by itself, other conversion
                            // will be added on the way but for ANY the conversion
                            // is still needed
                        } 
                    } else {
                        throw e;
                    }
                } else {
                    throw e;
                }
            } catch (ExpressionException e1) {
                throw e;
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
     * @return the resolved operation
     * @throws ExpressionException in case that no resolution can be found for various (typically type compliance) 
     *   reasons
     */
    private static IMetaOperation resolveOperation(IMetaType operand, String name, CallArgument[] arguments, 
        boolean allowConversion) throws ExpressionException {
        IMetaOperation resolved = null;
        // check for direct applicable candidates
        CallArgument[] unnamed = CallArgument.getUnnamedArguments(arguments);
        List<IMetaOperation> candidates = assignableCandidates(operand, name, unnamed);
        if (1 == candidates.size()) {
            resolved = candidates.get(0);
        } else if (allowConversion) {
            // check for candidates by conversion
            List<ConvertibleOperation> convertible = convertibleCandidates(operand, name, unnamed);
            if (0 == convertible.size() && null != operand.getBaseType()) {
                // also operand operations must be considered
                convertible = convertibleCandidates(operand.getBaseType(), name, unnamed);
            }
            if (1 == convertible.size()) {
                ConvertibleOperation found = convertible.get(0);
                // replace parameter expression by transparent call expression to conversion call
                resolved = found.operation;
                for (int i = 0; i < unnamed.length; i++) { // same length as conversions
                    IMetaOperation conversionOp = found.conversions[i];
                    if (null != conversionOp) {
                        unnamed[i].insertConversion(conversionOp);
                    }
                }
            }
        }
        if (null == resolved) {
            // try to go for a placeholder, works only on placeholder types
            resolved = operand.addPlaceholderOperation(name, unnamed.length, arguments.length - unnamed.length > 0);
        }
        if (null == resolved) {
            throw new ExpressionException("cannot resolve " + getSignature(name, arguments), 
                ExpressionException.ID_CANNOT_RESOLVE);
        } else {
            if (unnamed.length != arguments.length && !resolved.acceptsNamedParameters()) {
                // difference indicates named parameter
                // use java signature as it is the matching signature!
                throw new ExpressionException(resolved.getJavaSignature() 
                    + " does not accept (optional) named parameters", ExpressionException.ID_CANNOT_RESOLVE);
            }
        }
        return resolved;
    }

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
            } catch (ExpressionException e) {
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
     * @return <code>operation</code> or the one determined dynamically
     */
    @SuppressWarnings("unchecked")
    public static <O extends IMetaOperation> O dynamicDispatch(O operation, Object[] args, Class<O> cls, 
        TypeRegistry registry) {
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
                while (!failure && a < operation.getParameterCount()) {
                    // consider just parameter not named arguments
                    if (null == args[a]) {
                        failure = true;
                    } else {
                        IMetaType tmp;
                        if (args[a] instanceof EnumValue) {
                            tmp = getEnumType(registry, (EnumValue) args[a]);
                        } else {
                            tmp = registry.findType(args[a].getClass());
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
                                types[a - offset] = new CallArgument((TypeDescriptor<? extends IVilType>) tmp); // ugly
                            } else {
                                failure = true;
                            }
                        }
                        a++;
                    }
                }
                // fill named/optional
                while (!failure && a < types.length) {
                    types[a] = new CallArgument("name", null);
                    a++;
                }
                if (!allSame && !failure) {
                    try {
                        // no additional conversion while dynamic dispatch
                        IMetaOperation op = AbstractCallExpression.resolveOperation(
                            operand, operation.getName(), types, false);
                        if (cls.isInstance(op)) {
                            result = cls.cast(op);
                        }
                    } catch (ExpressionException e) {
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
