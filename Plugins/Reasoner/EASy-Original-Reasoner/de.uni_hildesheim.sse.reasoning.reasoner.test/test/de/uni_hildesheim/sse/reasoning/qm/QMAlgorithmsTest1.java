package de.uni_hildesheim.sse.reasoning.qm;


import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.StandaloneInitializer;
import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.test.AbstractTest;
import de.uni_hildesheim.sse.dslCore.translation.Message;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.reasoning.reasoner.Descriptor;
import de.uni_hildesheim.sse.reasoning.reasoner.Engine;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Hardware constraint: algNamesUnique = algorithms->collect(a|a.name).size() == algorithms.size() test.
 * 
 * @author Sizonenko
 */
public class QMAlgorithmsTest1 extends AbstractTest<Project> {

    private static final EASyLogger LOGGER =
            EASyLoggerFactory.INSTANCE.getLogger(QMAlgorithmsTest1.class, Descriptor.BUNDLE_NAME);
    
    private static final File TESTDATA = determineTestDataFolder("reasonerCore.testdata.home");
    private static final File FOLDER = new File(TESTDATA, "qmAlgorithmsTest1");
    
    private Project basic;
    private Project observables;
    private Project hardware;
    private Project hardwareCfg;
    private Project adaptivity;
    private Project adaptivityCfg;
    private Project observablesCfg;
    private Project dataManagement;
    private Project dataManagementCfg;
    private Project reconfigurableHardware;
    private Project reconfigurableHardwareCfg;
    private Project algorithms;
    private Project algorithmsCfg;
    private Project families;
    private Project familiesCfg;
    private Project pipelines;
    private Project priorityPipCfg;
    private Project pipelinesCfg;
    private Project infrastructure;
    private Project infrastructureCfg;
    private Project qm;
    
    private ProjectImport importBasic;
    private ProjectImport importObservables;
    private ProjectImport importHardware;
    private ProjectImport importHardwareCfg;
    private ProjectImport importAdaptivity;
    private ProjectImport importAdaptivityCfg;
    private ProjectImport importObservablesCfg;
    private ProjectImport importDataManagement;
    private ProjectImport importDataManagementCfg;
    private ProjectImport importReconfigurableHardware;
    private ProjectImport importReconfigurableHardwareCfg;
    private ProjectImport importAlgorithms;
    private ProjectImport importAlgorithmsCfg;
    private ProjectImport importFamilies;
    private ProjectImport importFamiliesCfg;
    private ProjectImport importPipelines;
    private ProjectImport importPriorityPipCfg;
    private ProjectImport importPipelinesCfg;
    private ProjectImport importInfrastructure;
    private ProjectImport importInfrastructureCfg;
    
