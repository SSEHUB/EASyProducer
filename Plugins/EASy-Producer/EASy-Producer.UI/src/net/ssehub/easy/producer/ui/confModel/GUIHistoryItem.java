package net.ssehub.easy.producer.ui.confModel;

import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Stores one value entered via the GUI until they are saved permanently.
 * @author Sass
 */
public class GUIHistoryItem implements Comparable<GUIHistoryItem> {
    
    private Value value;
    private IAssignmentState state;
    private IDecisionVariable variable;
    private Long lastEdited;
    
    /**
     * Sole constructor for this class.
     * This constructor defines a new value assignment.
     * @param value The value which shall be saved.
     * @param state The assignment state which shall be saved.
     * @param variable The variable which shall be saved.
     * @param lastEdited Time in milliseconds
     */
    GUIHistoryItem(Value value, IAssignmentState state, IDecisionVariable variable, Long lastEdited) {
        this.value = value;
        this.state = state;
        this.variable = variable;
        this.lastEdited = lastEdited;
    }

    /**
     * Getter for the value.
     * @return the value (must not be <code>null</code>).
     */
    public Value getValue() {
        return value;
    }

    /**
     * Getter for the assignment state.
     * @return the state (must not be <code>null</code>).
     */
    public IAssignmentState getState() {
        return state;
    }

    /**
     * Getter for the variable. 
     * @return the variable (must not be <code>null</code>).
     */
    public IDecisionVariable getVariable() {
        return variable;
    }
    
    /**
     * Getter for the last edited value.
     * @return last Edited in Milliseconds
     */
    public Long getLastEdited() {
        return lastEdited;
    }

    @Override
    public int compareTo(GUIHistoryItem historyItem) {
        return this.getLastEdited().compareTo(historyItem.getLastEdited());
    }
}
