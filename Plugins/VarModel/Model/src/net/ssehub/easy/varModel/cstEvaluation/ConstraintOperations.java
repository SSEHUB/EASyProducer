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

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.ConstraintValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Implements constraint operations. Actually, constraint euqlas and 
 * 
 * @author Holger Eichelberger
 */
public class ConstraintOperations {
    
    /**
     * Prevents external creation.
     */
    private ConstraintOperations() {
    }

    /**
     * Handles a constraint assignment, i.e., assigns the <code>cst</code>.
     * 
     * @param operand the operand to assign the constraint to
     * @param cst the value as constraint syntax tree
     * @return the expression return result
     */
    static EvaluationAccessor handleConstraintAssignment(EvaluationAccessor operand, ConstraintSyntaxTree cst) {
        EvaluationAccessor result;
        try {
            operand.setValue(ValueFactory.createValue(ConstraintType.TYPE, cst), true);
            result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.TRUE, operand.getContext());
        } catch (ValueDoesNotMatchTypeException e) {
            operand.getContext().addErrorMessage(e);
            result = null;
        }
        return result;
    }

    /**
     * Handles a constraint equality with propagation, i.e., assigns the <code>cst</code>.
     * 
     * @param operand the operand to assign the constraint to
     * @param cst the value as constraint syntax tree
     * @param negate negate the result (equals or not-equals)
     * @return the expression return result
     */
    static EvaluationAccessor handleConstraintEquals(EvaluationAccessor operand, ConstraintSyntaxTree cst, 
        boolean negate) {
        EvaluationAccessor result;
        if (!operand.isAssigned() && operand.isAssignable()) {
            if (!negate) {
                result = handleConstraintAssignment(operand, cst);
            } else {
                result = null;
            }
        } 
        Value oValue = operand.getValue();
        if (oValue instanceof ConstraintValue) {
            boolean equals = ((ConstraintValue) oValue).getValue().equals(cst);
            if (negate) {
                equals = !equals;
            }
            result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.toBooleanValue(equals), 
                operand.getContext());
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Registers the defined operations.
     */
    public static final void register() {
        EvaluatorRegistry.registerEvaluator(GenericOperations.TYPE_OF, ConstraintType.TYPE_OF);
        EvaluatorRegistry.registerEvaluator(GenericOperations.EQUALS, ConstraintType.EQUALS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.UNEQUALS, 
            ConstraintType.UNEQUALS, ConstraintType.UNEQUALS_ALIAS);
        EvaluatorRegistry.registerEvaluator(GenericOperations.ASSIGNMENT, ConstraintType.ASSIGNMENT);
        EvaluatorRegistry.registerEvaluator(GenericOperations.IS_DEFINED, ConstraintType.IS_DEFINED);
    }

}
