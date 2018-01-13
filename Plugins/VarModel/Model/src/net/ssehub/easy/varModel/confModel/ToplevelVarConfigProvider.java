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

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * 
 * {@link VariableConfigProvider} for not nested variables.
 * 
 * @author El-Sharkawy
 *
 */
class ToplevelVarConfigProvider extends VariableConfigProvider {
    
    private static final EASyLogger LOGGER
        = EASyLoggerFactory.INSTANCE.getLogger(ToplevelVarConfigProvider.class, Bundle.ID);
    
    private Value value;
    private IAssignmentState state;
    private IDecisionVariable relatedVariable;
    
    /**
     * Sole constructor for creating a {@link VariableConfigProvider} for a toplevel {@link IDecisionVariable}.
     * @param relatedVariable The {@link IDecisionVariable} where this {@link VariableConfigProvider} belongs to
     *     (must not be <tt>null</tt>).
     * @param value The (initial) value of the related {@link IDecisionVariable} (can be <tt>null</tt> for lazy
     *     initialization).
     * @param state The initial {@link IAssignmentState} of the related {@link IDecisionVariable}.
     *     In case of <tt>null</tt> the state will be set to {@link AssignmentState#UNDEFINED}.
     */
    protected ToplevelVarConfigProvider(IDecisionVariable relatedVariable, Value value, IAssignmentState state) {
        super();
        this.relatedVariable = relatedVariable;
        setValueImpl(value);
        if (null == state) {
            this.state = AssignmentState.UNDEFINED;
        } else {
            this.state = state;            
        }
    }

    @Override
    protected Value getValue() {
        return value;
    }

    @Override
    protected void setValue(Value value, IAssignmentState state) throws ConfigurationException {
        if (this.state != AssignmentState.FROZEN) {
            assignValue(value, state, false);
        } else if (null == this.value && this.state == AssignmentState.FROZEN && null != value
            && !value.isConfigured()) {
            // Allow lazy initialization of empty value
            setValueImpl(value);
        } else {
            throw new ConfigurationException(getConfiguration(), 
                "decision '" + getDeclaration().getName() 
                + "' is already frozen and cannot be changed", ConfigurationException.ALREADY_FROZEN);
        }
    }

    @Override
    protected IAssignmentState getState() {
        return state;
    }
    
    @Override
    protected final void setState(IAssignmentState state) {
        this.state = state;
        getConfiguration().variableChangedState(relatedVariable);
    }

    @Override
    protected final boolean isStateChangeAllowed() {
        return true;
    }

    /**
     * Returns the Declaration of the related {@link IDecisionVariable}.
     * @return {@link IDecisionVariable#getDeclaration()}.
     */
    protected final AbstractVariable getDeclaration() {
        return relatedVariable.getDeclaration();
    }
    
    /**
     * Return the {@link Configuration} where the related {@link IDecisionVariable} belongs to.
     * @return {@link IDecisionVariable#getConfiguration()}.
     */
    protected final Configuration getConfiguration() {
        return relatedVariable.getConfiguration();
    }

    @Override
    protected void setHistoryValue(Value value, IAssignmentState state) throws ConfigurationException {
        assignValue(value, state, true);
    }

    /**
     * Assigns a value. The boolean parameter facilitates a differentiation between assignment of
     * old values and new values. In case of old values, already assigned slots of a compound
     * can be set to null. This must be avoided in case of new values (incremental build up).
     * @param value the value (may be <b>null</b> for incremental buildup)
     * @param state the related assignment state
     * @param allowDeletation <tt>true</tt> if <tt>null</tt> values can overwrite already set values of an compound.
     * @throws ConfigurationException in case that the types of 
     *   {@link #getDeclaration()} and <code>value</code> do not comply
     */
    private void assignValue(Value value, IAssignmentState state, boolean allowDeletation)
        throws ConfigurationException {
        /*
         * TODO SE: Clean up code.
         */
        Value oldValue = this.value;
        if (null != value) {
            if (!getDeclaration().getType().isAssignableFrom(value.getType())) {
                throw new ConfigurationException(getConfiguration(), "type '"
                    + getDeclaration().getType().getName() 
                    + "' of variable declaration '"
                    + getDeclaration().getName()
                    + "'do not match type of value '"
                    + value.getType().getName() + "'", ConfigurationException.TYPE_MISMATCH);
            }
            /*
             * Avoid deletion of already configured nested values.
             * This is needed for the stepwise configuration of
             * (nested) CompoundValues.
             */
            if (value instanceof CompoundValue && null != oldValue && oldValue instanceof CompoundValue) {
                value = assignCompoundValue((CompoundValue) value, state, allowDeletation, (CompoundValue) oldValue);
            } else if (value instanceof ContainerValue) {
                value = assignContainerValue((ContainerValue) value, state, allowDeletation);
            }
        } else if (relatedVariable.getDeclaration().getType() instanceof Container && allowDeletation) {
            ContainerVariable container = (ContainerVariable) relatedVariable;
            container.clear();
        }
        setValueImpl(value);
        this.state = state;
        getConfiguration().variableChanged(relatedVariable, oldValue);
    }
    
