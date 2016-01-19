/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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

import java.util.Set;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.rewrite.RewriteContext;

/**
 * Removes constraint out of compounds, pointing to only frozen and constant elements.
 * @author El-Sharkawy
 *
 */
public class FrozenCompoundConstraintsOmitter extends AbstractFrozenChecker<Compound> {

    /**
     * Single constructor for this class.
     * @param config The configuration is needed to check whether all variables used in a constraint are really frozen.
     */
    public FrozenCompoundConstraintsOmitter(Configuration config) {
        super(config);
    }

    @Override
    public Class<? extends ContainableModelElement> getModifyingModelClass() {
        return Compound.class;
    }

    @Override
    public ContainableModelElement handleModelElement(ContainableModelElement element, RewriteContext context) {
        Compound cType = (Compound) element;
        int nConstraints = cType.getConstraintsCount();
        // Compound must only be rewritten if it has at least one constraint
        if (nConstraints > 0) {
            Set<IDecisionVariable> instances = context.getInstancesForType(getConfioguration(), cType);
            boolean cmpNeverInstantiated = instances.isEmpty();
            // Avoid IndexOutOfBoundsException through iteration/deletion in reversed order
            for (int i = nConstraints - 1; i >= 0; i--) {
                Constraint internalConstraint = cType.getConstraint(i);
                if (cmpNeverInstantiated) {
                    // If compound is never used remove all constraints
                    cType.removeConstraint(internalConstraint);
                } else if (constraintIsFrozen(internalConstraint.getConsSyntax(), context)) {
                    /*
                     * Compound was used at least one time,
                     * check whether current constraint must still be verified
                     * or whether all used variables are already frozen.
                     * If check is true -> remove current constraint
                     */
                    cType.removeConstraint(internalConstraint);
                }
            }
        }
        
        return cType;
    }
}
