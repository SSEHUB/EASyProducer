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

import net.ssehub.easy.varModel.confModel.paths.IResolutionPathElement;
import net.ssehub.easy.varModel.model.values.IValueParent;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Interface for configurable {@link DecisionVariable}.
 * Contrary to {@link IConfigurationElement}, this interface is only for elements of the {@link Configuration},
 * not the {@link Configuration} itself.
 * @author El-Sharkawy
 *
 */
public interface IDecisionVariable extends IConfigurationElement, IConfigurationVisitable, IValueParent {
    
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
     * Changes the value.
     * 
     * @param value the value (may be <b>null</b> for incremental buildup)
     * @param state the related assignment state
     * @param asAssignment does this call happen as part of evaluating an IVML assignment operation
     * @throws ConfigurationException in case that the types of 
     *   {@link #getDeclaration()} and <code>value</code> do not comply
     */
    public void setValue(Value value, IAssignmentState state, boolean asAssignment) throws ConfigurationException;

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
     * Returns an element specified by its name.
     * 
     * @param name the name of the nested element
     * @return the nested element (may be <b>null</b>)
     */
    public IDecisionVariable getNestedElement(String name);
    
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
     * Returns whether this variable is visible by the user.
     * @return <tt>false</tt> if the variable is hidden by an interface, <tt>true</tt> otherwise
     */
    public boolean isVisible();

    /**
     * Returns whether this variable is local, e.g., as a parameter of a user-defined function,
     * a variable defined by a let-expression, or an iterator in a container operation.
     * @return <tt>false</tt> if the variable is not local and part of an usual configuration, 
     *    <code>true</code> if the variable is local
     */
    public boolean isLocal();

    /**
     * Checks whether the variable has a configured {@link Value}.
     * @return <tt>true</tt> if the variable has a value, <tt>false</tt> otherwise.
     */
    public boolean hasValue();
    
    /**
     * Checks whether the variable has a {@link net.ssehub.easy.varModel.model.values.NullValue}.
     * Note: this method does not check whether the variable <b>has</b> a value.
     * @return <tt>true</tt> if the variable has a {@link net.ssehub.easy.varModel.model.values.NullValue},
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
    
    /**
     * Returns the qualified name of the declaration instance.
     * This is build as follows:<br/>
     * <tt>&lt;Project name&gt; :: [&lt;Parent name&gt;::]* &lt;Declaration name&gt;</tt>
     * @return The qualified and unique name of the variable.
     */
    public String getQualifiedName();
    
    /**
     * Returns a resolution path for this variable.
     * 
     * @return the resolution path
     */
    public IResolutionPathElement getResolutionPath();

    /**
     * Notifies this variable that it was created.
     */
    public void notifyCreated();
    
    // this is a hack for getting isDefined running on compounds

    /**
     * Shall we take the local {@link #wasAssigned()} over {@link #getState()} in the implementation of IVML 
     * "isDefined".
     *  
     * @return {@code true} take {@link #wasAssigned()}, {@code false} for {@link #getState()}.
     */
    public boolean enableWasAssignedForIsDefined();
    
    /**
     * Inform the variable independent of its own tracking that we believe that a value was assigned (although we
     * did not due to equal values/performance reasons), in particular after resetting the track through 
     * {@link CommandAssignmentState#compareTo(CommandAssignmentState)}.
     * 
     * @param value the new value
     * @return {@code true} whether this variable was defined before, {@code false} else
     */
    public boolean notifyWasAssigned(Value value);

    /**
     * Returns whether a value was assigned (correlated, but independent of {@link #getState()}).
     * 
     * @return {@code true} if a value was assigned, {@code false} else
     */
    public boolean wasAssigned();

}
