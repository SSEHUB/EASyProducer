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
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.rewrite.RewriteContext;

/**
 * Checks whether all instances of a given {@link DerivedDatatype} are frozen and will remove all constraints,
 * if all instances are frozen or if none exist.
 * @author El-Sharkawy
 *
 */
public class FrozenTypeDefResolver extends AbstractFrozenChecker<DerivedDatatype> {

    /**
     * Default constructor of this class.
     * @param config A already initialized {@link Configuration}.
     */
    public FrozenTypeDefResolver(Configuration config) {
        super(config);
    }
    
    @Override
    public Class<? extends ContainableModelElement> getModifyingModelClass() {
        return DerivedDatatype.class;
    }

    @Override
    public ContainableModelElement handleModelElement(ContainableModelElement element, RewriteContext context) {
        DerivedDatatype dType = (DerivedDatatype) element;
        boolean allFrozen = true;
        
        // 1st: Check whether all instances are frozen
        Set<IDecisionVariable> instances = context.getInstancesForType(getConfioguration(), dType);
        if (null != instances && !instances.isEmpty()) {
            Iterator<IDecisionVariable> varItr = instances.iterator();
            while (varItr.hasNext() && allFrozen) {
                IDecisionVariable usedInstance = varItr.next();
                allFrozen = (AssignmentState.FROZEN == usedInstance.getState());
            }
        } // Else: allFrozen = true
        
        // 2nd: ChecK whether variables of used Typedef are frozen
        for (int i = 0, n = dType.getConstraintCount(); i < n && allFrozen; i++) {
            Constraint constraint = dType.getConstraint(i);
            allFrozen = constraintIsFrozen(constraint.getConsSyntax(), context);
        }
        
        if (allFrozen) {
            dType.setConstraints(null);
        }
        return dType;
    }
}
