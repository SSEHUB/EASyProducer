package net.ssehub.easy.integration.common.eclipse.tests;

import org.junit.Assert;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.StandaloneInitializer;

/**
 * Sets up testing environment and provides helpful utility methods.
 * 
 * @author Holger Eichelberger
 */
public class AbstractTest {
    
    protected static final String NEWLINE = System.getProperty("line.separator");
    protected static final String INDENT = "    ";
    
    /**
     * Initializes {@link ModelUtility}.
     */
    static {
        ModelUtility.setResourceInitializer(new StandaloneInitializer());
    }
    
    /**
     * Asserts equality and emits where the comparison fails.
     * 
     * @param expected the expected string
     * @param actual the actual string
     */
    protected static void assertEquals(String expected, String actual) {
        int size = Math.min(expected.length(), actual.length());
        boolean match = true;
        for (int i = 0; match && i < size; i++) {
            char e = expected.charAt(i);
            char a = actual.charAt(i);
            if (e != a) {
                System.err.println(expected.substring(0, i));
                System.err.println();
                System.err.println((int) e + " " + (int) a);
                match = false;
            }
        }
        if (!match) {
            System.err.println();
            System.err.println(expected);
            System.err.println();
            System.err.println(actual);
        }
        Assert.assertEquals(expected.length(), actual.length());
    }

}
