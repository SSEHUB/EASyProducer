package net.ssehub.easy.varModel.varModel.management;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.ModelEvents;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.IProjectListener;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;

/**
 * Testcases for the varmodel.
 * @author lueder
 * @author Holger Eichelberger
 */
public class VarModelTest implements IProjectListener {

    private Project pro1;
    private Project pro2;
    private Project pro3;
    private VarModel vm;
    private ModelEvents<Project> events;
    private ProjectImport imp;
    private Project lastNotifiedOld;
    private Project lastNotifiedNew;
    
    /**
     * Sets up the project before the test runs.
     * @throws VersionFormatException 
     */
    @Before
    public void setUp() throws VersionFormatException {
        pro1 = new Project("Name1");
        pro2 = new Project("Name2");
        pro3 = new Project("Name1");
        Version version = new Version("1");
        pro1.setVersion(version);
        pro2.setVersion(version);
        pro3.setVersion(version);
        
        vm = VarModel.INSTANCE;
        events = vm.events();
        
        imp = new ProjectImport("Name1", "Interface");
        pro3.addImport(imp);
    }

    /**
     * Creating a varmodel block.
     */
    @Test
    public void creatingVarModel() {
        events.addModelListener(pro1, this);
        events.addModelListener(pro2, this);
        events.addModelListener(pro3, this);
        
        Assert.assertEquals(0, vm.getModelCount());
        
        File root = new File(".");
        File pro1F = new File(root, "1.ivml");
        File pro2F = new File(root, "2.ivml");
        File pro3F = pro1F; // testing updates
        
        vm.updateModel(pro1, pro1F.toURI()); 
        Assert.assertEquals(1, vm.getModelCount());
        assertNotified(null, null); // nothing happens as no change!
        
        vm.updateModel(pro2, pro2F.toURI());         
        Assert.assertEquals(2, vm.getModelCount());
        assertNotified(null, null); // nothing happens as no change!
        
        vm.updateModel(pro3, pro3F.toURI());         
        Assert.assertEquals(2, vm.getModelCount());
        assertNotified(pro1, pro3);
        
        Assert.assertNotSame(pro1, vm.getModel(0));
        Assert.assertEquals(pro3, vm.getModel(0));
        
        Assert.assertTrue(!events.removeModelListener(pro1, this)); // false as pro1 was replaced
        Assert.assertTrue(events.removeModelListener(pro2, this));  // true as pro2 is still there
        Assert.assertTrue(events.removeModelListener(pro3, this));  // true as pro3 is still there
        
        //SE: Folder which contains files and no system specific folders like recycle.bin
        File file = new File(".");
        try {
            vm.locations().addLocation(file, ProgressObserver.NO_OBSERVER);
            // TODO HE: this will typically work as no loader is defined. A loader shall not be defined for an 
            // entire disk (time consuming) but rather for a very specific test directory
            vm.locations().removeLocation(file, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail("unexpected exception " + e.getMessage()); // shall not happen
        }
    }
    
    // moved testUpdateProjectInformation to ivml.tests as the IVML loader is required!
    // cannot be tested here as most of the management functions in VarModel
    
    @Override
    public void notifyReplaced(Project oldProject, Project newProject) {
        lastNotifiedOld = oldProject;
        lastNotifiedNew = newProject;
    }
    
    /**
     * Checks the notified projects and clears the associated attributes.
     * 
     * @param oldProject the expected value for {@link #lastNotifiedOld}
     * @param newProject the expected value for {@link #lastNotifiedNew}
     */
    private void assertNotified(Project oldProject, Project newProject) {
        Assert.assertTrue(newProject == lastNotifiedNew);
        Assert.assertTrue(oldProject == lastNotifiedOld);
        
        lastNotifiedNew = null;
        lastNotifiedOld = null;
    }
    
    /**
     * Tests unloading using a specific in-memory model loader.
     * 
     * @throws ModelManagementException in case of problems in the var model
     */
    @Test
    public void testUnloading() throws ModelManagementException {
        UnloadTestModelLoader.performTests();
    }

}
