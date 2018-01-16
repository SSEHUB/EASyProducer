/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.varModel.model.datatypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;

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
        UNCHANGED(-1, -1, false, false),
        
        /**
         * Change it to the immediate type of the operand.
         */
        IMMEDIATE_OPERAND(-1, -1, false, false),
        
        /**
         * Change the return type to the operand with generic parameter. If no generic
         * parameter is available, {@link #IMMEDIATE_OPERAND} is applied.
         */
        TYPED_OPERAND_1(0, -1, false, false),

        /**
         * Change the return type to the operand with generic parameter. If no generic
         * parameter is available, {@link #IMMEDIATE_OPERAND} is applied.
         */
        TYPED_PARAM_1(-1, 0, false, false),

        /**
         * Use the return value of the first operation parameter. If not
         * available, {@link #IMMEDIATE_OPERAND} is applied.
         * Signals that checking the operand is desired.
         */
        PARAM_1_CHECK(-1, 0, false, true),
        
        /**
         * Use the return value of the first operation parameter. If not
         * available, {@link #IMMEDIATE_OPERAND} is applied.
         */
        PARAM_1(-1, 0, false, false),
        
        /**
         * Change it to the first generic parameter. If no generic
         * parameter is available, {@link #IMMEDIATE_OPERAND} is applied.
         */
        GENERIC_PARAM_1(0, -1, false, false),

        /**
         * Change it to the first generic operation parameter as generic type of the immediate 
         * operand in case that that is a collection. If the {@link #IMMEDIATE_OPERAND} is not a collection,
         * {@link #PARAM_1} will be applied. If no parameter
         * parameter is available, {@link #IMMEDIATE_OPERAND} is applied.
         */
        IMMEDIATE_OPERAND_COLLECTION_PARAM_1(-1, 0, false, false),

        /**
         * Change it to the deepest nested first generic operation parameter as generic type of the immediate 
         * operand in case that that is a collection. If the {@link #IMMEDIATE_OPERAND} is not a collection,
         * {@link #PARAM_1} will be applied. If no parameter
         * parameter is available, {@link #IMMEDIATE_OPERAND} is applied.
         */
        // 0: using generic parameters as parameters here
        IMMEDIATE_OPERAND_COLLECTION_NESTED_GENERIC_1(-1, 0, true, false), 

        /**
         * Change it to a collection based on the original result type using the immediate type as type parameter.
         */
        IMMEDIATE_OPERAND_COLLECTION(-1, -1, false, false);

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
         * Whether searching for the result type shall be applied recursively / in a nested fashion if applicable.
         */
        private boolean recurse;
        
        /**
         * Whether the operand (if a collection) shall fit the return type as parameter.
         */
        private boolean checkOperand;

        /**
         * Creates a new constant based on the affected generic type (index).
         * 
         * @param typeIndex the affected generic type (negative if none is affected)
         * @param paramIndex the parameter type to be considered as return (none: relevant)
         * @param recurse searching for the result type shall be applied recursively 
         * @param checkOperand whether the operand (if a collection) shall fit the return type as parameter
         */
        private ReturnTypeMode(int typeIndex, int paramIndex, boolean recurse, boolean checkOperand) {
            this.typeIndex = typeIndex;
            this.paramIndex = paramIndex;
            this.recurse = recurse;
            this.checkOperand = checkOperand;
        }

        /**
         * Whether the operand (if a collection) shall fit the return type as parameter.
         * 
         * @return <code>true</code> for check, <code>false</code> else
         */
        public boolean checkOperand() {
            return checkOperand;
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
        
        /**
         * Returns whether searching for the result shall be applied in a recursive fashion if applicable.
         * 
         * @return <code>true</code> do recursion, <code>false</code> no recursion
         */
        public boolean recurse() {
            return recurse;
        }
        
    }
    
    /**
     * Defines the nesting mode of the results.
     * 
     * @author Holger Eichelberger
     */
    public enum NestingMode {
        NONE,
        LEGACY,
        FLATTEN,
        NESTING
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
    // key is an alias for value
    private static transient Map<Operation, Operation> alias = new HashMap<Operation, Operation>();

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
    
    private boolean requiresAssignableParameter = false;
    
    private boolean acceptsNull = false;
    
    private FormattingHint formattingHint = FormattingHint.FUNCTION_CALL;
    
    private NestingMode nestingMode = NestingMode.NONE;
    
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
     * Returns whether this operation is static.
     * 
     * @return <code>true</code> for static, <code>false</code> else
     */
    public boolean isStatic() {
        return true;
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
     * Returns the number of required parameters.
     * 
     * @return the number of required parameters
     */
    public int getRequiredParameterCount() {
        return getParameterCount();
    }
    
    /**
     * Returns the parameter type at position <code>index</code>.
     * 
     * @param index a 0-based index denoting the parameter 
     *   to be returned
     * @return the specified parameter
     * 
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getParameterCount()}</code>
     */
    public IDatatype getParameterType(int index) {
        if (null == parameters) {
            throw new IndexOutOfBoundsException();
        }
        return parameters[index];
    }
    
    /**
     * Returns the parameter at position <code>index</code>.
     * 
     * @param index a 0-based index denoting the parameter 
     *   to be returned
     * @return the specified parameter (may be <b>null</b> if there is no formal declaration
     * 
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getParameterCount()}</code>
     */
    public DecisionVariableDeclaration getParameterDeclaration(int index) {
        if (index < 0 || index >= getParameterCount()) {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    /**
     * Returns the parameter default value at position <code>index</code>.
     * 
     * @param index a 0-based index denoting the parameter 
     *   to be returned
     * @return the specified parameter default value (may be <b>null</b> if there is no default value)
     * 
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getParameterCount()}</code>
     */
    public ConstraintSyntaxTree getParameterDefaultValue(int index) {
        ConstraintSyntaxTree result = null;
        DecisionVariableDeclaration decl = getParameterDeclaration(index);
        if (decl != null) {
            result = decl.getDefaultValue();
        }
        return result;
    }
    
    /**
     * Returns the specified named parameter.
     * 
     * @param name the name of the parameter
     * @return the named parameter declaration (may be <b>null</b>)
     */
    public DecisionVariableDeclaration getParameter(String name) {
        return null; // so far no named parameters
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
            if (Set.TYPE.isAssignableFrom(immediateOperand) && Sequence.TYPE.isAssignableFrom(getReturns())) {
                Set set = (Set) immediateOperand;
                result = createCollectionReturnType(Sequence.TYPE, set.getContainedType(), set.getParent());
            } else if (Sequence.TYPE.isAssignableFrom(immediateOperand) && Set.TYPE.isAssignableFrom(getReturns())) {
                Sequence sequence = (Sequence) immediateOperand;
                result = createCollectionReturnType(Set.TYPE, sequence.getContainedType(), sequence.getParent());
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
        case IMMEDIATE_OPERAND_COLLECTION:
            result = immediateOperandCollection(immediateOperand);
            break;
        case IMMEDIATE_OPERAND:
            result = immediateOperand;
            break;
        case PARAM_1_CHECK:
        case TYPED_PARAM_1:
        case PARAM_1:
            index = mode.getParameterIndex();
            if (null != parameter && index >= 0 && index < parameter.length) {
                result = parameter[index];
            } else {
                result = immediateOperand;
            }
            break;
        case IMMEDIATE_OPERAND_COLLECTION_PARAM_1:
            result = immediateOperandCollection(mode, immediateOperand, parameter);
            break;
        case IMMEDIATE_OPERAND_COLLECTION_NESTED_GENERIC_1:
            result = immediateOperandCollection(mode, immediateOperand, TypeQueries.toGenerics(immediateOperand));
            break;
        default:
            result = immediateOperand;
            break;
        }
        // in case of a nesting operation which is applied to a nested collection, keep the nesting
        if (NestingMode.NESTING == getNestingMode() && Container.TYPE.isAssignableFrom(immediateOperand) 
            && 1 == immediateOperand.getGenericTypeCount() 
            && Container.TYPE.isAssignableFrom(immediateOperand.getGenericType(0))) {
            if (Set.TYPE.isAssignableFrom(result)) {
                result = createCollectionReturnType(Set.TYPE, result, null);
            } else if (Sequence.TYPE.isAssignableFrom(result)) {
                result = createCollectionReturnType(Sequence.TYPE, result, null);
            }
        }
        return result;
    }

    /**
     * Returns a collection type using the immediate operand as generic based on the original return type of this
     * operation.
     * 
     * @param immediateOperand the immediate operand
     * @return the datatype
     */
    private IDatatype immediateOperandCollection(IDatatype immediateOperand) {
        IDatatype result;
        if (Sequence.TYPE.isAssignableFrom(getReturns())) {
            result = createCollectionReturnType(Sequence.TYPE, immediateOperand, null);
        } else if (Set.TYPE.isAssignableFrom(getReturns())) {
            result = createCollectionReturnType(Set.TYPE, immediateOperand, null);
        } else {
            result = immediateOperand;
        }
        return result;
    }
    
    /**
     * Creates a collection return type based on <code>aim</code>. Subclasses may override to limit the actual return
     * type.
     * 
     * @param aim the type aim ({@link Sequence#TYPE} or {@link Set#TYPE})
     * @param elementType the element type
     * @param parent the parent model element
     * @return the collection return type, <b>null</b> if <code>aim</code> is none of the types given above
     */
    protected IDatatype createCollectionReturnType(IDatatype aim, IDatatype elementType, IModelElement parent) {
        IDatatype result = null;
        if (Sequence.TYPE == aim) {
            result = new Sequence("", elementType, parent);
        } else if (Set.TYPE == aim) {
            result = new Set("", elementType, parent);
        }
        return result;
    }
    
    /**
     * Determines the immediate operand for a collection.
     * 
     * @param mode the return type mode
     * @param immediateOperand the actual immediate operand
     * @param parameter the parameters
     * @return the return type
     */
    private IDatatype immediateOperandCollection(ReturnTypeMode mode, IDatatype immediateOperand, 
        IDatatype[] parameter) {
        IDatatype result;
        int index = mode.getParameterIndex();
        if (null != parameter && index >= 0 && index < parameter.length) {
            if (Set.TYPE.isAssignableFrom(immediateOperand)) {
                Set set = (Set) immediateOperand;
                IDatatype eltType; 
                if (mode.recurse()) {
                    eltType = TypeQueries.findDeepestGeneric(set, 0);
                } else {
                    eltType = parameter[index];
                }
                result = createCollectionReturnType(Set.TYPE, eltType, set.getParent());
            } else if (Sequence.TYPE.isAssignableFrom(immediateOperand)) {
                Sequence sequence = (Sequence) immediateOperand;
                IDatatype eltType; 
                if (mode.recurse()) {
                    eltType = TypeQueries.findDeepestGeneric(sequence, 0);
                } else {
                    eltType = parameter[index];
                }
                result = createCollectionReturnType(Sequence.TYPE, eltType, sequence.getParent());
            } else {
                result = parameter[index];
            }
        } else {
            result = immediateOperand;
        }
        return result;
    }
    
    /**
     * Returns whether this operation is a container iterating operation, e.g. a quantor, i.e., 
     * some form of nesting mode is activated.
     * 
     * @return <code>true</code> if this is a container operation, <code>false</code> else
     */
    public boolean isContainerOperation() {
        return nestingMode != NestingMode.NONE;
    }
    
    /**
     * Returns the nesting mode.
     * 
     * @return the nesting mode
     */
    public NestingMode getNestingMode() {
        return nestingMode;
    }
    
    /**
     * Returns whether this operation accepts <b>null</b> as argument.
     * 
     * @return whether it accepts null
     */
    public boolean acceptsNull() {
        return acceptsNull;
    }
    
    /**
     * Marks this operation as a flattening container iterating operation. 
     * 
     * @return <b>this</b>
     */
    Operation markAsFlatteningContainerOperation() {
        nestingMode = NestingMode.FLATTEN;
        return this;
    }

    /**
     * Marks this operation as a flattening container iterating operation.
     * 
     * @return <b>this</b>
     */
    Operation markAsNestingContainerOperation() {
        nestingMode = NestingMode.NESTING;
        return this;
    }

    /**
     * Marks this operation as a container iterating operation. Introduced as constructors grew to
     * more than 5 parameter. 
     * 
     * @return <b>this</b>
     */
    Operation markAsContainerOperation() {
        nestingMode = NestingMode.LEGACY;
        return this;
    }
    
    /**
     * Marks this operation as an alias of <code>op</code>, indicating that this
     * operation is a potential a risk for breaking OCL compliance.
     * 
     * @param op the aliased operation
     * @return <b>this</b>
     */
    Operation markAsAliasOf(Operation op) {
        alias.put(this, op);
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
     * Marks that this operation accepts <b>null</b> as argument. 
     * 
     * @return <b>this</b>
     */
    Operation markAsAcceptsNull() {
        acceptsNull = true;
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
     * Marks this operation by a formatting hint.
     *  
     * @param formattingHint the formatting hint
     * @return <b>this</b> (builder pattern)
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
    
    /**
     * Returns the signature of the operation.
     * 
     * @return the signature of the operation
     */
    public String getSignature() {
        StringBuilder tmp = new StringBuilder();
        String operand = IvmlDatatypeVisitor.getQualifiedType(getOperand());
        if (operand.isEmpty()) {
            IDatatype oType = getOperand();
            operand = oType.getName();
        }     
        tmp.append(operand);
        tmp.append(".");
        tmp.append(getName());
        tmp.append("(");
        for (int p = 0; p < getParameterCount(); p++) {
            if (p > 0) {
                tmp.append(", ");
            }
            tmp.append(IvmlDatatypeVisitor.getQualifiedType(getParameterType(p).getType()));
        }
        tmp.append(")");
        return tmp.toString();
    }
    
    /**
     * Returns the alias defined for the given operation has.
     * 
     * @param op the operation to look for (ignored if <b>null</b>)
     * @return the alias or <b>null</b> for none
     */
    public static Operation getAlias(Operation op) {
        return null == op ? null : alias.get(op);
    }

}
