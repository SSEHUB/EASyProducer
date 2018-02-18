package test.de.uni_hildesheim.sse;

import java.io.File;
import java.io.IOException;
import org.junit.Test;

/**
 * A test class for testing the correctness of IVML function signatures. All test models shall 
 * contain functions for a specific IVML type, also testing the basic <i>AnyType</i> functions.
 * 
 * @author Holger Eichelberger
 */
public class SignatureTests extends AbstractTest {

    /**
     * Represents the directory containing the tests.
     */
    private static final File DIR = new File(getTestDataDir(), "signatures");

    /**
     * Creates a file object relative to {@link #DIR} (not a file).
     * 
     * @param name the name of the file (excluding ".ivml")
     * @return the file
     */
    private static final File createFile(String name) {
        return new File(DIR, name + ".ivml");
    }
    
    /**
     * Tests Boolean function signatures.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testBooleanFunctions() throws IOException {
        assertEqual(createFile("booleanFunctions"), null, null);
    }

    /**
     * Tests Integer function signatures.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testIntegerFunctions() throws IOException {
        assertEqual(createFile("integerFunctions"), null, null);
    }

    /**
     * Tests Real function signatures.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testRealFunctions() throws IOException {
        assertEqual(createFile("realFunctions"), null, null);
    }

    /**
     * Tests String function signatures.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStringFunctions() throws IOException {
        assertEqual(createFile("stringFunctions"), null, null);
    }

    /**
     * Tests Enum function signatures.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testEnumFunctions() throws IOException {
        assertEqual(createFile("enumFunctions"), null, null);
    }

    /**
     * Tests Sequence function signatures.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSequenceFunctions() throws IOException {
        assertEqual(createFile("sequenceFunctions"), null, null);
    }

    /**
     * Tests Sequence function signatures.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSetFunctions() throws IOException {
        assertEqual(createFile("setFunctions"), null, null);
    }

}
