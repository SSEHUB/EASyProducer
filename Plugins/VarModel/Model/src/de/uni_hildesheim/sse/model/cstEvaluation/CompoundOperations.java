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

import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;

/**
 * Implements compound operations.
 * 
 * @author Holger Eichelberger
 */
public class CompoundOperations {

    /**
     * Prevents external creation.
     */
    private CompoundOperations() {
    }
    
    /**
     * Registers the defined operations.
     */
    public static final void register() {
        EvaluatorRegistry.registerEvaluator(GenericOperations.TYPE_OF, Compound.TYPE_OF);
        EvaluatorRegistry.registerEvaluator(GenericOperations.EQUALS, Compound.EQUALS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.UNEQUALS, Compound.NOTEQUALS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.ASSIGNMENT, Compound.ASSIGNMENT);
        EvaluatorRegistry.registerEvaluator(GenericOperations.IS_DEFINED, Compound.IS_DEFINED);
    }
    
}
