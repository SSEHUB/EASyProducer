package de.uni_hildesheim.sse.reasoning.core.model.variables;

import de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * {@link ReasonerVariable} representing a reference {@link IDecisionVariable}.
 * @author El-Sharkawy
 *
 */
public class ReferenceVariable extends ReasonerVariable {

    private String value;
    
    /**
     * Sole constructor for creating a new {@link ReferenceVariable}.
     * @param configVariable The origin {@link IDecisionVariable}, which should be wrapped into
     *     this {@link ReasonerVariable} (must not be <tt>null</tt>).
     *     The variable must represent a reference.
     * @param name The unique name of the {@link ReasonerVariable} inside the
     *     {@link de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel}.
     * @param model Reasoning model of the variable. 
     * @param parent Variables container.     
     */
    ReferenceVariable(IDecisionVariable configVariable, String name, ReasonerModel model, ReasonerVariable parent) {
        super(configVariable, name, model, parent);
        value = null;
    }

    @Override
    protected void assignValue(Object newValue) {
        value = (String) newValue;
    }

    @Override
    protected boolean isSameValue(Object newValue) {
        return value.equals((String) newValue) ? true : false;
    }
    
    @Override
    protected String getObjectValue() {
        return value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void addNested(ReasonerVariable nestedVariable) {
        // TODO Auto-generated method stub
        
    }
}
