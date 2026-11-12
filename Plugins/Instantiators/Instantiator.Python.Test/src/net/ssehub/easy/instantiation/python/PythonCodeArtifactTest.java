package net.ssehub.easy.instantiation.python;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.Executor;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.tracing.ConsoleTracerFactory;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeArtifact;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeArtifactCreator;

import static net.ssehub.easy.varModel.varModel.testSupport.TextTestUtils.assertFileEqualitySafe;

import test.de.uni_hildesheim.sse.vil.buildlang.AbstractExecutionTest;
import test.de.uni_hildesheim.sse.vil.buildlang.BuildLangTestConfigurer;
import test.de.uni_hildesheim.sse.vil.buildlang.ITestConfigurer;

/**
 * Python code tests.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeArtifactTest extends AbstractExecutionTest<Script> {

    private static final PythonCodeArtifactCreator CREATOR = new PythonCodeArtifactCreator();

    @Override
    protected ITestConfigurer<Script> createTestConfigurer() {
        return new BuildLangTestConfigurer("instantiator.python.testdata.home");
    }

    @Before
    public void setUp() {
        Registration.register();
    }

    private void executeScript(String artifactsFolder, File script, File targetFile) {
        String scriptName = script.getName().replaceAll(".vil", "");

        try {
            ProjectDescriptor source = new ProjectDescriptor(script.getAbsolutePath(), scriptName);
            ProjectDescriptor target = new ProjectDescriptor(source, targetFile);

            TracerFactory.setDefaultInstance(ConsoleTracerFactory.INSTANCE);
            Executor executor = new Executor(source.getMainVilScript()).addSource(source).addTarget(target)
                            .addConfiguration(ProjectDescriptor.getConfiguration(scriptName));
            executor.execute();

        } catch (ModelManagementException e) {
            System.out.println(e.getMessage());
            fail(e.getMessage());
        } catch (VilException e) {
            System.out.println(e.getMessage());
            fail(e.getMessage());
        }
    }

    private void executeTestFile(String name) {
        File vilScript = new File("testdata/" + name, name + ".vil");
        File target = new File("testdata/" + name);

        executeScript(name, vilScript, target);

        File result = new File("testdata/" + name, name + ".py");
        File expected = new File("testdata/" + name, name + ".py.expected");
        assertFileEqualitySafe(result, expected);
    }

    @Test
    public void testArtifactCreator() {
        File tmpFile = new File("testdata/testArtifactCreator", "test.py");
        File expected = new File("testdata/testArtifactCreator", "test.py.expected");

        try {
            PythonCodeArtifact art = (PythonCodeArtifact) CREATOR.createArtifactInstance(tmpFile, null);
            art.setComment("test comment");
            art.store();
        } catch (VilException e) {
            fail("vil exception");
        }

        assertFileEqualitySafe(tmpFile, expected);
    }

    @Test
    public void test1() {
        executeTestFile("test1");
    }

    @Test
    public void testWhile() {
        executeTestFile("testWhile");
    }

    @Test
    public void testIf() {
        executeTestFile("testIf");
    }

    @Test
    public void testAdd() {
        executeTestFile("testAdd");
    }

    @Test
    public void testClass() {
        executeTestFile("testClass");
    }

    @Test
    public void testFunc() {
        executeTestFile("testFunc");
    }

    @Test
    public void testImport() {
        executeTestFile("testImport");
    }

    @Test
    public void testFor() {
        executeTestFile("testFor");
    }

    @Test
    public void testException() {
        executeTestFile("testException");
    }

    @Test
    public void testLambda() {
        executeTestFile("testLambda");
    }

    @Test
    public void testMatch() {
        executeTestFile("testMatch");
    }

    @Test
    public void testTypeAlias() {
        executeTestFile("testTypeAlias");
    }

    @Test
    public void testWith() {
        executeTestFile("testWith");
    }

    @Test
    public void testMisc() {
        executeTestFile("testMisc");
    }
}