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
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.utils.pool.IPoolManager;
import de.uni_hildesheim.sse.utils.pool.Pool;

/**
 * Implements an accessor for decision variables.
 * 
 * @author Holger Eichelberger
 */
class VariableAccessor extends AbstractDecisionVariableEvaluationAccessor {

    public static final Pool<VariableAccessor> POOL = new Pool<VariableAccessor>(new IPoolManager<VariableAccessor>() {

        public VariableAccessor create() {
            return new VariableAccessor();
        }

        public void clear(VariableAccessor instance) {
            instance.clear();
        }
    });
    
    /**
     * Creates an instance. Private due to pooling.
     */
    private VariableAccessor() {
    }
    
    /**
     * Binds the accessor to the given variable and context.
     * 
     * @param variable the underlying variable
     * @param context the evaluation context
     * @return <b>this</b> (builder pattern)
     */
    public VariableAccessor bind(AbstractVariable variable, EvaluationContext context) {
        super.bind(context.getDecision(variable), context);
        return this;
    }
    
    /**
     * Binds the accessor to the given variable and context.
     * 
     * @param variable the underlying variable 
     * @param context the evaluation context
     * @return <b>this</b> (builder pattern)
     */
    public VariableAccessor bind(IDecisionVariable variable, EvaluationContext context) {
        super.bind(variable, context);
        return this;
    }
    
    /**
     * {@inheritDoc}
     */
    public Value getValue() {
        Value result;
        IDecisionVariable var = getVariable();
        if (null != var) {
            result = var.getValue();
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
        if (context.allowAssignValues()) {
            if (null == value) {
                context.addErrorMessage("assignable value is not defined");
            } else {
                IDecisionVariable variable = getVariable();
                IAssignmentState targetState = context.getTargetState(variable.getState());
                if (null != targetState) {
                    try {
                        variable.setValue(value, targetState);
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
     * Returns a nested value based on the given accessor.
     * 
     * @param accessor the accessor to determine the nested value
     * @return the nested value
     */
    public Value getValue(EvaluationAccessor accessor) {
        Value result = null;
        IDecisionVariable variable = getVariable();
        if (Container.TYPE.isAssignableFrom(variable.getDeclaration().getType())) {
            ContainerValue value = (ContainerValue) variable.getValue();
            if (null != value) {
                Integer index = getIndex(value, accessor);
                if (null != index) {
                    result = ((ContainerValue) variable.getValue()).getElement(index);
                }
            }
        }
        return result;
    }

    /**
     * Returns the (valid) index from <code>accessor</code> for <code>value</code>.
     * 
     * @param value the container to be accessed
     * @param accessor the accessor expression
     * @return the index value (invalid if <b>null</b>)
     */
    private Integer getIndex(ContainerValue value, EvaluationAccessor accessor) {
        Integer result = null;
        EvaluationContext context = accessor.getContext();
        Value iValue = accessor.getValue();
        if (iValue instanceof IntValue) {
            int index = ((IntValue) iValue).getValue();
            if (index < 0) {
                context.addErrorMessage("index < 0");
            } else if (index >= value.getElementSize()) {
                context.addErrorMessage("index >= " + value.getElementSize());
            } else {
                result = index;
            }
        } else {
            context.addErrorMessage("index must happen trough an integer");
        }
        return result;
    }

    /**
     * Changes a nested value based on the given accessor.
     * 
     * @param accessor the accessor to determine the nested value
     * @param value the new nested value
     */
    public void setValue(EvaluationAccessor accessor, Value value) {
        IDecisionVariable variable = getVariable();
        if (Container.TYPE.isAssignableFrom(variable.getDeclaration().getType())) {
            ContainerValue container = (ContainerValue) variable.getValue();
            if (null != container) {
                Integer index = getIndex(container, accessor);
                if (null != index) {
                    EvaluationContext context = accessor.getContext();
                    try {
                        ((ContainerValue) variable.getValue()).setValue(index, value);
                    } catch (IllegalArgumentException e) {
                        context.addErrorMessage(e);
                    } catch (IndexOutOfBoundsException e) {
                        context.addErrorMessage(e);
                    }
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void release() {
        POOL.releaseInstance(this);
    }

}
