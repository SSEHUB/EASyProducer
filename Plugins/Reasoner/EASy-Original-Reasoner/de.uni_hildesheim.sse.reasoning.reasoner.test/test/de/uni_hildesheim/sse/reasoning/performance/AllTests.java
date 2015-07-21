package de.uni_hildesheim.sse.reasoning.performance;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Bundling all tests.
 * @author Sizonenko
 */
@RunWith(Suite.class)
@SuiteClasses({    
    GeneratedStats.class,
    HistoryStats.class
    })
public class AllTests {

}
