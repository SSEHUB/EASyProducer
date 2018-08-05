package net.ssehub.easy.producer.scenario_tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test Suite, which starts all individual test cases.
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    ScenarioRampUpTest.class, // must be first
    RealTests.class, 
    DynamicFreezeTest.class, 
    ConceptsTests.class, 
    ExperimentsTests.class, 
    ExperimentsControlTests.class})
public class AllTests {
}
