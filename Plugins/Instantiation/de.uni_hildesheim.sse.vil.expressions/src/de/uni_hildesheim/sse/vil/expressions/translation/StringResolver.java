package de.uni_hildesheim.sse.vil.expressions.translation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.dslCore.translation.IMessageReceiver;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.common.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CompositeExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ConstantExpression;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.Resolver;
import net.ssehub.easy.instantiation.core.model.expressions.VariableEx;
import net.ssehub.easy.instantiation.core.model.expressions.VariableExpression;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * StringResolver to resolve variables and expressions on compiling. Use the StringReplacer if you need to replace
 * expressions or variables on runtime.
 * 
 * @param <V> the actual IResolvable
 * @author Sass
 */
public class StringResolver<I extends VariableDeclaration, R extends Resolver<I>, 
    E extends ExpressionStatement> implements IMessageReceiver {

    private StringBuilder text;
    private ExpressionTranslator<I, R, E> translator;
    private int pos;
    private int curStart;
    private R resolver;
    private StringBuilder warnings;

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

    /**
     * Creates a replacer instance.
     * 
     * @param text
     *            the text to be analyzed
     * @param translator
     *            the translator to be used
     * @param resolver
     *            the resolver to be used
     * @param warnings 
     *            to collect warnings (may be <b>null</b>)
     */
    private StringResolver(String text, R resolver, ExpressionTranslator<I, R, E> translator, StringBuilder warnings) {
        this.warnings = warnings;
        this.resolver = resolver;
        this.translator = translator;
        if (null != text) {
            this.text = new StringBuilder(text);
        } else {
            this.text = null;
        }
    }

    /**
     * Substitutes a given text and returns a CompositeExpression.
     * 
     * @param text
     *            the text to be analyzed
     * @param resolver
     *            the resolver to be used.
     * @param translator
     *            the translator to be used.
     * @param warnings an optional (may be <b>null</b> buffer to collect warnings
     * @param <V> TODO:
     * 
     * @throws VilException delegates the exception
     *
     * @return a {@link CompositeExpression}
     */
    public static <I extends VariableDeclaration, R extends Resolver<I>, 
    E extends ExpressionStatement> Expression substitute(String text, R resolver,
            ExpressionTranslator<I, R, E> translator, StringBuilder warnings) throws VilException {
        CompositeExpression result;
        if (null != text) {
            try {
                StringResolver<I, R, E> replacer = new StringResolver<I, R, E>(text, resolver, translator, warnings);
                if (text.contains("$")) {
                    result = replacer.substitute();
                } else {
                    List<Expression> list = replacer.handleConstant(text);
                    result = new CompositeExpression(list);
                }
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
     * Substitutes the text and splits the text into expressions, variables or constants.
     * 
     * @return CompositeExpression containing all expressions, variables or constants.
     * @throws VilException in case of evaluation problems
     */
    private CompositeExpression substitute() throws VilException {
        pos = 0;
        curStart = 0;
        State state = State.TEXT;
        Expression expr = null;
        List<Expression> list = new ArrayList<Expression>();
        while (pos < text.length()) {
            char c = text.charAt(pos);
            switch (state) {
            case TEXT:
                if ('$' == c) {
                    state = State.VARIABLE_START;
                }
                if (pos == text.length() - 1 && state == State.TEXT) { // In case we are at the end of the line
                    expr = handleConstant(pos + 1);
                    addToList(expr, list);
                }
                break;
            case VARIABLE_START:
                state = checkVariableStart(list, c);
                break;
            case VARIABLE:
                if (!Character.isJavaIdentifierPart(c) || c == '$') {
                    expr = handleVariable();
                    addToList(expr, list);
                    state = State.TEXT;
                    curStart = pos;
                    pos--;
                }
                break;
            case EXPRESSION:
                if ('}' == c) {
                    expr = handleExpression();
                    addToList(expr, list);
                    state = State.TEXT;
                    curStart = pos + 1;
                    pos--;
                }
                break;
            default:
                EASyLoggerFactory.INSTANCE.getLogger(StringResolver.class, Bundle.ID).error("illegal state");
                break;
            }
            pos++;
        }
        switch (state) {
        case VARIABLE:
            expr = handleVariable();
            addToList(expr, list);
            break;
        case EXPRESSION:
            if ('}' == text.charAt(pos)) {
                expr = handleExpression();
                addToList(expr, list);
            }
            break;
        case VARIABLE_START:
            expr = handleConstant(pos);
            addToList(expr, list);
            break;
        default:
            break; // do nothing, just in text
        }
        CompositeExpression compExpr = new CompositeExpression(list);
        return compExpr;
    }

    /**
     * Check if a the start is containing to an expression or variable.
     * 
     * @param list  the list of expressions
     * @param character char on pos
     * @return the state
     * @throws VilException in case of evaluation problems
     */
    private State checkVariableStart(List<Expression> list, char character) throws VilException {
        State state;
        Expression expr;
        if ('{' == character) {
            state = State.EXPRESSION;
            expr = handleConstant(pos - 1);
            addToList(expr, list);
            curStart = pos;
        } else if (Character.isJavaIdentifierStart(character)) { // preliminary -> VIL
            state = State.VARIABLE;
            expr = handleConstant(pos - 1);
            addToList(expr, list);
            curStart = pos;
        } else {
            state = State.TEXT;
        }
        return state;
    }

    /**
     * Adds the expression to the expression list.
     * 
     * @param expr  the expression that should be added to the list
     * @param list  the list containing all expressions
     */
    private void addToList(Expression expr, List<Expression> list) {
        if (null != expr) {
            list.add(expr);
        }
    }

    /**
     * Handle expression placeholder from {@link #curStart} -1 until {@link #pos} + 1. {@link #curStart} points to "{",
     * {@link #pos} to "}".
     * 
     * @throws VilException
     *             in case of evaluation problems
     * @return Expression containing the expression
     */
    private Expression handleExpression() throws VilException {
        Expression expr = null;
        String expressionString = text.substring(curStart - 1, pos + 1);
        String pattern = "\\$\\{([^\\}]+)\\}";
        expressionString = expressionString.replaceAll(pattern, "$1");
        expr = translator.parseExpression(expressionString, resolver, warnings);
        if (expr instanceof VariableExpression) {
            VariableExpression e = (VariableExpression) expr;
            expr = new VariableEx(e.getDeclaration(), e.getQualifiedName());
        }
        return expr;
    }

    /**
     * Handle constant placeholder from {@link #curStart} until position. 
     * 
     * @param position  the actual position in the text.
     * @return ConstantExpression containing the constant
     * @throws VilException in case of evaluation problems
     */
    private ConstantExpression handleConstant(int position) throws VilException {
        String string = text.substring(curStart, position);
        ConstantExpression expr = null;
        if (string.length() > 0) {
            expr = new ConstantExpression(TypeRegistry.stringType(), string, resolver.getTypeRegistry());
        }
        return expr;
    }

    /**
     * Handle constant for a given text. Splits the text into constants by seperating the string on whitespaces.
     * 
     * @param text to be analyzed
     * @return  List of ConstantExpressions
     * @throws VilException in case of evaluation problems
     */
    private List<Expression> handleConstant(String text) throws VilException {
        List<Expression> list = new ArrayList<Expression>();
        // Split the string into words but keep the spaces
        String[] textArray = text.split("(?<=\\s)|(?=\\s)");
        for (String string : textArray) {
            ConstantExpression expr = new ConstantExpression(TypeRegistry.stringType(), string,
                    resolver.getTypeRegistry());
            list.add(expr);
        }
        return list;
    }

    /**
     * Handle variable.
     * 
     * @param text the variable name
     * @return CompositeExpression containing the variable
     */
    public CompositeExpression resolveVariable(String text) {
        CompositeExpression compExpression = null;
        // we are our own message receiver - cause/feature not needed here
        VariableDeclaration var = (VariableDeclaration) resolver.resolve(text, false, null, null, this);
        VariableExpression varExpr = null;
        if (var != null) {
            varExpr = new VariableExpression(var);
            List<Expression> expressionList = new ArrayList<Expression>();
            expressionList.add(varExpr);
            compExpression = new CompositeExpression(expressionList);
        }
        return compExpression;
    }

    /**
     * Handle variable placeholder from {@link #curStart} - 1 until {@link #pos}. {@link #curStart} points to "$",
     * {@link #pos} to the end position of the variable name.
     * 
     * @throws VilException
     *             in case of evaluation problems
     *             
     * @return VariableExpression containing the Variable
     */
    private VariableExpression handleVariable() throws VilException {
        String variableName = text.substring(curStart - 1, pos);
        String pattern2 = "\\$([A-Za-z0-9]+)";
        variableName = variableName.replaceAll(pattern2, "$1");
        pos = replace(text, curStart - 1, pos, variableName);
        VariableDeclaration var = (VariableDeclaration) resolver.resolve(variableName, false, null, null, this);
        VariableExpression varExpr = null;
        if (var != null) {
            varExpr = new VariableExpression(var);
        }
        return varExpr;
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

    @Override
    public void error(String message, EObject cause, EStructuralFeature causeFeature, int code) {
        // we just collect warnings here
    }

    @Override
    public void warning(String message, EObject cause, EStructuralFeature causeFeature, int code) {
        if (null != warnings) {
            if (warnings.length() > 0) {
                warnings.append(", ");
            }
            warnings.append(message);
        }
    }

}
