/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.reasoning.core.reasoner;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.Arrays;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import de.uni_hildesheim.sse.ModelUtility;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.StandaloneInitializer;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.dslCore.translation.Message;
import net.ssehub.easy.reasoning.core.frontend.IReasonerInstance;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.cstEvaluation.IConstraintEvaluator;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder.VisibilityType;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.varModel.testSupport.MeasurementCollector;
import net.ssehub.easy.varModel.varModel.testSupport.TSVMeasurementCollector;

/**
 * General abstract test class for reusable reasoning tests.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 * @author Eichelberger
 */
public abstract class AbstractTest extends net.ssehub.easy.dslCore.test.AbstractTest<Project> {

    public static final String DEFAULT_TAG = "REASONING";

    /**
     * The system property key for the number number of full reasoning executions {@value}}.
     */
    public static final String KEY_NUM_RUNS_REASONING_FULL = "easy.test.runs.reasoning.full";

    /**
     * The system property key for the number number of incremental reasoning executions {@value}}.
     */
    public static final String KEY_NUM_RUNS_REASONING_INCREMENTAL = "easy.test.runs.reasoning.incremental";

    /**
     * The system property key for the number number of full instance executions {@value}}.
     */
    public static final String KEY_NUM_RUNS_REASONING_INSTANCE = "easy.test.runs.reasoning.instance";
    
    /**
     * The system property key for the reasoning timeout {@value}}.
     */
    public static final String KEY_TIMEOUT_REASONING = "easy.test.timeout.reasoning.reasoning";

    /**
     * The number of full reasoning executions based on {@link #KEY_NUM_RUNS_REASONING_FULL}. At least 1.
     * @see #performReasoning(IReasoner, Project, Configuration, ReasonerConfiguration)
     */
    public static final int NUM_FULL_REASONING
        = MeasurementCollector.getIntProperty(KEY_NUM_RUNS_REASONING_FULL, 1, 1);

    /**
     * The number of incremental reasoning executions based on {@link #KEY_NUM_RUNS_REASONING_INCREMENTAL}. At least 0, 
     * i.e., can be switched off.
     */
    public static final int NUM_INCREMENTAL_REASONING 
        = MeasurementCollector.getIntProperty(KEY_NUM_RUNS_REASONING_INCREMENTAL, 1, 0);

    /**
     * The number of instance reasoning executions based on {@link #KEY_NUM_RUNS_REASONING_INSTANCE}. At least 0, 
     * i.e., can be switched off.
     */
    public static final int NUM_INSTANCE_REASONING 
        = MeasurementCollector.getIntProperty(KEY_NUM_RUNS_REASONING_INSTANCE, 2, 0);

    /**
     * The reasoning timeout {@link #KEY_TIMEOUT_REASONING}. No timeout if 0. 
     */
    public static final int TIMEOUT_REASONING
        = MeasurementCollector.getIntProperty(KEY_TIMEOUT_REASONING, 5000, 0);
    
    // just for debugging
    public static final boolean PRINT_REASONER_MESSAGES = false;
    
    private ITestDescriptor descriptor;
    private String testPath;
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     * @param testPath the test path (empty or <b>null</b> means do not try to load models)
     */
    protected AbstractTest(ITestDescriptor descriptor, String testPath) {
        this.descriptor = descriptor;
        this.testPath = testPath;
    }
    
    /**
     * Returns the testdata folder.
     * 
     * @return the testdata folder
     */
    public File getTestdataBase() {
        return determineTestDataFolder(descriptor.getSystemProperty());
    }
    
    /**
     * Creates a reasoner instance through {@link #descriptor}.
     * 
     * @return the reasoner instance
     */
    protected IReasoner createReasoner() {
        return descriptor.createReasoner();
    }
    
    /**
     * Returns the path after testdata folder where the test files are located.
     * 
     * @return the path
     */
    protected String getTestPath() {
        return testPath;
    }
    
