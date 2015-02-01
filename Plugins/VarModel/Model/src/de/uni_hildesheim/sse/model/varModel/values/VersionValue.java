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
package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.model.varModel.datatypes.VersionType;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;

/**
 * This class holds the value for a version.
 * 
 * @author Holger Eichelberger
 */
public class VersionValue extends BasisDatatypeValue {
    
    private Version value;

    /**
     * Constructor.
     * @param value Value of the datatype
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    protected VersionValue(Object value) throws ValueDoesNotMatchTypeException {
        super(VersionType.TYPE);
        this.setValue(value);
    }
    
    /**
     * Argumentless constructor.
     */
    protected VersionValue() {
        super(VersionType.TYPE);
    }

    /**
     * Creates a value object from the given value.
     * 
     * @param value the value to set
     */
    protected VersionValue(Version value) {
        super(VersionType.TYPE);
        this.value = value;
    }

    /**
     * Getter for the value.
     * @return the saved int
     */
    public Version getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (value instanceof Version) {
            this.value = (Version) value;
        } else if (null != value) {
            String sValue = stringValueOf(value);
            if (sValue.startsWith("v")) {
                sValue = sValue.substring(1);
            }
            try {
                this.value = new Version(sValue);      
            } catch (VersionFormatException e) {
                throw new ValueDoesNotMatchTypeException(sValue, this, 
                    ValueDoesNotMatchTypeException.TYPE_MISMATCH);
            }
        } else {
            this.value = Version.NULL_VALUE; // no version given
        }
    }
    
    @Override
    public boolean isConfigured() {
        return value != null;
    }
    
    @Override
    public void accept(IValueVisitor visitor) {
        visitor.visitVersionValue(this);
    }
    
    @Override
    public Value clone() {
        return new VersionValue(value);
    }
    
    @Override
    public int hashCode() {
        return null != value ? value.hashCode() : 0;
    }
    
    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (value != null && object instanceof VersionValue) {
            result = value.equals(((VersionValue) object).getValue());
        }
        return result;
    }

}
