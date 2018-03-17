package test.uni_hildesheim.sse.easy.instantiator.velocity.tests;

import static net.ssehub.easy.varModel.varModel.testSupport.TextTestUtils.*;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import test.de.uni_hildesheim.sse.vil.buildlang.AbstractExecutionTest;
import test.de.uni_hildesheim.sse.vil.buildlang.BuildLangTestConfigurer;
import test.de.uni_hildesheim.sse.vil.buildlang.ITestConfigurer;

/**
 * Tests for the basic language.
 * 
 * @author Holger Eichelberger
 */
public class ExecutionTests extends AbstractExecutionTest<Script> {
    
    private static ExecutionTests tests;
    private static final String MAIN_RULE = "main";

    @Override
    protected ITestConfigurer<Script> createTestConfigurer() {
        return new BuildLangTestConfigurer("vil.buildlang.testdata.home");
    }
    
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
     * The execution of a Velocity template.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVelocity() throws IOException {
        assertSelfInstantiate("velocity", MAIN_RULE, new SelfInstantiationAsserterAdapter() {

            @Override
            public void assertIn(File base) {
                File file = new File(base, "velocity.txt");
                File expected = new File(base, "velocity.txt.expected");
                assertFileEqualitySafe(file, expected);
            }
            
        });
    }

}
