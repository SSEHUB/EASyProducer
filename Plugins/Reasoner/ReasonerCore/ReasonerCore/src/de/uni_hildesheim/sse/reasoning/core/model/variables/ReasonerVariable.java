package de.uni_hildesheim.sse.reasoning.core.model.variables;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.reasoning.core.Bundle;
import de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel;
import de.uni_hildesheim.sse.reasoning.core.model.ReasoningState;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Adapter class for passing {@link IDecisionVariable}s to an
 * {@link de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner}.
 * @author El-Sharkawy
 * @author Sizonenko
 */
public abstract class ReasonerVariable {

    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(ReasonerVariable.class, Bundle.ID);
    
    private IDecisionVariable configVariable;
    private String name;
    private ReasoningState state;
    private ReasonerVariable parent;
    /**
     * Optional list of reason, which lead to a variable assignment or a conflict.
     */
    private List<Object> reasons;
    private boolean valueAssignedByReasoner;
    
    private ReasonerModel model;
    
    /**
     * Sole constructor for creating a new {@link ReasonerVariable}.
     * @param configVariable The origin {@link IDecisionVariable}, which should be wrapped into
     *     this {@link ReasonerVariable} (must not be <tt>null</tt>).
     * @param name The unique name of the {@link ReasonerVariable} inside the 
     *     {@link de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel}.
     * @param model Reasoning model of the variable.    
     * @param parent Variables container.
     */
    protected ReasonerVariable(IDecisionVariable configVariable, String name, ReasonerModel model,
            ReasonerVariable parent) {
        LOGGER.debug("");
        this.configVariable = configVariable;
        this.name = name;
        this.model = model;
        this.parent = parent;
        this.valueAssignedByReasoner = false;
        String aState = configVariable.getState().toString();
        if (null == configVariable.getValue()) {
            state = ReasoningState.UNASSIGNED;
        } else {
            state = ReasoningState.DEFAULT_SAME;
        } 
    }
//    if (null == configVariable.getValue() && AssignmentState.UNDEFINED == configVariable.getState()) {
//        state = ReasoningState.UNASSIGNED;
//    } else if (AssignmentState.FROZEN == configVariable.getState()) {
//        state = ReasoningState.FIXED;
//    } else if (AssignmentState.DEFAULT == configVariable.getState() 
//            || AssignmentState.ASSIGNED == configVariable.getState()) {
//        state = ReasoningState.DEFAULT_SAME;
//    } else {
//        state = ReasoningState.DEFAULT_DIFFERENT;
//    }
//}
    
    /**
     * Method for assigning value to the attribute that determines reasoning state.
     * @param state which should be assigned
     *     this {@link ReasonerVariable} state attribute  (must not be <tt>null</tt>).
     */
    public void setReasoningState(ReasoningState state) {
        this.state = state;
    }
 
    /**
     * Method for retrieving value of the attribute that determines reasoning state.
     * @return state The origin {@link ReasoningState}, which should be assigned
     *     this {@link ReasonerVariable} state attribute  (must not be <tt>null</tt>).
     */
    public ReasoningState getReasoningState() {
        return this.state;
    }
 
    /**
     * Method for retrieving value of the attribute that determines name.
     * @return name The origin {@link ReasoningState}, which should be assigned
     *     this {@link ReasonerVariable} name attribute  (must not be <tt>null</tt>).
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Getter for the {@link IDecisionVariable}.
     * @return The corresponding variable stored inside the {@link de.uni_hildesheim.sse.model.confModel.Configuration}.
     */
    public final IDecisionVariable getDecisionVariable() {
        return configVariable;
    }
    
    /**
     * Assigns a new value this variable (does not perform any checks).
     * @param newValue The new (already checked value) for this variable.
     */
    protected abstract void assignValue(Object newValue);
    
    /**
     * Checks whether the newValue is the same value as the current stored value.
     * @param newValue The new Value, which should be set/checked.
     * @return <tt>true</tt> if the value is same as the current set value, <tt>false</tt> otherwise.
     */
    protected abstract boolean isSameValue(Object newValue);
    
    /**
     * Checks whether the newValue could be assigned to this variable and sets the value (and state).
     * @param newValue The new Value which should be assigned to this variable.
     * @return operationResult Returns <tt>true</tt> if value assignment was successful.
     */
    public final boolean setValue(Object newValue) {
        LOGGER.debug("Start: " + getName() + " : " + getValue() + " : " + getReasoningState());
        boolean operationResult = true;
        // Rule (a) and (b)
        if (ReasoningState.UNASSIGNED == state || ReasoningState.DEFAULT_DIFFERENT == state) {
            if (newValue != null) {
                assignValue(newValue);
                state = ReasoningState.DEFAULT_SAME;
                valueAssignedByReasoner = true;
                model.variableChanged(this);
                LOGGER.debug("Value assigned");
            }            
        } else if (!isSameValue(newValue)) {
            state = ReasoningState.CONFLICT;
            operationResult = false;
            LOGGER.debug("Conflict assignment");
        }
        LOGGER.debug("Finish: " + getName() + " : " + getValue() + " : " + getReasoningState());
        return operationResult;
    }   
    
