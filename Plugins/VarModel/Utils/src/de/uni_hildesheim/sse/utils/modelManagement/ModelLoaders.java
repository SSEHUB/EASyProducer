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
package de.uni_hildesheim.sse.utils.modelManagement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Manages the model loaders. This class is not intended to be instantiated directly rather than
 * being created from {@link ModelManagement}. 
 * 
 * @param <M> the specific type of model
 * 
 * @author Holger Eichelberger
 */
public class ModelLoaders <M extends IModel> {

    private List<IModelLoader<M>> loaders = new ArrayList<IModelLoader<M>>();
    private IModelManagementRepository<M> repository;

    /**
     * Prevents this class from being instantiated from outside this package.
     * 
     * @param repository the model management repository for callbacks
     */
    ModelLoaders(IModelManagementRepository<M> repository) {
        this.repository = repository;
    }
    
    /**
     * Scans all locations for model information objects.
     * 
     * @param location the location to scan
     * @param holder the combined information and result collection instance
     */
    void scanAll(File location, ModelInfoHolder<M> holder) {
        for (int l = 0; l < loaders.size(); l++) {
            loaders.get(l).scan(location, holder);
        }        
    }
    
    /**
     * Returns whether the given <code>loader</code> is already registered.
     * @param loader the loader to check for
     * @return <code>true</code> if the loader is registered, <code>false</code> else
     */
    public synchronized boolean isRegistered(IModelLoader<M> loader) {
        return loaders.contains(loader);
    }
    
    /**
     * Registers a model loader and updates the model information
     * provided by the loader.
     * 
     * @param loader the model loader
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @throws ModelManagementException in case that the <code>loader</code> aims at loading 
     *   inconsistent information
     */
    public synchronized void registerLoader(IModelLoader<M> loader, ProgressObserver observer) 
        throws ModelManagementException {
        if (null != loader && !loaders.contains(loader)) {
            loaders.add(loader);
            repository.updateForLoader(loader, observer);
        }
    }
    
    /**
     * Unregisters a model loader.
     * 
     * @param loader the model loader
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     */
    public synchronized void unregisterLoader(IModelLoader<M> loader, ProgressObserver observer) {
        if (null != loader) {
            loaders.remove(loader);
        }
    }
    
    /**
     * Returns the number of loaders configured.
     * 
     * @return the number of loaders
     */
    public synchronized int getLoaderCount() {
        return loaders.size();
    }

}
