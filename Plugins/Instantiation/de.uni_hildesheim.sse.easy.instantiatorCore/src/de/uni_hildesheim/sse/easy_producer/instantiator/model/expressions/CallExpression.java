package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaOperation;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;

/**
 * Represents a call to an operation of a {@link TypeDescriptor}.
 * Please note that dot expressions shall be represented as nested call expressions, i.e., 
 * <i>call(a).call(b).call(c)</i> shall be represented as <i>call(call(call(a), b), c)</i>
 * (set {@link #dotRight} in the constructor).
 * 
 * @author Holger Eichelberger
 */
public class CallExpression extends AbstractCallExpression implements IArgumentProvider {

    /**
     * Defines some basic call types.
     * 
     * @author Holger Eichelberger
     */
    public enum CallType {
        
        /**
         * A normal operation.
         */
        NORMAL,
        
        /**
         * A transparent operation such as a conversion.
         */
        TRANSPARENT,
        
        /**
         * An external operation provided by a Java class.
         */
        EXTERNAL;
    }
    
    private Object parent;
    private CallArgument[] arguments;
    private OperationDescriptor resolved;
    private TypeDescriptor<?> type;
    private CallType callType = CallType.NORMAL;
    private boolean dotRight;

    /**
     * Creates a new (undotted) call expression.
     * 
     * @param parent the parent language unit (if given used as optional parameter during calls)
     * @param name the name of the call
     * @param arguments the arguments for the call
     * @throws VilException in case that no argument is given
     */
    public CallExpression(Object parent, String name, Expression... arguments) throws VilException {
        this(parent, name, false, CallArgument.createUnnamedArguments(arguments));
    }
    
    /**
     * Creates a new (undotted) call expression.
     * 
     * @param parent the parent language unit (if given used as optional parameter during calls)
     * @param name the name of the call.
     * @param arguments the arguments for the call
     * @throws VilException in case that no argument is given
     */
    public CallExpression(Object parent, String name, CallArgument... arguments) throws VilException {
        this(parent, name, false, arguments);
    }
    
    /**
     * Creates a new call expression which may be part of a dot expression.
     * 
     * @param parent the parent language unit (if given used as optional parameter during calls)
     * @param name the name of the call
     * @param dotRight if this expression occurred on the right side of a "."
     * @param arguments the arguments for the call
     * @throws VilException in case that no argument is given
     */
    public CallExpression(Object parent, String name, boolean dotRight, CallArgument... arguments) 
        throws VilException {
        super(name, true);
        if (doZeroArgumentTest() && 0 == arguments.length) {
            throw new VilException("at least one argument must be provided to '" + name + "'(owner)", 
                VilException.ID_INTERNAL);
        }
        this.parent = parent;
        this.dotRight = dotRight;
        this.arguments = arguments;
    }
    
    /**
     * Creates a new transparent call expression from a conversion or optimization operation.
     * 
     * @param operation the operation to be considered
     * @param arg the one and only argument
     * @throws VilException in case that the operation does not exactly take one argument and provide a result
     */
    public CallExpression(OperationDescriptor operation, CallArgument arg) throws VilException {
        super(operation.getName(), false);
        if (1 != operation.getParameterCount()) {
            throw new VilException("operation " + operation.getJavaSignature()  
                + " does not accept exactly one parameter", VilException.ID_INTERNAL);
        }
        if (TypeRegistry.voidType() == operation.getReturnType()) {
            throw new VilException("operation " + operation.getJavaSignature()  
                + " does not return a return value", VilException.ID_INTERNAL);
        }
        resolved = operation;
        callType = CallType.TRANSPARENT;
        arguments = new CallArgument[1];
        arguments[0] = arg;
    }

    /**
     * Creates a new transparent call expression from a conversion or optimization operation.
     * 
     * @param operation the operation to be considered
     * @param param the one and only parameter
     * @throws VilException in case that the operation does not exactly take one argument and provide a result
     */
    public CallExpression(IMetaOperation operation, CallArgument... param) throws VilException {
        super(operation.getName(), false);
        if (!(operation instanceof OperationDescriptor)) {
            throw new VilException("operation is of wrong type", VilException.ID_INTERNAL);
        }
        resolved = (OperationDescriptor) operation;
        callType = CallType.EXTERNAL;
        arguments = param;
    }
    
    /**
     * Returns the parent language unit.
     * 
     * @return the parent language unit (may be <b>null</b> if not given or implicit operation)
     */
    public Object getParent() {
        return parent;
    }

