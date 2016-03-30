package net.ssehub.easy.instantiation.core.model.vilTypes.testArtifacts;

import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifactNotifier;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySet;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * Implements a dynamic instantiator for testing.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("instanceInstantiator")
public class InstanceInstantiator implements IVilType, IArtifactNotifier {

    /**
     * Creates an instance instantiator.
     * 
     * @return the instantiator instance
     */
    public static InstanceInstantiator create() {
        return new InstanceInstantiator();
    }
    
    /**
     * Instantiates a file artifact.
     * 
     * @param file the file to be instantiated
     * @return the instantiated files
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public Set<FileArtifact> instanceInstantiator(FileArtifact file) {
        return ArraySet.empty(FileArtifact.class);
    }

    /**
     * Shall not be visible.
     */
    public void shallNotBeVisible() {
    }

    /**
     * Shall not be visible.
     * 
     * @param artifacts ignored
     */
    @Override
    public void notifyChanged(IArtifact... artifacts) {
    }

}
