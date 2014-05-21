package de.uni_hildesheim.sse.model.management;

import java.io.IOException;

import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.modelManagement.ImportResolver;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagement;

/**
 * The variability model, the central class holding all project instances and being
 * responsible for import resolution. Model loading is done by plugins of type 
 * {@link de.uni_hildesheim.sse.utils.modelManagement.IModelLoader}. Public access shall be 
 * synchronized (in any way) as multiple
 * source parts and tools may access the information concurrently. Please note that specific
 * information and settings are available via {@link #availableModels()}, {@link #comments()}, 
 * {@link #events()}, {@link #loaders()}, {@link #locale()} and {@link #locations()}.
 * The variability model needs a loader and a location to operate. After providing this 
 * information, available IVML projects can be accessed via {@link #availableModels()}.
 * 
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public class VarModel extends ModelManagement<Project> {
    
    // for optimizing speed we may consider letting the loaders store their individual part of the index 
    
    /**
     * Stores the singleton instance.
     */
    public static final VarModel INSTANCE = new VarModel();

    private static ImportResolver<Project> resolver = new DefaultImportResolver();
    
    private ModelCommentsPersistencer comments;
        
    /**
     * Singleton.
     */
    private VarModel() {
        comments = new ModelCommentsPersistencer(repository());
    }

    /**
     * Defines the new top-level resolver.
     * 
     * @param newResolver the new top-level resolver
     */
    public static void setResolver(ImportResolver<Project> newResolver) {
        if (null != newResolver) {
            resolver = newResolver;
        }
    }
    
    /**
     * Returns the top-level resolver.
     * 
     * @return the top-level resolver
     */
    public static ImportResolver<Project> getResolver() {
        return resolver;
    }
    
    /**
     * Returns the current top-level resolver.
     * 
     * @return the top-level resolver
     */
    protected ImportResolver<Project> getTopLevelResolver() {
        return resolver;
    }

    /**
     * Provides access to the comments persistencer. For future compatibility, 
     * please store the returned instance just for temporary purposes within a method and 
     * not for long-term use in an attribute etc.
     * 
     * @return the events object
     */
    public ModelCommentsPersistencer comments() {
        return comments;
    }
    
    /**
     * Additional code to be executed after a model was loaded. 
     * 
     * @param info the information object describing the model
     * @throws IOException in case that loading fails - however, model loading will not fail
     */
    @Override
    protected void postLoadModel(ModelInfo<Project> info) throws IOException {
        comments.loadComments(info);
    }

}
