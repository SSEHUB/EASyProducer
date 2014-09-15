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
package de.uni_hildesheim.sse.model.cstEvaluation;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.values.BooleanValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;

/**
 * Generic Number ({@link IntegerType}, {@link RealType}) operations.
 * @author El-Sharkawy
 *
 */
class GenericNumberOperations {
    
    /**
     * Strategy for comparing two numbers. this is used for defining constant operations.
     * @author El-Sharkawy
     *
     */
    private static interface INumberComparator {
        
        /**
         * Compares two numbers according to a specific operations.
         * @param value1 The first value to compare
         * @param value2 The second value to compare
         * @return The result of the comparison.
         */
        boolean compare(Number value1, Number value2);
    }

    private static final INumberComparator LESS_COMPARATOR = new INumberComparator() {
    
        public boolean compare(Number value1, Number value2) {
            return value1.doubleValue() < value2.doubleValue();
        }
    };
    
    private static final INumberComparator LESS_EQUALS_COMPARATOR = new INumberComparator() {
        
        public boolean compare(Number value1, Number value2) {
            return value1.doubleValue() <= value2.doubleValue();
        }
    };
    
    private static final INumberComparator GREATER_COMPARATOR = new INumberComparator() {
        
        public boolean compare(Number value1, Number value2) {
            return value1.doubleValue() > value2.doubleValue();
        }
    };
    
    private static final INumberComparator GREATER_EQUALS_COMPARATOR = new INumberComparator() {
        
        public boolean compare(Number value1, Number value2) {
            return value1.doubleValue() >= value2.doubleValue();
        }
    };
    
    private static final IOperationEvaluator GREATER = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return comparisionOperation(operand, arguments, GREATER_COMPARATOR);
        }
    };
    
    private static final IOperationEvaluator GREATER_EQUALS = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return comparisionOperation(operand, arguments, GREATER_EQUALS_COMPARATOR);
        }
    };
    
    private static final IOperationEvaluator LESS = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return comparisionOperation(operand, arguments, LESS_COMPARATOR);
        }
    };
    
    private static final IOperationEvaluator LESS_EQUALS = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return comparisionOperation(operand, arguments, LESS_EQUALS_COMPARATOR);
        }
    };
    
    private static final IOperationEvaluator INVERSE = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return inverse(operand, arguments);
        }
    };
    
    private static final IOperationEvaluator ABSOLUTE = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return absolute(operand, arguments);
        }
    };
    
    /**
     * Registers the defined operations.
     */
    public static final void register() {
        EvaluatorRegistry.registerEvaluator(GREATER_EQUALS, IntegerType.GREATER_EQUALS_INTEGER_INTEGER,
            IntegerType.GREATER_EQUALS_INTEGER_REAL, RealType.GREATER_EQUALS_REAL_INTEGER,
            RealType.GREATER_EQUALS_REAL_REAL);
        EvaluatorRegistry.registerEvaluator(GREATER, IntegerType.GREATER_INTEGER_INTEGER,
            IntegerType.GREATER_INTEGER_REAL, RealType.GREATER_REAL_INTEGER,
            RealType.GREATER_REAL_REAL);
        EvaluatorRegistry.registerEvaluator(LESS_EQUALS, IntegerType.LESS_EQUALS_INTEGER_INTEGER,
            IntegerType.LESS_EQUALS_INTEGER_REAL, RealType.LESS_EQUALS_REAL_INTEGER,
            RealType.LESS_EQUALS_REAL_REAL);
        EvaluatorRegistry.registerEvaluator(LESS, IntegerType.LESS_INTEGER_INTEGER,
            IntegerType.LESS_INTEGER_REAL, RealType.LESS_REAL_INTEGER,
            RealType.LESS_REAL_REAL);
        EvaluatorRegistry.registerEvaluator(INVERSE, IntegerType.INVERSE_INTEGER, RealType.INVERSE_REAL);
        EvaluatorRegistry.registerEvaluator(ABSOLUTE, IntegerType.ABS_INTEGER_INTEGER, RealType.ABS_REAL_REAL);
    }
    
    /**
     * Compares two numbers.
     * Supported comparisons are: less, less_equals, greater, and greater_equals.
     * @param operand the operand
     * @param arguments the arguments
     * @param strategy A {@link INumberComparator}, specifying which comparison should be used.
     * @return The result of the comparison. 
     */
    private static EvaluationAccessor comparisionOperation(EvaluationAccessor operand,
        EvaluationAccessor[] arguments, INumberComparator strategy) {
        
        EvaluationAccessor result = null;
        if (operand.getValue() != null && arguments.length == 1 && null != arguments[0].getValue()) {
            Object oValue = operand.getValue().getValue();
            Object aValue = arguments[0].getValue().getValue();
            
            if (oValue instanceof Number && aValue instanceof Number && null != strategy) {
                boolean booleanResult = strategy.compare((Number) oValue, (Number) aValue);
                
                result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.toBooleanValue(booleanResult),
                    operand.getContext());
            }
        }
        
        return result;
    }
    
    /**
     * Negates a number ({@link IntegerType} or {@link RealType}).
     * @param operand The number which shall be negated.
     * @param arguments Must be <tt>null</tt> or empty.
     * @return The given operand * -1;
     */
    private static EvaluationAccessor inverse(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
        
        EvaluationAccessor result = null;      
        if (null == arguments || arguments.length == 0) {
            Value value = operand.getValue();
            Object oValue = value.getValue();
            Value newValue = null;
            
            try {
                if (oValue instanceof Integer) {
                    newValue = ValueFactory.createValue(value.getType(), (Integer) (oValue) * -1);
                } else if (oValue instanceof Double) {
                    newValue = ValueFactory.createValue(value.getType(), (Double) (oValue) * -1); 
                }
            } catch (ValueDoesNotMatchTypeException e) {
                EASyLoggerFactory.INSTANCE.getLogger(GenericNumberOperations.class, Bundle.ID).exception(e);
            }    
            
            if (null != newValue) {
                result = ConstantAccessor.POOL.getInstance().bind(newValue, operand.getContext());
            }
        }
        
        return result;
    }
    
    /**
     * Removes the sign of a number ({@link IntegerType} or {@link RealType}).
     * @param operand The number which shall be made absolute.
     * @param arguments Must be <tt>null</tt> or empty.
     * @return The given |operand|;
     */
    private static EvaluationAccessor absolute(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
        
        EvaluationAccessor result = null;      
        if (null == arguments || arguments.length == 0) {
            Value value = operand.getValue();
            Object oValue = value.getValue();
            Value newValue = null;
            
            try {
                if (oValue instanceof Integer) {
                    newValue = ValueFactory.createValue(value.getType(), Math.abs((Integer) (oValue)));
                } else if (oValue instanceof Double) {
                    newValue = ValueFactory.createValue(value.getType(), Math.abs((Double) (oValue) * -1)); 
                }
            } catch (ValueDoesNotMatchTypeException e) {
                EASyLoggerFactory.INSTANCE.getLogger(GenericNumberOperations.class, Bundle.ID).exception(e);
            }    
            
            if (null != newValue) {
                result = ConstantAccessor.POOL.getInstance().bind(newValue, operand.getContext());
            }
        }
        
        return result;
    }
}
