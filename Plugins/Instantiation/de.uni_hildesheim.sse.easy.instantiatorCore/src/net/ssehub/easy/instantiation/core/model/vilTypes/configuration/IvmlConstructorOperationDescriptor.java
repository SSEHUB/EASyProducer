/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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

import java.util.ArrayList;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Implements an IMVL type constructor.
 * 
 * @author Holger Eichelberger
 */
public class IvmlConstructorOperationDescriptor extends IvmlOperationDescriptor {

    private IDatatype ivmlType;
    
    /**
     * Creates a constructor descriptor without parameters.
     * 
     * @param declaringType the declaring type.
     * @param ivmlType the IVML type (for declaring type)
     */
    IvmlConstructorOperationDescriptor(TypeDescriptor<?> declaringType, IDatatype ivmlType) {
        super(declaringType, "create", true);
        this.ivmlType = ivmlType;
        setParameters(new ArrayList<TypeDescriptor<?>>(), false, false);
    }

    @Override
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        return CompatibilityResult.COMPATIBLE;
    }

    @Override
    public Object invoke(Object... args) throws VilException {
        try {
            return ValueFactory.createValue(ivmlType);
        } catch (ValueDoesNotMatchTypeException e) {
            throw new VilException(e, VilException.ID_RUNTIME);
        }
    }
    
}