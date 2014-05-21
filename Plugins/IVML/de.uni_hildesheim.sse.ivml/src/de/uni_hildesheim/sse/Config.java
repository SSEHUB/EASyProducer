package de.uni_hildesheim.sse;

import de.uni_hildesheim.sse.translation.ModelTranslator;

/**
 * Stores some global configuration values.
 * <ul>
 *  <li>Debug messages are enabled using <code>-Divml.core.debug=true</code> as JVM parameter</li>
 * </ul>
 * 
 * @author Holger Eichelberger
 */
public class Config {

    /**
     * States whether recursive operation definitions are allowed in IVML. To keep the
     * dependencies right, this constant just passes the constant value from 
     * {@link ModelTranslator}.
     */
    public static final boolean ENABLE_RECURSIVE_OPERATION_DEFINITIONS 
        = ModelTranslator.ENABLE_RECURSIVE_OPERATION_DEFINITIONS;
    
    private static final boolean DEBUG = Boolean.valueOf(System.getProperty("ivml.core.log", "false"));

    /**
     * Returns whether debugging is enabled.
     * 
     * @return <code>true</code> if debugging is enabled, <code>false</code> else
     */
    public static boolean isDebuggingEnabled() {
        return DEBUG;
    }

}
