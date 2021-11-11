package net.ssehub.easy.instantiation.core.model.artifactModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ClassMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

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
     * @throws VilException in case of serious problems
     */
    public Path getPath() throws VilException;
    
    /**
     * Move this artifact.
     * 
     * @param target the target artifact. In case of a file, the target is 
     * supposed to be overridden. In case of a directory, this artifact shall
     * after this operation be part of the directory.
     * @return <b>this</b> (for chained operations)
     * @throws VilException in case of serious problems
     */
    @OperationMeta(returnGenerics = IFileSystemArtifact.class)    
    public Set<IFileSystemArtifact> move(IFileSystemArtifact target) throws VilException;

    /**
     * Copy this artifact.
     * 
     * @param target the target artifact. In case of a file, the target is 
     * supposed to be overridden by a copy of this artifact. In case of a directory, 
     * a copy of this artifact shall after this operation be part of the directory.
     * @return <b>this</b> (for chained operations)
     * @throws VilException in case of serious problems
     */
    @OperationMeta(returnGenerics = IFileSystemArtifact.class)
    public Set<IFileSystemArtifact> copy(IFileSystemArtifact target) throws VilException;
    
    /**
     * Enables the (operation system specific) execution flag for this artifact.
     * 
     * @param ownerOnly whether all users or just the owner shall be allowed to exectue this artifact
     * @throws VilException if the executable flag cannot be set.
     */
    @OperationMeta(storeArtifactsBefore = true)
    public void setExecutable(boolean ownerOnly) throws VilException;
    
    /**
     * Returns whether this artifact is (considered to be) a temporary artifact.
     * 
     * @return <code>true</code> if it is temporary, <code>false</code> else
     */
    @Invisible(inherit = true)
    public boolean isTemporary();
    
    // TODO rename
    
}