    /**
     * Changes the test path.
     * 
     * @param testPath the new test path
     */
    protected void setTestPath(String testPath) {
        removeLocation();
        this.testPath = testPath;
        addLocation();
    }

    /**
     * Returns the complete testdata folder.
     * 
     * @return the path
     */
    protected File getTestdata() {
        return new File(getTestdataBase(), getTestPath());
    }

    /**
     * Method for handling reasoning result, actually performing a propagation by default (due to legacy reasons).
     * 
     * @param expectedFailedConstraints Number of constraints that are expected to fail
     * @param expectedReevaluationCount expected number of constraint re-evaluations (ignored if negative)
     * @param projectP1 Project to reason on.
     * @return configuration (for further specific tests)
     */
    protected final Configuration resultHandler(int expectedFailedConstraints, int expectedReevaluationCount, 
        Project projectP1) {
        return assertPropagation(expectedFailedConstraints, expectedReevaluationCount, projectP1); // legacy
    }

    /**
     * Method for asserting a propagation.
     * 
     * @param expectedFailedConstraints Number of constraints that are expected to fail
     * @param expectedReevaluationCount expected number of constraint re-evaluations (ignored if negative)
     * @param projectP1 Project to reason on.
     * @return configuration (for further specific tests)
     * 
     * @see #debugConfigBeforeResultHandler(Configuration)
     */
    protected final Configuration assertPropagation(int expectedFailedConstraints, int expectedReevaluationCount, 
        Project projectP1) {
        Configuration config = new Configuration(projectP1, false);
        return assertPropagation(expectedFailedConstraints, expectedReevaluationCount, config);
    }

    /**
     * Method for asserting a propagation.
     * 
     * @param expectedFailedConstraints Number of constraints that are expected to fail
     * @param expectedReevaluationCount expected number of constraint re-evaluations (ignored if negative)
     * @param config the configuration to reason on.
     * @return <code>config</code> (for further specific tests)
     * 
     * @see #debugConfigBeforeResultHandler(Configuration)
     */
    protected final Configuration assertPropagation(int expectedFailedConstraints, int expectedReevaluationCount, 
        Configuration config) {
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        configureReasoner(rConfig);
        // Perform reasoning
        IReasoner reasoner = createReasoner();
        reasoner.setInterceptor(new ReasonerInterceptorAdaptor() {
            
            @Override
            public void notifyEvaluation(Constraint constraint, IConstraintEvaluator evaluator) {
                if (evaluator.getMessageCount() > 0) {
                    String msg = "";
                    for (int m = 0; m < evaluator.getMessageCount(); m++) {
                        net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor.Message mg = evaluator.getMessage(m);
                        if (Status.ERROR == mg.getStatus() && isErrorCode(mg)) { 
                            if (msg.length() > 0) {
                                msg += ", ";
                            }
                            msg += mg.getDescription() + " code: " + mg.getCode();
                            if (mg.getVariable() != null) {
                                msg += " variable: " + mg.getVariable();
                            }
                        }
                    }
                    if (msg.length() > 0) {
                        Assert.fail("Reasoning problems occurred: " + msg);
                    }
                }
            }
            
        });
        ReasoningResult rResult = performReasoning(reasoner, config.getProject(), config, rConfig);
        debugConfigBeforeResultHandler(config);
        resultHandler(expectedFailedConstraints, expectedReevaluationCount, rResult);
        return config;
    }
    
    /**
     * Returns whether the error code of <code>msg</code> is relevant.
     * 
     * @param msg the message
     * @return <code>true</code> for relevant, <code>false</code> else
     */
    private boolean isErrorCode(net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor.Message msg) {
        int code = msg.getCode();
        // no assng state/index as anyway check for error!
        return !(net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor.Message.CODE_ASSIGNMENT_STATE == code 
            || net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor.Message.CODE_INDEX == code);
    }

