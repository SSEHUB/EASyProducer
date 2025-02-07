/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.templateModel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.modelManagement.IndentationConfiguration;

/**
 * A simple language-dependent, configurable content formatter, in particular
 * for splitting too long lines and for removing empty lines.
 * 
 * @author Holger Eichelberger
 */
public class ContentFormatter {

    private static final Map<String, Profile> PROFILES = new HashMap<String, Profile>();
    private Profile profile;
    private FormattingConfiguration fConf;
    private IndentationConfiguration iConf;
    private boolean lastLineEmpty = false;

    /**
     * A formatting profile. Reusable, may store state.
     * 
     * @author Holger Eichelberger
     */
    public interface Profile {
        
        /**
         * Shall indentation be adjusted at all.
         * 
         * @return {@code true} for adjustment, {@code false} else
         */
        public boolean adjustIndentation();

        /**
         * Returns whether indentation shall be enabled in the current situation at
         * the given actual indentation. This allows, e.g., for conditional indentation at the leftmost margin, i.e., 
         * split at no indentation.
         * 
         * @param indent the actual indentation
         * @return the number of additional indentation steps, may be 0
         */
        public boolean enableIndentation(int indent);
        
        /**
         * Returns how many additional indentation steps shall be added when
         * adjusting indentation.
         * 
         * @return the number of additional indentation steps, may be 0
         */
        public int additionalIndent();
        
        /**
         * String to add to the adjusted indentation, may be state dependent.
         * 
         * @return the string to add, may be empty
         */
        public String addToIndent();

        /**
         * Is the given character a potential long-line splitting character, may be state dependent.
         * 
         * @param ch the character
         * @param nextChar the next character after
         * @return {@code true} for splitting character, {@code false} else
         */
        public boolean isSplitChar(char ch, char nextChar);
        
        /**
         * If the current position is a {@link #isSplitChar(char, char) split char}, then shall the split position be 
         * modified?
         * 
         * @param ch the character where the split will happen
         * @return increment or decrement to split position, may be 0 for none
         */
        public int adjustSplitPosition(char ch);
        
        /**
         * Finally enable a split with character {@code ch} at the the split position and {@code nextCh} at
         * one position right to ch as lookahead.
         * 
         * @param ch the character at the split position
         * @param nextCh the next/lookahead character, may be {@code 0} for there is none
         * @return {@code true} to enable the split, {@code false} else
         */
        public default boolean enableSplit(char ch, char nextCh) {
            return true;
        }
        
        /**
         * If the current position is a {@link #isSplitChar(char, char) split char}, then shall something be
         * added at this specific position, e.g., a string end for string end + string start?
         * 
         * @param ch the character where the split will happen
         * @return the additional text, may be empty for none
         */
        public String addBeforeSplit(char ch);

        /**
         * If the current position is a {@link #isSplitChar(char, char) split char}, then shall something be
         * added after the new line break, e.g., a + string end for string end + string start?
         * 
         * @param ch the character where the split will happen
         * @return the additional text, may be empty for none
         */
        public String addAfterSplit(char ch);

        /**
         * Notifies the profile about the actual character being processed. May form the state.
         * 
         * @param ch the character
         * @param pos the position of {@code ch}
         */
        public void processingChar(char ch, int pos);

        /**
         * Shall multiple empty lines in sequence be removed.
         * 
         * @return {@code true} for remove, {@code false} else
         */
        public boolean removeMultiEmptyLines();
        
        /**
         * Creates an instance of this (template) profile.
         * 
         * @return the instance
         */
        public Profile createInstance();
        
        /**
         * Resets the state of the profile.
         */
        public void reset();
        
        /**
         * (Re-)configures this profile.
         * 
         * @param fConfig the configuration to configure this profile with
         */
        public void configure(FormattingConfiguration fConfig);
        
        /**
         * Returns the (configured/overridden) line length.
         * 
         * @param fConfig the configuration to configure this profile with
         * @return the line length
         */
        public default int getLineLength(FormattingConfiguration fConfig) {
            return null == fConfig ? 80 : fConfig.getLineLength();
        }
        
    }

    /**
     * A default formatting profile.
     * 
     * @author Holger Eichelberger
     */
    public static class DefaultProfile implements Profile {

        @Override
        public boolean adjustIndentation() {
            return false;
        }

        @Override
        public int additionalIndent() {
            return 0;
        }
        
