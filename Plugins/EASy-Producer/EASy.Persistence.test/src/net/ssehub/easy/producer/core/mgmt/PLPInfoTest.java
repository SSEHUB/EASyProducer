package net.ssehub.easy.producer.core.mgmt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.producer.core.AllTests;
import net.ssehub.easy.producer.core.mgmt.VilTestExectuter.AbstractVilListener;
import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.producer.core.persistence.PersistenceUtils;
import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;
import net.ssehub.easy.producer.core.persistence.datatypes.IPersistencer;
import net.ssehub.easy.producer.core.persistence.datatypes.IProjectCreationResult;
import net.ssehub.easy.producer.core.persistence.datatypes.PathEnvironment;
import net.ssehub.easy.producer.core.persistence.standard.Persistencer;
import net.ssehub.easy.producer.core.varMod.container.ProjectContainer;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningOperation;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder.VisibilityType;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Tests the {@link PLPInfo} class.
 * @author El-Sharkawy
 *
 */
public class PLPInfoTest extends AbstractPLPInfoTest {
    
    /**
     * Project for testing reasoning capabilities.
     * This project has an inconsistent configuration.
     * PLP will not be modified -> PLP can be loaded from the origins folder. 
     */
    private static final File TEST_PROJECT_REASONING_FAIL
        = new File(AllTests.TESTDATA_DIR_ORIGINS, "ReasoningWillFail");
    
    /**
     * Project for testing reasoning propagation capabilities.
     * PLP will not be modified -> PLP can be loaded from the origins folder. 
     */
    private static final File TEST_PROJECT_PROPAGATION
        = new File(AllTests.TESTDATA_DIR_ORIGINS, "PropagationTestProject");
    
    /**
     * Project for testing switching IVML versions.
     * This project more than one IVML versions.
     * PLP will not be modified -> PLP can be loaded from the origins folder. 
     */
    private static final File TEST_PROJECT_DIFFERENT_IVML_VERSIONS
        = new File(AllTests.TESTDATA_DIR_ORIGINS, "DifferentIVMLVersions");
    
    /**
     * Project for creating (and saving) of a new {@link PLPInfo}.
     * PLP will be saved to local file system -> PLP must be stored to {@link AllTests#TESTDATA_DIR_COPY}.
     */
    private static final File TEST_PROJECT_CREATION
        = new File(AllTests.TESTDATA_DIR_COPY, "PROJECT_CREATION_TEST");
    
    /**
     * Project for saving of a modified {@link PLPInfo}.
     * PLP will be saved to local file system -> PLP must be stored to {@link AllTests#TESTDATA_DIR_COPY}.
     */
    private static final File TEST_PROJECT_MODIFY
        = new File(AllTests.TESTDATA_DIR_COPY, "Project4ModifyingAndSaving");
    
    /**
     * Project for instantiating a {@link PLPInfo}.
     * PLP instantiated files will be saved to local file system
     * -> PLP must be stored to {@link AllTests#TESTDATA_DIR_COPY}.
     */
    private static final File TEST_PROJECT_INSTANTIATE
        = new File(AllTests.TESTDATA_DIR_COPY, "PL_SimElevator_frozen");
    
    /**
     * Project for testing loading a project with an invalid VIL file
     * This has an invalid VIL file.
     * PLP will not be modified -> PLP can be loaded from the origins folder. 
     */
    private static final File TEST_PROJECT_INVALID_VIL_FILE
        = new File(AllTests.TESTDATA_DIR_ORIGINS, "InvalidVILFile");
   
    /**
     * Project for testing loading a project with an invalid IVML file
     * This has an invalid IVML file.
     * PLP will not be modified -> PLP can be loaded from the origins folder. 
     */
    private static final File TEST_PROJECT_INVALID_IVML_FILE
        = new File(AllTests.TESTDATA_DIR_ORIGINS, "InvalidIVMLFile");
    
    /**
     * Project for testing different IVML/VIL, and VTL folders.
     * PLP will be instantiated and files will be saved to local file system
     * -> PLP must be stored to {@link AllTests#TESTDATA_DIR_COPY}.
     */
    private static final File TEST_MULTIPLE_CONFIG_FOLDERS
        = new File(AllTests.TESTDATA_DIR_COPY, "MultipleFolders");
    
