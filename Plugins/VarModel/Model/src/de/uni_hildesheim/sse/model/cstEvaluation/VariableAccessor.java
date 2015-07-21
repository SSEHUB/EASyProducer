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

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IAssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cstEvaluation.EvaluationVisitor.Message;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.utils.messages.Status;
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
     * Binds the accessor to the given (non-local) variable and context.
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
     * Binds the accessor to the given (local or non-local) variable and context.
     * 
     * @param variable the underlying variable 
     * @param context the evaluation context
     * @param isLocal whether the variable is local and does not need a 
     *     {@link EvaluationContext#getTargetState(IDecisionVariable) target state check}
     * @return <b>this</b> (builder pattern)
     */
    public VariableAccessor bind(IDecisionVariable variable, EvaluationContext context, boolean isLocal) {
        super.bind(variable, context);
        return this;
    }
    
    @Override
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

    @Override
    public boolean setValue(Value value) {
        boolean successful = false;
        EvaluationContext context = getContext();
        if (context.allowAssignValues()) {
            if (null == value) {
                context.addErrorMessage("assignable value is not defined");
            } else {
                IDecisionVariable variable = getVariable();
                if (null == variable) {
                    context.addErrorMessage("variable does not exist (attribute access failure)?");
                } else {
                    if (!Value.equalsPartially(variable.getValue(), value)) { // don't reassign / send message
                        IAssignmentState targetState = isLocal() ? AssignmentState.ASSIGNED 
                            : context.getTargetState(variable);
                        if (null != targetState) {
                            try {
                                variable.setValue(value, targetState);
                                successful = true;
                                notifyVariableChange();
                            } catch (ConfigurationException e) {
                                context.addErrorMessage(e);
                            }
                        } else {
                            context.addMessage(new Message("Assignment state conflict", Status.ERROR, variable));
                        }
                    } else {
                        successful = true;
                    }
                }
            }
        }
        return successful;
    }
    
    @Override
    public boolean isAssignable() {
        return true;
    }
    
    /**
     * Returns a nested value based on the given accessor.
     * 
     * @param accessor the accessor to determine the nested value
     * @return the nested value
     */
    public EvaluationAccessor getValue(EvaluationAccessor accessor) {
        EvaluationAccessor result = null;
        IDecisionVariable variable = getVariable();
        if (Container.TYPE.isAssignableFrom(variable.getDeclaration().getType())) {
            Value uncastedValue = variable.getValue();
            if (null != uncastedValue) {
                if (uncastedValue instanceof ContainerValue) {
                    ContainerValue value = (ContainerValue) uncastedValue;
                    Integer index = getIndex(value, accessor);
                    if (null != index) {
                        result = IndexAccessor.POOL.getInstance().bind(variable, getContext(), index);
                    }                    
                } else {
                    getContext().addErrorMessage("index based access an null value", variable);
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
                    } catch (ValueDoesNotMatchTypeException e) {
                        context.addErrorMessage(e);
                    }
                }
            }
        }
    }

    @Override
    public void release() {
        POOL.releaseInstance(this);
    }

}
