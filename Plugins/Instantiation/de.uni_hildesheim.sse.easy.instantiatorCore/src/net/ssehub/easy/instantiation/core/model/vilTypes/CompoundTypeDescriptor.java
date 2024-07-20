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
package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.common.IModifier;
import net.ssehub.easy.instantiation.core.model.common.IModifierHolder;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;

/**
 * Implements a compound type descriptor.
 * 
 * @author Holger Eichelberger
 */
public class CompoundTypeDescriptor extends TypeDescriptor<CompoundInstance> {

    private boolean isAbstract;
    private CompoundTypeDescriptor refines;
    private TypeRegistry registry;
    
    /**
     * A slot field descriptor for compounds.
     * 
     * @author Holger Eichelberger
     */
    public static class SlotDescriptor extends FieldDescriptor implements IModifierHolder {

        private List<IModifier> modifiers;
        private Expression expression;
        private boolean isConstant;
        
        /**
         * Creates a slot descriptor.
         * 
         * @param declaringType the declaring compound type
         * @param var the variable declaration representing the variable
         */
        public SlotDescriptor(CompoundTypeDescriptor declaringType, VariableDeclaration var) {
            super(declaringType, var.getName(), var.getType());
            int modCount = var.getModifierCount();
            if (modCount > 0) {
                modifiers = new ArrayList<IModifier>(modCount);
                for (int i = 0; i < modCount; i++) {
                    modifiers.add(var.getModifier(i));
                }
            }
            this.expression = var.getExpression();
            this.isConstant = var.isConstant();
        }

        @Override
        public String getJavaSignature() {
            return getType().getVilName() + " " + getName();
        }

        @Override
        public boolean isReadOnly() {
            return isConstant;
        }
        
        /**
         * Returns whether this slot is constant or not. By default, a slot is always not constant.
         * 
         * @return <b>True</b> if this slot is a constant. <b>False</b> otherwise.
         */
        public boolean isConstant() {
            return this.isConstant;
        }

        @Override
        public boolean isStatic() {
            return false;
        }

        @Override
        public Object getValue(Object owner) throws VilException {
            Object result = null;
            if (owner instanceof CompoundInstance) {
                result = ((CompoundInstance) owner).getSlotValue(getName());
            }
            return result;
        }

        @Override
        public void setValue(Object owner, Object value) throws VilException {
            if (owner instanceof CompoundInstance) {
                ((CompoundInstance) owner).setSlotValue(getName(), value);
            }
        }

        @Override
        public int getModifierCount() {
            return null == modifiers ? 0 : modifiers.size();
        }
        
        @Override
        public IModifier getModifier(int index) {
            if (null == modifiers) {
                throw new IndexOutOfBoundsException();
            }
            return modifiers.get(index);
        }
        
        @Override
        public boolean hasModifier(IModifier modifier) {
            return null == modifiers ? false : modifiers.contains(modifier);
        }
        
        /**
         * Returns the initialization expression.
         * 
         * @return the initialization expression, may be <b>null</b> if there is none
         */
        public Expression getExpression() {
            return expression;
        }

    }

    /**
     * The constructor operation(s).
     * 
     * @author Holger Eichelberger
     */
    private static class ConstructorOperationDescriptor extends OperationDescriptor {

        /**
         * Creates the operation descriptor.
         * 
         * @param declaringType the declaring type instance
         */
        protected ConstructorOperationDescriptor(TypeDescriptor<?> declaringType) {
            super(declaringType, "create", true);
            setParameters(new ArrayList<TypeDescriptor<?>>(), true, false);
            setReturnType(declaringType);
        }

        @Override
        public boolean isStatic() {
            return false;
        }

        @Override
        public boolean isFirstParameterOperand() {
            return false;
        }

        @Override
        public boolean isPlaceholder() {
            return false;
        }

        @Override
        public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
            return CompatibilityResult.COMPATIBLE;
        }

