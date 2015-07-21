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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;

/**
 * Resolves reflective types. Considers {@link IClassNameMapperProvider} on the
 * type registry if given.
 * 
 * @author Holger Eichelberger
 */
public class ReflectionResolver {

    private static TypeRegistry registry = TypeRegistry.DEFAULT;
    private static IClassNameMapper mapper = null;
    
    /**
     * Changes the type registry for resolution.
     * 
     * @param reg the type registry (<b>null</b> is ignored)
     * @return the registry before setting
     */
    public static TypeRegistry setTypeRegistry(TypeRegistry reg) {
        TypeRegistry before = registry;
        if (null != reg) {
            registry = reg;
            if (registry instanceof IClassNameMapperProvider) {
                mapper = ((IClassNameMapperProvider) registry).getClassNameMapper();
            } else {
                mapper = null;
            }
        }
        return before;
    }
    
    /**
     * Returns the active registry for resolution.
     * 
     * @return the type registry
     */
    public static TypeRegistry getTypeRegistry() {
        return registry;
    }
    
    /**
     * Resolves the given type to a type descriptor.
     *  
     * @param cls the class to be resolved
     * @param generics the type generics (may be <b>null</b> if none)
     * @return the resolved type descriptor
     */
    public static TypeDescriptor<?> resolveType(Class<?> cls, Class<?>[] generics) {
        TypeDescriptor<?> result = null;
        if (Void.TYPE == cls) {
            result = ReflectionTypeDescriptor.VOID;
        } else {
            TypeDescriptor<?>[] parameter = null;
            if (null != generics) {
                parameter = TypeDescriptor.createArray(generics.length);
                for (int i = 0; i < generics.length; i++) {
                    parameter[i] = registry.getType(ReflectionTypeDescriptor.getRegName(generics[i]));
                    if (null == parameter[i]) {
                        parameter[i] = registry.getMappedType(generics[i], null);
                    }
                }
            }
            try {
                if (ReflectionTypeDescriptor.isSet(cls)) {
                    result = TypeRegistry.getSetType(parameter);
                } else if (ReflectionTypeDescriptor.isSequence(cls)) {
                    result = TypeRegistry.getSequenceType(parameter);
                } else if (ReflectionTypeDescriptor.isMap(cls)) {
                    result = TypeRegistry.getMapType(parameter);
                }
            } catch (VilException e) {
                // no type -> handled later
            }
            if (null == result) {
                if (null != mapper) {
                    result = registry.getMappedType(cls, parameter);
                }
                if (null == result) {
                    String clsName;
                    if (null != mapper) {
                        clsName = mapper.getVilName(cls);
                    } else {
                        clsName = cls.getName();
                    }
                    result = registry.getType(clsName);
                    if (null == result) {
                        result = registry.getType(cls.getSimpleName()); // artifacts
                    }
                }
            }
            if (null == result) {
                if (Object.class == cls) {
                    result = ReflectionTypeDescriptor.ANY;
                } else {
                    result = ReflectionTypeDescriptor.VOID;
                }
            }
        }
        return result;
    }

}
