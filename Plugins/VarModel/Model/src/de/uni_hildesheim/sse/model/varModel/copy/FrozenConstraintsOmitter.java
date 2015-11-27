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
package de.uni_hildesheim.sse.model.varModel.copy;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.filter.DeclrationInConstraintFinder;

/**
 * A {@link IModelCopyModifier} to filter constraints, containing only frozen variables and constants.
 * @author El-Sharkawy
 *
 */
public class FrozenConstraintsOmitter implements IModelCopyModifier<Constraint> {

    private Set<IFreezable> frozenElements;
    
    /**
     * Default constructor for this class.
     * @param frozenElements A list of already frozen variables (also of imported projects).
     * @see de.uni_hildesheim.sse.model.varModel.filter.FrozenElementsFinder
     */
    public FrozenConstraintsOmitter(Collection<IFreezable> frozenElements) {
        this.frozenElements = new HashSet<IFreezable>(frozenElements);
    }
    
    @Override
    public Class<? extends ContainableModelElement> getModifyingModelClass() {
        return Constraint.class;
    }

    @Override
    public ContainableModelElement handleModelElement(ContainableModelElement element) {
        Constraint constraint = (Constraint) element;
        DeclrationInConstraintFinder finder = new DeclrationInConstraintFinder(constraint.getConsSyntax());
        Set<AbstractVariable> vars = finder.getDeclarations();
        boolean containsOnlyFrozen = vars.isEmpty();
        
        if (!containsOnlyFrozen) {
            containsOnlyFrozen = true;
            Iterator<AbstractVariable> itr = vars.iterator();
            while (containsOnlyFrozen && itr.hasNext()) {
                AbstractVariable declaration = itr.next();
                containsOnlyFrozen = frozenElements.contains(declaration);
            }
        }
        
        
        if (containsOnlyFrozen) {
            constraint = null;
        }
        return constraint;
    }
    
    

}
