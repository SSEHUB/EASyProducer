/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
import net.ssehub.easy.instantiation.core.model.vilTypes.PseudoString;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Performs a conversion of an object (usually an {@link IvmlTypeDescriptor} to a String. Emulates 
 * {@link PseudoString#convertAny(Object)}, in particular for 
 * {@link net.ssehub.easy.instantiation.core.model.expressions.VarModelIdentifierExpression} having a specific
 * type assigned.
 * 
 * @author Holger Eichelberger
 */
public class IvmlToStringConversionOperationDescriptor extends IvmlConversionOperationDescriptor {

    /**
     * For serialization.
     */
    IvmlToStringConversionOperationDescriptor() {
        super(null, null);
    }
    
    /**
     * Creates a conversion to string operation descriptor.
     * 
     * @param declaringType the declaring type
     */
    IvmlToStringConversionOperationDescriptor(TypeDescriptor<?> declaringType) {
        super(declaringType, TypeRegistry.stringType());
    }

    @Override
    public Object invoke(Object... args) throws VilException {
        return PseudoString.convertAny(args[0]);
    }

}
