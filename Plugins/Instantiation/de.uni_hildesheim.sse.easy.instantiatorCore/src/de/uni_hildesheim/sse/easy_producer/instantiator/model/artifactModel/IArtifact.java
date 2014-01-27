package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ClassMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;

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
     * @throws ArtifactException in case of serious problems so that this operation 
     *   cannot continue
     */
    public void delete() throws ArtifactException;

    /**
     * Returns the name of this artifact.
     * 
     * @return the name of this artifact
     * @throws ArtifactException in case of serious problems so that this operation 
     *   cannot continue
     */
    public String getName() throws ArtifactException;
    
    /**
     * Renames this artifact.
     * 
     * @param name the new name of this artifact
     * @throws ArtifactException in case of serious problems so that this operation 
     *   cannot continue
     */
    public void rename(String name) throws ArtifactException;
    
    /**
     * Returns the textual representation of <i>the contents</i> of this artifact for manipulation.
     * In case of binary artifacts, the returned object may be empty.
     * 
     * @return the textual representation of the contents
     * @throws ArtifactException in case of obtaining the representation causes serious problems
     */
    public Text getText() throws ArtifactException;
    
    /**
     * Returns the binary representation of <i>the contents</i> of this artifact for manipulation.
     * 
     * @return the binary representation of the contents
     * @throws ArtifactException in case of obtaining the representation causes serious problems
     */
    public Binary getBinary() throws ArtifactException;
    
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
     * @throws ArtifactException in case that updating fails
     */
    @Invisible(inherit = true)
    public void update() throws ArtifactException;
    
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
     * @throws ArtifactException in case of problems storing this artifact
     */
    @Invisible(inherit = true)
    public void store() throws ArtifactException;
    
}
