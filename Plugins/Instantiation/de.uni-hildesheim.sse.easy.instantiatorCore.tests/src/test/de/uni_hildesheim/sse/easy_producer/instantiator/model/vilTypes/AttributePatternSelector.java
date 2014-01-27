package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.util.regex.Pattern;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * A simple RegEx selector.
 * 
 * @author Holger Eichelberger
 */
class AttributePatternSelector implements IVariableSelector {

    private Pattern selector;
    private Object value;

    /**
     * Creates a regEx selector.
     * 
     * @param selector the regEx
     */
    public AttributePatternSelector(String selector) {
        this(selector, null);
    }

    /**
     * Creates a regEx selector.
     * 
     * @param selector the regEx
     * @param value an optional value to filter for, i.e., consider IVML element values
     */
    public AttributePatternSelector(String selector, Object value) {
        this.value = value;
        // don't care for exceptions here - we are in a test support class, input shall be valid!
        this.selector = Pattern.compile(selector); 
    }
    
    @Override
    public boolean select(IDecisionVariable var) {
        boolean found = false;
        for (int a = 0; !found && a < var.getAttributesCount(); a++) {
            IDecisionVariable attr = var.getAttribute(a);
            if (AssignmentState.FROZEN == attr.getState()) {
                found = selector.matcher(attr.getDeclaration().getName()).matches() 
                    || selector.matcher(attr.getDeclaration().getQualifiedName()).matches();
                if (found && null != value) {
                    found = value.equals(attr.getValue());
                }
            }
        }
        return found;
    }
    
}