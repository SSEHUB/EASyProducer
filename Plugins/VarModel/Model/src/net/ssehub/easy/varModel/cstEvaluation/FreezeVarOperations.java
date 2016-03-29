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

import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.FreezeVariableType;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Implements the operations of the internal freeze variable type.
 * 
 * @author Holger Eichelberger
 */
public class FreezeVarOperations {
    
    /**
     * Implements the operation evaluator for variable names.
     * 
     * @author Holger Eichelberger
     */
    private static class NameOperationEvaluator implements IOperationEvaluator {

        private boolean qualified;

        /**
         * Creates a new name operation evaluator.
         * 
         * @param qualified whether qualified or simple names shall be returned
         */
        private NameOperationEvaluator(boolean qualified) {
            this.qualified = qualified;
        }
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            IDecisionVariable var = operand.getVariable();
            if (null != var) {
                AbstractVariable decl = var.getDeclaration();
                String name;
                if (qualified) {
                    name = decl.getQualifiedName();
                } else {
                    name = decl.getName();
                }
                try {
                    Value value = ValueFactory.createValue(StringType.TYPE, name);
                    result = ConstantAccessor.POOL.getInstance().bind(value, operand.getContext());
                } catch (ValueDoesNotMatchTypeException e) {
                    // result -> null
                }
            }
            return result;
        }
    };
    
    /**
     * Registers the defined operations.
     */
    public static final void register() {
        IOperationEvaluator tmp = new NameOperationEvaluator(false);
        EvaluatorRegistry.registerEvaluator(tmp, FreezeVariableType.NAME);
        EvaluatorRegistry.registerEvaluator(tmp, FreezeVariableType.NAME2);
        
        tmp = new NameOperationEvaluator(true);
        EvaluatorRegistry.registerEvaluator(tmp, FreezeVariableType.QNAME);
        EvaluatorRegistry.registerEvaluator(tmp, FreezeVariableType.QNAME2);
    }
    
}
