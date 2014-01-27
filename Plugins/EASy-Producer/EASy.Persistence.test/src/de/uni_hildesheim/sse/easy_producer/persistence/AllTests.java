package de.uni_hildesheim.sse.easy_producer.persistence;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.PLPInfoTest;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.SPLsManagerTest;

/**
 * Test suit: runs all test classes.
 * @author El-Sharkawy
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
    IntegrationTest.class,
    SPLsManagerTest.class,
    PLPInfoTest.class })
public class AllTests {
    
    /**
     * Original files used for testing.
     * These files should be copied before they are used for instantiation.
     * these files must not be modified while testing.
     */
    public static final File TESTDATA_DIR_ORIGINS = determineDir("de.uni_hildesheim.sse.easy_producer.core.test"
        , "testdata");
    
    /**
     * Sub-folder of {@link #TESTDATA_DIR_ORIGINS}, where copies are stored. These files can be modified while
     * running the test cases.
     */
    public static final File TESTDATA_DIR_COPY = new File(TESTDATA_DIR_ORIGINS, "temp");
    
    public static final String PLUGIN_ID = "de.uni_hildesheim.sse.easy_producer.core.test";
    
    /**
     * Determines folders, which should be used during testing.
     * @param property A system property to specify the directory from outside.
     * @param defaultFolder A folder relative to this project. Will only be used if no property was used.
     * @return A folder which can be used for testing.
     */
    private static File determineDir(String property, String defaultFolder) {
        File result;
        String externalLocation = System.getProperty(property);
        if (null == externalLocation) {
            result = new File(defaultFolder);
        } else {
            result = new File(externalLocation);
        }
        return result;
    }

    /**
     * Copies the test files into {@link #TESTDATA_DIR_COPY}.
     * These files can be modified while testing.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        TempDirectoryInitializer.INSTANCE.initTempFiles();
    }
}
