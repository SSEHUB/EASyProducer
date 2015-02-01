/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.model.cst;

import java.util.Arrays;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.IvmlKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.BaseTypeVisitor;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.ICustomOperationAccessor;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.MetaType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation.ReturnTypeMode;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.datatypes.TypeQueries;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;

/**
 * Class for OCLFeatureCall. This class may resolve custom operations if
 * a {@link ICustomOperationAccessor} is provided to the constructor.
 * 
 * @author jaehne
 * @author tebbje
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
public class OCLFeatureCall extends ConstraintSyntaxTree {
    
    private ConstraintSyntaxTree operand;
    
    private String operation;

    //Initialization avoids NullpointerException in inferDatatype
    private ConstraintSyntaxTree[] parameters;
    private Operation resolvedOperation; // lazy
    private IDatatype result; // lazy
    private ICustomOperationAccessor opAccessor;
    
    /**
     * Constructs an OCL feature call as a node of a constraint
     * syntax tree. Please note that this node receives the name
     * of an operation/feature call while resolution whether
     * the name is valid will be done in {@link #inferDatatype()}.
     * 
     * @param operand the constraint syntax tree to execute the feature call / operation on (may be <b>null</b>
     *   in case of a custom operation)
     * @param operation the name of the operation / feature call
     * @param parameters the parameters for the operation (may be <b>null</b>
     *   in case of no parameter)
     */
    public OCLFeatureCall(ConstraintSyntaxTree operand, String operation, ConstraintSyntaxTree... parameters) {
        this(operand, operation, null, parameters);
    }

    /**
     * Constructs an OCL feature call as a node of a constraint
     * syntax tree. Please note that this node receives the name
     * of an operation/feature call while resolution whether
     * the name is valid will be done in {@link #inferDatatype()}.
     * The <code>opHolder</code> is required to resolve custom operations.
     * 
     * @param operand the constraint syntax tree to execute the feature call / operation on (may be <b>null</b>
     *   in case of a custom operation)
     * @param operation the name of the operation / feature call
     * @param opAccessor an optional instance which stores additional operation definitions, 
     *   typically the containing project, may be <b>null</b>
     * @param parameters the parameters for the operation (may be <b>null</b>
     *   in case of no parameter)
     */
    public OCLFeatureCall(ConstraintSyntaxTree operand, String operation, ICustomOperationAccessor opAccessor, 
            ConstraintSyntaxTree... parameters) {
        this.operand = operand;
        this.operation = operation;
        this.parameters = parameters;
        this.opAccessor = opAccessor;
    }

    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        if (null == result) {
            //check whether the OCLFeatureCall is semantically correct
            //we need an operation (name) and the data type to call on
            if (null != operation) {
                if (null != operand) {
                    dfltInferDatatype();
                } else {
                    customInferDatatype();
                }
            } else {
                // should not happen
                throw new CSTSemanticException("<internal error>", CSTSemanticException.INTERNAL);
            }
            //If no exception is thrown, this OCLFeature call is semantically correct. 
        }
        return result;
    }

    /**
     * Performs specific type compliance checks for found operations, e.g., in case of equality or assignments.
     * 
     * @param op the operation to be checked
     * @param operandType the actual operand type
     * @param parameterTypes the actual parameter types
     * @throws CSTSemanticException in case that operand type and parameter types shall match somehow but do not match
     */
    public static void checkTypeCompliance(Operation op, IDatatype operandType, IDatatype[] parameterTypes) 
        throws CSTSemanticException {
        if (null != op && (IvmlKeyWords.EQUALS.equals(op.getName()) || IvmlKeyWords.ASSIGNMENT.equals(op.getName()))) {
            if (null != parameterTypes && 1 == parameterTypes.length) {
                IDatatype pType = parameterTypes[0];
                if (!(pType.isAssignableFrom(operandType) || operandType.isAssignableFrom(pType))) {
                    throw new CSTSemanticException("operand and parameter type must be assignable", 
                        CSTSemanticException.TYPE_MISMATCH);
                }
            }
        }
    }

    /**
     * Performs the default infer operation, i.e. resolve operation on operand or search for
     * a custom operation.
     * 
     * @throws CSTSemanticException in case of type resolution problems
     */
    private void dfltInferDatatype() throws CSTSemanticException {
        IDatatype operandType = operand.inferDatatype();
        // determine parameter types
        IDatatype[] paramTypes = null;
        if (null == parameters) {
            paramTypes = null;
        } else {
            paramTypes = new IDatatype[parameters.length];
            for (int p = 0; p < parameters.length; p++) {
                paramTypes[p] = parameters[p].inferDatatype();
            }
        }
        // check for reference-based operation
        Operation op = null;
        IDatatype relevantType = operandType;
        if (Container.TYPE.isAssignableFrom(operandType.getType())) {
            relevantType = ((Container) operandType.getType()).getContainedType();
        } 
        if (Reference.TYPE.isAssignableFrom(relevantType)) {
            op = TypeQueries.getOperation(operandType, operation, paramTypes);
            checkTypeCompliance(op, operandType, paramTypes);
        }
        // normal operations
        operandType = BaseTypeVisitor.getBaseType(operandType);
        if (null == op) {
            operandType = Reference.dereference(operandType);
            Reference.dereference(paramTypes);
            op = TypeQueries.getOperation(operandType, operation, paramTypes);
            if (null == op && null != paramTypes) {
                IDatatype[] paramTypesBase = new IDatatype[paramTypes.length];
                for (int p = 0; p < paramTypes.length; p++) {
                    paramTypesBase[p] = BaseTypeVisitor.getBaseType(paramTypes[p]);
                }
                op = TypeQueries.getOperation(operandType, operation, paramTypesBase);
            }
            if (null == op) {
                op = customInferDatatype();
                if (null == op) {
                    throw new UnknownOperationException(operation, CSTSemanticException.UNKNOWN_OPERATION, 
                        operandType, paramTypes);
                }
                op = null;
            }
        }
        if (null != op) {
            // done on individual types by customInferDatatype
            replaceEmptyInitializer(op);
            checkRequiredAssignableParameter(op, operandType, paramTypes);
            result = getActualReturnType(op, operandType, paramTypes);
            resolvedOperation = op;
        }
    }
    
    /**
     * Replaces (temporary) empty initializers.
     * 
     * @param op the operation to be considered
     */
    private void replaceEmptyInitializer(Operation op) {
        if (null != parameters) {
            for (int p = 0; p < parameters.length; p++) {
                if (EmptyInitializer.INSTANCE == parameters[p]) {
                    IDatatype pType = op.getParameter(p);
                    try {
                        if (Compound.TYPE.isAssignableFrom(pType)) {
                            parameters[p] = new CompoundInitializer((Compound) pType, new String[] {}, 
                                new AbstractVariable[] {}, new ConstraintSyntaxTree[] {});
                        } else if (Container.TYPE.isAssignableFrom(pType)) {
                            parameters[p] = new ContainerInitializer((Container) pType, new ConstraintSyntaxTree[] {});
                        }
                    } catch (CSTSemanticException e) {
                        EASyLoggerFactory.INSTANCE.getLogger(OCLFeatureCall.class, Bundle.ID).exception(e);
                    }
                }
            }
        }
    }
    
    /**
     * Determines the actual return type and considers the actual type of meta type parameters.
     *
     * @param op the operation to consider
     * @param immediateOperand the actual operand type (complying to {@link #getOperand()}.
     * @param parameter the actual parameter
     * @return the actual return type
     */
    private IDatatype getActualReturnType(Operation op, IDatatype immediateOperand, IDatatype... parameter) {
        // actually unsure whether the other inferType operations have to use this method
        IDatatype result = op.getActualReturnType(immediateOperand, parameter);
        ReturnTypeMode mode = op.getReturnTypeMode(); // this is intended to be polymorphic
        if (ReturnTypeMode.TYPED_PARAM_1 == mode && mode.getParameterIndex() < parameters.length 
            && MetaType.TYPE.isAssignableFrom(result)) {
            ConstraintSyntaxTree param = parameters[mode.getParameterIndex()];
            if (immediateOperand instanceof Set) {
                Set set = (Set) immediateOperand;
                result = new Set("", param.getContainedType(), set.getParent());
            } else if (immediateOperand instanceof Sequence) {
                Sequence sequence = (Sequence) immediateOperand;
                result = new Set("", param.getContainedType(), sequence.getParent());
            } else {
                result = immediateOperand;
            }
        }
        return result;
    }
    
    /**
     * Checks the operation for required assignable parameter if required. Mismatch leads 
     * to exception.
     * 
     * @param op the resolved operation
     * @param operandType the resolved operand type
     * @param paramTypes the resolved parameter types
     * @throws CSTSemanticException in case of any type conflict or mismatching parameter
     */
    private void checkRequiredAssignableParameter(Operation op, IDatatype operandType, 
        IDatatype[] paramTypes) throws CSTSemanticException {
        if (op.requiresAssignableParameter()) {
            boolean ok = true;
            // one parameter, i.e. only operand is no problem
            for (int p = 0; p < paramTypes.length; p++) {
                ok &= operandType.isAssignableFrom(paramTypes[p]) 
                    || paramTypes[p].isAssignableFrom(operandType);
            }
            if (!ok) {
                throw new CSTSemanticException("the types of all parameters of operation '" 
                    + op.getName() + "' need to be compliant", CSTSemanticException.TYPE_MISMATCH);
            }
        }
    }

    /**
     * Performs the infer operation for custom operations only, i.e. 
     * operand and parameter need to be mapped appropriately.
     * 
     * @return the resolved operation or <b>null</b>
     * @throws CSTSemanticException in case of type resolution problems
     */
    private Operation customInferDatatype() throws CSTSemanticException {
        Operation op = null;
        if (null != opAccessor) {
            // the operand of custom operation is always the project
            IDatatype operandType = opAccessor.getType();
            // map operand of feature call to first parameter
            IDatatype fcOperandType;
            int fcOperandIncrement;
            if (null == operand) {
                fcOperandType = null;
                fcOperandIncrement = 0;
            } else {
                fcOperandType = operand.inferDatatype();
                fcOperandIncrement = 1;
            }
            IDatatype[] paramTypes;
            int paramCount = getParameterCount() + fcOperandIncrement;
            if (0 == paramCount) {
                paramTypes = null;
            } else {
                paramTypes = new IDatatype[paramCount];
                if (null != fcOperandType) {
                    paramTypes[0] = fcOperandType;
                }
                for (int p = fcOperandIncrement; p < paramCount; p++) {
                    paramTypes[p] = Reference.dereference(parameters[p - fcOperandIncrement].inferDatatype());
                }
            }
            op = getCustomOperation(operandType, paramTypes);
            if (null != op) {
                replaceEmptyInitializer(op);
                checkRequiredAssignableParameter(op, operandType, paramTypes);
                result = getActualReturnType(op, operandType, paramTypes);
                resolvedOperation = op;
            } // not found exception is thrown in dflt
        } else {
            throw new CSTSemanticException("no custom operator accessor given for " + getOperation(), 
                CSTSemanticException.INTERNAL);
        }
        return op;
    }
        
    /**
     * Searches for a custom operation on {@link #opAccessor}. {@link #opAccessor} must not
     * be <b>null</b>.
     * 
     * @param operandType the operand type
     * @param paramTypes the parameter types
     * @return the operation or <b>null</b>
     */
    private Operation getCustomOperation(IDatatype operandType, IDatatype[] paramTypes) {
        Operation op = null;
        for (int o = 0; null == op && o < opAccessor.getOperationCount(); o++) {
            Operation tmp = opAccessor.getOperation(o);
            if (tmp.getName().equals(operation)) {
                if (operandType.equals(tmp.getOperand())) { // operations of the same project only, not isAssignable!
                    int tmpParamCount = tmp.getParameterCount();
                    if (null == paramTypes || 0 == paramTypes.length) {
                        // feature call has no parameter, custom operation must not have parameters to be qual
                        if (0 == tmpParamCount) {
                            op = tmp;
                        }
                    } else if (paramTypes.length == tmpParamCount) {
                        // feature call has parameter and also the same number of parameters, check types
                        boolean eq = true;
                        for (int p = 0; eq && p < tmpParamCount; p++) {
                            boolean ok = tmp.getParameter(p).isAssignableFrom(paramTypes[p]);
                            if (!ok) {
                                ok = tmp.getParameter(p).isAssignableFrom(Reference.dereference(paramTypes[p]));
                            }
                            eq = ok;
                        }
                        if (eq) {
                            op = tmp;
                        }
                    }
                }
            }
        }
        return op;
    }

    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitOclFeatureCall(this); // no further operations!
    }
    
    /**
     * Returns the operand.
     * 
     * @return the operand, may be <b>null</b> in case of custom 
     *   operations with no parameter
     */
    public ConstraintSyntaxTree getOperand() {
        return operand;
    }
    
    /**
     * Returns the operation name.
     * 
     * @return the operation name
     */
    public String getOperation() {
        return operation;
    }
    
    /**
     * Returns the number of parameters.
     * 
     * @return the number of parameters
     */
    public int getParameterCount() {
        return null == parameters ? 0 : parameters.length;
    }
    
    /**
     * Returns a specific parameter.
     * 
     * @param index the index of the parameter
     * @return the parameter
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getParameterCount()}</code>
     */
    public ConstraintSyntaxTree getParameter(int index) {
        if (null == parameters) {
            throw new IndexOutOfBoundsException();
        }
        return parameters[index];
    }
    
    /**
     * Returns the resolved operation. The result is only valid if
     * {@link #inferDatatype()} was called before this operation.
     * 
     * @return the resolved operation, <b>null</b> if the operation cannot
     *   be resolved or {@link #inferDatatype()} was not called before
     */
    public Operation getResolvedOperation() {
        return resolvedOperation;
    }
    
    /**
     * Returns the custom operation accessor.
     * 
     * @return the accessor (may be <b>null</b>)
     */
    public ICustomOperationAccessor getAccessor() {
        return opAccessor;
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj instanceof OCLFeatureCall) {
            OCLFeatureCall other = (OCLFeatureCall) obj;
            equals = operation.equals(other.operation);
            equals &= operand.equals(other.operand);
            // result hashcode/equals unclear
            if (null != opAccessor) {
                equals &= opAccessor.equals(other.opAccessor);    
            }
            equals &= Arrays.equals(parameters, other.parameters);
        }
        return equals;
    }
    
    @Override
    public int hashCode() {
        int hashCode = operand.hashCode();
        hashCode *= Arrays.hashCode(parameters);
        hashCode *= operation.hashCode();
        if (null != opAccessor) {
            hashCode *= opAccessor.hashCode();
        }
        // result hashcode/equals unclear
        return hashCode;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        if (null != operand) {
            result.append(operand.toString() + " ");
        }
        result.append(operation.toString());
        if (null != parameters) {
            for (int i = 0, n = parameters.length; i < n; i++) {
                result.append(" ");
                result.append(parameters[i].toString());
            }
        }
        return result.toString();
    }
}
