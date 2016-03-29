package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * Defines the interface for a variable selector.
 * 
 * @author Holger Eichelberger
 */
interface IVariableSelector {

    /**
     * Returns whether a variable shall be selected / considered.
     * 
     * @param var the variable to be tested
     * @return <code>true</code> if <code>var</code> shall be selected / considered, <code>false</code> else
     */
    public boolean select(IDecisionVariable var);
}