    private static final String PROJECT_NAME_MULTIPLE_PROJECTS_IN_IVML_FILE = "MultipleProjectsInIVMLFile";
    
    /**
     * Project for testing multiple projects in one IVML file.
     * Test will tests whether the file will be saved correctly
     * -> PLP must be stored to {@link AllTests#TESTDATA_DIR_COPY}.
     */
    private static final File TEST_MULTIPLE_PROJECTS_IN_IVML_FILE
        = new File(AllTests.TESTDATA_DIR_COPY, PROJECT_NAME_MULTIPLE_PROJECTS_IN_IVML_FILE);
    
    /**
     * Project for testing saving debug information.
     * Test will tests whether the debug file will be saved correctly
     * -> PLP must be stored to {@link AllTests#TESTDATA_DIR_COPY}.
     */
    private static final File TEST_SAVE_DEBUG_INFORMATION
        = new File(AllTests.TESTDATA_DIR_COPY, "SavingDebugInformation");
    
    /**
     * Project for testing multiple instantiation.
     * Test will tests whether instantiation works fine.
     * -> PLP must be stored to {@link AllTests#TESTDATA_DIR_COPY}.
     */
    private static final File TEST_MULTI_INSTANTIATION
        = new File(AllTests.TESTDATA_DIR_COPY, "MultiInstantiation");
    
    /**
     * Project for testing partial re-assignment of compounds.
     * Test will test correct initialization of the configuration.
     */
    private static final File TEST_PARTIAL_COMPOUND_ASSIGNMENT
        = new File(AllTests.TESTDATA_DIR_ORIGINS, "PartialCompoundAssignment");
    
    private static Set<PLPInfo> loadedInfos = new HashSet<PLPInfo>();
    
    /**
     * Fallback No. 2 ;-)
     */
    private static final String DEFAULT_JDK_LOCATION = "C:\\Program Files (x86)\\Java\\jdk1.7.0_51";
    
    /**
     * Registers VIL and VTL expression parser. This should normally be done via the Descriptive Services (DS),
     * but it seems that it is not the case when the tests are executed via ANT.
     * Checks whether the java.home variable is set to a JDK location.
     * If it is not set, the {@link #DEFAULT_JDK_LOCATION} will be set.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        // Ensure that the java compiler can be found.
        String javaLocation = System.getProperty("java.home");
        String os = System.getProperty("os.name").toLowerCase();
        if (javaLocation.contains("jre") && os.indexOf("win") >= 0) {
            // Fallback No. 1
            String jdkLocation = System.getenv("JAVA_HOME");
            if (null != jdkLocation) {
                System.setProperty("java.home", jdkLocation);
            } else {
                System.setProperty("java.home", DEFAULT_JDK_LOCATION);
            }
        }
        
        AbstractPLPInfoTest.setUpBeforeClass();
    }
    
    /**
     * Closes all {@link PLPInfo}s, which were loaded in a test.
     * This should avoid side effects inside the {@link net.ssehub.easy.basics.modelManagement.ModelManagement}s,
     * while parsing the config files of different {@link PLPInfo} projects.
     */
    @After
    public void tearDown() {
        for (PLPInfo plp : loadedInfos) {
            plp.close();
        }
        
        loadedInfos.clear();
    }
    
    /**
     * Helping method for loading projects from the testdata folder.
     * @param projectFolder The toplevel folder of a saved {@link PLPInfo} which should be used for testing.
     * @return A {@link PLPInfo} which was loaded from the given location.
     * @throws PersistenceException Must not occur, otherwise the config files inside the toplevel location are corrupt.
     */
    protected static PLPInfo loadPLPInfo(File projectFolder) throws PersistenceException {
        PLPInfo plp = AbstractPLPInfoTest.loadPLPInfo(projectFolder);
        // For closing the plps after running all tests
        loadedInfos.add(plp);
        
        return plp;
    }
 
