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
package net.ssehub.easy.varModel.cst;

import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Class for a constant value.
 * 
 * @author jaehne
 * @author Holger Eichelberger
 */
public class ConstantValue extends Leaf {
    
    private Value constant;
    
    /**
     * Constructor for serialization.
     */
    ConstantValue() {
    }
    
    /**
     * Sole constructor for the creation of a constant value.
     * @param constant Constant value to be stored.
     */
    public ConstantValue(Value constant) {
        this.constant = constant;
    }
    
    @Override
    public IDatatype inferDatatype() {
        return constant.getType();
    }
    
    /**
     * Getter-Method for the constant-value.
     * @return the value of the constant-attribute.
     */
    public Value getConstantValue() {
        return constant;
    }
    
    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitConstantValue(this); // no further operations!
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj instanceof ConstantValue) {
            equals = constant.equals(((ConstantValue) obj).constant);
        }
        return equals;
    }

    @Override
    public int hashCode() {
        return constant.hashCode();
    }

    @Override
    public IDatatype getContainedType() {
        IDatatype result = null;
        Value value = getConstantValue();
        if (null != value) {
            result = value.getContainedType();
        }
        return result;
    }
    
    @Override
    public String toString() {
        return null != constant ? constant.toString() : super.toString();
    }
    
    /**
     * Returns whether the given constraint is exactly the IVML null value.
     * 
     * @param cst the constraint syntax tree
     * @return <code>true</code> if <code>cst</code> is <b>null</b>, <code>false</code> else
     */
    public static final boolean isNull(ConstraintSyntaxTree cst) {
        return (cst instanceof ConstantValue && NullValue.INSTANCE == ((ConstantValue) cst).getConstantValue());
    }
    
}
