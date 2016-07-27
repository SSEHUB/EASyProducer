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
package net.ssehub.easy.varModel.model.values;

import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Holding basis data types.
 * @author Marcel Lueder
 * @author El-Sharkawy
 */
public abstract class BasisDatatypeValue extends Value {

    /**
     * Constructor for a new BasisDatatypeValue.
     * @param type type of the Value
     */
    protected BasisDatatypeValue(IDatatype type) {
        super(type);
        
        // Must be either Boolean, Integer, Real, String, or Constraint
        assert type.isPrimitive() : "\"" + type.getName()
            + " is not a basic type, but was used for a basic value \"" + this.getClass().getSimpleName() + "\".";
    }
    /**
     * Getter for the value. Not implemented yet.
     * @return null
     */
    @Override
    public Object getValue() {
        return null;
    }
    
    @Override
    public boolean equalsPartially(Value value) {
        return equals(value); // basis type values are symmetric as they have no nested elements
    }

}
