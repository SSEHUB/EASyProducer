/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch;

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.types.selectors.SelectorUtils;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IFileSystemArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.StringValueHelper;

/**
 * Path matching expressions.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractPathRuleMatchExpression extends AbstractRuleMatchExpression {

    private static final char MULTIPLE_CHAR_MATCH_CHAR = '*';
    private static final char SINGLE_CHAR_MATCH_CHAR = '?';
    private static final char NORMALIZED_FILE_SEPARATOR_CHAR = '/';
    
    private static final String MULTIPLE_CHAR_MATCH = String.valueOf(MULTIPLE_CHAR_MATCH_CHAR);
    private static final String SINGLE_CHAR_MATCH = String.valueOf(SINGLE_CHAR_MATCH_CHAR);
    private static final String NORMALIZED_FILE_SEPARATOR = String.valueOf(NORMALIZED_FILE_SEPARATOR_CHAR);

    private static final int INDEX_LEFT = 0;
    private static final int INDEX_RIGHT = 1;
    
    /**
     * Returns the resolved expression.
     * 
     * @return the resolved expression
     */
    protected abstract Path getResolved();
 
    @Override
    public Object determineExpected(AbstractRuleMatchExpression rhsExpr, Object rhsValue) throws VilException {
        IFileSystemArtifact result = null;
        if (null != getResolved()) {
            // no absolute paths in here
            Path resultPath = null;
            String lhsPath = getResolved().getPath();
            List<String> lhsTokens = tokenize(lhsPath, false);
            if (containsWildcards(lhsTokens)) {
                if (rhsExpr instanceof AbstractPathRuleMatchExpression) {
                    AbstractPathRuleMatchExpression rhsRule = (AbstractPathRuleMatchExpression) rhsExpr;
                    if (null != rhsRule.getResolved()) {
                        String rhsPath = rhsRule.getResolved().getPath();
                        String rhsValueText = StringValueHelper.getStringValue(rhsValue, null);
                        //if (SelectorUtils.match(rhsPath, rhsValueText)) {
                        List<String> rhsTokens = tokenize(rhsPath, false);
                        match(rhsTokens, rhsValueText);
                        String lhs = replaceWildcards(lhsTokens, rhsTokens);
                        resultPath = new Path(lhs, getResolved().getArtifactModel());
                        //}
                    }
                }
            } else {
                resultPath = getResolved();
            }
            if (null != resultPath) {
                result = ArtifactFactory.createArtifact(IFileSystemArtifact.class, resultPath.getAbsolutePath(), 
                    resultPath.getArtifactModel());
            }
        }
        return result;
    }
    
    @Override
    public boolean contributesTo(AbstractRuleMatchExpression expression) {
        boolean result = false;
        if (null != getResolved()) {
            String lhsPath = getResolved().getPath();
            if (expression instanceof AbstractPathRuleMatchExpression) {
                AbstractPathRuleMatchExpression rhsRule = (AbstractPathRuleMatchExpression) expression;
                if (null != rhsRule.getResolved()) {
                    String rhsPath = rhsRule.getResolved().getPath();
                    result = overlaps(lhsPath, rhsPath);
                }             
            }
        }
        return result;
    }
    
    /**
     * Defines matching states.
     * 
     * @author Holger Eichelberger
     */
    private enum MatchState {
        
        /**
         * Match the exact character at the given position.
         */
        EXACT_CHAR(0),
        
        /**
         * Match a single wildcard character on ?
         */
        MATCH_SINGLE_CHAR(0),
        
        /**
         * Matches multiple characters at **.
         */
        MATCH_MULTI_CHAR(1),
        
        /**
         * Matches deep paths.
         */
        MATCH_DEEP_PATH(2);
        
        private int offset;
        
        /**
         * Creates a new instance.
         * 
         * @param offset the offset (for skipping the underlying wildcard)
         */
        private MatchState(int offset) {
            this.offset = offset;
        }
        
        /**
         * Returns the offset for this match state.
         * 
         * @return the offset (for skipping underlying wildcard in case of try-and-backtrack, 
         *     <code>0</code> if no skipping is required)
         */
        public int getOffset() {
            return offset;
        }
    }

    /**
     * Returns whether the <code>leftPattern</code> and <code>rightPattern</code> match, i.e., whether the 
     * matches on one side can be considered as the same or a subset of the matches on the other side.
     * 
     * @param leftPattern the first pattern to match (LHS)
     * @param rightPattern the right pattern to match (RHS)
     * @return <code>true</code> if the patterns overlap, <code>false</code> else
     */
    public static boolean overlaps(String leftPattern, String rightPattern) {
        boolean result = false;
        if (leftPattern.length() > 0 && rightPattern.length() > 0) {
            leftPattern = preparePattern(leftPattern);
            rightPattern = preparePattern(rightPattern);
            result = overlaps(leftPattern, 0, rightPattern, 0);
        }
        return result;
    }
    
    /**
     * Returns whether the <code>leftPattern</code> and <code>rightPattern</code> match, i.e., whether the 
     * matches on one side can be considered as the same or a subset of the matches on the other side.
     * This method executes the implied recognizing state machines in intertwined fashion
     * and stops as soon as no match is possible anymore.
     * 
     * @param leftPattern the first pattern to match (LHS)
     * @param lPos the position to start from within <code>leftPattern</code>
     * @param rightPattern the right pattern to match (RHS)
     * @param rPos the position to start from within <code>rightPattern</code>
     * @return <code>true</code> if the patterns overlap, <code>false</code> else
     */
    public static boolean overlaps(String leftPattern, int lPos, String rightPattern, int rPos) {
        boolean result = false;
        boolean fail = false;
        int[] pos = new int[2];
        pos[INDEX_LEFT] = lPos;
        pos[INDEX_RIGHT] = rPos;
        MatchState lState = determineState(leftPattern, pos[INDEX_LEFT]);
        MatchState rState = determineState(rightPattern, pos[INDEX_RIGHT]);
        while (pos[INDEX_LEFT] < leftPattern.length() && pos[INDEX_RIGHT] < rightPattern.length() && !fail && !result) {
            int lastP = pos[INDEX_LEFT];
            int lastR = pos[INDEX_RIGHT];            
            char pChar = leftPattern.charAt(pos[INDEX_LEFT]);
            char rChar = rightPattern.charAt(pos[INDEX_RIGHT]);
            // in fact, the decisions follow a symmetric matrix but not realized so far - needs to be rewritten
            if (MatchState.EXACT_CHAR == rState) {
                if (MatchState.EXACT_CHAR == lState) {
                    if (pChar == rChar) {
                        pos[INDEX_LEFT]++;
                        pos[INDEX_RIGHT]++;
                    } else {
                        fail = true;
                    }
                } else {
                    pos[INDEX_RIGHT]++;
                    if (lState == MatchState.MATCH_SINGLE_CHAR) {
                        pos[INDEX_LEFT]++;
                    } else {
                        result = tryAndTrackBack(leftPattern, lState, rightPattern, rState, pos);
                    }
                }
            } else if (MatchState.MATCH_SINGLE_CHAR == rState) {
                pos[INDEX_RIGHT]++;
                if (MatchState.EXACT_CHAR == lState || MatchState.MATCH_SINGLE_CHAR == lState) {
                    pos[INDEX_LEFT]++;
                } else {
                    result = tryAndTrackBack(leftPattern, lState, rightPattern, rState, pos);
                }
            } else if (MatchState.MATCH_MULTI_CHAR == rState) {
                if (MatchState.EXACT_CHAR == lState || MatchState.MATCH_SINGLE_CHAR == lState) {
                    pos[INDEX_LEFT]++;
                    result = tryAndTrackBack(leftPattern, lState, rightPattern, rState, pos);
                } else {
                    result = tryAndTrackBack(leftPattern, lState, rightPattern, rState, pos);
                    fail = !result;
                }
            } else if (MatchState.MATCH_DEEP_PATH == rState) {
                if (MatchState.EXACT_CHAR == lState || MatchState.MATCH_SINGLE_CHAR == lState) {
                    pos[INDEX_LEFT]++;
                    result = tryAndTrackBack(leftPattern, lState, rightPattern, rState, pos);
                } else {
                    result = tryAndTrackBack(leftPattern, lState, rightPattern, rState, pos);
                    fail = !result;
                }
            }
            if (!fail) {
                lState = determineNextState(leftPattern, pos[INDEX_LEFT], lastP, lState);
                rState = determineNextState(rightPattern, pos[INDEX_RIGHT], lastR, rState);
            }
        }
        if (!result && !fail) {
            result = pos[INDEX_LEFT] >= leftPattern.length() && pos[INDEX_RIGHT] >= rightPattern.length();
        }
        return result; //TODO does not consider proper ending of ** at / at the moment
    }
    
    /**
     * Tries a match at the offsets determined by the states and tracks back if the match
     * cannot be made.
     * 
     * @param leftPattern the left pattern
     * @param leftState the matching state for the left pattern
     * @param rightPattern the right pattern
     * @param rightState the matching state for the right pattern
     * @param pos the current positions, at index 0 for left pattern, at index 1 for right
     * @return <code>true</code> if a match was found at the given positions, <code>false</code> else
     */
    private static boolean tryAndTrackBack(String leftPattern, MatchState leftState, String rightPattern, 
        MatchState rightState, int[] pos) {
        boolean result = false;
        int pOffset = leftState.getOffset();
        int rOffset = rightState.getOffset();
        // skip the wildcard on left side
        if (pOffset > 0) {
            result = overlaps(leftPattern, pos[INDEX_LEFT] + pOffset, rightPattern, pos[INDEX_RIGHT]);
        }
        // skip the wildcard on right side
        if (!result && rOffset > 0) {
            result = overlaps(leftPattern, pos[INDEX_LEFT], rightPattern, pos[INDEX_RIGHT] + rOffset);
        }
        // skip the wildcard on both sides
        if (!result && rOffset > 0 && pOffset > 0 ) {
            result = overlaps(leftPattern, pos[INDEX_LEFT] + pOffset, rightPattern, pos[INDEX_RIGHT] + rOffset);
        }                    
        return result;
    }

    /**
     * Prepares the given pattern conventions.
     * 
     * @param pattern the pattern to be prepared
     * @return the prepared pattern, may be <code>pattern</code> if nothing is changed
     */
    private static String preparePattern(String pattern) {
        pattern = pattern.trim();
        // shall already be normalized but just to be sure
        pattern = pattern.replace('\\', NORMALIZED_FILE_SEPARATOR_CHAR);
        pattern = pattern.replace(NORMALIZED_FILE_SEPARATOR + NORMALIZED_FILE_SEPARATOR, NORMALIZED_FILE_SEPARATOR);
        // see http://ant.apache.org/manual/dirtasks.html
        if (pattern.endsWith(NORMALIZED_FILE_SEPARATOR)) {
            pattern += SelectorUtils.DEEP_TREE_MATCH;
        }
        // remove duplicated **/** -> **
        pattern = pattern.replace(SelectorUtils.DEEP_TREE_MATCH + NORMALIZED_FILE_SEPARATOR 
            + SelectorUtils.DEEP_TREE_MATCH, SelectorUtils.DEEP_TREE_MATCH);
        return pattern;
    }
    
    /**
     * Returns whether <code>ch</code> belongs to a pattern.
     * 
     * @param ch the char to be tested
     * @return <code>true</code> if <code>ch</code> belongs to a pattern, <code>false</code> else
     */
    private static boolean isPatternChar(char ch) {
        return MULTIPLE_CHAR_MATCH_CHAR == ch || SINGLE_CHAR_MATCH_CHAR == ch || NORMALIZED_FILE_SEPARATOR_CHAR == ch;
    }

    /**
     * Determines the next matching state at the given position in <code>text</code>.
     * 
     * @param text the text to be considered
     * @param pos the actual position within <code>text</code>
     * @param lastPos the last position where <code>state</code> was determined
     * @param state the actual state (determined at lastPos)
     * @return the current state or <b>null</b> if <code>pos</code> is invalid
     */
    private static MatchState determineNextState(String text, int pos, int lastPos, MatchState state) {
        if (lastPos != pos && pos < text.length()) {
            char c = text.charAt(pos);
            boolean determineState = false;
            switch (state) {
            case MATCH_DEEP_PATH:
                determineState = !isPatternChar(c);
                break;
            case MATCH_MULTI_CHAR:
                if (c == NORMALIZED_FILE_SEPARATOR_CHAR) {
                    determineState = true;
                }
                break;
            case MATCH_SINGLE_CHAR:
                determineState = true;
                break;
            default:
                determineState = true;
                break;
            }
            if (determineState) {
                state = determineState(text, pos);
            }
        }
        return state;
    }

    /**
     * Determines the current matching state at the given position in <code>text</code>.
     * 
     * @param text the text to be considered
     * @param pos the actual position within <code>text</code>
     * @return the current state or <b>null</b> if <code>pos</code> is invalid
     */
    private static MatchState determineState(String text, int pos) {
        MatchState state;
        if (pos < text.length()) {
            char c = text.charAt(pos);
            switch (c) {
            case MULTIPLE_CHAR_MATCH_CHAR:
                if (pos + 1 < text.length() && MULTIPLE_CHAR_MATCH_CHAR == text.charAt(pos + 1)) {
                    state = MatchState.MATCH_DEEP_PATH;
                } else {
                    state = MatchState.MATCH_MULTI_CHAR;
                }
                break;
            case SINGLE_CHAR_MATCH_CHAR:
                state = MatchState.MATCH_SINGLE_CHAR;
                break;
            default:
                state = MatchState.EXACT_CHAR;
                break;
            }
        } else {
            state = null;
        }
        return state;
    }

    /**
     * Replaces the wildcards in <code>lhsPattern</code> with corresponding wildcard matches
     * in <code>rhsPattern</code> derived from <code>rhsValue</code>.
     * 
     * @param lhsPattern the pattern to be filled
     * @param rhsPattern the pattern to be used use to determine the values
     * @param rhsValue the value string (must match <code>rhsPattern</code>)
     * @return <code>lhsPattern</code> with resolved wildcards or the original <code>lhsPattern</code> 
     *     if <code>rhsValue</code> does not match <code>rhsValue</code> or <code>lhsPattern</code> has
     *     no wildcards
     */
    public static String replace(String lhsPattern, String rhsPattern, String rhsValue) {
        String result = lhsPattern;
        List<String> lhsTokens = tokenize(lhsPattern, false);
        if (containsWildcards(lhsTokens)) {
            List<String> rhsTokens = tokenize(rhsPattern, false);
            match(rhsTokens, rhsValue);
            result = replaceWildcards(lhsTokens, rhsTokens);
        }
        return result;
    }

    /**
     * Returns whether <code>token</code> is a wildcard.
     * 
     * @param token the token to be tested
     * @return <code>true</code> if <code>token</code> is a wildcard, <code>false</code> else
     */
    private static boolean isWildcard(String token) {
        return token.equals(SINGLE_CHAR_MATCH) 
            || token.equals(MULTIPLE_CHAR_MATCH) 
            || token.equals(SelectorUtils.DEEP_TREE_MATCH);
    }
    
    /**
     * Returns whether <code>tokens</code> contains wildcards.
     * 
     * @param tokens the tokens to be tested
     * @return <code>true</code> if <code>tokens</code> contains wildcards, <code>false</code> else
     */
    private static boolean containsWildcards(List<String> tokens) {
        boolean containsWildcards = false;
        for (int i = 0; !containsWildcards && i < tokens.size(); i++) {
            containsWildcards = isWildcard(tokens.get(i));
        }
        return containsWildcards;
    }

    /**
     * Matches the <code>tokens</code> against the (matching!) <code>value</code>,
     * removes common parts and replaces wildcards. Prerequisit: <code>value</code>
     * already matches <code>tokens</code>!
     * 
     * @param tokens the tokens to consider and to be modified as a side effect
     * @param valueText the value 
     */
    private static void match(List<String> tokens, String valueText) {
        int textPos = 0;
        int tokenPos = 0; 
        while (tokenPos < tokens.size() && textPos < valueText.length()) {
            String token = tokens.get(tokenPos);
            boolean isLastToken = tokenPos + 1 == tokens.size();
            boolean tokenRemoved = false;
            if (token.equals(SINGLE_CHAR_MATCH)) {
                tokens.set(tokenPos, valueText.substring(textPos, textPos + 1));
                textPos++;
            } else if (token.equals(MULTIPLE_CHAR_MATCH)) {
                if (isLastToken) {
                    int pos = valueText.indexOf(NORMALIZED_FILE_SEPARATOR_CHAR, textPos);
                    if (pos < 0) {
                        tokens.set(tokenPos, valueText.substring(textPos));
                        textPos = valueText.length();
                    } else {
                        tokens.set(tokenPos, valueText.substring(textPos, pos));
                        textPos = pos;
                    }
                } else {
                    String next = tokens.get(tokenPos + 1);
                    int pos = valueText.indexOf(next, textPos);
                    if (pos >= 0) {
                        tokens.set(tokenPos, valueText.substring(textPos, pos));
                        textPos = pos;
                    } else {
                        break;
                    }
                }
            } else if (token.equals(SelectorUtils.DEEP_TREE_MATCH)) {
                if (isLastToken) {
                    int pos = valueText.lastIndexOf(NORMALIZED_FILE_SEPARATOR_CHAR);
                    if (pos >= 0 && pos > textPos) { 
                        tokens.set(tokenPos, valueText.substring(textPos, pos));
                        textPos = pos;
                    } else {
                        break;
                    }
                } else {
                    String next = tokens.get(tokenPos + 1);
                    int pos = valueText.lastIndexOf(next);
                    if (pos > textPos) {
                        if (pos >= 0) {
                            tokens.set(tokenPos, valueText.substring(textPos, pos));
                            textPos = pos;
                        } else {
                            break;
                        }
                    } else {
                        tokens.set(tokenPos, ""); // empty match
                        textPos = pos;  // ensure match
                    }
                }
            } else {
                if (valueText.startsWith(token, textPos)) {
                    tokens.remove(tokenPos); // not needed, we collect only values
                    textPos += token.length();
                    tokenRemoved = true;
                } else {
                    break;
                }
            }
            tokenPos += tokenRemoved ? 0 : 1;
        }
        if (textPos < valueText.length()) {
            tokens.clear();
        }
    }
    
    /**
     * Replaces the wildcards in <code>tokens</code> by the values in <code>values</code>.
     * Replacement happens as long as values are available.
     * 
     * @param tokens the tokens to be considered for creating the result
     * @param values the values replacing wildcards in sequence
     * @return the concatenated tokens and replaced wildcards
     */
    private static String replaceWildcards(List<String> tokens, List<String> values) {
        StringBuilder tmp = new StringBuilder();
        int v = 0;
        int t = 0;
        while (t < tokens.size() && v < values.size()) {
            String token = tokens.get(t);
            if (token.equals(SINGLE_CHAR_MATCH)) {
                if (v < values.size()) {
                    token = values.get(v);
                    if (token.length() > 0) {
                        token = token.substring(0, 1);
                    }
                    v++;
                }
            } else if (token.equals(SelectorUtils.DEEP_TREE_MATCH)) {
                if (v < values.size()) {
                    token = values.get(v);
                    v++;
                    
                    // check for // situation after replacement
                    boolean replaceByEmptyAndReduce = 0 == token.length();
                    replaceByEmptyAndReduce &= tmp.length() > 0 
                        && tmp.charAt(tmp.length() - 1) == NORMALIZED_FILE_SEPARATOR_CHAR;
                    replaceByEmptyAndReduce &= t + 1 < tokens.size() 
                        && tokens.get(t + 1).startsWith(NORMALIZED_FILE_SEPARATOR);
                    if (replaceByEmptyAndReduce) {
                        tmp.deleteCharAt(tmp.length() - 1);
                    }
                }
            } else if (token.equals(MULTIPLE_CHAR_MATCH)) {
                if (v < values.size()) {
                    token = values.get(v);
                    int pos = token.indexOf(NORMALIZED_FILE_SEPARATOR_CHAR);
                    if (pos > 0) {
                        token = token.substring(0, pos);
                    }
                    v++;
                }
            } 
            tmp.append(token);
            t++;
        }
        while (t < tokens.size()) {
            tmp.append(tokens.get(t));
            t++;
        }
        return tmp.toString();
    }
    
    /**
     * Tokenizes the given path according to wildcards.
     * 
     * @param text the text to be tokenized
     * @param considerSeparator tokenize also separators
     * @return the tokens
     */
    private static List<String> tokenize(String text, boolean considerSeparator) {
        List<String> result = new ArrayList<String>();
        int i = 0;
        int len = text.length();
        int lastMatch = -1;
        while (i < len) {
            char c = text.charAt(i);
            if (MULTIPLE_CHAR_MATCH_CHAR == c) {
                if (i > 0) {
                    result.add(text.substring(lastMatch + 1, i));
                }
                if (i + 1 < len && MULTIPLE_CHAR_MATCH_CHAR == text.charAt(i + 1)) {
                    result.add(SelectorUtils.DEEP_TREE_MATCH);
                    i++;
                } else {
                    result.add("*");
                }
                lastMatch = i;
            } else if (SINGLE_CHAR_MATCH_CHAR == c) {
                if (i > 0) {
                    result.add(text.substring(lastMatch + 1, i));
                }
                result.add(SINGLE_CHAR_MATCH);
                lastMatch = i;
            } else if (considerSeparator && NORMALIZED_FILE_SEPARATOR_CHAR == c) {
                result.add(text.substring(lastMatch + 1, i));
                result.add(NORMALIZED_FILE_SEPARATOR);
                lastMatch = i;
            }
            i++;
        }
        if (lastMatch + 1 < len) {
            result.add(text.substring(lastMatch + 1, len));
        }
        return result;
    }

}
