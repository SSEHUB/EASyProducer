package de.uni_hildesheim.sse.easy.java.artifacts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Represents a Java class.
 * 
 * @author Holger Eichelberger, Sass
 */
public class JavaClass extends JavaParentFragmentArtifact {

    private TypeDeclaration typeDeclaration;

    /**
     * Default Constructor.
     * 
     * @param typeDeclaration the tyoe declaration representing the class
     * @param parent the parent artifact
     */
    public JavaClass(TypeDeclaration typeDeclaration, IJavaParent parent) {
        super(parent);
        this.typeDeclaration = typeDeclaration;
    }

    @Override
    public void delete() throws ArtifactException {
        // needed if substructures are stored
        super.delete();
    }

    @Override
    public String getName() throws ArtifactException {
        return typeDeclaration.getName().getIdentifier();
    }

    @Override
    public void rename(String name) throws ArtifactException {
        // TODO implement
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
     * Returns the annotations of this class.
     * 
     * @return the annotations
     */
    @SuppressWarnings("unchecked")
    @OperationMeta(returnGenerics = JavaAnnotation.class)
    public Set<JavaAnnotation> annotations() {
        return annotations(typeDeclaration.modifiers());
    }

    /**
     * Returns the methods of this class.
     * 
     * @return the methods
     */
    @OperationMeta(returnGenerics = JavaMethod.class)
    public Set<JavaMethod> methods() {
        final List<JavaMethod> list = new ArrayList<JavaMethod>();
        typeDeclaration.accept(new ASTVisitor() {
            @Override
            public boolean visit(MethodDeclaration node) {
                JavaMethod method = new JavaMethod(node, JavaClass.this);
                list.add(method);
                return false;
            }
        });
        return new ArraySet<JavaMethod>(list.toArray(new JavaMethod[list.size()]), JavaMethod.class);
    }

    /**
     * Returns the inner classes of this class.
     * 
     * @return Set with inner classes
     */
    public Set<JavaClass> classes() {
        final List<JavaClass> list = new ArrayList<JavaClass>();
        typeDeclaration.accept(new ASTVisitor() {
            public boolean visit(TypeDeclaration typeDeclaration) {
                // The below code is used to check if it is not a top-level class
                if (!typeDeclaration.isPackageMemberTypeDeclaration()) {
                    list.add(new JavaClass(typeDeclaration, JavaClass.this));
                }
                return true;
            }
        });
        return new ArraySet<JavaClass>(list.toArray(new JavaClass[list.size()]), JavaClass.class);

    }

    /**
     * Returns the attributes of this class.
     * 
     * @return the attributes
     */
    @OperationMeta(returnGenerics = JavaAttribute.class)
    public Set<JavaAttribute> attributes() {
        final List<JavaAttribute> list = new ArrayList<JavaAttribute>();
        typeDeclaration.accept(new ASTVisitor() {
            @Override
            public boolean visit(FieldDeclaration node) {
                String attributeName = "";
                Object object = node.fragments().get(0);
                if (object instanceof VariableDeclarationFragment) {
                    attributeName = ((VariableDeclarationFragment) object).getName().toString();
                }
                JavaAttribute attribute = new JavaAttribute(node, attributeName, JavaClass.this);
                list.add(attribute);
                return false;
            }
        });
        return new ArraySet<JavaAttribute>(list.toArray(new JavaAttribute[list.size()]), JavaAttribute.class);
    }
    
}
