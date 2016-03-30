package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.instantiation.core.model.templateModel.IndentationUtils;

/**
 * Tests for the indentation utilities.
 * 
 * @author Holger Eichelberger
 */
public class IndentationUtilsTests {
    
    /**
     * Tests whether text remains untouched.
     */
    @Test
    public void testNoRemoval() {
        testNoRemoval("");
        testNoRemoval("abba");
        testNoRemoval("abba\nabba");
        testNoRemoval("   abba\n   abba");
        testNoRemoval("abba\rabba");
        testNoRemoval("   abba\r   abba");
        testNoRemoval("abba\r\nabba");
        testNoRemoval("   abba\r\n   abba");
    }

    /**
     * Tests whether no removal happens on <code>testString</code> for 
     * a series of removal calls.
     * 
     * @param testString the string to be tested
     */
    private static void testNoRemoval(String testString) {
        testNoRemoval(testString, 0, 0);
        testNoRemoval(testString, 4, 0);
        testNoRemoval(testString, 4, 2);
        testNoRemoval(testString, 4, 4);
    }

    /**
     * Tests whether no removal happens on <code>testString</code>.
     * 
     * @param testString the string to be tested
     * @param indentation the actual indentation in number of whitespaces (positive number)
     * @param tabEmu the tab emulation in whitespaces (0 if disabled, positive number else)
     */
    private static void testNoRemoval(String testString, int indentation, int tabEmu) {
        String result = IndentationUtils.removeIndentation(testString, indentation, tabEmu);
        Assert.assertEquals("no removal fails:", testString, result);
    }

    /**
     * Tests whether removal happens on <code>testString</code> expecting <code>expected</code>.
     * 
     * @param testString the string to be tested
     * @param indentation the actual indentation in number of whitespaces (positive number)
     * @param tabEmu the tab emulation in whitespaces (0 if disabled, positive number else)
     * @param expected the expected result
     */
    private static void testRemoval(String testString, int indentation, int tabEmu, String expected) {
        if (null == expected) {
            expected = testString;
        }
        String result = IndentationUtils.removeIndentation(testString, indentation, tabEmu);
        Assert.assertEquals("removal fails:", expected, result);
    }
    
    /**
     * Tests whether indentation removal on <code>testString</code> results
     * in <code>expected</code> for a series of removals.
     * 
     * @param testString the string to be tested
     * @param expected the expected result
     */
    private static void testRemoval(String testString, String expected) {
        testRemoval(testString, 0, 0, null);
        testRemoval(testString, 4, 0, expected);
        testRemoval(testString, 4, 2, expected);
        testRemoval(testString, 4, 4, expected);
    }

    /**
     * Tests the removal of indentations.
     */
    @Test
    public void testRemoval() {
        // plain whitespace
        testRemoval("    abba", "abba");
        testRemoval("    abba\n    abba", "abba\nabba");
        testRemoval("abba\n    abba", "abba\nabba");
        testRemoval("\n    abba", "\nabba");
        testRemoval("    abba\r    abba", "abba\rabba");
        testRemoval("abba\r    abba", "abba\rabba");
        testRemoval("\r    abba", "\rabba");
        testRemoval("    abba\r\n    abba", "abba\r\nabba");
        testRemoval("abba\r\n    abba", "abba\r\nabba");
        testRemoval("\r\n    abba", "\r\nabba");
        // whitespace with non-replacable whitespace
        testRemoval("    abba    abba", "abba    abba");
        testRemoval("    abba    abba\r\n    abba    abba", "abba    abba\r\nabba    abba");
        testRemoval("      abba", "  abba");
        // plain tabs
        testRemoval("\t\tabba", 4, 2, "abba");
        testRemoval("\tabba", 4, 4, "abba");
        testRemoval("\t\tabba\r\n\t\tabba", 4, 2, "abba\r\nabba");
        testRemoval("\tabba\r\n\tabba", 4, 4, "abba\r\nabba");
        // mixed tabs
        testRemoval("\t  abba", 4, 2, "abba");
        testRemoval("  \tabba", 4, 2, "abba");
    }

    /**
     * Tests the insert of indentations.
     * 
     * @param testString the string to be tested
     * @param indentation the actual indentation in number of whitespaces (positive number)
     * @param expected the expected result
     */
    private static void testInsertion(String testString, int indentation, String expected) {
        String result = IndentationUtils.insertIndentation(testString, indentation);
        Assert.assertEquals("insertion fails:", result, expected);
    }
    
    /**
     * Tests the insertion of indentations.
     */
    @Test
    public void testInsertion() {
        testInsertion("", 4, "");
        testInsertion("abba", 4, "    abba");
        testInsertion("abba    abba", 4, "    abba    abba");
        testInsertion("\rabba", 4, "\r    abba");
        testInsertion("\nabba", 4, "\n    abba");
        testInsertion("\r\nabba", 4, "\r\n    abba");
        testInsertion("abba\rabba", 4, "    abba\r    abba");
        testInsertion("abba\nabba", 4, "    abba\n    abba");
        testInsertion("abba\r\nabba", 4, "    abba\r\n    abba");
    }
    
}
