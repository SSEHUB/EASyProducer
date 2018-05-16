package de.uni_hildesheim.sse.vil.templatelang;

/**
 * Stores some global configuration values.
 * <ul>
 *  <li>Debug messages are enabled using <code>-Deasy.vtl.core.debug=true</code> as JVM parameter</li>
 * </ul>
 * 
 * @author Holger Eichelberger
 */
public class TemplateLangConfig {

    private static final boolean DEBUG = Boolean.valueOf(System.getProperty("easy.vtl.core.log", "false"));

    /**
     * Returns whether debugging is enabled.
     * 
     * @return <code>true</code> if debugging is enabled, <code>false</code> else
     */
    public static boolean isDebuggingEnabled() {
        return DEBUG;
    }

}
