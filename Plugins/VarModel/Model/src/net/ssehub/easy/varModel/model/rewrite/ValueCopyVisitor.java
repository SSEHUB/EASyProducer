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
package net.ssehub.easy.varModel.model.rewrite;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
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
 * Parts of {@link CSTCopyVisitor} and {@link ProjectCopyVisitor}, to create a deep copy of {@link Value}s.
 * @author El-Sharkawy
 *
 */
class ValueCopyVisitor implements IValueVisitor {

    private Value result;
    private ProjectCopyVisitor copyier;
    private boolean complete;
    
    /**
     * Single constracutor for this class.
     * @param copyier The currently used {@link ProjectCopyVisitor} containing the mapping of translated elements.
     */
    ValueCopyVisitor(ProjectCopyVisitor copyier) {
        this.copyier = copyier;
        complete = true;
    }
    
    /**
     * Returns the deep copied value after visitation.
     * @return The copied value.
     */
    Value getResult() {
        return result;
    }
    
    /**
     * Specifies whether the {@link Value} could be translated completely.
     * @return <tt>true</tt> value was translated completely, <tt>false</tt>
     * if some parts of the value must still be translated.
     */
    boolean translatedCompletely() {
        return complete;
    }

    @Override
    public void visitConstraintValue(ConstraintValue value) {
        if (null != value.getValue()) {
            CSTCopyVisitor cstCopyier = new CSTCopyVisitor(copyier.getDeclarationMapping(), copyier);
            value.getValue().accept(cstCopyier);
            if (cstCopyier.translatedCompletely()) {
                try {
                    result = ValueFactory.createValue(value.getContainedType(), cstCopyier.getResult());
                } catch (ValueDoesNotMatchTypeException e) {
                    // May happen if not all elements are translated so far
                    result = value;
                    complete = false;
                }
            } else {
                result = value;
                complete = false;
            }
        }
        
    }

    @Override
    public void visitEnumValue(EnumValue value) {
        Enum copiedType = (Enum) copyier.getTranslatedType(value.getType());
        if (null != copiedType) {
            EnumLiteral lit = copiedType.get(value.getValue().getName());
            try {
                result = ValueFactory.createValue(copiedType, lit);
            } catch (ValueDoesNotMatchTypeException e) {
                // May happen if not all elements are translated so far
                result = value;
                complete = false;
            }
        } else {
            result = value;
            complete = false;
        }
        
    }

    @Override
    public void visitStringValue(StringValue value) {
        result = value;
    }

    @Override
    public void visitCompoundValue(CompoundValue value) {
        Compound cType = (Compound) copyier.getTranslatedType(value.getType());
        
        if (null != cType) {
            ArrayList<Object> copiedValues = new ArrayList<Object>();
            for (int i = 0, n = cType.getInheritedElementCount(); i < n; i++) {
                String slotName = cType.getInheritedElement(i).getName();
                Value nestedValue = value.getNestedValue(slotName);
                if (null != nestedValue) {
                    nestedValue.accept(this);
                    if (null != this.result) {
                        copiedValues.add(slotName);
                        copiedValues.add(this.result);
                    }
                }
            }
            try {
                result = ValueFactory.createValue(cType, copiedValues.toArray());
            } catch (ValueDoesNotMatchTypeException e) {
                // May happen if not all elements are translated so far
                result = value;
                complete = false;
            }
        } else {
            result = value;
            complete = false;
        }
    }

    @Override
    public void visitContainerValue(ContainerValue value) {
        Container conType = (Container) copyier.getTranslatedType(value.getType());
        
        if (null != conType) {
            List<Value> copiedValues = new ArrayList<Value>();
            for (int i = 0, n = value.getElementSize(); i < n; i++) {
                value.getElement(i).accept(this);
                if (null != this.result) {
                    copiedValues.add(this.result);
                }
            }
            try {
                result = ValueFactory.createValue(conType, copiedValues.toArray());
            } catch (ValueDoesNotMatchTypeException e) {
                // May happen if not all elements are translated so far
                result = value;
                complete = false;
            }
        } else {
            result = value;
            complete = false;
        }
    }

    @Override
    public void visitIntValue(IntValue value) {
        result = value;
    }

    @Override
    public void visitRealValue(RealValue value) {
        result = value;
    }

    @Override
    public void visitBooleanValue(BooleanValue value) {
        result = value;
    }

    @Override
    public void visitReferenceValue(ReferenceValue referenceValue) {
        AbstractVariable referencedDecl = referenceValue.getValue();
        
        AbstractVariable copiedDecl = (AbstractVariable) copyier.getCopiedElement(referencedDecl);
        IDatatype refType = copyier.getTranslatedType(referenceValue.getType());
        
        if (null != copiedDecl && null != refType) {
            try {
                result = ValueFactory.createValue(refType, copiedDecl);
            } catch (ValueDoesNotMatchTypeException e) {
                // Should not happen
                Bundle.getLogger(ValueCopyVisitor.class).exception(e);
            }
        } else {
            result = referenceValue;
            complete = false;
        }
    }

    @Override
    public void visitMetaTypeValue(MetaTypeValue value) {
        // TODO: Unclear what to do
        result = value;
    }

    @Override
    public void visitNullValue(NullValue value) {
        result = NullValue.INSTANCE;
    }

    @Override
    public void visitVersionValue(VersionValue value) {
        result = value;
    }
}
