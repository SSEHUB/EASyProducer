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

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

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
public class YamlNode extends YamlStructure {

    private java.util.Map<String, Object> data;
    private List<String> sequence = new ArrayList<>();

    /**
     * Creates an empty instance.
     * 
     * @param parent the parent to notify about changes
     */
    YamlNode(INodeParent parent) {
        super(parent);
        data = new HashMap<>();
    }
    
    /**
     * Creates an instance with given (typed) data map.
     * 
     * @param data the data map
     * @param parent the parent to notify about changes
     */
    YamlNode(java.util.Map<String, Object> data, INodeParent parent) {
        super(parent);
        this.data = data;
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
                set(key.toString(), val, false); // TODO more key conversion, recursive?
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
        set(name, value, true);
        return this;
    }

    /**
     * Adds a single value if the value is not considered empty (String).
     * 
     * @param name the name of the field
     * @param value the value
     * @return <b>this</b> for chaining
     */
    public YamlNode addValueNotEmpty(String name, Object value) {
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
     * Adds a single value if the value, turns the value into null/none if considered empty (String).
     * 
     * @param name the name of the field
     * @param value the value
     * @return <b>this</b> for chaining
     */
    public YamlNode addValueOrNone(String name, Object value) {
        boolean add = true;
        if (value instanceof String) {
            if (((String) value).isEmpty()) {
                value = null;
            }
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
    public YamlNode addObject(String name) {
        YamlNode node = new YamlNode(new ClassMap(), this);
        set(name, node, true);
        return node;
    }
    
    /**
     * Adds multiple (empty) objects.
     * 
     * @param path the path of the object names
     * @param separators the separator(s) among the names
     * @return the last created node, may be <b>this</b> for none
     */
    public YamlNode addObjects(String path, String separators) {
        YamlNode result = this;
        StringTokenizer tokens = new StringTokenizer(path, separators);
        while (tokens.hasMoreTokens()) {
            result = result.addObject(tokens.nextToken());
        }
        return result;
    }

    /**
     * Deletes a field and its value.
     * 
     * @param name the name of the field
     * @return <b>this</b> for chaining
     */
    public YamlNode delete(String name) {
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
     * Returns the value of a field as an object node.
     * 
     * @param name the name of the field
     * @return the value as a node, may be <b>null</b> if it does not exist/is not an object, ..
     * @see #has(String)
     */
    public YamlNode getObject(String name) {
        return isObject(name) ? new YamlNode((Map<?, ?>) data.get(name), this) : null;
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
     * Returns the value of a field as a list.
     * 
     * @param name the name of the field
     * @return the value as a list, may be <b>null</b> if it does not exist/is not a list, ...
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
     * Returns the value of a field as a {@link YamlList}.
     * 
     * @param name the name of the field
     * @return the value as a list, may be <b>null</b> if it does not exist/is not a list, ...
     * @see #isList(String)
     */
    @SuppressWarnings("unchecked")
    public YamlList getList(String name) {
        YamlList result = null;
        if (isList(name)) {
            Object d = data.get(name);
            if (d instanceof YamlList) {
                result = (YamlList) d;
            } else {
                result = new YamlList((List<Object>) d, this);
            }
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
     * @return the value as a map, may be <b>null</b> if it does not exist/is not a map, ...
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
     * Returns the value of a field as a map.
     * 
     * @param name the name of the field
     * @return the value as a map, may be <b>null</b> if it does not exist/is not 
     *   a map, ...
     * @see #isMap(String)
     */
    @SuppressWarnings("unchecked")
    public YamlNode getMap(String name) {
        YamlNode result = null;
        if (isList(name)) {
            Object d = data.get(name);
            if (d instanceof YamlNode) {
                result = (YamlNode) d;
            } else if (d instanceof Map) {
                java.util.Map<String, Object> tmp = new HashMap<>();
                for (java.util.Map.Entry<Object, Object> e: ((java.util.Map<Object, Object>) d).entrySet()) {
                    tmp.put(e.getKey().toString(), e.getValue());
                }
                result = new YamlNode(tmp, this);
            }
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
     * Adds a field with an empty list or returns a known list for the given field.
     * 
     * @param name the name of the field
     * @return the list for chaining
     * @see #getList(String)
     */
    public YamlList addList(String name) {
        YamlList result = getList(name);
        if (null == result) {
            result = new YamlList(new ArrayList<Object>(), this);
            set(name, result, true);
        }
        return result;
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
            tmp.add(IVilType.convertVilValue(o));
        }
        set(name, tmp, true);
        return this;
    }

    /**
     * Adds a field with value list, but only if the list is not empty.
     * 
     * @param name the name of the field
     * @param value the value
     * @return <b>this</b> for chaining
     */
    public YamlNode addListNotEmpty(String name, Sequence<?> value) {
        if (value.size() > 0) {
            addList(name, value);
        }
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
            set(key.toString(), val, false); // TODO more key conversion, recursive?
        }
        notifyChanged();
        return this;
    }

    /**
     * Adds a field with an empty map.
     * 
     * @param name the name of the field
     * @return the map node for chaining
     * @see #getMap(String)
     */
    public YamlNode addMap(String name) {
        YamlNode result = getMap(name);
        if (null == result) {
            result = new YamlNode(this);
            set(name, result, true);
        }
        return result;
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
            Object val = IVilType.convertVilValue(value.get(key));
            tmp.put(key.toString(), val); // TODO more key conversion, recursive?
        }
        set(name, tmp, true);
        return this;
    }

    @Override
    @Invisible
    java.util.Map<String, Object> getData(Sorting sorting) {
        java.util.Map<String, Object> result;
        switch(sorting) {
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
            result = new TreeMap<>(Collator.getInstance());
            break;
        default: // implies NONE
            result = new HashMap<>();
            break;
        }
        for (String key: data.keySet()) {
            Object value = data.get(key);
            if (value instanceof YamlStructure) {
                YamlStructure valueNode = (YamlStructure) value;
                if (valueNode.hasData()) {
                    value = valueNode.getData(sorting);                    
                } else {
                    value = null;
                }
            }
            result.put(key, value);
        }
        return result;
    }
    
    @Invisible
    @Override
    boolean hasData() {
        return data != null && data.size() > 0;
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return null != comparator ? "YamlNode" : data.toString();
    }

}
