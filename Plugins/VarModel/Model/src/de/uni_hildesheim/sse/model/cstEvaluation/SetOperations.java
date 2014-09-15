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

import java.util.HashSet;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;

import static de.uni_hildesheim.sse.model.cstEvaluation.ContainerOperations.*;

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
     * Implements the "excluding" operation.
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
        EvaluatorRegistry.registerEvaluator(ContainerOperations.AS_SET, Set.AS_SET);
        EvaluatorRegistry.registerEvaluator(ContainerOperations.AS_SEQUENCE, Set.AS_SEQUENCE);
        EvaluatorRegistry.registerEvaluator(UNION, Set.UNION);
        EvaluatorRegistry.registerEvaluator(ContainerOperations.INTERSECT, Set.INTERSECTION);
        EvaluatorRegistry.registerEvaluator(EXCLUDING, Set.EXCLUDING);
        EvaluatorRegistry.registerEvaluator(INCLUDING, Set.INCLUDING);
        EvaluatorRegistry.registerEvaluator(GenericOperations.EQUALS, Set.EQUALS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.ASSIGNMENT, Set.ASSIGNMENT);
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

}
