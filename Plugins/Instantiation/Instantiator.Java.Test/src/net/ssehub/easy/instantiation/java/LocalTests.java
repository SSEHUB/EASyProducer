package net.ssehub.easy.instantiation.java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test Suite, which starts all individual test cases including local ones. It's fine if there are no tests
 * in this class :)
 * 
 * @author Holger Eichelberger
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({LocalExecutionTests.class })
public class LocalTests {
}
