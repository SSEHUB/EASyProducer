package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ClassMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IStringValueProvider;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Represents a file system artifact, i.e., a real-world entity in a file system.
 * 
 * @author Holger Eichelberger
 */
@ClassMeta(name = "FileSystemArtifact", furtherOperations = FileSystemArtifactOperations.class)
public interface IFileSystemArtifact extends IArtifact, IStringValueProvider {

    /**
     * Returns the path artifact representing the path to this file system artifact.
     * The absolute and simple name can be obtained from the path. Note that {@link #getName()} 
     * will return the simple name of this artifact.
     * 
     * @return the path
     * @throws ArtifactException in case of serious problems
     */
    public Path getPath() throws ArtifactException;
    
    /**
     * Move this artifact.
     * 
     * @param target the target artifact. In case of a file, the target is 
     * supposed to be overridden. In case of a directory, this artifact shall
     * after this operation be part of the directory.
     * @return <b>this</b> (for chained operations)
     * @throws ArtifactException in case of serious problems
     */
    @OperationMeta(returnGenerics = IFileSystemArtifact.class)    
    public Set<IFileSystemArtifact> move(IFileSystemArtifact target) throws ArtifactException;

    /**
     * Copy this artifact.
     * 
     * @param target the target artifact. In case of a file, the target is 
     * supposed to be overridden by a copy of this artifact. In case of a directory, 
     * a copy of this artifact shall after this operation be part of the directory.
     * @return <b>this</b> (for chained operations)
     * @throws ArtifactException in case of serious problems
     */
    @OperationMeta(returnGenerics = IFileSystemArtifact.class)
    public Set<IFileSystemArtifact> copy(IFileSystemArtifact target) throws ArtifactException;
    
    /**
     * Returns whether this artifact is (considered to be) a temporary artifact.
     * 
     * @return <code>true</code> if it is temporary, <code>false</code> else
     */
    @Invisible(inherit = true)
    public boolean isTemporary();
    
    // TODO rename
    
}
