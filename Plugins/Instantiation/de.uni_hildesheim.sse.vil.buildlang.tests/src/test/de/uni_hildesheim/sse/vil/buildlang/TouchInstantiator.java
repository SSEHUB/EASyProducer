package test.de.uni_hildesheim.sse.vil.buildlang;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IFileSystemArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySet;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

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
     * @throws VilException in case that the execution fails
     */
    @OperationMeta(returnGenerics = IFileSystemArtifact.class)
    public static Set<IArtifact> touch(IFileSystemArtifact artifact) throws VilException {
        File file = artifact.getPath().getAbsolutePath();
        try {
            FileUtils.touch(file);
        } catch (IOException e) {
            throw new VilException(e.getMessage(), VilException.ID_IO);
        }
        IArtifact[] result = new IArtifact[1];
        result[0] = artifact;
        return new ArraySet<IArtifact>(result, IArtifact.class);
    }

}
