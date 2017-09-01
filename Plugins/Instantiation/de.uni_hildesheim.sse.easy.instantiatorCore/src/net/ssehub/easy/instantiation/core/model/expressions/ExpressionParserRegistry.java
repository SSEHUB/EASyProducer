package net.ssehub.easy.instantiation.core.model.expressions;

import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.Bundle;

/**
 * A global registry for expression parsers.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionParserRegistry {

    /**
     * Identifies a language.
     *
     * @param <R> the resolver type
     *
     * @author Holger Eichelberger
     */
    public interface ILanguage<R extends Resolver<?>> {

        /**
         * Returns the name of the language.
         * 
         * @return the name of the language
         */
        public String getName();
        
    }
    
    private static Map<ILanguage<?>, IExpressionParser<?>> expressionParsers 
        = new HashMap<ILanguage<?>, IExpressionParser<?>>();

    /**
     * Defines the expression parser for a language.
     * 
     * @param <R> the resolver type
     * @param language the language to define the parser for
     * @param parser the parser
     */
    public static <R extends Resolver<?>> void setExpressionParser(ILanguage<R> language, IExpressionParser<R> parser) {
        String info;
        if (null != parser) {
            info = "registered expression parser " + parser.getClass().getName() + " for " + language.getName();
        } else {
            info = "expression parser unregistered";
        }
        EASyLoggerFactory.INSTANCE.getLogger(ExpressionParserRegistry.class, Bundle.ID).info(info);
        expressionParsers.put(language, parser);
    }
    
    /**
     * Returns the expression parser for a given language.
     * 
     * @param <R> the resolver type
     * @param language the language to return the parser for
     * @return the parser (may be <b>null</b>)
     */
    @SuppressWarnings("unchecked")
    public static <R extends Resolver<?>> IExpressionParser<R> getExpressionParser(ILanguage<R> language) {
        return (IExpressionParser<R>) expressionParsers.get(language);
    }

}
