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

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.CompoundVariable;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IConfiguration;
import net.ssehub.easy.varModel.confModel.IConfigurationElement;
import net.ssehub.easy.varModel.confModel.IConfigurationVisitor;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.confModel.IFreezeSelector;
import net.ssehub.easy.varModel.confModel.paths.IResolutionPathElement;
import net.ssehub.easy.varModel.confModel.paths.StartPathElement;
import net.ssehub.easy.varModel.cstEvaluation.IValueChangeListener.ChangeKind;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.IValueParent;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * A local decision variable representing a parameter or a local variable. A local decision variable
 * must also return local decision variables (in order to remain "local").
 * 
 * @author Holger Eichelberger
 */
public class LocalDecisionVariable implements IDecisionVariable {

    static final String ITERATOR_RESULT_VARNAME = "*r*";
    
    private DecisionVariableDeclaration decl;
    private Value value;
    private IAssignmentState state;
    private IConfiguration conf;
    private IDecisionVariable parent;
    private IValueChangeListener listener;

    /**
     * Creates a local decision variable.
     * 
     * @param decl the defining variable declaration
     * @param conf the configuration
     * @param parent the parent decision variable for call-by-reference, may be <b>null</b>
     */
    public LocalDecisionVariable(DecisionVariableDeclaration decl, IConfiguration conf, IDecisionVariable parent) {
        this.decl = decl;
        this.state = AssignmentState.UNDEFINED;
        this.conf = conf;
        this.parent = parent;
    }

    @Override
    public IConfigurationElement getParent() {
        return parent;
    }

    @Override
    public Configuration getConfiguration() {
        return null; // would work if the return value would be IConfiguration, let's cross our fingers
    }

    @Override
    public boolean isNested() {
        return false;
    }

    @Override
    public IAssignmentState getState() {
        return state;
    }

    /**
     * Notifies the change listener if defined.
     * 
     * @param oldValue the old value before the change, may be <b>null</b>
     * @param oldState the old state of <code>variable</code> before the change
     * @param kind the change kind
     */
    private void notifyValueChanged(Value oldValue, IAssignmentState oldState, ChangeKind kind) {
        if (null != listener) {
            listener.notifyChanged(this, oldValue, oldState, kind);
        }
    }

    @Override
    public void setValue(Value value, IAssignmentState state, boolean asAssignment) throws ConfigurationException {
        IValueParent vParent = asAssignment ? obtainValueParent(value) : null;
        Value oldValue = this.value;
        IAssignmentState oldState = this.state;
        this.value = value;
        this.state = state;
        // we try to set a slot value on a compound, "call-by-ref"
        if (null != parent && vParent instanceof IDecisionVariable) {
            IDecisionVariable decVar = (IDecisionVariable) vParent;
            if (Compound.TYPE.isAssignableFrom(decVar.getDeclaration().getType())) {
                IDecisionVariable nested = decVar.getNestedElement(decl.getName());
                if (null != nested) {
                    decVar.setValue(value, state, nested);
                }
            }
        }
        notifyValueChanged(oldValue, oldState, ChangeKind.FULL);
    }

    @Override
    public void setValue(Value value, IAssignmentState state) throws ConfigurationException {
        Value oldValue = this.value;
        IAssignmentState oldState = this.state;
        this.value = value;
        this.state = state;
        notifyValueChanged(oldValue, oldState, ChangeKind.FULL);
    }

    @Override
    public void setValue(Value value, IAssignmentState state, IConfigurationElement nested)
        throws ConfigurationException {
        IAssignmentState oldState = this.state;
        Value oldValue = this.value;
        this.value = value;
        this.state = state;
        notifyValueChanged(oldValue, oldState, ChangeKind.FULL);
    }
    
    /**
     * Obtains the value parent for the stored value, the given value or the value of one of the parents.
     * 
     * @param value the value to consider (may be <b>null</b>)
     * @return the value parent, may be <b>null</b> for none
     */
    private IValueParent obtainValueParent(Value value) {
        IValueParent result = getValueParent(this.value);
        if (null == result) {
            result = getValueParent(value);
        }
        if (null == result) {
            IDecisionVariable iter = parent;
            while (null != iter && null == result) {
                result = getValueParent(iter.getValue());
                if (iter.getParent() instanceof IDecisionVariable) {
                    iter = (IDecisionVariable) iter.getParent();    
                } else {
                    iter = null;
                }
            }
        }
        return result;
    }

    /**
     * Returns the value parent of <code>value</code>.
     * 
     * @param value the value to return the parent for (may be <b>null</b>)
     * @return the value parent (may be <b>null</b>)
     */
    private IValueParent getValueParent(Value value) {
        return null == value ? null : value.getValueParent();
    }

    @Override
    public void freeze(IFreezeSelector selector) {
        // local variables cannot be frozen
    }

    @Override
    public void unfreeze(IAssignmentState state) {
        // local variables cannot be frozen
    }
    
    @Override
    public void freeze(String nestedElement) {
        // local variables cannot be frozen
    }

    @Override
    public AbstractVariable getDeclaration() {
        return decl;
    }

    @Override
    public void accept(IConfigurationVisitor visitor) {
        // local variables cannot be visited
    }

