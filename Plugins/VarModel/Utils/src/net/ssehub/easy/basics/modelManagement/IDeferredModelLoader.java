/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
 * Allows deferred loading of models, which require that functionality.
 * 
 * @param <M> the model type
 * @author Holger Eichelberger
 */
public interface IDeferredModelLoader <M extends IModel> {

    /**
     * Returns an ID of the model, e.g., its URI or its name. Used to identify this loader among 
     * multiple trials of loading the same model.
     * 
     * @return the ID
     */
    public String getModelId();
    
    /**
     * Completes loading in a deferred manner.
     * 
     * @param target cleanup target
     */
    public void completeLoading(IDeferredModelLoader<M> target);

}
