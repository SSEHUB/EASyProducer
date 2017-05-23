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
package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Defines a delegating alias type.
 * 
 * @param <T> the specific VilType or Artifact
 * @author Holger Eichelberger
 */
class AliasTypeDescriptor <T> extends TypeDescriptor<T> {

    private TypeDescriptor<T> type;
    private TypeRegistry registry;

    /**
     * Creates an alias type descriptor.
     * 
     * @param registry the type registry this type is registered with
     * @param name the name of the alias type
     * @param type the represented (aliased) type
     * @throws VilException if creating the type fails
     */
    AliasTypeDescriptor(TypeRegistry registry, String name, TypeDescriptor<T> type) throws VilException {
        super(type.getGenericParameter());
        setName(name);
        this.type = type;
        this.registry = registry;
        setConversions(toCollection(type.getConversions()));
        setFields(toCollection(type.getFields()));
        setOperations(toCollection(type.getOperations()));
    }
    
    /**
     * Turns an iterable into a collection.
     * 
     * @param <T> the element type
     * @param src the source iterable
     * @return the collection containing all elements from <code>src</code>
     */
    private static <T> java.util.Collection<T> toCollection(Iterable<T> src) {
        List<T> result = new ArrayList<T>();
        Iterator<T> iter = src.iterator();
        while (iter.hasNext()) {
            result.add(iter.next());
        }
        return result;
    }
    
    /**
     * Returns the aliased type.
     * 
     * @return the aliased type
     */
    TypeDescriptor<?> getAliasedType() {
        return type;
    }
    
    @Override
    public boolean isAssignableFrom(IMetaType type) {
        return this.type.isAssignableFrom(type);
    }

    @Override
    public boolean isBasicType() {
        return type.isBasicType();
    }

    @Override
    public TypeRegistry getTypeRegistry() {
        return registry;
    }

    @Override
    public boolean isPlaceholder() {
        return type.isPlaceholder();
    }

    @Override
    public boolean isActualTypeOf(IMetaType type) {
        return this.type.isActualTypeOf(type);
    }

    @Override
    public IMetaType getBaseType() {
        return type.getBaseType();
    }

    @Override
    public IMetaType getSuperType() {
        return type.getSuperType();
    }

    @Override
    public boolean isInternal() {
        return type.isInternal();
    }

    @Override
    public Class<T> getTypeClass() {
        return type.getTypeClass();
    }

    @Override
    public boolean canBeInstantiated() {
        return type.canBeInstantiated();
    }

    @Override
    public T create(Object... params) throws VilException {
        return type.create(params);
    }

    @Override
    public boolean isAssignableFrom(TypeDescriptor<?> desc) {
        return type.isAssignableFrom(desc);
    }

    @Override
    public boolean isIterator() {
        return type.isIterator();
    }

    @Override
    public boolean isMap() {
        return type.isMap();
    }

    @Override
    public boolean isCollection() {
        return type.isCollection();
    }

    @Override
    public boolean isSet() {
        return type.isSet();
    }

    @Override
    public boolean isSequence() {
        return type.isSequence();
    }

    @Override
    public boolean isInstance(Object object) {
        return type.isInstance(object);
    }
    
    @Override
    public boolean isSameType(Object object) {
        return type.isSameType(object);
    }

    @Override
    public OperationDescriptor addPlaceholderOperation(String name, int parameterCount, 
        boolean acceptsNamedParameters) {
        return type.addPlaceholderOperation(name, parameterCount, acceptsNamedParameters);
    }

    @Override
    public boolean isInstantiator() {
        return type.isInstantiator();
    }
    
    @Override
    public boolean checkConversion(IMetaType param, IMetaOperation conversion) {
        return true;
    }

    
    /**
     * Unalisases <code>type</code>.
     * 
     * @param type the type
     * @return the unalised type
     */
    static IMetaType unalias(IMetaType type) {
        if (type instanceof AliasTypeDescriptor) {
            type = ((AliasTypeDescriptor<?>) type).getAliasedType();
        }        
        return type;
    }
    
    /**
     * Unalisases <code>type</code>.
     * 
     * @param type the type
     * @return the unalised type
     */
    static TypeDescriptor<?> unalias(TypeDescriptor<?> type) {
        if (type instanceof AliasTypeDescriptor) {
            type = ((AliasTypeDescriptor<?>) type).getAliasedType();
        }        
        return type;
    }

}
