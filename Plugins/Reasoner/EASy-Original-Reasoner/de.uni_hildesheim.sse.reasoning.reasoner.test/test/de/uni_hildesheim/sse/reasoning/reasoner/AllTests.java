package de.uni_hildesheim.sse.reasoning.reasoner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Bundling all tests.
 * @author Sizonenko
 * @author El-Sharkawy
 */
@RunWith(Suite.class)
@SuiteClasses({    
    IntegrityTests.class,  
    ReasoningScenarioTests.class
    })
public class AllTests {

}
