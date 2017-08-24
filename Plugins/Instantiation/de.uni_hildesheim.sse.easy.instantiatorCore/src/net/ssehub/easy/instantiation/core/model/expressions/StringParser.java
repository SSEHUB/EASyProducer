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

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * A generic parser and replacer for values (<i>$name</i>) and expressions (<i>${expression}</i>) in strings.
 * Provides only the parsing mechanism to be re-used by the VTL parser and VTL runtime file processor.
 * 
 * @param <R> the parse result type
 * @author Holger Eichelberger
 */
public abstract class StringParser <R> {

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

    /**
     * Creates a string parser instance for the given text.
     * 
     * @param text the text to parse (may be <b>null</b>)
     */
    protected StringParser(String text) {
        if (null != text) {
            this.text = new StringBuilder(text);
        } else {
            this.text = null;
        }
    }
    
    /**
     * Parses for the variables in <code>text</code>.
     * 
     * @return the modified <code>text</code>
     * @throws VilException in case that something goes wrong while resolving variables
     *             
     * @see #handleVariableStartExpression(int)
     * @see #handleVariableStartVariable(int)
     * @see #handleEndOfText(int, State)
     * @see #handleExpression(int)
     * @see #handleVariable(int)
     * @see #createParseResult(State)
     */
    public R parse() throws VilException {
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
                    setCurStart(handleVariable(curStart, pos));
                    state = State.TEXT;
                    pos--;
                }
                break;
            case EXPRESSION:
                if ('{' == c) {
                    innerBracketLevel++;
                } else if ('}' == c) {
                    if (0 == innerBracketLevel) {
                        setCurStart(handleExpression(curStart, pos));
                        state = State.TEXT;
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
     * Completes the parsing at the end of the input string.
     * 
     * @param state the actual state
     * @return the parsing result
     * @throws VilException in case of evaluation problems
     */
    private R completeParsing(State state) throws VilException {
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
    private EASyLogger getLogger() {
        return EASyLoggerFactory.INSTANCE.getLogger(StringReplacer.class, Bundle.ID);
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
     * @throws IndexOutOfBoundsException if <code>start&lt;0 || start&gt;={@link #getTextLength()} || end&lt;0 
     *     || end&gt;={@link #getTextLength()}</code>
     */
    protected String substring(int start, int end) {
        return text.substring(start, end);
    }
    
    /**
     * Deletes the given character from the internal parse buffer.
     * 
     * @param pos the position to delete the character at
     * @throws IndexOutOfBoundsException if <code>pos&lt;0 || pos&gt;={@link #getTextLength()}</code>
     */
    protected void deleteCharAt(int pos) {
        text.deleteCharAt(pos);
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
     * @throws IndexOutOfBoundsException if <code>pos&lt;0 || pos&gt;={@link #getTextLength()}</code>
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
    protected abstract R createParseResult() throws VilException;

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
