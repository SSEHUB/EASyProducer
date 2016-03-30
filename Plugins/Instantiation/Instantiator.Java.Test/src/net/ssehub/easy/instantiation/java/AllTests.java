package net.ssehub.easy.instantiation.java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import net.ssehub.easy.instantiation.java.artifacts.JavaFileArtifactTest;

/**
 * Test Suite, which starts all individual test cases.
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ExecutionTests.class, JavaFileArtifactTest.class })
public class AllTests {
}
