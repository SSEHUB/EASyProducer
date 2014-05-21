package de.uni_hildesheim.sse.logger;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.utils.logger.AbstractJavaLogger;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.logger.JavaLogger;
import de.uni_hildesheim.sse.utils.logger.LoggingLevel;

/**
 * Test class for {@link JavaLogger}.
 * 
 * @author Sass
 * @author El-Sharkawy
 *
 */
public class JavaLoggerTest {

    /**
     * Saves the default/configured {@link LoggingLevel}.
     */
    private static LoggingLevel configuredLevel;
    private EASyLogger logger;

    private List<LogRecord> logRecords;
    
    /**
     * Saves the default {@link LoggingLevel}.
     * Sets also Logging level for testing.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        configuredLevel = EASyLoggerFactory.INSTANCE.getLoggingLevel();
        EASyLoggerFactory.INSTANCE.setLoggingLevel(LoggingLevel.DEBUG);
    }
    
    /**
     * Restores default {@link LoggingLevel}.
     */
    @AfterClass
    public static void tearDownAfterClass() {
        EASyLoggerFactory.INSTANCE.setLoggingLevel(configuredLevel);
    }
    
    /**
     * Set up method: Creates an empty ArrayList and returns logger instance.
     * 
     */
    @Before
    public void setUp() {
        logRecords = new ArrayList<LogRecord>();
        logger = EASyLoggerFactory.INSTANCE.getLogger(this.getClass(), "Model.tests");
    }
    
    /**
     * Test if info message is logged.
     */
    @Test
    public void testInfo() {
        Assert.assertEquals(0, logRecords.size());
        JavaLogger javaLogger = new JavaLogger();
        javaLogger.setFilter(new Filter() {
            public boolean isLoggable(LogRecord logRecord) {
                if (logRecord.getLevel().intValue() == Level.INFO.intValue()) {
                    logRecords.add(logRecord);
                }
                return false;
            }
        });
        EASyLoggerFactory.INSTANCE.setLogger(javaLogger);
        Assert.assertEquals(0, logRecords.size());
        logger.info("This is an info message!");
        logger.error("This message should not be logged!");
        Assert.assertEquals(1, logRecords.size());
        Assert.assertEquals("[" + this.getClass().getSimpleName() + "] This is an info message!", 
                logRecords.get(0).getMessage());
    }
    
    /**
     * Test if error message is logged.
     */
    @Test
    public void testError() {
        Assert.assertEquals(0, logRecords.size());
        JavaLogger javaLogger = new JavaLogger();
        javaLogger.setFilter(new Filter() {
            public boolean isLoggable(LogRecord logRecord) {
                if (logRecord.getLevel().intValue() == Level.SEVERE.intValue()) {
                    logRecords.add(logRecord);
                }
                return false;
            }
        });
        EASyLoggerFactory.INSTANCE.setLogger(javaLogger);
        Assert.assertEquals(0, logRecords.size());
        logger.error("This is an error message!");
        logger.info("This message should not be logged!");
        Assert.assertEquals(1, logRecords.size());
        Assert.assertEquals("[" + this.getClass().getSimpleName() + "] This is an error message!", 
                logRecords.get(0).getMessage());
    }
    
    /**
     * Test if debug message is logged.
     */
    @Test
    public void testDebug() {
        Assert.assertEquals(0, logRecords.size());
        JavaLogger javaLogger = new JavaLogger();
        javaLogger.setFilter(new Filter() {
            public boolean isLoggable(LogRecord logRecord) {
                Level debugLevel = AbstractJavaLogger.DEBUG_LEVEL;
                if (logRecord.getLevel().intValue() == debugLevel.intValue()) {
                    logRecords.add(logRecord);
                }
                return false;
            }
        });
        EASyLoggerFactory.INSTANCE.setLogger(javaLogger);
        Assert.assertEquals(0, logRecords.size());
        logger.debug("This is an debug message!");
        logger.info("This message should not be logged!");
        Assert.assertEquals(1, logRecords.size());
        Assert.assertEquals("[" + this.getClass().getSimpleName() + "] This is an debug message!", 
                logRecords.get(0).getMessage());
    }
    
