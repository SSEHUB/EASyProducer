package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;

/**
 * A global registry for expression parsers.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionParserRegistry {

    /**
     * Identifies a language.
     * 
     * @author Holger Eichelberger
     */
    public interface ILanguage {

        /**
         * Returns the name of the language.
         * 
         * @return the name of the language
         */
        public String getName();
        
    }
    
    private static Map<ILanguage, IExpressionParser> expressionParsers = new HashMap<ILanguage, IExpressionParser>();

    /**
     * Defines the expression parser for a language.
     * 
     * @param language the language to define the parser for
     * @param parser the parser
     */
    public static void setExpressionParser(ILanguage language, IExpressionParser parser) {
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
     * @param language the language to return the parser for
     * @return the parser (may be <b>null</b>)
     */
    public static IExpressionParser getExpressionParser(ILanguage language) {
        return expressionParsers.get(language);
    }

}
