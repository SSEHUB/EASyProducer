package net.ssehub.easy.reasoning.drools2.model.variables;

import net.ssehub.easy.reasoning.drools2.model.ReasonerModel;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * {@link ReasonerVariable} representing an real {@link IDecisionVariable}.
 * @author El-Sharkawy
 *
 */
public class RealVariable extends ReasonerVariable {

    private Double value;
    
    /**
     * Sole constructor for creating a new {@link RealVariable}.
     * @param configVariable The origin {@link IDecisionVariable}, which should be wrapped into
     *     this {@link ReasonerVariable} (must not be <tt>null</tt>).
     *     The variable must represent a real.
     * @param name The unique name of the {@link ReasonerVariable} inside the
     *     {@link net.ssehub.easy.reasoning.drools2.model.ReasonerModel}.
     * @param model Reasoning model of the variable.  
     * @param parent Variables container.     
     */
    RealVariable(IDecisionVariable configVariable, String name, ReasonerModel model, ReasonerVariable parent) {
        super(configVariable, name, model, parent);
        value = null;
        if (configVariable.getState() != AssignmentState.UNDEFINED) {
            if (configVariable.getValue().getType().getName().equals("Real")
                    || configVariable.getValue().getType().getName().equals("Integer")) {                
                value = ((Number) configVariable.getValue().getValue()).doubleValue(); 
            }
            
        }
    }

    
    @Override
    protected void assignValue(Object newValue) {
        value = (Double) newValue;
    }
    
    @Override
    protected boolean isSameValue(Object newValue) {
        return value.equals((Double) newValue) ? true : false;
    }
    
    @Override
    public Double getValue() {
        return value;
    }
    
    @Override
    protected Double getObjectValue() {
        return value;
    }


    @Override
    public void addNested(ReasonerVariable nestedVariable) {
        // TODO Auto-generated method stub
        
    }
}
