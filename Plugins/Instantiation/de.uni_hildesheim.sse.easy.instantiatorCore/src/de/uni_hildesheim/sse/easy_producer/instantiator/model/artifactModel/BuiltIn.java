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
            TypeRegistry.DEFAULT.register(XmlElement.class);
            TypeRegistry.DEFAULT.register(XmlAttribute.class);
        }
    }


}
