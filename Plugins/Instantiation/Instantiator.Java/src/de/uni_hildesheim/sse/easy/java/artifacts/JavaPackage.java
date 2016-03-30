package de.uni_hildesheim.sse.easy.java.artifacts;

import org.eclipse.jdt.core.dom.PackageDeclaration;

import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifactVisitor;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Binary;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Text;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

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
    public String getName() throws VilException {
        return packageDeclaration.getName().toString();
    }

    @Override
    public void rename(String name) throws VilException {       
        packageDeclaration.setName(packageDeclaration.getAST().newName(name));
        notifyChanged();
    }

    @Override
    public Text getText() throws VilException {
        return Text.CONSTANT_EMPTY;
    }

    @Override
    public Binary getBinary() throws VilException {
        return Binary.CONSTANT_EMPTY;
    }

    @Override
    public void accept(IArtifactVisitor visitor) {
        visitor.visitFragmentArtifact(this);
    }

    @Invisible
    @Override
    public String getStringValue(StringComparator comparator) {
        return "package '" + getNameSafe() + "'";
    }

    @Invisible
    @Override
    public ArtifactModel getArtifactModel() {
        return getParent().getArtifactModel();
    }

}
