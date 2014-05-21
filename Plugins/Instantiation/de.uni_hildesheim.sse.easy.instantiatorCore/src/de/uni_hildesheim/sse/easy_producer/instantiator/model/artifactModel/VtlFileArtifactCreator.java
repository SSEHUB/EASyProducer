package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * The artifact creator for VTL files.
 * 
 * @author Holger Eichelberger
 */
public class VtlFileArtifactCreator extends DefaultFileArtifactCreator {

    @Override
    protected boolean handlesFileImpl(File file) {
        return checkSuffix(file, ".vtl");
    }

    @Override
    public FileArtifact createArtifactInstance(Object real, ArtifactModel model) throws ArtifactException {
        return new VtlFileArtifact((File) real, model);
    }
    
    @Override
    public Class<? extends IArtifact> getArtifactClass() {
        return VtlFileArtifact.class;
    }

}
