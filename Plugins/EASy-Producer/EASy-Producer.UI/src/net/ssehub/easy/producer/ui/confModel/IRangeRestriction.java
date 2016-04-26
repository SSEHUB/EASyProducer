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
package net.ssehub.easy.producer.ui.confModel;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * Optional filter to restrict values of a {@link GUIVariable}.
 * @author El-Sharkawy
 *
 */
public interface IRangeRestriction {

    /**
     * Specifies which variables are restricted by this filter.
     * @param variable A variable for which a {@link GUIVariable} shall be generated.
     * @return <tt>true</tt> if the values of this variables shall be filtered, <tt>false</tt> if all assignable filters
     * shall be presented to the user.
     */
    public boolean appliesTo(IDecisionVariable variable);
    
    /**
     * Specifies whether a given value should be filtered or not.
     * @param value {@link net.ssehub.easy.varModel.model.values.Value#getValue()} of possible value,
     *     which may be filtered.
     * @param label Optional parameter for a displayable label
     * @return <tt>true</tt> value should be omitted, <tt>false</tt> keep value.
     */
    public boolean filterValue(Object value, String label);
}