    /**
     * Tests the correct instantiation of the {@link PLPInfo}.
     * @throws PersistenceException Must not occur, otherwise the config files inside the toplevel location are corrupt.
     */
    @Test
    public void testInit() throws PersistenceException {
        // Test project with 3 elements      
        PLPInfo plp = loadPLPInfo(TEST_PROJECT_REASONING_FAIL);
        Assert.assertNotNull(plp.getProject());
        Assert.assertEquals(3, plp.getProject().getElementCount());
        Assert.assertNotNull(plp.getConfiguration());
        
        // Test project with 1 element       
        plp = loadPLPInfo(TEST_PROJECT_DIFFERENT_IVML_VERSIONS);
        Assert.assertNotNull(plp.getProject());
        Assert.assertEquals(1, plp.getProject().getElementCount());
        Assert.assertNotNull(plp.getConfiguration());
    }
    
    /**
     * Tests whether projects with inconsistent/invalid variability model files can be loaded.
     * TODO SE: Loading project with broken IVML file is not tested. 
     * @throws PersistenceException Must not occur, otherwise the {@link IPersistencer} is broken.
     */
    @Test
    public void testLoadInvalidProject() throws PersistenceException {
        //Load project with an invalid IVML file
        PLPInfo plpIVML = loadPLPInfo(TEST_PROJECT_INVALID_IVML_FILE);
        Assert.assertNotNull(plpIVML);
        Assert.assertEquals(1, plpIVML.getParsingExceptions().size());
        
        //Load project with an invalid VIL file
        PLPInfo plpVIL = loadPLPInfo(TEST_PROJECT_INVALID_VIL_FILE);
        Assert.assertNotNull(plpVIL);
        Assert.assertEquals(1, plpVIL.getParsingExceptions().size());
    }
    
    /**
     * Tests the {@link PLPInfo#reason(net.ssehub.easy.reasoning.core.reasoner.ReasoningOperation,
     * de.uni_hildesheim.sse.reasoning.core.frontend.IReasonerListener)} method.<br/>
     * The performed reasoning should detect a incosistence in the configuration.
     * @throws PersistenceException Must not occur, otherwise the config files inside the toplevel location are corrupt.
     * 
     */
    @Test
    public void testReasonFails() throws PersistenceException {
        // Load PLP
        PLPInfo plp = loadPLPInfo(TEST_PROJECT_REASONING_FAIL);
        Assert.assertNotNull(plp.getProject());
        Assert.assertEquals(3, plp.getProject().getElementCount());
        Assert.assertNotNull(plp.getConfiguration());
        ReasoningListener rListener = new ReasoningListener() {
            
            @Override
            void afterReasoning(ReasoningResult result) {
                // Check correctness of reasoning
                Assert.assertFalse("Wrong reasoner used: Reasoning was unsupported.", result.reasoningUnsupported());
                Assert.assertFalse("Error: Info detected, but the reasult should only contain a conflict."
                    , result.hasInfo());
                
                // Reasoning should detect a conflict inside the configuration.
                Assert.assertTrue("Error: No conflict detected, but the model has a conflict", result.hasConflict());
            }
        };
        
        // Perform reasoning
        plp.reason(ReasoningOperation.VALIDATION, rListener);
        
        // Test whether reasoning was performed (otherwise its unclear whether the afterReasoning method was called).
        Assert.assertTrue("Reasoning not perfomed, maybe because of the absence of a reasoner.",
            rListener.didReasoning());
    }

    /**
     * Tests whether a {@link PLPInfo} can bear more than one IVML project.
     * @throws PersistenceException Must not occur, otherwise the config files inside the toplevel location are corrupt.
     */
    @Test
    public void testChangeIVMLVersion() throws PersistenceException {
        // Load PLP
        PLPInfo plp = loadPLPInfo(TEST_PROJECT_DIFFERENT_IVML_VERSIONS);
        List<ModelInfo<Project>> infos = plp.listAvailableModels();
        Collections.sort(infos, new Comparator<ModelInfo<Project>>() {

            @Override
            public int compare(ModelInfo<Project> o1, ModelInfo<Project> o2) {
                // Will crash if one version is null, but in this case all infos have a version.
                return o1.getVersion().compareTo(o2.getVersion());
            }
        });
        
        // Test correct setting of loaded plp
        Version highestVersion = new Version(1, 2);
        Assert.assertTrue(Version.equals(highestVersion, plp.getHighestVersion()));
        Assert.assertEquals(3, infos.size());
        Assert.assertEquals("0", plp.getVersion());
        Assert.assertNotNull(plp.getProject());
        Assert.assertSame(infos.get(0).getResolved(), plp.getProject());
        Assert.assertEquals(1, plp.getProject().getElementCount());
        
        // Switch to 2nd info
        switchProject(plp, infos.get(1));
        Assert.assertEquals("1.1", plp.getVersion());
        Assert.assertEquals(2, plp.getProject().getElementCount());
        
        //Switch to 3rd info
        switchProject(plp, infos.get(2));
        Assert.assertEquals("1.2", plp.getVersion());
        Assert.assertEquals(3, plp.getProject().getElementCount());
    }

