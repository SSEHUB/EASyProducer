package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.StringValueHelper;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;

/**
 * A parser and replacer for values (<i>$name</i>) and expressions (<i>${expression}</i>) in string values.
 * 
 * @author Holger Eichelberger
 */
public class StringReplacer {

    /**
     * The parser states.
     * 
     * @author Holger Eichelberger
     */
    private enum State {

        /**
         * Plain text.
         */
        TEXT,

        /**
         * Starting of a variable, i.e., $.
         */
        VARIABLE_START,

        /**
         * In a variable.
         */
        VARIABLE,

        /**
         * In an expression.
         */
        EXPRESSION
    }

    private StringBuilder text;
    private IRuntimeEnvironment environment;
    private IExpressionVisitor expressionEvaluator;
    private IExpressionParser expressionParser;
    private int pos;
    private int curStart;

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
        this.environment = environment;
        this.expressionEvaluator = expressionEvaluator;
        this.expressionParser = expressionParser;
        if (null != text) {
            this.text = new StringBuilder(text);
        } else {
            this.text = null;
        }
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
                result = replacer.substitute();
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

    /**
     * Substitutes the variables in <code>text</code>.
     * 
     * @return the modified <code>text</code>
     * @throws VilException
     *             in case that something goes wrong while resolving variables
     */
    public String substitute() throws VilException {
        pos = 0;
        curStart = 0;
        State state = State.TEXT;
        while (pos < text.length()) {
            char c = text.charAt(pos);
            switch (state) {
            case TEXT:
                if ('$' == c) {
                    state = State.VARIABLE_START;
                }
                break;
            case VARIABLE_START:
                if ('{' == c) {
                    state = State.EXPRESSION;
                    curStart = pos + 1;
                } else if (Character.isJavaIdentifierStart(c)) { // preliminary -> VIL
                    state = State.VARIABLE;
                    curStart = pos;
                } else {
                    state = State.TEXT;
                }
                break;
            case VARIABLE:
                if (!Character.isJavaIdentifierPart(c) || c == '$') {
                    handleVariable();
                    state = State.TEXT;
                    pos--;
                }
                break;
            case EXPRESSION:
                if ('}' == c) {
                    handleExpression();
                    state = State.TEXT;
                    pos--;
                }
                break;
            default:
                EASyLoggerFactory.INSTANCE.getLogger(StringReplacer.class, Bundle.ID).error("illegal state");
                break;
            }
            pos++;
        }
        switch (state) {
        case VARIABLE:
            handleVariable();
            break;
        case EXPRESSION:
            if ('}' == text.charAt(pos)) {
                handleExpression();
            }
            break;
        default:
            // do nothing, just in text
            break;
        }
        return text.toString();
    }

    /**
     * Handle variable placeholder from {@link #curStart} until {@link #pos}. {@link #curStart} points to "$",
     * {@link #pos} to the end position of the variable name.
     * 
     * @throws VilException
     *             in case of evaluation problems
     */
    private void handleVariable() throws VilException {
        String variableName = text.substring(curStart, pos);
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
                pos = replace(text, curStart - 1, pos, value);
            }
        }
    }

    /**
     * Handle expression placeholder from {@link #curStart} until {@link #pos}. {@link #curStart} points to "${",
     * {@link #pos} to "}". name.
     * 
     * @throws VilException
     *             in case of evaluation problems
     */
    private void handleExpression() throws VilException {
        if (null == expressionParser) {
            EASyLoggerFactory.INSTANCE.getLogger(StringReplacer.class, Bundle.ID).warn(
                    "no expression parser registered");
        } else if (null == expressionEvaluator) {
            EASyLoggerFactory.INSTANCE.getLogger(StringReplacer.class, Bundle.ID).warn(
                    "no expression evaluator registered");
        } else {
            String expressionString = text.substring(curStart, pos);
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
                pos = replace(text, curStart - 2, pos + 1, value);
            }
        }
    }

    /**
     * Replaces text and adjusts the position.
     * 
     * @param text
     *            the text buffer to perform an in-text replacement on
     * @param start
     *            the start position for the replacement in <code>text</code>
     * @param end
     *            the end position for the replacement in <code>text</code> (inclusive)
     * @param value
     *            the replacement for the specified fragment
     * @return end, but adjusted to the replacement
     */
    private static final int replace(StringBuilder text, int start, int end, String value) {
        int valueLen = value.length();
        int inTextLen = end - start;
        int result = end;
        if (inTextLen < valueLen) {
            // aaa -> aaaaa
            result += valueLen - inTextLen;
        } else if (inTextLen > valueLen) {
            // aaaaa -> aaa
            result -= inTextLen - valueLen;
        } // else end is ok as same length
        text.replace(start, end, value);
        return result;
    }

}
