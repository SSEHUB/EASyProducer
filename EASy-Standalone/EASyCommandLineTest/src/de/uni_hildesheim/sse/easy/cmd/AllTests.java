package de.uni_hildesheim.sse.easy.cmd;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CommandLineExecuterTests.class, ReasoningTests.class})
public class AllTests {

    /**
     * Top level folder of files and projects which can be used for instantiation while testing.
     */
    public final static File TESTDATA_DIR = new File(determineTestdataDir(), "temp");
    
    /**
     * Top level folder where the *.class files of the Application Under test (i.e. EASyCommandLine).
     */
    public final static File AUT_DIR = determineAUTDir();
    public final static File AUT_LIBS = determineAUTLibs();
    
    /**
     * Temporary elevator examples. Will be cleaned up before running all tests.
     */
    public static final File ELEVATOR_DIR = new File(AllTests.TESTDATA_DIR, "elevator");
    
    /**
     * Temporary reasonings examples. Will be cleaned up before running all tests.
     */
    public static final File REASONINGS_DIR = new File(AllTests.TESTDATA_DIR, "Reasonings");
    
    private final static File TESTDATA_DIR_ORIGINALS = determineTestdataDir();
    
    /**
     * Determines the toplevel directory of the test data files.
     * @return The toplevel directory of all test data files.
     */
    private static File determineTestdataDir() {
        return determineDir("EASyCommandlineTests.testdata", "testdata");
    }
    
    /**
     * Locates the toplevel directory of the <b>a</b>pplication <b>u</b>nder <b>t</b>est class files.
     * @return The folder from where to start the AUT.
     */
    private static File determineAUTDir() {        
        return determineDir("EASyCommandline.binFolder", "../EASyCommandLine/bin");
    }
    
    /**
     * Locates the <tt>lib</tt> directory of the <b>a</b>pplication <b>u</b>nder <b>t</b>est.
     * @return The folder which contains the needed libraries of the AUT.
     */
    private static File determineAUTLibs() {        
        return determineDir("EASyCommandline.libFolder", "../EASyCommandLine/lib");
    }
    
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
     * Prepare test data.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        initTestdata();
    }
    
    /**
     * This method ensures usable data inside of the temp directory.
     * Deletes the temp folder, recreates the folder, and copies all testdata into this folder.
     */
    private static void initTestdata() {
        if (TESTDATA_DIR.exists()) {
            try {
                FileUtils.deleteDirectory(TESTDATA_DIR);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            System.out.println(TESTDATA_DIR.getCanonicalPath());
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        TESTDATA_DIR.mkdir();
        
        File[] nestedFiles = TESTDATA_DIR_ORIGINALS.listFiles();
        if (null != nestedFiles) {
            for (int i = 0; i < nestedFiles.length; i++) {
                File src = nestedFiles[i];
                if(src.isDirectory() && !src.getName().equalsIgnoreCase("temp") && !src.getName().equalsIgnoreCase(".svn")) {
                    File dest = new File(TESTDATA_DIR, src.getName());
                    try {
                        FileUtils.copyDirectory(src, dest);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            
        }
    }
}
