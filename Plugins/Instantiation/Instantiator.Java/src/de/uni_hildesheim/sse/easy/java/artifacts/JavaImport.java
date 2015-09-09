package de.uni_hildesheim.sse.easy.java.artifacts;

import org.eclipse.jdt.core.dom.ImportDeclaration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;

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
    public String getName() throws VilException {
        return importDeclaration.getName().toString();
    }

    @Override
    public void rename(String name) throws VilException {
        importDeclaration.setName(importDeclaration.getAST().newName(name));
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
        return "import '" + getNameSafe() + "'";
    }

    @Invisible
    @Override
    public ArtifactModel getArtifactModel() {
        return getParent().getArtifactModel();
    }

}