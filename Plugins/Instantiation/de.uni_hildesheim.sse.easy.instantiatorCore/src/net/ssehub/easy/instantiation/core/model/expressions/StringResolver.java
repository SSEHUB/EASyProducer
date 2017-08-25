package net.ssehub.easy.instantiation.core.model.expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import net.ssehub.easy.basics.messages.IMessage;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.dslCore.translation.IMessageReceiver;
import net.ssehub.easy.instantiation.core.model.common.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
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
    E extends ExpressionStatement> extends StringParser<CompositeExpression> implements IMessageReceiver {

    private IExpressionTranslator<I, R> translator;
    private R resolver;
    private StringBuilder warnings;
    private IStringResolverFactory<I> factory;
    private Stack<InPlaceCommand<I>> commandStack;
    private List<Expression> expressions = new ArrayList<Expression>();

    /**
     * The general interface of an expression translator.
     * 
     * @param <I> the actual variable declaration type
     * @param <R> the actual resolver type
     * @author Holger Eichelberger
     */
    public interface IExpressionTranslator<I extends VariableDeclaration, R extends Resolver<I>> {

        /**
         * Parse the given expression.
         * 
         * @param expression the expression as string
         * @param resolver the resolver
         * @param warnings a collector for warnings
         * @return the resulting expression
         * @throws VilException if problems occur while parsing / resolving
         */
        public Expression parseExpression(String expression, R resolver, StringBuilder warnings) 
            throws VilException;

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
    private StringResolver(String text, R resolver, IExpressionTranslator<I, R> translator, StringBuilder warnings, 
        IStringResolverFactory<I> factory) {
        super(text);
        this.warnings = warnings;
        this.resolver = resolver;
        this.translator = translator;
        this.factory = factory;
        if (null != factory) {
            commandStack = new Stack<InPlaceCommand<I>>();
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
        IExpressionTranslator<I, R> translator, StringBuilder warnings, IStringResolverFactory<I> factory) 
        throws VilException {
        CompositeExpression result;
        if (null != text) {
            try {
                StringResolver<I, R, E> replacer = new StringResolver<I, R, E>(text, resolver, translator, 
                    warnings, factory);
                if (text.contains("$")) {
                    result = replacer.parse();
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
    
    @Override
    protected CompositeExpression createParseResult() throws VilException {
        clearStatementStack();
        return new CompositeExpression(expressions);
    }
    
    @Override
    protected void handleQuote(int pos) throws VilException {
        // don't modify quotes, keep the text
    }
    
    @Override
    protected void handleTextEnd(int curStart, int pos) throws VilException {
        handleConstant(curStart, pos + 1);
    }
    
    @Override
    protected int handleVariableStartExpression(int curStart, int pos) throws VilException {
        handleConstant(curStart, pos - 1);
        return pos;
    }        

    @Override
    protected int handleVariableStartVariable(int curStart, int pos) throws VilException {
        handleConstant(curStart, pos - 1);
        return pos;
    }

    @Override
    protected int handleEndOfText(int curStart, int pos, State state) throws VilException {
        if (State.VARIABLE_START == state) {
            handleConstant(curStart, pos);
        }
        return pos;
    }

    /**
     * Adds the expression to the expression list or to the active in-place command on the command stack (if present).
     * 
     * @param expr  the expression that should be added to the list
     */
    private void addExpression(Expression expr) {
        if (null != expr) {
            if (isNonEmptyCommandStack()) {
                commandStack.peek().append(expr);
            } else {
                expressions.add(expr);
            }
        }
    }

    @Override
    protected int handleExpression(int curStart, int pos) throws VilException {
        Expression result = null;
        String expressionString = substring(curStart - 1, pos + 1);
        //remove leading ${ and trailing }; reg-ex fails with nested {}
        expressionString = expressionString.substring(2, expressionString.length() - 1); 
        //String pattern = "\\$\\{([^\\}]+)\\}"; // still needed? prevents recursive processing
        //expressionString = expressionString.replaceAll(pattern, "$1");
        if (null != factory) {
            boolean clear = true;
            if (expressionString.startsWith("IF")) {
                expressionString = removePrefix(expressionString, "IF", true);
                push(new InPlaceIfCommand<I>(parseExpression(expressionString)));
            } else if (expressionString.startsWith("FOR")) {
                expressionString = removePrefix(expressionString, "FOR", true);
                expressionString = consumeWhitespaces(expressionString);
                int pos1 = consumeJavaIdentifierPart(expressionString);
                String iterName = expressionString.substring(0, pos1);
                expressionString = consumeWhitespaces(expressionString.substring(pos1));
                if (expressionString.startsWith("=")) {
                    expressionString = consume(expressionString, '=');
                } else if (expressionString.startsWith(":")) {
                    expressionString = consume(expressionString, ':');
                }
                expressionString = consumeWhitespaces(expressionString);
                pos1 = expressionString.indexOf(" SEPARATOR");
                Expression separatorEx = null;
                Expression endSeparatorEx = null;
                if (pos1 > 0) {
                    String separatorString = expressionString.substring(pos1 + 1).trim();
                    separatorString = removePrefix(separatorString, "SEPARATOR", true);
                    int pos2 = separatorString.indexOf(" END");
                    if (pos2 > 0) {
                        String endSeparatorString = separatorString.substring(pos2 + 1).trim();
                        endSeparatorString = removePrefix(endSeparatorString, "END", true);
                        endSeparatorEx = parseExpression(endSeparatorString);
                        separatorString = separatorString.substring(0, pos2).trim();
                    }
                    separatorEx = parseExpression(separatorString);
                    expressionString = expressionString.substring(0, pos1).trim();
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
        addExpression(result);
        return pos + 1;
    }

    /**
     * Returns the last Java identifier part character in <code>string</code>.
     * 
     * @param string the string to search for
     * @return the position, <code>0</code> for none
     */
    private int consumeJavaIdentifierPart(String string) {
        int pos = 0;
        while (pos < string.length() && Character.isJavaIdentifierPart(string.charAt(pos))) {
            pos++;
        }
        return pos;
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
     */
    private void clearStatementStack() {
        if (null != commandStack) {
            while (!commandStack.isEmpty()) {
                InPlaceCommand<I> cmd = commandStack.pop();
                if (cmd.holdsResolverLevel()) {
                    resolver.popLevel();
                }
                if (commandStack.isEmpty()) {
                    // sufficient as all in-place commands on the stack are linked via appends
                    cmd.append(expressions);
                }
            }
        }
    }
    
    /**
     * Parses an expression from <code>expressionString</code>.
     * 
     * @param expressionString the string representation of the expression
     * @return the parsed expression
     * @throws VilException in case that parsing/creating the expression fails
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
     * Handle constant placeholder from <code>curStart</code> until <code>position</code>. 
     * 
     * @param curStart the current start position
     * @param position  the actual position in the text.
     * @throws VilException in case of evaluation problems
     */
    private void handleConstant(int curStart, int position) throws VilException {
        String string = substring(curStart, position);
        if (string.length() > 0) {
            addExpression(createConstantStringExpression(string));
        }
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
            list.add(createConstantStringExpression(string));
        }
        return list;
    }
    
    /**
     * Creates a constant String expression.
     * 
     * @param string the string to create the expression for
     * @return the constant expression representing string
     * @throws VilException in case of evaluation/creation problems
     */
    private Expression createConstantStringExpression(String string) throws VilException {
        return new ConstantExpression(TypeRegistry.stringType(), string, resolver.getTypeRegistry());
    }

    /**
     * Handle variable.
     * 
     * @param text the variable name
     * @return CompositeExpression containing the variable
     */
    protected CompositeExpression resolveVariable(String text) {
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

    @Override
    protected int handleVariable(int curStart, int pos) throws VilException {
        String variableName = substring(curStart - 1, pos);
        String pattern2 = "\\$([A-Za-z0-9]+)";
        variableName = variableName.replaceAll(pattern2, "$1");
        pos = setPos(replace(curStart - 1, pos, variableName));
        VariableDeclaration var = (VariableDeclaration) resolver.resolve(variableName, false, null, null, this);
        VariableExpression varExpr = null;
        if (var != null) {
            varExpr = new VariableExpression(var);
        }
        addExpression(varExpr);
        return pos;
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
