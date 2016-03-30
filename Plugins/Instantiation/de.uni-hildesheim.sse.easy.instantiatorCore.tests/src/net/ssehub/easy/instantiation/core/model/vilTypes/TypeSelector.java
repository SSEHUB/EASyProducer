package net.ssehub.easy.instantiation.core.model.vilTypes;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * A simple type-equality selector.
 * 
 * @author Holger Eichelberger
 */
class TypeSelector implements IVariableSelector {

    private String selector;

    /**
     * Creates a new type-equality selector.
     * 
     * @param selector the type name
     */
    public TypeSelector(String selector) {
        this.selector = selector;
    }
    
    @Override
    public boolean select(IDecisionVariable var) {
        return var.getDeclaration().getType().getName().equals(selector) 
            || var.getDeclaration().getType().getQualifiedName().equals(selector);
    }
    
}