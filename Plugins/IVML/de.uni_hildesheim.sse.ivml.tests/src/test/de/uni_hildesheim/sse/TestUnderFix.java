package test.de.uni_hildesheim.sse;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * An empty class used for fixing problems found by tests.
 * 
 * @author Holger Eichelberger
 */
public class TestUnderFix extends AbstractTest {

    /**
     * Creates a file in {@link #DIR}.
     * 
     * @param name the name of the file (excluding ".ivml")
     * @return the file
     */
    public static final File createFile(String name) {
        return new File(new File(TESTDATA_DIR, ""), name + ".ivml");
    }

    /**
     * The test under fix.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void test() throws IOException {
        assertEqual(createFile("test"), "testC", "0");
    }

}
