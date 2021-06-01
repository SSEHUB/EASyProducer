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

import net.ssehub.easy.basics.DefaultLocale;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.MetaTypeValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.StringValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Generic operation implementation for the individual types. Testing shall happen
 * along the operation defining types.
 * 
 * @author Holger Eichelberger
 */
public class GenericOperations {
    
    /**
     * The generic assignment operation.
     */
    static final IOperationEvaluator ASSIGNMENT = new IOperationEvaluator() {

        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return assign(operand, arguments, true);
        }

    };
    
    /**
     * Implements the generic equals operation.
     */
    static final IOperationEvaluator EQUALS = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return GenericOperations.equals(operand, arguments, false); 
        }
    };

    /**
     * Implements the generic not-equals operation.
     */
    static final IOperationEvaluator UNEQUALS = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return GenericOperations.equals(operand, arguments, true); 
        }
    };

    /**
     * Implements the generic toString operation.
     */
    static final IOperationEvaluator TO_STRING = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (null != operand) {
                try {
                    Value sv = operand.getValue();
                    String sValue;
                    if (sv instanceof StringValue) {
                        // direct access, avoid IVML quoting
                        sValue = ((StringValue) sv).getValue();
                    } else {
                        sValue = StringProvider.toIvmlString(operand.getValue());
                    }
                    result = ConstantAccessor.POOL.getInstance().bind(
                        ValueFactory.createValue(StringType.TYPE, sValue), true, 
                        operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    // result -> null
                } 
            }
            return result; 
        }
    };
    
    /**
     * Implements the "is defined" operation.
     */
    static final IOperationEvaluator IS_DEFINED = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            // get state does not work as there may not be a directly underlying variable
            boolean eval;
            EvaluationContext context;
            if (null == operand) {
                eval = false;
                context = null; // replaced by caller
            } else {
                IDecisionVariable var = operand.getVariable();                
                if (var != null && var.enableWasAssignedForIsDefined()) { // the isDefined workaround/hack for compounds
                    eval = operand.getVariable().wasAssigned();
                    context = operand.getContext();
                } else {
                    Value val = operand.getValue();
                    eval = !(null == val || NullValue.INSTANCE == val);
                    context = operand.getContext();
                }
            }
            BooleanValue result = BooleanValue.toBooleanValue(eval);
            return ConstantAccessor.POOL.getInstance().bind(result, true, context);
        }
    };
    
    /**
     * Implements the "copy" operation.
     */
    static final IOperationEvaluator COPY = new IOperationEvaluator() {

        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (null != operand && 1 == arguments.length) {
                Value namePrefixValue = arguments[0].getValue();
                String namePrefix;
                if (namePrefixValue instanceof StringValue) {
                    namePrefix = ((StringValue) namePrefixValue).getValue();
                } else { // namePrefixValue == NullValue.INSTANCE
                    namePrefix = null;
                }
                try {
                    IDecisionVariable local = VariableValueCopier.copy(operand.getVariable(), namePrefix);
                    result = VariableAccessor.POOL.getInstance().bind(local, operand.getContext(), true);
                } catch (ConfigurationException e) {
                    // result -> null
                } catch (ValueDoesNotMatchTypeException e) {
                    // result -> null
                } catch (CSTSemanticException e) {
                    // result -> null
                }
            }
            return result;
        }
        
    };

    /**
     * Implements the "typeOf" operation.
     */
    static final IOperationEvaluator TYPE_OF = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value oVal = operand.getValue();
            if (null != oVal) {
                try {
                    Value resVal = ValueFactory.createValue(MetaType.TYPE, oVal.getType());
                    result = ConstantAccessor.POOL.getInstance().bind(resVal, true, operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    // result -> null
                }
            }
            return result;
        }
    };
    
    /**
     * Implements the "isTypeOf" operation.
     */
    static final IOperationEvaluator IS_TYPE_OF = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                IDatatype oType = toType(operand.getValue());
                IDatatype aType = toType(arguments[0].getValue());
                if (null != oType && null != aType) {
                    BooleanValue res = BooleanValue.toBooleanValue(TypeQueries.sameTypes(oType, aType));
                    result = ConstantAccessor.POOL.getInstance().bind(res, true, operand.getContext());
                }
            }
            return result;
        }
    };
    
    /**
     * Implements the "isKindOf" operation.
     */
    static final IOperationEvaluator IS_KIND_OF = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                IDatatype oType = toType(operand.getValue());
                IDatatype aType = toType(arguments[0].getValue());
                if (null != oType && null != aType) {
                    BooleanValue res = BooleanValue.toBooleanValue(oType.isAssignableFrom(aType));
                    result = ConstantAccessor.POOL.getInstance().bind(res, true, operand.getContext());
                }
            }
            return result;
        }
    };

    /**
     * Implements the "asType" operation.
     */
    static final IOperationEvaluator AS_TYPE = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value oValue = operand.getValue();
                IDatatype oType = toType(oValue);
                IDatatype aType = toType(arguments[0].getValue());
                if (aType.isAssignableFrom(oType)) {
                    if (null != operand.getVariable()) {
                        result = VariableAccessor.POOL.getInstance().bind(operand.getVariable(), operand.getContext());
                    } else {
                        result = ConstantAccessor.POOL.getInstance().bind(oValue, false, operand.getContext());
                    }
                }
            }
            return result;
        }
    };

    static final IOperationEvaluator GET_LOCALE = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            try {
                result = ConstantAccessor.POOL.getInstance().bind(ValueFactory.createValue(StringType.TYPE, 
                    localeToString(operand)), true, operand.getContext());
            } catch (ValueDoesNotMatchTypeException e) {
                // -> null
            }
            return result;
        }
    };

    static final IOperationEvaluator SET_LOCALE = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value arg = arguments[0].getValue();
                if (arg instanceof StringValue) {
                    String loc = ((StringValue) arg).getValue();
                    operand.getContext().setLocale(DefaultLocale.toLocale(loc));
                    try {
                        result = ConstantAccessor.POOL.getInstance().bind(ValueFactory.createValue(StringType.TYPE, 
                            localeToString(operand)), true, operand.getContext());
                    } catch (ValueDoesNotMatchTypeException e) {
                        // -> null
                    }
                }
            }
            return result;
        }
    };

    /**
     * Prevents external instantiation.
     */
    private GenericOperations() {
    }

    /**
     * Turns the locale of the accessor/context into a string.
     * 
     * @param accessor the accessor
     * @return the locale as string
     */
    public static String localeToString(EvaluationAccessor accessor) {
        return DefaultLocale.toString(accessor.getContext().getLocale());
    }

    /**
     * Registers the defined operations.
     */
    public static void register() {
        EvaluatorRegistry.registerEvaluator(IS_TYPE_OF, AnyType.IS_TYPE_OF);
        EvaluatorRegistry.registerEvaluator(IS_KIND_OF, AnyType.IS_KIND_OF);
        EvaluatorRegistry.registerEvaluator(GET_LOCALE, AnyType.GET_LOCALE);
        EvaluatorRegistry.registerEvaluator(SET_LOCALE, AnyType.SET_LOCALE);
        EvaluatorRegistry.registerEvaluator(AS_TYPE, AnyType.AS_TYPE);
        EvaluatorRegistry.registerEvaluator(ASSIGNMENT, AnyType.ASSIGNMENT);
        EvaluatorRegistry.registerEvaluator(EQUALS, AnyType.EQUALS);
        EvaluatorRegistry.registerEvaluator(UNEQUALS, AnyType.NOTEQUALS);
        EvaluatorRegistry.registerEvaluator(UNEQUALS, AnyType.NOTEQUALS_ALIAS);
    }

    /**
     * Implements a generic equality operation for basic values (excluding compounds and containers).
     * 
     * @param operand the operand value
     * @param arguments the argument values
     * @param negate whether the (boolean) result shall be negated
     * @return a boolean value if equality can be evaluated, <b>null</b> else
     */
    static EvaluationAccessor equals(EvaluationAccessor operand, EvaluationAccessor[] arguments, boolean negate) {
        EvaluationAccessor result;
        
        if (null != operand && null != arguments && arguments.length == 1) {
            Value oValue = operand.getValue();
            Value aValue = arguments[0].getValue();
            // Support equals on unequal datatypes (mixed Int/Real).
            if (null != oValue && oValue.getType() == RealType.TYPE && null != aValue
                && aValue.getType() == IntegerType.TYPE) {
                
                result = RealOperations.equalsRealInt(operand, arguments, negate);
            } else if (null != oValue && oValue.getType() == IntegerType.TYPE
                && null != aValue && aValue.getType() == RealType.TYPE) {
                
                result = IntegerOperations.equalsIntReal(operand, arguments, negate);
            } else {
                
                // Equals on same datatypes
                boolean equals; 
                if (!negate && operand.getContext().allowPropagation()) {
                    // special if not assigned, but assignable (not constant), we can do this now
                    if (((null == oValue || !operand.isAssigned()) && operand.isAssignable()) 
                            || isAssignableCompound(operand)) {
                        assign(operand, arguments, false);
                        oValue = operand.getValue();
                    } else if ((null == aValue) && arguments[0].isAssignable()) {
                        // considers the reverse case 1 == x, x undefined
                        EvaluationAccessor[] temp = new EvaluationAccessor[1];
                        temp[0] = operand;
                        assign(arguments[0], temp, false);
                        aValue = operand.getValue();
                    }
                }
                if (null == oValue || null == aValue) {
                    result = null;
                } else {
                    boolean operandIsRef = oValue instanceof ReferenceValue;
                    boolean parameterIsRef = aValue instanceof ReferenceValue;
                    if (null == oValue || null == aValue) {
                        // one part is undefined
                        equals = false;
                    } else if (operandIsRef != parameterIsRef) {
                        // One is a reference, the other not -> unpack both and compare values
                        oValue = operand.getDereferencedValue();
                        aValue = arguments[0].getDereferencedValue();
                        equals = oValue.equals(aValue);
                    } else {
                        // No dereferencing is needed (two references a compared based on the containing value)
                        equals = oValue.equals(aValue);
                    }
                    if (negate) {
                        equals = !equals;
                    }
                    BooleanValue resValue = BooleanValue.toBooleanValue(equals);
                    result = ConstantAccessor.POOL.getInstance().bind(resValue, true, 
                        operand.getContext());                
                }
            }
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Implements a generic equality operation for null values.
     * 
     * @param operand the operand value
     * @param argument the argument value 
     * @param context the evaluation context
     * @param negate whether the (boolean) result shall be negated
     * @return a boolean value if equality can be evaluated, <b>null</b> else
     */
    static final EvaluationAccessor equalsNull(Value operand, Value argument, EvaluationContext context, 
        boolean negate) {
        EvaluationAccessor result;
        Boolean equals;
        if (operand instanceof NullValue) {
            if (argument instanceof NullValue) {
                equals = true;
            } else {
                equals = false;
            }
        } else if (operand != null && argument instanceof NullValue) {
            equals = false;
        } else {
            equals = null;
        }
        if (null != equals) {
            if (negate) {
                equals = !equals;
            }
            result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.toBooleanValue(equals), true, context);
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Returns the type of <code>value</code>.
     * 
     * @param value the value to be turned into its type
     * @return the type (may be <b>null</b>)
     */
    private static IDatatype toType(Value value) {
        IDatatype result;
        if (value instanceof MetaTypeValue) {
            result = ((MetaTypeValue) value).getValue();
        } else if (value != null) {
            result = value.getType();
        } else {
            result = null;
        }
        return result;
    }    
    
    /**
     * Returns true if {@link EvaluationAccessor} is a compound and 
     *  all compounds nested elements are undefined.
     * @param operand {@link EvaluationAccessor} to be checked.
     * @return true if all nested elements are undefined.
     */
    private static boolean isAssignableCompound(EvaluationAccessor operand) {       
        boolean result = false;
        if (operand.getValue() instanceof CompoundValue) {  
            result = true;
            IDecisionVariable oCmp = operand.getVariable();
            if (oCmp != null) {
                for (int i = 0; i < oCmp.getNestedElementsCount(); i++) {
                    if (oCmp.getNestedElement(i).getState() != AssignmentState.UNDEFINED) {
                        result = false;
                    }
                }                
            } else {
                result = false;
            }
        } 
        return result;        
    }

    /**
     * Performs a value assignment.
     * 
     * @param operand the operand
     * @param arguments the arguments
     * @param asAssignment called as part of an assignment (hard constraint, <code>true</code>) or as part of a soft 
     *     constraint (<code>false</code>)
     * @return the result evaluation accessor
     */
    private static EvaluationAccessor assign(EvaluationAccessor operand, EvaluationAccessor[] arguments, 
        boolean asAssignment) {
        EvaluationAccessor result = null;
        if (arguments.length == 1 && null != operand) {
            if (operand.setValue(arguments[0].getValue(), asAssignment)) {
                result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.TRUE, true, operand.getContext());
            }
        }
        return result;        
    }

}
