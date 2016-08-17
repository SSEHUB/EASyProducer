package net.ssehub.easy.instantiation.yaml.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

/**
 * Abstract test class containing utility methods.
 * @author Aike Sass
 *
 */
public class AbstractTest {
    
    public static final File TMP = new File(determineTestDataDir(), "tmp");
    
    /**
     * Returns the system property determining the directory containing the actual test data.
     * 
     * @return the name of the system property
     */
    protected static String getSystemPropertyName() {
        return "instantiation.yaml.testdata.home";
    }

    
    /**
     * Determines the actual directory with the test IVML files depending on the
     * JVM system specified property which may contain a specific
     * directory (or be empty -> default directory <code>testdata</code>).
     * 
     * @return the actual directory as file
     */
    protected static File determineTestDataDir() {
        File result;
        String externalLocation = System.getProperty(getSystemPropertyName());
        if (null == externalLocation) {
            result = new File("testdata");
        } else {
            result = new File(externalLocation);
        }
        return result;
    }
    
    /**
     * Create temp directory if it doesnt exist.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        if (!TMP.exists()) {
            TMP.mkdirs();
            Assert.assertTrue(TMP.exists());
        }
    }
    
    /**
     * Delete file after testing.
     */
//    @AfterClass
//    public static void tearDownAfterClass() {
//        if (TMP.exists()) {
//            FileUtils.deleteQuietly(TMP);
//            Assert.assertEquals(TMP + " still exists", false, TMP.exists());
//        }
//    }
}
