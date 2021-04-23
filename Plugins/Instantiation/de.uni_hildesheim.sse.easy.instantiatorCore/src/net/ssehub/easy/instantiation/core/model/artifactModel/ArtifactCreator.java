package net.ssehub.easy.instantiation.core.model.artifactModel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Allows to bind an artifact creator to an artifact implementation.
 * 
 * @author Holger Eichelberger
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ArtifactCreator {

    /**
     * The related artifact creator (class).
     * 
     * @return the artifact creator class
     */
    Class<? extends IArtifactCreator> value();

}
