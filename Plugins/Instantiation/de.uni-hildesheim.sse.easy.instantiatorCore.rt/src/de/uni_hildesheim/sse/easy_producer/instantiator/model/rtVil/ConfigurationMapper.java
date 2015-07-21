/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Provides a mapping service for runtime variables into a given configuration. This class provides the generic mapping 
 * within IVML/VIL, while the domain specific mapping is done by {@link IValueMapper}. Provides automatic mappings for 
 * the Java basic types.
 * 
 * @author Holger Eichelberger
 */
public class ConfigurationMapper {

    private static final Map<Class<?>, IValueConverter<?>> CONVERTERS = new HashMap<Class<?>, IValueConverter<?>>();
    
    static {
        registerValueConverter(new SimpleConverter<Boolean>(Boolean.class, BooleanType.TYPE));
        registerValueConverter(new SimpleConverter<Integer>(Integer.class, IntegerType.TYPE));
        registerValueConverter(new SimpleConverter<Long>(Long.class, IntegerType.TYPE));
        registerValueConverter(new SimpleConverter<Double>(Double.class, RealType.TYPE));
        registerValueConverter(new SimpleConverter<Float>(Float.class, RealType.TYPE));
        registerValueConverter(new SimpleConverter<Short>(Short.class, IntegerType.TYPE));
        registerValueConverter(new SimpleConverter<Character>(Character.class, StringType.TYPE));
        registerValueConverter(new SimpleConverter<String>(String.class, StringType.TYPE));
    }
    
    private Configuration configuration;
    private IValueMapper valueMapper;
    
    private List<IDecisionVariable> runtimeVariables = new ArrayList<IDecisionVariable>();

    /**
     * Performs the domain/application specific mapping. 
     * 
     * @author Holger Eichelberger
     */
    public interface IValueMapper {
        
        /**
         * Returns whether an unfrozen variable is domain/application-relevant or shall be left unmapped.
         * 
         * @param variable the variable to be considered
         * @return <code>true</code> if <code>variable</code> is relevant, <code>false</code> else
         */
        public boolean isRelevant(IDecisionVariable variable);
        
        /**
         * Maps a value to <code>variable</code>. May set the value directly or, for in case of registered value 
         * converters (convenience) return a value that can be mapped automatically into IVML.
         * 
         * @param variable the variable the value shall be mapped into
         * @return the object value to be converted, <b>null</b> if the value was already set
         */
        public Object mapValue(IDecisionVariable variable);
        
    }

    /**
     * Converts a runtime object value to an IVML value object if possible. We introduce value converters
     * as a convenience for the domain-specific mapping in {@link IValueMapper}.
     * 
     * @param <T> the source type
     * @author Holger Eichelberger
     */
    protected interface IValueConverter<T> {
       
        /**
         * Converts the object value to an IVML value.
         * 
         * @param value the value to be converted
         * @return the converted value
         * @throws ValueDoesNotMatchTypeException in case that the value cannot be converted
         */
        public Value convert(Object value) throws ValueDoesNotMatchTypeException;
        
        /**
         * The target type to convert from.
         * 
         * @return the source type
         */
        public Class<T> getSourceType();
        
    }
    
    /**
     * Implements a simple converter directly calling the {@link ValueFactory}.
     * 
     * @param <T> the source type
     * @author Holger Eichelberger
     */
    protected static class SimpleConverter<T> implements IValueConverter<T> {

        private Class<T> sourceType;
        private IDatatype targetType;
        
        /**
         * Creates a simple converter.
         * 
         * @param sourceType the (Java) source type
         * @param targetType the (IVML) target type
         */
        protected SimpleConverter(Class<T> sourceType, IDatatype targetType) {
            this.sourceType = sourceType;
            this.targetType = targetType;
        }
        
        @Override
        public Value convert(Object value) throws ValueDoesNotMatchTypeException {
            return ValueFactory.createValue(targetType, value);
        }

        @Override
        public Class<T> getSourceType() {
            return sourceType;
        }
        
    }
    
    /**
     * Creates a configuration mapper.
     * 
     * @param configuration the configuration to perform the mapping for.
     * @param valueMapper the domain-specific value mapper
     * 
     */
    public ConfigurationMapper(Configuration configuration, IValueMapper valueMapper) {
        this(configuration);
        setValueMapper(valueMapper);
    }

    /**
     * Creates an unfinished configuration mapper. Call {@link #setValueMapper(IValueMapper)} to complete.
     * 
     * @param configuration the configuration to perform the mapping for.
     */
    protected ConfigurationMapper(Configuration configuration) {
        this.configuration = configuration;
    }
    
