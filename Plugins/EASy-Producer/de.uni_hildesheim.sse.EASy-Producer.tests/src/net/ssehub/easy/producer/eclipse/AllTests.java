package net.ssehub.easy.producer.eclipse;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import net.ssehub.easy.producer.eclipse.mgmt.MemberControllerTest;
import net.ssehub.easy.producer.eclipse.mgmt.ResourcesMgmtTest;
import net.ssehub.easy.producer.eclipse.persistency.project_creation.EASyProjectCreatorFactoryTest;

/**
 * Test Suite, which starts all individual test cases.
 * 
 * @author El-Sharkawy
 * 
 */
@RunWith(Suite.class)
// vitally important: Insert all Testcases here!
@Suite.SuiteClasses({
    // This test case must be the first test class, which import/create/delete projects inside the junit-workspace
    ResourcesMgmtTest.class,
    EASyProjectCreatorFactoryTest.class,
    MemberControllerTest.class })
public class AllTests {

    
    /**
     * Original files used for testing.
     * These files must not be modified while testing.
     */
    public static final File TESTDATA_DIR_ORIGINS = determineTestDataDir();
    
    /**
     * Sub-folder of {@link #TESTDATA_DIR_ORIGINS}, where copies are stored. These files can be modified while
     * running the test cases.
     */
    public static final File TESTDATA_DIR_COPY = new File(TESTDATA_DIR_ORIGINS, "temp");
    
    public static final String PLUGIN_ID = "easy_producer.testdata.home";

    /**
     * Copies the test files into {@link #TESTDATA_DIR_COPY}.
     * These files can be modified while testing.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        TempDirectoryInitializer.INSTANCE.initTempFiles();
    }
    

    /**
     * Determines the actual directory with the test IVML files depending on the JVM system property
     * {@value #PLUGIN_ID} which may contain a specific directory (or be empty -> default directory).
     * 
     * @return the actual directory as file
     */
    private static File determineTestDataDir() {
        File result;
        String externalLocation = System.getProperty(PLUGIN_ID);
        if (null == externalLocation) {
            result = new File("testdata");
        } else {
            result = new File(externalLocation);
        }
        return result;
    }
}
