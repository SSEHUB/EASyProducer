package test.de.uni_hildesheim.sse.java;

import static de.uni_hildesheim.sse.varModel.testSupport.TextTestUtils.assertFileEqualitySafe;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.easy.java.Registration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.Executor;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import test.de.uni_hildesheim.sse.vil.buildlang.AbstractExecutionTest;
import test.de.uni_hildesheim.sse.vil.buildlang.BuildLangTestConfigurer;
import test.de.uni_hildesheim.sse.vil.buildlang.ITestConfigurer;

/**
 * Test the execution of vil.
 * 
 * @author Aike Sass
 *
 */
public class ProjectExecutionTest extends AbstractExecutionTest<Script> {

    private File destination = new File(getArtifactsFolder(), "classpathTest/src/dest");
    
    /**
     * Register VIL types.
     */
    @Before
    public void setUp() {
        Registration.register();
    }
    
    /**
     * Clean up.
     */
    @After
    public void tearDown() {
        delete(destination);
        destination = new File(getArtifactsFolder(), "deleteMethod/src/dest");
        delete(destination);
        
    }
    
    
    /**
     * Deletes a directory.
     * 
     * @param destination the directory to be deleted
     */
    private void delete(File destination) {
        if (destination.exists() && destination.isDirectory()) {
            FileUtils.deleteQuietly(destination);
        }
    }

    /**
     * Creates a VIL executor for the contained PLP.
     * 
     * @param artifactsFolder the name of the folder in testdata
     * @param scriptFileName the file name of the script to be executed
     * @param scriptname the name of the script
     * 
     * @throws ModelManagementException 
     * @throws VilException 
     */
    private void executeScript(String artifactsFolder, String scriptFileName, String scriptname) throws
        ModelManagementException, 
        VilException {
        final File base = new File(getArtifactsFolder(), artifactsFolder);
        final File script = new File(getArtifactsFolder(), artifactsFolder + "/src/" + scriptFileName);
        // execute
        ProjectDescriptor source = new ProjectDescriptor(script.getAbsolutePath(), scriptname);
        ProjectDescriptor target = new ProjectDescriptor(source, base);
        Executor executor = new Executor(source.getMainVilScript()).addSource(target).addTarget(target)
                .addConfiguration(ProjectDescriptor.getConfiguration(scriptname));
        executor.execute();
    }

    /**
     * Test if a project can be executed.
     */
    @Test
    public void testProjectExecution() {
        try {
            executeScript("classpathTest", "method.vil", "PL_Test");
        } catch (ModelManagementException e) {
            Assert.fail(e.getMessage());
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }
        File tempFile = new File(getArtifactsFolder(), "classpathTest/src/dest/tmp/MethodFile.java");
        File expected = new File(getArtifactsFolder(), "classpathTest/src/ModifiedMethodFile.java");
        assertFileEqualitySafe(tempFile, expected);
    }

    @Override
    protected ITestConfigurer<Script> createTestConfigurer() {
        return new BuildLangTestConfigurer("instantiator.java.testdata.home");
    }
    
    /**
     * Test if all java calls are cleaned up if the method is deleted.
     */
    @Test
    public void testCleanUpAfterMethodRemoval() {
        try {
            executeScript("deleteMethod", "deleteWithJavaCalls.vil", "PL_DeleteWithCalls");
        } catch (ModelManagementException e) {
            Assert.fail(e.getMessage());
        } catch (VilException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        File tempFile = new File(getArtifactsFolder(), "deleteMethod/src/dest/tmp/MethodClass.java");
        File expected = new File(getArtifactsFolder(), "deleteMethodExpected/ExpectedMethodClass.java");
        assertFileEqualitySafe(tempFile, expected);
        File tempFile2 = new File(getArtifactsFolder(), "deleteMethod/src/dest/tmp/MethodClass2.java");
        File expected2 = new File(getArtifactsFolder(), "deleteMethodExpected/ExpectedMethodClass2.java");
        assertFileEqualitySafe(tempFile2, expected2);
    }

}
