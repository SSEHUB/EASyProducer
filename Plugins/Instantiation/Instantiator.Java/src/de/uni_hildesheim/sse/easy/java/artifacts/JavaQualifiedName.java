package de.uni_hildesheim.sse.easy.java.artifacts;

import org.eclipse.jdt.core.dom.QualifiedName;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * Represents a java qualified name.
 * 
 * @author Sass
 *
 */
public class JavaQualifiedName extends JavaParentFragmentArtifact {

    private QualifiedName qualifiedName;

    /**
     * Default Constructor.
     * 
     * @param parent    the parent artifact or fragment
     * @param node  The ImportDeclaration
     */
    protected JavaQualifiedName(QualifiedName node, IJavaParent parent) {
        super(parent);
        this.qualifiedName = node;
    }

    @Override
    public String getName() throws ArtifactException {
        return qualifiedName.getQualifier().toString();
    }

    @Override
    public void rename(String name) throws ArtifactException {
        qualifiedName.setQualifier(qualifiedName.getAST().newName(name));
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

}
