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
package net.ssehub.easy.basics.modelManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.modelManagement.IModelProcessingListener.Type;

/**
 * Notifications on model contents changes.
 * Instances of this class cannot be created directly rather than being obtained from {@link ModelManagement}.
 * 
 * @param <M> the specific type of model
 * 
 * @author Holger Eichelberger
 */
public class ModelEvents <M extends IModel> {

    private Map<M, List<IModelListener<M>>> modelListeners 
        = new HashMap<M, List<IModelListener<M>>>();

    private Map<M, List<IModelReloadListener<M>>> modelReloadListeners 
        = new HashMap<M, List<IModelReloadListener<M>>>();
    
    private Map<ModelInfo<M>, List<IModelProcessingListener<M>>> modelProcessingListeners
        = new HashMap<ModelInfo<M>, List<IModelProcessingListener<M>>>();
    
    /**
     * Prevents creation outside this package.
     */
    ModelEvents() {
    }
    
    /**
     * Notifies registered listeners about a failed model reload. 
     * 
     * @param model the model that cannot be reloaded
     */
    synchronized void notifyModelReloadFailed(M model) {
        if (null != model) {
            List<IModelReloadListener<M>> listeners = modelReloadListeners.get(model);
            if (null != listeners) {
                for (int l = 0; l < listeners.size(); l++) {
                    listeners.get(l).notifyReloadFailed(model);
                }
            }
        }
    }

    /**
     * Notifies about model processing events.
     * 
     * @param info the model information object
     * @param start whether processing started or ended
     * @param type the type of the processing
     */
    public synchronized void notifyModelProcessing(ModelInfo<M> info, boolean start, Type type) {
        if (null != info) {
            List<IModelProcessingListener<M>> listeners = modelProcessingListeners.get(info);
            if (null != listeners) {
                for (int l = 0; l < listeners.size(); l++) {
                    IModelProcessingListener<M> listener = listeners.get(l); 
                    if (start) {
                        listener.notifyProcessingStarted(info, type);
                    } else {
                        listener.notifyProcessingEnded(info, type);
                    }
                }
            }
        }        
    }
    
    /**
     * Notifies registered listeners about replacing a model instance. Changes
     * the listener registrations accordingly.
     * 
     * @param oldModel the old model being replaced
     * @param newModel the new model replacing <code>oldModel</code>
     */
    synchronized void notifyModelReplacement(M oldModel, M newModel) {
        List<IModelListener<M>> oldListeners = modelListeners.get(oldModel);
        if (null != oldListeners) {
            // are listeners registered (if not, do nothing)
            // inform listeners
            for (int l = 0; l < oldListeners.size(); l++) {
                oldListeners.get(l).notifyReplaced(oldModel, newModel);
            }
            // change listeners of both types
            if (oldModel != newModel) {
                updateListeners(modelListeners.get(oldModel), modelListeners, oldModel, newModel);
                updateListeners(modelReloadListeners.get(oldModel), modelReloadListeners, oldModel, newModel);
            }
        }
    }
    
    /**
     * Updates the listeners if a model is replaced. Otherwise the listeners
     * would listen to the wrong model.
     *
     * @param <T> the listener type
     * @param oldListeners list of listeners that were listening to the old model
     * @param listeners map of all listeners currently registered 
     * @param oldModel the old model being replaced
     * @param newModel the new model replacing <code>oldModel</code>l
     */
    private <T> void updateListeners(List<T> oldListeners, Map<M, List<T>> listeners, M oldModel, M newModel) {
        if (oldListeners != null) {
            // change listeners
            List<T> newListeners = listeners.get(newModel);
            if (null == newListeners) {
                // if no new listeners (usually the case), just relink
                listeners.put(newModel, oldListeners);
            } else {
                // otherwise add old
                newListeners.addAll(oldListeners);
            }
            // remove old registration
            listeners.remove(oldModel);
        }
    } 
    