    /**
     * Performs reasoning using {@link ITestDescriptor#createReasoner() the reasoner provided by 
     * the test descriptor} and collects the result in {@link MeasurementCollector}.
     * 
     * @param project the project
     * @param config the configuration
     * @param rConfig the reasoner configuration
     * @return the reasoning result
     */
    protected ReasoningResult performReasoning(Project project, Configuration config, 
        ReasonerConfiguration rConfig) {
        return performReasoning(descriptor.createReasoner(), project, config, rConfig);
    }

    /**
     * Performs reasoning using {@link ITestDescriptor#createReasoner() the reasoner provided by 
     * the test descriptor} and collects the result in {@link MeasurementCollector}.
     * 
     * @param project the project
     * @param config the configuration
     * @param rConfig the reasoner configuration
     * @param tag explicit tag for measurement recording (may be <b>null</b>)
     * @return the reasoning result
     */
    protected ReasoningResult performReasoning(Project project, Configuration config, 
        ReasonerConfiguration rConfig, String tag) {
        return performReasoning(descriptor.createReasoner(), project, config, rConfig, tag);
    }

    /**
     * Performs reasoning and collects the result in {@link MeasurementCollector} using {@link #DEFAULT_TAG}.
     * 
     * @param reasoner the reasoner to use
     * @param project the project
     * @param config the configuration
     * @param rConfig the reasoner configuration
     * @return the reasoning result
     */
    protected ReasoningResult performReasoning(IReasoner reasoner, Project project, Configuration config, 
        ReasonerConfiguration rConfig) {
        return performReasoning(reasoner, project, config, rConfig, DEFAULT_TAG);
    }

    /**
     * Performs reasoning and collects the result in {@link MeasurementCollector}.
     * Repeats the reasoning {@link #NUM_FULL_REASONING} times.
     * 
     * @param reasoner the reasoner to use
     * @param project the project
     * @param config the configuration
     * @param rConfig the reasoner configuration
     * @param tag explicit tag for measurement recording (may be <b>null</b>)
     * @return the (first) reasoning result
     */
    protected ReasoningResult performReasoning(IReasoner reasoner, Project project, Configuration config, 
        ReasonerConfiguration rConfig, String tag) {
        ensureCollector();
        ReasoningResult result = null;
        for (int r = 1, n = NUM_FULL_REASONING; r <= n; r++) {
            String id = MeasurementCollector.start(config, tag, r);
            ReasoningResult res =  reasoner.propagate(project, config, rConfig, ProgressObserver.NO_OBSERVER);
            MeasurementCollector.endAuto(id);
            transferReasoningMeasures(id, res);
            MeasurementCollector.end(id);
            res.logInformation(project, rConfig, PRINT_REASONER_MESSAGES);
            if (n > 1) {
                // we want to cause multiple reasoner calls, not re-reasoning on the same configuration here
                config = new Configuration(project, false); 
            }
            result = null == result ? res : result;
        }
        return result;
    }

    /**
     * Performs reasoning on a reasoner instance of {@link ITestDescriptor#createReasoner() the reasoner provided by 
     * the test descriptor} and collects the result in {@link MeasurementCollector}.
     * 
     * @param project the project
     * @param config the configuration
     * @param rConfig the reasoner configuration
     * @return the reasoning result
     */
    protected ReasoningResult performInstanceReasoning(Project project, Configuration config, 
        ReasonerConfiguration rConfig) {
        return performInstanceReasoning(descriptor.createReasoner(), project, config, rConfig);
    }

    /**
     * Performs reasoning on a reasoner instance of the given <code>reasoner</code> and collects the result 
     * in {@link MeasurementCollector}.
     * 
     * @param reasoner the reasoner to create the instance for
     * @param project the project
     * @param config the configuration
     * @param rConfig the reasoner configuration
     * @return the reasoning result
     */
    protected ReasoningResult performInstanceReasoning(IReasoner reasoner, Project project, Configuration config, 
        ReasonerConfiguration rConfig) {
        long start = System.currentTimeMillis();
        IReasonerInstance inst = reasoner.createInstance(project, config, rConfig);
        return performInstanceReasoning(inst, config, System.currentTimeMillis() - start);
    }

