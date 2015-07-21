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
 * Implements an abstract field descriptor.
 * 
 * @author Holger Eichelberger
 */
public abstract class FieldDescriptor implements IMetaField {

    private String name;
    private TypeDescriptor<?> fieldType;
    private TypeDescriptor<?> declaringType;

    /**
     * Creates a field descriptor.
     * 
     * @param declaringType the declaring type
     * @param name the name of the field
     * @param fieldType the type of the field
     */
    protected FieldDescriptor(TypeDescriptor<?> declaringType, 
        String name, TypeDescriptor<?> fieldType) {
        this.name = name;
        this.fieldType = fieldType;
        this.declaringType = declaringType;
    }

    /**
     * Returns the declaring type.
     * 
     * @return the declaring type (may be <b>null</b> in case of a wrapped external Java method)
     */
    public TypeDescriptor<?> getDeclaringType() {
        return declaringType;
    }

    /**
     * Returns the actual value of this field.
     * 
     * @param owner the owning object (ignored, i.e., shall be <b>null</b>, if {@link #isStatic()})
     * @return the actual value
     * @throws VilException in case that retrieving the value fails
     */
    public abstract Object getValue(Object owner) throws VilException;

    /**
     * Changes the actual value for this field in <code>owner</code>.
     * 
     * @param owner the owning object (ignored, i.e., shall be <b>null</b>, if {@link #isStatic()})
     * @param value the new value
     * @throws VilException in case that setting the value fails, e.g., as this field is {@link #isReadOnly()}
     */
    public abstract void setValue(Object owner, Object value) throws VilException;
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSignature() {
        StringBuilder tmp = new StringBuilder();
        tmp.append(getType().getVilName());
        tmp.append(" ");
        tmp.append(name);
        return tmp.toString();
    }

    @Override
    public TypeDescriptor<?> getType() {
        return fieldType;
    }
    
    /**
     * Returns the type to resolve operations on the field itself, e.g.,
     * whether the underlying decision variable is defined. A field must not
     * return a type (<b>null</b>, in particular if {@link #isStatic()}). If not 
     * <b>null</b>, this class must return a valid value in {@link #getMetaValue(Object)}.
     * 
     * @return <b>null</b>
     */
    public TypeDescriptor<?> getMetaType() {
        return null;
    }
    
    /**
     * Returns the value corresponding to {@link #getMetaType()}.
     * 
     * @param owner the owning object
     * @return the actual value
     * @throws VilException in case that retrieving the value fails
     */
    public Object getMetaValue(Object owner) throws VilException {
        return null;
    }

}
