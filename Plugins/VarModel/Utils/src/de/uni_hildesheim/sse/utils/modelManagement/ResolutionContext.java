package de.uni_hildesheim.sse.utils.modelManagement;

import java.net.URI;
import java.util.List;

/**
 * Defines an internal class representing the context of a model import resolution.
 *  
 * @param <M> the specific model type
 * @author Holger Eichelberger
 */
class ResolutionContext <M extends IModel> {
    
    private IModelRepository<M> repository;
    private ModelPaths paths;
    private M model;
    private ModelImport<M> toResolve;
    private URI modelUri;
    private List<ModelInfo<M>> inProgress;

    /**
     * Creates a resolution context.
     * 
     * @param model the model for which the import resolution happens
     * @param modelUri the URI to <code>model</code> (may be <b>null</b>)
     * @param context the parent contexts
     */
    public ResolutionContext(M model, URI modelUri, ResolutionContext<M> context) {
        this(model, modelUri, context.inProgress, context.repository, context.paths);
    }
    
    /**
     * Creates a resolution context.
     * 
     * @param model the model for which the import resolution happens
     * @param modelUri the URI to <code>model</code> (may be <b>null</b>)
     * @param inProgress the models being processed at once with <code>model</code>
     * @param repository the repository
     * @param paths the model paths
     */
    public ResolutionContext(M model, URI modelUri, List<ModelInfo<M>> inProgress, 
        IModelRepository<M> repository, ModelPaths paths) {
        this.model = model;
        this.modelUri = modelUri;
        this.inProgress = inProgress;
        this.repository = repository;
        this.paths = paths;
    }
    
    /**
     * Changes the actual import for resolution.
     * 
     * @param toResolve the actual import
     */
    public void setToResolve(ModelImport<M> toResolve) {
        this.toResolve = toResolve;
    }
    
    /**
     * Returns the actual import for resolution.
     * 
     * @return the actual import
     */
    public ModelImport<M> getToResolve() {
        return toResolve;
    }
    
    /**
     * Returns the URI to {@link #model}.
     * 
     * @return the URI (may be <b>null</b>)
     */
    public URI getModelURI() {
        return modelUri;
    }
    
    /**
     * Returns the model defining the context.
     * 
     * @return the model
     */
    public M getModel() {
        return model;
    }
    
    /**
     * Returns the model repository.
     * 
     * @return the model repository
     */
    public IModelRepository<M> getModelRepository() {
        return repository;
    }
    
    /**
     * Returns the model paths.
     * 
     * @return the model paths
     */
    public ModelPaths getModelPaths() {
        return paths;
    }
    
    /**
     * Returns whether loading <code>info</code> would cause in infinite
     * loop in type resolution as it is currently being processed in the
     * same resolution context.
     * 
     * @param info the information object to be checked
     * @return <code>true</code> if it would cause a loop, <code>false</code> else
     */
    public boolean isLoop(ModelInfo<M> info) {
        boolean isLoop = false;
        if (null != inProgress) {
            int size = inProgress.size();
            for (int i = 0; !isLoop && i < size; i++) {
                isLoop = Utils.matches(info, inProgress.get(i));
            }
        }
        return isLoop;
    }
    
}
