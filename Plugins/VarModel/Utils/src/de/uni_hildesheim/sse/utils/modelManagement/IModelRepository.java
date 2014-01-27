package de.uni_hildesheim.sse.utils.modelManagement;

import java.net.URI;
import java.util.List;

import de.uni_hildesheim.sse.utils.messages.IMessage;

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
     * Loads the model related to <code>info</code>.
     * 
     * @param info the model info to load the model for
     * @param messages the messages collected so far (modified as a side effect)
     * @return the loaded model or <b>null</b>
     */
    public M load(ModelInfo<M> info, List<IMessage> messages);

    /**
     * Returns a known model information object via its URI.
     *
     * @param name the name of the model to search for
     * @param version the version of the model to search for
     * @param uri the URI to search for
     * @return the related model information object (or <b>null</b> if not found)
     */
    public ModelInfo<M> getModelInfo(String name, Version version, URI uri);

}
