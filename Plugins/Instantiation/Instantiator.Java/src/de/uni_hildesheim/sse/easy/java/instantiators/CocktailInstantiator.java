package de.uni_hildesheim.sse.easy.java.instantiators;

import java.io.File;

import de.uni_hildesheim.sse.easy.java.artifacts.JavaFileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Project;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

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
     * @throws ArtifactException in case that something fails
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> cocktailInstantiator(Project target) throws ArtifactException {
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
