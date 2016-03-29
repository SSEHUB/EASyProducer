package net.ssehub.easy.sseReasoner.qm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Bundling all tests.
 * @author Sizonenko
 */
@RunWith(Suite.class)
@SuiteClasses({    
    QMValidTest.class,  
    QMHardwareTest1.class,
    QMHardwareTest2.class,
    QMHardwareTest3.class,
    QMAlgorithmsTest1.class,
    QMFamiliesTest1.class,
    QMFamiliesTest2.class,
    QMPipelinesTest1.class,
    QMScenarioTests.class,
    QMMismatchedTest.class
    })
public class AllTests {
    
}
