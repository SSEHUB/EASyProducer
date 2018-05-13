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
package net.ssehub.easy.varModel.cstEvaluation;

import net.ssehub.easy.basics.pool.IPoolManager;
import net.ssehub.easy.basics.pool.Pool;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor.Message;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Implements an accessor for constant values. [public for testing]
 * 
 * @author Holger Eichelberger
 */
public class ConstantAccessor extends EvaluationAccessor {

    public static final Pool<ConstantAccessor> POOL = new Pool<ConstantAccessor>(new IPoolManager<ConstantAccessor>() {

        public ConstantAccessor create() {
            return new ConstantAccessor();
        }

        public void clear(ConstantAccessor instance) {
            instance.clear();
        }
    });
    
    private Value value;
    private boolean isConstant;
    
    /**
     * Creates an instance. Private due to pooling.
     */
    private ConstantAccessor() {
    }
    
    /**
     * Binds the accessor to the given value and context.
     * 
     * @param value the actual value
     * @param isConstant whether <code>value</code> is still (potentially) linked by reference
     *   to a decision variable ({@code false}), else whether it is actually a truely constant
     * @param context the evaluation context
     * @return <b>this</b> (builder pattern)
     */
    public ConstantAccessor bind(Value value, boolean isConstant, EvaluationContext context) {
        super.bind(context);
        this.value = value;
        this.isConstant = isConstant;
        return this;
    }
    
    @Override
    public void clear() {
        super.clear();
        value = null;
        isConstant = false;
    }

    @Override
    public Value getValue() {
        return value;
    }

    @Override
    public boolean setValue(Value value, boolean asAssignment) {
        getContext().addErrorMessage("cannot assign a value to a constant - variable needed", Message.CODE_RESOLUTION);
        return false;
    }
    
    @Override
    public boolean isAssignable() {
        return false;
    }

    @Override
    public void release() {
        POOL.releaseInstance(this);
    }

    @Override
    public IDecisionVariable getVariable() {
        return null;
    }

    @Override
    public EvaluationAccessor getValue(EvaluationAccessor accessor) {
        EvaluationAccessor result = null;
        if (value instanceof ContainerValue) {
            Value aValue = accessor.getValue();
            if (aValue instanceof IntValue) {
                ContainerValue cVal = (ContainerValue) value;
                int index = OclKeyWords.toJavaIndex(((IntValue) aValue).getValue());
                if (0 <= index && index < cVal.getElementSize()) {
                    result = ConstantAccessor.POOL.getInstance().bind(cVal.getElement(index), false, getContext());
                } else {
                    getContext().addErrorMessage("invalid index value", Message.CODE_RESOLUTION);
                }
            } else {
                getContext().addErrorMessage("index must be an integer value", Message.CODE_RESOLUTION);
            }
        } else {
            getContext().addErrorMessage("left side of accessor must be a compound value", Message.CODE_RESOLUTION);
        }
        return result;
    }

    @Override
    public Value getReferenceValue() {
        Value result;
        if (value instanceof ReferenceValue) {
            result = value;
        } else {
            result = null; // no reference possible
        }
        return result; 
    }
    
    @Override
    public String toString() {
        return null == value ? "null" : value.toString();
    }

    @Override
    public boolean isConstant() {
        return isConstant;
    }
    
}
