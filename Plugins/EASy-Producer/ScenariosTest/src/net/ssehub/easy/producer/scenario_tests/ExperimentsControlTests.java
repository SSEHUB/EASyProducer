package net.ssehub.easy.producer.scenario_tests;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.IvmlException;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IResolutionScope;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.persistency.IVMLWriter;
import test.de.uni_hildesheim.sse.AbstractTest;

/**
 * A test class for blackbox testing parser and type resolution of 
 * IVML files contributed from "external" sources. These are basically IVML tests, which 
 * cannot be executed in IVML.tests as the reasoner dependency is not available there. 
 * 
 * @author Holger Eichelberger
 */
public class ExperimentsControlTests extends AbstractTest {

    /**
     * Creates a file in {@link #getTestDataDir()}.
     * 
     * @param name
     *            the name of the file (excluding ".ivml")
     * @return the file
     */
    private static final File createFile(String name) {
        return new File(getTestDataDir(), "experiments/control/" + name + ".ivml");
    }
    
    /**
     * Initializes the test.
     */
    @BeforeClass
    public static void startUp() {
        setTestDataDir("easy_producer.scenarios.testdata.home");
        AbstractTest.startUp();
        AbstractScenarioTest.initializeReasoner();
        IVMLWriter.setUseIvmlWhitespace(true);
    }

    /**
     * Shuts down the test.
     */
    @AfterClass
    public static void shutDown() {
        AbstractTest.shutDown();
        setTestDataDir(TESTDATA_SYSTEM_PROPERTY);
    }

    /**
     * Creates a file name, obtains the the project, asserts equality, creates a configuration and returns
     * the configuration.
     * 
     * @param name the name of the project
     * @return the configuration
     * @throws IOException in case that loading fails
     */
    private Configuration createAndAssertEqual(String name) throws IOException {
        List<Project> prj = assertEqual(createFile(name), null, null);
        Assert.assertTrue(null != prj && 1 == prj.size());
        Project project = prj.get(0);
        Assert.assertNotNull(project);
        return new Configuration(project);
    }
    
    /**
     * Asserts and returns a decision variable.
     * 
     * @param config the configuration to read from
     * @param name the name of the variable
     * @return the variable if it exists
     * @throws ModelQueryException if finding the variable fails
     */
    private IDecisionVariable assertDecisionVariable(Configuration config, String name) throws ModelQueryException {
        AbstractVariable decl = ModelQuery.findVariable(config.getProject(), name, null);
        Assert.assertNotNull(decl);
        IDecisionVariable var = config.getDecision(decl);
        Assert.assertNotNull(var);
        return var;
    }

    /**
     * Asserts an enumeration value.
     * 
     * @param scope the scope to search the expected value within
     * @param expected the (qualified) expected value as a string (may be <b>null</b>, requiring that 
     *     <code>value</code> is also <b>null</b>)
     * @param value the actual value
     * @throws ModelQueryException if querying the model for <code>expected</code> failed
     * @throws IvmlException if creating the value for <code>expected</code> failed
     */
    private static void assertEnumValue(IResolutionScope scope, String expected, Value value) 
        throws ModelQueryException, IvmlException {
        if (null == expected) {
            Assert.assertTrue(value == null || NullValue.INSTANCE == value);
        } else {
            Value enumVal = ModelQuery.enumLiteralAsValue(scope, expected);
            Assert.assertEquals(enumVal, value);
        }
    }

    /**
     * Asserts an enumeration value.
     * 
     * @param config the configuration to take the value/scope from
     * @param expected the (qualified) expected value as a string (may be <b>null</b>, requiring that 
     *     the value of <code>slot</code> is also <b>null</b>)
     * @param value the actual compound value
     * @param slot the slot within <code>value</code> to test for
     * @throws ModelQueryException if querying the model for <code>expected</code> failed
     * @throws IvmlException if creating the value for <code>expected</code> failed
     */
    private static void assertEnumValue(Configuration config, String expected, CompoundValue value, String slot) 
        throws ModelQueryException, IvmlException {
        assertEnumValue(config.getProject(), expected, value.getNestedValue(slot));
    }

    /**
     * Asserts an integer value.
     * 
     * @param config the configuration to take the value/scope from
     * @param expected the (qualified) expected value (may be <b>null</b>, requiring that 
     *     the value of <code>slot</code> is also <b>null</b>)
     * @param value the actual compound value
     * @param slot the slot within <code>value</code> to test for
     */
    private static void assertIntValue(Configuration config, Integer expected, CompoundValue value, String slot) {
        Value val = value.getNestedValue(slot);
        if (null == expected) {
            Assert.assertNull(val);
        } else {
            Assert.assertTrue(val instanceof IntValue);
            Assert.assertEquals(expected, ((IntValue) val).getValue()); 
        }
    }

