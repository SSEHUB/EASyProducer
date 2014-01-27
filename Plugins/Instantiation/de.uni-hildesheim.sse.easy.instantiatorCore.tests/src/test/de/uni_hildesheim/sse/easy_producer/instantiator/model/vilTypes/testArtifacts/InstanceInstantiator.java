package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactNotifier;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

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
