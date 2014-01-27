package de.uni_hildesheim.sse.easy_producer.persistence;

import org.junit.BeforeClass;

/**
 * Super class for all Test cases.
 * The {@link #setUpBeforeClass()} ensures, that the temp files will be created once.
 * @author El-Sharkawy
 *
 */
public abstract class AbstractEASyTest {

    /**
     * Copies the test files into {@link #TESTDATA_DIR_COPY}.
     * These files can be modified while testing.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        TempDirectoryInitializer.INSTANCE.initTempFiles();
    }
}
