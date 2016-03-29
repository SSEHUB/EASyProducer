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
package net.ssehub.easy.basics.pool;

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
