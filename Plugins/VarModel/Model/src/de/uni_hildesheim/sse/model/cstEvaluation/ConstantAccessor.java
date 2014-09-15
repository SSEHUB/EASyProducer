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
package de.uni_hildesheim.sse.model.cstEvaluation;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.utils.pool.IPoolManager;
import de.uni_hildesheim.sse.utils.pool.Pool;

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
    
    /**
     * Creates an instance. Private due to pooling.
     */
    private ConstantAccessor() {
    }
    
    /**
     * Binds the accessor to the given value and context.
     * 
     * @param value the actual value
     * @param context the evaluation context
     * @return <b>this</b> (builder pattern)
     */
    public ConstantAccessor bind(Value value, EvaluationContext context) {
        super.bind(context);
        this.value = value;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public Value getValue() {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    public boolean setValue(Value value) {
        getContext().addErrorMessage("cannot assign a value to a constant - variable needed");
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public void release() {
        POOL.releaseInstance(this);
    }

    @Override
    public IDecisionVariable getVariable() {
        return null;
    }

    /**
     * Returns a nested value based on the given accessor.
     * 
     * @param accessor the accessor to determine the nested value
     * @return the nested value
     */
    public Value getValue(EvaluationAccessor accessor) {
        Value result = null;
        if (value instanceof ContainerValue) {
            Value aValue = accessor.getValue();
            if (aValue instanceof IntValue) {
                ContainerValue cVal = (ContainerValue) value;
                int index = ((IntValue) aValue).getValue();
                if (0 <= index && index < cVal.getElementSize()) {
                    result = cVal.getElement(index);
                } else {
                    getContext().addErrorMessage("invalid index value");
                }
            } else {
                getContext().addErrorMessage("index must be an integer value");
            }
        } else {
            getContext().addErrorMessage("left side of accessor must be a compound value");
        }
        return result;
    }

}
