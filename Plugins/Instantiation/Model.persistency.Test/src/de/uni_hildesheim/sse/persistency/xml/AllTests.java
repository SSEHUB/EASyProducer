package de.uni_hildesheim.sse.persistency.xml;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for all XML tests.
 * 
 * @author Sass
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ 
//    ReadTest.class, 
//    WriteTest.class, 
    VilPersistencyTest.class, 
    VtlPersistencyTest.class,
    SerializeQM2ModelTest.class,
    ExecuteQM2ModelFromXMLTest.class,
})
public class AllTests {

}
