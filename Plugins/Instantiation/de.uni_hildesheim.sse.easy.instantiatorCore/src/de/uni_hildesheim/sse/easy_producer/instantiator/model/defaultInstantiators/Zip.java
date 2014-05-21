package de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Creates ZIP files.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("zip")
public class Zip implements IVilType {

    /**
     * Packs <code>source</code> files into <code>target</code>.
     * 
     * @param base the base path used to make the paths of the <code>artifacts</code> relative, may
     *   be the source or target project
     * @param artifacts the artifacts to be handled
     * @param zip the target zip file
     * @return the created artifacts
     * @throws ArtifactException in case that processing the JAR file fails for some reason
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> zip(Path base, Path artifacts, Path zip) throws ArtifactException {
        // needed as paths are typically expressed as strings and string->path->collection conversion is not supported
        return add(base, artifacts.selectAll(), zip, new ZipHandler());
    }
    
    /**
     * Packs <code>source</code> files into <code>target</code>.
     * 
     * @param base the base path used to make the paths of the <code>artifacts</code> relative, may
     *   be the source or target project
     * @param artifacts the artifacts to be handled
     * @param zip the target zip file
     * @return the created artifacts
     * @throws ArtifactException in case that processing the JAR file fails for some reason
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> zip(Path base, Collection<FileArtifact> artifacts, Path zip) 
        throws ArtifactException {
        return add(base, artifacts, zip, new ZipHandler());
    }

    /**
     * Packs <code>source</code> files into <code>target</code> using handler.
     * 
     * @param base the base path used to make the paths of the <code>artifacts</code> relative, may
     *   be the source or target project
     * @param artifacts the artifacts to be handled
     * @param target the target ZIP/JAR file
     * @param handler the actual ZIP handler
     * @return the created artifacts
     * @throws ArtifactException in case that processing the JAR file fails for some reason
     */
    @Invisible
    public static Set<FileArtifact> add(Path base, Collection<FileArtifact> artifacts, Path target, ZipHandler handler) 
        throws ArtifactException {
        List<File> files = toFileList(artifacts);
        List<File> zipResult;
        try {
            zipResult = handler.add(base.getAbsolutePath(), files, target.getAbsolutePath());
        } catch (IOException e) {
            throw new ArtifactException(e, ArtifactException.ID_IO);
        }
        return toFileArtifactSet(zipResult, target.getArtifactModel());
    }
    
    /**
     * Turns a collection of file artifacts into files.
     * 
     * @param artifacts the artifacts to be processed
     * @return the corresponding files
     */
    @Invisible
    public static final List<File> toFileList(Collection<FileArtifact> artifacts) {
        List<File> files = new ArrayList<File>();
        for (FileArtifact artifact : artifacts) {
            files.add(artifact.getPath().getAbsolutePath());
        }
        return files;
    }
    
    /**
     * Turns a list of files into related file artifacts.
     * 
     * @param files the files to be turned into file artifacts
     * @param model the artifact model to be used (may be <b>null</b> for auto-detection)s
     * @return the set of file artifacts
     * @throws ArtifactException if creating a file artifact instance fails
     */
    @Invisible
    public static final Set<FileArtifact> toFileArtifactSet(List<File> files, ArtifactModel model)
        throws ArtifactException {
        FileArtifact[] result = new FileArtifact[files.size()];
        for (int f = 0; f < files.size(); f++) {
            File file = files.get(f);
            if (!file.isDirectory()) {
                result[f] = ArtifactFactory.createArtifact(FileArtifact.class, file, model);
            }
        }
        return new ArraySet<FileArtifact>(result, FileArtifact.class);
    }

}
