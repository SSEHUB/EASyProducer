package de.uni_hildesheim.sse.vil.expressions.translation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.messages.IMessage;
import net.ssehub.easy.basics.messages.Status;
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
 * @param <I> the actual variable declaration type
 * @param <R> the actual resolver type
 * @param <E> the actual expression statement type
 * @author Sass
 * @author Eichelberger
 */
public class StringResolver<I extends VariableDeclaration, R extends Resolver<I>, 
    E extends ExpressionStatement> implements IMessageReceiver {

    private StringBuilder text;
    private ExpressionTranslator<I, R, E> translator;
    private int pos;
    private int curStart;
    private int innerBracketLevel;
    private R resolver;
    private StringBuilder warnings;
    private IStringResolverFactory<I> factory;
    private Stack<InPlaceCommand<I>> commandStack;

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
     * @param text the text to be analyzed
     * @param translator the translator to be used
     * @param resolver the resolver to be used
     * @param warnings  to collect warnings (may be <b>null</b>)
     * @param factory a factory turning in-place commands into language-specific expressions (may be <b>null</b>, then 
     *     in-place commands are not resolved but remain as string expressions)
     */
    private StringResolver(String text, R resolver, ExpressionTranslator<I, R, E> translator, StringBuilder warnings, 
        IStringResolverFactory<I> factory) {
        this.warnings = warnings;
        this.resolver = resolver;
        this.translator = translator;
        this.factory = factory;
        if (null != factory) {
            commandStack = new Stack<InPlaceCommand<I>>();
        }
        if (null != text) {
            this.text = new StringBuilder(text);
        } else {
            this.text = null;
        }
    }

    /**
     * Substitutes a given text and returns a CompositeExpression.
     * 
     * @param <I> the variable declaration type
     * @param <R> the resolver type
     * @param <E> the expression statement type
     * @param text the text to be analyzed
     * @param resolver the resolver to be used.
     * @param translator the translator to be used.
     * @param warnings an optional (may be <b>null</b> buffer to collect warnings
     * @param factory a factory turning in-place commands into language-specific expressions (may be <b>null</b>, then 
     *     in-place commands are not resolved but remain as string expressions)
     * 
     * @throws VilException delegates the exception
     *
     * @return a {@link CompositeExpression}
     */
    public static <I extends VariableDeclaration, R extends Resolver<I>, 
        E extends ExpressionStatement> Expression substitute(String text, R resolver,
        ExpressionTranslator<I, R, E> translator, StringBuilder warnings, IStringResolverFactory<I> factory) 
        throws VilException {
        CompositeExpression result;
        if (null != text) {
            try {
                StringResolver<I, R, E> replacer = new StringResolver<I, R, E>(text, resolver, translator, 
                    warnings, factory);
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
                    if (pos > 0 && '\\' == text.charAt(pos - 1)) {
                        state = State.TEXT; // stay, quote
                    } else {                    
                        state = State.VARIABLE_START;
                    }
                }
                if (pos == text.length() - 1 && state == State.TEXT) { // In case we are at the end of the line
                    expr = handleConstant(pos + 1);
                    addToList(expr, list);
                }
                break;
            case VARIABLE_START:
                state = checkVariableStart(list, c, state);
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
                if ('{' == c) {
                    innerBracketLevel++;
                } else if ('}' == c) {
                    if (0 == innerBracketLevel) {
                        expr = handleExpression();
                        addToList(expr, list);
                        state = State.TEXT;
                        curStart = pos + 1;
                        pos--;
                    } else {
                        innerBracketLevel--;
                    }
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
            if ('}' == text.charAt(pos) && 0 == innerBracketLevel) {
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
        clearStatementStack(list);
        CompositeExpression compExpr = new CompositeExpression(list);
        return compExpr;
    }

    /**
     * Check if a the start is containing to an expression or variable.
     * 
     * @param list  the list of expressions
     * @param character char on pos
     * @param curState the current state
     * @return the state
     * @throws VilException in case of evaluation problems
     */
    private State checkVariableStart(List<Expression> list, char character, State curState) throws VilException {
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
     * Adds the expression to the expression list or to the active in-place command on the command stack (if present).
     * 
     * @param expr  the expression that should be added to the list
     * @param list  the list containing all expressions
     */
    private void addToList(Expression expr, List<Expression> list) {
        if (null != expr) {
            if (isNonEmptyCommandStack()) {
                commandStack.peek().append(expr);
            } else {
                list.add(expr);
            }
        }
    }

    /**
     * Handle expression placeholder from {@link #curStart} -1 until {@link #pos} + 1. {@link #curStart} points to "{",
     * {@link #pos} to "}". Considers in-place expressions.
     * 
     * @throws VilException
     *             in case of evaluation problems
     * @return Expression containing the expression
     */
    private Expression handleExpression() throws VilException {
        Expression result = null;
        String expressionString = text.substring(curStart - 1, pos + 1);
        //remove leading ${ and trailing }; reg-ex fails with nested {}
        expressionString = expressionString.substring(2, expressionString.length() - 1); 
        String pattern = "\\$\\{([^\\}]+)\\}"; // still needed?
        expressionString = expressionString.replaceAll(pattern, "$1");
        if (null != factory) {
            boolean clear = true;
            if (expressionString.startsWith("IF")) {
                expressionString = removePrefix(expressionString, "IF", true);
                push(new InPlaceIfCommand<I>(parseExpression(expressionString)));
            } else if (expressionString.startsWith("FOR")) {
                expressionString = removePrefix(expressionString, "FOR", true);
                expressionString = consumeWhitespaces(expressionString);
                int pos = 0;
                while (pos < expressionString.length() && Character.isJavaIdentifierPart(expressionString.charAt(pos))) {
                    pos++;
                }
                String iterName = expressionString.substring(0, pos);
                expressionString = consumeWhitespaces(expressionString.substring(pos));
                if (expressionString.startsWith("=")) {
                    expressionString = consume(expressionString, '=');
                } else if (expressionString.startsWith(":")) {
                    expressionString = consume(expressionString, ':');
                }
                expressionString = consumeWhitespaces(expressionString);
                pos = expressionString.indexOf(" SEPARATOR");
                Expression separatorEx = null;
                Expression endSeparatorEx = null;
                if (pos > 0) {
                    String separatorString = expressionString.substring(pos + 1).trim();
                    separatorString = removePrefix(separatorString, "SEPARATOR", true);
                    int pos2 = separatorString.indexOf(" END");
                    if (pos2 > 0) {
                        String endSeparatorString = separatorString.substring(pos2 + 1).trim();
                        endSeparatorString = removePrefix(endSeparatorString, "END", true);
                        endSeparatorEx = parseExpression(endSeparatorString);
                        separatorString = separatorString.substring(0, pos2).trim();
                    }
                    separatorEx = parseExpression(separatorString);
                    expressionString = expressionString.substring(0, pos).trim();
                }
                Expression init = parseExpression(expressionString);
                I iterator = factory.createVariable(iterName, init);
                push(new InPlaceForCommand<I>(iterator, init, separatorEx, endSeparatorEx));
                resolver.pushLevel();
                resolver.add(iterator);
            } else if (expressionString.equals("ELSE")) {
                advanceState();
            } else if (expressionString.equals("ENDIF")) {
                result = close();
            } else if (expressionString.equals("ENDFOR")) {
                result = close();
                resolver.popLevel();
            } else {
                clear = false;
            }
            if (clear) {
                expressionString = null;
            }
        } 
        if (null != expressionString) {
            result = parseExpression(expressionString);
            if (isNonEmptyCommandStack()) {
                commandStack.peek().append(result);
                result = null;
            }
        }
        return result;
    }
    
    /**
     * Pushes an in-place command into its parent on the stace.
     * 
     * @param cmd the command to be pushed
     */
    private void push(InPlaceCommand<I> cmd) {
        if (null != commandStack) {
            if (!commandStack.isEmpty()) {
                commandStack.peek().append(cmd);
            }
            commandStack.push(cmd);
        }
    }
    
    /**
     * Returns whether the command stack exists and is not empty.
     * 
     * @return <code>true</code> for not empty, <code>false</code> else
     */
    private boolean isNonEmptyCommandStack() {
        return null != commandStack && !commandStack.isEmpty();
    }
    
    /**
     * Advances the state of the current in-place command.
     */
    private void advanceState() {
        if (isNonEmptyCommandStack()) {
            commandStack.peek().advanceState();
        }
    }
    
    /**
     * Closes the creation of the current in-place command.
     * 
     * @return the related expression, <b>null</b> for optional/none
     * @throws VilException in case that creation failed
     */
    private Expression close() throws VilException {
        Expression result = null;
        if (isNonEmptyCommandStack()) {
            InPlaceCommand<I> cur = commandStack.pop();
            result = cur.close(factory);
            if (null != result && isNonEmptyCommandStack()) {
                commandStack.peek().replace(cur, result);
            }
        }
        return result;
    }

    /**
     * Clears the statement stack and adds all expressions to <code>exprs</code>.
     * 
     * @param exprs the expression list to be filled
     */
    private void clearStatementStack(List<Expression> exprs) {
        if (null != commandStack) {
            while (!commandStack.isEmpty()) {
                InPlaceCommand<I> cmd = commandStack.pop();
                if (cmd.holdsResolverLevel()) {
                    resolver.popLevel();
                }
                if (commandStack.isEmpty()) {
                    // sufficient as all in-place commands on the stack are linked via appends
                    cmd.append(exprs);
                }
            }
        }
    }
    
    /**
     * Parses an expression from <code>expressionString</code>.
     * 
     * @param expressionString the string representation of the expression
     * @return
     * @throws VilException
     */
    private Expression parseExpression(String expressionString) throws VilException {
        Expression expr = translator.parseExpression(expressionString, resolver, warnings);
        if (expr instanceof VariableExpression) {
            VariableExpression e = (VariableExpression) expr;
            expr = new VariableEx(e.getDeclaration(), e.getQualifiedName());
        }
        return expr;
    }

    /**
     * Removes the given <code>prefix</code> from <code>text</code> if present. If <code>cutFollowingWhitespaces</code>
     * and whitespaces follow <code>prefix</code> in <code>text</code> remove also the whitespaces.
     * 
     * @param text the text to be manipulated
     * @param prefix the prefix to be removed
     * @param consumeFollowingWhitespaces if <code>true</code> remove also whitespaces occurring after 
     *   <code>prefix</code>, if <code>false </code> remove only the <code>prefix</code> if present
     * @return the modified string or <code>text</code>
     */
    private String removePrefix(String text, String prefix, boolean consumeFollowingWhitespaces) {
        String result = text;
        if (result.startsWith(prefix)) {
            // cut the prefix
            result = result.substring(prefix.length());
            if (consumeFollowingWhitespaces) {
                result = consumeWhitespaces(result);
            }
        }
        return result;
    }

    /**
     * Consumes all leading whitespaces in <code>text</code>.
     *  
     * @param text the text to consume the whitespaces
     * @return the text without leading whitespaces
     */
    private String consumeWhitespaces(String text) {
        return consume(text, ' ');
    }

    /**
     * Consumes all leading <code>ch</code> in <code>text</code>.
     *  
     * @param text the text to consume the characters
     * @param ch the character to consume
     * @return the text without leading <code>ch</code>
     */
    private String consume(String text, char ch) {
        String result = text;
        int pos = 0;
        while (pos < result.length() && ch == result.charAt(pos)) {
            pos++;
        }
        if (pos > 0) {
            result = result.substring(pos);
        }
        return result;
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

    @Override
    public void collect(IMessage message, EObject cause, EStructuralFeature causeFeature, int code) {
        if (Status.WARNING == message.getStatus()) {
            warnings.append(message);
        }
    }

}
