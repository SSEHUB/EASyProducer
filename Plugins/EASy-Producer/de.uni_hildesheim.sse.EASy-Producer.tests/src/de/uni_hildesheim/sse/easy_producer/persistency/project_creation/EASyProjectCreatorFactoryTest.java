package de.uni_hildesheim.sse.easy_producer.persistency.project_creation;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import test.AllTests;
import test.de.uni_hildesheim.sse.easy_producer.mgmt.ResourcesMgmtTest;
import de.uni_hildesheim.sse.easy_producer.ProjectConstants;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.SPLsManager;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceUtils;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ExpressionStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.InstantiateExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.MapExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.easy_producer.persistency.ResourcesMgmt;
import de.uni_hildesheim.sse.model.confModel.AllFreezeSelector;
import de.uni_hildesheim.sse.model.varModel.Project;

/**
 * Tests the {@link EASyProjectCreatorFactory} for creating new EASy projects.
 * @author El-Sharkawy
 *
 */
public class EASyProjectCreatorFactoryTest {

    private static File workspace;
    private static Set<String> usedProjectNames = new HashSet<String>();
    
    /**
     * Copies projects of the testdata directory into the workspace, if it is not already done by the
     * AllTests test suite.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        
        /*
         * Some of the tests here, need that the projects of the testdata directory are imported.
         * This is done by the ResourcesMgmtTest.setUpBeforeClass() method.
         * This will be done once if the test suite is executed, otherwise it will be done here ;-)
         */    
        ResourcesMgmtTest.setUpBeforeClass();    
        
