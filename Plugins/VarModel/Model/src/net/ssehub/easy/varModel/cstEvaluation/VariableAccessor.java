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
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * Implements an accessor for decision variables. This class supports {@link IEvaluationInterceptor}.
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
    public boolean setValue(Value value, boolean asAssignment) {
        boolean successful = false;
        EvaluationContext context = getContext();
        if (context.allowAssignValues()) {
            successful = setValue(context, value, asAssignment);
        }
        return successful;
    }

    /**
     * Changes the value within the given evaluation context.
     * 
     * @param context the evaluation context
     * @param value the new value
     * @param asAssignment called within an assignment or equality expression
     * @return <code>true</code> for success, <code>false</code> else
     */
    private boolean setValue(EvaluationContext context, Value value, boolean asAssignment) {
        boolean successful = false;
        if (value != null) { // value may still be undefined at a certain point, do not issue an error
            IDecisionVariable variable = getVariable();
            if (null == variable) {
                context.addErrorMessage("variable does not exist (attribute access failure)?", Message.CODE_RESOLUTION);
            } else {
                Value oldValue = variable.getValue();
                IAssignmentState oldState = variable.getState();
                if (!Value.equalsPartially(oldValue, value)
                        && oldState != AssignmentState.USER_ASSIGNED) { // don't reassign / send message
                    IAssignmentState targetState = isLocal() ? AssignmentState.ASSIGNED 
                        : context.getTargetState(variable);
                    if (null != targetState) {
                        try {
                            dereferenceIfNeeded(variable, value).setValue(value, targetState, asAssignment);
                            successful = true;
                            notifyVariableChange(oldValue, oldState, ChangeKind.FULL);
                        } catch (ConfigurationException e) {
                            context.addErrorMessage(e);
                        }
                    } else {
                        context.addMessage(new Message("Assignment state conflict", Status.ERROR, variable, 
                            Message.CODE_ASSIGNMENT_STATE));
                    }
                } else {
                    successful = true;
                    variable.notifyCreated();
                }
                // if the variable was changed, was is false. If not, pretend that it was changed and cause a change 
                // notification 
                boolean was = variable.notifyWasAssigned(value);
                if (!was && variable.enableWasAssignedForIsDefined()) { 
                    notifyVariableChange(oldValue, oldState, ChangeKind.VARIABLE_ONLY);
                }
            }
        }
        return successful;
    }
    
    @Override
    public boolean isAssignable() {
        return true;
    }
    
    @Override
    public EvaluationAccessor getValue(EvaluationAccessor accessor) {
        EvaluationAccessor result = null;
        IDecisionVariable variable = getVariable();
        if (Container.TYPE.isAssignableFrom(DerivedDatatype.resolveToBasis(variable.getDeclaration().getType()))) {
            Value uncastedValue = variable.getValue();
            if (null != uncastedValue) {
                if (uncastedValue instanceof ContainerValue) {
                    ContainerValue value = (ContainerValue) uncastedValue;
                    Integer index = getIndex(value, accessor);
                    if (null != index) {
                        result = IndexAccessor.POOL.getInstance().bind(variable, getContext(), index);
                    }                    
                } else {
                    getContext().addErrorMessage("index based access an null value", variable, Message.CODE_RESOLUTION);
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
            int index = OclKeyWords.toJavaIndex(((IntValue) iValue).getValue());
            if (index < 0) {
                context.addErrorMessage("index < 0", Message.CODE_INDEX);
            } else if (index >= value.getElementSize()) {
                context.addErrorMessage("index >= " + value.getElementSize(), Message.CODE_INDEX);
            } else {
                result = index;
            }
        } else if (null != iValue) {
            context.addErrorMessage("index access must happen trough an integer", Message.CODE_RESOLUTION);
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
