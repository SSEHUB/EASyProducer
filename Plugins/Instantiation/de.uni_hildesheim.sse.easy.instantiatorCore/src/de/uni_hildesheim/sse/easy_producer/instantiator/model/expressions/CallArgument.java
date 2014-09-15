package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaOperation;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Describes an optionally named call argument.
 * 
 * @author Holger Eichelberger
 */
public class CallArgument {
    private String name;
    private Expression expr;
    private TypeDescriptor<? extends IVilType> type;
    private Object fixedValue;
    private boolean fixed;

    /**
     * Creates a call argument for runtime operation resolution.
     * 
     * @param type the type of the argument
     */
    public CallArgument(TypeDescriptor<? extends IVilType> type) {
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
     * @param expr the expression specifying the value of the argument
     */
    public CallArgument(String name, Expression expr) {
        assert null == name || name.length() > 0;
        assert null != expr;
        this.name = name;
        this.expr = expr;
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
     * Returns the number of unnamed arguments.
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
     * @throws ExpressionException in case that inferring the type fails
     */
    public TypeDescriptor<? extends IVilType> inferType() throws ExpressionException {
        TypeDescriptor<? extends IVilType> result;
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
     * @throws ExpressionException in case that using the conversion operation is not 
     *     possible for some reason
     */
    void insertConversion(OperationDescriptor operation) throws ExpressionException {
        expr = new CallExpression(operation, new CallArgument(expr));        
    }
        
    /**
     * Replaces the expression by a transparent {@link CallExpression} executing the 
     * conversion.
     *  
     * @param operation the conversion operation (return type, exactly 1 argument) 
     * @throws ExpressionException in case that using the conversion operation is not 
     *     possible for some reason
     */
    void insertConversion(IMetaOperation operation) throws ExpressionException {
        if (operation instanceof OperationDescriptor) {
            insertConversion((OperationDescriptor) operation);
        } else {
            // shall not happen
            throw new ExpressionException(operation.getJavaSignature() + " is not a valid conversion", 
                ExpressionException.ID_CANNOT_RESOLVE);
        }
    }
    
    /**
     * Evaluates the argument in the given environment.
     * {@link #inferType()} must be called before!
     * 
     * @param env the actual runtime environment used to obtain actual values of variables
     * @return the result of evaluating this node
     * @throws ExpressionException in case that types or arguments are incompatible,
     *   operations cannot be found or executed
     */
    /*public Object evaluate(IRuntimeEnvironment env) throws ExpressionException {
        return expr.evaluate(env);
    }*/
    
    /**
     * Visits the expression in this argument. [convenience]
     * 
     * @param visitor the visitor
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object accept(IExpressionVisitor visitor) throws ExpressionException {
        Object result;
        if (fixed) {
            result = fixedValue;
        } else {
            if (null == expr) {
                throw new ExpressionException("expr is null", ExpressionException.ID_INTERNAL);
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
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object fixValue(IExpressionVisitor visitor) throws ExpressionException {
        fixedValue = accept(visitor);
        fixed = true;
        return fixedValue;
    }

}
