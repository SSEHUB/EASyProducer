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
package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.FieldDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Represents a field access.
 * 
 * @author Holger Eichelberger
 */
public class FieldAccessExpression extends Expression {

    private FieldAccessExpression nested;
    private VariableDeclaration variable;
    private FieldDescriptor field;
    private boolean metaAccess;
    
    /**
     * Creates a static field access expression.
     * 
     * @param field the field to access
     * @throws VilException in case that a static access cannot be done
     */
    public FieldAccessExpression(FieldDescriptor field) throws VilException {
        this.field = field;
        this.variable = null;
        if (!field.isStatic()) {
            throw new VilException("static field access must be on a static field", VilException.ID_STATIC);
        }
    }
    
    /**
     * Creates a field access expression.
     * 
     * @param variable the variable
     * @param field the field to access
     * @throws VilException in case that a static access cannot be done
     */
    public FieldAccessExpression(VariableDeclaration variable, FieldDescriptor field) throws VilException {
        this.variable = variable;
        this.field = field;
        if (field.isStatic()) {
            throw new VilException("non-static field access must be on a non-static field", VilException.ID_STATIC);
        }
    }

    /**
     * Creates a nested field access expression.
     * 
     * @param nested the nested expression (innermost created by the other constructor)
     * @param field the field to access
     */
    public FieldAccessExpression(FieldAccessExpression nested, FieldDescriptor field) {
        this.nested = nested;
        this.field = field;
        //metaAccess -> false!
    }
    
    /**
     * Returns the nested field access expression.
     * 
     * @return the nested expression (<b>null</b> if {@link #getVariable()} not <b>null</b>)
     */
    public FieldAccessExpression getNested() {
        return nested;
    }
    
    /**
     * Returns the variable to work on.
     * 
     * @return the variable (<b>null</b> if {@link #getNested()} not <b>null</b>)
     */
    public VariableDeclaration getVariable() {
        return variable;
    }
    
    /**
     * Returns the field.
     * 
     * @return the field
     */
    public FieldDescriptor getField() {
        return field;
    }
    
    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        TypeDescriptor<?> result = null;
        if (isMetaAccess()) {
            result = field.getMetaType();
        }
        if (null == result) {
            result = field.getType();
        }
        return result;
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        return visitor.visitFieldAccessExpression(this);
    }
    
    /**
     * Returns whether the field itself or the value of the field expression shall
     * be considered during execution.
     * 
     * @return <code>true</code> if the field itself shall be considered, <code>false</code> if the 
     * evaluation of the field expression shall be considered
     */
    public boolean isMetaAccess() {
        return metaAccess;
    }
    
    /**
     * Switches from evaluating the field expression (default) to evaluating the field itself.
     */
    public void enableMetaAccess() {
        metaAccess = true;
    }

}
