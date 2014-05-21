package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.util.regex.Pattern;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * A simple RegEx selector.
 * 
 * @author Holger Eichelberger
 */
class TypePatternSelector implements IVariableSelector {

    private Pattern selector;
    
    /**
     * Creates a regEx selector.
     * 
     * @param selector the regEx
     */
    public TypePatternSelector(String selector) {
        this.selector = Pattern.compile(selector);
    }
    
    @Override
    public boolean select(IDecisionVariable var) {
        return selector.matcher(var.getDeclaration().getType().getName()).matches()
            || selector.matcher(var.getDeclaration().getType().getQualifiedName()).matches();
    }
    
}