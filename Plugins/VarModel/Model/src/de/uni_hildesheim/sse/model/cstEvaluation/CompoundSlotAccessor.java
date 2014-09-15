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

import de.uni_hildesheim.sse.model.confModel.CompoundVariable;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IAssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.utils.pool.IPoolManager;
import de.uni_hildesheim.sse.utils.pool.Pool;

/**
 * Implements an accessor for decision variables.
 * 
 * @author Holger Eichelberger
 */
class CompoundSlotAccessor extends AbstractDecisionVariableEvaluationAccessor {

    public static final Pool<CompoundSlotAccessor> POOL = new Pool<CompoundSlotAccessor>(
        new IPoolManager<CompoundSlotAccessor>() {

            public CompoundSlotAccessor create() {
                return new CompoundSlotAccessor();
            }

            public void clear(CompoundSlotAccessor instance) {
                instance.clear();
            }
        });
    
    private IDecisionVariable slotVariable;
    
    /**
     * Creates an instance. Private due to pooling.
     */
    private CompoundSlotAccessor() {
    }
    
    /**
     * Binds the accessor to the given variable and context.
     * 
     * @param variable the underlying variable
     * @param slotName the name of the slot within <code>value</code>
     * @param context the evaluation context
     * @return <b>this</b> (builder pattern)
     */
    public CompoundSlotAccessor bind(IDecisionVariable variable, String slotName, 
        EvaluationContext context) {
        super.bind(variable, context);
        assert variable.getDeclaration().getType() instanceof Compound 
            && null != ((Compound) variable.getDeclaration().getType()).getElement(slotName);
        slotVariable = ((CompoundVariable) variable).getNestedVariable(slotName);
        return this;
    }
    
    /**
     * {@inheritDoc}
     */
    public void clear() {
        super.clear();
        slotVariable = null;
    }

    /**
     * {@inheritDoc}
     */
    public Value getValue() {
        Value result;
        if (null != slotVariable) {
            result = slotVariable.getValue();
        } else {
            result = null;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public boolean setValue(Value value) {
        boolean successful = false;
        EvaluationContext context = getContext();
        if (context.allowAssignValues() && null != slotVariable) {
            if (null == value) {
                context.addErrorMessage("assignable value is not defined");
            } else {
                IAssignmentState targetState = context.getTargetState(slotVariable.getState());
                if (null != targetState) {
                    try {
                        slotVariable.setValue(value, targetState);
                        successful = true;
                        notifyVariableChange();
                    } catch (ConfigurationException e) {
                        context.addErrorMessage(e);
                    }
                } else {
                    context.addErrorMessage("cannot assign due to assignment state conflict");
                }
            }
        }
        return successful;
    }
    
    /**
     * {@inheritDoc}
     */
    public IDecisionVariable getVariable() {
        return slotVariable;
    }
    
    /**
     * {@inheritDoc}
     */
    public void release() {
        POOL.releaseInstance(this);
    }

}
