package de.java.instantiator.prototype.model.artifactModel.java;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Represents a Java class file.
 * 
 * @author Holger Eichelberger
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
    public void artifactChanged() throws ArtifactException {
        // TODO 
    }

    @Override
    public void store() throws ArtifactException {
        // TODO consider super
    }
    
    /**
     * Returns the classes of this java file.
     * 
     * @return the annotations
     */
    @OperationMeta(returnGenerics = Class.class)
    public Set<Class> classes() {
        return new ArraySet<Class>(null, Class.class);
    }

}
