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
package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Implements a reflection field descriptor.
 * 
 * @author Holger Eichelberger
 */
public class ReflectionFieldDescriptor extends FieldDescriptor {

    private Field field;
    private boolean readOnly;

    /**
     * Creates a new reflection field descriptor taking the information from <code>field</code>.
     * 
     * @param declaringType the declaring type
     * @param field the field
     * @param typeGenerics the generics of the field type (may be <b>null</b>)
     */
    public ReflectionFieldDescriptor(TypeDescriptor<?> declaringType, Field field, 
        Class<?>[] typeGenerics) {
        this(declaringType, field, field.getName(), Modifier.isFinal(field.getModifiers()), typeGenerics);
    }

    /**
     * Creates a new reflection field descriptor taking the information from <code>field</code>.
     * 
     * @param declaringType the declaring type
     * @param field the field
     * @param name the explicit name of the field (may be <b>null</b> to take the name of <code>field</code>)
     * @param typeGenerics the generics of the field type (may be <b>null</b>)
     */
    public ReflectionFieldDescriptor(TypeDescriptor<?> declaringType, Field field, String name, 
        Class<?>[] typeGenerics) {
        this(declaringType, field, null == name ? field.getName() : name, Modifier.isFinal(field.getModifiers()), 
            typeGenerics);
    }

    /**
     * Creates a new reflection field descriptor.
     * 
     * @param declaringType the declaring type
     * @param field the field
     * @param name the name the field shall be accessible
     * @param readOnly whether the field is readonly
     * @param typeGenerics the generics of the field type (may be <b>null</b>)
     */
    public ReflectionFieldDescriptor(TypeDescriptor<?> declaringType, Field field, String name, boolean readOnly, 
        Class<?>[] typeGenerics) {
        super(declaringType, name, ReflectionResolver.resolveType(field.getType(), typeGenerics));
        this.field = field;
        this.readOnly = readOnly;
    }
    
    @Override
    public String getJavaSignature() {
        return field.getType().getName() + " " + field.getName();
    }

    @Override
    public boolean isReadOnly() {
        return readOnly;
    }
    
    @Override
    public boolean isStatic() {
        return Modifier.isStatic(field.getModifiers());
    }

    @Override
    public Object getValue(Object owner) throws VilException {
        try {
            return field.get(owner);
        } catch (IllegalArgumentException e) {
            throw new VilException(e, VilException.ID_RUNTIME);
        } catch (IllegalAccessException e) {
            throw new VilException(e, VilException.ID_RUNTIME);
        }
    }

    @Override
    public void setValue(Object owner, Object value) throws VilException {
        try {
            field.set(owner, value);
        } catch (IllegalArgumentException e) {
            throw new VilException(e, VilException.ID_RUNTIME);
        } catch (IllegalAccessException e) {
            throw new VilException(e, VilException.ID_RUNTIME);
        }
    }

}
