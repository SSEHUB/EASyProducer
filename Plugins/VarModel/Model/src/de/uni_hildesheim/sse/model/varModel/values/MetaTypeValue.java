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
package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.MetaType;

/**
 * Holds the value for a {@link MetaType}.
 *
 * @author Holger Eichelberger
 */
public class MetaTypeValue extends Value {
    
    private IDatatype value;

    /**
     * Constructor.
     * @param value Value of this instance
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    protected MetaTypeValue(Object value) throws ValueDoesNotMatchTypeException {
        super(MetaType.TYPE);
        setValue(value);
    }
    
    /**
     * Argumentless constructor.
     */
    protected MetaTypeValue() {
        super(MetaType.TYPE);
    }
    
    /**
     * Getter for the value.
     * 
     * @return the saved datatype
     */
    public IDatatype getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (value instanceof IDatatype) {
            this.value = (IDatatype) value;
        } else {
            throw new ValueDoesNotMatchTypeException(
                stringValueOf(value), this, ValueDoesNotMatchTypeException.NO_DATATYPE);
        }
    }
    
    @Override
    public void accept(IValueVisitor visitor) {
        visitor.visitMetaTypeValue(this);
    }

    @Override
    public boolean isConfigured() {
        return value != null;
    }
    
    @Override
    public Value clone() {
        Value result;
        try {
            result = new MetaTypeValue(value);
        } catch (ValueDoesNotMatchTypeException e) {
            assert false;
            // shall not happen on valid instances
            result = null;
        }
        return result;
    }
    
    /**
     * Returns the data type explicitly contained in this value. This is 
     * typically a meta value, i.e. a type expression.
     * 
     * @return the contained type or <b>null</b> if there is none
     */
    public IDatatype getContainedType() {
        return value;
    }

    @Override
    public boolean equalsPartially(Value value) {
        return equals(value); // meta type value is symmetric
    }

}
