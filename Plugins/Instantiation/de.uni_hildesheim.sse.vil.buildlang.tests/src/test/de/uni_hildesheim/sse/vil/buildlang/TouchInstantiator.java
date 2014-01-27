package test.de.uni_hildesheim.sse.vil.buildlang;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IFileSystemArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * A simple touch-Instantiator.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("touch")
public class TouchInstantiator implements IVilType {
    
    /**
     * Just touches the given artifact.
     * 
     * @param artifact the artifact to be touched 
     * @return the touched artifact(s)
     * @throws ArtifactException in case that the execution fails
     */
    @OperationMeta(returnGenerics = IFileSystemArtifact.class)
    public static Set<IArtifact> touch(IFileSystemArtifact artifact) throws ArtifactException {
        File file = artifact.getPath().getAbsolutePath();
        try {
            FileUtils.touch(file);
        } catch (IOException e) {
            throw new ArtifactException(e.getMessage(), ArtifactException.ID_IO);
        }
        IArtifact[] result = new IArtifact[1];
        result[0] = artifact;
        return new ArraySet<IArtifact>(result, IArtifact.class);
    }

}
