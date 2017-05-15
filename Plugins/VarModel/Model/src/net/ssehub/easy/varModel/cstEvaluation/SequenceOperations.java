package net.ssehub.easy.varModel.cstEvaluation;

import static net.ssehub.easy.varModel.cstEvaluation.ContainerOperations.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.ssehub.easy.varModel.cstEvaluation.ContainerOperations.ContainerValueOperation;
import net.ssehub.easy.varModel.cstEvaluation.ContainerOperations.ContainerValueOperationEvaluator;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
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
                    result = ConstantAccessor.POOL.getInstance().bind(cont.getElement(0), operand.getContext());
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
                    result = ConstantAccessor.POOL.getInstance().bind(cont.getElement(size - 1), operand.getContext());
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
                        BooleanValue.toBooleanValue(hasDuplicates), operand.getContext());
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
            EvaluationAccessor result = null;
            if (2 == arguments.length) {
                Value oValue = operand.getValue();
                Value aValue = arguments[0].getValue();
                Value insValue = arguments[1].getValue();
                if (oValue instanceof ContainerValue && aValue instanceof IntValue && null != insValue) {
                    ContainerValue cont = (ContainerValue) oValue;
                    int index = ((IntValue) aValue).getValue();
                    if (0 <= index && index <= cont.getElementSize()) { // this is an insert!
                        ArrayList<Value> tmp = new ArrayList<Value>();
                        ContainerOperations.addAll(cont, tmp);
                        tmp.add(index, insValue);
                        try {
                            Value rValue = ValueFactory.createValue(cont.getType(), tmp.toArray());
                            result = ConstantAccessor.POOL.getInstance().bind(rValue, operand.getContext());
                        } catch (ValueDoesNotMatchTypeException e) {
                            // result -> null
                        }
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
                        Value resVal = ValueFactory.createValue(IntegerType.TYPE, cont.indexOf(aValue));
                        result = ConstantAccessor.POOL.getInstance().bind(resVal, operand.getContext());
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
    static final IOperationEvaluator SUBSEQUENCE = new IOperationEvaluator() {

        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
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
                    result = ConstantAccessor.POOL.getInstance().bind(resVal, operand.getContext());
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
                    result = ConstantAccessor.POOL.getInstance().bind(resVal, operand.getContext());
                }
            }
            return result;
        }

    };

    /**
     * Implements the union operation.
     */
    static final IOperationEvaluator UNION = new Container2OperationEvaluator(new Container2Operation() {
        
        public void evaluate(ContainerValue c1, ContainerValue c2, List<Value> result) {
            ContainerOperations.addAll(c1, result);
            ContainerOperations.addAll(c2, result);
        }
    });

    /**
     * Implements the prepend operation.
     */
    static final IOperationEvaluator PREPEND = new ContainerValueOperationEvaluator(new ContainerValueOperation() {
        
        public void evaluate(ContainerValue cont, Value value, List<Value> result) {
            result.add(value);
            ContainerOperations.addAll(cont, result);
        }
    });
    
    /**
     * Implements the append operation.
     */
    static final IOperationEvaluator APPEND = new ContainerValueOperationEvaluator(new ContainerValueOperation() {
        
        public void evaluate(ContainerValue cont, Value value, List<Value> result) {
            ContainerOperations.addAll(cont, result);
            result.add(value);
        }
    });
    
    /**
     * Implements the "excluding" operation.
     */
    static final IOperationEvaluator EXCLUDING = new ContainerValueOperationEvaluator(new ContainerValueOperation() {
        
        public void evaluate(ContainerValue cont, Value value, List<Value> result) {
            for (int i = 0; i < cont.getElementSize(); i++) {
                Value elt = cont.getElement(i);
                if (!elt.equals(value)) {
                    result.add(elt);
                }
            }
        }
    });

    /**
     * Implements the "including" operation.
     */
    static final IOperationEvaluator INCLUDING = new ContainerValueOperationEvaluator(new ContainerValueOperation() {
        
        public void evaluate(ContainerValue cont, Value value, List<Value> result) {
            boolean found = false;
            for (int i = 0; i < cont.getElementSize(); i++) {
                Value elt = cont.getElement(i);
                result.add(elt);
                found = elt.equals(value);
            }
            if (!found) {
                result.add(value);
            }
        }
    });

    
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
        EvaluatorRegistry.registerEvaluator(ContainerOperations.AS_SET, Sequence.AS_SET);
        EvaluatorRegistry.registerEvaluator(ContainerOperations.AS_SEQUENCE, Sequence.AS_SEQUENCE);
        EvaluatorRegistry.registerEvaluator(UNION, Sequence.UNION);
        EvaluatorRegistry.registerEvaluator(APPEND, Sequence.APPEND);
        EvaluatorRegistry.registerEvaluator(PREPEND, Sequence.PREPEND);
        EvaluatorRegistry.registerEvaluator(INSERT_AT, Sequence.INSERT_AT);
        EvaluatorRegistry.registerEvaluator(HAS_DUPLICATES, Sequence.HAS_DUPLICATES);
        EvaluatorRegistry.registerEvaluator(INDEX_OF, Sequence.INDEX_OF);
        EvaluatorRegistry.registerEvaluator(INCLUDING, Sequence.INCLUDING);
        EvaluatorRegistry.registerEvaluator(EXCLUDING, Sequence.EXCLUDING);
        EvaluatorRegistry.registerEvaluator(GenericOperations.EQUALS, Sequence.EQUALS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.ASSIGNMENT, Sequence.ASSIGNMENT);
        EvaluatorRegistry.registerEvaluator(ContainerOperations.ADD, Sequence.ADD);
        EvaluatorRegistry.registerEvaluator(SUBSEQUENCE, Sequence.SUBSEQUENCE);
        EvaluatorRegistry.registerEvaluator(OVERLAPS, Sequence.OVERLAPS);
        EvaluatorRegistry.registerEvaluator(new ContainerOperations.FlattenOperationEvaluator(true), Sequence.FLATTEN);
    }

}
