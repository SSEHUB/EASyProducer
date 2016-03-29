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

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Reference value class.
 * @author lueder
 *
 */
public class ReferenceValue extends Value {
    
    private AbstractVariable value; // the declaration the reference goes to
    private ConstraintSyntaxTree valueEx; // a more complex expression that cannot be evaluated now

    /**
     * Constructor for a new ReferenceValue.
     * @param origin Reference which extends this ReferenceValue
     * @param ref the reference of this value
     * @throws ValueDoesNotMatchTypeException if one of the default values do not comply
     *   to the respective types
     */
    protected ReferenceValue(IDatatype origin, Object... ref) throws ValueDoesNotMatchTypeException {
        super(origin);
        if (null != ref && ref.length > 0) {
            setValue(ref[0]);
        } else {
            setValue(NullValue.INSTANCE);
        }
    }

    @Override
    public AbstractVariable getValue() {
        return value;
    }
    
    /**
     * If {@link #getValue()} is <b>null</b>, the actual value is determined by an expression that needs to be 
     * evaluated.
     * 
     * @return the value expression
     */
    public ConstraintSyntaxTree getValueEx() {
        return valueEx;
    }

    @Override
    public void accept(IValueVisitor visitor) {
        visitor.visitReferenceValue(this);
    }
    
    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (value instanceof AbstractVariable) {
            AbstractVariable decl = (AbstractVariable) value;
            this.value = decl;
        } else if (value instanceof ConstraintSyntaxTree) {
            this.valueEx = ((ConstraintSyntaxTree) value);
        } else if (NullValue.INSTANCE == value) {
            this.value = null;
        } else if (value instanceof ReferenceValue) {
            ReferenceValue other = (ReferenceValue) value;
            if (getType().isAssignableFrom(other.getType())) {
                this.value = other.value;
            } else {
                throw new ValueDoesNotMatchTypeException("given reference value of type '" + other.getType() 
                    + "' does not match expected reference type " + getType(), 
                    ValueDoesNotMatchTypeException.TYPE_MISMATCH);
            }
        } else if (value == null) {
            // TODO check - IVML has an explicit null value!!!
            throw new ValueDoesNotMatchTypeException("null is not a valid reference", 
                ValueDoesNotMatchTypeException.IS_NULL);
        } else {
            throw new ValueDoesNotMatchTypeException("given value '" + value + "' does not match reference type " 
                + getType(), ValueDoesNotMatchTypeException.TYPE_MISMATCH);
        }
    }

    @Override
    public boolean isConfigured() {
        return null != value;
    }

    @Override
    public Value clone() {
        Value result;
        try {
            result = new ReferenceValue(getType(), getValue());
        } catch (ValueDoesNotMatchTypeException e) {
            result = NullValue.INSTANCE;
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
        if (value != null && object instanceof ReferenceValue) {
            result = value.equals(((ReferenceValue) object).getValue());
        }
        return result;
    }

    @Override
    public boolean equalsPartially(Value value) {
        return equals(value); // usure
    }

}
