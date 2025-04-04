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

import java.util.Locale;
import java.util.regex.PatternSyntaxException;

import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor.Message;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
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
                        ValueFactory.createValue(IntegerType.TYPE, size), true, operand.getContext());
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
                        ValueFactory.createValue(IntegerType.TYPE, res), true, operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    // result -> null
                } catch (NumberFormatException e) {
                    operand.getContext().addErrorMessage("'" + str + "' does not denote an Integer", 
                        Message.CODE_RESOLUTION);
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
                        ValueFactory.createValue(RealType.TYPE, dbl), true, operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    // result -> null
                } catch (NumberFormatException e) {
                    operand.getContext().addErrorMessage("'" + str + "' does not denote a Real", 
                        Message.CODE_RESOLUTION);
                }
            }
            return result;
        }
    };

    /**
     * Implements the "toBoolean" operation.
     */
    static final IOperationEvaluator TO_BOOLEAN = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value value = operand.getValue();
            if (value instanceof StringValue) {
                String str = ((StringValue) value).getValue();
                BooleanValue bValue; // close to OCL
                if (equalsIgnoreCase(str, "true", operand)) {
                    bValue = BooleanValue.TRUE;
                } else {
                    bValue = BooleanValue.FALSE;
                }
                result = ConstantAccessor.POOL.getInstance().bind(bValue, true, operand.getContext());
            }
            return result;
        }
    };

    /**
     * Implements the "equalsIgnoreCase" operation.
     */
    static final IOperationEvaluator EQUALS_IGNORE_CASE = new IOperationEvaluator() {

        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value opValue = operand.getValue();
                Value argValue = arguments[0].getValue();
                if (opValue instanceof StringValue && argValue instanceof StringValue) {
                    String opS = ((StringValue) opValue).getValue();
                    String argS = ((StringValue) argValue).getValue();
                    result = ConstantAccessor.POOL.getInstance().bind(
                        BooleanValue.toBooleanValue(equalsIgnoreCase(opS, argS, operand)), true, operand.getContext());
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
                            ValueFactory.createValue(StringType.TYPE, opS + argS), true, operand.getContext());
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
                        int lower = OclKeyWords.toJavaIndex(((IntValue) lowerValue).getValue());
                        int upper = OclKeyWords.toJavaIndex(((IntValue) upperValue).getValue());
                        Value rValue = ValueFactory.createValue(StringType.TYPE, opS.substring(lower, upper));
                        result = ConstantAccessor.POOL.getInstance().bind(rValue, true, operand.getContext());
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
     * Implements the "at" operation.
     */
    static final IOperationEvaluator AT = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value opValue = operand.getValue();
                Value indexValue = arguments[0].getValue();
                if (opValue instanceof StringValue && indexValue instanceof IntValue) {
                    try {
                        int index = ((IntValue) indexValue).getValue();
                        String opS = ((StringValue) opValue).getValue();
                        Value rValue = ValueFactory.createValue(StringType.TYPE, String.valueOf(
                            opS.charAt(OclKeyWords.toJavaIndex(index))));
                        result = ConstantAccessor.POOL.getInstance().bind(rValue, true, operand.getContext());
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
     * Implements the "indexOf" operation.
     */
    static final IOperationEvaluator INDEX_OF = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value opValue = operand.getValue();
                Value argValue = arguments[0].getValue();
                if (opValue instanceof StringValue && argValue instanceof StringValue) {
                    try {
                        String opS = ((StringValue) opValue).getValue();
                        String arS = ((StringValue) argValue).getValue();
                        Value rValue = ValueFactory.createValue(IntegerType.TYPE, 
                            OclKeyWords.toIvmlIndex(opS.indexOf(arS)));
                        result = ConstantAccessor.POOL.getInstance().bind(rValue, true, operand.getContext());
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
     * Implements the case change operations.
     */
    static class CaseChange implements IOperationEvaluator {
        
        private boolean toUpper;
        
        /**
         * Creates a case change evaluator.
         * 
         * @param toUpper apply to upper case change (<code>true</code>) or to lower case change (<code>false</code>)
         */
        private CaseChange(boolean toUpper) {
            this.toUpper = toUpper;
        }
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value opValue = operand.getValue();
            if (opValue instanceof StringValue) {
                try {
                    String opS = ((StringValue) opValue).getValue();
                    if (toUpper) {
                        opS = opS.toUpperCase(operand.getContext().getLocale());
                    } else {
                        opS = opS.toLowerCase(operand.getContext().getLocale());
                    }
                    Value rValue = ValueFactory.createValue(StringType.TYPE, opS);
                    result = ConstantAccessor.POOL.getInstance().bind(rValue, true, operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    // result -> null
                } catch (IndexOutOfBoundsException e) {
                    operand.getContext().addErrorMessage(e);
                }
            }
            return result;
        }

    };
    
    /**
     * Implements the string compare operations.
     * 
     * @author Holger Eichelberger
     */
    static class CompareOperation implements IOperationEvaluator {
        
        private boolean withEquals;
        private int compareResult;

        /**
         * Creates a compare operation.
         * 
         * @param compareResult the expected comparison result for returning <code>true</code>
         * @param withEquals whether equals leads to a <code>true</code> or <code>false</code>
         */
        private CompareOperation(int compareResult, boolean withEquals) {
            this.withEquals = withEquals;
            this.compareResult = compareResult;
        }
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value opValue = operand.getValue();
                Value argValue = arguments[0].getValue();
                if (opValue instanceof StringValue && argValue instanceof StringValue) {
                    String opS = ((StringValue) opValue).getValue();
                    String arS = ((StringValue) argValue).getValue();
                    int res = operand.getContext().getCollator().compare(opS, arS);
                    boolean bRes;
                    if (0 == res) {
                        bRes = withEquals;
                    } else {
                        bRes = (compareResult < 0 && res < 0) || (compareResult > 0 && res > 0);
                    }
                    result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.toBooleanValue(bRes), 
                        true, operand.getContext());
                }
            }
            return result;
        }
        
    }

    /**
     * Implements the "matches" operation.
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
                        result = ConstantAccessor.POOL.getInstance().bind(rValue, true, operand.getContext());
                    } catch (PatternSyntaxException e) {
                        operand.getContext().addErrorMessage(e);
                    }
                }
            }
            return result;
        }
    };
    
    static final IOperationEvaluator CHARACTERS = new IOperationEvaluator() {

        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value opVal = operand.getValue();
            if (opVal instanceof StringValue) {
                String op = ((StringValue) opVal).getValue();
                String[] chars = new String[op.length()];
                for (int c = 0; c < op.length(); c++) {
                    chars[c] = String.valueOf(op.charAt(c));
                }
                Sequence type = new Sequence("", StringType.TYPE, null);
                try {
                    result = ConstantAccessor.POOL.getInstance().bind(
                        ValueFactory.createValue(type, (Object[]) chars), true, operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    operand.getContext().addErrorMessage(e);
                }
            }
            return result;
        }
        
    };

    /**
     * Implements the "substitutes" operation.
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
                        result = ConstantAccessor.POOL.getInstance().bind(rValue, true, operand.getContext());
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
     * Compares two strings without considering cases using the locale given by the evaluation <code>accessor</code>.
     * 
     * @param s1 the first string
     * @param s2 the second string
     * @param accessor the evaluation accessor carrying the evaluation context / locale
     * @return <code>true</code> for equality, <code>false</code> else
     * 
     * @see #equalsIgnoreCase(String, String, EvaluationContext)
     */
    private static boolean equalsIgnoreCase(String s1, String s2, EvaluationAccessor accessor) {
        return equalsIgnoreCase(s1, s2, accessor.getContext());
    }
    
    /**
     * Compares two strings without considering cases using the locale given by the evaluation <code>context</code>.
     * 
     * @param s1 the first string
     * @param s2 the second string
     * @param context the evaluation context carrying the locale
     * @return <code>true</code> for equality, <code>false</code> else
     */
    private static boolean equalsIgnoreCase(String s1, String s2, EvaluationContext context) {
        Locale locale = context.getLocale();
        String t1 = s1.toLowerCase(locale);
        String t2 = s2.toLowerCase(locale);
        return t1.equals(t2);
    }
    
    /**
     * Registers the defined operations.
     */
    public static final void register() {
        EvaluatorRegistry.registerEvaluator(GenericOperations.TYPE_OF, StringType.TYPE_OF);
        EvaluatorRegistry.registerEvaluator(GenericOperations.EQUALS, StringType.EQUALS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.UNEQUALS, StringType.UNEQUALS, StringType.UNEQUALS_ALIAS);
        EvaluatorRegistry.registerEvaluator(EQUALS_IGNORE_CASE, StringType.EQUALS_IGNORE_CASE);
        EvaluatorRegistry.registerEvaluator(GenericOperations.ASSIGNMENT, StringType.ASSIGNMENT);
        EvaluatorRegistry.registerEvaluator(GenericOperations.IS_DEFINED, StringType.IS_DEFINED);
        EvaluatorRegistry.registerEvaluator(GenericOperations.IF_DEFINED, StringType.IF_DEFINED);
        EvaluatorRegistry.registerEvaluator(GenericOperations.COPY, StringType.COPY);
        EvaluatorRegistry.registerEvaluator(SIZE, StringType.SIZE);
        EvaluatorRegistry.registerEvaluator(TO_INT, StringType.TO_INTEGER);
        EvaluatorRegistry.registerEvaluator(TO_REAL, StringType.TO_REAL);
        EvaluatorRegistry.registerEvaluator(CONCAT, StringType.CONCAT);
        EvaluatorRegistry.registerEvaluator(CONCAT, StringType.PLUS);
        EvaluatorRegistry.registerEvaluator(SUBSTRING, StringType.SUBSTRING);
        EvaluatorRegistry.registerEvaluator(new CaseChange(false), StringType.TO_LOWER_CASE);
        EvaluatorRegistry.registerEvaluator(new CaseChange(true), StringType.TO_UPPER_CASE);
        EvaluatorRegistry.registerEvaluator(INDEX_OF, StringType.INDEX_OF);
        EvaluatorRegistry.registerEvaluator(AT, StringType.AT);
        EvaluatorRegistry.registerEvaluator(MATCHES, StringType.MATCHES);
        EvaluatorRegistry.registerEvaluator(SUBSTITUTES, StringType.SUBSTITUTES);
        EvaluatorRegistry.registerEvaluator(GenericOperations.TO_STRING, StringType.TO_STRING);
        EvaluatorRegistry.registerEvaluator(TO_BOOLEAN, StringType.TO_BOOLEAN);
        EvaluatorRegistry.registerEvaluator(CHARACTERS, StringType.CHARACTERS);
        EvaluatorRegistry.registerEvaluator(new CompareOperation(-1, false), StringType.LESS);
        EvaluatorRegistry.registerEvaluator(new CompareOperation(-1, true), StringType.LESS_EQUALS);
        EvaluatorRegistry.registerEvaluator(new CompareOperation(1, false), StringType.GREATER);
        EvaluatorRegistry.registerEvaluator(new CompareOperation(1, true), StringType.GREATER_EQUALS);
    }
    
}
