package net.ssehub.easy.instantiation.core.model.templateModel;

/**
 * Indentation utilities.
 * 
 * @author Holger Eichelberger
 */
public class IndentationUtils {

    /**
     * Prevents external instantiation.
     */
    private IndentationUtils() {
    }

    /**
     * Remove indentation in <code>content</code>, i.e., all whitespace/tab combinations
     * matching the given <code>indentation</code> following a line start.
     * 
     * @param content the text to operate on
     * @param indentation the actual indentation in number of whitespaces (positive number)
     * @param tabEmu the tab emulation in whitespaces (0 if disabled, positive number else)
     * @return <code>content</code> without indentation
     */
    public static String removeIndentation(String content, int indentation, int tabEmu) {
        int tabWidth = Math.max(1, tabEmu); // count tabs at least as 1
        StringBuilder text = new StringBuilder(content);
        int i = 0;
        while (i < text.length() && indentation > 0) { // use actual length as we may cut the text
            char c = text.charAt(i);
            int startPos = -1;
            if ('\r' == c) {
                // lookahead for \r\n, allow also \r
                i = advanceIfNextIsNewLine(text, i);
                i++; // continue with next
                startPos = i;
            } else if ('\n' == c) {
                i++; // continue with next
                startPos = i;
            } else if (0 == i && isIndentationChar(c)) {
                startPos = i; // continue with this
            } else {
                i++;
            }
            if (startPos >= 0) {
                int actIndent = 0;
                // find whitespaces until other character or indentation possibly met
                while (i < text.length() && actIndent < indentation) {
                    c = text.charAt(i);
                    if (' ' == c) {
                        actIndent++;
                    } else if ('\t' == c) {
                        actIndent += tabWidth;
                    } else {
                        break;
                    }
                    i++;
                }
                // if indentation met, remove and continue at startPos, else go on at i
                if (actIndent == indentation) {
                    text.delete(startPos, i);
                    i = startPos;
                }
            }
        }
        return text.toString();
    }

    /**
     * Returns whether the next character in <code>text</code> after <code>pos</code> is <code>ch</code>.
     * 
     * @param text the text to analyze
     * @param pos the position
     * @param ch the character to look for
     * @return <code>true</code> if the next character is <code>ch</code>, <code>false</code> else
     */
    private static boolean nextIs(CharSequence text, int pos, char ch) {
        return pos + 1 < text.length() && ch == text.charAt(pos + 1);
    }
    
    /**
     * Advance the given position if it is a new line.
     * 
     * @param text the text to analyze
     * @param pos the position
     * @return the (not) advanced position
     */
    private static int advanceIfNextIsNewLine(CharSequence text, int pos) {
        int result = pos;
        if (nextIs(text, pos, '\n')) {
            result++;
        }
        return result;
    }

    /**
     * Inserts indentation into <code>content</code>, i.e., <code>indentation</code>
     * whitespaces at each line start.
     * 
     * @param content the text to operate on
     * @param indentation the actual indentation in number of whitespaces (<b>positive number</b>)
     * @param skipFirst skip the first indentation
     * @return <code>content</code> without indentation
     */
    public static String insertIndentation(String content, int indentation, boolean skipFirst) {
        StringBuilder text = new StringBuilder(content);
        int i = 0;
        int count = 0;
        while (i < text.length()) { // use actual length as we may cut the text
            int startPos = -1;
            char c = text.charAt(i);
            if ('\r' == c) {
                // lookahead for \r\n, allow also \r
                i = advanceIfNextIsNewLine(text, i);
                startPos = i + 1;
            } else if ('\n' == c) {
                startPos = i + 1;
            } else if (0 == i && !isIndentationChar(c)) {
                startPos = i;
            } else {
                i++;
            }
            if (startPos >= 0) {
                if (skipFirst && 0 == count) {
                    i = startPos + 1; // advance, avoid endless loop
                } else {
                    i = insertIndentation(text, startPos, indentation);
                }
                count++;
                i = skipWhitespaces(text, i);
            }
        }
        return text.toString();
    }

    /**
     * Returns whether <code>ch</code> is an indentation character.
     * 
     * @param ch the character
     * @return <code>true</code> for indentation character, <code>false</code> else
     */
    public static boolean isIndentationChar(char ch) {
        return ' ' == ch || '\t' == ch;
    }
    
    /**
     * Returns whether <code>ch</code> is a line end character.
     * 
     * @param ch the character
     * @return <code>true</code> for line end character, <code>false</code> else
     */
    public static boolean isLineEnd(char ch) {
        return '\r' == ch || '\n' == ch;
    }
    
