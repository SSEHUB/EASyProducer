package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

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
