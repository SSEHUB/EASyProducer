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
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * 
 * {@link VariableConfigProvider} for nested variables of a {@link ContainerVariable}.
 * 
 * @author El-Sharkawy
 *
 */
class ContainerItemConfigProvider extends NestedVarConfigProvider {

    /**
     * this index is used to retrieve the correct sub value of the parent {@link ContainerVariable}.
     */
    private int index;
    
    private IAssignmentState state;

    /**
     * Sole constructor for creating a {@link VariableConfigProvider} for nested elements of a container.
     * @param parent A {@link CompoundVariable} which will hold the
     *     nested {@link IDecisionVariable} where this provider belongs to.
     * @param index The <tt>index</tt> of the nested {@link IDecisionVariable}
     *     inside the prant.
     */
    ContainerItemConfigProvider(ContainerVariable parent, int index) {
        super(parent);
        this.index = index;
    }
    
    @Override
    protected Value getValue() {
        Value value = null;
        ContainerValue parentValue = (ContainerValue) getParent().getValue();
        if (null != parentValue && parentValue.getElementSize() > index) {
            value = parentValue.getElement(index);
        }
        return value;
    }

    @Override
    protected void setValue(Value value, IAssignmentState state) throws ConfigurationException {
        ContainerValue parentValue = (ContainerValue) getParent().getValue();
        if (parentValue != null) {
            try {
                parentValue.setValue(index, value);
            } catch (ValueDoesNotMatchTypeException e) {
                throw new ConfigurationException(getConfiguration(), e.getMessage(),
                    ConfigurationException.DUPLICATES_IN_SET);
            }
        } else {
            ContainerVariable parent = getParent();
            String nestedName = parent.getElementName(index);
            IDatatype type = DerivedDatatype.resolveToBasis(parent.getDeclaration().getType());
            type = ((Container) type).getContainedType();
            DecisionVariableDeclaration nestedDecl = new DecisionVariableDeclaration(nestedName,
                type, parent.getDeclaration());
            VariableCreator creator = new VariableCreator(nestedDecl, parent, parent.isVisible(), false);
            IDecisionVariable nestedVar = creator.getVariable(false);
            parent.addNestedElement(nestedVar);
        }
        this.state = state;
    }

    @Override
    protected IAssignmentState getState() {
        return state;
    }

    @Override
    protected void setState(IAssignmentState state) {
        // Needed for undo function
        this.state = state;
    }

    @Override
    protected AbstractVariable getDeclaration() {
        // TODO Auto-generated method stub
        return null;
    }

    
    @Override
    protected ContainerVariable getParent() {
        return (ContainerVariable) super.getParent();
    }
    
    /**
     * Setter for the index.
     * Should only be used inside the {@link ContainerVariable} classes to adjust the index after one
     * element as been removed from the list of nested elements.
     * @param newIndex The new index of the related nested {@link IDecisionVariable}.
     * This value must be in the range (this is not checked):
     * (<tt>0 &lt;= newIndex &lt; getParent().getNestedElementsCount()</tt>)
     */
    void setIndex(int newIndex) {
        this.index = newIndex;
    }

    @Override
    protected void setHistoryValue(Value value, IAssignmentState state) throws ConfigurationException {
        this.state = state;
    }

    @Override
    protected void freeze(IFreezeSelector selector) {
        if (0 <= index && index < getParent().getNestedElementsCount()) { // no checking of index before
            IDecisionVariable thisVariable = getParent().getNestedElement(index);
            if (selector.shallFreeze(thisVariable)) {
                state = AssignmentState.FROZEN;
            }
        }
    }
}
