package de.uni_hildesheim.sse.reasoning.drools;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Bundling all tests
 * @author Phani
 *
 */

@RunWith(Suite.class)
@SuiteClasses({
    OperationTests.class,
    
    
    // old to be checked
//    DroolsAssignmentsTest.class, DroolsSimpleConstraintsTest.class, DroolsCompoundConstraints.class,
//    DroolsAttributesTest.class, DroolsProjectImportTest.class,
    
    // fail
    // DroolsContainerTest.class, 
    //DroolsAdvancedConceptsTest.class, DroolsValuePropagationTest.class
    })
public class AllTests {

}
