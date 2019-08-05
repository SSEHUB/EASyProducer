package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * A nested rule block. Please note that this block must be visited explicitly.
 * 
 * @author Holger Eichelberger
 */
public class NestedRuleBlock extends RuleBlock {

    /**
     * Constructor for serialization.
     */ 
    public NestedRuleBlock() {
        super("", null);
    }
    
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

    @Override
    public boolean returnActualValue() {
        return false;
    }

}
