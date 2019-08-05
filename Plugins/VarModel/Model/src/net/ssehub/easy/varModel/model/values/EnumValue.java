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

import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;

/**
 * Holding enum literals.
 * 
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public class EnumValue extends Value {
    
    private EnumLiteral literal;

    /**
     * Constructor for serialization.
     */
    EnumValue() {
       super(null); 
    }
    
    /**
     * Constructor for a new EnumValue.
     * @param enumType the Enum which defines the specific type of this EnumValue
     */
    protected EnumValue(Enum enumType) {
        this(enumType, null);
    }

    /**
     * Constructor for a new EnumValue.
     * @param enumType the Enum which defines the specific type of this EnumValue
     * @param literal the initial value for the literal
     */
    protected EnumValue(Enum enumType, EnumLiteral literal) {
        super(enumType);
        this.literal = literal;
    }

    /**
     * Constructor for a new EnumValue.
     * @param enumType the Enum which defines the specific type of this EnumValue
     * @param value the enum value
     * @throws ValueDoesNotMatchTypeException in case of type problems
     */
    protected EnumValue(Enum enumType, Object value) throws ValueDoesNotMatchTypeException {
        super(enumType);
        if (null == value) {
            throw new ValueDoesNotMatchTypeException("null is not a valid enum literal", 
                ValueDoesNotMatchTypeException.IS_NULL);
        } else if (value instanceof EnumLiteral) {
            EnumLiteral lit = (EnumLiteral) value;
            if (!enumType.has(lit)) {
                throw new ValueDoesNotMatchTypeException(value.toString(), enumType, 
                     ValueDoesNotMatchTypeException.NO_LITERAL);
            }
            literal = lit;
        } else {
            setValue(value);
        }
    }
    
    /**
     * Getter for the value. Not implemented yet.
     * @return null
     */
    @Override
    public EnumLiteral getValue() {
        return literal;
    }

    @Override
    public void accept(IValueVisitor visitor) {
        visitor.visitEnumValue(this);
    }
    
    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (null == value) {
            throw new ValueDoesNotMatchTypeException("null is not a valid enum literal", 
                ValueDoesNotMatchTypeException.IS_NULL);
        }
        
        Enum enumType = (Enum) getType(); // works by construction
        String sValue = stringValueOf(value);
        EnumLiteral lit = enumType.get(sValue);
        if (null == lit) {
            throw new ValueDoesNotMatchTypeException(sValue, enumType, 
                ValueDoesNotMatchTypeException.NO_LITERAL);
        }
        literal = lit;
    }

    @Override
    public boolean isConfigured() {
        return literal != null;
    }
    
    @Override
    public Value clone() {
        return new EnumValue((Enum) getType(), literal);
    }

    @Override
    public int hashCode() {
        return null != literal ? literal.hashCode() : 0;
    }
    
    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (literal != null && object instanceof EnumValue) {
            result = literal.equals(((EnumValue) object).getValue());
        }
        return result;
    }

    @Override
    public boolean equalsPartially(Value value) {
        return equals(value); // enums are symmetric
    }

}
