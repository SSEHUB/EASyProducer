package net.ssehub.easy.instantiation.core.model.artifactModel;

/**
 * An instance which notifies the {@link ArtifactModel artifact model} about changed 
 * artifacts. Classes implementing this interface will automatically be recognized by 
 * the VIL build language and connected to the actual {@link ArtifactModel artifact model}.
 * 
 * @author Holger Eichelberger
 */
public interface IArtifactNotifier {

    /**
     * Notifies that a set of artifacts was changed.
     * 
     * @param artifacts the arficats which were changed.
     */
    public void notifyChanged(IArtifact... artifacts);
    
}
