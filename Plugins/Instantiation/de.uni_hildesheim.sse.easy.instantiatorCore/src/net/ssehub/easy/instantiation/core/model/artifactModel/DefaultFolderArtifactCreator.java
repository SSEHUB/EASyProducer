package net.ssehub.easy.instantiation.core.model.artifactModel;

import java.io.File;
import java.util.List;
import java.util.Properties;

import net.ssehub.easy.basics.messages.Message;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Defines the default folder creator.
 * 
 * @author Holger Eichelberger
 */
public class DefaultFolderArtifactCreator implements IArtifactCreator {

    @Override
    public boolean handlesArtifact(Class<? extends IArtifact> kind, Object real) {
        // handle self and those I inherit from (e.g., interfaces)
        boolean result = false;
        if (kind.isAssignableFrom(getArtifactClass()) && real instanceof File)  {
            File f = (File) real;
            result = FileUtils.isDirectory(f) && !PathUtils.isPattern(f);
        }
        return result;
    }

    @Override
    public FolderArtifact createArtifactInstance(Object real, ArtifactModel model) throws VilException {
        return new FolderArtifact((File) real, model);
    }
    
    @Override
    public void configure(Properties properties, List<Message> messages) {
        // no configuration
    }
    
    @Override
    public Class<? extends IArtifact> getArtifactClass() {
        return FolderArtifact.class;
    }

}
