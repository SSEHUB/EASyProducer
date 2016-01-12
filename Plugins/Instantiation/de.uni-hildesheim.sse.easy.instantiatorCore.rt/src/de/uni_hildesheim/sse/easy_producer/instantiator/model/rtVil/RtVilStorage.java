/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil;

/**
 * Storage provider for rt-VIL execution. Please note that a storage only needs to be set and available at
 * runtime. However, for parsing rt-VIL correctly and for providing hints whether storage will be available, 
 * the design environment (more precisely the binding to the underlying system) must set 
 * {@link #setStorageHint(boolean)} correctly. However, it is ok to have the storage provider instance before 
 * runtime, but this is actually not required.
 * 
 * @author Holger Eichelberger
 */
public abstract class RtVilStorage {
    
    private static RtVilStorage instance;
    private static boolean storageHint;
    private static ISimulationNotifier simulationNotifier;
    
    /**
     * Defines the global storage provider.
     * 
     * @param storageProvider the storage provider (may be <b>null</b> in case of no provider)
     */
    public static final void setInstance(RtVilStorage storageProvider) {
        instance = storageProvider;
    }
    
    /**
     * Returns the actual storage instance.
     * 
     * @return the actual storage instance
     */
    public static final RtVilStorage getInstance() {
        return instance;
    }
    
    /**
     * Provides a hint to the parser whether the runtime execution will provide a storage instance.
     * 
     * @param hasStorage <code>true</code> if there will be a storage instance, <code>false</code> else
     */
    public static final void setStorageHint(boolean hasStorage) {
        storageHint = hasStorage;
    }

    /**
     * Provides a hint to the execution whether the runtime execution happens in a simulation environment.
     * 
     * @param notifier the notifier instance or <b>null</b> in case of no notification
     */
    public static final void setSimulationNotifier(ISimulationNotifier notifier) {
        simulationNotifier = notifier;
    }
    
    /**
     * Returns the simulation notifier, i.e., whether rt-VIL is executed within a simulation environment.
     * 
     * @return <b>null</b> in case of no simulation, the notifier else
     */
    public static final ISimulationNotifier getSimulationNotifier() {
        return simulationNotifier;
    }
    
    /**
     * Returns whether the runtime execution will provide a storage instance.
     * 
     * @return <code>true</code> if a storage instance will be available at execution time of rt-VIL.
     */
    public static final boolean hasStorage() {
        return storageHint;
    }
    
    /**
     * Returns the value for <code>variable</code> in <code>script</code>.
     * 
     * @param script the script to return the value for
     * @param variable the variable in <code>script</code> to return the value for
     * @return the value (or <b>null</b> if not available)
     */
    public abstract Object getValue(String script, String variable);

    /**
     * Changes the value for <code>variable</code> in <code>script</code>.
     * 
     * @param script the script to set the value for
     * @param variable the variable in <code>script</code> to set the value for
     * @param value the value (or <b>null</b> to clear)
     */
    public abstract void setValue(String script, String variable, Object value);

}
