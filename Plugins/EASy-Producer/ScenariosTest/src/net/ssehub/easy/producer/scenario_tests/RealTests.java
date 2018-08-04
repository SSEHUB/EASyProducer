package net.ssehub.easy.producer.scenario_tests;

import static net.ssehub.easy.varModel.varModel.testSupport.TextTestUtils.assertFileEquality;
import static net.ssehub.easy.varModel.varModel.testSupport.TextTestUtils.assertFileEqualityRec;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.instantiation.maven.Registration;
import net.ssehub.easy.instantiation.velocity.VelocityInstantiator;
import net.ssehub.easy.reasoning.core.frontend.IReasonerInstance;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.AbstractTestDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.varModel.testSupport.MeasurementCollector;

/**
 * Real use case tests. Although Maven is available, we run the tests without Maven in order to
 * avoid external resolution issues and to allow for offline use. Thus, maven is commented out if used.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class RealTests extends AbstractEasyScenarioTest {

    protected static final String[] RELATIVE_CURL_EXECUTABLES = {"curl/curl.bat", "curl/curl.sh"};
    
    private static final int MAX_REASONING = 1; // increase for taking measurements
    private static final int MAX_INSTANCE_REASONING = 2; // increase for taking measurements
    private static RealTests tests;
    private boolean enableRealTimeAsserts;
    
    @Override
    protected void addTestDataLocations() {
    }

    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        tests = new RealTests();
        tests.cleanTemp();
        Registration.register();
        VelocityInstantiator.register();
    }

    /**
     * Tears down the test.
     */
    @AfterClass
    public static void shutDown() {
        if (!debug && null != tests) {
            tests.cleanTemp();
            tests = null;
        }
    }
    
    @Override
    protected File getTestFolder() {
        return new File(getTestDataDir(), "real");
    }
    
    /**
     * Deletes a newly created folder inside the temp folder.
     * Should be called after the creation of new tests.
     * @param baseFolder A project folder created during a test.
     */
    protected void cleanTempFolder(File baseFolder) {
        if (!debug) {
            FileUtils.deleteQuietly(baseFolder);
        }
    }

    /**
     * Asserts equality of the models and the parsed/analyzed result, i.e. it
     * reads <code>file</code> as a model, analyzes it, compares the obtained
     * errors with <code>expectedErrorCodes</code>, compares the contents of
     * <code>file</code> with the printed (analyzed) model and checks the
     * project information directly obtained from file. It is assumed that 
     * no version shall be checked.
     * 
     * @param file
     *            the name of the file containing the model (without suffix)
     * @param expectedName
     *            the expected name of the model
     * @param expectedErrorCodes
     *            the expected and allowed error codes (errors occurring
     *            multiple times need to be listed multiple times here)
     * @throws IOException
     *             problems finding or reading the model file
     */
    protected void assertEqual(String file, String expectedName, int... expectedErrorCodes) 
        throws IOException {
        EqualitySetup<Script> data = new EqualitySetup<Script>(createFile(file), expectedName, null);
        assertEqual(data, expectedErrorCodes);
    }
    
    /**
     * Asserts equality of the models and the parsed/analyzed result, i.e. it
     * reads <code>file</code> as a model, analyzes it, compares the obtained
     * errors with <code>expectedErrorCodes</code>, compares the contents of
     * <code>file</code> with the printed (analyzed) model and checks the
     * project information directly obtained from file. It is assumed that 
     * the name of the model is the same as of the file.
     * 
     * @param file
     *            the name of the file containing the model (without suffix)
     * @param expectedName
     *            the expected name of the model
     * @param expectedVersion
     *            the expected version of <code>expectedName</code>
     * @param expectedErrorCodes
     *            the expected and allowed error codes (errors occurring
     *            multiple times need to be listed multiple times here)
     * @throws IOException
     *             problems finding or reading the model file
     */
    protected void assertEqual(String file, String expectedName, String expectedVersion, int... expectedErrorCodes) 
        throws IOException {
        EqualitySetup<Script> data = new EqualitySetup<Script>(createFile(file), expectedName, expectedVersion, null);
        assertEqual(data, expectedErrorCodes);
    }
    
    /**
     * Asserts equality of the models and the parsed/analyzed result, i.e. it
     * reads <code>file</code> as a model, analyzes it, compares the obtained
     * errors with <code>expectedErrorCodes</code>, compares the contents of
     * <code>file</code> with the printed (analyzed) model and checks the
     * project information directly obtained from file. It is assumed that 
     * the name of the model is the same as of the file and no version.
     * 
     * @param file
     *            the name of the file containing the model (without suffix)
     * @param expectedErrorCodes
     *            the expected and allowed error codes (errors occurring
     *            multiple times need to be listed multiple times here)
     * @throws IOException
     *             problems finding or reading the model file
     */
    protected void assertEqual(String file, int... expectedErrorCodes) throws IOException {
        EqualitySetup<Script> data = new EqualitySetup<Script>(createFile(file), file, null, null);
        assertEqual(data, expectedErrorCodes);
    }
    
    /**
     * Assert the output of the curl wrapper to be expected.
     * @param base the base directory
     * @throws IOException in case of I/O problems (shall not happen)
     */
    protected void assertCurlOut(File base) throws IOException {
        File producedFile = new File(base, "curl/curl.out"); 
        File expectedFile = new File(base, "curl/expected.out"); // we could also read the copy source
        assertFileEquality(producedFile, expectedFile);
    }
    
    /**
     * Executes an INDENICA case.
     * 
     * @param projectName the name of the project
     * @param ivmlVersion the version of the IVML file (may be <b>null</b>)
     * @param vilVersion the version of the VIL build file (may be <b>null</b>)
     * @param makeExecutable those files (in relative paths) within the temporary copy of the project to be 
     *   made executable
     * @return the base directory of the instantiated project
     * @throws IOException in case of I/O problems
     */
    protected File executeIndenicaCase(String projectName, String ivmlVersion, String vilVersion, 
        String... makeExecutable) throws IOException {
        String[] versions = {ivmlVersion, vilVersion};
        return executeCase(projectName, versions, "INDENICA/", null, true, makeExecutable);
    }
    
    /**
     * Tests the complete VIL setup for the INDENICA RMS platform.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testIndenicaPlRmsPlatform2() throws IOException {
        File base = executeIndenicaCase("PL_RMS_Platform2", "0", "0", RELATIVE_CURL_EXECUTABLES);
        assertCurlOut(base);
        FileUtils.deleteQuietly(base);
        base = executeIndenicaCase("PL_RMS_Platform2", "0", "1", RELATIVE_CURL_EXECUTABLES);
        assertCurlOut(base);
        cleanTempFolder(base);
    }
    
    /**
     * Tests the complete VIL setup for the INDENICA YMS platform.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testIndenicaPlYmsPlatform() throws IOException {
        String projectName = "PL_YMS_Platform";

        // Original files
        File base = executeIndenicaCase(projectName, "0", "0", RELATIVE_CURL_EXECUTABLES);
        
        // Generated files
        File resources = new File(base, "src/main/resources/");

        assertCurlOut(base);
        String fileName = projectName + ".var";
        assertFileEquality(new File(base, "curl/" + fileName), new File(resources, fileName));
        fileName = "resolution.res";
        assertFileEquality(new File(base, "curl/" + fileName), new File(resources, fileName));
        cleanTempFolder(base);
    }

    /**
     * Tests the initial Easy-Producer 1 build file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testEP1() throws IOException {
        assertEqual("ep1");
    }

    /**
     * Tests the initial YMS build file (contributed by Christian).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testYMS1() throws IOException {
        assertEqual("yms1");
    }
    
    
    /**
     * Tests the elevator case.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testElevator() throws IOException {
        String[] versions = {"0", "0"};
        File base = executeCase("New_Product", versions, "elevator/", "PL_SimElevator", true);
        
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        Assert.assertNotNull("No JDK compiler, are you running JRE?", compiler);
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        List<File> files = new ArrayList<File>();
        enumerateJavaFiles(new File(base, "src"), files);
        List<String> options = new ArrayList<String>();
        options.add("-d");
        options.add(new File(base, "bin").getAbsolutePath());
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(files);
        StringWriter writer = new StringWriter();
        boolean success = compiler.getTask(writer, fileManager, null, options, null, compilationUnits).call();
        try {
            fileManager.close(); 
        } catch (IOException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
        Assert.assertTrue("compile problems: " + writer.toString(), success);

        cleanTempFolder(base);
    }

    /**
     * Enumerate Java files in <code>location</code> and store results in <code>files</code>.
     * 
     * @param location the location to enumerate
     * @param files the resulting java files (modified as a side effect)
     */
    protected void enumerateJavaFiles(File location, List<File> files) {
        if (location.isDirectory()) {
            File[] dir = location.listFiles();
            if (null != dir) {
                for (File f : dir) {
                    enumerateJavaFiles(f, files);
                }
            }
        } else {
            if (location.getName().endsWith(".java")) {
                files.add(location);
            }
        }
    }
    
    /**
     * Tests whether the instantiation process of templates will work.
     * @throws IOException If the produced file was not saved or the expected file was not found for comparison
     */
    @Test
    public void testInstantiateNumericCSVInstantiation() throws IOException {
        File base = executeCase("NumericCSVInstantiationTest", new String[] {"0", "0"}, "", null, true);
        File expectedFile = new File(base, "NumericCSVInstantiationTest.csv");
        File producedFile = new File(base, "expected/NumericCSVInstantiationTest.csv");
        assertExists(expectedFile);
        assertExists(producedFile);
        String expectedContent = file2String(expectedFile).replace("\r", "");
        String actualContent = file2String(producedFile).replace("\r", "");
        Assert.assertEquals(expectedContent, actualContent);
    }
    
    /**
     * Tests the SVNControl test case.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testSvncontrol() throws IOException {
        String msg = net.ssehub.easy.instantiation.aspectj.Registration.checkEnvironment();
        if (null != msg) {
            System.out.println("Warning: " + msg);
        } else {
            String[] versions = {"0", "0"};
            testSvncontrol(versions);
            versions[1] = "0.1";
            testSvncontrol(versions);
        }
    }

    /**
     * Tests the SVNcontrol use case for given versions.
     * 
     * @param versions the version of the models, index 0 IVML, index 1 VIL build file (may be <b>null</b>)
     * @throws IOException shall not occur
     */
    private void testSvncontrol(String[] versions) throws IOException {
        File base = executeCase("svncontrol", versions, "", null, true);
        assertExists(base, "variability/StaticConfiguration", ".java");
        assertExists(base, "variability/StartupConfiguration", ".java");
        assertExists(base, "variability/RuntimeConfiguration", ".java");
        assertExists(base, "gui/HooksTabAspect", ".aj");
        assertExists(base, "gui/ScheduleTabAspect", ".aj");
        assertExists(new File(base, "bin/client.jar"));
    }
    
    /**
     * Asserts the existence of the given source file and the related class file.
     * 
     * @param base the base folder
     * @param name the name/path of the file (without extension)
     * @param extension the primary extension which leads to the class file
     */
    protected static void assertExists(File base, String name, String extension) {
        assertExists(new File(base, name + extension));
        assertExists(new File(base, name + ".class"));
    }

    /**
     * Asserts the existence of the given file.
     * 
     * @param file the file
     */
    protected static void assertExists(File file) {
        Assert.assertTrue("file " + file.getPath() + " does not exist", file.exists());
    }

    /**
     * Tests the very initial QualiMaster test case.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testQualiMasterApril14() throws IOException {
        String[] versions = {"0", "0"};
        File base = executeCase("april14", versions, "QualiMaster/", null, true);
        assertFileEqualityRec(new File(base, "expected"), base);
    }

    /**
     * Tests the very initial QualiMaster test case.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testQualiMasterMay14() throws IOException {
        String[] versions = {"0", "0"};
        File base = executeCase("may14", versions, "QualiMaster/", null, true);
        assertFileEqualityRec(new File(base, "expected"), base);
    }

    /**
     * Tests the QualiMaster model / derivation in its state at the first review (February 2015).
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testQualiMasterFeb15() throws IOException {
        String[] versions = {"0", "0"};
        String[] names = {"feb15", "QM"};
        File base = executeCase(names, versions, "QualiMaster/", null, true);
        assertFileEqualityRec(new File(base, "expected"), base);
    }

    /**
     * Tests the QualiMaster model / derivation in its state at the second review (February 2016).
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testQualiMasterFeb16() throws IOException {
        String[] versions = {"0", "0"};
        String[] names = {"feb16", "QM"};
        enableRealTimeAsserts = true;
        File base = executeCase(names, versions, "QualiMaster/", null, true);
        enableRealTimeAsserts = false;
        assertFileEqualityRec(new File(base, "expected"), base);
    }

    // a simple runtime variability test, at least that runtime reasoning seems to be working
    @Override
    protected Configuration assertConfiguration(net.ssehub.easy.varModel.model.Project prj, boolean doReasoning) {
        Configuration result = super.assertConfiguration(prj, doReasoning);
        if (enableRealTimeAsserts && "QM".equals(prj.getName())) {
            net.ssehub.easy.varModel.confModel.Configuration cfg = result.getConfiguration();
            try {
                AbstractVariable ppfe2 = ModelQuery.findVariable(prj, "PriorityPip_FamilyElement2", null);
                if (null != ppfe2) {
                    IDecisionVariable cVar = cfg.getDecision(ppfe2);
                    IDecisionVariable eVar = cVar.getNestedElement("capacity");
                    // set to extreme high capacity, shall lead to failure
                    eVar.setValue(ValueFactory.createValue(eVar.getDeclaration().getType(), 1.0), 
                        AssignmentState.ASSIGNED);
                    System.out.println("Performing runtime reasoning/propagation...");
                    ReasonerConfiguration rCfg = new ReasonerConfiguration();
                    rCfg.setRuntimeMode(true);
                    for (int r = 1; r <= MAX_REASONING; r++) {
                        String id = MeasurementCollector.start(cfg, "SCENARIO-INC " + r);
                        ReasoningResult res = ReasonerFrontend.getInstance().propagate(prj, 
                            cfg, rCfg, ProgressObserver.NO_OBSERVER);
                        MeasurementCollector.endAuto(id);
                        net.ssehub.easy.reasoning.core.reasoner.AbstractTest.transferReasoningMeasures(
                            MeasurementCollector.getInstance(), id, getMeasurements(), res);
                        MeasurementCollector.end(id);
                        res.logInformation(prj, rCfg);
                        Assert.assertTrue("Runtime configuration must have conflict", res.hasConflict());
                        assertFailureMessage(res, ppfe2);
                    }

                    if (MAX_INSTANCE_REASONING > 0) {
                        System.out.println("Performing runtime reasoning/propagation with instance ...");
                        long instanceCreation = System.currentTimeMillis();
                        IReasonerInstance inst = ReasonerFrontend.getInstance().createInstance(prj, cfg, rCfg);
                        instanceCreation = System.currentTimeMillis() - instanceCreation;
                        for (int r = 1; r <= MAX_INSTANCE_REASONING; r++) {
                            String id = MeasurementCollector.start(cfg, "SCENARIO-INST " + r);
                            ReasoningResult res = inst.propagate(ProgressObserver.NO_OBSERVER);
                            MeasurementCollector.endAuto(id);
                            net.ssehub.easy.reasoning.core.reasoner.AbstractTest.transferReasoningMeasures(
                                MeasurementCollector.getInstance(), id, getMeasurements(), res);
                            MeasurementCollector.set(id, 
                                AbstractTestDescriptor.MeasurementIdentifier.REASONER_INSTANCE_CREATION_TIME, 
                                instanceCreation);
                            MeasurementCollector.end(id);
                            res.logInformation(prj, rCfg);
                            Assert.assertTrue("Runtime configuration must have conflict", res.hasConflict());
                            assertFailureMessage(res, ppfe2);
                        }
                    }
                }
            } catch (ModelQueryException e) {
                e.printStackTrace();
            } catch (ValueDoesNotMatchTypeException e) {
                e.printStackTrace();
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Asserts failure messages for each <code>vars</code>.
     * 
     * @param res the reasoning result
     * @param vars the variables that must cause conflicts
     */
    private static void assertFailureMessage(ReasoningResult res, AbstractVariable... vars) {
        Set<AbstractVariable> check = new HashSet<AbstractVariable>();
        for (AbstractVariable v : vars) {
            check.add(v);
        }
        for (int m = 0; m < res.getMessageCount(); m++) {
            Message msg = res.getMessage(m);
            for (Set<AbstractVariable> s : msg.getConstraintVariables()) {
                for (AbstractVariable v : s) {
                    check.remove(v);
                }
            }
        }
        Assert.assertTrue("No runtime failure found for " + check, check.isEmpty());
    }

    /**
     * Tests the QualiMaster model / derivation for VIL field migration (March 2015).
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testQualiMasterMar15() throws IOException {
        String[] versions = {"0", "0"};
        String[] names = {"mar15", "QM"};
        File base = executeCase(names, versions, "QualiMaster/", null, true);
        assertFileEqualityRec(new File(base, "expected"), base);
    }

    /**
     * Tests the QualiMaster model / derivation (June 2015, without rt-VIL).
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testQualiMasterJun15() throws IOException {
        String[] versions = {"0", "0"};
        String[] names = {"jun15", "QM"};
        File base = executeCase(names, versions, "QualiMaster/", null, true);
        assertFileEqualityRec(new File(base, "expected"), base);
    }

    /**
     * Tests the QualiMaster model / derivation (February 2017, without rt-VIL). Seems to fail on Jenkins.
     * This is a slightly modified version to ensure creation of artifacts in repeatable sequence.
     * 
     * @throws IOException shall not occur
     */
    protected void testQualiMasterFeb17Impl() throws IOException {
        String[] versions = {"0", "0"};
        String[] names = {"feb17", "QM"};
        enableRealTimeAsserts = true;
        File base = executeCase(names, versions, "QualiMaster/", null, true);
        enableRealTimeAsserts = false;
        assertFileEqualityRec(new File(base, "expected"), base);
    }
    
    /**
     * Tests the QualiMaster model / derivation (February 2017, without rt-VIL). Seems to fail on Jenkins.
     * This is a slightly modified version to ensure creation of artifacts in repeatable sequence.
     * 
     * @throws IOException shall not occur
     */
    @Ignore
    @Test
    public void testQualiMasterFeb17() throws IOException {
        testQualiMasterFeb17Impl();
    }
    
    /**
     * Tests the QualiMaster model / derivation (February 2017, experimentally modified, without rt-VIL). Seems to 
     * fail on Jenkins. This is a modified version for evaluating VIL/VTL.
     * 
     * @throws IOException shall not occur
     */
    protected void testQualiMasterSep17Impl() throws IOException {
        String[] versions = {"0", "0"};
        String[] names = {"sep17", "QM"};
        enableRealTimeAsserts = true;
        File base = executeCase(names, versions, "QualiMaster/", null, true);
        enableRealTimeAsserts = false;
        assertFileEqualityRec(new File(base, "expected"), base);
    }
    
    /**
     * Tests the QualiMaster model / derivation (February 2017, experimentally modified, without rt-VIL). Seems to 
     * fail on Jenkins. This is a modified version for evaluating VIL/VTL.
     * 
     * @throws IOException shall not occur
     */
    @Ignore
    @Test
    public void testQualiMasterSep17() throws IOException {
        testQualiMasterFeb17Impl();
    }
    
}
