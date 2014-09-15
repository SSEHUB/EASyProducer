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

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Reference value class.
 * @author lueder
 *
 */
public class ReferenceValue extends Value {
    
    private DecisionVariableDeclaration value; // the declaration the reference goes to

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
    public DecisionVariableDeclaration getValue() {
        return value;
    }

    @Override
    public void accept(IValueVisitor visitor) {
        visitor.visitReferenceValue(this);
    }
    
    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (value instanceof DecisionVariableDeclaration) {
            DecisionVariableDeclaration decl = (DecisionVariableDeclaration) value;
            this.value = decl;
        } else if (NullValue.INSTANCE == value) {
            this.value = null;
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

}