    /**
     * Initializes this Test class.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        ModelUtility.setResourceInitializer(new StandaloneInitializer());
        try {
            VarModel.INSTANCE.locations().addLocation(FOLDER, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail("Could not add location of test files.");
        }
    }
    
    /**
     * Frees the memory after testing.
     */
    @AfterClass
    public static void tearDownAfterClass() {
        try {
            VarModel.INSTANCE.locations().removeLocation(FOLDER, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail("Could not remove location of test files.");
        }
    }
    
    /**
     * Method for determining folder with IVML files.
     * @param property property
     * @return folder location
     */
    private static File determineTestDataFolder(String property) {
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
            
        return testdataFolder;    
    }
    
    /**
     * Helper method for load an IVML file.
     * @param path The name of the ivml file to load (including the file extension) inside of the
     *     <tt>reasonerModel</tt> folder.
     * @return The loaded {@link Project} representing the read IVML file.
     */
    protected Project loadProject(String path) {
        Project project = null;
        try {
            File projectFile = new File(FOLDER, path);
            URI uri = URI.createFileURI(projectFile.getAbsolutePath());
            TranslationResult<Project> result = ModelUtility.INSTANCE.parse(uri);
            StringBuffer errorMsg = new StringBuffer();
            for (int i = 0; i < result.getMessageCount(); i++) {
                Message msg = result.getMessage(i);
                if (!msg.ignore()) {
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
     * Method for loading all projects.
     */
    private void loadAllProjects() {
        basic = loadProject("Basics.ivml");
        observables = loadProject("Observables.ivml");
        hardware = loadProject("Hardware.ivml");
        hardwareCfg = loadProject("HardwareCfg.ivml");
        adaptivity = loadProject("Adaptivity.ivml");
        adaptivityCfg = loadProject("AdaptivityCfg.ivml");
        observablesCfg = loadProject("ObservablesCfg.ivml");
        dataManagement = loadProject("DataManagement.ivml");
        dataManagementCfg = loadProject("DataManagementCfg.ivml");
        reconfigurableHardware = loadProject("ReconfigurableHardware.ivml");
        reconfigurableHardwareCfg = loadProject("ReconfigurableHardwareCfg.ivml");
        algorithms = loadProject("Algorithms.ivml");
        algorithmsCfg = loadProject("AlgorithmsCfg.ivml");
        families = loadProject("Families.ivml");
        familiesCfg = loadProject("FamiliesCfg.ivml");
        pipelines = loadProject("Pipelines.ivml");
        priorityPipCfg = loadProject("PriorityPipCfg.ivml");
        pipelinesCfg = loadProject("PipelinesCfg.ivml");
        infrastructure = loadProject("Infrastructure.ivml");
        infrastructureCfg = loadProject("InfrastructureCfg.ivml");
        qm = loadProject("QM_0.ivml");
    }
    
    /**
     * Method for creating project imports.
     */
    private void createProjectImports() {
        importBasic = new ProjectImport(basic.getName(), null);
        importObservables = new ProjectImport(basic.getName(), null);
        importHardware = new ProjectImport(basic.getName(), null);
        importHardwareCfg = new ProjectImport(basic.getName(), null);
        importAdaptivity = new ProjectImport(basic.getName(), null);
        importAdaptivityCfg = new ProjectImport(basic.getName(), null);
        importObservablesCfg = new ProjectImport(basic.getName(), null);
        importDataManagement = new ProjectImport(basic.getName(), null);
        importDataManagementCfg = new ProjectImport(basic.getName(), null);
        importReconfigurableHardware = new ProjectImport(basic.getName(), null);
        importReconfigurableHardwareCfg = new ProjectImport(basic.getName(), null);
        importAlgorithms = new ProjectImport(basic.getName(), null);
        importAlgorithmsCfg = new ProjectImport(basic.getName(), null);
        importFamilies = new ProjectImport(basic.getName(), null);
        importFamiliesCfg = new ProjectImport(basic.getName(), null);
        importPipelines = new ProjectImport(basic.getName(), null);
        importPriorityPipCfg = new ProjectImport(basic.getName(), null);
        importPipelinesCfg = new ProjectImport(basic.getName(), null);
        importInfrastructure = new ProjectImport(basic.getName(), null);
        importInfrastructureCfg = new ProjectImport(basic.getName(), null);
    }
    
    /**
     * Method to create QM model(import projects) and validate it. 
     * @param expectedFailedConstraints Number of constraints that are expected to fail.
     */        
    public void reasoningTest(int expectedFailedConstraints) {
        loadAllProjects();
        createProjectImports();
        observables.addImport(importBasic);
        hardware.addImport(importBasic);
        hardware.addImport(importObservables);
        hardwareCfg.addImport(importHardware);
        adaptivity.addImport(importBasic);
        adaptivity.addImport(importObservables);
        adaptivityCfg.addImport(importAdaptivity);
        observablesCfg.addImport(importObservables);
        dataManagement.addImport(importBasic);
        dataManagement.addImport(importObservables);
        dataManagementCfg.addImport(importDataManagement);
        reconfigurableHardware.addImport(importBasic);
        reconfigurableHardware.addImport(importObservables);
        reconfigurableHardwareCfg.addImport(importReconfigurableHardware);
        algorithms.addImport(importBasic);
        algorithms.addImport(importObservables);
        algorithms.addImport(importReconfigurableHardware);
        algorithmsCfg.addImport(importReconfigurableHardware);
        algorithmsCfg.addImport(importReconfigurableHardwareCfg);
        algorithmsCfg.addImport(importAlgorithms);
        families.addImport(importBasic);
        families.addImport(importAlgorithms);
        familiesCfg.addImport(importReconfigurableHardware);
        familiesCfg.addImport(importFamilies);
        familiesCfg.addImport(importAlgorithmsCfg);
        pipelines.addImport(importBasic);
        pipelines.addImport(importFamilies);
        pipelines.addImport(importDataManagement);
        pipelines.addImport(importHardware);
        priorityPipCfg.addImport(importPipelines);
        priorityPipCfg.addImport(importFamiliesCfg);
        priorityPipCfg.addImport(importDataManagementCfg);
        pipelinesCfg.addImport(importPriorityPipCfg);
        infrastructure.addImport(importBasic);
        infrastructure.addImport(importHardware);
        infrastructure.addImport(importReconfigurableHardware);
        infrastructure.addImport(importFamilies);
        infrastructure.addImport(importObservables);
        infrastructure.addImport(importAdaptivity);
        infrastructure.addImport(importPipelines);
        infrastructureCfg.addImport(importInfrastructure);
        infrastructureCfg.addImport(importPipelinesCfg);
        qm.addImport(importHardwareCfg);
        qm.addImport(importReconfigurableHardwareCfg);
        qm.addImport(importDataManagementCfg);
        qm.addImport(importObservablesCfg);
        qm.addImport(importAdaptivityCfg);
        qm.addImport(importAlgorithmsCfg);
        qm.addImport(importFamiliesCfg);
        qm.addImport(importPipelinesCfg);
        qm.addImport(importInfrastructureCfg);
        
        resultHandler(expectedFailedConstraints, qm);
    }    

    /**
     * Method for handling reasoning result.
     * @param expectedFailedConstraints Number of constraints that are expected to fa
     * @param qm Project to reason on.
     */
    private void resultHandler(int expectedFailedConstraints, Project qm) {
        Configuration config = new Configuration(qm, false);        
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        // Perform reasoning
        Engine engine = new Engine(qm, config, rConfig, ProgressObserver.NO_OBSERVER);
        ReasoningResult result = engine.reason();
        
        // Test whether reasoning detected correct result  
        int failedConstraints = 0;
        for (int i = 0; i < result.getMessageCount(); i++) {
            if (result.getMessage(i).getStatus() == Status.ERROR) {
                failedConstraints = failedConstraints + result.getMessage(i).getConflicts().size(); 
            }
        }
        Assert.assertEquals("Failed constraints: ", expectedFailedConstraints, failedConstraints);
    }   
    
    /**
     * Basic test.
     */
    @Test    
    public void coreTest() {
        reasoningTest(1);
    } 
    
    
}