    /**
     * Performs reasoning on a reasoner instance and collects the result in {@link MeasurementCollector}.
     * Repeats the reasoning {@link #NUM_INSTANCE_REASONING} times.
     * 
     * @param inst the reasoner instance to use
     * @param config the configuration
     * @param instanceCreationTime time taken for creating the reasoning instance (in ms, may be negative for none)
     * @return the (first) reasoning result
     */
    protected ReasoningResult performInstanceReasoning(IReasonerInstance inst, Configuration config, 
        long instanceCreationTime) {
        ensureCollector();
        ReasoningResult result = null;
        for (int r = 1; r <= NUM_INSTANCE_REASONING; r++) {
            String id = MeasurementCollector.start(config, "IREASONING ", r);
            ReasoningResult res = inst.propagate(ProgressObserver.NO_OBSERVER);
            MeasurementCollector.endAuto(id);
            transferReasoningMeasures(id, res);
            MeasurementCollector.set(id, AbstractTestDescriptor.MeasurementIdentifier.REASONER_INSTANCE_CREATION_TIME, 
                instanceCreationTime);
            MeasurementCollector.end(id);
            res.logInformation(inst.getProject(), inst.getReasonerConfiguration(), PRINT_REASONER_MESSAGES);
            result = null == result ? res : result;
        }
        return result;
    }

    /**
     * Ensures the measurement collector.
     */
    protected void ensureCollector() {
        TSVMeasurementCollector.ensureCollector(new File(getTestdataBase(), 
            "temp/" + descriptor.getMeasurementFileName()));
    }

    /**
     * Transfers the reasoning measures from the given reasoning <code>result</code> to the collector <code>coll</code>.
     * 
     * @param id the measurement identifier
     * @param result the reasoning result to take the values from
     */
    protected void transferReasoningMeasures(String id, ReasoningResult result) {
        transferReasoningMeasures(MeasurementCollector.getInstance(), id, result);
    }

    /**
     * Transfers the reasoning measures from the given reasoning <code>result</code> to the collector <code>coll</code>.
     * 
     * @param coll the collector to receive the measurements
     * @param id the measurement identifier
     * @param result the reasoning result to take the values from
     */
    protected void transferReasoningMeasures(MeasurementCollector coll, String id, ReasoningResult result) {
        transferReasoningMeasures(coll, id, descriptor.measurements(), result);
    }
    
    /**
     * Transfers the reasoning measures from the given reasoning <code>result</code> to the collector <code>coll</code>.
     * 
     * @param coll the collector to receive the measurements
     * @param id the measurement identifier
     * @param keys the measurement keys to collect
     * @param result the reasoning result to take the values from
     */
    public static void transferReasoningMeasures(MeasurementCollector coll, String id, IMeasurementKey[] keys, 
        ReasoningResult result) {
        for (int k = 0; k < keys.length; k++) {
            Number measure = result.getMeasure(keys[k]);
            if (null != measure) {
                coll.setMeasurement(id, keys[k], measure.doubleValue());
            }
        }
        // auto columns in TSV
        MeasurementCollector.set(id, AbstractTestDescriptor.MeasurementIdentifier.REASONER_INSTANCE_CREATION_TIME, 0);
    }
    
    /**
     * Allows to configure the reasoner configuration.
     * 
     * @param rConfig the configuration to change if needed
     */
    protected void configureReasoner(ReasonerConfiguration rConfig) {
    }
    
    /**
     * Called to enable debugging the configuration after reasoning but before asserting.
     * 
     * @param cfg the configuration to debug
     */
    protected void debugConfigBeforeResultHandler(Configuration cfg) {
    }
    
