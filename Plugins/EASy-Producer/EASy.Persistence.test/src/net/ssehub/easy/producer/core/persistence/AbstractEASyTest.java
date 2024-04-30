package net.ssehub.easy.producer.core.persistence;

import org.junit.BeforeClass;

import net.ssehub.easy.producer.core.AllTests;

/**
 * Super class for all Test cases.
 * The {@link #setUpBeforeClass()} ensures, that the temp files will be created once.
 * @author El-Sharkawy
 *
 */
public abstract class AbstractEASyTest {

    /**
     * Copies the test files into {@link AllTests#TESTDATA_DIR_COPY}.
     * These files can be modified while testing.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        TempDirectoryInitializer.INSTANCE.initTempFiles();
    }
}
