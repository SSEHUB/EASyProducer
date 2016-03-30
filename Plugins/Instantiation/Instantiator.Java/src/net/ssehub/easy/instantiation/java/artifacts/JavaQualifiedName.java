package net.ssehub.easy.instantiation.java.artifacts;

import org.eclipse.jdt.core.dom.QualifiedName;

import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifactVisitor;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Binary;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Text;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

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
    public String getName() throws VilException {
        return qualifiedName.getQualifier().toString();
    }

    @Override
    public void rename(String name) throws VilException {
        qualifiedName.setQualifier(qualifiedName.getAST().newName(name));
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
        return "qName '" + getNameSafe() + "'";
    }

    @Invisible
    @Override
    public ArtifactModel getArtifactModel() {
        return getParent().getArtifactModel();
    }

}
