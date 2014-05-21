package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Helper class for initializing Temp directory.
 * This class is a singleton, so that the temp files can be initialized from
 * different test classes. Thus, the test classes can be executed as a single test
 * case but also as part of the whole test suite.
 * @author El-Sharkawy
 *
 */
public class TempDirectoryInitializer {

    public static final TempDirectoryInitializer INSTANCE = new TempDirectoryInitializer();
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(TempDirectoryInitializer.class,
        AllTests.PLUGIN_ID);
    
    private boolean filesInitialized;
    
    /**
     * Singleton constructor.
     */
    private TempDirectoryInitializer() {
        filesInitialized = false;
    }
    
    /**
     * Copies the files from {@link AllTests#TESTDATA_DIR_ORIGINS} to {@link AllTests#TESTDATA_DIR_COPY}.
     * These files can be modified while testing.
     */
    public void initTempFiles() {
        if (!filesInitialized) {
            if (AllTests.TESTDATA_DIR_COPY.exists()) {
                try {
                    FileUtils.deleteDirectory(AllTests.TESTDATA_DIR_COPY);
                } catch (IOException e) {
                    LOGGER.exception(e);
                }
            }
            try {
                LOGGER.debug(AllTests.TESTDATA_DIR_COPY.getCanonicalPath());
            } catch (IOException e1) {
                LOGGER.exception(e1);
            }
            AllTests.TESTDATA_DIR_COPY.mkdir();
            
            File[] nestedFiles = AllTests.TESTDATA_DIR_ORIGINS.listFiles();
            if (null != nestedFiles) {
                for (int i = 0; i < nestedFiles.length; i++) {
                    File src = nestedFiles[i];
                    if (src.isDirectory() && !src.getName().equalsIgnoreCase(AllTests.TESTDATA_DIR_COPY.getName())
                        && !src.getName().equalsIgnoreCase(".svn")) {
                        
                        File dest = new File(AllTests.TESTDATA_DIR_COPY, src.getName());
                        try {
                            FileUtils.copyDirectory(src, dest);
                        } catch (IOException e) {
                            LOGGER.exception(e);
                        }
                    }
                }
            }
        }
        
        filesInitialized = true;
    }
}
