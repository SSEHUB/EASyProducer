/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.reasoning.core.reasoner;

/**
 * A test descriptor pre-configured for the resoner core test cases.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractTestDescriptor implements ITestDescriptor {
    
    public static final String PLUGIN_ID = "net.ssehub.easy.reasoning.core.tests";
    public static final String SYSTEM_PROPERTY = "reasonerCore.testdata.home";
    static final String PROJECT_NAME = "../ReasonerCore.test/";
    
    private String pluginId;
    private String systemProperty;
    private boolean[] capabilities;

    /**
     * Creates a new default instance.
     */
    protected AbstractTestDescriptor() {
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
    protected AbstractTestDescriptor(String pluginId, String systemProperty, boolean... capabilities) {
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
    
    @Override
    public String getPluginId() {
        return pluginId;
    }

    @Override
    public String getSystemProperty() {
        return systemProperty;
    }

    @Override
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
