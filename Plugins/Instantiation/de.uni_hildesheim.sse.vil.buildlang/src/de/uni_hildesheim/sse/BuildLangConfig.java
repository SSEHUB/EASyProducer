package de.uni_hildesheim.sse;

/**
 * Stores some global configuration values.
 * <ul>
 *  <li>Logging messages (console) are enabled using <code>-Dvil.core.log=true</code> as JVM parameter</li>
 * </ul>
 * 
 * @author Holger Eichelberger
 */
public class BuildLangConfig {

    private static final boolean DEBUG = Boolean.valueOf(System.getProperty("easy.vil.core.log", "false"));

    /**
     * Returns whether debugging is enabled.
     * 
     * @return <code>true</code> if debugging is enabled, <code>false</code> else
     */
    public static boolean isDebuggingEnabled() {
        return DEBUG;
    }

}
