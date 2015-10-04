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
package de.uni_hildesheim.sse.dslcore.ui.listeners;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Implements an aggregating model loading listener, which enables the given controls only if all
 * listeners are enabled.
 * 
 * @author Holger Eichelberger
 */
public class AggregatingModelLoadingListener implements IControl, IAggregatableListener {
    
    private IControl[] controls;
    private Map<IAggregatableListener, Boolean> state = Collections.synchronizedMap(
        new HashMap<IAggregatableListener, Boolean>());
    
    /**
     * Aggregates the state of multiple loading listeners.
     * 
     * @param controls the controls to be informed
     * @see #initialize()
     * @see #addListeners(IAggregatableListener...)
     */
    public AggregatingModelLoadingListener(IControl... controls) {
        this.controls = controls;
    }
    
    @Override
    public void initialize() {
    }
    
    /**
     * Adds the listeners.
     * 
     * @param listeners the listeners
     */
    public void addListeners(IAggregatableListener... listeners) {
        for (IAggregatableListener listener : listeners) {
            state.put(listener, null);
        }
        for (IAggregatableListener listener : listeners) {
            listener.initialize();
        }
    }

    @Override
    public synchronized void setEnabled(IAggregatableListener key, boolean enabled) {
        if (null != key) {
            state.put(key, enabled);
            boolean allEnabled = true;
            for (Map.Entry<IAggregatableListener, Boolean> ent : state.entrySet()) {
                if (ent.getValue() != Boolean.TRUE) {
                    allEnabled = false;
                    break;
                }
            }
            for (IControl control : controls) {
                control.setEnabled(this, allEnabled);
            }
        }
    }
    
    /**
     * Disposes all aggregating listeners.
     */
    public void dispose() {
        for (IAggregatableListener listener : state.keySet()) {
            listener.dispose();
        }
    }

}
