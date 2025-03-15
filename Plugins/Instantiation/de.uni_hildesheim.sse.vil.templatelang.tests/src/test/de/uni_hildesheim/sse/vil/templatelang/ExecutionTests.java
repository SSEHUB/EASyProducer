package test.de.uni_hildesheim.sse.vil.templatelang;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.dslCore.translation.Message;
import net.ssehub.easy.instantiation.core.model.artifactModel.IFileSystemArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.defaultInstantiators.RandomDouble;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateLangExecution;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.persistency.IVMLWriter;
import net.ssehub.easy.varModel.varModel.testSupport.DefaultConfiguration;

/**
 * Performs some executions of templates and compares the traces
 * against expected traces and the output against expected output.
 * 
 * @author Holger Eichelberger
 */
public class ExecutionTests extends AbstractExecutionTest {

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
     * @param name the name of the file (excluding ".out")
     * @return the file
     */
    private static final File createOutFile(String name) {
        return new File(DIR, name + ".out");
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
        EqualitySetup<Template> setup = new EqualitySetup<Template>(createFile(name), name, null, 
            createTraceFile(name), param);
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
        net.ssehub.easy.varModel.confModel.Configuration ivmlCfg 
            = new net.ssehub.easy.varModel.confModel.Configuration(varModel);
        Configuration cfg = new Configuration(ivmlCfg);
        return assertEqual(vtlModelName, "main", cfg, expectedExceptions);
    }

    /**
     * Tests VTL function pointers.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testApply() throws IOException {
        assertEqual("apply");
    }
    
    /**
     * Tests VTL function pointers with typedefs, also imported ones.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testApply2() throws IOException {
        assertEqual("apply2");
    }

    /**
     * Tests an apply iterator without result.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testApply3() throws IOException {
        assertEqual("apply3");
    }
    
    /**
     * Tests an apply iterator with result.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testApply4() throws IOException {
        assertEqual("apply4");
    }
    
    /**
     * Tests a select operation with an aggregating iterator (failing).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testApply4Fail() throws IOException {
        assertEqual("apply4fail", VilException.ID_INVALID_ITERATOR);
    }
    
    /**
     * Tests an apply iterator with result and different types for result and iteration.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testApply5() throws IOException {
        assertEqual("apply5");
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
     * Tests set operations.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSet() throws IOException {
        assertEqual("set");
    }
    
    /**
     * Tests enumerating sequences.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSequence() throws IOException {
        assertEqual("sequence");
    }
    
    /**
     * Tests the map operation for sequences.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSequence1() throws IOException {
        assertEqual("sequence1");
    }
    
    /**
     * Tests a composite Boolean select condition on compounds (QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSequence2() throws IOException {
        assertEqualWithIvml("sequence2", "sequence2");
    }

    /**
     * Tests a simple Boolean select condition on compounds (QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSequence3() throws IOException {
        assertEqualWithIvml("sequence3", "sequence2");
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
     * Tests simple defs with defaults.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDef2() throws IOException {
        assertEqual("def2");
    }

    /**
     * Tests simple defs with defaults.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDef4() throws IOException {
        assertEqual("def4");
    }
    
    /**
     * Tests simple defs with direct set return.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDef5() throws IOException {
        assertEqualWithIvml("def5", "def5");
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
     * Tests empty string values [contributed by IIP-Ecosphere].
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testEmptyString() throws IOException {
        assertEqualWithIvml("emptyString", "emptyString");
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
     * Tests an alternative on an IVML compound access.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative5() throws IOException {
        assertEqualWithIvml("alternative5", "alternative5");
    }

    /**
     * Tests a constant alternative with undefined variable, initially defined in alternative.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative6() throws IOException {
        assertEqual("alternative6");
    }

    /**
     * Tests an alternative on an IVML enum/constants. [contributed by IIP-Ecosphere]
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAlternative7() throws IOException {
        assertEqualWithIvml("alternative7", "alternative7");
    }

    /**
     * Tests a simple while loop using an Integer.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testWhileLoop1() throws IOException {
        assertEqual("whileLoop1");
    }

    /**
     * Tests a simple while loop using an Integer (not entered).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testWhileLoop2() throws IOException {
        assertEqual("whileLoop2");
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
     * Tests a simple loop with iterator.
     * 
     * @throws IOException should not occur
     */
    @Ignore("Jenkins")
    @Test
    public void testLoop5() throws IOException {
        assertEqual("loop5");
    }

