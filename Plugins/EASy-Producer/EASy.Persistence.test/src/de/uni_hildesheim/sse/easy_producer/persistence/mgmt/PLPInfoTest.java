package de.uni_hildesheim.sse.easy_producer.persistence.mgmt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import junit.framework.Assert;

import org.junit.Test;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.persistence.AbstractEASyTest;
import de.uni_hildesheim.sse.easy_producer.persistence.AllTests;
import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceUtils;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.IPersistencer;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.IProjectCreationResult;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.PathEnvironment;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.PersistentProject;
import de.uni_hildesheim.sse.easy_producer.persistence.standard.Persistencer;
import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder.VisibilityType;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.modelManagement.ProjectContainer;
import de.uni_hildesheim.sse.reasoning.core.model.ReasoningOperation;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Tests the {@link PLPInfo} class.
 * @author El-Sharkawy
 *
 */
public class PLPInfoTest extends AbstractEASyTest {
    
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
     * Helping method for loading projects from the testdata folder.
     * @param projectFolder The toplevel folder of a saved {@link PLPInfo} which should be used for testing.
     * @return A {@link PLPInfo} which was loaded from the given location.
     * @throws PersistenceException Must not occur, otherwise the config files inside the toplevel location are corrupt.
     */
    private static PLPInfo loadPLPInfo(File projectFolder) throws PersistenceException {
        // Create Persistencer for loading a PLP
        PathEnvironment projectsWorkspace = new PathEnvironment(projectFolder.getParentFile());
        File easyConfigFile = PersistenceUtils.getConfigLocationFile(projectFolder);
        IPersistencer persistencer = new Persistencer(projectsWorkspace, projectFolder,
            easyConfigFile.getAbsolutePath(), ProgressObserver.NO_OBSERVER);
        Assert.assertNotNull("Error: Persistencer could not be created.", persistencer);
        
        // Load PLP
        PersistentProject project  = persistencer.load();
        Assert.assertNotNull("Error: Information could not be loaded.", project);
        Assert.assertNotNull("Error: IVML could not be loaded.", project.getProject());
        Assert.assertNotNull("Error: VIL could not be loaded.", project.getMainBuildScript());
        
        PLPInfo plp = new PLPInfoLoader(project);
        Assert.assertNotNull("Error: PLP could not be created.", plp);
        Assert.assertNotNull("Error: IVML could not be loaded.", plp.getProject());
        Assert.assertNotNull("Error: VIL could not be loaded.", plp.getBuildScript());
        
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
     * Tests the {@link PLPInfo#reason(de.uni_hildesheim.sse.reasoning.core.model.ReasoningOperation,
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
        ProjectContainer varModel = new ProjectContainer(info.getResolved(), plp.getConfigLocation());
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
        File easyConfigFile = PersistenceUtils.getConfigLocationFile(TEST_PROJECT_CREATION);
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
     *     inside of the IVML file is not of type {@link de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType}.
     * @throws ConfigurationException Must not occur, otherwise there is a failure inside of the
     *     {@link de.uni_hildesheim.sse.model.confModel.Configuration}.
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
        Assert.assertTrue("Error: changes has not been saved:", content.toString().contains("a = 1;"));
    }
    
    /**
     * Tests whether the instantiation process works.
     * @throws PersistenceException If the project could not be loaded from the file system.
     * @throws VilLanguageException If instantiation is not possible
     */
    @Test
    public void testInstantiate() throws PersistenceException, VilLanguageException {
        // Load project
        PLPInfo plp = loadPLPInfo(TEST_PROJECT_INSTANTIATE);
        
        // Test that uninstantiated SRC-Files are NOT compileable
        compile(plp.getProjectLocation(), false);
        
        //Instantiate project
        plp.instantiate(null);
        
        // Test that instantiated SRC-Files are compileable
        compile(plp.getProjectLocation(), true);
    }
    
    /**
     * Runs the java compiler and checks whether the given folder is compilable.
     * @param folder A java project folder containing a <tt>src</tt> and a <tt>bin</tt> folder.
     * @param compilable Specification, whether the project should be compilable (<tt>true</tt>) or not(<tt>false</tt>).
     */
    private void compile(File folder, boolean compilable) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null,
            Charset.forName("ISO-8859-1"));
        List<File> files = new ArrayList<File>();
        enumerateJavaFiles(new File(folder, "src"), files);
        List<String> options = new ArrayList<String>();
        options.add("-d");
        File binFolder = new File(folder, "bin");
        if (!binFolder.exists()) {
            binFolder.mkdir();
        }
        options.add(new File(folder, "bin").getAbsolutePath());
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(files);
        StringWriter writer = new StringWriter();
        boolean success = compiler.getTask(writer, fileManager, null, options, null, compilationUnits).call();
        try {
            fileManager.close(); 
        } catch (IOException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
        if (compilable) {
            Assert.assertTrue("compile problems: " + writer.toString(), success);
        } else {
            Assert.assertFalse("Files should not be compileable, but they are.", success);
        }
    }
    
    /**
     * Enumerate Java files in <code>location</code> and store results in <code>files</code>.
     * 
     * @param location the location to enumerate
     * @param files the resulting java files (modified as a side effect)
     */
    private void enumerateJavaFiles(File location, List<File> files) {
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
     * Tests the possibility to run the reasoner to propagate values.
     * The loaded project has an IVML file as follows:
     * <pre>
     * Integer a;
     * Integer b;
     * a = 5;
     * b = (a + 1);
     * </pre>
     * The reasoner should find a value for <tt>b</tt>.
     * @throws PersistenceException Must not occur, otherwise the config files inside the toplevel location are corrupt.
     */
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
        ReasoningListener rListener = new ReasoningListener() {
            
            @Override
            void afterReasoning(ReasoningResult result) {
                Assert.assertEquals(0, result.getMessageCount());
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
        Assert.assertEquals(new Integer(6), varB.getValue().getValue());
    }
}
