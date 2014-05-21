package de.uni_hildesheim.sse.utils.logger;

/**
 * ENUM for ILogger Logging Level. Is used to declare what type off messages should be logged.
 * Clients should normally use the predefined Level constants such as DEBUG. 
 * <p>The levels in descending order are:</p>
 * <li>ERROR (highest value)</li>
 * <li>WARNING</li>
 * <li>INFO</li> 
 * <li>DEBUG (lowest value)</li><br><br>
 * <p>In addition there is a level OFF that can be used to turn off logging.</p>
 * 
 * @author Sass
 *
 */
public enum LoggingLevel {
    DEBUG,
    INFO, 
    WARN, 
    ERROR, 
    OFF
}
