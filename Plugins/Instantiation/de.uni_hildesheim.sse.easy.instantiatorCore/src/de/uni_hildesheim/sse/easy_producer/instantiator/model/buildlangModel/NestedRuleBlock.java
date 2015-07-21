package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;

/**
 * A nested rule block. Please note that this block must be visited explicitly.
 * 
 * @author Holger Eichelberger
 */
public class NestedRuleBlock extends RuleBlock {

    /**
     * Creates a nested rule block.
     * 
     * @param body the rule body
     */
    public NestedRuleBlock(IRuleElement[] body) {
        super("", body);
    }

    @Override
    public boolean isVirtual() {
        return false;
    }

    @Override
    public Object accept(IVisitor visitor) throws VilException {
        return null; // must be visited explicitly
    }

}
