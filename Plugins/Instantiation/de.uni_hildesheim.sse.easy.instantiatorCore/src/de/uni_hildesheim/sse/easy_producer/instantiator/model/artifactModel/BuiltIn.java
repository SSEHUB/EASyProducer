package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.xml.XmlAttribute;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.xml.XmlElement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.xml.XmlFileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

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
            
            TypeRegistry.register(Text.class);
            TypeRegistry.register(Binary.class);
            
            TypeRegistry.register(Path.class);
            TypeRegistry.register(JavaPath.class);
            
            TypeRegistry.register(IArtifact.class);
            TypeRegistry.register(IFileSystemArtifact.class);
            TypeRegistry.register(FileArtifact.class);
            TypeRegistry.register(FolderArtifact.class);

            TypeRegistry.register(VtlFileArtifact.class);

            //-------------------- preliminary -------------
            
            TypeRegistry.register(XmlFileArtifact.class);
            TypeRegistry.register(XmlElement.class);
            TypeRegistry.register(XmlAttribute.class);
        }
    }


}
