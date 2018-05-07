package net.ssehub.easy.varModel.cstEvaluation;

import static net.ssehub.easy.varModel.cstEvaluation.ContainerOperations.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.ssehub.easy.varModel.cstEvaluation.ContainerOperations.ContainerValueOperation;
import net.ssehub.easy.varModel.cstEvaluation.ContainerOperations.ContainerValueOperationEvaluator;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Implements sequence operations.
 * 
 * @author Holger Eichelberger
 */
public class SequenceOperations {

    /**
     * Implements the index access operation.
     */
    static final IOperationEvaluator INDEX_ACCESS = new IOperationEvaluator() {

        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                result = operand.getValue(arguments[0]);
            }
            return result;
        }

    };

    /**
     * Implements the "first" operation.
     */
    static final IOperationEvaluator FIRST = new IOperationEvaluator() {

        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value value = operand.getValue();
            if (value instanceof ContainerValue) {
                ContainerValue cont = (ContainerValue) value;
                if (cont.getElementSize() > 0) {
                    result = ConstantAccessor.POOL.getInstance().bind(cont.getElement(0), false, operand.getContext());
                }
            }
            return result;
        }

    };

    /**
     * Implements the "last" operation.
     */
    static final IOperationEvaluator LAST = new IOperationEvaluator() {

        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value value = operand.getValue();
            if (value instanceof ContainerValue) {
                ContainerValue cont = (ContainerValue) value;
                int size = cont.getElementSize();
                if (size > 0) {
                    result = ConstantAccessor.POOL.getInstance().bind(cont.getElement(size - 1), 
                        false, operand.getContext());
                }
            }
            return result;
        }

    };

    /**
     * Implements the "hasDuplicates" operation.
     */
    static final IOperationEvaluator HAS_DUPLICATES = new IOperationEvaluator() {

        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            // see VIL implementation            
            EvaluationAccessor result = null;
            Value value = operand.getValue();
            if (value instanceof ContainerValue) {
                ContainerValue cont = (ContainerValue) value;
                boolean hasDuplicates = false;
                int size = cont.getElementSize();
                if (size > 0) {
                    Set<Value> known = new HashSet<Value>(size);
                    for (int i = 0; !hasDuplicates && i < size; i++) {
                        hasDuplicates = !known.add(cont.getElement(i));
                    }
                }
                result = ConstantAccessor.POOL.getInstance().bind(
                        BooleanValue.toBooleanValue(hasDuplicates), true, operand.getContext());
            }
            return result;
        }

    };
    
    /**
     * Implements the "hasDuplicates" operation.
     */
    static final IOperationEvaluator INSERT_AT = new IOperationEvaluator() {

        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            ConstantAccessor result = null;
            if (2 == arguments.length) {
                Value oValue = operand.getValue();
                Value aValue = arguments[0].getValue();
                Value insValue = arguments[1].getValue();
                if (oValue instanceof ContainerValue && aValue instanceof IntValue && null != insValue) {
                    ContainerValue cont = (ContainerValue) oValue;
                    int index = OclKeyWords.toJavaIndex(((IntValue) aValue).getValue());
                    if (0 <= index && index <= cont.getElementSize()) { // this is an insert!
                        ContainerArgument cnt = ContainerOperations.CA_POOL.getInstance().setValues(cont, operand);
                        ArrayList<Value> tmp = new ArrayList<Value>();
                        result = ConstantAccessor.POOL.getInstance();
                        ContainerOperations.addAll(cnt, tmp, result);
                        tmp.add(index, insValue);
                        try {
                            Value rValue = ValueFactory.createValue(cont.getType(), tmp.toArray());
                            result.bind(rValue, false, operand.getContext());
                        } catch (ValueDoesNotMatchTypeException e) {
                            result = EvaluationAccessor.release(result); // result -> null
                        }
                        ContainerOperations.CA_POOL.releaseInstance(cnt);
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

        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value oValue = operand.getValue();
                Value aValue = arguments[0].getValue();
                if (oValue instanceof ContainerValue && null != aValue) {
                    ContainerValue cont = (ContainerValue) oValue;
                    try {
                        Value resVal = ValueFactory.createValue(IntegerType.TYPE, 
                            OclKeyWords.toIvmlIndex(cont.indexOf(aValue)));
                        result = ConstantAccessor.POOL.getInstance().bind(resVal, true, operand.getContext());
                    } catch (ValueDoesNotMatchTypeException e) {
                        // result -> null
                    }
                }
            }
            return result;
        }

    };

    /**
     * Implements the "isSubsequenceOf" operation.
     */
    static final IOperationEvaluator ISSUBSEQUENCE = new IOperationEvaluator() {

        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            // see VIL implementation
            if (1 == arguments.length) {
                Value oValue = operand.getValue();
                Value aValue = arguments[0].getValue();
                if (oValue instanceof ContainerValue && aValue instanceof ContainerValue) {
                    ContainerValue cont1 = (ContainerValue) oValue;
                    ContainerValue cont2 = (ContainerValue) aValue;
                    int i1 = 0;
                    int i2 = 0;
                    int size1 = cont1.getElementSize();
                    int size2 = cont2.getElementSize();
                    while (i1 < size1 && i2 < size2) {
                        Value val1 = cont1.getElement(i1);
                        Value val2 = cont2.getElement(i2);
                        if (val1.equals(val2)) {
                            i1++;
                            i2++;
                        } else {
                            i2++; // operand: {1, 2, 5}, argument {1, 2, 3, 5}
                        }
                    }
                    Value resVal = BooleanValue.toBooleanValue(size1 > 0 && i1 == size1);
                    result = ConstantAccessor.POOL.getInstance().bind(resVal, true, operand.getContext());
                }
            }
            return result;
        }

    };

    /**
     * Implements the "overlaps" operation.
     */
    static final IOperationEvaluator OVERLAPS = new IOperationEvaluator() {

        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            // see VIL implementation
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value oValue = operand.getValue();
                Value aValue = arguments[0].getValue();
                if (oValue instanceof ContainerValue && aValue instanceof ContainerValue) {
                    ContainerValue cont1 = (ContainerValue) oValue;
                    ContainerValue cont2 = (ContainerValue) aValue;
                    Set<Object> tmp = new HashSet<Object>();
                    boolean found = false;
                    int size1 = cont1.getElementSize();
                    int size2 = cont2.getElementSize();
                    if (size1 > 0 && size2 > 0) {
                        for (int i1 = 0; i1 < size1; i1++) {
                            tmp.add(cont1.getElement(i1));
                        }
                        for (int i2 = 0; !found && i2 < size2; i2++) {
                            found = tmp.contains(cont2.getElement(i2));
                        }
                    }
                    Value resVal = BooleanValue.toBooleanValue(found);
                    result = ConstantAccessor.POOL.getInstance().bind(resVal, true, operand.getContext());
                }
            }
            return result;
        }

    };

    /**
     * Implements the union operation.
     */
    static final IOperationEvaluator UNION = new Container2OperationEvaluator(new Container2Operation() {
        
        public void evaluate(ContainerArgument c1, ContainerArgument c2, List<Value> result, 
            EvaluationAccessor resAcc) {
            ContainerOperations.addAll(c1, result, resAcc);
            ContainerOperations.addAll(c2, result, resAcc);
        }
    });

    /**
     * Implements the prepend operation.
     */
    static final IOperationEvaluator PREPEND = new ContainerValueOperationEvaluator(new ContainerValueOperation() {
        
        public void evaluate(ContainerArgument cont, Value value, List<Value> result, EvaluationAccessor resAcc) {
            result.add(value);
            resAcc.addBoundContainerElement(null);
            ContainerOperations.addAll(cont, result, resAcc);
        }
    });
    
    /**
     * Implements the append operation.
     */
    static final IOperationEvaluator APPEND = new ContainerValueOperationEvaluator(new ContainerValueOperation() {
        
        public void evaluate(ContainerArgument cont, Value value, List<Value> result, EvaluationAccessor resAcc) {
            ContainerOperations.addAll(cont, result, resAcc);
            result.add(value);
            resAcc.addBoundContainerElement(null);
        }
    });
    
    /**
     * Implements the "excluding" operation.
     */
    static final IOperationEvaluator EXCLUDING = new ContainerValueOperationEvaluator(new ContainerValueOperation() {
        
        public void evaluate(ContainerArgument cnt, Value value, List<Value> result, EvaluationAccessor resAcc) {
            ContainerValue cont = cnt.getValue();
            EvaluationAccessor contAcc = cnt.getAccessor();
            for (int i = 0; i < cont.getElementSize(); i++) {
                Value elt = cont.getElement(i);
                if (!elt.equals(value)) {
                    result.add(elt);
                    resAcc.addBoundContainerElement(contAcc, i);
                }
            }
        }
    });

    /**
     * Implements the "including" operation.
     */
    static final IOperationEvaluator INCLUDING = new ContainerValueOperationEvaluator(new ContainerValueOperation() {
        
        public void evaluate(ContainerArgument cnt, Value value, List<Value> result, EvaluationAccessor resAcc) {
            boolean found = false;
            ContainerValue cont = cnt.getValue();
            EvaluationAccessor contAcc = cnt.getAccessor();
            for (int i = 0; i < cont.getElementSize(); i++) {
                Value elt = cont.getElement(i);
                result.add(elt);
                resAcc.addBoundContainerElement(contAcc, i);
                found = elt.equals(value);
            }
            if (!found) {
                result.add(value);
                resAcc.addBoundContainerElement(null);
            }
        }
    });

    /**
     * Implements the "reverse" operation.
     */
    static final IOperationEvaluator REVERSE = new IOperationEvaluator() {
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value oValue = operand.getValue();
            if (oValue instanceof ContainerValue) {
                ContainerValue cont = (ContainerValue) oValue;
                List<Value> res = new ArrayList<Value>();
                for (int i = cont.getElementSize() - 1; i >= 0; i--) {
                    res.add(cont.getElement(i));
                }
                try {
                    Value rValue = ValueFactory.createValue(oValue.getType(), res.toArray());
                    result = ConstantAccessor.POOL.getInstance().bind(rValue, false, operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    operand.getContext().addErrorMessage(e);
                }
            }
            return result;
        }
    };

    /**
     * Implements the "subSequence" operation.
     */
    static final IOperationEvaluator SUBSEQUENCE = new IOperationEvaluator() {
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (2 == arguments.length) {
                Value oValue = operand.getValue();
                Value aValue1 = arguments[0].getValue();
                Value aValue2 = arguments[1].getValue();
                if (oValue instanceof ContainerValue && aValue1 instanceof IntValue && aValue2 instanceof IntValue) {
                    ContainerValue cont = (ContainerValue) oValue;
                    int lower = OclKeyWords.toJavaIndex(Math.max(0, ((IntValue) aValue1).getValue())); 
                    int upper = OclKeyWords.toJavaIndex(Math.min(((IntValue) aValue2).getValue(), 
                        cont.getElementSize() - 1)); 
                    List<Value> res = new ArrayList<Value>();
                    for (int i = lower; i <= upper; i++) {
                        res.add(cont.getElement(i));
                    }
                    try {
                        Value rValue = ValueFactory.createValue(oValue.getType(), res.toArray());
                        result = ConstantAccessor.POOL.getInstance().bind(rValue, false, operand.getContext());
                    } catch (ValueDoesNotMatchTypeException e) {
                        operand.getContext().addErrorMessage(e);
                    }
                }
            }
            return result;
        }
    };

    /**
     * Prevent instance creation.
     */
    private SequenceOperations() {
    }
    
    /**
     * Registers the defined operations.
     */
    public static void register() {
        EvaluatorRegistry.registerEvaluator(INDEX_ACCESS, Sequence.INDEX_ACCESS, Sequence.AT);
        EvaluatorRegistry.registerEvaluator(FIRST, Sequence.FIRST);
        EvaluatorRegistry.registerEvaluator(LAST, Sequence.LAST);
        EvaluatorRegistry.registerEvaluator(ContainerOperations.AS_SET, Sequence.AS_SET, Sequence.TO_SET);
        EvaluatorRegistry.registerEvaluator(ContainerOperations.AS_SEQUENCE, 
            Sequence.AS_SEQUENCE, Sequence.TO_SEQUENCE);
        EvaluatorRegistry.registerEvaluator(UNION, Sequence.UNION);
        EvaluatorRegistry.registerEvaluator(APPEND, Sequence.APPEND);
        EvaluatorRegistry.registerEvaluator(PREPEND, Sequence.PREPEND);
        EvaluatorRegistry.registerEvaluator(INSERT_AT, Sequence.INSERT_AT);
        EvaluatorRegistry.registerEvaluator(HAS_DUPLICATES, Sequence.HAS_DUPLICATES);
        EvaluatorRegistry.registerEvaluator(INDEX_OF, Sequence.INDEX_OF);
        EvaluatorRegistry.registerEvaluator(INCLUDING, Sequence.INCLUDING);
        EvaluatorRegistry.registerEvaluator(EXCLUDING, Sequence.EXCLUDING);
        EvaluatorRegistry.registerEvaluator(REVERSE, Sequence.REVERSE);
        EvaluatorRegistry.registerEvaluator(SUBSEQUENCE, Sequence.SUBSEQUENCE);
        EvaluatorRegistry.registerEvaluator(GenericOperations.EQUALS, Sequence.EQUALS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.ASSIGNMENT, Sequence.ASSIGNMENT);
        EvaluatorRegistry.registerEvaluator(ContainerOperations.ADD, Sequence.ADD);
        EvaluatorRegistry.registerEvaluator(ISSUBSEQUENCE, Sequence.ISSUBSEQUENCE);
        EvaluatorRegistry.registerEvaluator(OVERLAPS, Sequence.OVERLAPS);
        EvaluatorRegistry.registerEvaluator(new ContainerOperations.FlattenOperationEvaluator(true), Sequence.FLATTEN);
    }

}
