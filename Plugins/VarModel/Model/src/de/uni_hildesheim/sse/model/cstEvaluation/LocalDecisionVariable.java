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
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IAssignmentState;
import de.uni_hildesheim.sse.model.confModel.IConfigurationElement;
import de.uni_hildesheim.sse.model.confModel.IConfigurationVisitor;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * A local decision variable representing a parameter or a local variable.
 * 
 * @author Holger Eichelberger
 */
public class LocalDecisionVariable implements IDecisionVariable {

    private DecisionVariableDeclaration decl;
    private Value value;
    private IAssignmentState state;

    /**
     * Creates a local decision variable.
     * 
     * @param decl the defining variable declaration
     */
    LocalDecisionVariable(DecisionVariableDeclaration decl) {
        this.decl = decl;
        this.state = AssignmentState.UNDEFINED;
    }

    /**
     * {@inheritDoc}
     */
    public IConfigurationElement getParent() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Configuration getConfiguration() {
        return null; // would work if the return value would be IConfiguration, let's cross our fingers
    }

    /**
     * {@inheritDoc}
     */
    public boolean isNested() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public IAssignmentState getState() {
        return state;
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(Value value, IAssignmentState state, IConfigurationElement nested)
        throws ConfigurationException {
        this.value = value;
        this.state = state;
    }

    /**
     * {@inheritDoc}
     */
    public void freeze() {
        // local variables cannot be frozen
    }

    /**
     * {@inheritDoc}
     */
    public void unfreeze(IAssignmentState state) {
        // local variables cannot be frozen
    }
    
    /**
     * {@inheritDoc}
     */
    public void freeze(String nestedElement) {
        // local variables cannot be frozen
    }

    /**
     * {@inheritDoc}
     */
    public AbstractVariable getDeclaration() {
        return decl;
    }

    /**
     * {@inheritDoc}
     */
    public void accept(IConfigurationVisitor visitor) {
        // local variables cannot be visited
    }

    /**
     * {@inheritDoc}
     */
    public Value getValue() {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(Value value, IAssignmentState state) throws ConfigurationException {
        setValue(value, state, null);
    }

    /**
     * {@inheritDoc}
     */
    public void setHistoryValue(Value value, IAssignmentState state) throws ConfigurationException {
        // ignore
    }

    /**
     * {@inheritDoc}
     */
    public int getNestedElementsCount() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public IDecisionVariable getNestedElement(int index) {
        throw new IndexOutOfBoundsException();
    }

    /**
     * {@inheritDoc}
     */
    public int getAttributesCount() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public IDecisionVariable getAttribute(int index) {
        throw new IndexOutOfBoundsException();
    }

    /**
     * {@inheritDoc}
     */
    public int getNestedDepth() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isVisible() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean hasValue() {
        return null != value;
    }

    /**
     * {@inheritDoc}
     */
    public boolean hasNullValue() {
        return NullValue.INSTANCE == value;
    }

}
