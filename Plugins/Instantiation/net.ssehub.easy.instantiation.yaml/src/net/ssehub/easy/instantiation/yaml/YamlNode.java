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
package net.ssehub.easy.instantiation.yaml;

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
public class YamlNode implements IVilType, IStringValueProvider, INodeParent {

    private java.util.Map<String, Object> data;
    private INodeParent parent;

    /**
     * Creates an empty instance.
     * 
     * @param parent the parent to notify about changes
     */
    YamlNode(INodeParent parent) {
        data = new HashMap<>();
        setParent(parent);
    }
    
    /**
     * Creates an instance with given (typed) data map.
     * 
     * @param data the data map
     * @param parent the parent to notify about changes
     */
    YamlNode(java.util.Map<String, Object> data, INodeParent parent) {
        this.data = data;
        setParent(parent);
    }
    
    /**
     * Creates an instance with arbitrary data from reading a YAML file.
     * 
     * @param data the data
     * @param parent the parent to notify about changes
     */
    YamlNode(Object data, INodeParent parent) {
        this(parent);
        if (data instanceof Map) {
            Map<?, ?> value = (Map<?, ?>) data;
            for (Object key: value.keys()) {
                Object val = value.get(key);
                this.data.put(key.toString(), val); // TODO more key conversion, recursive?
            }
        }
    }
    
    void setParent(INodeParent parent) {
        this.parent = parent;
    }
    
    /**
     * Creates an instance (VIL constructor).
     * 
     * @return the instance
     */
    public static YamlNode create() {
        return new YamlNode(null);
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
    public YamlNode addValue(String name, Object value) {
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
    public YamlNode addObject(String name) {
        YamlNode node = new YamlNode(new ClassMap(), this);
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
    public YamlNode delete(String name) {
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
    public YamlNode addList(String name, Sequence<?> value) {
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
    public YamlNode addValues(Map<?, ?> value) {
        for (Object key: value.keys()) {
            Object val = value.get(key);
            data.put(key.toString(), val); // TODO more key conversion, recursive?
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
    public YamlNode addMap(String name, Map<?, ?> value) {
        java.util.Map<String, Object> tmp = new HashMap<>();
        for (Object key: value.keys()) {
            Object val = value.get(key);
            tmp.put(key.toString(), val); // TODO more key conversion, recursive?
        }
        data.put(name, tmp);
        notifyChanged();
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
            if (value instanceof YamlNode) {
                value = ((YamlNode) value).getData();
            }
            result.put(key, value);
        }
        return result;
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return null != comparator && comparator.inTracer() ? "YamlNode" : data.toString();
    }

    @Override
    public void notifyChanged() {
        if (null != parent) {
            parent.notifyChanged();
        }
    }

}