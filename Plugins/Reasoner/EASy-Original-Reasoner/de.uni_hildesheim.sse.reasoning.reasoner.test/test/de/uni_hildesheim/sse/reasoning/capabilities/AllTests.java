package de.uni_hildesheim.sse.reasoning.capabilities;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Tests for testing the reasoning capabilities.
 * @author Sizonenko
 */
@RunWith(Suite.class)
@SuiteClasses({    
    AttributeTests.class,  
    CollectionConstraintsTests.class,
    FailedDecisionsTests.class,
    RuntimeReasoningTests.class,
    OperationTests.class,
    CollectionOperationsTests.class,
    StructureTests.class
    })
public class AllTests {

}
