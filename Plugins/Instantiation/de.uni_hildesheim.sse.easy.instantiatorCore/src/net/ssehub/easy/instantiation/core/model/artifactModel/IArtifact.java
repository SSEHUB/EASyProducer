package net.ssehub.easy.instantiation.core.model.artifactModel;

import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Binary;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Text;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ClassMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a generic artifact.
 * 
 * @author Holger Eichelberger
 */
@ClassMeta(name = "Artifact", furtherOperations = ArtifactOperations.class)
public interface IArtifact extends IVilType {
    
    /**
     * Deletes this artifact.
     * 
     * @throws VilException in case of serious problems so that this operation 
     *   cannot continue
     */
    public void delete() throws VilException;

    /**
     * Returns the name of this artifact.
     * 
     * @return the name of this artifact
     * @throws VilException in case of serious problems so that this operation 
     *   cannot continue
     */
    public String getName() throws VilException;
    
    /**
     * Renames this artifact.
     * 
     * @param name the new name of this artifact
     * @throws VilException in case of serious problems so that this operation 
     *   cannot continue
     */
    public void rename(String name) throws VilException;
    
    /**
     * Returns the textual representation of <i>the contents</i> of this artifact for manipulation.
     * In case of binary artifacts, the returned object may be empty.
     * 
     * @return the textual representation of the contents
     * @throws VilException in case of obtaining the representation causes serious problems
     */
    public Text getText() throws VilException;
    
    /**
     * Returns the binary representation of <i>the contents</i> of this artifact for manipulation.
     * 
     * @return the binary representation of the contents
     * @throws VilException in case of obtaining the representation causes serious problems
     */
    public Binary getBinary() throws VilException;
    
    /**
     * Visits this artifact (and dependent on the visitor also contained artifacts and fragments) 
     * using the given visitor.
     * 
     * @param visitor the visitor used for visiting this artifact
     */
    @Invisible(inherit = true)
    public void accept(IArtifactVisitor visitor);

    /**
     * Called if the underlying real artifact may have been updated, e.g., by overriding it by another file.
     * 
     * @throws VilException in case that updating fails
     */
    @Invisible(inherit = true)
    public void update() throws VilException;
    
    /**
     * Returns the last modification timestamp of this artifact.
     *
     * @return the last modification timestamp, 0 if unknown
     */
    @Invisible(inherit = true)
    public long lastModification();

    /**
     * Returns whether this artifact is exists.
     * 
     * @return <code>true</code> if this artifact exists, <code>false</code> else
     */
    public boolean exists();
    
    /**
     * Stores this artifact in case of changes.
     * 
     * @throws VilException in case of problems storing this artifact
     */
    @Invisible(inherit = true)
    public void store() throws VilException;

    /**
     * Allow or disable auto-storing during VTL processing. Typically, an artifact is stored whenever
     * a variable containing it is removed from the actual scope, i.e., the scope is closed, thus auto-store is 
     * enabled. This is needed for usual artifacts to contain/flush recent VTL content output even if output fails. 
     * However, it is inefficient for artifacts, that collect information and need storing their information only once, 
     * when the VTL processing ends.
     * 
     * @return {@code true} to enable auto-storing, {@code false} to prevent it; by default, usual artifacts return the 
     * value of {@code enable}
     */
    @Invisible
    public default boolean enableAutoStore() {
        return true;
    }
    
}
