package test.de.uni_hildesheim.sse.java;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.easy.java.Registration;

import test.de.uni_hildesheim.sse.vil.buildlang.AbstractExecutionTest;

/**
 * Tests for the basic language.
 * 
 * @author Holger Eichelberger
 */
public class ExecutionTests extends AbstractExecutionTest {

    private static ExecutionTests tests;
    
    @Override
    protected String getSystemPropertyName() {
        return "instantiator.java.testdata.home";
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
     * The execution of the Java compiler.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJavac() throws IOException {
        assertSelfInstantiate("javac");
    }

    /**
     * Tests the implicit LHSMATCH variable.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJavac2() throws IOException {
        assertSelfInstantiate("javac2");
    }
    
    /**
     * The execution of the aspectJ compiler.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAspectJ() throws IOException {
        assertSelfInstantiate("aspectj");
    }

    /**
     * The execution of jar operations.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJar() throws IOException {
        assertSelfInstantiate("jar");
    }

}
