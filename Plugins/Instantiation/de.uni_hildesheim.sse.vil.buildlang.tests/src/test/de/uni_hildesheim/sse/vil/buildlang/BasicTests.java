package test.de.uni_hildesheim.sse.vil.buildlang;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.dslCore.translation.ErrorCodes;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;

/**
 * Tests for the basic language.
 * 
 * @author Holger Eichelberger
 */
public class BasicTests extends AbstractTest {

    private static BasicTests tests;
    
    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        tests = new BasicTests();
    }

    /**
     * Tears down the test.
     */
    @AfterClass
    public static void shutDown() {
        tests.cleanTemp();
        tests = null;
    }
    
    @Override
    protected File getTestFolder() {
        return new File(getTestDataDir(), "basic");
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

    /**
     * Tests the basic project element.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testProject() throws IOException {
        assertEqual("project", "projectTest");
    }

    /**
     * Tests the load properties element.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLoadProperties() throws IOException {
        assertEqual("loadProperties");
    }

    /**
     * Tests the variable declaration element.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVariableDeclarations() throws IOException {
        assertEqual("variableDeclarations");
    }
    
    // TODO complex expressions with dependencies

    /**
     * Tests the variable declaration element (failing due to already declared name).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVariableDeclarationsFail1() throws IOException {
        assertEqual("variableDeclarationsFail1", ErrorCodes.REDEFINITION);
    }

    /**
     * Tests the variable declaration element (failing due to already declared name).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVariableDeclarationsFail2() throws IOException {
        assertEqual("variableDeclarationsFail2", ErrorCodes.REDEFINITION);
    }

    /**
     * Tests the variable declaration element (failing due to missing constant value).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVariableDeclarationsFail3() throws IOException {
        assertEqual("variableDeclarationsFail3", ErrorCodes.INITIALIZER_CONSISTENCY);
    }

    /**
     * Tests the variable declaration element (failing due to missing constant value).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVariableDeclarationsFail4() throws IOException {
        assertEqual("variableDeclarationsFail4", ErrorCodes.TYPE_CONSISTENCY);
    }

    /**
     * Tests dependent variable declarations.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVariableDeclarations2() throws IOException {
        assertEqual("variableDeclarations2");
    }

    /**
     * Tests a very basic script import.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testImport() throws IOException {
        assertEqual("import", "importTest");
    }

    /**
     * Tests a very basic script import with version restriction.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testImport2() throws IOException {
        assertEqual("import2", "importTest2");
    }
    
    /**
     * Tests some very basic rules.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testRules() throws IOException {
        assertEqual("rules", "rulesTest", null);
    }

    /**
     * Tests set and sequence definitions.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSetsSequences() throws IOException {
        assertEqual("setsSequences");
    }
    
    /**
     * Tests maps and joins.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMapJoin1() throws IOException {
        assertEqual("mapJoin1");
    }

    /**
     * Tests maps and joins.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMapJoin2() throws IOException {
        assertEqual("mapJoin2");
    }

    /**
     * Tests maps and joins.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMapJoin3() throws IOException {
        assertEqual("mapJoin3");
    }

    /**
     * Tests maps and joins.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMapJoin4() throws IOException {
        assertEqual("mapJoin4");
    }
    
    /**
     * Tests maps and joins.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMapJoin5() throws IOException {
        assertEqual("mapJoin5");
    }

    /**
     * Tests maps and joins (shall fail).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMapJoin6() throws IOException {
        assertEqual("mapJoin6", ErrorCodes.TYPE_CONSISTENCY);
    }
    
    /**
     * Tests type selects (same type in collection on left hand).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTypeSelect() throws IOException {
        assertEqual("typeSelect");
    }

    /**
     * Tests type selects (parent type in collection on left hand).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTypeSelect2() throws IOException {
        assertEqual("typeSelect2");
    }
    
    /**
     * Tests type selects (wrong type in collection on left hand).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTypeSelect3() throws IOException {
        assertEqual("typeSelect3", ErrorCodes.TYPE_CONSISTENCY);
    }

    /**
     * Tests missing rules.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testRulesMissing() throws IOException {
        assertEqual("rulesMissing", ExpressionException.ID_CANNOT_RESOLVE);
    }

    /**
     * Tests calling rules.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testRuleCall() throws IOException {
        assertEqual("ruleCall");
    }

    /**
     * Tests a basic constructor.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testConstructor() throws IOException {
        assertEqual("constructor");
    }

    /**
     * Tests a simple version declaration.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVersion() throws IOException {
        assertEqual("version", "versionTest", "0.1");
    }
    
    /**
     * Tests a simple version declaration.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDerived() throws IOException {
        assertEqual("derived");
    }

    /**
     * Tests a simple version declaration.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testProtected() throws IOException {
        assertEqual("protected", "protectedTest");
    }

    /**
     * Tests instantiator calls in map statements (contributed by Christian).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMapInstantiator() throws IOException {
        assertEqual("mapInstantiator");
    }

    /**
     * Tests the instantiate syntax.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testInstantiate() throws IOException {
        assertEqual("instantiate");
    }

    /**
     * Tests the VTL syntax.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVtl() throws IOException {
        assertEqual("vtl");
    }

}
