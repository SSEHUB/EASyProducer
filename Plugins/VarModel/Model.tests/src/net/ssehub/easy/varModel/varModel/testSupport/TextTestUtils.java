package net.ssehub.easy.varModel.varModel.testSupport;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

/**
 * Some utility methods for testing text and text files.
 * 
 * @author Holger Eichelberger
 */
public class TextTestUtils {

    private static final String[] ASSERT_EQUALITY_REC_POSTFIX_EXCLUDE = {".svn", ".svn-base"};
    
    /**
     * Prevent external creation (utility class).
     */
    private TextTestUtils() {
    }

    /**
     * Assert the output for a certain file and handles possible exceptions.
     * @param producedFile the file produced during the tests
     * @param expectedFile the expected file (specified before the tests)
     */
    public static void assertFileEqualitySafe(File producedFile, File expectedFile) {
        try {
            assertFileEquality(producedFile, expectedFile);
        } catch (IOException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
    }
    
    /**
     * Assert the output for a certain file.
     * @param producedFile the file produced during the tests
     * @param expectedFile the expected file (specified before the tests)
     * @throws IOException in case of I/O problems (shall not happen)
     */
    public static void assertFileEquality(File producedFile, File expectedFile) throws IOException {
        Assert.assertTrue(producedFile + " does not exist (produced)", producedFile.exists());
        String produced = FileUtils.readFileToString(producedFile, Charset.defaultCharset()); // NIO fails in scenario
        produced = normalizeText(produced);
        boolean isXml = producedFile.getName().endsWith(".xml");
        if (isXml) {
            produced = normalizeXmlEncoding(produced);
        }
        Assert.assertTrue(expectedFile + " does not exist (expected)", expectedFile.exists());
        String expected = FileUtils.readFileToString(expectedFile, Charset.defaultCharset()); // NIO fails in scenario
        expected = normalizeText(expected);
        if (isXml) {
            expected = normalizeXmlEncoding(expected);
        }
        Assert.assertEquals("expected file " + expectedFile + " is not the same as produced file " + producedFile, 
            expected, produced);
    }
    
    /**
     * Normalizes the XML encoding to lower case letters. This is needed as the XALAN XML processing relies on
     * normalized encoding names (as they do not expect that we aim at writing XML files as they are).
     * 
     * @param text the text to be normalized
     * @return the normalized text
     */
    private static String normalizeXmlEncoding(String text) {
        int state = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (state) {
            case 0: // before XML elements
                if ('<' == c) {
                    if (prefixMatch(text, i + 1, "?xml")) {
                        state = 1; // we are in the prologue
                        i = skipWhitespaces(text, i + 5);
                    }
                }
                break;
            case 1: // in prologue
                if (!Character.isWhitespace(c)) {
                    if (prefixMatch(text, i, "encoding")) {
                        i = skipWhitespaces(text, i + 8);
                        if ('=' == text.charAt(i)) {
                            i = skipWhitespaces(text, i + 1);
                            if ('\"' == text.charAt(i)) {
                                state = 2; // i++ will follow
                            }
                        }
                    } 
                }
                break;
            case 2:
                int start = i;
                while (i < text.length() && '\"' != text.charAt(i)) {
                    i++;
                }
                if (i < text.length() && i > start) {
                    String encoding = text.substring(start, i);
                    text = text.substring(0, start) + encoding.toLowerCase() + text.substring(i);
                    break; // job done
                }
                break;
            default:
                break;
            }
        }
        text = text.replace("> </", "></").replace("> <", "><");
        return text;
    }
    
    /**
     * Returns whether the given <code>prefix</code> matches <code>text</code> at <code>pos</code>.
     * 
     * @param text the text to be matched at <code>pos</code>
     * @param pos the position within text to be matched
     * @param prefix the prefix to be matched against <code>text</code> at <code>pos</code>
     * @return <code>true</code> if <code>text</code> matches <code>prefix</code> at <code>pos</code>
     */
    private static boolean prefixMatch(String text, int pos, String prefix) {
        boolean match = false;
        if (prefix.length() > 0 && pos + prefix.length() < text.length()) {
            match = true;
            for (int i = pos; match && i < pos + prefix.length(); i++) {
                match = text.charAt(i) == prefix.charAt(i - pos);
            }
        }
        return match;
    }

    /**
     * Skips the whitespaces at <code>pos</code> in <code>text</code>.
     * 
     * @param text the text to be skipped
     * @param pos the pos to start skipping at
     * @return <code>pos</code> if there were no whitespaces at <code>pos</code>, 
     *     the next non-whitespace position in <code>text</code> after <code>pos</code>
     */
    private static int skipWhitespaces(String text, int pos) {
        while (pos < text.length() && Character.isWhitespace(text.charAt(pos))) {
            pos++;
        }
        return pos;
    }
    
    /**
     * Normalize the given <code>text</code> for comparison.
     * 
     * @param text the text to be normalized
     * @return the normalized text, i.e., without line ends, without spaces at beginning
     *    and end and with reduced whitespaces (multiples to one)
     */
    protected static final String normalizeText(String text) {
        text = text.replace("\\r\\n", "").replaceAll("(\\r|\\n)", "");
        text = text.replaceAll("\\t", " ");
        text = text.trim();
        StringBuffer tmp = new StringBuffer(text);
        int i = 0;
        while (i + 1 < tmp.length()) {
            if (' ' == tmp.charAt(i) && ' ' == tmp.charAt(i + 1)) {
                tmp.deleteCharAt(i);
            } else {
                i++;
            }
        }
        return tmp.toString();
    }

    /**
     * Asserts file equality on a set of files or directories. Starting from <code>expected</code>
     * the same relative files and directories are assumed in <code>generated</code> and asserted
     * using {@link #assertFileEquality(File, File)}.
     * 
     * @param expected the expected file or directory
     * @param generated the generated file or directory
     * @throws IOException in case that reading and comparing a file does not work
     */
    public static void assertFileEqualityRec(File expected, File generated) throws IOException {
        assertFileEqualityRec(expected, generated, null);
    }
    
    /**
     * Asserts file equality on a set of files or directories. Starting from <code>expected</code>
     * the same relative files and directories are assumed in <code>generated</code> and asserted
     * using {@link #assertFileEquality(File, File)}.
     * 
     * @param expected the expected file or directory
     * @param generated the generated file or directory
     * @param filter file filter to exclude files
     * @throws IOException in case that reading and comparing a file does not work
     */
    public static void assertFileEqualityRec(File expected, File generated, FileFilter filter) throws IOException {
        boolean exclude = false;
        for (String postfix : ASSERT_EQUALITY_REC_POSTFIX_EXCLUDE) {
            exclude |= expected.getName().endsWith(postfix);
        }
        if (!exclude) {
            if (expected.isFile()) {
                if (null == filter || filter.accept(expected)) {
                    assertFileEquality(generated, expected);
                }
            } else {
                File[] files = expected.listFiles(filter);
                if (null != files) {
                    for (File f: files) {
                        File gen = new File(generated, f.getName());
                        if (f.isDirectory()) {
                            assertFileEqualityRec(f, gen, filter);
                        } else {
                            assertFileEquality(gen, f);
                        }
                    }
                } 
            }
        }
    }

}