    /**
     * Skips the whitespaces and tabs at <code>pos</code> in <code>text</code>.
     * 
     * @param text the text to be considered
     * @param pos the start position
     * @return the position of the first character in <code>text</code> after 
     *     the whitespaces or the first position after the end of <code>text</code>
     */
    private static int skipWhitespaces(StringBuilder text, int pos) {
        while (pos < text.length()) {
            char c = text.charAt(pos);
            if (' ' == c || '\t' == c) {
                pos++;
            } else {
                break;
            }
        }
        return pos;
    }
    
    /**
     * Inserts an indentation of <code>indentation</code> whitespaces at <code>pos</code> into <code>text</code>.
     * 
     * @param text the text to be modified
     * @param pos the insert position
     * @param indentation the number of whitespaces to be inserted
     * @return the new position at the end of the indentation
     */
    private static int insertIndentation(StringBuilder text, int pos, int indentation) {
        for (int i = 0; i < indentation; i++) {
            text.insert(pos, ' ');
        }
        return pos + Math.max(0, indentation);
    }

    /**
     * Appends the with last indentation to <code>string</code>.
     * 
     * @param string the string to look into
     * @param text the text to append
     * @param skipLastIndent anyway skip the last indentation
     * @return the string with appended indentation (if there was any)
     */
    public static String appendWithLastIndentation(String string, String text, boolean skipLastIndent) {
        String result = string;
        if (result != null) {
            if ((text.length() > 0 && isIndentationChar(text.charAt(0))) || skipLastIndent) {
                // indented content statements
                result = result + text;
            } else {
                // single chained content statements
                int pos = result.length() - 1;
                while (pos >= 0 && !isIndentationChar(result.charAt(pos))) {
                    pos--;
                }
                int endPos = pos;
                while (pos >= 0 && isIndentationChar(result.charAt(pos))) {
                    pos--;
                }
                if (pos < 0) {
                    pos = 0;
                } else if (!isLineEnd(result.charAt(pos))) {
                    pos = -1;
                } else if (countLineEnds(result, endPos) > 1) { // don't jump into last nesting
                    pos = -1;
                }
                if (pos >= 0 && endPos >= pos) {
                    result = result + insertIndentation(text, endPos - pos, 
                        isIndentationChar(result.charAt(result.length() - 1)));
                } else {
                    result = result + text;
                }
            }
        } else {
            result = text;
        }
        return result;
    }
    
    /**
     * Returns the number of line ends considering returns and new lines in <code>string</code>
     * after <code>startPos</code>.
     * 
     * @param string the string to analyze
     * @param startPos the start position within string
     * @return the number of line ends
     */
    public static int countLineEnds(CharSequence string, int startPos) {
        int count = 0;
        int i = startPos;
        while (i < string.length()) {
            char c = string.charAt(i);
            if ('\r' == c) {
                count++;
                i = advanceIfNextIsNewLine(string, i);
            } else if ('\n' == c) {
                count++;
            }
            i++;
        }
        return count;
    }

    /**
     * Returns whether all lines start with the given <code>indent</code>.
     * 
     * @param text the text to analyze
     * @param indent the indent to check for
     * @return <code>true</code> if all lines start with the given indent, <code>false</code> else
     */
    public static boolean allLinesStartWith(String text, int indent) {
        boolean allLinesStart = text.length() > 0;
        int i = 0;
        int actIndent = 0;
        boolean inText = false;
        while (i < text.length()) {
            char c = text.charAt(i);
            if (isIndentationChar(c)) {
                if (!inText) {
                    actIndent++;
                }
            } else if (isLineEnd(c)) {
                inText = false;
                actIndent = 0;
            } else {
                if (!inText) {
                    if (actIndent < indent) {
                        allLinesStart = false;
                        break;
                    }
                }
                inText = true;
            }
            i++;
        }
        return allLinesStart;
    }
    
    /**
     * Removes the last indentation in <code>text</code> if present. This includes (from end of <code>text</code>) line
     * end characters and indentation characters, but no further characters.  
     * 
     * @param text the text to remove the last indentation for
     * @return the text without last indentation
     */
    public static String removeLastIndentation(String text) {
        String result = text;
        int pos = result.length() - 1;
        int initPos = pos;
        while (pos > 0 && isLineEnd(result.charAt(pos))) {
            pos--;
        }
        while (pos > 0 && isIndentationChar(result.charAt(pos))) {
            pos--;
        }
        if (pos > 0 && pos < initPos) {
            result = result.substring(0, pos + 1);
        }
        return result;
    }
    
    /**
     * Does the given <code>text</code> just consist of indentation characters?
     * 
     * @param text the text
     * @return <code>true</code> if just indentation characters, <code>false</code> else
     */
    public static boolean isIndentationString(String text) {
        boolean result;
        if (text.length() > 0) {
            result = true;
            for (int i = 0; result && i < text.length(); i++) {
                char c = text.charAt(i);
                result = isIndentationChar(c) || isLineEnd(c);
            }
        } else {
            result = false;
        }
        return result;
    }

}
