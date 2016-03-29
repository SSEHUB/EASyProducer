package net.ssehub.easy.reasoning.sseReasoner.reasoner;

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
    EvaluationIntegrityTest.class,
    IntegrityTests.class,  
    ReasoningScenarioTests.class,
    StressTest.class,
    CodedTests.class,
    BooleanProblemTests.class
    })
public class AllTests {

}
