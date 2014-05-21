package de.uni_hildesheim.sse.model.confModel;

import de.uni_hildesheim.sse.model.varModel.IvmlException;

/**
 * Implements a specific exception for errors in the configuration.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class ConfigurationException extends IvmlException {

    public static final int ALREADY_FROZEN = 19001;
    public static final int TYPE_MISMATCH = 19002;
    public static final int INTERNAL = 19003;
    
    private Configuration configuration;
    
    /**
     * Creates a configuration exception.
     *
     * @param configuration the causing configuration (may be <b>null</b> during incremental buildup)
     * @param message a message explaining the reason for this exception
     * @param code a code representing the reason
     */
    public ConfigurationException(Configuration configuration, String message, int code) {
        super(message, code);
        this.configuration = configuration;
    }
    
    /**
     * Returns the configuration this exception occurs on.
     * 
     * @return the configuration (may be <b>null</b> during incremental buildup)
     */
    public Configuration getConfiguration() {
        return configuration;
    }
    
}
