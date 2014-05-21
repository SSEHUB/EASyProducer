package test.de.uni_hildesheim.sse.reasoner.jess;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * Test Suite for running all test cases. <br/>
 * this test suite is for simplifying local testing of all test cases, and is
 * not used on the CruiseControl server. Please insert all test cases to this
 * test suite for simplify testing.
 * 
 * @author Phani
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({
    OperationTests.class,
    
    // old stuff
// varModel test
    SampleTest.class 
})
public class AllTests {

}