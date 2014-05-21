package de.uni_hildesheim.sse.utils.pool;

/**
 * Represents a pool manager (delegate) for a typed {@link Pool pool}. Depending
 * on the actual interface of &lt;T&gt; this interface may be implemented directly
 * or in terms of an anonymous class in order to keep the interface of &lt;T&gt; clean.
 * 
 * @param <T> the type of instances to be managed
 * 
 * @author Holger Eichelberger
 */
public interface IPoolManager <T> {

    /**
     * Creates a new element in case that the pool is empty.
     * 
     * @return the element
     */
    public T create();
    
    /**
     * Clears an instance before releasing it.
     * 
     * @param instance the instance to be cleared
     */
    public void clear(T instance);
    
}