        @Override
        public boolean enableIndentation(int indent) {
            return indent > 0;
        }

        @Override
        public String addToIndent() {
            return "";
        }

        @Override
        public boolean isSplitChar(char ch, char nextChar) {
            return false;
        }

        @Override
        public int adjustSplitPosition(char ch) {
            return 0;
        }
        
        @Override
        public String addBeforeSplit(char ch) {
            return "";
        }

        @Override
        public String addAfterSplit(char ch) {
            return "";
        }

        @Override
        public void processingChar(char ch, int pos) {
        }

        @Override
        public boolean removeMultiEmptyLines() {
            return false;
        }

        @Override
        public Profile createInstance() {
            return new DefaultProfile();
        }

        @Override
        public void reset() {
        }

        @Override
        public void configure(FormattingConfiguration fConfig) {
        }

    }
    
    /**
     * A simple formatting profile for Python.
     * 
     * @author Holger Eichelberger
     */
    public static class PythonProfile extends DefaultProfile {

        @Override
        public int getLineLength(FormattingConfiguration fConfig) {
            return Integer.MAX_VALUE; // see project thesis Kevin Shaperjahn
        }

        @Override
        public Profile createInstance() {
            return new PythonProfile();
        }

    }

    /**
     * A Java formatting profile detecting and adjusting the format of (javadoc) comments.
     * 
     * @author Holger Eichelberger
     */
    public static class JavaProfile implements Profile {

        private enum State {
            CODE,
            SLASH,
            STRING_START,
            STRING,
            STRING_ESCAPE,
            ML_COMMENT,
            ML_COMMENT_1,
            ML_COMMENT_JAVADOC,
            ML_COMMENT_STAR,
            ML_COMMENT_JAVADOC_STAR,
            SL_COMMENT
        }
        
        private State state;
        private String javadocIndent = " * ";
        private Set<String> noSplit2Chars = new HashSet<String>();

        /**
         * Creates a profile instance.
         */
        public JavaProfile() {
            reset();
            noSplit2Chars.add("==");
            noSplit2Chars.add("!=");
            noSplit2Chars.add("<=");
            noSplit2Chars.add(">=");
            noSplit2Chars.add("->");
            noSplit2Chars.add("|=");
            noSplit2Chars.add("&=");
            noSplit2Chars.add("%=");
            noSplit2Chars.add("^=");
            noSplit2Chars.add("-=");
            noSplit2Chars.add("+=");
            noSplit2Chars.add("*=");
            noSplit2Chars.add("/=");
            noSplit2Chars.add("++");
            noSplit2Chars.add("--");
            noSplit2Chars.add("\"\""); // not the empty string
            //noSplit2Chars.add("()"); // not the empty argument list
            
            noSplit2Chars.add(">>"); // prefix of >>=
            noSplit2Chars.add("<<"); // prefix of <<=
            noSplit2Chars.add(".."); // prefix of ...
        }
        
        @Override
        public void reset() {
            state = State.CODE;
        }
        
        @Override
        public Profile createInstance() {
            JavaProfile result = new JavaProfile();
            result.javadocIndent = this.javadocIndent;
            return result;
        }
        
        @Override
        public boolean adjustIndentation() {
            return true;
        }

        @Override
        public boolean enableIndentation(int indent) {
            return (State.CODE == state) ? indent >= 0 : indent > 0;
        }

        @Override
        public int additionalIndent() {
            int result = 0;
            if (State.CODE == state || State.STRING_START == state || State.STRING == state) {
                result = 1;
            }
            return result;       
        }
        
        @Override
        public boolean enableSplit(char ch, char nextCh) {
            boolean result = true;
            if ((State.STRING == state || State.STRING_START == state) && nextCh == '"') { 
                // we are in a string and the current char will end it, do not enable an empty split
                result = false;
            }
            return result;
        }

        @Override
        public String addToIndent() {
            String result = "";
            if (State.ML_COMMENT_JAVADOC == state) {
                result = javadocIndent;
            } else if (State.SL_COMMENT == state) {
                result = "// ";
            }
            return result;       
        }

