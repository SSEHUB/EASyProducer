package net.ssehub.easy.instantiation.python.codeArtifacts;

import java.io.File;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.DefaultFileArtifactCreator;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * The VIL/VTL artifact creator for Python.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeArtifactCreator extends DefaultFileArtifactCreator {
    
    @Override
    protected boolean handlesFileImpl(File file) {
        return checkSuffix(file, ".py");
    }

    @Override
    public FileArtifact createArtifactInstance(Object real, ArtifactModel model) throws VilException {
        return new PythonCodeArtifact((File) real, model);
    }

    @Override
    public java.lang.Class<? extends IArtifact> getArtifactClass() {
        return PythonCodeArtifact.class;
    }
    
}
