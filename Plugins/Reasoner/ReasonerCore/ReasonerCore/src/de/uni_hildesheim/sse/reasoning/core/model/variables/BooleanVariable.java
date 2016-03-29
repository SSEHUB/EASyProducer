package de.uni_hildesheim.sse.reasoning.core.model.variables;

import de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * {@link ReasonerVariable} representing an Boolean {@link IDecisionVariable}.
 * @author El-Sharkawy
 *
 */
public class BooleanVariable extends ReasonerVariable {

    private Boolean value;
    
    /**
     * Sole constructor for creating a new {@link BooleanVariable}.
     * @param configVariable The origin {@link IDecisionVariable}, which should be wrapped into
     *     this {@link ReasonerVariable} (must not be <tt>null</tt>).
     *     The variable must represent a boolean.
     * @param name The unique name of the {@link ReasonerVariable} inside the
     *     {@link de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel}. 
     * @param model Reasoning model of the variable.      
     * @param parent Variables container.
     */
    BooleanVariable(IDecisionVariable configVariable, String name, ReasonerModel model, ReasonerVariable parent) {
        super(configVariable, name, model, parent);
        value = null;        
        if (configVariable.getState() != AssignmentState.UNDEFINED) {
            if (configVariable.getValue().getType().getName().equals("Boolean")) {                
                value = (Boolean) configVariable.getValue().getValue();
            }
        }
    }

    @Override
    protected void assignValue(Object newValue) {
        value = (Boolean) newValue;
    }

    @Override
    protected boolean isSameValue(Object newValue) {
        return value.equals((Boolean) newValue) ? true : false;
    }
    
    /**
     * Method for getting value of {@link BooleanVariable} type variable.
     * @return boolean type value.
     */
    public Boolean getValue() {
        return value;
    }

    @Override
    protected Boolean getObjectValue() {
        return value;
    }

    @Override
    public void addNested(ReasonerVariable nestedVariable) {
        // TODO Auto-generated method stub
        
    }
}
