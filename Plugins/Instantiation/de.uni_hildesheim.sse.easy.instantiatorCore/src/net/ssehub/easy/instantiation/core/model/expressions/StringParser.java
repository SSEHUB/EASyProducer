/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.instantiation.core.model.expressions;

import java.util.List;
import java.util.Stack;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.messages.IMessageHandler;
import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * A generic parser and replacer for values (<i>$name</i>) and expressions (<i>${expression}</i>) in strings.
 * Provides only the parsing mechanism to be re-used by the VTL parser and VTL runtime file processor.
 * 
 * @param <P> the parse result type
 * @param <I> the actual variable declaration type
 * @param <R> the actual resolver type
 * @author Holger Eichelberger
 */
public abstract class StringParser<P, I extends VariableDeclaration, R extends Resolver<I>> {

    /**
     * The parser states.
     * 
     * @author Holger Eichelberger
     */
    protected enum State {

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
    private int pos;
    private int curStart;
    private int innerBracketLevel;
    private IStringParserFactory<I> factory;
    private Stack<InPlaceCommand<I>> commandStack;
    private R resolver;

    /**
     * Creates a string parser instance for the given text.
     * 
     * @param text the text to parse (may be <b>null</b>)
     * @param resolver the resolver to be used
     * @param factory a factory turning in-place commands into language-specific expressions (may be <b>null</b>, then 
     *     in-place commands are not resolved but remain as string expressions)
     */
    protected StringParser(String text, R resolver, IStringParserFactory<I> factory) {
        if (null != text) {
            this.text = new StringBuilder(text);
        } else {
            this.text = null;
        }
        this.resolver = resolver;
        this.factory = factory;
        if (null != factory) {
            commandStack = new Stack<InPlaceCommand<I>>();
        }
    }
    
    /**
     * Returns the resolver factory.
     * 
     * @return the factory
     */
    protected IStringParserFactory<I> getFactory() {
        return factory;
    }
    
    /**
     * Returns the resolver.
     * 
     * @return the resolver
     */
    protected R getResolver() {
        return resolver;
    }
    
    /**
     * Parses for the variables in <code>text</code>.
     * 
     * @return the modified <code>text</code>
     * @throws VilException in case that something goes wrong while resolving variables
     *             
     * @see #handleVariableStartExpression(int, int)
     * @see #handleVariableStartVariable(int, int)
     * @see #handleEndOfText(int, int, State)
     * @see #handleExpression(int, int)
     * @see #handleVariable(int, int)
     * @see #createParseResult()
     */
    public P parse() throws VilException {
        pos = 0;
        curStart = 0;
        State state = State.TEXT;
        while (pos < text.length()) { // text length may change during processing
            char c = text.charAt(pos);
            switch (state) {
            case TEXT:
                if ('$' == c) {
                    if (pos > 0 && '\\' == text.charAt(pos - 1)) {
                        handleQuote(pos - 1);
                        state = State.TEXT; // stay, quote
                    } else {
                        state = State.VARIABLE_START;
                    }
                }
                if (pos == text.length() - 1 && state == State.TEXT) { // In case we are at the end of the line
                    handleTextEnd(curStart, pos);
                }
                break;
            case VARIABLE_START:
                if ('{' == c) {
                    state = State.EXPRESSION;
                    setCurStart(handleVariableStartExpression(curStart, pos));
                } else if (Character.isJavaIdentifierStart(c)) { // preliminary -> VIL
                    state = State.VARIABLE;
                    setCurStart(handleVariableStartVariable(curStart, pos));
                } else {
                    state = State.TEXT;
                }
                break;
            case VARIABLE:
                if (!Character.isJavaIdentifierPart(c) || c == '$') {
                    if (pos > curStart && ':' == c && pos + 1 < text.length() && ':' == text.charAt(pos + 1)) {
                        // is it a qualified IVML variable name, i.e., a path separator ::
                        pos += 2;
                    } else {
                        setCurStart(handleVariable(curStart, pos));
                        state = State.TEXT;
                        pos--;
                    }
                }
                break;
            case EXPRESSION:
                if ('{' == c) {
                    innerBracketLevel++;
                } else if ('}' == c) {
                    if (0 == innerBracketLevel) {
                        setCurStart(handleExpression(curStart, pos));
                        state = State.TEXT;
                        if (isNonEmptyCommandStack()) {
                            notifyBracketsClosed(commandStack.peek(), pos);
                        }
                        pos--;
                    } else {
                        innerBracketLevel--;
                    }
                }
                break;
            default:
                getLogger().error("illegal string parsing state " + state);
                break;
            }
            pos++;
        }
        return completeParsing(state);
    }
    
