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
package net.ssehub.easy.varModel.varModel.testSupport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.varModel.confModel.AbstractConfigurationStatisticsVisitor;
import net.ssehub.easy.varModel.confModel.AbstractConfigurationStatisticsVisitor.ConfigStatistics;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.varModel.testSupport.MeasurementStatisticsVisitor.MeasurementStatistics;

/**
 * Extensible measurements collection mechanism to be applied while running a test suite. Aims at collecting 
 * performance data, potentially also detecting performance regression in the future. 
 * <p/>
 * Measurements are identified by {@link IMeasurementIdentifier} defined in testing scope only. For practical reasons, 
 * it is sometimes easier to use different identifiers, e.g., defined in production code. Therefore, the measurement
 * collector allows registering a global mapping between identifiers using 
 * {@link #registerMapping(Object, IMeasurementIdentifier)} and the respective method accept an Object that is mapped
 * internally (nothing happens if no mapping is possible, directly passing in a {@link IMeasurementIdentifier} 
 * is permitted).
 * <p/>
 * Some measurements can be done automatically, e.g., aggregation, averaging or measuring the entire (wall) response
 * time {@link DefaultMeasurementIdentifier#RESPONSETIME}. For automatic measurements, collectors can be registered
 * globally {@link #registerAutoCollector(IAutoCollector), which are called when starting or stopping a measurment.
 * <p/>
 * There are two ways of collecting measurement data:
 * <ol>
 *     <li>All values at once, call {@link #recordMeasurements(Configuration, String, Map) or on the actual instance
 *         {@link #record(Configuration, String, Map).</li>
 *     <li>Within the brackets of {@link #startMeasurement(Configuration, String, boolean)} 
 *         and {@link #endMeasurement(MeasurementRecord)} returning a unique identifier to be used with further calls. 
 *         Individual measurements can be added by 
 *         {@link #setMeasurement(String, IMeasurementIdentifier, double)} and read out by 
 *         {@link #getMeasurement(String, IMeasurementIdentifier)}. For the actual instance, the methods are 
 *         {@link #start(Configuration, String)}, {@link #end()}, {@link #set(IMeasurementIdentifier, double)}, 
 *         and {@link #get(String, IMeasurementIdentifier)}.</li>
 * </ol>
 * The default implementation in this class does nothing rather than providing the infrastructure. Concrete subclasses
 * may e.g. log into a file or a database.
 *  
 * @author Holger Eichelberger
 */
public class MeasurementCollector {

    private static MeasurementCollector instance = new MeasurementCollector("DEFAULT");
    private static Map<Object, IMeasurementIdentifier> idMapping = new HashMap<Object, IMeasurementIdentifier>();
    private static List<IAutoCollector> autoCollectors = new ArrayList<IAutoCollector>();
    private static Set<String> stackStop = new HashSet<String>();
    private Map<String, MeasurementRecord> records = new HashMap<String, MeasurementRecord>();
    private Set<IMeasurementIdentifier> disabledCollectors = null;
    private Object id;
    
    /**
     * Implements automatic collection for some measurement identifiers.
     * @author Holger Eichelberger
     *
     */
    public interface IAutoCollector {
        
        /**
         * Returns the identifier we are recording for.
         * 
         * @return the identifier
         */
        public IMeasurementIdentifier getIdentifier();
        
        /**
         * The actual code for start collecting.
         * 
         * @param record the record being recorded
         */
        public void start(MeasurementRecord record);

        /**
         * The actual code for end collecting.
         * 
         * @param record the record being recorded
         */
        public void end(MeasurementRecord record);

    }
    
    /**
     * Defines the type for (extensible) measurement identifier.
     * 
     * @author Holger Eichelberger
     */
    public interface IMeasurementIdentifier {
        
        /**
         * Returns whether measurement data is obtained automatically, either as part of the 
         * start-/end bracket or also as part of a single record call.
         * 
         * @return <code>true</code> for automatic, <code>false</code> else
         */
        public boolean isAutomatic();
        
        /**
         * Returns the name of the identifier.
         * 
         * @return the name
         */
        public String name();
    }

    /**
     * Defines default measurement identifier.
     * 
     * @author Holger Eichelberger
     */
    public enum DefaultMeasurementIdentifier implements IMeasurementIdentifier {
        
        RESPONSETIME_AUTO(true),
        
        /**
         * Number of top-level variables in the model.
         * 
         * @see ConfigStatistics#noOfToplevelVariables()
         */
        MODEL_TOPLEVEL_VARIABLES(false), 

