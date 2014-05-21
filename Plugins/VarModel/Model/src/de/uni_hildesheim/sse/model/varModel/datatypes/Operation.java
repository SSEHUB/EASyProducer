package de.uni_hildesheim.sse.model.varModel.datatypes;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;

/**
 * Describes an operation. Operations may be operators or function calls. Actually, this class
 * does not describe how the implementation of the operation is done. It just describes the 
 * signature of the operation. The concrete implementation is part of the reasoning process. 
 * Operations are intended to be made available as constants in their declaring type in order
 * to provide a simple operation-translation-mapping in the reasoning implementation. <br>
 * Note that at least the {@link Container} datatype is generic, i.e. parameterized over the type of 
 * elements it is containing. Thus, operations need to be generic, too. We provide a 
 * {@link ReturnTypeMode} specifying how the actual return type is to be handled based on the 
 * actual type and its generic types. This is actually a simplification but should work as
 * the type resolution relies on the return types. Generic return types may be specified using
 * {@link AnyType}.
 * 
 * @author Tebbje
 * @author Holger Eichelberger
 */
public class Operation {
    
    /**
     * Defines how to handle the return type of an operation.
     * We do not provide access to further generic parameters
     * as 
     * 
     * @author Holger Eichelberger
     */
    public enum ReturnTypeMode {
        
        /**
         * Do not change the return type.
         */
        UNCHANGED(-1, -1),
        
        /**
         * Change it to the immediate type of the operand.
         */
        IMMEDIATE_OPERAND(-1, -1),
        
        /**
         * Change it to the operand with generic parameter. If no generic
         * parameter is available, {@link #IMMEDIATE_OPERAND} is applied.
         */
        TYPED_OPERAND_1(0, -1),

        /**
         * Change it to the operand with generic parameter. If no generic
         * parameter is available, {@link #IMMEDIATE_OPERAND} is applied.
         */
        TYPED_PARAM_1(-1, 0),

        /**
         * Use the return value of the first operation parameter. If not
         * available, {@link #IMMEDIATE_OPERAND} is applied.
         */
        PARAM_1(-1, 0),
        
        /**
         * Change it to the first generic parameter. If no generic
         * parameter is available, {@link #IMMEDIATE_OPERAND} is applied.
         */
        GENERIC_PARAM_1(0, -1);
        
        /**
         * Stores the index of the affected generic type. Negative if none
         * is affected.
         */
        private int typeIndex;

        /**
         * Stores the index of the source operation parameter. Negative if none
         * is considered.
         */
        private int paramIndex;

        /**
         * Creates a new constant based on the affected generic type (index).
         * 
         * @param typeIndex the affected generic type (negative if none is affected)
         * @param paramIndex the parameter type to be considered as return (none: relevant)
         */
        private ReturnTypeMode(int typeIndex, int paramIndex) {
            this.typeIndex = typeIndex;
            this.paramIndex = paramIndex;
        }
        
        /**
         * Returns the index of the relevant generic type.
         * 
         * @return a negative value if no generic type is
         *   affected, the affected index else
         */
        public int getGenericTypeIndex() {
            return typeIndex;
        }
        
        /**
         * Returns the index of the relevant parameter.
         * 
         * @return a negative value if no parameter should be 
         *   considered, the index else
         */        
        public int getParameterIndex() {
            return paramIndex;
        }
    }
    
    /**
     * Defines some formatting hints for emitting operations
     * in a canonical form.
     * 
     * @author Holger Eichelberger
     */
    public enum FormattingHint {

        /**
         * Emit it as a function call <code>name(operand, param)</code>.
         */
        FUNCTION_CALL,
        
        /**
         * Emit it as an infix operator <code>operand name param</code>.
         */
        OPERATOR_INFIX,

        /**
         * Emit it as a prefix operator <code>name operand</code>.
         */
        OPERATOR_PREFIX,

        /**
         * Emit it as a postfix operator <code>operand name</code>.
         */
        OPERATOR_POSTFIX;
    }
    
    private static List<Operation> allOperations = new ArrayList<Operation>();

    private IDatatype returns;
    
    private String name;
    
    private IDatatype[] parameters;
   
    /**
     * Stores the data type this operation is defined for.
     */
    private IDatatype operand;
    
    /**
     * Stores the return type mode.
     */
    private ReturnTypeMode returnTypeMode = ReturnTypeMode.UNCHANGED;
        
    /**
     * Stores whether the operation is a container operation.
     */
    private boolean containerOperation;
    
    private boolean requiresAssignableParameter = false;
    
