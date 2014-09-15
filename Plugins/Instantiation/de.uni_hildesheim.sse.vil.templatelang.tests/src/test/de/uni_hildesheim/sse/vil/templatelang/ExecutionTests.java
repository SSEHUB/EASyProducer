package test.de.uni_hildesheim.sse.vil.templatelang;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.dslCore.translation.Message;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IFileSystemArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators.RandomDouble;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateLangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.persistency.IVMLWriter;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.varModel.testSupport.DefaultConfiguration;

/**
 * Performs some executions of templates and compares the traces
 * against expected traces and the output against expected output.
 * 
 * @author Holger Eichelberger
 */
public class ExecutionTests extends AbstractTest {

    protected static final String PARAM_CONFIG = "config";
    protected static final String PARAM_TARGET = "target";
    
    /**
     * Represents the directory containing the tests.
     */
    private static final File DIR = new File(TESTDATA_DIR, "execution");
    
    @Override
    protected File getTestFolder() {
        return DIR;
    }
    
    /**
     * Creates a file object relative to {@link #DIR} (not a file).
     * 
     * @param name the name of the file (excluding ".trc")
     * @return the file
     */
    private static final File createTraceFile(String name) {
        return new File(DIR, name + ".trc");
    }

    /**
     * Creates a file object relative to {@link #DIR} (not a file).
     * 
     * @param name the name of the file (excluding ".out")
     * @return the file
     */
    private static final File createOutFile(String name) {
        return new File(DIR, name + ".out");
    }

    /**
     * Creates a default parameter map.
     * 
     * @param config the configuration (use empty if <b>null</b>)
     * @param target the target artifact (use default if <b>null</b>)
     * @return the parameter map
     */
    private static Map<String, Object> createParameterMap(Configuration config, IArtifact target) {
        Map<String, Object> param = new HashMap<String, Object>();
        if (null == config) {
            de.uni_hildesheim.sse.model.confModel.Configuration cfg = DefaultConfiguration.createDefaultConfiguration();
            Assert.assertNotNull("creating default IVML configuration failed", cfg);
            config = new Configuration(cfg);
        }
        if (null == target) {
            try {
                target = ArtifactFactory.createFileSystemArtifact(new File("test.texts")); // shall be FileArtifact!!!
            } catch (ArtifactException e) {
                Assert.fail("unexpected exception: " + e.getMessage());
            }
        }
        param.put(TemplateLangExecution.PARAM_CONFIG, config);
        param.put(TemplateLangExecution.PARAM_TARGET, target);
        param.put(TemplateLangExecution.PARAM_CONFIG_SURE, config);
        param.put(TemplateLangExecution.PARAM_TARGET_SURE, target);
        return param;
    }

    /**
     * Execute the script in <code>name</code> with equally named trace and output file.
     * 
     * @param name the name of the test file (without extension), the name of the project and
     *   the name of the trace file (without extension)
     * @param expectedExceptions the expected extensions
     * @throws IOException in case that loading files or preparing the test environment fails
     */
    protected void assertEqual(String name, int... expectedExceptions) throws IOException {
        assertEqual(name, "main", expectedExceptions);
    }

    /**
     * Execute the script in <code>name</code> with equally named trace and output file.
     * 
     * @param name the name of the test file (without extension), the name of the project and
     *   the name of the trace file (without extension)
     * @param startRuleName the name of the start rule
     * @param expectedExceptions the expected extensions
     * @throws IOException in case that loading files or preparing the test environment fails
     */
    private void assertEqual(String name, String startRuleName, int... expectedExceptions) 
        throws IOException {
        assertEqual(name, startRuleName, null, expectedExceptions);
    }
    
