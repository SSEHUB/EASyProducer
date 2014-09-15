package de.uni_hildesheim.sse.easy.java.artifacts;

import org.eclipse.jdt.core.dom.ImportDeclaration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * Represents a Java import.
 * 
 * @author Sass
 *
 */
public class JavaImport extends JavaParentFragmentArtifact {
    
    private ImportDeclaration importDeclaration;

    /**
     * Default Constructor.
     * 
     * @param parent    the parent artifact or fragment
     * @param node  The ImportDeclaration
     */
    protected JavaImport(ImportDeclaration node, IJavaParent parent) {
        super(parent);
        this.importDeclaration = node;
    }

    @Override
    public String getName() throws ArtifactException {
        return importDeclaration.getName().toString();
    }

    @Override
    public void rename(String name) throws ArtifactException {
        importDeclaration.setName(importDeclaration.getAST().newName(name));
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
