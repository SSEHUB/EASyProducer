package test.net.ssehub.easy.reasoning.core.reasoner;

import java.io.IOException;

import org.junit.Test;

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
    
}
