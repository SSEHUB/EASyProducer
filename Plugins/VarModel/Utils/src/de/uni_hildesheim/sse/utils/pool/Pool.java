/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
    public synchronized T getInstance() {
        T result;
        if (pool.isEmpty()) {
            result = manager.create();
        } else {
            result = pool.remove(pool.size() - 1);
        }
//Helper code to detect release bugs / anomalies        
//Throwable t = new Throwable();
//ALLOC.put(result, t);
        return result;
    }
    
//private static boolean PRINT = true;    
//private java.util.Map<Object, Throwable> ALLOC = new java.util.HashMap<Object, Throwable>();    
//private java.util.Map<Object, Throwable> FREE = new java.util.HashMap<Object, Throwable>();    

    /**
     * Releases an <code>instance</code> obtained from {@link #get()}.<br/>
     * <b>Cave:</b> Do not release instances twice!
     * 
     * @param instance the instance to be released
     */
    public synchronized void releaseInstance(T instance) {
        if (null != instance) {
/*if (PRINT) {            
if (pool.contains(instance)) {
    System.out.println("RET " + instance);
    System.out.println("ALLOC:");
    ALLOC.get(instance).printStackTrace(System.out);
    System.out.println("FREE1:");
    FREE.get(instance).printStackTrace(System.out);
    System.out.println("FREE:");
    Throwable t = new Throwable();
    t.printStackTrace(System.out);
    PRINT = false;
} else {
    Throwable t = new Throwable();
    FREE.put(instance, t);
}
}*/
            assert !pool.contains(instance);
            manager.clear(instance);
            pool.add(instance);
        }
    }

}
