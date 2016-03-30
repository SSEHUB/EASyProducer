package net.ssehub.easy.instantiation.java.artifacts;

import java.io.File;

import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySet;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * Represents a Java class file.
 * 
 * @author Holger Eichelberger, Sass
 */
// TODO @ArtifactCreator
public class ClassFileArtifact extends FileArtifact {

    /**
     * Creates a new class file artifact.
     * 
     * @param file the file to read the artifact contents from
     * @param model the artifact model to create this folder artifact within
     */
    ClassFileArtifact(File file, ArtifactModel model) {
        super(file, model);
    }
    
    /**
     * Returns the annotation value.
     * 
     * @param annotation the name of the annotation type
     * @param field the field to be returned
     * @return the field or <b>null</b> if not found
     */
    public String annotationValue(String annotation, String field) {
        // TODO replace -> current used as part of testing
        return "";
    }

    @Override
    public void artifactChanged(Object cause) throws VilException {
        // TODO 
    }

    @Override
    public void store() throws VilException {
        // TODO consider super
    }
    
    /**
     * Returns the classes of this java file.
     * 
     * @return the annotations
     */
    @OperationMeta(returnGenerics = JavaClass.class)
    public Set<JavaClass> classes() {
        return new ArraySet<JavaClass>(null, JavaClass.class);
    }

}
