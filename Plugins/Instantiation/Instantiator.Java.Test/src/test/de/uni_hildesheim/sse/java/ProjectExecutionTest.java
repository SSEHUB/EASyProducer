package test.de.uni_hildesheim.sse.java;

import static net.ssehub.easy.varModel.varModel.testSupport.TextTestUtils.assertFileEqualitySafe;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.Executor;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.tracing.ConsoleTracerFactory;
import net.ssehub.easy.instantiation.java.Registration;
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
    
    private File tmpdir = new File(getArtifactsFolder(), "reasoner/dest");

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
     * @param script the script
     * @param targetFile the target directory
     * 
     * @throws ModelManagementException 
     * @throws VilException 
     */
    private void executeScript(String artifactsFolder, File script, File targetFile) throws
        ModelManagementException, 
        VilException {
//        final File base = new File(getArtifactsFolder(), artifactsFolder);
//        final File script = new File(getArtifactsFolder(), script);
        // execute
        System.out.println(script.getAbsolutePath());
        String scriptName = script.getName().replaceAll(".vil", "");
        ProjectDescriptor source = new ProjectDescriptor(script.getAbsolutePath(), scriptName);
        ProjectDescriptor target = new ProjectDescriptor(source, targetFile);
        TracerFactory.setInstance(ConsoleTracerFactory.INSTANCE);
        Executor executor = new Executor(source.getMainVilScript()).addSource(source).addTarget(target)
                .addConfiguration(ProjectDescriptor.getConfiguration(scriptName));
        executor.execute();
    }

//    /**
//     * Test if a project can be executed.
//     */
//    @Test
//    public void testProjectExecution() {
//        try {
//            executeScript("classpathTest", "method.vil", "PL_Test");
//        } catch (ModelManagementException e) {
//            Assert.fail(e.getMessage());
//        } catch (VilException e) {
//            Assert.fail(e.getMessage());
//        }
//        File tempFile = new File(getArtifactsFolder(), "classpathTest/src/dest/tmp/MethodFile.java");
//        File expected = new File(getArtifactsFolder(), "classpathTest/src/ModifiedMethodFile.java");
//        assertFileEqualitySafe(tempFile, expected);
//    }

    @Override
    protected ITestConfigurer<Script> createTestConfigurer() {
        return new BuildLangTestConfigurer("instantiator.java.testdata.home");
    }
    
//    /**
//     * Test if all java calls are cleaned up if the method is deleted.
//     */
//    @Test
//    public void testCleanUpAfterMethodRemoval() {
//        try {
//            executeScript("deleteMethod", "deleteWithJavaCalls.vil", "PL_DeleteWithJavaCalls");
//        } catch (ModelManagementException e) {
//            Assert.fail(e.getMessage());
//        } catch (VilException e) {
//            e.printStackTrace();
//            Assert.fail(e.getMessage());
//        }
//        File tempFile = new File(getArtifactsFolder(), "deleteMethod/MethodClass.java");
//        File expected = new File(getArtifactsFolder(), "deleteMethodExpected/MethodClass.java");
//        assertFileEqualitySafe(tempFile, expected);
//        File tempFile2 = new File(getArtifactsFolder(), "deleteMethod/MethodClass2.java");
//        File expected2 = new File(getArtifactsFolder(), "deleteMethodExpected/MethodClass2.java");
//        assertFileEqualitySafe(tempFile2, expected2);
//    }
    
    
//    /**
//     * Test the execution of the qm2 VIL script. This includes the instantiation.
//     * Afterwards all logging outputs will be removed.
//     */
//    @Test
//    public void testQM2() {
//        de.uni_hildesheim.sse.easy.maven.Registration.register();
//        try {
////            executeScript("reasoner", "qm2.vil", "QM");
//            executeScript("reasoner", "removeLogger.vil", "removeLogger", tmpdir);
//        } catch (ModelManagementException e) {
//            Assert.fail(e.getMessage());
//        } catch (VilException e) {
//            Assert.fail(e.getMessage());
//        }
//    }
//    
    /**
     * Remove all logging from reasoner.
     */
    @Test
    public void testReasoner() {
        try {
            File target = new File(getArtifactsFolder(), "reasoner/tmp");
            File script = new File(getArtifactsFolder(), "reasoner/reasoner/removeLogger.vil");
            executeScript("reasoner/reasoner", script, target);
        } catch (ModelManagementException e) {
            Assert.fail(e.getMessage());
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }
    }

}
