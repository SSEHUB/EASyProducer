package de.uni_hildesheim.sse.reasoning.qm;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.reasoning.reasoner.Engine;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Bundling all tests.
 * @author Sizonenko
 */
@RunWith(Suite.class)
@SuiteClasses({    
    QMValidTest.class,  
    QMHardwareTest1.class,
    QMHardwareTest2.class,
    QMHardwareTest3.class,
    QMAlgorithmsTest1.class,
    QMFamiliesTest1.class,
    QMFamiliesTest2.class,
    QMPipelinesTest1.class,
    QMScenarioTests.class
    })
public class AllTests {
    
    
    /**
     * Method for handling reasoning result.
     * @param expectedFailedConstraints Number of constraints that are expected to fa
     * @param projectP1 Project to reason on.
     */
    static void resultHandler(int expectedFailedConstraints, Project projectP1) {
        Configuration config = new Configuration(projectP1, false);        
        ReasonerConfiguration rConfig = new ReasonerConfiguration();

        // Perform reasoning
        Engine engine = new Engine(projectP1, config, rConfig, ProgressObserver.NO_OBSERVER);
        ReasoningResult result = engine.reason();
        
        // Test whether reasoning detected correct result  
        int failedConstraints = 0;
        for (int i = 0; i < result.getMessageCount(); i++) {
            if (result.getMessage(i).getStatus() == Status.ERROR) {
                failedConstraints = failedConstraints + result.getMessage(i).getConflicts().size();
            }
        }
        Assert.assertEquals("Failed constraints: ", expectedFailedConstraints, failedConstraints);
    }  

}
