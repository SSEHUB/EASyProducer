package test;

import java.io.File;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.de.uni_hildesheim.sse.easy_producer.mgmt.MemberControllerTest;
import test.de.uni_hildesheim.sse.easy_producer.mgmt.ResourcesMgmtTest;

/**
 * Test Suite, which starts all individual test cases.
 * 
 * @author El-Sharkawy
 * 
 */
@RunWith(Suite.class)
// vitally important: Insert all Testcases here!
@Suite.SuiteClasses({
// This test case must be the first test class, which
// import/create/delete projects inside the junit-workspace
    ResourcesMgmtTest.class,

    // Here is no order necessarily
    // FIXME: Jenkins cannot load swt components (32bit eclipse vs. 64 os).
    // PLuginNewWizardTest.class,
    // ProductLineProjectTest.class,
    // ProjectCreatorTest.class,
    MemberControllerTest.class })
public class AllTests {

    public static final File TESTDATA_DIR = determineTestDataDir();

    /**
     * Determines the actual directory with the test IVML files depending on the JVM system property
     * "easy_producer.testdata.home" which may contain a specific directory (or be empty -> default directory).
     * 
     * @return the actual directory as file
     */
    private static File determineTestDataDir() {
        File result;
        String externalLocation = System.getProperty("easy_producer.testdata.home");
        if (null == externalLocation) {
            result = new File("testdata");
        } else {
            result = new File(externalLocation);
        }
        return result;
    }
}
