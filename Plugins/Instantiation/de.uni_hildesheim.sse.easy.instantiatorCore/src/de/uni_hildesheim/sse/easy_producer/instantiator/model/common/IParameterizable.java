package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IResolvable;

/**
 * Defines the access to parameters.
 * 
 * @param <V> the actual type of resolvable / variable
 * 
 * @author Holger Eichelberger
 */
public interface IParameterizable <V extends IResolvable> {

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

}
