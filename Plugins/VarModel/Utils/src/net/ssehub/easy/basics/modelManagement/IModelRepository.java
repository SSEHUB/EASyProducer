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

import java.net.URI;
import java.util.List;

import net.ssehub.easy.basics.messages.IMessage;
import net.ssehub.easy.basics.modelManagement.ModelLocations.Location;

/**
 * Defines the interface of a model repository.
 * 
 * @param <M> the specific type of model
 * 
 * @author Holger Eichelberger
 */
public interface IModelRepository <M extends IModel> {

    /**
     * Returns models available for a given model <code>name</code>.
     * 
     * @param name the name to search for
     * 
     * @return the available model or <b>null</b>
     */
    public List<VersionedModelInfos<M>> getAvailable(String name);
    
    /**
     * Returns whether a model information is outdated.
     * 
     * @param info the object to be tested
     * @return <code>true</code> if it is outdated, <code>false</code> else
     */
    public boolean isOutdated(ModelInfo<M> info);

    /**
     * Loads the model related to <code>info</code> with a new default import resolver.
     * 
     * @param info the model info to load the model for
     * @param messages the messages collected so far (modified as a side effect)
     * @return the loaded model or <b>null</b>
     */
    public M load(ModelInfo<M> info, List<IMessage> messages);

    /**
     * Loads the model related to <code>info</code> with the given import resolver.
     * 
     * @param info the model info to load the model for
     * @param resolver the import resolver to use (<b>null</b> for a new default resolver)
     * @param messages the messages collected so far (modified as a side effect)
     * @return the loaded model or <b>null</b>
     */
    public M load(ModelInfo<M> info, ImportResolver<M> resolver, List<IMessage> messages);

    /**
     * Returns a known model information object via its URI.
     *
     * @param name the name of the model to search for
     * @param version the version of the model to search for
     * @param uri the URI to search for
     * @return the related model information object (or <b>null</b> if not found)
     */
    public ModelInfo<M> getModelInfo(String name, Version version, URI uri);

    /**
     * Returns the location for <code>uri</code>.
     * 
     * @param uri the URI to search for
     * @return the related location
     */
    public Location getLocationFor(URI uri);
    
}