    /**
     * Helping method of {@link #testChangeIVMLVersion()}.
     * Switches the the IVML project of the given {@link PLPInfo} and tests whether this operation
     * was performed successfully.
     * @param plp The {@link PLPInfo} where the Project should be changed.
     * @param info A {@link ModelInfo} holding a {@link Project} which is part of the given {@link PLPInfo}.
     */
    private void switchProject(PLPInfo plp, ModelInfo<Project> info) {
        
        // Load the project if not done already
        if (null == info.getResolved()) {
            try {
                VarModel.INSTANCE.load(info);
            } catch (ModelManagementException e) {
                Assert.fail("Model could not be loaded:\n" + e.getLocalizedMessage());
            }
        }
        
        // Switch project
        ProjectContainer varModel = new ProjectContainer(info.getResolved(), plp.getPathConfiguration());
        plp.setProject(varModel);
        
        // Test whether project was switched successfully
        Assert.assertNotNull(plp.getProject());
        Assert.assertSame(info.getResolved(), plp.getProject());
    }
    
    /**
     * Tests whether a new {@link PLPInfo} can be created and saved.
     * @throws PersistenceException If the files could not be written/created to the file system.
     */
    @Test
    public void testCreation() throws PersistenceException {
        // Test that no data exists at the desired location
        Assert.assertFalse(TEST_PROJECT_CREATION.exists());
        
        // Create and save new project.
        PathEnvironment projectsWorkspace = new PathEnvironment(TEST_PROJECT_CREATION.getParentFile());
        File easyConfigFile = PersistenceUtils.getLocationFile(TEST_PROJECT_CREATION, PathKind.IVML);
        IPersistencer persistencer = new Persistencer(projectsWorkspace, TEST_PROJECT_CREATION,
            easyConfigFile.getAbsolutePath(), ProgressObserver.NO_OBSERVER);
        IProjectCreationResult result = persistencer.createProject(TEST_PROJECT_CREATION.getName(),
            TEST_PROJECT_CREATION.getParentFile(), UUID.randomUUID().toString(), false);
        PLPInfo plp = new PLPInfoLoader(result);
        
        // Test whether project was saved correctly
        Assert.assertTrue(TEST_PROJECT_CREATION.exists());
        Assert.assertEquals(TEST_PROJECT_CREATION, plp.getProjectLocation());
    }
    
    /**
     * Tests whether a modified {@link PLPInfo} can be saved.
     * @throws PersistenceException IF the files could not be written/created to the file system.
     * @throws ValueDoesNotMatchTypeException Will be thrown, if the only one {@link DecisionVariableDeclaration}
     *     inside of the IVML file is not of type {@link net.ssehub.easy.varModel.model.datatypes.IntegerType}.
     * @throws ConfigurationException Must not occur, otherwise there is a failure inside of the
     *     {@link net.ssehub.easy.varModel.confModel.Configuration}.
     * @throws IOException Will be thrown, if the changed file could not be saved to the local file system.
     */
    @Test
    public void testSave() throws PersistenceException, ValueDoesNotMatchTypeException, ConfigurationException,
        IOException {
        
        // Load PLP
        PLPInfo plp = loadPLPInfo(TEST_PROJECT_MODIFY);
        String ivmlLocation
            = PersistenceUtils.ivmlFileLocation(plp.getProject(), plp.getConfigLocation().getAbsolutePath());
        DecisionVariableDeclaration decl = (DecisionVariableDeclaration) plp.getProject().getElement(0);
        Assert.assertNotNull(decl);
        Assert.assertEquals("a", decl.getName());
        IDecisionVariable var = plp.getConfiguration().getDecision(decl);
        Assert.assertNull(var.getValue());
        
        // Modify the value of the only one variable
        Value value = ValueFactory.createValue(decl.getType(), "1");
        var.setValue(value, AssignmentState.ASSIGNED);
        Assert.assertNotNull(var.getValue());
        
        // save modified plp
        plp.save();
        
        //Test whether files has been saved correctly
        BufferedReader reader = new BufferedReader(new FileReader(ivmlLocation));
        StringBuffer content = new StringBuffer();
        String line = null;
        while ((line = reader.readLine()) != null) {
            content.append(line);
        }
        reader.close();
        Assert.assertTrue("Error: changes has not been saved:", content.toString().contains("a = 1;"));
    }
    
