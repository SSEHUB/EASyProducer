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
import net.ssehub.easy.instantiation.yaml.Bundle;
import net.ssehub.easy.instantiation.yaml.Registration;
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
        return new BuildLangTestConfigurer("instantiator.yaml.testdata.home");
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
        final String fName = modelName + ".yaml";
        
        assertSelfInstantiate(modelName, "main", new SelfInstantiationAsserterAdapter() {

            @Override
            public File determineTestDirectory(File file) {
                return new File(file, "execution");
            }

            @Override
            public void assertIn(File base) {
                File expectedMethodClass2 = new File(getArtifactsFolder(), fName);
                File tempFileMethodClass2 = new File(base, fName);
                // for debugging
                try { 
                    System.out.println(FileUtils.readFileToString(tempFileMethodClass2, Charset.defaultCharset()));
                } catch (IOException e) {
                }
                assertFileEqualitySafe(tempFileMethodClass2, expectedMethodClass2);
            }

        });
    }

    /**
     * Test the Yaml artifact.
     * 
     * @throws IOException
     *             should not occur
     */
    @Test
    public void testYamlBasics() throws IOException {
        assertYaml("yamlBasics");
    }

}
