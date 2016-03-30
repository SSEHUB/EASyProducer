package net.ssehub.easy.instantiation.core.model.common;

import net.ssehub.easy.instantiation.core.model.expressions.IResolvable;

/**
 * An instance which receives (global) variable declarations.
 * 
 * @author Holger Eichelberger
 *
 * @param <I> the actual type of variable declarations
 */
public interface IVariableDeclarationReceiver<I extends IResolvable> {
    
    /**
     * Adds a variable declaration.
     * 
     * @param var the variable declaration
     */
    public void addVariableDeclaration(I var);

}
