package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Describes an optionally named call argument.
 * 
 * @author Holger Eichelberger
 */
public class CallArgument {
    private String name;
    private Expression expr;
    private TypeDescriptor<?> type;
    private Object fixedValue;
    private boolean fixed;

    /**
     * Constructor for serialization.
     */
    CallArgument() {
    }
    
    /**
     * Creates a call argument for runtime operation resolution.
     * 
     * @param type the type of the argument
     */
    public CallArgument(TypeDescriptor<?> type) {
        this.type = type;
        this.name = null;
        this.expr = null;
    }
    
    /**
     * Creates an unnamed call argument.
     * 
     * @param expr the expression specifying the value of the argument
     */
    public CallArgument(Expression expr) {
        this(null, expr);
    }
    
    /**
     * Creates a named call argument.
     * 
     * @param name the name of the argument (may be <b>null</b> if unnamed)
     * @param expr the expression specifying the value of the argument (may be <b>null</b>, 
     *    e.g., for dynamic dispatch)
     */
    public CallArgument(String name, Expression expr) {
        assert null == name || name.length() > 0;
        this.name = name;
        this.expr = expr;
    }

    /**
     * Creates a named call argument from a given runtime type.
     * 
     * @param name the name
     * @param type the specific type
     */
    public CallArgument(String name, TypeDescriptor<?> type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Creates unnamed arguments. [helper]
     * 
     * @param arguments the argument expressions
     * @return the unnamed arguments
     */
    public static CallArgument[] createUnnamedArguments(Expression... arguments) {
        CallArgument[] result = new CallArgument[arguments.length];
        for (int a = 0; a < arguments.length; a++) {
            result[a] = new CallArgument(arguments[a]);
        }
        return result;
    }

    /**
     * Returns the number of unnamed arguments. Unnamed must be given before named arguments.
     * 
     * @param arguments the arguments to be considered
     * @return the number of unnamed arguments
     */
    public static int countUnnamedArguments(CallArgument[] arguments) {
        int count = 0;
        for (int a = 0; a < arguments.length; a++) {
            if (!arguments[a].hasName()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the arguments.
     * 
     * @param arguments the arguments to be considered
     * @return the unnamed arguments (may be <code>arguments</code>)
     */
    public static CallArgument[] getUnnamedArguments(CallArgument[] arguments) {
        CallArgument[] result;
        final int count = countUnnamedArguments(arguments);
        if (count == arguments.length) {
            result = arguments;
        } else {
            result = new CallArgument[count];
            int pos = 0;
            for (int a = 0; a < arguments.length; a++) {
                if (!arguments[a].hasName()) {
                    result[pos++] = arguments[a];
                }
            }
        }
        return result;
    }
    
    /**
     * Returns whether this argument is named.
     * 
     * @return <code>true</code> if it is named, <code>false</code> else
     */
    public boolean hasName() {
        return null != name;
    }
    
    /**
     * Returns the name of the argument. 
     * 
     * @return the name of the argument, may be <b>null</b>}.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the expression specifying the value of the argument.
     * 
     * @return the expression specifying the value of the argument
     */
    public Expression getExpression() {
        return expr;
    }
    
    /**
     * Infers the type of this expression including the type of the contained sub-expressions.
     * 
     * @return the type of this expression
     * @throws VilException in case that inferring the type fails
     */
    public TypeDescriptor<?> inferType() throws VilException {
        TypeDescriptor<?> result;
        if (null == expr) {
            if (null == type) {
                result = TypeRegistry.voidType();
            } else {
                result = type;
            }
        } else {
            result = expr.inferType();
        }
        return result;
    }
    
    /**
     * Replaces the expression by a transparent {@link CallExpression} executing the 
     * conversion.
     *  
     * @param operation the conversion operation (return type, exactly 1 argument) 
     * @throws VilException in case that using the conversion operation is not 
     *     possible for some reason
     */
    void insertConversion(OperationDescriptor operation) throws VilException {
        expr = new CallExpression(operation, new CallArgument(expr));        
    }
        
    /**
     * Replaces the expression by a transparent {@link CallExpression} executing the 
     * conversion.
     *  
     * @param operation the conversion operation (return type, exactly 1 argument) 
     * @throws VilException in case that using the conversion operation is not 
     *     possible for some reason
     */
    void insertConversion(IMetaOperation operation) throws VilException {
        if (operation instanceof OperationDescriptor) {
            insertConversion((OperationDescriptor) operation);
        } else {
            // shall not happen
            throw new VilException(operation.getJavaSignature() + " is not a valid conversion", 
                VilException.ID_CANNOT_RESOLVE);
        }
    }
    
    /**
     * Visits the expression in this argument. [convenience]
     * 
     * @param visitor the visitor
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object accept(IExpressionVisitor visitor) throws VilException {
        Object result;
        if (fixed) {
            result = fixedValue;
        } else {
            if (null == expr) {
                throw new VilException("expr is null", VilException.ID_INTERNAL);
            }
            result = expr.accept(visitor);
        }
        return result;
    }
    
    /**
     * Fixes the value that will be returned by {@link #accept(IExpressionVisitor)} by calling
     * {@link #accept(IExpressionVisitor)}.
     * 
     * @param visitor the visitor
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object fixValue(IExpressionVisitor visitor) throws VilException {
        fixedValue = accept(visitor);
        fixed = true;
        return fixedValue;
    }
    
    /**
     * Fixes the value of this argument. <code>Caution:</code> There is no type check, 
     * i.e., <code>fixedValue</code> must match the type of this argument.
     *   
     * @param fixedValue the fixed value
     * @return <b>this</b> (builder pattern)
     */
    public CallArgument fixValue(Object fixedValue) {
        this.fixedValue = fixedValue;
        fixed = true;
        return this;
    }
    
    /**
     * Resolves an operation, i.e., overwrites the expression. Handle with care.
     * 
     * @param type the resolvable type (function pointer)
     * @param operation the resolving operation (actual base function)
     */
    public void resolveOperation(TypeDescriptor<?> type, IMetaOperation operation) {
        this.expr = new ResolvableOperationExpression(type, operation);
    }
    
    /**
     * Replaces the expression in this argument. Handle with care!
     * 
     * @param expr the new expression
     */
    public void setExpression(Expression expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        try {
            inferType();
        } catch (VilException e) {
            e.printStackTrace();
        }
        return type != null ? type.getName() : "<unknown type>";
    }
    
}
