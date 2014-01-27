package de.uni_hildesheim.sse.logger;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.logger.LoggingLevel;

/**
 * Test class for {@link EASyLoggerFactory}.
 * @author Sass
 *
 */
public class EASyLoggerFactoryTest {
    
    /**
     * Debug message for testing.
     */
    private static final String DEBUG_MESSAGE = "Debug message";
    /**
     * Info message for testing.
     */
    private static final String INFO_MESSAGE = "Info message";
    /**
     * Warning message for testing.
     */
    private static final String WARNING_MESSAGE = "Warning message";
    /**
     * Error message for testing.
     */
    private static final String ERROR_MESSAGE = "Error message";
    /**
     * Exception message for testing.
     */
    private static final String EXCEPTION_MESSAGE = "Exception Message";
    
    private static LoggingLevel originalLevel;
    
    private EASyLogger easyLogger;
    private ListLogger listLoger;
    
    /**
     * Stores the logging level of the {@link EASyLoggerFactory} before executing the test methods.
     * This facilitates that the {@link LoggingLevel} could be set to the origin level after executing all
     * test methods.
     * @see #tearDown()
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        originalLevel = EASyLoggerFactory.INSTANCE.getLoggingLevel();
    }

    /**
     * Resets the old {@link LoggingLevel} after executing all test methods.
     */
    @AfterClass
    public static void tearDownAfterClass() {
        EASyLoggerFactory.INSTANCE.setLoggingLevel(originalLevel);
    }
    
    /**
     * Creates a new {@link ListLogger} instance for each test method.
     * Creates also the easyLogger for logging messages.
     */
    @Before
    public void setUp() {
        listLoger = new ListLogger();
        EASyLoggerFactory.INSTANCE.setLogger(listLoger);
        easyLogger = EASyLoggerFactory.INSTANCE.getLogger(this.getClass(), "Model.tests");
    }
    
    
    /**
     * Test if the logger is returned.
     */
    @Test
    public void testGetLogger() {
        easyLogger = null;
        Assert.assertNull(easyLogger);
        easyLogger = EASyLoggerFactory.INSTANCE.getLogger(this.getClass(), "Model.tests");
        Assert.assertNotNull(easyLogger);
    }

    /**
     * Test if the logging level is set.
     */
    @Test
    public void testSetLoggingLevel() {
        Assert.assertNotNull(EASyLoggerFactory.INSTANCE.getLoggingLevel());
        easyLogger.debug("Set logging level to OFF...");
        EASyLoggerFactory.INSTANCE.setLoggingLevel(LoggingLevel.OFF);
        Assert.assertEquals(LoggingLevel.OFF, EASyLoggerFactory.INSTANCE.getLoggingLevel());
        EASyLoggerFactory.INSTANCE.setLoggingLevel(LoggingLevel.DEBUG);
        easyLogger.debug("Set logging level to DEBUG...");
    }
    
    /**
     * Tests whether logging could be deactivated.
     */
    @Test
    public void testSetLoggingLevelOFF() {
        // Test precondition
        checkListLogger(0, 0, 0, 0, 0);
        
        // Set State and log
        EASyLoggerFactory.INSTANCE.setLoggingLevel(LoggingLevel.OFF);
        logAll();
        
        // Test post condition (nothing should be logged).
        checkListLogger(0, 0, 0, 0, 0);
    }
    
    /**
     * Tests whether logging could be set to debug.
     */
    @Test
    public void testSetLoggingLevelDEBUG() {
        // Test precondition
        checkListLogger(0, 0, 0, 0, 0);
        
        // Set State and log
        EASyLoggerFactory.INSTANCE.setLoggingLevel(LoggingLevel.DEBUG);
        logAll();
        
        // Test post condition (nothing should be logged).
        checkListLogger(1, 1, 1, 1, 1);
        Assert.assertEquals(DEBUG_MESSAGE, listLoger.getDebugMessages().get(0));
        Assert.assertEquals(INFO_MESSAGE, listLoger.getInfoMessages().get(0));
        Assert.assertEquals(WARNING_MESSAGE, listLoger.getWarnMessages().get(0));
        Assert.assertEquals(ERROR_MESSAGE, listLoger.getErrorMessages().get(0));
        Assert.assertEquals(EXCEPTION_MESSAGE, listLoger.getExceptions().get(0));
    }
    
