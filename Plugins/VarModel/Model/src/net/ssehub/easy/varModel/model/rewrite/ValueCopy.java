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
package net.ssehub.easy.varModel.model.rewrite;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ConstraintValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.EnumValue;
import net.ssehub.easy.varModel.model.values.IValueVisitor;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.MetaTypeValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.RealValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.StringValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.model.values.VersionValue;

/**
 * Filters a given {@link Value} and creates a copy without filtered elements.
 * @author El-Sharkawy
 *
 */
class ValueCopy implements IValueVisitor {
    
    /**
     * Stores the current visited value.
     * Maybe the same instance or a copied/filtered version.
     * Maybe null if the current value shall be filtered out.
     */
    private Value copiedValue;
    private boolean valuesOmmited;
    private RewriteContext context;
    
    /**
     * Single constructor of this class.
     * @param context The context, containing information about filtered elements.
     * @param value The value to be copied.
     */
    ValueCopy(RewriteContext context, Value value) {
        this.context = context;
        valuesOmmited = false;
        value.accept(this);
    }
    
    /**
     * Returns the filtered and copied value.
     * @return Maybe the same instance if filtering was not needed. Maybe <tt>null</tt> if complete value was filtered.
     */
    Value getValue() {
        return copiedValue;
    }
    
    /**
     * Returns whether the original value will be returned or whether at least one value was removed from the original
     * value.
     * @return <tt>true</tt> if at least one value was removed, <tt>false</tt> if the original value will be returned.
     */
    boolean valuesOmitted() {
        return valuesOmmited;
    }

    @Override
    public void visitConstraintValue(ConstraintValue value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitEnumValue(EnumValue value) {
        // Check whether literals can be filtered (Currently not the case).
        this.copiedValue = value;        
    }

    @Override
    public void visitStringValue(StringValue value) {
        this.copiedValue = value;
    }

    @Override
    public void visitCompoundValue(CompoundValue value) {
        Compound cType = (Compound) value.getType();
        ArrayList<Object> copiedValues = new ArrayList<Object>();
        for (int i = 0, n = cType.getInheritedElementCount(); i < n; i++) {
            String slotName = cType.getInheritedElement(i).getName();
            Value nestedValue = value.getNestedValue(slotName);
            if (null != nestedValue) {
                nestedValue.accept(this);
                if (null != this.copiedValue) {
                    copiedValues.add(slotName);
                    copiedValues.add(this.copiedValue);
                }
            }
        }
        if (!valuesOmmited) {
            this.copiedValue = value;
        } else if (!copiedValues.isEmpty() && valuesOmmited) {
            try {
                this.copiedValue = ValueFactory.createValue(cType, copiedValues.toArray());
            } catch (ValueDoesNotMatchTypeException e) {
                this.copiedValue = value;
                EASyLoggerFactory.INSTANCE.getLogger(ValueCopy.class, Bundle.ID).exception(e);
            }
        } else if (copiedValues.isEmpty()) {
            try {
                this.copiedValue = ValueFactory.createValue(cType, (Object[]) null);
            } catch (ValueDoesNotMatchTypeException e) {
                this.copiedValue = value;
                EASyLoggerFactory.INSTANCE.getLogger(ValueCopy.class, Bundle.ID).exception(e);
            }
        }
    }

    @Override
    public void visitContainerValue(ContainerValue value) {
        List<Value> copiedValues = new ArrayList<Value>();
        for (int i = 0, n = value.getElementSize(); i < n; i++) {
            value.getElement(i).accept(this);
            if (null != this.copiedValue) {
                copiedValues.add(this.copiedValue);
            }
        }
        if (!valuesOmmited) {
            this.copiedValue = value;
        } else if (!copiedValues.isEmpty() && valuesOmmited) {
            try {
                this.copiedValue = ValueFactory.createValue(value.getType(), copiedValues.toArray());
            } catch (ValueDoesNotMatchTypeException e) {
                this.copiedValue = value;
                EASyLoggerFactory.INSTANCE.getLogger(ValueCopy.class, Bundle.ID).exception(e);
            }
        } else if (copiedValues.isEmpty()) {
            try {
                this.copiedValue = ValueFactory.createValue(value.getType(), (Object[]) null);
            } catch (ValueDoesNotMatchTypeException e) {
                this.copiedValue = value;
                EASyLoggerFactory.INSTANCE.getLogger(ValueCopy.class, Bundle.ID).exception(e);
            }
        }
    }

    @Override
    public void visitIntValue(IntValue value) {
        this.copiedValue = value;
    }

    @Override
    public void visitRealValue(RealValue value) {
        this.copiedValue = value;
    }

    @Override
    public void visitBooleanValue(BooleanValue value) {
        this.copiedValue = value;
    }

    @Override
    public void visitReferenceValue(ReferenceValue referenceValue) {
        AbstractVariable referencedDecl = referenceValue.getValue();
        if (null != referencedDecl && context.elementWasRemoved(referencedDecl)) {
            this.copiedValue = null;
            valuesOmmited = true;
        } else {
            // TODO SE: Handle referenceValue.getValueEx()
            this.copiedValue = referenceValue;
        }
    }

    @Override
    public void visitMetaTypeValue(MetaTypeValue value) {
        // TODO: Check whether meta values can be filtered.
        this.copiedValue = value;
    }

    @Override
    public void visitNullValue(NullValue value) {
        this.copiedValue = value;
    }

    @Override
    public void visitVersionValue(VersionValue value) {
        this.copiedValue = value;
    }

}