        @Override
        public boolean isSplitChar(char ch, char nextChar) {
            boolean result = false;
            if (State.CODE == state) {
                result = ch == '.' || ch == '"' || ch == '(';
                result |= ch == '+' || ch == '-' || ch == '/';
                result |= ch == '*' || ch == '[';
                result &= !noSplit2Chars.contains(String.valueOf(ch) + nextChar);
            } else if (State.STRING_START == state) {
                result = ch == '"';
            } else if (State.STRING == state) { // allow everywhere, see addBeforeSplit/addAfterSplit
                result = true;
            }
            return result;
        }

        @Override
        public int adjustSplitPosition(char ch) {
            int result = 0; 
            if (State.STRING_START == state) {
                result = -1; // split before splitChar
            }
            return result;
        }

        @Override
        public String addBeforeSplit(char ch) {
            String result = "";
            if (State.STRING == state && ch != '"') { // not at string end/empty string
                result = "\"";
            }
            return result;
        }

        @Override
        public String addAfterSplit(char ch) {
            String result = "";
            if (State.STRING == state && ch != '"') { // not at string end/empty string
                result = "+ \"";
            }
            return result;
        }

        @Override
        public void processingChar(char ch, int pos) {
            State before = state;
            if ('/' == ch) {
                if (State.CODE == state) {
                    state = State.SLASH;
                } else if (State.SLASH == state) {
                    state = State.SL_COMMENT;
                } else if (State.ML_COMMENT_STAR == state) {
                    state = State.CODE;
                } else if (State.ML_COMMENT_JAVADOC_STAR == state) {
                    state = State.CODE;
                }
            } else if ('\\' == ch) {
                if (State.STRING == state) {
                    state = State.STRING_ESCAPE;
                }
            } else if ('*' == ch) {
                if (State.SLASH == state) {
                    state = State.ML_COMMENT_1;
                } else if (State.ML_COMMENT_1 == state) {
                    state = State.ML_COMMENT_JAVADOC;
                } else if (State.ML_COMMENT == state) {
                    state = State.ML_COMMENT_STAR;
                } else if (State.ML_COMMENT_JAVADOC == state) {
                    state = State.ML_COMMENT_JAVADOC_STAR;
                }
            } else if (isNewline(ch)) {
                if (state == State.SL_COMMENT) {
                    state = State.CODE;
                }
            } else if ('"' == ch) {
                if (State.CODE == state) {
                    state = State.STRING_START;
                } else if (State.STRING_START == state || State.STRING == state) {
                    state = State.CODE;
                } // do not switch in comment, ignore if in STRING_ESCAPE
            }
            if (state == before) {
                if (State.SLASH == state) {
                    state = State.CODE; // reset   
                } else if (State.ML_COMMENT_STAR == state) {
                    state = State.ML_COMMENT;
                } else if (State.ML_COMMENT_JAVADOC_STAR == state) {
                    state = State.ML_COMMENT_JAVADOC;
                } else if (State.ML_COMMENT_1 == state) {
                    state = State.ML_COMMENT;
                } else if (State.STRING_ESCAPE == state || State.STRING_START == state) {
                    state = State.STRING;
                }
            }
        }

        @Override
        public boolean removeMultiEmptyLines() {
            return true;
        }

        @Override
        public void configure(FormattingConfiguration fConfig) {
            String arg = fConfig.getProfileArgument("javadocIndent");
            if (null != arg) {
                this.javadocIndent = arg;
            }
        }

    }
    
    // registers
    static {
        PROFILES.put("JAVA", new JavaProfile());
        PROFILES.put("JSON", new DefaultProfile()); // nothing specific so far
        PROFILES.put("YAML", new DefaultProfile()); // nothing specific so far
        PROFILES.put("PYTHON", new PythonProfile()); // nothing specific so far
        PROFILES.put("", new DefaultProfile());
    }
    
    /**
     * Returns the actual (reusable) profile from {@link FormattingConfiguration#getProfile()}. Stores the determined
     * profile in {@link #profile}.
     * 
     * @return the profile
     */
    private Profile determineProfile() {
        Profile result = this.profile;
        if (null == result) {
            String profileName = fConf.getProfile();
            if (null != profileName) {
                profileName = profileName.toUpperCase().trim();
            } else {
                profileName = "";
            }
            result = PROFILES.get(profileName);
            if (null == result) {
                result = PROFILES.get("");
            }
            result = result.createInstance();
            this.profile = result;
        }
        result.configure(fConf);
        return result;
    }

    /**
     * Explicitly sets the formatting configuration.
     * 
     * @param fConf the formatting configuration (may be <b>null</b>)
     */
    public void setFormattingConfiguration(FormattingConfiguration fConf) {
        this.fConf = fConf;
    }