        /**
         * Number of variables in the model.
         * 
         * @see ConfigStatistics#noOfVariables()
         */
        MODEL_VARIABLES(false),

        /**
         * Number of variables without container in the model.
         * 
         * @see ConfigStatistics#noOfVariablesWithoutContainer()
         */
        MODEL_VARIABLES_WITHOUT_CONTAINER(false), 

        /**
         * Number of normal variables in the model.
         * 
         * @see ConfigStatistics#noOfNormalVariables()
         */
        MODEL_NORMAL_VARIABLES(false),

        /**
         * Number of normal variables without container in the model.
         * 
         * @see ConfigStatistics#noOfNormalVariablesNoContainer()
         */
        MODEL_NORMAL_VARIABLES_NO_CONTAINER(false),

        /**
         * Number of constraint variables in the model.
         * 
         * @see ConfigStatistics#noOfConstraintVariables()
         */
        MODEL_CONSTRAINT_VARIABLES(false),

        /**
         * Number of constraint variables without container in the model.
         * 
         * @see ConfigStatistics#noOfConstraintVariablesNoContainer()
         */
        MODEL_CONSTRAINT_VARIABLES_NO_CONTAINER(false),

        /**
         * Number of constraints in the model.
         * 
         * @see ConfigStatistics#noOfConstraintInstances()
         */
        MODEL_CONSTRAINT_INSTANCES(false),

        /**
         * Number of annotations in the model.
         * 
         * @see ConfigStatistics#noOfAnnotations()
         */
        MODEL_ANNOTATIONS(false),

        /**
         * Average constraint complexity as calculated by {@link MeasurementStatisticsVistor}.
         */
        MODEL_CONSTRAINT_AVG_COMPLEXITY(false),

        /**
         * Total constraint complexity as calculated by {@link MeasurementStatisticsVistor}.
         */
        MODEL_CONSTRAINT_COMPLEXITY(false),

        /**
         * Average variable complexity as calculated by {@link MeasurementStatisticsVistor}.
         */
        MODEL_VARIABLE_AVG_COMPLEXITY(false),
        
        /**
         * Total variable complexity as calculated by {@link MeasurementStatisticsVistor}.
         */
        MODEL_VARIABLE_COMPLEXITY(false),

        /**
         * Total model complexity as calculated by {@link MeasurementStatisticsVistor}.
         */
        MODEL_COMPLEXITY(false);
        
        private boolean isAutomatic;

        /**
         * Creates an identifier.
         * 
         * @param isAutomatic whether the measurement is performed automatically
         */
        private DefaultMeasurementIdentifier(boolean isAutomatic) {
            this.isAutomatic = isAutomatic;
        }

        @Override
        public boolean isAutomatic() {
            return isAutomatic;
        }
        
    }
    
    /**
     * Implements a measurement record.
     * 
     * @author Holger Eichelberger
     */
    protected static class MeasurementRecord {
        
        private Map<IMeasurementIdentifier, Double> measurements = new HashMap<IMeasurementIdentifier, Double>();
        private Configuration cfg;
        private String tag;
        private int runCount;
        private String caller;
        private long start = -1;
        private long end = -1;
        
        /**
         * Creates a measurement record.
         * 
         * @param cfg the configuration we are recording for
         * @param tag the measurement tag
         * @param runCount the repetition number of the experiment
         */
        protected MeasurementRecord(Configuration cfg, String tag, int runCount) {
            this.cfg = cfg;
            this.tag = tag;
            this.runCount = runCount;
            this.caller = null;
            
            Throwable t = new Throwable();
            StackTraceElement[] stack = t.getStackTrace();
            String lastSignature = null;
            for (int s = 0; null == caller && s < stack.length; s++) {
                StackTraceElement elt = stack[s];
                String clsName = elt.getClassName();
                boolean stop = stackStop.contains(clsName);
                if (!stop) {
                    int innerPos = clsName.lastIndexOf('$');
                    if (innerPos > 0) {
                        clsName = clsName.substring(0, innerPos);
                    }
                    stop = stackStop.contains(clsName);
                }
                if (stop) {
                    caller = lastSignature;
                }
                lastSignature = clsName + "." + elt.getMethodName();
            }
        }

        /**
         * Defines the start timestamp for automatically recording runtime. Starting shall explicitly happen after
         * creating the record for closer time recording.
         * 
         * @param start the start timestamp, invalid if negative
         */
        protected void setStart(long start) {
            this.start = start;
        }
        
