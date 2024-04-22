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

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * 
 * {@link VariableConfigProvider} for nested variables of a {@link ContainerVariable}.
 * 
 * @author El-Sharkawy
 * 
 */
public abstract class ContainerVariable extends StructuredVariable {

    private List<IDecisionVariable> nestedElements;

    /**
     * Sole constructor for this class.
     * 
     * @param parent
     *     the parent this variable is part of, typically the {@link Configuration} instance, but in case of
     *     compounds/container also the containing {@link IDecisionVariable}
     * @param varDeclaration
     *     the variable declaration instantiated by this decision
     * @param isVisible Specifies whether this variables is exported by an interface or not:
     * <ul>
     * <li>{@code true}: The variable is exported by an interface or there is no interface.</li>
     * <li>{@code false}: There is an interface which does not export this variable.</li>
     * </ul>
     * @param isAttribute whether this variable represents (a part of) an attribute or a variable
     */
    protected ContainerVariable(IConfigurationElement parent, AbstractVariable varDeclaration, boolean isVisible, 
        boolean isAttribute) {
        super(parent, varDeclaration, isVisible, isAttribute);
        if (null == nestedElements) {
            nestedElements = new ArrayList<IDecisionVariable>();
        }
    }
    
    /**
     * Clears the list.
     */
    void clear() {
        nestedElements.clear();
    }

    @Override
    public int getNestedElementsCount() {
        // During initialization, nestedElements can be null
        return null == nestedElements ? 0 : nestedElements.size();
    }

    @Override
    public IDecisionVariable getNestedElement(int index) {
        return nestedElements.get(index);
    }
    
    /**
     * Returns the 0-based index of <code>var</code> in this container.
     * 
     * @param var the variable to search for
     * @return the index of <code>var</code> or <code>-1</code> if not found
     */
    public int indexOf(IDecisionVariable var) {
        return nestedElements.indexOf(var);
    }

    @Override
    public void setValue(Value value, IAssignmentState state, IConfigurationElement nested)
        throws ConfigurationException {

        nestedElements.clear();
        ContainerValue conValue = (ContainerValue) value;
        IDatatype type = DerivedDatatype.resolveToBasis(getDeclaration().getType());
        type = ((Container) type).getContainedType();
        for (int i = 0; null != conValue && i < conValue.getElementSize(); i++) {
            String name = getElementName(i);
            Value eltValue = conValue.getElement(i);
            DecisionVariableDeclaration decl = new DecisionVariableDeclaration(name, eltValue.getType(), 
                getDeclaration());
            VariableCreator creator = new VariableCreator(decl, this, isVisible(), false);
            IDecisionVariable var = creator.getVariable();
            var.setValue(eltValue, state);
            eltValue.setValueParent(var);
            nestedElements.add(var);
        }
    }
    
