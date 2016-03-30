package net.ssehub.easy.instantiation.core.model.buildlangModel.matchLoop;

import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * An applicator which may enable the execution of a loop body. This applicator
 * collects whether all conditions have at least one LHS/RHS match requiring a build. To be 
 * efficient, this applicator stops the loops as soon as possible.
 * 
 * @author Holger Eichelberger
 */
public class BuildEnablingApplicator extends Applicator {

    private boolean lhsRhsBuildMatchFound = false;
    private boolean allConditionsEnabled = true;

    
    @Override
    public void apply(Object expectedLhsValue, Object rhsValue, int index) throws VilException {
        lhsRhsBuildMatchFound = true;
    }
    
    @Override
    public boolean stopMatchLoop() {
        return lhsRhsBuildMatchFound;
    }

    @Override
    public boolean stopConditionLoop() {
        return !allConditionsEnabled;
    }

    @Override
    public void matchLoopFinished() throws VilException {
        allConditionsEnabled &= lhsRhsBuildMatchFound;
        lhsRhsBuildMatchFound = false;
    }
    
    /**
     * Returns whether all matching conditions are enabled.
     * 
     * @return <code>true</code> if all conditions are enabled, <code>false</code> else
     */
    public boolean allConditionsEnabled() {
        return allConditionsEnabled;
    }
    
}
