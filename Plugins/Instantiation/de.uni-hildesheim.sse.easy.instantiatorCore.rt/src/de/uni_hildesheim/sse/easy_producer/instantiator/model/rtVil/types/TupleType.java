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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Strategy;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.FieldDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Implements a specific temporary type for dynamic tuples in rt-VIL strategies.
 * 
 * @author Holger Eichelberger
 */
public class TupleType extends TypeDescriptor<TupleType> implements IVilType {

    private static final String TYPE_NAME_PREFIX = "$TUPLE$_"; // non VIL type!
    private TypeRegistry registry;
    
    /**
     * Implements a field descriptor for {@link TupleType}.
     * 
     * @author Holger Eichelberger
     */
    private static class TupleFieldDescriptor extends FieldDescriptor {

        /**
         * Creates a read-only tuple field descriptor.
         * 
         * @param declaringType the declaring type
         * @param name the field name
         * @param type the field type
         */
        private TupleFieldDescriptor(TypeDescriptor<?> declaringType, String name, TypeDescriptor<?> type) {
            super(declaringType, name, type);
        }
        
        @Override
        public String getJavaSignature() {
            return getSignature();
        }

        @Override
        public Object getValue(Object owner) throws VilException {
            Object result = null;
            if (getDeclaringType().isInstance(owner)) {
                result = ((TupleInstance) owner).get(getName());
            }
            return result;
        }

        @Override
        public boolean isReadOnly() {
            return true;
        }

        @Override
        public void setValue(Object owner, Object value) throws VilException {
            throw new VilException("field '" + getName() + "' is readonly", VilException.ID_SEMANTIC);
        }

        @Override
        public boolean isStatic() {
            return false;
        }
        
    }

    /**
     * Implements an instance of {@link TupleType}.
     * 
     * @author Holger Eichelberger
     */
    public static class TupleInstance extends java.util.HashMap<String, Object> {
        
        private static final long serialVersionUID = -186472759817751906L;
        private TupleType type;
        
        /**
         * Creates a tuple instance for a given tuple type.
         * 
         * @param type the tuple type
         */
        public TupleInstance(TupleType type) {
            this.type = type;
        }
        
        /**
         * Returns the actual type.
         * 
         * @return the actual type
         */
        public TupleType getType() {
            return type;
        }
        
    }
    
    /**
     * Creates a new tuple type in the given context (for constructing the type name) with the given fields.
     * 
     * @param declaringContext the declaring context (for deriving the type name)
     * @param fields the actual fields
     * @param registry the owning registry
     * @throws VilException if initialization fails
     */
    public TupleType(Strategy declaringContext, Map<String, TypeDescriptor<?>> fields, 
        TypeRegistry registry) throws VilException {
        super(TypeDescriptor.EMPTY);
        
        setName(TYPE_NAME_PREFIX + declaringContext.getParent().getName() + "." 
            + declaringContext.getSignature().replace(' ', '-'));
        this.registry = registry;
        List<FieldDescriptor> fTmp = new ArrayList<FieldDescriptor>();
        for (Map.Entry<String, TypeDescriptor<?>> entry : fields.entrySet()) {
            fTmp.add(new TupleFieldDescriptor(this, entry.getKey(), entry.getValue()));
        }
        setFields(fTmp);
    }
    
    @Override
    public boolean isAssignableFrom(IMetaType type) {
        return equals(type); // as TupleType is temporary only, there is no cross-assignment
    }

    @Override
    public boolean isAssignableFrom(TypeDescriptor<?> desc) {
        return equals(desc); // as TupleType is temporary only, there is no cross-assignment
    }

    @Override
    public boolean isActualTypeOf(IMetaType type) {
        return equals(type); // as TupleType is temporary only, there is no cross-assignment
    }
    
    @Override
    public boolean isInstance(Object object) {
        return object instanceof TupleInstance && isAssignableFrom(((TupleInstance) object).getType());
    }

    @Override
    public boolean isBasicType() {
        return false;
    }

    @Override
    public TypeRegistry getTypeRegistry() {
        return registry;
    }

    @Override
    public boolean isPlaceholder() {
        return false;
    }

    @Override
    public IMetaType getBaseType() {
        return null;
    }

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public Class<TupleType> getTypeClass() {
        return TupleType.class;
    }

    @Override
    public boolean canBeInstantiated() {
        return false; // this is done implicitly by rt-VIL
    }

    @Override
    public TupleType create(Object... params) throws VilException {
        return null; // this is done implicitly by rt-VIL
    }

    @Override
    public boolean isMap() {
        return false;
    }

    @Override
    public boolean isCollection() {
        return false;
    }

    @Override
    public boolean isSet() {
        return false;
    }

    @Override
    public boolean isSequence() {
        return false;
    }

    @Override
    public OperationDescriptor addPlaceholderOperation(String name, int parameterCount, 
        boolean acceptsNamedParameters) {
        return null;
    }

    @Override
    public boolean isInstantiator() {
        return false;
    }

    @Override
    public IMetaType getSuperType() {
        return null;
    }

}
