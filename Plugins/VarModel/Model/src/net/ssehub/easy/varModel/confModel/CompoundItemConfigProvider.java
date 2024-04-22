/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.confModel;

import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * {@link VariableConfigProvider} for nested Elements of a {@link ContainerVariable}.
 * 
 * @author El-Sharkawy
 *
 */
class CompoundItemConfigProvider extends NestedVarConfigProvider {
    private String slotName;
    private IAssignmentState state;
    
    /**
     * Sole constructor for creating a {@link VariableConfigProvider} for nested elements of a compound.
     * @param parent A {@link CompoundVariable} which will hold the
     *     nested {@link IDecisionVariable} where this provider belongs to.
     * @param slotName The {@code parent}'s slotName of the nested {@link IDecisionVariable}
     *     where this provider belongs to.
     */
    protected CompoundItemConfigProvider(CompoundVariable parent, String slotName) {
        super(parent);
        this.slotName = slotName;
        state = AssignmentState.UNDEFINED;
    }

    @Override
    protected CompoundVariable getParent() {
        return (CompoundVariable) super.getParent();
    }

    @Override
    protected Value getValue() {
        Value parentValue = getParent().getValue();
        return (parentValue instanceof NullValue) ? parentValue
            : ((CompoundValue) parentValue).getNestedValue(slotName);
    }

    @Override
    protected void setValue(Value value, IAssignmentState state) throws ConfigurationException {
        Value parentValue = getParent().getValue();
        if (null == parentValue || parentValue instanceof NullValue) {
            // Set empty value instead of NULL value, which can be configured
            getParent().setValue(null, state);
            parentValue = getParent().getValue();
        }
        CompoundValue cmpValue = (CompoundValue) parentValue;
        try {
            cmpValue.configureValue(slotName, value);
            setState(state);
            getParent().notifyCreated();
        } catch (ValueDoesNotMatchTypeException e) {
            throw new ConfigurationException(getConfiguration(), e.getMessage(),
                ConfigurationException.TYPE_MISMATCH);
        }            
    }

    @Override
    protected IAssignmentState getState() {
        IAssignmentState state = this.state;
        // Handle special situations
        if (!getParent().ownStateAllowed()) { 
            if (getParent().getState() == AssignmentState.FROZEN && null != getValue()) {
                // this is not correct in the general case as individual vars may still be assignable
                state = AssignmentState.FROZEN; 
            } else if (!getParent().ownStateAllowed() && null != getValue()) {
                state = getParent().getState();
            }
        }
        return state;
    }
    
    @Override
    protected final void setState(IAssignmentState state) {
        this.state = state;
        getConfiguration().variableChangedState(getParent());
    }

    @Override
    protected AbstractVariable getDeclaration() {
        Compound cmpType = (Compound) getParent().getDeclaration().getType();
        AbstractVariable decl = null;
        for (int i = 0; i < cmpType.getElementCount() && null == decl; i++) {
            if (cmpType.getElement(i).getName().equals(slotName)) {
                decl = cmpType.getElement(i);
            }
        }
        
        return decl;
    }

    @Override
    protected void setHistoryValue(Value value, IAssignmentState state) throws ConfigurationException {
        this.state = state;
    }

    @Override
    protected void freeze(IFreezeSelector selector) {
        IDecisionVariable thisVariable = getParent().getNestedVariable(slotName);
        if (selector.shallFreeze(thisVariable)) {
            freeze();
        }
    }
}
