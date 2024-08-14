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

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import net.ssehub.easy.basics.DefaultLocale;
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
public class JsonNode implements IVilType, IStringValueProvider, INodeParent {

    private java.util.Map<String, Object> data;
    private INodeParent parent;

    /**
     * Creates an empty instance.
     *
     * @param parent the node parent
     */
    JsonNode(INodeParent parent) {
        data = new HashMap<>();
        this.parent = parent;
    }
    
    /**
     * Creates an instance with given (typed) data map.
     * 
     * @param data the data map
     * @param parent the node parent
     */
    JsonNode(java.util.Map<String, Object> data, INodeParent parent) {
        this.data = data;
        this.parent = parent;
    }
    
    /**
     * Creates an instance with arbitrry data from reading a YAML file.
     * 
     * @param data the data
     * @param parent the node parent
     */
    JsonNode(Object data, INodeParent parent) {
        this(parent);
        if (data instanceof Map) {
            Map<?, ?> value = (Map<?, ?>) data;
            for (Object key: value.keys()) {
                Object val = value.get(key);
                this.data.put(key.toString(), val);
            }
        }
    }
    
    /**
     * Returns whether a field for {@code name} is known / was added before.
     * 
     * @param name the name of the field
     * @return {@code true} if the field exists, {@code false} else
     */
    public boolean has(String name) {
        return data.containsKey(name);
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
        notifyChanged();
        return this;
    }

    /**
     * Adds an object as sub-structure.
     * 
     * @param name the name of the field
     * @return the node representing the object
     */
    public JsonNode addObject(String name) {
        JsonNode node = new JsonNode(new HashMap<String, Object>(), this);
        data.put(name, node);
        notifyChanged();
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
        notifyChanged();
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
        notifyChanged();
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
            data.put(key.toString(), val);
        }
        notifyChanged();
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
            tmp.put(key.toString(), val);
        }
        data.put(name, tmp);
        notifyChanged();
        return this;
    }

    enum Sorting {
        
        NONE,
        ALPHA,
        COLLATOR
        
    }

    /**
     * Returns the data in this node, formatted to be useful for snakeyaml.
     * 
     * @param sorting the sorting mode
     * @return the data
     */
    @Invisible
    java.util.Map<String, Object> getData(Sorting sorting) {
        java.util.Map<String, Object> result;
        switch (sorting) {
        case ALPHA:
            result = new TreeMap<>((k1, k2) -> k1.compareTo(k2));
            break;
        case COLLATOR:
            result = new TreeMap<>(Collator.getInstance(DefaultLocale.getDefaultLocale()));
            break;
        default: // including NONE
            result = new HashMap<>();
            break;
        }
        for (String key: data.keySet()) {
            Object value = data.get(key);
            if (value instanceof JsonNode) {
                value = ((JsonNode) value).getData(sorting);
            }
            result.put(key, value);
        }
        return result;
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return null != comparator && comparator.inTracer() ? "JsonNode" : data.toString();
    }

    @Override
    public void notifyChanged() {
        if (null != parent) {
            parent.notifyChanged();
        }
    }

}
