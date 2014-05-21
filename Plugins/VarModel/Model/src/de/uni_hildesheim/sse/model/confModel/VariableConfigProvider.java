package de.uni_hildesheim.sse.model.confModel;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.values.Value;

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
     * Causes to freeze the current value (cannot be undone).
     */
    protected final void freeze() {
        if (null != getValue() && getValue().isConfigured() && isStateChangeAllowed()) {
            try {
                setState(AssignmentState.FROZEN);
            } catch (ConfigurationException e) {
                // Not needed: This exception only occurs if the variable is already frozen
            }
        }
    }
    
    /**
     * Specifies whether the related {@link IDecisionVariable} can have its own {@link IAssignmentState}.
     * In case of a nested {@link IDecisionVariable} of a {@link StructuredVariable}, this is not supported.
     * @return <tt>true</tt> if the related {@link IDecisionVariable} can have  its own {@link IAssignmentState},
     *     otherwise <tt>false</tt>.
     */
    protected abstract boolean isStateChangeAllowed();   
    
    /**
     * Setter for the {@link IAssignmentState}, needed by {@link CompoundVariable}s.
     * @param state The new {@link IAssignmentState}, which should be set.
     * @throws ConfigurationException Occurs if this variable is already frozen
     * and the new {@link IAssignmentState} is not equal.
     */
    protected abstract void setState(IAssignmentState state) throws ConfigurationException;
    
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
