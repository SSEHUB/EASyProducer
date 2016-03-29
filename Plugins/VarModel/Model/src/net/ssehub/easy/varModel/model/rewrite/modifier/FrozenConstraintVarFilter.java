/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.model.rewrite.modifier;

import java.util.Iterator;
import java.util.Set;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.rewrite.RewriteContext;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.ConstraintValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Removes frozen {@link ConstraintType} variables if they are only pointing to frozen variable.
 * @author El-Sharkawy
 *
 */
public class FrozenConstraintVarFilter extends AbstractFrozenChecker<DecisionVariableDeclaration> {

    /**
     * Default constructor of this class.
     * @param config A already initialized {@link Configuration}, needed for checking whether an arbitrary variable is
     * already frozen.
     */
    public FrozenConstraintVarFilter(Configuration config) {
        super(config);
    }

    @Override
    public Class<? extends ContainableModelElement> getModifyingModelClass() {
        return DecisionVariableDeclaration.class;
    }

    @Override
    public ContainableModelElement handleModelElement(ContainableModelElement element, RewriteContext context) {
        DecisionVariableDeclaration declaration = (DecisionVariableDeclaration) element;
        if (declaration.getType() == ConstraintType.TYPE) {
            Set<IDecisionVariable> instances = context.getInstancesForDeclaration(getConfiguration(), declaration);
            boolean allFrozen = true;
            if (instances != null && !instances.isEmpty()) {
                Iterator<IDecisionVariable> varItr = instances.iterator();
                while (varItr.hasNext() && allFrozen) {
                    IDecisionVariable constraintVar = varItr.next();
                    allFrozen = (constraintVar.getState() == AssignmentState.FROZEN);
                    if (allFrozen) {
                        Value value = constraintVar.getValue();
                        if (value instanceof ConstraintValue) {
                            ConstraintValue constraintValue = (ConstraintValue) value;
                            allFrozen = constraintIsFrozen(constraintValue.getValue(), context);
                        } else if (null != value && !(value instanceof BooleanValue)) {
                            // Unknown situation -> abort
                            allFrozen = false;
                        }
                        // If BooleanValue, value is constant -> keep allFrozen state
                    }
                }
            }
            // Else: allFrozen = true
            
            if (allFrozen) {
                declaration = null;
            }
        }
        return declaration;
    }

}
