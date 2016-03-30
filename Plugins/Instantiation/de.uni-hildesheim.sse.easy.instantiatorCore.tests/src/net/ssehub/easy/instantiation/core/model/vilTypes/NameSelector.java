package net.ssehub.easy.instantiation.core.model.vilTypes;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * A simple name-equality selector.
 * 
 * @author Holger Eichelberger
 */
class NameSelector implements IVariableSelector {

    private String selector;

    /**
     * Creates a new name-equality selector.
     * 
     * @param selector the name
     */
    public NameSelector(String selector) {
        this.selector = selector;
    }
    
    @Override
    public boolean select(IDecisionVariable var) {
        return var.getDeclaration().getName().equals(selector) 
            || var.getDeclaration().getQualifiedName().equals(selector);
    }
    
}