package test.de.uni_hildesheim.sse.vil.buildlang;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.URI;
import org.junit.Assert;

import de.uni_hildesheim.sse.VilExpressionParser;
import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.translation.Message;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.BuiltIn;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.PathUtils;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.StreamTracer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.Executor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Project;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.velocity.VelocityInstantiator;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;

/**
 * The refined version of abstract tests for the build language.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractTest extends de.uni_hildesheim.sse.dslCore.test.AbstractTest<Script> {

    /**
     * Creates and initializes an abstract test.
     */
    protected AbstractTest() {
        resourceInitialization();
        BuiltIn.initialize();
        furtherInitialization();
        registerTypeAnyway(TouchInstantiator.class);
        registerTypeAnyway(VelocityInstantiator.class);
        BuildlangExecution.setExpressionParser(new VilExpressionParser());
        try {
            BuildModel.INSTANCE.loaders().registerLoader(BuildLangModelUtility.INSTANCE, OBSERVER);
            BuildModel.INSTANCE.locations().addLocation(getTestDataDir(), OBSERVER);
        } catch (ModelManagementException e) {
            e.printStackTrace(System.err);
            Assert.assertTrue(false); // shall not happen
        }
        test.de.uni_hildesheim.sse.vil.templatelang.AbstractTest.initializeInfrastructure(getTestDataDir());
        //cleanTemp();
    }

    /**
     * Performs further initialization.
     */
    protected void furtherInitialization() {
    }

    /**
     * Returns the system property determining the directory containing the actual test data.
     * 
     * @return the name of the system property
     */
    protected String getSystemPropertyName() {
        return "vil.buildlang.testdata.home";
    }
    
    /**
     * The directory containing all tests.
     * 
     * @return the test data directory
     */
    protected File getTestDataDir() {
        return determineTestDataDir(getSystemPropertyName());
    }

    /**
     * The temporary directory. This must be within {@link #getTestDataDir()} due to 
     * server-based testing in the continuous integration environment.
     * 
     * @return the temporary directory
     */
    protected File getTempDir() {
        return new File(getTestDataDir(), "temp");
    }
    
    /**
     * Returns the test folder.
     * 
     * @return the test folder
     */
    protected abstract File getTestFolder();
    
    /**
     * Creates a file object relative to {@link #DIR} (not a file).
     * 
     * @param name
     *            the name of the file (excluding ".vil")
     * @return the file
     */
    protected File createFile(String name) {
        return new File(getTestFolder(), name + ".vil");
    }
    
    /**
     * Copies the given <code>source</code> file to <code>destination</code>.
     * 
     * @param source the source file to be copied
     * @param destination the destination file
     * @throws IOException in case of I/O problems
     */
    protected static void copyFile(File source, File destination) throws IOException {
        FileUtils.copyFile(source, destination);
    }
    
    /**
     * Deletes the given directory or file quietly.
     * 
     * @param dir the directory to be deleted
     */
    protected static void deleteQuietly(File dir) {
        FileUtils.deleteQuietly(dir);
    }
    
    /**
     * Registers the given type ignoring a previous registration.
     * 
     * @param cls the type to be registered
     */
    protected static void registerTypeAnyway(Class<? extends IVilType> cls) {
        try {
            TypeRegistry.DEFAULT.registerType(cls);
        } catch (VilException e) {
            if (VilException.ID_ALREADY_REGISTERED != e.getId()) {
                Assert.fail("unexpected exception: " + e.getMessage());
            }
        }
    }

    /**
     * Asserts equality of the models and the parsed/analyzed result, i.e. it
     * reads <code>file</code> as a model, analyzes it, compares the obtained
     * errors with <code>expectedErrorCodes</code>, compares the contents of
     * <code>file</code> with the printed (analyzed) model and checks the
     * project information directly obtained from file or cached in the model
     * management.
     * 
     * @param data the data describing the setup
     * @param expectedErrorCodes the expected and allowed error codes (errors occurring
     *   multiple times need to be listed multiple times here)
     * @throws IOException problems finding or reading the model file
     */
    protected void assertEqual(EqualitySetup data, int... expectedErrorCodes)
        throws IOException {
        File file = data.getFile();
        if (file.exists()) {
            URI uri = URI.createFileURI(file.getAbsolutePath());

            // parse the model
            TranslationResult<Script> result = BuildLangModelUtility.INSTANCE.parse(uri);
            List<Message> messages = result.getMessageListSpecific();
            
            Assert.assertTrue("no result produced: " + toString(messages), result.getResultCount() > 0);
            if (0 == result.getErrorCount()) {
                // read model file into memory
                String fileAsString = file2String(file);
                Assert.assertTrue("not found: " + file, null != fileAsString);

                // read model into String
                java.io.CharArrayWriter expected = new CharArrayWriter();
                BuildLangModelUtility.INSTANCE.print(result, expected, false, false);
                String errorMsg = checkEqualsAndPrepareMessage(fileAsString, expected);
                Assert.assertTrue(errorMsg, null == errorMsg);
                assertNamingAndVersion(data, result);
            }
            Assert.assertTrue("currently multiple scripts are not handled", 1 == result.getResultCount());
            
            File expectedTrace = data.getExpectedTrace();
            if (null != expectedTrace && 0 == result.getErrorCount()) {
                java.io.CharArrayWriter trace = new CharArrayWriter();
                // TODO handle multiple
                try {
                    String fileAsString = file2String(expectedTrace);
                    Assert.assertTrue(null != fileAsString);

                    Script script = result.getResult(0);
                    BuildlangExecution exec = new BuildlangExecution(new StreamTracer(trace, getBaseFolders(data)), 
                        getTestDataDir(), data.getStartElement(), data.getParameter());
                    script.accept(exec);
                    //String traceAsString = writer.toString().trim();
                    //Assert.assertTrue(checkEqualsAndPrint(fileAsString, traceAsString));
                    String errorMsg = checkEqualsAndPrepareMessage(fileAsString, trace);
                    if (exec.getFailedCount() > 0) {
                        StringBuilder tmp = new StringBuilder("failed rules: ");
                        for (int i = 0; i < exec.getFailedCount(); i++) {
                            if (i > 0) {
                                tmp.append(", ");
                            }
                            tmp.append(exec.getFailed(i).getName());
                        }
                        System.out.println(tmp.toString());                        
                    }
                    Assert.assertNull(errorMsg, errorMsg);
                    
                    // do the same via the executor
                    testExecutor(result.getResult(0), data);
                } catch (VilLanguageException e) {
                    //e.printStackTrace(System.out); // for debugging
                    if (null == messages) {
                        messages = new ArrayList<Message>();
                    }
                    messages.add(new Message(e.getMessage(), Status.ERROR, null, null, e.getId()));
                }
            }
            String errorCodes = checkErrorCodes(messages, expectedErrorCodes);
            Assert.assertNull(errorCodes, errorCodes);
        } else {
            Assert.assertTrue("File '" + file + "' does not exist", false);
        }
    }
    
    /**
     * Obtain the base folders (for the stream tracer) from <code>setup</code>.
     * 
     * @param setup the setup instance to be analyzed for default parameters
     * @return the base folders or <b>null</b>
     */
    private static String[] getBaseFolders(EqualitySetup setup) {
        List<String> tmp = new ArrayList<String>();
        addBaseFolders(setup, Executor.PARAM_SOURCE, tmp);
        addBaseFolders(setup, Executor.PARAM_TARGET, tmp);
        // and also the script directory
        tmp.add(setup.getFile().getParentFile().getAbsolutePath());
        String[] result;
        if (tmp.size() > 0) {
            result = new String[tmp.size()];
            tmp.toArray(result);
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Adds base folders from <code>setup</code> for <code>paramName</code> to <code>result</code>.
     * 
     * @param setup the setup instance to be analyzed for default parameters
     * @param paramName the parameter name to be taken into account
     * @param result modified as a side effect to contain the obtained base folders
     */
    private static void addBaseFolders(EqualitySetup setup, String paramName, List<String> result) {
        Map<String, Object> param = setup.getParameter();
        if (null != param) {
            Object p = param.get(paramName);
            if (p instanceof Project) {
                Project tmp = (Project) p;
                addBaseFolder(tmp, result);
            } else if (p instanceof Project[]) {
                Project[] tmp = (Project[]) p;
                for (int i = 0; i < tmp.length; i++) {
                    addBaseFolder(tmp[i], result);
                }
            }
        }        
    }
    
    /**
     * Adds the (normalized) base folder of <code>project</code> to <code>result</code>.
     * 
     * @param project the project to be considered
     * @param result modified as a side effect to contain the obtained base folders
     */
    private static void addBaseFolder(Project project, List<String> result) {
        String baseFolder = project.getPath().getAbsolutePath().getAbsolutePath();
        baseFolder = PathUtils.normalize(baseFolder);
        if (!result.contains(baseFolder)) {
            result.add(baseFolder);
        }
    }

    /**
     * Runs the script (again) through the executor. May not lead to the same results as
     * repeated execution. Therefore, we do not check the results, just that the script is executed
     * without problems.
     * 
     * @param script the script to execute
     * @param data the test setup data, in particular the parameters and the start rule
     * @throws VilLanguageException in case that the execution fails (shall not happen but one never knows
     *     whether VIL fails runing the same script twice)
     */
    private void testExecutor(Script script, EqualitySetup data) 
        throws VilLanguageException {
        // this may not do the same as the execution before - this would be a second instantiation
        Map<String, Object> args = data.getParameter();
        // several test cases do not have all default parameters!
        boolean inputPresent = (args.containsKey(Executor.PARAM_SOURCE) && args.containsKey(Executor.PARAM_TARGET) 
            && args.containsKey(Executor.PARAM_CONFIG));
        Executor executor = new Executor(script, data.getParameter()).addBase(getTestDataDir())
            .addStartRuleName(data.getStartElement());
        try {
            executor.execute();
            if (!inputPresent) {
                Assert.fail("illegal input exception expected");
            }
        } catch (IllegalArgumentException e) {
            if (inputPresent) {
                Assert.fail("unexpected exception: " + e.getMessage());
            }
        }
    }

    
    /**
     * Creates a directory within the temporary directory this test class is taking care of.
     * This shall be deleted automatically at the end of the test.
     * 
     * @param name the name of the directory (may be a relative path)
     * @return the created directory
     * @throws IOException if problems occur when creating the directory 
     */
    protected File createTempDir(String name) throws IOException {
        File dir = new File(getTempDir(), name);
        while (dir.exists()) {
            dir = new File(getTempDir(), name + (int) (Math.random() * 9));
        }
        dir.mkdirs();
        return dir;
    }
    
    /**
     * Cleans the temporary directory.
     */
    protected final void cleanTemp() {
        try {
            File tmp = getTempDir();
            if (tmp.exists()) {
                FileUtils.cleanDirectory(tmp);
            }
        } catch (IOException e) {
            // don't care
        }
    }
    
}
