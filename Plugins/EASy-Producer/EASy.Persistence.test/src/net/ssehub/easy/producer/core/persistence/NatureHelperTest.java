package net.ssehub.easy.producer.core.persistence;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.producer.core.AllTests;
import net.ssehub.easy.producer.core.persistence.standard.NatureHelper;

/**
 * TestCases for the NatureHelper.
 * Add-, Remove- and hasNature - Method are tested.
 * 
 * @author Niko Nowatzki
 * @author Holger Eichelberger
 */
public class NatureHelperTest {

    private static final File ORIGINAL_PROJECT = new File(AllTests.TESTDATA_DIR_ORIGINS, "natures");
    
    /**
     * Defines the original file to test for.
     */
    private static final File ORIGINAL_FILE = new File(ORIGINAL_PROJECT, NatureHelper.FILE_NAME);
    
    /**
     * Defines a nature, here the java nature matching the content in the test files.
     */
    private static final String JAVA_NATURE = "org.eclipse.jdt.core.javanature";

    /**
     * Defines a nature, here the plugin nature matching the content in the test files.
     */
    private static final String PLUGIN_NATURE = "org.eclipse.pde.PluginNature";
    
    /**
     * Defines a nature, here the checkstyle nature matching the content in the test files.
     */
    private static final String CHECKSTYLE_NATURE = "net.sf.eclipsecs.core.CheckstyleNature";
    
    /**
     * Defines an additional nature. This must not be the actual EASy nature but match the content in the test files.
     */
    private static final String EASY_NATURE = "de.uni-hildesheim.sse.easyNature";
    
    /**
     * Prepares the "project" for testing.
     * 
     * @return a temporary copy of the project related testing data
     * 
     * @throws IOException in case that preparation fails
     */
    private static File prepareProject() throws IOException {
        File result = new File(AllTests.TESTDATA_DIR_COPY, "natures");
        result.mkdirs();
        Utils.copyFile(ORIGINAL_FILE, getProjectFile(result));
        return result;
    }

    /**
     * Returns the actual project file in <code>project</code>.
     * 
     * @param project the project folder
     * @return the "project file"
     */
    private static File getProjectFile(File project) {
        return new File(project, ORIGINAL_FILE.getName());
    }
    
    /**
     * Deletes the given "project".
     * 
     * @param project the project to be deleted
     * @throws IOException in case that deletion fails
     */
    private static void deleteProject(File project) throws IOException {
        File f = new File(project, ORIGINAL_FILE.getName());
        if (f.exists()) {
            f.delete();
        }
        project.delete();
    }

    /**
     * Test the presence of natures.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testHasNature() throws IOException {
        File project = prepareProject();
        File projectFile = getProjectFile(project);

        // exists
        Assert.assertTrue("checking for java nature", 
            NatureHelper.hasNature(project, JAVA_NATURE));
        Utils.assertEquals("checking file after hasNature", ORIGINAL_FILE, projectFile, true);

        // exists            
        Assert.assertTrue("checking for plugin nature", 
            NatureHelper.hasNature(project, PLUGIN_NATURE));
        Utils.assertEquals("checking file after hasNature", ORIGINAL_FILE, projectFile, true);

        // does not exist
        Assert.assertFalse("checking for EASy nature", 
            NatureHelper.hasNature(project, EASY_NATURE));
        Utils.assertEquals("checking file after hasNature", ORIGINAL_FILE, projectFile, true);
        
        deleteProject(projectFile);
    }
        
    /**
     * Test the remove-function of natures.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testRemoveNature() throws IOException {
        File project = prepareProject();
        File projectFile = getProjectFile(project);

        // no effect
        NatureHelper.removeNature(project, EASY_NATURE);
        Utils.assertEquals("checking file after removing EASy nature", ORIGINAL_FILE, 
            projectFile, true);

        File expected = new File(ORIGINAL_PROJECT, ".project_remove1");
        // shall remove
        NatureHelper.removeNature(project, JAVA_NATURE);
        Utils.assertEquals("checking file after removing Java nature", expected, projectFile, true);
        // no effect
        NatureHelper.removeNature(project, EASY_NATURE);
        Utils.assertEquals("checking file after removing EASy nature", expected, projectFile, true); 

        expected = new File(ORIGINAL_PROJECT, ".project_remove2");
        // shall remove
        NatureHelper.removeNature(project, PLUGIN_NATURE);
        Utils.assertEquals("checking file after removing Plugin nature", expected, projectFile, true);
        // no effect
        NatureHelper.removeNature(project, EASY_NATURE);
        Utils.assertEquals("checking file after removing EASy nature", expected, projectFile, true); 

        expected = new File(ORIGINAL_PROJECT, ".project_remove3");
        // shall remove
        NatureHelper.removeNature(project, CHECKSTYLE_NATURE);
        Utils.assertEquals("checking file after removing Checkstyle nature", expected, projectFile, true);
        // no effect
        NatureHelper.removeNature(project, EASY_NATURE);
        Utils.assertEquals("checking file after removing EASy nature", expected, projectFile, true); 

        deleteProject(projectFile);
    }
    
    /**
     * Test the add-function of natures.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testAddNature() throws IOException {
        File project = prepareProject();
        File projectFile = getProjectFile(project);

        // no effect
        NatureHelper.addNature(project, JAVA_NATURE);
        Utils.assertEquals("checking file after adding EASy nature", ORIGINAL_FILE, projectFile, true);


        File expected = new File(ORIGINAL_PROJECT, ".project_add1");
        NatureHelper.addNature(project, EASY_NATURE);
        Utils.assertEquals("checking file after adding EASy nature", expected, projectFile, true);

        // no effect
        NatureHelper.addNature(project, EASY_NATURE);
        Utils.assertEquals("checking file after adding EASy nature", expected, projectFile, true);
        NatureHelper.addNature(project, JAVA_NATURE);
        Utils.assertEquals("checking file after adding EASy nature", expected, projectFile, true);
        
        expected = new File(ORIGINAL_PROJECT, ".project_add0.1");
        Utils.copyFile(new File(ORIGINAL_PROJECT, ".project_add0"), projectFile);
        NatureHelper.addNature(project, EASY_NATURE);
        Utils.assertEquals("checking file after adding EASy nature", expected, projectFile, true);

        deleteProject(projectFile);
    }
    
}
