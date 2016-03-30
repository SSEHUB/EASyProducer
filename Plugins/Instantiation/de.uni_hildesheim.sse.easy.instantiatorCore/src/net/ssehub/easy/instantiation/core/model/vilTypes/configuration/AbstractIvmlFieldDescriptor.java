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
package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.FieldDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.varModel.model.AbstractVariable;

/**
 * Implements the common capabilities for an IVML read-only field descriptor.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractIvmlFieldDescriptor extends FieldDescriptor {

    private AbstractVariable var;
    
    /**
     * Creates the field descriptor.
     * 
     * @param declaringType the declaring type
     * @param var the variable to create the descriptor for
     * @param registry the actual type registry 
     * @throws VilException in case that creating the descriptor fails
     */
    protected AbstractIvmlFieldDescriptor(TypeDescriptor<?> declaringType, 
        AbstractVariable var, TypeRegistry registry) throws VilException {
        super(declaringType, var.getName(), Utils.determineReturnType(var.getType(), registry, true));
        this.var = var;
    }
    
    /**
     * Returns the underlying IVML variable.
     * 
     * @return the underlying variable
     */
    protected AbstractVariable getVariable() {
        return var;
    }
    
    @Override
    public String getJavaSignature() {
        return getSignature();
    }

    @Override
    public boolean isReadOnly() {
        return !getDeclaringType().getTypeRegistry().forRuntime();
    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public TypeDescriptor<?> getMetaType() {
        return IvmlTypes.decisionVariableType();
    }
    
    /**
     * Returns the specific base value according to the decision variable access functions.
     * 
     * @param tmp the decision variable 
     * @return the specific base value, <b>null</b> if not possible
     */
    protected Object getSpecificBaseValue(AbstractIvmlVariable tmp) {
        Object result = null;
        if (TypeRegistry.stringType() == getType()) {
            result = tmp.getStringValue();
        } else if (TypeRegistry.booleanType() == getType()) {
            result = tmp.getBooleanValue();
        } else if (TypeRegistry.realType() == getType()) {
            result = tmp.getRealValue();
        } else if (TypeRegistry.integerType() == getType()) {
            result = tmp.getIntegerValue();
        }
        return result;
    }
    
}
