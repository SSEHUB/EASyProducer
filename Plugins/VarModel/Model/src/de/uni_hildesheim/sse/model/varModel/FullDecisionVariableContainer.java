package de.uni_hildesheim.sse.model.varModel;

import java.util.ArrayList;
import java.util.List;

/**
 * An extended version of the a decision variable container which also supports realizing constraints. 
 * 
 * @author Holger Eichelberger
 */
public class FullDecisionVariableContainer extends BasicDecisionVariableContainer {

    private List<Constraint> realizing = new ArrayList<Constraint>();

    /**
     * {@inheritDoc}
     */
    public void addConstraint(Constraint constraint, boolean internal) {
        assert null != constraint;
        if (internal) {
            realizing.add(constraint);
        } else {
            super.addConstraint(constraint, internal);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public int getRealizingCount() {
        return realizing.size();
    }
    
    /**
     * {@inheritDoc}
     */
    public Constraint getRealizing(int index) {
        return realizing.get(index);
    }

}