    /**
     * Explicitly sets the indentation configuration. Resets the actually used profile. 
     * 
     * @param iConf the indentation configuration (may be <b>null</b>)
     */
    public void setIndentationConfiguration(IndentationConfiguration iConf) {
        this.iConf = iConf;
        this.profile = null;
    }
    
    /**
     * Returns whether there is a line length or a profile configured (python re-defines line length).
     * 
     * @param fConf the formatter configuration
     * @return {@code true} for configured, {@code false}
     */
    private static boolean isFormatterConfigEnabled(FormattingConfiguration fConf) {
        return (fConf.getLineLength() > 0 || (fConf.getProfile() != null && fConf.getProfile().length() > 0));
    }

    /**
     * Formats the given content.
     * 
     * @param content the content (may be <b>null</b>)
     * @return the formatted content, may be <b>null</b> if no output shall happen
     */
    public String format(String content) {
        String result = content;
        if (iConf != null && fConf != null && isFormatterConfigEnabled(fConf)) {
            determineProfile();
            if (profile.removeMultiEmptyLines()) {
                if (result.trim().length() == 0) {
                    if (lastLineEmpty) {
                        result = null;
                    } else {
                        lastLineEmpty = true;
                    }
                } else {
                    lastLineEmpty = false;
                }
            }
            if (null != result) {
                StringBuilder bld = new StringBuilder(result);
                if (profile.removeMultiEmptyLines()) {
                    removeMulipleEmptyLines(bld);
                }
                splitLines(bld);
                result = bld.toString();
            }
        }
        if (null != fConf && fConf.getCharset() != null) {
            result = new String(result.getBytes(), fConf.getCharset());
        }
        return result;
    }
    
    /**
     * Removes multiple empty lines from {@code bld}.
     * 
     * @param bld the string builder holding the actual content to be modified/formatted
     */
    private void removeMulipleEmptyLines(StringBuilder bld) {
        int pos = 0;
        int lastNewLinePos = 0;
        int lastNonWsPos = -1;
        boolean lastEmpty = false;
        while (pos < bld.length()) {
            int posAdjust = 1;
            char c = bld.charAt(pos);
            if (!isNewline(c) && !Character.isWhitespace(c)) {
                lastNonWsPos = pos;
            }
            if (isCrNl(bld, pos)) {
                pos++;
                c = '\n';
            }
            if (isNewline(c)) {
                if (lastNonWsPos < 0) {
                    if (lastEmpty) {
                        bld.delete(lastNewLinePos, pos + 1);
                        posAdjust = -(pos - lastNewLinePos); 
                    } else {
                        lastEmpty = true;
                    }
                } else {
                    lastEmpty = false;
                }
                lastNewLinePos = pos + posAdjust;
                lastNonWsPos = -1;
            }
            pos += posAdjust;
        }
    }
    
    private char nextChar(StringBuilder builder, int pos) {
        return pos + 1 < builder.length() ? builder.charAt(pos + 1) : 0;
    }

    /**
     * Splits lines where feasible and necessary based on {@link FormattingConfiguration#getLineLength()}.
     * 
     * @param builder the string builder representing the actual content
     * @see #splitLines(char, StringBuilder, int, int)
     */
    private void splitLines(StringBuilder builder) {
        final int maxLineLength = profile.getLineLength(fConf);
        int pos = 0;
        int lastStartPos = 0;
        int lastSplitPos = 0;
        int lastNlPos = 0; // lastNLpos only for determining the indentation
        int doubleChars = 0;
        while (pos < builder.length()) {
            int advance = 0;
            char c = builder.charAt(pos);
            profile.processingChar(c, pos);
            if (isCrNl(builder, pos)) {
                pos++;
                c = '\n';
                doubleChars++;
            }
            if (canSplit(c, nextChar(builder, pos))) { // we can split here
                int count = pos - doubleChars - lastStartPos + 1;
                boolean split = count >= maxLineLength;
                if (!split) { // lookahead, are we before and the next is too late?
                    int nPos = pos + 1; // nextPos
                    while (nPos < builder.length() && !canSplit(builder.charAt(nPos), nextChar(builder, nPos))) {
                        nPos++;
                    }
                    split = (nPos > pos + 1 && nPos - doubleChars - lastStartPos - 1 > maxLineLength);
                }
                if (split) { // here, line length exceeded
                    int adv = splitLines(c, builder, pos, lastNlPos);
                    if (adv > 0) {
                        advance += adv;
                        lastStartPos = lastSplitPos;
                        lastSplitPos = pos + advance; // adjust positions
                    } else {
                        split = false;
                    }
                } 
                if (!split) {
                    lastSplitPos = pos; // do not split, advance split position
                    if (isNewline(c)) {
                        lastStartPos = pos;
                    }
                }
                if (isNewline(c)) {
                    lastNlPos = pos;
                    doubleChars = 0; // new line, do not let them accumulate!
                }
            }
            pos += advance == 0 ? 1 : advance;
        }
    }
    
