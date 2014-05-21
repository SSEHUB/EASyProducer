package de.uni_hildesheim.sse.utils.pool;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements a simple pool for explicit memory management of frequently
 * created elements. In order to keep interfaces of instances clean, we
 * delegate creation and clear operation to the {@link IPoolManager} delegate.
 * 
 * @param <T> the type of instances to be managed
 *
 * @author Holger Eichelberger
 */
public class Pool <T> {

    private IPoolManager<T> manager;
    private List<T> pool = new ArrayList<T>();

    /**
     * Creates a new pool for a given type of instances represented by its
     * pool manager.
     * 
     * @param manager the pool manager
     */
    public Pool(IPoolManager<T> manager) {
        assert null != manager;
        this.manager = manager;
    }
    
    /**
     * Returns an instance from the pool or creates a new instance via the
     * {@link #manager}.
     * 
     * @return an instance
     */
    public T getInstance() {
        T result;
        if (pool.isEmpty()) {
            result = manager.create();
        } else {
            result = pool.remove(pool.size() - 1);
        }
        return result;
    }
    
    /**
     * Releases an <code>instance</code> obtained from {@link #get()}.<br/>
     * <b>Cave:</b> Do not release instances twice!
     * 
     * @param instance the instance to be released
     */
    public void releaseInstance(T instance) {
        if (null != instance) {
            assert !pool.contains(instance);
            manager.clear(instance);
            pool.add(instance);
        }
    }

}