    private FormattingHint formattingHint = FormattingHint.FUNCTION_CALL;
    
    /**
     * Creates a non-container operation (descriptor).
     * The return type mode is {@link ReturnTypeMode#UNCHANGED} by default. Use 
     * {@link #markAsContainerOperation()} to flag this operation as a container operation.
     * 
     * @param returns result type of the operation
     * @param name name of the operation
     * @param operand the data type the operation is defined for
     * @param parameters list of parameters for operation
     */
    Operation(IDatatype returns, String name, IDatatype operand, IDatatype... parameters) {
        this(returns, ReturnTypeMode.UNCHANGED, name, operand, parameters);
    }
    
    /**
     * Creates an operation (descriptor). Use {@link #markAsContainerOperation()} to
     * flag this operation as a container operation.
     * 
     * @param returns result type of the operation
     * @param returnTypeMode the return type mode
     * @param name name of the operation
     * @param operand the data type the operation is defined for
     * @param parameters list of parameters for operation
     */
    Operation(IDatatype returns, ReturnTypeMode returnTypeMode, String name, IDatatype operand, 
        IDatatype... parameters) {
        
        this.returns = returns;
        this.returnTypeMode = returnTypeMode;
        this.name = name;
        this.parameters = parameters;
        this.operand = operand;
        if (registerAsOperation()) {
            allOperations.add(this);   
        }
    }

    /**
     * Creates an infix operator (descriptor).
     * The return type mode is {@link ReturnTypeMode#UNCHANGED} by default. 
     * 
     * @param returns result type of the operation
     * @param name name of the operation
     * @param operand the data type the operation is defined for
     * @param parameters list of parameters for operation
     * @return the operation
     */
    public static Operation createInfixOperator(IDatatype returns, String name, 
        IDatatype operand, IDatatype... parameters) {
        return new Operation(returns, name, operand, parameters).markByFormattingHint(FormattingHint.OPERATOR_INFIX);
    }
    
    /**
     * Creates a prefix operator (descriptor).
     * The return type mode is {@link ReturnTypeMode#UNCHANGED} by default. 
     * 
     * @param returns result type of the operation
     * @param name name of the operation
     * @param operand the data type the operation is defined for
     * @param parameters list of parameters for operation
     * @return the operation
     */
    public static Operation createPrefixOperator(IDatatype returns, String name, 
        IDatatype operand, IDatatype... parameters) {
        return new Operation(returns, name, operand, parameters).markByFormattingHint(FormattingHint.OPERATOR_PREFIX);
    }

    /**
     * Creates a postfix operator (descriptor).
     * The return type mode is {@link ReturnTypeMode#UNCHANGED} by default. 
     * 
     * @param returns result type of the operation
     * @param name name of the operation
     * @param operand the data type the operation is defined for
     * @param parameters list of parameters for operation
     * @return the operation
     */
    public static Operation createPostfixOperator(IDatatype returns, String name, 
        IDatatype operand, IDatatype... parameters) {
        return new Operation(returns, name, operand, parameters).markByFormattingHint(FormattingHint.OPERATOR_POSTFIX);
    }
    
    /**
     * Getter for the return type of this operation.
     * @return IDatatype
     */
    public IDatatype getReturns() {
        return returns;
    }
    
    /**
     * Returns the name of the operation.
     * @return the name of the operation
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the number of parameters of this operation.
     * 
     * @return the number of parameters
     */
    public int getParameterCount() {
        return null == parameters ? 0 : parameters.length;
    }
    
    /**
     * Returns the parameter at position <code>index</code>.
     * 
     * @param index a 0-based index denoting the parameter 
     *   to be returned
     * @return the specified parameter
     * 
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getParameterCount()}</code>
     */
    public IDatatype getParameter(int index) {
        if (null == parameters) {
            throw new IndexOutOfBoundsException();
        }
        return parameters[index];
    }
    
    /**
     * The operand this operation is defined on.
     * 
     * @return IDatatype the operand as datatype
     */
    public IDatatype getOperand() {
        return operand;
    }
    
    /**
     * Returns the function expression calculated by this operation.
     * 
     * @return the function operation (always <b>null</b>)
     */
    public ConstraintSyntaxTree getFunction() {
        return null;
    }

    /**
     * Returns the return type mode.
     * 
     * @return the return type mode
     */
    public ReturnTypeMode getReturnTypeMode() {
        return returnTypeMode;
    }
    
