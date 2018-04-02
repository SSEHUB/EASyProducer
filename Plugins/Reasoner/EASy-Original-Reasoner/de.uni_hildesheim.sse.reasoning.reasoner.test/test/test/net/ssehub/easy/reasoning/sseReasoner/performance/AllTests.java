package test.net.ssehub.easy.reasoning.sseReasoner.performance;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Bundling all performance tests.
 * @author Sizonenko
 */
@RunWith(Suite.class)
@SuiteClasses({    
    GeneratedStats.class,
    HistoryStats.class
    })
public class AllTests {

}