        /**
         * Returns the start timestamp for automatically recording runtime.
         * 
         * @return the start timestamp, invalid if negative
         */
        protected long getStart() {
            return start;
        }

        /**
         * Defines the end timestamp for automatically recording runtime.
         * 
         * @param end the end timestamp, invalid if negative
         */
        protected void setEnd(long end) {
            this.end = end;
        }
        
        /**
         * Returns the end timestamp for automatically recording runtime.
         * 
         * @return the end timestamp, invalid if negative
         */
        protected long getEnd() {
            return end;
        }

        /**
         * Returns the recording tag.
         * 
         * @return the recording tag
         */
        protected String getTag() {
            return tag;
        }
        
        /**
         * Returns the experiment run count.
         * 
         * @return the run count
         */
        protected int getRunCount() {
            return runCount;
        }
        
        /**
         * Returns the calling method if available.
         * 
         * @return the calling method or <b>null</b> for none
         */
        protected String getCaller() {
            return caller;
        }
        
        /**
         * Returns the related configuration.
         * 
         * @return the configuration
         */
        protected Configuration getConfiguration() {
            return cfg;
        }

        /**
         * Sets a measurement value.
         * 
         * @param id the measurement id (ignored if <b>null</b>)
         * @param value the measurement value
         */
        protected void setMeasurement(IMeasurementIdentifier id, double value) {
            if (null != id) {
                measurements.put(id, value);
            }
        }
        
        /**
         * Returns the used measurement identifiers.
         * 
         * @return the used identifiers
         */
        protected Collection<IMeasurementIdentifier> getMeasurementIdentifiers() {
            return measurements.keySet();
        }
        
        /**
         * Returns the measurement for a given identifier.
         * 
         * @param id the identifier
         * @return the measurement <code>null</code> if not recorded or <code>id</code> was <b>null</b>
         */
        protected Double getMeasurement(IMeasurementIdentifier id) {
            return null == id ? null : measurements.get(id);
        }
        
        @Override
        public String toString() {
            return cfg.getProject().getName() + " " + tag + " " + runCount + " " + caller + " " + measurements;
        }
        
    }
    
    /**
     * Registers the default collectors.
     */
    static {
        registerAutoCollector(new IAutoCollector() {
            
            @Override
            public void start(MeasurementRecord record) {
            }
            
            @Override
            public void end(MeasurementRecord record) {
                long start = record.getStart();
                long end = record.getEnd();
                if (start >= 0 && end >= 0) {
                    record.setMeasurement(getIdentifier(), end - start);
                }
            }

            @Override
            public IMeasurementIdentifier getIdentifier() {
                return DefaultMeasurementIdentifier.RESPONSETIME_AUTO;
            }
        });
        // stop stack at typical jUnit callers
        stackStop.add("jdk.internal.reflect.NativeMethodAccessorImpl");
        stackStop.add("java.lang.reflect.Method");
        stackStop.add("org.junit.runners.model.FrameworkMethod");
        stackStop.add("sun.reflect.NativeMethodAccessorImpl"); // JDK8
        stackStop.add("sun.reflect.DelegatingMethodAccessorImpl"); // JDK8
    }
    
    /**
     * Creates a measurement collector.
     * 
     * @param id the id of the collector for checking whether an appropriate one is installed
     */
    public MeasurementCollector(Object id) {
        this.id = id;
    }
    
    /**
     * Returns the id of this collector.
     * 
     * @return the id
     */
    public Object getId() {
        return id;
    }
     
    /**
     * Changes the actual instance. If the actual instance is changed, this method closes the old instance.
     * 
     * @param collector the new instance (ignored if <b>null</b>)
     * @see #close()
     */
    public static final void setInstance(MeasurementCollector collector) {
        if (null != collector) {
            instance.close();
            instance = collector;
        }
    }

    /**
     * Returns the actual instance.
     * 
     * @return the actual instance
     */
    public static final MeasurementCollector getInstance() {
        return instance;
    }

    /**
     * Starts a measurement on the actual collector and keeps it open until {@link #endMeasurement(MeasurementRecord)}.
     * {@link #setMeasurement(String, IMeasurementIdentifier, double)} and 
     * {@link #getMeasurement(String, IMeasurementIdentifier)} can be called.
     * 
     * @param cfg the configuration to measure for
     * @param tag a description what is being measured
     * @param runCount the repetition number of the experiment
     * @return a unique measurement id for subsequent functions
     */
    public static String start(Configuration cfg, String tag, int runCount) {
        return instance.startMeasurement(cfg, tag, runCount);
    }
    
