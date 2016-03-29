package net.ssehub.easy.reasoning.core.frontend;

/**
 * Configures reusable tests.
 * 
 * @author Holger Eichelberger
 */
public class TestConfiguration {

    /**
     * Defines reasoner capabilities which may not be supported and, thus, shall not be tested.
     * 
     * @author Eichelberger
     */
    public enum Capabilities {
        CHECK,
        CONSISTENT
    }
    
    public static final String PLUGIN_ID = "ReasonerCore.test";
    public static final String SYSTEM_PROPERTY = "reasonerCore.testdata.home";
    static final String PROJECT_NAME = "../ReasonerCore.test/";
    
    private String pluginId;
    private String systemProperty;
    private boolean[] capabilities;

    /**
     * Creates a new default instance.
     */
    TestConfiguration() {
        this(PLUGIN_ID, SYSTEM_PROPERTY, null);
    }
    
    /**
     * Creates a new instance.
     * 
     * @param pluginId the pluginId (in case that tests are started from within an OSGi environment, may be <b>null</b> 
     *   then the default is used)
     * @param systemProperty the property defining the location of the test files in a continuous 
     *   integration environment - this supersedes all other path specifications, may be <b>null</b> then the default 
     *   is used
     * @param capabilities the capabilities, may be <b>null</b> then all explicit capabilities are 
     *   unsupported, shall support all {@link Capabilities} in length (unspecified are considered as 
     *   unsupported)
     */
    public TestConfiguration(String pluginId, String systemProperty, boolean... capabilities) {
        assert null == capabilities || capabilities.length == Capabilities.values().length;
        if (null == pluginId || 0 == pluginId.length()) {
            this.pluginId = PLUGIN_ID;
        } else {
            this.pluginId = pluginId;
        }
        if (null == systemProperty || 0 == systemProperty.length()) {
            this.systemProperty = SYSTEM_PROPERTY;
        } else {
            this.systemProperty = systemProperty;
        }
        this.capabilities = capabilities;
    }
    
    /**
     * Returns the plugin id of the containing test.
     * 
     * @return the plugin id
     */
    public String getPluginId() {
        return pluginId;
    }
    
    /**
     * Returns the system property.
     * 
     * @return the system property
     */
    public String getSystemProperty() {
        return systemProperty;
    }

    /**
     * Returns whether <code>capability</code> is supported.
     * 
     * @param capability the capability to check for
     * @return <code>true</code> if <code>capability</code> is supported, <code>false</code> else
     */
    public boolean isSupported(Capabilities capability) {
        boolean result = false;
        if (null != capabilities) {
            if (capabilities.length > capability.ordinal()) {
                result = capabilities[capability.ordinal()];
            }
        }
        return result;
    }
    
}
