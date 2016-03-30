package net.ssehub.easy.instantiation.core.model.artifactModel;

import net.ssehub.easy.instantiation.core.model.artifactModel.variability.AlternativeFragment;
import net.ssehub.easy.instantiation.core.model.artifactModel.variability.MultipleSelectionFragment;
import net.ssehub.easy.instantiation.core.model.artifactModel.variability.OptionalityFragment;
import net.ssehub.easy.instantiation.core.model.artifactModel.variability.VariabilityFragment;

/**
 * A visitor for all top-level (default) artifacts.
 * 
 * @author Holger Eichelberger
 */
public interface IArtifactVisitor {
    
    /**
     * Visits a path artifact.
     * 
     * @param artifact the artifact to be visited.
     */
    public void visitFolderArtifact(FolderArtifact artifact);

    /**
     * Visits a file artifact.
     * 
     * @param artifact the artifact to be visited.
     */
    public void visitFileArtifact(FileArtifact artifact);

    /**
     * Visits a fragment artifact.
     * 
     * @param artifact the artifact to be visited.
     */
    public void visitFragmentArtifact(FragmentArtifact artifact);

    /**
     * Visits a composite fragment artifact.
     * 
     * @param artifact the artifact to be visited.
     */
    public void visitCompositeFragmentArtifact(CompositeFragmentArtifact artifact);

    /**
     * Visits a simple artifact.
     * 
     * @param artifact the artifact to be visited.
     */
    public void visitSimpleArtifact(SimpleArtifact artifact);

    /**
     * Visits a composite artifact.
     * 
     * @param artifact the artifact to be visited.
     */
    public void visitCompositeArtifact(CompositeArtifact artifact);

    /**
     * Visits an optionality fragment.
     * 
     * @param fragment the fragment to be visited.
     */
    public void visitOptionalityFragment(OptionalityFragment fragment);

    /**
     * Visits an alternative fragment.
     * 
     * @param fragment the fragment to be visited.
     */
    public void visitAlternativeFragment(AlternativeFragment fragment);

    /**
     * Visits a multiple selection fragment.
     * 
     * @param fragment the fragment to be visited.
     */
    public void visitMultipleSelectionFragment(MultipleSelectionFragment fragment);

    /**
     * Visits a variability selection fragment.
     * 
     * @param fragment the fragment to be visited.
     */
    public void visitVariabilityFragment(VariabilityFragment fragment);

}
