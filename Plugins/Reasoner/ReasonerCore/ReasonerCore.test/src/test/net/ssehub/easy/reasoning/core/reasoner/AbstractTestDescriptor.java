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
package test.net.ssehub.easy.reasoning.core.reasoner;

import net.ssehub.easy.reasoning.core.reasoner.GeneralMeasures;
import net.ssehub.easy.reasoning.core.reasoner.IMeasurementKey;
import net.ssehub.easy.varModel.varModel.testSupport.MeasurementCollector;
import net.ssehub.easy.varModel.varModel.testSupport.MeasurementCollector.IMeasurementIdentifier;

/**
 * A test descriptor pre-configured for the reasoner core test cases.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractTestDescriptor implements ITestDescriptor {
    
    public static final String PLUGIN_ID = "net.ssehub.easy.reasoning.core.tests";
    public static final String SYSTEM_PROPERTY = "reasonerCore.testdata.home";
    protected static final IMeasurementKey[] MEASUREMENTS = GeneralMeasures.values();
    static final String PROJECT_NAME = "../ReasonerCore.test/";
    
    private String pluginId;
    private String systemProperty;
    private boolean[] capabilities;

    /**
     * The abstract measurement identifiers.
     * 
     * @author Holger Eichelberger
     */
    public enum MeasurementIdentifier implements IMeasurementIdentifier {

        /**
         * Time taken for creating a re-usable reasoner instance (in ms).
         */
        REASONER_INSTANCE_CREATION_TIME,
        
        /**
         * Total number of re-evaluations.
         */
        REASONER_REEVALUATION_COUNT,
        
        /**
         * Total number of constraints.
         */
        REASONER_CONSTRAINT_COUNT,
        
        /**
         * Total number of evaluation problems.
         */
        REASONER_PROBLEMS,
        
        /**
         * Total time (in ms) spent for reasoning.
         */
        REASONER_REASONING_TIME,

        /**
         * Time (in ms) spent for translating the model - collected only if the approach performs translation.
         */
        REASONER_TRANSLATION_TIME,

        /**
         * Time (in ms) spent for constraint translation.
         */
        REASONER_EVALUATION_TIME;

        @Override
        public boolean isAutomatic() {
            return false;
        }

    }

    
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
    
    /**
     * Registers the measurement mappings for the SSE reasoner.
     */
    public static void registerMeasurementMappings() {
        MeasurementCollector.registerMapping(GeneralMeasures.REEVALUATION_COUNT, 
            MeasurementIdentifier.REASONER_REEVALUATION_COUNT);
        MeasurementCollector.registerMapping(GeneralMeasures.CONSTRAINT_COUNT, 
            MeasurementIdentifier.REASONER_CONSTRAINT_COUNT);
        MeasurementCollector.registerMapping(GeneralMeasures.PROBLEMS, 
            MeasurementIdentifier.REASONER_PROBLEMS);
        MeasurementCollector.registerMapping(GeneralMeasures.REASONING_TIME, 
            MeasurementIdentifier.REASONER_REASONING_TIME);
        MeasurementCollector.registerMapping(GeneralMeasures.TRANSLATION_TIME, 
            MeasurementIdentifier.REASONER_TRANSLATION_TIME);
        MeasurementCollector.registerMapping(GeneralMeasures.EVALUATION_TIME, 
            MeasurementIdentifier.REASONER_EVALUATION_TIME);
    }
    
    /**
     * Automatically registers the measurement mappings.
     */
    static {
        registerMeasurementMappings();
    }

    @Override
    public IMeasurementKey[] measurements() {
        return MEASUREMENTS;
    }

    /**
     * Concatenates two arrays of measurement keys.
     * 
     * @param a1 the first array
     * @param a2 the second array
     * @return the concatenated array
     */
    public static IMeasurementKey[] concat(IMeasurementKey[] a1, IMeasurementKey[] a2) {
        return concat(new IMeasurementKey[a1.length + a2.length], a1, a2);
    }

    /**
     * Concatenates two arrays of objects.
     * 
     * @param a1 the first array
     * @param a2 the second array
     * @return the concatenated array
     */
    public static Object[] concat(Object[] a1, Object[] a2) {
        return concat(new Object[a1.length + a2.length], a1, a2);
    }

    /**
     * Concatenates two arrays of objects.
     * 
     * @param <T> the array type
     * @param target the target array of size of (at last) the sum of the size of <code>a1</code> and <code>a2</code>
     * @param a1 the first array
     * @param a2 the second array
     * @return <code>target</code>
     */
    private static <T> T[] concat(T[] target, T[] a1, T[] a2) {
        System.arraycopy(a1, 0, target, 0, a1.length);
        System.arraycopy(a2, 0, target, a1.length, a2.length);
        return target;
    }

}
