package test.de.uni_hildesheim.sse.vil.buildlang;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests for the basic language.
 * 
 * @author Holger Eichelberger
 */
public class ExtraTests extends AbstractTest {

    private static ExtraTests tests;
    
    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        tests = new ExtraTests();
    }

    /**
     * Tears down the test.
     */
    @AfterClass
    public static void shutDown() {
        if (null != tests) {
            tests.cleanTemp();
            tests = null;
        }
    }

    /**
     * Asserts equality of the models and the parsed/analyzed result, i.e. it
     * reads <code>file</code> as a model, analyzes it, compares the obtained
     * errors with <code>expectedErrorCodes</code>, compares the contents of
     * <code>file</code> with the printed (analyzed) model and checks the
     * project information directly obtained from file. It is assumed that 
     * no version shall be checked.
     * 
     * @param file
     *            the name of the file containing the model (without suffix)
     * @param expectedName
     *            the expected name of the model
     * @param expectedErrorCodes
     *            the expected and allowed error codes (errors occurring
     *            multiple times need to be listed multiple times here)
     * @throws IOException
     *             problems finding or reading the model file
     */
    protected void assertEqual(String file, String expectedName, int... expectedErrorCodes) 
        throws IOException {
        EqualitySetup data = new EqualitySetup(createFile(file), expectedName, null);
        assertEqual(data, expectedErrorCodes);
    }
    
    /**
     * Asserts equality of the models and the parsed/analyzed result, i.e. it
     * reads <code>file</code> as a model, analyzes it, compares the obtained
     * errors with <code>expectedErrorCodes</code>, compares the contents of
     * <code>file</code> with the printed (analyzed) model and checks the
     * project information directly obtained from file. It is assumed that 
     * the name of the model is the same as of the file.
     * 
     * @param file
     *            the name of the file containing the model (without suffix)
     * @param expectedName
     *            the expected name of the model
     * @param expectedVersion
     *            the expected version of <code>expectedName</code>
     * @param expectedErrorCodes
     *            the expected and allowed error codes (errors occurring
     *            multiple times need to be listed multiple times here)
     * @throws IOException
     *             problems finding or reading the model file
     */
    protected void assertEqual(String file, String expectedName, String expectedVersion, int... expectedErrorCodes) 
        throws IOException {
        EqualitySetup data = new EqualitySetup(createFile(file), expectedName, expectedVersion, null);
        assertEqual(data, expectedErrorCodes);
    }
    
    /**
     * Asserts equality of the models and the parsed/analyzed result, i.e. it
     * reads <code>file</code> as a model, analyzes it, compares the obtained
     * errors with <code>expectedErrorCodes</code>, compares the contents of
     * <code>file</code> with the printed (analyzed) model and checks the
     * project information directly obtained from file. It is assumed that 
     * the name of the model is the same as of the file and no version.
     * 
     * @param file
     *            the name of the file containing the model (without suffix)
     * @param expectedErrorCodes
     *            the expected and allowed error codes (errors occurring
     *            multiple times need to be listed multiple times here)
     * @throws IOException
     *             problems finding or reading the model file
     */
    protected void assertEqual(String file, int... expectedErrorCodes) throws IOException {
        EqualitySetup data = new EqualitySetup(createFile(file), file, null, null);
        assertEqual(data, expectedErrorCodes);
    }

    @Override
    protected File getTestFolder() {
        return new File(getTestDataDir(), "extra");
    }
    
    /**
     * Tests the copy parameter problem (contributed by Christian).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCopy() throws IOException {
        assertEqual("copy");
    }
   
}
