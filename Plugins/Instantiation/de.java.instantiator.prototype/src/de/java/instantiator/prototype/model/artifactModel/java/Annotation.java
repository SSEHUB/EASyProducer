package de.java.instantiator.prototype.model.artifactModel.java;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FragmentArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * Represents a Java annotation.
 * 
 * @author Holger Eichelberger
 */
public class Annotation extends FragmentArtifact {
    
    private String annotationName;
    
    private String annotationValue;
    
    /**
     * Default Constructor.
     * 
     * @param name The annotation name
     * @param value The annotation value
     */
    public Annotation(String name, String value) {
        this.annotationName = name;
        this.annotationValue = value;
    }

    @Override
    public void delete() throws ArtifactException {
        // TODO Auto-generated method stub
    }

    @Override
    public String getName() throws ArtifactException {
        return annotationName;
    }

    @Override
    public void rename(String name) throws ArtifactException {
        // TODO Auto-generated method stub
    }

    @Override
    public Text getText() throws ArtifactException {
        return Text.CONSTANT_EMPTY;
    }

    @Override
    public Binary getBinary() throws ArtifactException {
        return Binary.CONSTANT_EMPTY;
    }

    @Override
    public void accept(IArtifactVisitor visitor) {
        visitor.visitFragmentArtifact(this);
    }
    
    /**
     * Returns the annotation value as a string.
     * 
     * @return The annotation value represented as a string.
     */
    public String getAnnotationValue() {
        return annotationValue;
    }

    @Override
    public void update() throws ArtifactException {
        // TODO Auto-generated method stub
        
    }

}
