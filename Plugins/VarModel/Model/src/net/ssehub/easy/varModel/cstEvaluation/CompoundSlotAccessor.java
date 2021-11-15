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

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.pool.IPoolManager;
import net.ssehub.easy.basics.pool.Pool;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.CompoundVariable;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor.Message;
import net.ssehub.easy.varModel.cstEvaluation.IValueChangeListener.ChangeKind;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Implements an accessor for decision variables. This class supports {@link IEvaluationInterceptor}.
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
        slotVariable = ((CompoundVariable) variable).getNestedVariable(slotName);
        return this;
    }

    /**
     * Binds the accessor to the given variable and context.
     * 
     * @param variable the underlying variable
     * @param slotName the name of the slot within <code>value</code>
     * @param context the evaluation context
     * @return <b>this</b> (builder pattern)
     */
    public CompoundSlotAccessor bind(LocalDecisionVariable variable, String slotName, 
        EvaluationContext context) {
        super.bind(variable, context);
        slotVariable = variable.getNestedVariable(slotName);
        return this;
    }
    
    @Override
    public void clear() {
        super.clear();
        slotVariable = null;
    }

    @Override
    public Value getValue() {
        Value result;
        EvaluationContext context = getContext();
        if (null != context.getEvaluationInterceptor()) {
            result = context.getEvaluationInterceptor().getValue(slotVariable);
        } else {
            if (null != slotVariable) {
                result = slotVariable.getValue();
            } else {
                result = null;
            }
        }
        return result;
    }
    
    @Override
    public EvaluationAccessor getValue(EvaluationAccessor accessor) {
        EvaluationAccessor result = null;
        if (null != slotVariable) {
            VariableAccessor tmp = VariableAccessor.POOL.getInstance().bind(slotVariable, getContext());
            result = tmp.getValue(accessor);
            VariableAccessor.POOL.releaseInstance(tmp);
        }
        return result;
    }

    @Override
    public boolean setValue(Value value, boolean asAssignment) {
        boolean successful = false;
        EvaluationContext context = getContext();
        if (null != context.getEvaluationInterceptor()) {
            successful = context.getEvaluationInterceptor().setValue(slotVariable, value, asAssignment, this);
        } else {
            if (context.allowAssignValues() && null != slotVariable) {
                if (null != value) {
                    boolean assign = true;
                    IAssignmentState slotState = slotVariable.getState();
                    if (AssignmentState.DEFAULT == context.getAssignmentState()) {
                        if (!slotVariable.getParent().wasCreated()) {
                            // no parent value, defer until initialized
                            successful = false; // defer
                            assign = false;
                        } else if (slotState != AssignmentState.UNDEFINED && slotState != AssignmentState.FROZEN) {
                            // there is a value and it is not frozen, ignore and pretend that successful
                            assign = false;
                        }
                    }
                    if (assign) {
                        successful = assignValue(value, asAssignment);
                    }
                }
            }
        }
        return successful;
    }
    
    /**
     * Assigns the value.
     * 
     * @param value the value
     * @param asAssignment does this happen through an IVML assignment operation
     * @return whether the assignment was successful or not
     */
    private final boolean assignValue(Value value, boolean asAssignment) {
        boolean successful = false;
        Value oldValue = slotVariable.getValue();
        IAssignmentState oldState = slotVariable.getState();
        if (!Value.equalsPartially(oldValue, value) 
            && oldState != AssignmentState.USER_ASSIGNED) { // don't reassign / send message
            EvaluationContext context = getContext();
            IAssignmentState targetState = context.getTargetState(slotVariable);
            if (null != targetState) {
                try {
                    dereferenceIfNeeded(slotVariable, value).setValue(value, targetState, asAssignment);
                    successful = true;
                    notifyVariableChange(oldValue, oldState, ChangeKind.FULL);
                } catch (ConfigurationException e) {
                    context.addErrorMessage(e);
                }
            } else {
                context.addMessage(new Message("Assignment state conflict", Status.ERROR, slotVariable, 
                    Message.CODE_ASSIGNMENT_STATE));
            }
        } else {
            successful = true;
        }
        return successful;
    }
    
    @Override
    public IDecisionVariable getVariable() {
        return slotVariable;
    }
    
    @Override
    public void release() {
        POOL.releaseInstance(this);
    }
    
    @Override
    public boolean isAssignable() {
        return true;
    }

}
