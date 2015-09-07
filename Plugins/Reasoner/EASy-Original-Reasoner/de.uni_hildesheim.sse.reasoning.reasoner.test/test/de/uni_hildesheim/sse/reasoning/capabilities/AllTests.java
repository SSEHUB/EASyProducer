package de.uni_hildesheim.sse.reasoning.capabilities;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Bundling all tests.
 * @author Sizonenko
 */
@RunWith(Suite.class)
@SuiteClasses({    
    AttributeTests.class,  
    CollectionConstraintsTests.class,
    FailedDecisionsTests.class,
    RuntimeReasoningTests.class
    })
public class AllTests {

}