    /**
     * Method for handling a reasoning result.
     * @param expectedFailedConstraints Number of constraints that are expected to fail
     * @param expectedReevaluationCount expected number of constraint re-evaluations (ignored if negative)
     * @param result the reasoning result
     */
    protected static final void resultHandler(int expectedFailedConstraints, int expectedReevaluationCount, 
        ReasoningResult result) {
        // Test whether reasoning detected correct result  
        int failedConstraints = 0;
        for (int i = 0; i < result.getMessageCount(); i++) {
            if (result.getMessage(i).getStatus() == Status.ERROR) {
                failedConstraints = failedConstraints + result.getMessage(i).getConflicts().size();
            }
        }
        Assert.assertEquals("Failed constraints: ", expectedFailedConstraints, failedConstraints);

        if (expectedReevaluationCount > 0) {
            Number measure = result.getMeasure(GeneralMeasures.REEVALUATION_COUNT);
            if (null == measure) {
                Assert.fail("Reasoner does not provide measure " + GeneralMeasures.REEVALUATION_COUNT);
            } else {
                // Test whether reasoning is done in correct reevalustion steps  
                Assert.assertTrue("Reevaluation count mismatch. Result: " + measure.intValue()
                    + " Expected: " + expectedReevaluationCount, measure.intValue() == expectedReevaluationCount);
            }
        }
    }
    
    /**
     * Helper method for load an IVML file.
     * @param testFolder The (sub-) folder where to load the specified IVML test files.
     * @param path The name of the IVML file to load (optional including the file extension) inside of the
     *     <tt>reasonerModel</tt> folder.
     * @return The loaded {@link Project} representing the read IVML file.
     */
    protected final Project loadProject(File testFolder, String path) {
        Project project = null;
        try {
            File projectFile = new File(testFolder, path.endsWith(".ivml") ? path : path + ".ivml");
            URI uri = URI.createFileURI(projectFile.getAbsolutePath());
            TranslationResult<Project> result = ModelUtility.INSTANCE.parse(uri);
            StringBuffer errorMsg = new StringBuffer();
            for (int i = 0; i < result.getMessageCount(); i++) {
                Message msg = result.getMessage(i);
                if (!msg.ignore() && Status.ERROR == msg.getStatus()) {
                    errorMsg.append(msg.getDescription());
                    errorMsg.append("\n");
                }
            }
            if (errorMsg.length() == 0) {
                project = result.getResult(0);
            } else {
                Assert.fail(errorMsg.toString());
            }
            Assert.assertNotNull("Error: The loaded project " + path + " is NULL (should not happen)", project);
            VarModel.INSTANCE.updateModel(project, projectFile.toURI());
        } catch (IOException exc) {
            Assert.fail(exc.getLocalizedMessage());
        }
        return project;
    }

    /**
     * Load an IVML File as project with dependencies assuming version "0".
     * 
     * @param projectName The name of the project to load.
     * @return the specified and parsed project 
     * @throws IOException
     *     if an error occurred while reading the IVML file
     */
    protected final Project loadCompleteProject(String projectName) throws IOException {
        return loadCompleteProject("", projectName);
    }
    
