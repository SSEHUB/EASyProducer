package de.uni_hildesheim.sse.reasoning.core.model.variables;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel;

/**
 * {@link ReasonerVariable} representing an Integer {@link IDecisionVariable}.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public class IntVariable extends ReasonerVariable {

    private Integer value;
    
    /**
     * Sole constructor for creating a new {@link IntVariable}.
     * @param configVariable The origin {@link IDecisionVariable}, which should be wrapped into
     *     this {@link ReasonerVariable} (must not be <tt>null</tt>).
     *     The variable must represent an integer.
     * @param name The unique name of the {@link ReasonerVariable} inside the 
     *     {@link de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel}.
     * @param model Reasoning model of the variable.
     * @param parent Variables container.     
     */
    IntVariable(IDecisionVariable configVariable, String name, ReasonerModel model, ReasonerVariable parent) {
        super(configVariable, name, model, parent);
        value = null;
        if (null != configVariable.getValue()) {
            value = (Integer) configVariable.getValue().getValue();
        } 
    }
    
    @Override
    public Integer getValue() {
        return value;
    }
    
    @Override
    protected void assignValue(Object newValue) {
        value = (Integer) newValue;
    }
    
    @Override
    protected boolean isSameValue(Object newValue) {
        return value.equals((Integer) newValue) ? true : false;
    }
    
    @Override
    protected Integer getObjectValue() {
        return value;
    }

    @Override
    public void addNested(ReasonerVariable nestedVariable) {
        // TODO Auto-generated method stub
        
    }
}
