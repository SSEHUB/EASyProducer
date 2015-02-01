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

import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;

/**
 * This class holds the value for the string.
 * @author lueder
 * @author Holger Eichelberger
 */
public class StringValue extends BasisDatatypeValue {
    
    private String value;

    /**
     * Argumentless constructor.
     */
    protected StringValue() {
        super(StringType.TYPE);
    }
    
    /**
     * Constructor.
     * @param value Value of the Datatype
     */
    protected StringValue(String value) {
        super(StringType.TYPE);
        this.value = value;
    }
    
    /**
     * Setter for the value.
     * @param value Value of the Datatype
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        this.value = stringValueOf(value);
    }
    
    /**
     * Getter for the value.
     * @return the saved String
     */
    public String getValue() {
        return value;
    }
    
    @Override
    public void accept(IValueVisitor visitor) {
        visitor.visitStringValue(this);
    }

    @Override
    public boolean isConfigured() {
        return value != null;
    }
    
    @Override
    public Value clone() {
        return new StringValue(value);
    }
    
    @Override
    public int hashCode() {
        return null != value ? value.hashCode() : 0;
    }
    
    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (value != null && object instanceof StringValue) {
            result = value.equals(((StringValue) object).getValue());
        }
        return result;
    }

}
