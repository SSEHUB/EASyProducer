package de.uni_hildesheim.sse.reasoning;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for automated test execution on build server.
 * Do not forget to add new test suites here.
 * @author Sizonenko
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
    de.uni_hildesheim.sse.reasoning.capabilities.AllTests.class,
    // Skip: performance in automatic testing 
    de.uni_hildesheim.sse.reasoning.qm.AllTests.class,
    de.uni_hildesheim.sse.reasoning.reasoner.AllTests.class
    })
public class AllTests {

}
