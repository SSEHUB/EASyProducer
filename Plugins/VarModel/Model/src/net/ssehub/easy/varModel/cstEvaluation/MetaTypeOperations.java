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

import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.values.MetaTypeValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Implements the meta type operations.
 * 
 * @author Holger Eichelberger
 */
public class MetaTypeOperations {

    /**
     * Implements the all instances operation.
     */
    static final IOperationEvaluator ALL_INSTANCES = new IOperationEvaluator() {
        
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value val = operand.getValue();
            if (val instanceof MetaTypeValue) {
                MetaTypeValue mtVal = (MetaTypeValue) val;
                Value resVal = operand.getContext().getAllInstances(mtVal.getValue());
                result = ConstantAccessor.POOL.getInstance().bind(resVal, operand.getContext());
            }
            return result; 
        }
    };
    
    /**
     * Prevents external creation.
     */
    private MetaTypeOperations() {
    }
    
    /**
     * Registers the defined operations.
     */
    public static final void register() {
        EvaluatorRegistry.registerEvaluator(GenericOperations.EQUALS, MetaType.EQUALS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.UNEQUALS, MetaType.NOTEQUALS);
        EvaluatorRegistry.registerEvaluator(ALL_INSTANCES, MetaType.ALL_INSTANCES);
    }
    
}