    /**
     * Alternative method of {@link #setValue(Object)}. this method also stores a reason,
     * which lead to the value assignment/conflict.
     * @param reason The reason, which lead to the <tt>newValue</tt>.
     *     The correct datatype must be ensured by the concrete reasoner instance.
     * @param newValue The new Value which should be assigned to this variable.
     * @see #getReasonsCount()
     * @see #getReason(int)
     */
    public final void setValue(Object reason, Object newValue) {
        if (null == reasons) {
            reasons = new ArrayList<Object>();
        }
        reasons.add(reason);
        setValue(newValue);
    }
    
    /**
     * Returns the number of stored reasons.
     * @return The number of stored reasons (only available if {@link #setValue(Object, Object)} was used instead of
     *     {@link #setValue(Object)}), <tt>-1</tt> otherwise.
     * @see #setValue(Object, Object)
     * @see #getReason(int)
     */
    public final int getReasonsCount() {
        return reasons == null ? -1 : reasons.size();
    }
    
    /**
     * Returns the stored reason, specified by the given <tt>index</tt>.
     * @param index A 0-based index, specifying which reason shall be returned.
     * @return The reason specified by the given <tt>index</tt>
     * @throws IndexOutOfBoundsException if the index is out of range
     *     (<tt> index &gt;= {@link #getReasonsCount()}</tt>)
     * @throws NullPointerException if {@link #getReasonsCount()} is returning <tt>-1</tt> (this is usually the case,
     *     if {@link #setValue(Object)} was used instead of {@link #setValue(Object, Object)}).
     */
    public final Object getReason(int index) {
        return reasons.get(index);
    }
    
    /**
     * The to String method should only be used for debugging and reasoning.
     * Please do not add needed functionality inside the toString method.
     * @return A textual representation, which is useful for debugging. 
     */
    @Override
    public String toString() {
        return getName() + ": " + getReasoningState();
    }
    
    /**
     * Internal Object based getter for the value.
     * @return The value of this {@link ReasonerVariable} as an Object.
     */
    protected abstract Object getObjectValue();
    
    /**
     * Returns the declaration of the variable.
     * @return The declaration of the variable.
     */
    public final AbstractVariable getDeclaration() {
        return configVariable.getDeclaration();
    }
    
    /**
     * Returns the name of the data type.
     * @return The name of the data type.
     */
    public final String getTypeName() {
        return getDeclaration().getType().getName();
    }
    
    /**
     * Method to get the value of {@link ReasonerVariable}.
     * @return value of the linked {@link IDecisionVariable}.
     */
    public abstract Object getValue();
    
    /**
     * Method for adding nested elements to Set and Sequence variables.
     * @param nestedVariable {@link ReasonerVariable} type lements.
     */
    public abstract void addNested(ReasonerVariable nestedVariable);
    
    /**
     * Method for propagating assignment state and value to {@link IDecisionVariable}.
     */
    public void propagate() {
        AssignmentState aState = translateState(); 
        if (null != getValue()) {
            try {
                IDatatype type = configVariable.getDeclaration().getType();
                Value value = null;
                if (type instanceof de.uni_hildesheim.sse.model.varModel.datatypes.Enum) {
                    EnumLiteral literal = ((Enum) type).getLiteralByOrdinal((Integer) getValue());
                    value = ValueFactory.createValue(type, literal);
                } else {
                    value = ValueFactory.createValue(type, getValue());
                }
                configVariable.setValue(value, aState);
            } catch (ValueDoesNotMatchTypeException e) {
                LOGGER.exception(e);
            } catch (ConfigurationException e) {
                LOGGER.exception(e);
            }
        }
    }

    /**
     * Method for translating {@link ReasoningState} to {@link AssignmentState}.
     * @return {@link AssignmentState} of propagated variable.
     */
    private AssignmentState translateState() {
        AssignmentState aState = AssignmentState.UNDEFINED;
        switch (state) {
        case DEFAULT_DIFFERENT:
            if (valueAssignedByReasoner) {
                aState = AssignmentState.DERIVED;                
            } else {
                aState = AssignmentState.ASSIGNED;
            }
            break;
        case DEFAULT_SAME:
            if (valueAssignedByReasoner) {
                aState = AssignmentState.DERIVED;                
            } else {
                aState = AssignmentState.ASSIGNED;
            }
            break;
        case FIXED:
            aState = AssignmentState.FROZEN;
            break;
        default:            
            aState = AssignmentState.UNDEFINED;
            break;
        }
        return aState;
    }
    
    /**
     * Method for propagating null value to {@link IDecisionVariable} in case of conflict.
     */
    public void propagateNull() {
        try {
            Value value = null;
            configVariable.setValue(value, AssignmentState.UNDEFINED);
        } catch (ConfigurationException e) {
            LOGGER.exception(e);
        }
    }
    /**
     * Method for retrieving if value was assigned by reasoner.
     * @return true if value was assigned by reasoner.
     */
    public boolean valueAssignedByReasoner() {
        return valueAssignedByReasoner;
        
    }
    
    /**
     * Method for returning parent of the variable.
     * @return {@link ReasonerVariable} that holds this variable, null if it is a top level element.
     */
    public ReasonerVariable getParent() {
        return parent;
    }    
}
