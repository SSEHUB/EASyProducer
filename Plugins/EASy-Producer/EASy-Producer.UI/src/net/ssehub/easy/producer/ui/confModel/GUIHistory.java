package net.ssehub.easy.producer.ui.confModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.NullValue;


/**
 * Stores values entered via the GUI until they are saved permanently.
 * @author Sass
 *
 */
public class GUIHistory {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(GUIHistory.class, Bundle.ID);
    
    private List<GUIHistoryItem> assignmentHistory;
    
    /**
     * Sole constructor for this class to create a new Assignment history.
     */
    public GUIHistory() {
        assignmentHistory = new ArrayList<GUIHistoryItem>();
    }
    
    /**
     * Stores a new value into this {@link GUIHistory}.
     * 
     * @param variable The variable for which the history shall be created.
     */
    void assignValue(IDecisionVariable variable) {
        GUIHistoryItem item = null;
        if (variable.getValue() instanceof NullValue) {
            item = new GUIHistoryItem(NullValue.INSTANCE, variable.getState(), variable, System.currentTimeMillis());
        } else if (variable.getDeclaration().getType() instanceof Container) {
            ContainerValue copiedValue = null;
            if (variable.getValue() != null) {
                copiedValue = (ContainerValue) variable.getValue().clone();
            }
            item = new GUIHistoryItem(copiedValue, variable.getState(), variable, System.currentTimeMillis());
        } else if (variable.getDeclaration().getType().isAssignableFrom(Compound.TYPE)) {
            CompoundValue copiedValue = (CompoundValue) variable.getValue().clone();
            item = new GUIHistoryItem(copiedValue, variable.getState(), variable, System.currentTimeMillis());
            
            for (int i = 0; i < variable.getNestedElementsCount(); i++) {
                IDecisionVariable nested = variable.getNestedElement(i);
                LOGGER.debug(nested + "; " + nested.getState());
            }
        } else {
            item = new GUIHistoryItem(variable.getValue(), variable.getState(), variable, System.currentTimeMillis());
        }
        if (item != null) {
            assignmentHistory.add(item);
            LOGGER.debug("Variable stored in history: " + item.getVariable() + " " + item.getState() 
                    + " Last edited: " + item.getLastEdited());
        }
    }
    
    /**
     * Returns the latest inserted {@link GUIHistoryItem}.
     * 
     * @return The latest inserted {@link GUIHistoryItem} or <code>null</code> if nothing was inserted yet.
     */
    public GUIHistoryItem getLastHistoryItem() {
        GUIHistoryItem lastHistoryItem = null;
        if (!assignmentHistory.isEmpty()) {
            lastHistoryItem = assignmentHistory.get(assignmentHistory.size() - 1);
            assignmentHistory.remove(lastHistoryItem);
        }
        return lastHistoryItem;
    }

    /**
     * Returns the the time of the last edited {@link GUIHistoryItem}.
     * 
     * @return The time of the last edited {@link GUIHistoryItem} as Long (System.currentTimeMillis());
     */
    public Long getLastEdited() {
        List<GUIHistoryItem> sortedAssignmentHistory = assignmentHistory;
        Collections.sort(sortedAssignmentHistory);
        Long lastEdited = new Long(-1);
        if (!sortedAssignmentHistory.isEmpty()) {
            lastEdited = sortedAssignmentHistory.get(sortedAssignmentHistory.size() - 1).getLastEdited();
        }
        return lastEdited;
    }
    
}
