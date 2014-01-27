package de.uni_hildesheim.sse.utils.modelManagement;

import java.net.URI;
import java.util.List;

/**
 * Model paths are similar to classpaths. Currently, this class is not implemented but represents the concept.
 * Instances of this class cannot be created directly rather than being obtained from {@link ModelManagement}.
 * 
 * @author Holger Eichelberger
 */
public class ModelPaths {

    /**
     * Prevents from creating instances from outside this package.
     */
    ModelPaths() {
    }
    
    /**
     * Returns the model path for a given URI.
     * 
     * @param uri the URI pointing to the model path
     * @return the model path (always <b>null</b>)
     */
    public List<String> getModelPath(URI uri) {
        // currently we do not have model paths ;)
        return null;
    }

}
