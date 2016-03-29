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
package net.ssehub.easy.varModel.model.rewrite.modifier;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.rewrite.RewriteContext;

/**
 * A {@link IModelElementFilter} to filter constraints, containing only frozen variables and constants.
 * Assignment constraints won't be filtered (to keepm the frozen configuration).
 * @author El-Sharkawy
 *
 */
public class FrozenConstraintsFilter extends AbstractFrozenChecker<Constraint> {

    /**
     * Default Constructor if a {@link Configuration} is available containing already derived and propagated variables.
     * @param config A already initialized {@link Configuration}.
     */
    public FrozenConstraintsFilter(Configuration config) {
        super(config);
    }
    
    @Override
    public Class<? extends ContainableModelElement> getModifyingModelClass() {
        return Constraint.class;
    }

    @Override
    public ContainableModelElement handleModelElement(ContainableModelElement element, RewriteContext context) {
        Constraint constraint = (Constraint) element;
        ConstraintSyntaxTree cst = constraint.getConsSyntax();
        if (null != cst) {
            if (!(cst instanceof OCLFeatureCall
                && OclKeyWords.ASSIGNMENT.equals(((OCLFeatureCall) cst).getOperation()))
                && constraintIsFrozen(cst, context)) {
                
                // Constraint must not be an assignment and should only contain frozen elements or constant values
                constraint = null;
            }
        } else {
            // Empty constraint will be filtered
            constraint = null;
        }
        return constraint;
    }
}