    /**
     * Returns whether the zero argument test shall be applied.
     * 
     * @return <code>true</code> if the test shall be applied, <code>false</code> else
     */
    protected boolean doZeroArgumentTest() {
        return true;
    }
    
    /**
     * Returns whether this expression occurred on the right side of a dot expression (decompose while writing).
     * 
     * @return <code>true</code> if it appeared on the right side, <code>false</code> else
     */
    public boolean isDotRightExpression() {
        return dotRight;
    }
    
    /**
     * Returns the resolved operation.
     * 
     * @return the resolved operation
     */
    public OperationDescriptor getResolved() {
        return resolved;
    }
    
    /**
     * Returns the call type.
     * 
     * @return the call type
     */
    public CallType getCallType() {
        return callType;
    }
    
    /**
     * Determines the operand for searching operations on. Is called by {@link #inferType()}.
     * 
     * @return the operand
     * @throws VilException in case that determining the operand fails
     */
    protected TypeDescriptor<?> determineOperand() throws VilException {
        TypeDescriptor<?> operand = null;
        // resolve types and determine operand (to search operations on)
        for (int p = 0; p < arguments.length; p++) {
            TypeDescriptor<?> tmp = arguments[p].inferType();
            if (0 == p) {
                operand = tmp;
            }
        }
        if (0 == arguments.length) {
            throw new VilException("cannot resolve call without a parameter: " 
                + getSignature(getName(), arguments), VilException.ID_INTERNAL);
        }
        return operand;
    }
    
    /**
     * Returns whether the field meta type shall be checked in {@link #resolveOperation()}.
     * 
     * @return <code>true</code>
     */
    protected boolean checkMetaForFirstArgField() {
        return true;
    }
    
    /**
     * Resolves the operation and takes into account that an operation directly on a field could be
     * appropriate (not equals for decision variables).
     * 
     * @return the resolved operation or <b>null</b>
     * @throws VilException in case that resolution fails
     */
    /*private IMetaOperation resolveOperation() throws VilException {
        IMetaOperation op = null;
        if (arguments.length > 0 && checkMetaForFirstArgField() 
            && arguments[0].getExpression() instanceof FieldAccessExpression) {
            FieldAccessExpression fae = (FieldAccessExpression) arguments[0].getExpression();
            TypeDescriptor<?> operand = fae.getField().getMetaType();
            if (null != operand) {
                CallArgument[] args = new CallArgument[arguments.length];
                args[0] = new CallArgument(operand);
                for (int a = 1; a < arguments.length; a++) {
                    args[a] = arguments[a];
                }
                try {
                    op = resolveOperation(operand, getName(), args);
                    if (null == args[0].getExpression() && op instanceof OperationDescriptor) {
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
            TypeDescriptor<?> operand = determineOperand();
            op = resolveOperation(operand, getName(), arguments);
        }
        return op;
    }*/
    