    /**
     * Starts a measurement and keeps it open until {@link #endMeasurement(MeasurementRecord)}.
     * {@link #setMeasurement(String, IMeasurementIdentifier, double)} and 
     * {@link #getMeasurement(String, IMeasurementIdentifier)} can be called.
     * 
     * @param cfg the configuration to measure for
     * @param tag a description what is being measured
     * @param runCount the repetition number of the experiment
     * @return a unique measurement id for subsequent functions
     */
    public String startMeasurement(Configuration cfg, String tag, int runCount) {
        String baseId = "" + System.currentTimeMillis();
        String id = baseId;
        int count = 0;
        while (records.containsKey(id)) {
            id = baseId + "-" + (count++);
        }
        MeasurementRecord record = new MeasurementRecord(cfg, tag, runCount);
        records.put(id, record);
        recordStatistics(cfg, record);
        record.setStart(System.currentTimeMillis());
        processAutoCollectors(record, true);
        for (int i = 0; i < autoCollectors.size(); i++) {
            autoCollectors.get(i).start(record);
        }
        return id;
    }
    
    /**
     * Processes the registerd auto collectors.
     * 
     * @param record the record to process for
     * @param start <code>true</code> for starting the measurement, <code>false</code> for ending
     */
    private void processAutoCollectors(MeasurementRecord record, boolean start) {
        for (int a = 0; a < autoCollectors.size(); a++) {
            IAutoCollector collector = autoCollectors.get(a);
            if (null == disabledCollectors || !disabledCollectors.contains(collector.getIdentifier())) {
                if (start) {
                    collector.start(record);
                } else {
                    collector.end(record);
                }
            }
        }
    }
    
    /**
     * Records statistics for <code>cfg</code>.
     * 
     * @param cfg the configuration
     * @param record the measurement record
     */
    private void recordStatistics(Configuration cfg, MeasurementRecord record) {
        AbstractConfigurationStatisticsVisitor sVis = createStatisticsVisitor();
        cfg.accept(sVis);
        ConfigStatistics statistics = sVis.getStatistics();
        storeStatistics(statistics, record);
    }

    /**
     * Changes a measurement on the actual instance. Does not permit 
     * {@link IMeasurementIdentifier#isAutomatic() automatic} measurements to be updated.
     * 
     * @param id the record identifier
     * @param identifier the measurement identifier
     * @param value the new value
     */
    public static void set(String id, Object identifier, double value) {
        instance.setMeasurement(id, identifier, value);
    }
    
    /**
     * Changes a measurement. Does not permit {@link IMeasurementIdentifier#isAutomatic() automatic}
     * measurements to be updated.
     * 
     * @param id the record identifier
     * @param identifier the measurement identifier
     * @param value the new value
     */
    public void setMeasurement(String id, Object identifier, double value) {
        IMeasurementIdentifier imIdentifier = obtainIdentifier(identifier);
        if (null != imIdentifier && !imIdentifier.isAutomatic()) {
            MeasurementRecord record = records.get(id);
            if (null != record) {
                record.setMeasurement(imIdentifier, value);
            }
        }
    }

    /**
     * Returns a recorded measurement from the actual instance.
     * 
     * @param id the record identifier
     * @param identifier the measurement identifier
     * @return the current value or <b>null</b> if nothing was recorded so far
     */
    public static Double get(String id, Object identifier) {
        return instance.getMeasurement(id, identifier);
    }
    
    /**
     * Returns a recorded measurement.
     * 
     * @param id the record identifier
     * @param identifier the measurement identifier
     * @return the current value or <b>null</b> if nothing was recorded so far
     */
    public Double getMeasurement(String id, Object identifier) {
        Double result = null;
        IMeasurementIdentifier imIdentifier = obtainIdentifier(identifier);
        if (null != imIdentifier) {
            MeasurementRecord record = records.get(id);
            if (null != record) {
                result = record.getMeasurement(imIdentifier);
            }
        }
        return result;
    }

    /**
     * Ends a measurement on the actual instance. <code>id</code> becomes invalid and operations based on 
     * <code>id</code> will not return results.
     * 
     * @param id the measurement identifier
     */
    public static void end(String id) {
        instance.endMeasurement(id);
    }
    
