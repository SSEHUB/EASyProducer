package de.uni_hildesheim.sse.reasoning.core.frontend;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.StandaloneInitializer;
import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder.VisibilityType;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.persistency.StringProvider;
import de.uni_hildesheim.sse.reasoning.core.frontend.TestConfiguration.Capabilities;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner;
import de.uni_hildesheim.sse.reasoning.core.reasoner.Message;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Abstract reasoner test functionality.
 * 
 * @author El-Sharkawy
 * @author Eichelberger
 */
public abstract class AbstractReasonerFrontendTest {

    protected static final ReasonerFrontend FRONTEND = ReasonerFrontend.getInstance();
    private static TestConfiguration configuration = new TestConfiguration();
    private static IReasonerInitializer initializer;
    private static final String TESTDIR = "testdata";

    /**
     * Determines the actual directory with the test IVML files depending on the
     * JVM system property <tt>reasonerCore.testdata.home</tt> which may contain a specific
     * directory (or be empty -> default directory). 
     * 
     * @param path the relative path for the test file
     * 
     * @return the actual directory as file
     */
    private static File obtainTestFile(String path) {
        File result;
        String externalLocation = System.getProperty(configuration.getSystemProperty());
        if (null == externalLocation) {
            // allow current configuration to provide own test files or supersede test files
            result = composeDir(configuration.getPluginId(), "./", path);
            if (!result.exists()) {
                // fallback to ReasonerCore
                result = composeDir(TestConfiguration.PLUGIN_ID, TestConfiguration.PROJECT_NAME, path);
            }
        } else {
            result = new File(externalLocation, path);
        }
        return result;
    }
    
    /**
     * Composes the directory either from the bundle or from the given <code>basePath</code>.
     * @param bundleId the bundle identifier to be tested
     * @param basePath the base path to be used if the bundle does not exist
     * @param path the bath to be appended
     * @return the composed directory
     */
    private static File composeDir(String bundleId, String basePath, String path) {
        // requires always OSGi environment!!!
        Bundle curBundle = Platform.getBundle(bundleId);
        File result;
        if (null == curBundle) {
            result = new File(basePath + TESTDIR);
        } else {
            // adapted - to be checked
            result = new File(curBundle.getLocation().substring(bundleId.length()));
            result = new File(result, TESTDIR);
        }
        result = new File(result, path);
        return result;
    }
    
    /**
     * Initializes the tests. Requires a valid {@link IReasonerInitializer} in 
     * {@link TestConfiguration#getInitializer()}.
     * 
     * @param config the configuration to be used for this test
     * @param init the initializer to be used for this test
     */
    public static void setupTests(TestConfiguration config, IReasonerInitializer init) {
        if (null == initializer) {
            if (null == init) {
                Assert.fail("Global reasoner initializer not specified");
            }
            initializer = init;
            if (null != config) {
                configuration = config;
            }
            IReasoner reasoner = null;
            try {
                reasoner = FRONTEND.findReasoner(init.getName(), init.getVersion());
            } catch (IllegalArgumentException e) {
            }
            if (null == reasoner) {
                reasoner = init.create();
                Assert.assertNotNull("Reasoner initializer does not provide valid instance", reasoner);
                FRONTEND.getRegistry().register(reasoner);
            }
            FRONTEND.setReasonerHint(reasoner.getDescriptor());
            ModelUtility.setResourceInitializer(new StandaloneInitializer());
        }
    }

    /**
     * Load an IVML File to the test projekt.
     * 
     * @param path
     *            of the ivml file we want to use to
     * @return the projekt with the configuration
     * @throws IOException
     *             if an error occurred due reading the ivml file
     */
    protected final Project loadProject(String path) throws IOException {
        File file = obtainTestFile(path);

        // TODO move this into initalization
        try {
            VarModel.INSTANCE.locations().addLocation(file, ProgressObserver.NO_OBSERVER);
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            System.out.println(e.getMessage());
        }

        // Parse IVML File
        de.uni_hildesheim.sse.dslCore.TranslationResult<Project> result = ModelUtility.INSTANCE.parse(file);
        // test cases must be correct!
        Assert.assertTrue("Parsing error", 0 == result.getMessageCount());
        for (int i = 0; i < result.getMessageCount(); i++) {
            System.out.println("Parsing error -> " + result.getMessage(i).getDescription());
        }
        Assert.assertEquals(1, result.getResultCount());

        // Load project
        Project p = result.getResult(0);
        return p;
    }

    /**
     * Performs a check with the current reasoner on the specified project and
     * configuration.
     * 
     * @param path the relative path to the model
     * @param isValid
     *            <tt>true</tt> if project and configuration should be valid,
     *            otherwise <tt>false</tt>
     * @throws IOException in case of problems loading the model
     */
    protected void performCheck(String path, boolean isValid) throws IOException {
        Project p = loadProject(path);
        Configuration config = new Configuration(p);
        performCheck(p, config, isValid);
    }
    
