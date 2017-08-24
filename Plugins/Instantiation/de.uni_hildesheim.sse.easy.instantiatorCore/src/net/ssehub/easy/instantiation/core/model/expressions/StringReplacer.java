package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.StringValueHelper;

/**
 * A parser and replacer for values (<i>$name</i>) and expressions (<i>${expression}</i>) in string values.
 * 
 * @author Holger Eichelberger
 */
public class StringReplacer extends StringParser<String> {

    private IRuntimeEnvironment environment;
    private IExpressionVisitor expressionEvaluator;
    private IExpressionParser expressionParser;

    /**
     * Creates a replacer instance.
     * 
     * @param text
     *            the text to be analyzed
     * @param environment
     *            the runtime environment containing the variables
     * @param expressionParser
     *            an instance for parsing strings into expression (may be <b>null</b> but then expression replacement
     *            will not work)
     * @param expressionEvaluator
     *            the expression visitor for evaluating expressions (may be <b>null</b> but then expression replacement
     *            will not work)
     */
    private StringReplacer(String text, IRuntimeEnvironment environment, IExpressionParser expressionParser,
            IExpressionVisitor expressionEvaluator) {
        super(text);
        this.environment = environment;
        this.expressionEvaluator = expressionEvaluator;
        this.expressionParser = expressionParser;
    }

    /**
     * Substitutes the variable and expression placeholders in <code>text</code>.
     * 
     * @param text
     *            the text to be analyzed
     * @param environment
     *            the runtime environment containing the variables
     * @param expressionParser
     *            an instance for parsing strings into expression (may be <b>null</b> but then expression replacement
     *            will not work)
     * @param expressionEvaluator
     *            the expression visitor for evaluating expressions (may be <b>null</b> but then expression replacement
     *            will not work)
     * @return the modified <code>text</code>
     * @throws VilException
     *             in case that something goes wrong while resolving variables
     */
    public static String substitute(String text, IRuntimeEnvironment environment, IExpressionParser expressionParser,
            IExpressionVisitor expressionEvaluator) throws VilException {
        String result;
        if (null != text) {
            try {
                StringReplacer replacer = new StringReplacer(text, environment, expressionParser, expressionEvaluator);
                result = replacer.parse();
            } catch (VilException e) {
                if (VilException.ID_NULL_VALUE == e.getId()) {
                    result = null;
                } else {
                    throw e;
                }
            }
        } else {
            result = null;
        }
        return result;
    }

    @Override
    protected String createParseResult() throws VilException {
        return toText();
    }
    
    @Override
    protected void handleQuote(int pos) throws VilException {
        if (pos + 2 < length() && charAt(pos + 2) != '$') { 
            deleteCharAt(pos); // remove quote -> Java quote
        }
    }

    @Override
    protected void handleTextEnd(int curStart, int pos) throws VilException {
        // do nothing
    }
    
    @Override
    protected int handleVariableStartExpression(int curStart, int pos) throws VilException {
        return pos + 1;
    }        

    @Override
    protected int handleVariableStartVariable(int curStart, int pos) throws VilException {
        return pos;
    }

    @Override
    protected int handleEndOfText(int curStart, int pos, State state) throws VilException {
        return pos;
    }

    @Override
    protected int handleVariable(int curStart, int pos) throws VilException {
        String variableName = substring(curStart, pos);
        IResolvable var = environment.get(variableName);
        if (null != var) {
            Object oValue = environment.getValue(var);
            if (null == oValue) {
                // stop replacement
                throw new VilException("", VilException.ID_NULL_VALUE);
            }
            String value = StringValueHelper.getStringValueInReplacement(oValue, null);
            if (null != value) {
                // curStart - 1 -> replace also the $!
                pos = setPos(replace(curStart - 1, pos, value));
            }
        }
        return -1;
    }

    @Override
    protected int handleExpression(int curStart, int pos) throws VilException {
        if (null == expressionParser) {
            EASyLoggerFactory.INSTANCE.getLogger(StringReplacer.class, Bundle.ID).warn(
                    "no expression parser registered");
        } else if (null == expressionEvaluator) {
            EASyLoggerFactory.INSTANCE.getLogger(StringReplacer.class, Bundle.ID).warn(
                    "no expression evaluator registered");
        } else {
            String expressionString = substring(curStart, pos);
            Expression expr = expressionParser.parse(expressionString, environment);
            if (null == expr) {
                throw new VilException("illegal expression '" + expressionString + "'",
                        VilException.ID_RUNTIME);
            }
            Object oValue = expr.accept(expressionEvaluator);
            if (null == oValue) {
                // stop replacement
                throw new VilException("", VilException.ID_NULL_VALUE);
            }
            String value = StringValueHelper.getStringValueInReplacement(oValue, null);
            if (null != value) {
                // curStart - 1 -> replace also the $!
                pos = setPos(replace(curStart - 2, pos + 1, value));
            }
        }
        return -1;
    }

}
