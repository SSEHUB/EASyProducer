package de.java.instantiator.prototype.model.artifactModel.java;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.DefaultFileArtifactCreator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * Defines the default file artifact creator.
 * 
 * @author Sass
 *
 */
public class DefaultJavaFileArtifactCreator extends DefaultFileArtifactCreator {
    
    @Override
    protected boolean handlesFileImpl(File file) {
        return checkSuffix(file, ".java");
    }

    @Override
    public FileArtifact createArtifactInstance(Object real, ArtifactModel model) throws ArtifactException {
        return new JavaFileArtifact((File) real, model);
    }
    
    @Override
    public java.lang.Class<? extends IArtifact> getArtifactClass() {
        return JavaFileArtifact.class;
    }
}