    /**
     * Tests sub-string statements (contributed by C. Qin/QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testString1() throws IOException {
        assertEqual("string1");
    }

    /**
     * Tests compounds.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompound() throws IOException {
        assertEqual("compound");
    }

    /**
     * Tests compounds.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompound1() throws IOException {
        assertEqual("compound1");
    }
    
    /**
     * Tests compounds with shadowing.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompound2() throws IOException {
        assertEqualWithIvml("compound2", "compounds2");
    }
    
    /**
     * Tests compounds with redefined slots via Any.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompound3() throws IOException {
        assertEqualWithIvml("compound3", "compounds3");
    }

    /**
     * Tests compounds with direct field accessor call.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompound4() throws IOException {
        assertEqualWithIvml("compound4", "compounds4");
    }

    /**
     * Tests compounds with multi-refinements [contributed by IIP-Ecosphere].
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompound5() throws IOException {
        assertEqualWithIvml("compound5", "compounds5");
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
     * Tests a switch statement over IVML types.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSwitch3() throws IOException {
        assertEqualWithIvml("switch3", "dispatch4");
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
    
    /**
     * Tests a switch statement with an imported value.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testImport2() throws IOException {
        assertEqual("importTest2");
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
     * Tests simple content with failing expression.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent20() throws IOException {
        assertEqual("content20");
    }

    /**
     * Tests content produced by nested defs [contributed by IIP-Ecosphere].
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent21() throws IOException {
        assertEqual("content21");
    }

    /**
     * Tests content produced by nested import defs [contributed by IIP-Ecosphere].
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent21b() throws IOException {
        assertEqual("content21b");
    }
    
    /**
     * Tests content produced by a loop over an empty sequence [contributed by IIP-Ecosphere].
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent22() throws IOException {
        assertEqual("content22");
    }

    /**
     * Tests content with formatting hints [contributed by IIP-Ecosphere].
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testHint() throws IOException {
        assertEqual("hint");
    }
    
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
     * Tests escaping replacements.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent11() throws IOException {
        assertEqual("content11");
    }

    /**
     * Tests formatting.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent12() throws IOException {
        assertEqualsNoSourceComparison("content12");
    }

    /**
     * Tests (nested) formatting with indentation annotation.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent13() throws IOException {
        assertEqual("content13");
    }

    /**
     * Tests (nested) formatting (same as {@link #testContent13()} but without indentation annotation.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent14() throws IOException {
        assertEqualsNoSourceComparison("content14");
    }

    /**
     * Tests nested formatting.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent15() throws IOException {
        assertEqualsNoSourceComparison("content15");
    }

    /**
     * Tests in-place content alternatives.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent16() throws IOException {
        assertEqual("content16");
    }

    /**
     * Tests in-place content loops.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent17() throws IOException {
        assertEqual("content17");
    }

    /**
     * Tests content statements with container initializer parameters.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent18() throws IOException {
        assertEqual("content18");
    }
    
    /**
     * Tests content statements with recursive variable/expression resolution.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testContent19() throws IOException {
        assertEqual("content19");
    }

    /**
     * Tests the flush statement.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testFlush() throws IOException {
        assertEqual("flush");
    }

    /**
     * Asserts equality of the trace and output during execution without asserting the 
     * equality of the formatted sources.
     * 
     * @param name the name of the test (files)
     * @throws IOException problems finding or reading the model file
     */
    private void assertEqualsNoSourceComparison(String name) throws IOException {
        Map<String, Object> param = createParameterMap(null, null);
        EqualitySetup<Template> setup = new EqualitySetup<Template>(createFile(name), name, null, 
            createTraceFile(name), param);
        setup.setExpectedOutputFile(createOutFile(name));
        setup.setEnableEquals(false);
        assertEqual(setup);
    }
    
