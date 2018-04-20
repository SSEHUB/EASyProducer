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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.pool.IPoolManager;
import net.ssehub.easy.basics.pool.Pool;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.cstEvaluation.ContainerIterators.CollectIteratorEvaluator;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.MetaTypeValue;
import net.ssehub.easy.varModel.model.values.RealValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Implements the default container operations.
 * 
 * @author Holger Eichelberger
 */
public class ContainerOperations {

    /**
     * A combined container value / accessor. Use {@link ContainerOperations#CA_POOL} to obtain/release instances.
     * 
     * @author Holger Eichelberger
     */
    static final class ContainerArgument {
        private ContainerValue value;
        private EvaluationAccessor accessor;

        /**
         * Creates a new instance. Prevents external instantiation.
         */
        private ContainerArgument() {
        }
        
        /**
         * Sets the values of this argument. [reuse]
         * 
         * @param value the container value
         * @param accessor the accessor
         * @return <b>this</b>
         */
        ContainerArgument setValues(ContainerValue value, EvaluationAccessor accessor) {
            this.value = value;
            this.accessor = accessor;
            return this;
        }

        /**
         * Returns the container value.
         * 
         * @return the container value
         */
        ContainerValue getValue() {
            return value;
        }
        
        /**
         * Returns the accessor.
         * 
         * @return the accessor
         */
        EvaluationAccessor getAccessor() {
            return accessor;
        }
        
        /**
         * Clears this instance for reuse.
         */
        private void clear() {
            value = null;
            accessor = null;
        }
    }

    static final Pool<ContainerArgument> CA_POOL = new Pool<ContainerArgument>(
        new IPoolManager<ContainerArgument>() {

            @Override
            public ContainerArgument create() {
                return new ContainerArgument();
            }
    
            @Override
            public void clear(ContainerArgument instance) {
                instance.clear();
            }
        });

