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
package de.uni_hildesheim.sse.model.varModel.filter.mandatoryVars;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * Stores information whether an {@link IDecisionVariable} is mandatory or not.
 * @author El-Sharkawy
 *
 */
class VariableImportance {

    private IDecisionVariable var;
    private Importance importance;
    
    /**
     * Single constructor for this class.
     * @param var The {@link IDecisionVariable} for which this information s stored.
     */
    VariableImportance(IDecisionVariable var) {
        this.var = var;
        importance = Importance.UNCLAER;
    }
    
    /**
     * Sets the {@link Importance}s for the wrapped {@link IDecisionVariable}.
     * Note a variable marked as {@link Importance#OPTIONAL} can not be changed to mandatory anymore.
     * @param importance The {@link Importance} of the variable.
     */
    void setImportance(Importance importance) {
        if (Importance.OPTIONAL != this.importance) {
            this.importance = importance;
        }
    }
    
    /**
     * Returns whether the variable is mandatory. 
     * @return <tt>true</tt> The user should enter a value for this variable, <tt>false</tt> otherwise.
     */
    boolean isMandatory() {
        return Importance.MANDATORY == importance;
    }
}
