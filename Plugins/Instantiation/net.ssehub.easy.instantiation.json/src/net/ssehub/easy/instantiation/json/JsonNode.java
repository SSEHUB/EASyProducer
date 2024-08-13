/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.Map;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;

/**
 * Represents an untyped node in the YAML document tree.
 * 
 * @author Holger Eichelberger
 */
public class JsonNode implements IVilType, IStringValueProvider {

    private java.util.Map<String, Object> data;

    /**
     * Creates an empty instance.
     */
    JsonNode() {
        data = new HashMap<>();
    }
    
    /**
     * Creates an instance with given (typed) data map.
     * 
     * @param data the data map
     */
    JsonNode(java.util.Map<String, Object> data) {
        this.data = data;
    }
    
    /**
     * Creates an instance with arbitrry data from reading a YAML file.
     * 
     * @param data the data
     */
    JsonNode(Object data) {
        this();
        if (data instanceof Map) {
            Map<?, ?> value = (Map<?, ?>) data;
            for (Object key: value.keys()) {
                Object val = value.get(key);
                this.data.put(key.toString(), val); // TODO more key conversion, recursive?
            }
        }
    }
    
    /**
     * Creates an instance (VIL constructor).
     * 
     * @return the instance
     */
    public static JsonNode create() {
        return new JsonNode();
    }

    /**
     * Adds a single value.
     * 
     * @param name the name of the field
     * @param value the value
     * @return <b>this</b> for chaining
     */
    public JsonNode addValue(String name, Object value) {
        data.put(name, value);
        return this;
    }

    /**
     * Adds an object as sub-structure.
     * 
     * @param name the name of the field
     * @return the node representing the object
     */
    public JsonNode addObject(String name) {
        JsonNode node = new JsonNode(new HashMap<String, Object>());
        data.put(name, node);
        return node;
    }

    /**
     * Deletes a field and its value.
     * 
     * @param name the name of the field
     * @return <b>this</b> for chaining
     */
    public JsonNode delete(String name) {
        data.remove(name);
        return this;
    }

    /**
     * Adds a field with value list.
     * 
     * @param name the name of the field
     * @param value the value
     * @return <b>this</b> for chaining
     */
    public JsonNode addList(String name, Sequence<?> value) {
        List<Object> tmp = new ArrayList<Object>();
        for (Object o : value) {
            tmp.add(o);
        }
        data.put(name, tmp);
        return this;
    }

    /**
     * Adds the fields within the given map to this node.
     * 
     * @param value the map value(s)
     * @return <b>this</b> for chaining
     */
    public JsonNode addValues(Map<?, ?> value) {
        for (Object key: value.keys()) {
            Object val = value.get(key);
            data.put(key.toString(), val); // TODO more key conversion, recursive?
        }
        return this;
    }
    
    /**
     * Adds a field with value map.
     * 
     * @param name the name of the field
     * @param value the value
     * @return <b>this</b> for chaining
     */
    public JsonNode addMap(String name, Map<?, ?> value) {
        java.util.Map<String, Object> tmp = new HashMap<>();
        for (Object key: value.keys()) {
            Object val = value.get(key);
            tmp.put(key.toString(), val); // TODO more key conversion, recursive?
        }
        data.put(name, tmp);
        return this;
    }

    /**
     * Returns the data in this node, formatted to be usedful for snakeyaml.
     * 
     * @return the data
     */
    @Invisible
    java.util.Map<String, Object> getData() {
        java.util.Map<String, Object> result = new HashMap<>();
        for (String key: data.keySet()) {
            Object value = data.get(key);
            if (value instanceof JsonNode) {
                value = ((JsonNode) value).getData();
            }
            result.put(key, value);
        }
        return result;
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return comparator.inTracer() ? "JsonNode" : data.toString();
    }

}