    /**
     * Tests variant models with same variables/expected results like "defaults1".
     * 
     * @param name the name of the model/file
     * @throws IOException shall not occur
     * @throws ModelQueryException shall not occur
     * @throws IvmlException shall not occur
     */
    private void testDefaults(String name) throws IOException, ModelQueryException, IvmlException {
        Configuration config = createAndAssertEqual(name);
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        rConfig.setAdditionalInformationLogger(ReasonerConfiguration.ADDITIONAL_INFO_LOG_NONE);
        ReasoningResult res = doReasoning(config, rConfig);
        Assert.assertFalse("there should not be reasoning conflicts", res.hasConflict());
        //Configuration.printConfig(System.out, config);

        IDecisionVariable da1 = assertDecisionVariable(config, "a1");
        IDecisionVariable da2 = assertDecisionVariable(config, "a2");
        CompoundValue v1 = (CompoundValue) da1.getValue();
        CompoundValue v2 = (CompoundValue) da2.getValue();

        assertEnumValue(config, "Kind.kind1", v1, "produces");
        assertEnumValue(config, null, v1, "consumes");
        assertIntValue(config, null, v1, "count");
        assertEnumValue(config, null, v2, "produces");
        assertEnumValue(config, "Kind.kind2", v2, "consumes");
        assertIntValue(config, null, v2, "count");

        IDecisionVariable dr1 = assertDecisionVariable(config, "r1");
        IDecisionVariable dw1 = assertDecisionVariable(config, "w1");
        CompoundValue w1 = (CompoundValue) dw1.getValue();
        CompoundValue r1 = (CompoundValue) dr1.getValue();

        assertEnumValue(config, "Kind.kind1", r1, "produces");
        assertEnumValue(config, null, r1, "consumes");
        assertIntValue(config, 5, r1, "count");
        assertEnumValue(config, null, w1, "produces");
        assertEnumValue(config, "Kind.kind2", w1, "consumes");
        assertIntValue(config, 10, w1, "count");
        
        IDecisionVariable dseq = assertDecisionVariable(config, "seq");
        ContainerValue seq = (ContainerValue) dseq.getValue();
        Assert.assertEquals(2, seq.getElementSize());
        CompoundValue s1 = (CompoundValue) seq.getElement(0);
        CompoundValue s2 = (CompoundValue) seq.getElement(1);

        assertEnumValue(config, "Kind.kind1", s1, "produces");
        assertEnumValue(config, null, s1, "consumes");
        assertIntValue(config, 6, s1, "count");
        assertEnumValue(config, null, s2, "produces");
        assertEnumValue(config, "Kind.kind2", s2, "consumes");
        assertIntValue(config, 7, s2, "count");
    }
    
    /**
     * Tests "defaults1". Uses simple constraints.
     * 
     * @throws IOException shall not occur
     * @throws ModelQueryException shall not occur
     * @throws IvmlException shall not occur
     */
    @Test
    public void testControlDefaults1() throws IOException, ModelQueryException, IvmlException {
        testDefaults("defaults1");
    }

    /**
     * Tests "defaults2". Uses shadowed slots.
     * 
     * @throws IOException shall not occur
     * @throws ModelQueryException shall not occur
     * @throws IvmlException shall not occur
     */
    @Test
    public void testControlDefaults2() throws IOException, ModelQueryException, IvmlException {
        testDefaults("defaults2");
    }

    /**
     * Tests "defaults3". This has not completely the same semantics as "defaults1" as slots
     * are not uninitialized (Java <b>null</b>) rather than containing the {@link NullValue#INSTANCE IVML null}.
     * Uses assigning dynamic-dispatch user-defined operations.
     * 
     * @throws IOException shall not occur
     * @throws ModelQueryException shall not occur
     * @throws IvmlException shall not occur
     */
    @Test
    public void testControlDefaults3() throws IOException, ModelQueryException, IvmlException {
        testDefaults("defaults3");
    }

    /**
     * Tests "defaults4". Uses assigning dynamic-dispatch user-defined operations.
     * 
     * @throws IOException shall not occur
     * @throws ModelQueryException shall not occur
     * @throws IvmlException shall not occur
     */
    @Test
    public void testControlDefaults4() throws IOException, ModelQueryException, IvmlException {
        testDefaults("defaults4");
    }

    /**
     * Tests inherited sub-constraints enabled/disabled through default values (from QM).
     * 
     * @throws IOException shall not occur
     * @throws ModelQueryException shall not occur
     * @throws IvmlException shall not occur
     */
    @Test
    public void testSub() throws IOException, ModelQueryException, IvmlException {
        Configuration config = createAndAssertEqual("configSub");
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        rConfig.setAdditionalInformationLogger(ReasonerConfiguration.ADDITIONAL_INFO_LOG_NONE);
        ReasoningResult res = doReasoning(config, rConfig);
        Assert.assertFalse("there should not be reasoning conflicts", res.hasConflict());
    }
    