    /**
     * Tests whether the instantiation process works.
     * @throws PersistenceException If the project could not be loaded from the file system.
     * @throws VilException If instantiation is not possible
     */
    @Test
    public void testInstantiate() throws PersistenceException, VilException {
        // Load project
        PLPInfo plp = loadPLPInfo(TEST_PROJECT_INSTANTIATE);
        
        // Test that uninstantiated SRC-Files are NOT compileable
        compile(plp.getProjectLocation(), false);
        
        // Start instantiation
        VilTestExectuter plpInstantiator = new VilTestExectuter();
        plpInstantiator.assertInstantiation(plp, 5000, new AbstractVilListener() {
            
            @Override
            public void vilExecutionFinished(PLPInfo plp) {
                // Test that instantiated SRC-Files are compileable
                compile(plp.getProjectLocation(), true);
            }
            
            @Override
            public void vilExecutionAborted(PLPInfo plp, VilException exc) {
                Assert.fail(exc.getMessage());
            }
        });
    }

    /**
     * Tests whether VIL scripts with own function containing a path as precondition can be executed twice.
     * @throws PersistenceException If the project could not be loaded from the file system.
     */
    @Test
    public void testMultipleInstantiation() throws PersistenceException {
        PLPInfo plp = loadPLPInfo(TEST_MULTI_INSTANTIATION);
        File copiedFolder = new File(plp.getProjectLocation(), "src");
        final File copiedFile = new File(copiedFolder, "HelloWorld.java");
        Assert.assertFalse(copiedFile.exists());
        
        // First instantiation
        VilTestExectuter plpInstantiator2 = new VilTestExectuter();
        // More time as this listener waits also until the second instantiation is finished
        plpInstantiator2.assertInstantiation(plp, 50000,  new AbstractVilListener() {
            
            @Override
            public void vilExecutionFinished(PLPInfo plp) {
                System.out.println("Finished 1st instantiation");
                Assert.assertTrue(copiedFile.exists());
                Assert.assertTrue(copiedFile.delete());
                
                // Start second instantiation
                VilTestExectuter plpInstantiator = new VilTestExectuter();
                plpInstantiator.assertInstantiation(plp, new AbstractVilListener() {
                    @Override
                    public void vilExecutionFinished(PLPInfo plp) {
                        System.out.println("Finished 2nd instantiation");
                        // Finished second instantiation
                        Assert.assertTrue(copiedFile.exists());
                    }
                    
                    @Override
                    public void vilExecutionAborted(PLPInfo plp, VilException exc) {
                        exc.printStackTrace();
                        Assert.fail("Second instantiation failed: " + exc.getMessage());
                    }
                });
            }
            
            @Override
            public void vilExecutionAborted(PLPInfo plp, VilException exc) {
                exc.printStackTrace();
                Assert.fail("First instantiation failed: " + exc.getMessage());
            }
        });
    }
    
