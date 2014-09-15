package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * A filter that enables all variables.
 * 
 * @author Holger Eichelberger
 */
public class NoVariableFilter implements IVariableFilter {

    public static final IVariableFilter INSTANCE = new NoVariableFilter();
    
    /**
     * Prevents external creation.
     */
    private NoVariableFilter() {
    }
    
    @Override
    public boolean isEnabled(IDecisionVariable variable) {
        return true;
    }

}
