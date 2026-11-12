package net.ssehub.easy.instantiation.yaml.test;

import static net.ssehub.easy.varModel.varModel.testSupport.TextTestUtils.assertFileEqualitySafe;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.ssehub.easy.instantiation.core.DefaultLibUtils;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.json.Bundle;
import net.ssehub.easy.instantiation.json.Registration;
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

    @Override
    protected ITestConfigurer<Script> createTestConfigurer() {
        return new BuildLangTestConfigurer("instantiator.json.testdata.home");
    }

    @Override
    protected void furtherInitialization() {
        Registration.register();
        DefaultLibUtils.loadDefaultModels(OBSERVER, Bundle.ID);
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
     * Assertion for Java code tests.
     * 
     * @param modelName the name of the VIL model to execute, searches for an artifact of the same name and 
     *     extension ".yaml"
     * @throws IOException if reading files fails
     */
    private void assertYaml(String modelName) throws IOException {
        final String fName = modelName + ".json";
        
        assertSelfInstantiate(modelName, "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public File determineTestDirectory(File file) {
                return new File(file, "execution");
            }

            @Override
            public void assertIn(File base) {
                File expectedFile = new File(getArtifactsFolder(), fName);
                File tempFile = new File(base, fName);
                // for debugging
                try { 
                    System.out.println(FileUtils.readFileToString(tempFile, Charset.defaultCharset()));
                } catch (IOException e) {
                }
                assertFileEqualitySafe(tempFile, expectedFile);
            }

        });
    }

    /**
     * Test the Json artifact.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testJsonBasics() throws IOException {
        assertYaml("jsonBasics");
    }

    /**
     * Test reading a Json artifact.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testReadingTest() throws IOException {
        String modelName = "readingTest";
        String fName = modelName + ".txt";
        assertSelfInstantiate(modelName, "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public File determineTestDirectory(File file) {
                return new File(file, "execution");
            }

            @Override
            public void assertIn(File base) {
                File expectedFile = new File(getArtifactsFolder(), fName);
                File tempFile = new File(base, fName);
                assertFileEqualitySafe(tempFile, expectedFile);
            }

        });
    }

}