    /**
     * Tests the possibility to run the reasoner to propagate values.
     * The loaded project has an IVML file as follows:
     * <pre>
     * Integer a;
     * Integer b;
     * a = 5;
     * b = (a + 1);
     * </pre>
     * The reasoner should find a value for <code>b</code>.
     * @throws PersistenceException Must not occur, otherwise the config files inside the toplevel location are corrupt.
     */
    @Ignore("Configuration is already propagating such values autmatically...")
    @Test
    public void testPropagation() throws PersistenceException {
        // Load project
        PLPInfo plp = loadPLPInfo(TEST_PROJECT_PROPAGATION);
        DeclarationFinder finder = new DeclarationFinder(plp.getProject(), FilterType.ALL, null);
        List<AbstractVariable> declarations = finder.getVariableDeclarations(VisibilityType.ALL);
        Assert.assertEquals(2, declarations.size());
        Configuration config = plp.getConfiguration();
        AbstractVariable declA = null;
        AbstractVariable declB = null;
        for (int i = 0; i < declarations.size(); i++) {
            AbstractVariable current = declarations.get(i);
            if (current.getName().equals("a")) {
                declA = current;
            } else if (current.getName().equals("b")) {
                declB = current;
            }
        }
        IDecisionVariable varA = config.getDecision(declA);
        IDecisionVariable varB = config.getDecision(declB);
        
        // Test that ONLY ONE of the existing variables has a value
        Assert.assertNotNull(varA.getValue());
        Assert.assertEquals(AssignmentState.ASSIGNED, varA.getState());
        Assert.assertNull(varB.getValue());
        Assert.assertEquals(AssignmentState.UNDEFINED, varB.getState());
        
        // Propagate values
        final AbstractVariable propagatedDeclaration = declB;
        ReasoningListener rListener = new ReasoningListener() {
            
            @Override
            void afterReasoning(ReasoningResult result) {
                // Test whether declB got a propagated value
                Assert.assertEquals(1, result.getMessageCount());
                Message msg = result.getMessage(0);
                Assert.assertSame(net.ssehub.easy.basics.messages.Status.INFO, msg.getStatus());
                Assert.assertEquals(1, msg.getConflicts().size());
                Assert.assertSame(propagatedDeclaration, msg.getConflicts().get(0));
            }
        };
        
        // Perform reasoning
        plp.reason(ReasoningOperation.PROPAGATION, rListener);
        
        // Test whether reasoning was performed (otherwise its unclear whether the afterReasoning method was called).
        Assert.assertTrue("Reasoning not perfomed, maybe because of the absence of a reasoner.",
            rListener.didReasoning());
        
        // Test that BOTH variables has a value
        Assert.assertNotNull(varA.getValue());
        Assert.assertEquals(AssignmentState.ASSIGNED, varA.getState());
        Assert.assertNotNull(varB.getValue());
        Assert.assertEquals(AssignmentState.DERIVED, varB.getState());
        Assert.assertEquals(6, varB.getValue().getValue());
    }
    
    /**
     * Tests the possibility to re-assign only some, but not all, values of a compound.
     * The loaded project has an IVML file as follows:
     * <pre>
     * compound Dimension {
     *   Integer width;
     *   Integer height;
     * }
     * 
     * Dimension dim = {width = 1920, height = 1080};
     * dim = {width = 1900};
     * </pre>
     * EASy should set the values for the compound as follows: {width = 1900, height=1080}.
     * @throws PersistenceException Must not occur, otherwise the config files inside the toplevel location are corrupt.
     */
    @Test
    public void testPartialCompoundAssignment() throws PersistenceException {
        // Load project
        PLPInfo plp = loadPLPInfo(TEST_PARTIAL_COMPOUND_ASSIGNMENT);
        Configuration config = plp.getConfiguration();
        Assert.assertEquals(1, config.getDecisionCount());
        
        Iterator<IDecisionVariable> itr = config.iterator();
        IDecisionVariable cmpVar = itr.next();
        
        // Test that the compound has a value
        Assert.assertNotNull(cmpVar.getValue());
        Assert.assertTrue(cmpVar.getValue().isConfigured());
        Assert.assertEquals(AssignmentState.ASSIGNED, cmpVar.getState());
        Assert.assertEquals(2, cmpVar.getNestedElementsCount());
        // Test correct value as described in JavaDoc.
        IDecisionVariable widthSlot = null;
        IDecisionVariable heightSlot = null;
        for (int i = 0; i < cmpVar.getNestedElementsCount(); i++) {
            IDecisionVariable nestedVar = cmpVar.getNestedElement(i);
            if ("width".equals(nestedVar.getDeclaration().getName())) {
                widthSlot = nestedVar;
            } else if ("height".equals(nestedVar.getDeclaration().getName())) {
                heightSlot = nestedVar;
            }
        }
        Assert.assertNotNull(widthSlot);
        Assert.assertNotNull(heightSlot);
        Assert.assertEquals(1900, widthSlot.getValue().getValue());
        Assert.assertEquals(1080, heightSlot.getValue().getValue());
    }
    
