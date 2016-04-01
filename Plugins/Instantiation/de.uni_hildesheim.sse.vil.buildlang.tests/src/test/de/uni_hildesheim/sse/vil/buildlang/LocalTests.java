package test.de.uni_hildesheim.sse.vil.buildlang;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test Suite, which starts all individual test cases including local ones. It's fine if there are no tests
 * in this class :)
 * 
 * @author Holger Eichelberger
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BasicTests.class, LocalExecutionTests.class })
public class LocalTests {
}
