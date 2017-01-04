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
package net.ssehub.easy.instantiation.velocity;

import java.util.HashMap;
import java.util.Map;

/**
 * Context which allows retrieval of nested values of a compound via <tt>getByName(&lt;slot name&gt;)</tt>.
 * @author El-Sharkawy
 */
public class VelocityCompoundAccess extends VelocityContextItem {

    private Map<String, Object> nestedValues;
    
    /**
     * Sole constructor for this class.
     * @param variableName The name of the compound.
     * @param cmpValue The compound value of the compound.
     */
    public VelocityCompoundAccess(String variableName, Object cmpValue) {
        super(variableName, cmpValue);
        nestedValues = new HashMap<String, Object>();
    }
    
    /**
     * Adds a nested value of the compound.
     * @param nestedName The slot name of the compound.
     * @param value The value, as it shall be accessible via velocity
     */
    void addValue(String nestedName, Object value) {
        nestedValues.put(nestedName, value);
    }
    
    /**
     * Returns the desired member value of the compound.
     * @param slotName The name of the desired slot.
     * @return The value or <tt>null</tt> if the specified slot does not exist.
     */
    public Object getByName(String slotName) {
        return nestedValues.get(slotName);
    }
    
    /**
     * Returns the desired member value of the compound.
     * @param slotName The name of the desired slot.
     * @return The value or <tt>null</tt> if the specified slot does not exist.
     */
    public Object byName(String slotName) {
        return getByName(slotName);
    }
    
    /**
     * Returns the desired member value of the compound.
     * @param slotName The name of the desired slot.
     * @return The value or <tt>null</tt> if the specified slot does not exist.
     */
    public Object value(String slotName) {
        return getByName(slotName);
    }
    
    

}
