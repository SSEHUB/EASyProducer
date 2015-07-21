package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.HashSet;
import java.util.Set;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * Enables only variables in the given map.
 * 
 * @author Holger Eichelberger
 */
public class SetVariablesFilter implements IVariableFilter {

    private Set<IDecisionVariable> enabled;

    /**
     * Creates a variables filter from the given set.
     * 
     * @param enabled the enabled variables
     */
    public SetVariablesFilter(Set<IDecisionVariable> enabled) {
        this.enabled = enabled;
    }

    /**
     * Creates a variables filter from the given set.
     * 
     * @param enabled the enabled variables
     * @return the filter instance
     */
    public static SetVariablesFilter createFilter(Set<AbstractIvmlVariable> enabled) {
        Set<IDecisionVariable> tmp = new HashSet<IDecisionVariable>();
        for (AbstractIvmlVariable var : enabled) {
            tmp.add(var.getVariable());
        }
        return new SetVariablesFilter(tmp);
    }
    
    @Override
    public boolean isEnabled(IDecisionVariable variable) {
        return enabled.contains(variable);
    }

}