    /**
     * Completely ends a measurement. <code>id</code> becomes invalid and operations based on <code>id</code>
     * will not return results.
     * 
     * @param id the measurement identifier
     * @see #endAuto(String)
     */
    public void endMeasurement(String id) {
        endAutoMeasurements(id); // if not already done
        MeasurementRecord record = records.remove(id);
        if (null != record) {
            endMeasurement(record);
        }
    }

    /**
     * Ends automatic measurements.
     * 
     * @param id the measurement identifier
     */
    public static void endAuto(String id) {
        instance.endAutoMeasurements(id);
    }

    /**
     * Ends automatic measurements.
     * 
     * @param id the measurement identifier
     */
    public void endAutoMeasurements(String id) {
        long now = System.currentTimeMillis();
        MeasurementRecord record = records.get(id);
        if (null != record) {
            record.setEnd(now);
            processAutoCollectors(record, false);
        }
    }

    /**
     * Records a complete set of measurements at once on the actual collector. Id-based measurement operations are not 
     * supported here. Automatic recording of runtime is not happening.
     * 
     * @param cfg the configuration to measure for
     * @param tag a description what is being measured
     * @param runCount the repetition number of the experiment
     * @param measurements the measurements to set, automatic measurements will be ignored, registered mappings will 
     * be applied
     */
    public static void record(Configuration cfg, String tag, int runCount, Map<?, Double> measurements) {
        instance.recordMeasurements(cfg, tag, runCount, measurements);
    }
    
    /**
     * Records a complete set of measurements at once. Id-based measurement operations are not supported here. 
     * Automatic measurements are not modified.
     * 
     * @param cfg the configuration to measure for
     * @param tag a description what is being measured
     * @param runCount the repetition number of the experiment
     * @param measurements the measurements to set, automatic measurements will be ignored, registered mappings will 
     * be applied
     */
    public void recordMeasurements(Configuration cfg, String tag, int runCount, Map<?, Double> measurements) {
        MeasurementRecord record = new MeasurementRecord(cfg, tag, runCount);
        recordStatistics(cfg, record);
        for (Map.Entry<?, Double> ent : measurements.entrySet()) {
            IMeasurementIdentifier identifier = obtainIdentifier(ent.getKey());
            if (null != identifier && !identifier.isAutomatic()) {
                record.setMeasurement(identifier, ent.getValue());
            }
        }
        endMeasurement(record);
    }
    
    /**
     * Closes this collector. Closes also all still open measurement records.
     */
    public void close() {
        for (MeasurementRecord record : records.values()) {
            endMeasurement(record);
        }
        records.clear();
    }
    
    /**
     * Creates a (configured) statistics visitor ready to use.
     * 
     * @return the statistics visitor instance
     */
    protected AbstractConfigurationStatisticsVisitor createStatisticsVisitor() {
        return new MeasurementStatisticsVisitor();
    }
    
    /**
     * Stores the given statistics result in <code>record</code.
     * >
     * @param statistics the statistics object
     * @param record the record to modify as a side effect
     */
    protected void storeStatistics(ConfigStatistics statistics, MeasurementRecord record) {
        record.setMeasurement(DefaultMeasurementIdentifier.MODEL_TOPLEVEL_VARIABLES, 
            statistics.noOfToplevelVariables());
        record.setMeasurement(DefaultMeasurementIdentifier.MODEL_VARIABLES, 
            statistics.noOfVariables());
        record.setMeasurement(DefaultMeasurementIdentifier.MODEL_VARIABLES_WITHOUT_CONTAINER, 
            statistics.noOfVariablesWithoutContainer());
        record.setMeasurement(DefaultMeasurementIdentifier.MODEL_NORMAL_VARIABLES, 
            statistics.noOfNormalVariables());
        record.setMeasurement(DefaultMeasurementIdentifier.MODEL_NORMAL_VARIABLES_NO_CONTAINER, 
            statistics.noOfNormalVariablesNoContainer());
        record.setMeasurement(DefaultMeasurementIdentifier.MODEL_CONSTRAINT_VARIABLES, 
            statistics.noOfConstraintVariables());
        record.setMeasurement(DefaultMeasurementIdentifier.MODEL_CONSTRAINT_VARIABLES_NO_CONTAINER, 
            statistics.noOfConstraintVariablesNoContainer());
        record.setMeasurement(DefaultMeasurementIdentifier.MODEL_CONSTRAINT_INSTANCES, 
            statistics.noOfConstraintInstances());
        record.setMeasurement(DefaultMeasurementIdentifier.MODEL_ANNOTATIONS, 
            statistics.noOfAnnotations());
        // parameterization would be nice, requires parameterization of visitor
        if (statistics instanceof MeasurementStatistics) {
            MeasurementStatistics mStatistics = (MeasurementStatistics) statistics;
            record.setMeasurement(DefaultMeasurementIdentifier.MODEL_CONSTRAINT_AVG_COMPLEXITY, 
                mStatistics.getAverageConstraintComplexity());
            record.setMeasurement(DefaultMeasurementIdentifier.MODEL_CONSTRAINT_COMPLEXITY, 
                mStatistics.getConstraintComplexity());
            record.setMeasurement(DefaultMeasurementIdentifier.MODEL_VARIABLE_AVG_COMPLEXITY, 
                mStatistics.getAverageVariableComplexity());
            record.setMeasurement(DefaultMeasurementIdentifier.MODEL_VARIABLE_COMPLEXITY, 
                mStatistics.getVariableComplexity());
            record.setMeasurement(DefaultMeasurementIdentifier.MODEL_COMPLEXITY, 
                mStatistics.getModelComplexity());
        }
    }

