package de.uni_hildesheim.sse.utils.modelManagement;

import java.io.File;
import java.net.URI;
import java.util.List;

import de.uni_hildesheim.sse.utils.messages.IMessage;
import de.uni_hildesheim.sse.utils.messages.Status;

/**
 * Defines the interface for a mechanism being able to load models.
 * 
 * @param <M> the specific type of the model
 * 
 * @author Holger Eichelberger
 */
public interface IModelLoader<M extends IModel> {

    /**
     * Represents the result of loading a model.
     * 
     * @param <M> the specific type of the model
     * 
     * @author Holger Eichelberger
     */
    public static class LoadResult<M extends IModel> {
        private List<M> models;
        private List<IMessage> messages;
        
        /**
         * Creates a result instance.
         * 
         * @param models the loaded models
         * @param messages the messages which occurred (may be <b>null</b>)
         */
        public LoadResult(List<M> models, List<IMessage> messages) {
            this.models = models;
            this.messages = messages;
        }
        
        /**
         * Returns the number of loaded models.
         * 
         * @return the number of loaded models
         */
        public int getModelCount() {
            return null == models ? 0 : models.size();
        }
        
        /**
         * Returns the specified model.
         * 
         * @param index the index of the model to return
         * @return the specified model
         * @throws IndexOutOfBoundsException if 
         *   <code>index&lt;0 || index&gt;={@link #getModelCount()}</code>
         */
        public M getModel(int index) {
            if (null == models) {
                throw new IndexOutOfBoundsException();
            }
            return models.get(index);
        }
        
        /**
         * Returns the number of errors in the stored messages.
         * 
         * @return the number of errors
         */
        public int getErrorCount() {
            int count = 0;
            if (null != messages) {
                for (int i = 0; i < messages.size(); i++) {
                    if (Status.ERROR == messages.get(i).getStatus()) {
                        count++;
                    }
                }
            }
            return count;
        }
        
        /**
         * Returns the number of messages occurred during loading.
         * 
         * @return the number of messages messages
         */
        public int getMessageCount() {
            return null == messages ? 0 : messages.size();
        }
        
        /**
         * Returns the specific message.
         * 
         * @param index the index of the message
         * @return the message
         * @throws IndexOutOfBoundsException if <code>index&lt;0 || index&gt;={@link #getMessageCount()}</code>
         */
        public IMessage getMessage(int index) {
            if (null == messages) {
                throw new IndexOutOfBoundsException();
            }
            return messages.get(index);
        }
    }
    
    /**
     * Loads the related model.
     * 
     * @param info the model to be loaded (as information object)
     * @return the loaded model (or <b>null</b> in case of problems)
     */
    public LoadResult<M> load(ModelInfo<M> info);
    
    /**
     * Scans a file for model information.
     * 
     * @param location the file to be scanned
     * @param holder an instance providing limited access to the model information storage
     */
    public void scan(File location, IModelInfoHolder<M> holder);

    /**
     * An instance providing limited access to model information.
     * 
     * @param <M> the specific type of the model
    *
     * @author Holger Eichelberger
     */
    public interface IModelInfoHolder<M extends IModel> {
        
        /**
         * Adds a model information as result of an operation.
         * 
         * @param toAdd the information object to add
         */
        public void addResult(ModelInfo<M> toAdd);
        
        /**
         * Checks whether model information for a given URI is known.
         * 
         * @param uri the URI to check
         * @param loader update the loader in case of unspecified loader
         * @return <code>true</code> if it is known, <code>false</code> else
         */
        public boolean isKnown(URI uri, IModelLoader<M> loader);
        
        /**
         * Notifies about an error.
         * 
         * @param message the error message
         */
        public void error(String message);
        
    }
    
}
