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

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.IDirectTypeRegistryAccess;
import net.ssehub.easy.instantiation.core.model.vilTypes.ITypeResolver;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * A basic IVML type resolver that just creates fake types.
 * 
 * @author Holger Eichelberger
 */
public class IvmlBaseTypeResolver implements ITypeResolver {

    private static final EASyLogger LOGGER 
        = EASyLoggerFactory.INSTANCE.getLogger(IvmlBaseTypeResolver.class, Bundle.ID);
    private IDirectTypeRegistryAccess access;
    private TypeRegistry typeRegistry;

    /**
     * Creates an IVML type resolver.
     * 
     * @param typeRegistry the type registry this resolver is working for
     */
    public IvmlBaseTypeResolver(TypeRegistry typeRegistry) {
        this.typeRegistry = typeRegistry;
    }

    @Override
    public TypeRegistry getTypeRegistry() {
        return typeRegistry;
    }

    @Override
    public TypeDescriptor<?> resolveType(String name, boolean addIfMissing) {
        TypeDescriptor<?> result = null;
        if (addIfMissing) {
            try {
                // automatically create fake types as having an IVML type resolver implies @advice
                // but only for non-IVML-IDs such as enum values
                result = new FakeTypeDescriptor(typeRegistry, name);
                addType(name, result);
            } catch (VilException e) {
                LOGGER.warn(e.getMessage()); // shall not occur
            }
        }
        return result;
    }

    @Override
    public TypeDescriptor<?> resolveType(IDatatype type) {
        if (!isKnown(type.getQualifiedName())) {
            resolveType(type.getQualifiedName(), true);
        }
        return resolveType(type.getName(), true);
    }

    @Override
    public TypeDescriptor<? extends IVilType> resolveInstantiator(String name) {
        return null; // Do not create FakeType -> Serialization
    }

    @Override
    public void setRegistryAccess(IDirectTypeRegistryAccess access) {
        this.access = access;
    }
    
    /**
     * Returns whether the given type is already known.
     * 
     * @param name the name of the type
     * @return <code>true</code> if the type is already known, <code>false</code> else
     */
    public boolean isKnown(String name) {
        return access.contains(name);
    }

    /**
     * Adds a type via a given name.
     * 
     * @param name the name of the type
     * @param type the type to be registered
     */
    protected void addType(String name, TypeDescriptor<?> type) {
        if (!isKnown(name)) {
            access.add(name, type);
        }
    }
    
    /**
     * Returns the direct registry access object.
     * 
     * @return the access object, only valid after {@link #setRegistryAccess(IDirectTypeRegistryAccess)}
     */
    protected IDirectTypeRegistryAccess getRegistryAccess() {
        return access;
    }

}