        @Override
        public Object invoke(Object... args) throws VilException {
            CompoundInstance result = new CompoundInstance((CompoundTypeDescriptor) getDeclaringType());
            if (1 == args.length && args[0] instanceof Map) {
                Map<?, ?> a0 = (Map<?, ?>) args[0];
                for (Map.Entry<?, ?> e : a0.entrySet()) {
                    try {
                        result.setSlotValue(e.getKey().toString(), e.getValue());
                    } catch (VilException ex) {
                        EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).warn(ex.getMessage());
                    }
                }
            }
            return result;
        }

        @Override
        protected void initializeParameters() {
        }

        @Override
        protected void initializeReturnType() {
        }

        @Override
        protected String getDeclaringTypeNameFallback() {
            return null;
        }

        @Override
        public String getJavaSignature() {
            return getName() + "()";
        }

        @Override
        public int useGenericParameterAsReturn() {
            return 0;
        }

        @Override
        public int useParameterAsReturn() {
            return 0;
        }

        @Override
        public boolean storeArtifactsBeforeExecution() {
            return false;
        }

    }
    
    /**
     * Represents a type->name operation descriptor.
     * 
     * @author Holger Eichelberger
     */
    private static class TypeOperationDescriptor extends OperationDescriptor {

        /**
         * Creates the operation descriptor.
         * 
         * @param declaringType the declaring type instance
         * @param name the name of the operation
         */
        protected TypeOperationDescriptor(TypeDescriptor<?> declaringType, String name) {
            super(declaringType, name, false);
            List<TypeDescriptor<?>> params = new ArrayList<TypeDescriptor<?>>();
            params.add(declaringType);
            setParameters(params, false, false);
            setReturnType(TypeRegistry.stringType());
        }

        @Override
        public boolean isStatic() {
            return false;
        }

        @Override
        public boolean isFirstParameterOperand() {
            return true;
        }

        @Override
        public boolean isPlaceholder() {
            return false;
        }

        @Override
        public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
            return CompatibilityResult.COMPATIBLE;
        }

        @Override
        public Object invoke(Object... args) throws VilException {
            Object result = null;
            if (1 == args.length) {
                Object a0 = args[0];
                if (a0 instanceof CompoundTypeDescriptor) {
                    result = ((CompoundTypeDescriptor) a0).getName();
                }
            }
            return result;
        }

        @Override
        protected void initializeParameters() {
        }

        @Override
        protected void initializeReturnType() {
        }

        @Override
        protected String getDeclaringTypeNameFallback() {
            return null;
        }

        @Override
        public String getJavaSignature() {
            return getName() + "()";
        }

        @Override
        public int useGenericParameterAsReturn() {
            return 0;
        }

        @Override
        public int useParameterAsReturn() {
            return 0;
        }

        @Override
        public boolean storeArtifactsBeforeExecution() {
            return false;
        }
        
    }


    /**
     * Creates a compound type descriptor.
     * 
     * @param name the name of the type
     * @param isAbstract if the type is abstract
     * @param refines if there is a refined type (may be <b>null</b> for none)
     * @param registry the defining type registry
     * @throws VilException in case of creation problems
     */
    public CompoundTypeDescriptor(String name, boolean isAbstract, CompoundTypeDescriptor refines, 
        TypeRegistry registry) throws VilException {
        super((TypeDescriptor<?>[]) null);
        setName(name);
        this.refines = refines;
        this.isAbstract = isAbstract;
        this.registry = registry;
        List<OperationDescriptor> operations = new ArrayList<OperationDescriptor>();
        operations.add(new TypeOperationDescriptor(this, "getName"));
        operations.add(new TypeOperationDescriptor(this, "name"));
        operations.add(new ConstructorOperationDescriptor(this));
        TypeOperationDescriptor toString = new TypeOperationDescriptor(this, "toString");
        operations.add(toString);
        setOperations(operations);
        operations.clear();
        operations.add(toString);
        setConversions(operations);
        operations.clear();
    }

    @Override
    public boolean isAssignableFrom(IMetaType type) {
        boolean result = false;
        type = AliasTypeDescriptor.unalias(type);
        if (type instanceof CompoundTypeDescriptor) {
            result = isAssignableFrom((CompoundTypeDescriptor) type);
        }
        return result;
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
    public boolean isActualTypeOf(IMetaType type) {
        return false; // shall not be handled by IActualTypeProvider
    }

    @Override
    public IMetaType getBaseType() {
        return null;
    }

    @Override
    public IMetaType getSuperType() {
        return refines;
    }

    /**
     * Returns the refined compound.
     * 
     * @return the refined compound (may be <b>null</b> if there is none)
     */
    public CompoundTypeDescriptor getRefines() {
        return refines;
    }

    @Override
    public boolean isInternal() {
        return false;
    }

    @Override
    public boolean checkConversion(IMetaType param, IMetaOperation conversion) {
        return true;
    }

    @Override
    public Class<CompoundInstance> getTypeClass() {
        return CompoundInstance.class;
    }

    @Override
    public boolean canBeInstantiated() {
        return !isAbstract;
    }
    
    /**
     * Returns whether the compound is abstract.
     * 
     * @return <code>true</code> for abstract, <code>false</code> else
     */
    public boolean isAbstract() {
        return isAbstract;
    }

    @Override
    public CompoundInstance create(Object... params) throws VilException {
        CompoundInstance result;
        if (isAbstract) {
            result = null;
        } else {
            result = new CompoundInstance(this); // no params accepted
        }
        return result;
    }

    @Override
    public boolean isAssignableFrom(TypeDescriptor<?> desc) {
        boolean isAssignable = false;
        desc = AliasTypeDescriptor.unalias(desc);
        if (desc instanceof CompoundTypeDescriptor) {
            CompoundTypeDescriptor iter = (CompoundTypeDescriptor) desc;
            while (null != iter && !isAssignable) {
                isAssignable = isSameType(iter);
                iter = iter.getRefines();
            }
        }
        return isAssignable;
    }

    @Override
    public boolean isMap() {
        return false;
    }

    @Override
    public boolean isIterator() {
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
    public boolean isInstance(Object object) {
        boolean result = false;
        if (object instanceof CompoundInstance) {
            CompoundInstance tmp = (CompoundInstance) object;
            result = isAssignableFrom(tmp.getType());
        }
        return result;
    }

    @Override
    public boolean isSameType(Object object) {
        return object == this;
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
    
    /**
     * Sets the fields of this descriptor, only if there have no fields been defined at all so far.
     * 
     * @param slots the slots defining the fields
     * @throws VilException in case that fields have been defined already
     */
    public void setFields(SlotDescriptor[] slots) throws VilException {
        if (isFieldsNull()) {
            super.setFields(slots);
        } else {
            throw new VilException("Fields are already defined", VilException.ID_INTERNAL);
        }
    }
    
    /**
     * Returns the specified slot descriptor.
     * 
     * @param index the 0-based index of the field to be returned
     * @return the specified field
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 
     *     || index&gt;={@link #getSlotCount()}</code>
     */
    public SlotDescriptor getSlot(int index) {
        return (SlotDescriptor) getField(index);
    }

    /**
     * Returns the number of slots provided by this compound type.
     * 
     * @return the number of slots
     */
    public int getSlotCount() {
        return getFieldCount();
    }
    
    /**
     * Returns the directly declared field with name <code>name</code>.
     * 
     * @param name the name of the field
     * @return the field descriptor or <b>null</b>
     */
    public FieldDescriptor getDeclaredField(String name) {
        return super.getField(name);
    }

    @Override
    public FieldDescriptor getField(String name) {
        // take super compounds into account
        FieldDescriptor field = null;
        CompoundTypeDescriptor iter = this;
        while (null != iter && null == field) {
            field = iter.getDeclaredField(name);
            iter = iter.getRefines();
        }
        return field;
    }

    /**
     * Returns the slot descriptor with the specified name.
     * 
     * @param name the name of the slot
     * @return the slot descriptor (may be <b>null</b> if not found)
     */
    public SlotDescriptor getSlot(String name) {
        return (SlotDescriptor) getField(name);
    }

    /**
     * Returns the directly declared slot with name <code>name</code>.
     * 
     * @param name the name of the slot
     * @return the slot descriptor or <b>null</b>
     */
    public SlotDescriptor getDeclaredSlot(String name) {
        return (SlotDescriptor) getDeclaredField(name);
    }

}
