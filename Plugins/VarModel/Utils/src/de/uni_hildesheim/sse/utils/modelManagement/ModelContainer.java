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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.utils.internal.Bundle;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;


/**
 * Extended capabilities for {@link Model}s.
 * @param <M> the specific model type
 * @author El-Sharkawy
 */
public abstract class ModelContainer<M extends IModel> implements IModelListener<M>, IModelData {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(
        ModelContainer.class, Bundle.ID); 
    
    /**
     * Data class for describing semantic errors occurred during parsing a Model file.
     * @author El-Sharkawy
     *
     */
    public static class SemanticErrorDescription {
        private String location;
        private String description;
        
        /**
         * Sole constructor for this class.
         * @param location The location of the parsed file (could be a URI or a path in the file system).
         * @param description Description of the error occurred during parsing.
         */
        public SemanticErrorDescription(String location, String description) {
            this.location = location;
            this.description = description;
        }
        
        /**
         * Getter for the location of the file.
         * @return The location of the parsed/loaded file.
         */
        public String getLocation() {
            return location;
        }
        
        /**
         * Getter for the error description.
         * @return A message describing the parser error. 
         */
        public String getDescription() {
            return description;
        }
    }

    /**
     * The model which should be managed by this container.
     */
    private M model;
    
    /**
     * A optional description of exceptions, caught during parsing the model.
     */
    private SemanticErrorDescription description;
    
    /**
     * The container holding and managing all models of type &lt;M&gt;.
     */
    private ModelManagement<M> modelManager;
    
    /**
     * The location (folder) of the managed model.
     */
    private File folder;
    
    /**
     * Optional {@link IModelListener} for getting informed whenever the managed model was replaced by the parser. 
     */
    private IModelListener<M> listener;
    
    /**
     * Default constructor of this class.
     * @param model The model, which should be managed by this container.
     * @param modelManager The container holding and managing all models of type &lt;M&gt;.
     * @param folder The location (folder) of the managed model.
     */
    public ModelContainer(M model, ModelManagement<M> modelManager, File folder) {
        this(model, null, modelManager, folder);
    }

    /**
     * Constructor if an Exception occurred during parsing the model.
     * The model can be used but not be saved, as long the semantic error is not solved.
     * @param model The model, which should be managed by this container.
     * @param description A description of an occurred semantic error while parsing the model.
     *     Can be <tt>null</tt>, then this constructor has the same behavior as {@link #ModelContainer(IModel)}.
     * @param modelManager The container holding and managing all models of type &lt;M&gt;.
     * @param folder The location (folder) of the managed model.
     */
    public ModelContainer(M model, SemanticErrorDescription description, ModelManagement<M> modelManager,
        File folder) {
        
        this.model = model;
        this.description = description;
        this.modelManager = modelManager;
        this.folder = folder;
        modelManager.events().addModelListener(model, this);
    }

    /**
     * Getter for the model.
     * @return Returns the managed model.
     */
    public M getModel() {
        return model;
    }
    
    /**
     * {@inheritDoc}
     */
    public Version getVersion() {
        Version version = null;
        if (null != model) {
            version = model.getVersion();
        }
        
        return version;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getName() {
        return model.getName();
    }
    
    /**
     * Returns the location, where the model is loaded from.
     * @return The location of the loaded model.
     */
    public File getLocation() {
        return folder;
    }
    
    /**
     * Getter for the {@link SemanticErrorDescription} (describing a caught exception).
     * @return The {@link SemanticErrorDescription} (describing a caught exception), or <tt>null</tt> if the model
     * has no semantic errors (i.e. parser errors).
     */
    public SemanticErrorDescription getDescription() {
        return description;
    }
    
    /**
     * Checks whether the model works and can be saved, or if a dummy was used to avoid {@link NullPointerException}s.
     * @return <tt>true</tt> if a loaded model is used and can be saved, <tt>false</tt> if a dummy was used, which
     * should not be saved.
     */
    public boolean isSaveable() {
        return null == description;
    }
    
    /**
     * {@inheritDoc}
     * If this method is called, the stored {@link #getDescription()} will be set to <tt>null</tt> as this is
     * usually only called if the parser has parsed the model successfully.
     */
    public void notifyReplaced(M oldModel, M newModel) {
        this.model = newModel;
        description = null;
        
        // inform optional listener of this container.
        if (null != listener) {
            listener.notifyReplaced(oldModel, newModel);
        }
    }
    
    /**
     * Returns the highest Version that is available for the managed model.
     * @return The highest version that exists within all models stored at the same configFolder
     *     (or <tt>null</tt> if no model exists).
     * @see #listAvailableModels()
     */
    public Version getHighestVersion() {
        Version highest = null;
        
        for (ModelInfo<M> models : listAvailableModels()) {
            if (highest == null) {
                highest = models.getVersion();
            } else {
                if (models.getVersion().compareTo(highest) == 1) {
                    highest = models.getVersion();
                }
            }
        }
        
        return highest;
    }
    
    /**
     * Returns a list with all (alternative) models of this model.
     * @return A list with all (alternative) models of this model.
     * @see #setMainModel(ModelInfo)
     */
    public List<ModelInfo<M>> listAvailableModels() {
        List<ModelInfo<M>> availableModels = new ArrayList<ModelInfo<M>>();
        
        List<ModelInfo<M>> infos = modelManager.availableModels().getVisibleModelInfo(folder.toURI());
    
        for (int i = 0; i < infos.size(); i++) {           
            if (infos.get(i).getName().equals(model.getName())) {
                availableModels.add(infos.get(i));
            }          
        }
        
        return availableModels;
    }
    
    /**
     * Changes the managed Model. The model should be add the specified location ({@link #getLocation()}.
     * @param newMainModel The model that should be used by this container.
     * @see #listAvailableModels()
     */
    public void setMainModel(ModelInfo<M> newMainModel) {
        if (this.listAvailableModels().contains(newMainModel)) {
            if (null == newMainModel.getResolved()) {
                try {
                    modelManager.load(newMainModel);
                } catch (ModelManagementException exc) {
                    LOGGER.exception(exc);
                }
            }
        }
    }
    
    /**
     * Sets the {@link IModelListener} for the managed model, to get informed when the model was replaced by the parser.
     * @param listener A listener for the managed model.
     * @see #unregisterModelListener()
     */
    public void registerModelListener(IModelListener<M> listener) {
        this.listener = listener;
    }
    
    /**
     * Removes the registered {@link IModelListener}.
     * @see #registerModelListener(IModelListener)
     */
    public void unregisterModelListener() {
        this.listener = null;
    }
}