    /**
     * Tests the collect operation on set.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCollect1() throws IOException {
        assertEqual("collect1");
    }

    /**
     * Tests the collect operation on sequence. The trace shows alpha-num sorted collections while
     * the output file the correct sequence.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCollect2() throws IOException {
        assertEqual("collect2");
    }

    /**
     * Tests the collect operation on sequence while changing the type of the return sequence by projection.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCollect3() throws IOException {
        assertEqual("collect3");
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
     * @throws VilException should not occur
     * @throws ConfigurationException should not occur
     */
    @Test
    public void testIvml6() throws IOException, VilException, ConfigurationException {
        String name = "ivml6";
        Configuration cfg = new Configuration(DefaultConfiguration.createDefaultConfiguration());
        Map<String, Object> param = createParameterMap(cfg, null);
        EqualitySetup<Template> setup = new EqualitySetup<Template>(createFile(name), name, null, 
            createTraceFile(name), param);
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
     * Tests simple Boolean return.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReturn1() throws IOException {
        assertEqual("return1");
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
     * Tests a Java path.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testJavaPath() throws IOException {
        assertEqual("javaPath");
    }
    
    /**
     * Tests some map operations.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMaps() throws IOException {
        assertEqual("maps");
    }
    
    /**
     * Tests the map sequence operation.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMapSequence() throws IOException {
        assertEqual("mapSequence");
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
     * Tests a line end formatting hint.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLineEnd() throws IOException {
        assertEqual("lineEnd");
    }
    
    /**
     * Tests a line end (windows) formatting hint.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLineEnd2() throws IOException {
        assertEqual("lineEnd2");
    }

    /**
     * Tests a line end (linux) formatting hint.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLineEnd3() throws IOException {
        assertEqual("lineEnd3");
    }

    /**
     * Tests a line end (windows-by-name) formatting hint.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLineEnd4() throws IOException {
        assertEqual("lineEnd4");
    }

    /**
     * Tests a line end (Linux-by-name) formatting hint.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testLineEnd5() throws IOException {
        assertEqual("lineEnd5");
    }

    /**
     * Tests the basic implementation of isValid.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testIsValid() throws IOException {
        assertEqualWithIvml("isValid", "adviceTestVM1");
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
     * Tests an advice with implicit value replacement
     * ({@link net.ssehub.easy.instantiation.core.model.vilTypes.IActualValueProvider}) for the configuration object.
     * The test shall actually do the same as {@link #testAdvice4()} except for the explicit configuration
     * projection to the target project. <br/>
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

    /**
     * Tests an a strange null situation in VTL (contributed by C. Qin, QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm1() throws IOException {
        assertEqualWithIvml("qm1", "qm1");
    }
    
    /**
     * Tests actual types in collections (contributed by C. Qin, QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm1o1() throws IOException {
        assertEqualWithIvml("qm1.1", "qm1");
    }

    /**
     * Tests selections on IVML types (contributed by C. Qin, QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm1o2() throws IOException {
        assertEqualWithIvml("qm1.2", "qm1");
    }
    
    /**
     * Tests toSequence on IVML types (contributed by C. Qin, QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm1o3() throws IOException {
        assertEqualWithIvml("qm1.3", "qm1");
    }
    
    /**
     * Tests typedefed operation on IVML types (contributed by C. Qin, QualiMaster). Negative case.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm1o4() throws IOException {
        assertEqualWithIvml("qm1.4", "qm1");
    }

    /**
     * Tests typedefed operation on IVML types (contributed by C. Qin, QualiMaster). Positive case.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm1o5() throws IOException {
        assertEqualWithIvml("qm1.5", "qm1_5");
    }
    
    /**
     * Tests an a strange null situation in VTL (contributed by C. Qin, QualiMaster).
     * The same as {@link #testQm1()} but with an explicit "null" value.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm2() throws IOException {
        assertEqualWithIvml("qm2", "qm1");
    }

    /**
     * Tests {@link #testQm2()} but with field access.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm2o1() throws IOException {
        assertEqualWithIvml("qm2.1", "qm1");
    }
    
    /**
     * Tests field access.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm0() throws IOException {
        assertEqualWithIvml("qm0", "qm0");
    }
    
    /**
     * Tests field access + size.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm0o1() throws IOException {
        assertEqualWithIvml("qm0.1", "qm0");
    }    
    
    /**
     * Tests an a switch problem in VTL (contributed by C. Qin, QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm3() throws IOException {
        assertEqualWithIvml("qm3", "qm1");
    }

    /**
     * Tests an a switch problem in VTL (contributed by C. Qin, QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm4() throws IOException {
        assertEqualWithIvml("qm4", "qm1");
    }

    /**
     * Tests an a is-defined/is-null in VTL (contributed by C. Qin, QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm5() throws IOException {
        assertEqualWithIvml("qm5", "qm5");
    }
    
    /**
     * Tests an access problem in VTL (contributed by C. Qin, QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm6() throws IOException {
        assertEqualWithIvml("qm6", "qm6");
    }

    /**
     * Tests an nested maps in VTL (contributed by C. Qin, QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm7() throws IOException {
        assertEqualWithIvml("qm7", "qm7");
    }

    /**
     * Tests an nested maps in VTL (contributed by C. Qin, QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm7o1() throws IOException {
        assertEqualWithIvml("qm7.1", "qm7");
    }
    
    /**
     * Tests switch-defaults (contributed by C. Qin, QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm8() throws IOException {
        assertEqualWithIvml("qm8", "qm8");
    }
    
    /**
     * Tests typedef-basetype compliance (contributed by QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm9() throws IOException {
        assertEqualWithIvml("qm9", "qm9");
    }
    
    /**
     * Tests callOf (contributed by QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQm10() throws IOException {
        assertEqualWithIvml("qm10", "qm7");
    }

    /**
     * Tests sorting IVML elements via expression.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSort() throws IOException {
        assertEqualWithIvml("sort", "SortModel");
    }
    
    /**
     * Tests sorting IVML map elements via expression.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSort2() throws IOException {
        assertEqualWithIvml("sort2", "SortModel");
    }
    
    /**
     * Tests IVML null values.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testNull1() throws IOException {
        assertEqualWithIvml("null1", "null1");
    }

    /**
     * Tests a dispatch on a supertype.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDispatch3() throws IOException {
        assertEqualWithIvml("dispatch3", "dispatch3");
    }
    
    /**
     * Tests a dispatch on a supertype and multiple parameters (contributed by QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDispatch3o1() throws IOException {
        assertEqualWithIvml("dispatch3_1", "dispatch3");
    }

    /**
     * Tests a dispatch on a supertype and basic types (contributed by QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDispatch4() throws IOException {
        assertEqualWithIvml("dispatch4", "dispatch4");
    }

    /**
     * Tests a dispatch on a refined reference type (contributed by QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDispatch5() throws IOException {
        assertEqualWithIvml("dispatch5", "dispatch5");
    }

    /**
     * Tests a dispatch on a refined reference type and DecisionVariable (contributed by C. Qin, QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDispatch6() throws IOException {
        assertEqualWithIvml("dispatch6", "dispatch5"); // IVML model is dispatch5
    }

    /**
     * Tests a dispatch on a refined reference type and DecisionVariable (contributed by C. Qin, QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDispatch7() throws IOException {
        assertEqualWithIvml("dispatch7", "dispatch5"); // IVML model is dispatch5
    }
    
    /**
     * Tests a dispatch on a indirect references (contributed by C. Qin, QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDispatch8() throws IOException {
        assertEqualWithIvml("dispatch8", "dispatch8");
    }
    
    /**
     * Tests type-based selection in VTL with advice.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTypes1() throws IOException {
        assertEqualWithIvml("types1", "dispatch8");
    }

    /**
     * Tests type-based selection in VTL without advice.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTypes2() throws IOException {
        assertEqualWithIvml("types2", "dispatch8");
    }

    /**
     * Tests nested fields on references.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReferences1() throws IOException {
        assertEqualWithIvml("references1", "references1");
    }

    /**
     * Tests equality of references.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReferences2() throws IOException {
        assertEqualWithIvml("references2", "references2");
    }

    /**
     * Tests the value of a reference into a collection.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReferences3() throws IOException {
        assertEqualWithIvml("references3", "references3");
    }
    
    /**
     * Tests the value of a reference into a collection (contributed by QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReferences4() throws IOException {
        assertEqualWithIvml("references4", "references4");
    }
    
    /**
     * Tests the value of a reference into a collection via typedefs (contributed by QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReferences5() throws IOException {
        assertEqualWithIvml("references5", "references5");
    }

    /**
     * Tests the negation of boolean IVML variables.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testBoolean() throws IOException {
        assertEqualWithIvml("bool", "bool");
    }

    /**
     * Tests the compatibility of a mapped configuration type.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testBoolean2() throws IOException {
        assertEqualWithIvml("bool2", "bool");
    }
    
    /**
     * Tests "casting" types by assignment.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCast1() throws IOException {
        assertEqualWithIvml("cast1", "cast1");
    }

    /**
     * Tests the format operation.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testFormat() throws IOException {
        Locale loc = Locale.getDefault();
        Locale.setDefault(Locale.GERMAN); // the file to check against has German number formatting
        assertEqualWithIvml("formatTest", "formatTest");
        Locale.setDefault(loc);
    }

    /**
     * Tests a template about dynamic dispatch to sub-templates (contributed by S. El-Sharkawy).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testQmDispatch() throws IOException {
        assertEqualWithIvml("qmDispatch", "QMDispatch");
    }
    
    /**
     * Tests dynamic imports with dynamic dispatch.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDynamicImports() throws IOException {
        assertEqualWithIvml("dynamicImports", "adviceTestVM1");
    }

    /**
     * Tests VTL builder blocks.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testBuilder() throws IOException {
        assertEqual("builder");
    }

}
