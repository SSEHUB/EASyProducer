package test.de.uni_hildesheim.sse.plugin.wizards;

import java.io.File;
import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.easy.ui.project_management.InvalidProjectnameException;
import de.uni_hildesheim.sse.easy.ui.project_management.ProjectAlreadyExistsException;
import de.uni_hildesheim.sse.easy.ui.project_management.ProjectCreator;
import de.uni_hildesheim.sse.easy_producer.ProjectConstants;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.SPLsManager;
import de.uni_hildesheim.sse.easy_producer.persistence.standard.PersistenceConstants;
import de.uni_hildesheim.sse.easy_producer.persistency.ResourcesMgmt;

/**
 * Tests the creation of a new Project. First of all we test whether a newly created Test-Project contains everything it
 * needs. Moreover this Test-Case checks the error handling by intentionally creating Projects that already exists or
 * got an invalid name.
 * 
 * @author Nowatzki
 */
public class ProjectCreatorTest {

    // fields we will need in oder to create all necessary test-projects
    private static final String PROJECTNAME_SINGLE_PROJECT = "A_TEST_PROJECT_FOR_PROJECT_CREATION";
    private static final String PROJECTNAME_PRE = "A_TEST_PROJECT_FOR_DERIVATION_PREDECESSOR";
    private static final String PROJECTNAME_SUC = "A_TEST_PROJECT_FOR_DERIVATION_SUCCESSOR";
    private static final String PROJECTNAME_ALREADY_EXISTS = "PROJECTNAME_ALREADY_EXISTS";
    private static final String SEPERATOR = System.getProperty("file.separator");
    private static final String PROJECTNAME_VALID = "A_VALID_PROJECTNAME";
    private static final String PROJECTNAME_INVALID = "%&AN_INVALID_PROJECTNAME&%";

    // fields we will need in the method TearDown in order to clear the workspace after we are finished
    private static final IWorkspace WORKSPACE = ResourcesMgmt.INSTANCE.getWorkspace();
    private static final String WORKSPACE_LOCATION = WORKSPACE.getRoot().getLocation().toFile().getPath().toString();
    private static final String DIR = WORKSPACE_LOCATION + ResourcesMgmt.INSTANCE.getSeperator();

    /**
     * Part of the test methods. Fails if the project already exists or has an invalid name.
     * 
     * @param projectname projectname of the project, which should be created!
     * @return ProjectCreator or null (in this case the test would fail)
     */
    private PLPInfo createProject(String projectname) {

        ProjectCreator pc = null;

        try {
            // Create new project and handle Exceptions
            pc = new ProjectCreator(projectname, false);
        } catch (ProjectAlreadyExistsException e) {
            Assert.fail();
        } catch (InvalidProjectnameException e) {
            Assert.fail();
        }
        return pc.newPLP();
    }

    /**
     * Tests whether all files of a new project will be created.
     * 
     * @throws InvalidProjectnameException If the projectname is not valid.
     * @throws ProjectAlreadyExistsException If the project which should be created already exists.
     */
    @Test
    public void createProjectTest() throws InvalidProjectnameException, ProjectAlreadyExistsException {

        // Create a new file
        String path = Platform.getLocation().toFile().getAbsolutePath() + SEPERATOR + PROJECTNAME_SINGLE_PROJECT;
        File file = new File(path);

        // Folder should not exist before the creation has started

        // creation
        createProject(PROJECTNAME_SINGLE_PROJECT);

        // Now the file should exist
        Assert.assertTrue(file.exists());

        // Now all Folders and configuration-files should exist
        Assert.assertTrue(file.exists());
        Assert.assertTrue(file.isDirectory());
        file = new File(path + SEPERATOR + ProjectConstants.FOLDER_LIBS);
        Assert.assertTrue(file.exists());
        Assert.assertTrue(file.isDirectory());
        file = new File(path + SEPERATOR + ProjectConstants.FOLDER_RES);
        Assert.assertTrue(file.exists());
        Assert.assertTrue(file.isDirectory());
        file = new File(path + SEPERATOR + "bin");
        Assert.assertTrue(file.exists());
        Assert.assertTrue(file.isDirectory());
        file = new File(path + SEPERATOR + "EASy" + SEPERATOR + PersistenceConstants.CONFIG_FILE);
        Assert.assertTrue(file.exists());
        Assert.assertTrue(file.isFile());
        file = new File(path + SEPERATOR + ".classpath");
        Assert.assertTrue(file.exists());
        Assert.assertTrue(file.isFile());
        file = new File(path + SEPERATOR + ".project");
        Assert.assertTrue(file.exists());
        Assert.assertTrue(file.isFile());
        file = new File(path);
        // Check wether everything is where it belongs
        Assert.assertEquals(7, file.listFiles().length);
    }

