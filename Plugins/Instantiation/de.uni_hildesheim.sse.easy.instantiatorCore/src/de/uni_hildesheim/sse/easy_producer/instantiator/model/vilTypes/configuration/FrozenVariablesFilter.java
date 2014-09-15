package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * Enables only frozen variables, i.e., variables with assignment state
 * {@link AssignmentState#FROZEN frozen}.
 * 
 * @author Holger Eichelberger
 */
public class FrozenVariablesFilter implements IVariableFilter {

    public static final IVariableFilter INSTANCE = new FrozenVariablesFilter();

    /**
     * Prevents external creation.
     */
    private FrozenVariablesFilter() {
    }
    
    @Override
    public boolean isEnabled(IDecisionVariable variable) {
        return AssignmentState.FROZEN == variable.getState();
    }

}
