import java.io.IOException;

import test.de.uni_hildesheim.sse.java.artifacts.JavaFileArtifactTest;
import de.uni_hildesheim.sse.easy.java.artifacts.JavaClass;
import de.uni_hildesheim.sse.easy.java.artifacts.JavaFileArtifact;
import de.uni_hildesheim.sse.easy.java.artifacts.JavaMethod;
import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

public class MethodFile {

    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(MethodFile.class, Bundle.ID);
    
    public void testModifyMethod() throws IOException {
        copyFile(copyFile, tempFile);
        try {
            JavaFileArtifact javaFileArtefact = (JavaFileArtifact) CREATOR.createArtifactInstance(tempFile, null);
            Set<JavaClass> classes = javaFileArtefact.classes();
            for (JavaClass javaClass : classes) {
                Set<JavaMethod> methods = javaClass.methods();
                for (JavaMethod javaMethod : methods) {
                    javaMethod.getText();
                }
            }
            javaFileArtefact.store();
        } catch (VilException e) {
        }
    }

    public void test() {
        System.out.println("dies ist ein test");
    }
}