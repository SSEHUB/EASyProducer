package test.de.uni_hildesheim.sse.vil.buildlang;

import static de.uni_hildesheim.sse.varModel.testSupport.TextTestUtils.*;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
/**
 * Tests for the basic language.
 * 
 * @author Holger Eichelberger
 */
public class ExecutionTests extends AbstractExecutionTest {
    
    private static ExecutionTests tests;
    
    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        tests = new ExecutionTests();
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
     * Tests the load properties element.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLoadProperties() throws IOException {
        assertEqual("loadProperties");
    }
    
    /**
     * Tests the load properties element (failing test due to overriden constant).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLoadPropertiesFail() throws IOException {
        assertEqual("loadPropertiesFail", VilLanguageException.ID_IS_CONSTANT);
    }

    /**
     * Tests basic numerical functions.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testNumbers() throws IOException {
        assertEqual("numbers");
    }

    /**
     * Tests basic boolean functions.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testBooleans() throws IOException {
        assertEqual("boolean");
    }

    /**
     * Tests basic boolean functions.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStrings() throws IOException {
        assertEqual("string");
    }

    /**
     * Tests basic collection functions.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCollections() throws IOException {
        assertEqual("collections");
    }

    /**
     * Tests basic map functions.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMap() throws IOException {
        assertEqual("mapTest");
    }
    
    /**
     * Tests simple independent variable declarations.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVariableDeclarations() throws IOException {
        assertEqual("variableDeclarations");
    }

    /**
     * Tests simple depending variable declarations.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVariableDeclarations2() throws IOException {
        assertEqual("variableDeclarations2");
    }

    /**
     * Tests simple script parameter (without script parameter).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testScriptParameter() throws IOException {
        assertEqual("scriptParameter");
    }

    /**
     * Tests simple script parameter (with typical script parameter).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testScriptParameter2() throws IOException {
        assertEqual("scriptParameter2", VilLanguageException.ID_RUNTIME_PARAMETER);
        assertEqualDefaultParam("scriptParameter2");
    }

    /**
     * Tests simple rule execution (without script parameter).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSimpleRules() throws IOException {
        assertEqual("simpleRules");
    }

    /**
     * Tests simple rule execution (with typical script parameter).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSimpleRules2() throws IOException {
        assertEqual("simpleRules2", VilLanguageException.ID_RUNTIME_PARAMETER);
        assertEqualDefaultParam("simpleRules2");
    }

    /**
     * Tests simple rule execution (nested rule dependency).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSimpleRules3() throws IOException {
        assertEqual("simpleRules3");
    }

    /**
     * Tests simple rule execution (co-occurring rule dependency).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSimpleRules4() throws IOException {
        assertEqual("simpleRules4");
    }
    
    /**
     * Tests the functionality of sequences.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSequences() throws IOException {
        assertSelfInstantiate("sequences");
    }

    /**
     * Tests the functionality of a simple map.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMapSimple() throws IOException {
        assertSelfInstantiate("mapSimple");
    }

    /**
     * Tests the functionality of a nested map.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMapNested() throws IOException {
        assertSelfInstantiate("mapNested");
    }

    /**
     * Tests the instantiation of an artifact via a constructor.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testConstructor() throws IOException {
        assertSelfInstantiate("constructor");
    }

    /**
     * Tests a simple double-sided join.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJoin1() throws IOException {
        assertSelfInstantiate("join1");
    }

    /**
     * Tests a simple double-sided join with condition.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJoin2() throws IOException {
        assertSelfInstantiate("join2");
    }

    /**
     * Tests a simple left-sided join with condition.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJoin3() throws IOException {
        assertSelfInstantiate("join3");
    }

    /**
     * Tests a simple right-sided join with condition (consider that just
     * the names not the paths shall be equal).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJoin4() throws IOException {
        assertSelfInstantiate("join4");
    }
    
    /**
     * The execution of a protected rule.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testProtected() throws IOException {
        assertSelfInstantiate("protectedRules");
        // the same as before, just explicitly using the default start rule
        assertSelfInstantiate("protectedRules", "main"); 
        // shall not work, protected
        assertSelfInstantiate("protectedRules", "compile", VilLanguageException.ID_RUNTIME_STARTRULE);
        // shall not work, does not exist
        assertSelfInstantiate("protectedRules", "bla", VilLanguageException.ID_RUNTIME_STARTRULE); 
    }

    /**
     * The execution of VTL templates.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVtl() throws IOException {
        assertSelfInstantiate("vtl", "main", new SelfInstantiationAsserter() {

            @Override
            public void assertIn(File base) {
                File file = new File(base, "test.txt");
                File expected = new File(base, "templates/test.vtl.expected");
                assertFileEqualitySafe(file, expected);
                file = new File(base, "test1.txt");
                assertFileEqualitySafe(file, expected);
                file = new File(base, "init.sql");
                expected = new File(base, "init.sql.expected");
                assertFileEqualitySafe(file, expected);
            }
            
        });
    }
    
    /**
     * The execution of a Velocity template.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVelocity() throws IOException {
        assertSelfInstantiate("velocity", "main", new SelfInstantiationAsserter() {

            @Override
            public void assertIn(File base) {
                File file = new File(base, "velocity.txt");
                File expected = new File(base, "velocity.txt.expected");
                assertFileEqualitySafe(file, expected);
            }
            
        });
    }
    
    /**
     * The execution of conditional rules with explicit dependencies.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testConditionalRules() throws IOException {
        assertSelfInstantiate("conditionalRules");
    }

    /**
     * The execution of conditional rules with implicit dependencies.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testConditionalRules2() throws IOException {
        assertSelfInstantiate("conditionalRules2");
    }

    /**
     * The execution of zip operations.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testZip() throws IOException {
        assertSelfInstantiate("zip");
    }

    /**
     * The use of a temporary folder.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTmpFolder() throws IOException {
        assertSelfInstantiate("tmpFolder");
    }

    /**
     * Tests simple operations on the textual representation.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testText() throws IOException {
        assertSelfInstantiate("text");
    }

    /**
     * Tests implicit variables.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testImplicitVars() throws IOException {
        assertSelfInstantiate("implicitVars");
    }

    /**
     * Tests the instantiation command. However, we cannot test
     * all variants of the call as currently the main script cannot
     * easily be determined in tests (projects are fed in as files).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testInstantiate() throws IOException {
        assertSelfInstantiate("instantiate");
    }

    /**
     * Tests a main rule call to a base PL from an extended PL (contributed by Sascha).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testExtendedPL() throws IOException {
        assertSelfInstantiate("extendedPL");
    }

}
