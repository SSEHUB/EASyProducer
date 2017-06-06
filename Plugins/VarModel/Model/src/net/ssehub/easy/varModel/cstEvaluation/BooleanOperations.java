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

import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Implements Boolean operations.
 * 
 * @author Holger Eichelberger
 */
public class BooleanOperations {

    /**
     * Implements the unary Boolean negation.
     */
    static final IOperationEvaluator NOT = new IOperationEvaluator() {

        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (null != operand) {
                Value value = operand.getValue();
                if (value instanceof BooleanValue) {
                    Boolean bool = ((BooleanValue) value).getValue();
                    if (null != bool) {
                        result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.toBooleanValue(!bool), 
                            operand.getContext());
                    }
                }
            }
            return result;
        }
    };
    
    /**
     * Implements the warning operation. If the inner expression is defined, then go to true. If undefined, 
     * remain on undefined.
     */
    static final IOperationEvaluator WARNING = new IOperationEvaluator() {

        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (null != operand) {
                EvaluationContext context = operand.getContext();
                Value value = operand.getValue();
                if (value instanceof BooleanValue) {
                    Boolean bool = ((BooleanValue) value).getValue();
                    if (null != bool) {
                        if (Boolean.FALSE == bool) {
                            context.issueWarning();
                        }
                    }
                }
                result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.TRUE, context);
            }
            return result;
        }
    };

    /**
     * Defines the interface for a binary boolean operation.
     * 
     * @author Holger Eichelberger
     */
    private interface BinaryBooleanOperation {

        /**
         * Evaluates boolean values according to the operation.
         * 
         * @param b1 the first value
         * @param b2 the second value
         * @return the result value of applying the operation
         */
        public boolean evaluate(boolean b1, boolean b2); 
    }
    
    /**
     * Generically implements binary Boolean operations.
     */
    private static class BinaryOperationEvaluator implements IOperationEvaluator {
        
        private BinaryBooleanOperation op;
        
        /**
         * Creates a binary operation evaluator based on a binary boolean operation.
         * 
         * @param op the operation to evaluate
         */
        private BinaryOperationEvaluator(BinaryBooleanOperation op) {
            this.op = op;
        }

        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (null != operand && null != arguments && 1 == arguments.length) {
                Value op = operand.getValue();
                Value arg = arguments[0].getValue();
                if (op instanceof BooleanValue && arg instanceof BooleanValue) {
                    Boolean bOp = ((BooleanValue) op).getValue();
                    Boolean bArg = ((BooleanValue) arg).getValue();
                    if (null != bOp && null != bArg) {
                        result = ConstantAccessor.POOL.getInstance().bind(
                            BooleanValue.toBooleanValue(this.op.evaluate(bOp, bArg)), operand.getContext());
                    } // one sided undefined may be considered here
                }
            }
            return result;
        }
    };
    
    /**
     * Prevents external creation.
     */
    private BooleanOperations() {
    }
    
    /**
     * Registers the defined operations.
     */
    public static final void register() {
        EvaluatorRegistry.registerEvaluator(GenericOperations.TYPE_OF, BooleanType.TYPE_OF);
        EvaluatorRegistry.registerEvaluator(GenericOperations.EQUALS, BooleanType.EQUALS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.UNEQUALS, BooleanType.UNEQUALS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.ASSIGNMENT, BooleanType.ASSIGNMENT);
        EvaluatorRegistry.registerEvaluator(GenericOperations.IS_DEFINED, BooleanType.IS_DEFINED);
        EvaluatorRegistry.registerEvaluator(GenericOperations.TO_STRING, BooleanType.TO_STRING);
        EvaluatorRegistry.registerEvaluator(NOT, BooleanType.NOT);
        EvaluatorRegistry.registerEvaluator(WARNING, BooleanType.WARNING);
        EvaluatorRegistry.registerEvaluator(new BinaryOperationEvaluator(new BinaryBooleanOperation() {
            
            public boolean evaluate(boolean b1, boolean b2) {
                return b1 || b2;
            }
        }), BooleanType.OR);
        EvaluatorRegistry.registerEvaluator(new BinaryOperationEvaluator(new BinaryBooleanOperation() {
            
            public boolean evaluate(boolean b1, boolean b2) {
                return b1 ^ b2;
            }
        }), BooleanType.XOR);
        EvaluatorRegistry.registerEvaluator(new BinaryOperationEvaluator(new BinaryBooleanOperation() {
            
            public boolean evaluate(boolean b1, boolean b2) {
                return b1 && b2;
            }
        }), BooleanType.AND);
        EvaluatorRegistry.registerEvaluator(new BinaryOperationEvaluator(new BinaryBooleanOperation() {
            
            public boolean evaluate(boolean b1, boolean b2) {
                return !b1 || b2;
            }
        }), BooleanType.IMPLIES);
        EvaluatorRegistry.registerEvaluator(new BinaryOperationEvaluator(new BinaryBooleanOperation() {
            
            public boolean evaluate(boolean b1, boolean b2) {
                return (!b1 || b2) && (!b2 || b1);
            }
        }), BooleanType.IFF);
        EvaluatorRegistry.registerEvaluator(new BinaryOperationEvaluator(new BinaryBooleanOperation() {
            
            public boolean evaluate(boolean b1, boolean b2) {
                return b1 && b2;
            }
        }), BooleanType.MULTI_AND);
    }
    
}