    @Override
    public Value getValue() {
        return value;
    }

    @Override
    public void setHistoryValue(Value value, IAssignmentState state) throws ConfigurationException {
        // ignore
    }

    @Override
    public int getNestedElementsCount() {
        int result;
        if (null != parent) {
            result = parent.getNestedElementsCount();
        } else if (value instanceof ContainerValue) {
            result = ((ContainerValue) value).getElementSize();
        } else if (value instanceof CompoundValue) {
            result = ((Compound) value.getType()).getElementCount();
        } else {
            result = 0;
        }
        return result;
    }

    @Override
    public IDecisionVariable getNestedElement(int index) {
        IDecisionVariable result;
        if (null != parent) {
            result = parent.getNestedElement(index);
        } else if (value instanceof ContainerValue) {
            Value cValue = ((ContainerValue) value).getElement(index);
            IModelElement par = null;
            IDatatype cType = cValue.getType();
            if (cType instanceof Container) {
                cType = ((Container) cType).getContainedType();
                par = (Container) cType;
            }
            LocalDecisionVariable var = new LocalDecisionVariable(new DecisionVariableDeclaration(String.valueOf(index),
                cType, par), conf, this);
            try {
                var.setValue(cValue, AssignmentState.ASSIGNED);
            } catch (ConfigurationException e) {
            }
            result = var;
        } else if (value instanceof CompoundValue) {
            CompoundValue cValue = (CompoundValue) value;
            Compound type = (Compound) cValue.getType();
            DecisionVariableDeclaration slotDecl = type.getElement(index);
            LocalDecisionVariable var = new LocalDecisionVariable(slotDecl, conf, this);
            Value slotValue = cValue.getNestedValue(slotDecl.getName());
            try {
                var.setValue(slotValue, AssignmentState.ASSIGNED);
            } catch (ConfigurationException e) {
            }
            result = var;
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Returns the nested variable for the given slot name.
     * 
     * @param slotName the slot name
     * @return the nested variable or <b>null</b> if it does not exist
     */
    public IDecisionVariable getNestedVariable(String slotName) {
        IDecisionVariable result = null;
        if (parent instanceof CompoundVariable) {
            result = ((CompoundVariable) parent).getNestedVariable(slotName);
        } else {
            Value tmp = Configuration.dereference(conf, value);
            if (tmp instanceof CompoundValue) { // not available for Container
                CompoundValue cValue = (CompoundValue) tmp;
                Compound type = (Compound) cValue.getType();
                DecisionVariableDeclaration slotDecl = type.getElement(slotName);
                if (null != slotDecl) {
                    Value slotValue = cValue.getNestedValue(slotName);
                    if (!Reference.TYPE.isAssignableFrom(slotDecl.getType())) { // don't dereference references
                        slotValue = Configuration.dereference(conf, slotValue);
                    }
                    LocalDecisionVariable var = new LocalDecisionVariable(slotDecl, conf, this);
                    if (null != slotValue) {
                        try {
                            var.setValue(slotValue, AssignmentState.ASSIGNED);
                        } catch (ConfigurationException e) {
                        }
                    }
                    result = var;
                }
            } 
        }
        return result;
    }

    @Override
    public IDecisionVariable getNestedElement(String name) {
        return Configuration.getNestedElement(this, name);
    }

    @Override
    public int getAttributesCount() {
        return null != parent ? parent.getAttributesCount() : 0;
    }

    @Override
    public IDecisionVariable getAttribute(int index) {
        if (null != parent) {
            return parent.getAttribute(index);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int getNestedDepth() {
        return 0;
    }

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public boolean hasValue() {
        return null != value;
    }

    @Override
    public boolean hasNullValue() {
        return NullValue.INSTANCE == value;
    }

    @Override
    public boolean removeDerivedValues() {
        // Should not be needed here.
        return false;
    }

    @Override
    public String getQualifiedName() {
        return getDeclaration().getQualifiedName();
    }
    
    @Override
    public IResolutionPathElement getResolutionPath() {
        return new StartPathElement(getDeclaration()); // unclear for now
    }
    
    @Override
    public boolean isLocal() {
        return true;
    }
    
    /**
     * Changes the underlying variable taking precedence over the stored value.
     * 
     * @param variable the variable (may be <b>null</b>) to ignore
     */
    public void setVariable(IDecisionVariable variable) {
        parent = variable;
    }

    /**
     * Returns the underlying variable.
     * 
     * @return variable the variable (may be <b>null</b>)
     */
    public IDecisionVariable getVariable() {
        return parent;
    }
    
    /**
     * Defines the value change listener to be informed.
     * 
     * @param listener the listener instance or <b>null</b> for none
     */
    public void setValueChangeListener(IValueChangeListener listener) {
        this.listener = listener;
    }

    @Override
    public boolean wasCreated() {
        return true;
    }

    @Override
    public void notifyCreated() {
    }
    
    @Override
    public boolean notifyWasAssigned(Value value) {
        return false; // not relevant here, disabled see #enableWasAssignedForIsDefined
    }

    @Override
    public boolean wasAssigned() {
        return true;
    }

    @Override
    public boolean enableWasAssignedForIsDefined() {
        return false;
    }

}
