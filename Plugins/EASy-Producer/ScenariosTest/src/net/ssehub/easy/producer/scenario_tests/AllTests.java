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
    ScenarioRampUpTest.class, // must be first as it disables testdata as default IVML location
    RealTests.class, // must be second as it disables testdata as default IVML location
    DynamicFreezeTest.class, 
    ConceptsTests.class, 
    ExperimentsTests.class, 
    ExperimentsControlTests.class})
public class AllTests {
}
