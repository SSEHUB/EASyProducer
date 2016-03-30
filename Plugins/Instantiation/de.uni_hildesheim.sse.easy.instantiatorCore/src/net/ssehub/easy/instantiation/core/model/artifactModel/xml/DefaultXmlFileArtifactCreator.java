package net.ssehub.easy.instantiation.core.model.artifactModel.xml;

import java.io.File;

import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.DefaultFileArtifactCreator;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Defines the default file artifact creator.
 * 
 * @author Holger Eichelberger
 */
public class DefaultXmlFileArtifactCreator extends DefaultFileArtifactCreator {

    @Override
    protected boolean handlesFileImpl(File file) {
        return checkSuffix(file, ".xml") || checkSuffix(file, ".xsd");
    }

    @Override
    public FileArtifact createArtifactInstance(Object real, ArtifactModel model) throws VilException {
        return new XmlFileArtifact((File) real, model);
    }
    
    @Override
    public Class<? extends IArtifact> getArtifactClass() {
        return XmlFileArtifact.class;
    }

}
