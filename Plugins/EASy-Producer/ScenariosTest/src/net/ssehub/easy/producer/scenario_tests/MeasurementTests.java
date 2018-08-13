package net.ssehub.easy.producer.scenario_tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test Suite, which starts all measurement test cases including local ones. 
 * 
 * @author Holger Eichelberger
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    ScenarioRampUpTest.class, // must be first
    RealMeasurementsTests.class})
public class MeasurementTests {
}
