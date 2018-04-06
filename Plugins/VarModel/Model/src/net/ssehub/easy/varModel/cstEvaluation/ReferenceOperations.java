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

import net.ssehub.easy.varModel.model.datatypes.Reference;

/**
 * Implements reference operations.
 * 
 * @author Holger Eichelberger
 */
public class ReferenceOperations {

    /**
     * Implements the "refBy" dereferencing operation.
     */
    static final IOperationEvaluator REF_BY = new IOperationEvaluator() {
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result;
            if (null != operand) {
                result = ConstantAccessor.POOL.getInstance().bind(operand.getDereferencedValue(), operand.getContext());
            } else {
                result = null;
            }
            return result;
        }
        
    };
    
    /**
     * Prevents external creation.
     */
    private ReferenceOperations() {
    }
    
    /**
     * Registers the defined operations.
     */
    public static final void register() {
        EvaluatorRegistry.registerEvaluator(GenericOperations.TYPE_OF, Reference.TYPE_OF);
        EvaluatorRegistry.registerEvaluator(GenericOperations.EQUALS, Reference.EQUALS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.UNEQUALS, Reference.UNEQUALS, Reference.UNEQUALS_ALIAS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.ASSIGNMENT, Reference.ASSIGNMENT);
        EvaluatorRegistry.registerEvaluator(GenericOperations.IS_DEFINED, Reference.IS_DEFINED);
        EvaluatorRegistry.registerEvaluator(REF_BY, Reference.REF_BY);
    }

}
