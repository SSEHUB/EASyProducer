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

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationType;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Defines an operation descriptor which enables access to the underlying configuration.
 * 
 * @author Holger Eichelberger
 */
public class IvmlConfigurationConversionOperationDescriptor extends IvmlOperationDescriptor {

    public static final String NAME = "convertToGeneric";

    /**
     * Creates the operation descriptor.
     * 
     * @param declaringType the declaring type
     */
    IvmlConfigurationConversionOperationDescriptor(TypeDescriptor<?> declaringType) {
        super(declaringType, NAME, false);
        setReturnType(IvmlTypes.configurationType());
        setParameters(createParameterList(declaringType), false, false);
        setCharacteristics(OperationType.NORMAL, AliasType.NONE, true, NAME);
    }
    
    @Override
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        return Utils.isCompatible(params, Configuration.class);
    }

    @Override
    public Object invoke(Object... args) throws VilException {
        Object result;
        if (null == args[0]) {
            result = null;
        } else {
            if (Utils.isCompatible(args, Configuration.class) != CompatibilityResult.COMPATIBLE) {
                throw new VilException("incompatible arguments", VilException.ID_TYPE_INCOMPATIBILITY);
            }
            result = args[0];
        } 
        return result;
    }

}
