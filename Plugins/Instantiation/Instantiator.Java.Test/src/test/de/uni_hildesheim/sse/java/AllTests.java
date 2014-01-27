package test.de.uni_hildesheim.sse.java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.de.uni_hildesheim.sse.java.artifacts.JavaFileArtifactTest;

/**
 * Test Suite, which starts all individual test cases.
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ExecutionTests.class, JavaFileArtifactTest.class })
public class AllTests {
}
