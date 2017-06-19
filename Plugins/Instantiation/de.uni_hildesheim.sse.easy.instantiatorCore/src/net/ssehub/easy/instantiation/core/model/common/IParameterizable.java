package net.ssehub.easy.instantiation.core.model.common;

import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaParameterDeclaration;

/**
 * Defines the access to parameters.
 * 
 * @param <V> the actual type of resolvable / variable
 * 
 * @author Holger Eichelberger
 */
public interface IParameterizable <V extends IMetaParameterDeclaration> {

    /**
     * Get the number of parameters of this rule.
     * 
     * @return The number of parameters of this rule.
     */
    public int getParameterCount();
    
    /**
     * Get the parameter of this rule at the specified index.
     * 
     * @param index The 0-based index of the rule parameter to be returned.
     * @return The rule parameter at the given index.
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getParameterCount()}</code>
     */
    public V getParameter(int index);

    /**
     * Returns the number of required parameters, i.e., non-default and non-named parameters.
     * 
     * @return the number of required parameters
     */
    public int getRequiredParameterCount();
    
    /**
     * Returns a named parameter declaration.
     * 
     * @param name the name of the parameter
     * @return the declaration or <b>null</b> if there is none
     */
    public V getParameter(String name);

}
