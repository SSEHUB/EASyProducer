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
import java.util.List;

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Represents a Yaml list.
 * 
 * @author Holger Eichelberger
 */
public class YamlList extends YamlStructure {

    private java.util.List<Object> data;

    /**
     * Creates an instance with data.
     * 
     * @param data the data map
     * @param parent the parent to notify about changes
     */
    YamlList(java.util.List<Object> data, INodeParent parent) {
        super(parent);
        this.data = data;
    }

    /**
     * Adds a simple value to this list. Adding happens only if the specified field is a list.
     * 
     * @param value the value
     * @return <b>this</b> for chaining
     */
    public YamlList addValue(Object value) {
        data.add(value);
        return this;
    }

    /**
     * Adds all values to this list.
     * 
     * @param values the values
     * @return <b>this</b> for chaining
     */
    public YamlList addValues(Sequence<?> values) {
        for (Object o : values) {
            data.add(o);
        }
        return this;
    }    
    
    /**
     * Adds a new object value to this list. Adding happens only if the specified field is a list.
     * 
     * @return the added object
     */
    public YamlNode addObject() {
        YamlNode obj = new YamlNode(new ClassMap(), this);
        addValue(obj);
        return obj;
    }
    
    /**
     * Adds a value with an empty list.
     * 
     * @return the list
     */
    public YamlList addList() {
        YamlList result = new YamlList(new ArrayList<Object>(), this);
        addValue(result);
        return result;
    }

    /**
     * Adds a field with an empty map.
     * 
     * @param name the name of the field
     * @return the map node for chaining
     * @see #getMap(String)
     */
    public YamlNode addMap(String name) {
        YamlNode result = new YamlNode(this);
        addValue(result);
        return result;
    }
    
    /**
     * Returns the number of elements in the list.
     * 
     * @return the number of elements
     */
    public int getSize() {
        return data.size();
    }
    
    /**
     * Returns the value of a field as a list.
     * 
     * @return the value as a list
     */
    public Sequence<Object> getListValue() {
        return new ListSequence<Object>(data, TypeRegistry.anyType());
    }
    
    @Override
    public String getStringValue(StringComparator comparator) {
        return null != comparator ? "YamlNode" : data.toString();
    }
    
    @Override
    @Invisible
    List<Object> getData(Sorting sorting) {
        List<Object> result = new ArrayList<Object>();
        for (Object value: data) {
            if (value instanceof YamlStructure) {
                YamlStructure valueNode = (YamlStructure) value;
                if (valueNode.hasData()) {
                    value = valueNode.getData(sorting);                    
                } else {
                    value = null;
                }
            }
            result.add(value);
        }
        return result;
    }

    
    @Invisible
    @Override
    boolean hasData() {
        return data != null && data.size() > 0;
    }
    

}
