package test.de.uni_hildesheim.sse;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * A test class for blackbox testing parser and type resolution of 
 * IVML files contributed from "external" sources. 
 * 
 * @author Holger Eichelberger
 */
public class ExternalTests extends AbstractTest {

    /**
     * Represents the directory containing the tests.
     */
    private static final File DIR = new File(TESTDATA_DIR, "external");

    /**
     * Creates a file in {@link #DIR}.
     * 
     * @param name
     *            the name of the file (excluding ".ivml")
     * @return the file
     */
    private static final File createFile(String name) {
        return new File(DIR, name + ".ivml");
    }

    /**
     * Tests the EasY file with 10000 variables.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void test10000() throws IOException {
        assertEqual(createFile("10000Variables"), null, null);
    }

    /**
     * ScaleLog test case leading to stackoverflow.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void scaleLogGoodsIn() throws IOException {
        assertEqual(createFile("GoodsIn_Instances"), null, null);
    }

}