    /**
     * Test if warn message is logged.
     */
    @Test
    public void testWarn() {
        Assert.assertEquals(0, logRecords.size());
        JavaLogger javaLogger = new JavaLogger();
        javaLogger.setFilter(new Filter() {
            public boolean isLoggable(LogRecord logRecord) {
                if (logRecord.getLevel().intValue() == Level.WARNING.intValue()) {
                    logRecords.add(logRecord);
                }
                return false;
            }
        });
        EASyLoggerFactory.INSTANCE.setLogger(javaLogger);
        Assert.assertEquals(0, logRecords.size());
        logger.warn("This is an warn message!");
        logger.info("This message should not be logged!");
        Assert.assertEquals(1, logRecords.size());
        Assert.assertEquals("[" + this.getClass().getSimpleName() + "] This is an warn message!", 
                logRecords.get(0).getMessage());
    }
    
    /**
     * Test if exception message is logged.
     */
    @Test
    public void testException() {
        Assert.assertEquals(0, logRecords.size());
        JavaLogger javaLogger = new JavaLogger();
        javaLogger.setFilter(new Filter() {
            public boolean isLoggable(LogRecord logRecord) {
                Level exceptionLevel = AbstractJavaLogger.EXCEPTION_LEVEL;
                if (logRecord.getLevel().intValue() == exceptionLevel.intValue()) {
                    logRecords.add(logRecord);
                }
                return false;
            }
        });
        EASyLoggerFactory.INSTANCE.setLogger(javaLogger);
        Assert.assertEquals(0, logRecords.size());
        Exception nullPointerException = new NullPointerException("This is a NPE for testing purposes!");
        logger.exception(nullPointerException);
        logger.info("This message should not be logged!");
        Assert.assertEquals(1, logRecords.size());
        Assert.assertEquals("[" + this.getClass().getSimpleName() + "] This is a NPE for testing purposes!", 
                logRecords.get(0).getMessage());
    }
    
    /**
     * Test if logging level is handled correctly.
     */
    @Test
    public void testLoggingLevel() {
        Assert.assertEquals(0, logRecords.size());
        // Log: all
        setFilterLevel(Level.ALL);
        sampleLogging();
        Assert.assertEquals(5, logRecords.size());
        logRecords.clear();
        // Log: info, warning, error
        setFilterLevel(Level.INFO);
        sampleLogging();
        Assert.assertEquals(3, logRecords.size());
        logRecords.clear();
        // Log: debug, info, warning, error
        setFilterLevel(AbstractJavaLogger.DEBUG_LEVEL);
        sampleLogging();
        Assert.assertEquals(5, logRecords.size());
        logRecords.clear();
        // Log: none
        setFilterLevel(Level.OFF);
        sampleLogging();
        Assert.assertEquals(0, logRecords.size());
    }
    
    /**
     * This method simply logs some messages.
     */
    private void sampleLogging() {
        logger.info("entering");
        try {
            willFail();
        } catch (NullPointerException e) {
            logger.exception(e);
        }
        logger.warn("An exception occured!");
        logger.info("exiting");
    } 
    
    /**
     * .
     * @throws NullPointerException Throws a NPE
     */
    private void willFail() throws NullPointerException {
        logger.debug("willFail() called");
        throw new NullPointerException("This is a NPE for testing! Ignore it!");
    }
    
    /**
     * Sets the logging level for the filter.
     * 
     * @param level The logging level that shall be used.
     */
    private void setFilterLevel(final Level level) {
        JavaLogger javaLogger = new JavaLogger();
        javaLogger.setFilter(new Filter() {
            public boolean isLoggable(LogRecord logRecord) {
                if (logRecord.getLevel().intValue() >= level.intValue()) {
                    logRecords.add(logRecord);
                }
                return false;
            }
        });
        EASyLoggerFactory.INSTANCE.setLogger(javaLogger);
    }
}
