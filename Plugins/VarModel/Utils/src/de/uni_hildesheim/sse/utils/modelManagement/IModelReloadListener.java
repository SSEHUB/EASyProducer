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
package de.uni_hildesheim.sse.utils.modelManagement;

/**
 * Defines a model listener in order to inform interested parties about
 * model reloads. Currently, this class does only notify
 * about failed reloads as successful updates are notified via {@link IModelListener}.
 * 
 * @param <M> the model type
 * 
 * @author Holger Eichelberger
 */
public interface IModelReloadListener <M extends IModel> {

    /**
     * Is called to notify that <code>model</code> was not successfully reloaded, e.g., due to syntactic or semantic
     * errors. Please note that successful reloads are notified through {@link IModelListener}.
     * 
     * @param model the model that was not updated
     */
    public void notifyReloadFailed(M model);

}