    /**
     * Test whether a derived PTN is a successor of the parent PTN.
     */
    @Test
    public void derivePTNTest() {
        // creation
        PLPInfo plp = createProject(PROJECTNAME_PRE);
        PLPInfo ptnPre = SPLsManager.INSTANCE.getPLP(plp.getProjectID());

        // At this time the PTN has no prede-/successors!
        Assert.assertFalse(ptnPre.getMemberController().hasPredecessors());
        Assert.assertFalse(ptnPre.getMemberController().hasSuccessors());

        // Derivation of a new PTN
        ProjectCreator pc = null;
        try {
            pc = new ProjectCreator(PROJECTNAME_SUC);
        } catch (InvalidProjectnameException e) {
            Assert.fail();
        } catch (ProjectAlreadyExistsException e) {
            Assert.fail();
        }
        PLPInfo plpSuc = pc.deriveNewPLP(ptnPre.getProjectID());
        PLPInfo ptnSuc = SPLsManager.INSTANCE.getPLP(plpSuc.getProjectID());

        // Old PTN should have exactly one successor
        Assert.assertFalse(ptnPre.getMemberController().hasPredecessors());
        Assert.assertTrue(ptnPre.getMemberController().hasSuccessors());
        Assert.assertEquals(1, ptnPre.getMemberController().getSuccessorsCount());
        Iterator<String> idsiterator = ptnPre.getMemberController().getSuccessorIDs().iterator();
        Assert.assertEquals(ptnSuc.getProjectID(), idsiterator.next());

        // New PTN should have exactly one Predecessor
        Assert.assertTrue(ptnSuc.getMemberController().hasPredecessors());
        Assert.assertFalse(ptnSuc.getMemberController().hasSuccessors());
        Assert.assertEquals(1, ptnSuc.getMemberController().getPredecessors().size());
        Assert.assertEquals(ptnPre.getProjectID(), ptnSuc.getMemberController().getPredecessorIDs().iterator().next());
    }

    /**
     * Tests what happens if a project should be created with a name which already exists inside the workspace.
     * 
     * @throws InvalidProjectnameException If the projectname is not valid.
     */
    @Test
    public void projectAlreadyExistsTest() throws InvalidProjectnameException {
        // Project should not exist
        Assert.assertFalse(ProjectCreator.projectExists(PROJECTNAME_ALREADY_EXISTS));

        // creation
        createProject(PROJECTNAME_ALREADY_EXISTS);

        // Test whether the project exists
        Assert.assertTrue(ProjectCreator.projectExists(PROJECTNAME_ALREADY_EXISTS));

        // In this case an exception should appear
        boolean exceptionOccur = false;
        try {
            new ProjectCreator(PROJECTNAME_ALREADY_EXISTS);
            Assert.fail();
        } catch (ProjectAlreadyExistsException e) {
            exceptionOccur = true;
        }
        Assert.assertTrue(exceptionOccur);

        // Test with other constructor
        try {
            new ProjectCreator(PROJECTNAME_ALREADY_EXISTS, false);
            Assert.fail();
        } catch (ProjectAlreadyExistsException e) {
            exceptionOccur = true;
        }
        Assert.assertTrue(exceptionOccur);
    }

    /**
     * Tests what happens if a project with an invalid name is up to be created.
     */
    @Test
    public void invalidProjectnameTest() {

        // Project should not exist at this moment
        Assert.assertFalse(ProjectCreator.projectExists(PROJECTNAME_INVALID));

        // Creation

        boolean fail = true;
        try {
            // Create new project and handle Exceptions
            new ProjectCreator(PROJECTNAME_INVALID, false);
            Assert.fail();
        } catch (ProjectAlreadyExistsException e) {
            Assert.fail();
        } catch (InvalidProjectnameException e) {
            fail = false;
        }
        Assert.assertFalse(fail);
    }

    /**
     * Test the creation with a valid name.
     */
    @Test
    public void testValidProjectname() {
        // Project should not exist
        Assert.assertFalse(ProjectCreator.projectExists(PROJECTNAME_VALID));

        // Creation
        createProject(PROJECTNAME_VALID);

        // Tests wether the project exists
        Assert.assertTrue(ProjectCreator.projectExists(PROJECTNAME_VALID));
        // Thats ok because the name is valid!!!
    }

    /**
     * Clears the workspace after the finished test.
     */
    @AfterClass
    public void tearDown() {
        File dest = new File(DIR);

        for (File file : dest.listFiles()) {
            String name = file.getName();
            IProject project = WORKSPACE.getRoot().getProject(name);
            if (project.exists()) {
                try {
                    project.close(null);
                } catch (CoreException e) {
                    e.printStackTrace();
                }
                deleteFile(file);
            }
        }
    }

    /**
     * Help-Method for the TearDown in oder to clear the workspace after this Test-Case is finished.
     * 
     * @param file file which will be deleted.
     */
    public static void deleteFile(File file) {
        if (file.isDirectory()) {
            File[] nestedFiles = file.listFiles();
            if (null != nestedFiles) {
                for (int i = 0; i < nestedFiles.length; i++) {
                    deleteFile(nestedFiles[i]);
                }
            }
        }
        file.delete();
    }
}
