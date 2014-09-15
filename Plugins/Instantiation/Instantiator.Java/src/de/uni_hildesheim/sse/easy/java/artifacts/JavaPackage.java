package de.uni_hildesheim.sse.easy.java.artifacts;

import org.eclipse.jdt.core.dom.PackageDeclaration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * Represents a Java package.
 * 
 * @author Sass
 *
 */
public class JavaPackage extends JavaParentFragmentArtifact {
    
    private PackageDeclaration packageDeclaration;

    /**
     * Default Constructor.
     * 
     * @param parent    The parent artifact or fragment
     * @param node  The {@link PackageDeclaration}
     */
    protected JavaPackage(PackageDeclaration node, IJavaParent parent) {
        super(parent);
        this.packageDeclaration = node;
    }

    @Override
    public String getName() throws ArtifactException {
        return packageDeclaration.getName().toString();
    }

    @Override
    public void rename(String name) throws ArtifactException {       
        packageDeclaration.setName(packageDeclaration.getAST().newName(name));
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
