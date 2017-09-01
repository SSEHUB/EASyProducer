package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.instantiation.core.model.common.VilException;


/**
 * Allows parsing a string to an expression.
 * 
 * @param <R> the resolver type
 * @author Holger Eichelberger
 */
public interface IExpressionParser <R extends Resolver<?>> {
    
    /**
     * Parses the given text into an expression. Resolution will happen in a separate resolver instance.
     * 
     * @param text the text to be parsed
     * @param environment the runtime environment used to resolve variables
     * @return the parsed expression
     * @throws VilException in case of parse problems
     */
    public Expression parse(String text, IRuntimeEnvironment environment) throws VilException;

    /**
     * Parses the given text into an expression. Resolution will happen in the given resolver instance.
     * 
     * @param text the text to be parsed
     * @param resolver a resolver instance providing a parse environment consisting of variables
     * @return the parsed expression
     * @throws VilException in case of parse problems
     */
    public Expression parse(String text, R resolver) throws VilException;
    
}
