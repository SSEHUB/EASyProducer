package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.xml;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.DefaultFileArtifactCreator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

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
    public FileArtifact createArtifactInstance(Object real, ArtifactModel model) throws ArtifactException {
        return new XmlFileArtifact((File) real, model);
    }
    
    @Override
    public Class<? extends IArtifact> getArtifactClass() {
        return XmlFileArtifact.class;
    }

}
