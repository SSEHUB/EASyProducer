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
import java.net.URI;
import java.util.List;

import de.uni_hildesheim.sse.utils.messages.IMessage;
import de.uni_hildesheim.sse.utils.modelManagement.ModelLocations.Location;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Implements the model repository interface by delegating to {@link ModelManagement}.
 * However, there are some methods that shall not directly be public in {@link ModelManagement} and
 * are, thus, hidden via delegation.
 * 
 * @param <M> the specific model type
 * 
 * @author Holger Eichelberger
 */
class ModelRepository <M extends IModel> implements IModelManagementRepository<M>, IModelRepository<M> {

    private ModelManagement<M> modelMgmt;
    
    /**
     * Creates a model repository.
     * 
     * @param modelMgmt the model management instance to delegate to
     */
    ModelRepository(ModelManagement<M> modelMgmt) {
        this.modelMgmt = modelMgmt;
    }
    
    @Override
    public List<VersionedModelInfos<M>> getAvailable(String name) {
        return modelMgmt.getAvailable(name);
    }

    @Override
    public boolean isOutdated(ModelInfo<M> info) {
        return modelMgmt.isOutdated(info);
    }

    @Override
    public M load(ModelInfo<M> info, List<IMessage> messages) {
        return modelMgmt.load(info, messages);
    }
    
    @Override
    public ModelInfo<M> getModelInfo(String name, Version version, URI uri) {
        return modelMgmt.availableModels().getModelInfo(name, version, uri);
    }
    
    /**
     * Updates the model information in <code>file</code>.
     * 
     * @param file the location folder to search
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @throws ModelManagementException in case that the available information
     *   may be come inconsistent due to this update
     */
    public void updateModelInformation(File file, ProgressObserver observer) throws ModelManagementException {
        modelMgmt.updateModelInformation(file, observer);
    }
    
    
    /**
     * Registers a model loader and updates the model information
     * provided by the loader.
     * 
     * @param loader the model loader (must not be <b>null</b>)
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @throws ModelManagementException in case that the <code>loader</code> aims at loading 
     *   inconsistent information
     */
    public synchronized void updateForLoader(IModelLoader<M> loader, ProgressObserver observer) 
        throws ModelManagementException {
        modelMgmt.updateForLoader(loader, observer);
    }
    
    /**
     * Returns the location for <code>uri</code>.
     * 
     * @param uri the URI to search for
     * @return the related location
     */
    public Location getLocationFor(URI uri) {
        return modelMgmt.locations().getLocationFor(uri);
    }
    
    /**
     * Returns the loaders.
     * 
     * @return the loaders
     */
    public ModelLoaders<M> loaders() {
        return modelMgmt.loaders();
    }
    
    /**
     * Returns the model paths.
     * 
     * @return the model paths
     */
    public ModelPaths paths() {
        return modelMgmt.paths();
    }

    /**
     * Removes a file location, i.e. a location from where models can be loaded.
     * 
     * @param file the file location (<b>null</b> is ignored)
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     */
    public synchronized void clearLocation(File file, ProgressObserver observer) {
        modelMgmt.clearLocation(file, observer);
    }
    
    /**
     * Returns the model information object for the given model by considering resolved
     * models.
     *  
     * @param model the model to search an information object for which resolves <code>model</code>
     * @return the related model information object or <b>null</b> if there is none
     */
    public synchronized ModelInfo<M> getResolvedModelInfo(M model) {
        return modelMgmt.availableModels().getResolvedModelInfo(model);            
    }

}
