package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;


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
     * @throws ExpressionException in case of parse problems
     */
    public abstract Expression parse(String text, IRuntimeEnvironment environment) throws ExpressionException;

}
