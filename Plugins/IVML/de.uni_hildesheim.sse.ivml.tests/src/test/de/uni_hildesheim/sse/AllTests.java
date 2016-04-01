package test.de.uni_hildesheim.sse;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Bundles all tests.
 * 
 * @author Holger Eichelberger
 */
@RunWith(Suite.class)
@SuiteClasses({BasicTests.class, AdvancedTests.class, VarModelTests.class, 
    LanguageSpecTests.class, AdditionalTests.class, ExternalTests.class, 
    HierarchicalTests.class, ImportTest.class })
public class AllTests {

}
