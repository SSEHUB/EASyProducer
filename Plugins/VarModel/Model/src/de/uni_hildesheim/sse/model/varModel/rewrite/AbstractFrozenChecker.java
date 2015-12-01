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
package de.uni_hildesheim.sse.model.varModel.rewrite;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IAssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;

/**
 * Super class for Filters which should remove elements based on already frozen variables.
 * @author El-Sharkawy
 *
 * @param <M> Type of {@link ContainableModelElement}s, which shall be handled by this class.
 */
public abstract class AbstractFrozenChecker<M extends ContainableModelElement> implements IModelCopyModifier<M> {

    private Configuration config;
    
    /**
     * Single constructor of this class.
     * @param config A already initialized {@link Configuration}, needed for checking whether an arbitrary variable is
     * already frozen.
     */
    protected AbstractFrozenChecker(Configuration config) {
        this.config = config;
    }

    /**
     * Checks whether the given declaration is already frozen.
     * @param declaration A declaration to test.
     * @return <tt>true</tt> if the declaration is clearly frozen, <tt>false</tt> otherwise.
     */
    protected boolean isFrozen(AbstractVariable declaration) {
        boolean isFrozen = false;
        IDecisionVariable configVar = config.getDecision(declaration);
        if (null != configVar && null != configVar.getState()) {
            IAssignmentState state = configVar.getState();
            isFrozen = AssignmentState.FROZEN == state;
        }

        return isFrozen;
    }
}