    /**
     * Tests whether logging could be set to info.
     */
    @Test
    public void testSetLoggingLevelINFO() {
        // Test precondition
        checkListLogger(0, 0, 0, 0, 0);
        
        // Set State and log
        EASyLoggerFactory.INSTANCE.setLoggingLevel(LoggingLevel.INFO);
        logAll();
        
        // Test post condition (nothing should be logged).
        checkListLogger(0, 1, 1, 1, 1);
        Assert.assertEquals(INFO_MESSAGE, listLoger.getInfoMessages().get(0));
        Assert.assertEquals(WARNING_MESSAGE, listLoger.getWarnMessages().get(0));
        Assert.assertEquals(ERROR_MESSAGE, listLoger.getErrorMessages().get(0));
        Assert.assertEquals(EXCEPTION_MESSAGE, listLoger.getExceptions().get(0));
    }
    
    /**
     * Tests whether logging could be set to warning.
     */
    @Test
    public void testSetLoggingLevelWARN() {
        // Test precondition
        checkListLogger(0, 0, 0, 0, 0);
        
        // Set State and log
        EASyLoggerFactory.INSTANCE.setLoggingLevel(LoggingLevel.WARN);
        logAll();
        
        // Test post condition (nothing should be logged).
        checkListLogger(0, 0, 1, 1, 1);
        Assert.assertEquals(WARNING_MESSAGE, listLoger.getWarnMessages().get(0));
        Assert.assertEquals(ERROR_MESSAGE, listLoger.getErrorMessages().get(0));
        Assert.assertEquals(EXCEPTION_MESSAGE, listLoger.getExceptions().get(0));
    }
    
    /**
     * Tests whether logging could be set to warning.
     */
    @Test
    public void testSetLoggingLevelERROR() {
        // Test precondition
        checkListLogger(0, 0, 0, 0, 0);
        
        // Set State and log
        EASyLoggerFactory.INSTANCE.setLoggingLevel(LoggingLevel.ERROR);
        logAll();
        
        // Test post condition (nothing should be logged).
        checkListLogger(0, 0, 0, 1, 1);
        Assert.assertEquals(ERROR_MESSAGE, listLoger.getErrorMessages().get(0));
        Assert.assertEquals(EXCEPTION_MESSAGE, listLoger.getExceptions().get(0));
    }

    /**
     * Helping method for applying a message of each kind.
     */
    private void logAll() {
        easyLogger.debug(DEBUG_MESSAGE);
        easyLogger.info(INFO_MESSAGE);
        easyLogger.warn(WARNING_MESSAGE);
        easyLogger.error(ERROR_MESSAGE);
        Exception exc = new Exception(EXCEPTION_MESSAGE);
        easyLogger.exception(exc);
    }

    /**
     * Check whether the correct number of messages were logged.
     * @param nInfos The number of info messages, which should be logged.
     * @param nWarnings The number of warnings messages, which should be logged.
     * @param nDebugs The number of debug messages, which should be logged.
     * @param nErrors The number of error messages, which should be logged.
     * @param nExceptions The number of exceptions, which should be logged.
     */
    private void checkListLogger(int nDebugs, int nInfos, int nWarnings, int nErrors, int nExceptions) {
        Assert.assertEquals(nInfos, listLoger.getInfoMessages().size());
        Assert.assertEquals(nWarnings, listLoger.getWarnMessages().size());
        Assert.assertEquals(nDebugs, listLoger.getDebugMessages().size());
        Assert.assertEquals(nErrors, listLoger.getErrorMessages().size());
        Assert.assertEquals(nExceptions, listLoger.getExceptions().size());
    }
}
