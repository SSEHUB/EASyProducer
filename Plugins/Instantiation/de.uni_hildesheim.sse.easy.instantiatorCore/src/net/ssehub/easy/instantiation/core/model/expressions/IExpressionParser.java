package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.instantiation.core.model.common.VilException;


/**
 * Allows parsing a string to an expression.
 * 
 * @author Holger Eichelberger
 */
public interface IExpressionParser {
    
    /**
     * Parses the given text into an expression.
     * 
     * @param text the text to be parsed
     * @param environment the runtime environment used to resolve variables
     * @return the parsed expression
     * @throws VilException in case of parse problems
     */
    public abstract Expression parse(String text, IRuntimeEnvironment environment) throws VilException;

}
