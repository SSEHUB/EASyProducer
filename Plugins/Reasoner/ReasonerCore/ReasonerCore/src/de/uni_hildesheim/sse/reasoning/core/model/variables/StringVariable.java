package de.uni_hildesheim.sse.reasoning.core.model.variables;

import de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * {@link ReasonerVariable} representing an String {@link IDecisionVariable}.
 * @author El-Sharkawy
 *
 */
public class StringVariable extends ReasonerVariable {

    private String value;
    
    /**
     * Sole constructor for creating a new {@link StringVariable}.
     * @param configVariable The origin {@link IDecisionVariable}, which should be wrapped into
     *     this {@link ReasonerVariable} (must not be <tt>null</tt>).
     *     The variable must represent a string.
     * @param name The unique name of the {@link ReasonerVariable} inside the 
     *     {@link de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel}.
     * @param model Reasoning model of the variable.
     * @param parent Variables container.     
     */
    StringVariable(IDecisionVariable configVariable, String name, ReasonerModel model, ReasonerVariable parent) {
        super(configVariable, name, model, parent);
        
        // value and configVariable.getValue() can share the same instance, since strings are immutable.
        value = null;
        if (configVariable.getState() != AssignmentState.UNDEFINED) {
            if (configVariable.getValue().getType().getName().equals("String")) {                
                value = (String) configVariable.getValue().getValue();
            }            
        }
    }

    @Override
    protected void assignValue(Object newValue) {
        value = (String) value;
    }
    
    @Override
    protected boolean isSameValue(Object newValue) {
        return value.equals((String) newValue) ? true : false;
    }
    
    /**
     * Method for returning the value of {@link StringVariable}.
     * @return String representation of the value.
     */
    public String getValue() {
        return value;
    }
    
    @Override
    protected String getObjectValue() {
        return value;
    }

    @Override
    public void addNested(ReasonerVariable nestedVariable) {
        // TODO Auto-generated method stub
        
    }
}
