/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.model.values;

import net.ssehub.easy.varModel.model.datatypes.StructuredDatatype;

/**
 * Super class of {@link ContainerValue} and {@link CompoundValue}.
 * @author beck
 * @author El-Sharkawy
 *
 */
abstract class StructuredValue extends Value {

    private IValueParent valueParent;

    /**
     * Constructor for serialization.
     */ 
    StructuredValue() {
    }
    
    /**
     * Constructor for the Class.
     * @param type the type of the specific object.
     */
    protected StructuredValue(StructuredDatatype type) {
        super(type);      
    }

    /**
     * Method to check, whether each object of the Value has a value assigned.
     * @return <b>true</b> if all sub-elements are configured, else <b>false</b>
     */
    public abstract boolean isFullyConfigured();
    
    @Override
    public final boolean isConfigured() {
        return isFullyConfigured();
    }
    
    @Override
    public void setValueParent(IValueParent valueParent) {
        this.valueParent = valueParent;
    }

    @Override
    public IValueParent getValueParent() {
        return valueParent;
    }

}