    /**
     * Handles in-place commands and pushes them onto the command stack.
     * 
     * @param expressionString the expression string to be analyzed
     * @param curStart the start position of the current concept
     * @param pos the end position of parsing
     * @return the corresponding expression
     * @throws VilException in case of parsing problems
     */
    protected Expression handleInPlaceCommands(String expressionString, int curStart, int pos) throws VilException {
        Expression result = null;
        if (null != factory && Character.isUpperCase(expressionString.charAt(0))) { // 2nd, for performance
            boolean clear = true;
            if (expressionString.startsWith("IF ")) {
                expressionString = removePrefix(expressionString, "IF", true);
                push(new InPlaceIfCommand<I>(parseExpression(expressionString)), curStart, pos);
            } else if (expressionString.startsWith("FOR ")) {
                expressionString = handleInPlaceForStart(expressionString, curStart, pos);
            } else if (expressionString.startsWith("VAR ")) {
                expressionString = handleInPlaceVarDecl(expressionString, curStart, pos);
                result = close(curStart, pos);
            } else if (expressionString.startsWith("IMPORT ")) {
                expressionString = handleInPlaceImport(expressionString, curStart, pos);
                result = close(curStart, pos);
            } else if (expressionString.equals("ELSE")) {
                advanceState(curStart, pos);
            } else if (expressionString.equals("ENDIF")) {
                result = close(curStart, pos);
            } else if (expressionString.equals("ENDFOR")) {
                result = close(curStart, pos);
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
     * Handles/parses an in-place for-loop start.
     * 
     * @param expressionString the expression string
     * @param curStart the start position of the current concept
     * @param pos the end position of parsing
     * @return the remaining expression string
     */
    private String handleInPlaceForStart(String expressionString, int curStart, int pos) {
        String result;
        try {
            result = removePrefix(expressionString, "FOR", true);
            result = consumeWhitespaces(result);
            int pos1 = consumeJavaIdentifierPart(result);
            String iterName = result.substring(0, pos1);
            result = consumeWhitespaces(result.substring(pos1));
            if (result.startsWith("=")) {
                result = consume(result, '=');
            } else if (result.startsWith(":")) {
                result = consume(result, ':');
            }
            result = consumeWhitespaces(result);
            pos1 = result.indexOf(" SEPARATOR");
            Expression separatorEx = null;
            Expression endSeparatorEx = null;
            if (pos1 > 0) {
                String separatorString = result.substring(pos1 + 1).trim();
                separatorString = removePrefix(separatorString, "SEPARATOR", true);
                int pos2 = separatorString.indexOf(" END");
                if (pos2 > 0) {
                    String endSeparatorString = separatorString.substring(pos2 + 1).trim();
                    endSeparatorString = removePrefix(endSeparatorString, "END", true);
                    endSeparatorEx = parseExpression(endSeparatorString);
                    separatorString = separatorString.substring(0, pos2).trim();
                }
                separatorEx = parseExpression(separatorString);
                result = result.substring(0, pos1).trim();
            }
            Expression init = parseExpression(result);
            I iterator = factory.createVariable(iterName, init, true);
            push(new InPlaceForCommand<I>(iterator, init, separatorEx, endSeparatorEx), curStart, pos);
            resolver.pushLevel();
            resolver.add(iterator);
        } catch (VilException e) {
            warnParsingIgnoring(expressionString, e);
            result = expressionString; // just keep it
        }
        return result;
    }

    /**
     * Handles/parses an in-place variable declaration start.
     * 
     * @param expressionString the expression string
     * @param curStart the start position of the current concept
     * @param pos the end position of parsing
     * @return the remaining expression string
     */
    private String handleInPlaceVarDecl(String expressionString, int curStart, int pos) {
        String result;
        try {
            result = removePrefix(expressionString, "VAR", true);
            int pos1 = consumeJavaIdentifierPart(result);
            String varName = result.substring(0, pos1);
            result = consumeWhitespaces(result.substring(pos1));
            if (result.startsWith("=")) {
                result = consume(result, '=');
            }                
            result = consumeWhitespaces(result);
            Expression init = parseExpression(result);
            if (null == init) {
                throw new VilException("Initialization expression missing / not resolved.", VilException.ID_INVALID);
            }
            I var = factory.createVariable(varName, init, false);
            push(new InPlaceVarDeclCommand<I>(var), curStart, pos);
        } catch (VilException e) {
            warnParsingIgnoring(expressionString, e);
            result = expressionString; // just keep it
        }
        return result;
    }

    /**
     * Handles/parses an in-place import.
     * 
     * @param expressionString the expression string
     * @param curStart the start position of the current concept
     * @param pos the end position of parsing
     * @return the remaining expression string
     */
    private String handleInPlaceImport(final String expressionString, int curStart, int pos) {
        String result;
        try {
            result = removePrefix(expressionString, "IMPORT", true);
            int pos1 = consumeJavaIdentifierPart(result);
            String name = result.substring(0, pos1);
            result = consumeWhitespaces(result.substring(pos1));
            IVersionRestriction restriction = null;
            if (result.startsWith("WITH")) {
                result = result.substring(4);
                I var = factory.createVariableDeclaration("version", TypeRegistry.versionType());
                resolver.pushLevel();
                resolver.add(var);
                Expression expression = parseExpression(result);
                resolver.popLevel();

                ExpressionVersionRestrictionValidator validator = new ExpressionVersionRestrictionValidator(
                    new IMessageHandler() {
                        
                        @Override
                        public void handle(String message, boolean error, int code) {
                            getLogger().warn("While parsing/resolving '" + expressionString + "': " + message 
                                + ". Ignoring.");
                        }
                    });
                expression.accept(validator);
                restriction = factory.createVersionRestriction(expression, var);
                result = consumeWhitespaces(result);
            }                
            push(new InPlaceImportCommand<I>(name, restriction), curStart, pos);
        } catch (VilException e) {
            warnParsingIgnoring(expressionString, e);
            result = expressionString; // just keep it
        }
        return result;
    }

    /**
     * Joins the results from {@link #handleInPlaceCommands(String, int, int)} with the current command stack. 
     * For temporary use only, as the result may be a {@link CompositeExpression}, which leads to specific
     * code formattings.
     * 
     * @param expr the expression returned by {@link #handleInPlaceCommands(String, int, int)}
     * @return <code>expr</code> or the result from the command stack
     */
    protected Expression join(Expression expr) {
        Expression result = expr;
        return result;
    }

    /**
     * Parses an expression from <code>expressionString</code>.
     * 
     * @param expressionString the string representation of the expression
     * @return the parsed expression
     * @throws VilException in case that parsing/creating the expression fails
     * @see #parseExpressionImpl(String)
     */
    protected Expression parseExpression(String expressionString) throws VilException {
        Expression result = parseExpressionImpl(expressionString);
        if (result instanceof VariableExpression) {
            VariableExpression e = (VariableExpression) result;
            result = new VariableEx(e.getDeclaration(), e.getQualifiedName());
        }
        return result;
    }
    
    /**
     * Parses an expression from <code>expressionString</code>.
     * 
     * @param expressionString the string representation of the expression
     * @return the parsed expression
     * @throws VilException in case that parsing/creating the expression fails
     */
    protected abstract Expression parseExpressionImpl(String expressionString) throws VilException;
    
    /**
     * Creates a constant String expression.
     * 
     * @param string the string to create the expression for
     * @return the constant expression representing string
     * @throws VilException in case of evaluation/creation problems
     */
    protected Expression createConstantStringExpression(String string) throws VilException {
        return new ConstantExpression(TypeRegistry.stringType(), string, getResolver().getTypeRegistry());
    }
    
    /**
     * Advances the state of the current in-place command.
     * 
     * @param curStart the start position of the current concept
     * @param pos the end position of parsing
     */
    private void advanceState(int curStart, int pos) {
        if (isNonEmptyCommandStack()) {
            InPlaceCommand<I> cur = commandStack.peek();
            cur.advanceState();
            notifyStartInPlaceCommand(cur, curStart, pos);
        }
    }
    
    /**
     * Closes the creation of the current in-place command.
     * 
     * @param curStart the start position of the current concept
     * @param pos the end position of parsing
     * @return the related expression, <b>null</b> for optional/none
     * @throws VilException in case that creation failed
     */
    private Expression close(int curStart, int pos) throws VilException {
        Expression result = null;
        if (isNonEmptyCommandStack()) {
            InPlaceCommand<I> cur = commandStack.pop();
            result = cur.close(factory);
            if (null != result && isNonEmptyCommandStack()) {
                commandStack.peek().replace(cur, result);
            }
            notifyEndInPlaceCommand(cur, result, curStart, pos);
        }
        return result;
    }

    /**
     * Clears the statement stack and adds all expressions to <code>exprs</code>.
     * 
     * @param expressions expressions collection to be modified
     */
    protected void clearStatementStack(List<Expression> expressions) {
        if (null != commandStack) {
            while (!commandStack.isEmpty()) {
                popFromCommandStack(expressions);
            }
        }
    }

    /**
     * Removes the top-level element from the command stack and appends its contents to <code>expressions</code>.
     * 
     * @param expressions expressions collection to be modified
     */
    protected void popFromCommandStack(List<Expression> expressions) {
        InPlaceCommand<I> cmd = commandStack.pop();
        if (cmd.holdsResolverLevel()) {
            resolver.popLevel();
        }
        if (commandStack.isEmpty()) {
            // sufficient as all in-place commands on the stack are linked via appends
            cmd.append(expressions);
        }
    }
    
    /**
     * Adds the expression to the expression list or to the active in-place command on the command stack (if present).
     * 
     * @param expr  the expression that should be added to the list
     * @param expressions expressions collection to be modified 
     */
    protected void addExpression(Expression expr, List<Expression> expressions) {
        if (null != expr) {
            if (isNonEmptyCommandStack()) {
                commandStack.peek().append(expr);
            } else {
                expressions.add(expr);
            }
        }
    }
    
    /**
     * Returns whether the command stack exists and is not empty.
     * 
     * @return <code>true</code> for not empty, <code>false</code> else
     */
    protected boolean isNonEmptyCommandStack() {
        return null != commandStack && !commandStack.isEmpty();
    }
    
    /**
     * Pushes an in-place command into its parent on the command stack.
     * 
     * @param cmd the command to be pushed
     * @param curStart the start position of the current concept
     * @param pos the end position of parsing
     */
    private void push(InPlaceCommand<I> cmd, int curStart, int pos) {
        if (null != commandStack) {
            if (!commandStack.isEmpty()) {
                commandStack.peek().append(cmd);
            }
            commandStack.push(cmd);
            notifyStartInPlaceCommand(cmd, curStart, pos);
        }
    }
    
    /**
     * Returns the current in-place command on the command stack.
     * 
     * @return the current in-place command or <b>null</b>
     */
    protected InPlaceCommand<I> getCurrentInPlaceCommand() {
        InPlaceCommand<I> result;
        if (isNonEmptyCommandStack()) {
            result = commandStack.peek();
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Notifies about start parsing an in-place command. If a command consists of a middle part (if-else), then
     * this function is called twice/multiple times for the same command.
     * 
     * @param cmd the current in-place command
     * @param curStart the start position of the current concept
     * @param pos the end position of parsing
     */
    protected void notifyStartInPlaceCommand(InPlaceCommand<I> cmd, int curStart, int pos) {
    }
    
    /**
     * Called to notify that all bracket levels for an expression within an in-place command are closed 
     * at <code>pos</code>.
     * 
     * @param cmd the current in-place command
     * @param pos the end position of parsing
     */
    protected void notifyBracketsClosed(InPlaceCommand<I> cmd, int pos) {
    }

    /**
     * Notifies that parsing an in-place command ended.
     * 
     * @param cmd the current in-place command
     * @param expr the resulting expression
     * @param curStart the start position of the current concept
     * @param pos the end position of parsing
     */
    protected void notifyEndInPlaceCommand(InPlaceCommand<I> cmd, Expression expr, int curStart, int pos) {
    }

    /**
     * Returns the last Java identifier part character in <code>string</code>.
     * 
     * @param string the string to search for
     * @return the position, <code>0</code> for none
     */
    protected int consumeJavaIdentifierPart(String string) {
        int pos = 0;
        while (pos < string.length() && Character.isJavaIdentifierPart(string.charAt(pos))) {
            pos++;
        }
        return pos;
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
    protected String removePrefix(String text, String prefix, boolean consumeFollowingWhitespaces) {
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
    protected String consumeWhitespaces(String text) {
        return consume(text, ' ');
    }

    /**
     * Consumes all leading <code>ch</code> in <code>text</code>.
     *  
     * @param text the text to consume the characters
     * @param ch the character to consume
     * @return the text without leading <code>ch</code>
     */
    protected String consume(String text, char ch) {
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
     * Completes the parsing at the end of the input string.
     * 
     * @param state the actual state
     * @return the parsing result
     * @throws VilException in case of evaluation problems
     */
    private P completeParsing(State state) throws VilException {
        switch (state) {
        case VARIABLE:
            handleVariable(curStart, pos);
            break;
        case EXPRESSION:
            if (pos < text.length() && '}' == text.charAt(pos) && 0 == innerBracketLevel) {
                handleExpression(curStart, pos);
            }
            break;
        default:
            handleEndOfText(curStart, pos, state);
            break;
        }
        return createParseResult();        
    }

    /**
     * Returns the logger.
     * 
     * @return the logger
     */
    protected EASyLogger getLogger() {
        return EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID);
    }
    
    /**
     * Logs a parse warning message that the <code>detail</code> is being ignored.
     * 
     * @param detail the detail
     * @param th the reason for the warning
     */
    protected void warnParsingIgnoring(String detail, Throwable th) {
        getLogger().warn("While parsing/resolving '" + detail + "': " + th.getMessage() + ". Ignoring.");
    }
    
    /**
     * Changes the current/next start position.
     * 
     * @param pos the position, ignored if negative
     */
    private void setCurStart(int pos) {
        if (pos >= 0) {
            curStart = pos;
        }
    }
    
    /**
     * Changes the current position. Handle with care.
     * 
     * @param pos the new current position
     * @return <code>pos</code>
     */
    protected int setPos(int pos) {
        this.pos = pos;
        return this.pos;
    }
    
    /**
     * Turns the internal parse buffer into a string.
     * 
     * @return the string contents of the parse buffer
     */
    protected String toText() {
        return text.toString();
    }

    /**
     * Returns the substring from the internal text buffer at the given positions.
     * 
     * @param start the start position (inclusive)
     * @param end the end position (exclusive)
     * @return the character
     * @throws IndexOutOfBoundsException if <code>start&lt;0 || start&gt;={@link #length()} || end&lt;0 
     *     || end&gt;={@link #length()}</code>
     */
    protected String substring(int start, int end) {
        return text.substring(start, end);
    }
    
    /**
     * Deletes the given character from the internal parse buffer.
     * 
     * @param pos the position to delete the character at
     * @throws IndexOutOfBoundsException if <code>pos&lt;0 || pos&gt;={@link #length()}</code>
     */
    protected void deleteCharAt(int pos) {
        text.deleteCharAt(pos);
    }

    /**
     * Deletes the given characters from the internal parse buffer.
     * 
     * @param start the start position to delete, inclusive
     * @param end the end position to delete, exclusive
     * @throws IndexOutOfBoundsException if <code>start&lt;0 || start&gt;={@link #length()} 
     *     || end&lt;0 || end&gt;={@link #length()}</code>
     */
    protected void delete(int start, int end) {
        text.delete(start, end);
    }

    /**
     * Returns the actual length of the internal parse buffer.
     * 
     * @return the length of the parse buffer in characters.
     */
    protected int length() {
        return text.length();
    }

    /**
     * Returns the character of the internal text buffer at position <code>pos</code>.
     * 
     * @param pos the position
     * @return the character
     * @throws IndexOutOfBoundsException if <code>pos&lt;0 || pos&gt;={@link #length()}</code>
     */
    protected char charAt(int pos) {
        return text.charAt(pos);
    }
    
    /**
     * Replaces text in the parse buffer and adjusts the position.
     * 
     * @param start
     *            the start position for the replacement in <code>text</code>
     * @param end
     *            the end position for the replacement in <code>text</code> (inclusive)
     * @param value
     *            the replacement for the specified fragment
     * @return end, but adjusted to the replacement
     */
    protected int replace(int start, int end, String value) {
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

    /**
     * Called to handle a quote character at <code>pos</code> (beginning) of the internal parse buffer.
     * 
     * @param pos the position within the parse buffer
     * @throws VilException in case of evaluation problems
     */
    protected abstract void handleQuote(int pos) throws VilException;

    /**
     * Handles the end of the text if there is no variable/expression.
     * 
     * @param start the start position
     * @param pos the actual position (end of text)
     * @throws VilException in case of evaluation problems
     */
    protected abstract void handleTextEnd(int start, int pos) throws VilException;

    /**
     * Handles the transition from state {@link State#VARIABLE_START} to {@link State#EXPRESSION}. 
     * 
     * @param start the start position
     * @param pos the actual position
     * @return the next start position (typically <code>pos</code>, ignored if negative)
     * @throws VilException in case of evaluation problems
     */
    protected abstract int handleVariableStartExpression(int start, int pos) throws VilException;

    /**
     * Handles the transition from state {@link State#VARIABLE_START} to {@link State#VARIABLE}. 
     * 
     * @param start the start position
     * @param pos the actual position
     * @return the next start position (typically <code>pos</code>, ignored if negative)
     * @throws VilException in case of evaluation problems
     */
    protected abstract int handleVariableStartVariable(int start, int pos) throws VilException;

    /**
     * Handles the very end of text at so far unhandled state.
     * 
     * @param start the start position
     * @param pos the current position
     * @param state the current state
     * @return the next start position (typically <code>pos</code>, ignored if negative)
     * @throws VilException in case of evaluation problems
     */
    protected abstract int handleEndOfText(int start, int pos, State state) throws VilException;
    
    /**
     * Creates the result of parsing a string.
     * 
     * @return the result
     * @throws VilException in case of evaluation problems
     * @see #parse()
     */
    protected abstract P createParseResult() throws VilException;

    /**
     * Handle a variable placeholder. <code>start</code> points to "$",
     * <code>pos</code> to the end position of the variable name.
     * 
     * @param start the start position
     * @param pos the actual/end position
     * @throws VilException in case of evaluation problems
     * @return the next start position (typically <code>pos</code>, ignored if negative)
     * @see #parse()
     */
    protected abstract int handleVariable(int start, int pos) throws VilException;

    /**
     * Handle an expression placeholder. <code>start</code> points to "${",
     * <code>pos</code> to "}". name.
     * 
     * @param start the start position
     * @param pos the actual/end position
     * @throws VilException in case of evaluation problems
     * @return the next start position (typically <code>pos</code>, ignored if negative)
     * @see #parse()
     */
    protected abstract int handleExpression(int start, int pos) throws VilException;

}
