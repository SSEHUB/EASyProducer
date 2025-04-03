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
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor.Message;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.RealValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Implements real operations.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class RealOperations {

    static final IOperationEvaluator EQUALS_REAL_INT = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return RealOperations.equalsRealInt(operand, arguments, false);
        }
    };
    
    static final IOperationEvaluator UNEQUALS_REAL_INT = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return RealOperations.equalsRealInt(operand, arguments, true);
        }
    };
    
    /**
     * Implements the to-integer conversion.
     */
    static final IOperationEvaluator TO_INT = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value value = operand.getValue();
            if (value instanceof RealValue) {
                double rValue = ((RealValue) value).getValue();
                try {
                    Value iValue = ValueFactory.createValue(IntegerType.TYPE, (int) rValue);
                    ConstantAccessor.POOL.getInstance().bind(iValue, true, operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    operand.getContext().addErrorMessage("toInt: " + e.getMessage(), Message.CODE_RESOLUTION);
                }
            }
            return result;
        }
    };
    
    static final IOperationEvaluator PLUS_REAL = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return arithmeticOperationReal(operand, arguments, ArithmeticOperationType.PLUS);
        }
    };
    
    static final IOperationEvaluator MINUS_REAL = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return arithmeticOperationReal(operand, arguments, ArithmeticOperationType.MINUS);
        }
    };
    
    static final IOperationEvaluator MULTIPLICATION_REAL = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return arithmeticOperationReal(operand, arguments, ArithmeticOperationType.MULTIPLICATION);
        }
    };
    
    static final IOperationEvaluator DIVISION_REAL = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return arithmeticOperationReal(operand, arguments, ArithmeticOperationType.DIVISION);
        }
    };
    
    static final IOperationEvaluator MODULO_REAL = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return arithmeticOperationReal(operand, arguments, ArithmeticOperationType.MODULO);
        }
    };
    
    static final IOperationEvaluator FLOOR = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return round(operand, arguments, false);
        }
    };
    
    static final IOperationEvaluator ROUND = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return round(operand, arguments, true);
        }
    };
    
    static final IOperationEvaluator MIN_REAL = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return minmaxOperationReal(operand, arguments, true);
        }
    };
    
    static final IOperationEvaluator MAX_REAL = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return minmaxOperationReal(operand, arguments, false);
        }
    };
    
    /**
     * Prevents external creation.
     */
    private RealOperations() {
    }
    
    /**
     * Registers the defined operations.
     */
    public static final void register() {
        EvaluatorRegistry.registerEvaluator(GenericOperations.TYPE_OF, RealType.TYPE_OF);
        EvaluatorRegistry.registerEvaluator(GenericOperations.EQUALS, RealType.EQUALS_REAL_REAL);
        EvaluatorRegistry.registerEvaluator(EQUALS_REAL_INT, RealType.EQUALS_REAL_INTEGER);
        EvaluatorRegistry.registerEvaluator(GenericOperations.ASSIGNMENT, 
            RealType.ASSIGNMENT_REAL_INTEGER, RealType.ASSIGNMENT_REAL_REAL);
        EvaluatorRegistry.registerEvaluator(GenericOperations.IS_DEFINED, RealType.IS_DEFINED);
        EvaluatorRegistry.registerEvaluator(GenericOperations.FORCE_DEFINED, RealType.FORCE_DEFINED);
        EvaluatorRegistry.registerEvaluator(GenericOperations.COPY, RealType.COPY);
        EvaluatorRegistry.registerEvaluator(GenericOperations.UNEQUALS, 
            RealType.NOTEQUALS_REAL_REAL, RealType.NOTEQUALS_REAL_REAL_ALIAS);
        EvaluatorRegistry.registerEvaluator(UNEQUALS_REAL_INT, 
            RealType.NOTEQUALS_REAL_INTEGER, RealType.NOTEQUALS_REAL_INTEGER_ALIAS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.TO_STRING, RealType.TO_STRING);
        EvaluatorRegistry.registerEvaluator(PLUS_REAL, RealType.PLUS_REAL_REAL, RealType.PLUS_REAL_INTEGER,
            IntegerType.PLUS_INTEGER_REAL);
        EvaluatorRegistry.registerEvaluator(MINUS_REAL, RealType.MINUS_REAL_REAL, RealType.MINUS_REAL_INTEGER,
            IntegerType.MINUS_INTEGER_REAL);
        EvaluatorRegistry.registerEvaluator(MULTIPLICATION_REAL, RealType.MULT_REAL_REAL, RealType.MULT_REAL_INTEGER,
            IntegerType.MULT_INTEGER_REAL);
        EvaluatorRegistry.registerEvaluator(DIVISION_REAL, RealType.DIV_REAL_REAL, RealType.DIV_REAL_INTEGER,
            IntegerType.DIV_INTEGER_REAL, IntegerType.DIVREAL_INTEGER_INTEGER);
        EvaluatorRegistry.registerEvaluator(MODULO_REAL, RealType.MOD_REAL_REAL, RealType.MOD_REAL_INTEGER,
            IntegerType.MOD_INTEGER_REAL);
        EvaluatorRegistry.registerEvaluator(FLOOR, RealType.FLOOR);
        EvaluatorRegistry.registerEvaluator(ROUND, RealType.ROUND);
        EvaluatorRegistry.registerEvaluator(MIN_REAL, RealType.MIN_REAL_REAL, RealType.MIN_REAL_INTEGER,
            IntegerType.MIN_INTEGER_REAL);
        EvaluatorRegistry.registerEvaluator(MAX_REAL, RealType.MAX_REAL_REAL, RealType.MAX_REAL_INTEGER,
            IntegerType.MAX_INTEGER_REAL);
    }

    /**
     * Implements the mixed int-real equality operation.
     * 
     * @param operand the operand
     * @param arguments the arguments
     * @param negate whether the result shall be negated
     * @return the comparison result, <b>null</b> if the operation cannot be applied
     */
    static EvaluationAccessor equalsRealInt(EvaluationAccessor operand, EvaluationAccessor[] arguments, 
        boolean negate) {
        EvaluationAccessor result = null;
        if (arguments.length == 1) {
            Value oValue = operand.getValue();
            Value aValue = arguments[0].getValue();
            if (aValue instanceof IntValue) {
                if (oValue instanceof RealValue) {
                    double op = ((RealValue) oValue).getValue();
                    int arg = ((IntValue) aValue).getValue();
                    boolean equals = ((int) op == arg);
                    if (negate) {
                        equals = !equals;
                    }
                    result = ConstantAccessor.POOL.getInstance().bind(
                        BooleanValue.toBooleanValue(equals), true, operand.getContext());
                } else if (oValue == NullValue.INSTANCE) {
                    result = ConstantAccessor.POOL.getInstance().bind(
                        BooleanValue.toBooleanValue(negate), true, operand.getContext());
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
    private static EvaluationAccessor arithmeticOperationReal(EvaluationAccessor operand,
        EvaluationAccessor[] arguments, ArithmeticOperationType type) {
        
        EvaluationAccessor result = null;
        
        if (null != operand.getValue() && arguments.length == 1 && null != arguments[0].getValue()) {
            Object oValue = operand.getValue().getValue();
            Object aValue = arguments[0].getValue().getValue();
            
            if (oValue instanceof Number && aValue instanceof Number && null != type) {
                
                double op = ((Number) oValue).doubleValue();
                double arg = ((Number) aValue).doubleValue();
                
                double resultOfOperation = 0;
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
                        if (Double.isInfinite(resultOfOperation) || Double.isNaN(resultOfOperation)) {
                            operationPerformed = false;
                        }
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
                        rValue = ValueFactory.createValue(RealType.TYPE, resultOfOperation);
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
     * Implements arithmetic operations of two integer variables/values.
     * @param operand the operand
     * @param arguments the arguments
     * @param roundUp If {@code true} this operation will round commercial (*.5 and higher will be round up), else
     *     numbers will be round down in any case.
     * @return The result of the arithmetic operation, <b>null</b> if the operation cannot be applied
     */
    private static EvaluationAccessor round(EvaluationAccessor operand,
        EvaluationAccessor[] arguments, boolean roundUp) {
        
        EvaluationAccessor result = null;
        if (null == arguments || arguments.length == 0) {
            Value value = operand.getValue();
            
            if (value instanceof RealValue) {
                double op = ((Double) value.getValue()).doubleValue();
                
                // Handle greater range of doubles in relation to range of integer
                int resultOfOperation = Integer.MAX_VALUE;
                if (op >= Integer.MIN_VALUE && op <= Integer.MAX_VALUE) {
                    resultOfOperation = (int) (roundUp ? Math.round(op) : Math.floor(op));
                } else if (op < Integer.MIN_VALUE) {
                    resultOfOperation = Integer.MIN_VALUE;
                }
                
                // Create (result) value
                try {
                    Value rValue = ValueFactory.createValue(IntegerType.TYPE, resultOfOperation);
                    result = ConstantAccessor.POOL.getInstance().bind(rValue, true, operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(GenericNumberOperations.class, Bundle.ID).exception(e);
                }
            }
        }
        
        return result;
    }
    
    /**
     * Implements min/max operations of two integer/real variables/values.
     * @param operand the operand
     * @param arguments the arguments
     * @param min If {@code true} the <b>min</b> operation will be applied, <b>max</b> otherwise.
     * @return The min/max of the two parameters, <b>null</b> if the operation cannot be applied
     */
    private static EvaluationAccessor minmaxOperationReal(EvaluationAccessor operand,
        EvaluationAccessor[] arguments, boolean min) {
        
        EvaluationAccessor result = null;
        if (arguments.length == 1) {
            Object oValue = operand.getValue().getValue();
            Object aValue = arguments[0].getValue().getValue();
            
            if (oValue instanceof Number && aValue instanceof Number) {
                Number op = (Number) oValue;
                Number arg = (Number) aValue;
                
                Number rNumber;
                if (min) {
                    // Copied from Math.min(int, int)
                    rNumber = (op.doubleValue() <= arg.doubleValue()) ? op : arg;
                } else {
                    // Copied from Math.max(int, int)
                    rNumber = (op.doubleValue() >= arg.doubleValue()) ? op : arg;
                }
                
                try {
                    Value rValue = ValueFactory.createValue(RealType.TYPE, rNumber);
                    result = ConstantAccessor.POOL.getInstance().bind(rValue, true, operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(GenericNumberOperations.class, Bundle.ID).exception(e);
                }
            }
        }
        
        return result;
    }
}
