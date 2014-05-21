package de.uni_hildesheim.sse.easy_producer.core.mgmt;

import java.io.File;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the correct behavior of the {@link SPLsManager}.
 * @author El-Sharkawy
 *
 */
public class SPLsManagerTest {

    /**
     * Tests the correct functionality of the AddPLP Method.
     */
    @Test
    public void testAddPLP() {
        SPLsManager manager = SPLsManager.INSTANCE;
        
        // Save precondition:
        int savedPLPs = manager.getProductLineProjects().size();
        
        // Add a PLP
        String name = "Project_A";
        String userHome = System.getProperty("user.home");
        File home = new File(userHome, name);
        PLPInfo plp = new PLPInfo(UUID.randomUUID().toString() , name, "0", home);
        manager.addPLP(plp);
        
        // Test postcondition: The new PLP should be added
        Assert.assertEquals(savedPLPs + 1, manager.getProductLineProjects().size());
        boolean found = false;
        for (PLPInfo onePLP : manager.getProductLineProjects().values()) {
            if (onePLP == plp) {
                found = true;
            }
        }
        Assert.assertTrue("The newly created plp wasn't found inside the SPLsManager.", found);
    }
    
    /**
     * Tests the correct functionality of the removePLP Method.
     */
    @Test
    public void testRemovePLP() {
        SPLsManager manager = SPLsManager.INSTANCE;
        
        // Save precondition:
        int savedPLPs = manager.getProductLineProjects().size();
        
        // Add a PLP
        String name = "Project_B";
        String userHome = System.getProperty("user.home");
        File home = new File(userHome, name);
        String plpID = UUID.randomUUID().toString();
        PLPInfo plp = new PLPInfo(plpID , name, "0", home);
        manager.addPLP(plp);
        savedPLPs++;
        Assert.assertEquals(savedPLPs, manager.getProductLineProjects().size());
        
        
        // Test postcondition: The new PLP should be added
        boolean found = false;
        manager.removePLP(plpID);
        savedPLPs--;
        for (PLPInfo onePLP : manager.getProductLineProjects().values()) {
            if (onePLP == plp) {
                found = true;
            }
        }
        Assert.assertEquals(savedPLPs, manager.getProductLineProjects().size());
        Assert.assertFalse("The newly created plp wasn't remove inside the SPLsManager.", found);
    }
    
    /**
     * Tests the correct functionality of the getProjectPath Method.
     */
    @Test
    public void testGetProjectPath() {
        SPLsManager manager = SPLsManager.INSTANCE;
        
        // Add a PLP
        String name = "Project_C";
        String userHome = System.getProperty("user.home");
        File home = new File(userHome, name);
        String plpID = UUID.randomUUID().toString();
        PLPInfo plp = new PLPInfo(plpID , name, "0", home);
        manager.addPLP(plp);
        
        String projectPath = manager.getProjectPath(plpID);
        Assert.assertEquals(home.getPath(), projectPath);
    }

}
