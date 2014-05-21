package de.uni_hildesheim.sse.model.confModel;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Defines the interface for elements in a configuration (including the
 * configuration itself).
 * 
 * @author Holger Eichelberger
 */
public interface IConfigurationElement {

    /**
     * Returns the element this element is part of.
     * 
     * @return the parent element (may be <b>null</b> in case of the 
     *   top-level configuration)
     */
    public IConfigurationElement getParent();
 
    /**
     * Returns the topLevel parent.
     * @return should be the configuration
     */
    public Configuration getConfiguration();

    /**
     * Returns whether this decision variable is nested. Being member of a 
     * {@link Configuration} does not imply 
     * <code>{@link #isNested() isNested} == true</code>.
     * 
     * @return <code>true</code> if it is nested in another decision variable, 
     *   <code>false</code> else
     */
    public boolean isNested();

    /**
     * Returns the assignment state of this variable.
     * 
     * @return the assignment state
     */
    public IAssignmentState getState();

    /**
     * Changes the value of a nested variable.
     * 
     * @param value the new value
     * @param state the new assignment state
     * @param nested the nested variable to be considered in the parent
     * @throws ConfigurationException in case of type incompatibilities
     */
    public void setValue(Value value, IAssignmentState state, IConfigurationElement nested) 
        throws ConfigurationException;
    
    /**
     * Causes to freeze the current value (cannot be undone).
     */
    public void freeze();
    
    /**
     * Causes to freeze a nested value (cannot be undone).
     * @param nestedElement The name of the nested Element, which should be frozen.
     */
    public void freeze(String nestedElement);
    
    /**
     * Returns the declaration of the variable.
     * 
     * @return the declaration of the decision variable
     */
    public AbstractVariable getDeclaration();

}
