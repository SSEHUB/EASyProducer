/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.rt.core.model.confModel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.ssehub.easy.instantiation.rt.core.model.rtVil.Bundle;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * A configuration, which can store additional temporary values. These values are ignored by the configuration and
 * other components until the {@link #takeOverValues()} method is called. <br/><br/>
 * 
 * This configuration should be used if much more value changes are expected than reasonings are needed.<br/><br/>
 * <b>Attention</b> Currently, only the following variable types are supported:
 * <ul>
 *   <li>Top level variables</li>
 *   <li>Variables nested in a top level compound (not multiple nested)</li>
 * </ul>
 * <br/>
 * <b>Manual:</b>
 * <ol>
 *   <li>Create AdaptiveConfiguration with appropriate {@link AbstractVariableIdentifier}</li>
 *   <li>Add values via the {@link #addValue(Object, Object)} method</li>
 *   <li>Call the {@link #takeOverValues()} before reasoning</li>
 * </ol>
 * <br/>
 * <b>Example:</b>
 * <pre><code>
 * AdaptiveConfiguration aConfig = new AdaptiveConfiguration&lt;IDecisionVariable&gt;(config,
 *     new IDecisionVariableIdentifier());
 * aConfig.addValue(intVar, 2);
 * ...
 * aConfig.takeOverValues();
 * </code></pre>
 * @param <V> specifies which kind of classes are used to reference {@link IDecisionVariable}s before the values
 * are stored in the {@link IDecisionVariable}s via the {@link #takeOverValues()} method.
 * @author El-Sharkawy
 */
public class AdaptiveConfiguration<V> {

    private Map<String, Object> unsavedValues;
    private AbstractVariableIdentifier<V> identifier;
    private Configuration config;
    
    /**
     * Constructor to create a fresh adaptive configuration based on a {@link Project}.
     * @param config The configuration which shall be manipulated during runtime.
     * @param identifier Maps configured elements to IDs, so that they can easily mapped back to
     * {@link IDecisionVariable}s during the {@link #takeOverValues()} method. The default implementation
     * is the {@link IDecisionVariableIdentifier}.
     */
    public AdaptiveConfiguration(Configuration config, AbstractVariableIdentifier<V> identifier) {
        this.config = config;
        this.identifier = identifier;
        unsavedValues = new HashMap<String, Object>();
    }
    
    /**
     * Takes the temporary values (added via {@link #addValue(String, Object)})
     * over to the nested {@link IDecisionVariable}s.
     * This is necessary to make the values visible to outside of this configuration, e.g., reasoner, UI, ...
     */
    public synchronized void takeOverValues() {
        if (!unsavedValues.isEmpty()) {
            /* 
             * Attention: Since unsavedValues is not synchronized, this may drop some few values in special situations,
             * but I assume that this is not relevant and this implementation should be faster.
             * Check this in future if this becomes relevant.
             */
            Map<String, Object> tempValue = unsavedValues;
            unsavedValues = new HashMap<String, Object>();
            
            /*
             * Iterate over variables: I assume this list is longer, but runtime should be O(n),
             * iteration over values should be O(n^2)
             */
            Iterator<IDecisionVariable> varItr = config.iterator();
            while (varItr.hasNext() && !tempValue.isEmpty()) {
                IDecisionVariable topVar = varItr.next();
                String id = identifier.iDecisionVariableToID(topVar);
                topVar = identifier.mapVariable(topVar);
                Object newValue = tempValue.get(id);
                if (null != newValue) {
                    // Replace value with recent value
                    convertMappedValue(topVar, newValue);
                    
                    // remove value to facilitate abortion of loop
                    tempValue.remove(id);
                }
            }
            if (!tempValue.isEmpty()) {
                /* 
                 * Some elements are not part of the model, e.g., intermediate spouts.
                 * Thus, logging only an info and not a warning.
                 */
                Bundle.getLogger(AdaptiveConfiguration.class).info("Some values could not be stored: " + tempValue);
            }
        }
    }
    /**
     * Recursive part of the {@link #takeOverValues()} method to convert the temporary variable mapping into
     * {@link Value}s.
     * @param variable The variable for which the value should be converted. When called from another method, this
     *     should be a top level variable of the configuration.
     * @param oValue The temporary object value as passed to the {@link #addValue(String, Object)} method.
     */
    private void convertMappedValue(IDecisionVariable variable, Object oValue) {
        if (oValue instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> map = (Map<String, Object>) oValue;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                // TODO SE: Handle key and nested types recursive
                String slotName = entry.getKey();
                IDecisionVariable nestedVariable = variable.getNestedElement(slotName);
                if (null != nestedVariable) {
                    convertMappedValue(nestedVariable, entry.getValue());
                }
            }
        } else {
            try {
                Value value = identifier.toIVMLValue(variable, oValue);
                identifier.assignValue(variable, value);
            } catch (ValueDoesNotMatchTypeException e) {
                // Do nothing, ignore Value and log error
                Bundle.getLogger(AdaptiveConfiguration.class).exception(e);
            } catch (ConfigurationException e) {
                Bundle.getLogger(AdaptiveConfiguration.class).exception(e);
            }
        }
    }
    
    /**
     * Adds a temporary value to this configuration. This value won't be used until the take {@link #takeOverValues()}
     * method is used.
     * @param id The id representing the specified variable
     *     (cf. {@link AbstractVariableIdentifier#variableToID(Object)}).
     * @param value The object value to save, must be in a form that the {@link ValueFactory} can handle it.
     */
    public void addValue(String id, Object value) {
        if (identifier.isNestedVariable(id)) {
            Iterator<String> idItr = identifier.getIDIterator(id);
            value = identifier.mapValue(id, value);
            // Value of a slot in a compound
            String cmpName = idItr.next();
            String slotName = idItr.next();
            @SuppressWarnings("unchecked")
            Map<String, Object> cmpValueMap = (Map<String, Object>) unsavedValues.get(cmpName);
            if (null == cmpValueMap) {
                cmpValueMap = new HashMap<String, Object>();
                unsavedValues.put(cmpName, cmpValueMap);
            }
            // TODO SE: Full recursion if compound is nested in compound
            cmpValueMap.put(slotName, value);
        } else {
            unsavedValues.put(id, value);
        }
    }
    
    /**
     * Adds a temporary value to this configuration. This value won't be used until the take {@link #takeOverValues()}
     * method is used.
     * @param var The variable for which the value should be saved.
     * @param value The object value to save, must be in a form that the {@link ValueFactory} can handle it.
     */
    public void addValue(V var, Object value) {
        addValue(identifier.variableToID(var), value);
    }
    
    /**
     * Adds an already existing mapping to this configuration.
     * @param mapping An already existing mapping in the form of
     *   <code>&lt;id for a (nested) variable, value&gt;</code>
     *   When using this option, the caller must ensure that the correct mapping was used.
     */
    public void addValues(Map<String, Object> mapping) {
        for (Map.Entry<String, Object> entry : mapping.entrySet()) {
            addValue(entry.getKey(), entry.getValue());
        }
    }
}
