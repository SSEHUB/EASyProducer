package de.uni_hildesheim.sse.easy.java.artifacts;

import org.eclipse.jdt.core.dom.MethodDeclaration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Represents a Java annotation.
 * 
 * @author Holger Eichelberger, Sass
 */
public class JavaMethod extends JavaParentFragmentArtifact {
    
    private MethodDeclaration methodDeclaration;
    
    /**
     * Default Constructor.
     * 
     * @param node The Method Declaration
     * @param parent the parent fragment
     */
    public JavaMethod(MethodDeclaration node, IJavaParent parent) {
        super(parent);
        this.methodDeclaration = node;
    }

    @Override
    public void delete() throws ArtifactException {
        methodDeclaration.delete();
        super.delete();
    }

    @Override
    public String getName() throws ArtifactException {
        return methodDeclaration.getName().toString();
    }

    @Override
    public void rename(String name) throws ArtifactException {
        methodDeclaration.setName(methodDeclaration.getAST().newSimpleName(name));
        notifyChanged();
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
     * Returns the annotations of this method.
     * 
     * @return the annotations
     */
    @SuppressWarnings("unchecked")
    @OperationMeta(returnGenerics = JavaAnnotation.class)
    public Set<JavaAnnotation> annotations() {
        return annotations(methodDeclaration.modifiers());
    }
    
    /**
     * Getter for the MethodDeclaration of the method.
     * 
     * @return Returns the MethodDeclaration of the method.
     */
    @Invisible
    MethodDeclaration getMethodDeclaration() {
        return methodDeclaration;
    }

}
