package test.de.uni_hildesheim.sse.vil.templatelang;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * Performs basic (syntactic) tests.
 * 
 * @author Holger Eichelberger
 */
public class BasicTests extends AbstractTest {

    /**
     * Represents the directory containing the tests.
     */
    private static final File DIR = new File(TESTDATA_DIR, "basic");


    @Override
    protected File getTestFolder() {
        return DIR;
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
     * no version shall be checked.
     * 
     * @param file the name of the file containing the model (without suffix)
     * @param expectedName the expected name of the model
     * @param expectedVersion the expected version (may be <b>null</b>)
     * @param expectedErrorCodes
     *            the expected and allowed error codes (errors occurring
     *            multiple times need to be listed multiple times here)
     * @throws IOException
     *             problems finding or reading the model file
     */
    protected void assertEqual(String file, String expectedName, String expectedVersion, int... expectedErrorCodes) 
        throws IOException {
        EqualitySetup data = new EqualitySetup(createFile(file), expectedName, expectedVersion);
        assertEqual(data, expectedErrorCodes);
    }
    
    /**
     * Tests a plain template.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTemplate() throws IOException {
        assertEqual("template");
    }

    /**
     * Tests a plain version.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVersion() throws IOException {
        assertEqual("version", "versionTest", "1.1");
    }

    /**
     * Tests simple variables.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVariables() throws IOException {
        assertEqual("variables");
    }

    /**
     * Tests a simple variable taking a value from a template parameter.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVariables2() throws IOException {
        assertEqual("variables2");
    }
    
    /**
     * Tests a plain sub-template definition ('def').
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDef() throws IOException {
        assertEqual("def", "defTest");
    }

    /**
     * Tests simple parameter at template and sub-template.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testParameter() throws IOException {
        assertEqual("parameter");
    }

    /**
     * Tests a simple Java extension.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJavaExtension() throws IOException {
        assertEqual("javaExtension");
    }

    /**
     * Tests a one-sided alternative with block.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative1() throws IOException {
        assertEqual("alternative1");
    }

    /**
     * Tests a one-sided alternative with statement.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative2() throws IOException {
        assertEqual("alternative2");
    }

    /**
     * Tests a one-sided alternative with empty block.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative3() throws IOException {
        assertEqual("alternative3");
    }

    /**
     * Tests a two-sided alternative with blocks.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative4() throws IOException {
        assertEqual("alternative4");
    }

    /**
     * Tests a two-sided alternative with if-block and else-statement.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative5() throws IOException {
        assertEqual("alternative5");
    }

    /**
     * Tests a two-sided alternative with two statements.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative6() throws IOException {
        assertEqual("alternative6");
    }

    /**
     * Tests a two-sided alternative with if-block and empty else-statement.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative7() throws IOException {
        assertEqual("alternative7");
    }

    /**
     * Tests a two-sided alternative with two blocks.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative8() throws IOException {
        assertEqual("alternative8");
    }
    
    /**
     * Tests a loop alternative with block.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLoop1() throws IOException {
        assertEqual("loop1");
    }

    /**
     * Tests a loop alternative with statement.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLoop2() throws IOException {
        assertEqual("loop2");
    }

    /**
     * Tests a loop alternative with statement and one separator.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLoop3() throws IOException {
        assertEqual("loop3");
    }

    /**
     * Tests a loop alternative with statement and two separators.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLoop4() throws IOException {
        assertEqual("loop4");
    }
    
    /**
     * Tests a switch statement with one case.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSwitch1() throws IOException {
        assertEqual("switch1");
    }

    /**
     * Tests a switch statement with one case and a default.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSwitch2() throws IOException {
        assertEqual("switch2");
    }

    /**
     * Tests a switch statement with two cases.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSwitch3() throws IOException {
        assertEqual("switch3");
    }

    /**
     * Tests a switch statement with two cases and a default.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSwitch4() throws IOException {
        assertEqual("switch4");
    }

    /**
     * Tests a switch statement with the VALUE variable.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSwitch5() throws IOException {
        assertEqual("switch5");
    }

    /**
     * Tests a switch statement with the VALUE variable mixing.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSwitch6() throws IOException {
        assertEqual("switch6");
    }
    
    /**
     * Tests simple content.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent1() throws IOException {
        assertEqual("content1");
    }

    /**
     * Tests a template call.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTemplateCall() throws IOException {
        assertEqual("templateCall");
    }
    
    /**
     * Tests a derived script.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDerived() throws IOException {
        assertEqual("derived");
    }

    /**
     * Tests a derived script.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testImport() throws IOException {
        assertEqual("import", "importTest");
    }

    /**
     * Tests a recursive sub-template.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testRecursion() throws IOException {
        assertEqual("recursion");
    }

}
