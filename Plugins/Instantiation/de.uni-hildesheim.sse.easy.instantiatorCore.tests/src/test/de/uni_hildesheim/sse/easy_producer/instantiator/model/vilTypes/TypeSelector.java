package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

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