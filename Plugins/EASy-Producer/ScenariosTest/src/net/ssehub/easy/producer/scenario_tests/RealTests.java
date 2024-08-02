package net.ssehub.easy.producer.scenario_tests;

import static net.ssehub.easy.varModel.varModel.testSupport.TextTestUtils.assertFileEquality;
import static net.ssehub.easy.varModel.varModel.testSupport.TextTestUtils.assertFileEqualityRec;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

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

import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.velocity.VelocityInstantiator;

/**
 * Real use case tests. Although Maven is available, we run the tests without Maven in order to
 * avoid external resolution issues and to allow for offline use. Thus, maven is commented out if used.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class RealTests extends AbstractRealTests {

    protected static final String[] RELATIVE_CURL_EXECUTABLES = {"curl/curl.bat", "curl/curl.sh"};
    
    private static RealTests tests;
    
    @Override
    protected void addTestDataLocations() {
        // prevent testdata dir as default IVML location
    }

    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        tests = new RealTests();
        if (!debug) {
            tests.cleanTemp();
        }
        net.ssehub.easy.instantiation.maven.Registration.register();
        net.ssehub.easy.instantiation.java.Registration.register();
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
            try {
                FileUtils.deleteDirectory(baseFolder);
            } catch (IOException e) {
                System.out.println("Cannot delete " + baseFolder + ": " + e.getMessage());
            }
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
     * @return the base directory of the instantiated project (<b>null</b> for no assert)
     * @throws IOException in case of I/O problems
     */
    protected File executeIndenicaCase(String projectName, String ivmlVersion, String vilVersion, 
        String... makeExecutable) throws IOException {
        String[] versions = {ivmlVersion, vilVersion};
        return executeCase(projectName, versions, "INDENICA/", null, Mode.REASON_INSTANTIATE, 
            new MakeExecutableTestModifier(makeExecutable));
    }
    
    /**
     * Tests the complete VIL setup for the INDENICA RMS platform.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testIndenicaPlRmsPlatform2() throws IOException {
        File base = executeIndenicaCase("PL_RMS_Platform2", "0", "0", RELATIVE_CURL_EXECUTABLES);
        if (null != base) {
            assertCurlOut(base);
            FileUtils.deleteQuietly(base);
        }
        base = executeIndenicaCase("PL_RMS_Platform2", "0", "1", RELATIVE_CURL_EXECUTABLES);
        if (null != base) {
            assertCurlOut(base);
            cleanTempFolder(base);
        }
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
        if (null != base) {
            // Generated files
            File resources = new File(base, "src/main/resources/");
    
            assertCurlOut(base);
            String fileName = projectName + ".var";
            assertFileEquality(new File(base, "curl/" + fileName), new File(resources, fileName));
            fileName = "resolution.res";
            assertFileEquality(new File(base, "curl/" + fileName), new File(resources, fileName));
            cleanTempFolder(base);
        }
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
        File base = executeCase("New_Product", versions, "elevator/", "PL_SimElevator", Mode.REASON_INSTANTIATE);
        if (null != base) {
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
        File base = executeCase("NumericCSVInstantiationTest", new String[] {"0", "0"}, "", null, 
            Mode.REASON_INSTANTIATE);
        if (null != base) {
            File expectedFile = new File(base, "NumericCSVInstantiationTest.csv");
            File producedFile = new File(base, "expected/NumericCSVInstantiationTest.csv");
            assertExists(expectedFile);
            assertExists(producedFile);
            String expectedContent = file2String(expectedFile).replace("\r", "");
            String actualContent = file2String(producedFile).replace("\r", "");
            Assert.assertEquals(expectedContent, actualContent);
        }
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
        File base = executeCase("svncontrol", versions, "", null, Mode.REASON_INSTANTIATE);
        if (null != base) {
            assertExists(base, "variability/StaticConfiguration", ".java");
            assertExists(base, "variability/StartupConfiguration", ".java");
            assertExists(base, "variability/RuntimeConfiguration", ".java");
            assertExists(base, "gui/HooksTabAspect", ".aj");
            assertExists(base, "gui/ScheduleTabAspect", ".aj");
            assertExists(new File(base, "bin/client.jar"));
        }
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
        File base = executeCase("april14", versions, "QualiMaster/", null, Mode.REASON_INSTANTIATE);
        if (null != base) {
            assertFileEqualityRec(new File(base, "expected"), base);
        }
    }

    /**
     * Tests the very initial QualiMaster test case.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testQualiMasterMay14() throws IOException {
        String[] versions = {"0", "0"};
        File base = executeCase("may14", versions, "QualiMaster/", null, Mode.REASON_INSTANTIATE);
        if (null != base) {
            assertFileEqualityRec(new File(base, "expected"), base);
        }
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
        File base = executeCase(names, versions, "QualiMaster/", null, Mode.REASON_INSTANTIATE);
        if (null != base) {
            assertFileEqualityRec(new File(base, "expected"), base);
        }
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
        File base = executeCase(names, versions, "QualiMaster/", null, Mode.REASON_INSTANTIATE);
        enableRealTimeAsserts = false;
        if (null != base) {
            assertFileEqualityRec(new File(base, "expected"), base);
        }
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
        File base = executeCase(names, versions, "QualiMaster/", null, Mode.REASON_INSTANTIATE);
        if (null != base) {
            assertFileEqualityRec(new File(base, "expected"), base);
        }
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
        File base = executeCase(names, versions, "QualiMaster/", null, Mode.REASON_INSTANTIATE);
        if (null != base) {
            assertFileEqualityRec(new File(base, "expected"), base);
        }
    }

    /**
     * Tests the QualiMaster model / derivation (February 2017, without rt-VIL). Seems to fail on Jenkins.
     * This is a slightly modified version to ensure creation of artifacts in repeatable sequence.
     * 
     * @param mode the test execution mode
     * @throws IOException shall not occur
     */
    protected void testQualiMasterFeb17Impl(Mode mode) throws IOException {
        String[] versions = {"0", "0"};
        String[] names = {"feb17", "QM"};
        enableRealTimeAsserts = true;
        File base = executeCase(names, versions, "QualiMaster/", null, mode);
        enableRealTimeAsserts = false;
        if (null != base) {
            assertFileEqualityRec(new File(base, "expected"), base);
        }
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
        testQualiMasterFeb17Impl(Mode.REASON_INSTANTIATE);
    }
    
    /**
     * Tests the QualiMaster model / derivation (February 2017, experimentally modified, without rt-VIL). Seems to 
     * fail on Jenkins. This is a modified version for evaluating VIL/VTL.
     * 
     * @param mode the test execution mode
     * @throws IOException shall not occur
     */
    protected void testQualiMasterSep17Impl(Mode mode) throws IOException {
        String[] versions = {"0", "0"};
        String[] names = {"sep17", "QM"};
        enableRealTimeAsserts = true;
        File base = executeCase(names, versions, "QualiMaster/", null, mode);
        enableRealTimeAsserts = false;
        if (null != base) {
            assertFileEqualityRec(new File(base, "expected"), base);
        }
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
        testQualiMasterFeb17Impl(Mode.REASON_INSTANTIATE);
    }

    /**
     * Tests the QualiMaster model / derivation (June 2015, without rt-VIL).
     * 
     * @throws IOException shall not occur
     */
    @Ignore("Unresolved constant assignments")
    @Test
    public void testQualiMasterMay21() throws IOException {
        String[] versions = {"0", "0"};
        String[] names = {"may21", "QM"};
        executeCase(names, versions, "QualiMaster/", null, Mode.REASON_INSTANTIATE);
        // no comparison here
    }
    
    private static class IipTestModifier implements ITestModifier {

        private String vilFolderName;
        private String vilStartRuleName;
        private String[] cfgFolder;

        private IipTestModifier(String vilFolderName) {
            this(vilFolderName, "main");
        }

        private IipTestModifier(String vilFolderName, String vilStartRuleName) {
            this(vilFolderName, vilStartRuleName, null);
        }

        private IipTestModifier(String vilFolderName, String vilStartRuleName, String[] cfgFolder) {
            this.vilFolderName = vilFolderName;
            this.vilStartRuleName = vilStartRuleName;
            this.cfgFolder = cfgFolder;
        }
        
        @Override
        public void postCopy(File target) {
        }
        
        @Override
        public String[] getConfigurationFolder() {
            return cfgFolder;
        }

        @Override
        public String getTempFolderName(String projectName) {
            return projectName;
        }

        @Override
        public File getVilOutputFolder(File temp) {
            File result = new File(temp, vilFolderName);
            if (!result.exists()) {
                result.mkdirs();
            }
            return result;
        }

        @Override
        public String getVilStartRuleName() {
            return vilStartRuleName;
        }
        
    }

    /**
     * Tests the IIP-Ecosphere model / instantiation (October 21).
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testIipEcosphereOct21() throws IOException {
        final String folder = "oct21";
        executeIipCase(folder, "SerializerConfig1", "main");
        executeIipCase(folder, "SimpleMesh", "main");
        executeIipCase(folder, "SimpleMesh3", "main");
    }

    /**
     * Tests the IIP-Ecosphere model / instantiation (November 21).
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testIipEcosphereNov21() throws IOException {
        final String folder = "nov21";
        executeIipCase(folder, "SerializerConfig1", "main");
        executeIipCase(folder, "SimpleMesh", "main");
        executeIipCase(folder, "SimpleMesh3", "main");
    }

    /**
     * Tests the IIP-Ecosphere model / instantiation (September 21).
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testIipEcosphereSep22() throws IOException {
        final String folder = "sep22";
        executeIipCase(folder, "SimpleMesh", "generateApps");
        executeIipCase(folder, "SimpleMesh3", "generateApps");
        executeIipCase(folder, "SerializerConfig1", "main");
        executeIipCase(folder, "SerializerConfig1Old", "generateApps");
        executeIipCase(folder, "RoutingTest", "generateApps");
        executeIipCase(folder, "KodexMesh", "generateApps");
    }

    /**
     * Tests the IIP-Ecosphere model / instantiation (for debugging).
     * 
     * @throws IOException shall not occur
     */
    @Ignore("debugging model")
    @Test
    public void testIipEcosphereTest() throws IOException {
        org.junit.Assume.assumeTrue(System.getProperty("os.name").startsWith("Windows")); // comparison fails on linux
        final String folder = "mar23";
        executeIipCase(folder, "PlatformConfiguration", "generateApps");
    }

    /**
     * Tests the oktoflow model / instantiation (June 24).
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testOktoflowJun24() throws IOException {
        final String folder = "jun24";
        executeIipCase(folder, "ApiPlatformConfiguration", "generateApi", "tests/api", "tests/common");
        executeIipCase(folder, "PlatformConfiguration", "generateApps", "tests/simpleMesh3", "tests/common");
        executeIipCase(folder, "SerializerConfig1", "main", "tests/single", "tests/common");
        executeIipCase(folder, "SerializerConfig1Old", "generateApps", "tests/single", "tests/common");
        executeIipCase(folder, "KodexMesh", "generateApps", "tests/single", "tests/common");
        executeIipCase(folder, "Modbus", "generateApps", "tests/modbus");
    }


    
    /**
     * Executes an IIP-Ecosphere case.
     * 
     * @param folder the case folder
     * @param modelName the name of the model to load and execute (expected files/created files in folder of same name)
     * @param vilStartRuleName the name of the VIL start rule to execute
     * @param cfgFolder additional IVML configuration folders, may be <b>null</b>
     * @throws IOException if execution/comparison fails
     */
    protected void executeIipCase(String folder, String modelName, String vilStartRuleName, 
        String... cfgFolder) throws IOException {
        String vilFolderName = modelName; // assumed same in expected
        String[] versions = null;
        String[] names = {folder, modelName, "IIPEcosphere"};
        File base = executeCase(names, versions, "IIP-Ecosphere/", null, Mode.REASON_INSTANTIATE, 
            new IipTestModifier(vilFolderName, vilStartRuleName, cfgFolder));
        assertFileEqualityRec(new File(new File(base, "expected"), vilFolderName), new File(base, vilFolderName), 
            new FileFilter() {
            
                @Override
                public boolean accept(File pathname) {
                    return !pathname.toString().endsWith("__pycache__");
                }
            }
        );
    }
    
    /*protected TracerFactory getTracerFactory() {
        return ConsoleTracerFactory.INSTANCE;
    }*/
    
}