        // Import and open all projects in workspace (must be done independently of the step before)
        IWorkspaceRoot wsRoot = ResourcesMgmt.INSTANCE.getWorkspace().getRoot();
        workspace = ResourcesMgmt.INSTANCE.getWorspaceFolder();
        File[] childs = workspace.listFiles();
        for (File child : childs) {
            if (!".metadata".equals(child.getName())) {
                IProject project = wsRoot.getProject(child.getName());
                try {
                    project.create(null);
                    project.open(null);
                    usedProjectNames.add(project.getName());
                } catch (CoreException e) {
                    Assert.fail(e.getLocalizedMessage());
                }
            }
        }        
    }
    
    /**
     * Helping method for testing valid/invalid project names.
     * @param expectedType The expected {@link ValidProjectNameType} for the given projectName
     * @param projectName A name to test.
     */
    private void isValidNameTest(ValidProjectNameType expectedType, String projectName) {
        Assert.assertSame(expectedType, EASyProjectCreatorFactory.isValidProjectName(projectName));
    }
    
    /**
     * Helping method for creating a new {@link ProductLineProject}.
     * Use this method only for testing and only with valid project names.
     * @param name The name of the project to create.
     * @param predecessorID Optional: The projectID for a predecessor. If <tt>null</tt> a project without a predecessor
     *     will be created.
     * @return The newly created {@link ProductLineProject}.
     */
    private ProductLineProject createProject(String name, String predecessorID) {
        Assert.assertFalse("Error: Project name used twice", usedProjectNames.contains(name));
        ProductLineProject plp = null;
        try {
            SRCFolderConfigurator configurator = new SRCFolderConfigurator();
            plp = EASyProjectCreatorFactory.createNewProject(name, predecessorID, false,
                configurator);
            configurator.checkExecution();
        } catch (ProjectCreationException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        
        Assert.assertNotNull("Error: No project was created", plp);
        usedProjectNames.add(name);
        
        return plp;
    }
    
    /**
     * Helping method for finding a project which is already imported (copied) into the workspace.
     * @param projectName the name of the desired project, must be located inside testdata directory.
     * @return The specified project.
     */
    private PLPInfo getPLPInfoByName(String projectName) {
        PLPInfo plp = null;
        
        for (PLPInfo info : SPLsManager.INSTANCE.getProductLineProjects().values()) {
            if (projectName.equals(info.getProjectName())) {
                plp = info;
            }
        }
        
        Assert.assertNotNull("Error: Specified project could not be found!", plp);
        return plp;
    }
    
    /**
     * Tests whether invalid IVML identifier could be used for creating an EASy project (should not be possible).
     */
    @Test
    public void testInValidNames() {
        String[] invalidIdentifiers = {"", "&", "%", "Hello World", "1"};       
        
        // Test at least one correct name
        isValidNameTest(ValidProjectNameType.VALID, "A_Project");
        isValidNameTest(ValidProjectNameType.VALID, "Project1");
        
        // Test invalid IVML identifier
        for (String projectName : invalidIdentifiers) {
            isValidNameTest(ValidProjectNameType.INVALID_IDENTIFIER, projectName);
            boolean exceptionThrown = false;
            try {
                EASyProjectCreatorFactory.createNewProject(projectName, null, true, (IEASyProjectConfigurator[]) null);
                Assert.fail("Error: Invalid IVML Identifier could be used as a project name. Name = " + projectName);
            } catch (ProjectAlreadyExistsException e) {
                Assert.fail("Error: wrong exception thrown. Exception: " + e.getMessage());
            } catch (InvalidProjectnameException e) {
                exceptionThrown = true;
                Assert.assertSame(ValidProjectNameType.INVALID_IDENTIFIER, e.getReason());
            } catch (ProjectCreationException e) {
                Assert.fail("Error: wrong exception thrown. Exception: " + e.getMessage());
            }
            
            Assert.assertTrue("Error: expected exception was not thrown.", exceptionThrown);
        }
    }
    
    /**
     * Tests whether project names, which are already used, could be used twice.
     * 
     * @param lazy wheter lazy project creation shall be tested
     */
    private void testAlreadyExistingProjectNames(boolean lazy) {
        Assert.assertFalse("Error: at least one project should be inside the testdata directory, otherwise this test "
            + "is useless", usedProjectNames.isEmpty());
        
        for (String projectName : usedProjectNames) {
            isValidNameTest(ValidProjectNameType.ALREADY_EXISTS, projectName);
            boolean exceptionThrown = false;
            try {
                EASyProjectCreatorFactory.createNewProject(projectName, null, lazy, (IEASyProjectConfigurator[]) null);
                if (!lazy) {
                    Assert.fail("Error: Already used project name could be used twice. Name = " + projectName);
                } else {
                    /*
                     * Last line checks whether an exception was thrown.
                     * If lazy is true, the check should be ignored.
                     */
                    exceptionThrown = true;
                }
            } catch (ProjectAlreadyExistsException e) {
                Assert.assertSame(ValidProjectNameType.ALREADY_EXISTS, e.getReason());
                exceptionThrown = true;
            } catch (InvalidProjectnameException e) {
                Assert.fail("Error: wrong exception thrown. Exception: " + e.getMessage());
            } catch (ProjectCreationException e) {
                Assert.fail("Error: wrong exception thrown. Exception: " + e.getMessage());
            }
            
            Assert.assertTrue("Error: expected exception was not thrown.", exceptionThrown);
        }
    }

    /**
     * Tests whether project names, which are already used, could be used twice.
     */
    @Test
    public void testAlreadyExistingProjectNames() {
        testAlreadyExistingProjectNames(true);
        testAlreadyExistingProjectNames(false);
    }

    /**
     * Test correct creation of new projects, which do not have any predecessors.
     */
    @Test
    public void testCreationOfNotDerivedProject() {
        String projectName = "A_new_Project_without_predecessors";
        
        // Check precondition: Project must not exist
        for (PLPInfo info : SPLsManager.INSTANCE.getProductLineProjects().values()) {
            if (projectName.equals(info.getProjectName())) {
                Assert.fail("Error: Project which should be created, exists before creation.");
            }
        }
        
        // Create project
        ProductLineProject plp = createProject(projectName, null);
        
        // Test postcondition: Project should be created without predecessor
        Assert.assertNotNull(plp.getProjectID());
        PLPInfo info = SPLsManager.INSTANCE.getPLP(plp.getProjectID());
        Assert.assertNotNull(info);
        Assert.assertSame(info, plp);
        Assert.assertFalse(plp.getMemberController().hasPredecessors());
        Assert.assertFalse(plp.getMemberController().hasSuccessors());
    }
    
    /**
     * Tests the correct creation of derived projects.
     */
    @Test
    public void testCreationOfDerivedProject() {
        String projectNamePre = "A_new_Project_for_derivation_predecessor";
        String projectNameSuc = "A_new_Project_for_derivation_successor";
        
        // Check precondition: Projects must not exist
        for (PLPInfo info : SPLsManager.INSTANCE.getProductLineProjects().values()) {
            if (projectNamePre.equals(info.getProjectName()) && projectNameSuc.equals(info.getProjectName())) {
                Assert.fail("Error: Project which should be created, exists before creation.");
            }
        }
        
        // Create project predecessor project (already tested in separate method)
        ProductLineProject plpPre = createProject(projectNamePre, null);
        Assert.assertFalse(plpPre.getMemberController().hasPredecessors());
        Assert.assertFalse(plpPre.getMemberController().hasSuccessors());
        
        // Create derived project (test object of this method)
        ProductLineProject plpSuc = createProject(projectNameSuc, plpPre.getProjectID());
        
        // Test postcondition: Project should be created with! predecessor
        Assert.assertNotNull(plpSuc.getProjectID());
        PLPInfo info = SPLsManager.INSTANCE.getPLP(plpSuc.getProjectID());
        Assert.assertNotNull(info);
        Assert.assertSame(info, plpSuc);
        Assert.assertTrue(plpSuc.getMemberController().hasPredecessors());
        Assert.assertFalse(plpSuc.getMemberController().hasSuccessors());
        // Predecessor should now have a successor
        Assert.assertTrue(plpPre.getMemberController().hasSuccessors());
    }
    
    /**
     * Tests the correct creation of derived projects, using the elevator example.
     * The existing VIL/IVML data of the existing predecessor must not be changed!
     */
    @Test
    public void testCreationOfDerivedProject2() {
        File originEASyFolder = new File(new File(AllTests.TESTDATA_DIR_ORIGINS, "PL_SimElevator"),
            ProjectConstants.EASY_FILES);
       
        PLPInfo plpPre = getPLPInfoByName("PL_SimElevator");
        
        /* 
         * Test precondition:
         *  - Predecessor has build script and variability model as defined inside the testdata directory.
         */
        File ivmlFilePre = new File(PersistenceUtils.ivmlFileLocation(plpPre.getProject(),
            plpPre.getConfigLocation().getAbsolutePath()));
        File vilFilePre = new File(PersistenceUtils.vilFileLocation(plpPre.getBuildScript(),
            plpPre.getScriptLocation().getAbsolutePath()));
        File ivmlFileOrg = new File(originEASyFolder, "PL_SimElevator_0.ivml");
        File vilFileOrg = new File(originEASyFolder, "PL_SimElevator_0.vil");
        testContents(ivmlFileOrg, ivmlFilePre);
        testContents(vilFileOrg, vilFilePre);

        // Derive new Product
        ProductLineProject plpSuc = createProject("New_derived_project", plpPre.getProjectID());
        
        /* 
         * Test postcondition:
         *  - Predecessor has build script and variability model as defined inside the testdata directory.
         *  - Successor files include files of predecessor
         */
        // Predecessor check
        testContents(ivmlFileOrg, ivmlFilePre);
        testContents(vilFileOrg, vilFilePre);
        // Successor check
        Project varModel = plpSuc.getProject();
        Assert.assertEquals(1, varModel.getImportsCount());
        Assert.assertEquals(plpPre.getProject().getName(), varModel.getImport(0).getName());
        Script script = plpSuc.getBuildScript();
        Assert.assertEquals(1, script.getImportsCount());
        Assert.assertEquals(plpPre.getProject().getName(), script.getImport(0).getName());
        Rule mainRule = script.getMainRule(false);
        Assert.assertEquals(1, mainRule.getBodyElementCount());
        ExpressionStatement statement = (ExpressionStatement) mainRule.getBodyElement(0);
        MapExpression expression = (MapExpression) statement.getExpression();
        Assert.assertEquals(1, expression.getBodyElementCount());
        ExpressionStatement mapBody = (ExpressionStatement) expression.getBodyElement(0);
        Assert.assertTrue(mapBody.getExpression() instanceof InstantiateExpression);       
    }
    
    /**
     * Tests whether a new derived {@link ProductLineProject} can be used for instantiation.
     * <ol>
     * <li>Loads an existing project (with complete and frozen config)</li>
     * <li>Derives new child from this project and freezes its configuration</li>
     * <li>Instantiates the newly created child</li>
     * </ol>
     */
    @Test
    public void testDerivationAndInstantiation() {
        PLPInfo plpPre = getPLPInfoByName("PL_SimElevator2");
        ProductLineProject plpSuc = createProject("New_derived_project2", plpPre.getProjectID());
        plpSuc.getConfiguration().freeze(AllFreezeSelector.INSTANCE);
        plpSuc.save();
        try {
            plpSuc.instantiate();
        } catch (VilException e) {
            Assert.fail("Error in instantiation: " + e.getLocalizedMessage());
        }
    }
    
    /**
     * Helping method for testing derivation.
     * Tests whether the content of the origin file and the file of the project in workspace are equal.
     * @param originFile A text file (e.g. IVML, VIL, or VTL) of the project inside the testdata directory. 
     * @param copiedFile A text file (e.g. IVML, VIL, or VTL) of the project inside workspace. 
     */
    private void testContents(File originFile, File copiedFile) {
        try {
            String originalContent = FileUtils.readFileToString(originFile).replace("\r", "").replace("\t", "    ");
            String copiedContent = FileUtils.readFileToString(copiedFile).replace("\r", "").replace("\t", "    ");
            Assert.assertEquals("Error: " + copiedFile.getAbsolutePath() + "was modiefied",
                originalContent, copiedContent);
        } catch (IOException e) {
            Assert.fail("Error in reading EASy files: " + e.getLocalizedMessage());
        }
    }
    
    /**
     * Tests whether a project can be derived from a PLP, be deleted, and derived again with the same name.
     * I.E.:
     * <code>
     * Derive project x. Delete project x (including deletion from harddisc).
     * Derive new project x will result in missing/empty IVML/VIL-files in the derived project.
     * </code>
     * Bug was detected at the CeBit 2014.
     */
    @Test
    public void testMultipleDerivation() {
        PLPInfo plpPre = getPLPInfoByName("ProjectForMultipleDerivation");
        String dervivedProjectName = "Successor_of_" + plpPre.getProjectName();
        File expectedLocation = new File(workspace, dervivedProjectName);
        
        // Test precondition: Project must not exist before
        Assert.assertFalse(expectedLocation.exists());
        
        // create derived project (No. 1)
        ProductLineProject plpSuc = createProject(dervivedProjectName, plpPre.getProjectID());
        
        // Test postcondition: Project must be created
        Assert.assertTrue(expectedLocation.exists());
        Assert.assertEquals(plpPre.getProjectID(), plpSuc.getMemberController().getPredecessorIDs().toArray()[0]);
        
        // Delete derived project
        usedProjectNames.remove(plpSuc.getProjectName());
        plpSuc.close();
        try {
            ResourcesPlugin.getWorkspace().getRoot().getProject(dervivedProjectName).delete(true, null);
        } catch (CoreException e) {
            e.printStackTrace();
        }
        FileUtils.deleteQuietly(expectedLocation);
        
        // Test precondition: Project must not exist before
        Assert.assertFalse(expectedLocation.exists());
        
        // Derive project again
        //checkstyle: stop exception type check
        try {
            plpSuc = createProject(dervivedProjectName, plpPre.getProjectID());
        } catch (Exception e) {
            Assert.fail("Error: It's not possible to derive 2 projects with the same name. Detailed message:\n"
                + e.getMessage());
        }
        //checkstyle: resume exception type check
        
        // Test postcondition: Project must be created
        Assert.assertTrue(expectedLocation.exists());
        Assert.assertEquals(plpPre.getProjectID(), plpSuc.getMemberController().getPredecessorIDs().toArray()[0]);
    }
}
