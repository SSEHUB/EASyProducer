/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
 * changes within a model instance. Currently, this class does only notify
 * about the internal replacement of an entire model instance as the editor
 * does not support incremental model updates.
 * 
 * @param <M> the model
 * 
 * @author Holger Eichelberger
 */
public interface IModelListener<M extends IModel> {

    /**
     * Is called to notify that <code>oldModel</code> is replaced by 
     * <code>newModel</code>. The listener registrations for 
     * <code>oldModel</code> will be adjusted accordingly.<br/>
     * Do not modify the the listeners of <code>oldModel</code> or <code>newModel</code>
     * during this method.
     * 
     * @param oldModel the old model being replaced
     * @param newModel the new model (the replacement)
     */
    public void notifyReplaced(M oldModel, M newModel);
    
}
