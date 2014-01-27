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
}
