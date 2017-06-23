package net.ssehub.easy.varModel.cstEvaluation;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.RealValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Implements the container iterators.
 * 
 * @author Holger Eichelberger
 */
class ContainerIterators {

    /**
     * Implements {@link net.ssehub.easy.varModel.model.datatypes.Container#APPLY}.
     */
    static final IIteratorEvaluator APPLY = new IIteratorEvaluator() {

        @Override
        public BooleanValue aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            // actual aggregation is defined by the apply expression, do not do here anything :o
            return BooleanValue.FALSE;
        }

        @Override
        public Value getStartResult(IDatatype type, IDatatype iterType) throws ValueDoesNotMatchTypeException {
            return null; // explicit defined, shall never be called
        }

        @Override
        public void postProcessResult(EvaluationAccessor result, Map<Object, Object> data) 
            throws ValueDoesNotMatchTypeException {
            // no action
        }

    };

    /**
     * Implements {@link net.ssehub.easy.varModel.model.datatypes.Container#FORALL}.
     */
    static final IIteratorEvaluator FOR_ALL = new IIteratorEvaluator() {

        @Override
        public BooleanValue aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            if (!(BooleanValue.TRUE.equals(result.getValue()) 
                && BooleanValue.TRUE.equals(value.getValue()))) {
                // forAll is only true if all evaluations are true
                result.setValue(BooleanValue.FALSE);
            }
            return BooleanValue.FALSE;
        }

        public Value getStartResult(IDatatype type, IDatatype iterType) throws ValueDoesNotMatchTypeException {
            return BooleanValue.TRUE;
        }

        @Override
        public void postProcessResult(EvaluationAccessor result, Map<Object, Object> data) 
            throws ValueDoesNotMatchTypeException {
            // no action
        }

    };

    /**
     * Implements {@link net.ssehub.easy.varModel.model.datatypes.Container#EXISTS}.
     */
    static final IIteratorEvaluator EXISTS = new IIteratorEvaluator() {
        
        @Override
        public BooleanValue aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            BooleanValue stop;
            if (BooleanValue.TRUE.equals(value.getValue())) {
                // exists is fine with the first evaluation result that is true
                result.setValue(BooleanValue.TRUE);
                stop = BooleanValue.TRUE;
            } else {
                stop = BooleanValue.FALSE;
            }
            return stop;
        }

        @Override
        public Value getStartResult(IDatatype type, IDatatype iterType) throws ValueDoesNotMatchTypeException {
            return BooleanValue.FALSE;
        }

        @Override
        public void postProcessResult(EvaluationAccessor result, Map<Object, Object> data) 
            throws ValueDoesNotMatchTypeException {
            // no action
        }

    };

    /**
     * Implements {@link net.ssehub.easy.varModel.model.datatypes.Container#IS_UNIQUE}.
     */
    static final IIteratorEvaluator IS_UNIQUE = new IIteratorEvaluator() {
        
        @Override
        public BooleanValue aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            BooleanValue stop;
            Value val = value.getValue();
            if (data.containsKey(val)) {
                stop = BooleanValue.TRUE;
                result.setValue(BooleanValue.FALSE);
            } else {
                data.put(val, null);
                stop = BooleanValue.FALSE;
            }
            return stop;
        }

        @Override
        public Value getStartResult(IDatatype type, IDatatype iterType) throws ValueDoesNotMatchTypeException {
            return BooleanValue.TRUE;
        }

        @Override
        public void postProcessResult(EvaluationAccessor result, Map<Object, Object> data) 
            throws ValueDoesNotMatchTypeException {
            // no action
        }

    };

    /**
     * Implements {@link net.ssehub.easy.varModel.model.datatypes.Container#ANY}.
     */
    static final IIteratorEvaluator ANY = new IIteratorEvaluator() {
        
        @Override
        public BooleanValue aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) {
            BooleanValue stop;
            if (BooleanValue.TRUE.equals(value.getValue())) {
                stop = BooleanValue.TRUE;
                result.setValue(iter);
            } else {
                stop = BooleanValue.FALSE;
            }
            return stop;
        }

        @Override
        public Value getStartResult(IDatatype type, IDatatype iterType) throws ValueDoesNotMatchTypeException {
            return NullValue.INSTANCE;
        }

        @Override
        public void postProcessResult(EvaluationAccessor result, Map<Object, Object> data) 
            throws ValueDoesNotMatchTypeException {
            // no action
        }

    };

    /**
     * Implements {@link net.ssehub.easy.varModel.model.datatypes.Container#ONE}.
     */
    static final IIteratorEvaluator ONE = new IIteratorEvaluator() {
        
        @Override
        public BooleanValue aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            BooleanValue stop;
            if (BooleanValue.TRUE.equals(value.getValue())) {
                stop = BooleanValue.toBooleanValue(!NullValue.INSTANCE.equals(result.getValue()));
                result.setValue(iter);
            } else {
                stop = BooleanValue.FALSE;
            }
            return stop;
        }

        @Override
        public Value getStartResult(IDatatype type, IDatatype iterType) throws ValueDoesNotMatchTypeException {
            return NullValue.INSTANCE;
        }
        
        @Override
        public void postProcessResult(EvaluationAccessor result, Map<Object, Object> data) 
            throws ValueDoesNotMatchTypeException {
            // no action
        }

    };
    
    /**
     * A number aggregating iterator.
     * 
     * @author Holger Eichelberger
     */
    private abstract static class NumberIteratorEvaluator implements IIteratorEvaluator {
        
        /**
         * Performs the integer aggregation operation.
         * 
         * @param i1 the first integer
         * @param i2 the second integer
         * @return the aggregated value
         */
        protected abstract int intOp(int i1, int i2);

        /**
         * Performs the double aggregation operation.
         * 
         * @param d1 the first double
         * @param d2 the second double
         * @return the aggregated value
         */
        protected abstract double doubleOp(double d1, double d2);

        @Override
        public BooleanValue aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            Value val = value.getValue();
            Object newVal = null;
            if (val instanceof IntValue) {
                int v = ((IntValue) value.getValue()).getValue();
                if (data.containsKey(this)) {
                    int oldVal = (Integer) data.get(this);    
                    int res = intOp(oldVal, v);
                    if (res != oldVal) {
                        newVal = res;
                    }
                } else {
                    newVal = v;
                }
            } else if (val instanceof RealValue) {
                double v = ((RealValue) value.getValue()).getValue();
                if (data.containsKey(this)) {
                    double oldVal = (Double) data.get(this);    
                    double res = doubleOp(oldVal, v);
                    if (res != oldVal) {
                        newVal = res;
                    }
                } else {
                    newVal = v;
                }
            }
            if (newVal != null) {
                data.put(this, newVal);
                result.setValue(iter);    
            }
            return BooleanValue.FALSE;
        }

        @Override
        public Value getStartResult(IDatatype type, IDatatype iterType) throws ValueDoesNotMatchTypeException {
            return NullValue.INSTANCE;
        }
        
        @Override
        public void postProcessResult(EvaluationAccessor result, Map<Object, Object> data) 
            throws ValueDoesNotMatchTypeException {
            // no action
        }
        
    }
    
    /**
     * Implements {@link net.ssehub.easy.varModel.model.datatypes.Container#MIN2}.
     */
    static final IIteratorEvaluator MIN2 = new NumberIteratorEvaluator() {

        @Override
        protected int intOp(int i1, int i2) {
            return Math.min(i1, i2);
        }

        @Override
        protected double doubleOp(double d1, double d2) {
            return Math.min(d1, d2);
        }
        
    };
    
    /**
     * Implements {@link net.ssehub.easy.varModel.model.datatypes.Container#MIN2}.
     */
    static final IIteratorEvaluator MAX2 = new NumberIteratorEvaluator() {

        @Override
        protected int intOp(int i1, int i2) {
            return Math.max(i1, i2);
        }

        @Override
        protected double doubleOp(double d1, double d2) {
            return Math.max(d1, d2);
        }
        
    };

    /**
     * Implements an evaluator adaptor for collecting operations.
     * 
     * @author Holger Eichelberger
     */
    abstract static class CollectingIteratorEvaluator implements IIteratorEvaluator {

        @Override
        public Value getStartResult(IDatatype type, IDatatype iterType) throws ValueDoesNotMatchTypeException {
            return ValueFactory.createValue(type, (Object[]) null);
        }

        @Override
        public void postProcessResult(EvaluationAccessor result, Map<Object, Object> data) 
            throws ValueDoesNotMatchTypeException {
            // no action
        }

    }

    /**
     * Implements {@link net.ssehub.easy.varModel.model.datatypes.Container#COLLECT} and 
     * {@link net.ssehub.easy.varModel.model.datatypes.Container#COLLECT_NESTED}.
     */
    static final IIteratorEvaluator COLLECT = new CollectingIteratorEvaluator() {
        
        @Override
        public BooleanValue aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            Value cVal = result.getValue();
            if (cVal instanceof ContainerValue) {
                ((ContainerValue) cVal).addElement(value.getValue());
            }
            return BooleanValue.FALSE;
        }

    };

    /**
     * Implements a basic closure iterator which can stop on a cycle. Uses {@link #DATA_CLOSURE_MARKED} and 
     * {@link #DATA_CLOSURE_CYCLIC}.
     * 
     * @author Holger Eichelberger
     */
    private static class ClosureIteratorEvaluator extends CollectingIteratorEvaluator {

        private boolean stopOnCycle = false;

        /**
         * Creates the closure iterator.
         * 
         * @param stopOnCycle stop on a cycle or just ignore the already vited nodes and go on
         */
        private ClosureIteratorEvaluator(boolean stopOnCycle) {
            this.stopOnCycle = stopOnCycle;
        }
        
        @Override
        public Value aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            Value rValue = result.getValue();
            List<Value> nextValues = null;
            ContainerValue resultContainer;
            if (rValue instanceof ContainerValue) {
                resultContainer = (ContainerValue) rValue;
            } else {
                resultContainer = null;
            }
            nextValues = new ArrayList<Value>();
            handleNextValue(iter, resultContainer, data, nextValues);
            Value val = value.getValue();
            if (val instanceof ContainerValue) {
                ContainerValue valContainer = (ContainerValue) val;
                for (int e = 0; e < valContainer.getElementSize(); e++) {
                    handleNextValue(valContainer.getElement(e), 
                        resultContainer, data, nextValues);
                    if (stopOnCycle && hasCycle(data)) {
                        break;
                    }
                }
            } else if (val instanceof ReferenceValue) {
                handleNextValue(val, resultContainer, data, nextValues);
            }
            
            Value res = BooleanValue.FALSE; // just go on
            if (stopOnCycle && hasCycle(data)) {
                res = BooleanValue.TRUE; // stop immediately
            } else {
                if (null != nextValues) {
                    res = new ListWrapperValue(nextValues);
                }
            }
            return res;
        }

        /**
         * Returns whether a cycle was detected.
         * 
         * @param data the data object
         * @return <code>true</code> for cycle, <code>false</code> else
         */
        protected boolean hasCycle(Map<Object, Object> data) {
            return Boolean.TRUE == data.get(DATA_CLOSURE_CYCLIC); 
        }

        /**
         * Handles the next value by checking whether it was already added.
         * 
         * @param value the value
         * @param result the result container to be changed if not already added
         * @param data the temporary data storing already added elements
         * @param nextValues the next values to be considered for iteration
         * @throws ValueDoesNotMatchTypeException if adding <code>value</code> to <code>result</code> is failing
         */
        private void handleNextValue(Value value, ContainerValue result, Map<Object, Object> data, 
            List<Value> nextValues) throws ValueDoesNotMatchTypeException {
            @SuppressWarnings("unchecked")
            Set<Object> marking = (Set<Object>) data.get(DATA_CLOSURE_MARKED);
            if (null == marking) {
                marking = new HashSet<Object>();
                data.put(DATA_CLOSURE_MARKED, marking);
            }
            if (!marking.contains(value)) {
                nextValues.add(value);
                if (null != result) {
                    result.addElement(value);
                }
                marking.add(value);
            } else {
                data.put(DATA_CLOSURE_CYCLIC, Boolean.TRUE);
            }
        }

    }

    /**
     * Implements {@link net.ssehub.easy.varModel.model.datatypes.Container#CLOSURE}.
     */
    static final IIteratorEvaluator CLOSURE = new ClosureIteratorEvaluator(false);

    /**
     * Implements {@link net.ssehub.easy.varModel.model.datatypes.Container#IS_ACYCLIC}.
     */
    static final IIteratorEvaluator IS_ACYCLIC = new ClosureIteratorEvaluator(true) {

        @Override
        public Value getStartResult(IDatatype type, IDatatype iterType) throws ValueDoesNotMatchTypeException {
            return BooleanValue.TRUE;
        }

        @Override
        public void postProcessResult(EvaluationAccessor result, Map<Object, Object> data) 
            throws ValueDoesNotMatchTypeException {
            result.setValue(BooleanValue.toBooleanValue(!hasCycle(data)));
        }
        
    };
    
    /**
     * Implements {@link net.ssehub.easy.varModel.model.datatypes.Container#CLOSURE}.
     */
    /*static final IIteratorEvaluator CLOSURE = new CollectingIteratorEvaluator() {
        
        @Override
        public Value aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            Value rValue = result.getValue();
            List<Value> nextValues = null;
            if (rValue instanceof ContainerValue) {
                ContainerValue resultContainer = (ContainerValue) rValue;
                nextValues = new ArrayList<Value>();
                handleNextValue(iter, resultContainer, data, nextValues);
                Value val = value.getValue();
                if (val instanceof ContainerValue) {
                    ContainerValue valContainer = (ContainerValue) val;
                    for (int e = 0; e < valContainer.getElementSize(); e++) {
                        handleNextValue(valContainer.getElement(e), 
                            resultContainer, data, nextValues);
                    }
                } else if (val instanceof ReferenceValue) {
                    handleNextValue(val, resultContainer, data, nextValues);
                }
            }
            
            Value res = BooleanValue.FALSE; // just go on
            if (null != nextValues) {
                res = new ListWrapperValue(nextValues);
            } 
            return res;
        }*/

        /**
         * Handles the next value by checking whether it was already added.
         * 
         * @param value the value
         * @param result the result container to be changed if not already added
         * @param data the temporary data storing already added elements
         * @param nextValues the next values to be considered for iteration
         * @throws ValueDoesNotMatchTypeException if adding <code>value</code> to <code>result</code> is failing
         */
        /*private void handleNextValue(Value value, ContainerValue result, Map<Object, Object> data, 
            List<Value> nextValues) throws ValueDoesNotMatchTypeException {
            if (!data.containsKey(value)) {
                nextValues.add(value);
                result.addElement(value);
                data.put(value,  null);
            }
        }

    };*/
    
    /**
     * Implements {@link net.ssehub.easy.varModel.model.datatypes.Container#SORTED_BY}.
     */
    static final IIteratorEvaluator SORTED_BY = new CollectingIteratorEvaluator() {

        private static final String KEY_SORTED_BY = "sortedBy";
        
        @SuppressWarnings("unchecked")
        @Override
        public BooleanValue aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            Object tmp = data.get(KEY_SORTED_BY);
            TreeMap<Value, List<Value>> keyMap;
            if (null == tmp) {
                Comparator<Value> cmp;
                IDatatype eltType = result.getValue().getContainedType();
                if (IntegerType.TYPE.isAssignableFrom(eltType)) {
                    cmp = INT_COMPARATOR;
                } else if (RealType.TYPE.isAssignableFrom(eltType)) {
                    cmp = REAL_COMPARATOR;
                } else {
                    cmp = new DefaultValueComparator(result.getContext().getCollator());
                }
                keyMap = new TreeMap<Value, List<Value>>(cmp);
                data.put(KEY_SORTED_BY, keyMap);
            } else {
                keyMap = (TreeMap<Value, List<Value>>) tmp;
            }
            Value cVal = result.getValue();
            if (cVal instanceof ContainerValue) {
                Value key = value.getValue();
                List<Value> keyValues = keyMap.get(key);
                if (null == keyValues) {
                    keyValues = new ArrayList<Value>();
                    keyMap.put(key, keyValues);
                }
                keyValues.add(iter);
            }
            return BooleanValue.FALSE;
        }

        @Override
        public void postProcessResult(EvaluationAccessor result, Map<Object, Object> data) 
            throws ValueDoesNotMatchTypeException {
            Value rVal = result.getValue();
            Object tmp = data.get(KEY_SORTED_BY);
            if (null != tmp && rVal instanceof ContainerValue) {
                ContainerValue container = (ContainerValue) rVal;
                @SuppressWarnings("unchecked")
                TreeMap<Value, List<Value>> keyMap = (TreeMap<Value, List<Value>>) tmp;
                for (List<Value> valList : keyMap.values()) {
                    for (Value val: valList) {
                        container.addElement(val);
                    }
                }
            }
        }

    };

    /**
     * Implements {@link net.ssehub.easy.varModel.model.datatypes.Container#SELECT} and
     * {@link net.ssehub.easy.varModel.model.datatypes.Container#REJECT}.
     */
    static class CollectIteratorEvaluator extends CollectingIteratorEvaluator {
        
        private BooleanValue condition;
        
        /**
         * Creates a collect iterator evaluator.
         * 
         * @param condition the boolean value that must be met by the iterated expression results
         */
        CollectIteratorEvaluator(BooleanValue condition) {
            this.condition = condition;
        }
        
        @Override
        public BooleanValue aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            Value cVal = result.getValue();
            if (condition.equals(value.getValue()) && cVal instanceof ContainerValue) {
                ((ContainerValue) cVal).addElement(iter);
            }
            return BooleanValue.FALSE;
        }

    };

    private static final Object DATA_CLOSURE_MARKED = new Object();
    private static final Object DATA_CLOSURE_CYCLIC = new Object();

    /**
     * The default value comparator for any value based on {@link StringProvider}.
     * 
     * @author Holger Eichelberger
     */
    private static class DefaultValueComparator implements Comparator<Value> {

        private Collator collator;

        /**
         * Creates a comparator based on a collator.
         * 
         * @param collator the collator
         */
        private DefaultValueComparator(Collator collator) {
            this.collator = collator;
        }

        @Override
        public int compare(Value o1, Value o2) {
            return collator.compare(StringProvider.toIvmlString(o1), StringProvider.toIvmlString(o2));
        }
        
    };

    /**
     * A comparator for {@link IntValue int values}. This comparator shall not be used with any other instance
     * than {@link IntValue int values}.
     */
    private static final Comparator<Value> INT_COMPARATOR = new Comparator<Value>() {

        @Override
        public int compare(Value o1, Value o2) {
            Integer i1 = ((IntValue) o1).getValue();
            Integer i2 = ((IntValue) o2).getValue();
            return i1.compareTo(i2);
        }
        
    };

    /**
     * A comparator for {@link RealValue real values}. This comparator shall not be used with any other instance
     * than {@link RealValue real values}.
     */
    private static final Comparator<Value> REAL_COMPARATOR = new Comparator<Value>() {

        @Override
        public int compare(Value o1, Value o2) {
            Double d1 = ((RealValue) o1).getValue();
            Double d2 = ((RealValue) o2).getValue();
            return d1.compareTo(d2);
        }
        
    };
    
    /**
     * Prevents external creation.
     */
    private ContainerIterators() {
    }
    
}