    /**
     * Load an IVML File as project with dependencies assuming version "0". Call 
     * {@link #resultHandler(int, int, Project)} afterwards.
     * 
     * @param folderName The folder the test project(s) relative to {@link #getTestdataBase()}
     * @param projectName The name of the project to load.
     * @return the specified and parsed project 
     * @throws IOException
     *     if an error occurred while reading the IVML file
     */
    protected final Project loadCompleteProject(String folderName, String projectName) throws IOException {
        // Register folder for parsing files
        File folder = getTestdataBase();
        if (null != getTestPath()) {
            folder = getTestdata();
        }
        folder = new File(folder, folderName);
        try {
            VarModel.INSTANCE.locations().addLocation(folder, ProgressObserver.NO_OBSERVER);
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            System.out.println(e.getMessage());
        }
        
        List<ModelInfo<Project>> infos = VarModel.INSTANCE.availableModels().getModelInfo(projectName, new Version(0));
        Assert.assertNotNull("No models found at \"" + folder.getAbsolutePath() + "\"", infos);
        Assert.assertEquals(infos.size() + " models found at \"" + folder.getAbsolutePath() + "\" but should be 1.",
            1, infos.size());
        
        // Parse IVML File
        Project project = null;
        try {
            project = VarModel.INSTANCE.load(infos.get(0));
        } catch (ModelManagementException e) {
            e.printStackTrace();
            Assert.fail("Could not load model \"" + projectName + "\", reason: " + e.getMessage());
        }
        
        Assert.assertNotNull("Loaded project is null, probably due parsing errors: \"" + projectName + "\"", project);

        try {
            VarModel.INSTANCE.locations().removeLocation(folder, ProgressObserver.NO_OBSERVER);
            VarModel.INSTANCE.loaders().unregisterLoader(ModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            System.out.println(e.getMessage());
        }

        return project;
    }
    
    /**
     * Helper method for load an IVML file.
     * @param path The name of the IVML file to load (optional including the file extension) inside of the
     *     <tt>reasonerModel</tt> folder.
     * @return The loaded {@link Project} representing the read IVML file.
     */
    protected Project loadProject(String path) {
        return loadProject(getTestdata(), path);
    }
    
    /**
     * Initializes this Test class.
     */
    @Before
    public void setUpBeforeClass() {
        startup();
    }
    
    /**
     * Frees the memory after testing.
     */
    @After
    public void tearDownAfterClass() {
        shutdown();
    }
    
    /**
     * Initializes this Test class.
     */
    public void startup() {
        descriptor.registerResoner();
        ModelUtility.setResourceInitializer(new StandaloneInitializer());
        addLocation();
    }
    
    /**
     * Frees the memory after testing.
     */
    protected void shutdown() {
        descriptor.unregisterReasoner();
        removeLocation();
    }

    /**
     * Adds {@link #testPath} as IVML location.
     */
    private void addLocation() {
        if (null != testPath && testPath.length() > 0) {
            try {
                VarModel.INSTANCE.locations().addLocation(getTestdata(), ProgressObserver.NO_OBSERVER);
            } catch (ModelManagementException e) {
                Assert.fail("Could not add location of test files.");
            }
        }
        
    }

    /**
     * Removes {@link #testPath} as IVML location.
     */
    private void removeLocation() {
        if (null != testPath && testPath.length() > 0) {
            try {
                VarModel.INSTANCE.locations().removeLocation(getTestdata(), ProgressObserver.NO_OBSERVER);
            } catch (ModelManagementException e) {
                Assert.fail("Could not remove location of test files.");
            }
        }
    }
    
    /**
     * Method to test whether different types of variables and constraints could be translated correctly
     * into rules and reasoned on without any errors. 
     * @param ivmlFile IVML file to translate and reason on.
     * @param expectedFailedConstraints Number of constraints that are expected to fail.
     * @param expectedReevaluationCount expected number of constraint re-evaluations (ignored if negative)
     * @return configuration (for further specific tests)
     */        
    public Configuration reasoningTest(String ivmlFile, int expectedFailedConstraints, int expectedReevaluationCount) {
        Project project = loadProject(ivmlFile);
        return resultHandler(expectedFailedConstraints, expectedReevaluationCount, project);
    }   
    
    /**
     * Method to test whether different types of variables and constraints could be translated correctly
     * into rules and reasoned on without any errors. 
     * @param ivmlFile IVML file to translate and reason on.
     * @param expectedFailedConstraints Number of constraints that are expected to fail.
     * @return configuration (for further specific tests)
     */        
    public Configuration reasoningTest(String ivmlFile, int expectedFailedConstraints) {
        return reasoningTest(ivmlFile, expectedFailedConstraints, -1);
    }

    /**
     * Method to test whether different types of variables and constraints could be translated correctly
     * into rules and reasoned on without any errors. 
     * @param p0 IVML file to translate and reason on.
     * @param p1 IVML file to translate and reason on.
     * @param expectedFailedConstraints Number of constraints that are expected to fail.
     * @return configuration (for further specific tests)
     */        
    protected Configuration reasoningTest(String p0, String p1, int expectedFailedConstraints) {
        Project projectP0 = loadProject(p0);
        Project projectP1 = loadProject(p1);
        ProjectImport importP0 = new ProjectImport(projectP0.getName(), null);
        projectP1.addImport(importP0);
        return resultHandler(expectedFailedConstraints, -1, projectP1);
    }
    
    /**
     * Method to test whether different types of variables and constraints could be translated correctly
     * into rules and reasoned on without any errors. 
     * @param p0 IVML file to translate and reason on.
     * @param p1 IVML file to translate and reason on.
     * @param p2 IVML file to translate and reason on.
     * @param expectedFailedConstraints Number of constraints that are expected to fail.
     * @return configuration (for further specific tests)
     */        
    protected Configuration reasoningTest(String p0, String p1, String p2, int expectedFailedConstraints) {
        Project projectP0 = loadProject(p0);
        Project projectP1 = loadProject(p1);
        Project projectP2 = loadProject(p2);
        ProjectImport importP0 = new ProjectImport(projectP0.getName(), null);
        projectP1.addImport(importP0);
        ProjectImport importP1 = new ProjectImport(projectP1.getName(), null);
        projectP2.addImport(importP1);
        return resultHandler(expectedFailedConstraints, -1, projectP2);
    }
    
    /**
     * Method for determining folder with IVML files.
     * @param property property
     * @return folder location
     */
    public static File determineTestDataFolder(String property) {
        File testdataFolder = determineTestDataDir(property);
        String externalLocation = System.getProperty(property);
        // If no property was defined, use ReasonerCore.test/testdata directory
        if (null == externalLocation) {
            // Work around over the path avoids a NullPointer exception
            String path = testdataFolder.getAbsolutePath();
            testdataFolder = new File(path);
            testdataFolder = testdataFolder.getParentFile().getParentFile();
            testdataFolder = new File(testdataFolder, "ReasonerCore.test");
            testdataFolder = new File(testdataFolder, "testdata");
        }
        if (!testdataFolder.exists()) {
            String path = testdataFolder.getAbsolutePath();
            testdataFolder = new File(path);
            testdataFolder = testdataFolder.getParentFile().getParentFile().getParentFile();
            testdataFolder = new File(testdataFolder, "ReasonerCore");
            testdataFolder = new File(testdataFolder, "ReasonerCore.test");
            testdataFolder = new File(testdataFolder, "testdata");
        }
        return testdataFolder;    
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
     * Asserts that <code>actual</code> is in <code>expected</code>.
     * 
     * @param actual the actual value
     * @param expected the expected/allowed values
     */
    protected void assertContained(Object actual, Object... expected) {
        Assert.assertTrue(null, Arrays.contains(expected, actual));
    }

    /**
     * Asserts that <code>actual</code> is in <code>expected</code>.
     * 
     * @param message emitted in case of failing
     * @param actual the actual value
     * @param expected the expected/allowed values
     */
    protected void assertContained(String message, Object actual, Object... expected) {
        Assert.assertTrue(message, Arrays.contains(expected, actual));
    }

    /**
     * Configures the reasoning timeout in {@code rCfg} based on {@link #TIMEOUT_REASONING}.
     * 
     * @param rCfg the configuration to be modified
     */
    public static void setReasoningTimeout(ReasonerConfiguration rCfg) {
        if (TIMEOUT_REASONING > 0) {
            rCfg.setTimeout(TIMEOUT_REASONING);
        }
    }
    
}