    /**
     * Determines the actual return type.  
     * 
     * @param immediateOperand the actual operand type (complying to {@link #getOperand()}.
     * @param parameter the actual parameter
     * @return the actual return type
     */
    public final IDatatype getActualReturnType(IDatatype immediateOperand, IDatatype... parameter) {
        IDatatype result;
        ReturnTypeMode mode = getReturnTypeMode(); // this is intended to be polymorphic
        switch (mode) { 
        case UNCHANGED:
            result = getReturns();
            break;
        case TYPED_OPERAND_1:
            // currently only type conversion is needed, else TYPED_PARAM_1
            if (immediateOperand instanceof Set && getReturns() instanceof Sequence) {
                Set set = (Set) immediateOperand;
                result = new Sequence("", set.getContainedType(), set.getParent());
            } else if (immediateOperand instanceof Sequence && getReturns() instanceof Set) {
                Sequence sequence = (Sequence) immediateOperand;
                result = new Set("", sequence.getContainedType(), sequence.getParent());
            } else {
                result = immediateOperand;
            }
            break;
        case GENERIC_PARAM_1:
            int index = mode.getGenericTypeIndex();
            if (index >= 0 && index < immediateOperand.getGenericTypeCount()) {
                result = immediateOperand.getGenericType(mode.getGenericTypeIndex());
            } else {
                result = immediateOperand;
            }
            break;
        case IMMEDIATE_OPERAND:
            result = immediateOperand;
            break;
        case TYPED_PARAM_1:
        case PARAM_1:
            index = mode.getParameterIndex();
            if (null != parameter && index >= 0 && index < parameter.length) {
                result = parameter[index];
            } else {
                result = immediateOperand;
            }
            break;
        default:
            result = immediateOperand;
            break;
        }
        return result;
    }
        
    /**
     * Returns whether this operation is a container operation, e.g. a quantor.
     * 
     * @return <code>true</code> if this is a container operation, <code>false</code> else
     */
    public boolean isContainerOperation() {
        return containerOperation;
    }
    
    /**
     * Marks this operation as a container operation. Introduced as constructors grew to
     * more than 5 parameter. 
     * 
     * @return <b>this</b>
     */
    Operation markAsContainerOperation() {
        containerOperation = true;
        return this;
    }

    /**
     * Marks that this operation requires assignable parameter types. Introduced as constructors 
     * grew to more than 5 parameter. 
     * 
     * @return <b>this</b>
     */
    Operation markAsAssignableParameterOperation() {
        requiresAssignableParameter = true;
        return this;
    }
    
    /**
     * Returns whether this operation requires equal parameter types.
     * 
     * @return <code>true</code> if parameter types need to be 
     */
    public boolean requiresAssignableParameter() {
        return requiresAssignableParameter;
    }

    /**
     * Marks this operation by a formatting hint. Introduced as constructors grew to
     * more than 5 parameter.
     *  
     * @param formattingHint the formatting hint
     * @return <b>this</b>
     */
    Operation markByFormattingHint(FormattingHint formattingHint) {
        if (null != formattingHint) {
            this.formattingHint = formattingHint;
        }
        return this;
    }
    
    /**
     * Returns the formatting hint.
     * 
     * @return the formatting hint
     */
    public FormattingHint getFormattingHint() {
        FormattingHint result = formattingHint;
        if (formattingHint == FormattingHint.OPERATOR_PREFIX
            || formattingHint == FormattingHint.OPERATOR_POSTFIX) {
            if (null != parameters && parameters.length > 0) {
                // prefix operators typically have only the operand
                result = FormattingHint.FUNCTION_CALL;
            }
        }
        return result;
    }
    
    /**
     * Returns the number of all defined operations. As a prerequisite,
     * the related datatype classes need to be loaded into the VM, e.g. 
     * by explicitly stating <code>BooleanType.class.getClass();</code>
     * for all relevant classes. 
     * 
     * @return the number of parameters
     */
    public static int getOperationsCount() {
        return allOperations.size();
    }
    
    /**
     * Returns the specified defined operation. As a prerequisite,
     * the related datatype classes need to be loaded into the VM, e.g. 
     * by explicitly stating <code>BooleanType.class.getClass();</code>
     * for all relevant classes. 
     * 
     * @param index a 0-based index denoting the operation
     * @return the operation
     * 
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getOperationsCount()()}</code>
     */
    public static Operation getOperation(int index) {
        return allOperations.get(index);
    }    
    
    /**
     * Returns whether this operation shall be registered as a global operation.
     * 
     * @return <code>true</code> if it should be registered, <code>false</code> else
     */
    protected boolean registerAsOperation() {
        return true;
    }

}
