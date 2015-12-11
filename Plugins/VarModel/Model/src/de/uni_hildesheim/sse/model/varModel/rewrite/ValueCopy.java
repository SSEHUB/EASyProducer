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
package de.uni_hildesheim.sse.model.varModel.rewrite;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.values.BooleanValue;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ConstraintValue;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.EnumValue;
import de.uni_hildesheim.sse.model.varModel.values.IValueVisitor;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.MetaTypeValue;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.RealValue;
import de.uni_hildesheim.sse.model.varModel.values.ReferenceValue;
import de.uni_hildesheim.sse.model.varModel.values.StringValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.model.varModel.values.VersionValue;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;

/**
 * Filters a given {@link Value} and creates a copy without filtered elements.
 * FIXME SE: This implementation is for testing and not finished!
 * @author El-Sharkawy
 *
 */
class ValueCopy implements IValueVisitor {
    
    private Value value;
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
     * @return Maybe the same instance if filtering was not needed.
     */
    Value getValue() {
        return value;
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitStringValue(StringValue value) {
        // TODO Auto-generated method stub
        
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
                if (null != this.value) {
                    copiedValues.add(slotName);
                    copiedValues.add(this.value);
                }
            }
        }
        if (!valuesOmmited) {
            this.value = value;
        } else if (!copiedValues.isEmpty() && valuesOmmited) {
            try {
                this.value = ValueFactory.createValue(cType, copiedValues.toArray());
            } catch (ValueDoesNotMatchTypeException e) {
                this.value = value;
                EASyLoggerFactory.INSTANCE.getLogger(ValueCopy.class, Bundle.ID).exception(e);
            }
        } else if (copiedValues.isEmpty()) {
            try {
                this.value = ValueFactory.createValue(cType, (Object[]) null);
            } catch (ValueDoesNotMatchTypeException e) {
                this.value = value;
                EASyLoggerFactory.INSTANCE.getLogger(ValueCopy.class, Bundle.ID).exception(e);
            }
        }
    }

    @Override
    public void visitContainerValue(ContainerValue value) {
        List<Value> copiedValues = new ArrayList<Value>();
        for (int i = 0, n = value.getElementSize(); i < n; i++) {
            value.getElement(i).accept(this);
            if (null != this.value) {
                copiedValues.add(value);
            }
        }
        if (!valuesOmmited) {
            this.value = value;
        } else if (!copiedValues.isEmpty() && valuesOmmited) {
            try {
                this.value = ValueFactory.createValue(value.getType(), copiedValues.toArray());
            } catch (ValueDoesNotMatchTypeException e) {
                this.value = value;
                EASyLoggerFactory.INSTANCE.getLogger(ValueCopy.class, Bundle.ID).exception(e);
            }
        } else if (copiedValues.isEmpty()) {
            try {
                this.value = ValueFactory.createValue(value.getType(), (Object[]) null);
            } catch (ValueDoesNotMatchTypeException e) {
                this.value = value;
                EASyLoggerFactory.INSTANCE.getLogger(ValueCopy.class, Bundle.ID).exception(e);
            }
        }
    }

    @Override
    public void visitIntValue(IntValue value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitRealValue(RealValue value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitBooleanValue(BooleanValue value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitReferenceValue(ReferenceValue referenceValue) {
        AbstractVariable referencedDecl = referenceValue.getValue();
        if (context.elementWasRemoved(referencedDecl)) {
            this.value = null;
            valuesOmmited = true;
        } else {
            this.value = referenceValue;
        }
    }

    @Override
    public void visitMetaTypeValue(MetaTypeValue value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitNullValue(NullValue value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitVersionValue(VersionValue value) {
        // TODO Auto-generated method stub
        
    }
    
    

}
