/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.confModel;

import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Delegate for handling the value and state of a {@link IDecisionVariable}.
 * This provider returns an own value and state for the associated {@link IDecisionVariable}.
 * The value of this provider can be a nested value of a structured variable or an own value
 * of a top level variable.
 * 
 * @author El-Sharkawy
 *
 */
abstract class VariableConfigProvider {   
    
    /**
     * Returns the current value of this {@link IDecisionVariable}.
     * 
     * @return the value (may be <b>null</b>)
     */
    protected abstract Value getValue();

    /**
     * Changes the value (for incremental buildup).
     * 
     * @param value the value (may be <b>null</b> for incremental buildup)
     * @param state the related assignment state
     * @throws ConfigurationException in case that the types of 
     *   {@link #getDeclaration()} and <code>value</code> do not comply
     */
    protected abstract void setValue(Value value, IAssignmentState state) throws ConfigurationException;
    
    /**
     * Changes the value from value history.
     * 
     * @param value the value (may be <b>null</b> for incremental buildup)
     * @param state the related assignment state
     * @throws ConfigurationException in case that the types of 
     *   {@link #getDeclaration()} and <code>value</code> do not comply
     */
    protected abstract void setHistoryValue(Value value, IAssignmentState state) throws ConfigurationException;
    
    /**
     * Returns the assignment state of this variable.
     * 
     * @return the assignment state
     */
    protected abstract IAssignmentState getState();
    
    /**
     * Causes to freeze the current value.
     * @param selector determines which parts shall be frozen
     */
    protected abstract void freeze(IFreezeSelector selector);
    
    /**
     * Causes to freeze the current value.
     */
    protected final void freeze() {
        // freeze shall also work on partially configured elements! If not configured, then VIL has to handle that.
        if (/*null != getValue() && getValue().isConfigured() && */isStateChangeAllowed()) {
            setState(AssignmentState.FROZEN);
        }
    }
    
    /**
     * Unfreezes this variable to the given <code>state</code>.
     * 
     * @param state the target state (must not be {@link AssignmentState#FROZEN})
     */
    protected final void unfreeze(IAssignmentState state) {
        //  unfreeze shall also work on partially configured elements and only change state if variable was frozen
//      if (null != getValue() && AssignmentState.FROZEN != state) {
        if (AssignmentState.FROZEN != state && AssignmentState.FROZEN == getState()) {
            setState(state);
        }
    }
    
    /**
     * Specifies whether the related {@link IDecisionVariable} can have its own {@link IAssignmentState}.
     * In case of a nested {@link IDecisionVariable} of a {@link StructuredVariable}, this is not supported.
     * @return {@code true} if the related {@link IDecisionVariable} can have  its own {@link IAssignmentState},
     *     otherwise {@code false}.
     */
    protected abstract boolean isStateChangeAllowed();   
    
    /**
     * Setter for the {@link IAssignmentState}, needed by {@link CompoundVariable}s.
     * @param state The new {@link IAssignmentState}, which should be set.
     */
    protected abstract void setState(IAssignmentState state);
    
    /**
     * Returns the declaration of the related {@link IDecisionVariable}.
     * @return {@link IDecisionVariable#getDeclaration()}.
     */
    protected abstract AbstractVariable getDeclaration();
    
    /**
     * Return the configuration containing the related {@link IDecisionVariable}.
     * @return {@link IDecisionVariable#getConfiguration()}.
     */
    protected abstract Configuration getConfiguration();
}
