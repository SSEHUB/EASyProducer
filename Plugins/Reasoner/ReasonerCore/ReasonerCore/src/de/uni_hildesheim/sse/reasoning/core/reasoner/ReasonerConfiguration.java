package de.uni_hildesheim.sse.reasoning.core.reasoner;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.reasoning.core.frontend.ReasonerFrontend;

/**
 * Describes the configuration to be passed via the {@link ReasonerFrontend} to the individual
 * reasoners. Data in this class may be defined e.g. via the UI or from a configuration file.
 * 
 * @author Holger Eichelberger
 */
public class ReasonerConfiguration {

    private AttributeValues attributeValues;
    private int timeout;
    private ReasonerDescriptor defaultReasoner;
    private boolean customMessages;
    private boolean runtime;
    private boolean freshConfig;
    private IAdditionalInformationLogger logger = new IAdditionalInformationLogger() {

        @Override
        public void info(String text) {
            System.out.println(text); // the legacy behavior
        }
        
    };

    /**
     * Describes an information logger.
     * 
     * @author Holger Eichelberger
     */
    public interface IAdditionalInformationLogger {

        /**
         * Emits some information.
         * 
         * @param text the text to be printed
         */
        public void info(String text);
        
    }
    
    /**
     * Creates a new instance and initializes it with default values, i.e.
     * the global timeout from {@link ReasonerFrontend#getTimeout()}, an
     * unspecified attributes values set (<b>null</b>) and an unspecified
     * default reasoner (<b>null</b>).
     */
    public ReasonerConfiguration() {
        this(false);
        this.freshConfig = true;
    }
    
    /**
     * Creates a new instance and initializes it with default values, i.e.
     * the global timeout from {@link ReasonerFrontend#getTimeout()}, an
     * unspecified attributes values set (<b>null</b>), custom messaging and an unspecified
     * default reasoner (<b>null</b>).
     * @param defParamValue Enables custom messages (comments instead of constraints).
     */
    public ReasonerConfiguration(boolean defParamValue) {
        this.timeout = ReasonerFrontend.getInstance().getTimeout();
        this.customMessages = defParamValue;
    }
    
    /**
     * Changes the timeout for reasoning.
     * 
     * @param timeout the timeout, shall be ignored if less negative or null
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    /**
     * Returns the timeout for reasoning.
     * 
     * @return the timeout, shall be ignored if less negative or null
     */
    public int getTimeout() {
        return timeout;
    }
    
    /**
     * Returns the specific timeout for reasoning. This method uses 
     * {@link ReasonerFrontend#getTimeout()} as fallback. Reasoners shall 
     * call this method rather than {@link #getTimeout()}.
     * 
     * @param configuration the configuration the timeout shall be returned for (may be <b>null</b>)
     * @return the timeout, shall be ignored if less negative or null
     */
    public int getTimeout(ReasonerConfiguration configuration) {
        int result = 0;
        if (null != configuration) {
            timeout = configuration.getTimeout();
        }
        if (result <= 0) {
            result = ReasonerFrontend.getInstance().getTimeout();
        }
        return result;
    }
    
    /**
     * Changes attribute values for reasoning.
     * 
     * @param attributeValues the values instance (may ba <b>null</b>)
     */
    public void setAttributeValues(AttributeValues attributeValues) {
        this.attributeValues = attributeValues;
    }

    /**
     * Returns the attribute values for reasoning. Reasoners shall call 
     * {@link #getAttributeValues(ReasonerConfiguration)} instead.
     * 
     * @return the attribute values for reasoning (may be <b>null</b> if none is provided)
     */
    public AttributeValues getAttributeValues() {
        return attributeValues;
    }
    
    /**
     * Null-safe access to the attribute values.
     * 
     * @param config the configuration instance holding the attribute values.
     * @return the values or <b>null</b> 
     */
    public static AttributeValues getAttributeValues(ReasonerConfiguration config) {
        AttributeValues result = null;
        if (null != config) {
            result = config.getAttributeValues();
        }
        return result;
    }
    
    /**
     * Changes the default reasoner.
     * 
     * @param defaultReasoner the default reasoner or <b>null</b> if there is none configured
     */
    public void setDefaultReasoner(ReasonerDescriptor defaultReasoner) {
        this.defaultReasoner = defaultReasoner;
    }

    /**
     * Returns the default reasoner.
     * 
     * @return the default reasoner or <b>null</b> if there is none configured
     */
    public ReasonerDescriptor getDefaultResoner() {
        return defaultReasoner;
    }
    
    /**
     * Enables custom messages.
     */
    public void enableCustomMessages() {
        this.customMessages = true;
    }
    
    /**
     * Disable custom messages.
     */
    public void disableCustomMessages() {
        this.customMessages = false;
    }
    
    /**
     * Returns if custom messages are enabled.
     * @return Returns true if custom messages are enabled.
     */
    public boolean getCustomMessages() {
        return customMessages;
    }
    
    /**
     * Returns the additional information logger.
     * 
     * @return the information logger
     */
    public IAdditionalInformationLogger getLogger() {
        return logger;
    }

    /**
     * Defines the additional information logger.
     * 
     * @param logger the logger
     */
    public void setAdditionalInformationLogger(IAdditionalInformationLogger logger) {
        if (null != logger) {
            this.logger = logger;
        }
    }
    
    /**
     * Defines whether runtime reasoning reasoning shall be activated. Currently, runtime reasoning assumes
     * that all required defaults and assignments have already been processed. In particular, the caller
     * is responsible for passing a "clean" configuration to the reasoner that leads to the expected
     * results.
     * 
     * @param runtime if reasoning shall happen for runtime
     */
    public void setRuntimeMode(boolean runtime) {
        this.runtime = runtime;
    }
    
    /**
     * Returns whether runtime reasoning shall be done (see {@link #setRuntimeMode(boolean)}.
     * 
     * @return <code>true</code> if reasoning shall happen for runtime, <code>false</code> else
     */
    public boolean isRuntimeMode() {
        return runtime;
    }
    
    /**
     * Defines whether the reasoner should create a fresh {@link Configuration}.
     */
    public void createFreshConfiguration() {
        freshConfig = true;
    }
    
    /**
     * Returns whether a fresh {@link Configuration} should be created.
     * @return <code>true</code> if Fresh {@link Configuration} is created.
     */
    public boolean isFreshConfiguration() {
        return freshConfig;
    }
}