    /**
     * Assigns a CompoundValue.
     * 
     * @param value the value (may be <b>null</b> for incremental buildup)
     * @param state the related assignment state
     * @param allowDeletation <tt>true</tt> if <tt>null</tt> values can overwrite already set values of an compound.
     * @param oldValue copy of value.
     * @return value
     * @throws ConfigurationException in case that the types of 
     * {@link #getDeclaration()} and <code>value</code> do not comply
     */
    private Value assignCompoundValue(CompoundValue value, IAssignmentState state, boolean allowDeletation, 
            CompoundValue oldValue)
        throws ConfigurationException {
        
        CompoundValue newValue = oldValue;
        if (allowDeletation) {
            newValue = value;
        } else {
            try {
                CompoundValue tmpValue = value;
                if (!TypeQueries.sameTypes(value.getType(), oldValue.getType())) {
                    // polymorphic value, we have to take over the old values into the new value
                    newValue = value;
                    tmpValue = oldValue;
                }
                Compound cType = (Compound) DerivedDatatype.resolveToBasis(getDeclaration().getType());
                for (int i = 0; i < cType.getInheritedElementCount(); i++) {
                    DecisionVariableDeclaration decl = cType.getInheritedElement(i);
                    String name = decl.getName();
                    IDecisionVariable var = relatedVariable.getNestedElement(name);
                    /*
                     * Avoid deletion of already configured nested values.
                     * This is needed for the stepwise configuration of
                     * (nested) CompoundValues.
                     */
                    Value oldSlotValue = newValue.getNestedValue(name);
                    Value newSlotValue = tmpValue.getNestedValue(name);
                    IAssignmentState oldState = null != var ? var.getState() : state;
                    if (!(oldSlotValue != null && newSlotValue == null) && (AssignmentState.USER_ASSIGNED != oldState
                        || state == AssignmentState.USER_ASSIGNED)) {
                        
                        newValue.configureValue(name, newSlotValue);
                    }
                }
            } catch (ValueDoesNotMatchTypeException exc) {
                LOGGER.exception(exc);
            }
        }
        Compound cmpType = (Compound) DerivedDatatype.resolveToBasis(getDeclaration().getType());
        for (int i = 0; i < cmpType.getInheritedElementCount(); i++) {
            String slotName = cmpType.getInheritedElement(i).getName();
            CompoundVariable cmpVar = (CompoundVariable) relatedVariable;
            Value nestedValue = newValue.getNestedValue(slotName);
            IDecisionVariable var = cmpVar.getNestedVariable(slotName);
            LOGGER.info("VAR: " + var + " STATE: " + var.getState());
            IAssignmentState nestedState = var.getState();
            // Use new state only iff old state is not USER_ASSIGNED
            if (nestedState != AssignmentState.USER_ASSIGNED) {
                nestedState = state;
            }
            if (allowDeletation) {
                if (nestedValue == null) {
                    var.setValue(nestedValue, AssignmentState.UNDEFINED);
                } else {
                    var.setValue(nestedValue, nestedState);
                }
            } else if (null != nestedValue && null != var) {
                var.setValue(nestedValue, nestedState);
            }
        }
        value = newValue;
        return value;
    }

    /**
     * Assigns a ContainerValue.
     * 
     * @param conValue the value (may be <b>null</b> for incremental buildup)
     * @param state the related assignment state
     * @param allowDeletation <tt>true</tt> if <tt>null</tt> values can overwrite already set values of an compound.
     * @return value
     * @throws ConfigurationException in case that the types of 
     * {@link #getDeclaration()} and <code>value</code> do not comply
     */
    private Value assignContainerValue(ContainerValue conValue, IAssignmentState state, boolean allowDeletation)
        throws ConfigurationException {
        ContainerVariable container = (ContainerVariable) relatedVariable;
        if (allowDeletation) {
            container.clear();
        }
        ContainerValue oldValue = null;
        if (value instanceof ContainerValue) {
            oldValue = (ContainerValue) value;            
        } 
        setValueImpl(conValue);
        for (int i = 0; i < conValue.getElementSize(); i++) {
            boolean overwrite = true;
            if (container.getNestedElementsCount() > i) {
                IDecisionVariable oldNestedVar = container.getNestedElement(i);
                overwrite = AssignmentState.USER_ASSIGNED != oldNestedVar.getState()
                    || state == AssignmentState.USER_ASSIGNED;
            }
            
            if (overwrite) {
                String nestedName = container.getElementName(i);
                //IDatatype containerType = DerivedDatatype.resolveToBasis(relatedVariable.getDeclaration().getType());
                //IDatatype type = ((Container) containerType).getContainedType();
                DecisionVariableDeclaration nestedDecl = new DecisionVariableDeclaration(nestedName,
                    conValue.getElement(i).getType(), relatedVariable.getDeclaration());
                VariableCreator creator = new VariableCreator(nestedDecl, relatedVariable,
                    relatedVariable.isVisible(), false);
                IDecisionVariable nestedVar = creator.getVariable();
                container.addNestedElement(nestedVar);
                Value nesValue = conValue.getElement(i);
                nestedVar.setValue(nesValue, state);
            } else if (oldValue.getElementSize() > i) {
                // Copy old value to new value
                try {
                    conValue.setValue(i, oldValue.getElement(i));
                } catch (ValueDoesNotMatchTypeException e) {
                    LOGGER.exception(e);
                }
            }
        }
        return value;
    }

    /**
     * Changes the value adjusting {@link Value#setValueParent(net.ssehub.easy.varModel.model.values.IValueParent) 
     * the parent variable of the involved values).
     * 
     * @param value the new value
     */
    private void setValueImpl(Value value) {
        if (null != this.value) {
            this.value.setValueParent(null);
        }
        this.value = value;
        if (null != this.value) {
            this.value.setValueParent(relatedVariable);
        }
    }

    @Override
    protected void freeze(IFreezeSelector selector) {
        freeze();
    }
}
