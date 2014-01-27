package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Represents a dedicated part of the artifact model linked to a certain project.
 * 
 * @author Holger Eichelberger
 */
public interface IArtifactRoot {

    /**
     * Does type selection of artifacts.
     * 
     * @param type the target type
     * @return the selected artifacts (the type will be adjusted to the actual
     *   type of <code>type</code>)
     */
    public Set<FileArtifact> selectByType(Class<?> type);

}
