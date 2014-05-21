package de.uni_hildesheim.sse.utils.modelManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * Prevents creation outside this package.
     */
    ModelEvents() {
    }
    
    /**
     * Notifies registered listeners about replacing a model instance. Changes
     * the listener registrations accordingly.
     * 
     * @param oldModel the old model being replaced
     * @param newModel the new model replacing <code>oldModel</code>
     */
    synchronized void notifyModelReplacement(M oldModel, M newModel) {
        assert null != oldModel;
        assert null != newModel;
        
        if (oldModel != newModel) {
            List<IModelListener<M>> oldListeners = modelListeners.get(oldModel);
            if (null != oldListeners) {
                // are listeners registered (if not, do nothing)
                int size = oldListeners.size();
                // inform listeners
                for (int l = 0; l < size; l++) {
                    oldListeners.get(l).notifyReplaced(oldModel, newModel);
                }
                // change listeners
                List<IModelListener<M>> newListeners = modelListeners.get(newModel);
                if (null == newListeners) {
                    // if no new listeners (usually the case), just relink
                    modelListeners.put(newModel, oldListeners);
                } else {
                    // otherwise add old
                    newListeners.addAll(oldListeners);
                }
                // remove old registration
                modelListeners.remove(oldModel);
            }
        }
    }
    
    /**
     * Removes all listeners.
     * 
     * @param model the model to remove all listeners for
     */
    void removeAllListeners(M model) {
        modelListeners.remove(model);
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
        assert null != model;
        assert null != listener;

        List<IModelListener<M>> listeners = modelListeners.get(model);
        if (null == listeners) {
            listeners = new ArrayList<IModelListener<M>>();
            modelListeners.put(model, listeners);
        }
        listeners.add(listener);
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
        assert null != model;
        assert null != listener;
        
        boolean removed = false;
        List<IModelListener<M>> listeners = modelListeners.get(model);
        if (null != listeners) {
            removed = listeners.remove(listener);
        }
        return removed;
    }

}
