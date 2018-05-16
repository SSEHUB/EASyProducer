package de.uni_hildesheim.sse;

/**
 * Stores some global configuration values.
 * <ul>
 *  <li>Debug messages are enabled using <code>-Divml.core.debug=true</code> as JVM parameter</li>
 * </ul>
 * 
 * @author Holger Eichelberger
 */
public class Config {
    
    private static final boolean DEBUG = Boolean.valueOf(System.getProperty("easy.ivml.core.log", "false"));

    /**
     * Returns whether debugging is enabled.
     * 
     * @return <code>true</code> if debugging is enabled, <code>false</code> else
     */
    public static boolean isDebuggingEnabled() {
        return DEBUG;
    }

}