    @Override
    public void setValue(Value value, IAssignmentState state) throws ConfigurationException {
        ContainerValue conValue = null;
        
        if (value == NullValue.INSTANCE) {
            nestedElements.clear();
        } else if (value instanceof ContainerValue) {
            conValue = (ContainerValue) value;
            IDatatype type = DerivedDatatype.resolveToBasis(getDeclaration().getType());
            type = ((Container) type).getContainedType();
            
            // Create nested Elements
            if (conValue != null) {
                while (nestedElements.size() > conValue.getElementSize()) {
                    nestedElements.remove(0);
                }
                for (int i = 0; i < conValue.getElementSize(); i++) {
                    // check whether a new variable needs to be created
                    boolean createNewVar = true;
                    if (nestedElements.size() > i) {
                        IDecisionVariable oldVar = nestedElements.get(i);
                        Value trgValue = conValue.getElement(i);
                        createNewVar = !(null != trgValue && trgValue.equals(oldVar.getValue()));
                        // Overwrite value only if it was not user defined
                        if (createNewVar) {
                            createNewVar = AssignmentState.USER_ASSIGNED != oldVar.getState() 
                                    || AssignmentState.USER_ASSIGNED == state;
                        }
                    }
                    if (createNewVar) {
                        String name = getElementName(i);
                        IDatatype eltType = conValue.getElement(i).getType(); // enable heterogenous polymorphic coll.
                        DecisionVariableDeclaration decl = new DecisionVariableDeclaration(name, eltType,
                            getDeclaration());
                        VariableCreator creator = new VariableCreator(decl, this, isVisible(), false);
                        try {
                            IDecisionVariable var = creator.getVariable();
                            addNestedElement(var);
                        } catch (ConfigurationException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        
        // Set Value for this variable
        super.setValue(value, state);
        
        // set value for nested elements (needed for recursion)
        if (conValue != null) {
            for (int i = 0; i < conValue.getElementSize(); i++) {
                IDecisionVariable nestedVariable = getNestedElement(i);
                if (AssignmentState.USER_ASSIGNED != nestedVariable.getState()
                    || state == AssignmentState.USER_ASSIGNED) {
                    
                    Value nestedValue = conValue.getElement(i);
                    nestedVariable.setValue(nestedValue, state);
                    nestedValue.setValueParent(nestedVariable);
                }
            }
        }
    }

    @Override
    public void freeze(IFreezeSelector selector) {
        super.freeze(selector);
        for (IDecisionVariable var : nestedElements) {
            var.freeze(selector);
        }
    }
    
    @Override
    public void freeze(String nestedElement) {
        // Not supported by this class
    }

    @Override
    boolean allowsNestedStates() {
        return true;
    }

    /**
     * Returns the symbolic name for an element in this container, such as the index for sequences.
     * 
     * @param index
     *            the position of the element within the container
     * @return the symbolic name
     */
    protected String getElementName(int index) {
        return "" + index;
    }

    /**
     * Adds a new nested element to this variable. This nested element is empty, is in state
     * {@link AssignmentState#UNDEFINED} and can be configured afterwards.
     * 
     * @return the created decision variable
     */
    public IDecisionVariable addNestedElement() {
        return addNestedElement((IDatatype) null);
    }
    
    /**
     * Returns the contained type of this container.
     * 
     * @return the contained type
     */
    public IDatatype getContainedType() {
        return ((Container) DerivedDatatype.resolveToBasis(getDeclaration().getType())).getContainedType();
    }
    
    /**
     * Adds a new nested element to this variable. This nested element is empty, is in state
     * {@link AssignmentState#UNDEFINED} and can be configured afterwards.
     * 
     * @param type the specific type to create the nested element for; if <b>null</b>, the declared contained type
     *    is used; if not assignable to the declared contained type, the declared contained type is used instead
     * @return the created decision variable
     */
    public IDecisionVariable addNestedElement(IDatatype type) {
        if (null == getValue()) {
            try {
                Value containerValue = ValueFactory.createValue(getDeclaration().getType(), (Object[]) null);
                setValue(containerValue, AssignmentState.UNDEFINED);
            } catch (ConfigurationException e) {
                e.printStackTrace();
            } catch (ValueDoesNotMatchTypeException e) {
                e.printStackTrace();
            }
        }
        IDecisionVariable result = null;
        IDatatype baseType = getContainedType();
        if (null == type || !baseType.isAssignableFrom(type)) {
            type = baseType;
        }
        int elementPos = nestedElements.size();
        try {
            String name = getElementName(elementPos);
            DecisionVariableDeclaration decl = new DecisionVariableDeclaration(name, type, getDeclaration());
            VariableCreator creator = new VariableCreator(decl, this, isVisible(), false);
            result = creator.getVariable(false);
            addNestedElement(result);
            Value nullValue = ValueFactory.createValue(type, (Object[]) null);
            result.setValue(nullValue, AssignmentState.UNDEFINED);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        } catch (ValueDoesNotMatchTypeException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Removes a (configured) element ({@link IDecisionVariable}) of this {@link ContainerVariable}.
     * This is the reverse function of {@link #addNestedElement()}.
     * @param var A variable which is directly nested in this variable and shall be deleted.
     * @return {@code true} if the specified element was found and deleted from this variable, {@code false} otherwise
     * @see #addNestedElement()
     */
    public boolean removeNestedElement(IDecisionVariable var) {
        int index = nestedElements.indexOf(var);
        
        if (-1 != index) {
            nestedElements.remove(index);
            
            /* 
             * Copy old values (the old indexes must be used,
             * since the ConfigurationProvider use the old complete ContainerValue to retrieve sub values.
             */
            Object[] copiedValues = new Object[nestedElements.size()];
            for (int i = 0; i < nestedElements.size(); i++) {
                copiedValues[i] = nestedElements.get(i).getValue();
            }
            
            // Change the indexes inside the ConfigurationProvider to retrieve the correct sub values
            for (int i = index; i < nestedElements.size(); i++) {
                ((DecisionVariable) nestedElements.get(i)).setIndex(i);
            }
           
            try {
                Value newValue = ValueFactory.createValue(getDeclaration().getType(), copiedValues);
                super.setValue(newValue, AssignmentState.ASSIGNED);
            } catch (ValueDoesNotMatchTypeException e) {
                // Should not occur
                Bundle.getLogger(ContainerValue.class).exception(e);
            } catch (ConfigurationException e) {
                // Should not occur
                Bundle.getLogger(ContainerValue.class).exception(e);
            }

        }
        
        return -1 != index;
    }

    @Override
    public IAssignmentState getState() {
        IAssignmentState state = super.getState();
        
        // check whether the whole container was frozen already
        if (state != AssignmentState.FROZEN && ownStateAllowed()) {
            if (getValue() != NullValue.INSTANCE) {
                if (getValue() == null || null == getValue().getValue()) {                
                    state = AssignmentState.UNDEFINED;
                } else if (state == AssignmentState.UNDEFINED && nestedElements.size() > 0) {
                    state = AssignmentState.ASSIGNED;
                }
            }
        }
        
        return state;
    }
    
//    @Override
//    public IAssignmentState getState() {
//        IAssignmentState state = super.getState();
//
//        if (state == AssignmentState.UNDEFINED && nestedElements.size() > 0) {
//            state = AssignmentState.ASSIGNED;
//        }
//
//        return state;
//    }

    /**
     * Adds a nested {@link IDecisionVariable} to this {@link ContainerVariable}.
     * If an equal {@link IDecisionVariable} is already part of this {@link ContainerVariable},
     * the {@link IDecisionVariable} will be replaced by the new one.
     * @param var The nested {@link IDecisionVariable} which should be added to this container.
     */
    void addNestedElement(IDecisionVariable var) {
        boolean found = false;
        for (int i = 0; i < getNestedElementsCount() && !found; i++) {
            IDecisionVariable oldVar = nestedElements.get(i);
            if (oldVar.getDeclaration().getName().equals(var.getDeclaration().getName())) {
                found = true;
                nestedElements.set(i, var);
            }
        }
        if (!found) {
            if (null == nestedElements) {
                nestedElements = new ArrayList<IDecisionVariable>();
            }
            nestedElements.add(var);
        }
    }
    
    @Override
    public boolean removeDerivedValues() {
        boolean changed = false;
        
        // First remove all variables which are completely in state Derived
        IAssignmentState oldState = getState();
        ArrayList<IDecisionVariable> copiedValues = new ArrayList<IDecisionVariable>();
        for (int i = 0, n = nestedElements.size(); i < n; i++) {
            if (AssignmentState.DERIVED != nestedElements.get(i).getState()) {
                copiedValues.add(nestedElements.get(i));
            }
        }
        // Copy only if there was a change
        if (copiedValues.isEmpty()) {
            // Remove complete value
            try {
                setValue(null, AssignmentState.UNDEFINED);
                changed = true;
            } catch (ConfigurationException e) {
                // Should not be possible
                Bundle.getLogger(ContainerValue.class).exception(e);
            }
        } else if (copiedValues.size() < nestedElements.size()) {
            // Set new (smaller) value
            // Change the indexes inside the ConfigurationProvider to retrieve the correct sub values
            for (int i = 0; i < copiedValues.size(); i++) {
                ((DecisionVariable) copiedValues.get(i)).setIndex(i);
            }
            Value newValue;
            try {
                newValue = ValueFactory.createValue(getDeclaration().getType(), copiedValues.toArray());
                super.setValue(newValue, oldState);
            } catch (ValueDoesNotMatchTypeException e) {
                Bundle.getLogger(ContainerValue.class).exception(e);
            } catch (ConfigurationException e) {
                Bundle.getLogger(ContainerValue.class).exception(e);
            }
            changed = true;
        }
        
        // Second remove values inside nested elements
        if (!nestedElements.isEmpty()) {
            for (int i = 0, n = nestedElements.size(); i < n; i++) {
                changed &= nestedElements.get(i).removeDerivedValues();
            }
        }
        return changed;
    }
    
    // enableWasAssignedForIsDefined() does not completely work for now here

    @Override    
    public boolean notifyWasAssigned(Value value) {
        boolean old = wasAssigned();
        super.notifyWasAssigned(value);
        if (value instanceof ContainerValue) {
            ContainerValue cValue = (ContainerValue) value;
            for (int n = 0; n < Math.min(getNestedElementsCount(), cValue.getElementSize()); n++) {
                getNestedElement(n).notifyWasAssigned(cValue.getElement(n));
            }
        }
        return old;
    }

}
