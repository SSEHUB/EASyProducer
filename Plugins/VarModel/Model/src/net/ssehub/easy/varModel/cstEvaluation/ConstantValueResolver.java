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
package net.ssehub.easy.varModel.cstEvaluation;

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
 * Implements a constant value resolution visitor. During resolution, individual values may be cloned, in particular
 * if resolution may change individual parts, e.g., from an expression to a constant.
 * 
 * @author Holger Eichelberger
 */
class ConstantValueResolver implements IValueVisitor {

    private EvaluationVisitor evaluator;
    // set this attribute only at the end of an evaluation when no further recursion can happen
    private Value value;
    
    /**
     * Creates a resolver instance.
     * 
     * @param evaluator the evaluator used to evaluate nested expression
     */
    ConstantValueResolver(EvaluationVisitor evaluator) {
        this.evaluator = evaluator;
    }

    /**
     * Returns the resolved value and clears the internal state.
     * 
     * @return the resolved value, may be <b>null</b> if resolution fails
     */
    Value getValue() {
        Value result = value;
        value = null;
        return result;
    }
    
    @Override
    public void visitConstraintValue(ConstraintValue value) {
        this.value = value;
    }

    @Override
    public void visitEnumValue(EnumValue value) {
        this.value = value;
    }

    @Override
    public void visitStringValue(StringValue value) {
        this.value = value;
    }

    @Override
    public void visitCompoundValue(CompoundValue value) {
        boolean ok = true;
        CompoundValue result = value.clone(); // clone as potential modification
        for (String slot : value.getSlotNames()) {
            Value nested = value.getNestedValue(slot); // stay with value but change result
            if (null != nested) { // ok if set so - don't change
                nested.accept(this);
                Value val = getValue();
                if (null == val) {
                    ok = false;
                } else {
                    try {
                        result.configureValue(slot, val);
                    } catch (ValueDoesNotMatchTypeException e) {
                        ok = false;
                    }
                }
            }
        }
        if (ok) {
            this.value = result;
        } else {
            this.value = null;
        }
    }

    @Override
    public void visitContainerValue(ContainerValue value) {
        boolean ok = true;
        ContainerValue result = null;
        try {
            // clone may lead to duplicate errors in sets
            result = (ContainerValue) ValueFactory.createValue(value.getType()); // clone as potential modification
        } catch (ValueDoesNotMatchTypeException e) {
            ok = false;
        }
        for (int i = 0; ok && i < value.getElementSize(); i++) {
            Value nested = value.getElement(i); // stay with value but change result
            if (null != nested) {
                nested.accept(this);
                Value val = getValue();
                if (null == val) {
                    ok = false;
                } else {
                    try {
                        result.addElement(val);
                        //result.setValue(i, val);
                    } catch (ValueDoesNotMatchTypeException e) {
                        ok = false;
                    }
                }
            }
        }
        if (ok) {
            this.value = result;
        } else {
            this.value = null;
        }
    }

    @Override
    public void visitIntValue(IntValue value) {
        this.value = value;
    }

    @Override
    public void visitRealValue(RealValue value) {
        this.value = value;
    }

    @Override
    public void visitBooleanValue(BooleanValue value) {
        this.value = value;
    }

    @Override
    public void visitReferenceValue(ReferenceValue referenceValue) {
        Value result = referenceValue;
        if (null != referenceValue.getValueEx()) {
            referenceValue.getValueEx().accept(evaluator); // -> leads to result
            EvaluationAccessor acc = evaluator.getResultAccessor(false);
            if (null != acc) {
                Value tmp = acc.getReferenceValue();
                if (null != tmp) {
                    result = tmp.clone();
                } else {
                    result = null;
                }
                evaluator.clearResult();
            }
        }
        this.value = result;
    }

    @Override
    public void visitMetaTypeValue(MetaTypeValue value) {
        this.value = value;
    }

    @Override
    public void visitNullValue(NullValue value) {
        this.value = value;
    }

    @Override
    public void visitVersionValue(VersionValue value) {
        this.value = value;
    }

}
