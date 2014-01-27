package test.de.uni_hildesheim.sse.scenarios;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests for the basic language.
 * 
 * @author Holger Eichelberger
 */
public class RealTests extends AbstractScenarioTest {

    protected static final String[] RELATIVE_CURL_EXECUTABLES = {"curl/curl.bat", "curl/curl.sh"};
    
    private static RealTests tests;
    
    @Override
    protected String getSystemPropertyName() {
        return "easy_producer.scenarios.testdata.home";
    }
    
    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        tests = new RealTests();
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
    
    @Override
    protected File getTestFolder() {
        return new File(getTestDataDir(), "real");
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
        EqualitySetup data = new EqualitySetup(createFile(file), expectedName, null);
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
        EqualitySetup data = new EqualitySetup(createFile(file), expectedName, expectedVersion, null);
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
        EqualitySetup data = new EqualitySetup(createFile(file), file, null, null);
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
        return executeCase(projectName, versions, "INDENICA/", null, makeExecutable);
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
        FileUtils.deleteQuietly(base);
    }
    
    /**
     * Tests the complete VIL setup for the INDENICA YMS platform.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testIndenicaPlYmsPlatform() throws IOException {
        String projectName = "PL_YMS_Platform";
        File base = executeIndenicaCase(projectName, "0", "0", RELATIVE_CURL_EXECUTABLES);
        assertCurlOut(base);
        File resources = new File(base, "src/main/resources/");
        String fileName = projectName + ".var";
        assertFileEquality(new File(resources, fileName), new File(base, "curl/" + fileName));
        fileName = "resolution.res";
        assertFileEquality(new File(resources, fileName), new File(base, "curl/" + fileName));
        FileUtils.deleteQuietly(base);
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
        File base = executeCase("New_Product", versions, "elevator/", "PL_SimElevator");
        
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
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

        FileUtils.deleteQuietly(base);
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
     * Tests the SVNControl test case.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testSvncontrol() throws IOException {
        String[] versions = {"0", "0"};
        testSvncontrol(versions);
        versions[1] = "0.1";
        testSvncontrol(versions);
    }

    /**
     * Tests the SVNcontrol use case for given versions.
     * 
     * @param versions the version of the models, index 0 IVML, index 1 VIL build file (may be <b>null</b>)
     * @throws IOException shall not occur
     */
    private void testSvncontrol(String[] versions) throws IOException {
        File base = executeCase("svncontrol", versions, "", null);
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

}
