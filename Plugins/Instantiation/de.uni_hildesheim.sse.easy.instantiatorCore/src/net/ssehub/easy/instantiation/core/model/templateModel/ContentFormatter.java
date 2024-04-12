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
import java.util.Map;

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
         * @return {@code true} for splitting character, {@code false} else
         */
        public boolean isSplitChar(char ch);
        
        /**
         * Notifies the profile about the actual character being processed. May form the state.
         * 
         * @param ch the character
         */
        public void processingChar(char ch);

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
        public String addToIndent() {
            return "";
        }

        @Override
        public boolean isSplitChar(char ch) {
            return false;
        }

        @Override
        public void processingChar(char ch) {
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
            ML_COMMENT,
            ML_COMMENT_1,
            ML_COMMENT_JAVADOC,
            ML_COMMENT_STAR,
            ML_COMMENT_JAVADOC_STAR,
            SL_COMMENT
        }
        
        private State state;

        public JavaProfile() {
            reset();
        }
        
        @Override
        public void reset() {
            state = State.CODE;
        }
        
        @Override
        public Profile createInstance() {
            return new JavaProfile();
        }
        
        @Override
        public boolean adjustIndentation() {
            return true;
        }

        @Override
        public int additionalIndent() {
            int result = 0;
            if (State.CODE == state) {
                result = 1;
            }
            return result;       
        }

        @Override
        public String addToIndent() {
            String result = "";
            if (State.ML_COMMENT_JAVADOC == state) {
                result = " * ";
            } else if (State.SL_COMMENT == state) {
                result = "// ";
            }
            return result;       
        }

        @Override
        public boolean isSplitChar(char ch) {
            boolean result = false;
            if (State.CODE == state) {
                result = ch == '.';
            }
            return result;
        }

        @Override
        public void processingChar(char ch) {
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
                }
            }
        }

        @Override
        public boolean removeMultiEmptyLines() {
            return true;
        }

    }
    
    // registers
    static {
        PROFILES.put("JAVA", new JavaProfile());
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
     * Formats the given content.
     * 
     * @param content the content (may be <b>null</b>)
     * @return the formatted content, may be <b>null</b> if no output shall happen
     */
    public String format(String content) {
        String result = content;
        if (iConf != null && fConf != null && fConf.getLineLength() > 0) {
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

    /**
     * Splits lines where feasible and necessary based on {@link FormattingConfiguration#getLineLength()}.
     * 
     * @param bld the string builder representing the actual content
     * @see #splitLines(char, StringBuilder, int, int)
     */
    private void splitLines(StringBuilder bld) {
        final int maxLineLength = fConf.getLineLength();
        int pos = 0;
        int lastLastStartPos = -1;
        int lastStartPos = 0;
        int lastSplitPos = 0;
        char lastSplitChar = 0;
        int doubleChars = 0;
        while (pos < bld.length()) {
            int advance = 0;
            char c = bld.charAt(pos);
            profile.processingChar(c);
            if (isCrNl(bld, pos)) {
                pos++;
                c = '\n';
                doubleChars++;
            }
            if (isNewline(c) || c == ' ' || profile.isSplitChar(c)) { // we can split here
                if (pos - doubleChars - lastStartPos > maxLineLength) { // here, line length exceeded
                    advance += splitLines(c, bld, pos, lastStartPos);
                    int adv = advance;                    
                    if (pos - doubleChars - lastSplitPos > maxLineLength) { // just in case that we hopped over
                        advance += splitLines(lastSplitChar, bld, lastSplitPos, lastLastStartPos);
                    }
                    lastSplitPos = pos + adv; // adjust positions
                    lastLastStartPos = lastStartPos;
                    lastStartPos = lastSplitPos;
                } else {
                    lastSplitPos = pos; // do not split, advance split position
                    if (isNewline(c)) {
                        lastStartPos = pos;
                    }
                }
                lastSplitChar = c;
            }
            pos += advance == 0 ? 1 : advance;
        }
    }

    /**
     * Tries splitting lines at character {@code ch} modifying {@code bld} at {@code splitPos} considering 
     * {@code startPos} as start of the actual line (in particular regarding/for adjusting the indentation).
     * 
     * @param ch the actual character
     * @param bld the string builder to modify as a side effect
     * @param splitPos the position where to potentially split the lines, i.e., insert newlines according to 
     *     {@link FormattingConfiguration#getLineEnding()}
     * @param startPos the line starting position for indentation check/adjustment
     * @return the position advancement, may be 0 for none
     * @see #adjustIndentation(Profile, StringBuilder, int, int)
     */
    private int splitLines(char ch, StringBuilder bld, int splitPos, int startPos) {
        int result = 0;
        if (!isNewline(ch)) { // do not insert double line breaks
            final String lineBreak = FormattingConfiguration.getLineEnding(fConf);
            final int indentStep = iConf.getIndentationStep();
            String ins = "";
            if (!profile.isSplitChar(ch)) {
                bld.delete(splitPos, splitPos + 1);
            } else {
                ins += ch;
            }
            ins += lineBreak + adjustIndentation(bld, startPos, indentStep);
            bld.insert(splitPos, ins);
            result = ins.length();
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
     * Returns whether {@code ch} is either a carridge return or a newline.
     * 
     * @param ch the character to check
     * @return {@code true} for carridge return or newline, {@code false} else
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
            if (indent > 0) {
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
        //profile = null;
        lastLineEmpty = false;
    }
    
}
