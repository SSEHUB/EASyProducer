package de.uni_hildesheim.sse.easy.java.artifacts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
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
     * @param typeDeclaration
     *            the type declaration representing the class
     * @param parent
     *            the parent artifact
     */
    public JavaClass(TypeDeclaration typeDeclaration, IJavaParent parent) {
        super(parent);
        this.typeDeclaration = typeDeclaration;
    }

    @Override
    public void delete() throws VilException {
        // needed if substructures are stored
        super.delete();
    }

    @Override
    public String getName() throws VilException {
        return typeDeclaration.getName().getIdentifier();
    }

    @Override
    public void rename(String name) throws VilException {
        // TODO implement
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
     * Deletes a statement within a method. Right now only JavaCall can be
     * deleted.
     * 
     * @param evaluator
     *            A wrapper type to pass and evaluate
     * @throws VilException
     *             in case something goes wrong
     */
    public void deleteStatement(ExpressionEvaluator evaluator) throws VilException {
        for (JavaMethod method : methods()) {
            method.deleteStatement(evaluator);
        }
    }

    /**
     * Deletes a method and all java calls assigned to this method.
     * 
     * @param evaluator
     *            A wrapper type to pass and evaluate
     * @throws VilException
     *             in case something goes wrong
     */
    public void deleteMethodWithCalls(ExpressionEvaluator evaluator) throws VilException {
        for (JavaMethod method : methods()) {
            Object object = evaluator.evaluate(method);
            if (null != object && object instanceof Boolean && Boolean.TRUE == ((Boolean) object).booleanValue()) {
                System.out.println(object);
                Set<FileArtifact> allFileArtifacts = getArtifactModel().selectByType(JavaFileArtifact.class);
                for (FileArtifact fileArtifact : allFileArtifacts) {
                    System.out.println(fileArtifact.getPath().getPath());
                }
                for (FileArtifact fileArtifact : allFileArtifacts) {
                    JavaFileArtifact javaFileArtifact = (JavaFileArtifact) fileArtifact;
                    for (JavaClass javaClass : javaFileArtifact.classes()) {
                        for (JavaMethod javaMethod : javaClass.methods()) {
                            InvocationRemovalVisitor visitor = new InvocationRemovalVisitor(
                                method.getMethodDeclaration());
                            javaMethod.getMethodDeclaration().accept(visitor);
                            if (visitor.hasBeenDeleted()) {
                                javaMethod.notifyChanged();
                                javaMethod.getParent().store();
                            }
                        }
                        System.out.println("end of method for");
                    }
                    System.out.println("end of class for");
                }
                System.out.println("end of fileartifact for");
                method.delete();
            }
        }
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
                // The below code is used to check if it is not a top-level
                // class
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

    /**
     * Returns the specified Java attribute.
     * 
     * @param name
     *            the name of the attribute
     * @return the attribute or <b>null</b> if there is no such attribute
     */
    public JavaAttribute getAttributeByName(final String name) {
        final JavaAttribute[] tmp = new JavaAttribute[1];
        typeDeclaration.accept(new ASTVisitor() {
            @Override
            public boolean visit(FieldDeclaration node) {
                String attributeName = "";
                Object object = node.fragments().get(0);
                if (object instanceof VariableDeclarationFragment) {
                    attributeName = ((VariableDeclarationFragment) object).getName().toString();
                }
                if (null == tmp[0] && attributeName.equals(name)) {
                    tmp[0] = new JavaAttribute(node, attributeName, JavaClass.this);
                }
                return false;
            }
        });
        return tmp[0];
    }

    /**
     * Returns all qualified names of this class.
     * 
     * @return the qualified names
     */
    public Set<JavaQualifiedName> qualifiedNames() {
        final List<JavaQualifiedName> list = new ArrayList<JavaQualifiedName>();
        typeDeclaration.accept(new ASTVisitor() {
            public boolean visit(QualifiedName node) {
                list.add(new JavaQualifiedName(node, JavaClass.this));
                return false;
            }
        });
        return new ArraySet<JavaQualifiedName>(list.toArray(new JavaQualifiedName[list.size()]),
                JavaQualifiedName.class);
    }

    @Invisible
    @Override
    public String getStringValue(StringComparator comparator) {
        return "class '" + getNameSafe() + "'";
    }

    @Invisible
    @Override
    public ArtifactModel getArtifactModel() {
        return getParent().getArtifactModel();
    }

}
