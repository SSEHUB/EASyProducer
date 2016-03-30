package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.regex.Pattern;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * A simple RegEx selector.
 * 
 * @author Holger Eichelberger
 */
class NamePatternSelector implements IVariableSelector {

    private Pattern selector;
    
    /**
     * Creates a regEx selector.
     * 
     * @param selector the regEx
     */
    public NamePatternSelector(String selector) {
        this.selector = Pattern.compile(selector);
    }
    
    @Override
    public boolean select(IDecisionVariable var) {
        return selector.matcher(var.getDeclaration().getName()).matches()
            || selector.matcher(var.getDeclaration().getQualifiedName()).matches();
    }
    
}