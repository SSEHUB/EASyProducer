package test.de.uni_hildesheim.sse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.persistency.IVMLWriter;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Tests model management functions in {@link VarModel} which require
 * the Model Loader provided by IVML.
 *  
 * @author Sascha El-Sharkawy
 * @author Holger Eichelberger
 */
public class VarModelTests extends AbstractTest {

    /**
     * Test whether the Varmodel.updateProjectInformation() method works correctly.
     * 
     * @throws IOException Occurs if files cannot be written into temp location of the OS.
     * @throws ModelManagementException If the {@link VarModel#updateModelInformation(File, ProgressObserver)} 
     *     has an error
     */
    @Test
    public void testUpdateProjectInformation() throws IOException, ModelManagementException {
        // Save precondition
        int projectCount = VarModel.INSTANCE.getModelCount();
        int locationCount = VarModel.INSTANCE.locations().getLocationCount();
        int infoCount = VarModel.INSTANCE.availableModels().getModelInfoCount(true);
        
        // Create one new Project for testing and save it in temp location
        String projectName = "Project_4_testUpdateProjectInformation";
        Project project = new Project(projectName);
        File ivmlFile = File.createTempFile(projectName, ".ivml");
        ivmlFile.deleteOnExit();
        FileWriter fileWriter = new FileWriter(ivmlFile);
        BufferedWriter bufWriter = new BufferedWriter(fileWriter);
        IVMLWriter writer = new IVMLWriter(bufWriter);
        project.accept(writer);
        bufWriter.flush();
        bufWriter.close();
        
        // Project/LocationCount must not be changed
        Assert.assertEquals(projectCount, VarModel.INSTANCE.getModelCount());
        Assert.assertEquals(locationCount, VarModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(infoCount, VarModel.INSTANCE.availableModels().getModelInfoCount(true));

        // PROBLEM: this test can never work as the loader instance is not configured!
        File destFolder = ivmlFile.getParentFile();
        // add the destination folder as location as otherwise models are not loaded
        VarModel.INSTANCE.locations().addLocation(destFolder, ProgressObserver.NO_OBSERVER);
        // Update ProjectInformation
        try {
            VarModel.INSTANCE.updateModelInformation(destFolder, ProgressObserver.NO_OBSERVER);
        } catch (NullPointerException npe) {
            Assert.fail("Unexpected NullpointerException occured while updating project information");
        }
        
        // project count must not be incremented as the project was not loaded!
        Assert.assertEquals(projectCount, VarModel.INSTANCE.getModelCount());
        // Test: ProjectInfo/LocationCount should be incremented by one
        Assert.assertEquals(++locationCount, VarModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(++infoCount, VarModel.INSTANCE.availableModels().getModelInfoCount(true));
    }
    
}
