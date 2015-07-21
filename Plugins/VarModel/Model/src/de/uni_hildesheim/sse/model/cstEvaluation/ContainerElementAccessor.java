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

import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IAssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cstEvaluation.EvaluationVisitor.Message;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.pool.IPoolManager;
import de.uni_hildesheim.sse.utils.pool.Pool;

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
    public boolean setValue(Value value) {
        boolean successful = false;
        EvaluationContext context = getContext();
        if (context.allowAssignValues() && null != elementVariable) {
            if (null == value) {
                context.addErrorMessage("assignable value is not defined");
            } else {
                if (!Value.equalsPartially(elementVariable.getValue(), value)) { // don't reassign / send message
                    IAssignmentState targetState = context.getTargetState(elementVariable);
                    if (null != targetState) {
                        try {
                            elementVariable.setValue(value, targetState);
                            successful = true;
                            notifyVariableChange();
                        } catch (ConfigurationException e) {
                            context.addErrorMessage(e);
                        }
                    } else {
                        context.addMessage(new Message("Assignment state conflict", Status.ERROR, elementVariable));
                    }
                } else {
                    successful = true;
                }
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