    /**
     * Removes all listeners (no processing listeners).
     * 
     * @param model the model to remove all listeners for
     */
    void removeAllListeners(M model) {
        modelListeners.remove(model);
        modelReloadListeners.remove(model);
    }
    
    /**
     * Adds a model listener for the specified model.
     * Note that notifications about models will only be issued
     * if the model was added to this instance by 
     * {@link ModelManagement#updateModel(IModel, java.net.URI, IModelLoader)} before. A listener may be added
     * multiple times (whyever).
     * 
     * @param model the model to add the listener for
     * @param listener the listener
     */
    public synchronized void addModelListener(M model, IModelListener<M> listener) {
        add(model, modelListeners, listener);
    }
    
    /**
     * Adds a model processing listener for the specified model information object.
     * 
     * @param info the information object to be informed about
     * @param listener the listener
     */
    public synchronized void addProcessingListener(ModelInfo<M> info, IModelProcessingListener<M> listener) {
        add(info, modelProcessingListeners, listener);
    }

    /**
     * Removes a model listener from the specified model.
     * 
     * @param model the model to remove the listener from
     * @param listener the listener
     * @return <code>true</code> if the <code>listener</code> was removed, 
     *   <code>false</code> if not (for any reason)
     */
    public synchronized boolean removeModelListener(M model, IModelListener<M> listener) {
        return remove(model, modelListeners, listener);
    }
    
    /**
     * Adds a model reload listener for the specified model.
     * Note that notifications about models will only be issued
     * if the model was reloaded by {@link ModelManagement#reload(IModel)}. A listener may be added
     * multiple times (whyever).
     * 
     * @param model the model to add the listener for
     * @param listener the listener
     */
    public synchronized void addReloadListener(M model, IModelReloadListener<M> listener) {
        add(model, modelReloadListeners, listener);
    }

    /**
     * Removes a model reload listener from the specified model.
     * 
     * @param model the model to remove the listener from
     * @param listener the listener
     * @return <code>true</code> if the <code>listener</code> was removed, 
     *   <code>false</code> if not (for any reason)
     */
    public synchronized boolean removeModelReloadListener(M model, IModelReloadListener<M> listener) {
        return remove(model, modelReloadListeners, listener);
    }
    
    /**
     * Removes a model processing listener for the specified model information object.
     * 
     * @param info the information object to be removed
     * @param listener the listener
     * @return <code>true</code> if the <code>listener</code> was removed, 
     *   <code>false</code> if not (for any reason)
     */
    public synchronized boolean removeProcessingListener(ModelInfo<M> info, IModelProcessingListener<M> listener) {
        return remove(info, modelProcessingListeners, listener);
    }

    /**
     * Adds the <code>listener</code> for <code>identifier</code> to <code>listeners</code>.
     * 
     * @param <T> the listener type
     * @param <I> the identifier type
     * 
     * @param identifier the identifier
     * @param listeners the listeners map
     * @param listener the listener to be removed
     */
    private static <T, I> void add(I identifier, Map<I, List<T>> listeners, T listener) {
        assert null != identifier;
        assert null != listener;

        List<T> tmp = listeners.get(identifier);
        if (null == tmp) {
            tmp = new ArrayList<T>();
            listeners.put(identifier, tmp);
        }
        tmp.add(listener);
    }
    
    /**
     * Removes the <code>listener</code> for <code>identifier</code> from <code>listeners</code>.
     * 
     * @param <T> the listener type
     * @param <I> the identifier type
     * 
     * @param identifier the identifier
     * @param listeners the listeners map
     * @param listener the listener to be removed
     * @return <code>true</code> if the <code>listener</code> was removed, 
     *   <code>false</code> if not (for any reason)
     */
    private static <T, I> boolean remove(I identifier, Map<I, List<T>> listeners, T listener) {
        assert null != identifier;
        assert null != listener;
        
        boolean removed = false;
        List<T> tmp = listeners.get(identifier);
        if (null != tmp) {
            removed = tmp.remove(listener);
        }
        return removed;        
    }

}
