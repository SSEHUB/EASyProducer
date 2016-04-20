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
package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements a simple instance-name based value mapper.
 * 
 * @author Holger Eichelberger
 */
public class InstanceNameValueMapper implements IVariableValueMapper {

    private static final String VALID = "valid:";
    private static final String ENACTING = "enact:";
    private transient Map<String, Object> values = new HashMap<String, Object>();

    /**
     * Returns a boolean value for <code>element</code>.
     * 
     * @param element the element
     * @param prefix the prefix
     * @param deflt the default value if the actual value is not defined
     * @return the boolean value
     */
    private boolean getBoolean(IvmlElement element, String prefix, boolean deflt) {
        boolean result;
        Object val = values.get(element.getInstanceName());
        if (val instanceof Boolean) {
            result = (Boolean) val;
        } else {
            result = deflt;
        }
        return result;
    }
    
    @Override
    public boolean isValid(IvmlElement element) {
        return getBoolean(element, VALID, true);
    }

    @Override
    public boolean isEnacting(IvmlElement element) {
        return getBoolean(element, ENACTING, false);
    }

    @Override
    public Object getValue(IvmlElement element) {
        return values.get(element.getInstanceName());
    }

    /**
     * Defines the value of <code>element</code>.
     * 
     * @param element the element to change the value for
     * @param value the value (<b>null</b> for undefined)
     */
    public void setValue(IvmlElement element, Object value) {
        setValue(element.getInstanceName(), value);
    }

    /**
     * Defines the value of an IVML element.
     * 
     * @param name the instance name of the element to change the value for
     * @param value the value (<b>null</b> for undefined)
     */
    public void setValue(String name, Object value) {
        if (null == value) {
            values.remove(name);
        } else {
            values.put(name,  value);
        }
    }

    /**
     * Defines the validity flag for <code>element</code>.
     * 
     * @param element the element to change the flag for
     * @param value the validity flag (<b>null</b> for undefined, the value for the flag)
     */
    public void setValid(IvmlElement element, Boolean value) {
        setValid(element.getInstanceName(), value);
    }
    
    /**
     * Defines the validity flag for <code>element</code>.
     * 
     * @param name the instance name of the IVML element to change the flag for
     * @param value the validity flag (<b>null</b> for undefined)
     */
    public void setValid(String name, Boolean value) {
        setValue(VALID + name, value);
    }

    /**
     * Defines the enacting flag for <code>element</code>.
     * 
     * @param element the element to change the flag for
     * @param value the enacting flag (<b>null</b> for undefined)
     */
    public void setEnacting(IvmlElement element, Boolean value) {
        setEnacting(element.getInstanceName(), value);
    }

    /**
     * Defines a enacting flag for <code>element</code>.
     * 
     * @param name the instance name of the IVML element to change the flag for
     * @param value the enacting flag (<b>null</b> for undefined)
     */
    public void setEnacting(String name, Boolean value) {
        setValue(VALID + name, value);
    }

    /**
     * Clears all values.
     */
    public void clear() {
        values.clear();
    }

}