    /**
     * Checks whether one of the parameter / argument types shall be used.
     * 
     * @return the parameter type or <b>null</b>
     * @throws VilException in case of type problems
     */
    private TypeDescriptor<?> checkUseParameter() throws VilException {
        TypeDescriptor<?> result = null;
        int useParam = resolved.useParameterAsReturn();
        if (useParam >= 0) {
            useParam++; // ignore implicit
            if (0 <= useParam && useParam < arguments.length) {
                Expression param = arguments[useParam].getExpression();
                if (param instanceof ExpressionEvaluator) {
                    param = ((ExpressionEvaluator) param).getExpression();
                }
                result = param.inferType();
            }
        }
        return result;
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        if (null == type) {
            if (null == resolved) {
                IMetaOperation op = resolveOperation(determineOperand(), true, getName(), arguments);
                if (op instanceof OperationDescriptor) {
                    resolved = (OperationDescriptor) op;
                } else {
                    throw new VilException(op.getJavaSignature() + " is not a valid operation", 
                        VilException.ID_CANNOT_RESOLVE);
                }
            }
            TypeDescriptor<?> result = considerIteratorResult(resolved.getReturnType());
            TypeDescriptor<?>[] returnGenerics = null;
            if (resolved.isTypeSelect() && arguments[1].getExpression() instanceof VilTypeExpression) {
                // 2 param are ensured by isTypeSelect, determine actual return type
                returnGenerics = TypeDescriptor.createArray(1);
                returnGenerics[0] = ((VilTypeExpression) arguments[1].getExpression()).getResolved(); // ugly
            }
            if (resolved.isGenericCollectionOperation()) {
                // implicit parameter 1 determines type
                TypeDescriptor<?> arg0Type = arguments[0].getExpression().inferType();
                if (arg0Type.getGenericParameterCount() > 0) { 
                    returnGenerics = TypeDescriptor.createArray(1);
                    returnGenerics[0] = checkUseParameter();
                    if (null == returnGenerics[0]) { // take value from implicit parameter
                        returnGenerics[0] = arg0Type.getGenericParameterType(0);
                    }
                }
            }
            if (resolved.getReturnType().isMap() && 2 == resolved.getParameterCount() 
                && resolved.getParameterType(0).isCollection() && resolved.getParameterType(1).isCollection()) {
                TypeDescriptor<?> arg0Type = arguments[0].getExpression().inferType();
                TypeDescriptor<?> arg1Type = arguments[1].getExpression().inferType();
                if (arg0Type.getGenericParameterCount() > 0 && arg1Type.getGenericParameterCount() > 0) {
                    returnGenerics = TypeDescriptor.createArray(2);
                    returnGenerics[0] = arg0Type.getGenericParameterType(0);
                    returnGenerics[1] = arg1Type.getGenericParameterType(0);
                }
            }
            int useParam = resolved.useGenericParameterAsReturn();
            if (useParam >= 0 && null != resolved.getDeclaringType()
                && arguments.length > 0
                && useParam < arguments[0].inferType().getGenericParameterCount()) {
                result = arguments[0].inferType().getGenericParameterType(useParam);
            }
            if (!resolved.isStatic() && TypeRegistry.anyType() == result) {
                // the operation has a generic return value -> implicit parameter determines actual type
                // current assumption: ANY points to original template parameter 
                TypeDescriptor<?> arg0Type = arguments[0].getExpression().inferType();
                if (1 == arg0Type.getGenericParameterCount()) {
                    result = arg0Type.getGenericParameterType(0);
                }
            }
            if (null != returnGenerics) {
                try {
                    if (result.isSet()) {
                        result = TypeRegistry.getSetType(returnGenerics);
                    } else if (result.isSequence()) {
                        result = TypeRegistry.getSequenceType(returnGenerics);
                    } else {
                        result = TypeRegistry.getMapType(returnGenerics);
                    }
                } catch (VilException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(CallExpression.class, Bundle.ID).exception(e);
                }
            }
            type = result;
        }
        return type;
    }
    
    
    /**
     * Returns the number of arguments.
     * 
     * @return the number of arguments
     */
    public int getArgumentsCount() {
        return null == arguments ? 0 : arguments.length;
    }
    
    /**
     * Returns the specified argument.
     * 
     * @param index the index of the argument to be returned
     * @return the argument
     * @throws IndexOutOfBoundsException in case of 
     * <code>index &lt; 0 || index &gt;= {@link #getArgumentsCount()}</code>.
     */
    public CallArgument getArgument(int index) {
        if (null == arguments) {
            throw new IndexOutOfBoundsException();
        }
        return arguments[index];
    }
    
    @Override
    public boolean isPlaceholder() {
        return isPlaceholder(resolved);
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        return visitor.visitCallExpression(this);
    }

    @Override
    public String getVilSignature() {
        return getVilSignature(resolved);
    }
    
    /**
     * Returns whether this call is an iterator call.
     * 
     * @return <code>true</code> if it is an iterator call, <code>false</code> else
     */
    public boolean isIteratorCall() {
        return null != resolved && getArgumentsCount() >= 2 
            && getArgument(1).getExpression() instanceof ExpressionEvaluator;
    }

    /**
     * Considers the potential explicit result type of an iterator.
     * 
     * @param result the result type so far
     * @return the result type
     * @throws VilException if aggregation shall be applied to a non-aggregating iterator operation
     */
    private TypeDescriptor<?> considerIteratorResult(TypeDescriptor<?> result) throws VilException {
        if (isIteratorCall()) {
            ExpressionEvaluator eval = ((ExpressionEvaluator) getArgument(1).getExpression());
            TypeDescriptor<?> evalType = eval.getResultType();
            boolean allowsAggregation = resolved.allowsAggregation();
            if (null != evalType) {
                result = evalType;
                if (!allowsAggregation) {
                    throw new VilException("operation " + resolved.getSignature() + " does not support "
                        + "aggregating iterators", VilException.ID_INVALID_ITERATOR);
                }
            } else {
                if (allowsAggregation) { // no agregation, no result
                    result = TypeRegistry.voidType();
                }
            }
        }
        return result;
    }

}
