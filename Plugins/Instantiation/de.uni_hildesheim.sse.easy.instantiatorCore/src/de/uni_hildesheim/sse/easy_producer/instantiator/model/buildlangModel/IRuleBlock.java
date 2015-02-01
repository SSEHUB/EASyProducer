package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

/**
 * Defines the interface for a rule block, i.e., a block containing {@link IRuleElement rule elements}.
 * 
 * @author Holger Eichelberger
 */
public interface IRuleBlock {

    /**
     * Get the number of body elements of this rule.
     * 
     * @return The number of body elements of this rule.
     */
    public int getBodyElementCount();
    
    /**
     * Get the element of this rule at the specified index.
     * 
     * @param index The 0-based index of the rule element to be returned. 
     * @return The rule element at the given index.
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getBodyElementCount()}</code>
     */
    public IRuleElement getBodyElement(int index);
    
    /**
     * Returns whether this block is a real block or consists just of a block
     * element without brackets.
     * 
     * @return <code>true</code> if this block is virtual, <code>false</code> else
     */
    public boolean isVirtual();

}
