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
import net.ssehub.easy.instantiation.core.model.vilTypes.Map;
import net.ssehub.easy.instantiation.core.model.vilTypes.ParameterMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReturnGenerics;
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
    @ReturnGenerics(IFileSystemArtifact.class)
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

    /**
     * Not really a touch, but an instantiation type that causes problems if the incoming double
     * is actually a decision variable.
     * 
     * @param values the values
     * @return the sum of the doubles in the mapping
     */
    public static double touch(
        @ParameterMeta(generics = {String.class, Double.class})
        Map<String, Double> values) {
        double result = 0.0;
        for (String k : values.keys()) {
            result += values.get(k);
        }
        return result;
    }

}
