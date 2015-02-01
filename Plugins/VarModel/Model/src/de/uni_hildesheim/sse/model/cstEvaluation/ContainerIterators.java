package de.uni_hildesheim.sse.model.cstEvaluation;

import java.util.Map;

import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.values.BooleanValue;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * Implements the container iterators.
 * 
 * @author Holger Eichelberger
 */
class ContainerIterators {
    
    /**
     * Implements {@link de.uni_hildesheim.sse.model.varModel.datatypes.Container#APPLY}.
     */
    static final IIteratorEvaluator APPLY = new IIteratorEvaluator() {

        @Override
        public boolean aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            // actual aggregation is defined by the apply expression, do not do here anything :o
            //result.setValue(value.getValue());
            return false;
        }

        @Override
        public Value getStartResult(IDatatype type) throws ValueDoesNotMatchTypeException {
            return null; // explicit defined, shall never be called
        }
        
    };

    /**
     * Implements {@link de.uni_hildesheim.sse.model.varModel.datatypes.Container#FORALL}.
     */
    static final IIteratorEvaluator FOR_ALL = new IIteratorEvaluator() {

        @Override
        public boolean aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            if (!(BooleanValue.TRUE.equals(result.getValue()) 
                && BooleanValue.TRUE.equals(value.getValue()))) {
                // forAll is only true if all evaluations are true
                result.setValue(BooleanValue.FALSE);
            }
            return false;
        }

        public Value getStartResult(IDatatype type) throws ValueDoesNotMatchTypeException {
            return BooleanValue.TRUE;
        }
        
    };

    /**
     * Implements {@link de.uni_hildesheim.sse.model.varModel.datatypes.Container#EXISTS}.
     */
    static final IIteratorEvaluator EXISTS = new IIteratorEvaluator() {
        
        @Override
        public boolean aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            boolean stop;
            if (BooleanValue.TRUE.equals(value.getValue())) {
                // exists is fine with the first evaluation result that is true
                result.setValue(BooleanValue.TRUE);
                stop = true;
            } else {
                stop = false;
            }
            return stop;
        }

        @Override
        public Value getStartResult(IDatatype type) throws ValueDoesNotMatchTypeException {
            return BooleanValue.FALSE;
        }

    };

    /**
     * Implements {@link de.uni_hildesheim.sse.model.varModel.datatypes.Container#IS_UNIQUE}.
     */
    static final IIteratorEvaluator IS_UNIQUE = new IIteratorEvaluator() {
        
        @Override
        public boolean aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            boolean stop;
            Value val = value.getValue();
            if (data.containsKey(val)) {
                stop = true;
                result.setValue(BooleanValue.FALSE);
            } else {
                data.put(val, null);
                stop = false;
            }
            return stop;
        }

        @Override
        public Value getStartResult(IDatatype type) throws ValueDoesNotMatchTypeException {
            return BooleanValue.TRUE;
        }

    };

    /**
     * Implements {@link de.uni_hildesheim.sse.model.varModel.datatypes.Container#ANY}.
     */
    static final IIteratorEvaluator ANY = new IIteratorEvaluator() {
        
        @Override
        public boolean aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) {
            boolean stop;
            if (BooleanValue.TRUE.equals(value.getValue())) {
                stop = true;
                result.setValue(iter);
            } else {
                stop = false;
            }
            return stop;
        }

        @Override
        public Value getStartResult(IDatatype type) throws ValueDoesNotMatchTypeException {
            return NullValue.INSTANCE;
        }

    };

    /**
     * Implements {@link de.uni_hildesheim.sse.model.varModel.datatypes.Container#ONE}.
     */
    static final IIteratorEvaluator ONE = new IIteratorEvaluator() {
        
        @Override
        public boolean aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            boolean stop;
            if (BooleanValue.TRUE.equals(value.getValue())) {
                stop = !NullValue.INSTANCE.equals(result.getValue());
                result.setValue(iter);
            } else {
                stop = false;
            }
            return stop;
        }

        @Override
        public Value getStartResult(IDatatype type) throws ValueDoesNotMatchTypeException {
            return NullValue.INSTANCE;
        }

    };

    /**
     * Implements an evaluator adaptor for collecting operations.
     * 
     * @author Holger Eichelberger
     */
    abstract static class CollectingIteratorEvaluator implements IIteratorEvaluator {

        @Override
        public Value getStartResult(IDatatype type) throws ValueDoesNotMatchTypeException {
            return ValueFactory.createValue(type, (Object[]) null);
        }

    }

    /**
     * Implements {@link de.uni_hildesheim.sse.model.varModel.datatypes.Container#COLLECT}.
     */
    static final IIteratorEvaluator COLLECT = new CollectingIteratorEvaluator() {
        
        @Override
        public boolean aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            ((ContainerValue) result.getValue()).addElement(value.getValue());
            return false;
        }

    };

    /**
     * Implements {@link de.uni_hildesheim.sse.model.varModel.datatypes.Container#SELECT} and
     * {@link de.uni_hildesheim.sse.model.varModel.datatypes.Container#REJECT}.
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
        public boolean aggregate(EvaluationAccessor result, Value iter, EvaluationAccessor value, 
            Map<Object, Object> data) throws ValueDoesNotMatchTypeException {
            if (condition.equals(value.getValue())) {
                ((ContainerValue) result.getValue()).addElement(iter);
            }
            return false;
        }

    };
    
    /**
     * Prevents external creation.
     */
    private ContainerIterators() {
    }
    
}