    /**
     * Execute the script in <code>name</code> with equally named trace and output file.
     * 
     * @param name the name of the test file (without extension), the name of the project and
     *   the name of the trace file (without extension)
     * @param startRuleName the name of the start rule
     * @param cfg the configuration to be used (may be <b>null</b> for an empty one)
     * @param expectedExceptions the expected extensions
     * @return the warnings collected (may be <b>null</b>)
     * @throws IOException in case that loading files or preparing the test environment fails
     */
    protected List<Message> assertEqual(String name, String startRuleName, Configuration cfg, 
        int... expectedExceptions) throws IOException {
        Map<String, Object> param = createParameterMap(cfg, null);
        EqualitySetup setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name), param);
        setup.setStartElement(startRuleName);
        setup.setExpectedOutputFile(createOutFile(name));
        return assertEqual(setup, expectedExceptions);
    }
    
    /**
     * Execute the script in <code>name</code> with equally named trace and output file using
     * the variability model configuration in <code>varModelName</code> (must be unique, no versions).
     * 
     * @param vtlModelName the name of the VTL model to be executed
     * @param varModelName the name of the IVML model including frozen configuration to be used 
     *   (adviced in <code>vtlModelName</code>)
     * @param expectedExceptions the expected extensions
     * @return the warnings collected
     * @throws IOException in case that loading files or preparing the test environment fails
     */
    protected List<Message> assertEqualWithIvml(String vtlModelName, String varModelName, int... expectedExceptions) 
        throws IOException {
        List<ModelInfo<Project>> infos = VarModel.INSTANCE.availableModels().getModelInfo(varModelName);
        Assert.assertNotNull("IVML model '" + varModelName + "' not found", infos);
        Assert.assertEquals("IVML model '" + varModelName + "' ambiguous (" + infos.size() + "models found)", 
            1, infos.size());
        ModelInfo<Project> info = infos.get(0);
        Project varModel = null;
        try {
            varModel = VarModel.INSTANCE.load(info);
        } catch (ModelManagementException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
        Assert.assertNotNull("IVML model '" + varModelName + "' not loaded", varModel);
        Configuration cfg = new Configuration(new de.uni_hildesheim.sse.model.confModel.Configuration(varModel));
        return assertEqual(vtlModelName, "main", cfg, expectedExceptions);
    }

    /**
     * Tests simple content.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSimple() throws IOException {
        assertEqual("simple");
    }

    /**
     * Tests simple defs. This is an exceptional case as "value" in 
     * a def is considered as a content expression, not as a single String.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDef() throws IOException {
        assertEqual("def");
    }
    
    /**
     * Tests simple variables.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testVariables() throws IOException {
        assertEqual("variables");
    }
    
    /**
     * Tests simple content.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent1() throws IOException {
        assertEqual("content1");
    }

    /**
     * Tests a simple alternative with text output (two-sided, if).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative1() throws IOException {
        assertEqual("alternative1");
    }

    /**
     * Tests a simple alternative with text output (one-sided, else).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative2() throws IOException {
        assertEqual("alternative2");
    }

    /**
     * Tests a simple alternative with text output (two-sided, else).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative3() throws IOException {
        assertEqual("alternative3");
    }

    /**
     * Tests a simple alternative with text output (one-sided, if).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative4() throws IOException {
        assertEqual("alternative4");
    }
    
    /**
     * Tests a simple loop with empty body.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLoop1() throws IOException {
        assertEqual("loop1");
    }
    
    /**
     * Tests a simple loop with producing body.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLoop2() throws IOException {
        assertEqual("loop2");
    }

    /**
     * Tests a simple loop with producing body, separator and print.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLoop3() throws IOException {
        assertEqual("loop3");
    }

    /**
     * Tests a simple loop with producing body, separators and print.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLoop4() throws IOException {
        assertEqual("loop4");
    }
    
    /**
     * Tests a switch statement with default in an untyped def.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSwitch1() throws IOException {
        assertEqual("switch1");
    }

    /**
     * Tests a switch statement with default in a typed def.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSwitch2() throws IOException {
        assertEqual("switch2");
    }

    /**
     * Tests a switch statement with default in a typed def.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testImport() throws IOException {
        assertEqual("importTest");
    }

    // TODO test additional params
    
    // ------------ testing jenkins 
    
    /**
     * Tests simple content with variable mixing.
     * 
     * @throws IOException should not occur
     */
    /*@Test
    public void testContent2() throws IOException {
        // -> LocalExecutionTests
        assertEqual("content2");
    }*/

    /**
     * Tests simple content with expression mixing.
     * 
     * @throws IOException should not occur
     */
    /*@Test
    public void testContent3() throws IOException {
        // xtext inline parsing problem
        assertEqual("content3");
    }*/

    /**
     * Tests simple content with multi-line expression mixing but no indentation hint.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent4() throws IOException {
        assertEqual("content4");
    }

    /**
     * Tests simple content with multi-line expression mixing with 4-indentation hint.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent5() throws IOException {
        assertEqual("content5");
    }

    /**
     * Tests simple content with multi-line expression mixing with 4-indentation no addition hint.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent6() throws IOException {
        assertEqual("content6");
    }

    /**
     * Tests simple content with multi-line expression mixing with 4-indentation no addition hint.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent7() throws IOException {
        assertEqual("content7");
    }

    /**
     * Tests simple content with contained start-end-characters for content part.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent8() throws IOException {
        assertEqual("content8");
    }
    
    /**
     * Tests content with call to def.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent9() throws IOException {
        assertEqual("content9");
    }

    /**
     * Tests multiple replacements.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent10() throws IOException {
        assertEqual("content10");
    }
        
    /**
     * Tests a template derivation with calls and output.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDerived() throws IOException {
        assertEqual("derived");
    }

    /**
     * Tests a template with IVML references.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testIvml1() throws IOException {
        Configuration cfg = new Configuration(DefaultConfiguration.createDefaultConfiguration());
        assertEqual("ivml1", "main", cfg);
    }
    
    /**
     * Tests a template with IVML access to a collection.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testIvml2() throws IOException {
        Configuration cfg = new Configuration(DefaultConfiguration.createDefaultConfiguration());
        assertEqual("ivml2", "main", cfg);
    }

    /**
     * Tests a template with implicit conversion of IVML values.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testIvml3() throws IOException {
        Configuration cfg = new Configuration(DefaultConfiguration.createDefaultConfiguration());
        assertEqual("ivml3", "main", cfg);
    }
    
    /**
     * Tests a template about IVML enums.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testIvml4() throws IOException {
        Configuration cfg = new Configuration(DefaultConfiguration.createDefaultConfiguration());
        assertEqual("ivml4", "main", cfg);
    }
    
    /**
     * Tests a template about content expressions (contributed by S. El-Sharkawy).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testIvml5() throws IOException {
        Configuration cfg = new Configuration(DefaultConfiguration.createDefaultConfiguration());
        assertEqual("ivml5", "main", cfg);
    }

    /**
     * Tests a template about storing the IVML configuration (inspired by K. Schmid).
     * 
     * @throws IOException should not occur
     * @throws ArtifactException should not occur
     * @throws ConfigurationException should not occur
     */
    @Test
    public void testIvml6() throws IOException, ArtifactException, ConfigurationException {
        String name = "ivml6";
        Configuration cfg = new Configuration(DefaultConfiguration.createDefaultConfiguration());
        Map<String, Object> param = createParameterMap(cfg, null);
        EqualitySetup setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name), param);
        setup.setStartElement("main");
        setup.setExpectedOutputFile(createOutFile(name));
        IFileSystemArtifact target = (IFileSystemArtifact) setup.getParameter().get(TemplateLangExecution.PARAM_TARGET);
        assertEqual(setup);

        File file = target.getPath().getAbsolutePath();
        Assert.assertTrue("target file must exist", file.exists());
        String fileAsString = file2String(file).trim();
        java.io.CharArrayWriter expected = new CharArrayWriter();
        Project prj = cfg.getConfiguration().toProject(true, true);
        IVMLWriter writer = IVMLWriter.getInstance(expected);
        prj.accept(writer);
        IVMLWriter.releaseInstance(writer);
        String errorMsg = checkEqualsAndPrepareMessage(fileAsString, expected);
        Assert.assertTrue(errorMsg, null == errorMsg);
    }
    
    /**
     * Tests a template about dynamic dispatch to sub-templates (contributed by S. El-Sharkawy).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDispatch1() throws IOException {
        Configuration cfg = new Configuration(DefaultConfiguration.createDefaultConfiguration());
        assertEqual("dispatch1", "main", cfg);
    }

    /**
     * Tests a template about dynamic dispatch to sub-templates (contributed by S. El-Sharkawy).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDispatch2() throws IOException {
        Configuration cfg = new Configuration(DefaultConfiguration.createDefaultConfiguration());
        assertEqual("dispatch2", "main", cfg);
    }
    
    /**
     * Tests a template with a collection iterator.
     * 
     * @throws IOException should not occur
     */
    /*@Test // old syntax is not written back, disabled
    public void testIterator1() throws IOException {
        Configuration cfg = new Configuration(DefaultConfiguration.createDefaultConfiguration());
        assertEqual("iterator1", "main", cfg);
    }*/
    
    /**
     * Tests a template with a collection iterator (new syntax without type).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testIterator2() throws IOException {
        Configuration cfg = new Configuration(DefaultConfiguration.createDefaultConfiguration());
        assertEqual("iterator2", "main", cfg);
    }

    /**
     * Tests a template with a collection iterator (new syntax with type).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testIterator3() throws IOException {
        Configuration cfg = new Configuration(DefaultConfiguration.createDefaultConfiguration());
        assertEqual("iterator3", "main", cfg);
    }
    
    /**
     * Tests a template with replacement expression.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReplacement1() throws IOException {
        Configuration cfg = new Configuration(DefaultConfiguration.createDefaultConfiguration());
        assertEqual("replacement1", "main", cfg);
    }

    /**
     * Tests simple content with variable mixing.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent2() throws IOException {
        assertEqual("content2");
    }

    /**
     * Tests simple content with expression mixing.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent3() throws IOException {
        assertEqual("content3");
    }

    /**
     * Tests a Java extension with call and output.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJavaExtension() throws IOException {
        assertEqual("javaExtension");
    }

    /**
     * Tests a default Java extension for Random numbers (inspired by K. Schmid).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testRandom() throws IOException {
        boolean inTests = RandomDouble.setInTests(true);
        assertEqual("random");
        RandomDouble.setInTests(inTests);
    }
    
    /**
     * Tests an advice with types taken over from the variability model, here dynamic dispatch.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAdvice1() throws IOException {
        assertEqualWithIvml("advice1", "adviceTestVM1");
    }

    /**
     * Tests an advice with types taken over from the variability model, here dynamic dispatch and decision 
     * variable access.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAdvice2() throws IOException {
        assertEqualWithIvml("advice2", "adviceTestVM1"); // VM1 is ok
    }
    
    /**
     * Tests an advice with types taken over from the variability model.
     * This test focuses on the access to meta information.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAdvice3() throws IOException {
        assertEqualWithIvml("advice3", "adviceTestVM1"); // VM1 is ok
    }

    
    /**
     * Tests an advice with types taken over from the variability model.
     * This test focuses on the access to meta information.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAdvice4() throws IOException {
        assertEqualWithIvml("advice4", "adviceTestVM4"); // VM1 is ok
    }

    /**
     * Tests an advice with unknown types.
     * This test focuses on the dynamic project types.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAdviceUnknown() throws IOException {
        assertEqualWithIvml("adviceUnknown", "adviceTestVM1");
    }

    /**
     * Tests an advice with implicit value replacement ({@link de.uni_hildesheim.sse.easy_producer.instantiator.
     * model.vilTypes.IActualValueProvider}) for the configuration object. The test shall actually do the same
     * as {@link #testAdvice4()} except for the explicit configuration projection to the target project.
     * This test focuses on the dynamic project types.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAdvice5() throws IOException {
        assertEqualWithIvml("advice5", "adviceTestVM4"); // VM4 is ok/required
    }

    /**
     * Tests an advice with attributes. However, as attributes are bound to variables,
     * attributes of individual variables cannot be turned into functions at the moment.
     * This test focuses on the dynamic project types.
     * 
     * Currently, the attribute of the project is wrong... check configuration.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAdvice6() throws IOException {
        assertEqualWithIvml("advice6", "adviceTestVM6");
    }

    /**
     * Tests null values in VIL.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testNull() throws IOException {
        assertEqualWithIvml("null", "adviceTestVM1");
    }

    /**
     * Tests an advice with attributes and switching among dynamic and generic types.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAdvice7() throws IOException {
        assertEqualWithIvml("advice7", "adviceTestVM1");
    }

    /**
     * Tests an advice with enum values.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAdvice8() throws IOException {
        assertEqualWithIvml("advice8", "adviceTestVM8");
    }

}
