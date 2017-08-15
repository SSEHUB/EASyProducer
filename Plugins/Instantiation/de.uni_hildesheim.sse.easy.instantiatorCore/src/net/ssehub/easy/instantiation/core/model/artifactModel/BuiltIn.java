package net.ssehub.easy.instantiation.core.model.artifactModel;

import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Binary;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Text;
import net.ssehub.easy.instantiation.core.model.artifactModel.xml.XmlAttribute;
import net.ssehub.easy.instantiation.core.model.artifactModel.xml.XmlComment;
import net.ssehub.easy.instantiation.core.model.artifactModel.xml.XmlElement;
import net.ssehub.easy.instantiation.core.model.artifactModel.xml.XmlFileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.xml.XmlNode;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Initializes built-in VIL artifact types.
 * 
 * @author Holger Eichelberger
 */
public class BuiltIn {
    
    private static boolean initialized = false;
    
    /**
     * Default built-in types.
     */
    public static synchronized void initialize() {
        if (!initialized) {
            initialized = true;
            
            TypeRegistry.DEFAULT.register(Text.class);
            TypeRegistry.DEFAULT.register(Binary.class);
            
            TypeRegistry.DEFAULT.register(Path.class);
            TypeRegistry.DEFAULT.register(JavaPath.class);
            
            TypeRegistry.DEFAULT.register(IArtifact.class);
            TypeRegistry.DEFAULT.register(IFileSystemArtifact.class);
            TypeRegistry.DEFAULT.register(FileArtifact.class);
            TypeRegistry.DEFAULT.register(FolderArtifact.class);

            TypeRegistry.DEFAULT.register(VtlFileArtifact.class);

            //-------------------- preliminary -------------
            
            TypeRegistry.DEFAULT.register(XmlFileArtifact.class);
            TypeRegistry.DEFAULT.register(XmlNode.class);
            TypeRegistry.DEFAULT.register(XmlElement.class);
            TypeRegistry.DEFAULT.register(XmlComment.class);
            TypeRegistry.DEFAULT.register(XmlAttribute.class);
        }
    }


}
