package de.uni_hildesheim.sse.easy.java.artifacts;

import org.eclipse.jdt.core.dom.ExpressionStatement;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;

/**
 * Represents a Java annotation.
 * 
 * @author Sass
 */
public class JavaCall extends JavaParentFragmentArtifact {

    private ExpressionStatement statementDeclaration;
    private String attributeName;
    private String binding;

    /**
     * Default Constructor.
     * 
     * @param node
     *            The Statement Declaration
     * @param attributeName
     *            The name of the call
     * @param parent
     *            the parent fragment
     * @param binding
     *            binding of the type represented as string
     */
    public JavaCall(ExpressionStatement node, String attributeName, String binding, IJavaParent parent) {
        super(parent);
        this.statementDeclaration = node;
        this.attributeName = attributeName;
        this.binding = binding;
    }

    /**
     * Constructor for JavaCalls that are not bound to a parent fragment. (Used to declare JavaCalls that should be
     * deleted).
     * 
     * @param attributeName
     *            The name of the call
     * @param binding
     *            binding of the type represented as string
     */
    public JavaCall(String attributeName, String binding) {
        super(null);
        this.attributeName = attributeName;
        this.binding = binding;
    }

    @Override
    public void delete() throws VilException {
        statementDeclaration.delete();
        super.delete();
    }

    @Override
    public String getName() throws VilException {
        return attributeName;
    }

    @Override
    public void rename(String name) throws VilException {
        // TODO Auto-generated method stub

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

    /**
     * Returns the type of the call represented as string.
     * 
     * @return type as string
     */
    public String getType() {
        return binding;
    }

    @Invisible
    @Override
    public String getStringValue(StringComparator comparator) {
        return "call '" + getNameSafe() + "'";
    }

}
