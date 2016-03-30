package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;

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
