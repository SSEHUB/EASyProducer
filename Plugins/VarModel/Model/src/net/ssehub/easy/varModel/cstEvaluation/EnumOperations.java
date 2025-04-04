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
package net.ssehub.easy.varModel.cstEvaluation;

import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.EnumValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Implements enum and ordered enum operations.
 * 
 * @author Holger Eichelberger
 */
public class EnumOperations {

    /**
     * Implements the ordinal operation for enums.
     */
    static final IOperationEvaluator ORDINAL = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value val = operand.getValue();
            if (val instanceof EnumValue) {
                EnumValue eVal = (EnumValue) val;
                EnumLiteral lit = eVal.getValue();
                try {
                    Value res = ValueFactory.createValue(IntegerType.TYPE, lit.getOrdinal());
                    result = ConstantAccessor.POOL.getInstance().bind(res, true, operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    // result -> null
                }
            }
            return result;
        }
    };
    
    /**
     * Defines the evaluation of a binary enum (literal) operation.
     * 
     * @author Holger Eichelberger
     */
    private interface BinaryEnumComparisonOperation {
        
        /**
         * Performs an operation on <code>e1</code> and <code>e2</code> and returns a boolean value.
         * 
         * @param e1 the first literal
         * @param e2 the second literal
         * @return whether the comparison was successful
         */
        public boolean evaluate(EnumLiteral e1, EnumLiteral e2);
    }
    
    /**
     * Implements the generic enum comparison operation based on {@link BinaryEnumComparisonOperation}.
     * 
     * @author Holger Eichelberger
     */
    private static class EnumComparisonOperation implements IOperationEvaluator {
        
        private BinaryEnumComparisonOperation op;
        
        /**
         * Creates an operation instance parameterized by the given comparison operation.
         * 
         * @param op the operation to be performed
         */
        EnumComparisonOperation(BinaryEnumComparisonOperation op) {
            this.op = op;
        }

        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value opVal = operand.getValue();
                Value aVal = arguments[0].getValue();
                if (opVal instanceof EnumValue && aVal instanceof EnumValue && opVal.getType() == aVal.getType()) {
                    boolean tmp = op.evaluate(((EnumValue) opVal).getValue(), ((EnumValue) aVal).getValue());
                    BooleanValue rVal = BooleanValue.toBooleanValue(tmp);
                    result = ConstantAccessor.POOL.getInstance().bind(rVal, true, operand.getContext());
                }
            }
            return result;
        }
        
    }
    
    /**
     * Implements {@link OrderedEnum#MIN}.
     */
    static class MinMaxEvaluator implements IOperationEvaluator {

        private boolean min;
        
        /**
         * Creates a minimum/maximum evaluator.
         * 
         * @param min return minimum (<code>true</code>) or maximum (<code>false</code>)
         */
        private MinMaxEvaluator(boolean min) {
            this.min = min;
        }
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value opVal = operand.getValue();
                Value aVal = arguments[0].getValue();
                if (opVal instanceof EnumValue && aVal instanceof EnumValue && opVal.getType() == aVal.getType()) {
                    EnumLiteral opLit = ((EnumValue) opVal).getValue();
                    EnumLiteral aLit = ((EnumValue) aVal).getValue();
                    EnumLiteral res;
                    if (min) {
                        if (opLit.getOrdinal() <= aLit.getOrdinal()) {
                            res = opLit;
                        } else {
                            res = aLit;
                        }
                    } else {
                        if (opLit.getOrdinal() >= aLit.getOrdinal()) {
                            res = opLit;
                        } else {
                            res = aLit;
                        }
                    }
                    try {
                        Value resVal = ValueFactory.createValue(opVal.getType(), res);
                        result = ConstantAccessor.POOL.getInstance().bind(resVal, true, operand.getContext());
                    } catch (ValueDoesNotMatchTypeException e) {
                        // result is anyway null
                    }
                }                
            }
            return result;
        }
        
    };
    
    /**
     * Prevents external creation.
     */
    private EnumOperations() {
    }
    
    /**
     * Registers the defined operations.
     */
    public static final void register() {
        EvaluatorRegistry.registerEvaluator(GenericOperations.TYPE_OF, Enum.TYPE_OF);
        EvaluatorRegistry.registerEvaluator(GenericOperations.EQUALS, Enum.EQUALS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.UNEQUALS, Enum.NOTEQUALS, Enum.NOTEQUALS_ALIAS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.ASSIGNMENT, Enum.ASSIGNMENT);
        EvaluatorRegistry.registerEvaluator(GenericOperations.IS_DEFINED, Enum.IS_DEFINED);
        EvaluatorRegistry.registerEvaluator(GenericOperations.IF_DEFINED, Enum.IF_DEFINED);
//        EvaluatorRegistry.registerEvaluator(GenericOperations.COPY, Enum.COPY);
        EvaluatorRegistry.registerEvaluator(ORDINAL, Enum.ORDINAL);
        
        // ordered enum
        EvaluatorRegistry.registerEvaluator(new EnumComparisonOperation(new BinaryEnumComparisonOperation() {
            
            public boolean evaluate(EnumLiteral e1, EnumLiteral e2) {
                return e1.getOrdinal() > e2.getOrdinal();
            }
        }), OrderedEnum.GREATER);
        EvaluatorRegistry.registerEvaluator(new EnumComparisonOperation(new BinaryEnumComparisonOperation() {
            
            public boolean evaluate(EnumLiteral e1, EnumLiteral e2) {
                return e1.getOrdinal() >= e2.getOrdinal();
            }
        }), OrderedEnum.GREATER_EQUALS);
        EvaluatorRegistry.registerEvaluator(new EnumComparisonOperation(new BinaryEnumComparisonOperation() {
            
            public boolean evaluate(EnumLiteral e1, EnumLiteral e2) {
                return e1.getOrdinal() < e2.getOrdinal();
            }
        }), OrderedEnum.LESS);
        EvaluatorRegistry.registerEvaluator(new EnumComparisonOperation(new BinaryEnumComparisonOperation() {
            
            public boolean evaluate(EnumLiteral e1, EnumLiteral e2) {
                return e1.getOrdinal() <= e2.getOrdinal();
            }
        }), OrderedEnum.LESS_EQUALS);
        EvaluatorRegistry.registerEvaluator(new MinMaxEvaluator(true), OrderedEnum.MIN);
        EvaluatorRegistry.registerEvaluator(new MinMaxEvaluator(false), OrderedEnum.MAX);
    }
    
}
