package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * A simple name-equality selector.
 * 
 * @author Holger Eichelberger
 */
class AttributeSelector implements IVariableSelector {

    private String selector;
    private Object value;

    /**
     * Creates a new name-equality selector.
     * 
     * @param selector the name
     */
    public AttributeSelector(String selector) {
        this(selector, null);
    }

    /**
     * Creates a new name-equality selector.
     * 
     * @param selector the name
     * @param value an optional value to filter for (may be <b>null</b> if not used)
     */
    public AttributeSelector(String selector, Object value) {
        this.selector = selector;
        this.value = value;
    }
    
    @Override
    public boolean select(IDecisionVariable var) {
        boolean found = false;
        for (int a = 0; !found && a < var.getAttributesCount(); a++) {
            IDecisionVariable attr = var.getAttribute(a);
            if (AssignmentState.FROZEN == attr.getState()) {
                found = attr.getDeclaration().getName().equals(selector) 
                    || attr.getDeclaration().getQualifiedName().equals(selector);
                if (found && null != value) {
                    found = value.equals(attr.getValue());
                }
            }
        }
        return found;
    }
    
}