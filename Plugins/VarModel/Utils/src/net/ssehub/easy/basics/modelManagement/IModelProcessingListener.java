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

/**
 * Defines the model processing listener interface, a listener that is informed when a certain model
 * is being processed. This interface is defined in terms of model information objects, because when loading the 
 * initial version of the model the model itself is not available.
 * 
 * See DSL-core for a simple generic implementation.
 * 
 * @param <M> the model type
 * @author Holger Eichelberger
 */
public interface IModelProcessingListener <M extends IModel> {

    /**
     * Processing types.
     * 
     * @author Holger Eichelberger
     */
    public enum Type {
        
        /**
         * Loading a model, i.e., parsing the model definition and turning it into the internal model implementation.
         */
        LOADING,
        
        /**
         * Model initialization phase in case that this is not already done by {@link #LOADING}.
         */
        INITIALIZING,
        
        /**
         * Refreshing the model contents.
         */
        REFRESHING,
        
        /**
         * Longer running calculation on the model contents.
         */
        CALCULATING,
        
        /**
         * Cleaning up a model.
         */
        DISPOSING;
        
    }
    
    /**
     * Is called when processing started (or shortly before).
     * 
     * @param info the model information
     * @param type the processing type
     */
    public void notifyProcessingStarted(ModelInfo<M> info, Type type);

    /**
     * Is called when processing ended (or shortly after).
     * 
     * @param info the model information
     * @param type the processing type
     */
    public void notifyProcessingEnded(ModelInfo<M> info, Type type);
    
}
