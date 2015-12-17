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
package de.uni_hildesheim.sse.model.confModel;

import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Interface for configurable {@link DecisionVariable}.
 * Contrary to {@link IConfigurationElement}, this interface is only for elements of the {@link Configuration},
 * not the {@link Configuration} itself.
 * @author El-Sharkawy
 *
 */
public interface IDecisionVariable extends IConfigurationElement, IConfigurationVisitable {
    
    /**
     * Returns the current value of this {@link IDecisionVariable}.
     * 
     * @return the value (may be <b>null</b>)
     */
    public Value getValue();

    /**
     * Changes the value (for incremental buildup).
     * 
     * @param value the value (may be <b>null</b> for incremental buildup)
     * @param state the related assignment state
     * @throws ConfigurationException in case that the types of 
     *   {@link #getDeclaration()} and <code>value</code> do not comply
     */
    public void setValue(Value value, IAssignmentState state) throws ConfigurationException;
    
    /**
     * Changes the value (for incremental buildup) from value history.
     * 
     * @param value the value (may be <b>null</b> for incremental buildup)
     * @param state the related assignment state
     * @throws ConfigurationException in case that the types of 
     *   {@link #getDeclaration()} and <code>value</code> do not comply
     */
    public void setHistoryValue(Value value, IAssignmentState state) throws ConfigurationException;
    
    /**
     * Returns the number of nested elements.
     * The return value should be 0 unless this {@link IDecisionVariable} is a
     * <ul>
     * <li>{@link CompoundVariable}</li>
     * <li>{@link ContainerVariable}</li>
     * </ul>
     * @return An integer value greater or equal to 0.
     */
    public int getNestedElementsCount();
    
    /**
     * Returns the element specified by <code>index</code>.
     * [also req SAP]
     * 
     * @param index a 0-based index specifying the element to be returned
     * @return the element
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getNestedElementsCount}</code>
     */
    public IDecisionVariable getNestedElement(int index);
    
    /**
     * Returns the number of attributes.
     * 
     * @return the number of attributes
     */
    public int getAttributesCount();

    /**
     * Returns a specific attribute.
     * 
     * @param index the index of the attribute
     * @return the attribute
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getAttributesCount()}</code>
     */
    public IDecisionVariable getAttribute(int index);
    
    
    /**
     * Returns how many parent {@link IDecisionVariable}s exist for this variable.
     * @return 0 if the Configuration is the direct parent of this {@link IDecisionVariable}, otherwise
     * a number greater than 0 indicating how many {@link IDecisionVariable}s between the {@link Configuration} and
     * this variable exist. 
     */
    public int getNestedDepth();

    /**
     * Returns whether this variables is visible by the user.
     * @return <tt>false</tt> if the variable is hidden by an interface, <tt>true</tt> otherwise
     */
    public boolean isVisible();
    
    /**
     * Checks whether the variable has a configured {@link Value}.
     * @return <tt>true</tt> if the variable has a value, <tt>false</tt> otherwise.
     */
    public boolean hasValue();
    
    /**
     * Checks whether the variable has a {@link de.uni_hildesheim.sse.model.varModel.values.NullValue}.
     * Note: this method does not check whether the variable <b>has</b> a value.
     * @return <tt>true</tt> if the variable has a {@link de.uni_hildesheim.sse.model.varModel.values.NullValue},
     *     <tt>false</tt> otherwise.
     */
    public boolean hasNullValue();
    
    /**
     * Removes all (nested) values which are in state {@link AssignmentState#DERIVED}, i.e., all values which are
     * propagated bay the reasoner. This will keep all user assigned {@link AssignmentState#ASSIGNED} and frozen
     * {@link AssignmentState#FROZEN} values.
     * @return <tt>true</tt> if there was a change, <tt>false</tt> if the variable keeps unchanged.
     */
    public boolean removeDerivedValues();
}