    /**
     * Implements {@link Container#SIZE}.
     */
    static final IOperationEvaluator SIZE = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result;
            Value opValue = operand.getValue();
            if (opValue instanceof ContainerValue) {
                try {
                    Value val = ValueFactory.createValue(IntegerType.TYPE, ((ContainerValue) opValue).getElementSize());
                    result = ConstantAccessor.POOL.getInstance().bind(val, operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    operand.getContext().addErrorMessage(e);
                    result = null;
                }
            } else {
                if (null != opValue) { // undefined is ok
                    operand.getContext().addErrorMessage("operand is no Container: " 
                        + IvmlDatatypeVisitor.getQualifiedType(opValue.getType()));
                }
                result = null;
            }
            return result;
        }
    };
    
    /**
     * Implements the "add" operation.
     */
    static final IOperationEvaluator ADD = new IOperationEvaluator() {

        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value oValue = operand.getValue();
                Value aValue = arguments[0].getValue();
                if (oValue instanceof ContainerValue && null != aValue) {
                    ContainerValue cont = (ContainerValue) oValue;
                    try {
                        cont.addElement(aValue);
                        result = ConstantAccessor.POOL.getInstance().bind(aValue, operand.getContext());
                    } catch (ValueDoesNotMatchTypeException e) {
                        // result -> null
                        operand.getContext().addErrorMessage(e);
                    }
                }
            }
            return result;
        }

    };

    /**
     * Implements the "avg" operation.
     */
    static final IOperationEvaluator AVG = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value opValue = operand.getValue();
            if (opValue instanceof ContainerValue) {
                ContainerValue cont = (ContainerValue) opValue;
                boolean isInt = TypeQueries.sameTypes(IntegerType.TYPE, cont.getContainedType());
                boolean isReal = TypeQueries.sameTypes(RealType.TYPE, cont.getContainedType());
                if (isInt || isReal) {
                    double sum = 0;
                    int size = cont.getElementSize();
                    if (size > 0) {
                        if (isInt) {
                            for (int i = 0; i < size; i++) {
                                Value elt = cont.getElement(i);
                                sum += ((IntValue) elt).getValue();
                            }
                        } else {
                            for (int i = 0; i < size; i++) {
                                Value elt = cont.getElement(i);
                                sum += ((RealValue) elt).getValue();
                            }
                        }
                        sum /= size;
                    }
                    try {
                        Value rValue;
                        if (isInt) {
                            rValue = ValueFactory.createValue(IntegerType.TYPE, (int) sum);
                        } else {
                            rValue = ValueFactory.createValue(RealType.TYPE, sum);
                        }
                        result = ConstantAccessor.POOL.getInstance().bind(rValue, operand.getContext());
                    } catch (ValueDoesNotMatchTypeException e) {
                        operand.getContext().addErrorMessage(e);
                    }
                }
            }
            return result;
        }
    };
    
    /**
     * Implements the typeSelection operation.
     */
    static class TypeSelectEvaluator implements IOperationEvaluator {
        
        private boolean reject;
        private boolean kindOf;
        
        /**
         * Creates a type select evaluator.
         * 
         * @param reject do reject instead of select
         * @param kindOf shall the evaluator take the subtypes into account (<code>true</code>) or
         *   consider only type equality (<code>false</code>)
         */
        TypeSelectEvaluator(boolean reject, boolean kindOf) {
            this.reject = reject;
            this.kindOf = kindOf;
        }
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value opValue = operand.getValue();
                Value argValue = arguments[0].getValue();
                if (opValue instanceof ContainerValue && argValue instanceof MetaTypeValue) {
                    ContainerValue cont = (ContainerValue) opValue;
                    IDatatype type = ((MetaTypeValue) argValue).getValue();
                    List<Value> tmp = new ArrayList<Value>();
                    int size = cont.getElementSize();
                    for (int i = 0; i < size; i++) {
                        Value elt = cont.getElement(i);
                        boolean condition;
                        if (kindOf) {
                            condition = type.isAssignableFrom(elt.getType());
                        } else {
                            condition = TypeQueries.sameTypes(type, elt.getType());
                        }
                        if (reject) {
                            condition = !condition;
                        }
                        if (condition) {
                            tmp.add(elt);
                        }
                    }
                    try {
                        Value rValue = ValueFactory.createValue(operand.getValue().getType(), tmp.toArray());
                        result = ConstantAccessor.POOL.getInstance().bind(rValue, operand.getContext());
                    } catch (ValueDoesNotMatchTypeException e) {
                        operand.getContext().addErrorMessage(e);
                    }
                }
            }
            return result;
        }
    };

    /**
     * Implements a container calculation evaluator (just as needed for now).
     * 
     * @author Holger Eichelberger
     */
    private static class CalcEvaluator implements IOperationEvaluator {
        
        private boolean mult;
        
        /**
         * Implements a container calculation evaluator.
         * 
         * @param mult multiply (product) or sum
         */
        CalcEvaluator(boolean mult) {
            this.mult = mult;
        }
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value opValue = operand.getValue();
            if (opValue instanceof ContainerValue) {
                ContainerValue cont = (ContainerValue) opValue;
                boolean isInt = TypeQueries.sameTypes(IntegerType.TYPE, cont.getContainedType());
                boolean isReal = TypeQueries.sameTypes(RealType.TYPE, cont.getContainedType());
                if (isInt || isReal) {
                    Value rValue;
                    int size = cont.getElementSize();
                    try {
                        if (isInt) {
                            int sum = 0; // may exceed range!
                            for (int i = 0; i < size; i++) {
                                Value elt = cont.getElement(i);
                                int tmp = ((IntValue) elt).getValue();
                                if (mult) {
                                    sum *= tmp;
                                } else {
                                    sum += tmp;
                                }
                            }
                            rValue = ValueFactory.createValue(IntegerType.TYPE, sum);
                        } else {
                            double sum = 0;
                            for (int i = 0; i < size; i++) {
                                Value elt = cont.getElement(i);
                                double tmp = ((RealValue) elt).getValue();
                                if (mult) {
                                    sum *= tmp;
                                } else {
                                    sum += tmp;
                                }
                            }
                            rValue = ValueFactory.createValue(RealType.TYPE, sum);
                        }
                        result = ConstantAccessor.POOL.getInstance().bind(rValue, operand.getContext());
                    } catch (ValueDoesNotMatchTypeException e) {
                        operand.getContext().addErrorMessage(e);
                    }
                }
            }
            return result;
        }
        
    }
    
    /**
     * Defines the "asSet" operation. Due to the implementation of values in EASy,
     * this operation can be implemented generically.
     */
    static final IOperationEvaluator AS_SET = new IOperationEvaluator() {
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return convert(operand, Set.TYPE);
        }
    };

    /**
     * Defines the "asSequence" operation. Due to the implementation of values in EASy,
     * this operation can be implemented generically.
     */
    static final IOperationEvaluator AS_SEQUENCE = new IOperationEvaluator() {
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return convert(operand, Sequence.TYPE);
        }
    };
    
    static final IOperationEvaluator MIN = new IOperationEvaluator() {
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return min(operand, arguments);
        }
    };
    
    static final IOperationEvaluator MAX = new IOperationEvaluator() {
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            return max(operand, arguments);
        }
    };
    
    /**
     * Defines a container/container operation.
     * 
     * @author Holger Eichelberger
     */
    interface Container2Operation {
        
        /**
         * Evaluates the specific function on two container values possibly modifying <code>result</code>.
         * 
         * @param c1 the first container (must not be modified)
         * @param c2 the second container (must not be modified)
         * @param result the result (to be modified as a side effect)
         * @param resultAccessor for taking over bound elements
         */
        public void evaluate(ContainerArgument c1, ContainerArgument c2, List<Value> result, 
            EvaluationAccessor resultAccessor);
    }

    /**
     * Defines a container/value operation.
     * 
     * @author Holger Eichelberger
     */
    interface ContainerValueOperation {

        /**
         * Evaluates the specific function on a container and a value possibly modifying <code>result</code>.
         * 
         * @param cont the container (must not be modified)
         * @param value the value 
         * @param result the result (to be modified as a side effect)
         * @param resAcc accessor to <code>result</code> for transferring bound elements
         */
        public void evaluate(ContainerArgument cont, Value value, List<Value> result, EvaluationAccessor resAcc);
    }
    
    /**
     * Implements a container/container operation generically.
     */
    static class Container2OperationEvaluator implements IOperationEvaluator {
        
        private Container2Operation op;

        /**
         * Creates a container/container operation evaluator.
         * 
         * @param op the operation to be executed
         */
        protected Container2OperationEvaluator(Container2Operation op) {
            this.op = op;
        }
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            ConstantAccessor result = null;
            if (1 == arguments.length) {
                Value opValue = operand.getValue();
                Value argValue = arguments[0].getValue();
                if (opValue instanceof ContainerValue && argValue instanceof ContainerValue) {
                    List<Value> tmp = new ArrayList<Value>();
                    result = ConstantAccessor.POOL.getInstance();
                    ContainerArgument c1 = CA_POOL.getInstance().setValues((ContainerValue) opValue, operand);
                    ContainerArgument c2 = CA_POOL.getInstance().setValues((ContainerValue) argValue, arguments[0]);
                    op.evaluate(c1, c2, tmp, result);
                    try {
                        Value rValue = ValueFactory.createValue(opValue.getType(), tmp.toArray());
                        result.bind(rValue, operand.getContext());
                    } catch (ValueDoesNotMatchTypeException e) {
                        operand.getContext().addErrorMessage(e);
                        result = EvaluationAccessor.release(result);
                    }
                    CA_POOL.releaseInstance(c1);
                    CA_POOL.releaseInstance(c2);
                }
            }
            return result;
        }
    };

    /**
     * Implements a container/value operation generically.
     */
    static class ContainerValueOperationEvaluator implements IOperationEvaluator {
        
        private ContainerValueOperation op;

        /**
         * Creates a container/value operation evaluator.
         * 
         * @param op the operation to be executed
         */
        protected ContainerValueOperationEvaluator(ContainerValueOperation op) {
            this.op = op;
        }

        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            ConstantAccessor result = null;
            if (1 == arguments.length) {
                Value opValue = operand.getValue();
                Value argValue = arguments[0].getValue();
                if (opValue instanceof ContainerValue && null != argValue) {
                    result = ConstantAccessor.POOL.getInstance();
                    ContainerArgument ca = CA_POOL.getInstance().setValues((ContainerValue) opValue, operand);
                    ArrayList<Value> tmp = new ArrayList<Value>();
                    op.evaluate(ca, argValue, tmp, result);
                    try {
                        Value rValue = ValueFactory.createValue(opValue.getType(), tmp.toArray());
                        result.bind(rValue, operand.getContext());
                    } catch (ValueDoesNotMatchTypeException e) {
                        operand.getContext().addErrorMessage(e);
                        result = EvaluationAccessor.release(result);
                    }
                    CA_POOL.releaseInstance(ca);
                }                
            }
            return result;
        }
    };

    /**
     * Implements the "intersect" operation generically.
     */
    static final IOperationEvaluator INTERSECT = new Container2OperationEvaluator(new Container2Operation() {
        
        public void evaluate(ContainerArgument c1, ContainerArgument c2, List<Value> result, 
            EvaluationAccessor resultAcc) {
            HashSet<Value> done = new HashSet<Value>();
            ContainerValue cv1 = c1.getValue();
            EvaluationAccessor c1Acc = c1.getAccessor();
            ContainerValue cv2 = c2.getValue();
            for (int a = 0; a < cv2.getElementSize(); a++) {
                done.add(cv2.getElement(a));
            }
            for (int o = 0; o < cv1.getElementSize(); o++) {
                Value elt = cv1.getElement(o);
                if (done.contains(elt)) {
                    result.add(elt);
                    resultAcc.addBoundContainerElement(c1Acc, o);
                }
            }
        }
    });

    /**
     * Implements the "includes"/"excludes" function.
     */
    static final class FindOperationEvaluator implements IOperationEvaluator {
        
        private boolean negate;
        
        /**
         * Creates a find operation evaluator.
         * 
         * @param negate negate the result ("excludes") or use the derived result ("includes")
         */
        public FindOperationEvaluator(boolean negate) {
            this.negate = negate;
        }
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value oValue = operand.getValue();
                Value aValue = arguments[0].getValue();
                if (oValue instanceof ContainerValue) {
                    ContainerValue cValue = (ContainerValue) oValue;
                    boolean bResult = cValue.indexOf(aValue) >= 0;
                    if (negate) {
                        bResult = !bResult;
                    }
                    result = ConstantAccessor.POOL.getInstance().bind(
                        BooleanValue.toBooleanValue(bResult), operand.getContext());
                }
            }
            return result;
        }
    };

    /**
     * Implements the "includesAll"/"excludesAll" function.
     */
    static final class IncludesAllOperationEvaluator implements IOperationEvaluator {
        
        private boolean exclude;
        
        /**
         * Creates an includes all operation evaluator.
         * 
         * @param exclude negate the result ("excludesAll") or use the derived result ("includesAll")
         */
        public IncludesAllOperationEvaluator(boolean exclude) {
            this.exclude = exclude;
        }
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value oValue = operand.getValue();
                Value aValue = arguments[0].getValue();
                if (oValue instanceof ContainerValue && aValue instanceof ContainerValue) {
                    ContainerValue coValue = (ContainerValue) oValue;
                    ContainerValue caValue = (ContainerValue) aValue;
                    boolean all = true;
                    for (int i = 0; all && i < caValue.getElementSize(); i++) {
                        Value val = caValue.getElement(i);
                        if (exclude) {
                            all &= coValue.indexOf(val) < 0; // exclude
                        } else {
                            all &= coValue.indexOf(val) >= 0;
                        }
                    }
                    result = ConstantAccessor.POOL.getInstance().bind(
                        BooleanValue.toBooleanValue(all), operand.getContext());
                }
            }
            return result;
        }
    };

    /**
     * Implements the "count" operation.
     */
    static final IOperationEvaluator COUNT = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            if (1 == arguments.length) {
                Value oValue = operand.getValue();
                Value aValue = arguments[0].getValue();
                if (oValue instanceof ContainerValue) {
                    ContainerValue cValue = (ContainerValue) oValue;
                    int size = cValue.getElementSize();
                    int count = 0;
                    for (int i = 0; i < size; i++) {
                        if (cValue.getElement(i).equals(aValue)) {
                            count++;
                        }
                    }
                    try {
                        Value rValue = ValueFactory.createValue(IntegerType.TYPE, count);
                        result = ConstantAccessor.POOL.getInstance().bind(
                            rValue, operand.getContext());
                    } catch (ValueDoesNotMatchTypeException e) {
                        operand.getContext().addErrorMessage(e);
                    }
                }
            }
            return result;
        }
    };

    /**
     * Implements the "isEmpty"/"notEmpty" function.
     */
    static final class IsEmptyOperationEvaluator implements IOperationEvaluator {
        
        private boolean negate;
        
        /**
         * Creates a find operation evaluator.
         * 
         * @param negate negate the result ("notEmpty") or use the derived result ("isEmpty")
         */
        public IsEmptyOperationEvaluator(boolean negate) {
            this.negate = negate;
        }
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value oValue = operand.getValue();
            if (oValue instanceof ContainerValue) {
                ContainerValue cValue = (ContainerValue) oValue;
                boolean bResult = 0 == cValue.getElementSize();
                if (negate) {
                    bResult = !bResult;
                }
                result = ConstantAccessor.POOL.getInstance().bind(
                    BooleanValue.toBooleanValue(bResult), operand.getContext());
            }
            return result;
        }
    };
    
    /**
     * Implements the "flattens" operation.
     */
    static final class FlattenOperationEvaluator implements IOperationEvaluator {

        private boolean allowDuplicates;
        
        /**
         * Creates a flatten operation evaluator.
         * 
         * @param allowDuplicates allow duplicates (sequence, <code>true</code>) or not (set, <code>false</code>)
         */
        FlattenOperationEvaluator(boolean allowDuplicates) {
            this.allowDuplicates = allowDuplicates;
        }
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value oValue = operand.getValue();
            if (oValue instanceof ContainerValue) {
                ContainerValue cont = (ContainerValue) oValue;
                Collection<Value> tmp; 
                if (allowDuplicates) {
                    tmp = new ArrayList<Value>();
                } else {
                    tmp = new HashSet<Value>();
                }
                for (int i = 0, size = cont.getElementSize(); i < size; i++) {
                    flatten(cont.getElement(i), tmp);
                }
                
                IDatatype resultType;
                IDatatype containerType = cont.getType();
                IDatatype deepest = TypeQueries.findDeepestGeneric(containerType, 0);
                if (Set.TYPE.isAssignableFrom(containerType)) {
                    resultType = new Set("", deepest, null);
                } else {
                    resultType = new Sequence("", deepest, null);
                }
                try {
                    Value rValue = ValueFactory.createValue(resultType, tmp.toArray());
                    result = ConstantAccessor.POOL.getInstance().bind(rValue, operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    // result -> null
                }
            }
            return result;
        }

    };
    
    /**
     * Prevent instance creation.
     */
    private ContainerOperations() {
    }
   
    /**
     * Registers the defined operations.
     */
    public static void register() {
        EvaluatorRegistry.registerEvaluator(SIZE, Container.SIZE);
        EvaluatorRegistry.registerEvaluator(GenericOperations.UNEQUALS, Container.UNEQUALS, Container.UNEQUALS_ALIAS);
        EvaluatorRegistry.registerEvaluator(new FindOperationEvaluator(false), Container.INCLUDES);
        EvaluatorRegistry.registerEvaluator(new FindOperationEvaluator(true), Container.EXCLUDES);
        EvaluatorRegistry.registerEvaluator(new IncludesAllOperationEvaluator(false), Container.INCLUDES_ALL);
        EvaluatorRegistry.registerEvaluator(new IncludesAllOperationEvaluator(true), Container.EXCLUDES_ALL);
        EvaluatorRegistry.registerEvaluator(COUNT, Container.COUNT);
        EvaluatorRegistry.registerEvaluator(new IsEmptyOperationEvaluator(false), Container.IS_EMPTY);
        EvaluatorRegistry.registerEvaluator(new IsEmptyOperationEvaluator(true), Container.NOT_EMPTY);
        EvaluatorRegistry.registerEvaluator(new CalcEvaluator(false), Container.SUM);
        EvaluatorRegistry.registerEvaluator(new CalcEvaluator(true), Container.PRODUCT);
        EvaluatorRegistry.registerEvaluator(MIN, Container.MIN);
        EvaluatorRegistry.registerEvaluator(MAX, Container.MAX);
        EvaluatorRegistry.registerEvaluator(AVG, Container.AVG);
        EvaluatorRegistry.registerEvaluator(GenericOperations.TYPE_OF, Container.TYPE_OF);
        EvaluatorRegistry.registerEvaluator(ContainerIterators.APPLY, Container.APPLY);
        EvaluatorRegistry.registerEvaluator(ContainerIterators.APPLY, Container.ITERATE);
        EvaluatorRegistry.registerEvaluator(ContainerIterators.FOR_ALL, Container.FORALL);
        EvaluatorRegistry.registerEvaluator(ContainerIterators.EXISTS, Container.EXISTS);
        EvaluatorRegistry.registerEvaluator(ContainerIterators.ANY, Container.ANY);
        EvaluatorRegistry.registerEvaluator(ContainerIterators.ONE, Container.ONE);
        EvaluatorRegistry.registerEvaluator(ContainerIterators.MIN2, Container.MIN2);
        EvaluatorRegistry.registerEvaluator(ContainerIterators.MAX2, Container.MAX2);
        EvaluatorRegistry.registerEvaluator(ContainerIterators.IS_UNIQUE, Container.IS_UNIQUE);
        EvaluatorRegistry.registerEvaluator(ContainerIterators.COLLECT, Container.COLLECT);
        EvaluatorRegistry.registerEvaluator(ContainerIterators.COLLECT, Container.COLLECT_NESTED);
        EvaluatorRegistry.registerEvaluator(ContainerIterators.IS_ACYCLIC, Container.IS_ACYCLIC);
        EvaluatorRegistry.registerEvaluator(ContainerIterators.CLOSURE, Container.CLOSURE);
        EvaluatorRegistry.registerEvaluator(ContainerIterators.SORTED_BY, Container.SORTED_BY);
        EvaluatorRegistry.registerEvaluator(new CollectIteratorEvaluator(BooleanValue.TRUE), Container.SELECT);
        EvaluatorRegistry.registerEvaluator(new CollectIteratorEvaluator(BooleanValue.FALSE), Container.REJECT);
        EvaluatorRegistry.registerEvaluator(new TypeSelectEvaluator(false, true), Container.TYPE_SELECT);
        EvaluatorRegistry.registerEvaluator(new TypeSelectEvaluator(false, false), Container.SELECT_BY_TYPE);
        EvaluatorRegistry.registerEvaluator(new TypeSelectEvaluator(false, true), Container.SELECT_BY_KIND);
        EvaluatorRegistry.registerEvaluator(new TypeSelectEvaluator(true, true), Container.TYPE_REJECT);
        EvaluatorRegistry.registerEvaluator(GenericOperations.IS_DEFINED, Container.IS_DEFINED);
    }

    /**
     * Performs the conversion of the operand to the given (container) datatype.
     * 
     * @param operand the operand to be converted
     * @param targetType the target datatype
     * @return the converted operand
     */
    private static final EvaluationAccessor convert(EvaluationAccessor operand, IDatatype targetType) {
        ConstantAccessor result = null;
        Value oVal = operand.getValue();
        if (oVal instanceof ContainerValue) {
            ContainerValue cont = (ContainerValue) oVal;
            // due to releasing Accessors create always
            result = ConstantAccessor.POOL.getInstance();
            try {
                Value rValue;
                if (Set.TYPE.isAssignableFrom(targetType)) {
                    if (1 == oVal.getType().getGenericTypeCount()) {
                        targetType = new Set("set", oVal.getType().getGenericType(0), null);
                    }
                    HashSet<Object> done = new HashSet<Object>();
                    ArrayList<Object> tmp = new ArrayList<Object>();
                    for (int i = 0; i < cont.getElementSize(); i++) {
                        Object elt = cont.getElement(i);
                        if (!done.contains(elt)) {
                            done.add(elt);
                            tmp.add(elt); // for now we try to keep the sequence
                            result.addBoundContainerElement(operand, i);
                        }
                    }
                    Object[] array = new Object[tmp.size()];
                    tmp.toArray(array);
                    rValue = ValueFactory.createValue(targetType, (Object[]) array);
                } else {
                    rValue = ValueFactory.createValue(targetType, (Object[]) null);
                    rValue.setValue(cont);
                }
                result.bind(rValue, operand.getContext());
            } catch (ValueDoesNotMatchTypeException e) {
                operand.getContext().addErrorMessage(e);
                result = EvaluationAccessor.release(result);
            }
        }
        return result;
    }
    
    /**
     * Performs the MIN operation the given (container) datatype.
     * 
     * @param operand the operand to be converted
     * @param arguments the arguments
     * @return The result of the arithmetic operation, <b>null</b> if the operation cannot be applied
     */
    private static final EvaluationAccessor min(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
        EvaluationAccessor result = null;
        Value oVal = operand.getValue();
        if (oVal instanceof ContainerValue) {
            ContainerValue cont = (ContainerValue) oVal;
            IDatatype contType = ((Container) cont.getType()).getContainedType();
            int contSize = cont.getElementSize();
            
            if (contSize > 0) {
                Value rValue = null;
                
                // Determine min for number containers 
                if (contType.isAssignableFrom(RealType.TYPE)) {
                    // Handle min for Reals
                    double min = (Double) cont.getElement(0).getValue();
                    for (int i = 1; i < contSize; i++) {
                        double tmp = (Double) cont.getElement(i).getValue();
                        if (tmp < min) {
                            min = tmp;
                        }
                    }
                    
                    try {
                        rValue = ValueFactory.createValue(contType, min);
                    } catch (ValueDoesNotMatchTypeException e) {
                        EASyLoggerFactory.INSTANCE.getLogger(GenericNumberOperations.class, Bundle.ID)
                            .debug(e.getMessage());
                    }
                } else if (contType.isAssignableFrom(IntegerType.TYPE)) {
                    // Handle min for Reals
                    int min = (Integer) cont.getElement(0).getValue();
                    for (int i = 1; i < contSize; i++) {
                        int tmp = (Integer) cont.getElement(i).getValue();
                        if (tmp < min) {
                            min = tmp;
                        }
                    }
                    
                    // Create min value
                    try {
                        rValue = ValueFactory.createValue(contType, min);
                    } catch (ValueDoesNotMatchTypeException e) {
                        EASyLoggerFactory.INSTANCE.getLogger(GenericNumberOperations.class, Bundle.ID)
                            .debug(e.getMessage());
                    }
                }
                
                if (null != rValue) {
                    result = ConstantAccessor.POOL.getInstance().bind(rValue, operand.getContext());
                }
            }
        }
        return result;
    }
    
    /**
     * Performs the MAX operation the given (container) datatype.
     * 
     * @param operand the operand to be converted
     * @param arguments the arguments
     * @return The result of the arithmetic operation, <b>null</b> if the operation cannot be applied
     */
    private static final EvaluationAccessor max(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
        EvaluationAccessor result = null;
        Value oVal = operand.getValue();
        if (oVal instanceof ContainerValue) {
            ContainerValue cont = (ContainerValue) oVal;
            IDatatype contType = ((Container) cont.getType()).getContainedType();
            int contSize = cont.getElementSize();
            
            if (contSize > 0) {
                Value rValue = null;
                
                // Determine max for number containers 
                if (contType.isAssignableFrom(RealType.TYPE)) {
                    // Handle max for Reals
                    double max = (Double) cont.getElement(0).getValue();
                    for (int i = 1; i < contSize; i++) {
                        double tmp = (Double) cont.getElement(i).getValue();
                        if (tmp > max) {
                            max = tmp;
                        }
                    }
                    
                    try {
                        rValue = ValueFactory.createValue(contType, max);
                    } catch (ValueDoesNotMatchTypeException e) {
                        EASyLoggerFactory.INSTANCE.getLogger(GenericNumberOperations.class, Bundle.ID)
                            .debug(e.getMessage());
                    }
                } else if (contType.isAssignableFrom(IntegerType.TYPE)) {
                    // Handle max for Reals
                    int max = (Integer) cont.getElement(0).getValue();
                    for (int i = 1; i < contSize; i++) {
                        int tmp = (Integer) cont.getElement(i).getValue();
                        if (tmp > max) {
                            max = tmp;
                        }
                    }
                    
                    // Create max value
                    try {
                        rValue = ValueFactory.createValue(contType, max);
                    } catch (ValueDoesNotMatchTypeException e) {
                        EASyLoggerFactory.INSTANCE.getLogger(GenericNumberOperations.class, Bundle.ID)
                            .debug(e.getMessage());
                    }
                }
                
                if (null != rValue) {
                    result = ConstantAccessor.POOL.getInstance().bind(rValue, operand.getContext());
                }
            }
        }
        return result;
    }
    
    /**
     * Adds all elements in <code>cnt</code> to <code>result</code>.
     * 
     * @param cnt the source of the elements
     * @param result the target (to be modified as a side effect)
     * @param resAcc the accessor to <code>cont</code> for taking over bound elements
     */
    static final void addAll(ContainerArgument cnt, List<Value> result, EvaluationAccessor resAcc) {
        ContainerValue cont = cnt.getValue();
        EvaluationAccessor contAcc = cnt.getAccessor();
        for (int i = 0; i < cont.getElementSize(); i++) {
            result.add(cont.getElement(i));
            resAcc.addBoundContainerElement(contAcc, i);
        }
    }

    /**
     * Adds all elements in <code>cnt</code> to <code>result</code>.
     * 
     * @param cnt the source of the elements
     * @param result the target (to be modified as a side effect)
     * @param resAcc the accessor to <code>cont</code> for taking over bound elements
     */
    static final void addAll(ContainerArgument cnt, java.util.Set<Value> result, EvaluationAccessor resAcc) {
        ContainerValue cont = cnt.getValue();
        EvaluationAccessor contAcc = cnt.getAccessor();
        for (int i = 0; i < cont.getElementSize(); i++) {
            result.add(cont.getElement(i));
            resAcc.addBoundContainerElement(contAcc, i);
        }
    }

    
    /**
     * Returns whether the first argument value can be found in the <code>operand</code> given that operand
     * is a container.
     * 
     * @param operand the operand
     * @param arguments the arguments
     * @param negate negate the result, i.e., from found to not found
     * @return whether the first argument was (not) found in <code>operand</code>
     */
    static final EvaluationAccessor found(EvaluationAccessor operand, EvaluationAccessor[] arguments, boolean negate) {
        EvaluationAccessor result = null;
        if (1 == arguments.length) {
            Value oValue = operand.getValue();
            Value aValue = arguments[0].getValue();
            if (oValue instanceof ContainerValue) {
                ContainerValue cValue = (ContainerValue) oValue;
                boolean bResult;
                if (negate) {
                    bResult = cValue.indexOf(aValue) < 0;
                } else {
                    bResult = cValue.indexOf(aValue) >= 0;
                }
                result = ConstantAccessor.POOL.getInstance().bind(
                    BooleanValue.toBooleanValue(bResult), operand.getContext());
            }
        }
        return result;
    }

    /**
     * (Recursively) Flattens the given value if needed.
     * 
     * @param value the value to be flattened
     * @param result the flattened values (modified as a side effect)
     */
    static void flatten(Value value, Collection<Value> result) {
        if (value instanceof ContainerValue) {
            ContainerValue cont = (ContainerValue) value;
            for (int i = 0, size = cont.getElementSize(); i < size; i++) {
                flatten(cont.getElement(i), result);
            }            
        } else {
            result.add(value);
        }
    }

}