    /**
     * Tests whether IVML, VIL, and VTL folder may be different.
     * @throws PersistenceException Must not occur, otherwise the config files inside the toplevel location are corrupt.
     * @throws VilException If instantiation is not possible (this may include, that three different folders are
     *     not supported).
     */
    @Test
    public void testMultipleConfigFolders() throws PersistenceException, VilException {
        // Load project
        PLPInfo plp = loadPLPInfo(TEST_MULTIPLE_CONFIG_FOLDERS);
        final File generatedFile = new File(plp.getProjectLocation(), "out.txt");
        
        // Check that all folders are different
        Assert.assertNotNull(plp.getConfigLocation());
        Assert.assertNotNull(plp.getScriptLocation());
        Assert.assertNotNull(plp.getTemplateLocation());
        Assert.assertNotEquals(plp.getConfigLocation(), plp.getScriptLocation());
        Assert.assertNotEquals(plp.getConfigLocation(), plp.getTemplateLocation());
        Assert.assertNotEquals(plp.getScriptLocation(), plp.getTemplateLocation());
        
        // Test whether such a folder setting can be used for instantiation
        // Test precondition: file to instantiate does not exist
        Assert.assertFalse(generatedFile.exists());
        
        // Start instantiation
        VilTestExectuter plpInstantiator = new VilTestExectuter();
        plpInstantiator.assertInstantiation(plp, new AbstractVilListener() {
            
            @Override
            public void vilExecutionFinished(PLPInfo plp) {
                // Test postcondition: File must be created and contain a "Hello World" ;-)
                Assert.assertTrue(generatedFile.exists());
                //String content = FileUtils.readFileToString(generatedFile);
                //Assert.assertTrue(content.contains("\"Hello World\""));
            }
            
            @Override
            public void vilExecutionAborted(PLPInfo plp, VilException exc) {
                Assert.fail(exc.getMessage());
            }
        });
    }
    
    /**
     * Tests whether a IVML file with multiple projects is saved correctly by EASy.
     * It would be nice if the projects would not be reordered, but this cannot be guaranteed at this moment.
     * However, this test tests whether the ordering will be kept.
     * @throws PersistenceException Must not occur, otherwise the config files inside the toplevel location are corrupt.
     * @throws ValueDoesNotMatchTypeException If configuration is not supported (Error in VarModel).
     * @throws ConfigurationException If configuration is not supported (Error in VarModel).
     * @throws IOException If the generated file could not read from the file system
     */
    @Test
    public void testMultipleProjectsInIVMLFile() throws PersistenceException,
        ValueDoesNotMatchTypeException, ConfigurationException, IOException {
        
        // Load project
        PLPInfo plp = loadPLPInfo(TEST_MULTIPLE_PROJECTS_IN_IVML_FILE);
        
        // Test precondition: PLP should have IVML-Project with 2 imports and no errors
        Assert.assertTrue("Error: IVML file with multiple projects could not be parsed.",
            plp.getParsingExceptions().isEmpty());
        Project mainProject = plp.getProject();

        Assert.assertEquals("Error: Not expected number of imports found.", 2, mainProject.getImportsCount());
        ProjectImport pImport1 = mainProject.getImport(0);
        ProjectImport pImport2 = mainProject.getImport(1);
        Assert.assertNotNull("Error: Imported IVML projects could not be resolved.", pImport1.getResolved());
        Assert.assertNotNull("Error: Imported IVML projects could not be resolved.", pImport2.getResolved());
        
        // Action: Configure one value and save (All variables are Integers).
        Configuration config = plp.getConfiguration();
        Iterator<IDecisionVariable> configIterator = config.iterator();
        boolean found = false;
        // An arbitrary variable could be used, but one specific should be chosen to simplify testing
        while (configIterator.hasNext() && !found) {
            IDecisionVariable var = configIterator.next();
            if (var.getDeclaration().getName().equals("internalProjectVar")) {
                Value value = ValueFactory.createValue(var.getDeclaration().getType(), "1");
                var.setValue(value, AssignmentState.ASSIGNED);
                found = true;
            }
        }
        Assert.assertTrue("Error: No variable found in config.", found);
        plp.save();
        
        /*
         * Test postcondition: Compare original IVML file and saved IVML file
         * 1.) The new file should contain a new line: internalProjectVar = 1;
         * 2.) The new file should contain the projects in the same order, but this cannot be guaranteed
         */
        String configFolder = plp.getConfigLocation().getName();
        String fileName = "MultipleProjectsInIVMLFile_0.ivml";
        File originalIVMLFile = new File(AllTests.TESTDATA_DIR_ORIGINS, PROJECT_NAME_MULTIPLE_PROJECTS_IN_IVML_FILE);
        originalIVMLFile = new File(new File(originalIVMLFile, configFolder), fileName);
        File savedIVMLFile = new File(new File(TEST_MULTIPLE_PROJECTS_IN_IVML_FILE, configFolder), fileName);
        String originalContent = FileUtils.readFileToString(originalIVMLFile).replaceAll("\r", "");
        String savedContent = FileUtils.readFileToString(savedIVMLFile).replaceAll("\r", "");
        // Test whether originalContent + value assignment = savedContent
        String assignment = "    internalProjectVar = 1;\n";
        int index = savedContent.indexOf(assignment);
        savedContent = savedContent.replaceAll(assignment, "");
        System.out.println(savedContent);
        Assert.assertTrue("Error: Assignment was not saved.", index > 0);
        Assert.assertEquals("Error: Saved file has not the expected structure. Maybe only the odering of "
            + "projects have been changed (this would be ok).", originalContent, savedContent);
    }
    