    /**
     * Is called when a measurement record shall be ended.
     * 
     * @param record the record
     */
    protected void endMeasurement(MeasurementRecord record) {
    }

    /**
     * Register arbitrary global key-identifier mappings. Values given for <code>key</code> will be recorded for 
     * <code>identifier</code>.
     * 
     * @param key the key
     * @param identifier the identifier
     */
    public static void registerMapping(Object key, IMeasurementIdentifier identifier) {
        if (null != key && null != identifier) {
            idMapping.put(key, identifier);
        }
    }
    
    /**
     * Registers a global collector for an automatic measurement.
     * 
     * @param collector the collector
     * @return <code>true</code> for success, <code>false</code> else
     */
    public static boolean registerAutoCollector(IAutoCollector collector) {
        boolean done = false;
        if (null != collector && collector.getIdentifier().isAutomatic()) {
            autoCollectors.add(collector);
            done = true;
        }
        return done;
    }
    
    /**
     * Turns an object into an identifier if possible / mapping is registered.
     * 
     * @param key the key/object to return the identifier for
     * @return the identifier or <b>null</b> of no translation is possible
     */
    public static IMeasurementIdentifier obtainIdentifier(Object key) {
        IMeasurementIdentifier identifier = null;
        if (key instanceof IMeasurementIdentifier) {
            identifier = (IMeasurementIdentifier) key;
        } else if (null != key) {
            identifier = idMapping.get(key);
        }
        return identifier;
    }

    /**
     * Disables an automatic collector for the given <code>key</code> on the active measurement collector.
     * 
     * @param key the key to disable the collector for
     * @return <code>true</code> for success, <code>false</code> else
     */
    public static boolean disableAutoCollector(Object key) {
        return instance.disableCollector(key);
    }

    /**
     * Disables an automatic collector for the given <code>key</code>.
     * 
     * @param key the key to disable the collector for
     * @return <code>true</code> for success, <code>false</code> else
     */
    public boolean disableCollector(Object key) {
        boolean done = false;
        IMeasurementIdentifier identifier = obtainIdentifier(key);
        if (null != identifier && identifier.isAutomatic()) {
            if (null == disabledCollectors) {
                disabledCollectors = new HashSet<IMeasurementIdentifier>();
            }
            disabledCollectors.add(identifier);
            done = true;
        }
        return done;
    }
    
    /**
     * Allows defining class names where searching for the caller shall stop.
     * 
     * @param clsName the class name (ignored if <b>null</b>)
     */
    public static void addStackStop(String clsName) {
        if (null != clsName) {
            stackStop.add(clsName);
        }
    }
    
    /**
     * Returns a system property as integer.
     * 
     * @param key the property key
     * @param deflt the default value if the property is not set/cannot be parsed
     * @param min the minimum value to be returned
     * @return the value of the property
     */
    public static int getIntProperty(String key, int deflt, int min) {
        int result = deflt;
        String prop = System.getProperty(key, null);
        if (null != prop) {
            try {
                result = Integer.parseInt(prop);
            } catch (NumberFormatException e) {
                EASyLoggerFactory.INSTANCE.getLogger(MeasurementCollector.class, null).warn("Parsing env value for '" 
                    + key + "': Number Format Exception " + e.getMessage());
            }
        }
        return Math.max(min, result);
    }

}
