package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;

/**
 * An expression denoting that a variable is used.
 * 
 * @author Aike Sass
 */
public class VariableEx extends VariableExpression {

    /**
     * Constructor for serialization.
     */ 
    VariableEx() {
    }
    
    /**
     * Creates a variable expression node.
     * 
     * @param variable the variable declaration used as variable here
     * @param qualifiedName the qualified name of the variable
     */
    public VariableEx(VariableDeclaration variable, String qualifiedName) {
        super(variable, qualifiedName);
    }

}