    /**
     * Defines the value mapper.
     * 
     * @param valueMapper the value mapper
     */
    protected void setValueMapper(IValueMapper valueMapper) {
        if (null != valueMapper) {
            this.valueMapper = valueMapper;
            collectAll(null);
        }
    }

    /**
     * Registers a value converter. Overrides existing registrations.
     * 
     * @param <T> the converter target type
     * @param converter the converter to be registered (ignored if <b>null</b>)
     * @return <code>true</code> if successful, <code>false</code> else
     */
    protected static <T> boolean registerValueConverter(IValueConverter<T> converter) {
        boolean done = false;
        if (null != converter) {
            Class<?> type = converter.getSourceType();
            if (null != type) {
                CONVERTERS.put(type, converter);
                done = true;
            }
        }
        return done;
    }

    /**
     * Unregisters a value converter.
     * 
     * @param <T> the converter target type
     * @param converter the converter to be unregistered
     * @return <code>true</code> if successful, <code>false</code> else
     */
    protected static <T> boolean unregisterValueConverter(IValueConverter<T> converter) {
        boolean done = false;
        if (null != converter) {
            Class<?> type = converter.getSourceType();
            if (null != type) {
                CONVERTERS.remove(type);
                done = true;
            }
        }
        return done;
    }

    /**
     * Updates this configuration, e.g., if the configuration is changed structurally.
     */
    public void update() {
        Set<IDecisionVariable> done = new HashSet<IDecisionVariable>();
        done.addAll(runtimeVariables);
        collectAll(done);
    }
    
    /**
     * Collects all variables in {@link #configuration}.
     * 
     * @param done optional set of already collected variables (may be <b>null</b> to be ignored)
     */
    private void collectAll(Set<IDecisionVariable> done) {
        Iterator<IDecisionVariable> iter = configuration.iterator();
        while (iter.hasNext()) {
            IDecisionVariable var = iter.next();
            collect(var, done);
        }
    }

    /**
     * Collects the variables for {@link #runtimeVariables}. Unfrozen 
     * {@link IValueMapper#isRelevant(IDecisionVariable) relevant} variables are collected if not already 
     * <code>done</code>.
     * 
     * @param variable the variable to be collected / considered
     * @param done optional set of already collected variables (may be <b>null</b> to be ignored)
     */
    private void collect(IDecisionVariable variable, Set<IDecisionVariable> done) {
        if (variable.getState() != AssignmentState.FROZEN && valueMapper.isRelevant(variable)) {
            boolean collect = true;
            if (null != done) {
                if (!done.contains(variable)) {
                    done.add(variable);
                } else {
                    collect = false;
                }
                if (collect) {
                    runtimeVariables.add(variable);
                    for (int e = 0, n = variable.getNestedElementsCount(); e < n; e++) {
                        collect(variable.getNestedElement(e), done);
                    }
                }
            }
        }
    }
    
    /**
     * Maps the values of all runtime variables. Calls {@link IValueMapper#mapValue(IDecisionVariable)}.
     */
    public void mapValues() {
        for (int v = 0, n = runtimeVariables.size(); v < n; v++) {
            IDecisionVariable variable = runtimeVariables.get(v);
            Object value = valueMapper.mapValue(variable);
            if (null != value) {
                try {
                    Value val = CONVERTERS.get(value.getClass()).convert(value);
                    if (null != val) {
                        variable.setValue(val, AssignmentState.ASSIGNED);
                    }
                } catch (ConfigurationException e) {
                    logErrorWhile(variable, "while wetting the value for ", e);
                } catch (ValueDoesNotMatchTypeException e) {
                    logErrorWhile(variable, "while converting the value for ", e);
                }
            }
        }
    }
    
    /**
     * Logs an error while converting or setting the value of <code>variable</code>.
     * 
     * @param variable the decision variable to be modified (to take the name from)
     * @param text the text to be emitted before the variable name
     * @param exc the exception to take the error message from
     */
    private static void logErrorWhile(IDecisionVariable variable, String text, Exception exc) {
        getLogger().error(text + " " + variable.getDeclaration().getQualifiedName() + ": " + exc.getMessage());
    }
    
    /**
     * Returns the logger to be used within this class.
     * 
     * @return the logger
     */
    private static EASyLogger getLogger() {
        return EASyLoggerFactory.INSTANCE.getLogger(ConfigurationMapper.class, Bundle.ID);
    }
    
    /**
     * Returns the underlying configuration.
     * 
     * @return the configuration
     */
    public Configuration getConfiguration() {
        return configuration;
    }
    
    /**
     * Returns the value mapper.
     * 
     * @return the value mapper
     */
    public IValueMapper getValueMapper() {
        return valueMapper;
    }
    
}
