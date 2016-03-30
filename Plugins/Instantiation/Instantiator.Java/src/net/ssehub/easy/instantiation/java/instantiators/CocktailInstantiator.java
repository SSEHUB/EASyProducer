package net.ssehub.easy.instantiation.java.instantiators;

import java.io.File;

import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySet;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Project;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;
import net.ssehub.easy.instantiation.java.artifacts.JavaFileArtifact;

/**
 * The SAP cocktail instantiator.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("cocktailInstantiator") 
public class CocktailInstantiator implements IVilType {

 // TODO this is not a default instantiator but simplifies things for the moment
 // if not required at all, move into tests
    
    /**
     * Does the standard job of the cocktain instantiator.
     * 
     * @param target the target project
     * 
     * @return the created artifacts
     * @throws VilException in case that something fails
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> cocktailInstantiator(Project target) throws VilException {
        FileArtifact[] result = new FileArtifact[1];
        // just pretend that something was created - otherwise script will fail
        result[0] = ArtifactFactory.createArtifact(FileArtifact.class, 
            new File(target.getPath().getAbsolutePath(), "bin/test.class"), target.getArtifactModel());
        return new ArraySet<FileArtifact>(result, FileArtifact.class);
    }
    
    /**
     * Compiles <code>source</code> to <code>target</code>.
     * 
     * @param artifacts the artifacts to process
     * @param resolution the cocktail resolution file
     * @return the created artifacts
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> cocktailInstantiator(Collection<JavaFileArtifact> artifacts, 
        FileArtifact resolution) {
        return ArraySet.empty(FileArtifact.class);
    }

}
