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
package de.uni_hildesheim.sse.model.varModel.rewrite.modifier;

import java.util.Iterator;
import java.util.Set;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.rewrite.RewriteContext;
import de.uni_hildesheim.sse.model.varModel.values.ConstraintValue;

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
            Set<IDecisionVariable> instances = context.getInstancesForDeclaration(getConfioguration(), declaration);
            boolean allFrozen = true;
            if (instances != null && !instances.isEmpty()) {
                Iterator<IDecisionVariable> varItr = instances.iterator();
                while (varItr.hasNext() && allFrozen) {
                    IDecisionVariable constraintVar = varItr.next();
                    allFrozen = (constraintVar.getState() == AssignmentState.FROZEN);
                    if (allFrozen) {
                        ConstraintValue constraintValue = (ConstraintValue) constraintVar.getValue();
                        allFrozen = constraintIsFrozen(constraintValue.getValue(), context); 
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
