package net.ssehub.easy.instantiation.core.model.artifactModel;

import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Provides access to the type descriptors of the types defined in this package.
 * 
 * @author Holger Eichelberger
 */
public class ArtifactTypes {

    /**
     * Utility class.
     * 
     */
    private ArtifactTypes() {
    }
    
    /**
     * Returns the type descriptor for the built-in type 'Artifact'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> artifactType() {
        return TypeRegistry.DEFAULT.getType(IArtifact.class);
    }

    /**
     * Returns the type descriptor for the built-in type 'Path'.
     * 
     * @return the type descriptor
     */
    public static final TypeDescriptor<?> pathType() {
        return TypeRegistry.DEFAULT.getType(Path.class);
    }

}
