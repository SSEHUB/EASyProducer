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

import net.ssehub.easy.varModel.model.datatypes.RealType;

/**
 * This class holds the value for the real.
 * @author lueder
 * @author Holger Eichelberger
 */
public class RealValue extends BasisDatatypeValue {
    
    private Double value;

    /**
     * Constructor.
     * @param value Value of the datatype
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    protected RealValue(String value) throws ValueDoesNotMatchTypeException {
        super(RealType.TYPE);
        this.setValue(value);
    }
    
    /**
     * Argumentless constructor.
     */
    protected RealValue() {
        super(RealType.TYPE);
    }

    /**
     * Creates a value object from the given value.
     * 
     * @param value the value to set
     */
    protected RealValue(Double value) {
        super(RealType.TYPE);
        this.value = value;
    }
    
    //Probably not needed? setValue(Object value) adequate ?
//    /**
//     * Setter for the value.
//     * @param value Value of the datatype
//     */
//    public void setValue(double value) {
//        this.value = value;
//    }
    
    /**
     * Getter for the value.
     * @return the saved float
     */
    public Double getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (null != value) {
            String sValue = stringValueOf(value);
            try {
                this.value = Double.parseDouble(sValue);
            } catch (NumberFormatException e) {
                throw new ValueDoesNotMatchTypeException(sValue, this, 
                    ValueDoesNotMatchTypeException.TYPE_MISMATCH);
            }
        } else {
            this.value = null;
        }
    }
    
    @Override
    public void accept(IValueVisitor visitor) {
        visitor.visitRealValue(this);
    }

    @Override
    public boolean isConfigured() {
        return value != null;
    }
    
    @Override
    public Value clone() {
        return new RealValue(value);
    }

    @Override
    public int hashCode() {
        return null != value ? value.hashCode() : 0;
    }
    
    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (value != null && object instanceof RealValue) {
            result = value.equals(((RealValue) object).getValue());
        }
        return result;
    }

}
