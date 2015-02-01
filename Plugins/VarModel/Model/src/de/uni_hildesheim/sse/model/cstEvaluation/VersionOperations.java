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

import de.uni_hildesheim.sse.model.varModel.datatypes.VersionType;
import de.uni_hildesheim.sse.model.varModel.values.BooleanValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.VersionValue;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * Implements version operations.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class VersionOperations {

    /**
     * A version evaluation result validator. Turns the evaluation result into a boolean value.
     * 
     * @author Holger Eichelberger
     */
    private interface IVersionResultConverter {
        
        /**
         * Converts the evaluation result (-1, 0, +1) into a boolean value.
         * 
         * @param value the value to be converted
         * @return the result of the (total) operation
         */
        public boolean convert(int value);
    }
    
    /**
     * Evaluates a version operation.
     * 
     * @author Holger Eichelberger
     */
    private static final class VersionEvaluator implements IOperationEvaluator {

        private IVersionResultConverter converter;

        /**
         * Creates a version evaluator based on the given converter.
         * 
         * @param converter the result converter to be used
         */
        private VersionEvaluator(IVersionResultConverter converter) {
            this.converter = converter;
        }
        
        @Override
        public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments) {
            EvaluationAccessor result = null;
            Value oValue = operand.getValue();
            if (oValue instanceof VersionValue && 1 == arguments.length) {
                Value aValue = arguments[0].getValue();
                if (aValue instanceof VersionValue) {
                    BooleanValue tmp = BooleanValue.toBooleanValue(converter.convert(
                        Version.compare(((VersionValue) oValue).getValue(), ((VersionValue) aValue).getValue())));
                    result = ConstantAccessor.POOL.getInstance().bind(tmp, operand.getContext());                    
                }
            }
            return result;
        }
    };
    
    
    /**
     * Prevents external creation.
     */
    private VersionOperations() {
    }
    
    /**
     * Registers the defined operations.
     */
    public static final void register() {
        // same (underlying) implementation as in VIL
        EvaluatorRegistry.registerEvaluator(new VersionEvaluator(new IVersionResultConverter() {

            public boolean convert(int value) {
                return 0 == value;
            }
            
        }), VersionType.EQUALS);
        EvaluatorRegistry.registerEvaluator(new VersionEvaluator(new IVersionResultConverter() {

            public boolean convert(int value) {
                return 0 != value;
            }
            
        }), VersionType.UNEQUALS);
        EvaluatorRegistry.registerEvaluator(new VersionEvaluator(new IVersionResultConverter() {

            public boolean convert(int value) {
                return value < 0;
            }
            
        }), VersionType.LESS);
        EvaluatorRegistry.registerEvaluator(new VersionEvaluator(new IVersionResultConverter() {

            public boolean convert(int value) {
                return value <= 0;
            }
            
        }), VersionType.LESS_EQUALS);
        EvaluatorRegistry.registerEvaluator(new VersionEvaluator(new IVersionResultConverter() {

            public boolean convert(int value) {
                return value > 0;
            }
            
        }), VersionType.GREATER);
        EvaluatorRegistry.registerEvaluator(new VersionEvaluator(new IVersionResultConverter() {

            public boolean convert(int value) {
                return value >= 0;
            }
            
        }), VersionType.GREATER_EQUALS);
    }

}
