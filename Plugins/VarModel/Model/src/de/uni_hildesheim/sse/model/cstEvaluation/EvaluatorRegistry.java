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

import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.model.varModel.datatypes.Operation;

/**
 * Allows to register, query and unregister evaluators for IVML operations.
 * 
 * @author Holger Eichelberger
 */
public class EvaluatorRegistry {
    
    // TODO complete this, currently just used to calculate some additional values in Saschas mechanism

    private static final Map<Operation, IOperationEvaluator> OP_EVALUATORS 
        = new HashMap<Operation, IOperationEvaluator>();
    private static final Map<Operation, IIteratorEvaluator> ITER_EVALUATORS 
        = new HashMap<Operation, IIteratorEvaluator>();

    /**
     * Registers an evaluator (but only if <code>evaluator</code> is not <b>null</b>).
     * 
     * @param evaluator the evaluator for <code>operation</code> 
     * @param operations the operation the <code>evaluator</code> shall be registered for
     */
    public static void registerEvaluator(IOperationEvaluator evaluator, Operation... operations) {
        if (null != evaluator) {
            for (int o = 0; o < operations.length; o++) {
                OP_EVALUATORS.put(operations[o], evaluator);
            }
        }
    }
    
    /**
     * Registers an evaluator (but only if <code>evaluator</code> is not <b>null</b>).
     * 
     * @param evaluator the evaluator for <code>operation</code> 
     * @param operations the operation the <code>evaluator</code> shall be registered for
     */
    public static void registerEvaluator(IIteratorEvaluator evaluator, Operation... operations) {
        if (null != evaluator) {
            for (int o = 0; o < operations.length; o++) {
                ITER_EVALUATORS.put(operations[o], evaluator);
            }
        }
    }
    
    /**
     * Returns the registered operation evaluator for the given operation.
     * 
     * @param operation the operation to return the evaluator for
     * @return the operation evaluator
     */
    public static IOperationEvaluator getOperationEvaluator(Operation operation) {
        return OP_EVALUATORS.get(operation);
    }

    /**
     * Returns the registered iterator evaluator for the given operation.
     * 
     * @param operation the operation to return the evaluator for
     * @return the operation iterator evaluator
     */
    public static IIteratorEvaluator getIteratorEvaluator(Operation operation) {
        return ITER_EVALUATORS.get(operation);
    }
    
    // register the default evaluators
    static {
        GenericOperations.register(); // AnyType
        MetaTypeOperations.register();
        
        BooleanOperations.register();
        RealOperations.register();
        IntegerOperations.register();
        StringOperations.register();
        GenericNumberOperations.register();

        ReferenceOperations.register();
        ConstraintOperations.register();
        EnumOperations.register();

        CompoundOperations.register();
        ContainerOperations.register();
        SetOperations.register();
        SequenceOperations.register();
    }

}
