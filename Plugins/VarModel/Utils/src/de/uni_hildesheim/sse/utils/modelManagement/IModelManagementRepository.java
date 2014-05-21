package de.uni_hildesheim.sse.utils.modelManagement;

import java.io.File;

import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Defines the internal interface of a model management repository.
 * <b>This is subject to change!</b>
 * 
 * @param <M> the specific type of model
 * 
 * @author Holger Eichelberger
 */
public interface IModelManagementRepository <M extends IModel> {

    /**
     * Updates the model information in <code>file</code>.
     * 
     * @param file the location folder to search
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @throws ModelManagementException in case that the available information
     *   may be come inconsistent due to this update
     */
    public void updateModelInformation(File file, ProgressObserver observer) throws ModelManagementException;
    
    /**
     * Returns the loaders.
     * 
     * @return the loaders
     */
    public ModelLoaders<M> loaders();

    /**
     * Returns the model paths.
     * 
     * @return the model paths
     */
    public ModelPaths paths();
    
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
    public void updateForLoader(IModelLoader<M> loader, ProgressObserver observer) throws ModelManagementException;
    
    /**
     * Clears the location related information from the repository.
     * 
     * @param file the location
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     */
    public void clearLocation(File file, ProgressObserver observer);
    
    /**
     * Returns the model information object for the given model by considering resolved
     * models.
     *  
     * @param model the model to search an information object for which resolves <code>model</code>
     * @return the related model information object or <b>null</b> if there is none
     */
    public ModelInfo<M> getResolvedModelInfo(M model);
}
