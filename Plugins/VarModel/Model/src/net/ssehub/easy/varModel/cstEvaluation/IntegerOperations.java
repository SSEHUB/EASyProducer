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

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.RealValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Implements integer operations.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class IntegerOperations {
    
    static final IOperationEvaluator EQUALS_INT_REAL = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return IntegerOperations.equalsIntReal(operand, arguments, false);
        }
    };
    
    static final IOperationEvaluator UNEQUALS_INT_REAL = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return IntegerOperations.equalsIntReal(operand, arguments, true);
        }
    };
    
    static final IOperationEvaluator PLUS_INT_INT = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return arithmeticOperationIntInt(operand, arguments, ArithmeticOperationType.PLUS);
        }
    };
    
    static final IOperationEvaluator MINUS_INT_INT = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return arithmeticOperationIntInt(operand, arguments, ArithmeticOperationType.MINUS);
        }
    };

    static final IOperationEvaluator MULTIPLICATION_INT_INT = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return arithmeticOperationIntInt(operand, arguments, ArithmeticOperationType.MULTIPLICATION);
        }
    };
    
    static final IOperationEvaluator DIVISION_INT_INT = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return arithmeticOperationIntInt(operand, arguments, ArithmeticOperationType.DIVISION);
        }
    };
    
    static final IOperationEvaluator MODULO_INT_INT = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return arithmeticOperationIntInt(operand, arguments, ArithmeticOperationType.MODULO);
        }
    };
    
    static final IOperationEvaluator MIN_INT_INT = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return minmaxOperationIntInt(operand, arguments, true);
        }
    };
    
    static final IOperationEvaluator MAX_INT_INT = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return minmaxOperationIntInt(operand, arguments, false);
        }
    };
    
    /**
     * Prevents external creation.
     */
    private IntegerOperations() {
    }
    
    /**
     * Registers the defined operations.
     */
    public static final void register() {
        EvaluatorRegistry.registerEvaluator(GenericOperations.TYPE_OF, IntegerType.TYPE_OF);
        EvaluatorRegistry.registerEvaluator(GenericOperations.EQUALS, IntegerType.EQUALS_INTEGER_INTEGER);
        EvaluatorRegistry.registerEvaluator(GenericOperations.TO_STRING, IntegerType.TO_STRING);
        EvaluatorRegistry.registerEvaluator(EQUALS_INT_REAL, IntegerType.EQUALS_INTEGER_REAL);
        EvaluatorRegistry.registerEvaluator(GenericOperations.ASSIGNMENT, IntegerType.ASSIGNMENT_INTEGER_INTEGER);
        EvaluatorRegistry.registerEvaluator(GenericOperations.IS_DEFINED, IntegerType.IS_DEFINED);
        EvaluatorRegistry.registerEvaluator(GenericOperations.UNEQUALS, IntegerType.NOTEQUALS_INTEGER_INTEGER);
        EvaluatorRegistry.registerEvaluator(UNEQUALS_INT_REAL, IntegerType.NOTEQUALS_INTEGER_REAL);
        EvaluatorRegistry.registerEvaluator(GenericOperations.UNEQUALS, 
            IntegerType.NOTEQUALS_INTEGER_INTEGER_ALIAS, IntegerType.NOTEQUALS_INTEGER_REAL_ALIAS);
        EvaluatorRegistry.registerEvaluator(IntegerOperations.PLUS_INT_INT, IntegerType.PLUS_INTEGER_INTEGER);
        EvaluatorRegistry.registerEvaluator(IntegerOperations.MINUS_INT_INT, IntegerType.MINUS_INTEGER_INTEGER);
        EvaluatorRegistry.registerEvaluator(IntegerOperations.MULTIPLICATION_INT_INT, IntegerType.MULT_INTEGER_INTEGER);
        EvaluatorRegistry.registerEvaluator(IntegerOperations.DIVISION_INT_INT, IntegerType.DIV_INTEGER_INTEGER);
        EvaluatorRegistry.registerEvaluator(IntegerOperations.MODULO_INT_INT, IntegerType.MOD_INTEGER_INTEGER);
        EvaluatorRegistry.registerEvaluator(IntegerOperations.MIN_INT_INT, IntegerType.MIN_INTEGER_INTEGER);
        EvaluatorRegistry.registerEvaluator(IntegerOperations.MAX_INT_INT, IntegerType.MAX_INTEGER_INTEGER);
    }

    /**
     * Implements the mixed int-real equality operation.
     * 
     * @param operand the operand
     * @param arguments the arguments
     * @param negate whether the result shall be negated
     * @return the comparison result, <b>null</b> if the operation cannot be applied
     */
    static EvaluationAccessor equalsIntReal(EvaluationAccessor operand, EvaluationAccessor[] arguments, 
        boolean negate) {
        EvaluationAccessor result = null;
        if (arguments.length == 1) {
            Value oValue = operand.getValue();
            Value aValue = arguments[0].getValue();
            if (aValue instanceof RealValue) {
                if (oValue instanceof IntValue) {
                    int op = ((IntValue) oValue).getValue();
                    double arg = ((RealValue) aValue).getValue();
                    boolean equals = (op == (int) arg);
                    if (negate) {
                        equals = !equals;
                    }
                    result = ConstantAccessor.POOL.getInstance().bind(
                        BooleanValue.toBooleanValue(equals), true, operand.getContext());
                }
            }
        }
        return result;
    }
    
    /**
     * Implements arithmetic operations of two integer variables/values.
     * @param operand the operand
     * @param arguments the arguments
     * @param type The desired arithmetic operation.
     * @return The result of the arithmetic operation, <b>null</b> if the operation cannot be applied
     */
    private static EvaluationAccessor arithmeticOperationIntInt(EvaluationAccessor operand,
        EvaluationAccessor[] arguments, ArithmeticOperationType type) {
        
        EvaluationAccessor result = null;
        if (arguments.length == 1) {
            Value oValue = operand.getValue();
            Value aValue = arguments[0].getValue();
            if (oValue instanceof IntValue && aValue instanceof IntValue && null != type) {
                int op = ((IntValue) oValue).getValue();
                int arg = ((IntValue) aValue).getValue();
                
                int resultOfOperation = 0;
                boolean operationPerformed = true;
                try {
                    switch (type) {
                    case PLUS:
                        resultOfOperation = op + arg;
                        break;
                    case MINUS:
                        resultOfOperation = op - arg;
                        break;
                    case MULTIPLICATION:
                        resultOfOperation = op * arg;
                        break;
                    case DIVISION:
                        resultOfOperation = op / arg;
                        break;
                    case MODULO:
                        resultOfOperation = op % arg;
                        break;
                    default:
                        operationPerformed = false;
                        break;
                    }
                } catch (ArithmeticException e) {
                    operationPerformed = false;
                }
                
                if (operationPerformed) {
                    Value rValue;
                    try {
                        rValue = ValueFactory.createValue(IntegerType.TYPE, resultOfOperation);
                        result = ConstantAccessor.POOL.getInstance().bind(rValue, true, operand.getContext());
                    } catch (ValueDoesNotMatchTypeException e) {
                        EASyLoggerFactory.INSTANCE.getLogger(GenericNumberOperations.class, Bundle.ID).exception(e);
                    }
                }
            }
        }
        
        return result;
    }
    
    /**
     * Implements min/max operations of two integer variables/values.
     * @param operand the operand
     * @param arguments the arguments
     * @param min If <tt>true</tt> the <b>min</b> operation will be applied, <b>max</b> otherwise.
     * @return The min/max of the two parameters, <b>null</b> if the operation cannot be applied
     */
    private static EvaluationAccessor minmaxOperationIntInt(EvaluationAccessor operand,
        EvaluationAccessor[] arguments, boolean min) {
        
        EvaluationAccessor result = null;
        if (arguments.length == 1) {
            Value oValue = operand.getValue();
            Value aValue = arguments[0].getValue();
            if (oValue instanceof IntValue && aValue instanceof IntValue) {
                int op = ((IntValue) oValue).getValue();
                int arg = ((IntValue) aValue).getValue();
                
                Value rValue;
                if (min) {
                    // Copied from Math.min(int, int)
                    rValue = (op <= arg) ? oValue : aValue;
                } else {
                    // Copied from Math.max(int, int)
                    rValue = (op >= arg) ? oValue : aValue;
                }
                
                result = ConstantAccessor.POOL.getInstance().bind(rValue, false, operand.getContext());
            }
        }
        
        return result;
    }

}
