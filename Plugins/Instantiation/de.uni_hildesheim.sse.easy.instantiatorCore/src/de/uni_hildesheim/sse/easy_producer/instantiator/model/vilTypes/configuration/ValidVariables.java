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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * Stores whether an IVML element is valid based on the constraints of the element.
 * Under rt-VIL, this operation shall constantly <code>true</code> as reasoning shall
 * ensure validity. Under rt-VIL, the constraint analysis may define the actual values. 
 * 
 * @author Holger Eichelberger
 */
public class ValidVariables {

    // really string or IDecisionVariable - causes further links to be maintained
    // do not persist the settings
    private static final transient Map<String, Boolean> VALID = new HashMap<String, Boolean>();

    /**
     * Prevent external instantiation.
     */
    private ValidVariables() {
    }

    /**
     * Defines a validity flag for <code>var</code>.
     * 
     * @param var the variable to change the flag for
     * @param isValid the validity flag (<b>null</b> for undefined, the value for the flag)
     */
    public static void setValidFlag(AbstractIvmlVariable var, Boolean isValid) {
        if (null != var) {
            setValidFlag(var.getVariable(), isValid);
        }
    }

    /**
     * Defines a validity flag for <code>var</code>.
     * 
     * @param var the variable to change the flag for
     * @param isValid the validity flag (<b>null</b> for undefined, the value for the flag)
     */
    public static void setValidFlag(IDecisionVariable var, Boolean isValid) {
        if (null != var) {
            String key = Configuration.getInstanceName(var);
            if (null == isValid) {
                VALID.remove(key);
            } else {
                VALID.put(key, isValid);
            }
        }
    }

    /**
     * Returns the validity flag for <code>var</code>.
     * 
     * @param var the variable
     * @param dflt the default value in case that <code>var</code> exists
     * @return the validity flag, <code>dflt</code> if undefined
     */
    public static Boolean getValidFlag(AbstractIvmlVariable var, Boolean dflt) {
        Boolean result;
        if (null != var) {
            result = getValidFlag(var.getVariable(), dflt);
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Returns the validity flag for <code>var</code>.
     * 
     * @param var the variable
     * @param dflt the default value in case that <code>var</code> exists
     * @return the validity flag, <code>dflt</code> if undefined
     */
    public static Boolean getValidFlag(IDecisionVariable var, Boolean dflt) {
        Boolean result;
        if (null != var) {
            result = VALID.get(Configuration.getInstanceName(var));
            if (null == result) {
                result = dflt;
            }
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Clears all validity flags.
     */
    public static void clear() {
        VALID.clear();
    }

}