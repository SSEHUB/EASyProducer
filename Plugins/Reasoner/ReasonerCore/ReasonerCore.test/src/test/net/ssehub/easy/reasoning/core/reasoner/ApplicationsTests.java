package test.net.ssehub.easy.reasoning.core.reasoner;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.Project;

/**
 * Defines application tests.
 * 
 * @author Eichelberger
 */
public class ApplicationsTests extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected ApplicationsTests(ITestDescriptor descriptor) {
        super(descriptor, "applications");
    }

    /**
     * Failing SimElevator.
     */
    @Test
    public void plSimElevatorTestFail() {
        reasoningTest("PL_SimElevator_frozen_orig", 1); // reassignment
    }
    
    /**
     * Working SimElevator.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void plSimElevatorTest() throws IOException {
        Project p = loadCompleteProject("applications", "PL_SimElevator_frozen");
        resultHandler(0, 0, p);
    }
    
    /**
     * Tests staged in-project configuration.
     * 
     * @throws IOException shall not occur
     * @throws ModelQueryException shall not occur
     */
    @Test
    public void configuredDevicesTest() throws IOException, ModelQueryException {
        testDevices("ConfiguredDevices");
    }

    /**
     * Tests the devices staged in-project configuration.
     * 
     * @param model the model to load
     * @throws ModelQueryException shall not occur
     * @throws IOException shall not occur
     */
    private void testDevices(String model) throws ModelQueryException, IOException {
        Project p = loadCompleteProject("", model);
        Configuration cfg = resultHandler(0, 0, p);        
        IDecisionVariable var = cfg.getDecision("containerManager", false);
        Assert.assertNotNull(var);
        Assert.assertNotNull(var.getNestedElement("dockerHost").getValue());
        Assert.assertEquals("unix:///var/run/docker.sock", var.getNestedElement("dockerHost").getValue().getValue());
        Assert.assertNotNull(var.getNestedElement("dockerImageYamlFilename").getValue());
        Assert.assertEquals("image-info.yml", var.getNestedElement("dockerImageYamlFilename").getValue().getValue());
        Assert.assertNotNull(var.getNestedElement("deleteWhenUndeployed").getValue());
        Assert.assertEquals(false, var.getNestedElement("deleteWhenUndeployed").getValue().getValue());        
    }
    
}
