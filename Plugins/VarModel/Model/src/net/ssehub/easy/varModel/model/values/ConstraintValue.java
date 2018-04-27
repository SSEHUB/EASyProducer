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

import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * This class holds the value for a constraint type.
 *
 * @author Holger Eichelberger
 */
public class ConstraintValue extends BasisDatatypeValue {
    
    private ConstraintSyntaxTree value;

    /**
     * Argumentless constructor.
     */
    protected ConstraintValue() {
        super(ConstraintType.TYPE);
    }

    /**
     * Constructor.
     * @param value Value of the Datatype
     * @throws ValueDoesNotMatchTypeException in case that the given value
     *   does not match the requirements of this class, i.e. cannot be converted
     */
    protected ConstraintValue(Object value) throws ValueDoesNotMatchTypeException {
        this();
        // either it is already a CST, a Constraint which contains a
        // CST, null or (according to the grammar) a Boolean constant
        if (value instanceof ConstraintSyntaxTree) {
            this.value = (ConstraintSyntaxTree) value;
        } else if (value instanceof ConstraintValue) {
            this.value = ((ConstraintValue) value).getValue();
        } else if (value == null) {
            this.value = null;
        } else {
            this.value = new ConstantValue(BooleanValue.toBooleanValue(value.toString()));
        }
    }
    
    /**
     * Constructor.
     * @param value Value of the Datatype
     */
    protected ConstraintValue(ConstraintSyntaxTree value) {
        this();
        this.value = value;
    }
    
    /**
     * Setter for the value.
     * @param value Value of the Datatype
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (value instanceof ConstraintSyntaxTree) {
            this.value = (ConstraintSyntaxTree) value;
        } else {
            throw new ValueDoesNotMatchTypeException("no constraint given", 
                ValueDoesNotMatchTypeException.TYPE_MISMATCH);
        }
    }
    
    /**
     * Returns the stored value.
     * 
     * @return the stored constraint (may be <b>null</b>)
     */
    public ConstraintSyntaxTree getValue() {
        return value;
    }
    
    /** 
     * Accept method for the visitor. <br/>
     * This method is used for saving this model element.
     * @param visitor The visitor, which should save this model element.
     */
    public void accept(IValueVisitor visitor) {
        visitor.visitConstraintValue(this);
    }

    @Override
    public boolean isConfigured() {
        return value != null;
    }
    
    @Override
    public Value clone() {
        return new ConstraintValue(value);
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object instanceof ConstraintValue) {
            ConstraintValue cValue = (ConstraintValue) object;
            if (null == value) {
                result = null == cValue;
            } else {
                result = value.equals(cValue.value);
            }
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        ConstraintSyntaxTree val = getValue();
        return (null == val ? null : StringProvider.toIvmlString(val)) + " : " + getType().toString();
    }

}
