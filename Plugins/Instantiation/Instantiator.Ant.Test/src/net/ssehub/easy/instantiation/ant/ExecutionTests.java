package net.ssehub.easy.instantiation.ant;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import test.de.uni_hildesheim.sse.vil.buildlang.AbstractExecutionTest;
import test.de.uni_hildesheim.sse.vil.buildlang.BuildLangTestConfigurer;
import test.de.uni_hildesheim.sse.vil.buildlang.ITestConfigurer;
import net.ssehub.easy.instantiation.ant.Registration;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;

/**
 * Tests for the basic language.
 * 
 * @author Holger Eichelberger
 */
public class ExecutionTests extends AbstractExecutionTest<Script> {

    private static ExecutionTests tests;
    
    @Override
    protected ITestConfigurer<Script> createTestConfigurer() {
        return new BuildLangTestConfigurer("instantiator.ant.testdata.home");
    }

    @Override
    protected void furtherInitialization() {
        Registration.register();
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
     * The execution of the Ant builder.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAnt() throws IOException {
        assertSelfInstantiate("ant");
    }
    
    /**
     * The execution of the Ant builder.
     * 
     * @throws IOException should not occur
     */
    @Ignore("does not work on Windows")
    @Test
    public void testMake() throws IOException {
        assertSelfInstantiate("make");
    }

}
