package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Implements a static instantiator for testing.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("staticInstantiator")
public class StaticInstantiator implements IVilType {
    
    /**
     * Instantiates a file artifact.
     * 
     * @param file the file to be instantiated
     * @return the instantiated files
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> staticInstantiator(FileArtifact file) {
        return ArraySet.empty(FileArtifact.class);
    }

    /**
     * Shall not be visible.
     */
    public void shallNotBeVisible() {
    }

}
