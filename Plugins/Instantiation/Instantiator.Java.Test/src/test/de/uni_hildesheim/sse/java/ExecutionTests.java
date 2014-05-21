package test.de.uni_hildesheim.sse.java;

import static de.uni_hildesheim.sse.varModel.testSupport.TextTestUtils.assertFileEqualitySafe;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import test.de.uni_hildesheim.sse.vil.buildlang.AbstractExecutionTest;
import de.uni_hildesheim.sse.easy.java.Registration;

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
    
    /**
     * The execution of jar operations.
     * This test case test the correct behavior of creating JARs with a given
     * manifest file.
     * Further tests were also applied:
     * <ul>
     * <li>Making files relative to directory</li>
     * <li>Include only files from a specific subfolder</li>
     * </ul>
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJarWithManifest() throws IOException {
        assertSelfInstantiate("jar2", "main", new SelfInstantiationAsserter() {

            @Override
            public void assertIn(File base) {
                // Manifest which should be included in JAR file
                File expected = new File(new File(getArtifactsFolder(), "jar2Testfiles"), "MANIFEST.MF");
                
                // Unpacked manifest file from the JAR file
                File generated = new File(new File(base, "Jar2TestUnzipped"), "META-INF");
                generated = new File(generated, "MANIFEST.MF");
                
                // Check that not the default Manifest file was used.
                assertFileEqualitySafe(expected, generated);
            }
            
        });
    }

}
