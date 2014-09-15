package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaOperation;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;

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
    private TypeDescriptor<? extends IVilType> type;
    private CallType callType = CallType.NORMAL;
    private boolean dotRight;

    /**
     * Creates a new (undotted) call expression.
     * 
     * @param parent the parent language unit (if given used as optional parameter during calls)
     * @param name the name of the call
     * @param arguments the arguments for the call
     * @throws ExpressionException in case that no argument is given
     */
    public CallExpression(Object parent, String name, Expression... arguments) throws ExpressionException {
        this(parent, name, false, CallArgument.createUnnamedArguments(arguments));
    }
    
    /**
     * Creates a new (undotted) call expression.
     * 
     * @param parent the parent language unit (if given used as optional parameter during calls)
     * @param name the name of the call.
     * @param arguments the arguments for the call
     * @throws ExpressionException in case that no argument is given
     */
    public CallExpression(Object parent, String name, CallArgument... arguments) throws ExpressionException {
        this(parent, name, false, arguments);
    }
    
    /**
     * Creates a new call expression which may be part of a dot expression.
     * 
     * @param parent the parent language unit (if given used as optional parameter during calls)
     * @param name the name of the call
     * @param dotRight if this expression occurred on the right side of a "."
     * @param arguments the arguments for the call
     * @throws ExpressionException in case that no argument is given
     */
    public CallExpression(Object parent, String name, boolean dotRight, CallArgument... arguments) 
        throws ExpressionException {
        super(name, true);
        if (doZeroArgumentTest() && 0 == arguments.length) {
            throw new ExpressionException("at least one argument must be provided to '" + name + "'(owner)", 
                ExpressionException.ID_INTERNAL);
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
     * @throws ExpressionException in case that the operation does not exactly take one argument and provide a result
     */
    public CallExpression(OperationDescriptor operation, CallArgument arg) throws ExpressionException {
        super(operation.getName(), false);
        if (1 != operation.getParameterCount()) {
            throw new ExpressionException("operation " + operation.getJavaSignature()  
                + " does not accept exactly one parameter", ExpressionException.ID_INTERNAL);
        }
        if (TypeRegistry.voidType() == operation.getReturnType()) {
            throw new ExpressionException("operation " + operation.getJavaSignature()  
                + " does not return a return value", ExpressionException.ID_INTERNAL);
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
     * @throws ExpressionException in case that the operation does not exactly take one argument and provide a result
     */
    public CallExpression(IMetaOperation operation, CallArgument... param) throws ExpressionException {
        super(operation.getName(), false);
        if (!(operation instanceof OperationDescriptor)) {
            throw new ExpressionException("operation is of wrong type", ExpressionException.ID_INTERNAL);
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
     * Returns the signature of this operation for exception messages.
     * 
     * @return the signature
     * @throws ExpressionException in case of type resolution problems
     */
    private String getSignature() throws ExpressionException {
        StringBuilder signature = new StringBuilder(getName());
        signature.append("(");
        for (int a = 0; a < arguments.length; a++) {
            signature.append(arguments[a].getExpression().inferType().getName());
            if (a < arguments.length - 1) {
                signature.append(",");
            }
        }
        signature.append(")");
        return signature.toString();
    }
    
    /**
     * Determines the operand for searching operations on. Is called by {@link #inferType()}.
     * 
     * @return the operand
     * @throws ExpressionException in case that determining the operand fails
     */
    protected TypeDescriptor<? extends IVilType> determineOperand() throws ExpressionException {
        TypeDescriptor<? extends IVilType> operand = null;
        // resolve types and determine operand (to search operations on)
        for (int p = 0; p < arguments.length; p++) {
            TypeDescriptor<? extends IVilType> tmp = arguments[p].inferType();
            if (0 == p) {
                operand = tmp;
            }
        }
        if (0 == arguments.length) {
            throw new ExpressionException("cannot resolve operations without a parameter: " + getSignature(), 
                            ExpressionException.ID_INTERNAL);
        }
        return operand;
    }

    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws ExpressionException {
        if (null == type) {
            if (null == resolved) {
                TypeDescriptor<? extends IVilType> operand = determineOperand();
                IMetaOperation op = resolveOperation(operand, getName(), arguments);
                if (op instanceof OperationDescriptor) {
                    resolved = (OperationDescriptor) op;
                } else {
                    throw new ExpressionException(op.getJavaSignature() + " is not a valid operation", 
                        ExpressionException.ID_CANNOT_RESOLVE);
                }
            }
            TypeDescriptor<? extends IVilType> result = resolved.getReturnType();
            TypeDescriptor<? extends IVilType>[] returnGenerics = null;
            if (resolved.isTypeSelect() && arguments[1].getExpression() instanceof VilTypeExpression) {
                // 2 param are ensured by isTypeSelect
                // determine actual return type
                returnGenerics = TypeDescriptor.createArray(1);
                // ugly
                returnGenerics[0] = ((VilTypeExpression) arguments[1].getExpression()).getResolved();
            }
            if (resolved.isGenericCollectionOperation()) {
                // implicit parameter 1 determines type
                returnGenerics = TypeDescriptor.createArray(1);
                returnGenerics[0] = arguments[0].getExpression().inferType().getParameterType(0);
            }
            if (!resolved.isStatic() && TypeRegistry.anyType() == result) {
                // the operation has a generic return value -> implicit parameter determines actual type
                // current assumption: ANY points to original template parameter 
                TypeDescriptor<? extends IVilType> arg0Type = arguments[0].getExpression().inferType();
                if (1 == arg0Type.getParameterCount()) {
                    result = arg0Type.getParameterType(0);
                }
            }
            if (null != returnGenerics) {
                try {
                    if (result.isSet()) {
                        result = TypeRegistry.getSetType(returnGenerics);
                    } else {
                        result = TypeRegistry.getSequenceType(returnGenerics);
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
    public Object accept(IExpressionVisitor visitor) throws ExpressionException {
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
        return null != resolved && getArgumentsCount() == 2 
            && getArgument(1).getExpression() instanceof ExpressionEvaluator;
    }

}