    /**
     * Performs a check with the current reasoner on the specified project and
     * configuration.
     * 
     * @param project
     *            The underlying variability project.
     * @param config
     *            A Configuration with is build based on the given project.
     * @param isValid
     *            <tt>true</tt> if project and configuration should be valid,
     *            otherwise <tt>false</tt>
     */
    protected void performCheck(Project project, Configuration config, boolean isValid) {
        Assert.assertSame("Configuration doesn't belong to the given project", project, config.getProject());

        long startTime = System.currentTimeMillis();
        ReasoningResult result = FRONTEND.check(project, config, new ReasonerConfiguration(),
            ProgressObserver.NO_OBSERVER);
        long endTime = System.currentTimeMillis();

        String errorMsg = "";
        System.out.println("Result -> " + result.hasConflict());
        if (configuration.isSupported(Capabilities.CHECK)) {
            if (result.hasConflict()) {
                errorMsg = resultErrorToFailureTrace(result, project);
            }
            Assert.assertEquals(errorMsg, !isValid, result.hasConflict());
        } else {
            Message warning = result.getMessage(0);
            Assert.assertEquals(Status.UNSUPPORTED, warning.getStatus());
        }

        System.out.println("\nReasoner took " + (endTime - startTime) + "ms");
    }

    /**
     * Configures a specified value.
     * 
     * @param project the project to configure on
     * @param config the configuration to modify
     * @param index the index of the element
     * @param value the related value(s)
     * @throws ConfigurationException in case that the configuration cannot be applied
     * @throws ValueDoesNotMatchTypeException in case that the value does not match the type of the variable
     * @deprecated Please use {@link #configureValue(Configuration, String, String, String...)}
     *             instead.
     */
    protected void configureValue(Project project, Configuration config, int index, String... value)
        throws ConfigurationException, ValueDoesNotMatchTypeException {

        DecisionVariableDeclaration decl = (DecisionVariableDeclaration) project.getElement(index);
        Value val = ValueFactory.createValue(decl.getType(), (Object[]) value);
        config.getDecision(decl).setValue(val, AssignmentState.ASSIGNED);
    }

    /**
     * Created a value and configures a variable inside the configuration with
     * the created value.
     * 
     * @param config
     *            The configuration containing the variable to be configured
     *            (Must not be <tt>null</tt>).
     * @param declName
     *            The name of the variable to be configured (Must not be
     *            <tt>null</tt>).
     * @param namespace
     *            The namespace of the variable. Can be used if more than one
     *            variable with the same name exist. If <tt>null</tt> the first
     *            variable with the specified name will be configured.
     * @param value
     *            The new value to be set.
     * @throws ConfigurationException
     *             Must not occur, otherwise there is an error inside the
     *             Configuration
     * @throws ValueDoesNotMatchTypeException
     *             Occurs if the value does not match to the datatype of the
     *             configured variable
     */
    protected void configureValue(Configuration config, String declName, String namespace, String... value)
        throws ConfigurationException, ValueDoesNotMatchTypeException {

        Project project = config.getProject();
        DeclarationFinder finder = new DeclarationFinder(project, FilterType.ALL, null);
        List<AbstractVariable> declarations = finder.getVariableDeclarations(VisibilityType.ALL);
        AbstractVariable decl = null;
        for (int i = 0; null == decl && i < declarations.size(); i++) {
            AbstractVariable tmp = declarations.get(i);
            if (tmp.getName().equals(declName)) {
                if (null == namespace ^ namespace.equals(tmp.getNameSpace())) {
                    decl = tmp;
                }
            }
        }
        if (null != decl) {
            Value val = ValueFactory.createValue(decl.getType(), (Object[]) value);
            config.getDecision(decl).setValue(val, AssignmentState.ASSIGNED);
        }
    }

    /**
     * Turns a reasoner result into a failure trace if necessary.
     * 
     * @param result the reasoning result
     * @param project the project used for reasoning
     * @return the failure trace
     */
    protected String resultErrorToFailureTrace(ReasoningResult result, Project project) {
        int index = -1;
        for (int i = 0; i < project.getElementCount() && -1 == index; i++) {
            if (project.getElement(i) == result.getMessage(0).getConflicts().get(0)) {
                index = i;
            }
        }

        ModelElement conflict = result.getMessage(0).getConflicts().get(0);
        String strConflict = StringProvider.toIvmlString(conflict);
        return result.getMessage(0).getDescription() + "\n" + strConflict + "\nConflict @ Element " + index;
    }

}
