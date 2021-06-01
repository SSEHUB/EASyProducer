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
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor.Message;
import net.ssehub.easy.varModel.cstEvaluation.IValueChangeListener.ChangeKind;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Implements an accessor for decision variables.
 * 
 * @author Holger Eichelberger
 */
class ContainerElementAccessor extends AbstractDecisionVariableEvaluationAccessor {

    public static final Pool<ContainerElementAccessor> POOL = new Pool<ContainerElementAccessor>(
        new IPoolManager<ContainerElementAccessor>() {

            public ContainerElementAccessor create() {
                return new ContainerElementAccessor();
            }

            public void clear(ContainerElementAccessor instance) {
                instance.clear();
            }
        });
    
    private IDecisionVariable elementVariable;
    
    /**
     * Creates an instance. Private due to pooling.
     */
    private ContainerElementAccessor() {
    }
    
    /**
     * Binds the accessor to the given variable and context.
     * 
     * @param variable the underlying variable
     * @param index the index of the element to access
     * @param context the evaluation context
     * @return <b>this</b> (builder pattern)
     */
    public ContainerElementAccessor bind(IDecisionVariable variable, int index, EvaluationContext context) {
        super.bind(variable, context);
        elementVariable = variable.getNestedElement(index);
        return this;
    }
    
    @Override
    public void clear() {
        super.clear();
        elementVariable = null;
    }

    @Override
    public Value getValue() {
        Value result;
        if (null != elementVariable) {
            result = elementVariable.getValue();
        } else {
            result = null;
        }
        return result;
    }

    @Override
    public boolean setValue(Value value, boolean asAssignment) {
        boolean successful = false;
        EvaluationContext context = getContext();
        if (context.allowAssignValues() && null != elementVariable) {
            if (null == value) {
                context.addErrorMessage("assignable value is not defined", Message.CODE_RESOLUTION);
            } else {
                Value oldValue = elementVariable.getValue();
                IAssignmentState oldState = elementVariable.getState();
                if (!Value.equalsPartially(oldValue, value)
                        && oldState != AssignmentState.USER_ASSIGNED) { //don't reassign/send message
                    IAssignmentState targetState = context.getTargetState(elementVariable);
                    if (null != targetState) {
                        try {
                            elementVariable.setValue(value, targetState, asAssignment);
                            successful = true;
                            notifyVariableChange(oldValue, oldState, ChangeKind.FULL);
                        } catch (ConfigurationException e) {
                            context.addErrorMessage(e);
                        }
                    } else {
                        context.addMessage(new Message("Assignment state conflict", Status.ERROR, elementVariable, 
                            Message.CODE_ASSIGNMENT_STATE));
                    }
                } else {
                    successful = true;
                }
                elementVariable.notifyWasAssigned(value);
            }
        }
        return successful;
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
