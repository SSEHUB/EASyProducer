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
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.Map;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Represents an untyped node in the YAML document tree.
 * 
 * @author Holger Eichelberger
 */
public class JsonNode implements IVilType, IStringValueProvider, INodeParent {

    private java.util.Map<String, Object> data;
    private List<String> sequence = new ArrayList<>();
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
        if (data instanceof java.util.Map) {
            java.util.Map<?, ?> value = (java.util.Map<?, ?>) data;
            for (Object key: value.keySet()) {
                Object val = value.get(key);
                set(key.toString(), val, false);
            }
        }
    }

    /**
     * Sets the value of {@code key} to {@code val} and records the (first) insertion position.
     * 
     * @param key the key/field name
     * @param val the value
     * @param notify enable calling {@link #notifyChanged()}
     */
    private void set(String key, Object val, boolean notify) {
        if (null == data.put(key, IVilType.convertVilValue(val))) { // just take the first position
            sequence.add(key);
        }
        if (notify) {
            notifyChanged();
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
        set(name, value, true);
        notifyChanged();
        return this;
    }
    
    /**
     * Adds a single value if the value is not considered empty (String).
     * 
     * @param name the name of the field
     * @param value the value
     * @return <b>this</b> for chaining
     */
    public JsonNode addValueNotEmpty(String name, Object value) {
        boolean add = true;
        if (value instanceof String) {
            add = !((String) value).isEmpty();
        }
        if (add) {
            addValue(name, value);
        }
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
        set(name, node, true);
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
        sequence.remove(name);
        notifyChanged();
        return this;
    }
    
    /**
     * Returns the value of a field.
     * 
     * @param name the name of the field
     * @return the value, may be <b>null</b>, a list, a map, ..
     * @see #has(String)
     */
    public Object getValue(String name) {
        return data.get(name);
    }

    /**
     * Returns the value of a field as a list.
     * 
     * @param name the name of the field
     * @return the value as a list, may be <b>null</b> if it does not exist/is not a list, ..
     * @see #isList(String)
     */
    public Sequence<Object> getListValue(String name) {
        Sequence<Object> result = null;
        if (isList(name)) {
            @SuppressWarnings("unchecked")
            List<Object> tmp = (List<Object>) data.get(name);
            result = new ListSequence<Object>(tmp, TypeRegistry.anyType());
        }
        return result;
    }
    
    /**
     * Returns whether the value of {@code name} is a list.
     * 
     * @param name the name of the field
     * @return {@code true} for list, {@code false} else
     */
    public boolean isList(String name) {
        return data.get(name) instanceof List;
    }

    /**
     * Returns the value of a field as a map.
     * 
     * @param name the name of the field
     * @return the value as a map, may be <b>null</b> if it does not exist/is not a map, ..
     * @see #isMap(String)
     */
    public Map<String, Object> getMapValue(String name) {
        Map<String, Object> result = null;
        if (isList(name)) {
            @SuppressWarnings("unchecked")
            java.util.Map<Object, Object> tmp = (java.util.Map<Object, Object>) data.get(name);
            TypeDescriptor<?>[] types = TypeDescriptor.createArray(2);
            types[0] = TypeRegistry.stringType();
            types[1] = TypeRegistry.anyType();
            result = new Map<String, Object>(tmp, types);
        }
        return result;
    }
    
    /**
     * Returns whether the value of {@code name} is a map.
     * 
     * @param name the name of the field
     * @return {@code true} for map, {@code false} else
     */
    public boolean isMap(String name) {
        return data.get(name) instanceof Map;
    }

    /**
     * Returns the value of a field as an object node.
     * 
     * @param name the name of the field
     * @return the value as a node, may be <b>null</b> if it does not exist/is not an object, ..
     * @see #has(String)
     */
    public JsonNode getObject(String name) {
        return isObject(name) ? new JsonNode((Map<?, ?>) data.get(name), this) : null;
    }

    /**
     * Returns whether the value of {@code name} is an object.
     * 
     * @param name the name of the field
     * @return {@code true} for object, {@code false} else
     */
    public boolean isObject(String name) {
        return data.get(name) instanceof Map;
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
            tmp.add(IVilType.convertVilValue(o));
        }
        set(name, tmp, true);
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
            set(key.toString(), val, false);
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
            Object val = IVilType.convertVilValue(value.get(key));
            tmp.put(key.toString(), val);
        }
        set(name, tmp, true);
        return this;
    }

    /**
     * Defines the sorting mode of maps/objects.
     * 
     * @author Holger Eichelberger
     */
    enum Sorting {
        
        /**
         * No sorting, implementation dependent.
         */
        NONE,
        
        /**
         * Insert/adding/reading sequence.
         */        
        INSERT,
        
        /**
         * Alphanumerical according to field/key names.
         */        
        ALPHA,
        
        /**
         * Locale/language based according to field/key names.
         */
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
        case INSERT:
            final java.util.Map<String, Integer> seq = new HashMap<>();
            for (int i = 0; i < sequence.size(); i++) {
                seq.put(sequence.get(i), i);
            }
            result = new TreeMap<>((f1, f2) -> Integer.compare(seq.get(f1), seq.get(f2)));
            break;
        case ALPHA:
            result = new TreeMap<>((f1, f2) -> f1.compareTo(f2));
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
        return null != comparator ? "JsonNode" : data.toString();
    }

    @Override
    public void notifyChanged() {
        if (null != parent) {
            parent.notifyChanged();
        }
    }

}
