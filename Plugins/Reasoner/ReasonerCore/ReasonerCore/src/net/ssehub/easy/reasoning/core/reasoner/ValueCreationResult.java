/*
 * Copyright 2009-2020 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.core.reasoner;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Denotes the result of creating a value of an IVML variable through the reasoner considering 
 * the relevant constraints.
 * 
 * @author Holger Eichelberger
 */
public class ValueCreationResult extends ReasoningResult {
    
    private IDecisionVariable var;
    
    /**
     * Creates a value creation result.
     * 
     * @param var the decision variable holding the created value (may be <b>null</b> in case of errors, 
     *     use {@link #addMessage(Message)})
     */
    public ValueCreationResult(IDecisionVariable var) {
        this.var = var;
    }

    /**
     * Returns the created value.
     * 
     * @return the created value (may be <b>null</b> in case of errors, use {@link #addMessage(Message)})
     */
    public Value getValue() {
        return null == var ? null : var.getValue();
    }
    
    /**
     * Returns the holding variable.
     * 
     * @return the holding variable (may be <b>null</b> in case of errors, use {@link #addMessage(Message)})
     */
    public IDecisionVariable getVariable() {
        return var;
    }

}
