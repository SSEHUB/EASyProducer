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

import static net.ssehub.easy.varModel.cstEvaluation.ContainerOperations.*;

import java.util.HashSet;
import java.util.List;

import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Implements set operations.
 * 
 * @author Holger Eichelberger
 *
 */
public class SetOperations {

    /**
     * Implements the union operation.
     */
    static final IOperationEvaluator UNION = new Container2OperationEvaluator(new Container2Operation() {
        
        public void evaluate(ContainerValue c1, ContainerValue c2, List<Value> result) {
            HashSet<Value> done = new HashSet<Value>();
            addAll((ContainerValue) c1, result, done);
            addAll((ContainerValue) c2, result, done);
        }
    });

    /**
     * Implements the difference (-) operation.
     */
    static final IOperationEvaluator DIFFERENCE = new Container2OperationEvaluator(new Container2Operation() {
        
        public void evaluate(ContainerValue c1, ContainerValue c2, List<Value> result) {
            HashSet<Value> inC2 = new HashSet<Value>();
            ContainerOperations.addAll(c2, inC2);
            for (int e = 0; e < c1.getElementSize(); e++) {
                Value val = c1.getElement(e);
                if (!inC2.contains(val)) {
                    result.add(val);
                }
            }
        }
    });

    /**
     * Implements the symmetric difference operation.
     */
    static final IOperationEvaluator SYMMETRIC_DIFFERENCE = new Container2OperationEvaluator(new Container2Operation() {
        
        public void evaluate(ContainerValue c1, ContainerValue c2, List<Value> result) {
            HashSet<Value> inC1 = new HashSet<Value>();
            HashSet<Value> inC2 = new HashSet<Value>();
            ContainerOperations.addAll(c1, inC1);
            ContainerOperations.addAll(c2, inC2);
            addAllXor(c1, inC1, inC2, result);
            addAllXor(c2, inC1, inC2, result);
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
    private SetOperations() {
    }
    
    /**
     * Registers the defined operations.
     */
    public static void register() {
        EvaluatorRegistry.registerEvaluator(ContainerOperations.AS_SET, Set.AS_SET, Set.TO_SET);
        EvaluatorRegistry.registerEvaluator(ContainerOperations.AS_SEQUENCE, Set.AS_SEQUENCE, Set.TO_SEQUENCE);
        EvaluatorRegistry.registerEvaluator(UNION, Set.UNION);
        EvaluatorRegistry.registerEvaluator(ContainerOperations.INTERSECT, Set.INTERSECTION);
        EvaluatorRegistry.registerEvaluator(EXCLUDING, Set.EXCLUDING);
        EvaluatorRegistry.registerEvaluator(INCLUDING, Set.INCLUDING);
        EvaluatorRegistry.registerEvaluator(DIFFERENCE, Set.DIFFERENCE);
        EvaluatorRegistry.registerEvaluator(SYMMETRIC_DIFFERENCE, Set.SYMMETRIC_DIFFERENCE);
        EvaluatorRegistry.registerEvaluator(GenericOperations.EQUALS, Set.EQUALS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.ASSIGNMENT, Set.ASSIGNMENT);
        EvaluatorRegistry.registerEvaluator(ContainerOperations.ADD, Set.ADD);
        EvaluatorRegistry.registerEvaluator(new ContainerOperations.FlattenOperationEvaluator(false), Set.FLATTEN);
    }
    
    /**
     * Adds all elements in <code>cont</code> to <code>result</code>.
     * 
     * @param cont the source of the elements
     * @param result the target (to be modified as a side effect)
     * @param done all elements considered so far
     */
    private static final void addAll(ContainerValue cont, List<Value> result, HashSet<Value> done) {
        for (int i = 0; i < cont.getElementSize(); i++) {
            Value elt = cont.getElement(i);
            if (!done.contains(elt)) {
                result.add(elt);
                done.add(elt);
            }
        }
    }

    /**
     * Adds all elements from <code>cont</code> to <code>result</code> if the individual
     * elements are either in <code>set1</code> or in <code>set2</code>.
     * 
     * @param cont the container to take the values from
     * @param set1 the first set
     * @param set2 the second set
     * @param result the resulting elements
     */
    private static void addAllXor(ContainerValue cont, HashSet<Value> set1, HashSet<Value> set2, List<Value> result)  {
        for (int e = 0; e < cont.getElementSize(); e++) {
            Value val = cont.getElement(e);
            if (set1.contains(val) ^ set2.contains(val)) {
                result.add(val);
            }
        }
    }

}