    /**
     * Tests whether debug information will be created correctly.
     * @throws PersistenceException Must not occur, otherwise the config files inside the toplevel location are corrupt.
     * @throws ValueDoesNotMatchTypeException If configuration is not supported (Error in VarModel).
     * @throws ConfigurationException If configuration is not supported (Error in VarModel).
     * @throws IOException If the generated file could not read from the file system
     */
    @Test
    public void testSavingDebugInformation() throws PersistenceException, ValueDoesNotMatchTypeException,
        ConfigurationException, IOException {
        
        // Load project
        PLPInfo plp = loadPLPInfo(TEST_SAVE_DEBUG_INFORMATION);
        plp.setSaveDebugInformation(true);
        String debugFileName = "SavingDebugInformation_conf_0_debug.ivml";
        File debugIVMLFile = new File(plp.getConfigLocation(), debugFileName);
        
        // Test precondition: Debug file must not exist
        Assert.assertFalse("Error: Debug file exists before it was saved.", debugIVMLFile.exists());
                
        // Action: Configure variables and save project (including debug information).
        Configuration config = plp.getConfiguration();
        Iterator<IDecisionVariable> configIterator = config.iterator();
        while (configIterator.hasNext()) {
            IDecisionVariable var = configIterator.next();
            if (var.getDeclaration().getName().equals("userInput")) {
                Value value = ValueFactory.createValue(var.getDeclaration().getType(), "1");
                var.setValue(value, AssignmentState.ASSIGNED);
            } else if (var.getDeclaration().getName().equals("reasonerInput")) {
                Value value = ValueFactory.createValue(var.getDeclaration().getType(), "2");
                var.setValue(value, AssignmentState.DERIVED);
            } else if (var.getDeclaration().getName().equals("frozenInput")) {
                Value value = ValueFactory.createValue(var.getDeclaration().getType(), "3");
                var.setValue(value, AssignmentState.FROZEN);
            } 
        }
        plp.save();
        
        // Test postcondition: Debug file must be created with all value assignments.
        Assert.assertTrue("Error: Debug file was not saved.", debugIVMLFile.exists());
        String savedContent = FileUtils.readFileToString(debugIVMLFile).replaceAll("\r", "");
        // SavingDebugInformation.version == v0 can be in parenthesis or not. Currently, its tested without
        String expected = "project SavingDebugInformation_conf {\n\n    version v0;\n"
            + "    import SavingDebugInformation with SavingDebugInformation.version == v0;\n"
            + "    userInput = 1;\n    reasonerInput = 2;\n    frozenInput = 3;\n    freeze {\n"
            + "        frozenInput;\n    }\n}\n";
        Assert.assertEquals("Error: Wrong debug information has been saved.", expected, savedContent);
    }
}
