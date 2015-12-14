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

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.filter.DeclrationInConstraintFinder;
import de.uni_hildesheim.sse.model.varModel.rewrite.RewriteContext;

/**
 * A {@link IModelElementFilter} to filter constraints, containing only frozen variables and constants.
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
        DeclrationInConstraintFinder finder = new DeclrationInConstraintFinder(constraint.getConsSyntax());
        Set<AbstractVariable> vars = finder.getDeclarations();
        boolean containsOnlyFrozen = vars.isEmpty();
        
        if (!containsOnlyFrozen) {
            containsOnlyFrozen = true;
            Iterator<AbstractVariable> itr = vars.iterator();
            while (containsOnlyFrozen && itr.hasNext()) {
                AbstractVariable declaration = itr.next();
                containsOnlyFrozen = isFrozen(declaration);
            }
        }
        
        if (containsOnlyFrozen) {
            constraint = null;
        }
        return constraint;
    }
}
