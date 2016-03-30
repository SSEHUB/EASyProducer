package net.ssehub.easy.instantiation.java.artifacts;

import java.io.File;

import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.DefaultFileArtifactCreator;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;

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
    public FileArtifact createArtifactInstance(Object real, ArtifactModel model) throws VilException {
        return new JavaFileArtifact((File) real, model);
    }
    
    @Override
    public java.lang.Class<? extends IArtifact> getArtifactClass() {
        return JavaFileArtifact.class;
    }
}
