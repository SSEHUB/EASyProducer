package net.ssehub.easy.reasoning.core.reasoner;

import java.util.function.Predicate;

import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.varModel.model.Project;

/**
 * Describes the configuration to be passed via the {@link ReasonerFrontend} to the individual
 * reasoners. Data in this class may be defined e.g. via the UI or from a configuration file.
 * Setters are realized in builder style so that they can be chained easily after instance creation.
 * 
 * @author Holger Eichelberger
 */
public class ReasonerConfiguration {

    public static final IAdditionalInformationLogger ADDITIONAL_INFO_LOG_SYSOUT = new IAdditionalInformationLogger() {

        @Override
        public void info(String text) {
            System.out.println(text);
        }

        @Override
        public void info(Message msg) {
            System.out.println(msg);
        }
        
    };

    public static final IAdditionalInformationLogger ADDITIONAL_INFO_LOG_NONE = new IAdditionalInformationLogger() {

        @Override
        public void info(String text) {
        }

        @Override
        public void info(Message msg) {
        }
        
    };

    private AttributeValues attributeValues;
    private int timeout;
    private ReasonerDescriptor defaultReasoner;
    private boolean customMessages;
    private boolean incremental;
    private IAdditionalInformationLogger logger = ADDITIONAL_INFO_LOG_SYSOUT; // the legacy behavior
    private Predicate<Project> projectFilter = p -> true;
    // see copy constructor

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

        /**
         * Emits information about <code>msg</code>.
         * 
         * @param msg the message to be printed
         */
        public void info(Message msg);
        
    }
    
    /**
     * Creates a new instance and initializes it with default values, i.e.
     * the global timeout from {@link ReasonerFrontend#getTimeout()}, an
     * unspecified attributes values set (<b>null</b>) and an unspecified
     * default reasoner (<b>null</b>).
     */
    public ReasonerConfiguration() {
        this(false);
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
     * Copies a reasoner configuration into a new instance.
     * 
     * @param from the configuration to copy from
     */
    public ReasonerConfiguration(ReasonerConfiguration from) {
        this.attributeValues = from.attributeValues;
        this.timeout = from.timeout;
        this.defaultReasoner = from.defaultReasoner;
        this.customMessages = from.customMessages;
        this.incremental = from.incremental;
        this.logger = from.logger;
        this.projectFilter = from.projectFilter;
    }

    /**
     * Changes the timeout for reasoning.
     * 
     * @param timeout the timeout in ms, shall be ignored if less negative or null
     * @return <b>this</b>
     */
    public ReasonerConfiguration setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     * Returns the timeout for reasoning.
     * 
     * @return the timeout in ms, shall be ignored if not positive
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
     * @return the timeout in ms, shall be ignored if less negative or null
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
     * @return <b>this</b>
     */
    public ReasonerConfiguration setAttributeValues(AttributeValues attributeValues) {
        this.attributeValues = attributeValues;
        return this;
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
     * @return <b>this</b>
     */
    public ReasonerConfiguration setDefaultReasoner(ReasonerDescriptor defaultReasoner) {
        this.defaultReasoner = defaultReasoner;
        return this;
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
     * 
     * @return <b>this</b>
     */
    public ReasonerConfiguration enableCustomMessages() {
        this.customMessages = true;
        return this;
    }
    
    /**
     * Disable custom messages.
     * 
     * @return <b>this</b>
     */
    public ReasonerConfiguration disableCustomMessages() {
        this.customMessages = false;
        return this;
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
     * @return <b>this</b>
     */
    public ReasonerConfiguration setAdditionalInformationLogger(IAdditionalInformationLogger logger) {
        if (null != logger) {
            this.logger = logger;
        }
        return this;
    }
    
    /**
     * Defines whether runtime reasoning reasoning shall be activated. Currently, runtime reasoning assumes
     * that all required defaults and assignments have already been processed. In particular, the caller
     * is responsible for passing a "clean" configuration to the reasoner that leads to the expected
     * results. Same as {@link #setIncrementalMode(boolean)}.
     * 
     * @param runtime if reasoning shall happen for runtime
     * @return <b>this</b>
     */
    public ReasonerConfiguration setRuntimeMode(boolean runtime) {
        this.incremental = runtime;
        return this;
    }

    /**
     * Defines whether runtime incremental reasoning shall be performend. Currently, runtime reasoning assumes
     * that all required defaults and assignments have already been processed. In particular, the caller
     * is responsible for passing a "clean" configuration to the reasoner that leads to the expected
     * results.
     * 
     * @param incremental if incremental reasoning shall happen
     * @return <b>this</b>
     */
    public ReasonerConfiguration setIncrementalMode(boolean incremental) {
        this.incremental = incremental;
        return this;
    }

    /**
     * Returns whether runtime reasoning shall be done (see {@link #setRuntimeMode(boolean)}.
     * 
     * @return <code>true</code> if reasoning shall happen for runtime, <code>false</code> else 
     * (same as {@link #isIncrementalMode()})
     */
    public boolean isRuntimeMode() {
        return incremental;
    }

    /**
     * Returns whether incremental reasoning shall be done (see {@link #setIncrementalMode(boolean)}.
     * 
     * @return <code>true</code> if reasoning shall happen for runtime, <code>false</code> else
     */
    public boolean isIncrementalMode() {
        return incremental;
    }
    
    /**
     * Determines projects that shall be considered while reasoning. While this may decrease reasoning 
     * speed it may also (if used without care) affect result precision.
     * 
     * @param projectFilter the project filter, ignored if <b>null</b>
     */
    public void setProjectFilter(Predicate<Project> projectFilter) {
        if (null != projectFilter) {
            this.projectFilter = projectFilter;
        }
    }

    /**
     * Returns the project filter.
     * 
     * @return the project folter
     */
    public Predicate<Project> getProjectFilter() {
        return projectFilter;
    }

}
