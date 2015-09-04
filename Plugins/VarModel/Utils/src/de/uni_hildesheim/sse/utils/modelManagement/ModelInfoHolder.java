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

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.utils.modelManagement.IModelLoader.IModelInfoHolder;

/**
 * An implementation of the model info holder for internal use.
 * 
 * @param <M> the specific type of model
 * 
 * @author Holger Eichelberger
 */
class ModelInfoHolder <M extends IModel> implements IModelInfoHolder<M> {

    private Map<URI, ModelInfo<M>> knownURI = new HashMap<URI, ModelInfo<M>>();
    private List<ModelInfo<M>> result = new ArrayList<ModelInfo<M>>();
    
    /**
     * Creates an instance from the currently available model.
     * 
     * @param availableModels the available models
     */
    ModelInfoHolder(AvailableModels<M> availableModels) {
        for (List<VersionedModelInfos<M>> info : availableModels.versionedModelInfos()) {
            for (int i = 0; i < info.size(); i++) {
                VersionedModelInfos<M> vInfo = info.get(i);
                for (int v = 0; v < vInfo.size(); v++) {
                    ModelInfo<M> pInfo = vInfo.get(v);
                    knownURI.put(pInfo.getLocation(), pInfo);
                }
            }
        } 
    }

    @Override
    public void addResult(ModelInfo<M> toAdd) {
        result.add(toAdd);
    }

    @Override
    public boolean isKnown(URI uri, IModelLoader<M> loader) {
        ModelInfo<M> info = knownURI.get(uri);
        if (null != info) {
            info.updateModelLoader(loader);
        }
        return null != info;
    }
    
    /**
     * Returns the resulting model information instances.
     * 
     * @return the resulting instances
     */
    public int getResultCount() {
        return result.size();
    }
    
    /**
     * Returns the the specified result.
     * 
     * @param index the index of the result
     * @return the result instance
     * @throws IndexOutOfBoundsException if 
     *     <code>index&lt;0 || index&gt;={@link #getResultCount()}</code>
     */
    public ModelInfo<M> getResult(int index) {
        return result.get(index);
    }
    
    @Override
    public void error(String message) {
        // currently unimplemented
    }

}