    /**
     * Can we split at {@code ch}.
     * 
     * @param ch the character to test
     * @param nextChar the follow-up character
     * @return {@code true} for splitting, {@code false} else
     */
    private boolean canSplit(char ch, char nextChar) {
        return isNewline(ch) || ch == ' ' || profile.isSplitChar(ch, nextChar);
    }

    /**
     * Tries splitting lines at character {@code ch} modifying {@code bld} at {@code splitPos} considering 
     * {@code startPos} as start of the actual line (in particular regarding/for adjusting the indentation).
     * 
     * @param ch the actual character
     * @param buffer the string builder to modify as a side effect
     * @param splitPos the position where to potentially split the lines, i.e., insert newlines according to 
     *     {@link FormattingConfiguration#getLineEnding()}
     * @param startPos the line starting position for indentation check/adjustment
     * @return the position advancement, may be 0 for none
     * @see #adjustIndentation(StringBuilder, int, int)
     */
    private int splitLines(char ch, StringBuilder buffer, int splitPos, int startPos) {
        int result = 0;
        if (!isNewline(ch)) { // do not insert double line breaks
            final String lineBreak = FormattingConfiguration.getLineEnding(fConf);
            final int indentStep = iConf.getIndentationStep();
            String ins = "";
            char nextCh = nextChar(buffer, splitPos);
            if (profile.enableSplit(ch, nextCh)) {
                if (!profile.isSplitChar(ch, nextCh)) {
                    buffer.delete(splitPos, splitPos + 1);
                } else {
                    splitPos++;
                    result++;
                }
                ins += profile.addBeforeSplit(ch) + lineBreak + adjustIndentation(buffer, startPos, indentStep) 
                    + profile.addAfterSplit(ch);
                int adjustSplitPos = profile.adjustSplitPosition(ch);
                buffer.insert(splitPos + adjustSplitPos, ins);
                result += ins.length() - adjustSplitPos;
            }
        }
        return result;
    }

    /**
     * Is at the actual position {@code pos} in {@code bld} a carridge return/newline.
     * 
     * @param bld the builder
     * @param pos the actual (valid!) position
     * @return {@code true} for carridge return/newline, {@code false} else
     */
    private static boolean isCrNl(StringBuilder bld, int pos) {
        return bld.charAt(pos) == '\r' && pos + 1 < bld.length() && bld.charAt(pos + 1) == '\n';
    }

    /**
     * Returns whether {@code ch} is either a carriage return or a newline.
     * 
     * @param ch the character to check
     * @return {@code true} for carriage return or newline, {@code false} else
     */
    private static boolean isNewline(char ch) {
        return ch == '\r' || ch == '\n'; 
    }

    private String adjustIndentation(StringBuilder string, int lastStart, int indentStep) {
        String result = "";
        if (profile.adjustIndentation() && indentStep > 0 && lastStart >= 0) {
            while (lastStart < string.length() && isNewline(string.charAt(lastStart))) {
                lastStart++;
            }
            int pos = lastStart;
            while (pos < string.length() && string.charAt(pos) == ' ') {
                pos++;
            }
            int indent = (pos - lastStart) / indentStep;
            if (profile.enableIndentation(indent)) { // usually indent > 0
                indent += profile.additionalIndent();
                for (int i = 1; i <= indent; i++) {
                    for (int j = 1; j <= indentStep; j++) {
                        result += " ";
                    }
                }
            }
            result += profile.addToIndent();
        }
        return result;
    }
    
    /**
     * Resets the state of the formatter.
     */
    public void reset() {
        if (null != profile) {
            profile.reset();
        }
        lastLineEmpty = false;
    }
    
}
