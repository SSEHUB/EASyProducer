/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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

import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * An abstract basic operation descriptor for type operations.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractIvmlTypeOperationDescriptor extends IvmlOperationDescriptor {

    /**
     * Creates a new operation descriptor. Overriding constructors shall call 
     * {@link #setCharacteristics(OperationType, AliasType, boolean)} in order to redefined the 
     * default values.
     * 
     * @param declaringType the declaring type
     * @param name the alias name (may be <b>null</b> if the original name of <code>method</code> shall be used)
     * @param isConstructor whether the operation is a constructor
     */
    AbstractIvmlTypeOperationDescriptor(TypeDescriptor<?> declaringType, String name, boolean isConstructor) {
        super(declaringType, name, isConstructor);
    }
    
    /**
     * Returns the actual type of <code>ob</code>.
     * 
     * @param ob the object to return the type for
     * @return the type
     */
    protected TypeDescriptor<?> getActualType(Object ob) {
        TypeDescriptor<?> result = null;
        if (null != ob) {
            result = getParameterType(0).getTypeRegistry().findType(ob.getClass(), false);
        }
        if (null == result) {
            result = TypeRegistry.voidType();
        }
        return result;
    }
    
}
