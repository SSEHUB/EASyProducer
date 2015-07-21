/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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

import java.util.HashMap;
import java.util.Map;

/**
 * Default in-memory storage provider implementation for rt-VIL.
 * 
 * @author Holger Eichelberger
 */
public class RtVILMemoryStorage extends RtVilStorage {

    private Map<String, Object> values = new HashMap<String, Object>();

    /**
     * Returns the storage key.
     * 
     * @param script the script 
     * @param variable the variable
     * @return the storage key (may be <b>null</b>)
     */
    private String key(String script, String variable) {
        return (null == script || null == variable) ? null : script + ":" + variable;
    }
    
    @Override
    public Object getValue(String script, String variable) {
        Object result = null;
        String key = key(script, variable);
        if (null != key) {
            result = values.get(key);
        }
        return result;
    }

    @Override
    public void setValue(String script, String variable, Object value) {
        String key = key(script, variable);
        if (null != key) {
            values.put(key, value);
        }
    }
    
    @Override
    public String toString() {
        return values.toString();
    }

}