    /**
     * A simple control file test (contributed by M. Keunecke).
     * 
     * @throws IOException shall not occur
     * @throws ModelQueryException shall not occur
     * @throws IvmlException shall not occur
     */
    @Test
    public void simpleTest() throws IOException, ModelQueryException, IvmlException {
        Configuration config = createAndAssertEqual("simple/Einfache_Steuerdatei_0");
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        rConfig.setAdditionalInformationLogger(ReasonerConfiguration.ADDITIONAL_INFO_LOG_NONE);
        ReasoningResult res = doReasoning(config, rConfig);
        Assert.assertFalse("there should not be reasoning conflicts", res.hasConflict());
    }

    /**
     * A test for an existence quantor in a user defined operation utilized by an all quantor (contributed by 
     * M. Keunecke).
     * 
     * @throws IOException shall not occur
     * @throws ModelQueryException shall not occur
     * @throws IvmlException shall not occur
     */
    @Test
    public void existsTest() throws IOException, ModelQueryException, IvmlException {
        Configuration config = createAndAssertEqual("exists/BaseSD_0");
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        rConfig.setAdditionalInformationLogger(ReasonerConfiguration.ADDITIONAL_INFO_LOG_NONE);
        ReasoningResult res = doReasoning(config, rConfig);
        Assert.assertFalse("there should not be reasoning conflicts", res.hasConflict());
    }

    /**
     * A test for an asymmetric quantor relation (contributed by M. Keunecke).
     * 
     * @throws IOException shall not occur
     * @throws ModelQueryException shall not occur
     * @throws IvmlException shall not occur
     */
    @Test
    public void asymmetricTest() throws IOException, ModelQueryException, IvmlException {
        Configuration config = createAndAssertEqual("assymetric/ActivityGraph2Configuration_0");
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        rConfig.setAdditionalInformationLogger(ReasonerConfiguration.ADDITIONAL_INFO_LOG_NONE);
        ReasoningResult res = doReasoning(config, rConfig);
        // dependenciesAntisymmetry does not fit configuration!
        Assert.assertTrue("there should be reasoning conflicts", res.hasConflict());
        Assert.assertEquals(1, res.getMessageCount());
        Message msg = res.getMessage(0);
        boolean found = false;
        for (IDecisionVariable v : msg.getNamedConstraintVariables()) {
            found |= v.getDeclaration().getName().equals("dependenciesAntisymmetry");
        }
        Assert.assertTrue("Constraint dependenciesAntisymmetry shall fail", found);
    }

    /**
     * A test for a failing activity graph configuration (contributed by M. Keunecke, J. Hagedorn).
     * 
     * @throws IOException shall not occur
     * @throws ModelQueryException shall not occur
     * @throws IvmlException shall not occur
     */
    @Test
    public void activityTestFail() throws IOException, ModelQueryException, IvmlException {
        Configuration config = createAndAssertEqual("activity/ActivityGraphConfiguration_0");
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        rConfig.setAdditionalInformationLogger(ReasonerConfiguration.ADDITIONAL_INFO_LOG_NONE);
        ReasoningResult res = doReasoning(config, rConfig);
        // checkSheetAfterReadSheets does not fit configuration!
        for (int m = 0; m < res.getMessageCount(); m++) {
            System.out.println(res.getMessage(m));
        }
        Assert.assertTrue("there should be reasoning conflicts", res.hasConflict());
    }

    /**
     * A test for a succeeding activity graph configuration (contributed by M. Keunecke, J. Hagedorn).
     * 
     * @throws IOException shall not occur
     * @throws ModelQueryException shall not occur
     * @throws IvmlException shall not occur
     */
    @Test
    public void activityTest() throws IOException, ModelQueryException, IvmlException {
        Configuration config = createAndAssertEqual("activity/ActivityGraphConfiguration_1");
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        rConfig.setAdditionalInformationLogger(ReasonerConfiguration.ADDITIONAL_INFO_LOG_NONE);
        ReasoningResult res = doReasoning(config, rConfig);
        // dependenciesAntisymmetry does not fit configuration!
        for (int m = 0; m < res.getMessageCount(); m++) {
            System.out.println(res.getMessage(m));
        }
        Assert.assertFalse("there should not be reasoning conflicts", res.hasConflict());
    }
    
    /**
     * Performs the reasoning.
     * 
     * @param cfg the configuration
     * @param rConfig the reasoner configuration
     * @return the reasoning result
     */
    private ReasoningResult doReasoning(Configuration cfg, ReasonerConfiguration rConfig) {
        ReasoningResult res = ReasonerFrontend.getInstance().propagate(cfg.getProject(), cfg, rConfig, 
            ProgressObserver.NO_OBSERVER);
        res.logInformation(cfg.getProject(), rConfig);
        return res;
    }

    @Override
    protected boolean checkWriteback(File file) {
        return false;
    }

    /**
     * Tests a quantified type expression (contributed by M. Keunecke, J. Hagedorn).
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void typeTest() throws IOException {
        Configuration config = createAndAssertEqual("types/Testprodukt_0");
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        ReasoningResult res = doReasoning(config, rConfig);
        Assert.assertTrue("there should be reasoning conflicts", res.hasConflict());
    }
    
}
