package test.de.uni_hildesheim.sse.vil.buildlang;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.URI;
import org.junit.Assert;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.VilExpressionParser;
import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.translation.Message;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.BuiltIn;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.PathUtils;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.Executor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.TracerFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionParserRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Project;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.velocity.VelocityInstantiator;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;

/**
 * The refined version of abstract tests for the build language.
 * 
 * @param <M> the actual model type
 * @author Holger Eichelberger
 */
public abstract class AbstractTest<M extends Script> extends de.uni_hildesheim.sse.dslCore.test.AbstractTest<M> {

    private ITestConfigurer<M> configurer = createTestConfigurer();
    
    /**
     * Creates and initializes an abstract test.
     */
    protected AbstractTest() {
        resourceInitialization();
        BuiltIn.initialize();
        furtherInitialization();
        registerTypeAnyway(TouchInstantiator.class);
        registerTypeAnyway(StringCreator.class);
        registerTypeAnyway(VelocityInstantiator.class);
        ExpressionParserRegistry.setExpressionParser(BuildlangExecution.LANGUAGE, new VilExpressionParser());
        configurer.furtherInitialization();
        try {
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, OBSERVER);
            configurer.getModelManagement().loaders().registerLoader(configurer.getModelLoader(), OBSERVER);
        } catch (ModelManagementException e) {
            e.printStackTrace(System.err);
            Assert.assertTrue(false); // shall not happen
        }
        test.de.uni_hildesheim.sse.vil.templatelang.AbstractTest.initializeInfrastructure();
        addTestDataLocations();
        configurer.addTestDataLocations(getTestDataDir());
        //cleanTemp();
    }

    /**
     * Adds the test data locations. Override to avoid.
     */
    protected void addTestDataLocations() {
        try {
            VarModel.INSTANCE.locations().addLocation(getTestDataDir(), OBSERVER);
            configurer.getModelManagement().locations().addLocation(getTestDataDir(), OBSERVER);
        } catch (ModelManagementException e) {
            e.printStackTrace(System.err);
            Assert.assertTrue(false); // shall not happen
        }
        test.de.uni_hildesheim.sse.vil.templatelang.AbstractTest.initializeLocations(getTestDataDir());
    }

    /**
     * Performs further initialization.
     */
    protected void furtherInitialization() {
    }
    
    /**
     * Creates the test configurer.
     * 
     * @return the test configurer
     */
    protected abstract ITestConfigurer<M> createTestConfigurer();

    /**
     * Returns the system property determining the directory containing the actual test data.
     * 
     * @return the name of the system property
     */
    protected final String getSystemPropertyName() {
        return configurer.getSystemPropertyName();
    }
    
    /**
     * Returns the configurer.
     * 
     * @return the configurer
     */
    protected ITestConfigurer<M> getTestConfigurer() {
        return configurer;
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
     * @param name the name of the file (excluding the respective file extension 
     *     {@link ITestConfigurer#getFileExtension()})
     * @return the file
     */
    protected File createFile(String name) {
        return new File(getTestFolder(), name + "." + configurer.getFileExtension());
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
     * Called to clean up artifacts between two subsequent executions.
     * 
     * @author Holger Eichelberger
     */
    protected interface Cleaner {

        /**
         * Now clean up.
         */
        public void deleteBetween();
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
    protected void assertEqual(EqualitySetup data, int... expectedErrorCodes) throws IOException {
        assertEqual(data, null, expectedErrorCodes);
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
     * @param cleaner an optional cleaner instance
     * @param expectedErrorCodes the expected and allowed error codes (errors occurring
     *   multiple times need to be listed multiple times here)
     * @throws IOException problems finding or reading the model file
     */
    protected void assertEqual(EqualitySetup data, Cleaner cleaner, int... expectedErrorCodes) throws IOException {
        File file = data.getFile();
        if (file.exists()) {
            URI uri = URI.createFileURI(file.getAbsolutePath());
            TranslationResult<M> result = configurer.parse(uri); // parse the model
            List<Message> messages = result.getMessageListSpecific();
            Assert.assertTrue("no result produced: " + toString(messages), result.getResultCount() > 0);
            if (0 == result.getErrorCount()) {
                String fileAsString = file2String(file); // read model file into memory
                Assert.assertTrue("not found: " + file, null != fileAsString);
                java.io.CharArrayWriter expected = new CharArrayWriter(); // read model into String
                configurer.print(result, expected, false, false);
                if (data.enableEquals()) {
                    String errorMsg = checkEqualsAndPrepareMessage(fileAsString, expected);
                    if (null != errorMsg) {
                        Assert.assertEquals(fileAsString.trim(), expected.toString().trim());
                        Assert.fail(errorMsg);
                    }
                    assertNamingAndVersion(data, result);
                }
            }
            Assert.assertTrue("currently multiple scripts are not handled", 1 == result.getResultCount());
            File expectedTrace = data.getExpectedTrace();
            if (null != expectedTrace && 0 == result.getErrorCount()) {
                Writer trace = new CharArrayWriter();
                try { // for debugging insert DelegatingSysoutWriter here
                    String fileAsString = file2String(expectedTrace);
                    Assert.assertTrue(null != fileAsString);
                    Script script = result.getResult(0);
                    TracerFactory oldFactory = TracerFactory.getInstance();
                    TracerFactory.setInstance(configurer.createTestTracerFactory(trace, getBaseFolders(data)));
                    BuildlangExecution exec = configurer.createExecutionEnvironment(
                        TracerFactory.createBuildLanguageTracer(), getTestDataDir(), data.getStartElement(), 
                        data.getParameter());
                    script.accept(exec);
                    exec.release(true);
                    TracerFactory.setInstance(oldFactory);
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
                    if (null != errorMsg) {
                        Assert.assertEquals(fileAsString.trim(), trace.toString().trim());
                        Assert.fail(errorMsg);
                    }
                    if (null != cleaner) {
                        cleaner.deleteBetween();
                    }
                    testExecutor(result.getResult(0), data); // do the same via the executor
                } catch (VilException e) {
                    //e.printStackTrace(System.out); // for debugging
                    if (null == messages) {
                        messages = new ArrayList<Message>();
                    }
                    messages.add(new Message(e.getMessage(), Status.ERROR, null, null, e.getId()));
                }
            }
            String errorCodes = checkErrorCodes(messages, null, expectedErrorCodes);
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
     * @throws VilException in case that the execution fails (shall not happen but one never knows
     *     whether VIL fails runing the same script twice)
     */
    protected void testExecutor(Script script, EqualitySetup data) throws VilException {
        // this may not do the same as the execution before - this would be a second instantiation
        Map<String, Object> args = data.getParameter();
        // several test cases do not have all default parameters!
        reInitProject(args, Executor.PARAM_SOURCE);
        reInitProject(args, Executor.PARAM_TARGET);
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
     * Re-initializes the project arguments if given so that the test can rely on a fresh artifact model, in particular
     * if a previous run on the same arguments released the project before.
     * 
     * @param args the argument for execution
     * @param key the key to be re-initialized 
     * @throws VilException in case that creating a project instance fails
     */
    private void reInitProject(Map<String, Object> args, String key) throws VilException {
        Object arg = args.get(key);
        if (arg instanceof Project) {
            args.put(key, new Project((Project) arg, OBSERVER));
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
