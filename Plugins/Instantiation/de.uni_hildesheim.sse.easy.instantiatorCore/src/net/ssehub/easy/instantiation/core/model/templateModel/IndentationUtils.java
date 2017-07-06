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
        int tabWidht = Math.max(1, tabEmu); // count tabs at least as 1
        StringBuilder text = new StringBuilder(content);
        int i = 0;
        while (i < text.length() && indentation > 0) { // use actual length as we may cut the text
            char c = text.charAt(i);
            int startPos = -1;
            if ('\r' == c) {
                // lookahead for \r\n, allow also \r
                if (i + 1 < text.length() && '\n' == text.charAt(i + 1)) {
                    i++;
                }
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
                        actIndent += tabWidht;
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
                if (i + 1 < text.length() && '\n' == text.charAt(i + 1)) {
                    i++;
                }
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
            
}
