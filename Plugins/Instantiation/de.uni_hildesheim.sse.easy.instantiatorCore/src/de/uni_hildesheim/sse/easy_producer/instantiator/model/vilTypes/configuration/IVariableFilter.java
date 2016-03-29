package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * Defines a variable filter. Basically, we will only filter for
 * frozen variables or leave all through (runtime), but in the future, 
 * further filters may be needed.
 * 
 * @author Holger Eichelberger
 */
public interface IVariableFilter {

    /**
     * Checks the given variable.
     * 
     * @param variable the variable to be checked
     * @return <code>true</code> if the variable is in (enabled), <code>false</code>
     *   if it is out
     */
    public boolean isEnabled(IDecisionVariable variable);
    
}
