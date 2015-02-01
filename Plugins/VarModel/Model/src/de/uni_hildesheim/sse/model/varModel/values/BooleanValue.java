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

import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;

/**
 * This class holds the value for the boolean.
 * @author lueder
 * @author Holger Eichelberger
 */
public class BooleanValue extends BasisDatatypeValue {
    
    public static final BooleanValue TRUE = new BooleanValue(true);
    public static final BooleanValue FALSE = new BooleanValue(false);
    
    private Boolean value;

    /**
     * Constructor. Please avoid this constructor and use the constants instead.
     * 
     * @param value Value of the Datatype
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    protected BooleanValue(String value) throws ValueDoesNotMatchTypeException {
        super(BooleanType.TYPE);
        setValue(value);
    }
    
    /**
     * Argumentless constructor representing the type itself.
     */
    protected BooleanValue() {
        super(BooleanType.TYPE);
    }

    /**
     * Creates a boolean value from the given boolean value.
     * 
     * @param value the value to assign
     */
    protected BooleanValue(Boolean value) {
        super(BooleanType.TYPE);
        this.value = value;
    }
    
    /**
     * Getter for the value.
     * @return the saved boolean
     */
    public Boolean getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (null != value) {
            Boolean val = toValue(value);
            if (null != val) {
                this.value = val.booleanValue();
            } else {
                throw new ValueDoesNotMatchTypeException(
                    stringValueOf(value), this, ValueDoesNotMatchTypeException.NO_LITERAL);
            } 
        } else {
            this.value = null;
        }
    }
    
    @Override
    public void accept(IValueVisitor visitor) {
        visitor.visitBooleanValue(this);
    }

    @Override
    public boolean isConfigured() {
        return value != null;
    }
    
    @Override
    public Value clone() {
        return new BooleanValue(value);
    }

    /**
     * Converts a Java boolean into an IVML boolean value. To some degree, 
     * this bypasses the value factory but - as the result is obvious, but 
     * also simplifies some (evaluation) code.
     * 
     * @param value the value to be converted
     * @return the IVML value
     */
    public static final BooleanValue toBooleanValue(boolean value) {
        return value ? TRUE : FALSE;
    }

    /**
     * Converts a String ("true", "false") into an IVML Boolean value.
     * 
     * @param value the value to be converted
     * @return the IVML value (may be <b>null</b> if no match)
     */
    private static final Boolean toValue(Object value) {
        Boolean result;
        if ("true".equals(value)) {
            result = Boolean.TRUE;
        } else if ("false".equals(value)) {
            result = Boolean.FALSE;
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Converts a String ("true", "false") into an IVML boolean value. To some degree, 
     * this bypasses the value factory but - as the result is obvious, but 
     * also simplifies some (evaluation) code and may save resources.
     * 
     * @param value the value to be converted
     * @return the IVML value (may be <b>null</b> if no match)
     */
    public static final BooleanValue toBooleanValue(String value) {
        Boolean val = toValue(value);
        BooleanValue result;
        if (Boolean.TRUE == val) {
            result = TRUE;
        } else if (Boolean.FALSE == val) {
            result = FALSE;
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Converts a String ("true", "false") into an IVML boolean value. To some degree, 
     * this bypasses the value factory but - as the result is obvious, but 
     * also simplifies some (evaluation) code and may save resources.
     * 
     * @param value the value to be converted
     * @return the IVML value
     * @throws ValueDoesNotMatchTypeException in case that the value does not match
     */
    public static final BooleanValue toBooleanValueEx(String value) throws ValueDoesNotMatchTypeException {
        BooleanValue result = toBooleanValue(value);
        if (null == result) {
            throw new ValueDoesNotMatchTypeException(
                value, "Boolean", ValueDoesNotMatchTypeException.NO_LITERAL);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return null != value ? value.hashCode() : 0;
    }
    
    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (value != null && object instanceof BooleanValue) {
            result = value.equals(((BooleanValue) object).getValue());
        }
        return result;
    }

}
