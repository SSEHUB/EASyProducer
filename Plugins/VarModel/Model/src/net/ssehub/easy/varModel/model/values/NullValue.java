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

import net.ssehub.easy.varModel.model.datatypes.AnyType;

/**
 * Defines the <b>null</b> value. The null value is instance of {@link AnyType}.
 * 
 * @author Holger Eichelberger
 */
public final class NullValue extends Value {

    /**
     * The only instance of the null value.
     */
    public static final Value INSTANCE = new NullValue();
    
    /**
     * Defines the type of the singleton null value. Actually, object would be sufficient, 
     * but for serialization a specific type is required.
     * 
     * @author Holger Eichelberger
     */
    public static class NullValueType {

        /**
         * Creates an instance and prevents external instantiation.
         */
        private NullValueType() {
        }
        
    }
    
    /**
     * The value to be returned by {@link #getValue()}. <b>null</b> would be
     * an alternative but this may break existing code.
     */
    public static final Object VALUE = new NullValueType();
    
    /**
     * Creates a null value. Not visible due to singlton constant character.
     */
    private NullValue() {
        super(AnyType.TYPE);
    }
    
    @Override
    public Object getValue() {
        return VALUE;
    }

    @Override
    public void accept(IValueVisitor visitor) {
        visitor.visitNullValue(this);
    }

    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        throw new ValueDoesNotMatchTypeException("cannot assign a value to 'null' (constant)", 
            ValueDoesNotMatchTypeException.IS_CONSTANT);
    }

    @Override
    public boolean isConfigured() {
        return true;
    }

    @Override
    public Value clone() {
        return this;
    }

    @Override 
    public int hashCode() {
        return System.identityHashCode(this);
    }
    
    @Override 
    public boolean equals(Object other) {
        return INSTANCE == other; // singleton
    }
    
    @Override
    public String toString() {
        return "NullValue";
    }

    @Override
    public boolean equalsPartially(Value value) {
        return equals(value); // meta type value is symmetric
    }

}
