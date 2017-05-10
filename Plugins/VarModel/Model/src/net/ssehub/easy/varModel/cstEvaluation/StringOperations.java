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

import java.util.regex.PatternSyntaxException;

import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.StringValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Implements string operations.
 * 
 * @author Holger Eichelberger
 */
public class StringOperations {

    /**
     * Implements the "size" operation.
     */
    static final IOperationEvaluator SIZE = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value value = operand.getValue();
            if (value instanceof StringValue) {
                try {
                    int size = ((StringValue) value).getValue().length();
                    result = ConstantAccessor.POOL.getInstance().bind(
                        ValueFactory.createValue(IntegerType.TYPE, size), operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    // result -> null
                }
            }
            return result;
        }
    };

    /**
     * Implements the "toInt" operation.
     */
    static final IOperationEvaluator TO_INT = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value value = operand.getValue();
            if (value instanceof StringValue) {
                String str = ((StringValue) value).getValue();
                try {
                    int res = Integer.parseInt(str);
                    result = ConstantAccessor.POOL.getInstance().bind(
                        ValueFactory.createValue(IntegerType.TYPE, res), operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    // result -> null
                } catch (NumberFormatException e) {
                    operand.getContext().addErrorMessage("'" + str + "' does not denote an Integer");
                }
            }
            return result;
        }
    };

    /**
     * Implements the "toReal" operation.
     */
    static final IOperationEvaluator TO_REAL = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value value = operand.getValue();
            if (value instanceof StringValue) {
                String str = ((StringValue) value).getValue();
                try {
                    double dbl = Double.parseDouble(str);
                    result = ConstantAccessor.POOL.getInstance().bind(
                        ValueFactory.createValue(RealType.TYPE, dbl), operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    // result -> null
                } catch (NumberFormatException e) {
                    operand.getContext().addErrorMessage("'" + str + "' does not denote a Real");
                }
            }
            return result;
        }
    };

    /**
     * Implements the "concat" operation.
     */
    static final IOperationEvaluator CONCAT = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value opValue = operand.getValue();
                Value argValue = arguments[0].getValue();
                if (opValue instanceof StringValue && argValue instanceof StringValue) {
                    try {
                        String opS = ((StringValue) opValue).getValue();
                        String argS = ((StringValue) argValue).getValue();
                        result = ConstantAccessor.POOL.getInstance().bind(
                            ValueFactory.createValue(StringType.TYPE, opS + argS), operand.getContext());
                    } catch (ValueDoesNotMatchTypeException e) {
                        // result -> null
                    } 
                }
            }
            return result;
        }
    };
    
    /**
     * Implements the "substring" operation.
     */
    static final IOperationEvaluator SUBSTRING = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (2 == arguments.length) {
                Value opValue = operand.getValue();
                Value lowerValue = arguments[0].getValue();
                Value upperValue = arguments[1].getValue();
                if (opValue instanceof StringValue && lowerValue instanceof IntValue 
                    && upperValue instanceof IntValue) {
                    try {
                        String opS = ((StringValue) opValue).getValue();
                        int lower = ((IntValue) lowerValue).getValue();
                        int upper = ((IntValue) upperValue).getValue();
                        Value rValue = ValueFactory.createValue(StringType.TYPE, opS.substring(lower, upper));
                        result = ConstantAccessor.POOL.getInstance().bind(rValue, operand.getContext());
                    } catch (ValueDoesNotMatchTypeException e) {
                        // result -> null
                    } catch (IndexOutOfBoundsException e) {
                        operand.getContext().addErrorMessage(e);
                    }
                }
            }
            return result;
        }
    };

    /**
     * Implements the "substring" operation.
     */
    static final IOperationEvaluator MATCHES = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value opValue = operand.getValue();
                Value argValue = arguments[0].getValue();
                if (opValue instanceof StringValue && argValue instanceof StringValue) {
                    try {
                        String opS = ((StringValue) opValue).getValue();
                        String argS = ((StringValue) argValue).getValue();
                        Value rValue = BooleanValue.toBooleanValue(opS.matches(argS));
                        result = ConstantAccessor.POOL.getInstance().bind(rValue, operand.getContext());
                    } catch (PatternSyntaxException e) {
                        operand.getContext().addErrorMessage(e);
                    }
                }
            }
            return result;
        }
    };

    /**
     * Implements the "substring" operation.
     */
    static final IOperationEvaluator SUBSTITUTES = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (2 == arguments.length) {
                Value opValue = operand.getValue();
                Value argRValue = arguments[0].getValue();
                Value argSValue = arguments[1].getValue();
                if (opValue instanceof StringValue && argRValue instanceof StringValue 
                    && argSValue instanceof StringValue) {
                    try {
                        String opS = ((StringValue) opValue).getValue();
                        String argR = ((StringValue) argRValue).getValue();
                        String argS = ((StringValue) argSValue).getValue();
                        String sResult = opS.replaceAll(argR, argS);
                        Value rValue = ValueFactory.createValue(StringType.TYPE, sResult);
                        result = ConstantAccessor.POOL.getInstance().bind(rValue, operand.getContext());
                    } catch (ValueDoesNotMatchTypeException e) {
                        // -> result = null
                    } catch (PatternSyntaxException e) {
                        operand.getContext().addErrorMessage(e);
                    }
                }
            }
            return result;
        }
    };
    
    /**
     * Prevents external creation.
     */
    private StringOperations() {
    }
    
    /**
     * Registers the defined operations.
     */
    public static final void register() {
        EvaluatorRegistry.registerEvaluator(GenericOperations.TYPE_OF, StringType.TYPE_OF);
        EvaluatorRegistry.registerEvaluator(GenericOperations.EQUALS, StringType.EQUALS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.UNEQUALS, StringType.UNEQUALS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.ASSIGNMENT, StringType.ASSIGNMENT);
        EvaluatorRegistry.registerEvaluator(GenericOperations.IS_DEFINED, StringType.IS_DEFINED);
        EvaluatorRegistry.registerEvaluator(SIZE, StringType.SIZE);
        EvaluatorRegistry.registerEvaluator(TO_INT, StringType.TO_INTEGER);
        EvaluatorRegistry.registerEvaluator(TO_REAL, StringType.TO_REAL);
        EvaluatorRegistry.registerEvaluator(CONCAT, StringType.CONCAT);
        EvaluatorRegistry.registerEvaluator(CONCAT, StringType.PLUS);
        EvaluatorRegistry.registerEvaluator(SUBSTRING, StringType.SUBSTRING);
        EvaluatorRegistry.registerEvaluator(MATCHES, StringType.MATCHES);
        EvaluatorRegistry.registerEvaluator(SUBSTITUTES, StringType.SUBSTITUTES);
    }
    
}
