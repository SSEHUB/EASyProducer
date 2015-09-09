package de.uni_hildesheim.sse.easy.java.artifacts;

import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.ITypeBinding;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;

/**
 * Represents a Java annotation.
 * 
 * @author Sass
 */
public class JavaCall extends AbstractJavaStatement {

    /**
     * Default Constructor.
     * 
     * @param node
     *            The Statement Declaration
     * @param attributeName
     *            The name of the call
     * @param parent
     *            the parent fragment
     * @param typeBinding
     *            binding of the type
     */
    public JavaCall(ExpressionStatement node, String attributeName, ITypeBinding typeBinding, IJavaParent parent) {
        super(parent, node, attributeName, typeBinding);
    }

    /**
     * Constructor for JavaCalls that are not bound to a parent fragment. (Used
     * to declare JavaCalls that should be deleted).
     * 
     * @param attributeName
     *            The name of the call
     * @param typeBinding
     *            binding of the type
     */
    public JavaCall(String attributeName, ITypeBinding typeBinding) {
        super(null, null, attributeName, typeBinding);
    }

    @Invisible
    @Override
    public ArtifactModel getArtifactModel() {
        return getParent().getArtifactModel();
    }
}
