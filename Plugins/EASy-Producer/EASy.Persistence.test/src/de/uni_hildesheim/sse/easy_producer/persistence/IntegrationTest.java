package de.uni_hildesheim.sse.easy_producer.persistence;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.easy_producer.persistence.standard.PersistenceConstants;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.persistency.PersistencyConstants;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * This test case tests whether the plug-ins work correctly together, i.e. whether there are loaded correctly.
 * A failing tests does not necessary detect a failure inside the code, instead the manifest files or the activators
 * are maybe broken.
 * @author El-Sharkawy
 *
 */
public class IntegrationTest extends AbstractEASyTest {

    /**
     * Project for testing correct behavior of the {@link de.uni_hildesheim.sse.dslCore.ModelUtility}s.
     * Project will not be modified -> Project can be loaded from the origins folder. 
     */
    private static final File TEST_PROJECT_MODELUTILITY
        = new File(AllTests.TESTDATA_DIR_ORIGINS, "ModelUtilityTestProject");
    
    /**
     * this test checks whether the {@link de.uni_hildesheim.sse.dslCore.ModelUtility}s are loaded correctly.
     */
    @Test
    public void testModelUtilitiesConfiguredCorrectly() {
        // Files needed for the tests
        File easyFolder = new File(TEST_PROJECT_MODELUTILITY, PersistenceConstants.EASY_FILES_DEFAULT);
        String projectName = TEST_PROJECT_MODELUTILITY.getName();
        String fileName = projectName + "_0";
        File ivmlFile = new File(easyFolder, fileName + PersistencyConstants.PROJECT_FILE_ENDING);
//        File commentsFile = new File(easyFolder, fileName + PersistencyConstants.COMMENT_FILE_ENDING);
        File vilFile = new File(easyFolder, fileName
            + de.uni_hildesheim.sse.easy_producer.instantiator.model.PersistencyConstants.SCRIPT_FILE_ENDING);
        File vtlFile = new File(easyFolder, fileName
            + de.uni_hildesheim.sse.easy_producer.instantiator.model.PersistencyConstants.TEMPLATE_FILE_ENDING);
        Version version = new Version(0);
        
        // Precondition: Test that the Infos are NOT available
        ModelInfo<Project> ivmlInfo = VarModel.INSTANCE.availableModels().getModelInfo(projectName, version,
            ivmlFile.toURI());
        ModelInfo<Script> vilInfo = BuildModel.INSTANCE.availableModels().getModelInfo(projectName, version,
            vilFile.toURI());
        ModelInfo<Template> vtlInfo = TemplateModel.INSTANCE.availableModels().getModelInfo(projectName, version,
            vtlFile.toURI());
        Assert.assertNull(ivmlInfo);
        Assert.assertNull(vilInfo);
        Assert.assertNull(vtlInfo);

        // Try to load the ModelInfos
        try {
            PersistenceUtils.addLocation(easyFolder, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail(e.getLocalizedMessage());
        }
        
        // Postcondition: Test that Infos ARE available
        ivmlInfo = VarModel.INSTANCE.availableModels().getModelInfo(projectName, version, ivmlFile.toURI());
        vilInfo = BuildModel.INSTANCE.availableModels().getModelInfo(projectName, version, vilFile.toURI());
        vtlInfo = TemplateModel.INSTANCE.availableModels().getModelInfo(projectName, version, vtlFile.toURI());
        Assert.assertNotNull("IVML ModelUtility is not working correctly", ivmlInfo);
        Assert.assertNotNull("VIL ModelUtility is not working correctly", vilInfo);
        Assert.assertNotNull("VTL ModelUtility is not working correctly", vtlInfo);
    }

}
