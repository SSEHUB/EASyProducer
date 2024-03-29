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
package net.ssehub.easy.varModel.cstEvaluation;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;

/**
 * Informs interested parties about the resolution of a variable to a decision variable.
 * 
 * @author Holger Eichelberger
 */
public interface IResolutionListener {
    
    /**
     * Is called to notify about the resolution of the declaration <code>decl</code> to the actual variable
     * <code>var</code>.
     * 
     * @param declaration the declaration
     * @param resolved the resolved decision variable
     */
    public void notifyResolved(AbstractVariable declaration, IDecisionVariable resolved);

    /**
     * Is called to notify about the resolution of the compound slot <code>slotName</code> in <code>compound</code> to 
     * <code>var</code>.
     *  
     * @param compound the compound variable
     * @param slotName the slot to be resolved
     * @param resolved the resolved slot variable
     */
    public void notifyResolved(IDecisionVariable compound, String slotName, IDecisionVariable resolved);
    
    /**
     * Is called when a local variable is created as part of container operation evaluation or let-evaluation.
     *  
     * @param var the created variable
     */
    public void localVariableCreated(LocalDecisionVariable var);

    /**
     * Is called when a local variable is disposed as part of container operation evaluation or let-evaluation.
     *  
     * @param var the disposed variable
     */
    public void localVariableDisposed(LocalDecisionVariable var);
    
}
